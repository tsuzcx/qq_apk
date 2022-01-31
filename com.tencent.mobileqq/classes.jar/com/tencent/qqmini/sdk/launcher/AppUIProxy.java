package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import bdcw;
import bdli;
import bdlm;
import bdln;
import bdlq;
import bdlt;
import bdnw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class AppUIProxy
  extends bdlt
{
  public static final String TAG = "minisdk-start_AppUIProxy";
  private AppUIProxy.LoadingUI mLoadingUI;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  private void initOnIntentChanged()
  {
    if (this.mIntent == null) {}
    Bundle localBundle;
    MiniAppInfo localMiniAppInfo;
    bdlq localbdlq;
    do
    {
      return;
      localBundle = this.mIntent.getExtras();
      localMiniAppInfo = (MiniAppInfo)this.mIntent.getParcelableExtra("KEY_APPINFO");
      localbdlq = bdli.a().a(localMiniAppInfo);
      bdnw.b("minisdk-start_AppUIProxy", "queryAppRunTimeLoader Loader:" + localbdlq);
      if (localbdlq == null) {
        break;
      }
      bdli.a().a(localbdlq);
    } while (!localbdlq.isLoadSucceed());
    onRuntimeResume(localbdlq);
    showLoading(false, null);
    return;
    showLoading(true, this.mIntent);
    bdli.a().a(localMiniAppInfo, new bdlm(this), localBundle);
  }
  
  private void onRuntimeCompleted(bdlq parambdlq)
  {
    if ((parambdlq == null) || (parambdlq.getRuntime() == null) || (this.mActivity == null)) {
      return;
    }
    if (!parambdlq.dismissLoadingAfterLoaded()) {
      parambdlq.addRuntimeStateObserver(new bdln(this));
    }
    for (;;)
    {
      this.mRuntime = parambdlq.getRuntime();
      this.mRuntime.a(this.mActivity, this.mRootLayout);
      this.mRuntime.a(parambdlq.getMiniAppInfo(), null);
      return;
      showLoading(false, null);
    }
  }
  
  private void onRuntimeResume(bdlq parambdlq)
  {
    if ((parambdlq == null) || (parambdlq.getRuntime() == null) || (this.mActivity == null)) {
      return;
    }
    this.mRuntime = parambdlq.getRuntime();
    this.mRuntime.a(this.mActivity, this.mRootLayout);
  }
  
  private void showLoading(boolean paramBoolean, Intent paramIntent)
  {
    if (this.mLoadingUI == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mLoadingUI.a(paramIntent);
      if (this.mLoadingUI.getVisibility() != 0) {
        this.mLoadingUI.setVisibility(0);
      }
      if (this.mLoadingUI.getParent() != null) {
        ((ViewGroup)this.mLoadingUI.getParent()).removeView(this.mLoadingUI);
      }
      this.mRootLayout.addView(this.mLoadingUI);
      this.mLoadingUI.a();
      return;
    }
    this.mLoadingUI.b();
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    super.onCreate(paramActivity, paramBundle, paramViewGroup);
    this.mLoadingUI = new AppUIProxy.LoadingUI(this, paramActivity.getApplicationContext());
    initOnIntentChanged();
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    super.onNewIntent(paramActivity, paramIntent);
    initOnIntentChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy
 * JD-Core Version:    0.7.0.1
 */