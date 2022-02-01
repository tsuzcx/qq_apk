package com.tencent.qqperf.monitor.crash.catchedexception;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

@Deprecated
public class QQCatchedExceptionReporter
{
  private static final String TAG = "QQCatchedExceptionReport";
  private static Field sDetailMessageField;
  
  private static void addCatchedMsgTag(Throwable paramThrowable, String paramString)
  {
    try
    {
      if (sDetailMessageField == null) {
        sDetailMessageField = Throwable.class.getDeclaredField("detailMessage");
      }
      sDetailMessageField.setAccessible(true);
      Field localField = sDetailMessageField;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" : ");
      localStringBuilder.append(paramThrowable.getMessage());
      localField.set(paramThrowable, localStringBuilder.toString());
      return;
    }
    catch (Exception paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQCatchedExceptionReport", 2, "addCatchedMsgTag failed : ", paramThrowable);
      }
    }
  }
  
  public static void reportQQCatchException(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tag]");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("[msg]");
      localStringBuilder.append(paramString2);
      QLog.d("NativeMemoryMonitor", 2, localStringBuilder.toString());
    }
    reportQQCatchedException(new Exception("CatchedNativeException"), paramString1, paramString2);
  }
  
  public static void reportQQCatchedException(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if ((paramThrowable != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      addCatchedMsgTag(paramThrowable, paramString1);
      CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, paramString2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.catchedexception.QQCatchedExceptionReporter
 * JD-Core Version:    0.7.0.1
 */