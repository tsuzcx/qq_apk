package com.tencent.mobileqq.pluginsdk;

import android.os.IInterface;

public abstract interface OnPluginInstallListener
  extends IInterface
{
  public abstract void onInstallBegin(String paramString);
  
  public abstract void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onInstallError(String paramString, int paramInt);
  
  public abstract void onInstallFinish(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
 * JD-Core Version:    0.7.0.1
 */