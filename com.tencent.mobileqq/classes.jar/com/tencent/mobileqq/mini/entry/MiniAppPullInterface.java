package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface MiniAppPullInterface
{
  public abstract void handlePullRefresh();
  
  public abstract boolean hasOpenDesktop();
  
  public abstract void hideMiniAppEntry();
  
  public abstract void initLater(DrawerFrame paramDrawerFrame);
  
  public abstract void initUI(Activity paramActivity);
  
  public abstract boolean isMiniAppLauncherOpened();
  
  public abstract void onAccountChanged(QQAppInterface paramQQAppInterface);
  
  public abstract void onPostThemeChanged();
  
  public abstract void onResume();
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppPullInterface
 * JD-Core Version:    0.7.0.1
 */