package com.tencent.qqmini.sdk.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import bdcw;
import bdit;
import bdle;
import bdli;
import bdlq;
import bdlt;
import bdlx;
import bdnp;
import bdnw;
import bdqv;
import bdqw;
import bdqy;
import bdsc;
import bdsh;
import bdsx;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class GameUIProxy
  extends bdlt
{
  static final String TAG = "GameUI";
  private LoadingUI mLoadingUI;
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  private void createRuntime(bdlq parambdlq)
  {
    if ((parambdlq == null) || (parambdlq.getRuntime() == null) || (this.mActivity == null)) {
      return;
    }
    if (parambdlq.dismissLoadingAfterLoaded()) {
      this.mLoadingUI.a();
    }
    this.mRuntime = parambdlq.getRuntime();
    this.mRuntime.a(parambdlq.getMiniAppInfo(), null);
    this.mRuntime.a(this.mActivity, this.mRootLayout);
    this.mRuntime.a(this.mMiniAppInfo, false);
  }
  
  private void initOnIntentChanged()
  {
    if (this.mIntent == null) {
      return;
    }
    Bundle localBundle = this.mIntent.getExtras();
    bdlx.a().a(getActivity());
    bdlx.a().a(this.mMiniAppInfo);
    bdlq localbdlq = bdli.a().a(this.mMiniAppInfo);
    if (localbdlq != null)
    {
      resumeRuntime(localbdlq);
      return;
    }
    this.mLoadingUI.a(this.mIntent).a(this.mRootLayout);
    initRuntimeLoader(this.mMiniAppInfo, localBundle);
  }
  
  private bdlq initRuntimeLoader(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    bdqv localbdqv = new bdqv(this);
    bdli.a().a(localbdqv);
    return bdli.a().a(paramMiniAppInfo, new bdqw(this), paramBundle);
  }
  
  private boolean isValidABI()
  {
    if (bdqy.b)
    {
      if (this.mMiniAppInfo != null)
      {
        bdsx.a(this.mMiniAppInfo, "1", null, "load_fail", "system_version_limit_fail");
        bdsc.a("2launch_fail", "system_version_limit_fail", null, this.mMiniAppInfo);
      }
      return false;
    }
    return true;
  }
  
  private void resumeRuntime(bdlq parambdlq)
  {
    if ((parambdlq == null) || (parambdlq.getRuntime() == null) || (this.mActivity == null)) {
      return;
    }
    this.mLoadingUI.a();
    this.mRuntime = parambdlq.getRuntime();
    this.mRuntime.a(this.mMiniAppInfo, false);
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public LoadingUI getLoadingUI()
  {
    return this.mLoadingUI;
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    super.onCreate(paramActivity, paramBundle, paramViewGroup);
    if (!isValidABI())
    {
      bdit.a(this.mActivity, "小游戏不支持该设备", 1).a();
      this.mActivity.finish();
      return;
    }
    this.mLoadingUI = new LoadingUI(paramActivity);
    initOnIntentChanged();
  }
  
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    super.onNewIntent(paramActivity, paramIntent);
    bdnw.b("GameUI", "onNewIntent");
    initOnIntentChanged();
  }
  
  public void onStop(Activity paramActivity)
  {
    if (this.mRuntime != null) {
      this.mRuntime.d();
    }
    bdle.a().a().onAppBackground(this.mMiniAppInfo, null);
    if (bdli.a().a() != null) {
      bdli.a().a().notifyRuntimeEvent(22, new Object[0]);
    }
  }
  
  public void reportEnineLoadFail()
  {
    bdsh.a(this.mMiniAppInfo, 510);
  }
  
  public void reportGkpLoadFail()
  {
    bdsh.a(this.mMiniAppInfo, 511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameUIProxy
 * JD-Core Version:    0.7.0.1
 */