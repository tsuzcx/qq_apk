package com.tencent.mobileqq.msf.sdk.b;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class a
{
  private static final String a = "MSFCatchedExceptionReporter";
  private static Field b;
  
  private static void a(Throwable paramThrowable, String paramString)
  {
    try
    {
      if (b == null) {
        b = Throwable.class.getDeclaredField("detailMessage");
      }
      b.setAccessible(true);
      Field localField = b;
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
        QLog.e("MSFCatchedExceptionReporter", 2, "addCatchedMsgTag failed : ", paramThrowable);
      }
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString1, String paramString2)
  {
    if ((paramThrowable != null) && (paramString1 != null))
    {
      if (paramString2 == null) {
        return;
      }
      a(paramThrowable, paramString1);
      CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, paramString2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */