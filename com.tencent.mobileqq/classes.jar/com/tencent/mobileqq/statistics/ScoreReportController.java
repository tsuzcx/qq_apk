package com.tencent.mobileqq.statistics;

import ahrv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScoreReportController
{
  private static String a(ahrv paramahrv)
  {
    return paramahrv.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    ahrv localahrv = new ahrv();
    localahrv.jdField_a_of_type_Long = paramLong9;
    localahrv.b = paramLong1;
    localahrv.c = paramLong2;
    localahrv.jdField_d_of_type_Long = paramLong3;
    localahrv.e = paramLong4;
    localahrv.jdField_f_of_type_Long = paramLong5;
    localahrv.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localahrv.g = paramLong6;
    localahrv.m = paramLong7;
    localahrv.h = paramLong8;
    localahrv.jdField_d_of_type_JavaLangString = paramString1;
    localahrv.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localahrv);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc02653", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ScoreReportController
 * JD-Core Version:    0.7.0.1
 */