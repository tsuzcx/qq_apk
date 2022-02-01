package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ArkAppReportController
{
  private static String a(ArkAppReportController.ReportData paramReportData)
  {
    return paramReportData.a();
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    ArkAppReportController.ReportData localReportData = new ArkAppReportController.ReportData();
    localReportData.a = paramString1;
    localReportData.b = paramString2;
    localReportData.c = paramString3;
    localReportData.d = paramLong1;
    localReportData.e = paramLong2;
    localReportData.g = paramLong3;
    localReportData.i = paramLong4;
    localReportData.j = paramLong5;
    localReportData.k = paramString4;
    localReportData.l = paramString5;
    localReportData.f = 1L;
    if (paramAppRuntime == null)
    {
      paramAppRuntime = a(localReportData);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("POST getReportingDetail=");
        paramString1.append(paramAppRuntime);
        QLog.i("ArkAppReportController", 1, paramString1.toString());
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramAppRuntime));
      return;
    }
    paramString1 = a(localReportData);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getReportingDetail=");
      paramString2.append(paramString1);
      QLog.i("ArkAppReportController", 1, paramString2.toString());
    }
    ReportController.b(paramAppRuntime, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ArkAppReportController
 * JD-Core Version:    0.7.0.1
 */