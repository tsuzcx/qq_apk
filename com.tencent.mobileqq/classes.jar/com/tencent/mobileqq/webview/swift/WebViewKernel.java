package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.PreloadIdleTask;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
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
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewKernel
  implements View.OnTouchListener, WebViewCallback
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected AuthorizeConfig a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  private WebViewKernelParam jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewKernelParam;
  private volatile WebViewPluginEngine jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
  private WebViewProvider jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
  private WebViewWrapper jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper;
  private SwiftBrowserSetting jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting;
  private SwiftBrowserStatistics jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
  protected final SwiftBrowserStateMachineScheduler a;
  private WebViewKernelCallBack jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = true;
  
  public WebViewKernel(@NonNull WebViewProvider paramWebViewProvider, WebViewKernelCallBack paramWebViewKernelCallBack, @NonNull WebViewKernelParam paramWebViewKernelParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler = new SwiftBrowserStateMachineScheduler(new WebViewKernel.1(this));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = paramWebViewProvider;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack = paramWebViewKernelCallBack;
    this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(-2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting = ((SwiftBrowserSetting)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(-1));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewKernelParam = paramWebViewKernelParam;
  }
  
  private WebViewWrapper a(ViewGroup paramViewGroup)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewKernelParam.b();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.createWebViewWrapper(bool);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper = new WebViewWrapperWithActivity(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity(), this, this.jdField_a_of_type_AndroidContentIntent, bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
    if (localObject != null) {
      ((SonicClientImpl)localObject).bindWebView(localTouchWebView);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
    localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
    if ((localTouchWebView instanceof SwiftReuseTouchWebView))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      if (1 == ((SwiftReuseTouchWebView)localTouchWebView).b) {
        bool = true;
      } else {
        bool = false;
      }
      ((SwiftBrowserStatistics)localObject).jdField_r_of_type_Boolean = bool;
    }
    localTouchWebView.getView().setOnTouchListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isNightMode()) {
      localTouchWebView.setMask(true);
    }
    if (paramViewGroup != null) {
      paramViewGroup.addView(localTouchWebView);
    }
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper;
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.b(paramString1);
      String str = SwiftBrowserCookieMonster.b(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null)
        {
          paramString1.a(paramString2, null, null, this.jdField_a_of_type_AndroidContentIntent);
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebViewKernel", 1, paramString1, new Object[0]);
    }
  }
  
  private boolean a(String paramString)
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
      QLog.d("WebViewKernel", 2, ((StringBuilder)localObject1).toString());
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
              break label364;
            }
            bool = true;
            ((SonicSessionConfig.Builder)localObject2).setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label370;
            }
            i = 1;
            break label372;
            localHashMap.put("cache-offline", localObject1);
            ((SonicSessionConfig.Builder)localObject2).setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label392;
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
            this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject1);
            ((SonicSession)localObject1).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
            return true;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("initSonicSession sonicSession = null, url = ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("WebViewKernel", 1, ((StringBuilder)localObject1).toString());
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initSonicSession sonicEngine = null, url = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("WebViewKernel", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initSonicSession exception, url = ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("WebViewKernel", 1, ((StringBuilder)localObject2).toString(), localException);
        return false;
      }
      label364:
      boolean bool = false;
      continue;
      label370:
      int i = 0;
      label372:
      String str;
      if (i != 0)
      {
        str = "store";
      }
      else
      {
        str = "true";
        continue;
        label392:
        bool = false;
      }
    }
  }
  
  private int g(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_x5_environment");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.Q = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 8;
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
  
  private int h(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime();
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(paramBundle.getApplication(), paramBundle);
    }
    if (paramBundle.getLongAccountUin() != 0L)
    {
      SwiftBrowserStatistics localSwiftBrowserStatistics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      boolean bool;
      if (paramBundle.getLongAccountUin() % SwiftBrowserStatistics.jdField_d_of_type_Int == 6L) {
        bool = true;
      } else {
        bool = false;
      }
      localSwiftBrowserStatistics.h = bool;
    }
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_AndroidContentIntent.getStringArrayExtra("insertPluginsArray"));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl(), 1L, null);
    }
    this.jdField_a_of_type_Int = 16;
    if (SwiftBrowserStatistics.u) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a("webview_init", System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, "0");
    }
    Util.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    return 1;
  }
  
  private void h()
  {
    synchronized (SwiftWebAccelerator.a)
    {
      if (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
        WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewKernel", 2, "-->web engine and plugin initialized at process preload!");
        }
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a();
        WebAccelerateHelper.getInstance().bindFragment(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity(), null, null);
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
      WebAccelerateHelper.getInstance().bindFragment(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
      return;
    }
  }
  
  private int i(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_load_url");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c("state_load_url");
    long l1 = System.currentTimeMillis();
    Util.a("Web_qqbrowser_init");
    b();
    Util.b("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.o = (l2 - l1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("init param and load url, cost = ");
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.o);
      QLog.d("WebViewKernel", 2, paramBundle.toString());
    }
    Util.b("Web_qqbrowser_state_machine_load_url");
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (paramBundle != null) {
      paramBundle.loadUrlFinish();
    }
    this.jdField_a_of_type_Int = 64;
    return 0;
  }
  
  private void i()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int j(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_bottombar");
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onInitBottomBar(paramBundle);
    }
    this.jdField_a_of_type_Int = 1024;
    Util.b("Web_qqbrowser_state_machine_init_bottombar");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebViewKernel", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
      }
      return -1;
    }
    return 1;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewKernel", 2, "onDestroy");
    }
    WebViewWrapper localWebViewWrapper = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper;
    if (localWebViewWrapper != null)
    {
      localWebViewWrapper.b();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper = null;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
  }
  
  private void k()
  {
    if (1 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(null);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int a(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("5295");
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("options");
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", ((JSONObject)localObject).getString("url"));
        if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("key_isReadModeEnabled")) {
          this.jdField_a_of_type_AndroidContentIntent.putExtra("key_isReadModeEnabled", true);
        }
        this.jdField_a_of_type_AndroidContentIntent.putExtra("ba_is_login", ((JSONObject)localObject).optBoolean("ba_is_login", true));
        this.jdField_a_of_type_AndroidContentIntent.putExtra("isShowAd", ((JSONObject)localObject).optBoolean("isShowAd", true));
        this.jdField_a_of_type_AndroidContentIntent.putExtra("avoidLoginWeb", ((JSONObject)localObject).optBoolean("avoidLoginWeb", false));
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewKernel", 2, localJSONException.toString());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("individuation_url_type", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b == -1) && (SwiftBrowserStatistics.CrashStepStatsEntry.jdField_d_of_type_Int != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b = SwiftBrowserStatistics.CrashStepStatsEntry.jdField_d_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl();
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onDataInit(paramBundle);
    }
    Util.b("Web_qqbrowser_state_machine_init_data");
    this.jdField_a_of_type_Int = 4;
    return 0;
  }
  
  public SonicClientImpl a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(null).a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setOnTouchListener(this);
      Object localObject = this.jdField_a_of_type_AndroidContentIntent;
      int j = 0;
      if (!((Intent)localObject).getBooleanExtra("key_from_opensdk_qrcode", false)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new WebViewKernel.WebViewLongClickedListener(this, null));
      }
      long l1 = System.currentTimeMillis();
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewKernelParam.a();
      int i = -1;
      if (bool) {}
      int k;
      do
      {
        i = 2;
        break;
        k = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("reqType", -1);
      } while (k == 1);
      if (k == 4) {
        i = 0;
      }
      if (AppSetting.g) {
        i = 2;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setCacheMode=");
        ((StringBuilder)localObject).append(i);
        QLog.i("WebViewKernel", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      long l2 = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      ((SwiftBrowserStatistics)localObject).n = (l2 - l1);
      ((SwiftBrowserStatistics)localObject).S = l2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init browser, cost = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n);
        QLog.d("WebViewKernel", 2, ((StringBuilder)localObject).toString());
      }
      l1 = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension();
      i = j;
      if (localObject != null) {
        i = 1;
      }
      if (i != 0)
      {
        Bundle localBundle = SwiftWebViewUtils.a();
        if (localBundle != null) {
          ((IX5WebViewExtension)localObject).invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
        ((SwiftBrowserStatistics)localObject).e = 2;
        ((SwiftBrowserStatistics)localObject).f = String.valueOf(QbSdk.getTbsVersion(MobileQQ.sMobileQQ));
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
        ((SwiftBrowserStatistics)localObject).e = 1;
        ((SwiftBrowserStatistics)localObject).f = String.valueOf(Build.VERSION.SDK_INT);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.J = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.jdField_a_of_type_Long;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDomainsAndArgumentForImageRequest, cost=");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.i("WebViewKernel", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    String str = paramIntent.getDataString();
    if (str != null)
    {
      TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localTouchWebView != null)
      {
        localTouchWebView.loadUrl(str);
        return;
      }
    }
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
    if (paramIntent.getBooleanExtra("onNewIntentReDoStateMachine", true))
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(paramIntent.getExtras());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("qqBrowserActivityCreateTime");
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", 0L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate mOnCreateMilliTimeStamp = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentIntent.getLongExtra("qqBrowserActivityCreateTime", -2L));
      QLog.e("WebViewKernel", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool;
    if ((localObject != null) && (!((Intent)localObject).getBooleanExtra("key_is_init_sonic_session", true))) {
      bool = false;
    } else {
      bool = a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getUrlFromIntent());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
    ((SwiftBrowserStatistics)localObject).jdField_d_of_type_Boolean = bool;
    if (!((SwiftBrowserStatistics)localObject).jdField_d_of_type_Boolean) {
      ThreadManager.post(new WebViewKernel.4(this), 5, null, true);
    }
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Util.a("Web_qqbrowser_state_machine_all");
    this.jdField_a_of_type_Int = 2;
    if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.jdField_c_of_type_Int > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a();
    }
    WebAccelerateHelper.isWebViewCache = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(paramBundle);
  }
  
  public boolean a(long paramLong, Map<String, Object> paramMap)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null) {
        return ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isActivityResume()) && ((System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L) || (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), (String)localObject).booleanValue())))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if ((localObject != null) && (((WebViewKernelCallBack)localObject).afterWebViewEngineHandleOverrideUrl(paramWebView, paramString))) {}
      return true;
    }
    return false;
  }
  
  protected int b(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_webview");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c("state_webview_create");
    a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.setWebView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onWebViewInit(paramBundle, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    }
    Util.b("Web_qqbrowser_state_machine_init_webview");
    this.jdField_a_of_type_Int = 32;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.R = System.currentTimeMillis();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
    paramBundle.v = (paramBundle.R - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.Q);
    if (SwiftBrowserStatistics.u)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      paramBundle.a("should_start_load", paramBundle.R - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, "0");
    }
    return 0;
  }
  
  protected void b()
  {
    Util.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.h) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k > 0L))
    {
      int i = (int)((System.nanoTime() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k) / 1000000L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Int);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, i, "", "", "", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k = 0L;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_r_of_type_Long = System.currentTimeMillis();
    long l = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_r_of_type_Long;
    l = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.b;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if ((localObject != null) && (((WebViewKernelCallBack)localObject).interceptStartLoadUrl()))
    {
      Util.b("Web_readyToLoadUrl");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl(), 0, 0, 0, 0, 0, null);
      return;
    }
    Util.b("Web_readyToLoadUrl");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl(), 0, 0, 0, 0, 0, null);
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed())
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return true;
      }
      Util.a("urlInterceptManager");
      WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if ((localWebViewKernelCallBack != null) && (localWebViewKernelCallBack.beforeWebViewEngineHandleOverrideUrl(paramWebView, paramString)))
      {
        Util.b("urlInterceptManager");
        return true;
      }
      Util.b("urlInterceptManager");
      return false;
    }
    return true;
  }
  
  protected int c(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_ui_frame");
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if ((localWebViewKernelCallBack != null) && (localWebViewKernelCallBack.interceptInitUIFrame()))
    {
      this.jdField_a_of_type_Int = 128;
      Util.b("Web_qqbrowser_state_machine_init_ui_frame");
      return 1;
    }
    localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onShowPreview(paramBundle);
    }
    this.jdField_a_of_type_Int = 128;
    Util.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null) {
      ((TouchWebView)localObject).onResume();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity();
    boolean bool = localObject instanceof SwiftWebViewFragmentSupporter;
    int j = 1;
    int i = j;
    if (bool)
    {
      localObject = ((SwiftWebViewFragmentSupporter)localObject).getCurrentWebViewFragment();
      i = j;
      if (localObject != null) {
        if (localObject == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider) {
          i = j;
        } else {
          i = 0;
        }
      }
    }
    if (i != 0) {
      a(2L, null);
    }
  }
  
  protected int d(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    Util.a("Web_qqbrowser_state_machine_init_ui_main_content");
    Util.a("Web_qqbrowser_initView");
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onInitUIContent(paramBundle);
    }
    Util.b("Web_qqbrowser_initView");
    Util.b("Web_qqbrowser_state_machine_init_ui_main_content");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.M = (SystemClock.elapsedRealtime() - l);
    this.jdField_a_of_type_Int = 256;
    return 1;
  }
  
  public void d()
  {
    a(8589934597L, null);
  }
  
  protected int e(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    Util.a("Web_qqbrowser_state_machine_init_titlebar");
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onInitTitleBar(paramBundle);
    }
    this.jdField_a_of_type_Int = 512;
    Util.b("Web_qqbrowser_state_machine_init_titlebar");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.L = (SystemClock.elapsedRealtime() - l);
    return 1;
  }
  
  public void e()
  {
    if (1 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_a_of_type_Int = 1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
    if (localObject != null)
    {
      ((SonicClientImpl)localObject).destroy();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject != null) {
      localObject = ((TouchWebView)localObject).getPluginEngine();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
    }
    SwiftBrowserIdleTaskHelper.a().a(2);
    j();
  }
  
  protected int f(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_FINAL");
    ThreadManager.getUIHandler().postDelayed(new WebViewKernel.2(this), 3000L);
    SwiftBrowserIdleTaskHelper.a().a(new WebViewKernel.3(this, 2));
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onFinalState(paramBundle);
    }
    Util.b("Web_qqbrowser_state_machine_init_FINAL");
    Util.b("Web_qqbrowser_state_machine_all");
    this.jdField_a_of_type_Int = 1;
    i();
    return -1;
  }
  
  public void f()
  {
    if (1 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void g()
  {
    SonicClientImpl localSonicClientImpl = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
    if (localSonicClientImpl != null) {
      localSonicClientImpl.clearHistory();
    }
  }
  
  public String getUAMark()
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack == null) {
      return null;
    }
    return localWebViewKernelCallBack.getUAMark();
  }
  
  public View getVideoLoadingProgressView()
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack == null) {
      return null;
    }
    return localWebViewKernelCallBack.getVideoLoadingProgressView();
  }
  
  public void handlePreloadCallback(int paramInt, String paramString)
  {
    Object localObject = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(16);
    if (localObject != null) {
      ((SwiftBrowserTBSHandler)localObject).a(paramInt, paramString);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localObject != null) {
      ((WebViewKernelCallBack)localObject).handlePreloadCallback(paramInt, paramString);
    }
  }
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    Object localObject = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(16);
    if (localObject != null) {
      return ((SwiftBrowserTBSHandler)localObject).a(paramString, paramBundle);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localObject == null) {
      return null;
    }
    return ((WebViewKernelCallBack)localObject).handlerMiscCallback(paramString, paramBundle);
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(paramString, paramInt);
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onDetectedBlankScreen(paramString, paramInt);
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onHideCustomView();
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack == null) {
      return false;
    }
    return localWebViewKernelCallBack.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed())
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c("state_page_finished");
      k();
      if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int == 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 8;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      Object localObject = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(-2);
      if (localObject != null)
      {
        SonicClientImpl localSonicClientImpl = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
        if (localSonicClientImpl != null) {
          ((SwiftBrowserStatistics)localObject).jdField_a_of_type_Int = localSonicClientImpl.getSession().getFinalResultCode();
        }
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(7, (Bundle)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.j)
      {
        this.jdField_a_of_type_Boolean = false;
        SwiftBrowserIdleTaskHelper.a().a(new SwiftBrowserIdleTaskHelper.PreloadIdleTask(1));
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("banner_fromBanner", false))
        {
          localObject = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("banner_webview_extra");
          if ((localObject != null) && (((Bundle)localObject).containsKey("AIO_Scroll_Y")))
          {
            int i = ((Bundle)localObject).getInt("AIO_Scroll_Y");
            if ((i > 0) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView() != null)) {
              ThreadManager.getUIHandler().post(new WebViewKernel.5(this, i));
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.U = System.currentTimeMillis();
        if (SwiftBrowserStatistics.u) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a("web_loaded_url", System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, "0");
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
      if (localObject != null) {
        ((SonicClientImpl)localObject).pageFinish(paramString);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper;
        if ((localObject != null) && (((WebViewWrapper)localObject).a() != null)) {
          onReceivedTitle(paramWebView, paramWebView.getTitle());
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if (localObject != null) {
        ((WebViewKernelCallBack)localObject).onPageFinished(paramWebView, paramString);
      }
      paramWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      paramWebView.j = false;
      paramWebView.c("state_final");
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed())
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      k();
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(6, (Bundle)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if (localObject != null) {
        ((WebViewKernelCallBack)localObject).onPageStarted(paramWebView, paramString, paramBitmap);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.i)
      {
        paramWebView = new StringBuilder();
        paramWebView.append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewKernelParam.a());
        paramWebView.append("");
        paramWebView = paramWebView.toString();
        paramString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl();
        paramBitmap = new StringBuilder();
        paramBitmap.append(HttpUtil.getNetWorkType());
        paramBitmap.append("");
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, paramWebView, paramString, paramBitmap.toString(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getUin());
        if (SwiftBrowserStatistics.u) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a("web_start_load_url", System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, "0");
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.i = false;
      }
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onProgressChanged(paramWebView, paramInt);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed())
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      k();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("descrip=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("failingUrl");
      ((StringBuilder)localObject).append(Util.b(paramString2, new String[0]));
      QLog.e("WebViewKernel", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramInt, paramString1, paramString2);
      if (SwiftBrowserStatistics.u) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a("web_loaded_url_err", System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, String.valueOf(paramInt));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if (localObject != null) {
        ((WebViewKernelCallBack)localObject).onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    if (SwiftBrowserStatistics.u) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a("web_loaded_url_err", System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, String.valueOf(paramSslError.getPrimaryError()));
    }
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onReceivedSslError(paramWebView, paramSslError);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed())
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return;
      }
      WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if (localWebViewKernelCallBack != null) {
        localWebViewKernelCallBack.onReceivedTitle(paramWebView, paramString);
      }
    }
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack == null) {
      return false;
    }
    return localWebViewKernelCallBack.onShowFileChooser(paramValueCallback, paramFileChooserParams);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if ((localWebViewKernelCallBack != null) && (localWebViewKernelCallBack.interceptTouchEvent(paramView, paramMotionEvent))) {
      return false;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    return false;
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("X5 webkit detect 302 url: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("WebViewKernel", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    SwiftBrowserCookieMonster.d();
    a(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e(paramString2);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(paramString2, 8589934626L, null);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localObject != null) {
      ((WebViewKernelCallBack)localObject).onUrlChange(paramString1, paramString2);
    }
  }
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onWebViewClientImplPageStarted(paramWebView, paramString, paramBitmap);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.openFileChooser(paramValueCallback, paramString1, paramString2);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.isDestroyed())
    {
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
        return true;
      }
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.g = false;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
      if ((localObject != null) && (((WebViewKernelCallBack)localObject).shouldOverrideUrlLoading(paramWebView, paramString))) {
        return true;
      }
      localObject = SwiftWebViewUtils.b(paramString);
      if (("http".equals(localObject)) || ("https".equals(localObject)))
      {
        paramWebView = paramWebView.getHitTestResult();
        if ((paramWebView != null) && (paramWebView.getType() == 0))
        {
          paramWebView = new StringBuilder();
          paramWebView.append("shouldOverrideUrlLoading detect 302, url: ");
          paramWebView.append(paramString);
          QLog.i("WebViewKernel", 1, paramWebView.toString());
          paramWebView = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaLangString = paramString;
          SwiftBrowserCookieMonster.d();
          a(paramWebView, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e(paramString);
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(paramString, 8589934626L, null);
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsWebViewKernelCallBack;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.showCustomView(paramView, paramInt, paramCustomViewCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel
 * JD-Core Version:    0.7.0.1
 */