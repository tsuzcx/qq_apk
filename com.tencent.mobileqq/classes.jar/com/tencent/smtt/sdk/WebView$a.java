package com.tencent.smtt.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;

class WebView$a
  extends BroadcastReceiver
{
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
        {
          int i = Apn.getApnType(???);
          long l = System.currentTimeMillis();
          synchronized (QbSdk.h)
          {
            if (QbSdk.e) {
              QbSdk.g += l - QbSdk.f;
            }
            QbSdk.f = l;
            ??? = new StringBuilder();
            ???.append("pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=");
            ???.append(QbSdk.g);
            ???.append(" apnType=");
            ???.append(i);
            TbsLog.d("sdkreport", ???.toString());
            if (i != 3) {
              break label128;
            }
            bool = true;
            QbSdk.e = bool;
            return;
          }
        }
        return;
      }
      catch (Throwable ???)
      {
        return;
      }
      label128:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.a
 * JD-Core Version:    0.7.0.1
 */