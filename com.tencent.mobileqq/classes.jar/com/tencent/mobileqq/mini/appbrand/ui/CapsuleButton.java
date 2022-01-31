package com.tencent.mobileqq.mini.appbrand.ui;

import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anxn;
import bdvr;
import bdwy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.JsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.ShareChatModel;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.mini.utils.NavigateBackUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.manager.GameCloseManager;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.Integer;>;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class CapsuleButton
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, View.OnLongClickListener
{
  public static final String KEY_TAP_INDEX_QQ = "tapIndexQQ";
  public static final String KEY_TAP_INDEX_QZONE = "tapIndexQZONE";
  public static final String KEY_TAP_INDEX_WX = "tapIndexWX";
  public static final String KEY_TAP_INDEX_WX_MOMENTS = "tapIndexWXMoments";
  private static final int MINI_APP_INNER_SHARE_BUTTON = 1;
  private static final int MINI_APP_MORE_BUTTON = 0;
  private static final int MINI_GAME_SHOW_RESTART_BTN = 1;
  public static final int MSG_ADD_SHORTCUT = 11;
  public static final int MSG_BACK_HOME = 10;
  public static final int MSG_COLOR_NOTE_CLICK = 14;
  public static final int MSG_COMPLAINT = 12;
  public static final int MSG_DEBUG_CLICK = 3;
  public static final int MSG_DETAIL_CLICK = 4;
  public static final int MSG_FORWARD_CLICK = 2;
  public static final int MSG_FORWARD_QZONE_CLICK = 6;
  public static final int MSG_FORWARD_SHARE_CHAT_CLICK = 13;
  public static final int MSG_FORWARD_WECHAT_CLICK = 7;
  public static final int MSG_FORWARD_WECHAT_MOMENT_CLICK = 8;
  public static final int MSG_MONITOR_CLICK = 5;
  public static final int MSG_MORE_CLICK = 1;
  public static final int MSG_QIPC_TIMEOUT = 1000;
  public static final int MSG_RESTART_MINIAPP = 15;
  public static final int MSG_SET_TOP = 9;
  public static final int REQUEST_CODE = 1001;
  public static final String TAG = "CapsuleButton";
  private static int unReadCount;
  private String KINGCARD_GUIDE_KEY_PREFFIX = "mini_app_kingcard_guide_";
  private int actionSheetCallbackId = -1;
  private ArrayList<Integer> backHomeSceneList = new CapsuleButton.1(this);
  private boolean isMiniMsgTabShow;
  private boolean isOpenMonitorPanel;
  private int launchFrom = -1;
  private bdwy lottieLoader;
  private AppBrandRuntime mAppBrandRuntime;
  private Drawable mCloseBtnBgDrawable;
  private Drawable mCloseBtnWhiteBgDrawable;
  private ImageView mCloseView;
  public CapsuleButton.onActivityFinishListener mGameActivityFinishListener;
  private GameBrandRuntime mGameBrandRuntime;
  private GameJsPluginEngine mGameJsPluginEngine;
  private Handler mHandler;
  private String mKingCardText;
  private Drawable mMoreBtnBgDrawable;
  private Drawable mMoreBtnWhiteBgDrawable;
  private DiniFlyAnimationView mMoreView;
  private TextView mRedDot;
  private View mSplider;
  private int mStyle = -1;
  private HashMap<String, Integer> tapIndexMap;
  
  public CapsuleButton(Context paramContext)
  {
    super(paramContext);
    initUI();
    this.mHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void backToHomePage()
  {
    if (this.mAppBrandRuntime == null) {
      return;
    }
    String str = this.mAppBrandRuntime.apkgInfo.getAppConfigInfo().entryPagePath;
    this.mAppBrandRuntime.reload(str, true);
  }
  
  private Activity getActivity()
  {
    Activity localActivity = null;
    if (isMiniGameRuntime()) {
      if (this.mGameBrandRuntime != null) {
        localActivity = this.mGameBrandRuntime.activity;
      }
    }
    while (this.mAppBrandRuntime == null) {
      return localActivity;
    }
    return this.mAppBrandRuntime.activity;
  }
  
  private View getContainerView()
  {
    this.mMoreView = new DiniFlyAnimationView(getContext());
    this.mMoreView.setId(2131363630);
    this.mMoreView.setContentDescription(alpo.a(2131701726));
    Object localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0F), -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    this.mMoreView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView(this.mMoreView, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(2131363541);
    ((ImageView)localObject).setContentDescription(alpo.a(2131701722));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0F), -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131363630);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new View(getContext());
    ((View)localObject).setId(2131369459);
    localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 0.5F), DisplayUtil.dip2px(getContext(), 18.0F));
    localLayoutParams.addRule(13, -1);
    ((View)localObject).setBackgroundColor(436207616);
    addView((View)localObject, localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setId(2131374629);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px(getContext(), 19.0F));
    localLayoutParams.leftMargin = DisplayUtil.dip2px(getContext(), 21.5F);
    localLayoutParams.topMargin = DisplayUtil.dip2px(getContext(), -9.5F);
    addView((View)localObject, localLayoutParams);
    return this;
  }
  
  private MiniAppInfo getMiniAppInfo()
  {
    Object localObject2 = null;
    Object localObject1;
    if (isMiniGameRuntime())
    {
      localObject1 = localObject2;
      if (this.mGameBrandRuntime != null)
      {
        localObject1 = localObject2;
        if (this.mGameBrandRuntime.getApkgInfo() != null)
        {
          localObject1 = localObject2;
          if (this.mGameBrandRuntime.getApkgInfo().appConfig != null) {
            localObject1 = this.mGameBrandRuntime.getApkgInfo().appConfig.config;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = localObject2;
        } while (this.mAppBrandRuntime == null);
        localObject1 = localObject2;
      } while (this.mAppBrandRuntime.apkgInfo == null);
      localObject1 = localObject2;
    } while (this.mAppBrandRuntime.apkgInfo.appConfig == null);
    return this.mAppBrandRuntime.apkgInfo.appConfig.config;
  }
  
  private void handleForwardClick()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    label213:
    label247:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (this.launchFrom == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (this.tapIndexMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexQQ"));
              localObject1 = "showActionSheet";
              localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if (!isMiniGameRuntime())
            {
              localObject2 = localObject1;
              if (this.mAppBrandRuntime != null)
              {
                localObject2 = localObject1;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
                  localObject2 = localObject1;
                }
              }
            }
            if (!isMiniGameRuntime()) {
              break label257;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 0;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label247;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject2, localJSONObject, this.actionSheetCallbackId);
            return;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject3;
            break label213;
          }
          localObject1 = localObject2;
          localJSONObject.put("fromShareButton", 0);
          localObject1 = localObject2;
          localJSONObject.put("shareTarget", 0);
          localObject1 = localObject2;
          continue;
          QLog.e("CapsuleButton", 1, "on forward aio click exception ", localJSONException1);
          localObject3 = localObject1;
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localObject3, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward aio click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localObject3, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 0;
      }
      localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject1 == null);
    label257:
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localObject3, localJSONObject.toString(), ((PageWebview)localObject1).pageWebviewId);
  }
  
  private void handleForwardQZoneClick()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    label213:
    label247:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (this.launchFrom == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (this.tapIndexMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexQZONE"));
              localObject1 = "showActionSheet";
              localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if (!isMiniGameRuntime())
            {
              localObject2 = localObject1;
              if (this.mAppBrandRuntime != null)
              {
                localObject2 = localObject1;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
                  localObject2 = localObject1;
                }
              }
            }
            if (!isMiniGameRuntime()) {
              break label257;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 1;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label247;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject2, localJSONObject, this.actionSheetCallbackId);
            return;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject3;
            break label213;
          }
          localObject1 = localObject2;
          localJSONObject.put("fromShareButton", 0);
          localObject1 = localObject2;
          localJSONObject.put("shareTarget", 1);
          localObject1 = localObject2;
          continue;
          QLog.e("CapsuleButton", 1, "on forward qzone click exception ", localJSONException1);
          localObject3 = localObject1;
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localObject3, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward qzone click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localObject3, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 1;
      }
      localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject1 == null);
    label257:
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localObject3, localJSONObject.toString(), ((PageWebview)localObject1).pageWebviewId);
  }
  
  private void handleForwardWeChatFriends()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = "onShareAppMessage";
    Object localObject2;
    label214:
    label224:
    do
    {
      do
      {
        try
        {
          if (this.launchFrom == 1)
          {
            localObject2 = "showActionSheet";
            localObject1 = localObject2;
            if (this.tapIndexMap != null)
            {
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexWX"));
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            if ((!isMiniGameRuntime()) && (this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)) {
              localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
            }
            if (!isMiniGameRuntime()) {
              break label224;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 3;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label214;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject1, localJSONObject, this.actionSheetCallbackId);
            return;
            localJSONObject.put("fromShareButton", 0);
            localJSONObject.put("shareTarget", 3);
          }
          this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localJSONException, localJSONObject.toString(), -1);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("CapsuleButton", 1, "on forward wechat friends click exception ", localJSONException);
          return;
        }
        return;
        QLog.e("CapsuleButton", 1, "on forward wechat friends click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localJSONException, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 3;
      }
      localObject2 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject2 == null);
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localJSONException, localJSONObject.toString(), ((PageWebview)localObject2).pageWebviewId);
  }
  
  private void handleForwardWeChatMoment()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = "onShareAppMessage";
    Object localObject1 = localObject2;
    label213:
    label247:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            if (this.launchFrom == 1)
            {
              String str = "showActionSheet";
              localObject2 = str;
              localObject1 = str;
              if (this.tapIndexMap == null) {
                continue;
              }
              localObject1 = str;
              localJSONObject.put("tapIndex", this.tapIndexMap.get("tapIndexWXMoments"));
              localObject1 = "showActionSheet";
              localObject2 = localObject1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            if (!isMiniGameRuntime())
            {
              localObject2 = localObject1;
              if (this.mAppBrandRuntime != null)
              {
                localObject2 = localObject1;
                if (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)
                {
                  localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
                  localObject2 = localObject1;
                }
              }
            }
            if (!isMiniGameRuntime()) {
              break label257;
            }
            this.mGameBrandRuntime.fromShareMenuBtn = 4;
            if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
              break label247;
            }
            if (this.launchFrom != 1) {
              break;
            }
            this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), (String)localObject2, localJSONObject, this.actionSheetCallbackId);
            return;
          }
          catch (JSONException localJSONException2)
          {
            Object localObject3;
            break label213;
          }
          localObject1 = localObject2;
          localJSONObject.put("fromShareButton", 0);
          localObject1 = localObject2;
          localJSONObject.put("shareTarget", 4);
          localObject1 = localObject2;
          continue;
          QLog.e("CapsuleButton", 1, "on forward wechat moment exception ", localJSONException1);
          localObject3 = localObject1;
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(localObject3, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward wechat moment exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, localObject3, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 4;
      }
      localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localObject1 == null);
    label257:
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(localObject3, localJSONObject.toString(), ((PageWebview)localObject1).pageWebviewId);
  }
  
  private void handleMoreClick()
  {
    QLog.d("CapsuleButton", 1, "handleMoreClick --  isMiniMsgTabShow : " + this.isMiniMsgTabShow);
    if (this.isMiniMsgTabShow) {
      return;
    }
    this.launchFrom = 0;
    int i = 1;
    int m = -1;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool2 = false;
    int n = 0;
    int i1 = 0;
    int j = 0;
    boolean bool1;
    if (isMiniGameRuntime()) {
      if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
      {
        if (this.mGameBrandRuntime.getApkgInfo() == null) {
          break label1617;
        }
        if (this.mGameBrandRuntime.getApkgInfo().appConfig.config.verType == 3)
        {
          bool2 = false;
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      String str2 = this.mGameBrandRuntime.getApkgInfo().appId;
      String str1 = this.mGameBrandRuntime.getApkgInfo().apkgName;
      bool7 = this.mGameBrandRuntime.withShareQQ;
      bool4 = this.mGameBrandRuntime.withShareQzone;
      boolean bool9 = this.mGameBrandRuntime.withShareWeChatFriend;
      bool3 = this.mGameBrandRuntime.withShareWeChatMoment;
      int k = this.mGameBrandRuntime.getApkgInfo().appConfig.config.topType;
      bool5 = ((GameActivity)this.mGameBrandRuntime.activity).getIsOrientationLandscape();
      Object localObject1 = ((GameActivity)this.mGameBrandRuntime.activity).getMenuStyle();
      bool6 = this.mGameBrandRuntime.getApkgInfo().appConfig.isLimitedAccessApp();
      boolean bool8 = bool1;
      bool1 = bool4;
      bool4 = bool9;
      label274:
      if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
      {
        bool9 = false;
        bool3 = false;
      }
      for (;;)
      {
        boolean bool10;
        label317:
        Object localObject2;
        label377:
        boolean bool11;
        if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1)
        {
          bool10 = true;
          if ((!(this.mGameBrandRuntime.activity instanceof GameActivity)) || (bool6)) {
            break label1585;
          }
          localObject2 = ((GameActivity)this.mGameBrandRuntime.activity).getColorNoteController();
          if (localObject2 == null) {
            break label1580;
          }
          bool4 = ((anxn)localObject2).a();
          if (!bool4) {
            break label1575;
          }
          if (!((anxn)localObject2).c()) {
            break label939;
          }
          j = 2;
          QLog.d("CapsuleButton", 1, "handleMoreClick, shouldDisplayColorNote : " + bool4);
          label404:
          bool4 = bool2;
          m = -1;
          bool2 = bool3;
          bool11 = false;
          bool3 = bool1;
          bool1 = bool11;
        }
        for (;;)
        {
          if (i == 0) {
            break label1608;
          }
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("miniAppID", str2);
          ((Intent)localObject2).putExtra("miniAppName", str1);
          if (isMiniGameRuntime())
          {
            bool11 = this.isOpenMonitorPanel;
            label474:
            ((Intent)localObject2).putExtra("isOpenMonitorPanel", bool11);
            ((Intent)localObject2).putExtra("debugEnable", getEnableDebug());
            ((Intent)localObject2).putExtra("showDebug", bool4);
            ((Intent)localObject2).putExtra("showMonitor", bool8);
            ((Intent)localObject2).putExtra("menuStyle", (String)localObject1);
            ((Intent)localObject2).putExtra("showShareQQ", bool7);
            ((Intent)localObject2).putExtra("showShareQzone", bool3);
            ((Intent)localObject2).putExtra("showShareWeChatFriends", bool9);
            ((Intent)localObject2).putExtra("showShareWeChatMoment", bool2);
            ((Intent)localObject2).putExtra("topType", k);
            ((Intent)localObject2).putExtra("showDetail", true);
            ((Intent)localObject2).putExtra("showSetting", true);
            ((Intent)localObject2).putExtra("showComplaint", true);
            if (Build.VERSION.SDK_INT < 21) {
              break label1444;
            }
            bool2 = true;
            label626:
            ((Intent)localObject2).putExtra("addShortcut", bool2);
            ((Intent)localObject2).putExtra("showBackHome", m);
            ((Intent)localObject2).putExtra("isLandscape", bool5);
            ((Intent)localObject2).putExtra("isSpecialMiniApp", bool1);
            ((Intent)localObject2).putExtra("showKingcardTip", shouldShowKingCardTip());
            ((Intent)localObject2).putExtra("key_mini_msgtab_type", 1);
            ((Intent)localObject2).putExtra("key_mini_msgtab_need_action_sheet", true);
            ((Intent)localObject2).putExtra("is_limited_access_app", bool6);
            ((Intent)localObject2).putExtra("showRestartMiniApp", bool10);
            if (!isMiniGameRuntime()) {
              break label1450;
            }
            if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.getApkgInfo() != null))
            {
              ((Intent)localObject2).putExtra("key_mini_app_version_type", 1);
              ((Intent)localObject2).putExtra("key_mini_app_config", this.mGameBrandRuntime.getApkgInfo().appConfig);
              ((Intent)localObject2).putExtra("key_mini_app_is_game", true);
              ((Intent)localObject2).putExtra("key_color_note", j);
            }
            label798:
            MiniAppSecurityUtil.modifyIntentDataWithoutLogin((Intent)localObject2, str2);
            if ((!isMiniGameRuntime()) || (this.mGameBrandRuntime.activity == null)) {
              break label1525;
            }
            MiniChatActivity.a(this.mGameBrandRuntime.activity, (Intent)localObject2, 1001);
            label837:
            this.mRedDot.setVisibility(8);
            this.isMiniMsgTabShow = true;
            unReadCount = 0;
            if (QLog.isColorLevel()) {
              QLog.d("CapsuleButton", 1, "isMiniMsgTabShow true");
            }
            reportClick("open");
            return;
            bool2 = true;
            bool1 = true;
            break;
            i = 0;
            bool5 = false;
            k = 0;
            str1 = "";
            str2 = "";
            bool6 = false;
            bool4 = false;
            bool7 = false;
            bool8 = false;
            bool3 = false;
            bool1 = false;
            bool2 = false;
            localObject1 = "light";
            break label274;
            bool10 = false;
            break label317;
            label939:
            j = 1;
            break label377;
            if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
            {
              localObject1 = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
              if (this.mAppBrandRuntime.apkgInfo.appConfig.config.verType == 3) {
                break label1566;
              }
              bool3 = true;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            if ((this.mAppBrandRuntime.apkgInfo.isEngineTypeMiniApp()) && (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null) && (this.mAppBrandRuntime.getCurPage().getCurrentPageWebview() != null) && (!this.mAppBrandRuntime.getCurPage().getCurrentPageWebview().enableShowBackHome())) {}
            for (bool2 = false;; bool2 = true)
            {
              str2 = this.mAppBrandRuntime.apkgInfo.appId;
              str1 = this.mAppBrandRuntime.apkgInfo.apkgName;
              if (localObject1 != null)
              {
                bool5 = ((PageWebview)localObject1).withShareQQ;
                bool4 = ((PageWebview)localObject1).withShareQzone;
                bool6 = ((PageWebview)localObject1).withShareWeChatFriend;
                bool7 = ((PageWebview)localObject1).withShareWeChatMoment;
              }
              k = this.mAppBrandRuntime.apkgInfo.appConfig.config.topType;
              bool8 = this.mAppBrandRuntime.apkgInfo.appConfig.config.isSpecialMiniApp();
              if (bool8)
              {
                bool5 = false;
                bool4 = false;
                bool6 = false;
                bool7 = false;
              }
              if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
              {
                bool6 = false;
                bool7 = false;
              }
              bool11 = this.mAppBrandRuntime.apkgInfo.appConfig.isLimitedAccessApp();
              j = i1;
              if ((this.mAppBrandRuntime.activity instanceof AppBrandUI))
              {
                j = i1;
                if (!bool11)
                {
                  localObject1 = ((AppBrandUI)this.mAppBrandRuntime.activity).getColorNoteController();
                  j = i1;
                  if (localObject1 != null)
                  {
                    bool9 = ((anxn)localObject1).a();
                    i = n;
                    if (bool9) {
                      if (!((anxn)localObject1).c()) {
                        break label1381;
                      }
                    }
                  }
                }
              }
              label1381:
              for (i = 2;; i = 1)
              {
                QLog.d("CapsuleButton", 1, "handleMoreClick, shouldDisplayColorNote : " + bool9);
                j = i;
                i = 1;
                bool9 = bool3;
                bool3 = bool8;
                bool10 = bool6;
                boolean bool12 = bool5;
                bool8 = bool1;
                localObject1 = "light";
                bool5 = false;
                bool6 = bool11;
                bool11 = bool2;
                bool1 = bool3;
                bool2 = bool7;
                bool7 = bool12;
                bool3 = bool4;
                bool4 = bool9;
                bool9 = bool10;
                bool10 = bool11;
                break;
              }
              bool10 = true;
              bool9 = false;
              bool7 = false;
              bool8 = false;
              i = 0;
              bool4 = false;
              localObject1 = "light";
              bool5 = false;
              k = 0;
              str1 = "";
              str2 = "";
              bool6 = false;
              bool1 = false;
              break;
              bool11 = this.mAppBrandRuntime.isOpenMonitorPanel();
              break label474;
              label1444:
              bool2 = false;
              break label626;
              label1450:
              if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.apkgInfo == null)) {
                break label798;
              }
              ((Intent)localObject2).putExtra("key_mini_app_version_type", this.mAppBrandRuntime.versionType);
              ((Intent)localObject2).putExtra("key_mini_app_config", this.mAppBrandRuntime.apkgInfo.appConfig);
              ((Intent)localObject2).putExtra("key_mini_app_is_game", false);
              ((Intent)localObject2).putExtra("key_color_note", j);
              break label798;
              label1525:
              if ((isMiniGameRuntime()) || (this.mAppBrandRuntime.activity == null)) {
                break label837;
              }
              MiniChatActivity.a(this.mAppBrandRuntime.activity, (Intent)localObject2, 1001);
              break label837;
            }
            label1566:
            bool3 = false;
          }
          label1575:
          j = 0;
          break label377;
          label1580:
          j = 0;
          break label404;
          label1585:
          bool4 = bool2;
          m = -1;
          bool11 = bool1;
          bool2 = bool3;
          bool1 = false;
          bool3 = bool11;
        }
        label1608:
        break;
        bool9 = bool4;
      }
      label1617:
      bool2 = false;
      bool1 = false;
    }
  }
  
  private void handleShareChatDirectly(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("key_mini_app_share_chat_uin");
    int i = paramBundle.getInt("key_mini_app_share_chat_type");
    paramBundle = paramBundle.getString("key_mini_app_share_chat_name");
    long l2 = -1L;
    long l1 = l2;
    if (localObject != null) {}
    JSONObject localJSONObject;
    label309:
    label342:
    label352:
    do
    {
      ShareChatModel localShareChatModel;
      do
      {
        for (;;)
        {
          try
          {
            l1 = Long.valueOf((String)localObject).longValue();
            localShareChatModel = new ShareChatModel(i, l1, paramBundle);
            localJSONObject = new JSONObject();
            localObject = "onShareAppMessage";
            paramBundle = (Bundle)localObject;
          }
          catch (Throwable localThrowable)
          {
            try
            {
              if (this.launchFrom == 1)
              {
                String str = "showActionSheet";
                localObject = str;
                paramBundle = str;
                if (this.tapIndexMap == null) {
                  continue;
                }
                paramBundle = str;
                localJSONObject.put("tapIndex", -1);
                paramBundle = "showActionSheet";
              }
            }
            catch (JSONException localJSONException1) {}
            try
            {
              if ((!isMiniGameRuntime()) && (this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.pageContainer.getCurrentPage() != null)) {
                localJSONObject.put("webViewUrl", this.mAppBrandRuntime.pageContainer.getCurrentPage().getUrl());
              }
              localJSONObject.put("chatDataHash", localShareChatModel.getEntryHash());
              if (!isMiniGameRuntime()) {
                break label352;
              }
              this.mGameBrandRuntime.fromShareMenuBtn = 0;
              this.mGameBrandRuntime.shareChatModel = localShareChatModel;
              if ((this.mGameJsPluginEngine == null) || (this.mGameJsPluginEngine.getGameJsRuntime(1) == null)) {
                break label342;
              }
              if (this.launchFrom != 1) {
                break;
              }
              this.mGameJsPluginEngine.callbackJsEventOK(this.mGameJsPluginEngine.getGameJsRuntime(1), paramBundle, localJSONObject, this.actionSheetCallbackId);
              return;
            }
            catch (JSONException localJSONException2)
            {
              PageWebview localPageWebview;
              break label309;
            }
            localThrowable = localThrowable;
            QLog.e("CapsuleButton", 1, "handleShareChatDirectly get an exception ", localThrowable);
            l1 = l2;
            continue;
            paramBundle = localThrowable;
            localJSONObject.put("fromShareButton", 0);
            paramBundle = localThrowable;
            localJSONObject.put("shareTarget", 5);
            paramBundle = localThrowable;
            continue;
          }
          QLog.e("CapsuleButton", 1, "on forward aio click exception ", localJSONException1);
        }
        this.mGameJsPluginEngine.getGameJsRuntime(1).evaluateSubcribeJS(paramBundle, localJSONObject.toString(), -1);
        return;
        QLog.e("CapsuleButton", 1, "on forward aio click exception mGameJsPluginEngine==null");
        return;
      } while (this.mAppBrandRuntime == null);
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().shareChatModel = localShareChatModel;
      }
      if (this.launchFrom == 1)
      {
        this.mAppBrandRuntime.jsPluginEngine.callbackJsEventOK(this.mAppBrandRuntime.serviceRuntime, paramBundle, localJSONObject, this.actionSheetCallbackId);
        return;
      }
      if (this.mAppBrandRuntime.getPageWebView() != null) {
        this.mAppBrandRuntime.getPageWebView().fromShareMenuBtn = 0;
      }
      localPageWebview = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    } while (localPageWebview == null);
    this.mAppBrandRuntime.serviceRuntime.evaluateSubcribeJS(paramBundle, localJSONObject.toString(), localPageWebview.pageWebviewId);
  }
  
  private boolean hasKingCardGuideShowed()
  {
    String str = this.KINGCARD_GUIDE_KEY_PREFFIX + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return StorageUtil.getPreference().getBoolean(str, false);
  }
  
  private void initUI()
  {
    setClipChildren(false);
    getContainerView();
    this.mCloseView = ((ImageView)findViewById(2131363541));
    this.mRedDot = ((TextView)findViewById(2131374629));
    this.mSplider = findViewById(2131369459);
    this.mRedDot.setTextSize(12.0F);
    this.mRedDot.setTextColor(-1);
    this.mRedDot.setGravity(17);
    this.mRedDot.setIncludeFontPadding(false);
    this.mMoreView.setOnClickListener(this);
    this.mMoreView.setOnLongClickListener(this);
    this.mCloseView.setOnClickListener(this);
    this.mMoreBtnWhiteBgDrawable = getResources().getDrawable(2130840987);
    this.mCloseBtnWhiteBgDrawable = getResources().getDrawable(2130840981);
    this.mMoreBtnBgDrawable = getResources().getDrawable(2130840984);
    this.mCloseBtnBgDrawable = getResources().getDrawable(2130840978);
    if ((!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_URL)) && (!TextUtils.isEmpty(MiniAppGlobal.CAPSULE_CLOSE_DARK_URL)))
    {
      this.mCloseBtnWhiteBgDrawable = MiniAppUtils.getIcon(getContext(), MiniAppGlobal.CAPSULE_CLOSE_DARK_URL, true, 2130840981, 40, 30);
      this.mCloseBtnBgDrawable = MiniAppUtils.getIcon(getContext(), MiniAppGlobal.CAPSULE_CLOSE_URL, true, 2130840978, 40, 30);
    }
    if (!TextUtils.isEmpty(MiniAppGlobal.KINGCARD_GUIDE_TEXT)) {}
    for (String str = MiniAppGlobal.KINGCARD_GUIDE_TEXT;; str = getResources().getString(2131694413))
    {
      this.mKingCardText = str;
      this.lottieLoader = new bdwy(null, super.getContext());
      int i = (int)(MemoryManager.a() / 2L);
      this.lottieLoader.a(i);
      return;
    }
  }
  
  private boolean isMiniGameRuntime()
  {
    return (this.mAppBrandRuntime == null) && (this.mGameBrandRuntime != null);
  }
  
  private void onMoreClick()
  {
    Bundle localBundle = null;
    this.mHandler.sendEmptyMessageDelayed(1000, 500L);
    if (isMiniGameRuntime())
    {
      if (this.mGameBrandRuntime != null) {}
      for (localApkgInfo = this.mGameBrandRuntime.getApkgInfo();; localApkgInfo = null)
      {
        int j = 3;
        int i = j;
        Object localObject = localBundle;
        if (localApkgInfo != null)
        {
          i = j;
          localObject = localBundle;
          if (localApkgInfo.appConfig != null)
          {
            i = j;
            localObject = localBundle;
            if (localApkgInfo.appConfig.config != null)
            {
              i = localApkgInfo.appConfig.config.verType;
              localObject = localApkgInfo.appConfig.config.appId;
            }
          }
        }
        localBundle = new Bundle();
        localBundle.putString("appid", (String)localObject);
        localBundle.putInt("verType", i);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_mini_app_data", localBundle, new CapsuleButton.4(this, localApkgInfo));
        return;
      }
    }
    if (this.mAppBrandRuntime != null) {}
    for (ApkgInfo localApkgInfo = this.mAppBrandRuntime.apkgInfo;; localApkgInfo = null) {
      break;
    }
  }
  
  private void performMiniGameClose()
  {
    if (!isMiniGameRuntime()) {}
    Object localObject;
    do
    {
      return;
      localObject = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.mGameBrandRuntime.activity);
      if (localObject != null) {}
      for (localObject = ((GameRuntimeLoader)localObject).getGameInfoManager().getMiniAppConfig(); localObject == null; localObject = null)
      {
        QLog.e("CapsuleButton", 1, "performMiniGameClose error, currentAppConfig is null!");
        return;
      }
      MiniReportManager.reportEventType((MiniAppConfig)localObject, 1025, "1");
      MiniProgramLpReportDC04239.reportPageView((MiniAppConfig)localObject, "1", null, "close", "inner_page");
      MiniAppReportManager2.reportPageView("2close", "inner_page", null, (MiniAppConfig)localObject);
      Activity localActivity = this.mGameBrandRuntime.activity;
      if ((localActivity instanceof GameActivity)) {
        ((GameActivity)localActivity).doOnBackPressed();
      }
    } while ((((MiniAppConfig)localObject).launchParam == null) || (TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.fromMiniAppId)));
    NavigateBackUtils.writeTagAppid(((MiniAppConfig)localObject).launchParam.fromMiniAppId);
  }
  
  private void reportClick(String paramString)
  {
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (isMiniGameRuntime())
      {
        MiniProgramLpReportDC04239.reportUserClick(this.mGameBrandRuntime.getApkgInfo().appConfig, MiniProgramLpReportDC04239.getAppType(this.mGameBrandRuntime.getApkgInfo().appConfig), null, "user_click", "more_button", paramString);
        return;
      }
    } while ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.pageContainer == null) || (this.mAppBrandRuntime.apkgInfo == null));
    PageWebview localPageWebview = this.mAppBrandRuntime.pageContainer.getCurrentPageWebview();
    MiniAppConfig localMiniAppConfig = this.mAppBrandRuntime.apkgInfo.appConfig;
    String str2 = MiniProgramLpReportDC04239.getAppType(this.mAppBrandRuntime.apkgInfo.appConfig);
    if (localPageWebview != null) {
      str1 = localPageWebview.getUrl();
    }
    MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, str2, str1, "user_click", "more_button", paramString);
  }
  
  private void restartMiniApp()
  {
    if (isMiniGameRuntime())
    {
      localMiniAppConfig = this.mGameBrandRuntime.getApkgInfo().appConfig;
      if (localMiniAppConfig != null)
      {
        this.mGameActivityFinishListener = new CapsuleButton.6(this, localMiniAppConfig);
        this.mGameBrandRuntime.activity.finish();
      }
    }
    while (this.mAppBrandRuntime == null)
    {
      MiniAppConfig localMiniAppConfig;
      return;
    }
    AppBrandRuntimeContainer.g().cleanup();
    MiniAppController.startApp(null, this.mAppBrandRuntime.apkgInfo.appConfig, null);
  }
  
  private void saveKingCardGuideShowed()
  {
    String str = this.KINGCARD_GUIDE_KEY_PREFFIX + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StorageUtil.getPreference().edit().putBoolean(str, true).apply();
  }
  
  private void sendSetUserAppTopRequest(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CapsuleButton", 1, "sendSetUserAppTopRequest, miniAppInfo = " + paramMiniAppInfo);
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", paramMiniAppInfo.appId);
    localBundle.putInt("topType", paramMiniAppInfo.topType);
    localBundle.putInt("verType", paramMiniAppInfo.verType);
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "sync_mini_app_data", localBundle, new CapsuleButton.7(this, paramMiniAppInfo));
  }
  
  private void setMiniAppTop(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null)
    {
      QLog.e("CapsuleButton", 1, "setMiniAppTop, miniAppInfo = null.");
      return;
    }
    MiniAppCmdUtil.getInstance().setUserAppTop(paramMiniAppInfo.appId, paramMiniAppInfo.topType, paramMiniAppInfo.verType, null, new CapsuleButton.8(this, paramMiniAppInfo));
  }
  
  private boolean shouldShowKingCardTip()
  {
    boolean bool = true;
    if (!AppNetConnInfo.isMobileConn())
    {
      QLog.i("CapsuleButton", 1, "shouldShowKingCardTip network type is wifi + " + AppNetConnInfo.isWifiConn());
      return false;
    }
    MiniAppInfo localMiniAppInfo = getMiniAppInfo();
    if ((localMiniAppInfo != null) && (localMiniAppInfo.appMode != null) && (localMiniAppInfo.appMode.isWangKa)) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.i("CapsuleButton", 1, "shouldShowKingCardTip， not wangka app");
      return false;
    }
    i = bdvr.a();
    QLog.i("CapsuleButton", 1, "shouldShowKingCardTip， king card status = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void startReportPage()
  {
    MiniAppConfig localMiniAppConfig;
    Object localObject1;
    if (isMiniGameRuntime())
    {
      if ((this.mGameBrandRuntime.getApkgInfo() == null) || (this.mGameBrandRuntime.getApkgInfo().appConfig == null)) {
        break label351;
      }
      localMiniAppConfig = this.mGameBrandRuntime.getApkgInfo().appConfig;
      localObject1 = this.mGameBrandRuntime.getApkgInfo().appConfig.config;
    }
    for (;;)
    {
      Object localObject3 = this.mGameBrandRuntime.activity;
      Object localObject2 = localObject1;
      localObject1 = localObject3;
      for (;;)
      {
        if ((localObject2 != null) && (localObject1 != null)) {
          localObject3 = "";
        }
        try
        {
          String str = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
          localObject3 = str;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            QLog.e("CapsuleButton", 1, "startComplainAndCallback, url = " + "");
            localUnsupportedEncodingException.printStackTrace();
            continue;
            localObject1 = null;
            localMiniAppConfig = null;
          }
          localObject1 = null;
          localObject2 = null;
          localMiniAppConfig = null;
        }
        localObject3 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + ((MiniAppInfo)localObject2).appId + "&openid=" + MainPageFragment.getUin() + "&avatar=" + (String)localObject3 + alpo.a(2131701725);
        localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject3);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("hide_more_button", true);
        ((Intent)localObject2).putExtras((Bundle)localObject3);
        ((Context)localObject1).startActivity((Intent)localObject2);
        MiniProgramLpReportDC04239.reportUserClick(localMiniAppConfig, MiniProgramLpReportDC04239.getAppType(localMiniAppConfig), null, "user_click", "more_button", "report");
        return;
        if (this.mAppBrandRuntime != null) {
          if ((this.mAppBrandRuntime.apkgInfo != null) && (this.mAppBrandRuntime.apkgInfo.appConfig != null))
          {
            localMiniAppConfig = this.mAppBrandRuntime.apkgInfo.appConfig;
            localObject1 = this.mAppBrandRuntime.apkgInfo.appConfig.config;
            localObject3 = this.mAppBrandRuntime.activity;
            localObject2 = localObject1;
            localObject1 = localObject3;
            continue;
          }
        }
      }
      label351:
      localObject1 = null;
      localMiniAppConfig = null;
    }
  }
  
  public void attachAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    this.mAppBrandRuntime = paramAppBrandRuntime;
  }
  
  public void attachGameBrandRuntime(GameBrandRuntime paramGameBrandRuntime, GameJsPluginEngine paramGameJsPluginEngine)
  {
    this.mGameBrandRuntime = paramGameBrandRuntime;
    this.mGameJsPluginEngine = paramGameJsPluginEngine;
  }
  
  public void changeNavIcon(int paramInt)
  {
    this.mStyle = paramInt;
    if (paramInt == -1)
    {
      this.mMoreView.setImageDrawable(this.mMoreBtnWhiteBgDrawable);
      this.mCloseView.setImageDrawable(this.mCloseBtnWhiteBgDrawable);
      this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      return;
    }
    this.mMoreView.setImageDrawable(this.mMoreBtnBgDrawable);
    this.mCloseView.setImageDrawable(this.mCloseBtnBgDrawable);
    this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public void detachAppBrandRuntime()
  {
    if (this.mAppBrandRuntime != null) {
      this.mAppBrandRuntime = null;
    }
    if (this.mGameBrandRuntime != null) {
      this.mGameBrandRuntime = null;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      this.isMiniMsgTabShow = false;
      QLog.d("CapsuleButton", 1, "isMiniMsgTabShow false");
      if (paramInt2 == -1)
      {
        if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.pageContainer != null)) {
          this.mAppBrandRuntime.pageContainer.reportPageViewShow("bring_to_front");
        }
        localObject = paramIntent.getStringExtra("miniAppID");
        if (((!isMiniGameRuntime()) || (!this.mGameBrandRuntime.appId.equals(localObject))) && ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.apkgInfo == null) || (this.mAppBrandRuntime.apkgInfo.appId == null) || (!this.mAppBrandRuntime.apkgInfo.appId.equals(localObject)))) {
          break label504;
        }
        paramInt1 = paramIntent.getIntExtra("clickID", -1);
        localObject = "";
        switch (paramInt1)
        {
        default: 
          paramIntent = (Intent)localObject;
          reportClick(paramIntent);
          updateRedDotVisible();
        }
      }
    }
    label504:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.mHandler.sendEmptyMessage(2);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(6);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(7);
        paramIntent = "share_WX";
        continue;
        this.mHandler.sendEmptyMessage(8);
        paramIntent = "share_Moments";
        continue;
        Message localMessage = new Message();
        localMessage.what = 13;
        localMessage.setData(paramIntent.getExtras());
        this.mHandler.sendMessage(localMessage);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(3);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(4);
        paramIntent = "about";
        continue;
        this.mHandler.sendEmptyMessage(5);
        paramIntent = (Intent)localObject;
        continue;
        paramIntent = "cancel";
        continue;
        paramIntent = "cancel_system";
        continue;
        this.mHandler.sendEmptyMessage(9);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(11);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(10);
        paramIntent = "back_home";
        continue;
        this.mHandler.sendEmptyMessage(12);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(14);
        paramIntent = (Intent)localObject;
        continue;
        this.mHandler.sendEmptyMessage(15);
        paramIntent = (Intent)localObject;
      }
    }
    Object localObject = new StringBuilder().append("intent appID : ").append((String)localObject).append("; current appid : ");
    if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.apkgInfo != null)) {}
    for (paramIntent = this.mAppBrandRuntime.apkgInfo.appId;; paramIntent = Integer.valueOf(0))
    {
      QLog.d("CapsuleButton", 1, paramIntent);
      return;
    }
  }
  
  public boolean getEnableDebug()
  {
    if (isMiniGameRuntime()) {
      if (this.mGameBrandRuntime != null) {}
    }
    while (this.mAppBrandRuntime == null)
    {
      return false;
      return StorageUtil.getPreference().getBoolean(this.mGameBrandRuntime.getApkgInfo().appId + "_debug", false);
    }
    return StorageUtil.getPreference().getBoolean(this.mAppBrandRuntime.apkgInfo.appId + "_debug", false);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CapsuleButton", 2, "handleMessage error, msg is null.");
      }
    }
    label355:
    label360:
    int i;
    label486:
    do
    {
      do
      {
        do
        {
          return false;
          switch (paramMessage.what)
          {
          case 4: 
          default: 
            return false;
          case 1: 
            onMoreClick();
            return false;
          case 1000: 
            handleMoreClick();
            return false;
          case 2: 
            handleForwardClick();
            return false;
          case 6: 
            handleForwardQZoneClick();
            return false;
          case 7: 
            handleForwardWeChatFriends();
            return false;
          case 8: 
            handleForwardWeChatMoment();
            return false;
          case 13: 
            handleShareChatDirectly(paramMessage.getData());
            return false;
          case 3: 
            if (getEnableDebug()) {
              setEnableDebug(false);
            }
            for (;;)
            {
              AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().exitProcess();
              return false;
              setEnableDebug(true);
            }
          case 5: 
            if (!isMiniGameRuntime()) {
              break label360;
            }
          }
        } while ((this.mGameBrandRuntime == null) || (this.mGameBrandRuntime.activity == null));
        paramMessage = this.mGameBrandRuntime.activity;
        if (((paramMessage instanceof GameActivity)) && (((GameActivity)paramMessage).getNavBar() != null))
        {
          ((GameActivity)paramMessage).clickMonitorPanel();
          if (this.isOpenMonitorPanel) {
            break label355;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          this.isOpenMonitorPanel = bool;
          setIsOpenMonitorPanel(this.isOpenMonitorPanel);
          paramMessage = GameRuntimeLoaderManager.g().getBindRuntimeLoader(paramMessage).getGameEngine();
          if (paramMessage == null) {
            break;
          }
          paramMessage.setEnableJankCanary(this.isOpenMonitorPanel);
          return false;
        }
      } while (this.mAppBrandRuntime == null);
      setIsOpenMonitorPanel(((AppBrandPageContainer)this.mAppBrandRuntime.getContainer()).clickMonitorPanel());
      return false;
      if (isMiniGameRuntime())
      {
        paramMessage = this.mGameBrandRuntime.getApkgInfo().appConfig.config;
        if (this.mGameBrandRuntime.getApkgInfo().appConfig.config.topType == 0)
        {
          i = 1;
          paramMessage.topType = i;
          sendSetUserAppTopRequest(this.mGameBrandRuntime.getApkgInfo().appConfig.config);
          if (this.mGameBrandRuntime.getApkgInfo().appConfig.config.topType != 1) {
            break label486;
          }
        }
        for (paramMessage = "settop_on";; paramMessage = "settop_off")
        {
          reportClick(paramMessage);
          return false;
          i = 0;
          break;
        }
      }
    } while (this.mAppBrandRuntime == null);
    paramMessage = this.mAppBrandRuntime.apkgInfo.appConfig.config;
    if (this.mAppBrandRuntime.apkgInfo.appConfig.config.topType == 0)
    {
      i = 1;
      paramMessage.topType = i;
      sendSetUserAppTopRequest(this.mAppBrandRuntime.apkgInfo.appConfig.config);
      if (this.mAppBrandRuntime.apkgInfo.appConfig.config.topType != 1) {
        break label593;
      }
    }
    label593:
    for (paramMessage = "settop_on";; paramMessage = "settop_off")
    {
      reportClick(paramMessage);
      return false;
      i = 0;
      break;
    }
    if (isMiniGameRuntime()) {
      if (this.mGameBrandRuntime.activity != null)
      {
        paramMessage = localObject1;
        if ((this.mGameBrandRuntime.activity instanceof BaseActivity)) {
          paramMessage = (BaseActivity)this.mGameBrandRuntime.activity;
        }
        ShortcutUtils.addShortcut(paramMessage, this.mGameBrandRuntime.getApkgInfo());
      }
    }
    for (;;)
    {
      reportClick("add_desktop");
      return false;
      if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.activity != null))
      {
        paramMessage = localObject2;
        if ((this.mAppBrandRuntime.activity instanceof BaseActivity)) {
          paramMessage = (BaseActivity)this.mAppBrandRuntime.activity;
        }
        ShortcutUtils.addShortcut(paramMessage, this.mAppBrandRuntime.apkgInfo);
      }
    }
    backToHomePage();
    return false;
    startReportPage();
    return false;
    if (isMiniGameRuntime())
    {
      if ((this.mGameBrandRuntime.activity == null) || (!(this.mGameBrandRuntime.activity instanceof GameActivity))) {
        break label900;
      }
      paramMessage = ((GameActivity)this.mGameBrandRuntime.activity).getColorNoteController();
    }
    while (paramMessage != null)
    {
      if (!paramMessage.c())
      {
        if (paramMessage.b())
        {
          if ((this.mAppBrandRuntime != null) && ((this.mAppBrandRuntime.getContainer() instanceof AppBrandPageContainer))) {
            ((AppBrandPageContainer)this.mAppBrandRuntime.getContainer()).notifyOnAddColorNote();
          }
          paramMessage.e();
          return false;
          if ((this.mAppBrandRuntime != null) && ((this.mAppBrandRuntime.activity instanceof AppBrandUI))) {
            paramMessage = ((AppBrandUI)this.mAppBrandRuntime.activity).getColorNoteController();
          }
        }
        else
        {
          paramMessage.i();
          return false;
        }
      }
      else
      {
        if (!paramMessage.c()) {
          break;
        }
        paramMessage.f();
        return false;
        restartMiniApp();
        return false;
      }
      label900:
      paramMessage = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = null;
    MiniAppStateManager.getInstance().notifyChange("hideKeyboard");
    switch (paramView.getId())
    {
    default: 
    case 2131363630: 
      do
      {
        return;
      } while (this.mHandler == null);
      this.mHandler.sendEmptyMessage(1);
      return;
    }
    QLog.e("CapsuleButton", 1, "[btn_close, inner page close]");
    MiniAppStateManager.getInstance().notifyChange("hideInput");
    if (isMiniGameRuntime()) {
      if ((this.mGameBrandRuntime.activity instanceof GameActivity))
      {
        GameActivity localGameActivity = (GameActivity)this.mGameBrandRuntime.activity;
        paramView = localObject;
        if (this.mGameBrandRuntime.getApkgInfo() != null) {
          paramView = this.mGameBrandRuntime.getApkgInfo().appConfig;
        }
        if ((!GameCloseManager.showAlertViewForBattleGame(localGameActivity, paramView, new CapsuleButton.2(this))) && (!GameCloseManager.showPullDownGuideDialog(localGameActivity, paramView, new CapsuleButton.3(this)))) {
          performMiniGameClose();
        }
      }
    }
    for (;;)
    {
      MiniMsgIPCClient.getInstance().clearBusiness(0);
      return;
      performMiniGameClose();
      continue;
      if (this.mAppBrandRuntime != null)
      {
        if (this.mAppBrandRuntime.apkgInfo != null)
        {
          MiniReportManager.reportEventType(this.mAppBrandRuntime.apkgInfo.appConfig, 1025, "0");
          MiniProgramLpReportDC04239.reportPageView(this.mAppBrandRuntime.apkgInfo.appConfig, "0", null, "close", "inner_page");
          MiniAppReportManager2.reportPageView("2close", "inner_page", null, this.mAppBrandRuntime.apkgInfo.appConfig);
          if ((this.mAppBrandRuntime.apkgInfo.appConfig != null) && (this.mAppBrandRuntime.apkgInfo.appConfig.launchParam != null) && (!TextUtils.isEmpty(this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.fromMiniAppId))) {
            NavigateBackUtils.writeTagAppid(this.mAppBrandRuntime.apkgInfo.appConfig.launchParam.fromMiniAppId);
          }
        }
        this.mAppBrandRuntime.moveAppBrandToBack();
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView.getId();
    return true;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    QLog.i("CapsuleButton", 1, "onNetChangeEvent =" + paramBoolean);
  }
  
  public void setEnableDebug(boolean paramBoolean)
  {
    if (isMiniGameRuntime()) {
      if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.getApkgInfo() != null)) {}
    }
    while (this.mAppBrandRuntime == null)
    {
      return;
      StorageUtil.getPreference().edit().putBoolean(this.mGameBrandRuntime.getApkgInfo().appId + "_debug", paramBoolean).apply();
      return;
    }
    StorageUtil.getPreference().edit().putBoolean(this.mAppBrandRuntime.apkgInfo.appId + "_debug", paramBoolean).apply();
  }
  
  public void setIsOpenMonitorPanel(boolean paramBoolean)
  {
    if (isMiniGameRuntime()) {
      this.isOpenMonitorPanel = paramBoolean;
    }
    while (this.mAppBrandRuntime == null) {
      return;
    }
    this.mAppBrandRuntime.setOpenMonitorPanel(paramBoolean);
  }
  
  public void setUnReadCount(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      unReadCount = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("CapsuleButton", 2, "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
      }
    }
    if (this.isMiniMsgTabShow) {
      return;
    }
    unReadCount = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("CapsuleButton", 2, "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
    }
    updateRedDotVisible();
  }
  
  public void showKingCardTips()
  {
    QLog.i("CapsuleButton", 1, "showKingCardTips trigger");
    if (getVisibility() != 0) {
      QLog.i("CapsuleButton", 1, "showKingCardTips 小程序官方模式下是 GONE状态，不需要展示");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = getActivity();
    } while ((this.mMoreView == null) || (localActivity == null) || (localActivity.isFinishing()) || (!shouldShowKingCardTip()));
    AppBrandTask.runTaskOnUiThreadIfNot(new CapsuleButton.9(this, localActivity));
  }
  
  public void showShareMenuForInnerShareButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, HashMap<String, Integer> paramHashMap, int paramInt)
  {
    QLog.d("CapsuleButton", 1, "showShareMenuForInnerShareButton --  isMiniMsgTabShow : " + this.isMiniMsgTabShow);
    if (this.isMiniMsgTabShow) {}
    label901:
    label1030:
    for (;;)
    {
      return;
      this.launchFrom = 1;
      this.tapIndexMap = paramHashMap;
      this.actionSheetCallbackId = paramInt;
      paramInt = 1;
      boolean bool4 = true;
      String str = "";
      Object localObject1 = "";
      boolean bool2 = false;
      boolean bool1 = false;
      paramHashMap = "light";
      label181:
      Object localObject2;
      boolean bool3;
      int i;
      if (isMiniGameRuntime()) {
        if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
        {
          str = this.mGameBrandRuntime.getApkgInfo().appId;
          localObject1 = this.mGameBrandRuntime.getApkgInfo().apkgName;
          bool2 = ((GameActivity)this.mGameBrandRuntime.activity).getIsOrientationLandscape();
          paramHashMap = ((GameActivity)this.mGameBrandRuntime.activity).getMenuStyle();
          bool1 = this.mGameBrandRuntime.getApkgInfo().appConfig.isLimitedAccessApp();
          if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) == 1) {
            break label1007;
          }
          paramBoolean3 = false;
          paramBoolean4 = false;
          localObject2 = localObject1;
          int j = -1;
          bool3 = false;
          i = paramInt;
          paramInt = j;
          localObject1 = paramHashMap;
          paramHashMap = (HashMap<String, Integer>)localObject2;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label1030;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("miniAppID", str);
        ((Intent)localObject2).putExtra("miniAppName", paramHashMap);
        boolean bool5;
        if (isMiniGameRuntime())
        {
          bool5 = this.isOpenMonitorPanel;
          label278:
          ((Intent)localObject2).putExtra("isOpenMonitorPanel", bool5);
          ((Intent)localObject2).putExtra("debugEnable", getEnableDebug());
          ((Intent)localObject2).putExtra("showDebug", false);
          ((Intent)localObject2).putExtra("showMonitor", false);
          ((Intent)localObject2).putExtra("menuStyle", (String)localObject1);
          ((Intent)localObject2).putExtra("showShareQQ", paramBoolean1);
          ((Intent)localObject2).putExtra("showShareQzone", paramBoolean2);
          ((Intent)localObject2).putExtra("showShareWeChatFriends", paramBoolean3);
          ((Intent)localObject2).putExtra("showShareWeChatMoment", paramBoolean4);
          ((Intent)localObject2).putExtra("topType", -11);
          ((Intent)localObject2).putExtra("showDetail", false);
          ((Intent)localObject2).putExtra("showSetting", false);
          ((Intent)localObject2).putExtra("showComplaint", false);
          ((Intent)localObject2).putExtra("addShortcut", false);
          ((Intent)localObject2).putExtra("showBackHome", paramInt);
          ((Intent)localObject2).putExtra("isLandscape", bool2);
          ((Intent)localObject2).putExtra("isSpecialMiniApp", bool3);
          ((Intent)localObject2).putExtra("showKingcardTip", shouldShowKingCardTip());
          ((Intent)localObject2).putExtra("key_mini_msgtab_type", 1);
          ((Intent)localObject2).putExtra("key_mini_msgtab_need_action_sheet", true);
          ((Intent)localObject2).putExtra("is_limited_access_app", bool1);
          ((Intent)localObject2).putExtra("showRestartMiniApp", bool4);
          if (!isMiniGameRuntime()) {
            break label901;
          }
          if ((this.mGameBrandRuntime != null) && (this.mGameBrandRuntime.getApkgInfo() != null))
          {
            ((Intent)localObject2).putExtra("key_mini_app_version_type", 1);
            ((Intent)localObject2).putExtra("key_mini_app_config", this.mGameBrandRuntime.getApkgInfo().appConfig);
            ((Intent)localObject2).putExtra("key_mini_app_is_game", true);
          }
          label576:
          if ((!isMiniGameRuntime()) || (this.mGameBrandRuntime == null) || (this.mGameBrandRuntime.activity == null)) {
            break label966;
          }
          MiniChatActivity.a(this.mGameBrandRuntime.activity, (Intent)localObject2, 1001);
          label615:
          this.mRedDot.setVisibility(8);
          this.isMiniMsgTabShow = true;
          unReadCount = 0;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CapsuleButton", 1, "isMiniMsgTabShow true");
          return;
          paramInt = 0;
          break label181;
          if ((this.mAppBrandRuntime != null) && (this.mAppBrandRuntime.activity != null) && (!this.isMiniMsgTabShow))
          {
            if (this.mAppBrandRuntime.pageContainer.getCurrentPageWebview() == null) {
              break;
            }
            if ((!this.mAppBrandRuntime.apkgInfo.isEngineTypeMiniApp()) || (this.mAppBrandRuntime.pageContainer.getCurrentPage() == null) || (this.mAppBrandRuntime.getCurPage().getCurrentPageWebview() == null) || (this.mAppBrandRuntime.getCurPage().getCurrentPageWebview().enableShowBackHome())) {
              break label1001;
            }
          }
        }
        label966:
        label1001:
        for (bool1 = false;; bool1 = true)
        {
          str = this.mAppBrandRuntime.apkgInfo.appId;
          paramHashMap = this.mAppBrandRuntime.apkgInfo.apkgName;
          bool3 = this.mAppBrandRuntime.apkgInfo.appConfig.config.isSpecialMiniApp();
          bool2 = this.mAppBrandRuntime.apkgInfo.appConfig.config.isLimitedAccessApp();
          if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_share_to_wx_switcher", 1) != 1)
          {
            paramBoolean3 = false;
            paramBoolean4 = false;
          }
          bool4 = bool1;
          localObject1 = "light";
          bool5 = false;
          bool1 = bool2;
          i = 1;
          paramInt = -1;
          bool2 = bool5;
          break;
          paramHashMap = "";
          bool2 = false;
          bool1 = false;
          localObject1 = "light";
          i = 0;
          paramInt = -1;
          bool3 = false;
          break;
          bool5 = this.mAppBrandRuntime.isOpenMonitorPanel();
          break label278;
          if ((this.mAppBrandRuntime == null) || (this.mAppBrandRuntime.apkgInfo == null)) {
            break label576;
          }
          ((Intent)localObject2).putExtra("key_mini_app_version_type", this.mAppBrandRuntime.versionType);
          ((Intent)localObject2).putExtra("key_mini_app_config", this.mAppBrandRuntime.apkgInfo.appConfig);
          ((Intent)localObject2).putExtra("key_mini_app_is_game", false);
          break label576;
          if ((isMiniGameRuntime()) || (this.mAppBrandRuntime.activity == null)) {
            break label615;
          }
          MiniChatActivity.a(this.mAppBrandRuntime.activity, (Intent)localObject2, 1001);
          break label615;
        }
        label1007:
        localObject2 = paramHashMap;
        i = paramInt;
        paramInt = -1;
        bool3 = false;
        paramHashMap = (HashMap<String, Integer>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public void updateRedDotVisible()
  {
    AppBrandTask.runTaskOnUiThreadIfNot(new CapsuleButton.5(this));
  }
  
  public void updateStyle(int paramInt)
  {
    if ((this.mMoreView != null) && (this.mCloseView != null) && (this.mSplider != null))
    {
      if (paramInt == -1)
      {
        this.mMoreView.setImageResource(2130840987);
        this.mCloseView.setImageResource(2130840981);
        this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      }
    }
    else {
      return;
    }
    this.mMoreView.setImageResource(2130840984);
    this.mCloseView.setImageResource(2130840978);
    this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public void updateUI() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton
 * JD-Core Version:    0.7.0.1
 */