package com.tencent.mobileqq.mvvm;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import mqq.app.MobileQQ;

public class ViewModelProviderHelper
{
  public static ViewModelProvider a(ViewModelStoreOwner paramViewModelStoreOwner)
  {
    return a(paramViewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(MobileQQ.sMobileQQ));
  }
  
  public static ViewModelProvider a(ViewModelStoreOwner paramViewModelStoreOwner, ViewModelProvider.Factory paramFactory)
  {
    return new ViewModelProvider(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.ViewModelProviderHelper
 * JD-Core Version:    0.7.0.1
 */