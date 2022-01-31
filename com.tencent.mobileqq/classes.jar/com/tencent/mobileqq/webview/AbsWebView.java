package com.tencent.mobileqq.webview;

import aklz;
import akma;
import akmb;
import akmc;
import akmd;
import akme;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
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
import mqq.app.MobileQQ;
import org.json.JSONObject;

public abstract class AbsWebView
{
  public long a;
  public ProgressBar a;
  private CustomWebChromeClient jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient;
  public TouchWebView a;
  OfflinePlugin jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin;
  public AppInterface a;
  public WebViewPluginEngine a;
  public WebStateReporter a;
  public WebViewProgressBar a;
  public WebViewProgressBarController a;
  private WebViewClient jdField_a_of_type_ComTencentSmttSdkWebViewClient;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public JSONObject a;
  public long b;
  public ArrayList b;
  public long c;
  public Context e;
  public Activity g;
  public boolean g;
  public String h;
  public boolean h;
  public String i = "";
  
  public AbsWebView(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter = new WebStateReporter();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.e = paramContext;
    this.jdField_g_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "bindAllJavaScript");
    }
    long l = System.currentTimeMillis();
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      a(this.jdField_b_of_type_JavaUtilArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "bindAllJavaScript time = " + (System.currentTimeMillis() - l));
      }
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API Level >= 23");
      }
    }
    for (this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new akmb(this);; this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new akmc(this))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "API level < 23");
      }
    }
  }
  
  private void c(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "initWebView");
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_h_of_type_JavaLangString, 1L, null)) {}
    WebSettings localWebSettings = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings();
    paramAppInterface = localWebSettings.getUserAgentString();
    String str1 = a();
    boolean bool;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      localWebSettings.setUserAgentString(SwiftWebViewUtils.a(paramAppInterface, str1, bool));
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localWebSettings.setMediaPlaybackRequiresUserGesture(false);
      paramAppInterface = this.e.getPackageManager();
      try
      {
        if (!paramAppInterface.hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = paramAppInterface.hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {}
        }
        else
        {
          j = 1;
          if (j != 0) {
            break label517;
          }
          bool = true;
          localWebSettings.setDisplayZoomControls(bool);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str2 = MobileQQ.getMobileQQ().getProcessName();
          str1 = "";
          paramAppInterface = str1;
          if (str2 != null)
          {
            j = str2.lastIndexOf(':');
            paramAppInterface = str1;
            if (j > -1) {
              paramAppInterface = "_" + str2.substring(j + 1);
            }
          }
          localWebSettings.setDatabasePath(this.e.getApplicationContext().getDir("database" + paramAppInterface, 0).getPath());
          localWebSettings.setAppCachePath(this.e.getApplicationContext().getDir("appcache" + paramAppInterface, 0).getPath());
          if (Build.VERSION.SDK_INT >= 11) {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException paramAppInterface)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.requestFocus();
            label376:
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.setFocusableInTouchMode(true);
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.setDownloadListener(new akma(this));
            CookieSyncManager.createInstance(this.e.getApplicationContext());
            if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
            {
              this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new akme(this, this.jdField_a_of_type_ComTencentBizUiTouchWebView));
              if (this.e.getSharedPreferences("WebView_X5_Report", 4).getBoolean("enableX5Report", true))
              {
                paramAppInterface = new Bundle();
                paramAppInterface.putBoolean("enabled", true);
                this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", paramAppInterface);
              }
            }
            return;
            bool = false;
            break;
            int j = 0;
            continue;
            paramAppInterface = paramAppInterface;
            j = 0;
          }
          label517:
          bool = false;
        }
        catch (Exception paramAppInterface)
        {
          break label376;
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient = new akmd(this);
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setWebChromeClient(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin == null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("offline");
        if ((localObject != null) && ((localObject instanceof OfflinePlugin))) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin = ((OfflinePlugin)localObject);
        }
      }
    }
  }
  
  public void A() {}
  
  public long a()
  {
    j();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_a_of_type_Long;
    }
    return 0L;
  }
  
  public CustomWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public WebAccelerateHelper.CommonJsPluginFactory a()
  {
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void a(ValueCallback paramValueCallback, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback) {}
  
  public void a(ArrayList paramArrayList) {}
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return true;
  }
  
  public long b()
  {
    j();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.jdField_b_of_type_Long;
    }
    return 0L;
  }
  
  public final void b(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(1);
    if (paramIntent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(paramIntent.getStringExtra("key_service_id"));
      long l2 = paramIntent.getLongExtra("startOpenPageTime", -1L);
      long l1 = l2;
      if (-1L == l2) {
        l1 = System.currentTimeMillis();
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(l1);
    }
  }
  
  public final void b(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "buildBaseWebView");
    }
    z();
    c(paramAppInterface);
    c();
    d();
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public View c()
  {
    return null;
  }
  
  public void d(boolean paramBoolean)
  {
    ProgressBar localProgressBar;
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
    {
      localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int j = 0;; j = 8)
    {
      localProgressBar.setVisibility(j);
      return;
    }
  }
  
  public boolean d()
  {
    j();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.e;
    }
    return false;
  }
  
  public void e() {}
  
  public void e(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    j();
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin != null) {
      return this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.d;
    }
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public final void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnResume");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 2L, null);
      }
    }
  }
  
  public final void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnPause");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onPause();
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934597L, null);
      }
    }
  }
  
  public final void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebChromeClient.a();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null)
      {
        localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
        localWebViewPluginEngine.b();
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      label75:
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.a("about:blank");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
      return;
    }
    catch (Exception localException)
    {
      break label75;
    }
  }
  
  public void x()
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.reload();
  }
  
  public final void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "preInitPluginEngine");
    }
    WebViewPluginEngine localWebViewPluginEngine;
    if ((PreloadService.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) && (!PreloadService.c))
    {
      localWebViewPluginEngine = PreloadService.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use reader preloaded web engine!");
        }
        b();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_g_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList);
        return;
      }
    }
    if ((PreloadService.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) && (!PreloadService.d))
    {
      localWebViewPluginEngine = PreloadService.b;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = localWebViewPluginEngine;
      if (localWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "use comic preloaded web engine!");
        }
        b();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_g_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList);
        return;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null) && (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "use preloaded web engine!");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      b();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_g_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "WebAccelerateHelper.isWebViewCache:" + WebAccelerateHelper.isWebViewCache + ",mPluginEngine=" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
    }
    ThreadManager.postImmediately(new aklz(this), null, false);
  }
  
  /* Error */
  public void z()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 68
    //   10: iconst_2
    //   11: ldc_w 546
    //   14: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 144	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   21: ifnull +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 36	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   29: astore 5
    //   31: aload 5
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 144	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   38: ifnonnull +100 -> 138
    //   41: aload_0
    //   42: invokespecial 505	com/tencent/mobileqq/webview/AbsWebView:b	()V
    //   45: iconst_0
    //   46: istore_3
    //   47: iconst_0
    //   48: istore 4
    //   50: iload 4
    //   52: istore_1
    //   53: aload_0
    //   54: getfield 59	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   57: invokestatic 499	com/tencent/mobileqq/webprocess/PreloadService:a	(Lmqq/app/AppRuntime;)Z
    //   60: ifeq +55 -> 115
    //   63: iload 4
    //   65: istore_1
    //   66: getstatic 501	com/tencent/mobileqq/webprocess/PreloadService:c	Z
    //   69: ifne +46 -> 115
    //   72: iload 4
    //   74: istore_1
    //   75: getstatic 548	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_Boolean	Z
    //   78: ifeq +37 -> 115
    //   81: getstatic 502	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   84: astore 6
    //   86: aload_0
    //   87: aload 6
    //   89: putfield 144	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   92: aload 6
    //   94: ifnull +56 -> 150
    //   97: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +163 -> 263
    //   103: ldc 68
    //   105: iconst_2
    //   106: ldc_w 550
    //   109: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: goto +151 -> 263
    //   115: iload_1
    //   116: ifeq +112 -> 228
    //   119: aload_0
    //   120: getfield 144	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   123: aload_0
    //   124: getfield 59	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   127: aload_0
    //   128: getfield 57	com/tencent/mobileqq/webview/AbsWebView:jdField_g_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   131: aload_0
    //   132: getfield 82	com/tencent/mobileqq/webview/AbsWebView:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   135: invokevirtual 508	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Ljava/util/List;)V
    //   138: aload 5
    //   140: monitorexit
    //   141: return
    //   142: astore 6
    //   144: aload 5
    //   146: monitorexit
    //   147: aload 6
    //   149: athrow
    //   150: getstatic 551	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   153: astore 6
    //   155: aload 6
    //   157: monitorenter
    //   158: getstatic 551	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   161: ldc2_w 552
    //   164: invokevirtual 556	java/lang/Object:wait	(J)V
    //   167: getstatic 502	com/tencent/mobileqq/webprocess/PreloadService:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   170: astore 7
    //   172: aload_0
    //   173: aload 7
    //   175: putfield 144	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   178: aload 7
    //   180: ifnull +78 -> 258
    //   183: iload_2
    //   184: istore_1
    //   185: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq +14 -> 202
    //   191: ldc 68
    //   193: iconst_2
    //   194: ldc_w 558
    //   197: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: iload_2
    //   201: istore_1
    //   202: aload 6
    //   204: monitorexit
    //   205: goto -90 -> 115
    //   208: astore 7
    //   210: aload 6
    //   212: monitorexit
    //   213: aload 7
    //   215: athrow
    //   216: astore 7
    //   218: aload 7
    //   220: invokevirtual 561	java/lang/InterruptedException:printStackTrace	()V
    //   223: iload_3
    //   224: istore_1
    //   225: goto -23 -> 202
    //   228: aload_0
    //   229: invokestatic 565	com/tencent/mobileqq/webprocess/WebAccelerateHelper:getInstance	()Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper;
    //   232: aload_0
    //   233: getfield 59	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   236: aload_0
    //   237: getfield 57	com/tencent/mobileqq/webview/AbsWebView:jdField_g_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   240: aconst_null
    //   241: aload_0
    //   242: invokevirtual 567	com/tencent/mobileqq/webview/AbsWebView:a	()Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper$CommonJsPluginFactory;
    //   245: aload_0
    //   246: getfield 82	com/tencent/mobileqq/webview/AbsWebView:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   249: invokevirtual 571	com/tencent/mobileqq/webprocess/WebAccelerateHelper:createWebViewPluginEngine	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/mobileqq/webprocess/WebAccelerateHelper$CommonJsPluginFactory;Ljava/util/List;)Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   252: putfield 144	com/tencent/mobileqq/webview/AbsWebView:jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine	Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   255: goto -117 -> 138
    //   258: iconst_0
    //   259: istore_1
    //   260: goto -58 -> 202
    //   263: iconst_1
    //   264: istore_1
    //   265: goto -150 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	AbsWebView
    //   52	213	1	j	int
    //   1	200	2	k	int
    //   46	178	3	m	int
    //   48	25	4	n	int
    //   29	116	5	localObject1	Object
    //   84	9	6	localWebViewPluginEngine1	WebViewPluginEngine
    //   142	6	6	localObject2	Object
    //   170	9	7	localWebViewPluginEngine2	WebViewPluginEngine
    //   208	6	7	localObject4	Object
    //   216	3	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   34	45	142	finally
    //   53	63	142	finally
    //   66	72	142	finally
    //   75	92	142	finally
    //   97	112	142	finally
    //   119	138	142	finally
    //   138	141	142	finally
    //   144	147	142	finally
    //   150	158	142	finally
    //   213	216	142	finally
    //   228	255	142	finally
    //   158	178	208	finally
    //   185	200	208	finally
    //   202	205	208	finally
    //   210	213	208	finally
    //   218	223	208	finally
    //   158	178	216	java/lang/InterruptedException
    //   185	200	216	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView
 * JD-Core Version:    0.7.0.1
 */