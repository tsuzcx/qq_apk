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
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.statistic.GetTraceInfoCallback;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.utils.CPUUtil;
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
  private final GameRuntimeStateObserver mGameRuntimeStateObserver = new GameRuntimeStateObserver(this);
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
    boolean bool;
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.isLandScape())) {
      bool = true;
    } else {
      bool = false;
    }
    setOrientation(bool);
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
    if (Build.VERSION.SDK_INT >= 22)
    {
      paramActivity = paramActivity.getReferrer();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.toString();
        break label27;
      }
    }
    paramActivity = null;
    label27:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step[startActivity] cost time: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" startMode: ");
    localStringBuilder.append(this.mStartMode);
    localStringBuilder.append(" miniAppInfo: ");
    localStringBuilder.append(paramMiniAppInfo);
    localStringBuilder.append(" referrer: ");
    localStringBuilder.append(paramActivity);
    QMLog.e("[minigame][timecost] ", localStringBuilder.toString());
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
    this.mActivity.setRequestedOrientation(paramBoolean ^ true);
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
  
  public String getLaunchMsg()
  {
    if (this.mPkgDownloadFlag)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("firstLaunch");
      localStringBuilder.append(this.mStartMode);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("twiceLaunch");
    localStringBuilder.append(this.mStartMode);
    return localStringBuilder.toString();
  }
  
  LoadingUI getLoadingUI()
  {
    return this.mLoadingUI;
  }
  
  protected AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver()
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
    if (localObject == null) {
      localObject = new ArrayList();
    } else {
      localObject = ((GameRuntimeLoader)localObject).getTaskExecuteStatics();
    }
    ((List)localObject).add(0, new TaskExecutionStatics("StartActivity", this.mActivityStartDuration));
    return localObject;
  }
  
  public void getTraceStatistics(GetTraceInfoCallback paramGetTraceInfoCallback)
  {
    Object localObject = this.mRuntime;
    if (localObject != null)
    {
      localObject = ((GameRuntime)localObject).getGameEngine();
      if (localObject != null) {
        ((TritonEngine)localObject).getStatisticsManager().getTraceInfo(paramGetTraceInfoCallback);
      }
    }
  }
  
  protected void hideLoading()
  {
    this.hasCompletedLoading = true;
    LoadingUI localLoadingUI = this.mLoadingUI;
    if (localLoadingUI == null) {
      return;
    }
    localLoadingUI.hide();
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mBeginOnCreate = System.currentTimeMillis();
    MiniAppInfo localMiniAppInfo = null;
    Intent localIntent;
    if (paramActivity != null) {
      localIntent = paramActivity.getIntent();
    } else {
      localIntent = null;
    }
    if (localIntent != null) {
      l = localIntent.getLongExtra("startDuration", 0L);
    } else {
      l = 0L;
    }
    if (localIntent != null) {
      localMiniAppInfo = (MiniAppInfo)localIntent.getParcelableExtra("KEY_APPINFO");
    }
    this.mStartMode = localIntent.getIntExtra("start_mode", 3);
    if (paramBundle != null) {
      l = 0L;
    }
    if (l != 0L) {
      l = this.mBeginOnCreate - l;
    } else {
      l = 0L;
    }
    this.mActivityStartDuration = l;
    if (localMiniAppInfo != null)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1030, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
      logOnAttachActivity(paramActivity, localMiniAppInfo, l);
    }
    if (!isValidABI(localMiniAppInfo))
    {
      MiniToast.makeText(paramActivity, "小游戏不支持该设备", 1).show();
      paramActivity.finish();
      return;
    }
    this.mGameRuntimeStateObserver.setOnCreateTimeStamp();
    createGameActivityStatusWatcher(paramActivity);
    createLoadingUI(paramActivity);
    super.onAttachActivity(paramActivity, paramBundle, paramViewGroup);
    initOrientation(localMiniAppInfo);
    initStatusBar(localMiniAppInfo);
    long l = System.currentTimeMillis() - this.mBeginOnCreate;
    if (localMiniAppInfo != null)
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1031, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
      paramActivity = new StringBuilder();
      paramActivity.append("step[doOnCreate] cost time: ");
      paramActivity.append(l);
      QMLog.e("[minigame][timecost] ", paramActivity.toString());
    }
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
    StringBuilder localStringBuilder;
    if (this.mCurrRuntimeLoader == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this);
      localStringBuilder.append(" GameUIProxy.onMiniResume() current runtime loader is null!");
      QMLog.e("minisdk-start_UIProxy", localStringBuilder.toString());
      return;
    }
    long l = System.currentTimeMillis();
    if (this.mCurrRuntimeLoader.isLoadSucceed())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume(). runtime is loaded. warm boot. ");
      localStringBuilder.append(this.mCurrRuntimeLoader.getMiniAppInfo());
      QMLog.d("minisdk-start_UIProxy", localStringBuilder.toString());
      this.mCurrRuntimeLoader.notifyRuntimeEvent(2051, new Object[0]);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume(). runtime is loading. start cold boot. ");
      localStringBuilder.append(this.mCurrRuntimeLoader.getMiniAppInfo());
      QMLog.d("minisdk-start_UIProxy", localStringBuilder.toString());
      this.mCurrRuntimeLoader.start();
    }
    super.onMiniResume();
    l = System.currentTimeMillis() - l;
    if (!this.mHasReportStepOnResume)
    {
      this.mHasReportStepOnResume = true;
      MiniReportManager.reportEventType(this.mCurrRuntimeLoader.getMiniAppInfo(), 1035, null, String.valueOf(this.mStartMode), null, 0, "1", l, null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("step[onResume] cost time: ");
      localStringBuilder.append(l);
      QMLog.e("[minigame][timecost] ", localStringBuilder.toString());
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
  
  protected void onRuntimeReady()
  {
    QMLog.i("minisdk-start_UIProxy", "GameRuntime onRuntimeReady. Here we go, start the runtime lifecycle");
    this.mMiniAppInfo = this.mCurrRuntimeLoader.getMiniAppInfo();
    this.mRuntime = this.mCurrRuntimeLoader.getRuntime();
    Object localObject = this.mRuntime;
    if (localObject != null)
    {
      localObject = (GameRuntime)localObject;
      ((GameRuntime)localObject).setPackageDownloadFlag(this.mPkgDownloadFlag);
      ((GameRuntime)localObject).setStartMode(this.mStartMode);
    }
    if (((this.mCurrRuntimeLoader instanceof GameRuntimeLoader)) && (!((GameRuntimeLoader)this.mCurrRuntimeLoader).isGameReadyStart(this.mMiniAppInfo)))
    {
      SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "not_ready");
      MiniAppReportManager2.reportPageView("2launch_fail", "not_ready", null, this.mMiniAppInfo);
      return;
    }
    if (NetworkUtil.getActiveNetworkType(getActivity()) == 0)
    {
      localObject = this.mMiniAppInfo;
      if ((localObject != null) && (!((MiniAppInfo)localObject).isSupportOffline))
      {
        SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_support");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_support", null, this.mMiniAppInfo);
        MiniToast.makeText(getActivity(), "此游戏暂不支持离线模式", 0).show();
        return;
      }
      localObject = this.mMiniAppInfo;
      if ((localObject != null) && (!GpkgManager.isOfflineResourceReady((MiniAppInfo)localObject)))
      {
        SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_ready");
        MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_ready", null, this.mMiniAppInfo);
        MiniToast.makeText(getActivity(), "游戏资源未加载完成，请联网后重试", 0).show();
        return;
      }
    }
    this.mMainHandler.post(new GameUIProxy.2(this));
    localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localObject != null) && (localMiniAppInfo != null)) {
      ((ChannelProxy)localObject).syncForceGroundAndRefreshBadge(this.mActivity, localMiniAppInfo.appId, AppLoaderFactory.g().getProcessName());
    }
  }
  
  public void preloadLoadingAd()
  {
    this.hasCompletedLoading = true;
    this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
    MiniLoadingAdManager.getInstance().preloadLoadingAd(this.mActivity, this.mMiniAppInfo);
  }
  
  protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBaseRuntimeLoader.isLoadSucceed())
    {
      if (!paramMiniAppInfo.isShortcutFakeApp()) {
        paramBaseRuntimeLoader.updateMiniAppInfo(paramMiniAppInfo);
      }
      paramBaseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
      hideLoading();
      return;
    }
    showLoading(paramMiniAppInfo);
    paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
    if (!paramBaseRuntimeLoader.isRunning()) {
      paramBaseRuntimeLoader.start();
    }
  }
  
  void setPackageDownloadFlag(boolean paramBoolean)
  {
    this.mPkgDownloadFlag = paramBoolean;
    BaseRuntime localBaseRuntime = this.mRuntime;
    if (localBaseRuntime != null) {
      ((GameRuntime)localBaseRuntime).setPackageDownloadFlag(paramBoolean);
    }
  }
  
  protected void showLoading(MiniAppInfo paramMiniAppInfo)
  {
    this.hasCompletedLoading = false;
    Object localObject = this.mLoadingUI;
    if (localObject == null) {
      return;
    }
    ((LoadingUI)localObject).initUIData(paramMiniAppInfo).show(this.mRootLayout);
    localObject = this.mRuntime;
    if (localObject != null) {
      ((GameRuntime)localObject).setLoadingAdStatus(1);
    }
    processSelectLoadingAdLogic(this.mActivity, paramMiniAppInfo);
  }
  
  public void showUpdateMobileQQDialog()
  {
    Object localObject3 = "";
    Object localObject1 = localObject3;
    Object localObject2;
    Throwable localThrowable2;
    try
    {
      localObject2 = GameWnsUtils.getQQUpdateUrl();
      try
      {
        if (getMiniAppInfo() != null) {
          localObject3 = getMiniAppInfo().appId;
        }
        if ((((String)localObject2).contains("{appid}")) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject1 = ((String)localObject2).replace("{appid}", (CharSequence)localObject3);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append("showUpdateMobileQQDialog jump to upgrate page:");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = localObject2;
        QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject3).toString());
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
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable3)
    {
      localObject2 = localThrowable1;
      localThrowable2 = localThrowable3;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("jump to upgrate page exception! url=");
    localStringBuilder.append((String)localObject2);
    QMLog.e("minisdk-start", localStringBuilder.toString(), localThrowable2);
  }
  
  protected void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2)
  {
    paramActivity.runOnUiThread(new GameUIProxy.3(this, paramMiniAppInfo, paramActivity, paramString, paramLong1, paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameUIProxy
 * JD-Core Version:    0.7.0.1
 */