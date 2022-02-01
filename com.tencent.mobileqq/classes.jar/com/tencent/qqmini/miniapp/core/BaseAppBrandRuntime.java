package com.tencent.qqmini.miniapp.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.plugins.engine.MiniAppJsPluginEngine;
import com.tencent.qqmini.sdk.runtime.AppStateManager;

public abstract class BaseAppBrandRuntime
  extends BaseRuntimeImpl
  implements Preloadable<IAppBrandService>
{
  private static final String TAG = "minisdk-start_BaseAppBrandRuntime";
  protected IAppBrandService appBrandService;
  protected JsPluginEngine jsPluginEngine;
  protected Activity mActivity;
  protected ApkgInfo mApkgInfo;
  protected AppStateManager mAppStateManager;
  protected String mEntryPath;
  protected EventListener mEventListener = new EventListener(this);
  private boolean mIsForground = true;
  protected MiniAppInfo mMiniAppInfo;
  protected boolean mPrecacheFetched = false;
  protected ViewGroup mRootLayout;
  protected IAppBrandPageContainer pageContainer;
  
  public BaseAppBrandRuntime(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppStateManager getAppStateManager()
  {
    return this.mAppStateManager;
  }
  
  public Activity getAttachedActivity()
  {
    return this.mActivity;
  }
  
  public String getBaseLibVersion()
  {
    return BaseLibManager.g().getBaseLibInfo().baseLibVersion;
  }
  
  public Context getContext()
  {
    return AppLoaderFactory.g().getContext();
  }
  
  public EventListener getEventListener()
  {
    return this.mEventListener;
  }
  
  public JsPluginEngine getJsPluginEngine()
  {
    return this.jsPluginEngine;
  }
  
  public IJsService getJsService()
  {
    return this.appBrandService;
  }
  
  public MiniAppInfo getMiniAppInfo()
  {
    return this.mMiniAppInfo;
  }
  
  public IPage getPage()
  {
    return this.pageContainer;
  }
  
  public ShareState getShareState()
  {
    return null;
  }
  
  public void init(IAppBrandService paramIAppBrandService)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] init");
    if (paramIAppBrandService == null)
    {
      QMLog.e("minisdk-start_BaseAppBrandRuntime", "customJsService is null!");
      return;
    }
    this.appBrandService = paramIAppBrandService;
    this.appBrandService.setAppBrandEventInterface(this.mEventListener);
  }
  
  public boolean isForground()
  {
    return this.mIsForground;
  }
  
  public boolean isMiniGame()
  {
    return false;
  }
  
  public boolean isOrientationLandscape()
  {
    return false;
  }
  
  protected void launchPage(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.pageContainer.cleanup(false);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = paramMiniAppInfo.launchParam.entryPath;
    }
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if ((paramMiniAppInfo != null) && (paramMiniAppInfo.apkgInfo != null) && (((ApkgInfo)paramMiniAppInfo.apkgInfo).mAppConfigInfo != null)) {
        paramMiniAppInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo).mAppConfigInfo.entryPagePath;
      } else {
        paramMiniAppInfo = null;
      }
      localObject = paramMiniAppInfo;
    }
    paramString = this.pageContainer;
    if (paramBoolean) {
      paramMiniAppInfo = "reLaunch";
    } else {
      paramMiniAppInfo = "appLaunch";
    }
    paramString.launch((String)localObject, paramMiniAppInfo);
  }
  
  public void loadMiniApp(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] loadMiniApp");
    if (this.mApkgInfo != null) {
      return;
    }
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
    ((MiniAppFileManager)getManager(MiniAppFileManager.class)).initFileManager(this.mApkgInfo, false);
    AppBrandUtil.updateAppLaunchInfoForApkgInfo(paramMiniAppInfo);
    if (!this.mPrecacheFetched)
    {
      this.mPrecacheFetched = true;
      PreCacheManager.g().fetchPreCacheData(this.mMiniAppInfo);
      PreCacheManager.g().fetchPreResourceIfNeed(this.mMiniAppInfo);
    }
    this.mEntryPath = this.mMiniAppInfo.launchParam.entryPath;
    paramMiniAppInfo = this.jsPluginEngine;
    if (paramMiniAppInfo != null) {
      paramMiniAppInfo.onCreate(this);
    }
  }
  
  public boolean onBackPress()
  {
    IAppBrandPageContainer localIAppBrandPageContainer = this.pageContainer;
    return (localIAppBrandPageContainer != null) && (localIAppBrandPageContainer.navigateBack(1, -1));
  }
  
  public void onLoadMiniAppInfo(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onLoadMiniAppInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadMiniAppInfo miniAppInfo=");
    localStringBuilder.append(paramMiniAppInfo);
    localStringBuilder.append(",fromReload=");
    localStringBuilder.append(paramBoolean);
    QMLog.i("minisdk-start_BaseAppBrandRuntime", localStringBuilder.toString());
    this.mMiniAppInfo = paramMiniAppInfo;
    this.mApkgInfo = ((ApkgInfo)paramMiniAppInfo.apkgInfo);
    this.mEntryPath = this.mMiniAppInfo.launchParam.entryPath;
    this.jsPluginEngine.onCreate(this);
    this.pageContainer.setMiniAppInfo(paramMiniAppInfo);
    this.pageContainer.setFromReload(paramBoolean);
    if (((AbsAppBrandService)this.appBrandService).getCurrState() == ((AbsAppBrandService)this.appBrandService).stateLoadSucc)
    {
      AppBrandTask.runTaskOnUiThread(new BaseAppBrandRuntime.1(this, paramMiniAppInfo, paramBoolean, paramString));
    }
    else
    {
      ((AbsAppBrandService)this.appBrandService).addStateChangeListener(new BaseAppBrandRuntime.2(this, paramMiniAppInfo, paramBoolean, paramString));
      this.appBrandService.setApkgInfo((ApkgInfo)paramMiniAppInfo.apkgInfo);
    }
    if ((this.appBrandService instanceof AppV8JsService))
    {
      QMLog.i("minisdk-start_BaseAppBrandRuntime", "onLoadMiniAppInfo run with v8rt");
      if (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
        new Handler(Looper.getMainLooper()).post(new BaseAppBrandRuntime.3(this));
      }
    }
  }
  
  public void onRuntimeAttachActivity(Activity paramActivity, ViewGroup paramViewGroup)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeAttachActivity");
    if ((this.mActivity == paramActivity) && (this.mRootLayout == paramViewGroup)) {
      return;
    }
    this.mActivity = paramActivity;
    this.mRootLayout = paramViewGroup;
    this.pageContainer.onAttachedToActivity(paramActivity);
    if ((this.pageContainer.getContentView() != null) && (this.pageContainer.getContentView().getParent() != null)) {
      ((ViewGroup)this.pageContainer.getContentView().getParent()).removeView(this.pageContainer.getContentView());
    }
    paramViewGroup.addView(this.pageContainer.getContentView(), new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void onRuntimeCreate()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeCreate");
    this.jsPluginEngine = new MiniAppJsPluginEngine(this.mContext);
  }
  
  public void onRuntimeDetachActivity(Activity paramActivity)
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeDetachActivity");
    if ((this.mRootLayout != null) && (this.pageContainer.getContentView() != null)) {
      this.mRootLayout.removeView(this.pageContainer.getContentView());
    }
    this.mActivity = null;
    this.mRootLayout = null;
  }
  
  public void onRuntimePause()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimePause");
    this.mIsForground = false;
    Object localObject = this.pageContainer;
    if (localObject != null) {
      ((IAppBrandPageContainer)localObject).onPause();
    }
    localObject = this.jsPluginEngine;
    if (localObject != null) {
      ((JsPluginEngine)localObject).onPause();
    }
    this.lastStayTime += System.currentTimeMillis() - this.onResumeTime;
  }
  
  public void onRuntimeResume()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeResume");
    this.mIsForground = true;
    Object localObject = this.pageContainer;
    if (localObject != null) {
      ((IAppBrandPageContainer)localObject).onResume();
    }
    localObject = this.jsPluginEngine;
    if (localObject != null) {
      ((JsPluginEngine)localObject).onResume();
    }
    this.onResumeTime = System.currentTimeMillis();
    if (this.startTime == 0L) {
      this.startTime = this.onResumeTime;
    }
  }
  
  public void onRuntimeStart()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeStart");
  }
  
  public void onRuntimeStop()
  {
    QMLog.i("minisdk-start_BaseAppBrandRuntime", " [MiniLifecycle] onRuntimeStop");
    IAppBrandPageContainer localIAppBrandPageContainer = this.pageContainer;
    if (localIAppBrandPageContainer != null) {
      localIAppBrandPageContainer.onStop();
    }
  }
  
  public void onUpdateMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if (localMiniAppInfo != null) {
      localMiniAppInfo.launchParam.clone(paramMiniAppInfo.launchParam);
    } else {
      this.mMiniAppInfo = paramMiniAppInfo;
    }
    this.pageContainer.setMiniAppInfo(paramMiniAppInfo);
    this.appBrandService.setApkgInfo((ApkgInfo)paramMiniAppInfo.apkgInfo);
  }
  
  public void setAppStateManager(AppStateManager paramAppStateManager)
  {
    this.mAppStateManager = paramAppStateManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */