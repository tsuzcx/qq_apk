package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class f
  implements Runnable
{
  f(MonitorSocketStat paramMonitorSocketStat) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.MonitorSocket", 2, "start to get status of Process");
    }
    if (MsfSdkUtils.isTopActivity(BaseApplication.getContext()))
    {
      if (MonitorSocketStat.access$200(this.a))
      {
        MonitorSocketStat.access$402(this.a, (byte)4);
        return;
      }
      MonitorSocketStat.access$402(this.a, (byte)1);
      return;
    }
    if (MonitorSocketStat.access$200(this.a))
    {
      MonitorSocketStat.access$402(this.a, (byte)2);
      return;
    }
    if ((!MsfSdkUtils.isTopActivity(BaseApplication.getContext())) && (!MonitorSocketStat.access$200(this.a)))
    {
      MonitorSocketStat.access$402(this.a, (byte)3);
      return;
    }
    MonitorSocketStat.access$402(this.a, (byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.f
 * JD-Core Version:    0.7.0.1
 */