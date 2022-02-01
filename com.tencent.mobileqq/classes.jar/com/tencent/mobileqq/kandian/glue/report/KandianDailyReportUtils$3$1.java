package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class KandianDailyReportUtils$3$1
  implements Runnable
{
  KandianDailyReportUtils$3$1(KandianDailyReportUtils.3 param3) {}
  
  public void run()
  {
    KandianDailyReportUtils.a(false);
    if (KandianDailyReportUtils.i().isEmpty()) {
      return;
    }
    ReadInJoyLogicEngine.a().a(KandianDailyReportUtils.i());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("execute feeds 64e export, size : ");
    localStringBuilder.append(KandianDailyReportUtils.i().size());
    QLog.d("KandianDailyReportUtils", 1, localStringBuilder.toString());
    KandianDailyReportUtils.i().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils.3.1
 * JD-Core Version:    0.7.0.1
 */