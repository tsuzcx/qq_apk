package com.tencent.mobileqq.flutter.channel.report;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;

class ReportChannel$1
  extends ReporterChannelHandler
{
  ReportChannel$1(ReportChannel paramReportChannel) {}
  
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString5, String paramString6, Boolean paramBoolean, MethodChannel.Result paramResult)
  {
    if (paramInt == 1) {}
    for (paramString1 = "dc00898";; paramString1 = "CliOper")
    {
      if (QLog.isColorLevel()) {
        QLog.i("flutter.ReporterChannel", 2, String.format("report table=%s opType=%s opName=%s entry=%d", new Object[] { paramString1, paramString3, paramString4, paramInteger1 }));
      }
      try
      {
        ReportController.b(null, paramString1, "", "", paramString3, paramString4, paramInteger1.intValue(), 0, paramInteger2 + "", paramInteger3 + "", paramString5, paramString6);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.d("flutter.ReporterChannel", 1, paramString1.getMessage(), paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.report.ReportChannel.1
 * JD-Core Version:    0.7.0.1
 */