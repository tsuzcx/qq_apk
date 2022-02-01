package com.tencent.mobileqq.guild.live.viewmodel;

import android.support.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.qphone.base.util.BaseApplication;

public class QQGuildLiveViewModelProvider
{
  public static ViewModelProvider a(@NonNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    return new ViewModelProvider(paramViewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplication.getContext()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveViewModelProvider
 * JD-Core Version:    0.7.0.1
 */