package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.OnGetTraceRecordCallback;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.utils.CPUUtil;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.BaseUIProxy;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import java.util.List;

@MiniKeep
public class GameUIProxy
  extends BaseUIProxy
{
  private long mActivityStartDuration = 0L;
  private long mBeginOnCreate;
  private GameActivityStatusWatcher mBroadcastWatcher;
  private GameRuntimeStateObserver mGameRuntimeStateObserver;
  private boolean mHasReportStepOnResume = false;
  private LoadingUI mLoadingUI;
  private MiniAppInfo mMiniAppInfo;
  private boolean mPkgDownloadFlag = false;
  private BaseRuntime mRuntime;
  private int mStartMode = 3;
  
  private void createGameActivityStatusWatcher(Activity paramActivity)
  {
    this.mBroadcastWatcher = new GameActivityStatusWatcher(paramActivity);
    this.mBroadcastWatcher.setOnHomePressedListener(new GameUIProxy.1(this));
    this.mBroadcastWatcher.startWatch();
  }
  
  private void createGameRuntimeStateObserver()
  {
    this.mGameRuntimeStateObserver = new GameRuntimeStateObserver(this);
    this.mGameRuntimeStateObserver.setOnCreateTimeStamp();
  }
  
  private void createLoadingUI(Activity paramActivity)
  {
    this.mLoadingUI = new LoadingUI(paramActivity);
  }
  
  private void destroyGameActivityStatusWatcher()
  {
    try
    {
      this.mBroadcastWatcher.stopWatch();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void initOrientation(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.isLandScape())) {}
    for (boolean bool = true;; bool = false)
    {
      setOrientation(bool);
      return;
    }
  }
  
  private void initStatusBar(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.isShowStatusBar())) {
      showStatusBar();
    }
  }
  
  private static boolean isValidABI(MiniAppInfo paramMiniAppInfo)
  {
    if (CPUUtil.sIsX86Emulator)
    {
      if (paramMiniAppInfo != null)
      {
        SDKMiniProgramLpReportDC04239.reportPageView(paramMiniAppInfo, "1", null, "load_fail", "system_version_limit_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "system_version_limit_fail", null, paramMiniAppInfo);
      }
      return false;
    }
    return true;
  }
  
  private void logOnAttachActivity(Activity paramActivity, MiniAppInfo paramMiniAppInfo, long paramLong)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 22)
    {
      paramActivity = paramActivity.getReferrer();
      localObject1 = localObject2;
      if (paramActivity != null) {
        localObject1 = paramActivity.toString();
      }
    }
    QMLog.e("[minigame][timecost] ", "step[startActivity] cost time: " + paramLong + " startMode: " + this.mStartMode + " miniAppInfo: " + paramMiniAppInfo + " referrer: " + (String)localObject1);
  }
  
  private void resetQuery()
  {
    if (this.mCurrRuntimeLoader != null)
    {
      Object localObject = this.mCurrRuntimeLoader.getRuntime();
      if ((localObject instanceof GameRuntime))
      {
        localObject = ((GameRuntime)localObject).getGameInfoManager();
        if (localObject != null) {
          ((GameInfoManager)localObject).resetQuery();
        }
      }
    }
  }
  
  private void setOrientation(boolean paramBoolean)
  {
    Activity localActivity = this.mActivity;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localActivity.setRequestedOrientation(i);
      return;
    }
  }
  
  private void showStatusBar()
  {
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.flags &= 0xFFFFFBFF;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
    this.mActivity.getWindow().clearFlags(512);
  }
  
  public boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  Activity getActivity()
  {
    return this.mActivity;
  }
  
  GameRuntime getGameRuntime()
  {
    if (this.mRuntime != null) {
      return (GameRuntime)getRuntime();
    }
    return null;
  }
  
  IJsService getJsService()
  {
    if (this.mRuntime != null) {
      return this.mRuntime.getJsService();
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
  
  LoadingUI getLoadingUI()
  {
    return this.mLoadingUI;
  }
  
  public AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver()
  {
    return this.mGameRuntimeStateObserver;
  }
  
  public int getStatMode()
  {
    return this.mStartMode;
  }
  
  public List<TaskExecutionStatics> getTaskStatics()
  {
    Object localObject = (GameRuntimeLoader)this.mCurrRuntimeLoader;
    if (localObject == null) {}
    for (localObject = new ArrayList();; localObject = ((GameRuntimeLoader)localObject).getTaskExecuteStatics())
    {
      ((List)localObject).add(0, new TaskExecutionStatics("StartActivity", this.mActivityStartDuration));
      return localObject;
    }
  }
  
  public void getTraceStatistics(ITTEngine.OnGetTraceRecordCallback paramOnGetTraceRecordCallback)
  {
    if (this.mRuntime != null)
    {
      ITTEngine localITTEngine = ((GameRuntime)this.mRuntime).getGameEngine();
      if (localITTEngine != null) {
        localITTEngine.getTraceRecord(paramOnGetTraceRecordCallback);
      }
    }
  }
  
  public void hideLoading()
  {
    this.hasCompletedLoading = true;
    if (this.mLoadingUI == null) {
      return;
    }
    this.mLoadingUI.hide();
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    long l2 = 0L;
    this.mBeginOnCreate = System.currentTimeMillis();
    Intent localIntent;
    long l1;
    label36:
    MiniAppInfo localMiniAppInfo;
    if (paramActivity != null)
    {
      localIntent = paramActivity.getIntent();
      if (localIntent == null) {
        break label164;
      }
      l1 = localIntent.getLongExtra("startDuration", 0L);
      if (localIntent == null) {
        break label170;
      }
      localMiniAppInfo = (MiniAppInfo)localIntent.getParcelableExtra("KEY_APPINFO");
      label54:
      this.mStartMode = localIntent.getIntExtra("start_mode", 3);
      if (paramBundle != null) {
        l1 = 0L;
      }
      if (l1 != 0L) {
        l2 = this.mBeginOnCreate - l1;
      }
      this.mActivityStartDuration = l2;
      if (localMiniAppInfo != null)
      {
        MiniReportManager.reportEventType(localMiniAppInfo, 1030, null, String.valueOf(this.mStartMode), null, 0, "1", l2, null);
        logOnAttachActivity(paramActivity, localMiniAppInfo, l2);
      }
      if (isValidABI(localMiniAppInfo)) {
        break label176;
      }
      MiniToast.makeText(paramActivity, "小游戏不支持该设备", 1).show();
      paramActivity.finish();
    }
    label164:
    label170:
    label176:
    do
    {
      return;
      localIntent = null;
      break;
      l1 = 0L;
      break label36;
      localMiniAppInfo = null;
      break label54;
      createGameRuntimeStateObserver();
      createGameActivityStatusWatcher(paramActivity);
      createLoadingUI(paramActivity);
      super.onAttachActivity(paramActivity, paramBundle, paramViewGroup);
      initOrientation(localMiniAppInfo);
      initStatusBar(localMiniAppInfo);
      l1 = System.currentTimeMillis() - this.mBeginOnCreate;
    } while (localMiniAppInfo == null);
    MiniReportManager.reportEventType(localMiniAppInfo, 1031, null, String.valueOf(this.mStartMode), null, 0, "1", l1, null);
    QMLog.e("[minigame][timecost] ", "step[doOnCreate] cost time: " + l1);
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    AppStateEvent.obtain(2053).notifyRuntime(getRuntime());
    return super.onBackPressed(paramActivity);
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    QMLog.i("minisdk-start_UIProxy", "onDetachActivity");
    AppStateEvent.obtain(62).notifyRuntime(getRuntime());
    destroyGameActivityStatusWatcher();
    super.onDetachActivity(paramActivity);
  }
  
  public void onMiniPause()
  {
    AppStateEvent.obtain(2052).notifyRuntime(getRuntime());
    resetQuery();
    super.onMiniPause();
  }
  
  public void onMiniResume()
  {
    if (this.mCurrRuntimeLoader == null)
    {
      QMLog.e("minisdk-start_UIProxy", this + " GameUIProxy.onMiniResume() current runtime loader is null!");
      return;
    }
    long l = System.currentTimeMillis();
    if (this.mCurrRuntimeLoader.isLoadSucceed())
    {
      QMLog.d("minisdk-start_UIProxy", "onResume(). runtime is loaded. warm boot. " + this.mCurrRuntimeLoader.getMiniAppInfo());
      this.mCurrRuntimeLoader.notifyRuntimeEvent(2051, new Object[0]);
    }
    for (;;)
    {
      super.onMiniResume();
      l = System.currentTimeMillis() - l;
      if (this.mHasReportStepOnResume) {
        break;
      }
      this.mHasReportStepOnResume = true;
      MiniReportManager.reportEventType(this.mCurrRuntimeLoader.getMiniAppInfo(), 1035, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
      QMLog.e("[minigame][timecost] ", "step[onResume] cost time: " + l);
      return;
      QMLog.d("minisdk-start_UIProxy", "onResume(). runtime is loading. start cold boot. " + this.mCurrRuntimeLoader.getMiniAppInfo());
      this.mCurrRuntimeLoader.start();
    }
  }
  
  public void onMiniStart()
  {
    super.onMiniStart();
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy != null) {
      localAdProxy.onActivityStart();
    }
  }
  
  public void onMiniStop()
  {
    if (getRuntime() != null) {
      getRuntime().onRuntimeStop();
    }
    AppLoaderFactory.g().getAppBrandProxy().onAppBackground(getMiniAppInfo(), null);
    AppStateEvent.obtain(22).notifyRuntime(getRuntime());
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if (localAdProxy != null) {
      localAdProxy.onActivityStop();
    }
  }
  
  public void onRuntimeReady()
  {
    QMLog.i("minisdk-start_UIProxy", "GameRuntime onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mCurrRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mCurrRuntimeLoader.getRuntime();
    Object localObject;
    if (this.mRuntime != null)
    {
      localObject = (GameRuntime)this.mRuntime;
      ((GameRuntime)localObject).setPackageDownloadFlag(this.mPkgDownloadFlag);
      ((GameRuntime)localObject).setStartMode(this.mStartMode);
    }
    if (((this.mCurrRuntimeLoader instanceof GameRuntimeLoader)) && (!((GameRuntimeLoader)this.mCurrRuntimeLoader).isGameReadyStart(this.mMiniAppInfo)))
    {
      SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "not_ready");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_ready", null, this.mMiniAppInfo);
    }
    MiniAppInfo localMiniAppInfo;
    do
    {
      return;
      if (NetworkUtil.getActiveNetworkType(getActivity()) == 0)
      {
        if ((this.mMiniAppInfo != null) && (!this.mMiniAppInfo.isSupportOffline))
        {
          SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_support");
          MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_support", null, this.mMiniAppInfo);
          MiniToast.makeText(getActivity(), "此游戏暂不支持离线模式", 0).show();
          return;
        }
        if ((this.mMiniAppInfo != null) && (!GpkgManager.isOfflineResourceReady(this.mMiniAppInfo)))
        {
          SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_ready");
          MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_ready", null, this.mMiniAppInfo);
          MiniToast.makeText(getActivity(), "游戏资源未加载完成，请联网后重试", 0).show();
          return;
        }
      }
      this.mMainHandler.post(new GameUIProxy.2(this));
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      localMiniAppInfo = getMiniAppInfo();
    } while ((localObject == null) || (localMiniAppInfo == null));
    ((ChannelProxy)localObject).syncForceGroundAndRefreshBadge(this.mActivity, localMiniAppInfo.appId, AppLoaderFactory.g().getProcessName());
  }
  
  public void preloadLoadingAd()
  {
    this.hasCompletedLoading = true;
    this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mActivity, this.mMiniAppInfo);
  }
  
  public void reloadMiniAppInfoIfNeed(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBaseRuntimeLoader.isLoadSucceed())
    {
      if (!paramMiniAppInfo.isShortcutFakeApp()) {
        paramBaseRuntimeLoader.updateMiniAppInfo(paramMiniAppInfo);
      }
      paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
      hideLoading();
    }
    do
    {
      return;
      showLoading(paramMiniAppInfo);
      paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
    } while (paramBaseRuntimeLoader.isRunning());
    paramBaseRuntimeLoader.start();
  }
  
  void setPackageDownloadFlag(boolean paramBoolean)
  {
    this.mPkgDownloadFlag = paramBoolean;
    if (this.mRuntime != null) {
      ((GameRuntime)this.mRuntime).setPackageDownloadFlag(paramBoolean);
    }
  }
  
  public void showLoading(MiniAppInfo paramMiniAppInfo)
  {
    this.hasCompletedLoading = false;
    if (this.mLoadingUI == null) {
      return;
    }
    this.mLoadingUI.initUIData(paramMiniAppInfo).show(this.mRootLayout);
    if (this.mRuntime != null) {
      ((GameRuntime)this.mRuntime).setLoadingAdStatus(1);
    }
    processSelectLoadingAdLogic(this.mActivity, paramMiniAppInfo);
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
      QMLog.i("minisdk-start_UIProxy", "showUpdateMobileQQDialog jump to upgrate page:" + (String)localObject2);
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
  
  public void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong)
  {
    paramActivity.runOnUiThread(new GameUIProxy.3(this, paramMiniAppInfo, paramActivity, paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy
 * JD-Core Version:    0.7.0.1
 */