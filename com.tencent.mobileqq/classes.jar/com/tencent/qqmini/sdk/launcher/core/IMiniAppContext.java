package com.tencent.qqmini.sdk.launcher.core;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public abstract interface IMiniAppContext
{
  public abstract boolean canLaunchApp();
  
  public abstract AdReportData getAdReportData();
  
  public abstract Activity getAttachedActivity();
  
  public abstract String getBaseLibVersion();
  
  public abstract Context getContext();
  
  public abstract int getLaunchAppScene();
  
  @NonNull
  public abstract <T> T getManager(Class<T> paramClass);
  
  public abstract MiniAppInfo getMiniAppInfo();
  
  public abstract boolean isMiniGame();
  
  public abstract boolean isOrientationLandscape();
  
  public abstract <T> T performAction(Action<T> paramAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
 * JD-Core Version:    0.7.0.1
 */