package com.tencent.pts.utils;

public abstract interface PTSLogger
{
  public static final String DEBUG = "DEBUG";
  public static final String EVENT = "EVENT";
  public static final String INFO = "INFO";
  public static final String WARN = "WARN";
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isDebug();
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSLogger
 * JD-Core Version:    0.7.0.1
 */