package com.tencent.mobileqq.teamwork;

import android.app.Activity;
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
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewCallback;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewWrapperWithActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WebViewWrapperForDoc
  extends WebViewWrapperWithActivity
{
  public boolean a;
  
  public WebViewWrapperForDoc(AppRuntime paramAppRuntime, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppRuntime, paramActivity, paramWebViewCallback, paramIntent, paramBoolean);
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    WebViewWrapperForDoc.1 local1 = new WebViewWrapperForDoc.1(this);
    paramTouchWebView.setWebChromeClient(local1);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = local1;
  }
  
  public TouchWebView a(Context paramContext, boolean paramBoolean)
  {
    Util.a("Web_qqbrowser_init_only_webview");
    long l = System.currentTimeMillis();
    if (TenDocWebPreLoadHelper.a(paramContext, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url")))
    {
      localObject1 = TenDocWebPreLoadHelper.a(paramContext);
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (paramBoolean) {
        localObject1 = SwiftReuseTouchWebView.a(paramContext);
      } else {
        localObject1 = new TouchWebView(paramContext);
      }
    }
    Object localObject2 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
    paramContext = ((TouchWebView)localObject1).getLayoutParams();
    if (paramContext == null)
    {
      paramContext = new ViewGroup.LayoutParams(((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
    }
    else
    {
      paramContext.width = ((DisplayMetrics)localObject2).widthPixels;
      paramContext.height = ((DisplayMetrics)localObject2).heightPixels;
    }
    ((TouchWebView)localObject1).setLayoutParams(paramContext);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    return localObject1;
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
    boolean bool = TencentDocPreloadConfigProcessor.a().a();
    Object localObject2 = "";
    if (bool) {
      localObject1 = " _tdocFlag/1";
    } else {
      localObject1 = "";
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("tendocpreload get UA");
    IGetExternalInterface localIGetExternalInterface = (IGetExternalInterface)QRoute.api(IGetExternalInterface.class);
    String str1 = localWebSettings.getUserAgentString();
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback);
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject3).append(localIGetExternalInterface.getWebViewUAForQQ(str1, str2, bool));
    QLog.i("WebLog_WebViewWrapper", 1, ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    localIGetExternalInterface = (IGetExternalInterface)QRoute.api(IGetExternalInterface.class);
    str1 = localWebSettings.getUserAgentString();
    str2 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback);
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject3).append(localIGetExternalInterface.getWebViewUAForQQ(str1, str2, bool));
    ((StringBuilder)localObject3).append((String)localObject1);
    localWebSettings.setUserAgentString(((StringBuilder)localObject3).toString());
    Util.b("Web_SetUserAgent");
    localWebSettings.setSavePassword(false);
    localWebSettings.setSaveFormData(false);
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setPluginState(WebSettings.PluginState.ON);
    Object localObject1 = paramAppRuntime.getApplication().getPackageManager();
    try
    {
      if (((PackageManager)localObject1).hasSystemFeature("android.hardware.touchscreen.multitouch")) {
        break label393;
      }
      bool = ((PackageManager)localObject1).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
      if (!bool) {}
    }
    catch (RuntimeException localRuntimeException)
    {
      try
      {
        int i;
        long l4;
        paramTouchWebView.requestFocus();
        paramTouchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(paramAppRuntime.getApplication().getApplicationContext());
        if (paramTouchWebView.getX5WebViewExtension() == null) {
          break label732;
        }
        paramTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new WebViewWrapperForDoc.DownloadQQBrowserExtension(this, paramTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback));
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).addAioParamForX5(paramIntent);
        break label746;
        ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).addAioParamForSystem(paramIntent);
        Util.b("Web_AdjustSettings");
        if (!((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getReportPerformance()) {
          break label893;
        }
        paramAppRuntime = new HashMap(5);
        paramAppRuntime.put("createWebview", String.valueOf(l1));
        paramAppRuntime.put("initWebClient", String.valueOf(l3 - l2));
        paramAppRuntime.put("setWebSetting", String.valueOf(l4 - l2));
        paramAppRuntime.put("coreInit", String.valueOf(((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getWebAcceleratorCostTime()));
        paramAppRuntime.put("coldStart", String.valueOf(((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getPreloadWebProcess()));
        StatisticCollector.getInstance(MobileQQ.getContext().getApplicationContext()).collectPerformance(null, "actWebviewInit", true, 0L, 0L, paramAppRuntime, null);
        if (!QLog.isColorLevel()) {
          break label959;
        }
        QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getReportPerformance()), " cost:", Long.valueOf(((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getWebAcceleratorCostTime()) });
        return paramTouchWebView;
        localRuntimeException = localRuntimeException;
      }
      catch (Exception localException)
      {
        break label670;
      }
    }
    i = 0;
    break label396;
    label393:
    i = 1;
    label396:
    localWebSettings.setDisplayZoomControls(i ^ 0x1);
    localWebSettings.setPluginsEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setAllowContentAccess(true);
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCacheEnabled(true);
    localObject3 = MobileQQ.getMobileQQ().getQQProcessName();
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      i = ((String)localObject3).lastIndexOf(':');
      localObject1 = localObject2;
      if (i > -1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(((String)localObject3).substring(i + 1));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    localObject2 = paramAppRuntime.getApplication().getApplicationContext();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("database");
    ((StringBuilder)localObject3).append((String)localObject1);
    localWebSettings.setDatabasePath(((Context)localObject2).getDir(((StringBuilder)localObject3).toString(), 0).getPath());
    localObject2 = paramAppRuntime.getApplication().getApplicationContext();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("appcache");
    ((StringBuilder)localObject3).append((String)localObject1);
    localWebSettings.setAppCachePath(((Context)localObject2).getDir(((StringBuilder)localObject3).toString(), 0).getPath());
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
  
  protected void a() {}
  
  void a(TouchWebView paramTouchWebView)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = new WebViewWrapperForDoc.2(this);
    } else {
      localObject = new WebViewWrapperForDoc.3(this);
    }
    paramTouchWebView.setWebViewClient((WebViewClient)localObject);
  }
  
  public void b()
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
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
        if (!this.jdField_a_of_type_Boolean) {
          break label115;
        }
        TenDocWebViewPool.a().a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        break label139;
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
        this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient == null) {
          break label163;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = null;
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label95;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.WebViewWrapperForDoc
 * JD-Core Version:    0.7.0.1
 */