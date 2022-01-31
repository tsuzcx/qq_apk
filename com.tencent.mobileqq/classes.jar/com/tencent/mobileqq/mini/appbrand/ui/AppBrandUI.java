package com.tencent.mobileqq.mini.appbrand.ui;

import alrv;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.AppUIProxy;
import com.tencent.mobileqq.mini.app.IAppUIProxy;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

public class AppBrandUI
  extends BaseActivity
{
  public static final String TAG = "miniapp-start_AppBrandUI";
  protected IAppUIProxy mAppUIProxy;
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (getAppUIProxy().doDispatchKeyEvent(paramKeyEvent)) {
      return true;
    }
    return super.doDispatchKeyEvent(paramKeyEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    getAppUIProxy().doOnActivityResult(this, paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnBackPressed");
    getAppUIProxy().doOnBackPressed(this, true);
  }
  
  public void doOnBackPressedWithOutReport()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnBackPressed");
    getAppUIProxy().doOnBackPressed(this, false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnCreate");
    setRequestedOrientation(1);
    getAppUIProxy().doBeforeOnCreate(this, paramBundle);
    super.doOnCreate(paramBundle);
    return getAppUIProxy().doOnCreate(this, paramBundle);
  }
  
  public void doOnDestroy()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnDestroy");
    getAppUIProxy().doOnDestroy(this);
    super.doOnDestroy();
    MiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnResume");
    super.doOnNewIntent(paramIntent);
    getAppUIProxy().doOnNewIntent(this, paramIntent);
  }
  
  public void doOnPause()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnPause");
    getAppUIProxy().doOnPause(this);
    super.doOnPause();
    MiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void doOnResume()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnResume");
    super.doOnResume();
    getAppUIProxy().doOnResume(this);
  }
  
  public void doOnStop()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doOnStop");
    super.doOnStop();
    getAppUIProxy().doOnStop(this);
    MiniProgramLpReportDC04239.deleteRecordDurationMsg();
  }
  
  public void doRefreshMiniBadge(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "doRefreshMiniBadge");
    super.doRefreshMiniBadge(paramBundle);
    getAppUIProxy().doRefreshMiniBadge(this, paramBundle);
  }
  
  public void finish()
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "finish");
    getAppUIProxy().finish(this);
    super.finish();
  }
  
  public IAppUIProxy getAppUIProxy()
  {
    if (this.mAppUIProxy == null) {
      this.mAppUIProxy = AppLoaderFactory.createAppUIProxy();
    }
    return this.mAppUIProxy;
  }
  
  public alrv getColorNoteController()
  {
    IAppUIProxy localIAppUIProxy = getAppUIProxy();
    if ((localIAppUIProxy instanceof AppUIProxy)) {
      return ((AppUIProxy)localIAppUIProxy).getColorNoteController();
    }
    return null;
  }
  
  public boolean isWrapContent()
  {
    return getAppUIProxy().isWrapContent(this);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "moveTaskToBack nonRoot=" + paramBoolean);
    return super.moveTaskToBack(paramBoolean);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "moveTaskToBack nonRoot=" + paramBoolean1 + " bAnim=" + paramBoolean2);
    return getAppUIProxy().moveTaskToBack(this, paramBoolean1, paramBoolean2);
  }
  
  public void onProcessBackground(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "onProcessBackground");
    super.onProcessBackground(paramBundle);
    getAppUIProxy().onProcessBackground(this, paramBundle);
  }
  
  public void onProcessForeGround(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "onProcessForeGround");
    super.onProcessForeGround(paramBundle);
    getAppUIProxy().onProcessForeGround(this, paramBundle);
  }
  
  public void onRefreshMiniBadge(Bundle paramBundle)
  {
    QLog.i("miniapp-start_AppBrandUI", 1, "onRefreshMiniBadge");
    super.onRefreshMiniBadge(paramBundle);
    getAppUIProxy().onRefreshMiniBadge(this, paramBundle);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setColorNoteWithOutMoveTaskToBackThisTime()
  {
    IAppUIProxy localIAppUIProxy = getAppUIProxy();
    if ((localIAppUIProxy instanceof AppUIProxy)) {
      ((AppUIProxy)localIAppUIProxy).setColorNoteWithOutMoveTaskToBackThisTime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI
 * JD-Core Version:    0.7.0.1
 */