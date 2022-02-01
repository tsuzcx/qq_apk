package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.util.ThrowablesUtils;
import java.lang.reflect.Field;

public class HuayangCrashReport
{
  public static void a(Throwable paramThrowable)
  {
    Monitor.a("2490056");
    CaughtExceptionReport.a(paramThrowable);
  }
  
  private static boolean a(Throwable paramThrowable)
  {
    return (paramThrowable != null) && ((paramThrowable.getClass().getCanonicalName().contains("android.system.")) || (paramThrowable.getClass().getCanonicalName().contains("libcore.io.")));
  }
  
  public static void b(Throwable paramThrowable)
  {
    c(paramThrowable);
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      Object localObject2;
      for (Object localObject1 = paramThrowable;; localObject1 = ((Throwable)localObject1).getCause())
      {
        localObject2 = paramThrowable;
        if (localObject1 == null) {
          break;
        }
        if (a((Throwable)localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("huayangCatchedException:");
          ((StringBuilder)localObject1).append(paramThrowable.getMessage());
          localObject2 = new RuntimeException(((StringBuilder)localObject1).toString());
          ((Throwable)localObject2).setStackTrace(arrayOfStackTraceElement);
          break;
        }
      }
      CrashReport.handleCatchException(Thread.currentThread(), (Throwable)localObject2, ThrowablesUtils.a((Throwable)localObject2), null);
      CrashReport.doUploadExceptionDatas();
      return;
    }
    catch (Throwable paramThrowable) {}
  }
  
  private static void c(Throwable paramThrowable)
  {
    int i;
    label170:
    do
    {
      try
      {
        Object localObject2 = Class.forName("java.lang.Throwable").getDeclaredFields();
        int k = localObject2.length;
        int j = 0;
        i = 0;
        while (i < k)
        {
          Object localObject1 = localObject2[i];
          if (localObject1.getName().equals("detailMessage"))
          {
            localObject1.setAccessible(true);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("huayangCatchedException:");
            ((StringBuilder)localObject2).append(paramThrowable.getMessage());
            localObject1.set(paramThrowable, ((StringBuilder)localObject2).toString());
            paramThrowable = paramThrowable.getCause();
            i = j;
            break label170;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("huayangCatchedException:");
            ((StringBuilder)localObject2).append(paramThrowable.getMessage());
            localObject1.set(paramThrowable, ((StringBuilder)localObject2).toString());
            paramThrowable = paramThrowable.getCause();
            i += 1;
            break label170;
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HuayangCrashReport", 2, "addStackTag failed", paramThrowable);
        }
      }
      while (paramThrowable == null) {}
    } while (i <= 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport
 * JD-Core Version:    0.7.0.1
 */