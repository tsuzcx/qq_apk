package com.tencent.mobileqq.location;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class ThemeChangedReceiver
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ThemeChangedReceiver.1(this);
  private ThemeChangedListener jdField_a_of_type_ComTencentMobileqqLocationThemeChangedListener;
  
  public ThemeChangedReceiver()
  {
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public void a()
  {
    BaseApplication.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void a(ThemeChangedListener paramThemeChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationThemeChangedListener = paramThemeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ThemeChangedReceiver
 * JD-Core Version:    0.7.0.1
 */