package com.tencent.rmonitor.fd.utils;

import com.tencent.rmonitor.common.logger.Logger;

public final class LogUtils
{
  public static void a(String paramString1, String paramString2)
  {
    Logger.b.i(new String[] { paramString1, paramString2 });
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Logger.b.a(paramString1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Logger.b.d(new String[] { paramString1, paramString2 });
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Logger.b.w(new String[] { paramString1, paramString2 });
  }
  
  public static void d(String paramString1, String paramString2)
  {
    Logger.b.e(new String[] { paramString1, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */