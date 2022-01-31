package com.tencent.qqmini.sdk.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import bghl;
import bghn;
import bgld;
import bgnf;
import bgqg;
import bgqj;
import bgtj;
import bgud;
import bgut;
import bgvn;
import bgvo;
import bgvy;
import bgvz;
import bgxl;
import bgyd;
import bgyg;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

public class GameUIProxy
  extends bgqj
{
  private long mBeginOnCreate;
  private bgvz mBroadcastWatcher;
  private bgvn mGameRuntimeStateObserver;
  private boolean mHasReportStepOnResume;
  private LoadingUI mLoadingUI;
  private boolean mPkgDownloadFlag;
  private int mStartMode = 3;
  
  private void createGameActivityStatusWatcher(Activity paramActivity)
  {
    this.mBroadcastWatcher = new bgvz(paramActivity);
    this.mBroadcastWatcher.a(new bgvo(this));
    this.mBroadcastWatcher.a();
  }
  
  private void createGameRuntimeStateObserver()
  {
    this.mGameRuntimeStateObserver = new bgvn(this);
    this.mGameRuntimeStateObserver.a();
    AppRuntimeLoaderManager.g().addAppEventObserver(this.mGameRuntimeStateObserver);
  }
  
  private void destroyGameActivityStatusWatcher()
  {
    try
    {
      this.mBroadcastWatcher.b();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void destroyGameRuntimeStateObserver()
  {
    AppRuntimeLoaderManager.g().deleteAppEventObserver(this.mGameRuntimeStateObserver);
  }
  
  private static boolean isValidABI(MiniAppInfo paramMiniAppInfo)
  {
    if (bgvy.b)
    {
      if (paramMiniAppInfo != null)
      {
        bgyg.a(paramMiniAppInfo, "1", null, "load_fail", "system_version_limit_fail");
        bgxl.a("2launch_fail", "system_version_limit_fail", null, paramMiniAppInfo);
      }
      return false;
    }
    return true;
  }
  
  private void resetQuery()
  {
    if (this.mRuntime != null)
    {
      bgut localbgut = ((bgtj)this.mRuntime).a();
      if (localbgut != null) {
        localbgut.a();
      }
    }
  }
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public bgtj getGameRuntime()
  {
    if (this.mRuntime != null) {
      return (bgtj)getRuntime();
    }
    return null;
  }
  
  public bghn getJsService()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.a();
    }
    return null;
  }
  
  public String getLaunchMsg()
  {
    if (this.mPkgDownloadFlag) {
      return "firstLaunch" + this.mStartMode;
    }
    return "twiceLaunch" + this.mStartMode;
  }
  
  public LoadingUI getLoadingUI()
  {
    return this.mLoadingUI;
  }
  
  public int getStatMode()
  {
    return this.mStartMode;
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
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(2053, new Object[0]);
    return super.onBackPressed(paramActivity);
  }
  
  public void onCreate(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mBeginOnCreate = System.currentTimeMillis();
    Intent localIntent;
    long l;
    label32:
    MiniAppInfo localMiniAppInfo;
    if (paramActivity != null)
    {
      localIntent = paramActivity.getIntent();
      if (localIntent == null) {
        break label172;
      }
      l = localIntent.getLongExtra("startDuration", 0L);
      if (localIntent == null) {
        break label178;
      }
      localMiniAppInfo = (MiniAppInfo)localIntent.getParcelableExtra("KEY_APPINFO");
      label49:
      this.mStartMode = localIntent.getIntExtra("start_mode", 3);
      l = this.mBeginOnCreate - l;
      if (localMiniAppInfo != null)
      {
        bgyd.a(localMiniAppInfo, 1030, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
        QMLog.e("[minigame][timecost] ", "step[startActivity] cost time: " + l + " startMode: " + this.mStartMode);
      }
      if (isValidABI(localMiniAppInfo)) {
        break label184;
      }
      bgnf.a(this.mActivity, "小游戏不支持该设备", 1).a();
      this.mActivity.finish();
    }
    label172:
    label178:
    label184:
    do
    {
      return;
      localIntent = null;
      break;
      l = 0L;
      break label32;
      localMiniAppInfo = null;
      break label49;
      createGameRuntimeStateObserver();
      createGameActivityStatusWatcher(paramActivity);
      this.mLoadingUI = new LoadingUI(paramActivity);
      super.onCreate(paramActivity, paramBundle, paramViewGroup);
      l = System.currentTimeMillis() - this.mBeginOnCreate;
    } while (localMiniAppInfo == null);
    bgyd.a(localMiniAppInfo, 1031, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
    QMLog.e("[minigame][timecost] ", "step[doOnCreate] cost time: " + l);
  }
  
  public void onDestroy(Activity paramActivity)
  {
    QMLog.i("UIProxy", "onDestroy");
    if (this.mActivity == paramActivity)
    {
      this.mActivity = null;
      this.mRootLayout = null;
      if (this.mRuntime != null)
      {
        this.mRuntime.e();
        this.mRuntime.a(paramActivity);
      }
      AppRuntimeLoaderManager.g().removeRuntimeLoader(this.mActivatedRuntimeLoader);
    }
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(62, new Object[0]);
    destroyGameActivityStatusWatcher();
    destroyGameRuntimeStateObserver();
  }
  
  public void onPause(Activity paramActivity)
  {
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(2052, new Object[0]);
    resetQuery();
    super.onPause(paramActivity);
  }
  
  public void onResume(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    if ((this.mActivatedRuntimeLoader != null) && (this.mActivatedRuntimeLoader.isLoadSucceed()))
    {
      QMLog.d("UIProxy", "onResume(). runtime is loaded. warm boot. " + this.mMiniAppInfo);
      this.mActivatedRuntimeLoader.notifyRuntimeEvent(2051, new Object[0]);
    }
    for (;;)
    {
      super.onResume(paramActivity);
      l = System.currentTimeMillis() - l;
      if (!this.mHasReportStepOnResume)
      {
        this.mHasReportStepOnResume = true;
        bgyd.a(this.mMiniAppInfo, 1035, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
        QMLog.e("[minigame][timecost] ", "step[onResume] cost time: " + l);
      }
      return;
      QMLog.d("UIProxy", "onResume(). runtime is loading. cold boot. " + this.mMiniAppInfo);
      if (this.mActivatedRuntimeLoader != null)
      {
        QMLog.d("UIProxy", "onResume(). Start " + this.mActivatedRuntimeLoader);
        this.mActivatedRuntimeLoader.start();
      }
    }
  }
  
  public void onRuntimeReady()
  {
    QMLog.i("UIProxy", "GameRuntime onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mActivatedRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mActivatedRuntimeLoader.getRuntime();
    if (this.mRuntime != null)
    {
      bgtj localbgtj = (bgtj)this.mRuntime;
      localbgtj.a(this.mPkgDownloadFlag);
      localbgtj.a(this.mStartMode);
    }
    if (((this.mActivatedRuntimeLoader instanceof GameRuntimeLoader)) && (!((GameRuntimeLoader)this.mActivatedRuntimeLoader).isGameReadyStart(this.mMiniAppInfo)))
    {
      bgyg.a(this.mMiniAppInfo, "1", null, "load_fail", "not_ready");
      bgxl.a("2launch_fail", "not_ready", null, this.mMiniAppInfo);
      return;
    }
    if (bgld.a(getActivity()) == 0)
    {
      if ((this.mMiniAppInfo != null) && (!this.mMiniAppInfo.isSupportOffline))
      {
        bgyg.a(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_support");
        bgxl.a("2launch_fail", "offline_not_support", null, this.mMiniAppInfo);
        bgnf.a(getActivity(), "此游戏暂不支持离线模式", 0).a();
        return;
      }
      if ((this.mMiniAppInfo != null) && (!bgud.a(this.mMiniAppInfo)))
      {
        bgyg.a(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_ready");
        bgxl.a("2launch_fail", "offline_not_ready", null, this.mMiniAppInfo);
        bgnf.a(getActivity(), "游戏资源未加载完成，请联网后重试", 0).a();
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
    AppLoaderFactory.g().getAppBrandProxy().onAppBackground(getMiniAppInfo(), null);
    AppRuntimeLoaderManager.g().notifyRuntimeEvent(22, new Object[0]);
  }
  
  public void setPackageDownloadFlag(boolean paramBoolean)
  {
    this.mPkgDownloadFlag = paramBoolean;
    if (this.mRuntime != null) {
      ((bgtj)this.mRuntime).a(paramBoolean);
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
      Object localObject3 = GameWnsUtils.getQQUpdateUrl();
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
      QMLog.i("UIProxy", "showUpdateMobileQQDialog jump to upgrate page:" + (String)localObject2);
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
      QMLog.e("minisdk-start", "jump to upgrate page exception! url=" + (String)localObject1, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameUIProxy
 * JD-Core Version:    0.7.0.1
 */