package com.tencent.mobileqq.statistics;

import aikr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScoreReportController
{
  private static String a(aikr paramaikr)
  {
    return paramaikr.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    aikr localaikr = new aikr();
    localaikr.jdField_a_of_type_Long = paramLong9;
    localaikr.b = paramLong1;
    localaikr.c = paramLong2;
    localaikr.jdField_d_of_type_Long = paramLong3;
    localaikr.e = paramLong4;
    localaikr.jdField_f_of_type_Long = paramLong5;
    localaikr.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localaikr.g = paramLong6;
    localaikr.m = paramLong7;
    localaikr.h = paramLong8;
    localaikr.jdField_d_of_type_JavaLangString = paramString1;
    localaikr.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localaikr);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ScoreReportController
 * JD-Core Version:    0.7.0.1
 */