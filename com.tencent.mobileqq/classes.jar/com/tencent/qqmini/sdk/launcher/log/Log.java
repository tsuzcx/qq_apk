package com.tencent.qqmini.sdk.launcher.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;

@MiniKeep
public abstract interface Log
{
  public static final int ASSERT = 6;
  public static final int DEBUG = 2;
  public static final int ERROR = 5;
  public static final int INFO = 3;
  public static final int VERBOSE = 1;
  public static final int WARN = 4;
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int getLogLevel();
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.log.Log
 * JD-Core Version:    0.7.0.1
 */