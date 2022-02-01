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
  private IWebViewWrapperInjector a;
  protected AppRuntime b;
  protected WebViewCallback c;
  protected TouchWebView d;
  protected Intent e;
  protected CustomWebChromeClient f;
  protected SonicClientImpl g;
  public long h = 0L;
  
  public WebViewWrapper(AppRuntime paramAppRuntime, WebViewCallback paramWebViewCallback, Intent paramIntent, Context paramContext, boolean paramBoolean)
  {
    this.b = paramAppRuntime;
    this.c = paramWebViewCallback;
    this.e = paramIntent;
    this.d = a(paramContext, paramBoolean);
    a();
    a(this.d, paramAppRuntime, paramIntent);
  }
  
  public WebViewWrapper(AppRuntime paramAppRuntime, WebViewCallback paramWebViewCallback, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    this.b = paramAppRuntime;
    this.c = paramWebViewCallback;
    this.e = paramIntent;
    this.d = paramTouchWebView;
    a();
    paramWebViewCallback = this.d;
    if (paramWebViewCallback != null) {
      a(paramWebViewCallback, paramAppRuntime, paramIntent);
    }
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    WebViewWrapper.1 local1 = new WebViewWrapper.1(this);
    paramTouchWebView.setWebChromeClient(local1);
    this.f = local1;
  }
  
  public TouchWebView a(Context paramContext, boolean paramBoolean)
  {
    Util.f("Web_qqbrowser_init_only_webview");
    long l = System.currentTimeMillis();
    if (paramBoolean) {
      paramContext = SwiftReuseTouchWebView.b(paramContext);
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
    this.h = (System.currentTimeMillis() - l);
    return paramContext;
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppRuntime paramAppRuntime, Intent paramIntent)
  {
    l1 = this.h;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createWebView TouchWebView cost = ");
      ((StringBuilder)localObject1).append(l1);
      QLog.d("WebLog_WebViewWrapper", 2, ((StringBuilder)localObject1).toString());
    }
    paramTouchWebView.setIntent(paramIntent);
    Util.g("Web_qqbrowser_init_only_webview");
    l2 = System.currentTimeMillis();
    a(paramTouchWebView);
    b(paramTouchWebView);
    l3 = System.currentTimeMillis();
    paramTouchWebView.setScrollBarStyle(0);
    Util.f("Web_AdjustSettings");
    WebSettings localWebSettings = paramTouchWebView.getSettings();
    Util.f("Web_SetUserAgent");
    Object localObject1 = localWebSettings.getUserAgentString();
    Object localObject2 = a(this.c);
    boolean bool;
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    localWebSettings.setUserAgentString(SwiftWebViewUtils.a((String)localObject1, (String)localObject2, bool));
    Util.g("Web_SetUserAgent");
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
        paramTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new WebViewWrapper.DownloadQQBrowserExtension(this, paramTouchWebView, this.c));
        BaseOpenWebMonitor.b(paramIntent, "use_x5", "1");
        break label576;
        BaseOpenWebMonitor.b(paramIntent, "use_x5", "2");
        if (!SwiftBrowserStatistics.aL) {
          break label688;
        }
        paramAppRuntime = new HashMap(5);
        paramAppRuntime.put("createWebview", String.valueOf(l1));
        paramAppRuntime.put("initWebClient", String.valueOf(l3 - l2));
        paramAppRuntime.put("setWebSetting", String.valueOf(l4 - l2));
        paramAppRuntime.put("coreInit", String.valueOf(SwiftWebAccelerator.TbsAccelerator.b));
        paramAppRuntime.put("coldStart", String.valueOf(SwiftBrowserStatistics.aD));
        StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(null, "actWebviewInit", true, 0L, 0L, paramAppRuntime, null);
        if (!QLog.isColorLevel()) {
          break label734;
        }
        QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(SwiftBrowserStatistics.aL), " cost:", Long.valueOf(SwiftWebAccelerator.TbsAccelerator.b) });
        Util.g("Web_AdjustSettings");
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
        this.a = ((IWebViewWrapperInjector)((Class)WebViewWrapperInjectorUtil.a.get(0)).newInstance());
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
    this.g = paramSonicClientImpl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSonicClient sonicClient = ");
    localStringBuilder.append(paramSonicClientImpl);
    QLog.i("WebLog_WebViewWrapper", 1, localStringBuilder.toString());
  }
  
  public void b()
  {
    if (this.c != null) {
      this.c = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).d();
      }
      this.d.setPluginEngine(null);
      if (this.d.getParent() == null) {}
    }
    try
    {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    }
    catch (Exception localException1)
    {
      try
      {
        this.d.stopLoading();
        this.d.loadUrlOriginal("about:blank");
        this.d.clearView();
        this.d.destroy();
        this.d = null;
        localObject = this.f;
        if (localObject == null) {
          break label141;
        }
        ((CustomWebChromeClient)localObject).a();
        this.f = null;
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
  
  public TouchWebView c()
  {
    return this.d;
  }
  
  public CustomWebChromeClient d()
  {
    return this.f;
  }
  
  protected boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper
 * JD-Core Version:    0.7.0.1
 */