package com.tencent.mobileqq.perf.rmonitor.natmem;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.natmem.INatMemListener;

public class QQRMonitorNatMemListener
  implements INatMemListener
{
  public void a()
  {
    QLog.i("QQRMonitorNatMemListener", 1, "onSuccess.");
    com.tencent.mobileqq.perf.report.FeatureFlag.a = true;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFail , errCode = ");
    localStringBuilder.append(paramInt);
    QLog.i("QQRMonitorNatMemListener", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.natmem.QQRMonitorNatMemListener
 * JD-Core Version:    0.7.0.1
 */