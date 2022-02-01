package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
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
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.theme.ThemeUtil;
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
import com.tencent.smtt.sdk.QbSdk;
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
import org.json.JSONException;
import org.json.JSONObject;

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
    if ((this.isDestroyed) || (this.webView == null)) {
      return true;
    }
    Util.a("urlInterceptManager");
    SwiftWebViewUtils.a(paramString);
    Util.b("urlInterceptManager");
    return false;
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
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null) {
          paramString1.a(paramString2, null, null, this.intent);
        }
      }
      return;
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
    TouchWebView localTouchWebView = this.webViewWrapper.a();
    if (this.sonicClient != null) {
      this.sonicClient.bindWebView(localTouchWebView);
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
    if (this.webViewWrapper != null)
    {
      this.webViewWrapper.a();
      this.webViewWrapper = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  protected boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.webView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.webView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.webView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  protected int doCreateLoopStep_Final(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_FINAL");
    Util.a("Web_IPCSetup");
    if (!WebIPCOperator.a().a()) {
      WebIPCOperator.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    Util.b("Web_IPCSetup");
    SwiftBrowserIdleTaskHelper.a().a(new WebViewModule.4(this, 2));
    Util.b("Web_qqbrowser_state_machine_init_FINAL");
    Util.b("Web_qqbrowser_state_machine_all");
    this.mCreateLoopNextStep = 1;
    return -1;
  }
  
  protected int doCreateLoopStep_InitAppAndWebVieEngine(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
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
    Util.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    return 1;
  }
  
  protected int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    i = 1;
    Util.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("5105");
    paramBundle = this.intent.getStringExtra("options");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.intent.putExtra("url", paramBundle.getString("url"));
      if (!this.intent.hasExtra("key_isReadModeEnabled")) {
        this.intent.putExtra("key_isReadModeEnabled", true);
      }
      this.intent.putExtra("ba_is_login", paramBundle.optBoolean("ba_is_login", true));
      this.intent.putExtra("isShowAd", paramBundle.optBoolean("isShowAd", true));
      this.intent.putExtra("avoidLoginWeb", paramBundle.optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        boolean bool;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.d("WebViewModule", 2, paramBundle.toString());
          continue;
          i = 0;
        }
      }
    }
    new StringBuilder().append(Build.MANUFACTURER).append("_").append(Build.MODEL).toString();
    bool = this.intent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    j = hashCode();
    if (bool)
    {
      ViewExposeUtil.a(paramBundle, j, i, this.mUrl);
      Util.b("Web_qqbrowser_state_machine_init_data");
      this.mCreateLoopNextStep = 4;
      return 0;
    }
  }
  
  protected int doCreateLoopStep_InitWebView(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_webview");
    initWebView();
    Util.b("Web_qqbrowser_state_machine_init_webview");
    this.mCreateLoopNextStep = 32;
    return 0;
  }
  
  protected int doCreateLoopStep_InitX5Environment(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_x5_environment");
    this.mCreateLoopNextStep = 8;
    if (SwiftWebAccelerator.TbsAccelerator.a())
    {
      Util.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (SwiftWebAccelerator.TbsAccelerator.b())
    {
      Util.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    Util.b("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  protected int doCreateLoopStep_LoadUrl(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_load_url");
    System.currentTimeMillis();
    Util.a("Web_qqbrowser_init");
    startLoadUrl();
    Util.b("Web_qqbrowser_init");
    Util.b("Web_qqbrowser_state_machine_load_url");
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
      int i = this.mCreateLoopNextStep;
      this.mCreateLoopScheduler.b();
      this.mCreateLoopScheduler.a();
      this.mCreateLoopScheduler.a(new Bundle());
    }
  }
  
  protected void ensurePluginEngineCreated()
  {
    synchronized (SwiftWebAccelerator.a)
    {
      if (WebViewPluginEngine.a != null)
      {
        this.mPluginEngine = WebViewPluginEngine.a;
        WebViewPluginEngine.a = null;
      }
      if (this.mPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewModule", 2, "-->web engine and plugin initialized at process preload!");
        }
        this.mPluginEngine.b();
        if (WebViewModulePluginBuilder.a(this.intent) != null)
        {
          ??? = WebViewModulePluginBuilder.a(this.intent);
          this.mPluginEngine.a(this.mApp, getActivity(), ((CommonJsPluginFactory)???).getCommonJsPlugin());
          WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, null);
        }
        return;
      }
    }
    this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, getActivity(), null, WebViewModulePluginBuilder.a(this.intent), null);
    WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, getActivity());
    WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, null);
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
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "initSonicSession url = :" + paramString);
    }
    for (;;)
    {
      int i;
      try
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        Object localObject = Uri.parse(paramString);
        if (((Uri)localObject).isHierarchical())
        {
          localObject = ((Uri)localObject).getQueryParameter("_sonic_xv");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            HashMap localHashMap = new HashMap();
            long l = Long.parseLong((String)localObject);
            if ((0x2 & l) == 0L) {
              break label332;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label338;
            }
            i = 1;
            break label320;
            label137:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label351;
            }
            bool = true;
            localBuilder.setSupportCacheControl(bool);
          }
        }
        localObject = WebAccelerateHelper.getSonicEngine();
        if (localObject != null)
        {
          localObject = ((SonicEngine)localObject).createSession(paramString, localBuilder.build());
          if (localObject != null)
          {
            this.sonicClient = new SonicClientImpl((SonicSession)localObject);
            ((SonicSession)localObject).bindClient(this.sonicClient);
            return true;
          }
          QLog.d("WebViewModule", 1, "initSonicSession sonicSession = null, url = " + paramString);
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("WebViewModule", 1, "initSonicSession exception, url = " + paramString, localException);
        return false;
      }
      QLog.d("WebViewModule", 1, "initSonicSession sonicEngine = null, url = " + paramString);
      return false;
      for (;;)
      {
        label320:
        if (i == 0) {
          break label343;
        }
        str = "store";
        break label137;
        label332:
        bool = false;
        break;
        label338:
        i = 0;
      }
      label343:
      String str = "true";
      continue;
      label351:
      boolean bool = false;
    }
  }
  
  protected void initWebView()
  {
    int k = -1;
    int j = 0;
    int i;
    if (this.webView == null)
    {
      this.webView = createWebViewWrapper().a();
      System.currentTimeMillis();
      i = k;
      switch (this.intent.getIntExtra("reqType", -1))
      {
      default: 
        i = k;
      }
    }
    for (;;)
    {
      if (AppSetting.g) {
        i = 2;
      }
      this.webView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebViewModule", 2, "setCacheMode=" + i);
      }
      this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      System.currentTimeMillis();
      long l1 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.webView.getX5WebViewExtension();
      i = j;
      if (localIX5WebViewExtension != null) {
        i = 1;
      }
      if (i != 0)
      {
        Bundle localBundle = SwiftWebViewUtils.a();
        if (localBundle != null) {
          localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebViewModule", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l2 - l1));
      }
      this.mPluginEngine.a(this.mUrl, 8589934623L, null);
      return;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public void onCreate()
  {
    preInitData();
    doWebSoRequest();
    if (!this.intent.getBooleanExtra("key_is_init_sonic_session", true)) {}
    for (boolean bool = false;; bool = initSonicSession(getUrlFromIntent()))
    {
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
      return;
    }
  }
  
  public void onDestroy()
  {
    if (1 != this.mCreateLoopNextStep)
    {
      this.mCreateLoopScheduler.b();
      this.mCreateLoopNextStep = 1;
    }
    if (this.sonicClient != null)
    {
      this.sonicClient.destroy();
      this.sonicClient = null;
    }
    if (this.webView != null) {}
    for (Object localObject = this.webView.getPluginEngine();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.webView.getUrl(), 8589934596L, null);
      }
      new Bundle().putString("url", this.mUrl);
      destroyWebView();
      if (QQBrowserActivity.sQQBrowserActivityCounter == 0)
      {
        WebIPCOperator.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry.d = -1;
      }
      localObject = ViewExposeUtil.a(getClass(), hashCode());
      if (localObject != null) {
        ReportController.b(null, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).b), "", "", "");
      }
      SwiftBrowserIdleTaskHelper.a().a(2);
      return;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.webView != null)
        {
          str = paramString;
          if (this.webView.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    boolean bool2 = this.authConfig.a(str, "publicAccount.getLocation");
    if (this.webView != null) {}
    for (paramString = Util.a(this.webView.getUrl(), 2);; paramString = "")
    {
      boolean bool3 = ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).getLocationPermissionGrant(this.uin, paramString);
      if ((bool3) && (bool2)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewModule", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.uin, " urlHost:", paramString });
        }
        paramGeolocationPermissionsCallback.invoke(str, bool1, false);
        return;
      }
    }
  }
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.webView == null)) {}
    do
    {
      return;
      ensureCreateLoopFinished();
      this.redirectCookie = false;
      if (this.sonicClient != null) {
        this.sonicClient.pageFinish(paramString);
      }
    } while ((Build.VERSION.SDK_INT < 19) || (this.isDestroyed) || (this.webViewWrapper == null) || (this.webViewWrapper.a() == null));
    onReceivedTitle(paramWebView, paramWebView.getTitle());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return;
    }
    ensureCreateLoopFinished();
  }
  
  public void onPause()
  {
    dispatchPluginEvent(8589934597L, null);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return;
    }
    ensureCreateLoopFinished();
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onResume()
  {
    if (this.webView != null) {
      this.webView.onResume();
    }
    dispatchPluginEvent(2L, null);
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebViewModule", 2, "X5 webkit detect 302 url: " + paramString2);
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
    if ((this.isDestroyed) || (this.webView == null)) {
      return true;
    }
    if (((paramString.startsWith("http://")) || (!paramString.startsWith("https://"))) || (((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (!paramString.startsWith("http://")) && (paramString.startsWith("https://")))) {}
    String str = SwiftWebViewUtils.a(paramString);
    if (("http".equals(str)) || ("https".equals(str)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebViewModule", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        paramWebView = this.mRedirect302Url;
        this.mRedirect302Url = paramString;
        SwiftBrowserCookieMonster.d();
        buildCookieForRedirect(paramWebView, this.mRedirect302Url);
      }
    }
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void startLoadUrl()
  {
    Util.a("Web_readyToLoadUrl");
    if (this.webView == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.mUrl)) {
        this.webView.loadUrl(this.mUrl);
      }
      Util.b("Web_readyToLoadUrl");
    } while (!this.webView.isPaused);
    this.webView.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewModule
 * JD-Core Version:    0.7.0.1
 */