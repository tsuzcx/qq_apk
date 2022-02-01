package com.tencent.qqperf.monitor.crash;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class ReportLog$3
  implements Runnable
{
  ReportLog$3(ReportLog paramReportLog, MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    if ((this.a instanceof BaseApplicationImpl))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        QLog.d("ReportLog", 1, "uncaughtException QQAppInterface exit.");
        ((QQAppInterface)localObject).exit(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.ReportLog.3
 * JD-Core Version:    0.7.0.1
 */