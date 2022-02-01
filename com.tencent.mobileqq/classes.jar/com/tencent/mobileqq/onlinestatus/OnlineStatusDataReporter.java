package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;

public class OnlineStatusDataReporter
{
  public static void a(long paramLong)
  {
    if (paramLong >= 40001L) {
      ReportHelperKt.a("0X800B0F2", 2);
    }
  }
  
  public static void a(AppRuntime.Status paramStatus, long paramLong)
  {
    int i;
    switch (OnlineStatusDataReporter.1.a[paramStatus.ordinal()])
    {
    default: 
      i = -1;
      break;
    case 6: 
      i = 6;
      break;
    case 5: 
      i = 5;
      break;
    case 4: 
      i = 4;
      break;
    case 3: 
      i = 3;
      break;
    case 2: 
      i = 2;
      break;
    case 1: 
      i = 1;
    }
    int j = i;
    if (i == 1)
    {
      j = i;
      if (paramLong > 0L) {
        j = (int)paramLong;
      }
    }
    ReportHelperKt.a("0X800AF3D", j);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009DDA", "0X8009DDA", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, AppRuntime.Status paramStatus, long paramLong)
  {
    if ((paramAppRuntime != null) && (paramStatus != null))
    {
      int i = 0;
      switch (OnlineStatusDataReporter.1.a[paramStatus.ordinal()])
      {
      default: 
        break;
      case 6: 
        i = 6;
        break;
      case 5: 
        i = 5;
        break;
      case 4: 
        i = 4;
        break;
      case 3: 
        i = 3;
        break;
      case 2: 
        i = 2;
        break;
      case 1: 
        i = 1;
      }
      if ((i == 1) && (paramLong > 0L)) {
        i = (int)paramLong;
      }
      if (i != 0) {
        ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009DDB", "0X8009DDB", i, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, AppRuntime.Status paramStatus, long paramLong, AutoReplyText paramAutoReplyText)
  {
    if ((paramAppRuntime != null) && (paramAutoReplyText != null) && (a(paramStatus)))
    {
      int i;
      if (paramAutoReplyText.getTextId() == 2147483647) {
        i = 2;
      } else {
        i = 1;
      }
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009DDC", "0X8009DDC", i, 0, "", "", "", "");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      String str1;
      if (paramBoolean) {
        str1 = "0X8009DDE";
      } else {
        str1 = "0X8009DDF";
      }
      String str2;
      if (paramBoolean) {
        str2 = "0X8009DDE";
      } else {
        str2 = "0X8009DDF";
      }
      ReportController.b(paramAppRuntime, "dc00898", "", "", str1, str2, 0, 0, "", "", "", "");
    }
  }
  
  public static boolean a(AppRuntime.Status paramStatus)
  {
    return (paramStatus == AppRuntime.Status.away) || (paramStatus == AppRuntime.Status.busy) || (paramStatus == AppRuntime.Status.dnd);
  }
  
  public static void b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009DDD", "0X8009DDD", 0, 0, "", "", "", "");
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, AppRuntime.Status paramStatus, long paramLong)
  {
    int i;
    switch (OnlineStatusDataReporter.1.a[paramStatus.ordinal()])
    {
    default: 
      i = -1;
      break;
    case 6: 
      i = 6;
      break;
    case 5: 
      i = 5;
      break;
    case 4: 
      i = 4;
      break;
    case 3: 
      i = 3;
      break;
    case 2: 
      i = 2;
      break;
    case 1: 
      i = 1;
    }
    int j = i;
    if (i == 1)
    {
      j = i;
      if (paramLong > 0L) {
        j = (int)paramLong;
      }
    }
    ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009DE0", "0X8009DE0", j, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusDataReporter
 * JD-Core Version:    0.7.0.1
 */