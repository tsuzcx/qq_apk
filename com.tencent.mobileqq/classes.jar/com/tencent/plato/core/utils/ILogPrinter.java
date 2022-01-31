package com.tencent.plato.core.utils;

public abstract interface ILogPrinter
{
  public abstract int d(String paramString1, String paramString2);
  
  public abstract int d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int e(String paramString1, String paramString2);
  
  public abstract int e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int i(String paramString1, String paramString2);
  
  public abstract int i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int w(String paramString1, String paramString2);
  
  public abstract int w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.core.utils.ILogPrinter
 * JD-Core Version:    0.7.0.1
 */