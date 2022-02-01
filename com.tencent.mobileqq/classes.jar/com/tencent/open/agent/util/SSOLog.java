package com.tencent.open.agent.util;

import com.tencent.qphone.base.util.QLog;

public class SSOLog
{
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK_LOGIN.");
      localStringBuilder.append(paramString1);
      QLog.d(localStringBuilder.toString(), 2, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_LOGIN.");
    localStringBuilder.append(paramString1);
    QLog.d(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_LOGIN.");
    localStringBuilder.append(paramString);
    QLog.d(localStringBuilder.toString(), 1, paramVarArgs);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_LOGIN.");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_LOGIN.");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_LOGIN.");
    localStringBuilder.append(paramString);
    QLog.e(localStringBuilder.toString(), 1, paramVarArgs);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDK_LOGIN.");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.SSOLog
 * JD-Core Version:    0.7.0.1
 */