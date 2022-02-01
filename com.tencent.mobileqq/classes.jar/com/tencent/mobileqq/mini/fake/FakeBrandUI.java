package com.tencent.mobileqq.mini.fake;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import apkn;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AppUIProxy;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

public class FakeBrandUI
  implements IFakeBrandUI
{
  protected IAppUIProxy mAppUIProxy;
  
  public boolean doBeforeOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    return getAppUIProxy().doBeforeOnCreate(paramBaseActivity, paramBundle);
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return getAppUIProxy().doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doOnActivityResult(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    getAppUIProxy().doOnActivityResult(paramBaseActivity, paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    getAppUIProxy().doOnBackPressed(paramBaseActivity, true);
  }
  
  public boolean doOnCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    return getAppUIProxy().doOnCreate(paramBaseActivity, paramBundle);
  }
  
  public void doOnDestroy(BaseActivity paramBaseActivity)
  {
    getAppUIProxy().doOnDestroy(paramBaseActivity);
    MiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void doOnNewIntent(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    getAppUIProxy().doOnNewIntent(paramBaseActivity, paramIntent);
  }
  
  public void doOnPause(BaseActivity paramBaseActivity)
  {
    getAppUIProxy().doOnPause(paramBaseActivity);
    MiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void doOnResume(BaseActivity paramBaseActivity)
  {
    getAppUIProxy().doOnResume(paramBaseActivity);
  }
  
  public void doOnStart(BaseActivity paramBaseActivity)
  {
    getAppUIProxy().doOnStart(paramBaseActivity);
  }
  
  public void doOnStop(BaseActivity paramBaseActivity)
  {
    getAppUIProxy().doOnStop(paramBaseActivity);
    MiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void doRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    getAppUIProxy().doRefreshMiniBadge(paramBaseActivity, paramBundle);
  }
  
  public void finish(BaseActivity paramBaseActivity)
  {
    getAppUIProxy().finish(paramBaseActivity);
  }
  
  public IAppUIProxy getAppUIProxy()
  {
    if (this.mAppUIProxy == null) {
      this.mAppUIProxy = AppLoaderFactory.createAppUIProxy();
    }
    return this.mAppUIProxy;
  }
  
  public apkn getColorNoteController()
  {
    IAppUIProxy localIAppUIProxy = getAppUIProxy();
    if ((localIAppUIProxy instanceof AppUIProxy)) {
      return ((AppUIProxy)localIAppUIProxy).getColorNoteController();
    }
    return null;
  }
  
  public boolean isWrapContent(BaseActivity paramBaseActivity)
  {
    return getAppUIProxy().isWrapContent(paramBaseActivity);
  }
  
  public boolean moveTaskToBack(BaseActivity paramBaseActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    return getAppUIProxy().moveTaskToBack(paramBaseActivity, paramBoolean1, paramBoolean2);
  }
  
  public void onProcessBackground(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    getAppUIProxy().onProcessBackground(paramBaseActivity, paramBundle);
  }
  
  public void onProcessForeGround(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    getAppUIProxy().onProcessForeGround(paramBaseActivity, paramBundle);
  }
  
  public void onRefreshMiniBadge(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    getAppUIProxy().onRefreshMiniBadge(paramBaseActivity, paramBundle);
  }
  
  public void setColorNoteWithOutMoveTaskToBackThisTime()
  {
    IAppUIProxy localIAppUIProxy = getAppUIProxy();
    if ((localIAppUIProxy instanceof AppUIProxy)) {
      ((AppUIProxy)localIAppUIProxy).setColorNoteWithOutMoveTaskToBackThisTime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeBrandUI
 * JD-Core Version:    0.7.0.1
 */