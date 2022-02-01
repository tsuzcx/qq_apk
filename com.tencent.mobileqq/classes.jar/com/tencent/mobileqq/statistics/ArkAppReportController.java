package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class ArkAppReportController
{
  private static String a(ArkAppReportController.ReportData paramReportData)
  {
    return paramReportData.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5)
  {
    ArkAppReportController.ReportData localReportData = new ArkAppReportController.ReportData();
    localReportData.jdField_a_of_type_JavaLangString = paramString1;
    localReportData.jdField_b_of_type_JavaLangString = paramString2;
    localReportData.jdField_c_of_type_JavaLangString = paramString3;
    localReportData.jdField_a_of_type_Long = paramLong1;
    localReportData.jdField_b_of_type_Long = paramLong2;
    localReportData.jdField_d_of_type_Long = paramLong3;
    localReportData.f = paramLong4;
    localReportData.g = paramLong5;
    localReportData.jdField_d_of_type_JavaLangString = paramString4;
    localReportData.e = paramString5;
    localReportData.jdField_c_of_type_Long = 1L;
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = a(localReportData);
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppReportController", 1, "POST getReportingDetail=" + paramQQAppInterface);
      }
      ThreadManager.executeOnSubThread(new ArkAppReportController.1(paramQQAppInterface));
      return;
    }
    paramString1 = a(localReportData);
    if (QLog.isColorLevel()) {
      QLog.i("ArkAppReportController", 1, "getReportingDetail=" + paramString1);
    }
    ReportController.b(paramQQAppInterface, "dc01616", paramString1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ArkAppReportController
 * JD-Core Version:    0.7.0.1
 */