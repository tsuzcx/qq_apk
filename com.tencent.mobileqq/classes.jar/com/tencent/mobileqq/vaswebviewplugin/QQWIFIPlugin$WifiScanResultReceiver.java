package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class QQWIFIPlugin$WifiScanResultReceiver
  extends BroadcastReceiver
{
  protected String callback = "";
  private long lastdealtime;
  private Runnable receiveRunable;
  protected String ssid;
  
  private QQWIFIPlugin$WifiScanResultReceiver(QQWIFIPlugin paramQQWIFIPlugin) {}
  
  private void initScanReceiverRunable(Context paramContext)
  {
    this.receiveRunable = new QQWIFIPlugin.WifiScanResultReceiver.1(this, paramContext);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("QQWIFIPlugin", 2, "campus receive scanresults at " + System.currentTimeMillis() + " action:" + paramIntent);
    }
    if ("android.net.wifi.SCAN_RESULTS".equals(paramIntent))
    {
      long l = System.currentTimeMillis() - this.lastdealtime;
      if (QLog.isColorLevel()) {
        QLog.i("QQWIFIPlugin", 2, "interval=" + l);
      }
      if (l <= 2000L) {
        break label165;
      }
      if (this.receiveRunable == null) {
        initScanReceiverRunable(paramContext);
      }
      if (TextUtils.isEmpty(this.callback)) {
        break label150;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQWIFIPlugin", 2, "run");
      }
      ThreadManager.postImmediately(this.receiveRunable, null, false);
    }
    label150:
    label165:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("QQWIFIPlugin", 2, "callback is empty");
      return;
    }
    QLog.i("QQWIFIPlugin", 2, "in time interval");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin.WifiScanResultReceiver
 * JD-Core Version:    0.7.0.1
 */