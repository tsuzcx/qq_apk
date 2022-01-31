package com.tencent.mobileqq.statistics;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

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
      sDetailMessageField.set(paramThrowable, paramString + " : " + paramThrowable.getMessage());
      return;
    }
    catch (Exception paramThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQCatchedExceptionReport", 2, "addCatchedMsgTag failed : ", paramThrowable);
    }
  }
  
  public static void reportQQCatchException(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeMemoryMonitor", 2, "[tag]" + paramString1 + "[msg]" + paramString2);
    }
    reportQQCatchedException(new Exception("CatchedNativeException"), paramString1, paramString2);
  }
  
  public static void reportQQCatchedException(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if ((paramThrowable == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    addCatchedMsgTag(paramThrowable, paramString1);
    CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QQCatchedExceptionReporter
 * JD-Core Version:    0.7.0.1
 */