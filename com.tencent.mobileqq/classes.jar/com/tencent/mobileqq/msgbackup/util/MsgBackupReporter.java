package com.tencent.mobileqq.msgbackup.util;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MsgBackupReporter
{
  public static MsgBackupReportData a;
  
  private static HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    MsgBackupReportData localMsgBackupReportData = a;
    if (localMsgBackupReportData != null)
    {
      MsgBackupUtil.a("MsgBackup_MsgBackupReporter", "mReportContainer = %s", new Object[] { localMsgBackupReportData });
      localHashMap.put("bizType", String.valueOf(a.jdField_a_of_type_Int));
      localHashMap.put("platForm", String.valueOf(a.jdField_b_of_type_Int));
      localHashMap.put("requestStatus", String.valueOf(a.jdField_a_of_type_Boolean));
      localHashMap.put("errorCode", String.valueOf(a.jdField_c_of_type_Int));
      localHashMap.put("totalCost", String.valueOf(a.jdField_a_of_type_Long));
      localHashMap.put("averageSpeed", String.valueOf(a.jdField_a_of_type_Double));
      localHashMap.put("totalSessionCount", String.valueOf(a.jdField_b_of_type_Long));
      localHashMap.put("finishedSessionCount", String.valueOf(a.jdField_c_of_type_Long));
      localHashMap.put("resSessionContains", String.valueOf(a.jdField_d_of_type_Long));
      localHashMap.put("resTotalSize", String.valueOf(a.e));
      localHashMap.put("dbTotalSize", String.valueOf(a.f));
      localHashMap.put("resRequestCount", String.valueOf(a.g));
      localHashMap.put("resRequestFailedCount", String.valueOf(a.h));
      localHashMap.put("resRequestCancelCount", String.valueOf(a.i));
      localHashMap.put("resTrivialCount", String.valueOf(a.j));
      localHashMap.put("resTrivialFailedCount", String.valueOf(a.k));
      localHashMap.put("resTrivialCancelCount", String.valueOf(a.l));
      localHashMap.put("dbRequestCount", String.valueOf(a.m));
      localHashMap.put("dbRequestFailedCount", String.valueOf(a.n));
      localHashMap.put("dbRequestCancelCount", String.valueOf(a.o));
      localHashMap.put("udpDetected", String.valueOf(a.jdField_b_of_type_Boolean));
      localHashMap.put("connectType", String.valueOf(a.jdField_d_of_type_Int));
      localHashMap.put("connectElipse", String.valueOf(a.p));
      localHashMap.put("sessionReadyAllTimes", String.valueOf(a.q));
      localHashMap.put("fileFailedCount", String.valueOf(a.r));
      localHashMap.put("fileErrorList", String.valueOf(a.jdField_a_of_type_JavaUtilArrayList));
    }
    return localHashMap;
  }
  
  public static void a()
  {
    if (a == null)
    {
      a = new MsgBackupReportData();
      a.a();
      a.jdField_b_of_type_Int = 4;
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("MsgBackup_MsgBackupReporter", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], fromType = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MsgBackup_MsgBackupReporter", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report() called with: key = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], fromType = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], reservedFromType = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.d("MsgBackup_MsgBackupReporter", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public static void b()
  {
    MsgBackupReportData localMsgBackupReportData = a;
    if (localMsgBackupReportData != null)
    {
      localMsgBackupReportData.a();
      a = null;
    }
  }
  
  public static void c()
  {
    if (a != null)
    {
      HashMap localHashMap = a();
      String str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "MsgBackup_MsgBackupReporter", true, 0L, 0L, localHashMap, null);
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupReporter
 * JD-Core Version:    0.7.0.1
 */