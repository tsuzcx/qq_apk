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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WebViewWrapper
{
  public long a;
  Intent jdField_a_of_type_AndroidContentIntent;
  CustomWebChromeClient jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  private IWebViewWrapperInjector jdField_a_of_type_ComTencentMobileqqWebviewSwiftIWebViewWrapperInjector;
  WebViewCallback jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public WebViewWrapper(AppRuntime paramAppRuntime, WebViewCallback paramWebViewCallback, Intent paramIntent, Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramContext, paramBoolean);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = paramWebViewCallback;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    b();
    a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramAppRuntime, paramIntent);
  }
  
  public WebViewWrapper(AppRuntime paramAppRuntime, WebViewCallback paramWebViewCallback, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = paramWebViewCallback;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    b();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramAppRuntime, paramIntent);
    }
  }
  
  private void b()
  {
    try
    {
      if ((WebViewWrapperInjectorUtil.a != null) && (WebViewWrapperInjectorUtil.a.size() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftIWebViewWrapperInjector = ((IWebViewWrapperInjector)((Class)WebViewWrapperInjectorUtil.a.get(0)).newInstance());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebLog_WebViewWrapper", 1, "registerInjector Fail,", localThrowable);
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
    DisplayMetrics localDisplayMetrics;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      paramContext = SwiftReuseTouchWebView.a(paramContext);
      localDisplayMetrics = MobileQQ.getContext().getResources().getDisplayMetrics();
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams != null) {
        break label88;
      }
      localLayoutParams = new ViewGroup.LayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    }
    for (;;)
    {
      paramContext.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      return paramContext;
      paramContext = new TouchWebView(paramContext);
      break;
      label88:
      localLayoutParams.width = localDisplayMetrics.widthPixels;
      localLayoutParams.height = localDisplayMetrics.heightPixels;
    }
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    long l1 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + l1);
    }
    paramTouchWebView.setIntent(paramIntent);
    Util.b("Web_qqbrowser_init_only_webview");
    long l2 = System.currentTimeMillis();
    a(paramTouchWebView);
    b(paramTouchWebView);
    long l3 = System.currentTimeMillis();
    paramTouchWebView.setScrollBarStyle(0);
    Util.a("Web_AdjustSettings");
    WebSettings localWebSettings = paramTouchWebView.getSettings();
    Util.a("Web_SetUserAgent");
    Object localObject = (IWebviewApi)QRoute.api(IWebviewApi.class);
    String str1 = localWebSettings.getUserAgentString();
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback);
    boolean bool;
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      localWebSettings.setUserAgentString(((IWebviewApi)localObject).getQUA(str1, str2, bool));
      Util.b("Web_SetUserAgent");
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localObject = paramAppRuntime.getApplication().getPackageManager();
      int i = 0;
      try
      {
        if (!((PackageManager)localObject).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = ((PackageManager)localObject).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {
            break label563;
          }
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        label228:
        long l4;
        break label228;
      }
      if (i == 0)
      {
        bool = true;
        localWebSettings.setDisplayZoomControls(bool);
        localWebSettings.setPluginsEnabled(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        str2 = MobileQQ.sMobileQQ.getQQProcessName();
        str1 = "";
        localObject = str1;
        if (str2 != null)
        {
          i = str2.lastIndexOf(':');
          localObject = str1;
          if (i > -1) {
            localObject = "_" + str2.substring(i + 1);
          }
        }
        localWebSettings.setDatabasePath(paramAppRuntime.getApplication().getApplicationContext().getDir("database" + (String)localObject, 0).getPath());
        localWebSettings.setAppCachePath(paramAppRuntime.getApplication().getApplicationContext().getDir("appcache" + (String)localObject, 0).getPath());
        localWebSettings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 21) {
          localWebSettings.setMixedContentMode(0);
        }
        l4 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11) {
          paramTouchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
      }
      try
      {
        paramTouchWebView.requestFocus();
        label475:
        paramTouchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(paramAppRuntime.getApplication().getApplicationContext());
        if (paramTouchWebView.getX5WebViewExtension() != null) {
          paramTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new WebViewWrapper.DownloadQQBrowserExtension(this, paramTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback));
        }
        Util.b("Web_AdjustSettings");
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftIWebViewWrapperInjector != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftIWebViewWrapperInjector.a(paramTouchWebView, paramIntent, l1, l3 - l2, l4 - l2);
        }
        return paramTouchWebView;
        bool = false;
        continue;
        label563:
        i = 0;
        break label228;
        bool = false;
      }
      catch (Exception localException)
      {
        break label475;
      }
    }
  }
  
  String a(WebViewCallback paramWebViewCallback)
  {
    if (paramWebViewCallback != null) {
      return paramWebViewCallback.getUAMark();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.b();
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
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
          label77:
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a();
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = null;
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
          }
        }
      }
      catch (Exception localException2)
      {
        break label77;
      }
    }
  }
  
  void a(TouchWebView paramTouchWebView)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = new WebViewWrapper.2(this);; localObject = new WebViewWrapper.3(this))
    {
      paramTouchWebView.setWebViewClient((WebViewClient)localObject);
      return;
    }
  }
  
  public void a(SonicClientImpl paramSonicClientImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = paramSonicClientImpl;
    QLog.i("WebLog_WebViewWrapper", 1, "setSonicClient sonicClient = " + paramSonicClientImpl);
  }
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper
 * JD-Core Version:    0.7.0.1
 */