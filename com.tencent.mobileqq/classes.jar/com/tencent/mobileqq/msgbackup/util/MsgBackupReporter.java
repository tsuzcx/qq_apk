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
  
  public static void a()
  {
    if (a == null)
    {
      a = new MsgBackupReportData();
      a.a();
      a.b = 4;
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
      HashMap localHashMap = d();
      String str = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "MsgBackup_MsgBackupReporter", true, 0L, 0L, localHashMap, null);
      b();
    }
  }
  
  private static HashMap<String, String> d()
  {
    HashMap localHashMap = new HashMap();
    MsgBackupReportData localMsgBackupReportData = a;
    if (localMsgBackupReportData != null)
    {
      MsgBackupUtil.a("MsgBackup_MsgBackupReporter", "mReportContainer = %s", new Object[] { localMsgBackupReportData });
      localHashMap.put("bizType", String.valueOf(a.a));
      localHashMap.put("platForm", String.valueOf(a.b));
      localHashMap.put("requestStatus", String.valueOf(a.c));
      localHashMap.put("errorCode", String.valueOf(a.d));
      localHashMap.put("totalCost", String.valueOf(a.e));
      localHashMap.put("averageSpeed", String.valueOf(a.f));
      localHashMap.put("totalSessionCount", String.valueOf(a.g));
      localHashMap.put("finishedSessionCount", String.valueOf(a.h));
      localHashMap.put("resSessionContains", String.valueOf(a.i));
      localHashMap.put("resTotalSize", String.valueOf(a.j));
      localHashMap.put("dbTotalSize", String.valueOf(a.k));
      localHashMap.put("resRequestCount", String.valueOf(a.l));
      localHashMap.put("resRequestFailedCount", String.valueOf(a.m));
      localHashMap.put("resRequestCancelCount", String.valueOf(a.n));
      localHashMap.put("resTrivialCount", String.valueOf(a.o));
      localHashMap.put("resTrivialFailedCount", String.valueOf(a.p));
      localHashMap.put("resTrivialCancelCount", String.valueOf(a.q));
      localHashMap.put("dbRequestCount", String.valueOf(a.r));
      localHashMap.put("dbRequestFailedCount", String.valueOf(a.s));
      localHashMap.put("dbRequestCancelCount", String.valueOf(a.t));
      localHashMap.put("udpDetected", String.valueOf(a.u));
      localHashMap.put("connectType", String.valueOf(a.v));
      localHashMap.put("connectElipse", String.valueOf(a.w));
      localHashMap.put("sessionReadyAllTimes", String.valueOf(a.x));
      localHashMap.put("fileFailedCount", String.valueOf(a.y));
      localHashMap.put("fileErrorList", String.valueOf(a.z));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupReporter
 * JD-Core Version:    0.7.0.1
 */