package com.tencent.mobileqq.webview.swift;

import aayn;
import abgu;
import admy;
import adna;
import adqf;
import agdz;
import agej;
import akxe;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import aohr;
import aser;
import asev;
import asjw;
import avpp;
import avqh;
import bdgb;
import bdll;
import bdmc;
import bdmv;
import bdmw;
import bhin;
import bhlq;
import bhnh;
import bhpc;
import bhzh;
import bilw;
import binl;
import binq;
import bioe;
import biof;
import biog;
import bioh;
import bioi;
import bioj;
import biok;
import biol;
import biom;
import bion;
import bioo;
import biop;
import bioq;
import bioy;
import bioz;
import bipd;
import bipk;
import bipn;
import bips;
import bipt;
import bipy;
import biqa;
import biqg;
import biql;
import biqp;
import biqq;
import biqx;
import biqz;
import birb;
import birg;
import birj;
import birn;
import birp;
import birt;
import birw;
import biry;
import birz;
import bish;
import bitb;
import bitf;
import bitg;
import bitj;
import bitm;
import bito;
import bitp;
import bitr;
import bits;
import bjef;
import bjqh;
import bmko;
import bmky;
import bmzn;
import bngm;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc02216;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mvd;
import niz;
import nkl;
import nnj;
import nnr;
import noe;
import oej;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.opengroup.AppUrlOpenGroup.ReqBody;
import tzq;

public class WebViewFragment
  extends ReportV4Fragment
  implements aayn, View.OnClickListener, View.OnTouchListener, bioe, bioz, bips, bipt, bipy, bitf, bitg, bitj, bitm, bito, bitp, bitr, bits
{
  public static final String ACTION_SELECT_PICTURE = "actionSelectPicture";
  public static final String AIO_EXTRA_SCROLL_Y = "AIO_Scroll_Y";
  protected static final int CREATE_LOOP_STEP_FINAL = 1024;
  public static final int CREATE_LOOP_STEP_INIT_APP_AND_WEBVIEW_ENGINE = 8;
  protected static final int CREATE_LOOP_STEP_INIT_BOTTOM = 512;
  public static final int CREATE_LOOP_STEP_INIT_DATA = 2;
  protected static final int CREATE_LOOP_STEP_INIT_TITLE_BAR = 256;
  protected static final int CREATE_LOOP_STEP_INIT_UI_CONTENT = 128;
  protected static final int CREATE_LOOP_STEP_INIT_UI_FRAME = 64;
  public static final int CREATE_LOOP_STEP_INIT_WEBVIEW = 16;
  public static final int CREATE_LOOP_STEP_INIT_X5_ENVIRONMENT = 4;
  protected static final int CREATE_LOOP_STEP_LOAD_URL = 32;
  public static final int CREATE_LOOP_STEP_NONE = 1;
  public static final String EXTRA_ACTION = "keyAction";
  public static final String KEY_FOR_FORCE_CLOSE_AFTER_JUMP = "keyForForceCloseAfterJump";
  public static final String KEY_FROM_UPDATE_AVATAR = "keyFromUpdateAvatar";
  public static final String KEY_IS_INIT_SONIC_SESSION = "key_is_init_sonic_session";
  protected static final String MORE_GAME_URL = "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155";
  public static final int REQUEST_TO_SCREEN_SHOT_PAGE = 11;
  public static final String TAG = "WebLog_WebViewFragment";
  private static final String T_REPORT_WEB_DOWNLOAD_THIRD_APP = "0X800A86B";
  private static final String T_REPORT_WEB_OPEN_THIRD_APP = "0X800A86A";
  public static int sQQBrowserActivityCounter;
  public int appId;
  protected niz authConfig;
  public BrowserAppInterface browserApp;
  public WebBrowserViewContainer contentView;
  ViewGroup contentViewWrapper;
  FrameLayout customContainer;
  View customView;
  IX5WebChromeClient.CustomViewCallback customViewCallback;
  public Intent intent;
  boolean isArticalChannelReported = false;
  protected boolean isDelaySetTitle;
  public boolean isDestroyed;
  public boolean isFromQzone;
  public boolean isInitView;
  protected volatile boolean isSendWebSoRequest;
  boolean isVideoPlaying;
  private avpp jumpCancelable;
  public boolean mActNeedImmersive = true;
  public volatile AppInterface mApp;
  String mArticalChannelExtralInfo = "";
  int mArticalChannelId = 0;
  public int mBusiID;
  public final bipn mComponentsProvider = createComponentsProvider();
  public int mCreateLoopNextStep = 1;
  protected final birn mCreateLoopScheduler = new birn(new biof(this));
  protected nnj mFileChooserHelper;
  public aser mIpcObserver;
  public String mKeyWording;
  protected long mLastTouchTime;
  public MiniMsgUser mMiniMsgUser;
  public boolean mNeedStatusTrans = true;
  protected boolean mNightMode;
  int mOriginFullscreenFlag;
  int mOriginOrientation;
  protected boolean mPayActionSucc;
  protected volatile WebViewPluginEngine mPluginEngine;
  public String mRedirect302Url = "";
  public biqp mSetting;
  public biqx mStatistics;
  public String mStyle;
  public binq mSwiftTitleUI;
  public View mSystemBarComp;
  public birj mUIStyle;
  public birg mUIStyleHandler;
  public String mUrl;
  public int mWhere;
  boolean mX5CoreActive = false;
  public String msgid = "";
  public String publicUin = "";
  boolean redirectCookie = true;
  protected final Object sInitEngineLock = new Object();
  public abgu share;
  protected SonicClientImpl sonicClient;
  public String sourcePuin = "";
  public RelativeLayout titleRoot;
  View.OnTouchListener titleTouchListener = new bioj(this);
  public String toUin = "";
  public String troopAppCompanyName;
  public String troopAppInfoUrl;
  public String troopAppName;
  public String troopAppShareUrl;
  public int troopId;
  public String uin;
  public int uinType;
  View videoProgressView;
  public TouchWebView webView;
  public String webViewTitle = "";
  bipd webViewWrapper;
  
  private void collectPerformanceInfo()
  {
    long l;
    int i;
    if (this.mStatistics.w)
    {
      l = 2L;
      if (!(this.webView instanceof SwiftReuseTouchWebView)) {
        break label158;
      }
      if (1 != ((SwiftReuseTouchWebView)this.webView).b) {
        break label153;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i), Long.valueOf(biry.jdField_a_of_type_Long) }));
      }
      System.currentTimeMillis();
      JSONObject localJSONObject = this.webView.reportInitPerformance(l, i, this.mStatistics.jdField_c_of_type_Long, biry.jdField_a_of_type_Long);
      this.mStatistics.a(localJSONObject);
      System.currentTimeMillis();
      this.mStatistics.G = SystemClock.elapsedRealtime();
      return;
      if (biqx.s) {}
      for (i = 1;; i = 0)
      {
        l = i;
        break;
      }
      label153:
      i = 0;
      continue;
      label158:
      i = 0;
    }
  }
  
  private void doActivityResultByWeiBo(Intent paramIntent, int paramInt1, int paramInt2)
  {
    QLog.d("WebLog_WebViewFragment", 1, "Activity result  to weibo plugin.");
    if (this.webView == null)
    {
      QLog.d("WebLog_WebViewFragment", 1, "Activity result weibo null == webView.");
      return;
    }
    Object localObject = this.webView.getPluginEngine();
    if (localObject == null)
    {
      QLog.d("WebLog_WebViewFragment", 1, "Activity result weibo null == engine.");
      return;
    }
    localObject = ((WebViewPluginEngine)localObject).a("share");
    if (localObject == null)
    {
      QLog.d("WebLog_WebViewFragment", 1, "Activity result weibo null == plugin.");
      return;
    }
    ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  private void dumpViewInError(ClassCastException paramClassCastException)
  {
    throw new ClassCastException(paramClassCastException.toString());
  }
  
  public static String httpRequest(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
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
      paramContext = nnr.a(paramContext, paramString1, "POST", localBundle, paramString2);
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
  
  private void initTitleColor()
  {
    if (this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null)
    {
      int i = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop();
      int j = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom();
      int k = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft();
      int m = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight();
      this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(super.getResources().getDrawable(2130850099));
      this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(k, i, m, j);
      return;
    }
    this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_c_of_type_Int);
    this.mSwiftTitleUI.d(this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.jdField_d_of_type_Int);
    this.mSwiftTitleUI.f(this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.e);
  }
  
  public static WebViewFragment newInstance(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new WebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void showWarningDialog(Intent paramIntent)
  {
    Resources localResources = getResources();
    bhlq.a(getActivity(), 230, null, localResources.getString(2131719302), localResources.getString(2131690580), localResources.getString(2131694098), new biok(this, paramIntent), new biol(this)).show();
  }
  
  private void traverseViews(View paramView, StringBuilder paramStringBuilder)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = 0;
      label20:
      if (i < localViewGroup.getChildCount())
      {
        if (!(localViewGroup.getChildAt(i) instanceof ViewGroup)) {
          break label54;
        }
        traverseViews(paramView, paramStringBuilder);
      }
      for (;;)
      {
        i += 1;
        break label20;
        break;
        label54:
        paramStringBuilder.append("view:").append(paramView.getClass().getSimpleName()).append("\n");
      }
    }
    paramStringBuilder.append("view:").append(paramView.getClass().getSimpleName()).append("\n");
  }
  
  private void visitViewFromField(View paramView, String paramString)
  {
    Object localObject = paramView.getClass().getDeclaredField(paramString);
    if (localObject == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, new Object[] { paramString, " field is null" });
      return;
    }
    ((Field)localObject).setAccessible(true);
    paramView = ((Field)localObject).get(paramView);
    if (paramView == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, new Object[] { paramString, " statusAttri is null" });
      return;
    }
    localObject = paramView.getClass().getDeclaredField("view");
    if (localObject == null)
    {
      QLog.e("WebLog_WebViewFragment", 1, new Object[] { paramString, " viewField is null" });
      return;
    }
    ((Field)localObject).setAccessible(true);
    paramView = (View)((Field)localObject).get(paramView);
    if (paramView != null)
    {
      localObject = new StringBuilder(100);
      traverseViews(paramView, (StringBuilder)localObject);
      QLog.e("WebLog_WebViewFragment", 1, new Object[] { paramString, ((StringBuilder)localObject).toString() });
      return;
    }
    QLog.d("WebLog_WebViewFragment", 1, new Object[] { paramString, " viewFromState is null" });
  }
  
  public void activityFinish()
  {
    if (this.webView == null) {}
    for (Object localObject = null;; localObject = this.webView.getPluginEngine())
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.mUrl, 8589934598L, null);
      }
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.mUrl, 8589934599L, null);
      }
      if (this.intent.getBooleanExtra("flow_key_from_guide", false))
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
  
  public void addToFavorite(String paramString, boolean paramBoolean)
  {
    if (this.mApp == null) {
      return;
    }
    String str = this.mApp.getCurrentAccountUin();
    bmko.a(paramString).c(str).b(super.getActivity(), str, 2, null);
    paramString = this.mApp;
    if (paramBoolean) {}
    for (int i = 42;; i = 45)
    {
      bmky.a(paramString, i, 2);
      return;
    }
  }
  
  protected void adjustWebViewTopMargin(int paramInt1, int paramInt2)
  {
    Object localObject1 = (TextView)this.mUIStyleHandler.d.findViewById(2131363682);
    if (localObject1 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt1;
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    localObject1 = this.mUIStyleHandler.d.findViewById(2131381335);
    Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt2;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    boolean bool1 = bool2;
    long l;
    if (super.getActivity().isResume()) {
      if (System.currentTimeMillis() - this.mLastTouchTime >= 1000L)
      {
        bool1 = bool2;
        if (!this.authConfig.a(paramWebView.getUrl(), (String)localObject2).booleanValue()) {}
      }
      else
      {
        l = System.currentTimeMillis();
        bool1 = akxe.a().a(paramString, this);
        QLog.i("WebLog_WebViewFragment", 1, "TryPayIntercept result:" + bool1 + " cost:" + (System.currentTimeMillis() - l) + " ms.");
        if (!bool1) {
          break label132;
        }
        bool1 = true;
      }
    }
    return bool1;
    label132:
    localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
    ((Intent)localObject2).addFlags(268435456);
    for (;;)
    {
      try
      {
        ((Intent)localObject2).putExtra("url", getCurrentUrl());
        ActivityInfo localActivityInfo = ((Intent)localObject2).resolveActivityInfo(getActivity().getPackageManager(), 0);
        localObject1 = "";
        if (localActivityInfo != null) {
          localObject1 = localActivityInfo.packageName;
        }
        aohr.a("scheme", paramWebView.getUrl(), (String)localObject1, "1", "web", getActivity().getClass().getName());
        paramWebView = getIntent();
        bool1 = paramWebView.getBooleanExtra("h5_ark_is_from_share", false);
        l = paramWebView.getLongExtra("appShareID", -1L);
        ((Intent)localObject2).putExtra("h5_ark_is_from_share", bool1);
        ((Intent)localObject2).putExtra("appShareID", l);
        if (this.jumpCancelable != null) {
          this.jumpCancelable.a();
        }
      }
      catch (Exception paramWebView)
      {
        QLog.e("WebLog_WebViewFragment", 1, "afterWebViewEngineHandleOverrideUrl error!", paramWebView);
        continue;
      }
      try
      {
        bool2 = getIntent().getBooleanExtra("keyForForceCloseAfterJump", false);
        this.jumpCancelable = JefsClass.getInstance().a(getActivity(), (Intent)localObject2, paramString, new WebViewFragment.15(this, (Intent)localObject2, bool2, (String)localObject1, bool1, l));
        return true;
      }
      catch (Throwable paramWebView)
      {
        QLog.e("WebLog_WebViewFragment", 1, paramWebView, new Object[0]);
      }
    }
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return true;
    }
    noe.a("urlInterceptManager");
    paramWebView = birz.b(paramString);
    if ((("http".equals(paramWebView)) || ("data".equals(paramWebView))) && ((super.getActivity() instanceof QQBrowserActivity))) {
      if ((this.browserApp != null) && (this.browserApp.a != null))
      {
        paramWebView = this.browserApp.a.a(paramString);
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
    noe.b("urlInterceptManager");
    return false;
  }
  
  void buildCookieForRedirect(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.b(paramString1);
      String str = SwiftBrowserCookieMonster.b(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.redirectCookie = false;
      }
      if (this.redirectCookie)
      {
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null) {
          paramString1.a(paramString2, this, null, this.intent);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebLog_WebViewFragment", 1, paramString1, new Object[0]);
    }
  }
  
  public void changeFullScreenCutoutMode()
  {
    if ((Build.VERSION.SDK_INT >= 28) && (super.getActivity() != null) && (this.mUIStyle.jdField_a_of_type_Boolean))
    {
      Window localWindow = getActivity().getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  void checkAppUrl(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    AppUrlOpenGroup.ReqBody localReqBody = new AppUrlOpenGroup.ReqBody();
    localReqBody.uint32_appid.set(paramInt);
    localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(this.mUrl));
    localReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new NewIntent(BaseApplicationImpl.getApplication(), nkl.class);
    paramString.putExtra("cmd", "GroupOpen.CheckAppUrl");
    paramString.putExtra("data", localReqBody.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    this.mApp.startServlet(paramString);
  }
  
  public bipn createComponentsProvider()
  {
    return new bipn(this, 127, null);
  }
  
  public TouchWebView createCustomWebView()
  {
    return null;
  }
  
  public final bipd createWebViewWrapper(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    boolean bool1;
    TouchWebView localTouchWebView;
    if ((this.mUIStyle.jdField_b_of_type_Long & 0x40) != 0L)
    {
      bool1 = true;
      localTouchWebView = createCustomWebView();
      if (localTouchWebView != null) {
        break label201;
      }
    }
    label201:
    for (this.webViewWrapper = new bipk(this.mApp, super.getActivity(), this, this.intent, bool1);; this.webViewWrapper = new bipk(this.mApp, super.getActivity(), this, this.intent, localTouchWebView))
    {
      this.webViewWrapper.a(this.sonicClient);
      localTouchWebView = this.webViewWrapper.a();
      if (this.sonicClient != null) {
        this.sonicClient.bindWebView(localTouchWebView);
      }
      this.mPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.mPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        biqx localbiqx = this.mStatistics;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).b) {
          bool1 = true;
        }
        localbiqx.jdField_u_of_type_Boolean = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.mX5CoreActive = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.mNightMode) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.webViewWrapper;
      bool1 = false;
      break;
    }
  }
  
  void destroyWebView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    biqx localbiqx = this.mStatistics;
    this.isDestroyed = true;
    localbiqx.l = true;
    if (this.webViewWrapper != null)
    {
      this.webViewWrapper.a();
      this.webViewWrapper = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  public boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.webView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.webView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.webView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_FINAL");
    noe.a("Web_IPCSetup");
    if (!asjw.a().a()) {
      asjw.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    noe.b("Web_IPCSetup");
    if ((this.mUIStyle.jdField_a_of_type_Long & 0x400000) > 0L)
    {
      SosoInterface.a(new bioo(this, 0, false, false, 600000L, false, false, "webview"));
      SosoInterface.a(new biop(this, 0, true, false, 600000L, false, false, "webview"));
    }
    ThreadManager.getUIHandler().postDelayed(new WebViewFragment.8(this), 3000L);
    ThreadManager.executeOnSubThread(new WebViewFragment.9(this));
    birp.a().a(new biog(this, 2));
    noe.b("Web_qqbrowser_state_machine_init_FINAL");
    noe.b("Web_qqbrowser_state_machine_all");
    this.mCreateLoopNextStep = 1;
    collectPerformanceInfo();
    return -1;
  }
  
  public int doCreateLoopStep_InitAppAndWebVieEngine(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.mApp instanceof BrowserAppInterface)) {
      this.browserApp = ((BrowserAppInterface)this.mApp);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(this.mApp.getApplication(), this.mApp);
    }
    this.uin = this.mApp.getAccount();
    if (this.mApp.getLongAccountUin() != 0L)
    {
      paramBundle = this.mStatistics;
      if (this.mApp.getLongAccountUin() % biqx.jdField_d_of_type_Int != 6L) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      paramBundle.i = bool;
      ensurePluginEngineCreated();
      if (this.mPluginEngine != null)
      {
        this.mPluginEngine.a(getIntent().getStringArrayExtra("insertPluginsArray"));
        this.mPluginEngine.a(this.mUrl, 1L, null);
      }
      this.mCreateLoopNextStep = 16;
      if (biqx.x) {
        this.mStatistics.a("webview_init", System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, "0");
      }
      noe.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
      return 1;
    }
  }
  
  public int doCreateLoopStep_InitBottomBar(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_bottombar");
    this.mUIStyleHandler.b(getIntent(), this.mUrl);
    this.mUIStyleHandler.f();
    this.mCreateLoopNextStep = 1024;
    noe.b("Web_qqbrowser_state_machine_init_bottombar");
    if (this.webView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
      }
      return -1;
    }
    return 1;
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("4745");
    paramBundle = this.intent.getStringExtra("options");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.intent.putExtra("url", paramBundle.getString("url"));
      if (!this.intent.hasExtra("key_isReadModeEnabled")) {
        this.intent.putExtra("key_isReadModeEnabled", true);
      }
      this.intent.putExtra("ba_is_login", paramBundle.optBoolean("ba_is_login", true));
      this.intent.putExtra("isShowAd", paramBundle.optBoolean("isShowAd", true));
      this.intent.putExtra("avoidLoginWeb", paramBundle.optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        boolean bool;
        int j;
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d("WebLog_WebViewFragment", 2, paramBundle.toString());
          continue;
          i = 0;
          continue;
          bool = false;
        }
      }
    }
    if (("Xiaomi_MI 2".equals(Build.MANUFACTURER + "_" + Build.MODEL)) && (Build.VERSION.SDK_INT == 16)) {
      this.isDelaySetTitle = true;
    }
    this.mArticalChannelId = this.intent.getIntExtra("articalChannelId", 100);
    this.mArticalChannelExtralInfo = this.intent.getStringExtra("ARTICAL_CHANNEL_EXTRAL_INFO");
    this.isFromQzone = this.intent.getBooleanExtra("fromQZone", false);
    bool = this.intent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    j = hashCode();
    if (bool)
    {
      i = 1;
      bdmv.a(paramBundle, j, i, this.mUrl);
      if (this.intent.getBooleanExtra("vasUsePreWebview", false)) {
        break label476;
      }
      bool = true;
      this.mSetting.a("web_view_long_click", bool);
      this.mStatistics.jdField_a_of_type_Biqz.b = this.intent.getIntExtra("individuation_url_type", -1);
      if (sQQBrowserActivityCounter == 1) {
        biqz.jdField_d_of_type_Int = this.mStatistics.jdField_a_of_type_Biqz.b;
      }
      if ((this.mStatistics.jdField_a_of_type_Biqz.b == -1) && (biqz.jdField_d_of_type_Int != -1)) {
        this.mStatistics.jdField_a_of_type_Biqz.b = biqz.jdField_d_of_type_Int;
      }
      this.mStatistics.jdField_d_of_type_JavaLangString = this.mUrl;
      this.webViewTitle = this.intent.getStringExtra("title");
      this.mUIStyleHandler.jdField_a_of_type_JavaLangString = this.webViewTitle;
      if ((this.mUIStyle.jdField_a_of_type_Long & 0x4000000) == 0L) {
        this.mSetting.a("image_long_click", true);
      }
      noe.b("Web_qqbrowser_state_machine_init_data");
      this.mCreateLoopNextStep = 4;
      return 0;
    }
  }
  
  public int doCreateLoopStep_InitTitleBar(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    noe.a("Web_qqbrowser_state_machine_init_titlebar");
    initTitleBar(this.intent, this.mUrl);
    this.mUIStyleHandler.g();
    initTabBarView();
    paramBundle = this.intent.getExtras();
    if (paramBundle != null)
    {
      this.uinType = paramBundle.getInt("uin_type");
      this.publicUin = paramBundle.getString("puin");
      this.msgid = paramBundle.getString("msg_id");
      if (this.msgid == null) {
        this.msgid = "";
      }
      this.sourcePuin = paramBundle.getString("source_puin");
      if (this.sourcePuin == null) {
        this.sourcePuin = "";
      }
      this.toUin = paramBundle.getString("friendUin");
      if (this.toUin == null) {
        this.toUin = "";
      }
      boolean bool = paramBundle.getBoolean("isOpeningQunApp");
      this.appId = paramBundle.getInt("appid");
      this.troopId = paramBundle.getInt("troopid");
      String str = paramBundle.getString("extraParams");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        if (birz.a()) {
          break label285;
        }
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131690728));
      }
    }
    for (;;)
    {
      checkAppUrl(this.appId, paramBundle, new bion(this));
      this.mCreateLoopNextStep = 512;
      ((biqq)getComponentProvider().a(4)).d();
      noe.b("Web_qqbrowser_state_machine_init_titlebar");
      this.mStatistics.K = (SystemClock.elapsedRealtime() - l);
      return 1;
      label285:
      if (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.getBackground() == null) {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setText(super.getResources().getString(2131690728));
      }
    }
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    long l = SystemClock.elapsedRealtime();
    noe.a("Web_qqbrowser_state_machine_init_ui_main_content");
    noe.a("Web_qqbrowser_initView");
    if (!this.isInitView)
    {
      this.isInitView = true;
      this.mUIStyleHandler.a(this.contentView, this.intent, this.webView);
      if (this.webView.isPaused) {
        this.webView.onResume();
      }
      if ((this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
        ((RefreshView)this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).setOnFlingGesture(this);
      }
    }
    for (;;)
    {
      noe.b("Web_qqbrowser_initView");
      noe.b("Web_qqbrowser_state_machine_init_ui_main_content");
      this.mStatistics.L = (SystemClock.elapsedRealtime() - l);
      this.mCreateLoopNextStep = 256;
      return 1;
      if ((this.mUIStyle.jdField_a_of_type_Boolean) && (this.mUIStyle.jdField_c_of_type_Long != 0L)) {
        this.mUIStyleHandler.jdField_a_of_type_Binl.a(this.contentView);
      }
    }
  }
  
  public int doCreateLoopStep_InitUIFrame(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (!this.mUIStyleHandler.jdField_c_of_type_Boolean)
    {
      long l = SystemClock.elapsedRealtime();
      showPreview();
      this.mStatistics.J = (SystemClock.elapsedRealtime() - l);
    }
    this.mCreateLoopNextStep = 128;
    noe.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public int doCreateLoopStep_InitWebView(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_webview");
    this.mStatistics.c("state_webview_create");
    initWebView();
    noe.b("Web_qqbrowser_state_machine_init_webview");
    this.mCreateLoopNextStep = 32;
    this.mStatistics.Q = System.currentTimeMillis();
    this.mStatistics.jdField_u_of_type_Long = (this.mStatistics.Q - this.mStatistics.P);
    if (biqx.x) {
      this.mStatistics.a("should_start_load", this.mStatistics.Q - this.mStatistics.jdField_c_of_type_Long, "0");
    }
    bmzn.a().a(this.mUrl, 130, this.mStatistics.Q - this.mStatistics.jdField_c_of_type_Long, "0", this.mStatistics.e, this.mStatistics.g);
    return 0;
  }
  
  public int doCreateLoopStep_InitX5Environment(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_init_x5_environment");
    this.mStatistics.P = System.currentTimeMillis();
    this.mCreateLoopNextStep = 8;
    if (biry.a())
    {
      noe.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (biry.b())
    {
      noe.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    noe.b("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  public int doCreateLoopStep_LoadUrl(Bundle paramBundle)
  {
    noe.a("Web_qqbrowser_state_machine_load_url");
    this.mStatistics.c("state_load_url");
    long l1 = System.currentTimeMillis();
    noe.a("Web_qqbrowser_init");
    startLoadUrl();
    noe.b("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.mStatistics.o = (l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "init param and load url, cost = " + this.mStatistics.o);
    }
    noe.b("Web_qqbrowser_state_machine_load_url");
    this.mCreateLoopNextStep = 64;
    return 0;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if ((!TextUtils.isEmpty(this.mUrl)) && (this.mUrl.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        super.getActivity().setResult(-1, paramIntent);
        super.getActivity().finish();
      }
      break;
    }
    label307:
    label584:
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
                bmko.a(super.getActivity(), paramIntent);
                return;
                localObject = paramIntent.getStringExtra("DELETE_BLOG");
                if (this.webView != null) {
                  this.webView.loadUrl((String)localObject);
                }
                if (paramIntent == null) {
                  break;
                }
                boolean bool2 = paramIntent.getBooleanExtra("click_long_screen_shot", false);
                QLog.d("WebLog_WebViewFragment", 1, "REQUEST_TO_SCREEN_SHOT_PAGE. clickLongScreenShot is " + bool2);
                if ((!bool2) || (this.webView == null)) {
                  break;
                }
                QLog.d("WebLog_WebViewFragment", 1, "start screen long shot");
                bhin.a(this.webView, new bioi(this));
                break;
                if (paramInt1 != 21) {
                  break label307;
                }
                localObject = agej.a(new Intent(super.getActivity(), SplashActivity.class), null);
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
            } while (dispatchPluginEvent(8589934600L, (Map)localObject));
            if (bilw.a(paramIntent, paramInt1))
            {
              doActivityResultByWeiBo(paramIntent, paramInt1, paramInt2);
              return;
            }
            int i = birz.a(paramInt1);
            int j = birz.b(paramInt1);
            if (j <= 0) {
              break label548;
            }
            if (this.webView != null)
            {
              localObject = this.webView.getPluginEngine();
              if (localObject != null)
              {
                if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (((WebViewPluginEngine)localObject).a("card") == null)) {
                  ((WebViewPluginEngine)localObject).a(new String[] { "card" });
                }
                localObject = ((WebViewPluginEngine)localObject).a(j, true);
                if (localObject != null)
                {
                  ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)i, paramInt2);
                  return;
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.w("WebLog_WebViewFragment", 2, "Caution! activity result not handled!");
          return;
          if ((this.mFileChooserHelper == null) || (!this.mFileChooserHelper.a(paramInt1, paramInt2, paramIntent))) {
            break label584;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebLog_WebViewFragment", 2, "Activity result handled by FileChooserHelper.");
        return;
      } while ((paramInt2 != -1) || (this.webView == null));
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (paramIntent == null);
    label548:
    Object localObject = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    this.webView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
    for (;;)
    {
      try
      {
        if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
          break label798;
        }
        this.mPayActionSucc = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionSucc=" + this.mPayActionSucc);
        return;
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebLog_WebViewFragment", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
      return;
      label798:
      bool1 = false;
    }
  }
  
  public void doOnBackEvent()
  {
    this.mStatistics.c("state_back");
    if (1 != this.mCreateLoopNextStep)
    {
      this.mCreateLoopScheduler.b();
      this.mCreateLoopNextStep = 1;
    }
    if ((TextUtils.isEmpty(this.mUrl)) && (this.webView != null)) {
      this.mUrl = this.webView.getUrl();
    }
    this.mStatistics.b(getIntent(), this.mUrl);
    this.mStatistics.a(BaseApplicationImpl.getApplication(), this.mUrl, this.intent);
    agdz.c(this.intent);
    if (this.isVideoPlaying) {
      onHideCustomView();
    }
    HashMap localHashMap;
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      do
      {
        return;
        if (this.sonicClient != null) {
          this.sonicClient.clearHistory();
        }
        localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
      } while (dispatchPluginEvent(8589934601L, localHashMap));
      if ((this.mUIStyle.g) || ((this.mUIStyle.jdField_a_of_type_Long & 0x4) != 0L) || (this.webView == null) || (!this.webView.canGoBack())) {
        break;
      }
      this.webView.stopLoading();
      this.webView.goBack();
      localWebViewPluginEngine = this.webView.getPluginEngine();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.a(this.webView.getUrl(), 8589934610L, localHashMap);
    return;
    super.getActivity().finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.isInitView);
    this.mComponentsProvider.a(4, localBundle);
    if (this.webView != null) {}
    for (paramConfiguration = this.webView.getPluginEngine();; paramConfiguration = null)
    {
      if (paramConfiguration != null) {
        paramConfiguration.a(this.mUrl, 8589934611L, null);
      }
      return;
    }
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    agdz.a(this.intent);
    Object localObject = (biqg)this.mComponentsProvider.a(1);
    if ((localObject != null) && (!((biqg)localObject).a(this.intent)))
    {
      super.getActivity().finish();
      return true;
    }
    preInitData();
    if (paramBundle != null)
    {
      this.intent.removeExtra("qqBrowserActivityCreateTime");
      this.intent.putExtra("startOpenPageTime", 0L);
      QLog.e("WebLog_WebViewFragment", 1, "doOnCreate mOnCreateMilliTimeStamp = " + this.intent.getLongExtra("qqBrowserActivityCreateTime", -2L));
    }
    this.mStatistics.c("state_activity_create");
    this.mStatistics.a(this.intent, this.mUrl);
    doWebSoRequest();
    if ((this.intent != null) && (!this.intent.getBooleanExtra("key_is_init_sonic_session", true))) {}
    for (boolean bool = false;; bool = initSonicSession(getUrlFromIntent()))
    {
      this.mStatistics.jdField_d_of_type_Boolean = bool;
      if (!bool) {
        ThreadManager.post(new WebViewFragment.2(this), 5, null, true);
      }
      noe.a("Web_qqbrowser_dooncreate");
      this.mActNeedImmersive = false;
      this.mNeedStatusTrans = false;
      bdmc.a(BaseApplicationImpl.getApplication(), 10000L);
      this.mStatistics.N = System.currentTimeMillis();
      this.mNightMode = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      this.authConfig = niz.a();
      localObject = this.mStatistics;
      this.isDestroyed = false;
      ((biqx)localObject).l = false;
      this.mStatistics.O = System.currentTimeMillis();
      noe.a("Web_qqbrowser_state_machine_all");
      this.mCreateLoopNextStep = 2;
      if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.jdField_c_of_type_Int > 0)) {
        this.mCreateLoopScheduler.a();
      }
      WebAccelerateHelper.isWebViewCache = true;
      this.mCreateLoopScheduler.a(paramBundle);
      paramBundle = new Bundle();
      paramBundle.putString("url", this.mUrl);
      this.mComponentsProvider.a(5, paramBundle);
      this.mStatistics.r = (System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long);
      noe.b("Web_qqbrowser_dooncreate");
      this.mStatistics.S = System.currentTimeMillis();
      return true;
    }
  }
  
  public void doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 82: 
      dispatchPluginEvent(8589934607L, null);
      return;
    case 25: 
      dispatchPluginEvent(8589934608L, null);
      return;
    }
    dispatchPluginEvent(8589934609L, null);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i = -1;
    int j;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      j = paramIntent.getIntExtra("requestCode", -1);
      int k = j >> 8 & 0xFF;
      if (k > 0) {
        if (this.webView != null)
        {
          localObject = this.webView.getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(k, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label574;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(j & 0xFF), i);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewFragment", 2, "Caution! activity result not handled!");
      }
      this.uin = this.mApp.getAccount();
      if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
      {
        if (this.webView == null) {
          break label569;
        }
        localObject = this.webView.getPluginEngine();
        if (localObject == null) {
          break label569;
        }
        localObject = ((WebViewPluginEngine)localObject).a(120, true);
        if ((localObject == null) || (!(localObject instanceof BuscardJsPlugin))) {
          break label569;
        }
        ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
      }
      label569:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          BuscardHelper.a(this.uin, super.getActivity(), paramIntent);
        }
        localObject = new HashMap();
        ((Map)localObject).put("intent", paramIntent);
        dispatchPluginEvent(128L, (Map)localObject);
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
            paramIntent = asev.a("ipc_update_avatar", "", 0, paramIntent);
            asjw.a().b(paramIntent);
            return;
          }
        }
        localObject = paramIntent.getDataString();
        if ((localObject != null) && (this.webView != null)) {
          this.webView.loadUrl((String)localObject);
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
          biql localbiql = (biql)this.mComponentsProvider.a(64);
          if (localbiql == null) {
            break;
          }
          localbiql.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
          return;
          this.intent = paramIntent;
          preInitData();
          this.mCreateLoopScheduler.b();
          if (paramIntent.getBooleanExtra("onNewIntentReDoStateMachine", true))
          {
            this.mCreateLoopNextStep = 2;
            this.mCreateLoopScheduler.a(paramIntent.getExtras());
          }
        }
      }
      label574:
      i = 0;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_a_of_type_Boolean))
    {
      hideVirtualNavBar();
      changeFullScreenCutoutMode();
    }
  }
  
  public void doShowTitleBar(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {}
    int j;
    do
    {
      return;
      j = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296599);
      if (paramBoolean) {
        break;
      }
      adjustWebViewTopMargin(j, 0);
      localViewGroup.setVisibility(8);
    } while (this.mSystemBarComp == null);
    this.mSystemBarComp.setVisibility(8);
    this.mUIStyleHandler.d.findViewById(2131365074).setVisibility(8);
    return;
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());; i = 0)
    {
      if (this.mUIStyle.n) {
        j += i;
      }
      for (;;)
      {
        adjustWebViewTopMargin(j, i);
        localViewGroup.setVisibility(0);
        if (this.mSystemBarComp == null) {
          break;
        }
        this.mSystemBarComp.setVisibility(0);
        this.mUIStyleHandler.d.findViewById(2131365074).setVisibility(0);
        return;
        j += i * 2;
        i += BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299018);
      }
    }
  }
  
  public void doTransparent(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
    this.mUIStyleHandler.a(paramJSONObject, true);
  }
  
  void doWebSoRequest()
  {
    if (!this.isSendWebSoRequest)
    {
      this.isSendWebSoRequest = true;
      String str = this.intent.getStringExtra("url");
      if (bitb.b(str)) {
        ThreadManager.postImmediately(new WebViewFragment.3(this, str), null, false);
      }
    }
  }
  
  void doWebsoShowScreenshot()
  {
    String str = this.intent.getStringExtra("url");
    if (bitb.b(str)) {
      WebSoService.a(getActivity(), str);
    }
  }
  
  public void enableSwipeBackForHost(boolean paramBoolean)
  {
    if ((this.mUIStyleHandler != null) && ((this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView))) {
      ((RefreshView)this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).c(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForHost enable=" + paramBoolean);
    }
  }
  
  public void enableSwipeBackForJS(boolean paramBoolean)
  {
    if ((this.mUIStyleHandler != null) && ((this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView))) {
      ((RefreshView)this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).b(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "enableSwipeBackForJS enable=" + paramBoolean);
    }
  }
  
  void ensureCreateLoopFinished()
  {
    if (1 != this.mCreateLoopNextStep)
    {
      int i = this.mCreateLoopNextStep;
      this.mCreateLoopScheduler.b();
      this.mCreateLoopScheduler.a();
      this.mCreateLoopScheduler.a(null);
    }
  }
  
  protected void ensurePluginEngineCreated()
  {
    synchronized (birw.a)
    {
      if (WebViewPluginEngine.a != null)
      {
        this.mPluginEngine = WebViewPluginEngine.a;
        WebViewPluginEngine.a = null;
      }
      if (this.mPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "-->web engine and plugin initialized at process preload!");
        }
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, super.getActivity());
        this.mPluginEngine.a();
        WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, this);
        return;
      }
    }
    this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, super.getActivity(), null, null);
    WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, super.getActivity());
    WebAccelerateHelper.getInstance().bindFragment(this.mPluginEngine, this);
  }
  
  protected abgu ensureShare()
  {
    if (this.share == null) {
      this.share = new abgu(this.mApp, super.getActivity());
    }
    return this.share;
  }
  
  public void flingLToR()
  {
    if (this.webView == null) {
      doOnBackEvent();
    }
    HashMap localHashMap;
    do
    {
      return;
      if (!this.webView.canGoBack()) {
        break;
      }
      localHashMap = new HashMap(1);
      localHashMap.put("target", Integer.valueOf(2));
    } while (!this.webView.goBack(localHashMap));
    reset();
    return;
    doOnBackEvent();
  }
  
  public Intent generateConverationIntent()
  {
    return generateGoToConversation(birz.a(this, this.intent));
  }
  
  public Intent generateGoToConversation(Bundle paramBundle)
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
          break label284;
        }
        localIntent.putExtra("banner_webViewUrl", paramBundle.getString("banner_webViewUrl"));
        label144:
        if (!paramBundle.containsKey("banner_wording")) {
          break label310;
        }
        localIntent.putExtra("banner_wording", paramBundle.getString("banner_wording"));
        label170:
        if (!paramBundle.containsKey("banner_businessCategory")) {
          break label478;
        }
        localIntent.putExtra("banner_businessCategory", paramBundle.getString("banner_businessCategory"));
        label196:
        if (!paramBundle.containsKey("banner_webview_extra")) {
          break label538;
        }
      }
      label538:
      for (paramBundle = paramBundle.getBundle("banner_webview_extra");; paramBundle = new Bundle())
      {
        if ((this.webView.getView() != null) && (this.webView.getView().getScrollY() > 0)) {
          paramBundle.putInt("AIO_Scroll_Y", this.webView.getView().getScrollY());
        }
        localIntent.putExtra("banner_webview_extra", paramBundle);
        return localIntent;
        localIntent.putExtra("banner_activityName", QQBrowserActivity.class.getName());
        break;
        label284:
        if (TextUtils.isEmpty(this.mUrl)) {
          break label144;
        }
        localIntent.putExtra("banner_webViewUrl", this.mUrl);
        break label144;
        label310:
        Object localObject = this.webView.getTitle();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).trim();
          label330:
          String str = birz.b((String)localObject);
          if ((!"http".equals(str)) && (!"https".equals(str)) && (!"data".equals(str)) && (!"file".equals(str)) && (!((String)localObject).startsWith("about")) && (!((String)localObject).startsWith("base64"))) {
            break label455;
          }
        }
        label455:
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (((String)localObject).length() <= 1)) {
            break label460;
          }
          localIntent.putExtra("banner_wording", String.format(anzj.a(2131715675), new Object[] { this.webView.getTitle() }));
          break;
          localObject = "";
          break label330;
        }
        label460:
        localIntent.putExtra("banner_wording", anzj.a(2131715676));
        break label170;
        label478:
        if (TextUtils.isEmpty(this.mUrl)) {
          break label196;
        }
        localObject = Uri.parse(this.mUrl);
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
  
  public bipn getComponentProvider()
  {
    return this.mComponentsProvider;
  }
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.webView != null)
      {
        if (TextUtils.isEmpty(this.webView.getUrl())) {
          break label46;
        }
        str1 = this.webView.getUrl();
      }
    }
    return str1;
    label46:
    return this.intent.getStringExtra("url");
  }
  
  public Activity getHostActivity()
  {
    return super.getActivity();
  }
  
  public WebViewFragment getHostFragment()
  {
    return this;
  }
  
  public WebView getHostWebView()
  {
    return this.webView;
  }
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public long getLoadShareJsTime()
  {
    return this.mStatistics.jdField_a_of_type_Long;
  }
  
  protected MiniMsgUser.IMiniMsgActionCallback getMiniMsgActionCallback()
  {
    return new biom(this);
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = this.mBusiID;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.requestCode = 200;
    if (this.mSwiftTitleUI.a() != null)
    {
      localMiniMsgUserParam.entryView = this.mSwiftTitleUI.a();
      localMiniMsgUserParam.unreadView = ((TextView)this.mSwiftTitleUI.a().findViewById(2131371183));
    }
    localMiniMsgUserParam.actionCallback = getMiniMsgActionCallback();
    return localMiniMsgUserParam;
  }
  
  public String getMsgid()
  {
    return this.msgid;
  }
  
  public String getOpenidBatch(String paramString)
  {
    paramString = httpRequest(BaseApplicationImpl.getApplication(), "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.intent.getStringExtra("vkey"), this.uin);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  public boolean getPayActionSucc()
  {
    return this.mPayActionSucc;
  }
  
  public String getPublicUin()
  {
    return this.publicUin;
  }
  
  public String getRedirect302Url()
  {
    return this.mRedirect302Url;
  }
  
  public long getRulesFromUrl()
  {
    return this.mUIStyle.jdField_a_of_type_Long;
  }
  
  public abgu getShare()
  {
    return ensureShare();
  }
  
  public String getShareUrl()
  {
    if (ensureShare() == null) {
      return "";
    }
    return ensureShare().a();
  }
  
  public String getSourcePuin()
  {
    return this.sourcePuin;
  }
  
  @Deprecated
  public SystemBarCompact getSystemBarComp()
  {
    return null;
  }
  
  public int getTitleBarAlpa()
  {
    return this.mUIStyle.jdField_d_of_type_Int;
  }
  
  public int getTitleBarHeight()
  {
    return super.getResources().getDimensionPixelSize(2131299011);
  }
  
  public View getTitleBarView()
  {
    return this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public Activity getTopActivity()
  {
    return BaseActivity.sTopActivity;
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public String getUrlFromIntent()
  {
    String str2 = this.intent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.intent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.videoProgressView == null) {
      this.videoProgressView = LayoutInflater.from(super.getActivity()).inflate(2131563083, null);
    }
    return this.videoProgressView;
  }
  
  public CustomWebView getWebView()
  {
    return this.webView;
  }
  
  public void goToConversation()
  {
    goToConversation(birz.a(this, this.intent));
  }
  
  public final void goToConversation(Bundle paramBundle)
  {
    if ((this.mUIStyle.F) && (paramBundle != null))
    {
      paramBundle = generateGoToConversation(paramBundle);
      if (paramBundle != null) {
        startActivity(paramBundle);
      }
      return;
    }
    QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
  }
  
  public final void gotoConversationForH5SDK()
  {
    gotoConversationForH5SDK(anzj.a(2131715677), 2130838356, null, SingleTaskQQBrowser.class.getName());
  }
  
  public final void gotoConversationForH5SDK(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    QLog.d("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK " + paramString1 + "," + paramInt + "," + paramString2 + "," + paramString3);
    if (!this.intent.getBooleanExtra("from_single_task", false))
    {
      QLog.e("WebLog_WebViewFragment", 1, "WebViewSwitchAio gotoConversationForH5SDK call from normal activity, ignore.");
      return;
    }
    Bundle localBundle1 = asev.a("ipc_qqbrowser_to_conversation", "", 0, null);
    localBundle1.putInt("banner_msg", 1134049);
    Bundle localBundle2 = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = anzj.a(2131715672);
    }
    localBundle2.putString("tips", str);
    localBundle2.putString("iconURL", paramString2);
    localBundle2.putInt("icon", paramInt);
    localBundle2.putInt("timeout", 900000);
    localBundle2.putString("url", this.mUrl);
    localBundle2.putString("activity", paramString3);
    localBundle2.putInt("flags", 335544320);
    localBundle1.putBundle("barInfo", localBundle2);
    asjw.a().b(localBundle1);
    paramString1 = new Intent();
    paramString1.setClass(getActivity(), SplashActivity.class);
    paramString1.setFlags(335544320);
    paramString1.putExtra("tab_index", MainFragment.b);
    paramString1.putExtra("fragment_id", 1);
    startActivity(paramString1);
  }
  
  public void gotoSelectPicture(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    super.startActivity(paramIntent);
  }
  
  public void handlePreloadCallback(int paramInt, String paramString)
  {
    birb localbirb = (birb)this.mComponentsProvider.a(16);
    if (localbirb != null) {
      localbirb.a(paramInt, paramString);
    }
  }
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    if ("handleImage".equals(paramString))
    {
      localObject = (biqa)this.mComponentsProvider.a(8);
      if (localObject != null) {
        return Boolean.valueOf(((biqa)localObject).a());
      }
    }
    Object localObject = (birb)this.mComponentsProvider.a(16);
    if (localObject != null) {
      return ((birb)localObject).a(paramString, paramBundle);
    }
    return null;
  }
  
  public void hideQQBrowserButton() {}
  
  public void hideVirtualNavBar()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }
  }
  
  protected void initFinish() {}
  
  public void initNativeMiniAIOUser()
  {
    if (this.mMiniMsgUser == null)
    {
      this.mMiniMsgUser = new MiniMsgUser(getActivity(), getMiniMsgUserParam());
      this.mMiniMsgUser.onForeground();
    }
  }
  
  boolean initSonicSession(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "initSonicSession url = :" + paramString);
    }
    for (;;)
    {
      int i;
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
            long l = Long.parseLong((String)localObject);
            if ((0x2 & l) == 0L) {
              break label332;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label338;
            }
            i = 1;
            break label320;
            label137:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label351;
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
            this.sonicClient = new SonicClientImpl((SonicSession)localObject);
            ((SonicSession)localObject).bindClient(this.sonicClient);
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
        label320:
        if (i == 0) {
          break label343;
        }
        str = "store";
        break label137;
        label332:
        bool = false;
        break;
        label338:
        i = 0;
      }
      label343:
      String str = "true";
      continue;
      label351:
      boolean bool = false;
    }
  }
  
  public void initTabBarView()
  {
    noe.a("Web_qqbrowser_createtabbar");
    Activity localActivity = getHostActivity();
    if ((localActivity instanceof QQBrowserActivity))
    {
      ((QQBrowserActivity)localActivity).h();
      boolean bool1 = avqh.a().c();
      boolean bool2 = getIntent().getBooleanExtra("fromAio", false);
      if ((bool1) && (bool2)) {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    noe.b("Web_qqbrowser_createtabbar");
  }
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    this.mUIStyleHandler.a(paramIntent, paramString);
  }
  
  protected void initWebView()
  {
    int i = -1;
    int j = 0;
    long l1;
    long l2;
    if (this.webView == null)
    {
      this.webView = createWebViewWrapper(null).a();
      this.webView.getView().setOnTouchListener(this);
      this.webView.setOnLongClickListener(new bioq(this));
      l1 = System.currentTimeMillis();
      if ((this.mUIStyle.jdField_a_of_type_Long & 0x10000) == 0L) {
        break label335;
      }
      i = 2;
      if (AppSetting.f) {
        i = 2;
      }
      this.webView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
      }
      this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.mStatistics.n = (l2 - l1);
      this.mStatistics.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.mStatistics.n);
      }
      l1 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.webView.getX5WebViewExtension();
      i = j;
      if (localIX5WebViewExtension != null) {
        i = 1;
      }
      if (i == 0) {
        break label389;
      }
      Bundle localBundle = birz.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      this.mStatistics.e = 2;
    }
    label389:
    for (this.mStatistics.g = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.mStatistics.g = String.valueOf(Build.VERSION.SDK_INT))
    {
      this.mStatistics.I = this.webViewWrapper.jdField_a_of_type_Long;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l2 - l1));
      }
      return;
      label335:
      switch (this.intent.getIntExtra("reqType", -1))
      {
      case 2: 
      case 3: 
      default: 
        break;
      case 1: 
        i = 2;
        break;
      case 4: 
        i = 0;
        break;
        this.mStatistics.e = 1;
      }
    }
  }
  
  public boolean isActivityResume()
  {
    if (getActivity() != null) {
      return getActivity().isResume();
    }
    return false;
  }
  
  public boolean isFullScreen()
  {
    return this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_a_of_type_Boolean;
  }
  
  protected boolean isNeedMiniMsg()
  {
    return true;
  }
  
  public boolean isNotNeedLoadShareJs(String paramString)
  {
    return ((biqq)this.mComponentsProvider.a(4)).a(paramString);
  }
  
  public boolean isTransparentTitle()
  {
    return this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_b_of_type_Boolean;
  }
  
  protected void listenKeyboardShowHide(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 11) && (paramView != null)) {
      paramView.addOnLayoutChangeListener(new bioh(this));
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((getHostActivity() != null) && (getHostActivity().isFinishing()))
    {
      QLog.e("WebLog_WebViewFragment", 1, "HostActivity " + getHostActivity() + " is finishing! Don't call WebViewFragment.doOnCreate!");
      return;
    }
    doOnCreate(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.intent = ((Intent)super.getArguments().getParcelable("intent"));
    Bundle localBundle;
    if (this.intent == null)
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
        this.intent.setExtrasClassLoader(WebViewTitleStyle.class.getClassLoader());
      }
    }
    for (;;)
    {
      super.onAttach(paramActivity);
      return;
      localBundle = this.intent.getExtras();
      break;
      label82:
      QLog.d("WebLog_WebViewFragment", 2, "already has classloader for this fragment: " + localBundle.getClassLoader());
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.webView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView) || (paramView == this.mSwiftTitleUI.jdField_a_of_type_ComTencentWidgetFadeIconImageView) || (paramView == this.mUIStyleHandler.jdField_a_of_type_AndroidViewView))
      {
        doOnBackEvent();
        if (paramView == this.mSwiftTitleUI.jdField_a_of_type_ComTencentWidgetFadeIconImageView) {
          bdll.a(null, "dc00898", "", "", "0X8009B1F", "0X8009B1F", 0, 0, "", "", "", "");
        }
      }
      else
      {
        Object localObject;
        if ((paramView == this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView) || (paramView == this.mSwiftTitleUI.d))
        {
          if (biqq.jdField_b_of_type_Long != -1L) {
            biqq.jdField_b_of_type_Long = -1L;
          }
          localObject = new Intent();
          ((Intent)localObject).setAction("SignInSbumited");
          BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          if (!rightButtonCallBack())
          {
            bjqh.a().a("", "", "", "1000", "100", "0", false);
            showActionSheet();
          }
          if (this.mUIStyleHandler.b != null)
          {
            localObject = this.mUIStyleHandler.b.getParent();
            if ((localObject != null) && ((localObject instanceof ViewGroup))) {
              ((ViewGroup)localObject).removeView(this.mUIStyleHandler.b);
            }
          }
        }
        else if (paramView == this.mSwiftTitleUI.c)
        {
          localObject = getCurrentUrl();
          if ((localObject != null) && (((String)localObject).contains("checkin/index")))
          {
            localObject = new Intent();
            ((Intent)localObject).setAction("SignInSbumited");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          if (!rightButtonCallBack())
          {
            if (!this.mUIStyle.l) {
              break label359;
            }
            doOnBackEvent();
          }
          for (;;)
          {
            if (this.mUIStyleHandler.b == null) {
              break label386;
            }
            localObject = this.mUIStyleHandler.b.getParent();
            if ((localObject == null) || (!(localObject instanceof ViewGroup))) {
              break;
            }
            ((ViewGroup)localObject).removeView(this.mUIStyleHandler.b);
            break;
            label359:
            bjqh.a().a("", "", "", "1000", "100", "0", false);
            showActionSheet();
          }
        }
        else
        {
          label386:
          if (paramView == this.mUIStyleHandler.jdField_a_of_type_Binl.d)
          {
            if (this.mUIStyle.H)
            {
              LpReportInfo_dc02216.reportExit();
              if (getWebView() != null)
              {
                localObject = getWebView().getPluginEngine();
                if ((localObject != null) && (((WebViewPluginEngine)localObject).a(getCurrentUrl(), 8589934615L, null)))
                {
                  this.mUIStyleHandler.jdField_a_of_type_Binl.b.setVisibility(8);
                  this.mUIStyleHandler.jdField_a_of_type_Binl.a(this.mUIStyleHandler.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView, true);
                  this.mUIStyleHandler.jdField_a_of_type_Binl.i.setVisibility(8);
                  continue;
                }
              }
            }
            this.mUIStyleHandler.jdField_a_of_type_Binl.b.setVisibility(8);
            this.mUIStyleHandler.jdField_a_of_type_Binl.a(this.mUIStyleHandler.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView, true);
            this.mUIStyleHandler.jdField_a_of_type_Binl.i.setVisibility(8);
            super.getActivity().finish();
            bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
          }
          else if (paramView == this.mUIStyleHandler.jdField_a_of_type_Binl.f)
          {
            if (biqq.jdField_b_of_type_Long != -1L) {
              biqq.jdField_b_of_type_Long = -1L;
            }
            this.mUIStyleHandler.jdField_a_of_type_Binl.b.setVisibility(8);
            this.mUIStyleHandler.jdField_a_of_type_Binl.a(this.mUIStyleHandler.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView, true);
            this.mUIStyleHandler.jdField_a_of_type_Binl.i.setVisibility(8);
            showActionSheet();
            bjqh.a().a("", "", "", "1000", "100", "0", false);
            bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
            if (this.mUIStyle.H) {
              LpReportInfo_dc02216.reportShare();
            }
          }
          else if (paramView == this.mUIStyleHandler.jdField_a_of_type_Binl.h)
          {
            localObject = new Intent(super.getActivity(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
            ((Intent)localObject).putExtra("url", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
            super.startActivity((Intent)localObject);
            super.getActivity().finish();
            bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
            }
          }
          else if (paramView == this.mUIStyleHandler.jdField_a_of_type_Binl.g)
          {
            this.mUIStyleHandler.jdField_a_of_type_Binl.b.setVisibility(8);
            this.mUIStyleHandler.jdField_a_of_type_Binl.a(this.mUIStyleHandler.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView, true);
            this.mUIStyleHandler.jdField_a_of_type_Binl.i.setVisibility(8);
            if (!TextUtils.isEmpty(getShare().v))
            {
              this.webView.callJs(getShare().v, new String[] { "" });
              if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewFragment", 2, "call js function getShare().mOnShareHandler");
              }
            }
            bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "senddesk", "", "", "");
            if (this.mUIStyle.H) {
              LpReportInfo_dc02216.reportExit();
            }
          }
          else if (paramView == this.mUIStyleHandler.jdField_a_of_type_Binl.e)
          {
            this.mUIStyleHandler.jdField_a_of_type_Binl.b.setVisibility(8);
            this.mUIStyleHandler.jdField_a_of_type_Binl.a(this.mUIStyleHandler.jdField_a_of_type_Binl.jdField_a_of_type_AndroidViewView, true);
            this.mUIStyleHandler.jdField_a_of_type_Binl.i.setVisibility(8);
            if (this.mUIStyle.G)
            {
              if (TextUtils.isEmpty(this.webView.getTitle())) {}
              for (localObject = anzj.a(2131715678);; localObject = this.webView.getTitle())
              {
                gotoConversationForH5SDK(String.format(anzj.a(2131715673), new Object[] { localObject }), 2130838356, null, SingleTaskQQBrowser.class.getName());
                bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "fold", "", "", "");
                break;
              }
            }
            if (this.mUIStyle.F) {
              getHostFragment().goToConversation();
            }
          }
          else if (paramView == this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetTextView)
          {
            localObject = new HashMap();
            ((Map)localObject).put("intent", this.intent);
            dispatchPluginEvent(8589934622L, (Map)localObject);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mUIStyleHandler = ((birg)this.mComponentsProvider.a(2));
    this.mUIStyleHandler.c();
    this.mUIStyle = this.mUIStyleHandler.jdField_a_of_type_Birj;
    this.mSwiftTitleUI = this.mUIStyleHandler.jdField_a_of_type_Binq;
    this.mSetting = ((biqp)this.mComponentsProvider.a(-1));
    this.mStatistics = ((biqx)this.mComponentsProvider.a(-2));
    this.mUIStyleHandler.a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      this.contentView = ((WebBrowserViewContainer)WebAccelerateHelper.preloadBrowserView);
      WebAccelerateHelper.preloadBrowserView = null;
      this.mStatistics.v = true;
    }
    for (;;)
    {
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
      this.contentView.setLayoutParams(paramLayoutInflater);
      listenKeyboardShowHide(this.contentView);
      paramLayoutInflater = this.contentView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.contentView = new WebBrowserViewContainer(super.getActivity());
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "doOnDestroy");
    }
    if (this.jumpCancelable != null) {
      this.jumpCancelable.a();
    }
    if (1 != this.mCreateLoopNextStep)
    {
      this.mCreateLoopScheduler.b();
      this.mCreateLoopNextStep = 1;
    }
    if (this.sonicClient != null)
    {
      this.sonicClient.destroy();
      this.sonicClient = null;
    }
    Object localObject = Long.valueOf(this.intent.getLongExtra("Gif_msg_uniseq_key", 0L));
    if (((Long)localObject).longValue() > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("Gif_msg_uniseq_key", ((Long)localObject).longValue());
      localObject = asev.a("close_annimate", null, -1, localBundle);
      asjw.a().a((Bundle)localObject);
    }
    if (this.mIpcObserver != null) {
      asjw.a().b(this.mIpcObserver);
    }
    if (this.webView != null) {}
    for (localObject = this.webView.getPluginEngine();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.webView.getUrl(), 8589934596L, null);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", this.mUrl);
      this.mComponentsProvider.a(3, (Bundle)localObject);
      destroyWebView();
      if (QQBrowserActivity.jdField_d_of_type_Int == 0)
      {
        asjw.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        biqz.jdField_d_of_type_Int = -1;
      }
      if (this.share != null) {
        this.share.c();
      }
      localObject = bdmv.a(getClass(), hashCode());
      if (localObject != null) {
        bdll.b(null, "CliOper", "", "", ((bdmw)localObject).jdField_a_of_type_JavaLangString, ((bdmw)localObject).jdField_a_of_type_JavaLangString, ((bdmw)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((bdmw)localObject).jdField_b_of_type_Long), "", "", "");
      }
      birp.a().a(2);
      this.mSwiftTitleUI.i();
      agdz.d(super.getActivity().getIntent());
      bmzn.a().a(this.mUrl, 133, System.currentTimeMillis() - this.mStatistics.T, "0", this.mStatistics.e, this.mStatistics.g);
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
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    this.mStatistics.a(paramString, paramInt);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
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
        if (this.webView != null)
        {
          str = paramString;
          if (this.webView.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    boolean bool2 = this.authConfig.a(str, "publicAccount.getLocation");
    paramString = "";
    if (this.webView != null) {
      paramString = noe.a(this.webView.getUrl(), 2);
    }
    boolean bool3 = PublicAccountJavascriptInterface.getLocationPermissionGrant(this.uin, paramString);
    if ((bool3) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.uin, " urlHost:", paramString });
      }
      paramGeolocationPermissionsCallback.invoke(str, bool1, false);
      return;
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      dispatchPluginEvent(512L, null);
      return;
    }
    dispatchPluginEvent(256L, null);
  }
  
  public void onHideCustomView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "hide custom view called");
    }
    if (this.customViewCallback == null) {
      return;
    }
    this.customView.setKeepScreenOn(false);
    this.customContainer.setVisibility(8);
    this.customViewCallback.onCustomViewHidden();
    try
    {
      this.customContainer.removeAllViews();
      label56:
      if (!this.mUIStyle.A) {
        super.getActivity().getWindow().setFlags(this.mOriginFullscreenFlag, 1024);
      }
      super.getActivity().setRequestedOrientation(this.mOriginOrientation);
      this.customView = null;
      this.customViewCallback = null;
      this.videoProgressView = null;
      this.isVideoPlaying = false;
      return;
    }
    catch (Exception localException)
    {
      break label56;
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onLowMemory()
  {
    try
    {
      if ((biqx.x) && (this.mStatistics != null) && (this.mStatistics.jdField_c_of_type_Long > 0L)) {
        bdll.b(null, "dc00899", "WV_Analysis", "", "memory_consumption", biqx.a(this.mUrl), this.mStatistics.e, 0, "", this.mStatistics.g, this.mStatistics.f, "");
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
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return;
    }
    this.mStatistics.c("state_page_finished");
    ensureCreateLoopFinished();
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.mStatistics.jdField_a_of_type_Biqz.jdField_a_of_type_Int == 2))
    {
      this.mStatistics.jdField_a_of_type_Biqz.jdField_a_of_type_Int = 8;
      this.mStatistics.jdField_a_of_type_Biqz.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.isArticalChannelReported = true;
    this.mArticalChannelId = 100;
    Object localObject = (biqx)this.mComponentsProvider.a(-2);
    if ((localObject != null) && (this.sonicClient != null)) {
      ((biqx)localObject).jdField_a_of_type_Int = this.sonicClient.getSession().getFinalResultCode();
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("url", paramString);
    this.mComponentsProvider.a(7, (Bundle)localObject);
    if (this.mStatistics.jdField_k_of_type_Boolean)
    {
      this.mStatistics.jdField_k_of_type_Boolean = false;
      this.redirectCookie = false;
      ensureShare();
      birp.a().a(new birt(1));
      if (this.intent.getBooleanExtra("banner_fromBanner", false))
      {
        localObject = this.intent.getBundleExtra("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).containsKey("AIO_Scroll_Y")))
        {
          int i = ((Bundle)localObject).getInt("AIO_Scroll_Y");
          if ((i > 0) && (this.webView.getView() != null)) {
            ThreadManager.getUIHandler().post(new WebViewFragment.14(this, i));
          }
        }
      }
      this.mStatistics.T = System.currentTimeMillis();
      if (biqx.x) {
        this.mStatistics.a("web_loaded_url", System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, "0");
      }
      bmzn.a().a(paramString, 131, this.mStatistics.T - this.mStatistics.Q, "0", this.mStatistics.e, this.mStatistics.g);
      bmzn.a().a(paramString, 129, this.mStatistics.T - this.mStatistics.jdField_c_of_type_Long, "0", this.mStatistics.e, this.mStatistics.g);
    }
    if (this.sonicClient != null) {
      this.sonicClient.pageFinish(paramString);
    }
    if ((Build.VERSION.SDK_INT >= 19) && (!this.isDestroyed) && (this.webViewWrapper != null) && (this.webViewWrapper.a() != null)) {
      onReceivedTitle(paramWebView, paramWebView.getTitle());
    }
    localObject = getHostActivity();
    if ((localObject instanceof QQBrowserActivity)) {
      ((QQBrowserActivity)localObject).a(paramWebView, paramString);
    }
    if ((paramWebView instanceof CustomWebView)) {
      oej.a((CustomWebView)paramWebView);
    }
    this.mStatistics.c("state_final");
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.isDestroyed) || (this.webView == null)) {}
    do
    {
      return;
      ensureCreateLoopFinished();
      paramWebView = new Bundle();
      paramWebView.putString("url", paramString);
      this.mComponentsProvider.a(6, paramWebView);
    } while (!this.mStatistics.j);
    bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, this.mUIStyle.jdField_c_of_type_Long + "", this.mUrl, nnr.a() + "", this.uin);
    if (biqx.x) {
      this.mStatistics.a("web_start_load_url", System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, "0");
    }
    this.mStatistics.j = false;
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onPause");
    }
    if (this.isVideoPlaying) {
      onHideCustomView();
    }
    String str = BridgeHelper.a(super.getActivity(), this.uin).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(super.getActivity());
    }
    this.mComponentsProvider.a(1, null);
    dispatchPluginEvent(8589934597L, null);
    if ((this.isFromQzone) && (bdgb.c())) {
      bngm.a().a();
    }
    super.onPause();
  }
  
  public void onPostThemeChanged()
  {
    if (this.mApp != null)
    {
      this.mNightMode = ThemeUtil.isInNightMode(this.mApp);
      dispatchPluginEvent(8589934604L, null);
    }
    if ((this.mSystemBarComp != null) && (!this.mUIStyle.i))
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.mSystemBarComp.setBackgroundResource(2130850100);
      }
    }
    else {
      return;
    }
    this.mSystemBarComp.setBackgroundColor(getResources().getColor(2131167048));
    bdgb.a(false, getResources().getColor(2131167048), getHostActivity().getWindow());
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if ((this.mUIStyleHandler.jdField_a_of_type_Bjef != null) && (this.mUIStyleHandler.jdField_a_of_type_Bjef.b() == 0)) {
      this.mUIStyleHandler.jdField_a_of_type_Bjef.a((byte)1);
    }
    if (paramInt == 100) {
      this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return;
    }
    ensureCreateLoopFinished();
    this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    QLog.e("WebLog_WebViewFragment", 1, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + noe.b(paramString2, new String[0]));
    this.mStatistics.a(this.webView, paramInt, paramString1, paramString2);
    if (biqx.x) {
      this.mStatistics.a("web_loaded_url_err", System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, String.valueOf(paramInt));
    }
    bmzn.a().a(this.mUrl, 132, System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, String.valueOf(paramInt), this.mStatistics.e, this.mStatistics.g);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError)
  {
    if (biqx.x) {
      this.mStatistics.a("web_loaded_url_err", System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, String.valueOf(paramSslError.getPrimaryError()));
    }
    bmzn.a().a(this.mUrl, 132, System.currentTimeMillis() - this.mStatistics.jdField_c_of_type_Long, String.valueOf(paramSslError.getPrimaryError()), this.mStatistics.e, this.mStatistics.g);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.webView == null)) {}
    while ((!TextUtils.isEmpty(this.webViewTitle)) || ((this.mUIStyle.jdField_b_of_type_Long & 0x8) > 0L) || (bish.a(paramString)) || (paramString == null)) {
      return;
    }
    this.mSwiftTitleUI.a(paramWebView, paramString, this.isDelaySetTitle);
  }
  
  public void onResume()
  {
    noe.a("Web_qqbrowser_doonresume");
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onResume");
    }
    if (this.webView != null) {
      this.webView.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", this.uin);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    localObject = BridgeHelper.a(super.getActivity(), this.uin).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(super.getActivity());
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", this.mCreateLoopNextStep);
    this.mComponentsProvider.a(2, (Bundle)localObject);
    localObject = getHostActivity();
    int i;
    if ((localObject instanceof QQBrowserActivity))
    {
      WebViewFragment localWebViewFragment = ((QQBrowserActivity)localObject).a();
      if (localWebViewFragment != null) {
        if (localWebViewFragment == this) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        dispatchPluginEvent(2L, null);
      }
      ThreadManager.executeOnSubThread(new WebViewFragment.4(this, (Activity)localObject));
      if ((this.isFromQzone) && (bdgb.c())) {
        bngm.a().b(1);
      }
      if (this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_a_of_type_Boolean)
      {
        hideVirtualNavBar();
        changeFullScreenCutoutMode();
      }
      noe.b("Web_qqbrowser_doonresume");
      super.onResume();
      if (this.mMiniMsgUser != null) {
        this.mMiniMsgUser.onForeground();
      }
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public void onSetCookiesFinished(String paramString, Bundle paramBundle, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, new Object[] { "onSetCookieFinish ", paramString, " " + paramLong });
    }
  }
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (this.mFileChooserHelper == null) {
      this.mFileChooserHelper = new nnj();
    }
    return this.mFileChooserHelper.a(super.getActivity(), 0, paramValueCallback, paramFileChooserParams);
  }
  
  public void onStop()
  {
    if ((this.mUIStyle.jdField_a_of_type_Long & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "close on hide by wv param");
      }
      super.getActivity().finish();
    }
    if (this.mMiniMsgUser != null) {
      this.mMiniMsgUser.onBackground();
    }
    super.onStop();
    biqx.c();
    if ((this.mSwiftTitleUI != null) && (this.mSwiftTitleUI.a() != null) && (this.mSwiftTitleUI.c())) {
      MiniMsgIPCClient.getInstance().clearBusiness(this.mBusiID);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.mLastTouchTime = System.currentTimeMillis();
      if (paramView.getId() == 2131366309)
      {
        paramMotionEvent = paramView.getParent();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof ViewGroup))) {
          ((ViewGroup)paramMotionEvent).removeView(paramView);
        }
      }
    }
    return false;
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_WebViewFragment", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.mRedirect302Url = paramString2;
    SwiftBrowserCookieMonster.d();
    buildCookieForRedirect(paramString1, paramString2);
    this.mStatistics.e(paramString2);
  }
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.isArticalChannelReported) && (tzq.a(paramString, this.mArticalChannelId, this.mArticalChannelExtralInfo))) {
      this.isArticalChannelReported = true;
    }
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (this.mFileChooserHelper == null) {
      this.mFileChooserHelper = new nnj();
    }
    this.mFileChooserHelper.a(super.getActivity(), 0, paramValueCallback, paramString1, paramString2);
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "pluginStartActivityForResult not handled");
      }
      return i;
    }
    super.startActivityForResult(paramIntent, i);
    return i;
  }
  
  void preInitData()
  {
    this.mUrl = getUrlFromIntent();
    this.mUIStyleHandler.a(this.mUrl);
    if (this.mUIStyle.jdField_a_of_type_Long != 4L)
    {
      if ((this.mUIStyle.jdField_a_of_type_Long & 0x2) != 0L) {
        this.intent.putExtra("hide_more_button", true);
      }
      if ((this.mUIStyle.jdField_a_of_type_Long & 1L) != 0L) {
        this.intent.putExtra("webStyle", "noBottomBar");
      }
      if ((this.mUIStyle.jdField_a_of_type_Long & 0x100000) > 0L) {
        this.intent.putExtra("ignoreLoginWeb", true);
      }
    }
  }
  
  protected void reset()
  {
    ensureShare().b();
  }
  
  public void resetTitleBarTextColor()
  {
    this.mSwiftTitleUI.g();
  }
  
  protected boolean rightButtonCallBack()
  {
    if (this.webView != null)
    {
      if ((this.mSwiftTitleUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) && (this.mSwiftTitleUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.jdField_a_of_type_Boolean))
      {
        this.webView.callJs4OpenApi(this.mSwiftTitleUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.mSwiftTitleUI.jdField_a_of_type_JavaLangString))
      {
        this.webView.callJs(this.mSwiftTitleUI.jdField_a_of_type_JavaLangString, new String[] { "" });
        return true;
      }
      if (this.mSwiftTitleUI.jdField_a_of_type_Admy != null)
      {
        adqf.b(this.mSwiftTitleUI.jdField_a_of_type_Admy, adna.jdField_a_of_type_OrgJsonJSONObject);
        return true;
      }
    }
    return false;
  }
  
  public void setActNeedImmersive(boolean paramBoolean)
  {
    this.mActNeedImmersive = paramBoolean;
  }
  
  public void setBottomBarVisible(boolean paramBoolean) {}
  
  public void setImmersiveStatus()
  {
    setImmersiveStatus(false);
  }
  
  public void setImmersiveStatus(boolean paramBoolean)
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getActivity().getWindow().addFlags(67108864);
      if (this.mActNeedImmersive) {
        if (this.mSystemBarComp == null)
        {
          this.mSystemBarComp = new View(super.getActivity());
          if (this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle == null) {
            break label216;
          }
          this.mSystemBarComp.setBackgroundColor(this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.b);
          bdgb.a(true, this.mUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle.b, getHostActivity().getWindow());
        }
      }
    }
    for (;;)
    {
      if (this.mSystemBarComp.getParent() == null)
      {
        if (paramBoolean)
        {
          localObject = new View(super.getActivity());
          ((View)localObject).setId(2131365074);
          ((View)localObject).setBackgroundColor(-16777216);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
          localLayoutParams.addRule(10, -1);
          this.mUIStyleHandler.d.addView((View)localObject, localLayoutParams);
        }
        Object localObject = new RelativeLayout.LayoutParams(-1, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()));
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        this.mUIStyleHandler.d.addView(this.mSystemBarComp, (ViewGroup.LayoutParams)localObject);
      }
      return;
      label216:
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.mSystemBarComp.setBackgroundResource(2130850100);
      }
      else
      {
        this.mSystemBarComp.setBackgroundColor(getResources().getColor(2131167048));
        bdgb.a(false, getResources().getColor(2131167048), getHostActivity().getWindow());
      }
    }
  }
  
  public void setLoadShareJsTime(long paramLong)
  {
    this.mStatistics.jdField_a_of_type_Long = paramLong;
  }
  
  public void setMiniAIOEntry(boolean paramBoolean)
  {
    int i;
    View localView;
    if (this.mSwiftTitleUI.a() != null)
    {
      if (!paramBoolean) {
        break label87;
      }
      i = 0;
      this.mSwiftTitleUI.a().setVisibility(i);
      localView = this.mSwiftTitleUI.a().findViewById(2131371182);
      if (this.mStyle != null)
      {
        if (!this.mStyle.equals("white")) {
          break label93;
        }
        localView.setBackgroundResource(2130841027);
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.onForeground();
      }
      return;
      label87:
      i = 8;
      break;
      label93:
      if (this.mStyle.equals("black")) {
        localView.setBackgroundResource(2130841026);
      }
    }
  }
  
  public void setNeedStatusTrans(boolean paramBoolean)
  {
    this.mNeedStatusTrans = paramBoolean;
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, admy paramadmy)
  {
    this.mSwiftTitleUI.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramadmy);
    ((biqq)this.mComponentsProvider.a(4)).d();
    this.mUIStyleHandler.l();
  }
  
  public void setRightButton(boolean paramBoolean)
  {
    this.mSwiftTitleUI.b(paramBoolean);
    ((biqq)this.mComponentsProvider.a(4)).d();
    this.mUIStyleHandler.l();
  }
  
  public void setRulesFromUrl(long paramLong)
  {
    this.mUIStyle.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean setShareUrl(String paramString)
  {
    return ensureShare().a(paramString);
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return ensureShare().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public void setTitle(String paramString)
  {
    this.mSwiftTitleUI.c(paramString);
  }
  
  public void setTitleBarButtonColor(int paramInt)
  {
    this.mSwiftTitleUI.f(paramInt);
  }
  
  public void setTitleBarTextColor(int paramInt)
  {
    this.mSwiftTitleUI.d(paramInt);
  }
  
  public void setUsingCustomTitleBarColor(boolean paramBoolean)
  {
    this.mUIStyle.i = paramBoolean;
  }
  
  public void setWarnToastVisible(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.jdField_a_of_type_Binq != null)) {
      this.mUIStyleHandler.jdField_a_of_type_Binq.a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public boolean shareStructMsgForH5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return ensureShare().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return true;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      this.mStatistics.h = false;
    }
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      reset();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.mUrl = paramString;
        localObject = (biqq)this.mComponentsProvider.a(4);
        if (localObject != null) {
          ((biqq)localObject).a(this.mUrl);
        }
        localObject = (biql)this.mComponentsProvider.a(64);
        if (localObject != null) {
          ((biql)localObject).a(this.mUrl);
        }
      }
    }
    if (super.getActivity().isFinishing()) {
      this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    Object localObject = birz.b(paramString);
    if (("http".equals(localObject)) || ("https".equals(localObject)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebLog_WebViewFragment", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        paramWebView = this.mRedirect302Url;
        this.mRedirect302Url = paramString;
        SwiftBrowserCookieMonster.d();
        buildCookieForRedirect(paramWebView, this.mRedirect302Url);
        this.mStatistics.e(paramString);
      }
    }
    return false;
  }
  
  public void showActionSheet()
  {
    biqq localbiqq = (biqq)this.mComponentsProvider.a(4);
    if (localbiqq != null) {
      localbiqq.a(ensureShare(), this.mUIStyle.jdField_a_of_type_Long);
    }
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "show custom view called");
    }
    if (this.customViewCallback != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.mOriginOrientation = super.getActivity().getRequestedOrientation();
    this.mOriginFullscreenFlag = (super.getActivity().getWindow().getAttributes().flags & 0x400);
    if (this.customContainer == null)
    {
      this.customContainer = new FrameLayout(BaseApplicationImpl.getApplication());
      this.customContainer.setBackgroundColor(-16777216);
      ((ViewGroup)super.getActivity().getWindow().getDecorView()).addView(this.customContainer, new ViewGroup.LayoutParams(-1, -1));
    }
    if (!this.mUIStyle.A) {
      super.getActivity().getWindow().setFlags(1024, 1024);
    }
    super.getActivity().setRequestedOrientation(paramInt);
    this.isVideoPlaying = true;
    this.customContainer.addView(paramView);
    this.customView = paramView;
    this.customViewCallback = paramCustomViewCallback;
    this.customContainer.setVisibility(0);
  }
  
  @TargetApi(14)
  public boolean showPreview()
  {
    boolean bool1 = false;
    noe.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.mUIStyleHandler.a(this.intent);
    this.mUIStyleHandler.b(this.intent);
    this.contentView.a(this.mUIStyleHandler.jdField_a_of_type_Birj.D);
    doWebsoShowScreenshot();
    if (this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_a_of_type_Boolean)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      hideVirtualNavBar();
      changeFullScreenCutoutMode();
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
      }
      this.mUIStyleHandler.jdField_c_of_type_Boolean = true;
      this.mUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar = this.contentView.jdField_a_of_type_AndroidWidgetProgressBar;
      this.contentView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.mUIStyleHandler.a(this.mUrl);
      this.mUIStyleHandler.e();
      noe.b("Web_qqbrowser_ShowPreview");
      return true;
    }
    this.mUIStyleHandler.d = this.contentView;
    this.mSwiftTitleUI.a(this.intent, this);
    this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.titleTouchListener);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    float f = mvd.a(BaseApplicationImpl.getApplication(), 50.0F);
    int i;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      f += i;
    }
    for (;;)
    {
      for (;;)
      {
        localLayoutParams.height = ((int)f);
        this.mUIStyle.C = true;
        int j = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296599);
        boolean bool2;
        if ((this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_b_of_type_Boolean) || (this.mUIStyle.m))
        {
          this.mUIStyle.n = true;
          this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(super.getResources().getDrawable(2130850680));
          this.mSwiftTitleUI.d(-1);
          this.mSwiftTitleUI.f(-1);
          if (this.mUIStyle.o)
          {
            adjustWebViewTopMargin(j + i, i);
            bool1 = true;
          }
          bool2 = bool1;
          if (this.mUIStyle.m)
          {
            this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
            bool2 = bool1;
          }
        }
        try
        {
          for (;;)
          {
            for (;;)
            {
              if (ImmersiveUtils.isSupporImmersive() == 1)
              {
                this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
                super.getActivity().getWindow().addFlags(67108864);
              }
              setImmersiveStatus(bool2);
              if ((!this.mUIStyleHandler.jdField_a_of_type_Birj.jdField_b_of_type_Boolean) && (!this.mUIStyle.m)) {
                initTitleColor();
              }
              if (!"2105".equals(ThemeUtil.curThemeId)) {
                break;
              }
              try
              {
                this.mSwiftTitleUI.f(Color.parseColor("#03081A"));
              }
              catch (Exception localException)
              {
                QLog.d("WebLog_WebViewFragment", 2, "there may be some views not be initialized, should not do this UI adjust");
              }
            }
            break;
            this.mNeedStatusTrans = true;
            this.mActNeedImmersive = true;
            adjustWebViewTopMargin(j + i * 2, i + BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299018));
            bool2 = true;
          }
        }
        catch (ClassCastException localClassCastException)
        {
          for (;;)
          {
            dumpViewInError(localClassCastException);
          }
        }
      }
      i = 0;
    }
  }
  
  public void showVirtualNavBar()
  {
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public void startLoadUrl()
  {
    noe.a("Web_readyToLoadUrl");
    if (this.webView == null) {
      return;
    }
    initFinish();
    if ((this.mStatistics.i) && (this.mStatistics.jdField_k_of_type_Long > 0L))
    {
      bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.jdField_k_of_type_Long) / 1000000L), "", "", "", "" + this.mStatistics.jdField_c_of_type_Int);
      this.mStatistics.jdField_k_of_type_Long = 0L;
    }
    this.mStatistics.q = System.currentTimeMillis();
    long l = this.mStatistics.q;
    l = this.mStatistics.jdField_b_of_type_Long;
    if (bhnh.a().a(this.mUrl))
    {
      this.webView.loadUrl("file:///android_asset/error.html");
      QLog.d("WebLog_WebViewFragment", 1, new Object[] { "url:", this.mUrl, "in black" });
    }
    for (;;)
    {
      noe.b("Web_readyToLoadUrl");
      this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
      return;
      if (!TextUtils.isEmpty(this.mUrl)) {
        this.webView.loadUrl(this.mUrl);
      }
    }
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewFragment", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean)
  {
    return switchRequestCode(paramWebViewPlugin, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment
 * JD-Core Version:    0.7.0.1
 */