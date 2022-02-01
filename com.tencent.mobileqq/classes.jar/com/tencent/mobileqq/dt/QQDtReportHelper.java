package com.tencent.mobileqq.dt;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import java.util.TreeMap;

public class QQDtReportHelper
{
  private static long a;
  public static boolean a;
  private static boolean b;
  
  private static long a()
  {
    return SystemClock.uptimeMillis() - a;
  }
  
  public static void a()
  {
    if (!DtSdkInitStep.b())
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin] dt sdk has not init");
      return;
    }
    QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin]");
    c();
    a("dt_appin", null);
  }
  
  public static void a(int paramInt)
  {
    b = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("848QQDT [setIsMainProcess] process: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append(", from: ");
    localStringBuilder.append(paramInt);
    QLog.d("QQDtReportHelper", 1, localStringBuilder.toString());
  }
  
  private static void a(Long paramLong, String paramString, Map<String, String> paramMap)
  {
    if ("dt_appin".equals(paramString))
    {
      VideoReport.reportEvent("qqin", null);
      QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] qqin");
      c();
      return;
    }
    if ("dt_appout".equals(paramString))
    {
      if (a == 0L)
      {
        QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] startTimestamp is 0");
        return;
      }
      paramString = new TreeMap();
      a(paramString, paramMap);
      paramString.put("qq_lvtm", paramLong.toString());
      VideoReport.reportEvent("qqout", paramString);
      paramString = new StringBuilder();
      paramString.append("848QQDT [doSupplementReport] qqout, timeInterval: ");
      paramString.append(paramLong);
      QLog.d("QQDtReportHelper", 1, paramString.toString());
    }
  }
  
  public static void a(String paramString, Map<String, String> paramMap)
  {
    if ((b) && (a == 0L))
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [supplementReportForSwitchAccount] startTimestamp is 0");
      return;
    }
    a(Long.valueOf(a()), paramString, paramMap);
  }
  
  private static void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if ((paramMap2 != null) && (paramMap1 != null))
    {
      String str = (String)paramMap2.get("dt_lvtm_delta");
      paramMap2 = (String)paramMap2.get("dt_lvtm");
      if (str != null)
      {
        paramMap1.put("dt_lvtm_delta", str);
        QLog.d("QQDtReportHelper", 1, new Object[] { "848QQDT [doSupplementReport] delta: ", str });
      }
      if (paramMap2 != null)
      {
        paramMap1.put("dt_lvtm", paramMap2);
        QLog.d("QQDtReportHelper", 1, new Object[] { "848QQDT [doSupplementReport] dtLvTime: ", paramMap2 });
      }
    }
  }
  
  public static void b()
  {
    if (!DtSdkInitStep.b())
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin] dt sdk has not init");
      return;
    }
    QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogout]");
    a("dt_appout", null);
    a = 0L;
  }
  
  public static void c()
  {
    a = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("848QQDT [updateStartTime] timeStamp: ");
      localStringBuilder.append(a);
      QLog.d("QQDtReportHelper", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dt.QQDtReportHelper
 * JD-Core Version:    0.7.0.1
 */