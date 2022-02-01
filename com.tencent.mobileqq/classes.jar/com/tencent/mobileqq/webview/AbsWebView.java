package com.tencent.mobileqq.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.utils.WebStateReporter;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public abstract class AbsWebView
{
  public static final String TAG = "AbsWebView";
  public static final String WEBP_DECODER_VERSION_OF_X5 = " WebP/0.3.0";
  private CustomWebChromeClient mChromeClient;
  protected Context mContext;
  protected Activity mInActivity;
  protected AppRuntime mInterface;
  protected boolean mIsFirstOnPageStart = true;
  protected ProgressBar mLoadProgress;
  public WebViewProgressBar mLoadingProgressBar;
  protected boolean mPerfFirstLoadTag = true;
  protected WebViewPluginEngine mPluginEngine;
  public ArrayList<WebViewPlugin> mPluginList = null;
  public WebViewProgressBarController mProgressBarController;
  public long mRedirect302Time = -1L;
  public String mRedirect302Url = "";
  protected long mStartLoadUrlMilliTimeStamp;
  public WebStateReporter mStateReporter = new WebStateReporter();
  protected long mTimeBeforeLoadUrl = 0L;
  public String mUrl;
  private WebViewClient mWebViewClient;
  public TouchWebView mWebview;
  public JSONObject mX5PerformanceJson = null;
  private final Object sInitEngineLock = new Object();
  
  public AbsWebView(Context paramContext, Activity paramActivity, AppRuntime paramAppRuntime)
  {
    this.mContext = paramContext;
    this.mInActivity = paramActivity;
    this.mInterface = paramAppRuntime;
  }
  
  private void bindAllJavaScript()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "bindAllJavaScript");
    }
    long l = System.currentTimeMillis();
    Object localObject = this.mPluginList;
    if (localObject == null) {
      this.mPluginList = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    bindJavaScript(this.mPluginList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindAllJavaScript time = ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("AbsWebView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void bindWebChromeClient()
  {
    if (this.mChromeClient == null) {
      this.mChromeClient = new AbsWebView.5(this);
    }
    this.mWebview.setWebChromeClient(this.mChromeClient);
  }
  
  private void bindWebViewClient()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API Level >= 23");
      }
      this.mWebViewClient = new AbsWebView.3(this);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API level < 23");
      }
      this.mWebViewClient = new AbsWebView.4(this);
    }
    this.mWebview.setWebViewClient(this.mWebViewClient);
  }
  
  private void initWebView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "initWebView");
    }
    this.mWebview.setPluginEngine(this.mPluginEngine);
    this.mPluginEngine.a(this.mUrl, 1L, null);
    WebSettings localWebSettings = this.mWebview.getSettings();
    localObject1 = localWebSettings.getUserAgentString();
    Object localObject2 = getUAMark();
    boolean bool;
    if (this.mWebview.getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    localWebSettings.setUserAgentString(SwiftWebViewUtils.a((String)localObject1, (String)localObject2, bool));
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    localObject1 = this.mContext.getPackageManager();
    try
    {
      if (((PackageManager)localObject1).hasSystemFeature("android.hardware.touchscreen.multitouch")) {
        break label170;
      }
      bool = ((PackageManager)localObject1).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
      if (!bool) {}
    }
    catch (RuntimeException localRuntimeException)
    {
      try
      {
        int i;
        StringBuilder localStringBuilder;
        this.mWebview.requestFocus();
        this.mWebview.setFocusableInTouchMode(true);
        this.mWebview.setDownloadListener(new AbsWebView.2(this));
        CookieSyncManager.createInstance(this.mContext.getApplicationContext());
        if (this.mWebview.getX5WebViewExtension() == null) {
          break label538;
        }
        this.mWebview.getX5WebViewExtension().setWebViewClientExtension(new AbsWebView.DownloadQQBrowserExtension(this, this.mWebview));
        if (!this.mContext.getSharedPreferences("WebView_X5_Report", 4).getBoolean("enableX5Report", true)) {
          break label538;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("enabled", true);
        this.mWebview.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", (Bundle)localObject1);
        return;
        localRuntimeException = localRuntimeException;
      }
      catch (Exception localException)
      {
        break label414;
      }
    }
    i = 0;
    break label172;
    label170:
    i = 1;
    label172:
    localWebSettings.setDisplayZoomControls(i ^ 0x1);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localObject1 = MobileQQ.getMobileQQ().getQQProcessName();
    if (localObject1 != null)
    {
      i = ((String)localObject1).lastIndexOf(':');
      if (i > -1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(((String)localObject1).substring(i + 1));
        localObject1 = ((StringBuilder)localObject2).toString();
        break label282;
      }
    }
    localObject1 = "";
    label282:
    localObject2 = this.mContext.getApplicationContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("database");
    localStringBuilder.append((String)localObject1);
    localWebSettings.setDatabasePath(((Context)localObject2).getDir(localStringBuilder.toString(), 0).getPath());
    localObject2 = this.mContext.getApplicationContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("appcache");
    localStringBuilder.append((String)localObject1);
    localWebSettings.setAppCachePath(((Context)localObject2).getDir(localStringBuilder.toString(), 0).getPath());
    if (Build.VERSION.SDK_INT >= 11) {
      this.mWebview.removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList) {}
  
  protected final void buildBaseWebView(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "buildBaseWebView");
    }
    initPluginEngine();
    initWebView();
    bindWebViewClient();
    bindWebChromeClient();
  }
  
  public Object doInterceptRequest(WebView paramWebView, String paramString)
  {
    return null;
  }
  
  protected final void doOnBackPressed(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnBackPressed");
    }
    String str = this.mWebview.getUrl();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnBackPressed...url=");
      localStringBuilder.append(str);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    this.mStateReporter.a(this.mContext, paramAppRuntime.getLongAccountUin(), str, false);
  }
  
  protected final void doOnCreate(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnCreate");
    }
    this.mStateReporter.a(1);
    if (paramIntent != null)
    {
      this.mStateReporter.a(paramIntent.getStringExtra("key_service_id"));
      long l2 = paramIntent.getLongExtra("startOpenPageTime", -1L);
      long l1 = l2;
      if (-1L == l2) {
        l1 = System.currentTimeMillis();
      }
      this.mStateReporter.a(l1);
    }
  }
  
  protected final void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnDestroy");
    }
    Object localObject = this.mChromeClient;
    if (localObject != null) {
      ((CustomWebChromeClient)localObject).a();
    }
    localObject = this.mWebview;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null)
      {
        ((WebViewPluginEngine)localObject).a(this.mWebview.getUrl(), 8589934596L, null);
        ((WebViewPluginEngine)localObject).b();
      }
    }
    try
    {
      this.mWebview.stopLoading();
      label73:
      this.mWebview.loadUrlOriginal("about:blank");
      this.mWebview.clearView();
      this.mWebview.destroy();
      return;
    }
    catch (Exception localException)
    {
      break label73;
    }
  }
  
  protected final void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnPause");
    }
    Object localObject = this.mWebview;
    if (localObject != null)
    {
      ((TouchWebView)localObject).onPause();
      localObject = this.mWebview.getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.mWebview.getUrl(), 8589934597L, null);
      }
    }
  }
  
  protected final void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnResume");
    }
    Object localObject = this.mWebview;
    if (localObject != null)
    {
      ((TouchWebView)localObject).onResume();
      localObject = this.mWebview.getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.mWebview.getUrl(), 2L, null);
      }
    }
  }
  
  public long getStartLoadUrlMilliTimeStamp()
  {
    return this.mStartLoadUrlMilliTimeStamp;
  }
  
  public long getTimeBeforeLoadUrl()
  {
    return this.mTimeBeforeLoadUrl;
  }
  
  protected String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebview;
  }
  
  public void initPluginEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "initPluginEngine");
    }
    if (this.mPluginEngine != null) {
      return;
    }
    synchronized (this.sInitEngineLock)
    {
      if (this.mPluginEngine == null)
      {
        bindAllJavaScript();
        this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mInterface, this.mInActivity, null, myCommonJsPlugins(), this.mPluginList);
      }
      return;
    }
  }
  
  public boolean isIsFirstOnPageStart()
  {
    return this.mIsFirstOnPageStart;
  }
  
  public boolean isPerfFirstLoadTag()
  {
    return this.mPerfFirstLoadTag;
  }
  
  protected CommonJsPluginFactory myCommonJsPlugins()
  {
    return new CommonJsPluginFactory();
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback) {}
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return true;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public void onWebViewReady() {}
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  protected final void preInitPluginEngine()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "preInitPluginEngine");
    }
    if ((this.mPluginEngine == null) && (WebViewPluginEngine.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "use preloaded web engine!");
      }
      this.mPluginEngine = WebViewPluginEngine.a;
      WebViewPluginEngine.a = null;
      bindAllJavaScript();
      this.mPluginEngine.a(this.mInterface, this.mInActivity, this.mPluginList);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebAccelerateHelper.isWebViewCache:");
      localStringBuilder.append(WebAccelerateHelper.isWebViewCache);
      localStringBuilder.append(",mPluginEngine=");
      localStringBuilder.append(this.mPluginEngine);
      QLog.d("AbsWebView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new AbsWebView.1(this), null, false);
  }
  
  public void refresh()
  {
    this.mWebview.reload();
  }
  
  public void setIsFirstOnPageStart(boolean paramBoolean)
  {
    this.mIsFirstOnPageStart = paramBoolean;
  }
  
  public void setPerfFirstLoadTag(boolean paramBoolean)
  {
    this.mPerfFirstLoadTag = paramBoolean;
  }
  
  public void setStartLoadUrlMilliTimeStamp(long paramLong)
  {
    this.mStartLoadUrlMilliTimeStamp = paramLong;
  }
  
  public void setTimeBeforeLoadUrl(long paramLong)
  {
    this.mTimeBeforeLoadUrl = paramLong;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void showProgressBar(boolean paramBoolean)
  {
    ProgressBar localProgressBar = this.mLoadProgress;
    if (localProgressBar != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localProgressBar.setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView
 * JD-Core Version:    0.7.0.1
 */