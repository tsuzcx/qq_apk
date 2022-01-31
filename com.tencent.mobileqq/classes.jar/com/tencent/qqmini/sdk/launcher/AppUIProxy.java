package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import bglr;
import bgls;
import bguk;
import bgun;
import bguq;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

public class AppUIProxy
  extends bguq
{
  private AppUIProxy.LoadingUI mLoadingUI;
  
  public void hideLoading()
  {
    if (this.mLoadingUI == null) {
      return;
    }
    this.mMainHandler.post(new AppUIProxy.1(this));
    bglr.a(System.currentTimeMillis());
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mLoadingUI = new AppUIProxy.LoadingUI(this, paramActivity.getApplicationContext());
    super.onCreate(paramActivity, paramBundle, paramViewGroup);
  }
  
  public void onDestroy(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onDestroy");
    if (this.mActivity == paramActivity)
    {
      this.mActivity = null;
      this.mRootLayout = null;
      if (this.mRuntime != null) {
        this.mRuntime.a(paramActivity);
      }
    }
    if (AppRuntimeLoaderManager.g().getCurrentRunTimeLoader() != null) {
      AppRuntimeLoaderManager.g().getCurrentRunTimeLoader().notifyRuntimeEvent(62, new Object[0]);
    }
  }
  
  public void onRuntimeReady()
  {
    if (!this.mActivatedRuntimeLoader.dismissLoadingAfterLoaded()) {
      this.mActivatedRuntimeLoader.addRuntimeStateObserver(new bguk(this));
    }
    for (;;)
    {
      super.onRuntimeReady();
      return;
      hideLoading();
    }
  }
  
  public void resumeRuntime(bgun parambgun)
  {
    if (this.mActivity == null) {
      QMLog.w("UIProxy", "Failed to resumeRuntime. Activity is null");
    }
    do
    {
      return;
      if (parambgun == null)
      {
        QMLog.w("UIProxy", "Failed to resumeRuntime. runtime loader is null");
        return;
      }
      this.mActivatedRuntimeLoader = parambgun;
      this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
      this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
      hideLoading();
    } while (this.mRuntime == null);
    this.mRuntime.a(this.mActivity, this.mRootLayout);
  }
  
  public void showLoading(MiniAppInfo paramMiniAppInfo)
  {
    if (this.mLoadingUI == null) {
      return;
    }
    this.mLoadingUI.a(paramMiniAppInfo);
    if (this.mLoadingUI.getVisibility() != 0) {
      this.mLoadingUI.setVisibility(0);
    }
    if (this.mLoadingUI.getParent() != null) {
      ((ViewGroup)this.mLoadingUI.getParent()).removeView(this.mLoadingUI);
    }
    this.mRootLayout.addView(this.mLoadingUI);
    this.mLoadingUI.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy
 * JD-Core Version:    0.7.0.1
 */