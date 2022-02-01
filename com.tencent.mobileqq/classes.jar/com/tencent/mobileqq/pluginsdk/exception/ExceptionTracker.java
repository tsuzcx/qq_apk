package com.tencent.mobileqq.pluginsdk.exception;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public final class ExceptionTracker
{
  public static void printCallStack(String paramString)
  {
    printCallStack(paramString, 1);
  }
  
  public static void printCallStack(String paramString, int paramInt)
  {
    int i = paramInt + 3;
    for (;;)
    {
      try
      {
        StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
        if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length > i))
        {
          paramInt = i;
          if (QLog.isColorLevel())
          {
            QLog.d(paramString, 2, "printCallStack:");
            paramInt = i;
          }
          if (paramInt < arrayOfStackTraceElement.length)
          {
            if (!QLog.isColorLevel()) {
              break label108;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(arrayOfStackTraceElement[paramInt]);
            QLog.d(paramString, 2, localStringBuilder.toString());
            break label108;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d(paramString, 2, "printCallStack empty");
        }
        return;
      }
      catch (Throwable paramString)
      {
        return;
      }
      label108:
      paramInt += 1;
    }
  }
  
  public static void trackException(String paramString1, String paramString2)
  {
    printCallStack(paramString1, 1);
    try
    {
      throw new IllegalArgumentException(paramString2);
    }
    catch (Exception paramString2)
    {
      new Handler(Looper.getMainLooper()).post(new ExceptionTracker.1(paramString1, paramString2));
      throw new IllegalArgumentException(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker
 * JD-Core Version:    0.7.0.1
 */