package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScoreReportController
{
  private static String a(ScoreReportController.ReportData paramReportData)
  {
    return paramReportData.b();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    ScoreReportController.ReportData localReportData = new ScoreReportController.ReportData();
    localReportData.a = paramLong9;
    localReportData.b = paramLong1;
    localReportData.c = paramLong2;
    localReportData.d = paramLong3;
    localReportData.e = paramLong4;
    localReportData.f = paramLong5;
    localReportData.g = paramQQAppInterface.getCurrentUin();
    localReportData.i = paramLong6;
    localReportData.r = paramLong7;
    localReportData.j = paramLong8;
    localReportData.p = paramString1;
    localReportData.w = paramString2;
    paramString1 = a(localReportData);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getReportingDetail=");
      paramString2.append(paramString1);
      QLog.i("ScoreReportController", 1, paramString2.toString());
    }
    ReportController.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ScoreReportController
 * JD-Core Version:    0.7.0.1
 */