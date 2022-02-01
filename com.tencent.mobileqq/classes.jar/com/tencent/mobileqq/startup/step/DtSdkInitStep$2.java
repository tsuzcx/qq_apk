package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;

final class DtSdkInitStep$2
  implements Runnable
{
  public void run()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      long l = System.currentTimeMillis();
      QQBeaconReport.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init beacon-dt success ! cost : ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      localStringBuilder.append(" ms");
      QLog.d("DtSdkInitStep", 1, localStringBuilder.toString());
      return;
    }
    QLog.d("DtSdkInitStep", 1, "init beacon-dt error ! app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.DtSdkInitStep.2
 * JD-Core Version:    0.7.0.1
 */