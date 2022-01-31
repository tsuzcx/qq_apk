package com.tencent.mobileqq.webview.swift;

import akne;
import aknf;
import akng;
import aknh;
import akni;
import aknj;
import aknk;
import aknl;
import aknm;
import aknn;
import akno;
import aknq;
import aknr;
import akns;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
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
import com.tencent.av.utils.UITools;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.CustomScrollView.OnGestureListener;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.PayInterceptHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.PreloadIdleTask;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.utils.UrlMatcher;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.OfflinePluginInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.ShareApiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebFeaturesInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_dc02216;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.opengroup.AppUrlOpenGroup.ReqBody;

public class WebViewFragment
  extends Fragment
  implements View.OnClickListener, View.OnTouchListener, CustomScrollView.OnGestureListener, WebViewCallback, WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter, WebUiUtils.OfflinePluginInterface, WebUiUtils.QQBrowserBaseActivityInterface, WebUiUtils.ShareApiInterface, WebUiUtils.WebFeaturesInterface, WebUiUtils.WebShareInterface, WebUiUtils.WebShareReportInterface, WebUiUtils.WebTitleBarInterface, WebUiUtils.WebUiMethodInterface
{
  public static int g;
  public Intent a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new akng(this);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public AuthorizeConfig a;
  protected FileChooserHelper a;
  public TouchWebView a;
  public Share a;
  public volatile AppInterface a;
  public BrowserAppInterface a;
  public Client.onRemoteRespObserver a;
  protected SonicClientImpl a;
  public SwiftIphoneTitleBarUI a;
  public WebBrowserViewContainer a;
  public volatile WebViewPluginEngine a;
  WebViewWrapper jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper;
  public final SwiftBrowserComponentsProvider a;
  public SwiftBrowserSetting a;
  public SwiftBrowserStatistics a;
  public SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle a;
  public SwiftBrowserUIStyleHandler a;
  protected final SwiftBrowserStateMachineScheduler a;
  IX5WebChromeClient.CustomViewCallback jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback;
  protected final Object a;
  public View d;
  public String d;
  public long e;
  View e;
  public String e;
  int jdField_f_of_type_Int = 0;
  View jdField_f_of_type_AndroidViewView;
  String jdField_f_of_type_JavaLangString = "";
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  protected volatile boolean i;
  public int j;
  public String j;
  boolean j;
  int k;
  public String k;
  public boolean k;
  int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  protected boolean m;
  public String n;
  public boolean n = true;
  public String o;
  public boolean o;
  public String p;
  boolean p = false;
  boolean q;
  protected boolean r;
  
  public WebViewFragment()
  {
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_j_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_o_of_type_Boolean = true;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider = a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler = new SwiftBrowserStateMachineScheduler(new akne(this));
  }
  
  public static WebViewFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new WebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString3 = "vkey=" + paramString3 + ";uin=" + paramString4;
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "<--httpRequest vookies=" + paramString3 + ",appids=" + paramString2);
    }
    paramString2 = new Bundle();
    paramString2.putString("Cookie", paramString3);
    try
    {
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void a(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramView != null)) {
      paramView.addOnLayoutChangeListener(new aknf(this));
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
      int i4 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(super.getResources().getDrawable(2130845871));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(i3, i1, i4, i2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.b);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.e(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_d_of_type_Int);
  }
  
  public void A()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      n();
    }
    HashMap localHashMap;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()) {
        break;
      }
      localHashMap = new HashMap(1);
      localHashMap.put("target", Integer.valueOf(2));
    } while (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(localHashMap));
    o();
    return;
    n();
  }
  
  public void B()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.e();
  }
  
  public final void C()
  {
    a("返回游戏中心继续浏览", 2130837945, null, SingleTaskQQBrowser.class.getName());
  }
  
  public void D()
  {
    d(SwiftWebViewUtils.a(this, this.jdField_a_of_type_AndroidContentIntent));
  }
  
  public int a(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_FINAL");
    Util.a("Web_IPCSetup");
    if (!WebIPCOperator.a().a()) {
      WebIPCOperator.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    Util.b("Web_IPCSetup");
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x400000) > 0L)
    {
      SosoInterface.a(new aknm(this, 0, false, false, 600000L, false, false, "webview"));
      SosoInterface.a(new aknn(this, 0, true, false, 600000L, false, false, "webview"));
    }
    ThreadManager.getUIHandler().postDelayed(new akno(this), 3000L);
    SwiftBrowserIdleTaskHelper.a().a(new aknq(this, 2));
    Util.b("Web_qqbrowser_state_machine_init_FINAL");
    Util.b("Web_qqbrowser_state_machine_all");
    this.jdField_m_of_type_Int = 1;
    return -1;
  }
  
  public final int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.a() == null);
      i1 = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i1 != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewFragment", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i1);
    return -1;
    return i1 << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean)
  {
    return a(paramWebViewPlugin, paramByte);
  }
  
  public final int a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i1 = a(paramWebViewPlugin, paramByte);
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "pluginStartActivityForResult not handled");
      }
      return i1;
    }
    super.startActivityForResult(paramIntent, i1);
    return i1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long;
  }
  
  public Activity a()
  {
    return super.getActivity();
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public CustomWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public Share a()
  {
    return b();
  }
  
  public WebViewFragment a()
  {
    return this;
  }
  
  public final WebViewWrapper a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Long & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper = new WebViewWrapper(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this, this.jdField_a_of_type_AndroidContentIntent, bool1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.a(localTouchWebView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        SwiftBrowserStatistics localSwiftBrowserStatistics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).jdField_a_of_type_Int) {
          bool1 = true;
        }
        localSwiftBrowserStatistics.q = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.p = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.jdField_g_of_type_Boolean) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper;
    }
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 127, null);
  }
  
  public WebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public Object a()
  {
    if ((!this.p) && (14 <= Build.VERSION.SDK_INT) && (Build.VERSION.SDK_INT <= 18))
    {
      AuthorizeConfig localAuthorizeConfig;
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null)
      {
        localAuthorizeConfig = AuthorizeConfig.a();
        this.jdField_a_of_type_ComTencentBizAuthorizeConfig = localAuthorizeConfig;
      }
      while (localAuthorizeConfig.a("enable_custom_am", Boolean.valueOf(false)).booleanValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "using custom AudioManager");
        }
        return new aknr(BaseApplicationImpl.getApplication());
        localAuthorizeConfig = this.jdField_a_of_type_ComTencentBizAuthorizeConfig;
      }
    }
    return null;
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    SwiftBrowserTBSHandler localSwiftBrowserTBSHandler = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(16);
    if (localSwiftBrowserTBSHandler != null) {
      return localSwiftBrowserTBSHandler.a(paramString, paramBundle);
    }
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_g_of_type_JavaLangString.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        super.getActivity().setResult(-1, paramIntent);
        super.getActivity().finish();
      }
      break;
    }
    label226:
    label491:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                QfavBuilder.a(super.getActivity(), paramIntent);
                return;
                localObject = paramIntent.getStringExtra("DELETE_BLOG");
                if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
                break;
                if (paramInt1 != 21) {
                  break label226;
                }
                localObject = AIOUtils.a(new Intent(super.getActivity(), SplashActivity.class), null);
              } while (paramIntent == null);
              ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
              super.startActivity((Intent)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewFragment", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
              }
              localObject = new HashMap();
              ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
              ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
              ((Map)localObject).put("data", paramIntent);
            } while (a(8589934600L, (Map)localObject));
            int i1 = paramInt1 >> 8 & 0xFF;
            if (i1 <= 0) {
              break label454;
            }
            if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
            {
              localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
              if (localObject != null)
              {
                if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (((WebViewPluginEngine)localObject).a("card") == null)) {
                  ((WebViewPluginEngine)localObject).a(new String[] { "card" });
                }
                localObject = ((WebViewPluginEngine)localObject).a(i1, true);
                if (localObject != null)
                {
                  ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(paramInt1 & 0xFF), paramInt2);
                  return;
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.w("WebLog_WebViewFragment", 2, "Caution! activity result not handled!");
          return;
          if ((this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper == null) || (!this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper.a(paramInt1, paramInt2, paramIntent))) {
            break label491;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebLog_WebViewFragment", 2, "Activity result handled by FileChooserHelper.");
        return;
      } while ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null));
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (paramIntent == null);
    label454:
    Object localObject = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
    for (;;)
    {
      try
      {
        if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
          break label708;
        }
        this.jdField_r_of_type_Boolean = bool;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionSucc=" + this.jdField_r_of_type_Boolean);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
      return;
      label708:
      bool = false;
    }
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 82: 
      a(8589934607L, null);
      return;
    case 25: 
      a(8589934608L, null);
      return;
    }
    a(8589934609L, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    SwiftBrowserTBSHandler localSwiftBrowserTBSHandler = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(16);
    if (localSwiftBrowserTBSHandler != null) {
      localSwiftBrowserTBSHandler.a(paramInt, paramString);
    }
  }
  
  void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    AppUrlOpenGroup.ReqBody localReqBody = new AppUrlOpenGroup.ReqBody();
    localReqBody.uint32_appid.set(paramInt);
    localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
    localReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
    paramString.putExtra("cmd", "GroupOpen.CheckAppUrl");
    paramString.putExtra("data", localReqBody.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Intent paramIntent)
  {
    int i1 = -1;
    int i2;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      i2 = paramIntent.getIntExtra("requestCode", -1);
      int i3 = i2 >> 8 & 0xFF;
      if (i3 > 0) {
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(i3, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label520;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(i2 & 0xFF), i1);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewFragment", 2, "Caution! activity result not handled!");
      }
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
      {
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
          break label515;
        }
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
        if (localObject == null) {
          break label515;
        }
        localObject = ((WebViewPluginEngine)localObject).a(120, true);
        if ((localObject == null) || (!(localObject instanceof BuscardJsPlugin))) {
          break label515;
        }
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
      }
      label515:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          BuscardHelper.a(this.jdField_e_of_type_JavaLangString, super.getActivity(), paramIntent);
        }
        localObject = new HashMap();
        ((Map)localObject).put("intent", paramIntent);
        a(128L, (Map)localObject);
        if (("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction"))) || ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("fromNotification", false))) {
          break;
        }
        localObject = paramIntent.getDataString();
        if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
        }
        for (;;)
        {
          boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "doOnNewIntent, isPhotoPlusEditSend = " + bool);
          }
          if (!bool) {
            break;
          }
          paramIntent.removeExtra("PhotoConst.SEND_FLAG");
          localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break;
          }
          localObject = (String)((ArrayList)localObject).get(0);
          QLog.d("WebLog_WebViewFragment", 2, "editScreenShotBack:" + (String)localObject);
          SwiftBrowserScreenShotHandler localSwiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(64);
          if (localSwiftBrowserScreenShotHandler == null) {
            break;
          }
          localSwiftBrowserScreenShotHandler.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
          return;
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          t();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
          if (paramIntent.getBooleanExtra("onNewIntentReDoStateMachine", true))
          {
            this.jdField_m_of_type_Int = 2;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(paramIntent.getExtras());
          }
        }
      }
      label520:
      i1 = 0;
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(paramIntent, paramString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.jdField_k_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4, localBundle);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {}
    for (paramConfiguration = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();; paramConfiguration = null)
    {
      if (paramConfiguration != null) {
        paramConfiguration.a(this.jdField_g_of_type_JavaLangString, 8589934611L, null);
      }
      return;
    }
  }
  
  public void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "show custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.jdField_k_of_type_Int = super.getActivity().getRequestedOrientation();
    this.jdField_l_of_type_Int = (super.getActivity().getWindow().getAttributes().flags & 0x400);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getApplication());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
      ((ViewGroup)super.getActivity().getWindow().getDecorView()).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.v) {
      super.getActivity().getWindow().setFlags(1024, 1024);
    }
    super.getActivity().setRequestedOrientation(paramInt);
    this.q = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
    this.jdField_e_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = paramCustomViewCallback;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i1 = a(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i1);
    super.startActivity(paramIntent);
  }
  
  public void a(ValueCallback paramValueCallback, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper == null) {
      this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper = new FileChooserHelper();
    }
    this.jdField_a_of_type_ComTencentBizCommonUtilFileChooserHelper.a(super.getActivity(), 0, paramValueCallback, paramString1, paramString2);
  }
  
  public void a(WebView paramWebView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)1);
    }
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    x();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    QLog.e("WebLog_WebViewFragment", 1, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + Util.b(paramString2, new String[0]));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramInt, paramString1, paramString2);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      x();
      if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int == 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 8;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.jdField_j_of_type_Boolean = true;
      this.jdField_f_of_type_Int = 100;
      Object localObject = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(-2);
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)) {
        ((SwiftBrowserStatistics)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.a().getFinalResultCode();
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(7, (Bundle)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_g_of_type_Boolean = false;
        b();
        SwiftBrowserIdleTaskHelper.a().a(new SwiftBrowserIdleTaskHelper.PreloadIdleTask(1));
        if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("banner_fromBanner", false))
        {
          localObject = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("banner_webview_extra");
          if ((localObject != null) && (((Bundle)localObject).containsKey("AIO_Scroll_Y")))
          {
            int i1 = ((Bundle)localObject).getInt("AIO_Scroll_Y");
            if ((i1 > 0) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView() != null)) {
              ThreadManager.getUIHandler().post(new aknh(this, i1));
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.pageFinish(paramString);
      }
      if ((Build.VERSION.SDK_INT >= 19) && (!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.a() != null)) {
        b(paramWebView, paramWebView.getTitle());
      }
      localObject = a();
      if ((localObject instanceof QQBrowserActivity)) {
        ((QQBrowserActivity)localObject).a(paramWebView, paramString);
      }
    } while (!(paramWebView instanceof CustomWebView));
    BusinessReporter.a((CustomWebView)paramWebView);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      x();
      paramWebView = new Bundle();
      paramWebView.putString("url", paramString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(6, paramWebView);
    } while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.f);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Long + "", this.jdField_g_of_type_JavaLangString, HttpUtil.a() + "", this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.f = false;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(paramString, paramInt);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    QLog.d("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK " + paramString1 + "," + paramInt + "," + paramString2 + "," + paramString3);
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("from_single_task", false))
    {
      QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK call from normal activity, ignore.");
      return;
    }
    Bundle localBundle1 = DataFactory.a("ipc_qqbrowser_to_conversation", "", 0, null);
    localBundle1.putInt("banner_msg", 1134049);
    Bundle localBundle2 = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "标题为空";
    }
    localBundle2.putString("tips", str);
    localBundle2.putString("iconURL", paramString2);
    localBundle2.putInt("icon", paramInt);
    localBundle2.putInt("timeout", 900000);
    localBundle2.putString("url", this.jdField_g_of_type_JavaLangString);
    localBundle2.putString("activity", paramString3);
    localBundle2.putInt("flags", 335544320);
    localBundle1.putBundle("barInfo", localBundle2);
    WebIPCOperator.a().b(localBundle1);
    paramString1 = new Intent();
    paramString1.setClass(getActivity(), SplashActivity.class);
    paramString1.setFlags(335544320);
    paramString1.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
    paramString1.putExtra("fragment_id", 1);
    startActivity(paramString1);
  }
  
  public void a(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          str = paramString;
          if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {
            str = "http://" + paramString + "/";
          }
        }
      }
    }
    paramGeolocationPermissionsCallback.invoke(str, this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(str, "publicAccount.getLocation"), false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramJsBridgeListener, paramOnClickListener);
    ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).d();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(paramJSONObject, true);
  }
  
  public void a(boolean paramBoolean) {}
  
  @TargetApi(14)
  public boolean a()
  {
    Util.a("Web_qqbrowser_ShowPreview");
    long l1 = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.y);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      y();
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init view 1, cost = " + (System.nanoTime() - l1) / 1000000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_g_of_type_JavaLangString);
      Util.b("Web_qqbrowser_ShowPreview");
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(this.jdField_a_of_type_AndroidContentIntent, this);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    float f1 = UITools.a(BaseApplicationImpl.getApplication(), 50.0F);
    int i1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i1 = ImmersiveUtils.a(BaseApplicationImpl.getApplication());
      f1 += i1;
    }
    for (;;)
    {
      localLayoutParams.height = ((int)f1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.x = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_k_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_l_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(super.getResources().getDrawable(2130846407));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(-1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.e(-1);
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_m_of_type_Boolean) {
          break label500;
        }
        b(i1, i1);
      }
      label500:
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_k_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
        }
        for (bool2 = bool1;; bool2 = true)
        {
          if (ImmersiveUtils.isSupporImmersive() == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.a(BaseApplicationImpl.getApplication()), 0, 0);
            super.getActivity().getWindow().addFlags(67108864);
          }
          f(bool2);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_k_of_type_Boolean)) {
            break;
          }
          f();
          break;
          this.n = true;
          this.jdField_o_of_type_Boolean = true;
          b(i1 * 2, i1 + BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558449));
        }
      }
      i1 = 0;
    }
  }
  
  public boolean a(long paramLong, Map paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  @TargetApi(11)
  public boolean a(Bundle paramBundle)
  {
    AIOOpenWebMonitor.a(this.jdField_a_of_type_AndroidContentIntent);
    Object localObject = (SwiftBrowserNavigator)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(1);
    if ((localObject != null) && (!((SwiftBrowserNavigator)localObject).a(this.jdField_a_of_type_AndroidContentIntent)))
    {
      super.getActivity().finish();
      return true;
    }
    t();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_AndroidContentIntent);
    s();
    if (!b(d())) {
      ThreadManager.post(new akni(this), 5, null, true);
    }
    Util.a("Web_qqbrowser_dooncreate");
    this.jdField_o_of_type_Boolean = false;
    this.n = false;
    StatisticCollector.a(BaseApplicationImpl.getApplication(), 10000L);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.t = System.currentTimeMillis();
    this.jdField_g_of_type_Boolean = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
    this.jdField_h_of_type_Boolean = false;
    ((SwiftBrowserStatistics)localObject).jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.u = System.currentTimeMillis();
    Util.a("Web_qqbrowser_state_machine_all");
    this.jdField_m_of_type_Int = 2;
    if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.jdField_c_of_type_Int > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a();
    }
    WebAccelerateHelper.isWebViewCache = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putString("url", this.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(5, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_o_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long);
    Util.b("Web_qqbrowser_dooncreate");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.y = System.currentTimeMillis();
    return true;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    boolean bool1 = bool2;
    if (super.getActivity().isResume()) {
      if (System.currentTimeMillis() - this.jdField_e_of_type_Long >= 1000L)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), (String)localObject2).booleanValue()) {}
      }
      else
      {
        long l1 = System.currentTimeMillis();
        bool1 = PayInterceptHelper.a().a(paramString, this);
        QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool1 + " cost:" + (System.currentTimeMillis() - l1) + " ms.");
        if (!bool1) {
          break label133;
        }
        bool1 = true;
      }
    }
    return bool1;
    label133:
    localObject1 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
    ((Intent)localObject1).addFlags(268435456);
    try
    {
      localObject2 = ((Intent)localObject1).resolveActivityInfo(getActivity().getPackageManager(), 0);
      paramString = "";
      if (localObject2 != null) {
        paramString = ((ActivityInfo)localObject2).packageName;
      }
      StartAppCheckHandler.a("scheme", paramWebView.getUrl(), paramString, "1", "web", getActivity().getClass().getName());
      super.startActivity((Intent)localObject1);
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramWebView);
      }
    }
    return true;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return b().a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return b().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return b().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public int b()
  {
    return super.getResources().getDimensionPixelSize(2131558448);
  }
  
  public int b(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_titlebar");
    a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_g_of_type_JavaLangString);
    v();
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (paramBundle != null)
    {
      this.jdField_h_of_type_Int = paramBundle.getInt("uin_type");
      this.jdField_i_of_type_JavaLangString = paramBundle.getString("puin");
      this.jdField_j_of_type_JavaLangString = paramBundle.getString("msg_id");
      if (this.jdField_j_of_type_JavaLangString == null) {
        this.jdField_j_of_type_JavaLangString = "";
      }
      this.jdField_k_of_type_JavaLangString = paramBundle.getString("source_puin");
      if (this.jdField_k_of_type_JavaLangString == null) {
        this.jdField_k_of_type_JavaLangString = "";
      }
      this.jdField_l_of_type_JavaLangString = paramBundle.getString("friendUin");
      if (this.jdField_l_of_type_JavaLangString == null) {
        this.jdField_l_of_type_JavaLangString = "";
      }
      boolean bool = paramBundle.getBoolean("isOpeningQunApp");
      this.jdField_i_of_type_Int = paramBundle.getInt("appid");
      this.jdField_j_of_type_Int = paramBundle.getInt("troopid");
      String str = paramBundle.getString("extraParams");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131433698));
        a(this.jdField_i_of_type_Int, paramBundle, new aknl(this));
      }
    }
    this.jdField_m_of_type_Int = 512;
    ((SwiftBrowserShareMenuHandler)b().a(4)).d();
    Util.b("Web_qqbrowser_state_machine_init_titlebar");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
      }
      return -1;
    }
    return 1;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_Long;
  }
  
  public Activity b()
  {
    return BaseActivity.sTopActivity;
  }
  
  public View b()
  {
    if (this.jdField_f_of_type_AndroidViewView == null) {
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(super.getActivity()).inflate(2130971713, null);
    }
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  Share b()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity());
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
  }
  
  public SwiftBrowserComponentsProvider b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider;
  }
  
  public String b()
  {
    String str2 = this.jdField_g_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) {
          break label46;
        }
        str1 = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      }
    }
    return str1;
    label46:
    return this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
  }
  
  public String b(String paramString)
  {
    paramString = a(BaseApplicationImpl.getApplication(), "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("vkey"), this.jdField_e_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  public void b()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null) {
      localSwiftBrowserShareMenuHandler.a(b(), this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long);
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.findViewById(2131366767);
    if (localObject1 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((LinearLayout.LayoutParams)localObject2).topMargin += paramInt1;
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.findViewById(2131366769);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((FrameLayout.LayoutParams)localObject2).topMargin += paramInt2;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    while ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) || ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Long & 0x8) > 0L) || (UrlMatcher.a(paramString)) || (paramString == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramWebView, paramString, this.jdField_m_of_type_Boolean);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_j_of_type_Boolean) && (PublicAccountUtil.a(paramString, this.jdField_f_of_type_Int, this.jdField_f_of_type_JavaLangString))) {
      this.jdField_j_of_type_Boolean = true;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.jdField_d_of_type_JavaLangString = paramString2;
    SwiftBrowserCookieMonster.d();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c(paramString2);
  }
  
  public boolean b()
  {
    if (getActivity() != null) {
      return getActivity().isResume();
    }
    return false;
  }
  
  public boolean b(WebView paramWebView, String paramString)
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return true;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_d_of_type_Boolean = false;
    }
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      o();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.jdField_g_of_type_JavaLangString = paramString;
        localObject = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
        if (localObject != null) {
          ((SwiftBrowserShareMenuHandler)localObject).a(this.jdField_g_of_type_JavaLangString);
        }
        localObject = (SwiftBrowserScreenShotHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(64);
        if (localObject != null) {
          ((SwiftBrowserScreenShotHandler)localObject).a(this.jdField_g_of_type_JavaLangString);
        }
      }
    }
    if (super.getActivity().isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    Object localObject = SwiftWebViewUtils.a(paramString);
    if (("http".equals(localObject)) || ("https".equals(localObject)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebLog_WebViewFragment", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        this.jdField_d_of_type_JavaLangString = paramString;
        SwiftBrowserCookieMonster.d();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c(paramString);
      }
    }
    return false;
  }
  
  boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "initSonicSession url = :" + paramString);
    }
    for (;;)
    {
      int i1;
      try
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        Object localObject = Uri.parse(paramString);
        if (((Uri)localObject).isHierarchical())
        {
          localObject = ((Uri)localObject).getQueryParameter("_sonic_xv");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            HashMap localHashMap = new HashMap();
            long l1 = Long.parseLong((String)localObject);
            if ((0x2 & l1) == 0L) {
              break label298;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l1) == 0L) {
              break label304;
            }
            i1 = 1;
            break label286;
            label138:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l1) == 0L) {
              break label317;
            }
            bool = true;
            localBuilder.setSupportCacheControl(bool);
          }
        }
        localObject = WebAccelerateHelper.getSonicEngine().createSession(paramString, localBuilder.build());
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
          ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
          return true;
        }
        QLog.d("WebLog_WebViewFragment", 1, "initSonicSession sonicSession = null, url = " + paramString);
        return false;
      }
      catch (Exception localException)
      {
        QLog.e("WebLog_WebViewFragment", 1, "initSonicSession exception, url = " + paramString, localException);
        return false;
      }
      for (;;)
      {
        label286:
        if (i1 == 0) {
          break label309;
        }
        str = "store";
        break label138;
        label298:
        bool = false;
        break;
        label304:
        i1 = 0;
      }
      label309:
      String str = "true";
      continue;
      label317:
      boolean bool = false;
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_d_of_type_Int;
  }
  
  public int c(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_ui_main_content");
    Util.a("Web_qqbrowser_initView");
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup instanceof RefreshView)) {
        ((RefreshView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup).setOnFlingGesture(this);
      }
    }
    try
    {
      paramBundle = new URL(this.jdField_g_of_type_JavaLangString);
      if (PreloadManager.a().a(paramBundle.getHost())) {
        h(true);
      }
      Util.b("Web_qqbrowser_initView");
      if (this.jdField_l_of_type_Boolean) {
        QzoneOnlineTimeCollectRptService.a().b(1);
      }
      Util.b("Web_qqbrowser_state_machine_init_ui_main_content");
      this.jdField_m_of_type_Int = 256;
      return 1;
    }
    catch (MalformedURLException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(paramInt);
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_JavaLangString, new String[] { "" });
        return true;
      }
    }
    return false;
  }
  
  public boolean c(WebView paramWebView, String paramString)
  {
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return true;
    }
    Util.a("urlInterceptManager");
    paramWebView = SwiftWebViewUtils.a(paramString);
    if ((("http".equals(paramWebView)) || ("data".equals(paramWebView))) && ((super.getActivity() instanceof QQBrowserActivity))) {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a != null))
      {
        paramWebView = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a.a(paramString);
        if (paramWebView != null)
        {
          paramString = new Intent(super.getActivity(), JumpActivity.class);
          paramString.setData(Uri.parse(paramWebView));
          paramString.putExtra("from", "webview");
          super.startActivity(paramString);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("WebLog_WebViewFragment", 2, "URLInterceptManager = null");
      }
    }
    Util.b("urlInterceptManager");
    return false;
  }
  
  public boolean c(String paramString)
  {
    return ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).a(paramString);
  }
  
  public int d(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_webview");
    e();
    Util.b("Web_qqbrowser_state_machine_init_webview");
    this.jdField_m_of_type_Int = 32;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.w = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_r_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.w - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.v);
    return 0;
  }
  
  public String d()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a())
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_g_of_type_JavaLangString, 8589934598L, null);
      }
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_g_of_type_JavaLangString, 8589934599L, null);
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("flow_key_from_guide", false))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(BaseApplicationImpl.getApplication(), SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
        ((Intent)localObject).addFlags(67108864);
        super.startActivity((Intent)localObject);
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.e(paramInt);
  }
  
  public final void d(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.A) && (paramBundle != null))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(getActivity(), SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
      localIntent.putExtra("fragment_id", 1);
      if (paramBundle.containsKey("banner_activityName"))
      {
        localIntent.putExtra("banner_activityName", paramBundle.getString("banner_activityName"));
        if (paramBundle.containsKey("banner_activityFlag")) {
          localIntent.putExtra("banner_activityFlag", paramBundle.getInt("banner_activityFlag"));
        }
        if (!paramBundle.containsKey("banner_webViewUrl")) {
          break label322;
        }
        localIntent.putExtra("banner_webViewUrl", paramBundle.getString("banner_webViewUrl"));
        label145:
        if (!paramBundle.containsKey("banner_wording")) {
          break label348;
        }
        localIntent.putExtra("banner_wording", paramBundle.getString("banner_wording"));
        label171:
        if (!paramBundle.containsKey("banner_businessCategory")) {
          break label510;
        }
        localIntent.putExtra("banner_businessCategory", paramBundle.getString("banner_businessCategory"));
        label197:
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_c_of_type_AndroidWidgetImageView != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (!paramBundle.containsKey("banner_webview_extra")) {
          break label570;
        }
      }
      label570:
      for (paramBundle = paramBundle.getBundle("banner_webview_extra");; paramBundle = new Bundle())
      {
        if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView() != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().getScrollY() > 0)) {
          paramBundle.putInt("AIO_Scroll_Y", this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().getScrollY());
        }
        localIntent.putExtra("banner_webview_extra", paramBundle);
        startActivity(localIntent);
        return;
        localIntent.putExtra("banner_activityName", QQBrowserActivity.class.getName());
        break;
        label322:
        if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          break label145;
        }
        localIntent.putExtra("banner_webViewUrl", this.jdField_g_of_type_JavaLangString);
        break label145;
        label348:
        Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).trim();
          label368:
          String str = SwiftWebViewUtils.a((String)localObject);
          if ((!"http".equals(str)) && (!"https".equals(str)) && (!"data".equals(str)) && (!"file".equals(str)) && (!((String)localObject).startsWith("about")) && (!((String)localObject).startsWith("base64"))) {
            break label490;
          }
        }
        label490:
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 != 0) || (((String)localObject).length() <= 1)) {
            break label495;
          }
          localIntent.putExtra("banner_wording", String.format("正在浏览 %s", new Object[] { this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle() }));
          break;
          localObject = "";
          break label368;
        }
        label495:
        localIntent.putExtra("banner_wording", "返回继续浏览");
        break label171;
        label510:
        if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          break label197;
        }
        localObject = Uri.parse(this.jdField_g_of_type_JavaLangString);
        if (!((Uri)localObject).isHierarchical()) {
          break label197;
        }
        localIntent.putExtra("banner_businessCategory", "WebView_" + ((Uri)localObject).getHost());
        break label197;
      }
    }
    QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean;
  }
  
  public int e(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c) {
      a();
    }
    this.jdField_m_of_type_Int = 128;
    Util.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public String e()
  {
    if (b() == null) {
      return "";
    }
    return b().a();
  }
  
  public void e()
  {
    int i1 = -1;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(null).a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new akns(this));
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x10000) == 0L) {
        break label410;
      }
      i1 = 2;
      if (AppSetting.e) {
        i1 = 2;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i1);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i1);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k = (l2 - l1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.x = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k);
      }
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() == null) {
        break label465;
      }
      i1 = 1;
      label224:
      if (i1 != 0)
      {
        Bundle localBundle = SwiftWebViewUtils.a();
        if (localBundle != null) {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.s) {
          break label470;
        }
        l1 = 2L;
        if (!(this.jdField_a_of_type_ComTencentBizUiTouchWebView instanceof SwiftReuseTouchWebView)) {
          break label494;
        }
        if (1 != ((SwiftReuseTouchWebView)this.jdField_a_of_type_ComTencentBizUiTouchWebView).jdField_a_of_type_Int) {
          break label489;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Long.valueOf(SwiftWebAccelerator.TbsAccelerator.jdField_a_of_type_Long) }));
      }
      System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.reportInitPerformance(l1, i1, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long, SwiftWebAccelerator.TbsAccelerator.jdField_a_of_type_Long);
      System.currentTimeMillis();
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
      }
      return;
      label410:
      switch (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("reqType", -1))
      {
      case 2: 
      case 3: 
      default: 
        break;
      case 1: 
        i1 = 2;
        break;
      case 4: 
        i1 = 0;
        break;
        label465:
        i1 = 0;
        break label224;
        label470:
        if (SwiftBrowserStatistics.jdField_o_of_type_Boolean) {}
        for (i1 = 1;; i1 = 0)
        {
          l1 = i1;
          break;
        }
        label489:
        i1 = 0;
        continue;
        label494:
        i1 = 0;
      }
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e()
  {
    return this.jdField_r_of_type_Boolean;
  }
  
  public int f(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("3565");
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("options");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("url", paramBundle.getString("url"));
      if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("key_isReadModeEnabled")) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("key_isReadModeEnabled", true);
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("ba_is_login", paramBundle.optBoolean("ba_is_login", true));
      this.jdField_a_of_type_AndroidContentIntent.putExtra("isShowAd", paramBundle.optBoolean("isShowAd", true));
      this.jdField_a_of_type_AndroidContentIntent.putExtra("avoidLoginWeb", paramBundle.optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        boolean bool;
        int i2;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("WebLog_WebViewFragment", 2, paramBundle.toString());
          continue;
          i1 = 0;
          continue;
          bool = false;
        }
      }
    }
    if (("Xiaomi_MI 2".equals(Build.MANUFACTURER + "_" + Build.MODEL)) && (Build.VERSION.SDK_INT == 16)) {
      this.jdField_m_of_type_Boolean = true;
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("articalChannelId", 100);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("ARTICAL_CHANNEL_EXTRAL_INFO");
    this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromQZone", false);
    bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    i2 = hashCode();
    if (bool)
    {
      i1 = 1;
      ViewExposeUtil.a(paramBundle, i2, i1, this.jdField_g_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("vasUsePreWebview", false)) {
        break label477;
      }
      bool = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("web_view_long_click", bool);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("individuation_url_type", -1);
      if (jdField_g_of_type_Int == 1) {
        SwiftBrowserStatistics.CrashStepStatsEntry.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b == -1) && (SwiftBrowserStatistics.CrashStepStatsEntry.jdField_d_of_type_Int != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.b = SwiftBrowserStatistics.CrashStepStatsEntry.jdField_d_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_b_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("title");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x4000000) == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("image_long_click", true);
      }
      Util.b("Web_qqbrowser_state_machine_init_data");
      this.jdField_m_of_type_Int = 4;
      return 0;
    }
  }
  
  public String f()
  {
    return this.jdField_j_of_type_JavaLangString;
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.n) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getActivity().getWindow().addFlags(67108864);
      if (this.jdField_o_of_type_Boolean) {
        if (this.jdField_d_of_type_AndroidViewView == null)
        {
          this.jdField_d_of_type_AndroidViewView = new View(super.getActivity());
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
            break label195;
          }
          this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_a_of_type_Int);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidViewView.getParent() == null)
      {
        if (paramBoolean)
        {
          localObject = new View(super.getActivity());
          ((View)localObject).setId(2131362370);
          ((View)localObject).setBackgroundColor(-16777216);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.a(BaseApplicationImpl.getApplication()));
          localLayoutParams.addRule(10, -1);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.addView((View)localObject, localLayoutParams);
        }
        Object localObject = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.a(BaseApplicationImpl.getApplication()));
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
      return;
      label195:
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130845872);
      } else {
        this.jdField_d_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131494254));
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean;
  }
  
  public int g(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_x5_environment");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.v = System.currentTimeMillis();
    this.jdField_m_of_type_Int = 8;
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
  
  public String g()
  {
    return this.jdField_i_of_type_JavaLangString;
  }
  
  public void g()
  {
    Util.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    c();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_h_of_type_Long > 0L))
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_h_of_type_Long) / 1000000L), "", "", "", "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_h_of_type_Long = 0L;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n = System.currentTimeMillis();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n;
    l1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_b_of_type_Long;
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_g_of_type_JavaLangString);
    }
    Util.b("Web_readyToLoadUrl");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_g_of_type_JavaLangString, 0, 0, 0, 0, 0, null);
  }
  
  public void g(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup instanceof RefreshView))) {
      ((RefreshView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup).b(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForJS enable=" + paramBoolean);
    }
  }
  
  public int h(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin() != 0L)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin() % SwiftBrowserStatistics.jdField_d_of_type_Int != 6L) {
        break label183;
      }
    }
    label183:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.e = bool;
      r();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(a().getStringArrayExtra("insertPluginsArray"));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_g_of_type_JavaLangString, 1L, null);
      }
      this.jdField_m_of_type_Int = 16;
      Util.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
      return 1;
    }
  }
  
  public String h()
  {
    return this.jdField_k_of_type_JavaLangString;
  }
  
  public void h(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup instanceof RefreshView))) {
      ((RefreshView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewViewGroup).c(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForHost enable=" + paramBoolean);
    }
  }
  
  public int i(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_load_url");
    long l1 = System.currentTimeMillis();
    Util.a("Web_qqbrowser_init");
    g();
    Util.b("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.l = (l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "init param and load url, cost = " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.l);
    }
    Util.b("Web_qqbrowser_state_machine_load_url");
    this.jdField_m_of_type_Int = 64;
    return 0;
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void j(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void k(boolean paramBoolean)
  {
    this.jdField_o_of_type_Boolean = paramBoolean;
  }
  
  public void l(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b(paramBoolean);
    ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).d();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f();
  }
  
  public void n()
  {
    if (1 != this.jdField_m_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_m_of_type_Int = 1;
    }
    if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(BaseApplicationImpl.getApplication(), this.jdField_g_of_type_JavaLangString);
    AIOOpenWebMonitor.c(this.jdField_a_of_type_AndroidContentIntent);
    if (this.q) {
      q();
    }
    HashMap localHashMap;
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.clearHistory();
        }
        localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
      } while (a(8589934601L, localHashMap));
      if (((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x4) != 0L) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934610L, localHashMap);
    return;
    super.getActivity().finish();
  }
  
  public void o()
  {
    b().b();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((a() != null) && (a().isFinishing()))
    {
      QLog.e("WebLog_WebViewFragment", 1, "HostActivity " + a() + " is finishing! Don't call WebViewFragment.doOnCreate!");
      return;
    }
    a(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidContentIntent = ((Intent)super.getArguments().getParcelable("intent"));
    Bundle localBundle;
    if (this.jdField_a_of_type_AndroidContentIntent == null)
    {
      localBundle = null;
      if (localBundle != null)
      {
        if (localBundle.getClassLoader() != null) {
          break label82;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "No classloader for this fragment");
        }
        this.jdField_a_of_type_AndroidContentIntent.setExtrasClassLoader(WebViewTitleStyle.class.getClassLoader());
      }
    }
    for (;;)
    {
      super.onAttach(paramActivity);
      return;
      localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      break;
      label82:
      QLog.d("WebLog_WebViewFragment", 2, "already has classloader for this fragment: " + localBundle.getClassLoader());
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    label286:
    label313:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  return;
                  if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView)
                  {
                    n();
                    return;
                  }
                  if ((paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d))
                  {
                    if (SwiftBrowserShareMenuHandler.jdField_b_of_type_Long != -1L) {
                      SwiftBrowserShareMenuHandler.jdField_b_of_type_Long = -1L;
                    }
                    paramView = new Intent();
                    paramView.setAction("SignInSbumited");
                    BaseApplicationImpl.getApplication().sendBroadcast(paramView);
                    if (!c())
                    {
                      ReportCenter.a().a("", "", "", "1000", "100", "0", false);
                      b();
                    }
                    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView != null)
                    {
                      paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView.getParent();
                      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
                        ((ViewGroup)paramView).removeView(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView);
                      }
                    }
                  }
                  else
                  {
                    if (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_c_of_type_AndroidWidgetTextView) {
                      break;
                    }
                    paramView = b();
                    if ((paramView != null) && (paramView.contains("checkin/index")))
                    {
                      paramView = new Intent();
                      paramView.setAction("SignInSbumited");
                      BaseApplicationImpl.getApplication().sendBroadcast(paramView);
                    }
                    if (!c())
                    {
                      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_j_of_type_Boolean) {
                        break label286;
                      }
                      n();
                    }
                    for (;;)
                    {
                      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView == null) {
                        break label313;
                      }
                      paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView.getParent();
                      if ((paramView == null) || (!(paramView instanceof ViewGroup))) {
                        break;
                      }
                      ((ViewGroup)paramView).removeView(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView);
                      return;
                      ReportCenter.a().a("", "", "", "1000", "100", "0", false);
                      b();
                    }
                  }
                }
                if (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_d_of_type_AndroidViewView) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.b.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
                super.getActivity().finish();
                ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
              } while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.C);
              LpReportInfo_dc02216.reportExit();
              return;
              if (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_f_of_type_AndroidViewView) {
                break;
              }
              if (SwiftBrowserShareMenuHandler.jdField_b_of_type_Long != -1L) {
                SwiftBrowserShareMenuHandler.jdField_b_of_type_Long = -1L;
              }
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.b.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
              b();
              ReportCenter.a().a("", "", "", "1000", "100", "0", false);
              ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
            } while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.C);
            LpReportInfo_dc02216.reportShare();
            return;
            if (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.h) {
              break;
            }
            paramView = new Intent(super.getActivity(), QQBrowserActivity.class);
            paramView.putExtra("key_isReadModeEnabled", true);
            paramView.putExtra("url", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
            super.startActivity(paramView);
            super.getActivity().finish();
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
          } while (!QLog.isColorLevel());
          QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
          return;
          if (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.g) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.b.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
          if (!TextUtils.isEmpty(a().q))
          {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(a().q, new String[] { "" });
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewFragment", 2, "call js function getShare().mOnShareHandler");
            }
          }
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "senddesk", "", "", "");
        } while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.C);
        LpReportInfo_dc02216.reportExit();
        return;
      } while (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_e_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.i.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.B)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle())) {}
        for (paramView = "游戏中心";; paramView = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle())
        {
          a(String.format("返回%s继续浏览", new Object[] { paramView }), 2130837945, null, SingleTaskQQBrowser.class.getName());
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "fold", "", "", "");
          return;
        }
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.A);
    a().D();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = ((SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting = ((SwiftBrowserSetting)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(-1));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(-2));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = ((WebBrowserViewContainer)WebAccelerateHelper.preloadBrowserView);
      WebAccelerateHelper.preloadBrowserView = null;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_r_of_type_Boolean = true;
    }
    for (;;)
    {
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setLayoutParams(paramLayoutInflater);
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = new WebBrowserViewContainer(super.getActivity());
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "doOnDestroy");
    }
    if (1 != this.jdField_m_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_m_of_type_Int = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    Object localObject = Long.valueOf(this.jdField_a_of_type_AndroidContentIntent.getLongExtra("Gif_msg_uniseq_key", 0L));
    if (((Long)localObject).longValue() > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("Gif_msg_uniseq_key", ((Long)localObject).longValue());
      localObject = DataFactory.a("close_annimate", null, -1, localBundle);
      WebIPCOperator.a().a((Bundle)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver != null) {
      WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(3, (Bundle)localObject);
      u();
      if (QQBrowserActivity.jdField_c_of_type_Int == 0)
      {
        WebIPCOperator.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        SwiftBrowserStatistics.CrashStepStatsEntry.jdField_d_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginShare.c();
      }
      localObject = ViewExposeUtil.a(getClass(), hashCode());
      if (localObject != null) {
        ReportController.b(null, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long), "", "", "");
      }
      SwiftBrowserIdleTaskHelper.a().a(2);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.g();
      AIOOpenWebMonitor.d(super.getActivity().getIntent());
      super.onDestroy();
      return;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      a(512L, null);
      return;
    }
    a(256L, null);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onPause");
    }
    if (this.q) {
      q();
    }
    String str = BridgeHelper.a(super.getActivity(), this.jdField_e_of_type_JavaLangString).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(super.getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(1, null);
    a(8589934597L, null);
    if (this.jdField_l_of_type_Boolean) {
      QzoneOnlineTimeCollectRptService.a().a();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    Util.a("Web_qqbrowser_doonresume");
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).putExtra("selfuin", this.jdField_e_of_type_JavaLangString);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    localObject = BridgeHelper.a(super.getActivity(), this.jdField_e_of_type_JavaLangString).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(super.getActivity());
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", this.jdField_m_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(2, (Bundle)localObject);
    localObject = a();
    int i1;
    if ((localObject instanceof QQBrowserActivity))
    {
      WebViewFragment localWebViewFragment = ((QQBrowserActivity)localObject).b();
      if (localWebViewFragment != null) {
        if (localWebViewFragment == this) {
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        a(2L, null);
      }
      ThreadManager.executeOnSubThread(new aknk(this, (Activity)localObject));
      if (this.jdField_l_of_type_Boolean) {
        QzoneOnlineTimeCollectRptService.a().b(1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
        y();
      }
      Util.b("Web_qqbrowser_doonresume");
      super.onResume();
      return;
      i1 = 0;
      continue;
      i1 = 1;
    }
  }
  
  public void onStop()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "close on hide by wv param");
      }
      super.getActivity().finish();
    }
    super.onStop();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      if (paramView.getId() == 2131366431)
      {
        paramMotionEvent = paramView.getParent();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof ViewGroup))) {
          ((ViewGroup)paramMotionEvent).removeView(paramView);
        }
      }
    }
    return false;
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "hide custom view called");
    }
    if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback == null) {
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setKeepScreenOn(false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback.onCustomViewHidden();
    try
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      label57:
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.v) {
        super.getActivity().getWindow().setFlags(this.jdField_l_of_type_Int, 1024);
      }
      super.getActivity().setRequestedOrientation(this.jdField_k_of_type_Int);
      this.jdField_e_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = null;
      this.jdField_f_of_type_AndroidViewView = null;
      this.q = false;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  final void r()
  {
    synchronized (SwiftWebAccelerator.jdField_a_of_type_JavaLangObject)
    {
      if (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
        WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "-->web engine and plugin initialized at process preload!");
        }
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity());
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a();
        WebAccelerateHelper.getInstance().bindFragment(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), null, null);
    WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity());
    WebAccelerateHelper.getInstance().bindFragment(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this);
  }
  
  void s()
  {
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = true;
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
      if (WebSoUtils.b(str)) {
        ThreadManager.postImmediately(new aknj(this, str), null, false);
      }
    }
  }
  
  void t()
  {
    this.jdField_g_of_type_JavaLangString = d();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_g_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long != 4L)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x2) != 0L) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("hide_more_button", true);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 1L) != 0L) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x100000) > 0L) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("ignoreLoginWeb", true);
      }
    }
  }
  
  void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    SwiftBrowserStatistics localSwiftBrowserStatistics = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
    this.jdField_h_of_type_Boolean = true;
    localSwiftBrowserStatistics.jdField_h_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewWrapper = null;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void v()
  {
    Util.a("Web_qqbrowser_createtabbar");
    Activity localActivity = a();
    if ((localActivity instanceof QQBrowserActivity)) {
      ((QQBrowserActivity)localActivity).d();
    }
    Util.b("Web_qqbrowser_createtabbar");
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_g_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      a(8589934604L, null);
    }
    if ((this.jdField_d_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_g_of_type_Boolean))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130845872);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131494254));
  }
  
  void x()
  {
    if (1 != this.jdField_m_of_type_Int)
    {
      int i1 = this.jdField_m_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(null);
    }
  }
  
  public void y()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  public void z()
  {
    f(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment
 * JD-Core Version:    0.7.0.1
 */