package com.tencent.qqmini.sdk.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import behn;
import behp;
import beln;
import benn;
import beqb;
import beqf;
import beqm;
import beqp;
import beqy;
import besv;
import betc;
import beuy;
import bevk;
import bewz;
import bexa;
import bexg;
import bexh;
import bexm;
import beyq;
import bezi;
import bezl;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;

public class GameUIProxy
  extends beqp
{
  private long mBeginOnCreate;
  private bexh mBroadcastWatcher;
  private boolean mHasReportStepOnResume;
  private LoadingUI mLoadingUI;
  private boolean mPkgDownloadFlag;
  
  private static boolean isValidABI(MiniAppInfo paramMiniAppInfo)
  {
    if (bexg.b)
    {
      if (paramMiniAppInfo != null)
      {
        bezl.a(paramMiniAppInfo, "1", null, "load_fail", "system_version_limit_fail");
        beyq.a("2launch_fail", "system_version_limit_fail", null, paramMiniAppInfo);
      }
      return false;
    }
    return true;
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public behp getJsService()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.a();
    }
    return null;
  }
  
  public LoadingUI getLoadingUI()
  {
    return this.mLoadingUI;
  }
  
  public void hideLoading()
  {
    if (this.mLoadingUI == null) {
      return;
    }
    this.mLoadingUI.a();
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    beqf.a().a(2053, new Object[0]);
    return super.onBackPressed(paramActivity);
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mBeginOnCreate = System.currentTimeMillis();
    this.mBroadcastWatcher = new bexh(paramActivity);
    this.mBroadcastWatcher.a(new bexa(this));
    this.mBroadcastWatcher.a();
    Intent localIntent;
    long l1;
    label66:
    MiniAppInfo localMiniAppInfo;
    label83:
    long l2;
    if (paramActivity != null)
    {
      localIntent = paramActivity.getIntent();
      if (localIntent == null) {
        break label182;
      }
      l1 = localIntent.getLongExtra("startDuration", 0L);
      if (localIntent == null) {
        break label188;
      }
      localMiniAppInfo = (MiniAppInfo)localIntent.getParcelableExtra("KEY_APPINFO");
      int i = localIntent.getIntExtra("start_mode", 3);
      l2 = this.mBeginOnCreate;
      if (localMiniAppInfo != null) {
        bezi.a(localMiniAppInfo, 1030, null, null, null, i, "1", l2 - l1, null);
      }
      this.mLoadingUI = new LoadingUI(paramActivity);
      super.onCreate(paramActivity, paramBundle, paramViewGroup);
      if (isValidABI(getMiniAppInfo())) {
        break label194;
      }
      benn.a(this.mActivity, "小游戏不支持该设备", 1).a();
      this.mActivity.finish();
    }
    label182:
    label188:
    label194:
    do
    {
      return;
      localIntent = null;
      break;
      l1 = 0L;
      break label66;
      localMiniAppInfo = null;
      break label83;
      beqf.a().a(1, new Object[0]);
      beqy.a().a(paramActivity);
      beqy.a().a(getMiniAppInfo());
      paramActivity = new bewz(this);
      beqf.a().a(paramActivity);
      l1 = System.currentTimeMillis();
      l2 = this.mBeginOnCreate;
    } while (localMiniAppInfo == null);
    bezi.a(localMiniAppInfo, 1031, null, null, null, 0, "1", l1 - l2, null);
  }
  
  public void onDestroy(Activity paramActivity)
  {
    betc.b("UIProxy", "onDestroy");
    if (this.mActivity == paramActivity)
    {
      this.mActivity = null;
      this.mRootLayout = null;
      if (this.mRuntime != null)
      {
        this.mRuntime.e();
        this.mRuntime.a(paramActivity);
      }
      beqf.a().a(this.mActivatedRuntimeLoader);
    }
    beqf.a().a(62, new Object[0]);
    this.mBroadcastWatcher.b();
  }
  
  public void onPause(Activity paramActivity)
  {
    super.onPause(paramActivity);
    beqf.a().a(2052, new Object[0]);
  }
  
  public void onResume(Activity paramActivity)
  {
    long l1 = System.currentTimeMillis();
    super.onResume(paramActivity);
    if ((this.mActivatedRuntimeLoader != null) && (!this.mActivatedRuntimeLoader.isLoadSucceed())) {
      this.mActivatedRuntimeLoader.notifyRuntimeEvent(2041, new Object[0]);
    }
    long l2 = System.currentTimeMillis();
    if (!this.mHasReportStepOnResume)
    {
      this.mHasReportStepOnResume = true;
      bezi.a(this.mMiniAppInfo, 1035, null, null, null, 0, "1", l2 - l1, null);
    }
  }
  
  public void onRuntimeReady()
  {
    betc.b("UIProxy", "GameRuntime onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
    if (this.mRuntime != null) {
      ((beuy)this.mRuntime).b(this.mPkgDownloadFlag);
    }
    if (((this.mActivatedRuntimeLoader instanceof GameRuntimeLoader)) && (!((GameRuntimeLoader)this.mActivatedRuntimeLoader).isGameReadyStart(this.mMiniAppInfo)))
    {
      bezl.a(this.mMiniAppInfo, "1", null, "load_fail", "not_ready");
      beyq.a("2launch_fail", "not_ready", null, this.mMiniAppInfo);
      return;
    }
    if (beln.a(getActivity()) == 0)
    {
      if ((this.mMiniAppInfo != null) && (!this.mMiniAppInfo.isSupportOffline))
      {
        bezl.a(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_support");
        beyq.a("2launch_fail", "offline_not_support", null, this.mMiniAppInfo);
        benn.a(getActivity(), "此游戏暂不支持离线模式", 0).a();
        return;
      }
      if ((this.mMiniAppInfo != null) && (!bevk.a(this.mMiniAppInfo)))
      {
        bezl.a(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_ready");
        beyq.a("2launch_fail", "offline_not_ready", null, this.mMiniAppInfo);
        benn.a(getActivity(), "游戏资源未加载完成，请联网后重试", 0).a();
        return;
      }
    }
    this.mMainHandler.post(new GameUIProxy.2(this));
  }
  
  public void onStop(Activity paramActivity)
  {
    if (getRuntime() != null) {
      getRuntime().d();
    }
    beqb.a().a().onAppBackground(getMiniAppInfo(), null);
    beqf.a().a(22, new Object[0]);
  }
  
  public void setPackageDownloadFlag(boolean paramBoolean)
  {
    this.mPkgDownloadFlag = paramBoolean;
    if (this.mRuntime != null) {
      ((beuy)this.mRuntime).b(paramBoolean);
    }
  }
  
  public void showLoading(MiniAppInfo paramMiniAppInfo)
  {
    if (this.mLoadingUI == null) {
      return;
    }
    this.mLoadingUI.a(paramMiniAppInfo).a(this.mRootLayout);
  }
  
  public void showUpdateMobileQQDialog()
  {
    Object localObject1 = "";
    try
    {
      Object localObject3 = bexm.b();
      String str = "";
      localObject1 = localObject3;
      if (getMiniAppInfo() != null)
      {
        localObject1 = localObject3;
        str = getMiniAppInfo().appId;
      }
      Object localObject2 = localObject3;
      localObject1 = localObject3;
      if (((String)localObject3).contains("{appid}"))
      {
        localObject2 = localObject3;
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = localObject3;
          localObject2 = ((String)localObject3).replace("{appid}", str);
        }
      }
      localObject1 = localObject2;
      betc.b("UIProxy", "showUpdateMobileQQDialog jump to upgrate page:" + (String)localObject2);
      localObject1 = localObject2;
      localObject3 = new Intent();
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("hide_more_button", true);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("hide_operation_bar", true);
      localObject1 = localObject2;
      ((Intent)localObject3).putExtra("url", (String)localObject2);
      localObject1 = localObject2;
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(getActivity(), (Intent)localObject3);
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("minisdk-start", "jump to upgrate page exception! url=" + (String)localObject1, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameUIProxy
 * JD-Core Version:    0.7.0.1
 */