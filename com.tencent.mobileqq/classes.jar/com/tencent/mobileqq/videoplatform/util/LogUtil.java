package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.mobileqq.videoplatform.imp.LogImp;

public class LogUtil
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final int USR = 1;
  static ILog sLog = new LogImp();
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    sLog.d(paramString1, paramInt, paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2)
  {
    sLog.e(paramString1, paramInt, paramString2);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    sLog.e(paramString1, paramInt, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2)
  {
    sLog.i(paramString1, paramInt, paramString2);
  }
  
  public static boolean isColorLevel()
  {
    return sLog.isColorLevel();
  }
  
  public static void setLogImp(ILog paramILog)
  {
    sLog = paramILog;
  }
  
  public static void v(String paramString1, int paramInt, String paramString2)
  {
    sLog.v(paramString1, paramInt, paramString2);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2)
  {
    sLog.w(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.util.LogUtil
 * JD-Core Version:    0.7.0.1
 */