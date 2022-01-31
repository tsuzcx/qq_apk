package com.tencent.ttpic.videoshelf.utils;

public abstract interface ITTPTLogger
{
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.utils.ITTPTLogger
 * JD-Core Version:    0.7.0.1
 */