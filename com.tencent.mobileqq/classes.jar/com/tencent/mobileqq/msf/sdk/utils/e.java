package com.tencent.mobileqq.msf.sdk.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

class e
  implements Runnable
{
  e(MonitorSocketStat paramMonitorSocketStat, b paramb, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMsg fail, total=");
      localStringBuilder.append(MonitorSocketStat.access$100(this.c).size());
      localStringBuilder.append(" dataFlowItem=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" result=");
      localStringBuilder.append(this.b);
      QLog.d("MonitorSocketStat", 1, localStringBuilder.toString());
    }
    try
    {
      MonitorSocketStat.access$100(this.c).put(this.a);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MonitorSocketStat", 1, "MonitorSocketStat excep!", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.e
 * JD-Core Version:    0.7.0.1
 */