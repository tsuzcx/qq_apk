package com.tencent.mobileqq.utils;

import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QAVGroupConfig$Report
{
  public static void a()
  {
    a("0X8008CC3");
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == 4)
    {
      a("0X8009187");
      return;
    }
    if (paramInt == 2) {
      a("0X8009188");
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportAVGroupNum, num[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], isVideo[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("QAVGroupConfig", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("num", String.valueOf(paramInt));
      UserAction.onUserAction("reportAVGroupNum_video", true, -1L, -1L, (Map)localObject, true);
    }
    else
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("num", String.valueOf(paramInt));
      UserAction.onUserAction("reportAVGroupNum_audio", true, -1L, -1L, (Map)localObject, true);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("isVideo", String.valueOf(paramBoolean));
    ((HashMap)localObject).put("num", String.valueOf(paramInt));
    UserAction.onUserAction("reportAVGroupNum", true, -1L, -1L, (Map)localObject, true);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportClickEvent, key[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w("QAVGroupConfig", 1, localStringBuilder.toString());
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0X8008CC7");
      return;
    }
    a("0X8008CC8");
  }
  
  public static void b()
  {
    a("0X8008CC4");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0X8008CBA");
      return;
    }
    a("0X8008CB5");
  }
  
  public static void c()
  {
    a("0X8008CC5");
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a("0X8008E7D");
      return;
    }
    a("0X8008E7E");
  }
  
  public static void d()
  {
    a("0X8008CC6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig.Report
 * JD-Core Version:    0.7.0.1
 */