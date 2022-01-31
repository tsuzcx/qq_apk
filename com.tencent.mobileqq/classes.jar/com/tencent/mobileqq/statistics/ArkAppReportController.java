package com.tencent.mobileqq.statistics;

import ahrn;
import ahro;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ArkAppReportController
{
  private static String a(ahro paramahro)
  {
    return paramahro.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    ahro localahro = new ahro();
    localahro.jdField_a_of_type_JavaLangString = paramString1;
    localahro.jdField_b_of_type_JavaLangString = paramString2;
    localahro.jdField_c_of_type_JavaLangString = paramString3;
    localahro.jdField_a_of_type_Long = paramLong1;
    localahro.jdField_b_of_type_Long = paramLong2;
    localahro.jdField_d_of_type_Long = paramLong3;
    localahro.f = paramLong4;
    localahro.g = paramLong5;
    localahro.jdField_d_of_type_JavaLangString = paramString4;
    localahro.e = paramString5;
    localahro.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localahro);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ahrn(paramQQAppInterface));
      return;
    }
    paramString1 = a(localahro);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ArkAppReportController
 * JD-Core Version:    0.7.0.1
 */