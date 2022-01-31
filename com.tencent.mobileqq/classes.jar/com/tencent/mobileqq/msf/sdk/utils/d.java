package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

class d
  implements Runnable
{
  d(MonitorSocketStat paramMonitorSocketStat, b paramb, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MonitorSocketStat", 1, "sendMsg fail, total=" + MonitorSocketStat.access$100(this.c).size() + " dataFlowItem=" + this.a + " result=" + this.b);
    }
    try
    {
      MonitorSocketStat.access$100(this.c).put(this.a);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MonitorSocketStat", 1, "MonitorSocketStat excep!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.d
 * JD-Core Version:    0.7.0.1
 */