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
  public Activity mActivity;
  private final Binder mClientBinder = new Binder();
  protected BaseRuntimeLoader mCurrRuntimeLoader;
  private boolean mIsDestroyed;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper());
  protected PageGestureProxy mPageGestureProxy;
  public ViewGroup mRootLayout;
  protected long showTimeStamp = 0L;
  
  private void destroyLastRuntimeLoader(BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    if (paramBaseRuntimeLoader.isRunning())
    {
      QMLog.i("minisdk-start_UIProxy", "pause last runtime loader:" + paramBaseRuntimeLoader);
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
    if (this.mCurrRuntimeLoader != null) {
      return this.mCurrRuntimeLoader.getMiniAppInfo();
    }
    return null;
  }
  
  public BaseRuntime getRuntime()
  {
    if (this.mCurrRuntimeLoader != null) {
      return this.mCurrRuntimeLoader.getRuntime();
    }
    return null;
  }
  
  protected abstract AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver();
  
  protected abstract void hideLoading();
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.i("minisdk-start_UIProxy", "onActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
    ActivityResultManager.g().notifyActivityResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachActivity(Activity paramActivity, Bundle paramBundle, ViewGroup paramViewGroup)
  {
    QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onAttachActivity");
    paramBundle = paramActivity.getWindow();
    if (paramBundle != null) {
      paramBundle.setSoftInputMode(18);
    }
    if (this.mActivity != null) {}
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    MiniGdtReporter.prepareReport();
    this.mPageGestureProxy = ((PageGestureProxy)ProxyManager.get(PageGestureProxy.class));
    if (this.mPageGestureProxy != null) {
      this.mPageGestureProxy.onActivityCreate(paramActivity);
    }
  }
  
  public boolean onBackPressed(Activity paramActivity)
  {
    QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onBackPressed");
    boolean bool = false;
    if (this.mCurrRuntimeLoader != null) {
      bool = this.mCurrRuntimeLoader.getRuntime().onBackPress();
    }
    AppStateEvent.obtain(25).notifyRuntime(getRuntime());
    return bool;
  }
  
  public void onDetachActivity(Activity paramActivity)
  {
    QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onDetachActivity");
    if (this.mActivity != paramActivity)
    {
      QMLog.e("minisdk-start_UIProxy", "onDetachActivity. activity is mismatch. mActivity=" + this.mActivity + " activity=" + paramActivity);
      return;
    }
    if (this.mCurrRuntimeLoader != null)
    {
      this.mCurrRuntimeLoader.onDetachActivity(paramActivity);
      if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
        AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      }
    }
    this.mCurrRuntimeLoader = null;
    if (this.mPageGestureProxy != null) {
      this.mPageGestureProxy.onActivityDestroy(paramActivity);
    }
    this.mActivity = null;
    this.mRootLayout = null;
    this.mIsDestroyed = true;
  }
  
  public void onIntentUpdate(Intent paramIntent)
  {
    QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onIntentUpdate " + paramIntent);
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramIntent.getParcelableExtra("KEY_APPINFO");
    if (localMiniAppInfo == null)
    {
      QMLog.e("minisdk-start_UIProxy", "onIntentUpdate MiniAppInfo is Null!");
      return;
    }
    if (localMiniAppInfo.canDebug()) {
      localMiniAppInfo.forceReroad = 3;
    }
    AppLoaderFactory.g().getAppBrandProxy().onAppStart(localMiniAppInfo, null);
    startMiniAppInfo(localMiniAppInfo, paramIntent.getExtras());
    MiniGdtReporter.prepareReport();
  }
  
  public void onMiniPause()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniPause current runtime loader is null!");
    }
    do
    {
      do
      {
        return;
        QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onMiniPause");
        this.mCurrRuntimeLoader.onMiniPause();
      } while (this.mCurrRuntimeLoader.getMiniAppInfo() == null);
      GameGrowthGuardianManager.executeEnd(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
    } while (this.mPageGestureProxy == null);
    this.mPageGestureProxy.onActivityPause(this.mActivity);
  }
  
  public void onMiniResume()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniResume current runtime loader is null!");
    }
    ChannelProxy localChannelProxy;
    do
    {
      do
      {
        return;
        this.showTimeStamp = System.currentTimeMillis();
        QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onMiniResume");
        this.mCurrRuntimeLoader.onMiniResume();
        AppRuntimeLoaderManager.g().onEnterForeground(this.mCurrRuntimeLoader);
      } while (this.mCurrRuntimeLoader.getMiniAppInfo() == null);
      AppLoaderFactory.g().getAppBrandProxy().onAppForeground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      GameGrowthGuardianManager.executeBegin(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
      if (this.mPageGestureProxy != null)
      {
        this.mPageGestureProxy.onActivityResume(this.mActivity);
        this.mPageGestureProxy.onCreateMiniAppInfo(this.mCurrRuntimeLoader.getMiniAppInfo());
      }
      localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    } while (localChannelProxy == null);
    localChannelProxy.syncForceGroundAndRefreshBadge(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo().appId, AppLoaderFactory.g().getProcessName());
  }
  
  public void onMiniStart()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniStart current runtime loader is null!");
    }
    do
    {
      return;
      QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onMiniStart");
    } while (this.mCurrRuntimeLoader == null);
    this.mCurrRuntimeLoader.onMiniStart();
  }
  
  public void onMiniStop()
  {
    if (this.mCurrRuntimeLoader == null) {
      QMLog.e("minisdk-start_UIProxy", "onMiniStop current runtime loader is null!");
    }
    do
    {
      return;
      QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onMiniStop");
      this.mCurrRuntimeLoader.onMiniStop();
      AppRuntimeLoaderManager.g().onEnterBackground();
      if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
        AppLoaderFactory.g().getAppBrandProxy().onAppBackground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
      }
    } while ((this.mPageGestureProxy == null) || (this.mActivity == null));
    this.mPageGestureProxy.onActivityStop(this.mActivity);
  }
  
  public void onRefreshMiniBadge(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = null;
    QMLog.i("minisdk-start_UIProxy", "onRefreshMiniBadge");
    MiniAppInfo localMiniAppInfo;
    if (this.mCurrRuntimeLoader != null)
    {
      paramActivity = this.mCurrRuntimeLoader.getRuntime();
      if (this.mCurrRuntimeLoader == null) {
        break label65;
      }
      localMiniAppInfo = this.mCurrRuntimeLoader.getMiniAppInfo();
      label42:
      if ((paramActivity != null) && (localMiniAppInfo != null)) {
        break label71;
      }
      QMLog.e("minisdk-start_UIProxy", "Failed to refreshMiniBadge, runtime or miniappinfo is null");
    }
    label65:
    label71:
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          paramActivity = null;
          break;
          localMiniAppInfo = null;
          break label42;
        } while (paramBundle == null);
        str = paramBundle.getString("key_appid");
        if (QMLog.isColorLevel()) {
          QMLog.d("TAG", "onRefreshMiniBadge appID : " + str);
        }
      } while (!localMiniAppInfo.appId.equals(str));
      i = paramBundle.getInt("KEY_BADGE_COUNT");
      if (QMLog.isColorLevel()) {
        QMLog.e("minisdk-start_UIProxy", "onRefreshMiniBadge badge : " + i);
      }
      paramBundle = paramActivity.getPage();
      paramActivity = localObject;
      if (paramBundle != null) {
        paramActivity = paramBundle.getCapsuleButton();
      }
    } while (paramActivity == null);
    paramActivity.setUnReadCount(i, false);
  }
  
  public void onRequestPermissionsResult(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QMLog.i("minisdk-start_UIProxy", "onRequestPermissionsResult requestCode=" + paramInt + " permissions=" + paramArrayOfString + "grantResults=" + paramArrayOfInt);
    ActivityResultManager.g().notifyRequestPermissionResultListener(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRuntimeFail(int paramInt, String paramString)
  {
    QMLog.e("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onRuntimeFail. Whoops, failed to load the runtime, retCode = " + paramInt + ", msg = " + paramString);
    this.mMainHandler.postDelayed(new BaseUIProxy.4(this, paramInt, paramString), 1000L);
  }
  
  protected void onRuntimeReady()
  {
    QMLog.i("minisdk-start_UIProxy", this + " [MiniLifecycle] " + "onRuntimeReady. Here we go, start the runtime lifecycle");
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
    if (this.mActivity != null) {
      this.mActivity.finish();
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
    }
    do
    {
      return;
      showLoading(paramMiniAppInfo);
      paramBaseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
    } while (paramBaseRuntimeLoader.isRunning());
    paramBaseRuntimeLoader.start();
  }
  
  protected abstract void showLoading(MiniAppInfo paramMiniAppInfo);
  
  protected void startMiniAppInfo(MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramMiniAppInfo == null) {
      QMLog.e("minisdk-start_UIProxy", "Failed to start. miniAppInfo is null");
    }
    label286:
    label313:
    label480:
    label485:
    label494:
    for (;;)
    {
      return;
      ThreadManager.executeOnDiskIOThreadPool(new BaseUIProxy.1(this, paramBundle));
      MiniAppPrelaunchRecorder.get().onMiniAppStart(paramMiniAppInfo.appId);
      BaseRuntimeLoader localBaseRuntimeLoader3 = this.mCurrRuntimeLoader;
      if ((localBaseRuntimeLoader3 != null) && (localBaseRuntimeLoader3.getRuntime() != null)) {
        ((ObserverManager)localBaseRuntimeLoader3.getRuntime().getManager(ObserverManager.class)).notifyChange("resetPlayer");
      }
      QMLog.i("minisdk-start_UIProxy", " [MiniLifecycle] startMiniAppInfo ");
      QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo " + paramMiniAppInfo.toDetailString());
      BaseRuntimeLoader localBaseRuntimeLoader2 = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
      BaseRuntimeLoader localBaseRuntimeLoader1 = localBaseRuntimeLoader2;
      if (localBaseRuntimeLoader2 != null)
      {
        localBaseRuntimeLoader1 = localBaseRuntimeLoader2;
        if (paramMiniAppInfo.forceReroad != 0)
        {
          QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo. There is a existing runtime loader but need force Reroad. " + localBaseRuntimeLoader2.toSimpleString());
          AppRuntimeLoaderManager.g().removeRuntimeLoader(localBaseRuntimeLoader2);
          localBaseRuntimeLoader1 = null;
        }
      }
      int i;
      if (localBaseRuntimeLoader1 != null)
      {
        QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo. Resume the existing runtime of existing runtime loader = " + localBaseRuntimeLoader1.toSimpleString());
        this.mCurrRuntimeLoader = localBaseRuntimeLoader1;
        this.mCurrRuntimeLoader.addRuntimeStateObserver(getRuntimeStateObserver());
        AppRuntimeLoaderManager.g().bringToFront(localBaseRuntimeLoader1);
        if ((localBaseRuntimeLoader3 != null) && (localBaseRuntimeLoader3 != localBaseRuntimeLoader1)) {
          destroyLastRuntimeLoader(localBaseRuntimeLoader3);
        }
        localBaseRuntimeLoader1.notifyRuntimeEvent(20, new Object[0]);
        if (localBaseRuntimeLoader3 != localBaseRuntimeLoader1) {
          showLoading(paramMiniAppInfo);
        }
        reloadMiniAppInfoIfNeed(localBaseRuntimeLoader1, paramMiniAppInfo);
        if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.appId))) {
          break label431;
        }
        if (paramBundle == null) {
          break label480;
        }
        i = paramBundle.getInt("start_mode", 3);
        if (i != 3) {
          break label485;
        }
        MiniAppStartState.setProcessLoad(paramMiniAppInfo.appId, false);
      }
      for (;;)
      {
        if (this.mPageGestureProxy == null) {
          break label494;
        }
        this.mPageGestureProxy.onCreateMiniAppInfo(paramMiniAppInfo);
        return;
        showLoading(paramMiniAppInfo);
        MiniReportManager.reportEventType(paramMiniAppInfo, 1013, "1");
        localBaseRuntimeLoader1 = AppRuntimeLoaderManager.g().createAppRuntimeLoader(paramMiniAppInfo, createRuntimeLoaderListener(), paramBundle);
        if ((localBaseRuntimeLoader3 != null) && (localBaseRuntimeLoader3 != localBaseRuntimeLoader1)) {
          destroyLastRuntimeLoader(localBaseRuntimeLoader3);
        }
        localBaseRuntimeLoader1.addRuntimeStateObserver(getRuntimeStateObserver());
        if (paramMiniAppInfo.forceReroad != 0)
        {
          localBaseRuntimeLoader1.resetAndStart(paramMiniAppInfo);
          this.mCurrRuntimeLoader = localBaseRuntimeLoader1;
        }
        for (;;)
        {
          localBaseRuntimeLoader1.notifyRuntimeEvent(20, new Object[0]);
          break label286;
          break;
          this.mCurrRuntimeLoader = localBaseRuntimeLoader1;
          if (paramMiniAppInfo.isEngineTypeMiniApp())
          {
            QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo. Create a new runtime loader = " + localBaseRuntimeLoader1);
            localBaseRuntimeLoader1.start();
          }
        }
        i = 3;
        break label313;
        MiniAppStartState.setProcessLoad(paramMiniAppInfo.appId, true);
      }
    }
  }
  
  protected void updateLoadingAdUI(Activity paramActivity, MiniAppInfo paramMiniAppInfo, String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.BaseUIProxy
 * JD-Core Version:    0.7.0.1
 */