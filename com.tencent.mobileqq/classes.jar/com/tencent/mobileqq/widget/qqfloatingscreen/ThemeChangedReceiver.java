package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class ThemeChangedReceiver
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ThemeChangedReceiver.1(this);
  private ThemeChangedReceiver.Listener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenThemeChangedReceiver$Listener;
  
  public ThemeChangedReceiver()
  {
    BaseApplication.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.ThemeChangedReceiver
 * JD-Core Version:    0.7.0.1
 */