package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

final class KandianDailyReportUtils$3
  implements Runnable
{
  KandianDailyReportUtils$3(ReportInfo paramReportInfo) {}
  
  public void run()
  {
    KandianDailyReportUtils.a().add(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add feeds 64e exposure info ");
    localStringBuilder.append(this.a);
    QLog.d("KandianDailyReportUtils", 1, localStringBuilder.toString());
    if (!KandianDailyReportUtils.a())
    {
      ThreadManager.getSubThreadHandler().postDelayed(new KandianDailyReportUtils.3.1(this), 100L);
      KandianDailyReportUtils.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils.3
 * JD-Core Version:    0.7.0.1
 */