package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class w
  extends BroadcastReceiver
{
  w(v paramv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_ON"))
    {
      v.a(this.a, true);
      return;
    }
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      v.a(this.a, false);
      return;
    }
    if (paramContext.equals("android.net.wifi.SCAN_RESULTS")) {
      try
      {
        v.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.w
 * JD-Core Version:    0.7.0.1
 */