package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import begv;
import begw;
import bepo;
import beps;
import bepv;
import bepy;
import besl;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppUIProxy
  extends bepy
{
  private AppUIProxy.LoadingUI mLoadingUI;
  
  public void hideLoading()
  {
    if (this.mLoadingUI == null) {
      return;
    }
    this.mMainHandler.post(new AppUIProxy.1(this));
    begv.a(System.currentTimeMillis());
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mLoadingUI = new AppUIProxy.LoadingUI(this, paramActivity.getApplicationContext());
    super.onCreate(paramActivity, paramBundle, paramViewGroup);
  }
  
  public void onDestroy(Activity paramActivity)
  {
    besl.b("UIProxy", "onDestroy");
    if (this.mActivity == paramActivity)
    {
      this.mActivity = null;
      this.mRootLayout = null;
      if (this.mRuntime != null) {
        this.mRuntime.a(paramActivity);
      }
    }
    if (bepo.a().a() != null) {
      bepo.a().a().notifyRuntimeEvent(62, new Object[0]);
    }
  }
  
  public void onRuntimeReady()
  {
    if (!this.mActivatedRuntimeLoader.dismissLoadingAfterLoaded()) {
      this.mActivatedRuntimeLoader.addRuntimeStateObserver(new beps(this));
    }
    for (;;)
    {
      super.onRuntimeReady();
      return;
      hideLoading();
    }
  }
  
  public void resumeRuntime(bepv parambepv)
  {
    if (this.mActivity == null) {
      besl.c("UIProxy", "Failed to resumeRuntime. Activity is null");
    }
    do
    {
      return;
      if (parambepv == null)
      {
        besl.c("UIProxy", "Failed to resumeRuntime. runtime loader is null");
        return;
      }
      this.mActivatedRuntimeLoader = parambepv;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy
 * JD-Core Version:    0.7.0.1
 */