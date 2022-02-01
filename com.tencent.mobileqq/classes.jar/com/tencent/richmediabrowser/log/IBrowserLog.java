package com.tencent.richmediabrowser.log;

public abstract interface IBrowserLog
{
  public static final int CLR = 2;
  public static final int DEV = 4;
  public static final int USR = 1;
  
  public abstract void d(String paramString1, int paramInt, String paramString2);
  
  public abstract void e(String paramString1, int paramInt, String paramString2);
  
  public abstract void i(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean isColorLevel();
  
  public abstract void w(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.log.IBrowserLog
 * JD-Core Version:    0.7.0.1
 */