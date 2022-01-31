package com.tencent.mobileqq.mini.app;

import amgv;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;

public abstract interface IAppUIProxy
  extends amgv
{
  public abstract void completeLoading(BaseActivity paramBaseActivity);
  
  public abstract boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract boolean doDispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean);
  
  public abstract boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void doOnDestroy(BaseActivity paramBaseActivity);
  
  public abstract void doOnNewIntent(BaseActivity paramBaseActivity, Intent paramIntent);
  
  public abstract void doOnPause(BaseActivity paramBaseActivity);
  
  public abstract void doOnResume(BaseActivity paramBaseActivity);
  
  public abstract void doOnStart(BaseActivity paramBaseActivity);
  
  public abstract void doOnStop(BaseActivity paramBaseActivity);
  
  public abstract void doRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void finish(BaseActivity paramBaseActivity);
  
  public abstract Fragment getAppBrandFragment();
  
  public abstract boolean isWrapContent(BaseActivity paramBaseActivity);
  
  public abstract boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onProcessBackground(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void onProcessForeGround(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void onRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle);
  
  public abstract void startLoading(BaseActivity paramBaseActivity, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.IAppUIProxy
 * JD-Core Version:    0.7.0.1
 */