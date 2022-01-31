package com.tencent.smtt.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;

class WebView$ConnectivityChangedReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        int i;
        long l;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
        {
          i = Apn.getApnType(???);
          l = System.currentTimeMillis();
        }
        synchronized (QbSdk.sApnLock)
        {
          if (QbSdk.sIsApnWifi) {
            QbSdk.sWifiConnectedTime += l - QbSdk.sApnRecordTime;
          }
          QbSdk.sApnRecordTime = l;
          TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.sWifiConnectedTime + " apnType=" + i);
          if (i == 3)
          {
            bool = true;
            QbSdk.sIsApnWifi = bool;
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable ???)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.ConnectivityChangedReceiver
 * JD-Core Version:    0.7.0.1
 */