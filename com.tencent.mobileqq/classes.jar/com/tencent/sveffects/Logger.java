package com.tencent.sveffects;

public abstract interface Logger
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract boolean isEnable();
  
  public abstract void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sveffects.Logger
 * JD-Core Version:    0.7.0.1
 */