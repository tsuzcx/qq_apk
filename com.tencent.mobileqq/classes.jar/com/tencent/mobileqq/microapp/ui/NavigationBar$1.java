package com.tencent.mobileqq.microapp.ui;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class NavigationBar$1
  implements ValueCallback
{
  NavigationBar$1(NavigationBar paramNavigationBar) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavigationBar", 2, "onReceiveValue: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ui.NavigationBar.1
 * JD-Core Version:    0.7.0.1
 */