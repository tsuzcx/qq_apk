package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WebViewWrapper
{
  public long a;
  protected Intent a;
  protected CustomWebChromeClient a;
  protected TouchWebView a;
  protected SonicClientImpl a;
  private IWebViewWrapperInjector a;
  protected WebViewCallback a;
  protected AppRuntime a;
  
  public WebViewWrapper(AppRuntime paramAppRuntime, WebViewCallback paramWebViewCallback, Intent paramIntent, Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = paramWebViewCallback;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramContext, paramBoolean);
    a();
    a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramAppRuntime, paramIntent);
  }
  
  public WebViewWrapper(AppRuntime paramAppRuntime, WebViewCallback paramWebViewCallback, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = paramWebViewCallback;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    a();
    paramWebViewCallback = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (paramWebViewCallback != null) {
      a(paramWebViewCallback, paramAppRuntime, paramIntent);
    }
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    WebViewWrapper.1 local1 = new WebViewWrapper.1(this);
    paramTouchWebView.setWebChromeClient(local1);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = local1;
  }
  
  public CustomWebChromeClient a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  }
  
  public TouchWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public TouchWebView a(Context paramContext, boolean paramBoolean)
  {
    Util.a("Web_qqbrowser_init_only_webview");
    long l = System.currentTimeMillis();
    if (paramBoolean) {
      paramContext = SwiftReuseTouchWebView.a(paramContext);
    } else {
      paramContext = new TouchWebView(paramContext);
    }
    DisplayMetrics localDisplayMetrics = MobileQQ.getContext().getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = paramContext.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new ViewGroup.LayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    }
    else
    {
      localLayoutParams.width = localDisplayMetrics.widthPixels;
      localLayoutParams.height = localDisplayMetrics.heightPixels;
    }
    paramContext.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    return paramContext;
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    l1 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createWebView TouchWebView cost = ");
      ((StringBuilder)localObject1).append(l1);
      QLog.d("WebLog_WebViewWrapper", 2, ((StringBuilder)localObject1).toString());
    }
    paramTouchWebView.setIntent(paramIntent);
    Util.b("Web_qqbrowser_init_only_webview");
    l2 = System.currentTimeMillis();
    a(paramTouchWebView);
    b(paramTouchWebView);
    l3 = System.currentTimeMillis();
    paramTouchWebView.setScrollBarStyle(0);
    Util.a("Web_AdjustSettings");
    WebSettings localWebSettings = paramTouchWebView.getSettings();
    Util.a("Web_SetUserAgent");
    Object localObject1 = localWebSettings.getUserAgentString();
    Object localObject2 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback);
    boolean bool;
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    localWebSettings.setUserAgentString(SwiftWebViewUtils.a((String)localObject1, (String)localObject2, bool));
    Util.b("Web_SetUserAgent");
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    localObject1 = paramAppRuntime.getApplication().getPackageManager();
    try
    {
      if (((PackageManager)localObject1).hasSystemFeature("android.hardware.touchscreen.multitouch")) {
        break label231;
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
        long l4;
        paramTouchWebView.requestFocus();
        paramTouchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(paramAppRuntime.getApplication().getApplicationContext());
        if (paramTouchWebView.getX5WebViewExtension() == null) {
          break label566;
        }
        paramTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new WebViewWrapper.DownloadQQBrowserExtension(this, paramTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback));
        BaseOpenWebMonitor.b(paramIntent, "use_x5", "1");
        break label576;
        BaseOpenWebMonitor.b(paramIntent, "use_x5", "2");
        if (!SwiftBrowserStatistics.u) {
          break label688;
        }
        paramAppRuntime = new HashMap(5);
        paramAppRuntime.put("createWebview", String.valueOf(l1));
        paramAppRuntime.put("initWebClient", String.valueOf(l3 - l2));
        paramAppRuntime.put("setWebSetting", String.valueOf(l4 - l2));
        paramAppRuntime.put("coreInit", String.valueOf(SwiftWebAccelerator.TbsAccelerator.jdField_a_of_type_Long));
        paramAppRuntime.put("coldStart", String.valueOf(SwiftBrowserStatistics.p));
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(null, "actWebviewInit", true, 0L, 0L, paramAppRuntime, null);
        if (!QLog.isColorLevel()) {
          break label734;
        }
        QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(SwiftBrowserStatistics.u), " cost:", Long.valueOf(SwiftWebAccelerator.TbsAccelerator.jdField_a_of_type_Long) });
        Util.b("Web_AdjustSettings");
        return paramTouchWebView;
        localRuntimeException = localRuntimeException;
      }
      catch (Exception localException)
      {
        break label508;
      }
    }
    i = 0;
    break label234;
    label231:
    i = 1;
    label234:
    localWebSettings.setDisplayZoomControls(i ^ 0x1);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localObject1 = MobileQQ.sMobileQQ.getQQProcessName();
    if (localObject1 != null)
    {
      i = ((String)localObject1).lastIndexOf(':');
      if (i > -1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(((String)localObject1).substring(i + 1));
        localObject1 = ((StringBuilder)localObject2).toString();
        break label355;
      }
    }
    localObject1 = "";
    label355:
    localObject2 = paramAppRuntime.getApplication().getApplicationContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("database");
    localStringBuilder.append((String)localObject1);
    localWebSettings.setDatabasePath(((Context)localObject2).getDir(localStringBuilder.toString(), 0).getPath());
    localObject2 = paramAppRuntime.getApplication().getApplicationContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("appcache");
    localStringBuilder.append((String)localObject1);
    localWebSettings.setAppCachePath(((Context)localObject2).getDir(localStringBuilder.toString(), 0).getPath());
    localWebSettings.setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 21) {
      localWebSettings.setMixedContentMode(0);
    }
    l4 = System.currentTimeMillis();
    if (Build.VERSION.SDK_INT >= 11) {
      paramTouchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  String a(WebViewCallback paramWebViewCallback)
  {
    if (paramWebViewCallback != null) {
      return paramWebViewCallback.getUAMark();
    }
    return null;
  }
  
  protected void a()
  {
    try
    {
      if ((WebViewWrapperInjectorUtil.a != null) && (WebViewWrapperInjectorUtil.a.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftIWebViewWrapperInjector = ((IWebViewWrapperInjector)((Class)WebViewWrapperInjectorUtil.a.get(0)).newInstance());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebLog_WebViewWrapper", 1, "registerInjector Fail,", localThrowable);
    }
  }
  
  void a(TouchWebView paramTouchWebView)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = new WebViewWrapper.2(this);
    } else {
      localObject = new WebViewWrapper.3(this);
    }
    paramTouchWebView.setWebViewClient((WebViewClient)localObject);
  }
  
  public void a(SonicClientImpl paramSonicClientImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = paramSonicClientImpl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSonicClient sonicClient = ");
    localStringBuilder.append(paramSonicClientImpl);
    QLog.i("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).b();
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setPluginEngine(null);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent() == null) {}
    }
    try
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
        if (localObject == null) {
          break label141;
        }
        ((CustomWebChromeClient)localObject).a();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = null;
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label94;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper
 * JD-Core Version:    0.7.0.1
 */