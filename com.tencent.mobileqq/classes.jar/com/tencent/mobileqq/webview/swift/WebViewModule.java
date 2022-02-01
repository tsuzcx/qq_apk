package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class WebViewModule
  implements WebViewCallback
{
  private static final String TAG = "WebViewModule";
  protected AuthorizeConfig authConfig;
  public BrowserAppInterface browserApp;
  private Intent intent;
  public boolean isDestroyed;
  protected volatile boolean isSendWebSoRequest = false;
  public volatile AppInterface mApp;
  private Context mContext;
  protected int mCreateLoopNextStep = 1;
  protected final SwiftBrowserStateMachineScheduler mCreateLoopScheduler = new SwiftBrowserStateMachineScheduler(new WebViewModule.1(this));
  protected boolean mNightMode = false;
  protected volatile WebViewPluginEngine mPluginEngine;
  public String mRedirect302Url = "";
  private String mUrl = null;
  boolean redirectCookie = true;
  protected SonicClientImpl sonicClient;
  public String uin;
  public TouchWebView webView;
  WebViewWrapper webViewWrapper;
  
  public WebViewModule(@NotNull Intent paramIntent, Context paramContext)
  {
    this.mContext = paramContext;
    this.intent = paramIntent;
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    if ((!this.isDestroyed) && (this.webView != null))
    {
      Util.f("urlInterceptManager");
      SwiftWebViewUtils.b(paramString);
      Util.g("urlInterceptManager");
      return false;
    }
    return true;
  }
  
  void buildCookieForRedirect(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.b(paramString1);
      String str = SwiftBrowserCookieMonster.b(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.redirectCookie = false;
      }
      if (this.redirectCookie)
      {
        paramString1 = SwiftBrowserCookieMonster.c(paramString2);
        if (paramString1 != null)
        {
          paramString1.a(paramString2, null, null, this.intent);
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebViewModule", 1, paramString1, new Object[0]);
    }
  }
  
  public final WebViewWrapper createWebViewWrapper()
  {
    this.webViewWrapper = new WebViewWrapper(this.mApp, this, this.intent, this.mContext, false);
    this.webViewWrapper.a(this.sonicClient);
    TouchWebView localTouchWebView = this.webViewWrapper.c();
    SonicClientImpl localSonicClientImpl = this.sonicClient;
    if (localSonicClientImpl != null) {
      localSonicClientImpl.bindWebView(localTouchWebView);
    }
    this.mPluginEngine.a(localTouchWebView);
    localTouchWebView.setPluginEngine(this.mPluginEngine);
    if (this.mNightMode) {
      localTouchWebView.setMask(true);
    }
    return this.webViewWrapper;
  }
  
  void destroyWebView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "onDestroy");
    }
    this.isDestroyed = true;
    WebViewWrapper localWebViewWrapper = this.webViewWrapper;
    if (localWebViewWrapper != null)
    {
      localWebViewWrapper.b();
      this.webViewWrapper = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  protected boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    Object localObject = this.webView;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null) {
        return ((WebViewPluginEngine)localObject).a(this.webView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  protected int doCreateLoopStep_Final(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_FINAL");
    Util.f("Web_IPCSetup");
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
    }
    Util.g("Web_IPCSetup");
    SwiftBrowserIdleTaskHelper.a().a(new WebViewModule.4(this, 2));
    Util.g("Web_qqbrowser_state_machine_init_FINAL");
    Util.g("Web_qqbrowser_state_machine_all");
    this.mCreateLoopNextStep = 1;
    return -1;
  }
  
  protected int doCreateLoopStep_InitAppAndWebVieEngine(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.mApp instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)this.mApp);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(this.mApp.getApplication(), this.mApp);
    }
    this.uin = this.mApp.getAccount();
    ensurePluginEngineCreated();
    if (this.mPluginEngine != null)
    {
      this.mPluginEngine.a(this.intent.getStringArrayExtra("insertPluginsArray"));
      this.mPluginEngine.a(this.mUrl, 1L, null);
    }
    this.mCreateLoopNextStep = 16;
    Util.g("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    return 1;
  }
  
  protected int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected int doCreateLoopStep_InitWebView(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_webview");
    initWebView();
    Util.g("Web_qqbrowser_state_machine_init_webview");
    this.mCreateLoopNextStep = 32;
    return 0;
  }
  
  protected int doCreateLoopStep_InitX5Environment(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_x5_environment");
    this.mCreateLoopNextStep = 8;
    if (SwiftWebAccelerator.TbsAccelerator.a())
    {
      Util.g("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (SwiftWebAccelerator.TbsAccelerator.b())
    {
      Util.g("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    Util.g("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  protected int doCreateLoopStep_LoadUrl(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_load_url");
    System.currentTimeMillis();
    Util.f("Web_qqbrowser_init");
    startLoadUrl();
    Util.g("Web_qqbrowser_init");
    Util.g("Web_qqbrowser_state_machine_load_url");
    this.mCreateLoopNextStep = 1024;
    return 0;
  }
  
  void doWebSoRequest()
  {
    if (!this.isSendWebSoRequest)
    {
      this.isSendWebSoRequest = true;
      String str = this.intent.getStringExtra("url");
      if (WebSoUtils.b(str)) {
        ThreadManager.postImmediately(new WebViewModule.3(this, str), null, false);
      }
    }
  }
  
  void ensureCreateLoopFinished()
  {
    if (1 != this.mCreateLoopNextStep)
    {
      this.mCreateLoopScheduler.b();
      this.mCreateLoopScheduler.a();
      this.mCreateLoopScheduler.a(new Bundle());
    }
  }
  
  protected void ensurePluginEngineCreated()
  {
    synchronized (SwiftWebAccelerator.d)
    {
      if (WebViewPluginEngine.f != null)
      {
        this.mPluginEngine = WebViewPluginEngine.f;
        WebViewPluginEngine.f = null;
      }
      if (this.mPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewModule", 2, "-->web engine and plugin initialized at process preload!");
        }
        this.mPluginEngine.d();
        if (WebViewModulePluginBuilder.a(this.intent) != null)
        {
          ??? = WebViewModulePluginBuilder.a(this.intent);
          this.mPluginEngine.a(this.mApp, getActivity(), ((CommonJsPluginFactory)???).getCommonJsPlugin());
          WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, null);
        }
      }
      else
      {
        this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, getActivity(), null, WebViewModulePluginBuilder.a(this.intent), null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, getActivity());
        WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, null);
      }
      return;
    }
  }
  
  protected Activity getActivity()
  {
    return null;
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public String getUrlFromIntent()
  {
    String str2 = this.intent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.intent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  public void handlePreloadCallback(int paramInt, String paramString) {}
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  boolean initSonicSession(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initSonicSession url = :");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("WebViewModule", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject2 = new SonicSessionConfig.Builder();
        ((SonicSessionConfig.Builder)localObject2).setSessionMode(1);
        localObject1 = Uri.parse(paramString);
        if (((Uri)localObject1).isHierarchical())
        {
          localObject1 = ((Uri)localObject1).getQueryParameter("_sonic_xv");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            HashMap localHashMap = new HashMap();
            long l = Long.parseLong((String)localObject1);
            if ((0x2 & l) == 0L) {
              break label366;
            }
            bool = true;
            ((SonicSessionConfig.Builder)localObject2).setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label372;
            }
            i = 1;
            break label374;
            localHashMap.put("cache-offline", localObject1);
            ((SonicSessionConfig.Builder)localObject2).setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label394;
            }
            bool = true;
            ((SonicSessionConfig.Builder)localObject2).setSupportCacheControl(bool);
          }
        }
        localObject1 = WebAccelerateHelper.getSonicEngine();
        if (localObject1 != null)
        {
          localObject1 = ((SonicEngine)localObject1).createSession(paramString, ((SonicSessionConfig.Builder)localObject2).build());
          if (localObject1 != null)
          {
            this.sonicClient = new SonicClientImpl((SonicSession)localObject1);
            ((SonicSession)localObject1).bindClient(this.sonicClient);
            return true;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initSonicSession sonicSession = null, url = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("WebViewModule", 1, ((StringBuilder)localObject1).toString());
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initSonicSession sonicEngine = null, url = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("WebViewModule", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initSonicSession exception, url = ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("WebViewModule", 1, ((StringBuilder)localObject2).toString(), localException);
        return false;
      }
      label366:
      boolean bool = false;
      continue;
      label372:
      int i = 0;
      label374:
      String str;
      if (i != 0)
      {
        str = "store";
      }
      else
      {
        str = "true";
        continue;
        label394:
        bool = false;
      }
    }
  }
  
  protected void initWebView()
  {
    if (this.webView == null)
    {
      this.webView = createWebViewWrapper().c();
      System.currentTimeMillis();
      Object localObject = this.intent;
      int i = -1;
      int k = ((Intent)localObject).getIntExtra("reqType", -1);
      int j = 1;
      if (k != 1)
      {
        if (k == 4) {
          i = 0;
        }
      }
      else {
        i = 2;
      }
      if (AppSetting.h) {
        i = 2;
      }
      this.webView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setCacheMode=");
        ((StringBuilder)localObject).append(i);
        QLog.i("WebViewModule", 2, ((StringBuilder)localObject).toString());
      }
      this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      System.currentTimeMillis();
      long l1 = System.currentTimeMillis();
      localObject = this.webView.getX5WebViewExtension();
      if (localObject != null) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Bundle localBundle = SwiftWebViewUtils.c();
        if (localBundle != null) {
          ((IX5WebViewExtension)localObject).invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDomainsAndArgumentForImageRequest, cost=");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.i("WebViewModule", 2, ((StringBuilder)localObject).toString());
      }
      this.mPluginEngine.a(this.mUrl, 8589934623L, null);
    }
  }
  
  public void onCreate()
  {
    preInitData();
    doWebSoRequest();
    boolean bool;
    if (!this.intent.getBooleanExtra("key_is_init_sonic_session", true)) {
      bool = false;
    } else {
      bool = initSonicSession(getUrlFromIntent());
    }
    if (!bool) {
      ThreadManager.post(new WebViewModule.2(this), 5, null, true);
    }
    this.mNightMode = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    this.authConfig = AuthorizeConfig.a();
    this.isDestroyed = false;
    this.mCreateLoopNextStep = 2;
    if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.c > 0)) {
      this.mCreateLoopScheduler.a();
    }
    WebAccelerateHelper.isWebViewCache = true;
    this.mCreateLoopScheduler.a(new Bundle());
  }
  
  public void onDestroy()
  {
    if (1 != this.mCreateLoopNextStep)
    {
      this.mCreateLoopScheduler.b();
      this.mCreateLoopNextStep = 1;
    }
    Object localObject = this.sonicClient;
    if (localObject != null)
    {
      ((SonicClientImpl)localObject).destroy();
      this.sonicClient = null;
    }
    localObject = this.webView;
    if (localObject != null) {
      localObject = ((TouchWebView)localObject).getPluginEngine();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.webView.getUrl(), 8589934596L, null);
    }
    new Bundle().putString("url", this.mUrl);
    destroyWebView();
    if (QQBrowserActivity.sQQBrowserActivityCounter == 0)
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(BaseApplicationImpl.getApplication());
      com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry.h = -1;
    }
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null) {
      ReportController.b(null, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).d, ((ViewExposeUtil.ViewExposeUnit)localObject).d, ((ViewExposeUtil.ViewExposeUnit)localObject).e, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).c), "", "", "");
    }
    SwiftBrowserIdleTaskHelper.a().a(2);
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGeolocationPermissionsShowPrompt:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebViewModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.indexOf(':') == -1)
      {
        TouchWebView localTouchWebView = this.webView;
        localObject = paramString;
        if (localTouchWebView != null)
        {
          localObject = paramString;
          if (localTouchWebView.getX5WebViewExtension() != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https://");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("/");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    boolean bool2 = this.authConfig.a((String)localObject, "publicAccount.getLocation");
    paramString = this.webView;
    if (paramString != null) {
      paramString = Util.a(paramString.getUrl(), 2);
    } else {
      paramString = "";
    }
    boolean bool3 = ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).getLocationPermissionGrant(this.uin, paramString);
    boolean bool1;
    if ((bool3) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.uin, " urlHost:", paramString });
    }
    paramGeolocationPermissionsCallback.invoke((String)localObject, bool1, false);
  }
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!this.isDestroyed)
    {
      if (this.webView == null) {
        return;
      }
      ensureCreateLoopFinished();
      this.redirectCookie = false;
      SonicClientImpl localSonicClientImpl = this.sonicClient;
      if (localSonicClientImpl != null) {
        localSonicClientImpl.pageFinish(paramString);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.isDestroyed))
      {
        paramString = this.webViewWrapper;
        if ((paramString != null) && (paramString.d() != null)) {
          onReceivedTitle(paramWebView, paramWebView.getTitle());
        }
      }
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (!this.isDestroyed)
    {
      if (this.webView == null) {
        return;
      }
      ensureCreateLoopFinished();
    }
  }
  
  public void onPause()
  {
    dispatchPluginEvent(8589934597L, null);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!this.isDestroyed)
    {
      if (this.webView == null) {
        return;
      }
      ensureCreateLoopFinished();
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onResume()
  {
    TouchWebView localTouchWebView = this.webView;
    if (localTouchWebView != null) {
      localTouchWebView.onResume();
    }
    dispatchPluginEvent(2L, null);
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("X5 webkit detect 302 url: ");
      localStringBuilder.append(paramString2);
      QLog.i("WebViewModule", 2, localStringBuilder.toString());
    }
    this.mRedirect302Url = paramString2;
    SwiftBrowserCookieMonster.d();
    buildCookieForRedirect(paramString1, paramString2);
  }
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  void preInitData()
  {
    this.mUrl = getUrlFromIntent();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!this.isDestroyed)
    {
      if (this.webView == null) {
        return true;
      }
      if (!paramString.startsWith("http://")) {
        paramString.startsWith("https://");
      }
      if (((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (!paramString.startsWith("http://"))) {
        paramString.startsWith("https://");
      }
      String str = SwiftWebViewUtils.b(paramString);
      if (("http".equals(str)) || ("https".equals(str)))
      {
        paramWebView = paramWebView.getHitTestResult();
        if ((paramWebView != null) && (paramWebView.getType() == 0))
        {
          paramWebView = new StringBuilder();
          paramWebView.append("shouldOverrideUrlLoading detect 302, url: ");
          paramWebView.append(paramString);
          QLog.i("WebViewModule", 1, paramWebView.toString());
          paramWebView = this.mRedirect302Url;
          this.mRedirect302Url = paramString;
          SwiftBrowserCookieMonster.d();
          buildCookieForRedirect(paramWebView, this.mRedirect302Url);
        }
      }
      return false;
    }
    return true;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void startLoadUrl()
  {
    Util.f("Web_readyToLoadUrl");
    if (this.webView == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.mUrl)) {
      this.webView.loadUrl(this.mUrl);
    }
    Util.g("Web_readyToLoadUrl");
    if (this.webView.isPaused) {
      this.webView.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModule
 * JD-Core Version:    0.7.0.1
 */