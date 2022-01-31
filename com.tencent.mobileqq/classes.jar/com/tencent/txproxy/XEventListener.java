package com.tencent.txproxy;

import android.app.Activity;
import android.os.Bundle;

public abstract interface XEventListener
{
  public abstract void onDataReport(String paramString, Bundle paramBundle);
  
  public abstract void onDownload(int paramInt, String paramString1, String paramString2, HostEventListener paramHostEventListener);
  
  public abstract void onError(String paramString1, int paramInt, String paramString2);
  
  public abstract void onGetPluginActivity(Activity paramActivity);
  
  public abstract void onLog(String paramString1, String paramString2, int paramInt);
  
  public abstract void onPluginInstalled(String paramString);
  
  public abstract void onPluginLoaded(String paramString);
  
  public abstract void onPluginRun(String paramString);
  
  public abstract void onProgress(String paramString, int paramInt);
  
  public abstract void onReceivePluginMsg(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract int onUnZipSo(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.XEventListener
 * JD-Core Version:    0.7.0.1
 */