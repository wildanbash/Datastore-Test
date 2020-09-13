package com.bash.datastoredemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bash.datastoredemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.readFromDataStore.observe(this, { name ->
            result.text = name
        })

        btn_save.setOnClickListener{
            val name = et_name.text.toString()
            viewModel.saveToDataStore(name)
        }
    }
}