package com.tencent.mobileqq.webview.swift;

import aknu;
import aknv;
import aknw;
import aknx;
import akny;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import mqq.app.MobileQQ;

public class WebViewWrapper
{
  public Activity a;
  public Intent a;
  CustomWebChromeClient jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  public TouchWebView a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public SonicClientImpl a;
  public WebViewCallback a;
  
  public WebViewWrapper(AppInterface paramAppInterface, Activity paramActivity, WebViewCallback paramWebViewCallback, Intent paramIntent, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback = paramWebViewCallback;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramAppInterface, paramActivity, paramIntent, paramBoolean);
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    aknv localaknv = new aknv(this);
    paramTouchWebView.setWebChromeClient(localaknv);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = localaknv;
  }
  
  public CustomWebChromeClient a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  }
  
  public TouchWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public TouchWebView a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    Util.a("Web_qqbrowser_init_only_webview");
    long l = System.currentTimeMillis();
    Object localObject1;
    if (paramBoolean) {
      localObject1 = SwiftReuseTouchWebView.a(paramActivity);
    }
    for (;;)
    {
      Object localObject3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      Object localObject2 = ((TouchWebView)localObject1).getLayoutParams();
      label63:
      WebSettings localWebSettings;
      if (localObject2 == null)
      {
        localObject2 = new ViewGroup.LayoutParams(((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
        ((TouchWebView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + (System.currentTimeMillis() - l));
        }
        ((TouchWebView)localObject1).setIntent(paramIntent);
        Util.b("Web_qqbrowser_init_only_webview");
        System.currentTimeMillis();
        a((TouchWebView)localObject1);
        b((TouchWebView)localObject1);
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        if ((BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("enableWebviewDebug", false)) && (Build.VERSION.SDK_INT >= 19)) {
          WebView.setWebContentsDebuggingEnabled(true);
        }
        Util.a("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        Util.a("Web_SetUserAgent");
        localObject2 = localWebSettings.getUserAgentString();
        localObject3 = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label670;
        }
        paramBoolean = true;
        label216:
        localWebSettings.setUserAgentString(SwiftWebViewUtils.a((String)localObject2, (String)localObject3, paramBoolean));
        Util.b("Web_SetUserAgent");
        localWebSettings.setSavePassword(false);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localObject2 = paramAppInterface.getApplication().getPackageManager();
      }
      try
      {
        if (!((PackageManager)localObject2).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          paramBoolean = ((PackageManager)localObject2).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!paramBoolean) {}
        }
        else
        {
          i = 1;
          label309:
          if (i != 0) {
            break label690;
          }
          paramBoolean = true;
          label317:
          localWebSettings.setDisplayZoomControls(paramBoolean);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str = MobileQQ.getMobileQQ().getProcessName();
          localObject3 = "";
          localObject2 = localObject3;
          if (str != null)
          {
            i = str.lastIndexOf(':');
            localObject2 = localObject3;
            if (i > -1) {
              localObject2 = "_" + str.substring(i + 1);
            }
          }
          localWebSettings.setDatabasePath(paramAppInterface.getApplication().getApplicationContext().getDir("database" + (String)localObject2, 0).getPath());
          localWebSettings.setAppCachePath(paramAppInterface.getApplication().getApplicationContext().getDir("appcache" + (String)localObject2, 0).getPath());
          localWebSettings.setMediaPlaybackRequiresUserGesture(false);
          if (Build.VERSION.SDK_INT >= 11) {
            ((TouchWebView)localObject1).removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          int i;
          ((TouchWebView)localObject1).requestFocus();
          label539:
          paramBoolean = paramIntent.getBooleanExtra("fromArkAppDownload", false);
          ((TouchWebView)localObject1).setFocusableInTouchMode(true);
          ((TouchWebView)localObject1).setDownloadListener(new aknu(this, (TouchWebView)localObject1, paramBoolean, paramActivity));
          CookieSyncManager.createInstance(paramAppInterface.getApplication().getApplicationContext());
          if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
          {
            ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new akny(this, (TouchWebView)localObject1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewCallback));
            AIOOpenWebMonitor.b(paramIntent, "use_x5", "1");
          }
          for (;;)
          {
            Util.b("Web_AdjustSettings");
            return localObject1;
            localObject1 = new TouchWebView(paramActivity);
            break;
            ((ViewGroup.LayoutParams)localObject2).width = ((DisplayMetrics)localObject3).widthPixels;
            ((ViewGroup.LayoutParams)localObject2).height = ((DisplayMetrics)localObject3).heightPixels;
            break label63;
            label670:
            paramBoolean = false;
            break label216;
            i = 0;
            break label309;
            localRuntimeException = localRuntimeException;
            i = 0;
            break label309;
            label690:
            paramBoolean = false;
            break label317;
            AIOOpenWebMonitor.b(paramIntent, "use_x5", "2");
          }
        }
        catch (Exception localException)
        {
          break label539;
        }
      }
    }
  }
  
  String a(WebViewCallback paramWebViewCallback)
  {
    if (paramWebViewCallback != null) {
      return paramWebViewCallback.a();
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
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
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
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.a("about:blank");
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
    for (Object localObject = new aknw(this);; localObject = new aknx(this))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper
 * JD-Core Version:    0.7.0.1
 */