package com.tencent.mobileqq.statistics;

import aify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ScoreReportController
{
  private static String a(aify paramaify)
  {
    return paramaify.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, String paramString1, String paramString2)
  {
    aify localaify = new aify();
    localaify.jdField_a_of_type_Long = paramLong9;
    localaify.b = paramLong1;
    localaify.c = paramLong2;
    localaify.jdField_d_of_type_Long = paramLong3;
    localaify.e = paramLong4;
    localaify.jdField_f_of_type_Long = paramLong5;
    localaify.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
    localaify.g = paramLong6;
    localaify.m = paramLong7;
    localaify.h = paramLong8;
    localaify.jdField_d_of_type_JavaLangString = paramString1;
    localaify.jdField_f_of_type_JavaLangString = paramString2;
    paramString1 = a(localaify);
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