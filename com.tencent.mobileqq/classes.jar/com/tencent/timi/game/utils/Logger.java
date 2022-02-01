package com.tencent.timi.game.utils;

import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

public class Logger
{
  public static String a(long paramLong)
  {
    return "";
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.i(paramString1, paramInt, paramString2);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.w(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.i(paramString1, 2, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public static String b(long paramLong)
  {
    return LogUtil.getSafePrintUin(String.valueOf(paramLong));
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.d(paramString1, paramInt, paramString2);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    LogMsgChecker.a.a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.e(paramString1, paramInt, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.e(paramString1, 1, paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    QLog.w(paramString1, paramInt, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    LogMsgChecker.a.a(paramString2);
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.Logger
 * JD-Core Version:    0.7.0.1
 */