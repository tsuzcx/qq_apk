package com.tencent.vas.update.callback;

import android.content.Context;

public abstract interface ICommonManager
{
  public abstract boolean copyFile(String paramString1, String paramString2);
  
  public abstract boolean filePatch(String paramString1, String paramString2);
  
  public abstract String getAppVersion();
  
  public abstract Context getApplicationContext();
  
  public abstract String getFileMd5(String paramString);
  
  public abstract int getNetType();
  
  public abstract String getReportVersion();
  
  public abstract String getSeqConfigPath();
  
  public abstract long getServiceTime();
  
  public abstract long getTimerDelay();
  
  public abstract String unCompressFile(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.callback.ICommonManager
 * JD-Core Version:    0.7.0.1
 */