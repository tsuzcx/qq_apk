package com.tencent.qqperf.monitor.crash.catchedexception;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class CaughtExceptionReport
{
  private static final Set<String> a = new HashSet(20);
  private static final Set<Class> b = new HashSet(5);
  
  public static void a(Class paramClass)
  {
    b.add(paramClass);
  }
  
  public static void a(String paramString)
  {
    a.add(paramString);
  }
  
  public static void a(@NonNull Throwable paramThrowable)
  {
    a(paramThrowable, "This is CaughtException");
  }
  
  public static void a(@NonNull Throwable paramThrowable, @NonNull String paramString)
  {
    if (paramThrowable != null)
    {
      if (paramString == null) {
        return;
      }
      if (!a(paramThrowable))
      {
        Log.e("CaughtExceptionReport", "this report is not permitted. ", paramThrowable);
        return;
      }
      Object localObject = paramThrowable;
      if (!(paramThrowable instanceof CaughtException))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Caught: ");
        ((StringBuilder)localObject).append(paramThrowable.getMessage());
        localObject = new CaughtException(((StringBuilder)localObject).toString(), paramThrowable);
      }
      if (QLog.isColorLevel()) {
        QLog.e("CaughtExceptionReport-eup", 2, "rqd将上报信息到rdm网站，上报不会导致客户端闪退，仅用作数据统计");
      }
      paramThrowable = Thread.currentThread();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ExtraMessage: ");
      localStringBuilder.append(paramString);
      CrashReport.handleCatchException(paramThrowable, (Throwable)localObject, localStringBuilder.toString(), null);
    }
  }
  
  private static boolean a(Throwable paramThrowable)
  {
    if (b.contains(paramThrowable.getClass())) {
      return true;
    }
    paramThrowable = paramThrowable.getStackTrace();
    if (paramThrowable != null)
    {
      if (paramThrowable.length < 1) {
        return false;
      }
      paramThrowable = paramThrowable[0].getClassName();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext()) {
        if (paramThrowable.startsWith((String)localIterator.next())) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport
 * JD-Core Version:    0.7.0.1
 */