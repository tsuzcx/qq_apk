package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.view.ViewGroup;
import mqq.app.AppRuntime;

public abstract interface MiniAppPullInterface
{
  public abstract void handlePullRefresh();
  
  public abstract boolean hasOpenDesktop();
  
  public abstract void hideMiniAppEntry(int paramInt);
  
  public abstract void initLater(ViewGroup paramViewGroup);
  
  public abstract void initUI(Activity paramActivity);
  
  public abstract boolean isMiniAppLauncherOpened();
  
  public abstract void onAccountChanged(AppRuntime paramAppRuntime);
  
  public abstract void onDestroy();
  
  public abstract void onPostThemeChanged();
  
  public abstract void onResume();
  
  public abstract void onStop();
  
  public abstract boolean showMicroAppEntry();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPullInterface
 * JD-Core Version:    0.7.0.1
 */