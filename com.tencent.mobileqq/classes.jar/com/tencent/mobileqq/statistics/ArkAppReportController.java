package com.tencent.mobileqq.statistics;

import aifq;
import aifr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ArkAppReportController
{
  private static String a(aifr paramaifr)
  {
    return paramaifr.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    aifr localaifr = new aifr();
    localaifr.jdField_a_of_type_JavaLangString = paramString1;
    localaifr.jdField_b_of_type_JavaLangString = paramString2;
    localaifr.jdField_c_of_type_JavaLangString = paramString3;
    localaifr.jdField_a_of_type_Long = paramLong1;
    localaifr.jdField_b_of_type_Long = paramLong2;
    localaifr.jdField_d_of_type_Long = paramLong3;
    localaifr.f = paramLong4;
    localaifr.g = paramLong5;
    localaifr.jdField_d_of_type_JavaLangString = paramString4;
    localaifr.e = paramString5;
    localaifr.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localaifr);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new aifq(paramQQAppInterface));
      return;
    }
    paramString1 = a(localaifr);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ArkAppReportController
 * JD-Core Version:    0.7.0.1
 */