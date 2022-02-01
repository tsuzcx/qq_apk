package com.tencent.mobileqq.mini.api.entry;

import android.view.ViewGroup;
import mqq.app.AppRuntime;

public abstract interface BaseContactsMiniAppEntryManager
{
  public abstract void onAccountChanged(AppRuntime paramAppRuntime);
  
  public abstract void onPostThemeChanged();
  
  public abstract void setDrawerFrameEvent(int paramInt);
  
  public abstract void showMicroAppPanel(int paramInt);
  
  public abstract void shutdownMiniAppPullDownEntry(ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.entry.BaseContactsMiniAppEntryManager
 * JD-Core Version:    0.7.0.1
 */