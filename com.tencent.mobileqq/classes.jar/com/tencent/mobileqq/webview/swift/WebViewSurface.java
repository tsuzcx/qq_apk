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
  private int jdField_a_of_type_Int;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new WebViewSurface.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private SwiftBrowserUIStyle jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
  private SwiftIphoneTitleBarUI jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
  private WebViewProvider jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider;
  private SwiftBrowserSetting jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting;
  private SwiftBrowserStatistics jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
  private SwiftBrowserUIStyleHandler jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler;
  private IWebViewSurfaceInjector jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
  private IX5WebChromeClient.CustomViewCallback jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d = true;
  private boolean e = true;
  
  public WebViewSurface(@NonNull WebViewProvider paramWebViewProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = paramWebViewProvider;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = ((SwiftBrowserUIStyleHandler)paramWebViewProvider.getComponentProvider().a(2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(paramWebViewProvider.getOnclickListener());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting = ((SwiftBrowserSetting)paramWebViewProvider.getComponentProvider().a(-1));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = ((SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector = WebViewSurfaceInjectorUtils.a();
  }
  
  private void f()
  {
    Util.a("Web_qqbrowser_createtabbar");
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity();
    if ((localActivity instanceof QQBrowserActivity))
    {
      ((QQBrowserActivity)localActivity).createTabBarView();
      boolean bool1 = ZhuoXusManager.a().c();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent().getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    Util.b("Web_qqbrowser_createtabbar");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
      int j = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
      int k = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
      int m = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getDrawable(2130850433));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(k, i, m, j);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.c);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.d);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.e);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getDimensionPixelSize(2131299168);
  }
  
  public View a()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a()
  {
    onHideCustomView();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(1, null);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(2, (Bundle)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      WebViewUIUtils.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
      WebViewUIUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131363811);
    if (localObject1 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt1;
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131381085);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt2;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if ((localObject != null) && (((IWebViewSurfaceInjector)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramInt1, paramInt2, paramIntent))) {
      return;
    }
    localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if ((localTouchWebView != null) && (localTouchWebView.getPluginEngine().a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934600L, (Map)localObject))) {
      return;
    }
    int i = SwiftWebViewUtils.a(paramInt1);
    int j = SwiftWebViewUtils.b(paramInt1);
    if (j > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getPluginEngine();
        if (localObject != null)
        {
          localObject = ((WebViewPluginEngine)localObject).a(j, true);
          if (localObject != null)
          {
            ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)i, paramInt2);
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("WebViewSurface", 2, "Caution! activity result not handled!");
      }
    }
    else if (((SwiftFileChooseHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(128)).a(paramInt1, paramInt2, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.w("WebViewSurface", 2, "Activity result handled by FileChooserHelper.");
      }
    }
    else if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
      if ((localObject == null) || (!((IWebViewSurfaceInjector)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramInt1, paramIntent))) {}
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(4, localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putString("url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(5, paramBundle);
  }
  
  public void a(View paramView)
  {
    this.jdField_c_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramAPICallback);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (paramString1 != null) {
      paramString1.f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.k();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(paramJSONObject, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler;
    if ((localSwiftBrowserUIStyleHandler != null) && (localSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewSurface", 2, "hide custom view called");
    }
    if (!this.jdField_c_of_type_Boolean) {
      return false;
    }
    this.jdField_b_of_type_AndroidViewView.setKeepScreenOn(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback.onCustomViewHidden();
    try
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      label58:
      Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity();
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.A) {
        localActivity.getWindow().setFlags(this.jdField_b_of_type_Int, 1024);
      }
      localActivity.setRequestedOrientation(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = null;
      this.jdField_a_of_type_AndroidViewView = null;
      this.jdField_c_of_type_Boolean = false;
      return true;
    }
    catch (Exception localException)
    {
      break label58;
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    return (localIWebViewSurfaceInjector != null) && (localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramIntent));
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      return localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramWebView, paramString);
    }
    return false;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewSurface", 2, "close on hide by wv param");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(8, null);
    SwiftBrowserStatistics.c();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.d) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().getWindow().addFlags(67108864);
      if (this.e)
      {
        if (this.jdField_c_of_type_AndroidViewView == null)
        {
          this.jdField_c_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle != null)
          {
            this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_b_of_type_Int);
            SimpleUIUtil.a(true, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().getWindow());
          }
          else if (ThemeUtil.isDefaultOrDIYTheme(false))
          {
            this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130850434);
          }
          else
          {
            this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getColor(2131167114));
            SimpleUIUtil.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getColor(2131167114), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().getWindow());
          }
        }
        if (this.jdField_c_of_type_AndroidViewView.getParent() == null)
        {
          if (paramBoolean)
          {
            localObject = new View(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
            ((View)localObject).setId(2131365199);
            ((View)localObject).setBackgroundColor(-16777216);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
            localLayoutParams.addRule(10, -1);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.addView((View)localObject, localLayoutParams);
          }
          Object localObject = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
          ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.addView(this.jdField_c_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    paramWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (paramWebView != null) {
      return paramWebView.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramString);
    }
    return false;
  }
  
  public void c()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("url", this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(3, (Bundle)localObject);
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null) {
      ReportController.b(null, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long), "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.j();
    BaseOpenWebMonitor.d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent());
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.i))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130850434);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getColor(2131167114));
      SimpleUIUtil.a(false, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getColor(2131167114), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().getWindow());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b(paramBoolean);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.k();
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TouchWebView)localObject).getPluginEngine();
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl(), 8589934598L, null);
    }
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl(), 8589934599L, null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject == null) {
      return;
    }
    int j = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296653);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a(j, 0);
      ((View)localObject).setVisibility(8);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131365199).setVisibility(8);
      }
    }
    else
    {
      int i;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
      } else {
        i = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.n)
      {
        j += i;
      }
      else
      {
        j += i * 2;
        i += BaseApplication.getContext().getResources().getDimensionPixelSize(2131299175);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a(j, i);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d.findViewById(2131365199).setVisibility(0);
      }
    }
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity()).inflate(2131563022, null);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void handlePreloadCallback(int paramInt, String paramString) {}
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    if ("handleImage".equals(paramString))
    {
      paramString = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(8);
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
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
    return false;
  }
  
  public boolean interceptTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void loadUrlFinish() {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    if ((paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView) && (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_ComTencentWidgetFadeIconImageView) && (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView))
    {
      IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
      if (localIWebViewSurfaceInjector != null) {
        localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramView);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.doOnBackEvent();
      if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_ComTencentWidgetFadeIconImageView) {
        ReportController.a(null, "dc00898", "", "", "0X8009B1F", "0X8009B1F", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    this.e = false;
    this.d = false;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    if (("Xiaomi_MI 2".equals(((StringBuilder)localObject).toString())) && (Build.VERSION.SDK_INT == 16)) {
      this.jdField_a_of_type_Boolean = true;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramBundle);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent().getBooleanExtra("vasUsePreWebview", false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("web_view_long_click", bool ^ true);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent().getStringExtra("title");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x4000000) == 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("image_long_click", true);
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onFinalState(Bundle paramBundle)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramBundle);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localObject != null) {
      ((IWebViewSurfaceInjector)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramString, paramGeolocationPermissionsCallback);
    }
  }
  
  public void onHideCustomView()
  {
    a();
  }
  
  public void onInitBottomBar(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e();
  }
  
  public void onInitTitleBar(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f();
    f();
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null)
    {
      localIWebViewSurfaceInjector.c(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector.f(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider);
    }
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent(), this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.isPaused) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.c != 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView());
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.j) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebShareInterface().getShare();
    }
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramWebView, paramString);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramWebView, paramString, paramBitmap);
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)1);
    }
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramWebView, paramInt, paramString1, paramString2);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramWebView, paramSslError);
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x8) > 0L) {
        return;
      }
      if (UrlMatcher.a(paramString)) {
        return;
      }
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramWebView, paramString, this.jdField_a_of_type_Boolean);
      }
    }
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return ((SwiftFileChooseHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(128)).a(paramValueCallback, paramFileChooserParams);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_Boolean) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    Util.a("Web_qqbrowser_ShowPreview");
    long l2 = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView().a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D);
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().getWindow().setFlags(1024, 1024);
      WebViewUIUtils.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
      WebViewUIUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getIntent(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getOnclickListener());
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      float f = Utils.a(50.0F, BaseApplication.getContext().getResources());
      int i;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        i = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
        f += i;
      }
      else
      {
        i = 0;
      }
      paramBundle.height = ((int)f);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.C = true;
      int j = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296653);
      boolean bool2;
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m))
      {
        this.d = true;
        this.e = true;
        int k = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299175);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a(j + i * 2, k + i);
        bool2 = true;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.n = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getResource().getDrawable(2130851078));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(-1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.f(-1);
        boolean bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.o)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().a(j + i, i);
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
          bool2 = bool1;
        }
      }
      try
      {
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().getWindow().addFlags(67108864);
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebTitleBarInterface().b(bool2);
      }
      catch (ClassCastException paramBundle)
      {
        WebViewUIUtils.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity(), paramBundle);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m)) {
        g();
      }
      if (!"2105".equals(ThemeUtil.curThemeId)) {}
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.f(Color.parseColor("#03081A"));
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
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler;
    paramBundle.jdField_c_of_type_Boolean = true;
    paramBundle.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView().jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getContentView().jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getCurrentUrl());
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d();
    Util.b("Web_qqbrowser_ShowPreview");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.K = (SystemClock.elapsedRealtime() - l1);
  }
  
  public void onUrlChange(String paramString1, String paramString2) {}
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramWebView, paramString, paramBitmap);
    }
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    IWebViewSurfaceInjector localIWebViewSurfaceInjector = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftInjectorIWebViewSurfaceInjector;
    if (localIWebViewSurfaceInjector != null) {
      localIWebViewSurfaceInjector.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider, paramBundle, paramTouchWebView);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    ((SwiftFileChooseHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(128)).a(paramValueCallback, paramString1, paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getWebShareInterface().reset();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.setCurUrl(paramString);
        paramWebView = new Bundle();
        paramWebView.putString("url", paramString);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(9, paramWebView);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewSurface", 2, "show custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity();
    this.jdField_a_of_type_Int = localActivity.getRequestedOrientation();
    this.jdField_b_of_type_Int = (localActivity.getWindow().getAttributes().flags & 0x400);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplication.getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
      ((ViewGroup)localActivity.getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.A) {
      localActivity.getWindow().setFlags(1024, 1024);
    }
    localActivity.setRequestedOrientation(paramInt);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = paramCustomViewCallback;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_c_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurface
 * JD-Core Version:    0.7.0.1
 */