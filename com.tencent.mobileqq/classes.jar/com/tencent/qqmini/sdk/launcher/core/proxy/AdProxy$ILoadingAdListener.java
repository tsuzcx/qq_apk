package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.view.View;

public abstract interface AdProxy$ILoadingAdListener
{
  public abstract void getLoadingAdLayoutReady();
  
  public abstract void onAdClick(int paramInt);
  
  public abstract void onAdDismiss(boolean paramBoolean);
  
  public abstract void onAdShow(View paramView);
  
  public abstract void onDownloadAdEnd(String paramString1, long paramLong, String paramString2);
  
  public abstract void onPreloadAdReceive(int paramInt);
  
  public abstract void onSelectAdProcessDone(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
 * JD-Core Version:    0.7.0.1
 */