package com.tencent.oskplayer.util;

import com.tencent.oskplayer.support.log.ILogger;

public class LogProxy
  implements ILogger
{
  private QLog qLog;
  
  public LogProxy(QLog paramQLog)
  {
    this.qLog = paramQLog;
  }
  
  public int d(String paramString1, String paramString2)
  {
    return this.qLog.d(paramString1, paramString2);
  }
  
  public int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return this.qLog.d(paramString1, paramString2, paramThrowable);
  }
  
  public int e(String paramString1, String paramString2)
  {
    return this.qLog.e(paramString1, paramString2);
  }
  
  public int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return this.qLog.i(paramString1, paramString2, paramThrowable);
  }
  
  public int i(String paramString1, String paramString2)
  {
    return this.qLog.i(paramString1, paramString2);
  }
  
  public int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return this.qLog.i(paramString1, paramString2, paramThrowable);
  }
  
  public int v(String paramString1, String paramString2)
  {
    return this.qLog.v(paramString1, paramString2);
  }
  
  public int v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return this.qLog.v(paramString1, paramString2, paramThrowable);
  }
  
  public int w(String paramString1, String paramString2)
  {
    return this.qLog.w(paramString1, paramString2);
  }
  
  public int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return this.qLog.i(paramString1, paramString2, paramThrowable);
  }
  
  public int w(String paramString, Throwable paramThrowable)
  {
    return this.qLog.w(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.util.LogProxy
 * JD-Core Version:    0.7.0.1
 */