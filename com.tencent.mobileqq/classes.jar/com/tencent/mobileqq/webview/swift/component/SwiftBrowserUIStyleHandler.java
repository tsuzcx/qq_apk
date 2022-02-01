package com.tencent.mobileqq.webview.swift.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bdla;
import bhdz;
import biei;
import biej;
import bieo;
import bigl;
import bign;
import bigo;
import bihv;
import biur;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.SwiftWebTitleBuilder;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import nro;
import nwo;
import org.json.JSONObject;

public class SwiftBrowserUIStyleHandler
  extends bign
  implements View.OnClickListener, Animation.AnimationListener
{
  public static final String BUNDLE_CONFIGURATION = "Configuration";
  public static final String BUNDLE_IS_INIT_VIEW = "is_initView";
  public static final String CMD_WV_FULLSCREEN = "ui.wvFullScreen";
  public static final String CMD_WV_HIDE_ACTIONBTN = "ui.wvHideActionBtn";
  public static final String CMD_WV_TRANS_TITLE = "ui.wvTransparentTitle";
  public static final String CONFIG_EXT_CTRL_WV_SWITCH = "wv_ctrl_switch";
  public static final String EXTRA_HIDE_LEFT_BUTTON = "hide_left_button";
  public static final String EXTRA_HIDE_MORE_BUTTON = "hide_more_button";
  public static final String EXTRA_IS_FROM_FUDAI_ENTRY = "isFromFudaiEntry";
  public static final String EXTRA_LEFT_CLOSE_BUTTON_TEXT = "left_close_button_text";
  public static final String EXTRA_ONE_CLICK_CLOSE_MODE = "fromOneCLickCLose";
  public static final String EXTRA_RIGHT_TOP_CANCEL_MODE = "rightTopCancel";
  public static final String EXTRA_SHOW_RIGHT_CLOSE_BUTTON = "show_right_close_button";
  public static final String EXTRA_WEB_VIEW_MOVE_TOP = "webViewMoveTop";
  public static final String TAG = "SwiftBrowserUIStyleHandler";
  public static final String WEBVIEW_UPDATE_TITLE_BAR_UI = "Web_updateTitleBarUI";
  public ImageView back;
  public ViewGroup bottomBar;
  public boolean canWebViewOverScroll = true;
  private View.OnClickListener clickListener;
  public boolean disableProgress;
  public ImageView forward;
  private boolean isBottomBarShow;
  public boolean isWebViewOverScroll;
  long lastBottomBarHandleTime = 0L;
  public View mBrowserTips;
  public int mBrowserTipsColor = -1;
  public int mBrowserWebviewColor = -1;
  public View mFavGuideView;
  public View mFloatQuickBtn;
  public Activity mHostActivity;
  public WebViewFragment mHostFragment;
  public boolean mIsShownPreview;
  public ViewGroup mLlShareMusic;
  public WebViewProgressBar mLoadingProgressBar;
  public biur mProgressBarController;
  public ViewGroup mRootView;
  Animation mSlideIn;
  Animation mSlideOut;
  private bihv mStatistics;
  public biej mSwiftFloatUI;
  public bieo mSwiftTitleUI;
  public TextView mTvShareMusic;
  public final SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle mUIStyle = new SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle();
  public View qqbrowser;
  public TextView tbsTipView;
  public TextView urlText;
  public ProgressBar waitting;
  public String webViewTitle = "";
  public FrameLayout webviewContainer;
  public ViewGroup webviewWrapper;
  
  private void checkWvParamAuthorize(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!"1".equals(nro.a().a("wv_ctrl_switch", "")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize disable");
        }
      }
      else
      {
        if ((!nro.a().a(paramString2, paramString1)) && ((this.mUIStyle.mRulesFromUrl & paramLong) != 0L))
        {
          paramString1 = this.mUIStyle;
          paramString1.mRulesFromUrl &= (0xFFFFFFFF ^ paramLong);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "no authorize for wv param domain:", paramString2, " wv:", Long.valueOf(paramLong) });
          }
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "checkWvParamAuthorize cost:", Long.valueOf(l2 - l1), " domain:", paramString2, " wv:", Long.valueOf(paramLong) });
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramString1, new Object[0]);
    }
  }
  
  private int getColorIntFromUrlParams(String paramString)
  {
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("0x")) {
        break label86;
      }
      paramString = paramString.substring(2);
    }
    label86:
    for (;;)
    {
      String str = paramString;
      try
      {
        if (!paramString.startsWith("#")) {
          str = "#" + paramString;
        }
        i = Color.parseColor(str);
      }
      catch (NumberFormatException paramString)
      {
        do
        {
          i = j;
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserUIStyleHandler", 4, "Illegal getColorIntFromUrlParams");
        return -1;
      }
      return i;
    }
  }
  
  private WebViewTitleStyle getTitleStyleFromNAVParams(String paramString)
  {
    int j = 0;
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Uri.parse(paramString);
    String str1;
    String str2;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      paramString = ((Uri)localObject).getQueryParameter("_nav_bgclr");
      str1 = ((Uri)localObject).getQueryParameter("_nav_statusclr");
      str2 = ((Uri)localObject).getQueryParameter("_nav_titleclr");
      localObject = ((Uri)localObject).getQueryParameter("_nav_txtclr");
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label253;
        }
        k = getColorIntFromUrlParams(paramString);
        i = 1;
      }
      catch (Exception paramString)
      {
        i = -1;
        m = -1;
        k = -1;
      }
      try
      {
        if (!TextUtils.isEmpty(str1))
        {
          m = getColorIntFromUrlParams(str1);
          j = 1;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label196:
          m = -1;
          n = -1;
          j = i;
          i = n;
        }
      }
      try
      {
        if (TextUtils.isEmpty(str2)) {
          break label248;
        }
        i = getColorIntFromUrlParams(str2);
        j = 1;
      }
      catch (Exception paramString)
      {
        i = -1;
        break label196;
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label242;
        }
        n = getColorIntFromUrlParams((String)localObject);
        j = i1;
        if (j == 0) {
          break label237;
        }
        paramString = new WebViewTitleStyle();
        paramString.statusBarColor = m;
        paramString.titleBgColor = k;
        paramString.titleColor = i;
        paramString.leftAndRightBtnColor = n;
        return paramString;
      }
      catch (Exception paramString)
      {
        break label196;
      }
      int m = 0;
      j = i;
      continue;
      QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", paramString);
      int n = -1;
      continue;
      label237:
      paramString = null;
      continue;
      label242:
      n = -1;
      continue;
      label248:
      int i = -1;
      continue;
      label253:
      i = 0;
      int k = -1;
    }
  }
  
  private WebViewTitleStyle getTitleStyleFromWVParams(String paramString)
  {
    int i1 = 1;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = Uri.parse(paramString);
    String str1;
    String str2;
    int k;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      paramString = ((Uri)localObject).getQueryParameter("_wvNb");
      str1 = ((Uri)localObject).getQueryParameter("_wvNs");
      str2 = ((Uri)localObject).getQueryParameter("_wvNt");
      localObject = ((Uri)localObject).getQueryParameter("_wvNi");
      k = 0;
    }
    int j;
    for (int i = 0;; i = j)
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          i = getColorIntFromUrlParams(paramString);
          k = 1;
        }
        catch (Exception paramString)
        {
          j = -1;
          m = -1;
          i = -1;
        }
        try
        {
          if (!TextUtils.isEmpty(str1))
          {
            m = getColorIntFromUrlParams(str1);
            k = 1;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            j = -1;
            m = -1;
          }
        }
        try
        {
          if (TextUtils.isEmpty(str2)) {
            break label245;
          }
          j = getColorIntFromUrlParams(str2);
          k = 1;
        }
        catch (Exception paramString)
        {
          j = -1;
          break label199;
        }
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label239;
          }
          n = getColorIntFromUrlParams((String)localObject);
          k = i1;
          if (k == 0) {
            break label234;
          }
          paramString = new WebViewTitleStyle();
          paramString.statusBarColor = m;
          paramString.titleBgColor = i;
          paramString.titleColor = j;
          paramString.leftAndRightBtnColor = n;
          return paramString;
        }
        catch (Exception paramString)
        {
          break label199;
        }
        int m = i;
        continue;
        label199:
        QLog.e("SwiftBrowserUIStyleHandler", 1, "getTitleStyleFromWVParams Illegal param, e = ", paramString);
        int n = -1;
        continue;
        label234:
        paramString = null;
        continue;
        label239:
        n = -1;
        continue;
        label245:
        j = -1;
      }
      j = -1;
      k = i;
    }
  }
  
  private void reportUIStyleRules(Uri paramUri)
  {
    String str = "unknown";
    if (paramUri != null) {}
    try
    {
      str = paramUri.getHost();
      if ((this.mUIStyle.mRulesFromUrl & 0x20000) != 0L) {
        bdla.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
      }
      if ((this.mUIStyle.mRulesFromUrl & 0x1000000) != 0L) {
        bdla.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
      }
      if ((this.mUIStyle.mRulesFromUrl & 0x2) != 0L) {
        bdla.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 2, 0, "", "", str, "");
      }
      return;
    }
    catch (Throwable paramUri)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramUri, new Object[0]);
    }
  }
  
  public void adjustWebViewInBottomBar()
  {
    FrameLayout.LayoutParams localLayoutParams;
    if ((this.mComponentContext.a() != null) && (this.bottomBar != null))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.webviewWrapper.getLayoutParams();
      if (localLayoutParams != null) {}
    }
    else
    {
      return;
    }
    DisplayMetrics localDisplayMetrics;
    float f;
    if (this.isBottomBarShow)
    {
      localDisplayMetrics = this.mHostActivity.getResources().getDisplayMetrics();
      f = this.mUIStyle.bottomMargin;
    }
    for (localLayoutParams.bottomMargin = ((int)(localDisplayMetrics.density * f));; localLayoutParams.bottomMargin = 0)
    {
      this.webviewWrapper.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void createUI()
  {
    this.mSwiftTitleUI = SwiftWebTitleBuilder.createTitleBar(this);
    this.mSwiftFloatUI = biei.a(this);
  }
  
  public void didBindContext()
  {
    super.didBindContext();
    this.mHostActivity = this.mComponentContext.a();
    this.mHostFragment = this.mComponentContext.a();
    this.mStatistics = ((bihv)this.mComponentContext.a().a(-2));
  }
  
  public void disabledHistoryButton(WebView paramWebView)
  {
    if (this.mUIStyle.isOnClickClose)
    {
      if (this.back != null) {
        this.back.setEnabled(false);
      }
      if (this.forward != null) {
        this.forward.setEnabled(false);
      }
    }
  }
  
  public void doTransparent(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.mSwiftTitleUI.doTransparent(paramJSONObject, paramBoolean);
  }
  
  public void enableTitlebarBgGrandualChange(TouchWebView paramTouchWebView)
  {
    this.mSwiftTitleUI.enableTitlebarBgGrandualChange(paramTouchWebView);
  }
  
  public int getBarHeight()
  {
    try
    {
      int i = ((Integer)Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null)).intValue();
      i = this.mHostActivity.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 38;
  }
  
  public TouchWebView getWebView()
  {
    return (TouchWebView)this.mComponentContext.a();
  }
  
  public void initAioShareMusicBottomView()
  {
    ViewStub localViewStub = (ViewStub)this.webviewContainer.findViewById(2131363690);
    if (localViewStub == null) {
      return;
    }
    this.mLlShareMusic = ((ViewGroup)localViewStub.inflate());
    this.mTvShareMusic = ((TextView)this.webviewContainer.findViewById(2131379718));
    this.mTvShareMusic.setOnClickListener(this.clickListener);
    this.mLlShareMusic.setVisibility(8);
  }
  
  public void initBottomBar(Intent paramIntent, String paramString)
  {
    if (this.mUIStyle.isFullScreen) {}
    do
    {
      do
      {
        return;
      } while ((this.bottomBar != null) || (!this.mUIStyle.isOnClickClose));
      paramIntent = (ViewStub)this.webviewContainer.findViewById(2131363735);
    } while (paramIntent == null);
    this.bottomBar = ((ViewGroup)paramIntent.inflate());
    this.back = ((ImageView)this.webviewContainer.findViewById(2131363323));
    this.back.setOnClickListener(this);
    this.back.setEnabled(false);
    this.forward = ((ImageView)this.webviewContainer.findViewById(2131367213));
    this.forward.setOnClickListener(this);
    this.forward.setEnabled(false);
    this.bottomBar.setVisibility(8);
    int i = (int)(this.mHostActivity.getResources().getDisplayMetrics().density * 50.0F);
    this.mSlideIn = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
    this.mSlideIn.setDuration(300L);
    this.mSlideIn.setAnimationListener(this);
    this.mSlideOut = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    this.mSlideOut.setDuration(300L);
    this.mSlideOut.setAnimationListener(this);
  }
  
  @TargetApi(14)
  public void initContentView(WebBrowserViewContainer paramWebBrowserViewContainer, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.webviewContainer = ((FrameLayout)paramWebBrowserViewContainer.findViewById(2131367473));
    this.webviewContainer.setVisibility(0);
    if ((this.mUIStyle.isFullScreen) && (this.mUIStyle.mFloatBarRulesFromUrl != 0L))
    {
      paramWebBrowserViewContainer.b(this.mUIStyle.isFromQzoneGame);
      this.mSwiftFloatUI.a(paramWebBrowserViewContainer, this.clickListener);
      this.mSwiftFloatUI.a(this.mHostActivity);
    }
    long l1 = System.currentTimeMillis();
    this.mStatistics.s = (l1 - l2);
    this.mLoadingProgressBar = ((WebViewProgressBar)this.webviewContainer.findViewById(2131373229));
    this.mProgressBarController = new biur();
    this.mLoadingProgressBar.setController(this.mProgressBarController);
    paramIntent = this.mProgressBarController;
    if (!this.disableProgress) {}
    for (boolean bool = true;; bool = false)
    {
      paramIntent.a(bool);
      if ((this.mStatistics.j) && (this.mProgressBarController != null) && (this.mProgressBarController.b() != 0)) {
        this.mProgressBarController.a((byte)0);
      }
      nwo.a("Web_qqbrowser_initView_WebViewWrapper");
      this.webviewWrapper = ((ViewGroup)this.webviewContainer.findViewById(2131381412));
      nwo.b("Web_qqbrowser_initView_WebViewWrapper");
      l2 = System.currentTimeMillis();
      this.mStatistics.m = (l2 - l1);
      if (!this.mUIStyle.mIsDisableRefreshView)
      {
        this.mBrowserTips = this.webviewContainer.findViewById(2131363783);
        this.urlText = ((TextView)this.webviewContainer.findViewById(2131363784));
        this.tbsTipView = ((TextView)this.webviewContainer.findViewById(2131378525));
        this.urlText.setVisibility(4);
        this.tbsTipView.setVisibility(4);
        if ((this.mUIStyle.isTransparentTitle) && ((this.mHostActivity instanceof BaseActivity))) {
          ((ViewGroup.MarginLayoutParams)this.urlText.getLayoutParams()).topMargin = ((BaseActivity)this.mHostActivity).getTitleBarHeight();
        }
      }
      if (!this.mIsShownPreview) {
        this.waitting = ((ProgressBar)this.webviewContainer.findViewById(2131376461));
      }
      if ((this.mUIStyle.isNeedSetBrowserTipsPadding) && (this.mBrowserTips != null)) {
        this.mBrowserTips.setPadding(0, (int)bhdz.a(BaseApplicationImpl.getContext(), 30.0F), 0, 0);
      }
      updateScreenOrientation();
      this.mHostActivity.getWindow().setBackgroundDrawable(null);
      if (this.mRootView != null) {
        this.mRootView.setBackgroundDrawable(null);
      }
      initWebViewInContentView();
      if (this.mBrowserWebviewColor != -1) {
        paramWebBrowserViewContainer.setBackgroundColor(this.mBrowserWebviewColor);
      }
      if (this.mSwiftTitleUI != null) {
        this.mSwiftTitleUI.initDefaultThemeTitleBar();
      }
      return;
    }
  }
  
  public void initFloatTitleBar()
  {
    ViewStub localViewStub;
    if (this.mUIStyle.isShowFloatCancelBtn)
    {
      localViewStub = (ViewStub)this.webviewContainer.findViewById(2131366952);
      if (localViewStub != null) {}
    }
    else
    {
      return;
    }
    this.mFloatQuickBtn = localViewStub.inflate();
    this.mFloatQuickBtn.getLayoutParams();
    this.mFloatQuickBtn.setOnClickListener(this.clickListener);
  }
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    this.mSwiftTitleUI.initTitleBar(paramIntent, paramString);
    doTransparent(this.mUIStyle.transparentTitlebarConfig, false);
    initWebViewInTitleBar();
  }
  
  public void initTitleStyle(Intent paramIntent)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.getStringExtra("url")))) {}
    do
    {
      Uri localUri;
      do
      {
        return;
        localObject = paramIntent.getStringExtra("url");
        localUri = Uri.parse((String)localObject);
      } while ((localUri == null) || (!localUri.isHierarchical()));
      if ("1".equals(localUri.getQueryParameter("_qStyle")))
      {
        paramIntent = new WebViewTitleStyle();
        paramIntent.statusBarColor = -16777216;
        paramIntent.titleBgColor = -1;
        paramIntent.titleColor = -16777216;
        paramIntent.leftAndRightBtnColor = -16777216;
        this.mUIStyle.mTitleStyle = paramIntent;
        return;
      }
      WebViewTitleStyle localWebViewTitleStyle = getTitleStyleFromWVParams((String)localObject);
      if (localWebViewTitleStyle != null)
      {
        this.mUIStyle.mTitleStyle = localWebViewTitleStyle;
        return;
      }
      Object localObject = getTitleStyleFromNAVParams((String)localObject);
      if (localObject != null)
      {
        this.mUIStyle.mTitleStyle = ((WebViewTitleStyle)localObject);
        return;
      }
      paramIntent = (WebViewTitleStyle)paramIntent.getParcelableExtra("titleStyle");
      if (paramIntent != null)
      {
        this.mUIStyle.mTitleStyle = paramIntent;
        return;
      }
      paramIntent = localUri.getHost();
      paramIntent = (WebViewTitleStyle)WebViewTitleStyleHelper.getsInstance().styleMap.get(paramIntent);
    } while (paramIntent == null);
    this.mUIStyle.mTitleStyle = paramIntent;
  }
  
  public void initUIStyle(Intent paramIntent)
  {
    int i;
    boolean bool;
    if (((this.mUIStyle.mRulesFromUrl & 0x20000) != 0L) || (paramIntent.getBooleanExtra("isFullScreen", false)))
    {
      i = 1;
      if (i != 0) {
        this.mUIStyle.isFullScreen = true;
      }
      SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.mUIStyle;
      if (((this.mUIStyle.mRulesFromUrl & 0x1000000) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitle", false))) {
        break label692;
      }
      bool = true;
      label76:
      localSwiftBrowserUIStyle.isTransparentTitle = bool;
      localSwiftBrowserUIStyle = this.mUIStyle;
      if (((this.mUIStyle.mWWVRulesFromUrl & 1L) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
        break label697;
      }
      bool = true;
      label115:
      localSwiftBrowserUIStyle.isTransparentTitleAndClickable = bool;
      localSwiftBrowserUIStyle = this.mUIStyle;
      if (((this.mUIStyle.mRulesFromUrl & 0x2) == 0L) && (!paramIntent.getBooleanExtra("hide_more_button", false))) {
        break label702;
      }
      bool = true;
      label155:
      localSwiftBrowserUIStyle.hideMore = bool;
      localSwiftBrowserUIStyle = this.mUIStyle;
      if (((this.mUIStyle.mRulesFromUrl & 1L) == 0L) && (!paramIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
        break label707;
      }
      bool = true;
      label210:
      localSwiftBrowserUIStyle.needHideBottomBar = bool;
      localSwiftBrowserUIStyle = this.mUIStyle;
      if ((this.mUIStyle.mWWVRulesFromUrl & 0x100) == 0L) {
        break label712;
      }
      bool = true;
      label240:
      localSwiftBrowserUIStyle.isDisableImmersive = bool;
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_params_qq")))
      {
        this.mUIStyle.hideMore = true;
        this.mUIStyle.needHideBottomBar = true;
      }
      i = paramIntent.getIntExtra("reqType", -1);
      if ((!this.mUIStyle.needHideBottomBar) && (i == 6)) {
        this.mUIStyle.needHideBottomBar = true;
      }
      this.mUIStyle.isOnClickClose = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
      this.mUIStyle.isShowFloatCancelBtn = paramIntent.getBooleanExtra("rightTopCancel", false);
      this.mUIStyle.isWebviewNeedMoveTop = paramIntent.getBooleanExtra("webViewMoveTop", false);
      if ((!this.mUIStyle.hideMore) && ((i == 3) || (i == 1) || (!paramIntent.getBooleanExtra("ba_is_login", true)) || (i == 7))) {
        this.mUIStyle.hideMore = true;
      }
      if ((this.mUIStyle.mRulesFromUrl & 0x20000) > 0L) {
        this.mUIStyle.isFullScreen = true;
      }
      if ((this.mUIStyle.mRulesFromUrl & 0x20000000) != 0L) {
        this.mUIStyle.isGrandualChangeTitlebarBg = true;
      }
      if ((this.mUIStyle.mRulesFromUrl & 0x800) > 0L)
      {
        this.mUIStyle.isScreenLandscape = true;
        this.mUIStyle.mIsPortraitOnly = Boolean.valueOf(false);
      }
      if ((this.mUIStyle.mWWVRulesFromUrl & 0x4) > 0L)
      {
        this.mUIStyle.isScreenLandscape = false;
        this.mUIStyle.mIsPortraitOnly = Boolean.valueOf(true);
      }
      if ((this.mUIStyle.mWWVRulesFromUrl & 0x2) > 0L) {
        this.mUIStyle.isFollowSystemOrientation = true;
      }
      if ((this.mUIStyle.mWWVRulesFromUrl & 0x200) > 0L) {
        this.mUIStyle.mIsDisableRefreshView = true;
      }
      if ((this.mUIStyle.mWWVRulesFromUrl & 0x400) > 0L)
      {
        localSwiftBrowserUIStyle = this.mUIStyle;
        this.mUIStyle.isShowDefaultThemeIcon = true;
        localSwiftBrowserUIStyle.mIsDefaultTheme = true;
      }
      if ((this.mUIStyle.mWWVRulesFromUrl & 0x2000) > 0L) {
        this.mUIStyle.isHideTitleBar = true;
      }
      if ((this.mUIStyle.mCRulesFromUrl & 1L) > 0L) {
        this.mUIStyle.isTransparentTitle = true;
      }
      if ((this.mUIStyle.mCRulesFromUrl & 0x8) > 0L) {
        this.mUIStyle.isTransparentTitleAndClickable = true;
      }
      if (!paramIntent.getBooleanExtra("from_single_task", false)) {
        break label717;
      }
      this.mUIStyle.isNeedSwitchAIOForH5Game = true;
    }
    label692:
    label697:
    label702:
    label707:
    label712:
    label717:
    while ((this.mUIStyle.mRulesFromUrl & 0x80000000) <= 0L)
    {
      return;
      i = 0;
      break;
      bool = false;
      break label76;
      bool = false;
      break label115;
      bool = false;
      break label155;
      bool = false;
      break label210;
      bool = false;
      break label240;
    }
    this.mUIStyle.isNeedSwitchAIO = nro.a().j(paramIntent.getStringExtra("url"));
  }
  
  public void initWebViewInContentView()
  {
    if (this.mComponentContext.a() != null)
    {
      WebView localWebView = this.mComponentContext.a();
      localWebView.setId(2131381402);
      if (this.mBrowserWebviewColor != -1) {
        localWebView.setBackgroundColor(this.mBrowserWebviewColor);
      }
      this.webviewWrapper.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void initWebViewInTitleBar()
  {
    if ((this.mComponentContext.a() != null) && (!this.mUIStyle.isFullScreen)) {
      enableTitlebarBgGrandualChange((TouchWebView)this.mComponentContext.a());
    }
  }
  
  public boolean needTitlebarTransparent(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (this.mUIStyle.transparentTitlebarConfig == null) {
        this.mUIStyle.transparentTitlebarConfig = this.mSwiftTitleUI.getTitleBarConfig(paramString);
      }
    } while ((this.mUIStyle.transparentTitlebarConfig == null) || (this.mUIStyle.transparentTitlebarConfig.length() == 0));
    if (this.mUIStyle.transparentTitlebarConfig.optInt("trans", -1) == 0) {
      this.mUIStyle.mCanTransparentTitlebar = true;
    }
    if (!this.mUIStyle.mCanTransparentTitlebar) {
      this.mUIStyle.mCanTransparentTitlebar = this.mSwiftTitleUI.adjustContentViewToTop();
    }
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.mSlideIn)
    {
      if (this.bottomBar != null) {
        this.bottomBar.setVisibility(0);
      }
      adjustWebViewInBottomBar();
    }
    while ((paramAnimation != this.mSlideOut) || (this.bottomBar == null)) {
      return;
    }
    this.bottomBar.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if ((this.mHostActivity instanceof View.OnClickListener)) {
      ((View.OnClickListener)this.mHostActivity).onClick(paramView);
    }
    TouchWebView localTouchWebView = (TouchWebView)this.mComponentContext.a();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localTouchWebView != null) && (localTouchWebView.canGoBack()))
      {
        localTouchWebView.stopLoading();
        localTouchWebView.goBack();
        WebViewPluginEngine localWebViewPluginEngine = localTouchWebView.getPluginEngine();
        HashMap localHashMap;
        if (localWebViewPluginEngine != null)
        {
          localHashMap = new HashMap(1);
          localHashMap.put("target", Integer.valueOf(3));
          localWebViewPluginEngine.a(localTouchWebView.getUrl(), 8589934610L, localHashMap);
        }
        updateHistoryButton(localTouchWebView);
        bdla.a(null, "dc00898", "", "", "0X8009B21", "0X8009B21", 0, 0, "", "", "", "");
        continue;
        if ((localTouchWebView != null) && (localTouchWebView.canGoForward()))
        {
          localTouchWebView.stopLoading();
          localTouchWebView.goForward();
          localWebViewPluginEngine = localTouchWebView.getPluginEngine();
          if (localWebViewPluginEngine != null)
          {
            localHashMap = new HashMap(1);
            localHashMap.put("target", Integer.valueOf(3));
            localWebViewPluginEngine.a(localTouchWebView.getUrl(), 8589934602L, localHashMap);
          }
          updateHistoryButton(localTouchWebView);
          bdla.a(null, "dc00898", "", "", "0X8009B20", "0X8009B20", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void onLifeCycleStateChanged(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    super.onLifeCycleStateChanged(paramInt, paramBundle);
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 2: 
      nwo.a("Web_updateTitleBarUI");
      if (this.mUIStyle.isGrandualChangeTitlebarBg) {
        this.mSwiftTitleUI.updateTitleBarUI();
      }
      nwo.b("Web_updateTitleBarUI");
      return;
    case 3: 
      if (this.mFavGuideView != null)
      {
        paramBundle = this.mFavGuideView.getParent();
        if ((paramBundle != null) && ((paramBundle instanceof ViewGroup))) {
          ((ViewGroup)paramBundle).removeView(this.mFavGuideView);
        }
      }
      this.mSwiftTitleUI.resetTitleBarButtonColor();
      this.mSwiftTitleUI.onDestroy();
      return;
    case 4: 
      if ((this.mSwiftFloatUI.a != null) && (8 == this.mSwiftFloatUI.c.getVisibility())) {
        this.mSwiftFloatUI.a();
      }
      if (paramBundle.containsKey("Configuration")) {}
      for (paramBundle = (Configuration)paramBundle.getParcelable("Configuration"); (paramBundle != null) && (this.mSwiftFloatUI.c != null) && (paramBundle.orientation == 2) && (this.mSwiftFloatUI.c.getVisibility() == 0); paramBundle = null)
      {
        this.mSwiftFloatUI.c.setVisibility(8);
        return;
      }
    case 6: 
      if ((!this.mStatistics.j) && (this.mProgressBarController != null) && (this.mProgressBarController.b() != 0)) {
        this.mProgressBarController.a((byte)0);
      }
      this.waitting.setVisibility(8);
      if ((paramBundle == null) || (!paramBundle.containsKey("url"))) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("url");; paramBundle = null)
    {
      if (!TextUtils.isEmpty(paramBundle)) {
        localObject1 = Uri.parse(paramBundle);
      }
      if ((localObject1 != null) && (((Uri)localObject1).isHierarchical()) && ("simple".equals(((Uri)localObject1).getQueryParameter("style"))))
      {
        this.mSwiftTitleUI.rightViewImg.setVisibility(8);
        this.mUIStyle.mOverrideBackButton = true;
      }
      disabledHistoryButton(this.mComponentContext.a());
      return;
      if (this.mProgressBarController != null) {
        this.mProgressBarController.a((byte)2);
      }
      this.waitting.setVisibility(8);
      if ((this.mUIStyle.mIsDisableRefreshView) || (this.urlText == null)) {
        break;
      }
      if ((this.mBrowserTips != null) && (this.mBrowserTipsColor == -1)) {
        this.mBrowserTips.setBackgroundResource(2131167359);
      }
      this.urlText.setVisibility(0);
      if (this.mComponentContext.a() == null) {
        break;
      }
      localObject1 = (TouchWebView)this.mComponentContext.a();
      if (this.tbsTipView != null)
      {
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label569;
        }
        this.tbsTipView.setVisibility(0);
      }
      for (;;)
      {
        paramBundle = localObject2;
        if ((this.webviewWrapper instanceof RefreshView)) {
          paramBundle = (RefreshView)this.webviewWrapper;
        }
        if ((paramBundle == null) || (!this.canWebViewOverScroll)) {
          break;
        }
        ((TouchWebView)localObject1).setOnOverScrollHandler(new SwiftBrowserUIStyleHandler.1(this, (TouchWebView)localObject1, paramBundle));
        ((TouchWebView)localObject1).setOnScrollChangedListener(new SwiftBrowserUIStyleHandler.2(this));
        updateHistoryButton(this.mComponentContext.a());
        return;
        label569:
        this.tbsTipView.setVisibility(8);
      }
    }
  }
  
  public void parseUrlParam(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Uri localUri = Uri.parse(paramString);
    String str;
    if (localUri.isHierarchical())
    {
      str = localUri.getQueryParameter("_wv");
      if (str == null) {}
    }
    try
    {
      this.mUIStyle.mRulesFromUrl = Long.parseLong(str, 10);
      checkWvParamAuthorize("ui.wvHideActionBtn", paramString, 2L);
      checkWvParamAuthorize("ui.wvFullScreen", paramString, 131072L);
      checkWvParamAuthorize("ui.wvTransparentTitle", paramString, 16777216L);
      paramString = localUri.getQueryParameter("_fv");
      if (paramString == null) {}
    }
    catch (NumberFormatException localNumberFormatException6)
    {
      try
      {
        this.mUIStyle.mFloatBarRulesFromUrl = Long.parseLong(paramString, 10);
        paramString = localUri.getQueryParameter("_fu");
        this.mUIStyle.mNeedChangeFloatBarRes = false;
        if (paramString == null) {}
      }
      catch (NumberFormatException localNumberFormatException6)
      {
        try
        {
          if (Long.parseLong(paramString) == 2019L) {
            this.mUIStyle.mNeedChangeFloatBarRes = true;
          }
          paramString = localUri.getQueryParameter("_wwv");
          if (paramString == null) {}
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          try
          {
            this.mUIStyle.mWWVRulesFromUrl = Long.parseLong(paramString, 10);
            str = localUri.getQueryParameter("_cwv");
            if (str == null) {}
          }
          catch (NumberFormatException localNumberFormatException6)
          {
            try
            {
              this.mUIStyle.mCRulesFromUrl = Long.parseLong(str, 10);
              paramString = localUri.getQueryParameter("channel");
              if (!TextUtils.isEmpty(paramString)) {
                this.mUIStyle.mControlParam = URLDecoder.decode(paramString);
              }
              paramString = localUri.getQueryParameter("subIndex");
              if (TextUtils.isEmpty(paramString)) {}
            }
            catch (NumberFormatException localNumberFormatException6)
            {
              try
              {
                this.mUIStyle.mSubIndex = Integer.parseInt(paramString.trim());
                paramString = localUri.getQueryParameter("bgColor");
                if (TextUtils.isEmpty(paramString)) {}
              }
              catch (NumberFormatException localNumberFormatException6)
              {
                try
                {
                  this.mBrowserWebviewColor = ((int)Long.parseLong(paramString, 16));
                  paramString = localUri.getQueryParameter("titleAlpha");
                  if (TextUtils.isEmpty(paramString)) {}
                }
                catch (NumberFormatException localNumberFormatException6)
                {
                  try
                  {
                    for (;;)
                    {
                      this.mUIStyle.mInitTitleAlpha = Integer.parseInt(paramString.trim());
                      paramString = localUri.getAuthority();
                      if ((TextUtils.isEmpty(paramString)) || (!paramString.endsWith("urlshare.cn"))) {
                        break;
                      }
                      this.mUIStyle.isFromQzoneGame = true;
                      reportUIStyleRules(localUri);
                      return;
                      localNumberFormatException8 = localNumberFormatException8;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wv param(" + str + ") error:" + localNumberFormatException8.getMessage());
                      continue;
                      localNumberFormatException1 = localNumberFormatException1;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + paramString + ") error:" + localNumberFormatException1.getMessage());
                      continue;
                      localNumberFormatException2 = localNumberFormatException2;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _fv param(" + paramString + ") error:" + localNumberFormatException2.getMessage());
                      continue;
                      localNumberFormatException3 = localNumberFormatException3;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _wwv param(" + paramString + ") error:" + localNumberFormatException3.getMessage());
                      continue;
                      localNumberFormatException4 = localNumberFormatException4;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser _cwv param(" + paramString + ") error:" + localNumberFormatException4.getMessage());
                      continue;
                      localNumberFormatException5 = localNumberFormatException5;
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser subIndex param(" + paramString + ") error:" + localNumberFormatException5.getMessage());
                    }
                    localNumberFormatException6 = localNumberFormatException6;
                    QLog.e("SwiftBrowserUIStyleHandler", 1, "parser bgColor param(" + paramString + ") error:" + localNumberFormatException6.getMessage());
                  }
                  catch (NumberFormatException localNumberFormatException7)
                  {
                    for (;;)
                    {
                      QLog.e("SwiftBrowserUIStyleHandler", 1, "parser titleAlpha param(" + paramString + ") error:" + localNumberFormatException7.getMessage());
                      continue;
                      this.mUIStyle.isFromQzoneGame = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void removeTitleTextShadow()
  {
    if (this.mSwiftTitleUI != null)
    {
      if (this.mSwiftTitleUI.leftView != null) {
        this.mSwiftTitleUI.leftView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      if (this.mSwiftTitleUI.centerView != null) {
        this.mSwiftTitleUI.centerView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
      if (this.mSwiftTitleUI.rightViewText != null) {
        this.mSwiftTitleUI.rightViewText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      }
    }
  }
  
  public void restoreOrientationFollowSenSor()
  {
    this.mUIStyle.isFollowSystemOrientation = true;
    this.mHostActivity.setRequestedOrientation(2);
  }
  
  public void runTitleBarAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSwiftTitleUI.runTitleBarAnimation(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void setAddShortcutBtnVisible()
  {
    if (this.mSwiftFloatUI.g != null) {
      this.mSwiftFloatUI.g.setVisibility(0);
    }
    if ((this.mSwiftFloatUI.a != null) && ((this.mSwiftFloatUI.a.getVisibility() == 8) || (this.mSwiftFloatUI.a.getVisibility() == 4))) {
      this.mSwiftFloatUI.a.setVisibility(0);
    }
  }
  
  public void setBottomBarVisible(boolean paramBoolean)
  {
    if ((!this.mUIStyle.isOnClickClose) || (this.mUIStyle.isFullScreen)) {}
    TouchWebView localTouchWebView;
    do
    {
      do
      {
        return;
      } while ((this.bottomBar == null) || (this.isBottomBarShow == paramBoolean));
      if (!paramBoolean) {
        break;
      }
      localTouchWebView = (TouchWebView)this.mComponentContext.a();
    } while ((localTouchWebView != null) && (!localTouchWebView.canGoBack()) && (!localTouchWebView.canGoForward()));
    this.isBottomBarShow = true;
    this.bottomBar.setVisibility(0);
    this.bottomBar.clearAnimation();
    this.bottomBar.setAnimation(this.mSlideIn);
    this.mSlideIn.start();
    bdla.a(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
    return;
    this.isBottomBarShow = false;
    adjustWebViewInBottomBar();
    this.bottomBar.clearAnimation();
    this.bottomBar.setAnimation(this.mSlideOut);
    this.mSlideOut.start();
  }
  
  public void setDefaultThemeIcon(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      return;
      int i;
      if ((this.mUIStyle.isShowDefaultThemeIcon) && (!"1000".equals(ThemeUtil.getCurrentThemeId()))) {
        i = 1;
      }
      Drawable localDrawable;
      while (paramBoolean)
      {
        if (i != 0)
        {
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
          if (localDrawable != null)
          {
            paramView.setBackgroundDrawable(localDrawable);
            return;
            i = 0;
            continue;
          }
        }
        paramView.setBackgroundResource(paramInt2);
        return;
      }
      if ((paramView instanceof ImageView))
      {
        paramView = (ImageView)paramView;
        if (i != 0)
        {
          localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
          if (localDrawable != null)
          {
            paramView.setImageDrawable(localDrawable);
            return;
          }
        }
        paramView.setImageResource(paramInt2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsBaseWebViewActivity", 2, "-->setShowDefaultThemeIcon err! resId=" + paramInt1);
  }
  
  public void setFloatingShareVisible(boolean paramBoolean)
  {
    this.mSwiftFloatUI.a(paramBoolean);
  }
  
  public void setNavigationBarStyle(boolean paramBoolean)
  {
    if (this.mUIStyle.isCurrentTitleTransparent == paramBoolean) {}
    Object localObject;
    for (;;)
    {
      return;
      this.mUIStyle.isCurrentTitleTransparent = paramBoolean;
      localObject = null;
      if ((this.mHostActivity instanceof IphoneTitleBarActivity)) {
        localObject = ((IphoneTitleBarActivity)this.mHostActivity).getTitleBarView();
      }
      while (localObject != null)
      {
        ((View)localObject).setBackgroundColor(BaseApplicationImpl.getContext().getResources().getColor(2131167084));
        if (!paramBoolean) {
          break label98;
        }
        runTitleBarAnimation((View)localObject, 255, 0, 200);
        return;
        if (this.mHostFragment != null) {
          localObject = this.mSwiftTitleUI.titleContainer;
        }
      }
    }
    label98:
    runTitleBarAnimation((View)localObject, 0, 255, 200);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.clickListener = paramOnClickListener;
  }
  
  public void setRightCloseButtonVisible(boolean paramBoolean)
  {
    this.mSwiftTitleUI.mUIStyle.mShowRightCloseButton = paramBoolean;
    if (paramBoolean)
    {
      this.mSwiftTitleUI.showCloseButton("");
      return;
    }
    this.mSwiftTitleUI.hideCloseButton();
  }
  
  public void setShareMusicVisible(boolean paramBoolean, int paramInt)
  {
    if (this.mLlShareMusic == null) {}
    Object localObject;
    int i;
    label40:
    do
    {
      do
      {
        return;
        localObject = this.mLlShareMusic;
        if (!paramBoolean) {
          break;
        }
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
        localObject = this.mTvShareMusic;
        if (paramInt != 0) {
          break label118;
        }
        paramInt = 2131693569;
        ((TextView)localObject).setText(paramInt);
      } while (this.mComponentContext.a() == null);
      localObject = (FrameLayout.LayoutParams)this.webviewWrapper.getLayoutParams();
    } while (localObject == null);
    if (paramBoolean) {}
    for (((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(this.mHostActivity.getResources().getDisplayMetrics().density * 75.0F));; ((FrameLayout.LayoutParams)localObject).bottomMargin = 0)
    {
      this.webviewWrapper.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      i = 8;
      break;
      label118:
      paramInt = 2131693570;
      break label40;
    }
  }
  
  public void setTitleBarScrollChange(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (this.mComponentContext.a() == null) {
      return;
    }
    this.mSwiftTitleUI.setTitleBarScrollChange((TouchWebView)this.mComponentContext.a(), paramBoolean1, paramInt1, paramInt2, paramInt3, paramBoolean2, paramString1, paramString2, paramString3);
  }
  
  public void supportOrientationFollowSenSor()
  {
    this.mUIStyle.isFollowSystemOrientation = true;
    int i = this.mHostActivity.getResources().getConfiguration().orientation;
    if (QLog.isColorLevel()) {
      QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = " + i);
    }
    if (i == 1) {
      updateScreenOrientation();
    }
    do
    {
      return;
      this.mHostActivity.setRequestedOrientation(2);
    } while (!QLog.isColorLevel());
    QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR 4");
  }
  
  public void tryMoveWebViewToTitlebar()
  {
    if ((this.mUIStyle.isWebviewNeedMoveTop) && (!this.mUIStyle.mCanTransparentTitlebar)) {
      this.mUIStyle.mCanTransparentTitlebar = this.mSwiftTitleUI.adjustContentViewToTop();
    }
  }
  
  public void updateHistoryButton(WebView paramWebView)
  {
    if (this.mUIStyle.isOnClickClose)
    {
      if (!this.mUIStyle.mIsHideBackForward) {
        break label26;
      }
      disabledHistoryButton(paramWebView);
    }
    label26:
    do
    {
      return;
      boolean bool = paramWebView.canGoBack();
      if (this.back != null) {
        this.back.setEnabled(bool);
      }
    } while (this.forward == null);
    this.forward.setEnabled(paramWebView.canGoForward());
  }
  
  public void updateScreenOrientation()
  {
    int i;
    boolean bool;
    if ((this.mUIStyle.isScreenLandscape) || (this.mUIStyle.mIsPortraitOnly.booleanValue()))
    {
      i = 1;
      if (i != 0) {
        break label74;
      }
      if ((!this.mUIStyle.hideMore) || (this.mUIStyle.isFollowSystemOrientation)) {
        break label69;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        break label88;
      }
      this.mHostActivity.setRequestedOrientation(1);
      return;
      i = 0;
      break;
      label69:
      bool = false;
      continue;
      label74:
      bool = this.mUIStyle.mIsPortraitOnly.booleanValue();
    }
    label88:
    if (this.mUIStyle.isScreenLandscape)
    {
      this.mHostActivity.setRequestedOrientation(0);
      return;
    }
    this.mHostActivity.setRequestedOrientation(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler
 * JD-Core Version:    0.7.0.1
 */