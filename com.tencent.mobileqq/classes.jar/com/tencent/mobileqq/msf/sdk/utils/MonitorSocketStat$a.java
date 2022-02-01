package com.tencent.mobileqq.msf.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class MonitorSocketStat$a
  extends BroadcastReceiver
{
  private String b = null;
  
  private MonitorSocketStat$a(MonitorSocketStat paramMonitorSocketStat) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.b = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "screenOn");
      }
      MonitorSocketStat.access$202(this.a, false);
      MonitorSocketStat.access$300(this.a);
      return;
    }
    if ("android.intent.action.SCREEN_OFF".equals(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "screenOff");
      }
      MonitorSocketStat.access$202(this.a, true);
      MonitorSocketStat.access$300(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat.a
 * JD-Core Version:    0.7.0.1
 */