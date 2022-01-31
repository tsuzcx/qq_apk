package com.tencent.mobileqq.vas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import mqq.app.MobileQQ;

public class ThemeChangeBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ("com.tencent.qplus.THEME_INVALIDATE".equals(paramIntent.getAction())) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ThemeChangeBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */