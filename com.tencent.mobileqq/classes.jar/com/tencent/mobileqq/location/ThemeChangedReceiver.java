package com.tencent.mobileqq.location;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;

public class ThemeChangedReceiver
{
  private ThemeChangedListener a;
  private BroadcastReceiver b = new ThemeChangedReceiver.1(this);
  
  public ThemeChangedReceiver()
  {
    BaseApplication.getContext().registerReceiver(this.b, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public void a()
  {
    BaseApplication.getContext().unregisterReceiver(this.b);
  }
  
  public void a(ThemeChangedListener paramThemeChangedListener)
  {
    this.a = paramThemeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ThemeChangedReceiver
 * JD-Core Version:    0.7.0.1
 */