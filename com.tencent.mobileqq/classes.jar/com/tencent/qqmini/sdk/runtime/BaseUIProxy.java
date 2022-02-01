package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;

public abstract class BaseUIProxy
  implements IUIProxy
{
  protected static final String TAG = "minisdk-start_UIProxy";
  protected boolean hasCompletedLoading = false;
  protected long loadCompleteTimeForLoadingAdReport;
  protected Activity mActivity;
  private final Binder mClientBinder = new Binder();
  protected BaseRuntimeLoader mCurrRuntimeLoader;
  private boolean mIsDestroyed;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper());
  protected PageGestureProxy mPageGestureProxy;
  protected ViewGroup mRootLayout;
  protected long showTimeStamp = 0L;
  
  private void destroyLastRuntimeLoader(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if (paramBaseRuntimeLoader.isRunning())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pause last runtime loader:");
      localStringBuilder.append(paramBaseRuntimeLoader);
      QMLog.i("minisdk-start_UIProxy", localStringBuilder.toString());
      paramBaseRuntimeLoader.pause();
    }
    paramBaseRuntimeLoader.onDetachActivity(this.mActivity, false);
    paramBaseRuntimeLoader.removeRuntimeStateObserver(getRuntimeStateObserver());
  }
  
  protected BaseRuntimeLoader.OnAppRuntimeLoadListener createRuntimeLoaderListener()
  {
    return new BaseUIProxy.2(this);
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    BaseRuntimeLoader localBaseRuntimeLoader = this.mCurrRuntimeLoader;
    if (localBaseRuntimeLoader != null) {
      return localBaseRuntimeLoader.getMiniAppInfo();
    }
    return null;
  }
  
  public BaseRuntime getRuntime()
  {
    BaseRuntimeLoader localBaseRuntimeLoader = this.mCurrRuntimeLoader;
    if (localBaseRuntimeLoader != null) {
      return localBaseRuntimeLoader.getRuntime();
    }
    return null;
  }
  
  protected abstract AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver();
  
  protected abstract void hideLoading();
  
  protected abstract boolean isAbleToShowAd();
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramActivity = new StringBuilder();
    paramActivity.append("onActivityResult requestCode=");
    paramActivity.append(paramInt1);
    paramActivity.append(" resultCode=");
    paramActivity.append(paramInt2);
    QMLog.i("minisdk-start_UIProxy", paramActivity.toString());
    ActivityResultManager.g().notifyActivityResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    paramBundle = new StringBuilder();
    paramBundle.append(this);
    paramBundle.append(" [MiniLifecycle] ");
    paramBundle.append("onAttachActivity");
    QMLog.i("minisdk-start_UIProxy", paramBundle.toString());
    paramBundle = paramActivity.getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle = this.mActivity;
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    MiniGdtReporter.prepareReport();
    this.mPageGestureProxy = ((PageGestureProxy)ProxyManager.get(PageGestureProxy.class));
    paramBundle = this.mPageGestureProxy;
    if (paramBundle != null) {
      paramBundle.onActivityCreate(paramActivity);
    }
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    paramActivity = new StringBuilder();
    paramActivity.append(this);
    paramActivity.append(" [MiniLifecycle] ");
    paramActivity.append("onBackPressed");
    QMLog.i("minisdk-start_UIProxy", paramActivity.toString());
    paramActivity = this.mCurrRuntimeLoader;
    boolean bool;
    if (paramActivity != null) {
      bool = paramActivity.getRuntime().onBackPress();
    } else {
      bool = false;
    }
    AppStateEvent.obtain(25).notifyRuntime(getRuntime());
    return bool;
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" [MiniLifecycle] ");
    ((StringBuilder)localObject).append("onDetachActivity");
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
    if (this.mActivity != paramActivity)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDetachActivity. activity is mismatch. mActivity=");
      ((StringBuilder)localObject).append(this.mActivity);
      ((StringBuilder)localObject).append(" activity=");
      ((StringBuilder)localObject).append(paramActivity);
      QMLog.e("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
      return;
    }
    localObject = this.mCurrRuntimeLoader;
    if (localObject != null)
    {
      ((BaseRuntimeLoader)localObject).onDetachActivity(paramActivity);
      if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
        AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      }
    }
    this.mCurrRuntimeLoader = null;
    localObject = this.mPageGestureProxy;
    if (localObject != null) {
      ((PageGestureProxy)localObject).onActivityDestroy(paramActivity);
    }
    this.mActivity = null;
    this.mRootLayout = null;
    this.mIsDestroyed = true;
  }
  
  public void onIntentUpdate(Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" [MiniLifecycle] ");
    ((StringBuilder)localObject).append("onIntentUpdate ");
    ((StringBuilder)localObject).append(paramIntent);
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
    localObject = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    if (localObject == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onIntentUpdate MiniAppInfo is Null!");
      return;
    }
    if (((MiniAppInfo)localObject).canDebug()) {
      ((MiniAppInfo)localObject).launchParam.forceReload = 3;
    }
    AppLoaderFactory.g().getAppBrandProxy().onAppStart((MiniAppInfo)localObject, null);
    if (!((MiniAppInfo)localObject).launchParam.skipHotReload) {
      startMiniAppInfo((MiniAppInfo)localObject, paramIntent.getExtras());
    }
    paramIntent = new StringBuilder();
    paramIntent.append("launch param skipHotReload: ");
    paramIntent.append(((MiniAppInfo)localObject).launchParam.skipHotReload);
    QMLog.d("minisdk-start_UIProxy", paramIntent.toString());
    MiniGdtReporter.prepareReport();
  }
  
  public void onMiniPause()
  {
    if (this.mCurrRuntimeLoader == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onMiniPause current runtime loader is null!");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" [MiniLifecycle] ");
    ((StringBuilder)localObject).append("onMiniPause");
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
    this.mCurrRuntimeLoader.onMiniPause();
    if (this.mCurrRuntimeLoader.getMiniAppInfo() != null)
    {
      GameGrowthGuardianManager.executeEnd(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
      localObject = this.mPageGestureProxy;
      if (localObject != null) {
        ((PageGestureProxy)localObject).onActivityPause(this.mActivity);
      }
    }
  }
  
  public void onMiniResume()
  {
    if (this.mCurrRuntimeLoader == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onMiniResume current runtime loader is null!");
      return;
    }
    this.showTimeStamp = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" [MiniLifecycle] ");
    ((StringBuilder)localObject).append("onMiniResume");
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
    this.mCurrRuntimeLoader.onMiniResume();
    AppRuntimeLoaderManager.g().onEnterForeground(this.mCurrRuntimeLoader);
    if (this.mCurrRuntimeLoader.getMiniAppInfo() != null)
    {
      AppLoaderFactory.g().getAppBrandProxy().onAppForeground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      GameGrowthGuardianManager.executeBegin(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
      localObject = this.mPageGestureProxy;
      if (localObject != null)
      {
        ((PageGestureProxy)localObject).onActivityResume(this.mActivity);
        this.mPageGestureProxy.onCreateMiniAppInfo(this.mCurrRuntimeLoader.getMiniAppInfo());
      }
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null) {
        ((ChannelProxy)localObject).syncForceGroundAndRefreshBadge(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo().appId, AppLoaderFactory.g().getProcessName());
      }
    }
  }
  
  public void onMiniStart()
  {
    if (this.mCurrRuntimeLoader == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onMiniStart current runtime loader is null!");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" [MiniLifecycle] ");
    ((StringBuilder)localObject).append("onMiniStart");
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
    localObject = this.mCurrRuntimeLoader;
    if (localObject != null) {
      ((BaseRuntimeLoader)localObject).onMiniStart();
    }
  }
  
  public void onMiniStop()
  {
    if (this.mCurrRuntimeLoader == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onMiniStop current runtime loader is null!");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" [MiniLifecycle] ");
    ((StringBuilder)localObject).append("onMiniStop");
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject).toString());
    this.mCurrRuntimeLoader.onMiniStop();
    AppRuntimeLoaderManager.g().onEnterBackground();
    if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
      AppLoaderFactory.g().getAppBrandProxy().onAppBackground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
    }
    localObject = this.mPageGestureProxy;
    if (localObject != null)
    {
      Activity localActivity = this.mActivity;
      if (localActivity != null) {
        ((PageGestureProxy)localObject).onActivityStop(localActivity);
      }
    }
  }
  
  public void onRefreshMiniBadge(Activity paramActivity, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_UIProxy", "onRefreshMiniBadge");
    paramActivity = this.mCurrRuntimeLoader;
    Object localObject2 = null;
    if (paramActivity != null) {
      paramActivity = paramActivity.getRuntime();
    } else {
      paramActivity = null;
    }
    Object localObject1 = this.mCurrRuntimeLoader;
    if (localObject1 != null) {
      localObject1 = ((BaseRuntimeLoader)localObject1).getMiniAppInfo();
    } else {
      localObject1 = null;
    }
    if ((paramActivity != null) && (localObject1 != null))
    {
      if (paramBundle != null)
      {
        String str = paramBundle.getString("key_appid");
        if (QMLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onRefreshMiniBadge appID : ");
          localStringBuilder.append(str);
          QMLog.d("TAG", localStringBuilder.toString());
        }
        if (((MiniAppInfo)localObject1).appId.equals(str))
        {
          int i = paramBundle.getInt("KEY_BADGE_COUNT");
          if (QMLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("onRefreshMiniBadge badge : ");
            paramBundle.append(i);
            QMLog.e("minisdk-start_UIProxy", paramBundle.toString());
          }
          paramBundle = paramActivity.getPage();
          paramActivity = localObject2;
          if (paramBundle != null) {
            paramActivity = paramBundle.getCapsuleButton();
          }
          if (paramActivity != null) {
            paramActivity.setUnReadCount(i, false);
          }
        }
      }
      return;
    }
    QMLog.e("minisdk-start_UIProxy", "Failed to refreshMiniBadge, runtime or miniappinfo is null");
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramActivity = new StringBuilder();
    paramActivity.append("onRequestPermissionsResult requestCode=");
    paramActivity.append(paramInt);
    paramActivity.append(" permissions=");
    paramActivity.append(paramArrayOfString);
    paramActivity.append("grantResults=");
    paramActivity.append(paramArrayOfInt);
    QMLog.i("minisdk-start_UIProxy", paramActivity.toString());
    ActivityResultManager.g().notifyRequestPermissionResultListener(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(" [MiniLifecycle] ");
    localStringBuilder.append("onRuntimeFail. Whoops, failed to load the runtime, retCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg = ");
    localStringBuilder.append(paramString);
    QMLog.e("minisdk-start_UIProxy", localStringBuilder.toString());
    this.mMainHandler.postDelayed(new BaseUIProxy.4(this, paramInt, paramString), 1000L);
  }
  
  protected void onRuntimeReady()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(" [MiniLifecycle] ");
    localStringBuilder.append("onRuntimeReady. Here we go, start the runtime lifecycle");
    QMLog.i("minisdk-start_UIProxy", localStringBuilder.toString());
    AppBrandTask.runTaskOnUiThread(new BaseUIProxy.3(this));
  }
  
  protected void processSelectLoadingAdLogic(Activity paramActivity, MiniAppInfo paramMiniAppInfo)
  {
    String str = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    long l = System.currentTimeMillis();
    MiniLoadingAdManager.getInstance().selectAd(paramActivity, paramMiniAppInfo, str, new BaseUIProxy.5(this, l, str, paramMiniAppInfo, paramActivity));
  }
  
  public void quit()
  {
    Activity localActivity = this.mActivity;
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader paramBaseRuntimeLoader, MiniAppInfo paramMiniAppInfo)
  {
    if (paramBaseRuntimeLoader.isLoadSucceed())
    {
      if (!paramMiniAppInfo.isShortcutFakeApp()) {
        paramBaseRuntimeLoader.setMiniAppInfo(paramMiniAppInfo);
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
  
  protected abstract void showLoading(MiniAppInfo paramMiniAppInfo);
  
  protected void startMiniAppInfo(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_UIProxy", "Failed to start. miniAppInfo is null");
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new BaseUIProxy.1(this, paramBundle));
    MiniAppPrelaunchRecorder.get().onMiniAppStart(paramMiniAppInfo.appId);
    BaseRuntimeLoader localBaseRuntimeLoader = this.mCurrRuntimeLoader;
    if ((localBaseRuntimeLoader != null) && (localBaseRuntimeLoader.getRuntime() != null)) {
      ((ObserverManager)localBaseRuntimeLoader.getRuntime().getManager(ObserverManager.class)).notifyChange("resetPlayer");
    }
    QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] startMiniAppInfo ");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startMiniAppInfo ");
    ((StringBuilder)localObject1).append(paramMiniAppInfo.toDetailString());
    QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject1).toString());
    Object localObject2 = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (paramMiniAppInfo.launchParam.forceReload != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startMiniAppInfo. There is a existing runtime loader but need force Reroad. ");
        ((StringBuilder)localObject1).append(((BaseRuntimeLoader)localObject2).toSimpleString());
        QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject1).toString());
        AppRuntimeLoaderManager.g().removeRuntimeLoader((BaseRuntimeLoader)localObject2);
        localObject1 = null;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startMiniAppInfo. Resume the existing runtime of existing runtime loader = ");
      ((StringBuilder)localObject2).append(((BaseRuntimeLoader)localObject1).toSimpleString());
      QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject2).toString());
      this.mCurrRuntimeLoader = ((BaseRuntimeLoader)localObject1);
      this.mCurrRuntimeLoader.addRuntimeStateObserver(getRuntimeStateObserver());
      AppRuntimeLoaderManager.g().bringToFront((BaseRuntimeLoader)localObject1);
      if ((localBaseRuntimeLoader != null) && (localBaseRuntimeLoader != localObject1)) {
        destroyLastRuntimeLoader(localBaseRuntimeLoader);
      }
      ((BaseRuntimeLoader)localObject1).notifyRuntimeEvent(20, new Object[0]);
      if (localBaseRuntimeLoader != localObject1) {
        showLoading(paramMiniAppInfo);
      }
      reloadMiniAppInfoIfNeed((BaseRuntimeLoader)localObject1, paramMiniAppInfo);
    }
    else
    {
      showLoading(paramMiniAppInfo);
      MiniReportManager.reportEventType(paramMiniAppInfo, 1013, "1");
      localObject1 = AppRuntimeLoaderManager.g().createAppRuntimeLoader(paramMiniAppInfo, createRuntimeLoaderListener(), paramBundle);
      if ((localBaseRuntimeLoader != null) && (localBaseRuntimeLoader != localObject1)) {
        destroyLastRuntimeLoader(localBaseRuntimeLoader);
      }
      ((BaseRuntimeLoader)localObject1).addRuntimeStateObserver(getRuntimeStateObserver());
      if (paramMiniAppInfo.launchParam.forceReload != 0)
      {
        ((BaseRuntimeLoader)localObject1).resetAndStart(paramMiniAppInfo);
        this.mCurrRuntimeLoader = ((BaseRuntimeLoader)localObject1);
      }
      else
      {
        this.mCurrRuntimeLoader = ((BaseRuntimeLoader)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startMiniAppInfo. Create a new runtime loader = ");
        ((StringBuilder)localObject2).append(localObject1);
        QMLog.i("minisdk-start_UIProxy", ((StringBuilder)localObject2).toString());
        ((BaseRuntimeLoader)localObject1).start();
      }
      ((BaseRuntimeLoader)localObject1).notifyRuntimeEvent(20, new Object[0]);
    }
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      int i;
      if (paramBundle != null) {
        i = paramBundle.getInt("start_mode", 3);
      } else {
        i = 3;
      }
      if (i == 3) {
        MiniAppStartState.setProcessLoad(paramMiniAppInfo.appId, false);
      } else {
        MiniAppStartState.setProcessLoad(paramMiniAppInfo.appId, true);
      }
      paramBundle = this.mPageGestureProxy;
      if (paramBundle != null) {
        paramBundle.onCreateMiniAppInfo(paramMiniAppInfo);
      }
    }
  }
  
  protected void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy
 * JD-Core Version:    0.7.0.1
 */