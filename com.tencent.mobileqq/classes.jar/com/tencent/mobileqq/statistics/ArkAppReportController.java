package com.tencent.mobileqq.statistics;

import aikk;
import aikl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ArkAppReportController
{
  private static String a(aikl paramaikl)
  {
    return paramaikl.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    aikl localaikl = new aikl();
    localaikl.jdField_a_of_type_JavaLangString = paramString1;
    localaikl.jdField_b_of_type_JavaLangString = paramString2;
    localaikl.jdField_c_of_type_JavaLangString = paramString3;
    localaikl.jdField_a_of_type_Long = paramLong1;
    localaikl.jdField_b_of_type_Long = paramLong2;
    localaikl.jdField_d_of_type_Long = paramLong3;
    localaikl.f = paramLong4;
    localaikl.g = paramLong5;
    localaikl.jdField_d_of_type_JavaLangString = paramString4;
    localaikl.e = paramString5;
    localaikl.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localaikl);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new aikk(paramQQAppInterface));
      return;
    }
    paramString1 = a(localaikl);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ArkAppReportController
 * JD-Core Version:    0.7.0.1
 */