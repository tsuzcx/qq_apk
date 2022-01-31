package com.tencent.mobileqq.mini.appbrand;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.mini.appbrand.page.BrandPagePool;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientFactory;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.appbrand.worker.MiniAppWorkerManager;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniAppStartState;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04363;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.CoverMapView;
import com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandRuntime
  extends BaseAppBrandRuntime
  implements AppBrandServiceEventInterface
{
  public static final String APPLAUNCH = "appLaunch";
  public static final int BOOT_STATE_LOADING = 0;
  public static final int BOOT_STATE_SHOW = 2;
  public static final int BOOT_STATE_SHOWING = 1;
  public static final String EXIT_MINIPROGRAM = "exitMiniProgram";
  public static final String KEY_APPID = "appId";
  public static final String KEY_DELTA = "delta";
  public static final String KEY_SCENE = "scene";
  public static final String KEY_SHARETICKET = "shareTicket";
  public static final String KEY_URL = "url";
  private static final Set<Integer> LaunchAppScenes;
  public static final String NAVIGATE_BACK = "navigateBack";
  public static final String NAVIGATE_TO = "navigateTo";
  public static final String ON_APP_ENTER_BACKGROUD = "onAppEnterBackground";
  public static final String ON_APP_ENTER_FOREGROUD = "onAppEnterForeground";
  public static final String ON_APP_LOW_MEMORY = "onMemoryWarning";
  public static final String ON_PAUSE = "onPause";
  public static final String ON_UPDATE_STATUS_CHANGE = "onUpdateStatusChange";
  public static final String REDIRECT_TO = "redirectTo";
  public static final String RELAUNCH = "reLaunch";
  public static final String SWITCH_TAB = "switchTab";
  public static final String TAG = "AppBrandRuntime";
  public static final String UPDATE_APP = "updateApp";
  private static final Set<Integer> keepLaunchAppScenes;
  private static final boolean mEnableNewPage;
  public volatile ApkgInfo apkgInfo;
  public AppBrandRuntimeContainerInterface appBrandRuntimeContainer;
  private int bootState = 0;
  private boolean hasReportAppCreate;
  private boolean isColdBoot;
  public boolean isFirstDomReady;
  private boolean isKeyboardShowing;
  private boolean isNavigateBeforeResume;
  private boolean isOpenMonitorPanel;
  public boolean isPause;
  public boolean isResume;
  public JsPluginEngine jsPluginEngine;
  private AppBrandRuntime.KeyboardObserver keyboardObserver;
  private int lauchAppScene;
  boolean mFinished;
  public JsErrorGuard mJsErrorGuard;
  public AppBrandRuntime.JsErrorListener mJsErrorListener;
  public long mReportSeqNo = -1L;
  protected boolean mWeixinJSBridgeFinished;
  private int miniAppStoreLastScene = 9999;
  public MiniAppWorkerManager miniAppWorkerManager;
  private String[] miniStoreSceneWhiteArr;
  private String miniStoreSceneWhiteStr = QzoneConfig.getInstance().getConfig("qqminiapp", "miniStoreSceneWhiteList", "1001,2050,2009,3002,3003");
  public boolean needReboot;
  private MiniAppConfig newAppConfig;
  public AppBrandPageContainer pageContainer;
  private boolean reportBringToFront;
  private Runnable reportLaunchEndTimeoutRunnable = new AppBrandRuntime.4(this);
  public JsRuntime serviceRuntime;
  public int versionType;
  public WebviewPool webviewPool;
  
  static
  {
    boolean bool = true;
    keepLaunchAppScenes = new HashSet();
    LaunchAppScenes = new HashSet();
    keepLaunchAppScenes.add(Integer.valueOf(1001));
    keepLaunchAppScenes.add(Integer.valueOf(1038));
    LaunchAppScenes.add(Integer.valueOf(1036));
    LaunchAppScenes.add(Integer.valueOf(1069));
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_redirectto_config", 1) == 1) {}
    for (;;)
    {
      mEnableNewPage = bool;
      return;
      bool = false;
    }
  }
  
  public AppBrandRuntime(AppBrandRuntimeContainerInterface paramAppBrandRuntimeContainerInterface)
  {
    this.appBrandRuntimeContainer = paramAppBrandRuntimeContainerInterface;
    this.pageContainer = new AppBrandPageContainer(BaseApplicationImpl.getContext(), this);
    this.jsPluginEngine = new JsPluginEngine(this);
    this.jsPluginEngine.init();
    this.webviewPool = new WebviewPool(this);
    this.miniAppWorkerManager = new MiniAppWorkerManager(this);
    this.mJsErrorGuard = new JsErrorGuard(this);
    this.mJsErrorListener = new AppBrandRuntime.1(this);
    if (!TextUtils.isEmpty(this.miniStoreSceneWhiteStr)) {
      this.miniStoreSceneWhiteArr = this.miniStoreSceneWhiteStr.split(",");
    }
    if (this.keyboardObserver == null) {
      this.keyboardObserver = new AppBrandRuntime.KeyboardObserver(this);
    }
  }
  
  private Bitmap buildBitmapFromView(View paramView)
  {
    if (paramView != null)
    {
      paramView.setDrawingCacheEnabled(true);
      paramView.buildDrawingCache();
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
      paramView.setDrawingCacheEnabled(false);
      return localBitmap;
    }
    return null;
  }
  
  private void checkUpdate()
  {
    if (this.apkgInfo.appConfig.config.verType != 3)
    {
      QLog.d("AppBrandRuntime", 1, "checkUpdate -- miniapp is not online, return.");
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("state", "noUpdate");
        evaluateServiceSubcribeJS("onUpdateStatusChange", localJSONObject.toString());
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AppBrandRuntime", 1, "updateJSONObject error." + localException);
        return;
      }
    }
    ThreadManager.excute(new AppBrandRuntime.5(this), 16, null, false);
  }
  
  private void getScreenshotFromView(BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback, View paramView)
  {
    paramView = buildBitmapFromView(paramView);
    if ((paramView == null) || (paramView.isRecycled())) {
      if (paramShareScreenshotCallback != null) {
        paramShareScreenshotCallback.onGetShareScreenshot(null);
      }
    }
    for (;;)
    {
      this.isGettingScreenShot = false;
      return;
      ThreadManagerV2.executeOnFileThread(new AppBrandRuntime.19(this, paramShareScreenshotCallback, paramView));
    }
  }
  
  private boolean isMiniAppStore()
  {
    return (this.apkgInfo != null) && (this.apkgInfo.appConfig != null) && (this.apkgInfo.appConfig.config != null) && (this.apkgInfo.appConfig.config.isAppStoreMiniApp());
  }
  
  private boolean needReloadMiniStore(MiniAppConfig paramMiniAppConfig)
  {
    boolean bool2 = false;
    try
    {
      if (this.miniAppStoreLastScene == 9999) {
        return false;
      }
      boolean bool1;
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null) && (this.miniAppStoreLastScene == paramMiniAppConfig.launchParam.scene))
      {
        String[] arrayOfString = this.miniStoreSceneWhiteArr;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!TextUtils.isEmpty(str))
          {
            int k = Integer.valueOf(str).intValue();
            int m = paramMiniAppConfig.launchParam.scene;
            bool1 = bool2;
            if (k == m) {
              break label122;
            }
          }
          i += 1;
        }
      }
      return bool1;
    }
    catch (Throwable paramMiniAppConfig)
    {
      QLog.e("AppBrandRuntime", 1, "needReloadMiniStore error, ", paramMiniAppConfig);
      bool1 = true;
    }
  }
  
  private static Message obtainMessage(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    return localMessage;
  }
  
  public boolean canLaunchApp()
  {
    return LaunchAppScenes.contains(Integer.valueOf(this.lauchAppScene));
  }
  
  public final void cleanup()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "cleanup. | " + this);
    }
    this.pageContainer.cleanup(false);
    this.jsPluginEngine.onDestroy();
    this.webviewPool.recycleServiceWebview(this.serviceRuntime, this.activity);
    this.webviewPool.destroyCachePageWebView();
    this.miniAppWorkerManager.cleanUp();
    ThreadManager.getSubThreadHandler().removeCallbacks(this.reportLaunchEndTimeoutRunnable);
    this.reportLaunchEndTimeoutRunnable = null;
    this.mFinished = true;
    Object localObject = this.pageContainer.getCurrentPage();
    MiniAppConfig localMiniAppConfig;
    if (this.apkgInfo != null)
    {
      localMiniAppConfig = this.apkgInfo.appConfig;
      if (localObject == null) {
        break label144;
      }
    }
    label144:
    for (localObject = ((AbsAppBrandPage)localObject).getUrl();; localObject = null)
    {
      MiniReportManager.reportEventType(localMiniAppConfig, 22, (String)localObject, null, null, 0);
      return;
      localMiniAppConfig = null;
      break;
    }
  }
  
  public void evaluateServiceSubcribeJS(String paramString1, String paramString2)
  {
    this.serviceRuntime.evaluateSubcribeJS(paramString1, paramString2, 0);
  }
  
  public void evaluateServiceSubcribeJS(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 2, "evaluateServiceSubcribeJS. eventName=" + paramString1 + ",webviewId=" + paramInt + " | " + this);
    }
    StringBuilder localStringBuilder;
    if (("custom_event_PAGE_EVENT".equals(paramString1)) && (paramString2 != null) && (paramString2.contains("__DOMReady"))) {
      if ((!this.isFirstDomReady) && (this.pageContainer != null) && (this.pageContainer.getCurrentPage() != null))
      {
        MiniProgramLpReportDC04239.reportPageView(this.apkgInfo.appConfig, "0", this.pageContainer.getCurrentPage().getUrl(), "show", "first_frame");
        MiniAppReportManager2.reportPageView("2launch", "first_frame", this.pageContainer.getCurrentPage().getUrl(), this.apkgInfo.appConfig);
        localStringBuilder = new StringBuilder().append("--- report show firstframe appid:");
        if ((this.apkgInfo.appConfig == null) || (this.apkgInfo.appConfig.config == null)) {
          break label308;
        }
      }
    }
    label308:
    for (Object localObject = this.apkgInfo.appConfig.config.appId;; localObject = Integer.valueOf(0))
    {
      QLog.i("AppBrandRuntime", 1, localObject);
      setBootState(2);
      this.isFirstDomReady = true;
      BrandPagePool.g().preloadBrandPage(this);
      if (this.reportLaunchEndTimeoutRunnable != null)
      {
        if (!this.mWeixinJSBridgeFinished) {}
        ThreadManager.getSubThreadHandler().removeCallbacks(this.reportLaunchEndTimeoutRunnable);
        this.reportLaunchEndTimeoutRunnable = null;
      }
      AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.8(this));
      AppBrandTask.runTaskOnUiThreadDelay(new AppBrandRuntime.9(this), 1500L);
      this.serviceRuntime.evaluateSubcribeJS(paramString1, paramString2, paramInt);
      return;
    }
  }
  
  public final void finish()
  {
    if (this.mFinished) {
      return;
    }
    this.mFinished = true;
    if (this.appBrandRuntimeContainer != null)
    {
      int i = this.appBrandRuntimeContainer.getAppBrandRuntimeSize();
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandRuntime", 2, "finish. appRunTimeCount=" + i + " | " + this);
      }
      if (i == 1)
      {
        this.appBrandRuntimeContainer.finish();
        return;
      }
      this.appBrandRuntimeContainer.removeAppBrandRunTime(this);
    }
    cleanup();
  }
  
  public ApkgInfo getApkgInfo()
  {
    return this.apkgInfo;
  }
  
  public int getBootState()
  {
    return this.bootState;
  }
  
  public View getContainer()
  {
    return this.pageContainer;
  }
  
  public AbsAppBrandPage getCurPage()
  {
    return this.pageContainer.getCurrentPage();
  }
  
  public WebviewContainer getCurWebviewContainer()
  {
    return this.pageContainer.getCurrentWebviewContainer();
  }
  
  public AppBrandRuntime.KeyboardObserver getKeyboardObserver()
  {
    return this.keyboardObserver;
  }
  
  public int getLaunchAppScene()
  {
    return this.lauchAppScene;
  }
  
  public PageWebview getPageWebView()
  {
    return this.pageContainer.getCurrentPageWebview();
  }
  
  public void getShareScreenshot(BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback)
  {
    super.getShareScreenshot(paramShareScreenshotCallback);
    this.isGettingScreenShot = true;
    FrameLayout localFrameLayout;
    View localView2;
    if (getCurPage() != null)
    {
      localFrameLayout = getCurPage().getCenterLayout();
      View localView1 = getCurWebviewContainer().findViewWithTag("MiniAppVideoPlayer");
      localView2 = getCurWebviewContainer().findViewWithTag("MiniAppMapTag");
      if ((localView1 instanceof MiniAppVideoPlayer))
      {
        QLog.d("AppBrandRuntime", 2, new Object[] { "getShareScreenshot", " has video player" });
        ((MiniAppVideoPlayer)localView1).captureImage(new AppBrandRuntime.16(this, localFrameLayout, paramShareScreenshotCallback, localView1));
      }
    }
    do
    {
      return;
      if ((localView2 instanceof CoverMapView))
      {
        QLog.d("AppBrandRuntime", 2, new Object[] { "yuki getShareScreenshot", " has CoverMapView" });
        ((CoverMapView)localView2).captureImage(new AppBrandRuntime.17(this, localFrameLayout, paramShareScreenshotCallback, localView2));
        return;
      }
      if ((getCurPage() != null) && (getCurPage().getCurrentPageWebview() != null) && (getCurPage().getCurrentPageWebview().getEmbeddedWidgetClientFactory() != null) && (getCurPage().getCurrentPageWebview().getEmbeddedWidgetClientFactory().getVideoEmbeddedWidgetClientMap() != null))
      {
        getCurPage().getCurrentPageWebview().shotWebview(new AppBrandRuntime.18(this, paramShareScreenshotCallback, localFrameLayout));
        return;
      }
      QLog.d("AppBrandRuntime", 2, new Object[] { "getShareScreenshot", " no video player and mapview" });
      getScreenshotFromView(paramShareScreenshotCallback, localFrameLayout);
      return;
      QLog.e("AppBrandRuntime", 2, new Object[] { "getShareScreenshot", " can not get current page screenshot" });
    } while (paramShareScreenshotCallback == null);
    paramShareScreenshotCallback.onGetShareScreenshot(null);
    this.isGettingScreenShot = false;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.jsPluginEngine != null) {
      return this.jsPluginEngine.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
    }
    return "";
  }
  
  public boolean isNeedReboot()
  {
    return this.needReboot;
  }
  
  public boolean isOpenMonitorPanel()
  {
    return this.isOpenMonitorPanel;
  }
  
  public void moveAppBrandToBack()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "moveAppBrandToBack. | " + this);
    }
    if ((this.activity instanceof AppBrandUI))
    {
      localAppBrandUI = (AppBrandUI)this.activity;
      if (!localAppBrandUI.moveTaskToBack(false, true)) {
        localAppBrandUI.finish();
      }
    }
    while (this.activity.moveTaskToBack(false))
    {
      AppBrandUI localAppBrandUI;
      return;
    }
    this.activity.finish();
  }
  
  public void onAppCreate(ApkgInfo paramApkgInfo, String paramString, boolean paramBoolean)
  {
    super.onAppCreate(paramApkgInfo, paramString, paramBoolean);
    this.apkgInfo = paramApkgInfo;
    if ((paramApkgInfo == null) || (paramApkgInfo.appConfig == null) || (paramApkgInfo.mAppConfigInfo == null)) {
      return;
    }
    this.versionType = paramApkgInfo.appConfig.config.verType;
    this.appId = paramApkgInfo.appId;
    if (!this.hasReportAppCreate)
    {
      MiniReportManager.reportEventType(paramApkgInfo.appConfig, 24, "", null, null, 1);
      this.hasReportAppCreate = true;
    }
    this.jsPluginEngine.onCreate();
    QLog.d("AppBrandRuntime", 1, "onAppCreate. fromReload=" + paramBoolean + ",entryPath=" + paramString + " | " + this);
    this.isPause = false;
    this.mFinished = false;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = paramApkgInfo.mAppConfigInfo.entryPagePath;
    }
    this.serviceRuntime = this.webviewPool.getServiceWebview(this.appId);
    if (this.serviceRuntime.getApkgInfo() == null) {
      this.serviceRuntime.setApkgInfo(paramApkgInfo);
    }
    this.serviceRuntime.setAppBrandEventInterface(this);
    if (!paramBoolean)
    {
      this.isColdBoot = true;
      this.serviceRuntime.initService(paramApkgInfo, new AppBrandRuntime.2(this, str));
    }
    for (;;)
    {
      MiniAppStateManager.getInstance().notifyChange("resetPlayer");
      ThreadManager.getSubThreadHandler().postDelayed(this.reportLaunchEndTimeoutRunnable, 30000L);
      return;
      this.serviceRuntime.initService(paramApkgInfo, new AppBrandRuntime.3(this, str));
    }
  }
  
  public void onAttachWindow(Activity paramActivity)
  {
    if (this.activity == paramActivity) {}
    do
    {
      return;
      super.onAttachWindow(paramActivity);
      this.activity = paramActivity;
      if ((paramActivity instanceof BaseActivity))
      {
        AppInterface localAppInterface = ((BaseActivity)paramActivity).getAppInterface();
        if ((localAppInterface instanceof MiniAppInterface)) {
          this.appInterface = ((MiniAppInterface)localAppInterface);
        }
        this.jsPluginEngine.onAttachWindow((BaseActivity)paramActivity);
      }
      if (this.appInterface == null) {
        throw new MiniAppException("app params error, appInterface=" + this.appInterface + ",appBrandRuntimeContainer=" + this.appBrandRuntimeContainer);
      }
      if (this.pageContainer != null) {
        this.pageContainer.onAttachWindow();
      }
    } while (this.webviewPool == null);
    this.webviewPool.setContext(paramActivity);
  }
  
  public final void onPause()
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "onPause. | " + this);
    }
    this.isPause = true;
    this.isResume = false;
    this.jsPluginEngine.onPause();
    if ((this.pageContainer != null) && (this.pageContainer.getCurrentPage() != null)) {
      this.pageContainer.getCurrentPage().onPageBackground();
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("scene", this.apkgInfo.appConfig.launchParam.scene);
      ((JSONObject)localObject).put("appId", this.appId);
      evaluateServiceSubcribeJS("onAppEnterBackground", ((JSONObject)localObject).toString());
      if ((this.pageContainer != null) && (this.pageContainer.getCurrentPageWebview() != null)) {
        this.pageContainer.getCurrentPageWebview().onPause();
      }
      long l = Storage.getCurrentStorageSize(this.apkgInfo.appConfig.config.appId);
      if (l >= 0L)
      {
        MiniReportManager.reportEventType(this.apkgInfo.appConfig, 639, null, String.valueOf(l), null, 1, MiniReportManager.getAppType(this.apkgInfo.appConfig), 0L, null);
        QLog.d("AppBrandRuntime", 2, "report  cacheSize:  " + l);
      }
      reportMiniAppEnd();
      MiniReportManager.reportEventType(this.apkgInfo.appConfig, 20, null, null, null, 0);
      localObject = TaskMonitorManager.g();
      if (this.pageContainer != null) {
        str = MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.pageContainer.appBrandRuntime);
      }
      ((TaskMonitorManager)localObject).switchPerfmPage(str, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public final void onResume(MiniAppConfig paramMiniAppConfig, boolean paramBoolean)
  {
    MiniAppInfo localMiniAppInfo = null;
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "onResume. | " + this);
    }
    this.isPause = false;
    this.isResume = true;
    this.jsPluginEngine.onResume();
    if (paramBoolean) {
      this.isOpenMonitorPanel = false;
    }
    Object localObject2;
    if (this.pageContainer.getCurrentPage() != null)
    {
      this.pageContainer.getCurrentPage().onPageForeground();
      if ((!this.isNavigateBeforeResume) && (paramBoolean) && (paramMiniAppConfig.launchParam != null) && (!TextUtils.isEmpty(paramMiniAppConfig.launchParam.entryPath)) && (paramMiniAppConfig.launchParam.fromBackToMiniApp != 1)) {
        if (isMiniAppStore())
        {
          if (!needReloadMiniStore(paramMiniAppConfig)) {
            break label770;
          }
          reload(paramMiniAppConfig.launchParam.entryPath, false);
          localObject2 = paramMiniAppConfig.launchParam.entryPath;
          localObject1 = localObject2;
          if (paramMiniAppConfig.config == null) {
            break label692;
          }
          localObject1 = localObject2;
          if (TextUtils.isEmpty(paramMiniAppConfig.config.appId)) {
            break label692;
          }
          MiniAppStartState.setSwitchPage(paramMiniAppConfig.config.appId, true);
          paramBoolean = true;
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if ((paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null))
      {
        this.miniAppStoreLastScene = paramMiniAppConfig.launchParam.scene;
        if (LaunchAppScenes.contains(Integer.valueOf(paramMiniAppConfig.launchParam.scene))) {
          this.lauchAppScene = paramMiniAppConfig.launchParam.scene;
        }
      }
      else
      {
        label255:
        if (this.isNavigateBeforeResume) {
          this.isNavigateBeforeResume = false;
        }
        this.pageContainer.bringToFront();
        this.apkgInfo.updateMiniConfig(paramMiniAppConfig);
        MiniAppStateManager.getInstance().notifyChange("resumePlayer");
        if (this.isColdBoot)
        {
          this.isColdBoot = false;
          MiniAppFileManager.getInstance().updateCurApkgInfo(this.apkgInfo);
          checkUpdate();
        }
        reportMiniAppStart();
        MiniReportManager.reportEventType(this.apkgInfo.appConfig, 21, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this), null, null, 0);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (this.pageContainer == null) || (this.pageContainer.getCurrentPage() == null)) {
          break label767;
        }
        localObject1 = this.pageContainer.getCurrentPage().getUrl();
      }
      label430:
      label692:
      label756:
      label761:
      label767:
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          if (this.reportBringToFront)
          {
            if ((this.apkgInfo == null) || (this.apkgInfo.appConfig == null)) {
              break label761;
            }
            if (this.apkgInfo.appConfig.launchParam == null) {
              break label756;
            }
            paramMiniAppConfig = this.apkgInfo.appConfig.launchParam;
            localObject2 = paramMiniAppConfig;
            if (this.apkgInfo.appConfig.config != null) {
              localMiniAppInfo = this.apkgInfo.appConfig.config;
            }
          }
        }
        Object localObject3;
        for (localObject2 = paramMiniAppConfig;; localObject3 = null)
        {
          for (;;)
          {
            paramMiniAppConfig = AppBrandUtil.getAppLaunchInfo((String)localObject1, (LaunchParam)localObject2, localMiniAppInfo);
            try
            {
              paramMiniAppConfig.put("reLaunch", paramBoolean);
              evaluateServiceSubcribeJS("onAppEnterForeground", paramMiniAppConfig.toString());
              MiniProgramLpReportDC04239.reportPageView(this.apkgInfo.appConfig, "0", (String)localObject1, "show", "bring_to_front");
              localObject1 = new StringBuilder().append("--- report show bring to front appid:");
              if ((this.apkgInfo.appConfig != null) && (this.apkgInfo.appConfig.config != null))
              {
                paramMiniAppConfig = this.apkgInfo.appConfig.config.appId;
                QLog.i("AppBrandRuntime", 1, paramMiniAppConfig);
                if (!this.reportBringToFront) {
                  this.reportBringToFront = true;
                }
                if ((this.pageContainer != null) && (this.pageContainer.getCurrentPageWebview() != null))
                {
                  this.pageContainer.getCurrentPageWebview().onResume();
                  this.pageContainer.getCurrentPageWebview().requestFocus();
                }
                return;
                if (!this.isFirstDomReady) {
                  break label770;
                }
                reload(paramMiniAppConfig.launchParam.entryPath, false);
                localObject2 = paramMiniAppConfig.launchParam.entryPath;
                localObject1 = localObject2;
                if (paramMiniAppConfig.config != null)
                {
                  localObject1 = localObject2;
                  if (!TextUtils.isEmpty(paramMiniAppConfig.config.appId))
                  {
                    MiniAppStartState.setSwitchPage(paramMiniAppConfig.config.appId, true);
                    localObject1 = localObject2;
                  }
                }
                paramBoolean = true;
                break;
                if (keepLaunchAppScenes.contains(Integer.valueOf(paramMiniAppConfig.launchParam.scene))) {
                  break label255;
                }
                this.lauchAppScene = paramMiniAppConfig.launchParam.scene;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("AppBrandRuntime", 1, "appLaunchInfo error.", localThrowable);
                continue;
                paramMiniAppConfig = Integer.valueOf(0);
              }
            }
          }
          paramMiniAppConfig = null;
          break label430;
        }
      }
      label770:
      paramBoolean = false;
    }
  }
  
  public void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("custom_event_onAppRouteDone".equals(paramString1)) {
      AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.7(this));
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      PageWebview localPageWebview = this.pageContainer.findPageWebView(k);
      if (localPageWebview != null) {
        localPageWebview.evaluateSubcribeJSInService(paramString1, paramString2, k);
      }
      i += 1;
    }
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = null;
    String str = null;
    Object localObject = null;
    if (("reportIDKey".equals(paramString1)) || ("reportRealtimeAction".equals(paramString1))) {
      if ("reportRealtimeAction".equals(paramString1)) {
        try
        {
          paramString1 = new JSONObject(new JSONObject(paramString2).optString("actionData", ""));
          if (paramString1 != null)
          {
            paramString1 = paramString1.optString("eventID", "");
            if (JSONUtil.isJson(paramString1))
            {
              localJSONObject = new JSONObject(paramString1);
              if ((localJSONObject != null) && (localJSONObject.has("finishShow")))
              {
                if (this.apkgInfo == null) {
                  break label882;
                }
                paramString1 = this.apkgInfo.appConfig;
                str = MiniProgramLpReportDC04239.getAppType(this.apkgInfo.appConfig);
                if (this.pageContainer != null) {
                  localObject = MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.pageContainer.appBrandRuntime);
                }
                MiniProgramLpReportDC04239.reportPageView(paramString1, str, (String)localObject, "finishshow", null);
                if (localJSONObject.length() == 1) {
                  return "";
                }
              }
            }
            else if (paramString1.equals("finishShow"))
            {
              if (this.apkgInfo != null) {}
              for (paramString1 = this.apkgInfo.appConfig;; paramString1 = null)
              {
                str = MiniProgramLpReportDC04239.getAppType(this.apkgInfo.appConfig);
                localObject = localJSONObject;
                if (this.pageContainer != null) {
                  localObject = MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this.pageContainer.appBrandRuntime);
                }
                MiniProgramLpReportDC04239.reportPageView(paramString1, str, (String)localObject, "finishshow", null);
                return "";
              }
            }
          }
          return "";
        }
        catch (Throwable paramString1)
        {
          QLog.e("AppBrandRuntime", 1, "reportRealtimeAction error", paramString1);
          if (this.apkgInfo != null) {
            MiniProgramLpReportDC04363.handleReportRealTimeAction(this.apkgInfo.appId, paramString2);
          }
        }
      }
    }
    if (this.mFinished) {
      return "";
    }
    if ("initWeixinJSBridgeFinish".equals(paramString1))
    {
      this.mWeixinJSBridgeFinished = true;
      QLog.i("AppBrandRuntime", 1, "WeixinJSBridge finished.");
      return "";
    }
    for (;;)
    {
      try
      {
        if (("redirectTo".equals(paramString1)) || ("navigateTo".equals(paramString1)) || ("navigateBack".equals(paramString1)) || ("switchTab".equals(paramString1)) || ("reLaunch".equals(paramString1)) || ("exitMiniProgram".equals(paramString1)))
        {
          localObject = str;
          if (this.apkgInfo != null) {
            localObject = this.apkgInfo.appConfig;
          }
          MiniReportManager.reportEventType((MiniAppConfig)localObject, 612, MiniProgramReportHelper.currentUrlFromAppBrandRuntime(this), null, null, 0);
        }
        if ("redirectTo".equals(paramString1))
        {
          localObject = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.10(this, (String)localObject, paramString1, paramInt));
          }
          return ApiUtil.wrapCallbackOk(paramString1, null).toString();
        }
        if ("navigateTo".equals(paramString1))
        {
          localObject = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (this.apkgInfo == null) {
              break label887;
            }
            bool = this.apkgInfo.isTabBarPage((String)localObject);
            if (bool) {
              return ApiUtil.wrapCallbackFail(paramString1, null).toString();
            }
            if (this.isResume)
            {
              this.isNavigateBeforeResume = false;
              AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.11(this, (String)localObject, paramString1, paramInt));
            }
          }
          else
          {
            return ApiUtil.wrapCallbackOk(paramString1, null).toString();
          }
          this.isNavigateBeforeResume = true;
          continue;
        }
        int i;
        paramString1 = null;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return "";
        if ("navigateBack".equals(paramString1))
        {
          i = new JSONObject(paramString2).optInt("delta", 0);
          if (i > 0) {
            AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.12(this, i, paramString1, paramInt));
          }
          return ApiUtil.wrapCallbackOk(paramString1, null).toString();
        }
        if ("switchTab".equals(paramString1))
        {
          localObject = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.13(this, (String)localObject, paramString1, paramInt));
          }
          return ApiUtil.wrapCallbackOk(paramString1, null).toString();
        }
        if ("reLaunch".equals(paramString1))
        {
          localObject = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.14(this, (String)localObject, paramString1, paramInt));
          }
          return ApiUtil.wrapCallbackOk(paramString1, null).toString();
        }
        if ("exitMiniProgram".equals(paramString1))
        {
          AppBrandTask.runTaskOnUiThread(new AppBrandRuntime.15(this));
          return handleNativeRequest(paramString1, paramString2, this.serviceRuntime, paramInt);
        }
        if ((!"updateApp".equals(paramString1)) || (this.newAppConfig == null)) {
          continue;
        }
        this.needReboot = true;
        this.newAppConfig.forceReroad = 1;
        this.newAppConfig.launchParam.scene = this.apkgInfo.appConfig.launchParam.scene;
        MiniAppController.startApp(null, this.newAppConfig, null);
        continue;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      label882:
      break;
      label887:
      boolean bool = false;
    }
  }
  
  public final void reload(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "reload. entryPath=" + paramString + " | " + this);
    }
    if (paramBoolean) {
      this.pageContainer.reportPageViewHide();
    }
    this.pageContainer.cleanup(false);
    onAppCreate(this.apkgInfo, paramString, true);
  }
  
  public void reportMiniAppEnd()
  {
    VACDReportUtil.endReport(this.mReportSeqNo, "MiniAppEnd", null, 0, null);
  }
  
  public void reportMiniAppStart()
  {
    ThreadManagerV2.excute(new AppBrandRuntime.6(this), 16, null, false);
  }
  
  public void setBootState(int paramInt)
  {
    this.bootState = paramInt;
  }
  
  public void setOpenMonitorPanel(boolean paramBoolean)
  {
    this.isOpenMonitorPanel = paramBoolean;
  }
  
  public String toString()
  {
    return "[appId=" + this.appId + ",versionType=" + this.versionType + ",isPause=" + this.isPause + ",mFinished=" + this.mFinished + "]";
  }
  
  public final void updateApkgInfo(ApkgInfo paramApkgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "updateApkgInfo. apkgInfo=" + paramApkgInfo + " | " + this);
    }
    if (paramApkgInfo != null) {
      this.apkgInfo = paramApkgInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */