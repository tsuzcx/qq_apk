package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class ThemeChangedReceiver
{
  private ThemeChangedReceiver.Listener a;
  private BroadcastReceiver b = new ThemeChangedReceiver.1(this);
  
  public ThemeChangedReceiver()
  {
    BaseApplication.getContext().registerReceiver(this.b, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.ThemeChangedReceiver
 * JD-Core Version:    0.7.0.1
 */