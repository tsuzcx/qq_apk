package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.lang.reflect.Field;

public class HuayangCrashReport
{
  public static void a(Throwable paramThrowable)
  {
    Monitor.a("2490056");
    b(paramThrowable);
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
      for (Throwable localThrowable = paramThrowable;; localThrowable = localThrowable.getCause())
      {
        Object localObject = paramThrowable;
        if (localThrowable != null)
        {
          if (a(localThrowable))
          {
            localObject = new RuntimeException("huayangCatchedException:" + paramThrowable.getMessage());
            ((Throwable)localObject).setStackTrace(arrayOfStackTraceElement);
          }
        }
        else
        {
          CrashReport.handleCatchException(Thread.currentThread(), (Throwable)localObject, ThrowablesUtils.a((Throwable)localObject), null);
          CrashReport.doUploadExceptionDatas();
          return;
        }
      }
      return;
    }
    catch (Throwable paramThrowable) {}
  }
  
  private static void c(Throwable paramThrowable)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        Field[] arrayOfField = Class.forName("java.lang.Throwable").getDeclaredFields();
        int k = arrayOfField.length;
        i = 0;
        if (i >= k) {
          return;
        }
        localField = arrayOfField[i];
        if (!localField.getName().equals("detailMessage")) {
          continue;
        }
        localField.setAccessible(true);
        localField.set(paramThrowable, "huayangCatchedException:" + paramThrowable.getMessage());
        paramThrowable = paramThrowable.getCause();
        i = j;
      }
      catch (Throwable paramThrowable)
      {
        int i;
        Field localField;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("HuayangCrashReport", 2, "addStackTag failed", paramThrowable);
        return;
        if (paramThrowable == null) {
          return;
        }
        if (i <= 10) {
          continue;
        }
      }
      localField.set(paramThrowable, "huayangCatchedException:" + paramThrowable.getMessage());
      paramThrowable = paramThrowable.getCause();
      i += 1;
      continue;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangCrashReport
 * JD-Core Version:    0.7.0.1
 */