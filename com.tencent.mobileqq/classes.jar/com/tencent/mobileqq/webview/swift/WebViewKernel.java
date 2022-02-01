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
  protected AuthorizeConfig a;
  protected final SwiftBrowserStateMachineScheduler b = new SwiftBrowserStateMachineScheduler(new WebViewKernel.1(this));
  private WebViewProvider c;
  private WebViewKernelCallBack d;
  private Intent e;
  private TouchWebView f;
  private SwiftBrowserStatistics g;
  private int h = 1;
  private WebViewWrapper i;
  private volatile WebViewPluginEngine j;
  private boolean k = true;
  private String l = "";
  private SonicClientImpl m;
  private long n = 0L;
  private SwiftBrowserSetting o;
  private WebViewKernelParam p;
  
  public WebViewKernel(@NonNull WebViewProvider paramWebViewProvider, WebViewKernelCallBack paramWebViewKernelCallBack, @NonNull WebViewKernelParam paramWebViewKernelParam)
  {
    this.c = paramWebViewProvider;
    this.d = paramWebViewKernelCallBack;
    this.e = this.c.getIntent();
    this.g = ((SwiftBrowserStatistics)this.c.getComponentProvider().a(-2));
    this.o = ((SwiftBrowserSetting)this.c.getComponentProvider().a(-1));
    this.p = paramWebViewKernelParam;
  }
  
  private WebViewWrapper a(ViewGroup paramViewGroup)
  {
    boolean bool = this.p.b();
    this.i = this.c.createWebViewWrapper(bool);
    if (this.i == null) {
      this.i = new WebViewWrapperWithActivity(this.c.getAppRuntime(), this.c.getHostActivity(), this, this.e, bool);
    }
    this.i.a(this.m);
    TouchWebView localTouchWebView = this.i.c();
    Object localObject = this.m;
    if (localObject != null) {
      ((SonicClientImpl)localObject).bindWebView(localTouchWebView);
    }
    this.j.a(localTouchWebView);
    localTouchWebView.setPluginEngine(this.j);
    if ((localTouchWebView instanceof SwiftReuseTouchWebView))
    {
      localObject = this.g;
      if (1 == ((SwiftReuseTouchWebView)localTouchWebView).b) {
        bool = true;
      } else {
        bool = false;
      }
      ((SwiftBrowserStatistics)localObject).aF = bool;
    }
    localTouchWebView.getView().setOnTouchListener(this);
    if (this.c.isNightMode()) {
      localTouchWebView.setMask(true);
    }
    if (paramViewGroup != null) {
      paramViewGroup.addView(localTouchWebView);
    }
    return this.i;
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.b(paramString1);
      String str = SwiftBrowserCookieMonster.b(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.k = false;
      }
      if (this.k)
      {
        paramString1 = SwiftBrowserCookieMonster.c(paramString2);
        if (paramString1 != null)
        {
          paramString1.a(paramString2, null, null, this.e);
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
            long l1 = Long.parseLong((String)localObject1);
            if ((0x2 & l1) == 0L) {
              break label365;
            }
            bool = true;
            ((SonicSessionConfig.Builder)localObject2).setSupportLocalServer(bool);
            if ((0x4 & l1) == 0L) {
              break label371;
            }
            i1 = 1;
            break label373;
            localHashMap.put("cache-offline", localObject1);
            ((SonicSessionConfig.Builder)localObject2).setCustomResponseHeaders(localHashMap);
            if ((0x8 & l1) == 0L) {
              break label393;
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
            this.m = new SonicClientImpl((SonicSession)localObject1);
            ((SonicSession)localObject1).bindClient(this.m);
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
      label365:
      boolean bool = false;
      continue;
      label371:
      int i1 = 0;
      label373:
      String str;
      if (i1 != 0)
      {
        str = "store";
      }
      else
      {
        str = "true";
        continue;
        label393:
        bool = false;
      }
    }
  }
  
  private int h(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_x5_environment");
    this.g.X = System.currentTimeMillis();
    this.h = 8;
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
  
  private int i(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    paramBundle = this.c.getAppRuntime();
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(paramBundle.getApplication(), paramBundle);
    }
    if (paramBundle.getLongAccountUin() != 0L)
    {
      SwiftBrowserStatistics localSwiftBrowserStatistics = this.g;
      boolean bool;
      if (paramBundle.getLongAccountUin() % SwiftBrowserStatistics.aJ == 6L) {
        bool = true;
      } else {
        bool = false;
      }
      localSwiftBrowserStatistics.as = bool;
    }
    k();
    if (this.j != null)
    {
      this.j.a(this.e.getStringArrayExtra("insertPluginsArray"));
      this.j.a(this.c.getCurrentUrl(), 1L, null);
    }
    this.h = 16;
    if (SwiftBrowserStatistics.aL) {
      this.g.a("webview_init", System.currentTimeMillis() - this.g.d, "0");
    }
    Util.g("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    return 1;
  }
  
  private int j(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_load_url");
    this.g.c("state_load_url");
    long l1 = System.currentTimeMillis();
    Util.f("Web_qqbrowser_init");
    b();
    Util.g("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.g.r = (l2 - l1);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("init param and load url, cost = ");
      paramBundle.append(this.g.r);
      QLog.d("WebViewKernel", 2, paramBundle.toString());
    }
    Util.g("Web_qqbrowser_state_machine_load_url");
    paramBundle = this.d;
    if (paramBundle != null) {
      paramBundle.loadUrlFinish();
    }
    this.h = 64;
    return 0;
  }
  
  private int k(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_bottombar");
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onInitBottomBar(paramBundle);
    }
    this.h = 1024;
    Util.g("Web_qqbrowser_state_machine_init_bottombar");
    if (this.f == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebViewKernel", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
      }
      return -1;
    }
    return 1;
  }
  
  private void k()
  {
    synchronized (SwiftWebAccelerator.d)
    {
      if (WebViewPluginEngine.f != null)
      {
        this.j = WebViewPluginEngine.f;
        WebViewPluginEngine.f = null;
      }
      if (this.j != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewKernel", 2, "-->web engine and plugin initialized at process preload!");
        }
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.j, this.c.getAppRuntime(), this.c.getHostActivity());
        this.j.b();
        WebAccelerateHelper.getInstance().bindFragment(this.j, this.c);
        return;
      }
      this.j = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.c.getAppRuntime(), this.c.getHostActivity(), null, null);
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.j, this.c.getAppRuntime(), this.c.getHostActivity());
      WebAccelerateHelper.getInstance().bindFragment(this.j, this.c);
      return;
    }
  }
  
  private void l()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewKernel", 2, "onDestroy");
    }
    WebViewWrapper localWebViewWrapper = this.i;
    if (localWebViewWrapper != null)
    {
      localWebViewWrapper.b();
      this.i = null;
      this.f = null;
    }
  }
  
  private void n()
  {
    if (1 != this.h)
    {
      this.b.b();
      this.b.a();
      this.b.a(null);
    }
  }
  
  protected int a(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("5770");
    Object localObject = this.e.getStringExtra("options");
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.e.putExtra("url", ((JSONObject)localObject).getString("url"));
        if (!this.e.hasExtra("key_isReadModeEnabled")) {
          this.e.putExtra("key_isReadModeEnabled", true);
        }
        this.e.putExtra("ba_is_login", ((JSONObject)localObject).optBoolean("ba_is_login", true));
        this.e.putExtra("isShowAd", ((JSONObject)localObject).optBoolean("isShowAd", true));
        this.e.putExtra("avoidLoginWeb", ((JSONObject)localObject).optBoolean("avoidLoginWeb", false));
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewKernel", 2, localJSONException.toString());
        }
      }
    }
    this.g.aW.d = this.e.getIntExtra("individuation_url_type", -1);
    if ((this.g.aW.d == -1) && (SwiftBrowserStatistics.CrashStepStatsEntry.h != -1)) {
      this.g.aW.d = SwiftBrowserStatistics.CrashStepStatsEntry.h;
    }
    this.g.aw = this.c.getCurrentUrl();
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onDataInit(paramBundle);
    }
    Util.g("Web_qqbrowser_state_machine_init_data");
    this.h = 4;
    return 0;
  }
  
  protected void a()
  {
    if (this.f == null)
    {
      this.f = a(null).c();
      this.f.getView().setOnTouchListener(this);
      Object localObject = this.e;
      int i2 = 0;
      if (!((Intent)localObject).getBooleanExtra("key_from_opensdk_qrcode", false)) {
        this.f.setOnLongClickListener(new WebViewKernel.WebViewLongClickedListener(this, null));
      }
      long l1 = System.currentTimeMillis();
      boolean bool = this.p.a();
      int i1 = -1;
      if (bool) {}
      int i3;
      do
      {
        i1 = 2;
        break;
        i3 = this.e.getIntExtra("reqType", -1);
      } while (i3 == 1);
      if (i3 == 4) {
        i1 = 0;
      }
      if (AppSetting.h) {
        i1 = 2;
      }
      this.f.getSettings().setCacheMode(i1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setCacheMode=");
        ((StringBuilder)localObject).append(i1);
        QLog.i("WebViewKernel", 2, ((StringBuilder)localObject).toString());
      }
      this.f.getSettings().setAllowFileAccessFromFileURLs(false);
      this.f.getSettings().setAllowUniversalAccessFromFileURLs(false);
      long l2 = System.currentTimeMillis();
      localObject = this.g;
      ((SwiftBrowserStatistics)localObject).q = (l2 - l1);
      ((SwiftBrowserStatistics)localObject).Z = l2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init browser, cost = ");
        ((StringBuilder)localObject).append(this.g.q);
        QLog.d("WebViewKernel", 2, ((StringBuilder)localObject).toString());
      }
      l1 = System.currentTimeMillis();
      localObject = this.f.getX5WebViewExtension();
      i1 = i2;
      if (localObject != null) {
        i1 = 1;
      }
      if (i1 != 0)
      {
        Bundle localBundle = SwiftWebViewUtils.c();
        if (localBundle != null) {
          ((IX5WebViewExtension)localObject).invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
        localObject = this.g;
        ((SwiftBrowserStatistics)localObject).aQ = 2;
        ((SwiftBrowserStatistics)localObject).aR = String.valueOf(QbSdk.getTbsVersion(MobileQQ.sMobileQQ));
      }
      else
      {
        localObject = this.g;
        ((SwiftBrowserStatistics)localObject).aQ = 1;
        ((SwiftBrowserStatistics)localObject).aR = String.valueOf(Build.VERSION.SDK_INT);
      }
      this.g.P = this.i.h;
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
      TouchWebView localTouchWebView = this.f;
      if (localTouchWebView != null)
      {
        localTouchWebView.loadUrl(str);
        return;
      }
    }
    this.e = paramIntent;
    this.b.b();
    if (paramIntent.getBooleanExtra("onNewIntentReDoStateMachine", true))
    {
      this.h = 2;
      this.b.a(paramIntent.getExtras());
    }
  }
  
  public boolean a(long paramLong, Map<String, Object> paramMap)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null) {
        return ((WebViewPluginEngine)localObject).a(this.f.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((this.c.isActivityResume()) && ((System.currentTimeMillis() - this.n < 1000L) || (this.a.d(paramWebView.getUrl(), (String)localObject).booleanValue())))
    {
      localObject = this.d;
      if ((localObject != null) && (((WebViewKernelCallBack)localObject).afterWebViewEngineHandleOverrideUrl(paramWebView, paramString))) {}
      return true;
    }
    return false;
  }
  
  protected int b(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_webview");
    this.g.c("state_webview_create");
    a();
    this.c.setWebView(this.f);
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onWebViewInit(paramBundle, this.f);
    }
    Util.g("Web_qqbrowser_state_machine_init_webview");
    this.h = 32;
    this.g.Y = System.currentTimeMillis();
    paramBundle = this.g;
    paramBundle.y = (paramBundle.Y - this.g.X);
    if (SwiftBrowserStatistics.aL)
    {
      paramBundle = this.g;
      paramBundle.a("should_start_load", paramBundle.Y - this.g.d, "0");
    }
    return 0;
  }
  
  protected void b()
  {
    Util.f("Web_readyToLoadUrl");
    if (this.f == null) {
      return;
    }
    if ((this.g.as) && (this.g.n > 0L))
    {
      int i1 = (int)((System.nanoTime() - this.g.n) / 1000000L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.g.ax);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, i1, "", "", "", ((StringBuilder)localObject).toString());
      this.g.n = 0L;
    }
    this.g.u = System.currentTimeMillis();
    long l1 = this.g.u;
    l1 = this.g.c;
    Object localObject = this.d;
    if ((localObject != null) && (((WebViewKernelCallBack)localObject).interceptStartLoadUrl()))
    {
      Util.g("Web_readyToLoadUrl");
      this.g.a(this.f, this.c.getCurrentUrl(), 0, 0, 0, 0, 0, null);
      return;
    }
    Util.g("Web_readyToLoadUrl");
    this.g.a(this.f, this.c.getCurrentUrl(), 0, 0, 0, 0, 0, null);
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    if (!this.c.isDestroyed())
    {
      if (this.f == null) {
        return true;
      }
      Util.f("urlInterceptManager");
      WebViewKernelCallBack localWebViewKernelCallBack = this.d;
      if ((localWebViewKernelCallBack != null) && (localWebViewKernelCallBack.beforeWebViewEngineHandleOverrideUrl(paramWebView, paramString)))
      {
        Util.g("urlInterceptManager");
        return true;
      }
      Util.g("urlInterceptManager");
      return false;
    }
    return true;
  }
  
  protected int c(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_ui_frame");
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if ((localWebViewKernelCallBack != null) && (localWebViewKernelCallBack.interceptInitUIFrame()))
    {
      this.h = 128;
      Util.g("Web_qqbrowser_state_machine_init_ui_frame");
      return 1;
    }
    localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onShowPreview(paramBundle);
    }
    this.h = 128;
    Util.g("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void c()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((TouchWebView)localObject).onResume();
    }
    localObject = this.c.getHostActivity();
    boolean bool = localObject instanceof SwiftWebViewFragmentSupporter;
    int i2 = 1;
    int i1 = i2;
    if (bool)
    {
      localObject = ((SwiftWebViewFragmentSupporter)localObject).getCurrentWebViewFragment();
      i1 = i2;
      if (localObject != null) {
        if (localObject == this.c) {
          i1 = i2;
        } else {
          i1 = 0;
        }
      }
    }
    if (i1 != 0) {
      a(2L, null);
    }
  }
  
  protected int d(Bundle paramBundle)
  {
    long l1 = SystemClock.elapsedRealtime();
    Util.f("Web_qqbrowser_state_machine_init_ui_main_content");
    Util.f("Web_qqbrowser_initView");
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onInitUIContent(paramBundle);
    }
    Util.g("Web_qqbrowser_initView");
    Util.g("Web_qqbrowser_state_machine_init_ui_main_content");
    this.g.T = (SystemClock.elapsedRealtime() - l1);
    this.h = 256;
    return 1;
  }
  
  public void d()
  {
    a(8589934597L, null);
  }
  
  protected int e(Bundle paramBundle)
  {
    long l1 = SystemClock.elapsedRealtime();
    Util.f("Web_qqbrowser_state_machine_init_titlebar");
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onInitTitleBar(paramBundle);
    }
    this.h = 512;
    Util.g("Web_qqbrowser_state_machine_init_titlebar");
    this.g.S = (SystemClock.elapsedRealtime() - l1);
    return 1;
  }
  
  public void e()
  {
    if (1 != this.h)
    {
      this.b.b();
      this.h = 1;
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      ((SonicClientImpl)localObject).destroy();
      this.m = null;
    }
    localObject = this.f;
    if (localObject != null) {
      localObject = ((TouchWebView)localObject).getPluginEngine();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.f.getUrl(), 8589934596L, null);
    }
    SwiftBrowserIdleTaskHelper.a().a(2);
    m();
  }
  
  protected int f(Bundle paramBundle)
  {
    Util.f("Web_qqbrowser_state_machine_init_FINAL");
    ThreadManager.getUIHandler().postDelayed(new WebViewKernel.2(this), 3000L);
    SwiftBrowserIdleTaskHelper.a().a(new WebViewKernel.3(this, 2));
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onFinalState(paramBundle);
    }
    Util.g("Web_qqbrowser_state_machine_init_FINAL");
    Util.g("Web_qqbrowser_state_machine_all");
    this.h = 1;
    l();
    return -1;
  }
  
  public String f()
  {
    return this.l;
  }
  
  public void g()
  {
    if (1 != this.h)
    {
      this.b.b();
      this.h = 1;
    }
  }
  
  public void g(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.e.removeExtra("qqBrowserActivityCreateTime");
      this.e.putExtra("startOpenPageTime", 0L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnCreate mOnCreateMilliTimeStamp = ");
      ((StringBuilder)localObject).append(this.e.getLongExtra("qqBrowserActivityCreateTime", -2L));
      QLog.e("WebViewKernel", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    boolean bool;
    if ((localObject != null) && (!((Intent)localObject).getBooleanExtra("key_is_init_sonic_session", true))) {
      bool = false;
    } else {
      bool = a(this.c.getUrlFromIntent());
    }
    localObject = this.g;
    ((SwiftBrowserStatistics)localObject).Q = bool;
    if (!((SwiftBrowserStatistics)localObject).Q) {
      ThreadManager.post(new WebViewKernel.4(this), 5, null, true);
    }
    this.a = AuthorizeConfig.a();
    Util.f("Web_qqbrowser_state_machine_all");
    this.h = 2;
    if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.c > 0)) {
      this.b.a();
    }
    WebAccelerateHelper.isWebViewCache = true;
    this.b.a(paramBundle);
  }
  
  public String getUAMark()
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack == null) {
      return null;
    }
    return localWebViewKernelCallBack.getUAMark();
  }
  
  public View getVideoLoadingProgressView()
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack == null) {
      return null;
    }
    return localWebViewKernelCallBack.getVideoLoadingProgressView();
  }
  
  public void h()
  {
    SonicClientImpl localSonicClientImpl = this.m;
    if (localSonicClientImpl != null) {
      localSonicClientImpl.clearHistory();
    }
  }
  
  public void handlePreloadCallback(int paramInt, String paramString)
  {
    Object localObject = (SwiftBrowserTBSHandler)this.c.getComponentProvider().a(16);
    if (localObject != null) {
      ((SwiftBrowserTBSHandler)localObject).a(paramInt, paramString);
    }
    localObject = this.d;
    if (localObject != null) {
      ((WebViewKernelCallBack)localObject).handlePreloadCallback(paramInt, paramString);
    }
  }
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    Object localObject = (SwiftBrowserTBSHandler)this.c.getComponentProvider().a(16);
    if (localObject != null) {
      return ((SwiftBrowserTBSHandler)localObject).a(paramString, paramBundle);
    }
    localObject = this.d;
    if (localObject == null) {
      return null;
    }
    return ((WebViewKernelCallBack)localObject).handlerMiscCallback(paramString, paramBundle);
  }
  
  public SonicClientImpl i()
  {
    return this.m;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    this.g.a(paramString, paramInt);
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onDetectedBlankScreen(paramString, paramInt);
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onGeolocationPermissionsShowPrompt(paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onHideCustomView();
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack == null) {
      return false;
    }
    return localWebViewKernelCallBack.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (!this.c.isDestroyed())
    {
      if (this.f == null) {
        return;
      }
      this.g.c("state_page_finished");
      n();
      if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.g.aW.b == 2))
      {
        this.g.aW.b = 8;
        this.g.aW.g = System.currentTimeMillis();
      }
      Object localObject = (SwiftBrowserStatistics)this.c.getComponentProvider().a(-2);
      if (localObject != null)
      {
        SonicClientImpl localSonicClientImpl = this.m;
        if (localSonicClientImpl != null) {
          ((SwiftBrowserStatistics)localObject).an = localSonicClientImpl.getSession().getFinalResultCode();
        }
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      this.c.getComponentProvider().a(7, (Bundle)localObject);
      if (this.g.au)
      {
        this.k = false;
        SwiftBrowserIdleTaskHelper.a().a(new SwiftBrowserIdleTaskHelper.PreloadIdleTask(1));
        if (this.e.getBooleanExtra("banner_fromBanner", false))
        {
          localObject = this.e.getBundleExtra("banner_webview_extra");
          if ((localObject != null) && (((Bundle)localObject).containsKey("AIO_Scroll_Y")))
          {
            int i1 = ((Bundle)localObject).getInt("AIO_Scroll_Y");
            if ((i1 > 0) && (this.f.getView() != null)) {
              ThreadManager.getUIHandler().post(new WebViewKernel.5(this, i1));
            }
          }
        }
        this.g.ab = System.currentTimeMillis();
        if (SwiftBrowserStatistics.aL) {
          this.g.a("web_loaded_url", System.currentTimeMillis() - this.g.d, "0");
        }
      }
      localObject = this.m;
      if (localObject != null) {
        ((SonicClientImpl)localObject).pageFinish(paramString);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.c.isDestroyed()))
      {
        localObject = this.i;
        if ((localObject != null) && (((WebViewWrapper)localObject).d() != null)) {
          onReceivedTitle(paramWebView, paramWebView.getTitle());
        }
      }
      localObject = this.d;
      if (localObject != null) {
        ((WebViewKernelCallBack)localObject).onPageFinished(paramWebView, paramString);
      }
      paramWebView = this.g;
      paramWebView.au = false;
      paramWebView.c("state_final");
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (!this.c.isDestroyed())
    {
      if (this.f == null) {
        return;
      }
      n();
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      this.c.getComponentProvider().a(6, (Bundle)localObject);
      localObject = this.d;
      if (localObject != null) {
        ((WebViewKernelCallBack)localObject).onPageStarted(paramWebView, paramString, paramBitmap);
      }
      if (this.g.at)
      {
        paramWebView = new StringBuilder();
        paramWebView.append(this.p.c());
        paramWebView.append("");
        paramWebView = paramWebView.toString();
        paramString = this.c.getCurrentUrl();
        paramBitmap = new StringBuilder();
        paramBitmap.append(HttpUtil.getNetWorkType());
        paramBitmap.append("");
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, paramWebView, paramString, paramBitmap.toString(), this.c.getUin());
        if (SwiftBrowserStatistics.aL) {
          this.g.a("web_start_load_url", System.currentTimeMillis() - this.g.d, "0");
        }
        this.g.at = false;
      }
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onProgressChanged(paramWebView, paramInt);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (!this.c.isDestroyed())
    {
      if (this.f == null) {
        return;
      }
      n();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errorCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("descrip=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("failingUrl");
      ((StringBuilder)localObject).append(Util.b(paramString2, new String[0]));
      QLog.e("WebViewKernel", 1, ((StringBuilder)localObject).toString());
      this.g.a(this.f, paramInt, paramString1, paramString2);
      if (SwiftBrowserStatistics.aL) {
        this.g.a("web_loaded_url_err", System.currentTimeMillis() - this.g.d, String.valueOf(paramInt));
      }
      localObject = this.d;
      if (localObject != null) {
        ((WebViewKernelCallBack)localObject).onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    if (SwiftBrowserStatistics.aL) {
      this.g.a("web_loaded_url_err", System.currentTimeMillis() - this.g.d, String.valueOf(paramSslError.getPrimaryError()));
    }
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onReceivedSslError(paramWebView, paramSslError);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (!this.c.isDestroyed())
    {
      if (this.f == null) {
        return;
      }
      WebViewKernelCallBack localWebViewKernelCallBack = this.d;
      if (localWebViewKernelCallBack != null) {
        localWebViewKernelCallBack.onReceivedTitle(paramWebView, paramString);
      }
    }
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack == null) {
      return false;
    }
    return localWebViewKernelCallBack.onShowFileChooser(paramValueCallback, paramFileChooserParams);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if ((localWebViewKernelCallBack != null) && (localWebViewKernelCallBack.interceptTouchEvent(paramView, paramMotionEvent))) {
      return false;
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.n = System.currentTimeMillis();
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
    this.l = paramString2;
    SwiftBrowserCookieMonster.d();
    a(paramString1, paramString2);
    this.g.e(paramString2);
    if (this.j != null) {
      this.j.a(paramString2, 8589934626L, null);
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((WebViewKernelCallBack)localObject).onUrlChange(paramString1, paramString2);
    }
  }
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.onWebViewClientImplPageStarted(paramWebView, paramString, paramBitmap);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.openFileChooser(paramValueCallback, paramString1, paramString2);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!this.c.isDestroyed())
    {
      if (this.f == null) {
        return true;
      }
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        this.g.aq = false;
      }
      Object localObject = this.d;
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
          paramWebView = this.l;
          this.l = paramString;
          SwiftBrowserCookieMonster.d();
          a(paramWebView, this.l);
          this.g.e(paramString);
          if (this.j != null) {
            this.j.a(paramString, 8589934626L, null);
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    WebViewKernelCallBack localWebViewKernelCallBack = this.d;
    if (localWebViewKernelCallBack != null) {
      localWebViewKernelCallBack.showCustomView(paramView, paramInt, paramCustomViewCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel
 * JD-Core Version:    0.7.0.1
 */