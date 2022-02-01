package com.tencent.mobileqq.qroute.module;

public abstract interface IQRoutePluginInstallListener
{
  public abstract void onInstallBegin(String paramString);
  
  public abstract void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onInstallError(String paramString, int paramInt);
  
  public abstract void onInstallFinish(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener
 * JD-Core Version:    0.7.0.1
 */