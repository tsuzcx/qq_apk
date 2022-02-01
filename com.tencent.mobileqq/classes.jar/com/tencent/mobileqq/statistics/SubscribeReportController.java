package com.tencent.mobileqq.statistics;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SubscribeReportController
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    SubscribeReportController.ReportData localReportData = new SubscribeReportController.ReportData();
    localReportData.jdField_c_of_type_JavaLangString = paramString1;
    localReportData.jdField_d_of_type_JavaLangString = paramString2;
    localReportData.jdField_e_of_type_JavaLangString = paramString3;
    localReportData.f = paramString4;
    localReportData.jdField_c_of_type_Long = paramInt1;
    localReportData.jdField_d_of_type_Long = paramInt2;
    localReportData.jdField_e_of_type_Long = paramInt3;
    localReportData.g = paramString5;
    localReportData.h = paramString6;
    localReportData.i = paramString7;
    localReportData.j = paramString8;
    paramString1 = localReportData.a();
    if (QLog.isColorLevel()) {
      QLog.i("SubscribeReportController", 1, "getReportingDetail=" + paramString1);
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QQAppInterface localQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localQQAppInterface = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localQQAppInterface = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localQQAppInterface = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localQQAppInterface = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localQQAppInterface == null)
    {
      paramQQAppInterface = a("${uin_unknown}", paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7);
      paramString1 = new Intent();
      paramString1.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramString1.putExtra("reporting_tag", "dc05263");
      paramString1.putExtra("reporting_detail", paramQQAppInterface);
      paramString1.putExtra("reporting_count", paramInt2);
      paramString1.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
      return;
    }
    ReportController.b(localQQAppInterface, "dc05263", a(localQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7), paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt1, 1, paramInt2, paramString4, paramString5, paramString6, paramString7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.SubscribeReportController
 * JD-Core Version:    0.7.0.1
 */