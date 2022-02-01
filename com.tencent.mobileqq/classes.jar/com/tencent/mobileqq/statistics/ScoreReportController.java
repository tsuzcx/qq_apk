package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScoreReportController
{
  private static String a(ScoreReportController.ReportData paramReportData)
  {
    return paramReportData.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    ScoreReportController.ReportData localReportData = new ScoreReportController.ReportData();
    localReportData.jdField_a_of_type_Long = paramLong9;
    localReportData.b = paramLong1;
    localReportData.c = paramLong2;
    localReportData.jdField_d_of_type_Long = paramLong3;
    localReportData.e = paramLong4;
    localReportData.jdField_f_of_type_Long = paramLong5;
    localReportData.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
    localReportData.g = paramLong6;
    localReportData.m = paramLong7;
    localReportData.h = paramLong8;
    localReportData.jdField_d_of_type_JavaLangString = paramString1;
    localReportData.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localReportData);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ScoreReportController
 * JD-Core Version:    0.7.0.1
 */