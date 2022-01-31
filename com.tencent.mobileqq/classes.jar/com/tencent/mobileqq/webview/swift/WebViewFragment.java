package com.tencent.mobileqq.webview.swift;

import aabm;
import aabo;
import aaet;
import actd;
import actn;
import agwj;
import ajyc;
import akgs;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
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
import anql;
import anqp;
import anvl;
import aqvl;
import aqwd;
import axmt;
import axqw;
import axrl;
import axsd;
import axse;
import bbac;
import bbei;
import bbqi;
import bcbq;
import bcbv;
import bccj;
import bcck;
import bccl;
import bccm;
import bccn;
import bcco;
import bccp;
import bccq;
import bccr;
import bccs;
import bcct;
import bcdb;
import bcdc;
import bcdg;
import bcdn;
import bcdq;
import bcdv;
import bcdw;
import bceb;
import bced;
import bcej;
import bceo;
import bces;
import bcet;
import bcfa;
import bcfc;
import bcfe;
import bcfj;
import bcfm;
import bcfq;
import bcfs;
import bcfw;
import bcfz;
import bcgb;
import bcgc;
import bcgk;
import bche;
import bchi;
import bchj;
import bchm;
import bchp;
import bchr;
import bchs;
import bchu;
import bchv;
import bcsc;
import bded;
import bgpd;
import bhdv;
import bhkr;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.BaseApplication;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc02216;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import muf;
import mvv;
import mxh;
import nae;
import nam;
import nax;
import nqp;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import sgj;
import tencent.im.opengroup.AppUrlOpenGroup.ReqBody;
import xec;
import xmt;

public class WebViewFragment
  extends Fragment
  implements View.OnClickListener, View.OnTouchListener, bccj, bcdc, bcdv, bcdw, bceb, bchi, bchj, bchm, bchp, bchr, bchs, bchu, bchv, xec
{
  public static final String d;
  public static int g;
  public Intent a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new bcco(this);
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public anql a;
  private aqvl jdField_a_of_type_Aqvl;
  public bcbv a;
  bcdg jdField_a_of_type_Bcdg;
  public final bcdq a;
  public bces a;
  public bcfa a;
  public bcfj a;
  public bcfm a;
  protected final bcfq a;
  public TouchWebView a;
  public volatile AppInterface a;
  public MiniMsgUser a;
  public BrowserAppInterface a;
  protected SonicClientImpl a;
  public WebBrowserViewContainer a;
  protected volatile WebViewPluginEngine a;
  IX5WebChromeClient.CustomViewCallback jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback;
  protected final Object a;
  protected mvv a;
  protected nae a;
  public xmt a;
  public View d;
  protected long e;
  View e;
  public String e;
  int jdField_f_of_type_Int = 0;
  View jdField_f_of_type_AndroidViewView;
  public String f;
  String g;
  public int h;
  public String h;
  protected boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  protected volatile boolean j;
  int jdField_k_of_type_Int;
  public String k;
  boolean jdField_k_of_type_Boolean = false;
  int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  public String n;
  protected boolean n;
  public int o;
  public String o;
  boolean o = true;
  public String p;
  public boolean p = true;
  public String q;
  public boolean q = true;
  public String r;
  boolean r = false;
  public String s;
  boolean s;
  protected boolean t;
  
  static
  {
    jdField_d_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/Tencent/MobileQQ/web_long_shot/";
  }
  
  public WebViewFragment()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_k_of_type_JavaLangString = "";
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_m_of_type_JavaLangString = "";
    this.jdField_m_of_type_Int = 1;
    this.jdField_a_of_type_Bcdq = a();
    this.jdField_a_of_type_Bcfq = new bcfq(new bcck(this));
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
      paramContext = nam.a(paramContext, paramString1, "POST", localBundle, paramString2);
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
      paramView.addOnLayoutChangeListener(new bccm(this));
    }
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new WebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null)
    {
      int i1 = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
      int i2 = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
      int i3 = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
      int i4 = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
      this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(super.getResources().getDrawable(2130849026));
      this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setPadding(i3, i1, i4, i2);
      return;
    }
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.b);
    this.jdField_a_of_type_Bcbv.d(this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bcbv.f(this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_d_of_type_Int);
  }
  
  private void j()
  {
    long l1;
    int i1;
    if (this.jdField_a_of_type_Bcfa.w)
    {
      l1 = 2L;
      if (!(this.jdField_a_of_type_ComTencentBizUiTouchWebView instanceof SwiftReuseTouchWebView)) {
        break label159;
      }
      if (1 != ((SwiftReuseTouchWebView)this.jdField_a_of_type_ComTencentBizUiTouchWebView).jdField_a_of_type_Int) {
        break label154;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i1), Long.valueOf(bcgb.jdField_a_of_type_Long) }));
      }
      System.currentTimeMillis();
      JSONObject localJSONObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.reportInitPerformance(l1, i1, this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, bcgb.jdField_a_of_type_Long);
      this.jdField_a_of_type_Bcfa.a(localJSONObject);
      System.currentTimeMillis();
      this.jdField_a_of_type_Bcfa.G = SystemClock.elapsedRealtime();
      return;
      if (bcfa.jdField_s_of_type_Boolean) {}
      for (i1 = 1;; i1 = 0)
      {
        l1 = i1;
        break;
      }
      label154:
      i1 = 0;
      continue;
      label159:
      i1 = 0;
    }
  }
  
  void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    bcfa localbcfa = this.jdField_a_of_type_Bcfa;
    this.jdField_i_of_type_Boolean = true;
    localbcfa.jdField_l_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bcdg != null)
    {
      this.jdField_a_of_type_Bcdg.a();
      this.jdField_a_of_type_Bcdg = null;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void B()
  {
    nax.a("Web_qqbrowser_createtabbar");
    Activity localActivity = a();
    if ((localActivity instanceof QQBrowserActivity))
    {
      ((QQBrowserActivity)localActivity).h();
      boolean bool1 = aqwd.a().c();
      boolean bool2 = a().getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    nax.b("Web_qqbrowser_createtabbar");
  }
  
  void C()
  {
    if (1 != this.jdField_m_of_type_Int)
    {
      int i1 = this.jdField_m_of_type_Int;
      this.jdField_a_of_type_Bcfq.b();
      this.jdField_a_of_type_Bcfq.a();
      this.jdField_a_of_type_Bcfq.a(null);
    }
  }
  
  public void D()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  public void E()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public void F()
  {
    f(false);
  }
  
  public void G()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      f();
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
    } while (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack(localHashMap));
    s();
    return;
    f();
  }
  
  public void H()
  {
    this.jdField_a_of_type_Bcbv.f();
  }
  
  public void I()
  {
    d(bcgc.a(this, this.jdField_a_of_type_AndroidContentIntent));
  }
  
  public int a(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_FINAL");
    nax.a("Web_IPCSetup");
    if (!anvl.a().a()) {
      anvl.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    nax.b("Web_IPCSetup");
    if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x400000) > 0L)
    {
      SosoInterface.a(new bccr(this, 0, false, false, 600000L, false, false, "webview"));
      SosoInterface.a(new bccs(this, 0, true, false, 600000L, false, false, "webview"));
    }
    ThreadManager.getUIHandler().postDelayed(new WebViewFragment.8(this), 3000L);
    ThreadManager.executeOnSubThread(new WebViewFragment.9(this));
    bcfs.a().a(new bccl(this, 2));
    nax.b("Web_qqbrowser_state_machine_init_FINAL");
    nax.b("Web_qqbrowser_state_machine_all");
    this.jdField_m_of_type_Int = 1;
    j();
    return -1;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean)
  {
    return switchRequestCode(paramWebViewPlugin, paramByte);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long;
  }
  
  public Activity a()
  {
    return super.getActivity();
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public Intent a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Intent localIntent = new Intent();
      if (getActivity() == null) {
        return null;
      }
      localIntent.setClass(getActivity(), SplashActivity.class);
      localIntent.setFlags(67108864);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fragment_id", 1);
      if (paramBundle.containsKey("banner_activityName"))
      {
        localIntent.putExtra("banner_activityName", paramBundle.getString("banner_activityName"));
        if (paramBundle.containsKey("banner_activityFlag")) {
          localIntent.putExtra("banner_activityFlag", paramBundle.getInt("banner_activityFlag"));
        }
        if (!paramBundle.containsKey("banner_webViewUrl")) {
          break label285;
        }
        localIntent.putExtra("banner_webViewUrl", paramBundle.getString("banner_webViewUrl"));
        label144:
        if (!paramBundle.containsKey("banner_wording")) {
          break label311;
        }
        localIntent.putExtra("banner_wording", paramBundle.getString("banner_wording"));
        label170:
        if (!paramBundle.containsKey("banner_businessCategory")) {
          break label479;
        }
        localIntent.putExtra("banner_businessCategory", paramBundle.getString("banner_businessCategory"));
        label196:
        if (!paramBundle.containsKey("banner_webview_extra")) {
          break label539;
        }
      }
      label539:
      for (paramBundle = paramBundle.getBundle("banner_webview_extra");; paramBundle = new Bundle())
      {
        if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView() != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().getScrollY() > 0)) {
          paramBundle.putInt("AIO_Scroll_Y", this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().getScrollY());
        }
        localIntent.putExtra("banner_webview_extra", paramBundle);
        return localIntent;
        localIntent.putExtra("banner_activityName", QQBrowserActivity.class.getName());
        break;
        label285:
        if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
          break label144;
        }
        localIntent.putExtra("banner_webViewUrl", this.jdField_h_of_type_JavaLangString);
        break label144;
        label311:
        Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).trim();
          label331:
          String str = bcgc.b((String)localObject);
          if ((!"http".equals(str)) && (!"https".equals(str)) && (!"data".equals(str)) && (!"file".equals(str)) && (!((String)localObject).startsWith("about")) && (!((String)localObject).startsWith("base64"))) {
            break label456;
          }
        }
        label456:
        for (int i1 = 1;; i1 = 0)
        {
          if ((i1 != 0) || (((String)localObject).length() <= 1)) {
            break label461;
          }
          localIntent.putExtra("banner_wording", String.format(ajyc.a(2131716894), new Object[] { this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle() }));
          break;
          localObject = "";
          break label331;
        }
        label461:
        localIntent.putExtra("banner_wording", ajyc.a(2131716895));
        break label170;
        label479:
        if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
          break label196;
        }
        localObject = Uri.parse(this.jdField_h_of_type_JavaLangString);
        if (!((Uri)localObject).isHierarchical()) {
          break label196;
        }
        localIntent.putExtra("banner_businessCategory", "WebView_" + ((Uri)localObject).getHost());
        break label196;
      }
    }
    QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public final bcdg a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    boolean bool1;
    TouchWebView localTouchWebView;
    if ((this.jdField_a_of_type_Bcfm.jdField_b_of_type_Long & 0x40) != 0L)
    {
      bool1 = true;
      localTouchWebView = a();
      if (localTouchWebView != null) {
        break label201;
      }
    }
    label201:
    for (this.jdField_a_of_type_Bcdg = new bcdn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this, this.jdField_a_of_type_AndroidContentIntent, bool1);; this.jdField_a_of_type_Bcdg = new bcdn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this, this.jdField_a_of_type_AndroidContentIntent, localTouchWebView))
    {
      this.jdField_a_of_type_Bcdg.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      localTouchWebView = this.jdField_a_of_type_Bcdg.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        bcfa localbcfa = this.jdField_a_of_type_Bcfa;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).jdField_a_of_type_Int) {
          bool1 = true;
        }
        localbcfa.jdField_u_of_type_Boolean = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.r = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.jdField_h_of_type_Boolean) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Bcdg;
      bool1 = false;
      break;
    }
  }
  
  public bcdq a()
  {
    return new bcdq(this, 127, null);
  }
  
  public TouchWebView a()
  {
    return null;
  }
  
  protected MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new bccp(this);
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = this.jdField_n_of_type_Int;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.requestCode = 200;
    if (this.jdField_a_of_type_Bcbv.a() != null)
    {
      localMiniMsgUserParam.entryView = this.jdField_a_of_type_Bcbv.a();
      localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_Bcbv.a().findViewById(2131370260));
    }
    localMiniMsgUserParam.actionCallback = a();
    return localMiniMsgUserParam;
  }
  
  public WebViewFragment a()
  {
    return this;
  }
  
  public WebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public Object a(String paramString, Bundle paramBundle)
  {
    if ("handleImage".equals(paramString))
    {
      localObject = (bced)this.jdField_a_of_type_Bcdq.a(8);
      if (localObject != null) {
        return Boolean.valueOf(((bced)localObject).a());
      }
    }
    Object localObject = (bcfe)this.jdField_a_of_type_Bcdq.a(16);
    if (localObject != null) {
      return ((bcfe)localObject).a(paramString, paramBundle);
    }
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public xmt a()
  {
    return b();
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if ((!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.jdField_h_of_type_JavaLangString.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        super.getActivity().setResult(-1, paramIntent);
        super.getActivity().finish();
      }
      break;
    }
    label313:
    label578:
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
                bgpd.a(super.getActivity(), paramIntent);
                return;
                localObject = paramIntent.getStringExtra("DELETE_BLOG");
                if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
                  this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
                }
                if (paramIntent == null) {
                  break;
                }
                boolean bool2 = paramIntent.getBooleanExtra("click_long_screen_shot", false);
                QLog.d("WebLog_WebViewFragment", 1, "REQUEST_TO_SCREEN_SHOT_PAGE. clickLongScreenShot is " + bool2);
                if ((!bool2) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
                  break;
                }
                QLog.d("WebLog_WebViewFragment", 1, "start screen long shot");
                bbac.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, new bccn(this));
                break;
                if (paramInt1 != 21) {
                  break label313;
                }
                localObject = actn.a(new Intent(super.getActivity(), SplashActivity.class), null);
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
              break label541;
            }
            if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
            {
              localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
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
          if ((this.jdField_a_of_type_Nae == null) || (!this.jdField_a_of_type_Nae.a(paramInt1, paramInt2, paramIntent))) {
            break label578;
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
    label541:
    Object localObject = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
    for (;;)
    {
      try
      {
        if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
          break label792;
        }
        this.t = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionSucc=" + this.t);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
      return;
      label792:
      bool1 = false;
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
    bcfe localbcfe = (bcfe)this.jdField_a_of_type_Bcdq.a(16);
    if (localbcfe != null) {
      localbcfe.a(paramInt, paramString);
    }
  }
  
  void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    AppUrlOpenGroup.ReqBody localReqBody = new AppUrlOpenGroup.ReqBody();
    localReqBody.uint32_appid.set(paramInt);
    localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_h_of_type_JavaLangString));
    localReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new NewIntent(BaseApplicationImpl.getApplication(), mxh.class);
    paramString.putExtra("cmd", "GroupOpen.CheckAppUrl");
    paramString.putExtra("data", localReqBody.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long = paramLong;
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
          localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(i3, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label582;
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
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
      {
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
          break label577;
        }
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
        if (localObject == null) {
          break label577;
        }
        localObject = ((WebViewPluginEngine)localObject).a(120, true);
        if ((localObject == null) || (!(localObject instanceof BuscardJsPlugin))) {
          break label577;
        }
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
      }
      label577:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          BuscardHelper.a(this.jdField_f_of_type_JavaLangString, super.getActivity(), paramIntent);
        }
        localObject = new HashMap();
        ((Map)localObject).put("intent", paramIntent);
        a(128L, (Map)localObject);
        if (("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction"))) || ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("fromNotification", false))) {
          break;
        }
        if (paramIntent.getBooleanExtra("keyFromUpdateAvatar", false))
        {
          localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
          if (localObject != null)
          {
            paramIntent = new Bundle();
            paramIntent.putString("path", (String)localObject);
            paramIntent = anqp.a("ipc_update_avatar", "", 0, paramIntent);
            anvl.a().b(paramIntent);
            return;
          }
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
          bceo localbceo = (bceo)this.jdField_a_of_type_Bcdq.a(64);
          if (localbceo == null) {
            break;
          }
          localbceo.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
          return;
          this.jdField_a_of_type_AndroidContentIntent = paramIntent;
          z();
          this.jdField_a_of_type_Bcfq.b();
          if (paramIntent.getBooleanExtra("onNewIntentReDoStateMachine", true))
          {
            this.jdField_m_of_type_Int = 2;
            this.jdField_a_of_type_Bcfq.a(paramIntent.getExtras());
          }
        }
      }
      label582:
      i1 = 0;
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_Bcfj.a(paramIntent, paramString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.jdField_l_of_type_Boolean);
    this.jdField_a_of_type_Bcdq.a(4, localBundle);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {}
    for (paramConfiguration = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();; paramConfiguration = null)
    {
      if (paramConfiguration != null) {
        paramConfiguration.a(this.jdField_h_of_type_JavaLangString, 8589934611L, null);
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
    if (!this.jdField_a_of_type_Bcfm.y) {
      super.getActivity().getWindow().setFlags(1024, 1024);
    }
    super.getActivity().setRequestedOrientation(paramInt);
    this.jdField_s_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
    this.jdField_e_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = paramCustomViewCallback;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i1 = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i1);
    super.startActivity(paramIntent);
  }
  
  public void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nae == null) {
      this.jdField_a_of_type_Nae = new nae();
    }
    this.jdField_a_of_type_Nae.a(super.getActivity(), 0, paramValueCallback, paramString1, paramString2);
  }
  
  public void a(WebView paramWebView, int paramInt)
  {
    if ((this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcsc != null) && (this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcsc.b() == 0)) {
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcsc.a((byte)1);
    }
    if (paramInt == 100) {
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    C();
    this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    QLog.e("WebLog_WebViewFragment", 1, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + nax.b(paramString2, new String[0]));
    this.jdField_a_of_type_Bcfa.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramInt, paramString1, paramString2);
    if (bcfa.x) {
      this.jdField_a_of_type_Bcfa.a("web_loaded_url_err", System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, String.valueOf(paramInt));
    }
    bhdv.a().a(this.jdField_h_of_type_JavaLangString, 132, System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, String.valueOf(paramInt), this.jdField_a_of_type_Bcfa.e, this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString);
  }
  
  public void a(WebView paramWebView, SslError paramSslError)
  {
    if (bcfa.x) {
      this.jdField_a_of_type_Bcfa.a("web_loaded_url_err", System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, String.valueOf(paramSslError.getPrimaryError()));
    }
    bhdv.a().a(this.jdField_h_of_type_JavaLangString, 132, System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, String.valueOf(paramSslError.getPrimaryError()), this.jdField_a_of_type_Bcfa.e, this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString);
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    this.jdField_a_of_type_Bcfa.c("state_page_finished");
    C();
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.jdField_a_of_type_Int = 8;
      this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_k_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 100;
    Object localObject = (bcfa)this.jdField_a_of_type_Bcdq.a(-2);
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)) {
      ((bcfa)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.getSession().getFinalResultCode();
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    this.jdField_a_of_type_Bcdq.a(7, (Bundle)localObject);
    if (this.jdField_a_of_type_Bcfa.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_Bcfa.jdField_k_of_type_Boolean = false;
      this.o = false;
      b();
      bcfs.a().a(new bcfw(1));
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("banner_fromBanner", false))
      {
        localObject = this.jdField_a_of_type_AndroidContentIntent.getBundleExtra("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).containsKey("AIO_Scroll_Y")))
        {
          int i1 = ((Bundle)localObject).getInt("AIO_Scroll_Y");
          if ((i1 > 0) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView() != null)) {
            ThreadManager.getUIHandler().post(new WebViewFragment.14(this, i1));
          }
        }
      }
      this.jdField_a_of_type_Bcfa.T = System.currentTimeMillis();
      if (bcfa.x) {
        this.jdField_a_of_type_Bcfa.a("web_loaded_url", System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, "0");
      }
      bhdv.a().a(paramString, 131, this.jdField_a_of_type_Bcfa.T - this.jdField_a_of_type_Bcfa.Q, "0", this.jdField_a_of_type_Bcfa.e, this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString);
      bhdv.a().a(paramString, 129, this.jdField_a_of_type_Bcfa.T - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, "0", this.jdField_a_of_type_Bcfa.e, this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.pageFinish(paramString);
    }
    if ((Build.VERSION.SDK_INT >= 19) && (!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Bcdg != null) && (this.jdField_a_of_type_Bcdg.a() != null)) {
      b(paramWebView, paramWebView.getTitle());
    }
    localObject = a();
    if ((localObject instanceof QQBrowserActivity)) {
      ((QQBrowserActivity)localObject).a(paramWebView, paramString);
    }
    if ((paramWebView instanceof CustomWebView)) {
      nqp.a((CustomWebView)paramWebView);
    }
    this.jdField_a_of_type_Bcfa.c("state_final");
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      C();
      paramWebView = new Bundle();
      paramWebView.putString("url", paramString);
      this.jdField_a_of_type_Bcdq.a(6, paramWebView);
    } while (!this.jdField_a_of_type_Bcfa.jdField_j_of_type_Boolean);
    axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, this.jdField_a_of_type_Bcfm.jdField_c_of_type_Long + "", this.jdField_h_of_type_JavaLangString, nam.a() + "", this.jdField_f_of_type_JavaLangString);
    if (bcfa.x) {
      this.jdField_a_of_type_Bcfa.a("web_start_load_url", System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, "0");
    }
    this.jdField_a_of_type_Bcfa.jdField_j_of_type_Boolean = false;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Bcfa.a(paramString, paramInt);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    QLog.d("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK " + paramString1 + "," + paramInt + "," + paramString2 + "," + paramString3);
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("from_single_task", false))
    {
      QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK call from normal activity, ignore.");
      return;
    }
    Bundle localBundle1 = anqp.a("ipc_qqbrowser_to_conversation", "", 0, null);
    localBundle1.putInt("banner_msg", 1134049);
    Bundle localBundle2 = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = ajyc.a(2131716891);
    }
    localBundle2.putString("tips", str);
    localBundle2.putString("iconURL", paramString2);
    localBundle2.putInt("icon", paramInt);
    localBundle2.putInt("timeout", 900000);
    localBundle2.putString("url", this.jdField_h_of_type_JavaLangString);
    localBundle2.putString("activity", paramString3);
    localBundle2.putInt("flags", 335544320);
    localBundle1.putBundle("barInfo", localBundle2);
    anvl.a().b(localBundle1);
    paramString1 = new Intent();
    paramString1.setClass(getActivity(), SplashActivity.class);
    paramString1.setFlags(335544320);
    paramString1.putExtra("tab_index", MainFragment.b);
    paramString1.putExtra("fragment_id", 1);
    startActivity(paramString1);
  }
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onSetCookieFinish ", paramString, " " + paramLong });
    }
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
    boolean bool2 = this.jdField_a_of_type_Mvv.a(str, "publicAccount.getLocation");
    paramString = "";
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      paramString = nax.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 2);
    }
    boolean bool3 = PublicAccountJavascriptInterface.getLocationPermissionGrant(this.jdField_f_of_type_JavaLangString, paramString);
    if ((bool3) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.jdField_f_of_type_JavaLangString, " urlHost:", paramString });
      }
      paramGeolocationPermissionsCallback.invoke(str, bool1, false);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, aabm paramaabm)
  {
    this.jdField_a_of_type_Bcbv.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramaabm);
    ((bcet)this.jdField_a_of_type_Bcdq.a(4)).d();
    this.jdField_a_of_type_Bcfj.j();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
    this.jdField_a_of_type_Bcfj.a(paramJSONObject, true);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bcfj != null) && (this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbv != null)) {
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbv.a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  @TargetApi(14)
  public boolean a()
  {
    nax.a("Web_qqbrowser_ShowPreview");
    long l1 = System.nanoTime();
    this.jdField_a_of_type_Bcfj.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_Bcfj.b(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.B);
    y();
    if (this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_a_of_type_Boolean)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      D();
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init view 1, cost = " + (System.nanoTime() - l1) / 1000000L);
      }
      this.jdField_a_of_type_Bcfj.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Bcfj.a(this.jdField_h_of_type_JavaLangString);
      nax.b("Web_qqbrowser_ShowPreview");
      return true;
    }
    this.jdField_a_of_type_Bcfj.d = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
    this.jdField_a_of_type_Bcbv.a(this.jdField_a_of_type_AndroidContentIntent, this);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    float f1 = muf.a(BaseApplicationImpl.getApplication(), 50.0F);
    int i1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      f1 += i1;
    }
    for (;;)
    {
      localLayoutParams.height = ((int)f1);
      this.jdField_a_of_type_Bcfm.A = true;
      int i2 = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296536);
      if ((this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Bcfm.jdField_m_of_type_Boolean))
      {
        this.jdField_a_of_type_Bcfm.jdField_n_of_type_Boolean = true;
        this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(super.getResources().getDrawable(2130849549));
        this.jdField_a_of_type_Bcbv.d(-1);
        this.jdField_a_of_type_Bcbv.f(-1);
        if (!this.jdField_a_of_type_Bcfm.o) {
          break label563;
        }
        b(i2 + i1, i1);
      }
      label563:
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.jdField_a_of_type_Bcfm.jdField_m_of_type_Boolean) {
          this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
        }
        for (bool2 = bool1;; bool2 = true)
        {
          for (;;)
          {
            if (ImmersiveUtils.isSupporImmersive() == 1)
            {
              this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
              super.getActivity().getWindow().addFlags(67108864);
            }
            f(bool2);
            if ((!this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Bcfm.jdField_m_of_type_Boolean)) {
              i();
            }
            if (!"2105".equals(ThemeUtil.curThemeId)) {
              break;
            }
            try
            {
              this.jdField_a_of_type_Bcbv.f(Color.parseColor("#03081A"));
            }
            catch (Exception localException)
            {
              QLog.d("WebLog_WebViewFragment", 2, "there may be some views not be initialized, should not do this UI adjust");
            }
          }
          break;
          this.p = true;
          this.q = true;
          b(i2 + i1 * 2, i1 + BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298872));
        }
      }
      i1 = 0;
    }
  }
  
  public boolean a(long paramLong, Map<String, Object> paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Bundle paramBundle)
  {
    actd.a(this.jdField_a_of_type_AndroidContentIntent);
    Object localObject = (bcej)this.jdField_a_of_type_Bcdq.a(1);
    if ((localObject != null) && (!((bcej)localObject).a(this.jdField_a_of_type_AndroidContentIntent)))
    {
      super.getActivity().finish();
      return true;
    }
    z();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("qqBrowserActivityCreateTime");
      this.jdField_a_of_type_AndroidContentIntent.putExtra("startOpenPageTime", 0L);
      QLog.e("WebLog_WebViewFragment", 1, "doOnCreate mOnCreateMilliTimeStamp = " + this.jdField_a_of_type_AndroidContentIntent.getLongExtra("qqBrowserActivityCreateTime", -2L));
    }
    this.jdField_a_of_type_Bcfa.c("state_activity_create");
    this.jdField_a_of_type_Bcfa.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_h_of_type_JavaLangString);
    x();
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_is_init_sonic_session", true))) {}
    for (boolean bool = false;; bool = b(d()))
    {
      this.jdField_a_of_type_Bcfa.jdField_d_of_type_Boolean = bool;
      if (!bool) {
        ThreadManager.post(new WebViewFragment.2(this), 5, null, true);
      }
      nax.a("Web_qqbrowser_dooncreate");
      this.q = false;
      this.p = false;
      axrl.a(BaseApplicationImpl.getApplication(), 10000L);
      this.jdField_a_of_type_Bcfa.N = System.currentTimeMillis();
      this.jdField_h_of_type_Boolean = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      this.jdField_a_of_type_Mvv = mvv.a();
      localObject = this.jdField_a_of_type_Bcfa;
      this.jdField_i_of_type_Boolean = false;
      ((bcfa)localObject).jdField_l_of_type_Boolean = false;
      this.jdField_a_of_type_Bcfa.O = System.currentTimeMillis();
      nax.a("Web_qqbrowser_state_machine_all");
      this.jdField_m_of_type_Int = 2;
      if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.b > 0)) {
        this.jdField_a_of_type_Bcfq.a();
      }
      WebAccelerateHelper.isWebViewCache = true;
      this.jdField_a_of_type_Bcfq.a(paramBundle);
      paramBundle = new Bundle();
      paramBundle.putString("url", this.jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_Bcdq.a(5, paramBundle);
      this.jdField_a_of_type_Bcfa.r = (System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long);
      nax.b("Web_qqbrowser_dooncreate");
      this.jdField_a_of_type_Bcfa.S = System.currentTimeMillis();
      return true;
    }
  }
  
  public boolean a(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (this.jdField_a_of_type_Nae == null) {
      this.jdField_a_of_type_Nae = new nae();
    }
    return this.jdField_a_of_type_Nae.a(super.getActivity(), 0, paramValueCallback, paramFileChooserParams);
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    boolean bool1 = bool2;
    long l1;
    if (super.getActivity().isResume()) {
      if (System.currentTimeMillis() - this.jdField_e_of_type_Long >= 1000L)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Mvv.a(paramWebView.getUrl(), (String)localObject2).booleanValue()) {}
      }
      else
      {
        l1 = System.currentTimeMillis();
        bool1 = agwj.a().a(paramString, this);
        QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool1 + " cost:" + (System.currentTimeMillis() - l1) + " ms.");
        if (!bool1) {
          break label133;
        }
        bool1 = true;
      }
    }
    return bool1;
    label133:
    localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
    ((Intent)localObject2).addFlags(268435456);
    for (;;)
    {
      try
      {
        ((Intent)localObject2).putExtra("url", b());
        ActivityInfo localActivityInfo = ((Intent)localObject2).resolveActivityInfo(getActivity().getPackageManager(), 0);
        localObject1 = "";
        if (localActivityInfo != null) {
          localObject1 = localActivityInfo.packageName;
        }
        akgs.a("scheme", paramWebView.getUrl(), (String)localObject1, "1", "web", getActivity().getClass().getName());
        paramWebView = a();
        bool1 = paramWebView.getBooleanExtra("h5_ark_is_from_share", false);
        l1 = paramWebView.getLongExtra("appShareID", -1L);
        ((Intent)localObject2).putExtra("h5_ark_is_from_share", bool1);
        ((Intent)localObject2).putExtra("appShareID", l1);
        if (this.jdField_a_of_type_Aqvl != null) {
          this.jdField_a_of_type_Aqvl.a();
        }
      }
      catch (Exception paramWebView)
      {
        QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramWebView);
        continue;
      }
      try
      {
        bool2 = a().getBooleanExtra("keyForForceCloseAfterJump", false);
        this.jdField_a_of_type_Aqvl = JefsClass.getInstance().a(getActivity(), (Intent)localObject2, paramString, new WebViewFragment.15(this, (Intent)localObject2, bool2, (String)localObject1, bool1, l1));
        return true;
      }
      catch (Throwable paramWebView)
      {
        QLog.e("WebLog_WebViewFragment", 1, paramWebView, new Object[0]);
      }
    }
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
    return super.getResources().getDimensionPixelSize(2131298865);
  }
  
  public int b(Bundle paramBundle)
  {
    long l1 = SystemClock.elapsedRealtime();
    nax.a("Web_qqbrowser_state_machine_init_titlebar");
    a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_h_of_type_JavaLangString);
    B();
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    if (paramBundle != null)
    {
      this.jdField_h_of_type_Int = paramBundle.getInt("uin_type");
      this.jdField_j_of_type_JavaLangString = paramBundle.getString("puin");
      this.jdField_k_of_type_JavaLangString = paramBundle.getString("msg_id");
      if (this.jdField_k_of_type_JavaLangString == null) {
        this.jdField_k_of_type_JavaLangString = "";
      }
      this.jdField_l_of_type_JavaLangString = paramBundle.getString("source_puin");
      if (this.jdField_l_of_type_JavaLangString == null) {
        this.jdField_l_of_type_JavaLangString = "";
      }
      this.jdField_m_of_type_JavaLangString = paramBundle.getString("friendUin");
      if (this.jdField_m_of_type_JavaLangString == null) {
        this.jdField_m_of_type_JavaLangString = "";
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
        if (bcgc.a()) {
          break label278;
        }
        this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131690832));
      }
    }
    for (;;)
    {
      a(this.jdField_i_of_type_Int, paramBundle, new bccq(this));
      this.jdField_m_of_type_Int = 512;
      ((bcet)b().a(4)).d();
      nax.b("Web_qqbrowser_state_machine_init_titlebar");
      this.jdField_a_of_type_Bcfa.K = (SystemClock.elapsedRealtime() - l1);
      return 1;
      label278:
      if (this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.getBackground() == null) {
        this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131690832));
      }
    }
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Bcfa.jdField_a_of_type_Long;
  }
  
  public Activity b()
  {
    return BaseActivity.sTopActivity;
  }
  
  public View b()
  {
    if (this.jdField_f_of_type_AndroidViewView == null) {
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(super.getActivity()).inflate(2131562592, null);
    }
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  public bcdq b()
  {
    return this.jdField_a_of_type_Bcdq;
  }
  
  public String b()
  {
    String str2 = this.jdField_h_of_type_JavaLangString;
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
    paramString = a(BaseApplicationImpl.getApplication(), "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.jdField_a_of_type_AndroidContentIntent.getStringExtra("vkey"), this.jdField_f_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  protected xmt b()
  {
    if (this.jdField_a_of_type_Xmt == null) {
      this.jdField_a_of_type_Xmt = new xmt(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity());
    }
    return this.jdField_a_of_type_Xmt;
  }
  
  public void b() {}
  
  protected void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = (TextView)this.jdField_a_of_type_Bcfj.d.findViewById(2131363423);
    if (localObject1 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt1;
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_Bcfj.d.findViewById(2131379407);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt2;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    while ((!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || ((this.jdField_a_of_type_Bcfm.jdField_b_of_type_Long & 0x8) > 0L) || (bcgk.a(paramString)) || (paramString == null)) {
      return;
    }
    this.jdField_a_of_type_Bcbv.a(paramWebView, paramString, this.jdField_n_of_type_Boolean);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_k_of_type_Boolean) && (sgj.a(paramString, this.jdField_f_of_type_Int, this.jdField_g_of_type_JavaLangString))) {
      this.jdField_k_of_type_Boolean = true;
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.jdField_e_of_type_JavaLangString = paramString2;
    SwiftBrowserCookieMonster.d();
    c(paramString1, paramString2);
    this.jdField_a_of_type_Bcfa.e(paramString2);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_a_of_type_Boolean)) {
      D();
    }
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
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return true;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      this.jdField_a_of_type_Bcfa.jdField_h_of_type_Boolean = false;
    }
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      s();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.jdField_h_of_type_JavaLangString = paramString;
        localObject = (bcet)this.jdField_a_of_type_Bcdq.a(4);
        if (localObject != null) {
          ((bcet)localObject).a(this.jdField_h_of_type_JavaLangString);
        }
        localObject = (bceo)this.jdField_a_of_type_Bcdq.a(64);
        if (localObject != null) {
          ((bceo)localObject).a(this.jdField_h_of_type_JavaLangString);
        }
      }
    }
    if (super.getActivity().isFinishing()) {
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    Object localObject = bcgc.b(paramString);
    if (("http".equals(localObject)) || ("https".equals(localObject)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebLog_WebViewFragment", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        paramWebView = this.jdField_e_of_type_JavaLangString;
        this.jdField_e_of_type_JavaLangString = paramString;
        SwiftBrowserCookieMonster.d();
        c(paramWebView, this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_Bcfa.e(paramString);
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
              break label336;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l1) == 0L) {
              break label342;
            }
            i1 = 1;
            break label324;
            label138:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l1) == 0L) {
              break label355;
            }
            bool = true;
            localBuilder.setSupportCacheControl(bool);
          }
        }
        localObject = WebAccelerateHelper.getSonicEngine();
        if (localObject != null)
        {
          localObject = ((SonicEngine)localObject).createSession(paramString, localBuilder.build());
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
            ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
            return true;
          }
          QLog.d("WebLog_WebViewFragment", 1, "initSonicSession sonicSession = null, url = " + paramString);
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("WebLog_WebViewFragment", 1, "initSonicSession exception, url = " + paramString, localException);
        return false;
      }
      QLog.d("WebLog_WebViewFragment", 1, "initSonicSession sonicEngine = null, url = " + paramString);
      return false;
      for (;;)
      {
        label324:
        if (i1 == 0) {
          break label347;
        }
        str = "store";
        break label138;
        label336:
        bool = false;
        break;
        label342:
        i1 = 0;
      }
      label347:
      String str = "true";
      continue;
      label355:
      boolean bool = false;
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Bcfm.jdField_d_of_type_Int;
  }
  
  public int c(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("4440");
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
      this.jdField_n_of_type_Boolean = true;
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("articalChannelId", 100);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("ARTICAL_CHANNEL_EXTRAL_INFO");
    this.jdField_m_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromQZone", false);
    bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    i2 = hashCode();
    if (bool)
    {
      i1 = 1;
      axsd.a(paramBundle, i2, i1, this.jdField_h_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("vasUsePreWebview", false)) {
        break label477;
      }
      bool = true;
      this.jdField_a_of_type_Bces.a("web_view_long_click", bool);
      this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.b = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("individuation_url_type", -1);
      if (jdField_g_of_type_Int == 1) {
        bcfc.jdField_d_of_type_Int = this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.b;
      }
      if ((this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.b == -1) && (bcfc.jdField_d_of_type_Int != -1)) {
        this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcfc.b = bcfc.jdField_d_of_type_Int;
      }
      this.jdField_a_of_type_Bcfa.jdField_d_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("title");
      this.jdField_a_of_type_Bcfj.jdField_a_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x4000000) == 0L) {
        this.jdField_a_of_type_Bces.a("image_long_click", true);
      }
      nax.b("Web_qqbrowser_state_machine_init_data");
      this.jdField_m_of_type_Int = 4;
      return 0;
    }
  }
  
  public String c()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void c()
  {
    bcet localbcet = (bcet)this.jdField_a_of_type_Bcdq.a(4);
    if (localbcet != null) {
      localbcet.a(b(), this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long);
    }
  }
  
  void c(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.b(paramString1);
      String str = SwiftBrowserCookieMonster.b(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.o = false;
      }
      if (this.o)
      {
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null) {
          paramString1.a(paramString2, this, null, this.jdField_a_of_type_AndroidContentIntent);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebLog_WebViewFragment", 1, paramString1, new Object[0]);
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      if ((this.jdField_a_of_type_Bcbv.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) && (this.jdField_a_of_type_Bcbv.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs4OpenApi(this.jdField_a_of_type_Bcbv.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bcbv.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(this.jdField_a_of_type_Bcbv.jdField_a_of_type_JavaLangString, new String[] { "" });
        return true;
      }
      if (this.jdField_a_of_type_Bcbv.jdField_a_of_type_Aabm != null)
      {
        aaet.b(this.jdField_a_of_type_Bcbv.jdField_a_of_type_Aabm, aabo.jdField_a_of_type_OrgJsonJSONObject);
        return true;
      }
    }
    return false;
  }
  
  public boolean c(WebView paramWebView, String paramString)
  {
    if ((this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return true;
    }
    nax.a("urlInterceptManager");
    paramWebView = bcgc.b(paramString);
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
    nax.b("urlInterceptManager");
    return false;
  }
  
  public boolean c(String paramString)
  {
    return ((bcet)this.jdField_a_of_type_Bcdq.a(4)).a(paramString);
  }
  
  public int d(Bundle paramBundle)
  {
    long l1 = SystemClock.elapsedRealtime();
    nax.a("Web_qqbrowser_state_machine_init_ui_main_content");
    nax.a("Web_qqbrowser_initView");
    if (!this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = true;
      this.jdField_a_of_type_Bcfj.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.isPaused) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      }
      if ((this.jdField_a_of_type_Bcfj.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
        ((RefreshView)this.jdField_a_of_type_Bcfj.jdField_c_of_type_AndroidViewViewGroup).setOnFlingGesture(this);
      }
    }
    for (;;)
    {
      nax.b("Web_qqbrowser_initView");
      nax.b("Web_qqbrowser_state_machine_init_ui_main_content");
      this.jdField_a_of_type_Bcfa.L = (SystemClock.elapsedRealtime() - l1);
      this.jdField_m_of_type_Int = 256;
      return 1;
      if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bcfm.jdField_c_of_type_Long != 0L)) {
        this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      }
    }
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
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine())
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_h_of_type_JavaLangString, 8589934598L, null);
      }
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_h_of_type_JavaLangString, 8589934599L, null);
      }
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("flow_key_from_guide", false))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(BaseApplicationImpl.getApplication(), SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", MainFragment.b);
        ((Intent)localObject).addFlags(67108864);
        super.startActivity((Intent)localObject);
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Bcbv.d(paramInt);
  }
  
  public final void d(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Bcfm.D) && (paramBundle != null))
    {
      paramBundle = a(paramBundle);
      if (paramBundle != null) {
        startActivity(paramBundle);
      }
      return;
    }
    QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Bcbv.c(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_b_of_type_Boolean;
  }
  
  public int e(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_webview");
    this.jdField_a_of_type_Bcfa.c("state_webview_create");
    e();
    nax.b("Web_qqbrowser_state_machine_init_webview");
    this.jdField_m_of_type_Int = 32;
    this.jdField_a_of_type_Bcfa.Q = System.currentTimeMillis();
    this.jdField_a_of_type_Bcfa.jdField_u_of_type_Long = (this.jdField_a_of_type_Bcfa.Q - this.jdField_a_of_type_Bcfa.P);
    if (bcfa.x) {
      this.jdField_a_of_type_Bcfa.a("should_start_load", this.jdField_a_of_type_Bcfa.Q - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, "0");
    }
    bhdv.a().a(this.jdField_h_of_type_JavaLangString, 130, this.jdField_a_of_type_Bcfa.Q - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, "0", this.jdField_a_of_type_Bcfa.e, this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString);
    return 0;
  }
  
  public String e()
  {
    if (b() == null) {
      return "";
    }
    return b().a();
  }
  
  protected void e()
  {
    int i1 = -1;
    int i2 = 0;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(null).a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new bcct(this));
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x10000) == 0L) {
        break label338;
      }
      i1 = 2;
      if (AppSetting.g) {
        i1 = 2;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i1);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i1);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Bcfa.n = (l2 - l1);
      this.jdField_a_of_type_Bcfa.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Bcfa.n);
      }
      l1 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension();
      i1 = i2;
      if (localIX5WebViewExtension != null) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label393;
      }
      Bundle localBundle = bcgc.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      this.jdField_a_of_type_Bcfa.e = 2;
    }
    label393:
    for (this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString = String.valueOf(Build.VERSION.SDK_INT))
    {
      this.jdField_a_of_type_Bcfa.I = this.jdField_a_of_type_Bcdg.jdField_a_of_type_Long;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l2 - l1));
      }
      return;
      label338:
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
        this.jdField_a_of_type_Bcfa.e = 1;
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_Bcbv.f(paramInt);
  }
  
  public void e(boolean paramBoolean)
  {
    int i1;
    View localView;
    if (this.jdField_a_of_type_Bcbv.a() != null)
    {
      if (!paramBoolean) {
        break label87;
      }
      i1 = 0;
      this.jdField_a_of_type_Bcbv.a().setVisibility(i1);
      localView = this.jdField_a_of_type_Bcbv.a().findViewById(2131370259);
      if (this.jdField_s_of_type_JavaLangString != null)
      {
        if (!this.jdField_s_of_type_JavaLangString.equals("white")) {
          break label93;
        }
        localView.setBackgroundResource(2130840693);
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
      }
      return;
      label87:
      i1 = 8;
      break;
      label93:
      if (this.jdField_s_of_type_JavaLangString.equals("black")) {
        localView.setBackgroundResource(2130840692);
      }
    }
  }
  
  public boolean e()
  {
    return this.t;
  }
  
  public int f(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (!this.jdField_a_of_type_Bcfj.jdField_c_of_type_Boolean)
    {
      long l1 = SystemClock.elapsedRealtime();
      a();
      this.jdField_a_of_type_Bcfa.J = (SystemClock.elapsedRealtime() - l1);
    }
    this.jdField_m_of_type_Int = 128;
    nax.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public String f()
  {
    return this.jdField_k_of_type_JavaLangString;
  }
  
  public void f()
  {
    this.jdField_a_of_type_Bcfa.c("state_back");
    if (1 != this.jdField_m_of_type_Int)
    {
      this.jdField_a_of_type_Bcfq.b();
      this.jdField_m_of_type_Int = 1;
    }
    if ((TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    }
    this.jdField_a_of_type_Bcfa.b(a(), this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_Bcfa.a(BaseApplicationImpl.getApplication(), this.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentIntent);
    actd.c(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_s_of_type_Boolean) {
      v();
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
      if ((this.jdField_a_of_type_Bcfm.g) || ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x4) != 0L) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934610L, localHashMap);
    return;
    super.getActivity().finish();
  }
  
  public void f(boolean paramBoolean)
  {
    if ((this.p) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getActivity().getWindow().addFlags(67108864);
      if (this.q) {
        if (this.jdField_d_of_type_AndroidViewView == null)
        {
          this.jdField_d_of_type_AndroidViewView = new View(super.getActivity());
          if (this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
            break label216;
          }
          this.jdField_d_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_a_of_type_Int);
          axmt.a(true, this.jdField_a_of_type_Bcfm.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_a_of_type_Int, a().getWindow());
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
          ((View)localObject).setId(2131364718);
          ((View)localObject).setBackgroundColor(-16777216);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
          localLayoutParams.addRule(10, -1);
          this.jdField_a_of_type_Bcfj.d.addView((View)localObject, localLayoutParams);
        }
        Object localObject = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        this.jdField_a_of_type_Bcfj.d.addView(this.jdField_d_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      }
      return;
      label216:
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130849027);
      }
      else
      {
        this.jdField_d_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166910));
        axmt.a(false, getResources().getColor(2131166910), a().getWindow());
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_a_of_type_Boolean;
  }
  
  public int g(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_x5_environment");
    this.jdField_a_of_type_Bcfa.P = System.currentTimeMillis();
    this.jdField_m_of_type_Int = 8;
    if (bcgb.a())
    {
      nax.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (bcgb.b())
    {
      nax.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    nax.b("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  public String g()
  {
    return this.jdField_j_of_type_JavaLangString;
  }
  
  public void g()
  {
    nax.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    a();
    if ((this.jdField_a_of_type_Bcfa.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_Bcfa.jdField_k_of_type_Long > 0L))
    {
      axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Bcfa.jdField_k_of_type_Long) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Bcfa.jdField_c_of_type_Int);
      this.jdField_a_of_type_Bcfa.jdField_k_of_type_Long = 0L;
    }
    this.jdField_a_of_type_Bcfa.q = System.currentTimeMillis();
    long l1 = this.jdField_a_of_type_Bcfa.q;
    l1 = this.jdField_a_of_type_Bcfa.jdField_b_of_type_Long;
    if (bbei.a().a(this.jdField_h_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("file:///android_asset/error.html");
      QLog.d("WebLog_WebViewFragment", 1, new Object[] { "url:", this.jdField_h_of_type_JavaLangString, "in black" });
    }
    for (;;)
    {
      nax.b("Web_readyToLoadUrl");
      this.jdField_a_of_type_Bcfa.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_h_of_type_JavaLangString, 0, 0, 0, 0, 0, null);
      return;
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_h_of_type_JavaLangString);
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {}
    int i2;
    do
    {
      return;
      i2 = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296536);
      if (paramBoolean) {
        break;
      }
      b(i2, 0);
      localViewGroup.setVisibility(8);
    } while (this.jdField_d_of_type_AndroidViewView == null);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Bcfj.d.findViewById(2131364718).setVisibility(8);
    return;
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int i1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());; i1 = 0)
    {
      if (this.jdField_a_of_type_Bcfm.jdField_n_of_type_Boolean) {
        i2 += i1;
      }
      for (;;)
      {
        b(i2, i1);
        localViewGroup.setVisibility(0);
        if (this.jdField_d_of_type_AndroidViewView == null) {
          break;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Bcfj.d.findViewById(2131364718).setVisibility(0);
        return;
        i2 += i1 * 2;
        i1 += BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298872);
      }
    }
  }
  
  public CustomWebView getWebView()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public int h(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin() != 0L)
    {
      paramBundle = this.jdField_a_of_type_Bcfa;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin() % bcfa.jdField_d_of_type_Int != 6L) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.jdField_i_of_type_Boolean = bool;
      w();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(a().getStringArrayExtra("insertPluginsArray"));
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_h_of_type_JavaLangString, 1L, null);
      }
      this.jdField_m_of_type_Int = 16;
      if (bcfa.x) {
        this.jdField_a_of_type_Bcfa.a("webview_init", System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long, "0");
      }
      nax.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
      return 1;
    }
  }
  
  public String h()
  {
    return this.jdField_l_of_type_JavaLangString;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_h_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      a(8589934604L, null);
    }
    if ((this.jdField_d_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_Bcfm.jdField_i_of_type_Boolean))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130849027);
      }
    }
    else {
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131166910));
    axmt.a(false, getResources().getColor(2131166910), a().getWindow());
  }
  
  public void h(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bcfj != null) && ((this.jdField_a_of_type_Bcfj.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView))) {
      ((RefreshView)this.jdField_a_of_type_Bcfj.jdField_c_of_type_AndroidViewViewGroup).b(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForJS enable=" + paramBoolean);
    }
  }
  
  public int i(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_load_url");
    this.jdField_a_of_type_Bcfa.c("state_load_url");
    long l1 = System.currentTimeMillis();
    nax.a("Web_qqbrowser_init");
    g();
    nax.b("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_Bcfa.o = (l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "init param and load url, cost = " + this.jdField_a_of_type_Bcfa.o);
    }
    nax.b("Web_qqbrowser_state_machine_load_url");
    this.jdField_m_of_type_Int = 64;
    return 0;
  }
  
  public void i(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bcfj != null) && ((this.jdField_a_of_type_Bcfj.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView))) {
      ((RefreshView)this.jdField_a_of_type_Bcfj.jdField_c_of_type_AndroidViewViewGroup).c(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForHost enable=" + paramBoolean);
    }
  }
  
  public int j(Bundle paramBundle)
  {
    nax.a("Web_qqbrowser_state_machine_init_bottombar");
    this.jdField_a_of_type_Bcfj.b(a(), this.jdField_h_of_type_JavaLangString);
    this.jdField_a_of_type_Bcfj.e();
    this.jdField_m_of_type_Int = 1024;
    nax.b("Web_qqbrowser_state_machine_init_bottombar");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
      }
      return -1;
    }
    return 1;
  }
  
  public void j(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bcfm.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void k(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void l(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void m(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bcbv.b(paramBoolean);
    ((bcet)this.jdField_a_of_type_Bcdq.a(4)).d();
    this.jdField_a_of_type_Bcfj.j();
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
          break label83;
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
      label83:
      QLog.d("WebLog_WebViewFragment", 2, "already has classloader for this fragment: " + localBundle.getClassLoader());
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    label335:
    label362:
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
                if ((paramView == this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView) || (paramView == this.jdField_a_of_type_Bcbv.jdField_a_of_type_ComTencentWidgetFadeIconImageView))
                {
                  f();
                  if (paramView == this.jdField_a_of_type_Bcbv.jdField_a_of_type_ComTencentWidgetFadeIconImageView) {
                    axqw.a(null, "dc00898", "", "", "0X8009B1F", "0X8009B1F", 0, 0, "", "", "", "");
                  }
                }
                else if ((paramView == this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.jdField_a_of_type_Bcbv.d))
                {
                  if (bcet.jdField_b_of_type_Long != -1L) {
                    bcet.jdField_b_of_type_Long = -1L;
                  }
                  paramView = new Intent();
                  paramView.setAction("SignInSbumited");
                  BaseApplicationImpl.getApplication().sendBroadcast(paramView);
                  if (!c())
                  {
                    bded.a().a("", "", "", "1000", "100", "0", false);
                    c();
                  }
                  if (this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidViewView != null)
                  {
                    paramView = this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidViewView.getParent();
                    if ((paramView != null) && ((paramView instanceof ViewGroup))) {
                      ((ViewGroup)paramView).removeView(this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidViewView);
                    }
                  }
                }
                else
                {
                  if (paramView != this.jdField_a_of_type_Bcbv.c) {
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
                    if (!this.jdField_a_of_type_Bcfm.jdField_l_of_type_Boolean) {
                      break label335;
                    }
                    f();
                  }
                  for (;;)
                  {
                    if (this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidViewView == null) {
                      break label362;
                    }
                    paramView = this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidViewView.getParent();
                    if ((paramView == null) || (!(paramView instanceof ViewGroup))) {
                      break;
                    }
                    ((ViewGroup)paramView).removeView(this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidViewView);
                    return;
                    bded.a().a("", "", "", "1000", "100", "0", false);
                    c();
                  }
                }
              }
              if (paramView == this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_d_of_type_AndroidViewView)
              {
                if (this.jdField_a_of_type_Bcfm.F)
                {
                  LpReportInfo_dc02216.reportExit();
                  if (getWebView() != null)
                  {
                    paramView = getWebView().getPluginEngine();
                    if ((paramView != null) && (paramView.a(b(), 8589934615L, null)))
                    {
                      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.b.setVisibility(8);
                      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.a(this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView, true);
                      this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.i.setVisibility(8);
                      return;
                    }
                  }
                }
                this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.b.setVisibility(8);
                this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.a(this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView, true);
                this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.i.setVisibility(8);
                super.getActivity().finish();
                axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
                return;
              }
              if (paramView != this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_f_of_type_AndroidViewView) {
                break;
              }
              if (bcet.jdField_b_of_type_Long != -1L) {
                bcet.jdField_b_of_type_Long = -1L;
              }
              this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.b.setVisibility(8);
              this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.a(this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView, true);
              this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.i.setVisibility(8);
              c();
              bded.a().a("", "", "", "1000", "100", "0", false);
              axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
            } while (!this.jdField_a_of_type_Bcfm.F);
            LpReportInfo_dc02216.reportShare();
            return;
            if (paramView != this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.h) {
              break;
            }
            paramView = new Intent(super.getActivity(), QQBrowserActivity.class);
            paramView.putExtra("key_isReadModeEnabled", true);
            paramView.putExtra("url", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
            super.startActivity(paramView);
            super.getActivity().finish();
            axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
          } while (!QLog.isColorLevel());
          QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
          return;
          if (paramView != this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.g) {
            break;
          }
          this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.b.setVisibility(8);
          this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.a(this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.i.setVisibility(8);
          if (!TextUtils.isEmpty(a().u))
          {
            this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(a().u, new String[] { "" });
            if (QLog.isColorLevel()) {
              QLog.d("WebLog_WebViewFragment", 2, "call js function getShare().mOnShareHandler");
            }
          }
          axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "senddesk", "", "", "");
        } while (!this.jdField_a_of_type_Bcfm.F);
        LpReportInfo_dc02216.reportExit();
        return;
        if (paramView != this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_e_of_type_AndroidViewView) {
          break;
        }
        this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.b.setVisibility(8);
        this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.a(this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.jdField_a_of_type_AndroidViewView, true);
        this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbq.i.setVisibility(8);
        if (this.jdField_a_of_type_Bcfm.E)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle())) {}
          for (paramView = ajyc.a(2131716897);; paramView = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getTitle())
          {
            a(String.format(ajyc.a(2131716892), new Object[] { paramView }), 2130838172, null, SingleTaskQQBrowser.class.getName());
            axqw.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "fold", "", "", "");
            return;
          }
        }
      } while (!this.jdField_a_of_type_Bcfm.D);
      a().I();
      return;
    } while (paramView != this.jdField_a_of_type_Bcfj.jdField_a_of_type_AndroidWidgetTextView);
    paramView = new HashMap();
    paramView.put("intent", this.jdField_a_of_type_AndroidContentIntent);
    a(8589934622L, paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Bcfj = ((bcfj)this.jdField_a_of_type_Bcdq.a(2));
    this.jdField_a_of_type_Bcfj.c();
    this.jdField_a_of_type_Bcfm = this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm;
    this.jdField_a_of_type_Bcbv = this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbv;
    this.jdField_a_of_type_Bces = ((bces)this.jdField_a_of_type_Bcdq.a(-1));
    this.jdField_a_of_type_Bcfa = ((bcfa)this.jdField_a_of_type_Bcdq.a(-2));
    this.jdField_a_of_type_Bcfj.a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = ((WebBrowserViewContainer)WebAccelerateHelper.preloadBrowserView);
      WebAccelerateHelper.preloadBrowserView = null;
      this.jdField_a_of_type_Bcfa.v = true;
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
    if (this.jdField_a_of_type_Aqvl != null) {
      this.jdField_a_of_type_Aqvl.a();
    }
    if (1 != this.jdField_m_of_type_Int)
    {
      this.jdField_a_of_type_Bcfq.b();
      this.jdField_m_of_type_Int = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.destroy();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    Object localObject = Long.valueOf(this.jdField_a_of_type_AndroidContentIntent.getLongExtra("Gif_msg_uniseq_key", 0L));
    if (((Long)localObject).longValue() > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("Gif_msg_uniseq_key", ((Long)localObject).longValue());
      localObject = anqp.a("close_annimate", null, -1, localBundle);
      anvl.a().a((Bundle)localObject);
    }
    if (this.jdField_a_of_type_Anql != null) {
      anvl.a().b(this.jdField_a_of_type_Anql);
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", this.jdField_h_of_type_JavaLangString);
      this.jdField_a_of_type_Bcdq.a(3, (Bundle)localObject);
      A();
      if (QQBrowserActivity.jdField_c_of_type_Int == 0)
      {
        anvl.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        bcfc.jdField_d_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_Xmt != null) {
        this.jdField_a_of_type_Xmt.c();
      }
      localObject = axsd.a(getClass(), hashCode());
      if (localObject != null) {
        axqw.b(null, "CliOper", "", "", ((axse)localObject).jdField_a_of_type_JavaLangString, ((axse)localObject).jdField_a_of_type_JavaLangString, ((axse)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((axse)localObject).jdField_b_of_type_Long), "", "", "");
      }
      bcfs.a().a(2);
      this.jdField_a_of_type_Bcbv.h();
      actd.d(super.getActivity().getIntent());
      bhdv.a().a(this.jdField_h_of_type_JavaLangString, 133, System.currentTimeMillis() - this.jdField_a_of_type_Bcfa.T, "0", this.jdField_a_of_type_Bcfa.e, this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString);
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
  
  public void onLowMemory()
  {
    try
    {
      if ((bcfa.x) && (this.jdField_a_of_type_Bcfa != null) && (this.jdField_a_of_type_Bcfa.jdField_c_of_type_Long > 0L)) {
        axqw.b(null, "dc00899", "WV_Analysis", "", "memory_consumption", bcfa.a(this.jdField_h_of_type_JavaLangString), this.jdField_a_of_type_Bcfa.e, 0, "", this.jdField_a_of_type_Bcfa.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Bcfa.jdField_f_of_type_JavaLangString, "");
      }
      label73:
      super.onLowMemory();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label73;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onPause");
    }
    if (this.jdField_s_of_type_Boolean) {
      v();
    }
    String str = BridgeHelper.a(super.getActivity(), this.jdField_f_of_type_JavaLangString).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(super.getActivity());
    }
    this.jdField_a_of_type_Bcdq.a(1, null);
    a(8589934597L, null);
    if ((this.jdField_m_of_type_Boolean) && (axmt.c())) {
      bhkr.a().a();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    nax.a("Web_qqbrowser_doonresume");
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", this.jdField_f_of_type_JavaLangString);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    localObject = BridgeHelper.a(super.getActivity(), this.jdField_f_of_type_JavaLangString).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(super.getActivity());
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", this.jdField_m_of_type_Int);
    this.jdField_a_of_type_Bcdq.a(2, (Bundle)localObject);
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
      ThreadManager.executeOnSubThread(new WebViewFragment.4(this, (Activity)localObject));
      if ((this.jdField_m_of_type_Boolean) && (axmt.c())) {
        bhkr.a().b(1);
      }
      if (this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm.jdField_a_of_type_Boolean) {
        D();
      }
      nax.b("Web_qqbrowser_doonresume");
      super.onResume();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
      }
      return;
      i1 = 0;
      continue;
      i1 = 1;
    }
  }
  
  public void onStop()
  {
    if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "close on hide by wv param");
      }
      super.getActivity().finish();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
    }
    super.onStop();
    bcfa.c();
    if ((this.jdField_a_of_type_Bcbv != null) && (this.jdField_a_of_type_Bcbv.a() != null) && (this.jdField_a_of_type_Bcbv.c())) {
      MiniMsgIPCClient.getInstance().clearBusiness(this.jdField_n_of_type_Int);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      if (paramView.getId() == 2131365918)
      {
        paramMotionEvent = paramView.getParent();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof ViewGroup))) {
          ((ViewGroup)paramMotionEvent).removeView(paramView);
        }
      }
    }
    return false;
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i1 = switchRequestCode(paramWebViewPlugin, paramByte);
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
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), a());
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
  }
  
  protected void s()
  {
    b().b();
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i1 = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i1 != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewFragment", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i1);
    return -1;
    return i1 << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public void v()
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
      if (!this.jdField_a_of_type_Bcfm.y) {
        super.getActivity().getWindow().setFlags(this.jdField_l_of_type_Int, 1024);
      }
      super.getActivity().setRequestedOrientation(this.jdField_k_of_type_Int);
      this.jdField_e_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesIX5WebChromeClient$CustomViewCallback = null;
      this.jdField_f_of_type_AndroidViewView = null;
      this.jdField_s_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  protected void w()
  {
    synchronized (bcfz.jdField_a_of_type_JavaLangObject)
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
  
  void x()
  {
    if (!this.jdField_j_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = true;
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
      if (bche.b(str)) {
        ThreadManager.postImmediately(new WebViewFragment.3(this, str), null, false);
      }
    }
  }
  
  void y()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
    if (bche.b(str)) {
      WebSoService.a(getActivity(), str);
    }
  }
  
  void z()
  {
    this.jdField_h_of_type_JavaLangString = d();
    this.jdField_a_of_type_Bcfj.a(this.jdField_h_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long != 4L)
    {
      if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x2) != 0L) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("hide_more_button", true);
      }
      if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 1L) != 0L) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.jdField_a_of_type_Bcfm.jdField_a_of_type_Long & 0x100000) > 0L) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("ignoreLoginWeb", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment
 * JD-Core Version:    0.7.0.1
 */