package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponent;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftFileChooseHandler;
import com.tencent.mobileqq.webview.swift.injector.IWebViewSurfaceInjector;
import com.tencent.mobileqq.webview.swift.injector.WebViewSurfaceInjectorUtils;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webview.utils.UrlMatcher;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WebViewSurface
  implements WebViewKernelCallBack, WebUiUtils.WebTitleBarInterface
{
  View.OnTouchListener a = new WebViewSurface.1(this);
  private boolean b = false;
  private IWebViewSurfaceInjector c;
  private WebViewProvider d;
  private TouchWebView e;
  private String f = "";
  private boolean g = false;
  private SwiftBrowserUIStyleHandler h;
  private SwiftBrowserUIStyle i;
  private SwiftIphoneTitleBarUI j;
  private SwiftBrowserSetting k;
  private SwiftBrowserStatistics l;
  private View m;
  private boolean n;
  private FrameLayout o;
  private View p;
  private int q;
  private int r;
  private View s;
  private IX5WebChromeClient.CustomViewCallback t;
  private boolean u = true;
  private boolean v = true;
  
  public WebViewSurface(@NonNull WebViewProvider paramWebViewProvider)
  {
    this.d = paramWebViewProvider;
    this.h = ((SwiftBrowserUIStyleHandler)paramWebViewProvider.getComponentProvider().a(2));
    this.h.a(paramWebViewProvider.getOnclickListener());
    this.h.b();
    this.i = this.h.f;
    this.j = this.h.g;
    this.k = ((SwiftBrowserSetting)paramWebViewProvider.getComponentProvider().a(-1));
    this.l = ((SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2));
    this.c = WebViewSurfaceInjectorUtils.a();
  }
  
  private void h()
  {
    Util.f("Web_qqbrowser_createtabbar");
    Activity localActivity = this.d.getHostActivity();
    if ((localActivity instanceof QQBrowserActivity))
    {
      ((QQBrowserActivity)localActivity).createTabBarView();
      boolean bool1 = ZhuoXusManager.a().d();
      boolean bool2 = this.d.getIntent().getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.j.h.setVisibility(8);
      }
    }
    Util.g("Web_qqbrowser_createtabbar");
  }
  
  private void i()
  {
    if (this.i.R == null)
    {
      int i1 = this.j.o.getPaddingTop();
      int i2 = this.j.o.getPaddingBottom();
      int i3 = this.j.o.getPaddingLeft();
      int i4 = this.j.o.getPaddingRight();
      this.j.o.setBackgroundDrawable(this.d.getResource().getDrawable(2130852228));
      this.j.o.setPadding(i3, i1, i4, i2);
      return;
    }
    this.j.o.setBackgroundColor(this.i.R.c);
    this.j.d(this.i.R.d);
    this.j.f(this.i.R.e);
  }
  
  public void a()
  {
    onHideCustomView();
    this.d.getComponentProvider().a(1, null);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.b(this.d);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", paramInt);
    this.d.getComponentProvider().a(2, (Bundle)localObject);
    localObject = this.c;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).a(this.d);
    }
    if (this.h.f.a)
    {
      WebViewUIUtils.b(this.d.getHostActivity());
      WebViewUIUtils.a(this.d.getHostActivity());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (TextView)this.h.x.findViewById(2131429744);
    if (localObject1 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt1;
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = this.h.x.findViewById(2131450099);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt2;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((IWebViewSurfaceInjector)localObject).a(this.d, paramInt1, paramInt2, paramIntent))) {
      return;
    }
    localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    TouchWebView localTouchWebView = this.e;
    if ((localTouchWebView != null) && (localTouchWebView.getPluginEngine().a(this.e.getUrl(), 8589934600L, (Map)localObject))) {
      return;
    }
    int i1 = SwiftWebViewUtils.a(paramInt1);
    int i2 = SwiftWebViewUtils.b(paramInt1);
    if (i2 > 0)
    {
      localObject = this.e;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getPluginEngine();
        if (localObject != null)
        {
          localObject = ((WebViewPluginEngine)localObject).a(i2, true);
          if (localObject != null)
          {
            ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)i1, paramInt2);
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("WebViewSurface", 2, "Caution! activity result not handled!");
      }
    }
    else if (((SwiftFileChooseHandler)this.d.getComponentProvider().a(128)).a(paramInt1, paramInt2, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebViewSurface", 2, "Activity result handled by FileChooserHelper.");
      }
    }
    else if ((paramInt2 == -1) && (this.e != null))
    {
      localObject = this.c;
      if ((localObject == null) || (!((IWebViewSurfaceInjector)localObject).a(this.d, paramInt1, paramIntent))) {}
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.g);
    this.d.getComponentProvider().a(4, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.d(this.d, paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putString("url", this.d.getCurrentUrl());
    this.d.getComponentProvider().a(5, paramBundle);
  }
  
  public void a(View paramView)
  {
    this.s = paramView;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.j.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramAPICallback);
    paramString1 = this.c;
    if (paramString1 != null) {
      paramString1.f(this.d);
    }
    this.h.k();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.h.f.I = paramJSONObject;
    }
    this.h.a(paramJSONObject, true);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = this.h;
    if ((localSwiftBrowserUIStyleHandler != null) && (localSwiftBrowserUIStyleHandler.g != null)) {
      this.h.g.a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    return (localIWebViewSurfaceInjector != null) && (localIWebViewSurfaceInjector.a(this.d, paramIntent));
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      return localIWebViewSurfaceInjector.b(this.d, paramWebView, paramString);
    }
    return false;
  }
  
  public void b()
  {
    if ((this.i.c & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewSurface", 2, "close on hide by wv param");
      }
      this.d.getHostActivity().finish();
    }
    this.d.getComponentProvider().a(8, null);
    SwiftBrowserStatistics.c();
  }
  
  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    paramWebView = this.c;
    if (paramWebView != null) {
      return paramWebView.c(this.d, this.e, paramString);
    }
    return false;
  }
  
  public void c()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("url", this.d.getCurrentUrl());
    this.d.getComponentProvider().a(3, (Bundle)localObject);
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null) {
      ReportController.b(null, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).d, ((ViewExposeUtil.ViewExposeUnit)localObject).d, ((ViewExposeUtil.ViewExposeUnit)localObject).e, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).c), "", "", "");
    }
    this.j.m();
    BaseOpenWebMonitor.d(this.d.getIntent());
    localObject = this.c;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).c(this.d);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.u) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.d.getHostActivity().getWindow().addFlags(67108864);
      if (this.v)
      {
        if (this.s == null)
        {
          this.s = new View(this.d.getHostActivity());
          if (this.i.R != null)
          {
            this.s.setBackgroundColor(this.i.R.b);
            SimpleUIUtil.a(true, this.i.R.b, this.d.getHostActivity().getWindow());
          }
          else if (ThemeUtil.isDefaultOrDIYTheme(false))
          {
            this.s.setBackgroundResource(2130852229);
          }
          else
          {
            this.s.setBackgroundColor(this.d.getResource().getColor(2131168092));
            SimpleUIUtil.a(false, this.d.getResource().getColor(2131168092), this.d.getHostActivity().getWindow());
          }
        }
        if (this.s.getParent() == null)
        {
          if (paramBoolean)
          {
            localObject = new View(this.d.getHostActivity());
            ((View)localObject).setId(2131431363);
            ((View)localObject).setBackgroundColor(-16777216);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
            localLayoutParams.addRule(10, -1);
            this.h.x.addView((View)localObject, localLayoutParams);
          }
          Object localObject = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
          ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
          this.h.x.addView(this.s, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewSurface", 2, "hide custom view called");
    }
    if (!this.n) {
      return false;
    }
    this.p.setKeepScreenOn(false);
    this.o.setVisibility(8);
    this.t.onCustomViewHidden();
    try
    {
      this.o.removeAllViews();
      label58:
      Activity localActivity = this.d.getHostActivity();
      if (!this.i.L) {
        localActivity.getWindow().setFlags(this.r, 1024);
      }
      localActivity.setRequestedOrientation(this.q);
      this.p = null;
      this.t = null;
      this.m = null;
      this.n = false;
      return true;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public void e()
  {
    if ((this.s != null) && (!this.i.r))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.s.setBackgroundResource(2130852229);
        return;
      }
      this.s.setBackgroundColor(this.d.getResource().getColor(2131168092));
      SimpleUIUtil.a(false, this.d.getResource().getColor(2131168092), this.d.getHostActivity().getWindow());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.j.b(paramBoolean);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.f(this.d);
    }
    this.h.k();
  }
  
  public void f(boolean paramBoolean)
  {
    Object localObject = this.j.o;
    if (localObject == null) {
      return;
    }
    int i2 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296967);
    if (!paramBoolean)
    {
      this.d.getWebTitleBarInterface().a(i2, 0);
      ((View)localObject).setVisibility(8);
      localObject = this.s;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        this.h.x.findViewById(2131431363).setVisibility(8);
      }
    }
    else
    {
      int i1;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i1 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
      } else {
        i1 = 0;
      }
      if (this.i.w)
      {
        i2 += i1;
      }
      else
      {
        i2 += i1 * 2;
        i1 += BaseApplication.getContext().getResources().getDimensionPixelSize(2131299927);
      }
      this.d.getWebTitleBarInterface().a(i2, i1);
      ((View)localObject).setVisibility(0);
      localObject = this.s;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.h.x.findViewById(2131431363).setVisibility(0);
      }
    }
  }
  
  public boolean f()
  {
    return this.u;
  }
  
  public void g()
  {
    Object localObject = this.e;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TouchWebView)localObject).getPluginEngine();
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.d.getCurrentUrl(), 8589934598L, null);
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.d.getCurrentUrl(), 8589934599L, null);
    }
    localObject = this.c;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).e(this.d);
    }
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.m == null) {
      this.m = LayoutInflater.from(this.d.getHostActivity()).inflate(2131629632, null);
    }
    return this.m;
  }
  
  public void handlePreloadCallback(int paramInt, String paramString) {}
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    if ("handleImage".equals(paramString))
    {
      paramString = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)this.d.getComponentProvider().a(8);
      return Boolean.valueOf(((IWebviewApi)QRoute.api(IWebviewApi.class)).onQRFromX5(paramString));
    }
    return null;
  }
  
  public boolean interceptInitUIFrame()
  {
    return false;
  }
  
  public boolean interceptStartLoadUrl()
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.g(this.d);
    }
    return false;
  }
  
  public boolean interceptTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public View l()
  {
    return this.s;
  }
  
  public void loadUrlFinish() {}
  
  public int m()
  {
    return this.d.getResource().getDimensionPixelSize(2131299920);
  }
  
  public View n()
  {
    return this.j.o;
  }
  
  public void onClick(View paramView)
  {
    if (this.e == null) {
      return;
    }
    if ((paramView != this.j.d) && (paramView != this.j.j) && (paramView != this.h.o))
    {
      IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
      if (localIWebViewSurfaceInjector != null) {
        localIWebViewSurfaceInjector.a(this.d, paramView);
      }
    }
    else
    {
      this.d.doOnBackEvent();
      if (paramView == this.j.j) {
        ReportController.a(null, "dc00898", "", "", "0X8009B1F", "0X8009B1F", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    this.v = false;
    this.u = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    if (("Xiaomi_MI 2".equals(((StringBuilder)localObject).toString())) && (Build.VERSION.SDK_INT == 16)) {
      this.b = true;
    }
    localObject = this.c;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).a(this.d, paramBundle);
    }
    boolean bool = this.d.getIntent().getBooleanExtra("vasUsePreWebview", false);
    this.k.a("web_view_long_click", bool ^ true);
    this.f = this.d.getIntent().getStringExtra("title");
    this.h.G = this.f;
    if ((this.i.c & 0x4000000) == 0L) {
      this.k.a("image_long_click", true);
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onFinalState(Bundle paramBundle)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.b(this.d, paramBundle);
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGeolocationPermissionsShowPrompt:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebViewSurface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).a(this.d, paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    d();
  }
  
  public void onInitBottomBar(Bundle paramBundle)
  {
    this.h.b(this.d.getIntent(), this.d.getCurrentUrl());
    this.h.e();
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    this.h.a(this.d.getIntent(), this.d.getCurrentUrl());
    this.h.f();
    h();
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null)
    {
      localIWebViewSurfaceInjector.c(this.d, paramBundle);
      this.c.f(this.d);
    }
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    if (!this.g)
    {
      this.g = true;
      this.h.a(this.d.getContentView(), this.d.getIntent(), this.e);
      if (this.e.isPaused) {
        this.e.onResume();
      }
    }
    else if ((this.i.a) && (this.i.e != 0L))
    {
      this.h.h.a(this.d.getContentView());
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.l.au) {
      this.d.getWebShareInterface().getShare();
    }
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.d, paramWebView, paramString);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.b(this.d, paramWebView, paramString, paramBitmap);
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if ((this.h.w != null) && (this.h.w.d() == 0)) {
      this.h.w.a((byte)1);
    }
    if (paramInt == 100) {
      this.h.B.setVisibility(8);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.h.B.setVisibility(8);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.d, paramWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.d, paramWebView, paramSslError);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (TextUtils.isEmpty(this.f))
    {
      if ((this.i.d & 0x8) > 0L) {
        return;
      }
      if (UrlMatcher.a(paramString)) {
        return;
      }
      if (paramString != null) {
        this.j.a(paramWebView, paramString, this.b);
      }
    }
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return ((SwiftFileChooseHandler)this.d.getComponentProvider().a(128)).a(paramValueCallback, paramFileChooserParams);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    if (this.h.t) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    Util.f("Web_qqbrowser_ShowPreview");
    long l2 = System.nanoTime();
    this.h.a(this.d.getIntent());
    this.h.b(this.d.getIntent());
    this.d.getContentView().a(this.h.f.O);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.e(this.d, paramBundle);
    }
    if (this.h.f.a)
    {
      this.d.getHostActivity().getWindow().setFlags(1024, 1024);
      WebViewUIUtils.b(this.d.getHostActivity());
      WebViewUIUtils.a(this.d.getHostActivity());
    }
    else
    {
      this.h.x = this.d.getContentView();
      this.j.a(this.d.getIntent(), this.d.getOnclickListener());
      this.j.o.setOnTouchListener(this.a);
      paramBundle = (RelativeLayout.LayoutParams)this.j.o.getLayoutParams();
      float f1 = Utils.a(50.0F, BaseApplication.getContext().getResources());
      int i1;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        i1 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        f1 += i1;
      }
      else
      {
        i1 = 0;
      }
      paramBundle.height = ((int)f1);
      this.i.N = true;
      int i2 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296967);
      boolean bool2;
      if ((!this.h.f.b) && (!this.i.v))
      {
        this.u = true;
        this.v = true;
        int i3 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299927);
        this.d.getWebTitleBarInterface().a(i2 + i1 * 2, i3 + i1);
        bool2 = true;
      }
      else
      {
        this.i.w = true;
        this.j.o.setBackgroundDrawable(this.d.getResource().getDrawable(2130853309));
        this.j.d(-1);
        this.j.f(-1);
        boolean bool1;
        if (this.i.x)
        {
          this.d.getWebTitleBarInterface().a(i2 + i1, i1);
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
        bool2 = bool1;
        if (this.i.v)
        {
          this.j.o.setOnTouchListener(null);
          bool2 = bool1;
        }
      }
      try
      {
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.j.o.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
          this.d.getHostActivity().getWindow().addFlags(67108864);
        }
        this.d.getWebTitleBarInterface().c(bool2);
      }
      catch (ClassCastException paramBundle)
      {
        WebViewUIUtils.a(this.d.getHostActivity(), paramBundle);
      }
      if ((!this.h.f.b) && (!this.i.v)) {
        i();
      }
      if (!"2105".equals(ThemeUtil.curThemeId)) {}
    }
    try
    {
      this.j.f(Color.parseColor("#03081A"));
    }
    catch (Exception paramBundle)
    {
      label628:
      break label628;
    }
    QLog.d("WebViewSurface", 2, "there may be some views not be initialized, should not do this UI adjust");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("init view 1, cost = ");
      paramBundle.append((System.nanoTime() - l2) / 1000000L);
      QLog.d("WebViewSurface", 2, paramBundle.toString());
    }
    paramBundle = this.h;
    paramBundle.t = true;
    paramBundle.B = this.d.getContentView().b;
    this.d.getContentView().a.setVisibility(8);
    this.h.b(this.d.getCurrentUrl());
    this.h.d();
    Util.g("Web_qqbrowser_ShowPreview");
    this.l.R = (SystemClock.elapsedRealtime() - l1);
  }
  
  public void onUrlChange(String paramString1, String paramString2) {}
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.d, paramWebView, paramString, paramBitmap);
    }
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    this.e = paramTouchWebView;
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.c;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.d, paramBundle, paramTouchWebView);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    ((SwiftFileChooseHandler)this.d.getComponentProvider().a(128)).a(paramValueCallback, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.d.getWebShareInterface().reset();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.d.setCurUrl(paramString);
        paramWebView = new Bundle();
        paramWebView.putString("url", paramString);
        this.d.getComponentProvider().a(9, paramWebView);
      }
    }
    if (this.d.getHostActivity().isFinishing()) {
      this.h.B.setVisibility(8);
    }
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewSurface", 2, "show custom view called");
    }
    if (this.t != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    Activity localActivity = this.d.getHostActivity();
    this.q = localActivity.getRequestedOrientation();
    this.r = (localActivity.getWindow().getAttributes().flags & 0x400);
    if (this.o == null)
    {
      this.o = new FrameLayout(BaseApplication.getContext());
      this.o.setBackgroundColor(-16777216);
      ((ViewGroup)localActivity.getWindow().getDecorView()).addView(this.o, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.i.L) {
      localActivity.getWindow().setFlags(1024, 1024);
    }
    localActivity.setRequestedOrientation(paramInt);
    this.o.addView(paramView);
    this.p = paramView;
    this.t = paramCustomViewCallback;
    this.o.setVisibility(0);
    this.n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurface
 * JD-Core Version:    0.7.0.1
 */