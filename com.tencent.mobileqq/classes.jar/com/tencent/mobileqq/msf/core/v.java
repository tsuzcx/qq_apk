package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class v
  extends BroadcastReceiver
{
  v(u paramu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_ON"))
    {
      u.a(this.a, true);
      return;
    }
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      u.a(this.a, false);
      return;
    }
    if (paramContext.equals("android.net.wifi.SCAN_RESULTS")) {
      try
      {
        u.a(this.a);
        return;
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQWiFiScanManager", 2, "onReceive, SCAN_RESULTS_AVAILABLE_ACTION", paramContext);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.v
 * JD-Core Version:    0.7.0.1
 */