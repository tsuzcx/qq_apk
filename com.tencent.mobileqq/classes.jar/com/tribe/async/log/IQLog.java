package com.tribe.async.log;

public abstract interface IQLog
{
  public static final int DEBUG = 3;
  public static final int ERROR = 6;
  public static final int INFO = 4;
  public static final int VERBOSE = 2;
  public static final int WARN = 5;
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void w(String paramString, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.log.IQLog
 * JD-Core Version:    0.7.0.1
 */