package com.tencent.mobileqq.jsp;

import aady;
import aakn;
import aart;
import aasr;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anvx;
import ascz;
import ashz;
import aupt;
import awbd;
import awbi;
import awbj;
import awbk;
import awbl;
import awbm;
import awbo;
import awbp;
import awbq;
import awbr;
import awbs;
import awbt;
import awbu;
import awbv;
import awbw;
import awby;
import awbz;
import awca;
import awcb;
import awcc;
import bcnc;
import bdla;
import becr;
import bglb;
import bhcu;
import bhdj;
import bhdz;
import bheg;
import bhgy;
import bhhr;
import bhkk;
import bhkn;
import bhyo;
import bhyq;
import bhyt;
import bieo;
import bifb;
import bifw;
import biit;
import bikb;
import bikc;
import bike;
import bikh;
import biki;
import bikl;
import bkzi;
import bkzq;
import bkzs;
import bkzu;
import bleh;
import blek;
import blqp;
import blsg;
import bmib;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneJumpQBrowserInterface;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import nro;
import nta;
import nwo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import oww;
import owx;
import oxb;
import pcp;
import twh;
import ykv;
import zcl;
import znl;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, bkzq, bkzs, bkzu
{
  public static volatile BroadcastReceiver a;
  public static ResultReceiver a;
  public static CopyOnWriteArrayList<WeakReference<UiApiPlugin>> a;
  public static AtomicBoolean a;
  static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public static AtomicLong a;
  public static volatile BroadcastReceiver b;
  public static AtomicBoolean b;
  public static volatile BroadcastReceiver c;
  public static AtomicBoolean c;
  public int a;
  public aady a;
  public aakn a;
  public ProgressDialog a;
  public View a;
  public ImageView a;
  public ascz a;
  public bkzi a;
  bleh jdField_a_of_type_Bleh = null;
  public RefreshView a;
  public MiniMsgUser a;
  public String a;
  WeakReference<UiApiPlugin> jdField_a_of_type_JavaLangRefWeakReference = null;
  private owx jdField_a_of_type_Owx;
  public boolean a;
  int b;
  protected ProgressDialog b;
  public View b;
  public ImageView b;
  public String b;
  public boolean b;
  public int c;
  public ImageView c;
  public String c;
  public boolean c;
  public int d;
  public ImageView d;
  public String d;
  public boolean d;
  public int e;
  protected String e;
  public boolean e;
  public String f;
  public boolean f;
  public String g;
  public boolean g;
  public String h;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public UiApiPlugin()
  {
    this.jdField_a_of_type_Aady = null;
    this.jdField_a_of_type_Ascz = new awbd(this);
    this.jdField_c_of_type_Int = -1;
    this.mPluginNameSpace = "ui";
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 6: 
      return 2130843753;
    }
    return 2130850427;
  }
  
  static int a(JSONObject paramJSONObject, String paramString)
  {
    try
    {
      n = paramJSONObject.getInt(paramString);
      return n;
    }
    catch (JSONException localJSONException)
    {
      try
      {
        int n = Color.parseColor(paramJSONObject.getString(paramString));
        return n;
      }
      catch (Exception paramJSONObject) {}
    }
    return 0;
  }
  
  public static Intent a(Context paramContext, Map<String, Object> paramMap, String paramString1, String paramString2)
  {
    paramMap = new Intent("android.intent.action.MAIN");
    paramMap.setClassName(paramContext, ShortcutGuideActivity.class.getName());
    paramMap.addCategory("android.intent.category.LAUNCHER");
    paramMap.putExtra("from", paramString2);
    paramMap.putExtra("url", paramString1);
    return paramMap;
  }
  
  private IMiniMsgUnreadCallback a()
  {
    return new awcb(this);
  }
  
  private MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new awcc(this);
  }
  
  public static String a(aart paramaart)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramaart != null) {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "init");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShowBottomBar", paramaart.jdField_a_of_type_Boolean);
      localJSONObject.put("barHeight", paramaart.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("data", localJSONObject);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException paramaart)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("UiApiPlugin", 2, "getSetBottomBarCallBackResult json error!");
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramString1);
      if (paramString2 != null) {
        localJSONObject.put("resultData", paramString2);
      }
      if (paramString3 != null) {
        localJSONObject.put("message", paramString3);
      }
      if (paramString4 != null) {
        localJSONObject.put("extras", paramString4);
      }
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "getCallBackResult json error!");
      }
    }
    return "{\"result\":\"-1\",\"message\":\"getCallBackResult json error!\"}";
  }
  
  public static void a(Activity paramActivity, CustomWebView paramCustomWebView, AppInterface paramAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramActivity == null) {}
    Intent localIntent;
    JSONObject localJSONObject2;
    String str2;
    JSONObject localJSONObject1;
    label48:
    label64:
    Object localObject1;
    Object localObject2;
    label114:
    boolean bool4;
    label237:
    int n;
    do
    {
      do
      {
        do
        {
          return;
          localIntent = paramActivity.getIntent();
        } while ((paramCustomWebView == null) && (!paramBoolean2));
        try
        {
          localJSONObject2 = new JSONObject(paramString);
          str2 = localJSONObject2.optString("url");
          if (!paramBoolean1) {
            break;
          }
          localJSONObject1 = localJSONObject2;
          if (localJSONObject1 == null) {
            break label2607;
          }
          paramString = localJSONObject1.optString("businessId");
        }
        catch (Exception paramActivity)
        {
          QLog.e("UiApiPlugin", 1, "convert json exception", paramActivity);
          return;
        }
        localObject1 = null;
        if (localIntent != null)
        {
          localObject2 = localIntent.getStringExtra("big_brother_ref_source_key");
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localIntent.getStringExtra("big_brother_source_key");
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label2552;
        }
        localObject1 = paramString;
        if (paramCustomWebView != null) {
          b(paramCustomWebView.getUrl(), str2);
        }
        bool4 = localJSONObject2.optBoolean("force_no_reload");
      } while ((TextUtils.isEmpty(str2)) || (localJSONObject1 == null) || (!localJSONObject1.has("style")));
      localObject2 = null;
      paramString = (String)localObject2;
      if (!paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        paramString = (String)localObject2;
        if (!paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
        {
          paramString = (String)localObject2;
          if (!localJSONObject1.optBoolean("useNewConfig", false)) {
            paramString = paramActivity.getIntent().getExtras();
          }
        }
      }
      if (paramString != null) {
        break label573;
      }
      paramString = new Bundle();
      if (paramString.containsKey("startOpenPageTime")) {
        paramString.putLong("startOpenPageTime", System.currentTimeMillis());
      }
      n = localJSONObject1.optInt("style");
      if ((str2.startsWith("https://y.qq.com/m/mqq/musicsearch/index.html")) && (str2.contains("entry=aio"))) {
        paramString.remove("hide_left_button");
      }
      if (!Boolean.valueOf(localJSONObject2.optBoolean("is_native", true)).booleanValue()) {
        break label2565;
      }
      PluginJumpManager.getInstance().updateConfig(paramAppInterface);
      PluginJumpManager.getInstance().loadConfig();
    } while (PluginJumpManager.getInstance().openView(paramActivity, str2, String.valueOf(n)));
    break label2565;
    label347:
    label372:
    String str1;
    switch (localJSONObject1.optInt("navigationBarStyle"))
    {
    case 1: 
      paramString.putBoolean("hide_title_left_arrow", localJSONObject1.optBoolean("hideLeftArrow", false));
      n = localJSONObject1.optInt("target");
      if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        paramCustomWebView = new Intent(((BasePluginActivity)paramActivity).getOutActivity(), QQBrowserActivity.class);
        paramCustomWebView.putExtra("big_brother_source_key", str1);
        paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
        paramCustomWebView.putExtras(paramString);
        paramCustomWebView.putExtra("url", str2);
        paramCustomWebView.setFlags(0);
        if (n == 1) {
          paramCustomWebView.putExtra("articalChannelId", 0);
        }
        paramActivity.startActivityForResult(paramCustomWebView, 100);
      }
      for (;;)
      {
        label560:
        label573:
        for (;;)
        {
          label494:
          switch (localJSONObject1.optInt("animation"))
          {
          case 0: 
          case 1: 
            paramActivity.overridePendingTransition(0, 0);
            return;
            localJSONObject1 = localJSONObject2.optJSONObject("options");
            break label48;
            str1 = localIntent.getStringExtra("big_brother_source_key");
            break label64;
            paramString.remove("title");
            paramString.remove("leftViewText");
            paramString.remove("post_data");
            paramString.remove("options");
            paramString.remove("isOpeningQunApp");
            paramString.remove("isTransparentTitleAndClickable");
            a(paramString);
            boolean bool2 = false;
            boolean bool3 = false;
            boolean bool1 = bool3;
            paramBoolean1 = bool2;
            if (paramCustomWebView != null) {}
            try
            {
              localObject2 = Uri.parse(paramCustomWebView.getUrl());
              bool1 = bool3;
              paramBoolean1 = bool2;
              if (localObject2 != null)
              {
                bool1 = bool3;
                paramBoolean1 = bool2;
                if (((Uri)localObject2).isHierarchical())
                {
                  paramBoolean1 = "1".equals(((Uri)localObject2).getQueryParameter("__iscomic"));
                  bool1 = "1".equals(((Uri)localObject2).getQueryParameter("__useCampusNotice"));
                }
              }
              if ((paramBoolean1) && (!bool1))
              {
                paramString.remove("uintype");
                QLog.d("UiApiPlugin", 1, "remove campus notice");
              }
              if (paramString.containsKey("insertPluginsArray"))
              {
                localObject2 = paramString.get("insertPluginsArray");
                if ((localObject2 instanceof String[]))
                {
                  localObject2 = (String[])localObject2;
                  n = 0;
                  while (n < localObject2.length)
                  {
                    if ("gdtReportPlugin".equals(localObject2[n])) {
                      localObject2[n] = null;
                    }
                    n += 1;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              QLog.e("UiApiPlugin", 1, "open url exception", localException);
            }
          }
        }
        break label237;
        paramString.putBoolean("hide_more_button", false);
        paramString.putBoolean("hide_operation_bar", true);
        break label347;
        paramString.putBoolean("hide_more_button", true);
        paramString.putBoolean("hide_operation_bar", true);
        break label347;
        paramString.putBoolean("hide_more_button", false);
        paramString.putBoolean("hide_operation_bar", false);
        paramString.putString("webStyle", "");
        break label347;
        paramString.putBoolean("hide_more_button", true);
        paramString.putBoolean("hide_operation_bar", false);
        paramString.putString("webStyle", "");
        break label347;
        paramString.putBoolean("hide_left_button", true);
        paramString.putBoolean("show_right_close_button", true);
        break label347;
        paramString.putBoolean("isTransparentTitleAndClickable", true);
        break label372;
        if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramCustomWebView.setFlags(0);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if ((paramActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.fragment.VipComicWebFragmentActivity")) || (paramActivity.getClass().getName().equalsIgnoreCase("com.qqcomic.activity.media.VipComicMediaPlayActivity")))
        {
          paramCustomWebView = new Intent();
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramString.remove("activityNoTitle");
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramCustomWebView.setFlags(0);
          if (blqp.a(str2, paramCustomWebView))
          {
            paramCustomWebView.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else
          {
            blqp.a(paramActivity, paramCustomWebView, 100);
          }
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.QQH5BrowserActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramCustomWebView.setFlags(0);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramString.remove("isFullScreen");
          paramString.remove("isTransparentTitle");
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramCustomWebView.setFlags(0);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          if (becr.a(str2)) {
            paramCustomWebView = TeamWorkDocEditBrowserActivity.a(new Intent(paramActivity, TeamWorkDocEditBrowserActivity.class), str2, paramActivity);
          }
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("cooperation.qwallet.plugin.QWalletPluginProxyActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if ((paramActivity.getClass().getName().equalsIgnoreCase("cooperation.qqreader.ui.ReaderContentPageActivity")) || (paramActivity.getClass().getName().equalsIgnoreCase("com.qqreader.pureader.SSReaderActivity")) || (paramActivity.getClass().getName().equalsIgnoreCase("cooperation.qqreader.shadow.ReaderSingleTaskProxyActivity")))
        {
          if (!(paramActivity instanceof BasePluginActivity)) {
            break label2547;
          }
          paramCustomWebView = ((BasePluginActivity)paramActivity).getOutActivity();
          label1635:
          paramCustomWebView = new Intent(paramCustomWebView, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramCustomWebView.setFlags(0);
          if (n == 1) {
            paramCustomWebView.putExtra("articalChannelId", 0);
          }
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if (paramActivity.getClass().getName().equalsIgnoreCase("cooperation.liveroom.LiveRoomProxyActivity"))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else if ((paramActivity instanceof NearbyActivity))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramCustomWebView.putExtras(paramString);
          paramCustomWebView.putExtra("url", str2);
          paramActivity.startActivityForResult(paramCustomWebView, 100);
        }
        else
        {
          if ((!(paramActivity instanceof GameActivity)) && (!(paramActivity instanceof GameActivity1))) {
            break label1974;
          }
          paramAppInterface = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
          paramAppInterface.putExtra("url", str2);
          paramAppInterface.putExtra("big_brother_source_key", str1);
          paramAppInterface.putExtra("big_brother_ref_source_key", (String)localObject1);
          paramString.putBoolean("hide_left_button", true);
          paramString.putBoolean("hide_more_button", true);
          paramAppInterface.putExtras(paramString);
          QLog.d("PayForFriendView", 1, "checkPayForFriendLogic startActivityForResult at " + System.currentTimeMillis());
          paramActivity.startActivityForResult(paramAppInterface, 3004);
          if (paramCustomWebView != null) {
            paramCustomWebView.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
          }
        }
      }
      label1974:
      paramString.remove("BusinessFeedData");
      if (localJSONObject1.optBoolean("useApolloBrowser", false))
      {
        ApolloUtil.a(paramActivity, null, "other", str2, paramAppInterface);
        return;
      }
      if (((paramActivity instanceof ApolloFloatActivity)) || ((paramActivity instanceof ApolloGameActivity)) || (localJSONObject1.optBoolean("useQQBrowser", false)))
      {
        paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
        paramCustomWebView.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      }
      break;
    }
    label2565:
    label2607:
    label2612:
    label2623:
    for (;;)
    {
      if (becr.a(str2))
      {
        paramCustomWebView = new Intent(paramActivity, TeamWorkDocEditBrowserActivity.class);
        paramCustomWebView.addFlags(603979776);
        paramCustomWebView = TeamWorkDocEditBrowserActivity.a(paramCustomWebView, str2, paramActivity);
      }
      if (localJSONObject1.optBoolean("isOpeningQunApp"))
      {
        paramString.putBoolean("isOpeningQunApp", localJSONObject1.optBoolean("isOpeningQunApp"));
        paramString.putInt("appid", localJSONObject1.optInt("appid"));
        paramAppInterface = localJSONObject1.optJSONObject("extraParams");
        if (paramAppInterface != null)
        {
          paramString.putString("extraParams", paramAppInterface.toString());
          paramString.putInt("troopid", paramAppInterface.optInt("gc"));
        }
      }
      paramCustomWebView.putExtra("force_no_reload", bool4);
      paramCustomWebView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramCustomWebView.putExtras(paramString);
      paramCustomWebView.putExtra("big_brother_source_key", str1);
      paramCustomWebView.putExtra("big_brother_ref_source_key", (String)localObject1);
      paramCustomWebView.putExtra("url", str2);
      paramCustomWebView.setFlags(0);
      if (n == 1) {
        paramCustomWebView.putExtra("articalChannelId", 0);
      }
      if (blqp.a(str2, paramCustomWebView))
      {
        paramCustomWebView.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
        blsg.a(paramActivity, paramCustomWebView, "com.qqcomic.activity.media.VipComicMediaPlayActivity", null);
        break label494;
        if ((paramActivity instanceof QzoneJumpQBrowserInterface))
        {
          paramCustomWebView = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
          continue;
        }
        if ((paramActivity instanceof EcshopWebActivity))
        {
          paramCustomWebView = new Intent(paramActivity, BusinessBrowser.class);
          paramCustomWebView.putExtra("jump_from", 2);
          continue;
        }
        if ((paramActivity instanceof ReadInJoyArticleDetailActivity))
        {
          paramCustomWebView = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
          paramString.remove("click_time");
          paramString.remove("available_memory");
          continue;
        }
        if ((paramActivity instanceof PublicFragmentActivityForTool))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramAppInterface = ((PublicFragmentActivityForTool)paramActivity).a();
          if (!(paramAppInterface instanceof EcshopNewPageFragment)) {
            break label2623;
          }
          ((EcshopNewPageFragment)paramAppInterface).jdField_a_of_type_Boolean = true;
          break label2623;
        }
        if (localJSONObject1.optBoolean("QzoneUseQQBrowser", false))
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          paramString.remove("isTransparentTitle");
          paramString.remove("hide_more_button");
          paramString.remove("hide_left_button");
          continue;
        }
        if (paramBoolean2)
        {
          paramCustomWebView = new Intent(paramActivity, QQBrowserActivity.class);
          paramCustomWebView.putExtra("big_brother_source_key", str1);
          continue;
        }
        paramCustomWebView = new Intent(paramActivity, paramActivity.getClass());
        paramCustomWebView.putExtra("big_brother_source_key", str1);
        continue;
      }
      paramActivity.startActivityForResult(paramCustomWebView, 100);
      break label494;
      paramActivity.overridePendingTransition(2130772299, 0);
      return;
      label2547:
      paramCustomWebView = paramActivity;
      break label1635;
      label2552:
      break label114;
      for (;;)
      {
        if (paramString == null) {
          break label2612;
        }
        str1 = paramString;
        break;
        switch (n)
        {
        }
        break label347;
        break label372;
        return;
        paramString = null;
      }
      if (localIntent != null) {
        break label560;
      }
      str1 = null;
      break;
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, long paramLong, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfString.length;
    if ((i1 == 0) || (i1 != paramArrayOfInt.length) || (paramLong == -1L))
    {
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4));
      paramActivity.finish();
      return;
    }
    GetOpenidProto.GetOpenidReq localGetOpenidReq = new GetOpenidProto.GetOpenidReq();
    localGetOpenidReq.appid.set(paramLong);
    int n = 0;
    if (n < i1)
    {
      GetOpenidProto.GetOpenidEntry localGetOpenidEntry = new GetOpenidProto.GetOpenidEntry();
      for (;;)
      {
        int i2;
        try
        {
          localGetOpenidEntry.id.set(Long.parseLong(paramArrayOfString[n], 10));
          i2 = paramArrayOfInt[n];
          if (i2 == 0)
          {
            localGetOpenidEntry.type.set(0);
            localGetOpenidReq.list.add(localGetOpenidEntry);
            n += 1;
          }
        }
        catch (NumberFormatException paramAppInterface)
        {
          paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin error"));
          paramActivity.finish();
          return;
        }
        if (i2 == 1)
        {
          localGetOpenidEntry.type.set(1);
        }
        else
        {
          if (i2 != 3000) {
            break label217;
          }
          localGetOpenidEntry.type.set(2);
        }
      }
      label217:
      paramActivity.setResult(-1, new Intent().putExtra("ret", 4).putExtra("errMsg", "uin type error"));
      paramActivity.finish();
      return;
    }
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), nta.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new awbl(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (bhgy.a(paramActivity, new String[] { paramString1 }))
    {
      QQToast.a(paramActivity, 2131692037, 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
      paramActivity = a("-4", null, "createShortcut exsit!", paramString3);
      bdla.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
      callJs(paramString5, new String[] { paramActivity });
      return;
    }
    ThreadManagerV2.excute(new UiApiPlugin.27(this, paramActivity, paramString4, paramString1, paramString2, paramString3, paramString5), 128, null, true);
  }
  
  public static void a(Activity paramActivity, JSONObject paramJSONObject, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramActivity != null) {
      for (;;)
      {
        String str2;
        try
        {
          if (paramActivity.isFinishing()) {
            return;
          }
          String str4 = paramJSONObject.optString("title");
          String str5 = paramJSONObject.optString("text");
          boolean bool1 = paramJSONObject.optBoolean("needOkBtn", true);
          boolean bool2 = paramJSONObject.optBoolean("needCancelBtn", true);
          String str1 = paramJSONObject.optString("okBtnText");
          str2 = paramJSONObject.optString("cancelBtnText");
          String str3 = paramJSONObject.optString("callback");
          QQCustomDialog localQQCustomDialog = bhdj.a(paramActivity, 0);
          localQQCustomDialog.setTitle(str4);
          localQQCustomDialog.setMessage(str5);
          paramJSONObject = localQQCustomDialog.getMessageTextView().getLayoutParams();
          if ((paramJSONObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((ViewGroup.MarginLayoutParams)paramJSONObject).leftMargin = ViewUtils.dip2px(12.0F);
            ((ViewGroup.MarginLayoutParams)paramJSONObject).rightMargin = ViewUtils.dip2px(12.0F);
            localQQCustomDialog.getMessageTextView().setLayoutParams(paramJSONObject);
          }
          if (bool2)
          {
            if (!TextUtils.isEmpty(str2)) {
              break label244;
            }
            paramJSONObject = paramActivity.getString(2131690697);
            localQQCustomDialog.setNegativeButton(paramJSONObject, paramOnClickListener1);
          }
          if (bool1)
          {
            if (TextUtils.isEmpty(str1))
            {
              paramActivity = paramActivity.getString(2131694399);
              localQQCustomDialog.setPositiveButton(paramActivity, paramOnClickListener2);
            }
          }
          else
          {
            if (!TextUtils.isEmpty(str3)) {
              localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
            }
            try
            {
              localQQCustomDialog.show();
              return;
            }
            catch (Exception paramActivity)
            {
              return;
            }
          }
          paramActivity = str1;
        }
        catch (Exception paramActivity)
        {
          paramActivity.printStackTrace();
          return;
        }
        continue;
        label244:
        paramJSONObject = str2;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    int n = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("UiApiPlugin", 2, "showTips param:" + paramString);
    }
    if (paramContext == null) {
      label38:
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        str = paramString.optString("text");
        switch (paramString.optInt("type"))
        {
        case 0: 
          int i1 = paramString.optInt("iconMode", 1);
          if (TextUtils.isEmpty(str)) {
            break label38;
          }
          switch (i1)
          {
          case 0: 
          case 6: 
            QQToast.a(paramContext, n, str, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
            return;
          }
          break;
        }
      }
      catch (JSONException paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UiApiPlugin", 2, "showTips error:" + paramContext);
      return;
      n = 2;
      continue;
      n = 1;
      continue;
      n = 6;
      continue;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      paramContext = QQToast.a(paramContext, 0, str, 0).a(0);
      paramContext.setGravity(23, 0, 0);
      paramContext.show();
      return;
      return;
      n = 2;
    }
  }
  
  public static void a(Intent paramIntent, owx paramowx, String paramString, twh paramtwh)
  {
    if ((paramIntent == null) || (paramowx == null))
    {
      QLog.d("UiApiPlugin", 1, "requestCommentCreateForWeb object is null");
      return;
    }
    try
    {
      str1 = paramIntent.getStringExtra("comment_json_string");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("UiApiPlugin", 1, "handleInfoAndRequestForWeb webJsonString is null");
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      QLog.e("UiApiPlugin", 1, "handleInfoAndRequestForWeb error :" + paramIntent.getMessage());
      return;
    }
    Object localObject1 = new JSONObject(str1);
    String str1 = ((JSONObject)localObject1).optString("uniqueKey", "");
    int n = ((JSONObject)localObject1).optInt("src", 1);
    int i1 = ((JSONObject)localObject1).optInt("commentType", 1);
    String str2 = ((JSONObject)localObject1).optString("replyFirstCommentId", "");
    String str3 = ((JSONObject)localObject1).optString("replySubCommentId", "");
    String str4 = ((JSONObject)localObject1).optString("replyUin", "");
    localObject1 = ((JSONObject)localObject1).optString("replyNick", "");
    Object localObject2 = new JSONObject(paramIntent.getStringExtra("arg_result_json"));
    paramIntent = ((JSONObject)localObject2).optString("comment");
    boolean bool2 = ((JSONObject)localObject2).optBoolean("select_to_friend");
    localObject2 = new ArticleInfo();
    ((ArticleInfo)localObject2).innerUniqueID = str1;
    paramowx.a(new awbj(paramtwh, paramString, str2, str3, (String)localObject1));
    if (!TextUtils.isEmpty(str3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramowx, n, (ArticleInfo)localObject2, i1, str3, str2, paramIntent, bool2, bool1, str4);
      return;
    }
  }
  
  private static void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("openWithWebBundle");
      paramBundle.remove("real_url");
      paramBundle.remove("preload_url");
      paramBundle.remove("bundle_data");
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    if (paramInt != 0)
    {
      localObject = paramImageView2;
      if (paramImageView2 == null)
      {
        paramImageView2 = new ImageView(BaseApplicationImpl.getApplication());
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, paramImageView1.getId());
        ((RelativeLayout.LayoutParams)localObject).addRule(6, paramImageView1.getId());
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        paramImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = paramImageView2;
        if ((paramImageView1.getParent() instanceof RelativeLayout))
        {
          ((RelativeLayout)paramImageView1.getParent()).addView(paramImageView2);
          localObject = paramImageView2;
        }
      }
      paramInt = a(paramInt);
      if (paramInt > 0)
      {
        ((ImageView)localObject).setImageResource(paramInt);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    while (paramImageView2 == null)
    {
      Object localObject;
      return;
      ((ImageView)localObject).setVisibility(8);
      return;
    }
    paramImageView2.setVisibility(8);
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if ((paramJSONObject == null) || (paramActivity == null))
    {
      QLog.d("UiApiPlugin", 1, "showCommentEditorNew null object");
      return;
    }
    QLog.d("UiApiPlugin", 1, "showCommentEditorNew json is :" + paramJSONObject.toString());
    String str1 = new String(bhcu.decode(paramJSONObject.optString("placeholder", ""), 0));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    int n = paramJSONObject.optInt("maxLength", 100);
    int i1 = paramJSONObject.optInt("commentType", 1);
    int i2 = paramJSONObject.optInt("sourceType", 1);
    int i3 = paramJSONObject.optInt("openAt", 0);
    boolean bool = paramJSONObject.optBoolean("canBiu", false);
    String str2 = new String(bhcu.decode(paramJSONObject.optString("defaultTxt"), 0));
    Intent localIntent = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      localIntent.putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    QLog.d("UiApiPlugin", 2, "#showCommentEditorNew bridge isPgcAuthor = " + paramJSONObject.optBoolean("isPgcAuthor", false));
    localIntent.putExtra("comment_type", true);
    localIntent.putExtra("comment_json_string", paramJSONObject.toString());
    localIntent.putExtra("arg_comment_placeholder", str1);
    localIntent.putExtra("arg_comment_default_txt", str2);
    localIntent.putExtra("arg_comment_max_length", n);
    localIntent.putExtra("arg_comment_comment_type", i1);
    localIntent.putExtra("arg_comment_source_type", i2);
    localIntent.putExtra("arg_callback", paramString);
    localIntent.putExtra("arg_comment_open_at", i3);
    localIntent.putExtra("comment_can_biu", bool);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (localJSONArray != null) {
      localIntent.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    pcp.a(paramActivity, localIntent, 117);
  }
  
  private static void a(owx paramowx, int paramInt1, ArticleInfo paramArticleInfo, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    RIJBiuAndCommentRequestData localRIJBiuAndCommentRequestData = new RIJBiuAndCommentRequestData();
    localRIJBiuAndCommentRequestData.setBiu(true);
    localRIJBiuAndCommentRequestData.setContentSrc(paramInt1);
    localRIJBiuAndCommentRequestData.setContentString(paramString3);
    localRIJBiuAndCommentRequestData.setDiffuseToFriends(paramBoolean1);
    if (paramArticleInfo == null) {}
    for (paramString3 = "";; paramString3 = paramArticleInfo.innerUniqueID)
    {
      localRIJBiuAndCommentRequestData.setRowKey(paramString3);
      localRIJBiuAndCommentRequestData.setListShowType(2);
      localRIJBiuAndCommentRequestData.setCommentType(paramInt2);
      localRIJBiuAndCommentRequestData.setReplyCommentId(paramString1);
      localRIJBiuAndCommentRequestData.setReplyParentCommentId(paramString2);
      localRIJBiuAndCommentRequestData.setIsSecondReply(paramBoolean2);
      localRIJBiuAndCommentRequestData.setReplyUin(paramString4);
      paramowx.a(paramArticleInfo, localRIJBiuAndCommentRequestData);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, twh paramtwh)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig callback is null");
      return;
    }
    QLog.d("UiApiPlugin", 1, "webGetCommentAladdinConfig isFromMainProcess + " + paramBoolean);
    JSONObject localJSONObject = new JSONObject();
    if (paramBoolean)
    {
      paramBoolean = oww.a();
      try
      {
        localJSONObject.put("isGrayscaleUser", paramBoolean);
        QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig is " + paramBoolean);
        paramtwh.a(paramString, localJSONObject);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig error " + localJSONException.getMessage());
        }
      }
    }
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_update_biu_and_comment_switch_action", new Bundle(), new awbi(localJSONObject, paramtwh, paramString));
  }
  
  public static boolean a(Context paramContext, Intent paramIntent, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    label168:
    label181:
    label373:
    for (;;)
    {
      int n;
      try
      {
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130840422);
        if (paramString2 == null) {
          break label373;
        }
        n = bhdz.a(paramContext);
        if (n == paramString2.getWidth()) {
          break label373;
        }
        if (bhkn.jdField_c_of_type_Boolean) {
          break label168;
        }
        paramString2 = bhkk.a().a(paramString2, n);
        if (paramString2 != null) {
          break label181;
        }
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "createShortcut.failed, icon is null.");
        }
        return false;
      }
      catch (OutOfMemoryError paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
        }
        paramString2 = null;
        continue;
      }
      try
      {
        paramString2 = HttpUtil.openUrlForByte(paramContext, paramString2, "GET", null, null);
        if (paramString2 == null) {
          return false;
        }
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
        try
        {
          paramString2 = BitmapFactory.decodeByteArray(paramString2, 0, paramString2.length);
        }
        catch (OutOfMemoryError paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString2));
          }
          paramString2 = null;
        }
      }
      continue;
      paramString2 = Bitmap.createScaledBitmap(paramString2, n, n, false);
      continue;
      bhkk.a().a(paramIntent);
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = (ShortcutManager)paramContext.getSystemService("shortcut");
        if ((localObject != null) && (((ShortcutManager)localObject).isRequestPinShortcutSupported()))
        {
          paramContext = new ShortcutInfo.Builder(paramContext, "QQ" + paramString1).setIcon(Icon.createWithBitmap(paramString2)).setShortLabel(paramString1).setIntent(paramIntent).build();
          try
          {
            ((ShortcutManager)localObject).requestPinShortcut(paramContext, null);
            return true;
          }
          catch (Exception paramContext)
          {
            QLog.i("UiApiPlugin", 1, "requestPinShortcut exception", paramContext);
            return false;
          }
        }
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.NAME", paramString1);
      ((Intent)localObject).putExtra("android.intent.extra.shortcut.ICON", paramString2);
      ((Intent)localObject).putExtra("duplicate", false);
      ((Intent)localObject).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramContext.sendOrderedBroadcast((Intent)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "createShortcut.finish.");
      }
      return true;
    }
  }
  
  private static JSONObject b(oxb paramoxb, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramoxb.a());
      localJSONObject.put("rspCommentId", paramoxb.a());
      localJSONObject.put("replyFirstCommentId", paramString1);
      localJSONObject.put("replySubCommentId", paramString2);
      localJSONObject.put("comment", paramoxb.c());
      localJSONObject.put("replyUin", paramoxb.e());
      localJSONObject.put("replyNick", paramString3);
      return localJSONObject;
    }
    catch (JSONException paramoxb)
    {
      QLog.e("UiApiPlugin", 1, "convertRespDataToJsonString error :" + paramoxb.getMessage());
    }
    return localJSONObject;
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http:"))) || ((paramString2.startsWith("https:")) && (!TextUtils.isEmpty(paramString1)) && (paramString1.contains("h5costreport=1")))) {
      ThreadManager.getSubThreadHandler().post(new UiApiPlugin.17(paramString1, paramString2));
    }
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "unRegisterReceiver");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    for (;;)
    {
      if ((jdField_c_of_type_AndroidContentBroadcastReceiver != null) && (jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(jdField_c_of_type_AndroidContentBroadcastReceiver);
        jdField_c_of_type_AndroidContentBroadcastReceiver = null;
      }
      if ((jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)))
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(jdField_b_of_type_AndroidContentBroadcastReceiver);
        jdField_b_of_type_AndroidContentBroadcastReceiver = null;
      }
      return;
      QLog.i("UiApiPlugin", 1, "no need unregister sExitWebViewReceiver");
    }
  }
  
  private void h()
  {
    jdField_c_of_type_AndroidContentBroadcastReceiver = new awca(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initX5LogUploadReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("upload_x5_log");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_c_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UiApiPlugin", 1, "register receiver error:" + localException.toString());
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { "2", Integer.toString(paramInt) });
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "0", Integer.toString(paramInt) });
      continue;
      callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(paramInt));
    }
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    int n = -1;
    if ("1".equals(paramString)) {
      n = 2130843933;
    }
    do
    {
      return n;
      if ("2".equals(paramString)) {
        return 2130843932;
      }
      if ("3".equals(paramString)) {
        return 2130840369;
      }
      if ("4".equals(paramString)) {
        return 2130839433;
      }
      if ("5".equals(paramString)) {
        return 2130843977;
      }
      if ("7".equals(paramString))
      {
        if (paramBoolean) {
          return 2130842567;
        }
        return 2130842570;
      }
      if ("8".equals(paramString))
      {
        if (paramBoolean) {
          return 2130850145;
        }
        return 2130850149;
      }
      if ("9".equals(paramString)) {
        return 2130838962;
      }
      if ("10".equals(paramString)) {
        return 2130850337;
      }
      if ("11".equals(paramString)) {
        return 2130850336;
      }
      if ("14".equals(paramString)) {
        return 2130850264;
      }
    } while (!"15".equals(paramString));
    return 2130850265;
  }
  
  public Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public bikh a()
  {
    bifb localbifb = this.mRuntime.a(this.mRuntime.a());
    if ((localbifb != null) && ((localbifb instanceof bikh))) {
      return (bikh)localbifb;
    }
    return null;
  }
  
  public bikl a()
  {
    bifb localbifb = this.mRuntime.a(this.mRuntime.a());
    if ((localbifb != null) && ((localbifb instanceof bikl))) {
      return (bikl)localbifb;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      Drawable localDrawable = this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
      if (localDrawable != null)
      {
        localDrawable = bheg.a(localDrawable, paramInt);
        if (localDrawable != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = null;
    awbo localawbo = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    RelativeLayout localRelativeLayout;
    label200:
    do
    {
      do
      {
        return;
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131376760);
        switch (paramInt)
        {
        }
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
            break label200;
          }
          if (paramBoolean2) {
            break;
          }
          localRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
          this.jdField_a_of_type_AndroidWidgetImageView = null;
          this.jdField_b_of_type_AndroidWidgetImageView = null;
          return;
          Drawable localDrawable = localActivity.getResources().getDrawable(2130844741);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localawbo = new awbo(this, paramString);
            localObject = localDrawable;
          }
        }
      } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
      if (paramBoolean1) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localawbo);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130850427));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localawbo);
      paramString = new RelativeLayout(localActivity);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      paramString.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(localBaseApplication, 8.0F), DisplayUtil.dip2px(localBaseApplication, 8.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, DisplayUtil.dip2px(localBaseApplication, 4.0F), DisplayUtil.dip2px(localBaseApplication, 4.0F), 0);
      paramString.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(localBaseApplication, 36.0F), DisplayUtil.dip2px(localBaseApplication, 36.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131376894);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.dip2px(localBaseApplication, 4.0F), 0);
    } while (localRelativeLayout == null);
    localRelativeLayout.addView(paramString, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      if ("my_emoji_clk".equals(paramString2)) {
        if (("11".equals(paramString1)) && (paramActivity != null))
        {
          paramString2 = paramActivity.getIntent();
          Intent localIntent = new Intent(paramActivity, EmosmActivity.class);
          localIntent.putExtra("key_emojimall_detail_chat_type", paramString2.getIntExtra("key_emojimall_detail_chat_type", -1));
          localIntent.putExtra("key_emojimall_detail_chat_uin", paramString2.getStringExtra("key_emojimall_detail_chat_uin"));
          localIntent.putExtra("emojimall_src", paramString2.getIntExtra("emojimall_src", 1));
          paramActivity.startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      if ("10".equals(paramString1)) {
        bdla.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
      }
      return;
      QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, my_emoji_clk, activity = null or iconid != my dressup");
      continue;
      callJs(paramString2, new String[] { "" });
      continue;
      QLog.e("UiApiPlugin", 1, "handleDoubleRightBtnClickEvent, callback null, iconId=" + paramString1);
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int n;
    label170:
    label177:
    label247:
    do
    {
      do
      {
        boolean bool;
        int i2;
        do
        {
          int i1;
          do
          {
            do
            {
              return;
              n = paramIntent.getIntExtra("mode", 0);
              bool = paramIntent.getBooleanExtra("exclude", false);
              i1 = paramIntent.getIntExtra("number", 0);
              i2 = paramIntent.getIntExtra("sender", 0);
              if (QLog.isColorLevel()) {
                if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
                  break label170;
                }
              }
              for (paramContext = this.jdField_a_of_type_JavaLangRefWeakReference.toString();; paramContext = "null")
              {
                QLog.d("UiApiPlugin", 2, String.format("plugin %s (mSequence: %d): onReceive , mode: %d, exclude: %b, number: %d, sender: %d", new Object[] { paramContext, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(n), Boolean.valueOf(bool), Integer.valueOf(i1), Integer.valueOf(i2) }));
                paramContext = this.mRuntime.a();
                if ((paramContext == null) || (paramContext.isFinishing())) {
                  break;
                }
                if (i1 <= 0) {
                  break label247;
                }
                if (i2 != this.jdField_b_of_type_Int) {
                  break label177;
                }
                if (bool) {
                  break;
                }
                paramContext.finish();
                return;
              }
              if ((this.jdField_b_of_type_Int < i2 - i1) || (this.jdField_b_of_type_Int >= i2)) {
                break;
              }
            } while ((n != 0) && (n != 2));
            paramContext.finish();
            return;
          } while ((this.jdField_b_of_type_Int <= i2) || (this.jdField_b_of_type_Int > i1 + i2) || ((n != 0) && (n != 1)));
          paramContext.finish();
          return;
          if (i2 != this.jdField_b_of_type_Int) {
            break;
          }
        } while (bool);
        paramContext.finish();
        return;
        if (i2 <= this.jdField_b_of_type_Int) {
          break;
        }
      } while ((n != 0) && (n != 2));
      paramContext.finish();
      return;
    } while ((n != 0) && (n != 1));
    paramContext.finish();
  }
  
  protected void a(File paramFile)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    Object localObject = paramFile.getAbsolutePath();
    paramFile = new Bundle();
    paramFile.putInt("forward_type", 1);
    paramFile.putString("forward_urldrawable_thumb_url", (String)localObject);
    paramFile.putString("forward_filepath", (String)localObject);
    paramFile.putString("forward_extra", (String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtras(paramFile);
    aupt.a(localActivity, (Intent)localObject, 18);
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_Bkzi != null)
      {
        if (this.jdField_a_of_type_Bkzi.isShowing()) {
          this.jdField_a_of_type_Bkzi.dismiss();
        }
        if (paramString.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Bkzi.show();
          return;
        }
      }
      localObject1 = this.mRuntime.a();
    } while (localObject1 == null);
    for (;;)
    {
      int i4;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject1 = bkzi.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((bkzi)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        int i3 = localJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = localJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label398;
        }
        this.jdField_a_of_type_Boolean = true;
        ((bkzi)localObject1).a(str, 3);
        n = 1;
        i1 = n;
        if (localObject2 != null)
        {
          i1 = n;
          if (((JSONArray)localObject2).length() > 0)
          {
            i4 = ((JSONArray)localObject2).length();
            i1 = i2;
            if (i3 >= 0)
            {
              i1 = i2;
              if (i3 < i4)
              {
                i1 = 0;
                if (i1 >= i4) {
                  break label409;
                }
                str = ((JSONArray)localObject2).getString(i1);
                if (i1 != i3) {
                  break label403;
                }
                bool = true;
                ((bkzi)localObject1).a(str, bool);
                i1 += 1;
                continue;
              }
            }
            if (i1 >= i4) {
              break label409;
            }
            ((bkzi)localObject1).c(((JSONArray)localObject2).getString(i1));
            i1 += 1;
            continue;
          }
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((bkzi)localObject1).d((CharSequence)localObject2);
        }
        ((bkzi)localObject1).a(this);
        ((bkzi)localObject1).a(this);
        ((bkzi)localObject1).setOnCancelListener(this);
        ((bkzi)localObject1).a(this);
        this.jdField_a_of_type_Bkzi = ((bkzi)localObject1);
        this.jdField_b_of_type_JavaLangString = localJSONObject.optString("onclick");
        this.jdField_a_of_type_Int = i1;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Bkzi.show();
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("UiApiPlugin", 2, "showActionSheet error:" + paramString.getMessage());
      return;
      label398:
      int n = 0;
      continue;
      label403:
      boolean bool = false;
      continue;
      label409:
      int i1 = n + i4;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("rowKey");
      ((JSONObject)localObject2).optString("articleId");
      ((JSONObject)localObject2).optBoolean("isAccountDerelict");
      ((JSONObject)localObject2).optLong("publisherUin");
      String str1 = ((JSONObject)localObject2).optString("commentID");
      String str2 = ((JSONObject)localObject2).optString("subCommentID");
      String str3 = ((JSONObject)localObject2).optString("isAwesome");
      Object localObject1 = ((JSONObject)localObject2).optString("onCommentSend");
      String str4 = ((JSONObject)localObject2).optString("onCommentLike");
      String str5 = ((JSONObject)localObject2).optString("onCommentDelete");
      String str6 = ((JSONObject)localObject2).optString("onPanelClose");
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("rowKey", paramString);
      ((Bundle)localObject2).putString("commentId", str1);
      ((Bundle)localObject2).putString("subCommentId", str2);
      ((Bundle)localObject2).putString("isAwesome", str3);
      ((Bundle)localObject2).putString("onCommentSend", (String)localObject1);
      ((Bundle)localObject2).putString("onCommentLike", str4);
      ((Bundle)localObject2).putString("onCommentDelete", str5);
      ((Bundle)localObject2).putString("onPanelClose", str6);
      ((Bundle)localObject2).putInt("seq", paramInt);
      localObject1 = new AnchorData();
      ((AnchorData)localObject1).jdField_a_of_type_JavaLangString = str1;
      ((AnchorData)localObject1).jdField_b_of_type_JavaLangString = str2;
      ((AnchorData)localObject1).jdField_a_of_type_Boolean = "1".equals(str3);
      QLog.i("UiApiPlugin", 1, "anchorData commentId:" + str1 + " ,subCommentId :" + str2);
      ReadInJoyAtlasCommentFragment.a((Activity)this.mRuntime.a().getContext(), paramString, null, null, null, (AnchorData)localObject1, false, false, (Bundle)localObject2);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("UiApiPlugin", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    EntityManager localEntityManager = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
    TroopInfo localTroopInfo = (TroopInfo)localEntityManager.find(TroopInfo.class, paramString1);
    localEntityManager.close();
    int n;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.mRuntime.a().getAccount())) {
        break label116;
      }
      n = 0;
    }
    for (;;)
    {
      bdla.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, n + "", "", "");
      return;
      label116:
      if (localTroopInfo.isAdmin()) {
        n = 1;
      } else {
        n = 2;
      }
    }
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      localJSONObject.put("options", paramJSONObject);
      callJs("javascript:mqq.dispatchEvent(\"miniAIOEvent\"," + localJSONObject.toString() + ");");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("UiApiPlugin", 1, paramString, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, null, new awbp(this, paramJSONObject));
    }
  }
  
  public void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject, paramJsBridgeListener, null);
    }
  }
  
  public void a(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    int n;
    String str1;
    String str2;
    String str3;
    boolean bool2;
    int i1;
    label148:
    do
    {
      return;
      n = paramJSONObject.optInt("iconID");
      str1 = paramJSONObject.optString("title");
      str2 = paramJSONObject.optString("callback");
      str3 = paramJSONObject.optString("color");
      bool2 = paramJSONObject.optBoolean("hidden");
      i1 = paramJSONObject.optInt("cornerID");
      if ((localActivity instanceof AbsBaseWebViewActivity))
      {
        int i2 = paramJSONObject.optInt("navIconUseDefault", -1);
        if (i2 >= 0)
        {
          paramJSONObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.mUIStyle;
            if (1 != i2) {
              break label148;
            }
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          paramJSONObject.isShowDefaultThemeIcon = bool1;
          ((AbsBaseWebViewActivity)localActivity).a(str2, str1, str3, bool2, n, i1, paramJsBridgeListener, paramOnClickListener);
          return;
        }
      }
      paramJSONObject = this.mRuntime.a(this.mRuntime.a());
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bikl)))
      {
        ((bikl)paramJSONObject).setRightButton(str2, str1, str3, bool2, n, i1, paramOnClickListener, null);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bikb)))
      {
        ((bikb)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bikc)))
      {
        ((bikc)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
    } while ((paramJSONObject == null) || (!(paramJSONObject instanceof bike)));
    ((bike)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, this.mRuntime.a().hashCode());
  }
  
  public void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str1 = paramJSONObject.optString("callback");
    if (paramString == null)
    {
      paramJSONObject = new JSONObject();
      try
      {
        paramJSONObject.put("code", paramInt);
        callJs(str1, new String[] { paramJSONObject.toString() });
        return;
      }
      catch (JSONException paramJSONObject)
      {
        callJs(str1, new String[] { "{\"code\":" + paramInt + "}" });
        return;
      }
    }
    String str2 = paramJSONObject.optString("text");
    Object localObject = paramJSONObject.optString("textColor");
    paramInt = paramJSONObject.optInt("x");
    int n = paramJSONObject.optInt("y");
    Rect localRect = new Rect(paramInt, n, paramJSONObject.optInt("width") + paramInt, paramJSONObject.optInt("height") + n);
    paramJSONObject = (JSONObject)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject = "#FF000000";
    }
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(str2);
    bcnc.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new awby(this, str1));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_g_of_type_Boolean) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label241;
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break;
      }
      localObject3 = BaseApplicationImpl.getContext();
      localObject2 = this.mRuntime.a();
    } while ((localObject2 == null) || (((Activity)localObject2).isFinishing()));
    Object localObject1 = new TextView((Context)localObject2);
    ((TextView)localObject1).setText(2131690845);
    ((TextView)localObject1).setBackgroundResource(2130850733);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setMaxWidth(DisplayUtil.dip2px((Context)localObject3, 100.0F));
    ((TextView)localObject1).setMinWidth(DisplayUtil.dip2px((Context)localObject3, 52.0F));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131167020));
    ((TextView)localObject1).setTextSize(1, 17.0F);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px((Context)localObject3, 36.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131376894);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject1).setOnClickListener(this);
    Object localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131376760);
    if (localObject2 != null) {
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    label197:
    for (this.jdField_g_of_type_Boolean = true;; this.jdField_g_of_type_Boolean = false)
    {
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((WebViewFragment)localObject1).mSwiftTitleUI == null)) {
        break;
      }
      ((WebViewFragment)localObject1).mSwiftTitleUI.setConversationBtnVisible(paramBoolean);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break label197;
      label241:
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)localObject).findViewById(2131376760);
    } while (localView == null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (int n = ImmersiveUtils.getStatusBarHeight((Context)localObject) + 0;; n = 0)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      n += localView.getMeasuredHeight();
      if ((!this.jdField_d_of_type_Boolean) && (paramBoolean))
      {
        localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -n);
        ((TranslateAnimation)localObject).setDuration(paramInt);
        ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
        ((TranslateAnimation)localObject).setFillAfter(true);
        ((TranslateAnimation)localObject).setAnimationListener(new awbt(this, localView, localView.getTop() - n, localView.getBottom() - n));
        localView.startAnimation((Animation)localObject);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      if ((!this.jdField_d_of_type_Boolean) || (paramBoolean)) {
        break;
      }
      localObject = new TranslateAnimation(0.0F, 0.0F, -n, 0.0F);
      ((TranslateAnimation)localObject).setDuration(paramInt);
      ((TranslateAnimation)localObject).setInterpolator(new LinearInterpolator());
      ((TranslateAnimation)localObject).setFillAfter(true);
      ((TranslateAnimation)localObject).setAnimationListener(new awbu(this, localView, localView.getTop() + n, n + localView.getBottom()));
      localView.setVisibility(0);
      localView.startAnimation((Animation)localObject);
      this.jdField_d_of_type_Boolean = false;
      return;
    }
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localObject == null) || (localActivity == null) || (localActivity.isFinishing())) {
      callJs4OpenApiIfNeeded("setPullDown", -100, "recode_failed_native_error");
    }
    do
    {
      return;
      localObject = (View)((WebView)localObject).getParent();
    } while (!(localObject instanceof RefreshView));
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)localObject);
    this.jdField_h_of_type_Boolean = false;
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131363783);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Aakn = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_Aakn;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Aakn.setHeaderBgColor(-16777216);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(-16777216);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new awbm(this));
        callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
        return;
        this.jdField_a_of_type_Aakn.setHeaderBgColor(paramInt1);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(paramInt2);
      }
    }
    callJs4OpenApiIfNeeded("setPullDown", 0, "already initPullDown");
  }
  
  protected void a(byte[] paramArrayOfByte, String paramString)
  {
    paramString = AppConstants.SDCARD_PATH + "diskcache/Image_" + paramString;
    FileUtils.writeFile(paramArrayOfByte, paramString);
    a(new File(paramString));
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      do
      {
        return false;
        if (paramString2.equals("g_appstore_myapp"))
        {
          QLog.d("UiApiPlugin", 1, "open troopApp manager error,TroopProxyActivity已在725下架");
          return true;
        }
      } while ((TextUtils.isEmpty(paramString1)) || (!paramString1.matches("\\d+")));
      if (paramString2.equals("g_flower"))
      {
        startActivityForResult(bglb.a(this.mRuntime.a(), paramString1, "web"), (byte)10);
        a(paramString1, "exp");
        return true;
      }
      if (paramString2.equals("g_proceeding")) {
        return true;
      }
      if (paramString2.equals("g_homework"))
      {
        if (this.jdField_a_of_type_Aady == null)
        {
          this.jdField_a_of_type_Aady = aady.a();
          this.jdField_a_of_type_Aady.a();
        }
        this.jdField_a_of_type_Aady.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_org"))
      {
        paramString1 = "mqqapi://group/openOrg?troopUin=" + paramString1;
        paramString2 = new Intent();
        paramString2.setData(Uri.parse(paramString1));
        paramString2.setAction("android.intent.action.VIEW");
        this.mRuntime.a().startActivity(paramString2);
        return true;
      }
      if (paramString2.equals("g_troop_reward"))
      {
        if (this.jdField_a_of_type_Aady == null)
        {
          this.jdField_a_of_type_Aady = aady.a();
          this.jdField_a_of_type_Aady.a();
        }
        this.jdField_a_of_type_Aady.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_background"))
      {
        if (bhhr.q(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin())) {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
        }
        for (;;)
        {
          return true;
          bhhr.z(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
          paramString2 = new Intent(this.mRuntime.a(), TroopPicEffectGuidePicActivity.class);
          paramString2.putExtra("friendUin", paramString1);
          paramString2.putExtra("troopUin", paramString1);
          paramString2.putExtra("isFromTroopApp", true);
          this.mRuntime.a().startActivity(paramString2);
        }
      }
    } while ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("mqqapi://groupopenapp/openapp")));
    if ("group_story".equals(paramString2))
    {
      paramString1 = zcl.a(null, paramString3, null);
      ykv.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      paramString2 = new Intent(this.mRuntime.a(), JumpActivity.class);
      paramString2.setData(Uri.parse(paramString1));
      this.mRuntime.a().startActivity(paramString2);
      return true;
      paramString1 = paramString3;
      if ("group_album".equals(paramString2)) {
        paramString1 = paramString3.replace("$UNREADNUM$", "1");
      }
    }
  }
  
  public void ad_()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject instanceof PublicFragmentActivity))
    {
      localObject = ((PublicFragmentActivity)localObject).a();
      if ((localObject instanceof TribeVideoListPlayerFragment)) {
        ((TribeVideoListPlayerFragment)localObject).a(this.jdField_a_of_type_Bkzi);
      }
    }
  }
  
  public void b()
  {
    try
    {
      Activity localActivity = this.mRuntime.a();
      WebViewFragment localWebViewFragment = this.mRuntime.a();
      if ((localActivity != null) && (localWebViewFragment != null)) {
        ((InputMethodManager)localActivity.getSystemService("input_method")).toggleSoftInput(2, 0);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("UiApiPlugin", 1, localException, new Object[0]);
    }
  }
  
  public void b(int paramInt)
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = paramInt;
    localMiniMsgUserParam.accessType = 3;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.isNeedBackConversation = true;
    localMiniMsgUserParam.unreadCallback = a();
    localMiniMsgUserParam.actionCallback = a();
    this.mRuntime.a();
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mini_msg uiApiPlugin initMiniMsgUser = ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(this.mRuntime.a(), localMiniMsgUserParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
  }
  
  public void b(String paramString)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if ((localObject != null) && ((localObject instanceof biki)))
    {
      localObject = ((biki)localObject).getShare();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((aasr)localObject).b());
      localBundle.putString("desc", ((aasr)localObject).c());
      localBundle.putString("detail_url", ((aasr)localObject).a());
      localBundle.putString("cover_url", ((aasr)localObject).e());
      localBundle.putInt("article_id", ((aasr)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((aasr)localObject).d());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((aasr)localObject).f());
      if (a() != null)
      {
        if (!bmib.a(this.mRuntime.a(), a(), localBundle, null, 0)) {
          break label189;
        }
        if (!TextUtils.isEmpty(paramString)) {
          callJs(paramString, new String[] { "true" });
        }
      }
    }
    return;
    label189:
    if (!TextUtils.isEmpty(paramString)) {
      callJs(paramString, new String[] { "false" });
    }
    znl.a(1, 2131689486);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "showPopupMenu: context is null");
      }
    }
    Object localObject1;
    float f1;
    JSONArray localJSONArray;
    for (;;)
    {
      return;
      localObject1 = this.mRuntime.a(this.mRuntime.a());
      if ((localObject1 != null) && ((localObject1 instanceof bikl))) {
        localObject1 = ((bikl)localObject1).getTitleBarView();
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("UiApiPlugin", 2, "showPopupMenu: Can not get TitleBar");
          return;
          if ((localObject1 != null) && ((localObject1 instanceof bikb)))
          {
            localObject1 = ((bikb)localObject1).a();
          }
          else if ((localObject1 != null) && ((localObject1 instanceof bike)))
          {
            localObject1 = ((bike)localObject1).a(this.mRuntime.a().hashCode());
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("UiApiPlugin", 2, "showPopupMenu: activity has not implement WebUiMethodInterface");
            return;
          }
        }
      }
      f1 = localActivity.getResources().getDisplayMetrics().density;
      if (this.jdField_a_of_type_Bleh != null)
      {
        if (!this.jdField_a_of_type_Bleh.isShowing()) {
          this.jdField_a_of_type_Bleh.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298811) - localActivity.getResources().getDimensionPixelSize(2131298807), localActivity.getResources().getDimensionPixelSize(2131298808));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130839568);
        try
        {
          localJSONArray = paramJSONObject.optJSONArray("list");
          if (localJSONArray == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("UiApiPlugin", 2, "showPopupMenu: list is null");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("UiApiPlugin", 2, "showPopupMenu Exception: " + localException.getMessage());
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bleh = bleh.a(localActivity, localArrayList, new awbq(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_Bleh.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298811) - localActivity.getResources().getDimensionPixelSize(2131298807), localActivity.getResources().getDimensionPixelSize(2131298808));
      return;
      int n = 0;
      while (n < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(n);
        blek localblek = new blek();
        localblek.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localblek.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localblek.jdField_c_of_type_JavaLangString = localblek.jdField_a_of_type_JavaLangString;
        localblek.jdField_b_of_type_Int = 2130850878;
        localObject2 = ((JSONObject)localObject2).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(71.0F * f1));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = localException;
          localURLDrawableOptions.mFailedDrawable = localException;
          localblek.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        }
        localArrayList.add(localblek);
        n += 1;
      }
    }
  }
  
  void c()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizUiRefreshView != null) {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(null);
      }
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = this.mRuntime.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(this.mRuntime.a().getApplication(), 1, anvx.a(2131715212), 0).a();
      return;
    }
    if (this.jdField_b_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_b_of_type_AndroidAppProgressDialog = new ReportProgressDialog((Context)localObject1, 2131755829);
      this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
      this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2131559607);
      ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131372740)).setText(anvx.a(2131715214));
    }
    for (;;)
    {
      localObject2 = new File(AbsDownloader.getFilePath(paramString));
      if (!((File)localObject2).exists()) {
        break;
      }
      this.jdField_b_of_type_AndroidAppProgressDialog.dismiss();
      a((File)localObject2);
      return;
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
    }
    localObject1 = new Bundle();
    Object localObject2 = new bhyo(paramString, (File)localObject2);
    ((bhyo)localObject2).d = 60L;
    ((bhyq)this.mRuntime.a().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a((bhyo)localObject2, new awbv(this, paramString), (Bundle)localObject1);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Object localObject3 = this.mRuntime.a();
    if ((localObject3 == null) || (((Activity)localObject3).isFinishing())) {}
    while (paramJSONObject == null) {
      return;
    }
    Object localObject2 = paramJSONObject.optString("title");
    bifb localbifb;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localbifb = this.mRuntime.a(this.mRuntime.a());
      if ((localbifb != null) && ((localbifb instanceof bike))) {
        ((bike)localbifb).a((String)localObject2, this.mRuntime.a().hashCode());
      }
    }
    else
    {
      label97:
      paramJSONObject = paramJSONObject.optString("callback");
    }
    for (;;)
    {
      try
      {
        localObject3 = this.mRuntime.a();
        if (localObject3 == null) {
          break;
        }
        localObject2 = ((CustomWebView)localObject3).getPluginEngine();
        localObject3 = ((CustomWebView)localObject3).getUrl();
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          boolean bool = ((WebViewPluginEngine)localObject2).a().a((String)localObject3, "ui.setLeftCloseHandler");
          if (bool) {
            this.jdField_e_of_type_JavaLangString = paramJSONObject;
          }
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, new Object[] { "setLeftCloseHandler url:", localObject3, " hasRight:", Boolean.valueOf(bool) });
          }
        }
        localObject2 = new HashMap(2);
        if (localObject3 != null) {
          break label417;
        }
        paramJSONObject = (JSONObject)localObject1;
      }
      catch (Exception paramJSONObject)
      {
        label247:
        QLog.e("UiApiPlugin", 1, new Object[] { "e:", paramJSONObject.toString() });
        return;
      }
      ((HashMap)localObject2).put("host", localObject1);
      if (paramJSONObject == null)
      {
        paramJSONObject = "";
        ((HashMap)localObject2).put("path", paramJSONObject);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "actWvCloseHandle", true, 0L, 0L, (HashMap)localObject2, null);
        return;
        if ((localbifb != null) && ((localbifb instanceof bikb)))
        {
          ((bikb)localbifb).a((String)localObject2);
          break label97;
        }
        if ((localbifb instanceof WebViewFragment))
        {
          if (biit.a()) {
            break label97;
          }
          localObject3 = (WebViewFragment)localbifb;
          if ((((WebViewFragment)localObject3).mSwiftTitleUI == null) || (((WebViewFragment)localObject3).mSwiftTitleUI.leftView == null)) {
            break label97;
          }
          ((WebViewFragment)localObject3).mSwiftTitleUI.leftView.setText((CharSequence)localObject2);
          break label97;
        }
        localObject3 = (TextView)((Activity)localObject3).findViewById(2131369231);
        if (localObject3 == null) {
          break label97;
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        break label97;
        label417:
        paramJSONObject = Uri.parse((String)localObject3);
      }
      while (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.getHost();
        break;
        paramJSONObject = paramJSONObject.getPath();
        break label247;
      }
      localObject1 = "";
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bleh.isShowing()) {
      this.jdField_a_of_type_Bleh.dismiss();
    }
  }
  
  protected void d(String paramString)
  {
    String str;
    try
    {
      paramString = new JSONObject(paramString);
      str = paramString.optString("imageData");
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = AppConstants.SDCARD_PATH + "diskcache/Image_" + MD5Utils.toMD5(str);
        FileUtils.writeFile(bhcu.decode(str, 0), (String)localObject1);
        a(paramString, (String)localObject1, 0);
        return;
      }
      str = paramString.optString("imageUrl");
      localObject1 = this.mRuntime.a();
      if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        a(paramString, null, -2);
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("UiApiPlugin", 1, "mergeTextToImage exception e = ", paramString);
      return;
    }
    Object localObject2 = new File(AbsDownloader.getFilePath(str));
    if (((File)localObject2).exists())
    {
      a(paramString, AbsDownloader.getFilePath(str), 0);
      return;
    }
    Object localObject1 = new Bundle();
    localObject2 = new bhyo(str, (File)localObject2);
    ((bhyo)localObject2).d = 60L;
    ((bhyq)this.mRuntime.a().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a((bhyo)localObject2, new awbw(this, str, paramString), (Bundle)localObject1);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    Activity localActivity;
    WebViewFragment localWebViewFragment;
    String str1;
    String str2;
    String str3;
    int n;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (paramJSONObject != null)
    {
      localActivity = this.mRuntime.a();
      localWebViewFragment = this.mRuntime.a();
      if (localWebViewFragment == null) {
        break label509;
      }
      str1 = paramJSONObject.optString("iconID1");
      paramJSONObject.optString("schemeType1");
      str2 = paramJSONObject.optString("_sharedCallbackID1");
      str3 = paramJSONObject.optString("voiceStr1");
      n = paramJSONObject.optInt("cornerID1");
      localObject1 = paramJSONObject.optString("iconID2");
      paramJSONObject.optString("schemeType2");
      localObject2 = paramJSONObject.optString("_sharedCallbackID2");
      String str4 = paramJSONObject.optString("voiceStr2");
      int i1 = paramJSONObject.optInt("cornerID2");
      localWebViewFragment.mSwiftTitleUI.rightViewImg.setVisibility(0);
      paramJSONObject = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
      if ((paramJSONObject == null) || (!paramJSONObject.mUIStyle.isShowDefaultThemeIcon) || ("1000".equals(ThemeUtil.getCurrentThemeId()))) {
        break label391;
      }
      bool = true;
      this.jdField_e_of_type_Int = a((String)localObject1, bool);
      if (paramJSONObject == null) {
        break label397;
      }
      paramJSONObject.setDefaultThemeIcon(localWebViewFragment.mSwiftTitleUI.rightViewImg, false, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int);
      label200:
      localWebViewFragment.mSwiftTitleUI.rightViewImg.setContentDescription(str4);
      localWebViewFragment.mSwiftTitleUI.rightViewImg.setOnClickListener(new awbr(this, localActivity, (String)localObject1, (String)localObject2));
      a(localWebViewFragment.mSwiftTitleUI.rightViewImg, localWebViewFragment.mSwiftTitleUI.mRightCornerIcon, i1);
      localObject1 = (RelativeLayout)localActivity.findViewById(2131376760);
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        break label415;
      }
      ((RelativeLayout)localObject1).removeView(this.jdField_c_of_type_AndroidWidgetImageView);
      label288:
      this.jdField_d_of_type_Int = a(str1, bool);
      if (paramJSONObject == null) {
        break label495;
      }
      paramJSONObject.setDefaultThemeIcon(this.jdField_c_of_type_AndroidWidgetImageView, false, this.jdField_d_of_type_Int, this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(str3);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new awbs(this, localActivity, str1, str2));
      localWebViewFragment.mSwiftTitleUI.setConversationBtnVisible(false);
      ((RelativeLayout)localObject1).addView(this.jdField_c_of_type_AndroidWidgetImageView);
      a(this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_d_of_type_AndroidWidgetImageView, n);
      return;
      label391:
      bool = false;
      break;
      label397:
      localWebViewFragment.mSwiftTitleUI.rightViewImg.setImageResource(this.jdField_e_of_type_Int);
      break label200;
      label415:
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_c_of_type_AndroidWidgetImageView.setId(2131379025);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131376894);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = DisplayUtil.dip2px(localActivity.getApplicationContext(), 10.0F);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label288;
      label495:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(this.jdField_d_of_type_Int);
    }
    label509:
    QLog.e("UiApiPlugin", 1, "setDoubleRightButton, not support " + localActivity);
  }
  
  void e()
  {
    jdField_a_of_type_AndroidContentBroadcastReceiver = new awbz(this);
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "initExitWebViewReceiver!");
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE");
      BaseApplicationImpl.getApplication().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("UiApiPlugin", 1, "register receiver error:" + localException.toString());
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aady == null) {
      this.jdField_a_of_type_Aady = aady.a();
    }
    this.jdField_a_of_type_Aady.e();
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {
      this.jdField_e_of_type_JavaLangString = null;
    }
    label299:
    label613:
    do
    {
      int i1;
      do
      {
        int n;
        do
        {
          for (;;)
          {
            return false;
            if ((paramLong == 8589934597L) || (paramLong == 512L))
            {
              callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=true;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            else if ((paramLong == 2L) || (paramLong == 256L))
            {
              callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('qbrowserVisibilityChange');e.hidden=false;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            else if (paramLong == 16L)
            {
              this.jdField_e_of_type_JavaLangString = null;
            }
            else
            {
              if ((paramLong != 8589934601L) && (paramLong != 8589934602L)) {
                break;
              }
              if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
              {
                callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
                return true;
              }
              if ((this.mOpenApiListeners != null) && (this.mOpenApiListeners.containsKey("setLeftButton")))
              {
                callJs4OpenApiIfNeeded("setLeftButton", 0, "");
                return true;
              }
              if (paramLong == 8589934601L)
              {
                if (this.jdField_c_of_type_Int == -1)
                {
                  this.jdField_c_of_type_Int = 0;
                  paramString = this.mRuntime.a();
                  if ((paramString != null) && ((paramString instanceof QQBrowserActivity)))
                  {
                    Object localObject2 = paramString.getIntent();
                    localObject1 = a();
                    if ((localObject1 != null) && ((((bikl)localObject1).getRulesFromUrl() & 0x200000) == 0L) && (!((Intent)localObject2).getBooleanExtra("show_right_close_button", false)))
                    {
                      localObject2 = (TextView)paramString.findViewById(2131369262);
                      if ((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131690845).equals(((TextView)localObject2).getText()))) {
                        break label299;
                      }
                    }
                  }
                }
                while (this.jdField_c_of_type_Int == 0)
                {
                  return false;
                  if ((((bikl)localObject1).getRulesFromUrl() & 0x4) == 0L) {
                    this.jdField_c_of_type_Int = 1;
                  }
                }
                paramString = paramMap.get("target");
                if (!(paramString instanceof Integer)) {
                  return false;
                }
                n = ((Integer)paramString).intValue();
                if ((n != 1) && (n != 3)) {
                  return false;
                }
                paramString = this.mRuntime.a();
                if (paramString != null)
                {
                  n = paramString.copyBackForwardList().getCurrentIndex();
                  if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "web history current index:" + n);
                  }
                  if (n > 1) {
                    a(true);
                  } else {
                    a(false);
                  }
                }
              }
            }
          }
          if (paramLong != 8589934600L) {
            break;
          }
          n = ((Integer)paramMap.get("requestCode")).intValue();
          i1 = ((Integer)paramMap.get("resultCode")).intValue();
          if (n == 14) {
            for (;;)
            {
              try
              {
                localObject1 = new JSONObject();
                paramString = "";
                if (i1 == -1) {
                  paramString = ((Intent)paramMap.get("data")).getStringExtra("data");
                }
                if (!TextUtils.isEmpty(paramString)) {
                  break label613;
                }
                ((JSONObject)localObject1).put("result", -2);
                ((JSONObject)localObject1).put("data", "");
                callJs(this.jdField_h_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
              }
              catch (Exception paramString)
              {
                callJs(this.jdField_h_of_type_JavaLangString, new String[] { "" });
                QLog.e("UiApiPlugin", 1, "mOpenCustomWebViewCallback call back exception e = ", paramString);
              }
              break;
              ((JSONObject)localObject1).put("result", 0);
              ((JSONObject)localObject1).put("data", paramString);
            }
          }
        } while (n != 18);
        paramString = this.mRuntime.a();
      } while ((i1 != -1) || (paramString == null) || (paramString.isFinishing()));
      Object localObject1 = AIOUtils.setOpenAIOIntent(new Intent(paramString, SplashActivity.class), null);
      paramMap = (Intent)paramMap.get("data");
      if (paramMap != null)
      {
        ((Intent)localObject1).putExtras(new Bundle(paramMap.getExtras()));
        paramString.startActivity((Intent)localObject1);
      }
      return true;
    } while ((paramLong != 8589934615L) || (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)));
    callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
    return true;
  }
  
  /* Error */
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 100
    //   2: aload_3
    //   3: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +17435 -> 17441
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 2673	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 2675
    //   19: aload 4
    //   21: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +199 -> 223
    //   27: aload 5
    //   29: arraylength
    //   30: ifle +193 -> 223
    //   33: new 113	org/json/JSONObject
    //   36: dup
    //   37: aload 5
    //   39: iconst_0
    //   40: aaload
    //   41: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   50: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 2677
    //   60: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 2679
    //   69: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload 5
    //   75: ldc 154
    //   77: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload 5
    //   83: ldc_w 809
    //   86: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 5
    //   91: aload 4
    //   93: ifnull +91 -> 184
    //   96: aload_1
    //   97: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   100: ifeq +84 -> 184
    //   103: aload_2
    //   104: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   107: ifeq +77 -> 184
    //   110: new 129	android/content/Intent
    //   113: dup
    //   114: aload 4
    //   116: ldc_w 2686
    //   119: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc_w 2083
    //   129: aload_1
    //   130: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload 4
    //   136: ldc_w 2679
    //   139: aload_2
    //   140: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: ldc_w 2688
    //   147: aload_3
    //   148: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +25 -> 176
    //   154: aload 4
    //   156: ldc_w 2690
    //   159: bipush 8
    //   161: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   164: pop
    //   165: aload 4
    //   167: ldc_w 809
    //   170: aload 5
    //   172: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   175: pop
    //   176: aload_0
    //   177: aload 4
    //   179: bipush 9
    //   181: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_1
    //   187: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq -6 -> 184
    //   193: ldc_w 2692
    //   196: iconst_2
    //   197: new 549	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 2694
    //   207: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -36 -> 184
    //   223: ldc_w 2696
    //   226: aload 4
    //   228: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +164 -> 395
    //   234: aload 5
    //   236: arraylength
    //   237: ifle +158 -> 395
    //   240: new 113	org/json/JSONObject
    //   243: dup
    //   244: aload 5
    //   246: iconst_0
    //   247: aaload
    //   248: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   251: astore_2
    //   252: aload_2
    //   253: ldc_w 600
    //   256: invokevirtual 2699	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 10
    //   261: aload_2
    //   262: ldc_w 2701
    //   265: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: istore 6
    //   270: aload_2
    //   271: ldc_w 2703
    //   274: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_2
    //   279: ldc_w 809
    //   282: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   290: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   293: new 549	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   300: lload 10
    //   302: invokevirtual 559	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 482
    //   308: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: bipush 9
    //   316: invokestatic 2708	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   319: astore_3
    //   320: aload_3
    //   321: ldc_w 2710
    //   324: aload_1
    //   325: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 2712
    //   333: iload 6
    //   335: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_3
    //   340: ldc_w 809
    //   343: aload_2
    //   344: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   347: pop
    //   348: aload_0
    //   349: aload_3
    //   350: bipush 8
    //   352: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   355: goto -171 -> 184
    //   358: astore_1
    //   359: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -178 -> 184
    //   365: ldc_w 2692
    //   368: iconst_2
    //   369: new 549	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2714
    //   379: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -208 -> 184
    //   395: ldc_w 2716
    //   398: aload 4
    //   400: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq +28 -> 431
    //   406: aload 5
    //   408: arraylength
    //   409: ifle +22 -> 431
    //   412: aload_0
    //   413: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   416: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   419: invokevirtual 1680	com/tencent/biz/pubaccount/CustomWebView:getContext	()Landroid/content/Context;
    //   422: aload 5
    //   424: iconst_0
    //   425: aaload
    //   426: invokestatic 2718	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   429: iconst_1
    //   430: ireturn
    //   431: ldc_w 2720
    //   434: aload 4
    //   436: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   439: ifeq +109 -> 548
    //   442: new 113	org/json/JSONObject
    //   445: dup
    //   446: aload 5
    //   448: iconst_0
    //   449: aaload
    //   450: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   453: ldc_w 2722
    //   456: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   459: astore_1
    //   460: aload_1
    //   461: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   464: ifeq +5 -> 469
    //   467: iconst_1
    //   468: ireturn
    //   469: aload_0
    //   470: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   473: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   476: astore_2
    //   477: new 129	android/content/Intent
    //   480: dup
    //   481: aload_2
    //   482: ldc_w 2654
    //   485: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   488: aconst_null
    //   489: invokestatic 2660	com/tencent/mobileqq/activity/aio/AIOUtils:setOpenAIOIntent	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   492: astore_3
    //   493: aload_3
    //   494: ldc_w 2724
    //   497: aload_1
    //   498: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   501: pop
    //   502: aload_3
    //   503: ldc_w 460
    //   506: iconst_1
    //   507: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   510: pop
    //   511: aload_3
    //   512: ldc_w 2726
    //   515: iconst_1
    //   516: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   519: pop
    //   520: aload_2
    //   521: aload_3
    //   522: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   525: goto -341 -> 184
    //   528: astore_1
    //   529: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -348 -> 184
    //   535: ldc 209
    //   537: iconst_2
    //   538: ldc_w 2728
    //   541: aload_1
    //   542: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -361 -> 184
    //   548: ldc_w 2732
    //   551: aload 4
    //   553: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   556: ifeq +231 -> 787
    //   559: new 113	org/json/JSONObject
    //   562: dup
    //   563: aload 5
    //   565: iconst_0
    //   566: aaload
    //   567: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   570: astore_3
    //   571: aload_3
    //   572: ldc_w 2722
    //   575: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   578: astore 4
    //   580: aload 4
    //   582: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifeq +5 -> 590
    //   588: iconst_1
    //   589: ireturn
    //   590: aload_3
    //   591: ldc_w 2734
    //   594: ldc_w 2735
    //   597: invokestatic 2335	anvx:a	(I)Ljava/lang/String;
    //   600: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   603: astore 5
    //   605: aload_3
    //   606: ldc_w 2737
    //   609: ldc_w 2739
    //   612: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: astore 14
    //   617: aload_0
    //   618: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   621: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   624: astore_1
    //   625: new 129	android/content/Intent
    //   628: dup
    //   629: aload_1
    //   630: ldc_w 2654
    //   633: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   636: aconst_null
    //   637: invokestatic 2660	com/tencent/mobileqq/activity/aio/AIOUtils:setOpenAIOIntent	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   640: astore_2
    //   641: aload_2
    //   642: ldc_w 2724
    //   645: aload 4
    //   647: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   650: pop
    //   651: aload_2
    //   652: ldc_w 460
    //   655: iconst_1
    //   656: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   659: pop
    //   660: aload_2
    //   661: ldc_w 2734
    //   664: aload 5
    //   666: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   669: pop
    //   670: aload_2
    //   671: ldc_w 2737
    //   674: aload 14
    //   676: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   679: pop
    //   680: aload_3
    //   681: ldc 174
    //   683: iconst_0
    //   684: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   687: istore 6
    //   689: iload 6
    //   691: iconst_1
    //   692: if_icmpne +65 -> 757
    //   695: aload_3
    //   696: ldc_w 2741
    //   699: invokevirtual 1037	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   702: astore_3
    //   703: aload_3
    //   704: ifnull +15 -> 719
    //   707: aload_2
    //   708: ldc_w 2743
    //   711: aload_3
    //   712: invokevirtual 1081	org/json/JSONArray:toString	()Ljava/lang/String;
    //   715: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   718: pop
    //   719: aload_2
    //   720: ldc_w 2745
    //   723: iload 6
    //   725: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   728: pop
    //   729: aload_1
    //   730: aload_2
    //   731: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   734: goto -550 -> 184
    //   737: astore_1
    //   738: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   741: ifeq -557 -> 184
    //   744: ldc 209
    //   746: iconst_2
    //   747: ldc_w 2747
    //   750: aload_1
    //   751: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   754: goto -570 -> 184
    //   757: iload 6
    //   759: iconst_2
    //   760: if_icmpne -41 -> 719
    //   763: aload_2
    //   764: ldc_w 2749
    //   767: aload_3
    //   768: ldc_w 2741
    //   771: ldc_w 2750
    //   774: invokestatic 2335	anvx:a	(I)Ljava/lang/String;
    //   777: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   780: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   783: pop
    //   784: goto -65 -> 719
    //   787: ldc_w 2752
    //   790: aload 4
    //   792: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifeq +50 -> 845
    //   798: new 113	org/json/JSONObject
    //   801: dup
    //   802: aload 5
    //   804: iconst_0
    //   805: aaload
    //   806: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   809: ldc_w 799
    //   812: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   815: astore_1
    //   816: aload_1
    //   817: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   820: ifne -636 -> 184
    //   823: aload_0
    //   824: aload_0
    //   825: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   828: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   831: aload_1
    //   832: invokestatic 2757	awuc:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   835: putfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   838: goto -654 -> 184
    //   841: astore_1
    //   842: goto -658 -> 184
    //   845: ldc_w 2761
    //   848: aload 4
    //   850: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   853: ifeq +52 -> 905
    //   856: aload_0
    //   857: getfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   860: ifnull -676 -> 184
    //   863: aload_0
    //   864: getfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   867: invokevirtual 2762	android/app/ProgressDialog:isShowing	()Z
    //   870: ifeq -686 -> 184
    //   873: aload_0
    //   874: getfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   877: invokevirtual 2370	android/app/ProgressDialog:dismiss	()V
    //   880: aload_0
    //   881: aconst_null
    //   882: putfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   885: goto -701 -> 184
    //   888: astore_1
    //   889: aload_0
    //   890: aconst_null
    //   891: putfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   894: goto -710 -> 184
    //   897: astore_1
    //   898: aload_0
    //   899: aconst_null
    //   900: putfield 2759	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   903: aload_1
    //   904: athrow
    //   905: ldc_w 2764
    //   908: aload 4
    //   910: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   913: ifeq +83 -> 996
    //   916: aload 5
    //   918: arraylength
    //   919: iconst_1
    //   920: if_icmpne -736 -> 184
    //   923: aload_1
    //   924: getfield 2767	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   927: ifeq +36 -> 963
    //   930: aload_0
    //   931: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   934: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   937: aload_0
    //   938: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   941: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   944: aload_0
    //   945: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   948: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   951: aload 5
    //   953: iconst_0
    //   954: aaload
    //   955: iconst_1
    //   956: iconst_0
    //   957: invokestatic 2769	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   960: goto -776 -> 184
    //   963: aload_0
    //   964: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   967: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   970: aload_0
    //   971: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   974: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   977: aload_0
    //   978: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   981: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   984: aload 5
    //   986: iconst_0
    //   987: aaload
    //   988: iconst_0
    //   989: iconst_0
    //   990: invokestatic 2769	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   993: goto -809 -> 184
    //   996: ldc_w 2771
    //   999: aload 4
    //   1001: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1004: ifeq +118 -> 1122
    //   1007: aload_0
    //   1008: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1011: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1014: instanceof 2773
    //   1017: ifeq +26 -> 1043
    //   1020: aload_1
    //   1021: aload_0
    //   1022: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1025: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1028: checkcast 2773	mqq/app/AppActivity
    //   1031: invokevirtual 2776	mqq/app/AppActivity:isResume	()Z
    //   1034: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1037: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1040: goto -856 -> 184
    //   1043: aload_0
    //   1044: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1047: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1050: instanceof 2781
    //   1053: ifeq +26 -> 1079
    //   1056: aload_1
    //   1057: aload_0
    //   1058: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1061: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1064: checkcast 2781	cooperation/qwallet/plugin/QWalletPluginProxyActivity
    //   1067: invokevirtual 2782	cooperation/qwallet/plugin/QWalletPluginProxyActivity:isResume	()Z
    //   1070: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1073: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1076: goto -892 -> 184
    //   1079: aload_0
    //   1080: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1083: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1086: ifnonnull +25 -> 1111
    //   1089: invokestatic 2785	avxi:a	()Z
    //   1092: ifne +19 -> 1111
    //   1095: aload_1
    //   1096: invokestatic 2790	avxo:a	()Lavxo;
    //   1099: invokevirtual 2791	avxo:a	()Z
    //   1102: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1105: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1108: goto -924 -> 184
    //   1111: aload_1
    //   1112: iconst_0
    //   1113: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1116: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1119: goto -935 -> 184
    //   1122: ldc_w 2793
    //   1125: aload 4
    //   1127: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1130: ifeq +50 -> 1180
    //   1133: aload 5
    //   1135: arraylength
    //   1136: iconst_1
    //   1137: if_icmpne +43 -> 1180
    //   1140: aload_0
    //   1141: new 113	org/json/JSONObject
    //   1144: dup
    //   1145: aload 5
    //   1147: iconst_0
    //   1148: aaload
    //   1149: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1152: aload_1
    //   1153: aconst_null
    //   1154: invokevirtual 1743	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Landroid/view/View$OnClickListener;)V
    //   1157: goto -973 -> 184
    //   1160: astore_1
    //   1161: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1164: ifeq -980 -> 184
    //   1167: ldc 209
    //   1169: iconst_2
    //   1170: ldc_w 2795
    //   1173: aload_1
    //   1174: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1177: goto -993 -> 184
    //   1180: ldc_w 2797
    //   1183: aload 4
    //   1185: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1188: ifeq +119 -> 1307
    //   1191: aload 5
    //   1193: arraylength
    //   1194: iconst_1
    //   1195: if_icmpne +112 -> 1307
    //   1198: aload_0
    //   1199: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1202: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1205: astore_2
    //   1206: aload_2
    //   1207: ifnull +16289 -> 17496
    //   1210: aload_2
    //   1211: invokevirtual 797	android/app/Activity:isFinishing	()Z
    //   1214: ifeq +6 -> 1220
    //   1217: goto +16279 -> 17496
    //   1220: new 113	org/json/JSONObject
    //   1223: dup
    //   1224: aload 5
    //   1226: iconst_0
    //   1227: aaload
    //   1228: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1231: astore_2
    //   1232: aload_0
    //   1233: aload_2
    //   1234: ldc_w 2799
    //   1237: invokevirtual 423	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1240: invokevirtual 2801	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1243: aload_0
    //   1244: aload_2
    //   1245: ldc_w 2803
    //   1248: invokevirtual 423	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1251: aload_1
    //   1252: invokevirtual 2805	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1255: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1258: ifeq -1074 -> 184
    //   1261: ldc 209
    //   1263: iconst_2
    //   1264: iconst_2
    //   1265: anewarray 277	java/lang/Object
    //   1268: dup
    //   1269: iconst_0
    //   1270: ldc_w 2797
    //   1273: aastore
    //   1274: dup
    //   1275: iconst_1
    //   1276: aload_2
    //   1277: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1280: aastore
    //   1281: invokestatic 2429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1284: goto -1100 -> 184
    //   1287: astore_1
    //   1288: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1291: ifeq -1107 -> 184
    //   1294: ldc 209
    //   1296: iconst_2
    //   1297: ldc_w 2807
    //   1300: aload_1
    //   1301: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1304: goto -1120 -> 184
    //   1307: ldc_w 2808
    //   1310: aload 4
    //   1312: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1315: ifeq +71 -> 1386
    //   1318: aload 5
    //   1320: arraylength
    //   1321: iconst_1
    //   1322: if_icmpne +64 -> 1386
    //   1325: aload_0
    //   1326: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1329: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1332: astore_2
    //   1333: aload_2
    //   1334: ifnull +16164 -> 17498
    //   1337: aload_2
    //   1338: invokevirtual 797	android/app/Activity:isFinishing	()Z
    //   1341: ifeq +6 -> 1347
    //   1344: goto +16154 -> 17498
    //   1347: aload_0
    //   1348: new 113	org/json/JSONObject
    //   1351: dup
    //   1352: aload 5
    //   1354: iconst_0
    //   1355: aaload
    //   1356: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1359: aload_1
    //   1360: invokevirtual 2805	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1363: goto -1179 -> 184
    //   1366: astore_1
    //   1367: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -1186 -> 184
    //   1373: ldc 209
    //   1375: iconst_2
    //   1376: ldc_w 2810
    //   1379: aload_1
    //   1380: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1383: goto -1199 -> 184
    //   1386: ldc_w 2812
    //   1389: aload 4
    //   1391: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1394: ifeq +109 -> 1503
    //   1397: aload 5
    //   1399: arraylength
    //   1400: iconst_1
    //   1401: if_icmpne +102 -> 1503
    //   1404: aload_0
    //   1405: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1408: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1411: astore_1
    //   1412: aload_1
    //   1413: ifnull +16087 -> 17500
    //   1416: aload_1
    //   1417: invokevirtual 797	android/app/Activity:isFinishing	()Z
    //   1420: ifeq +6 -> 1426
    //   1423: goto +16077 -> 17500
    //   1426: new 113	org/json/JSONObject
    //   1429: dup
    //   1430: aload 5
    //   1432: iconst_0
    //   1433: aaload
    //   1434: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1437: astore_1
    //   1438: aload_1
    //   1439: ldc_w 2814
    //   1442: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1445: istore 6
    //   1447: aload_1
    //   1448: ldc_w 2816
    //   1451: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1454: istore 12
    //   1456: aload_1
    //   1457: ldc_w 809
    //   1460: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1463: astore_2
    //   1464: aload_0
    //   1465: iload 6
    //   1467: iload 12
    //   1469: aload_1
    //   1470: ldc_w 2818
    //   1473: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1476: aload_2
    //   1477: invokevirtual 2820	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1480: goto -1296 -> 184
    //   1483: astore_1
    //   1484: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1487: ifeq -1303 -> 184
    //   1490: ldc 209
    //   1492: iconst_2
    //   1493: ldc_w 2810
    //   1496: aload_1
    //   1497: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1500: goto -1316 -> 184
    //   1503: ldc_w 2602
    //   1506: aload 4
    //   1508: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1511: ifeq +70 -> 1581
    //   1514: aload 5
    //   1516: arraylength
    //   1517: iconst_1
    //   1518: if_icmpne +63 -> 1581
    //   1521: aload_0
    //   1522: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1525: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1528: astore_1
    //   1529: aload_1
    //   1530: ifnull +15972 -> 17502
    //   1533: aload_1
    //   1534: invokevirtual 797	android/app/Activity:isFinishing	()Z
    //   1537: ifeq +6 -> 1543
    //   1540: goto +15962 -> 17502
    //   1543: aload_0
    //   1544: new 113	org/json/JSONObject
    //   1547: dup
    //   1548: aload 5
    //   1550: iconst_0
    //   1551: aaload
    //   1552: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1555: invokevirtual 2801	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1558: goto -1374 -> 184
    //   1561: astore_1
    //   1562: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq -1381 -> 184
    //   1568: ldc 209
    //   1570: iconst_2
    //   1571: ldc_w 2822
    //   1574: aload_1
    //   1575: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1578: goto -1394 -> 184
    //   1581: ldc_w 2824
    //   1584: aload 4
    //   1586: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1589: ifeq +83 -> 1672
    //   1592: aload 5
    //   1594: arraylength
    //   1595: iconst_1
    //   1596: if_icmpne +76 -> 1672
    //   1599: aload_0
    //   1600: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1603: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1606: astore_1
    //   1607: aload_1
    //   1608: ifnull +15896 -> 17504
    //   1611: aload_1
    //   1612: invokevirtual 797	android/app/Activity:isFinishing	()Z
    //   1615: ifeq +6 -> 1621
    //   1618: goto +15886 -> 17504
    //   1621: aload_0
    //   1622: new 113	org/json/JSONObject
    //   1625: dup
    //   1626: aload 5
    //   1628: iconst_0
    //   1629: aaload
    //   1630: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1633: invokevirtual 2826	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1636: goto -1452 -> 184
    //   1639: astore_1
    //   1640: ldc 209
    //   1642: iconst_1
    //   1643: new 549	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   1650: ldc_w 2828
    //   1653: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: aload_1
    //   1657: invokestatic 2831	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1660: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1666: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1669: goto -1485 -> 184
    //   1672: ldc_w 1398
    //   1675: aload 4
    //   1677: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1680: ifeq +21 -> 1701
    //   1683: aload 5
    //   1685: arraylength
    //   1686: iconst_1
    //   1687: if_icmpne +14 -> 1701
    //   1690: aload_0
    //   1691: aload 5
    //   1693: iconst_0
    //   1694: aaload
    //   1695: invokevirtual 2832	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1698: goto -1514 -> 184
    //   1701: ldc_w 2834
    //   1704: aload 4
    //   1706: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1709: ifeq +174 -> 1883
    //   1712: aload 5
    //   1714: arraylength
    //   1715: iconst_1
    //   1716: if_icmpne +167 -> 1883
    //   1719: new 113	org/json/JSONObject
    //   1722: dup
    //   1723: aload 5
    //   1725: iconst_0
    //   1726: aaload
    //   1727: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1730: astore_2
    //   1731: aload_2
    //   1732: ldc_w 2836
    //   1735: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1738: astore_1
    //   1739: aload_0
    //   1740: aload_2
    //   1741: ldc_w 809
    //   1744: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1747: putfield 2837	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1750: aload_0
    //   1751: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1754: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1757: ifnonnull +5 -> 1762
    //   1760: iconst_1
    //   1761: ireturn
    //   1762: aload_0
    //   1763: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1766: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1769: invokevirtual 261	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1772: astore_2
    //   1773: new 129	android/content/Intent
    //   1776: dup
    //   1777: aload_0
    //   1778: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1781: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1784: ldc_w 2839
    //   1787: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1790: ldc 154
    //   1792: ldc_w 772
    //   1795: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1798: astore_3
    //   1799: aload_1
    //   1800: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1803: ifeq +48 -> 1851
    //   1806: aload_0
    //   1807: getfield 2837	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1810: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1813: ifeq +38 -> 1851
    //   1816: aload_3
    //   1817: ldc_w 2841
    //   1820: iconst_1
    //   1821: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1824: pop
    //   1825: aload_0
    //   1826: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1829: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1832: ifnonnull +5 -> 1837
    //   1835: iconst_1
    //   1836: ireturn
    //   1837: aload_0
    //   1838: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1841: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1844: aload_3
    //   1845: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1848: goto -1664 -> 184
    //   1851: aload_3
    //   1852: ldc_w 2836
    //   1855: aload_1
    //   1856: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1859: ldc_w 2843
    //   1862: aload_2
    //   1863: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1866: ldc_w 2845
    //   1869: iconst_1
    //   1870: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1873: pop
    //   1874: aload_0
    //   1875: aload_3
    //   1876: iconst_3
    //   1877: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1880: goto -1696 -> 184
    //   1883: ldc_w 2847
    //   1886: aload 4
    //   1888: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1891: ifeq +243 -> 2134
    //   1894: aload 5
    //   1896: arraylength
    //   1897: iconst_1
    //   1898: if_icmpne +236 -> 2134
    //   1901: new 113	org/json/JSONObject
    //   1904: dup
    //   1905: aload 5
    //   1907: iconst_0
    //   1908: aaload
    //   1909: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1912: astore 4
    //   1914: aload 4
    //   1916: ldc_w 2836
    //   1919: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1922: astore_1
    //   1923: aload 4
    //   1925: ldc_w 928
    //   1928: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1931: astore_2
    //   1932: aload 4
    //   1934: ldc 174
    //   1936: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1939: astore_3
    //   1940: aload_0
    //   1941: aload 4
    //   1943: ldc_w 809
    //   1946: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1949: putfield 2849	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1952: aload_0
    //   1953: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1956: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1959: ifnonnull +5 -> 1964
    //   1962: iconst_1
    //   1963: ireturn
    //   1964: aload_0
    //   1965: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1968: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1971: invokevirtual 261	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1974: astore 4
    //   1976: new 129	android/content/Intent
    //   1979: dup
    //   1980: aload_0
    //   1981: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   1984: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   1987: ldc_w 2851
    //   1990: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1993: ldc_w 2853
    //   1996: iconst_4
    //   1997: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2000: ldc_w 2854
    //   2003: invokevirtual 588	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2006: astore 5
    //   2008: aload_1
    //   2009: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2012: ifeq +73 -> 2085
    //   2015: aload_0
    //   2016: getfield 2849	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2019: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2022: ifeq +63 -> 2085
    //   2025: aload_0
    //   2026: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2029: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2032: ifnonnull +5 -> 2037
    //   2035: iconst_1
    //   2036: ireturn
    //   2037: aload_0
    //   2038: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2041: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2044: aload 5
    //   2046: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2049: goto -1865 -> 184
    //   2052: astore_1
    //   2053: ldc 209
    //   2055: iconst_1
    //   2056: new 549	java/lang/StringBuilder
    //   2059: dup
    //   2060: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   2063: ldc_w 2856
    //   2066: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: aload_1
    //   2070: invokevirtual 921	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2073: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2079: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2082: goto -1898 -> 184
    //   2085: aload 5
    //   2087: ldc_w 2836
    //   2090: aload_1
    //   2091: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2094: ldc 174
    //   2096: aload_3
    //   2097: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2100: ldc_w 928
    //   2103: aload_2
    //   2104: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2107: ldc_w 2843
    //   2110: aload 4
    //   2112: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2115: ldc_w 2845
    //   2118: iconst_1
    //   2119: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2122: pop
    //   2123: aload_0
    //   2124: aload 5
    //   2126: bipush 17
    //   2128: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2131: goto -1947 -> 184
    //   2134: ldc_w 2858
    //   2137: aload 4
    //   2139: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2142: ifeq +102 -> 2244
    //   2145: aload 5
    //   2147: arraylength
    //   2148: iconst_1
    //   2149: if_icmpne +95 -> 2244
    //   2152: new 113	org/json/JSONObject
    //   2155: dup
    //   2156: aload 5
    //   2158: iconst_0
    //   2159: aaload
    //   2160: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2163: ldc_w 809
    //   2166: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2169: astore_1
    //   2170: aload_0
    //   2171: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2174: aload_0
    //   2175: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2178: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2181: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2184: astore_2
    //   2185: aload_2
    //   2186: ifnull +23 -> 2209
    //   2189: aload_2
    //   2190: instanceof 2171
    //   2193: ifeq +16 -> 2209
    //   2196: aload_2
    //   2197: checkcast 2171	biki
    //   2200: invokeinterface 2175 1 0
    //   2205: aload_1
    //   2206: putfield 2861	aasr:v	Ljava/lang/String;
    //   2209: aload_1
    //   2210: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2213: ifne -2029 -> 184
    //   2216: aload_0
    //   2217: iconst_2
    //   2218: invokevirtual 2862	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2221: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   2224: astore_1
    //   2225: aload_1
    //   2226: ifnull -2042 -> 184
    //   2229: aload_1
    //   2230: invokevirtual 2865	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setAddShortcutBtnVisible	()V
    //   2233: goto -2049 -> 184
    //   2236: astore_1
    //   2237: aload_1
    //   2238: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2241: goto -2057 -> 184
    //   2244: ldc_w 2868
    //   2247: aload 4
    //   2249: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2252: ifeq +42 -> 2294
    //   2255: aload 5
    //   2257: arraylength
    //   2258: iconst_1
    //   2259: if_icmpne +35 -> 2294
    //   2262: aload_0
    //   2263: new 113	org/json/JSONObject
    //   2266: dup
    //   2267: aload 5
    //   2269: iconst_0
    //   2270: aaload
    //   2271: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2274: ldc_w 809
    //   2277: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2280: putfield 2422	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2283: goto -2099 -> 184
    //   2286: astore_1
    //   2287: aload_1
    //   2288: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2291: goto -2107 -> 184
    //   2294: ldc_w 2870
    //   2297: aload 4
    //   2299: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2302: ifeq +78 -> 2380
    //   2305: aload 5
    //   2307: arraylength
    //   2308: iconst_1
    //   2309: if_icmpne +71 -> 2380
    //   2312: new 113	org/json/JSONObject
    //   2315: dup
    //   2316: aload 5
    //   2318: iconst_0
    //   2319: aaload
    //   2320: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2323: ldc_w 809
    //   2326: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2329: astore_1
    //   2330: aload_0
    //   2331: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2334: aload_0
    //   2335: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2338: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2341: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2344: astore_2
    //   2345: aload_2
    //   2346: ifnull -2162 -> 184
    //   2349: aload_2
    //   2350: instanceof 2171
    //   2353: ifeq -2169 -> 184
    //   2356: aload_2
    //   2357: checkcast 2171	biki
    //   2360: invokeinterface 2175 1 0
    //   2365: aload_1
    //   2366: invokevirtual 2871	aasr:a	(Ljava/lang/String;)V
    //   2369: goto -2185 -> 184
    //   2372: astore_1
    //   2373: aload_1
    //   2374: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2377: goto -2193 -> 184
    //   2380: ldc_w 2873
    //   2383: aload 4
    //   2385: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2388: ifeq +111 -> 2499
    //   2391: aload 5
    //   2393: arraylength
    //   2394: iconst_1
    //   2395: if_icmpne +104 -> 2499
    //   2398: new 113	org/json/JSONObject
    //   2401: dup
    //   2402: aload 5
    //   2404: iconst_0
    //   2405: aaload
    //   2406: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2409: ldc_w 809
    //   2412: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2415: astore_1
    //   2416: aload_0
    //   2417: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2420: aload_0
    //   2421: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2424: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2427: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2430: astore_2
    //   2431: aload_2
    //   2432: ifnull +23 -> 2455
    //   2435: aload_2
    //   2436: instanceof 2171
    //   2439: ifeq +16 -> 2455
    //   2442: aload_2
    //   2443: checkcast 2171	biki
    //   2446: invokeinterface 2175 1 0
    //   2451: aload_1
    //   2452: putfield 2875	aasr:q	Ljava/lang/String;
    //   2455: aconst_null
    //   2456: ldc_w 768
    //   2459: ldc_w 2877
    //   2462: ldc_w 482
    //   2465: ldc_w 2879
    //   2468: ldc_w 2879
    //   2471: iconst_0
    //   2472: iconst_0
    //   2473: ldc_w 482
    //   2476: ldc_w 482
    //   2479: ldc_w 482
    //   2482: ldc_w 482
    //   2485: invokestatic 1537	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2488: goto -2304 -> 184
    //   2491: astore_1
    //   2492: aload_1
    //   2493: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2496: goto -41 -> 2455
    //   2499: ldc_w 2881
    //   2502: aload 4
    //   2504: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2507: ifeq +78 -> 2585
    //   2510: aload 5
    //   2512: arraylength
    //   2513: iconst_1
    //   2514: if_icmpne +71 -> 2585
    //   2517: new 113	org/json/JSONObject
    //   2520: dup
    //   2521: aload 5
    //   2523: iconst_0
    //   2524: aaload
    //   2525: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2528: ldc_w 809
    //   2531: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2534: astore_1
    //   2535: aload_0
    //   2536: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2539: aload_0
    //   2540: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2543: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2546: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2549: astore_2
    //   2550: aload_2
    //   2551: ifnull -2367 -> 184
    //   2554: aload_2
    //   2555: instanceof 2171
    //   2558: ifeq -2374 -> 184
    //   2561: aload_2
    //   2562: checkcast 2171	biki
    //   2565: invokeinterface 2175 1 0
    //   2570: aload_1
    //   2571: putfield 2884	aasr:r	Ljava/lang/String;
    //   2574: goto -2390 -> 184
    //   2577: astore_1
    //   2578: aload_1
    //   2579: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2582: goto -2398 -> 184
    //   2585: ldc_w 2886
    //   2588: aload 4
    //   2590: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2593: ifeq +111 -> 2704
    //   2596: aload 5
    //   2598: arraylength
    //   2599: iconst_1
    //   2600: if_icmpne +104 -> 2704
    //   2603: new 113	org/json/JSONObject
    //   2606: dup
    //   2607: aload 5
    //   2609: iconst_0
    //   2610: aaload
    //   2611: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2614: ldc_w 809
    //   2617: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2620: astore_1
    //   2621: aload_0
    //   2622: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2625: aload_0
    //   2626: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2629: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2632: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2635: astore_2
    //   2636: aload_2
    //   2637: ifnull +23 -> 2660
    //   2640: aload_2
    //   2641: instanceof 2171
    //   2644: ifeq +16 -> 2660
    //   2647: aload_2
    //   2648: checkcast 2171	biki
    //   2651: invokeinterface 2175 1 0
    //   2656: aload_1
    //   2657: putfield 2889	aasr:s	Ljava/lang/String;
    //   2660: aconst_null
    //   2661: ldc_w 768
    //   2664: ldc_w 2877
    //   2667: ldc_w 482
    //   2670: ldc_w 2891
    //   2673: ldc_w 2891
    //   2676: iconst_0
    //   2677: iconst_0
    //   2678: ldc_w 482
    //   2681: ldc_w 482
    //   2684: ldc_w 482
    //   2687: ldc_w 482
    //   2690: invokestatic 1537	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2693: goto -2509 -> 184
    //   2696: astore_1
    //   2697: aload_1
    //   2698: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2701: goto -41 -> 2660
    //   2704: ldc_w 2893
    //   2707: aload 4
    //   2709: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2712: ifeq +111 -> 2823
    //   2715: aload 5
    //   2717: arraylength
    //   2718: iconst_1
    //   2719: if_icmpne +104 -> 2823
    //   2722: new 113	org/json/JSONObject
    //   2725: dup
    //   2726: aload 5
    //   2728: iconst_0
    //   2729: aaload
    //   2730: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2733: ldc_w 809
    //   2736: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2739: astore_1
    //   2740: aload_0
    //   2741: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2744: aload_0
    //   2745: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2748: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2751: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2754: astore_2
    //   2755: aload_2
    //   2756: ifnull +23 -> 2779
    //   2759: aload_2
    //   2760: instanceof 2171
    //   2763: ifeq +16 -> 2779
    //   2766: aload_2
    //   2767: checkcast 2171	biki
    //   2770: invokeinterface 2175 1 0
    //   2775: aload_1
    //   2776: putfield 2896	aasr:t	Ljava/lang/String;
    //   2779: aconst_null
    //   2780: ldc_w 768
    //   2783: ldc_w 2877
    //   2786: ldc_w 482
    //   2789: ldc_w 2898
    //   2792: ldc_w 2898
    //   2795: iconst_0
    //   2796: iconst_0
    //   2797: ldc_w 482
    //   2800: ldc_w 482
    //   2803: ldc_w 482
    //   2806: ldc_w 482
    //   2809: invokestatic 1537	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2812: goto -2628 -> 184
    //   2815: astore_1
    //   2816: aload_1
    //   2817: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2820: goto -41 -> 2779
    //   2823: ldc_w 2900
    //   2826: aload 4
    //   2828: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2831: ifeq +111 -> 2942
    //   2834: aload 5
    //   2836: arraylength
    //   2837: iconst_1
    //   2838: if_icmpne +104 -> 2942
    //   2841: new 113	org/json/JSONObject
    //   2844: dup
    //   2845: aload 5
    //   2847: iconst_0
    //   2848: aaload
    //   2849: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2852: ldc_w 809
    //   2855: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2858: astore_1
    //   2859: aload_0
    //   2860: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2863: aload_0
    //   2864: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   2867: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   2870: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   2873: astore_2
    //   2874: aload_2
    //   2875: ifnull +23 -> 2898
    //   2878: aload_2
    //   2879: instanceof 2171
    //   2882: ifeq +16 -> 2898
    //   2885: aload_2
    //   2886: checkcast 2171	biki
    //   2889: invokeinterface 2175 1 0
    //   2894: aload_1
    //   2895: putfield 2903	aasr:u	Ljava/lang/String;
    //   2898: aconst_null
    //   2899: ldc_w 768
    //   2902: ldc_w 2877
    //   2905: ldc_w 482
    //   2908: ldc_w 2905
    //   2911: ldc_w 2905
    //   2914: iconst_0
    //   2915: iconst_0
    //   2916: ldc_w 482
    //   2919: ldc_w 482
    //   2922: ldc_w 482
    //   2925: ldc_w 482
    //   2928: invokestatic 1537	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2931: goto -2747 -> 184
    //   2934: astore_1
    //   2935: aload_1
    //   2936: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   2939: goto -41 -> 2898
    //   2942: ldc_w 2907
    //   2945: aload 4
    //   2947: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2950: ifeq +74 -> 3024
    //   2953: aload 5
    //   2955: arraylength
    //   2956: iconst_1
    //   2957: if_icmpne +67 -> 3024
    //   2960: new 113	org/json/JSONObject
    //   2963: dup
    //   2964: aload 5
    //   2966: iconst_0
    //   2967: aaload
    //   2968: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2971: astore_1
    //   2972: aload_1
    //   2973: ldc_w 809
    //   2976: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2979: astore_3
    //   2980: new 2909	awbn
    //   2983: dup
    //   2984: aload_0
    //   2985: aload_3
    //   2986: invokespecial 2910	awbn:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   2989: astore_2
    //   2990: new 2912	awbx
    //   2993: dup
    //   2994: aload_0
    //   2995: aload_3
    //   2996: invokespecial 2913	awbx:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   2999: astore_3
    //   3000: aload_0
    //   3001: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3004: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   3007: aload_1
    //   3008: aload_2
    //   3009: aload_2
    //   3010: aload_3
    //   3011: invokestatic 2915	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lorg/json/JSONObject;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;)V
    //   3014: iconst_1
    //   3015: ireturn
    //   3016: astore_1
    //   3017: aload_1
    //   3018: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   3021: goto -2837 -> 184
    //   3024: ldc_w 2917
    //   3027: aload 4
    //   3029: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3032: ifeq +399 -> 3431
    //   3035: aload 5
    //   3037: arraylength
    //   3038: iconst_1
    //   3039: if_icmpne +392 -> 3431
    //   3042: new 113	org/json/JSONObject
    //   3045: dup
    //   3046: aload 5
    //   3048: iconst_0
    //   3049: aaload
    //   3050: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3053: astore_2
    //   3054: aload_2
    //   3055: ldc_w 2919
    //   3058: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3061: astore_3
    //   3062: aload_2
    //   3063: ldc_w 2921
    //   3066: invokevirtual 423	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3069: astore_2
    //   3070: ldc_w 2923
    //   3073: aload_3
    //   3074: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3077: ifeq +106 -> 3183
    //   3080: aload_2
    //   3081: ldc_w 2677
    //   3084: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3087: astore_2
    //   3088: aload_2
    //   3089: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3092: ifeq +66 -> 3158
    //   3095: new 129	android/content/Intent
    //   3098: dup
    //   3099: invokespecial 494	android/content/Intent:<init>	()V
    //   3102: astore_3
    //   3103: aload_3
    //   3104: getstatic 2926	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3107: aload_2
    //   3108: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3111: pop
    //   3112: aload_0
    //   3113: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3116: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   3119: aload_3
    //   3120: aload_0
    //   3121: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3124: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   3127: invokevirtual 2064	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3130: invokestatic 2929	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3133: aload_1
    //   3134: ldc_w 2931
    //   3137: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3140: goto -2956 -> 184
    //   3143: astore_2
    //   3144: aload_2
    //   3145: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   3148: aload_1
    //   3149: ldc_w 2933
    //   3152: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3155: goto -2971 -> 184
    //   3158: aload_1
    //   3159: ldc_w 2933
    //   3162: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3165: goto -2981 -> 184
    //   3168: astore_2
    //   3169: aload_2
    //   3170: invokevirtual 874	java/lang/Exception:printStackTrace	()V
    //   3173: aload_1
    //   3174: ldc_w 2933
    //   3177: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3180: goto -2996 -> 184
    //   3183: ldc_w 2935
    //   3186: aload_3
    //   3187: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3190: ifeq +71 -> 3261
    //   3193: aload_2
    //   3194: ldc_w 2677
    //   3197: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3200: astore_2
    //   3201: aload_2
    //   3202: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3205: ifeq +46 -> 3251
    //   3208: invokestatic 2940	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   3211: astore_3
    //   3212: aload_3
    //   3213: aload_0
    //   3214: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3217: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   3220: invokevirtual 2064	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3223: putfield 2943	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   3226: aload_0
    //   3227: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3230: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   3233: aload_3
    //   3234: aload_2
    //   3235: aconst_null
    //   3236: iconst_0
    //   3237: iconst_0
    //   3238: invokestatic 2949	cooperation/qzone/QZoneHelper:forwardToQunFeed	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3241: aload_1
    //   3242: ldc_w 2931
    //   3245: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3248: goto -3064 -> 184
    //   3251: aload_1
    //   3252: ldc_w 2933
    //   3255: invokevirtual 2779	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3258: goto -3074 -> 184
    //   3261: ldc_w 2951
    //   3264: aload_3
    //   3265: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3268: ifeq +66 -> 3334
    //   3271: aload_0
    //   3272: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3275: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   3278: astore_3
    //   3279: aload_2
    //   3280: ldc_w 2677
    //   3283: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3286: astore_2
    //   3287: aload_3
    //   3288: ifnull -3104 -> 184
    //   3291: aload_2
    //   3292: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3295: ifeq -3111 -> 184
    //   3298: new 129	android/content/Intent
    //   3301: dup
    //   3302: aload_3
    //   3303: ldc_w 2953
    //   3306: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3309: astore 4
    //   3311: aload 4
    //   3313: ldc_w 2083
    //   3316: aload_2
    //   3317: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3320: pop
    //   3321: aload_3
    //   3322: aload 4
    //   3324: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3327: aload_3
    //   3328: invokevirtual 654	android/app/Activity:finish	()V
    //   3331: goto -3147 -> 184
    //   3334: ldc_w 2955
    //   3337: aload_3
    //   3338: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3341: ifeq -3157 -> 184
    //   3344: aload_0
    //   3345: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3348: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   3351: astore_3
    //   3352: aload_2
    //   3353: ldc_w 2677
    //   3356: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3359: astore 4
    //   3361: aload_2
    //   3362: ldc_w 2679
    //   3365: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3368: astore_2
    //   3369: aload_3
    //   3370: ifnull -3186 -> 184
    //   3373: aload 4
    //   3375: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3378: ifeq -3194 -> 184
    //   3381: aload_2
    //   3382: invokestatic 2684	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3385: ifeq -3201 -> 184
    //   3388: new 129	android/content/Intent
    //   3391: dup
    //   3392: aload_3
    //   3393: ldc_w 2686
    //   3396: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3399: astore 5
    //   3401: aload 5
    //   3403: ldc_w 2083
    //   3406: aload 4
    //   3408: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3411: pop
    //   3412: aload 5
    //   3414: ldc_w 2679
    //   3417: aload_2
    //   3418: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3421: pop
    //   3422: aload_3
    //   3423: aload 5
    //   3425: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3428: goto -3244 -> 184
    //   3431: ldc_w 2956
    //   3434: aload 4
    //   3436: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3439: ifeq +888 -> 4327
    //   3442: aload 5
    //   3444: arraylength
    //   3445: iconst_1
    //   3446: if_icmpne +881 -> 4327
    //   3449: aload_0
    //   3450: ldc_w 482
    //   3453: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3456: new 113	org/json/JSONObject
    //   3459: dup
    //   3460: aload 5
    //   3462: iconst_0
    //   3463: aaload
    //   3464: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3467: astore_1
    //   3468: aload_1
    //   3469: ifnull +840 -> 4309
    //   3472: aload_0
    //   3473: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3476: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   3479: astore_3
    //   3480: aload_1
    //   3481: ldc_w 2960
    //   3484: ldc_w 2962
    //   3487: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3490: astore 14
    //   3492: aload_1
    //   3493: ldc_w 2836
    //   3496: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3499: astore 4
    //   3501: aload_1
    //   3502: ldc_w 419
    //   3505: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3508: astore 15
    //   3510: aload_1
    //   3511: ldc_w 2964
    //   3514: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3517: astore 5
    //   3519: aload_1
    //   3520: ldc_w 809
    //   3523: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3526: astore_2
    //   3527: aload_1
    //   3528: ldc_w 408
    //   3531: iconst_m1
    //   3532: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3535: istore 6
    //   3537: new 113	org/json/JSONObject
    //   3540: dup
    //   3541: aload 15
    //   3543: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3546: astore_1
    //   3547: aload_0
    //   3548: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   3551: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3554: astore 15
    //   3556: aload 15
    //   3558: ifnull +16 -> 3574
    //   3561: aload_1
    //   3562: ldc_w 2966
    //   3565: aload 15
    //   3567: invokevirtual 2967	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3570: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3573: pop
    //   3574: ldc_w 2969
    //   3577: aload 14
    //   3579: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3582: ifeq +164 -> 3746
    //   3585: new 301	android/os/Bundle
    //   3588: dup
    //   3589: invokespecial 302	android/os/Bundle:<init>	()V
    //   3592: astore_2
    //   3593: aload_2
    //   3594: ldc_w 419
    //   3597: aload_1
    //   3598: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3601: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3604: aload_2
    //   3605: ldc_w 2964
    //   3608: aload 5
    //   3610: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3613: ldc_w 2971
    //   3616: aload 4
    //   3618: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3621: ifeq +95 -> 3716
    //   3624: new 2973	bewd
    //   3627: dup
    //   3628: aload_3
    //   3629: checkcast 2975	com/tencent/mobileqq/app/BaseActivity
    //   3632: aload_2
    //   3633: invokespecial 2978	bewd:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3636: aload_3
    //   3637: invokevirtual 2980	bewd:a	(Landroid/app/Activity;)V
    //   3640: goto -3456 -> 184
    //   3643: astore_1
    //   3644: ldc_w 482
    //   3647: astore_2
    //   3648: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3651: ifeq +22 -> 3673
    //   3654: ldc 209
    //   3656: iconst_2
    //   3657: ldc_w 2982
    //   3660: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3663: ldc 209
    //   3665: iconst_2
    //   3666: aload_1
    //   3667: invokestatic 1201	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3670: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3673: aload_2
    //   3674: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3677: ifne -3493 -> 184
    //   3680: aload_0
    //   3681: aload_2
    //   3682: iconst_1
    //   3683: anewarray 285	java/lang/String
    //   3686: dup
    //   3687: iconst_0
    //   3688: ldc_w 2984
    //   3691: aastore
    //   3692: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3695: goto -3511 -> 184
    //   3698: astore_1
    //   3699: aconst_null
    //   3700: astore_1
    //   3701: goto -233 -> 3468
    //   3704: astore_1
    //   3705: new 113	org/json/JSONObject
    //   3708: dup
    //   3709: invokespecial 172	org/json/JSONObject:<init>	()V
    //   3712: astore_1
    //   3713: goto -166 -> 3547
    //   3716: ldc_w 2986
    //   3719: aload 4
    //   3721: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3724: ifeq -3540 -> 184
    //   3727: new 2988	bexy
    //   3730: dup
    //   3731: aload_3
    //   3732: checkcast 2975	com/tencent/mobileqq/app/BaseActivity
    //   3735: aload_2
    //   3736: invokespecial 2989	bexy:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3739: aload_3
    //   3740: invokevirtual 2990	bexy:a	(Landroid/app/Activity;)V
    //   3743: goto -3559 -> 184
    //   3746: ldc_w 2962
    //   3749: aload 14
    //   3751: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3754: ifeq +331 -> 4085
    //   3757: new 129	android/content/Intent
    //   3760: dup
    //   3761: invokespecial 494	android/content/Intent:<init>	()V
    //   3764: astore 14
    //   3766: ldc_w 2992
    //   3769: aload 4
    //   3771: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3774: ifeq +119 -> 3893
    //   3777: aload 14
    //   3779: new 2994	android/content/ComponentName
    //   3782: dup
    //   3783: aload_0
    //   3784: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   3787: aload 4
    //   3789: invokespecial 2995	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3792: invokevirtual 2999	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3795: pop
    //   3796: aload 14
    //   3798: ldc_w 3001
    //   3801: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   3804: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3807: pop
    //   3808: aload 14
    //   3810: ldc_w 419
    //   3813: aload_1
    //   3814: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3817: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3820: pop
    //   3821: aload_0
    //   3822: aload 5
    //   3824: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3827: aload 5
    //   3829: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3832: ifeq +208 -> 4040
    //   3835: aload_3
    //   3836: aload 14
    //   3838: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3841: goto +13669 -> 17510
    //   3844: ldc_w 3003
    //   3847: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   3850: aload 4
    //   3852: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3855: ifeq -3671 -> 184
    //   3858: aload_0
    //   3859: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   3862: ifnonnull +17 -> 3879
    //   3865: aload_0
    //   3866: invokestatic 2044	aady:a	()Laady;
    //   3869: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   3872: aload_0
    //   3873: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   3876: invokevirtual 2046	aady:a	()V
    //   3879: aload_0
    //   3880: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   3883: invokevirtual 3005	aady:c	()V
    //   3886: goto -3702 -> 184
    //   3889: astore_1
    //   3890: goto -242 -> 3648
    //   3893: ldc_w 3007
    //   3896: aload 4
    //   3898: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3901: ifeq +78 -> 3979
    //   3904: aload 14
    //   3906: new 2994	android/content/ComponentName
    //   3909: dup
    //   3910: aload_3
    //   3911: aload 4
    //   3913: invokespecial 2995	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3916: invokevirtual 2999	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3919: pop
    //   3920: aload 14
    //   3922: ldc_w 3009
    //   3925: iconst_0
    //   3926: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3929: pop
    //   3930: aload 14
    //   3932: ldc_w 304
    //   3935: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   3938: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3941: pop
    //   3942: aload 14
    //   3944: getstatic 3013	bmct:l	Ljava/lang/String;
    //   3947: iconst_1
    //   3948: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3951: pop
    //   3952: aload 14
    //   3954: getstatic 3014	bmct:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3957: ldc_w 2439
    //   3960: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3963: pop
    //   3964: aload 14
    //   3966: getstatic 3015	bmct:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3969: ldc_w 2836
    //   3972: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3975: pop
    //   3976: goto -168 -> 3808
    //   3979: ldc_w 3017
    //   3982: aload 4
    //   3984: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3987: ifeq +34 -> 4021
    //   3990: aload 14
    //   3992: new 2994	android/content/ComponentName
    //   3995: dup
    //   3996: aload_3
    //   3997: aload 4
    //   3999: invokespecial 2995	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4002: invokevirtual 2999	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4005: pop
    //   4006: aload 14
    //   4008: ldc_w 3019
    //   4011: ldc_w 2212
    //   4014: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4017: pop
    //   4018: goto -210 -> 3808
    //   4021: aload 14
    //   4023: new 2994	android/content/ComponentName
    //   4026: dup
    //   4027: aload_3
    //   4028: aload 4
    //   4030: invokespecial 2995	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4033: invokevirtual 2999	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4036: pop
    //   4037: goto -229 -> 3808
    //   4040: aload_0
    //   4041: aload 14
    //   4043: iconst_4
    //   4044: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4047: aload_2
    //   4048: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4051: ifne +13459 -> 17510
    //   4054: aload_0
    //   4055: aload_2
    //   4056: iconst_1
    //   4057: anewarray 285	java/lang/String
    //   4060: dup
    //   4061: iconst_0
    //   4062: ldc_w 1396
    //   4065: aastore
    //   4066: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4069: goto +13441 -> 17510
    //   4072: aload_3
    //   4073: ldc_w 3020
    //   4076: ldc_w 3021
    //   4079: invokevirtual 412	android/app/Activity:overridePendingTransition	(II)V
    //   4082: goto -238 -> 3844
    //   4085: ldc_w 3023
    //   4088: aload 14
    //   4090: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4093: ifeq -3909 -> 184
    //   4096: aload 4
    //   4098: ldc_w 3025
    //   4101: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4104: ifeq +102 -> 4206
    //   4107: aload_1
    //   4108: ldc_w 3027
    //   4111: iconst_0
    //   4112: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4115: iconst_1
    //   4116: if_icmpne -3932 -> 184
    //   4119: aload_0
    //   4120: aload 5
    //   4122: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4125: aload_1
    //   4126: ldc 154
    //   4128: ldc_w 482
    //   4131: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4134: astore_2
    //   4135: aload_3
    //   4136: aload_0
    //   4137: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   4140: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   4143: aload_1
    //   4144: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4147: iconst_4
    //   4148: aload_2
    //   4149: invokestatic 3032	beub:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)Landroid/content/Intent;
    //   4152: astore_1
    //   4153: aload_1
    //   4154: ifnull +23 -> 4177
    //   4157: aload_0
    //   4158: invokevirtual 3034	com/tencent/mobileqq/jsp/UiApiPlugin:g	()V
    //   4161: aload_0
    //   4162: aload_1
    //   4163: iconst_4
    //   4164: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4167: aload_3
    //   4168: ldc_w 3020
    //   4171: ldc_w 3021
    //   4174: invokevirtual 412	android/app/Activity:overridePendingTransition	(II)V
    //   4177: ldc_w 482
    //   4180: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4183: ifne -3999 -> 184
    //   4186: aload_0
    //   4187: ldc_w 482
    //   4190: iconst_1
    //   4191: anewarray 285	java/lang/String
    //   4194: dup
    //   4195: iconst_0
    //   4196: ldc_w 1396
    //   4199: aastore
    //   4200: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4203: goto -4019 -> 184
    //   4206: aload 4
    //   4208: ldc_w 3036
    //   4211: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   4214: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4217: ifeq -4033 -> 184
    //   4220: new 129	android/content/Intent
    //   4223: dup
    //   4224: invokespecial 494	android/content/Intent:<init>	()V
    //   4227: astore 14
    //   4229: aload 14
    //   4231: new 2994	android/content/ComponentName
    //   4234: dup
    //   4235: aload_3
    //   4236: aload 4
    //   4238: invokespecial 2995	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4241: invokevirtual 2999	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4244: pop
    //   4245: aload 14
    //   4247: ldc_w 419
    //   4250: aload_1
    //   4251: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4254: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4257: pop
    //   4258: aload_0
    //   4259: aload 5
    //   4261: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4264: aload_0
    //   4265: aload 14
    //   4267: iconst_4
    //   4268: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4271: aload_2
    //   4272: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4275: ifne +13260 -> 17535
    //   4278: aload_0
    //   4279: aload_2
    //   4280: iconst_1
    //   4281: anewarray 285	java/lang/String
    //   4284: dup
    //   4285: iconst_0
    //   4286: ldc_w 1396
    //   4289: aastore
    //   4290: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4293: goto +13242 -> 17535
    //   4296: aload_3
    //   4297: ldc_w 3020
    //   4300: ldc_w 3021
    //   4303: invokevirtual 412	android/app/Activity:overridePendingTransition	(II)V
    //   4306: goto -4122 -> 184
    //   4309: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4312: ifeq -4128 -> 184
    //   4315: ldc 209
    //   4317: iconst_2
    //   4318: ldc_w 3038
    //   4321: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4324: goto -4140 -> 184
    //   4327: ldc_w 3040
    //   4330: aload 4
    //   4332: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4335: ifeq +1942 -> 6277
    //   4338: aload 5
    //   4340: arraylength
    //   4341: iconst_1
    //   4342: if_icmpne +1935 -> 6277
    //   4345: new 113	org/json/JSONObject
    //   4348: dup
    //   4349: aload 5
    //   4351: iconst_0
    //   4352: aaload
    //   4353: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4356: astore_2
    //   4357: aload_0
    //   4358: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   4361: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   4364: astore 4
    //   4366: aload 4
    //   4368: instanceof 386
    //   4371: ifne +5 -> 4376
    //   4374: iconst_1
    //   4375: ireturn
    //   4376: aload_0
    //   4377: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   4380: invokevirtual 1875	bifw:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4383: astore_3
    //   4384: aload_3
    //   4385: ifnonnull +5 -> 4390
    //   4388: iconst_1
    //   4389: ireturn
    //   4390: aload_2
    //   4391: ldc_w 3042
    //   4394: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4397: ifeq +103 -> 4500
    //   4400: aload_2
    //   4401: ldc_w 3044
    //   4404: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4407: ifeq +93 -> 4500
    //   4410: aload_2
    //   4411: ldc_w 3044
    //   4414: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4417: ifeq +83 -> 4500
    //   4420: aload_2
    //   4421: ldc_w 3042
    //   4424: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4427: istore 6
    //   4429: aload_0
    //   4430: iconst_2
    //   4431: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4434: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4437: astore_1
    //   4438: aload_1
    //   4439: ifnull +25 -> 4464
    //   4442: aload_1
    //   4443: getfield 3049	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mBrowserTips	Landroid/view/View;
    //   4446: ifnull +18 -> 4464
    //   4449: aload_1
    //   4450: iload 6
    //   4452: putfield 3052	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mBrowserTipsColor	I
    //   4455: aload_1
    //   4456: getfield 3049	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mBrowserTips	Landroid/view/View;
    //   4459: iload 6
    //   4461: invokevirtual 3053	android/view/View:setBackgroundColor	(I)V
    //   4464: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4467: ifeq +33 -> 4500
    //   4470: ldc 209
    //   4472: iconst_2
    //   4473: new 549	java/lang/StringBuilder
    //   4476: dup
    //   4477: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   4480: ldc_w 3055
    //   4483: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4486: iload 6
    //   4488: invokestatic 3058	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4491: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4494: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4497: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4500: aload_2
    //   4501: ldc_w 3060
    //   4504: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4507: ifeq +71 -> 4578
    //   4510: aload_2
    //   4511: ldc_w 3060
    //   4514: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4517: istore 12
    //   4519: iload 12
    //   4521: ifne +57 -> 4578
    //   4524: aload_0
    //   4525: iconst_2
    //   4526: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4529: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4532: astore_1
    //   4533: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4536: ifeq +30 -> 4566
    //   4539: ldc 209
    //   4541: iconst_2
    //   4542: new 549	java/lang/StringBuilder
    //   4545: dup
    //   4546: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   4549: ldc_w 3062
    //   4552: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: iload 12
    //   4557: invokevirtual 1056	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4560: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4563: invokestatic 882	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4566: aload_1
    //   4567: ifnull +11 -> 4578
    //   4570: aload_1
    //   4571: getfield 3066	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mProgressBarController	Lbiur;
    //   4574: iconst_0
    //   4575: invokevirtual 3069	biur:a	(Z)V
    //   4578: aload_2
    //   4579: ldc_w 3071
    //   4582: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4585: ifeq +72 -> 4657
    //   4588: aload_2
    //   4589: ldc_w 3071
    //   4592: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4595: istore 6
    //   4597: aload 4
    //   4599: ldc_w 2612
    //   4602: invokevirtual 1475	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4605: checkcast 830	android/widget/TextView
    //   4608: astore_1
    //   4609: aload 4
    //   4611: ldc_w 3072
    //   4614: invokevirtual 1475	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4617: checkcast 974	android/widget/ImageView
    //   4620: astore 5
    //   4622: aload_1
    //   4623: ifnull +34 -> 4657
    //   4626: aload 5
    //   4628: ifnull +29 -> 4657
    //   4631: iload 6
    //   4633: iconst_1
    //   4634: if_icmpne +1104 -> 5738
    //   4637: aload 5
    //   4639: invokevirtual 1460	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   4642: ifnull +1045 -> 5687
    //   4645: aload 5
    //   4647: iconst_0
    //   4648: invokevirtual 1015	android/widget/ImageView:setVisibility	(I)V
    //   4651: aload_1
    //   4652: bipush 8
    //   4654: invokevirtual 3073	android/widget/TextView:setVisibility	(I)V
    //   4657: aload_2
    //   4658: ldc_w 3075
    //   4661: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4664: ifeq +23 -> 4687
    //   4667: aload_2
    //   4668: ldc_w 3075
    //   4671: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4674: iconst_1
    //   4675: if_icmpne +12884 -> 17559
    //   4678: iconst_1
    //   4679: istore 12
    //   4681: aload_3
    //   4682: iload 12
    //   4684: invokevirtual 3078	com/tencent/mobileqq/webview/swift/WebViewFragment:enableSwipeBackForJS	(Z)V
    //   4687: aload_2
    //   4688: ldc_w 3080
    //   4691: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4694: ifeq +129 -> 4823
    //   4697: aload_2
    //   4698: ldc_w 3082
    //   4701: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4704: ifeq +119 -> 4823
    //   4707: aload_2
    //   4708: ldc_w 3084
    //   4711: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4714: ifeq +109 -> 4823
    //   4717: aload_2
    //   4718: ldc_w 3086
    //   4721: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4724: ifeq +99 -> 4823
    //   4727: aload_2
    //   4728: ldc_w 3088
    //   4731: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4734: ifeq +89 -> 4823
    //   4737: aload_2
    //   4738: ldc_w 3080
    //   4741: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4744: astore_1
    //   4745: aload_2
    //   4746: ldc_w 3082
    //   4749: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4752: istore 6
    //   4754: aload_2
    //   4755: ldc_w 3084
    //   4758: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4761: istore 7
    //   4763: aload_2
    //   4764: ldc_w 3086
    //   4767: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4770: istore 8
    //   4772: aload_2
    //   4773: ldc_w 3088
    //   4776: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4779: istore 9
    //   4781: aload_3
    //   4782: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4785: ifnull +38 -> 4823
    //   4788: aload_3
    //   4789: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4792: getfield 3096	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4795: instanceof 1962
    //   4798: ifeq +25 -> 4823
    //   4801: aload_3
    //   4802: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4805: getfield 3096	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4808: checkcast 1962	com/tencent/biz/ui/RefreshView
    //   4811: aload_1
    //   4812: iload 6
    //   4814: iload 7
    //   4816: iload 8
    //   4818: iload 9
    //   4820: invokevirtual 3099	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;IIII)V
    //   4823: aload_2
    //   4824: ldc_w 3101
    //   4827: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4830: ifeq +45 -> 4875
    //   4833: aload_2
    //   4834: ldc_w 3101
    //   4837: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4840: astore_1
    //   4841: aload_3
    //   4842: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4845: ifnull +30 -> 4875
    //   4848: aload_3
    //   4849: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4852: getfield 3096	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4855: instanceof 1962
    //   4858: ifeq +17 -> 4875
    //   4861: aload_3
    //   4862: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4865: getfield 3096	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4868: checkcast 1962	com/tencent/biz/ui/RefreshView
    //   4871: aload_1
    //   4872: invokevirtual 3102	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;)V
    //   4875: aload_3
    //   4876: invokevirtual 3104	com/tencent/mobileqq/webview/swift/WebViewFragment:isFullScreen	()Z
    //   4879: ifne +146 -> 5025
    //   4882: aload_2
    //   4883: ldc_w 3106
    //   4886: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4889: ifeq +136 -> 5025
    //   4892: aload_2
    //   4893: ldc_w 3106
    //   4896: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4899: istore 7
    //   4901: aload 4
    //   4903: ldc_w 1471
    //   4906: invokevirtual 1475	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4909: astore 5
    //   4911: aload 5
    //   4913: ifnull +112 -> 5025
    //   4916: aconst_null
    //   4917: astore_1
    //   4918: aload_0
    //   4919: invokevirtual 3108	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbikh;
    //   4922: ifnull +832 -> 5754
    //   4925: aload_0
    //   4926: invokevirtual 3108	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbikh;
    //   4929: invokeinterface 3111 1 0
    //   4934: astore_1
    //   4935: iload 7
    //   4937: iconst_m1
    //   4938: if_icmpne +916 -> 5854
    //   4941: aload 5
    //   4943: invokevirtual 3114	android/view/View:getPaddingTop	()I
    //   4946: istore 6
    //   4948: aload 5
    //   4950: invokevirtual 3117	android/view/View:getPaddingBottom	()I
    //   4953: istore 7
    //   4955: aload 5
    //   4957: invokevirtual 3120	android/view/View:getPaddingLeft	()I
    //   4960: istore 8
    //   4962: aload 5
    //   4964: invokevirtual 3123	android/view/View:getPaddingRight	()I
    //   4967: istore 9
    //   4969: aload 5
    //   4971: ldc_w 3124
    //   4974: invokevirtual 3125	android/view/View:setBackgroundResource	(I)V
    //   4977: aload 5
    //   4979: iload 8
    //   4981: iload 6
    //   4983: iload 9
    //   4985: iload 7
    //   4987: invokevirtual 3128	android/view/View:setPadding	(IIII)V
    //   4990: aload_1
    //   4991: ifnull +7 -> 4998
    //   4994: aload_1
    //   4995: invokevirtual 3131	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   4998: aload_3
    //   4999: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5002: ifnull +23 -> 5025
    //   5005: aload_3
    //   5006: invokevirtual 3136	com/tencent/mobileqq/webview/swift/WebViewFragment:isTransparentTitle	()Z
    //   5009: ifeq +769 -> 5778
    //   5012: aload_3
    //   5013: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5016: iconst_4
    //   5017: invokevirtual 1889	android/view/View:setVisibility	(I)V
    //   5020: aload_3
    //   5021: iconst_0
    //   5022: invokevirtual 3139	com/tencent/mobileqq/webview/swift/WebViewFragment:setUsingCustomTitleBarColor	(Z)V
    //   5025: aload_2
    //   5026: ldc_w 1756
    //   5029: iconst_m1
    //   5030: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   5033: istore 6
    //   5035: aload_0
    //   5036: iconst_2
    //   5037: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5040: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5043: astore_1
    //   5044: iload 6
    //   5046: iflt +98 -> 5144
    //   5049: aload_1
    //   5050: ifnull +94 -> 5144
    //   5053: aload_1
    //   5054: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5057: astore 5
    //   5059: iconst_1
    //   5060: iload 6
    //   5062: if_icmpne +12503 -> 17565
    //   5065: iconst_1
    //   5066: istore 12
    //   5068: aload 5
    //   5070: iload 12
    //   5072: putfield 1771	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isShowDefaultThemeIcon	Z
    //   5075: aload_0
    //   5076: getfield 2526	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5079: ifeq +23 -> 5102
    //   5082: aload_1
    //   5083: aload_1
    //   5084: getfield 3140	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbieo;
    //   5087: getfield 2515	bieo:rightViewImg	Landroid/widget/ImageView;
    //   5090: iconst_0
    //   5091: aload_0
    //   5092: getfield 2526	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5095: aload_0
    //   5096: getfield 2526	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5099: invokevirtual 2530	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setDefaultThemeIcon	(Landroid/view/View;ZII)V
    //   5102: aload_0
    //   5103: getfield 2545	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5106: ifeq +20 -> 5126
    //   5109: aload_1
    //   5110: aload_0
    //   5111: getfield 1456	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5114: iconst_0
    //   5115: aload_0
    //   5116: getfield 2545	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5119: aload_0
    //   5120: getfield 2545	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5123: invokevirtual 2530	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setDefaultThemeIcon	(Landroid/view/View;ZII)V
    //   5126: aload_1
    //   5127: aload_1
    //   5128: getfield 3140	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbieo;
    //   5131: getfield 2466	bieo:leftView	Landroid/widget/TextView;
    //   5134: iconst_1
    //   5135: ldc_w 3141
    //   5138: ldc_w 3142
    //   5141: invokevirtual 2530	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setDefaultThemeIcon	(Landroid/view/View;ZII)V
    //   5144: aload_2
    //   5145: ldc_w 3144
    //   5148: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5151: ifeq +22 -> 5173
    //   5154: aload_2
    //   5155: ldc_w 3144
    //   5158: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5161: istore 6
    //   5163: iload 6
    //   5165: iconst_m1
    //   5166: if_icmpne +939 -> 6105
    //   5169: aload_3
    //   5170: invokevirtual 3147	com/tencent/mobileqq/webview/swift/WebViewFragment:resetTitleBarTextColor	()V
    //   5173: aload_2
    //   5174: ldc_w 3149
    //   5177: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5180: ifeq +14 -> 5194
    //   5183: aload_3
    //   5184: aload_2
    //   5185: ldc_w 3149
    //   5188: invokevirtual 3152	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5191: invokevirtual 3155	com/tencent/mobileqq/webview/swift/WebViewFragment:setBottomBarVisible	(Z)V
    //   5194: aload_2
    //   5195: ldc_w 3157
    //   5198: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5201: ifeq +25 -> 5226
    //   5204: aload_2
    //   5205: ldc_w 3157
    //   5208: invokevirtual 3152	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5211: ifeq +952 -> 6163
    //   5214: aload_3
    //   5215: aload_3
    //   5216: invokevirtual 3158	com/tencent/mobileqq/webview/swift/WebViewFragment:getRulesFromUrl	()J
    //   5219: ldc2_w 3159
    //   5222: land
    //   5223: invokevirtual 3163	com/tencent/mobileqq/webview/swift/WebViewFragment:setRulesFromUrl	(J)V
    //   5226: aload_2
    //   5227: ldc_w 3165
    //   5230: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5233: ifeq +22 -> 5255
    //   5236: aload_2
    //   5237: ldc_w 3165
    //   5240: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5243: astore 5
    //   5245: aload 4
    //   5247: checkcast 386	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5250: aload 5
    //   5252: invokevirtual 3167	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5255: aload_2
    //   5256: ldc_w 3169
    //   5259: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5262: ifeq +49 -> 5311
    //   5265: aload_2
    //   5266: ldc_w 3169
    //   5269: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5272: istore 12
    //   5274: sipush 800
    //   5277: istore 6
    //   5279: aload_2
    //   5280: ldc_w 3171
    //   5283: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5286: ifeq +17 -> 5303
    //   5289: aload_2
    //   5290: ldc_w 3171
    //   5293: invokevirtual 3175	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5296: ldc2_w 3176
    //   5299: dmul
    //   5300: d2i
    //   5301: istore 6
    //   5303: aload_0
    //   5304: iload 12
    //   5306: iload 6
    //   5308: invokevirtual 3179	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5311: aload_2
    //   5312: ldc_w 3181
    //   5315: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5318: ifeq +44 -> 5362
    //   5321: aload_2
    //   5322: ldc_w 3181
    //   5325: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5328: istore 6
    //   5330: aload_1
    //   5331: ifnull +31 -> 5362
    //   5334: iload 6
    //   5336: ifne +842 -> 6178
    //   5339: aload_1
    //   5340: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5343: iconst_0
    //   5344: putfield 3184	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isScreenLandscape	Z
    //   5347: aload_1
    //   5348: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5351: iconst_1
    //   5352: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5355: putfield 3188	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:mIsPortraitOnly	Ljava/lang/Boolean;
    //   5358: aload_1
    //   5359: invokevirtual 3191	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:updateScreenOrientation	()V
    //   5362: aload_2
    //   5363: ldc_w 3193
    //   5366: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5369: ifeq +26 -> 5395
    //   5372: aload_2
    //   5373: ldc_w 3193
    //   5376: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5379: istore 6
    //   5381: aload_1
    //   5382: ifnull +13 -> 5395
    //   5385: iload 6
    //   5387: iconst_1
    //   5388: if_icmpne +7 -> 5395
    //   5391: aload_1
    //   5392: invokevirtual 3196	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:restoreOrientationFollowSenSor	()V
    //   5395: aload_2
    //   5396: ldc_w 3198
    //   5399: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5402: ifeq +18 -> 5420
    //   5405: aload_2
    //   5406: ldc_w 3198
    //   5409: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5412: iconst_1
    //   5413: if_icmpne +7 -> 5420
    //   5416: aload_1
    //   5417: invokevirtual 3201	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:supportOrientationFollowSenSor	()V
    //   5420: aload_2
    //   5421: ldc_w 3203
    //   5424: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5427: ifeq +63 -> 5490
    //   5430: aload_2
    //   5431: ldc_w 3203
    //   5434: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5437: istore 6
    //   5439: aload_0
    //   5440: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   5443: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   5446: astore 5
    //   5448: aload 5
    //   5450: ifnull +40 -> 5490
    //   5453: aload 5
    //   5455: instanceof 522
    //   5458: ifeq +32 -> 5490
    //   5461: aload 4
    //   5463: checkcast 522	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   5466: invokevirtual 3204	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   5469: checkcast 3206	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   5472: astore 4
    //   5474: aload 4
    //   5476: ifnull +14 -> 5490
    //   5479: iload 6
    //   5481: iconst_1
    //   5482: if_icmpne +724 -> 6206
    //   5485: aload 4
    //   5487: invokevirtual 3207	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:e	()V
    //   5490: aload_2
    //   5491: ldc_w 3209
    //   5494: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5497: ifeq +23 -> 5520
    //   5500: aload_2
    //   5501: ldc_w 3209
    //   5504: iconst_0
    //   5505: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5508: istore 12
    //   5510: aload_1
    //   5511: ifnull +9 -> 5520
    //   5514: aload_1
    //   5515: iload 12
    //   5517: invokevirtual 3212	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setFloatingShareVisible	(Z)V
    //   5520: aload_2
    //   5521: ldc_w 3214
    //   5524: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5527: ifeq +38 -> 5565
    //   5530: aload_2
    //   5531: ldc_w 3214
    //   5534: iconst_0
    //   5535: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5538: istore 12
    //   5540: aload_1
    //   5541: ifnull +24 -> 5565
    //   5544: aload_1
    //   5545: getfield 3140	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbieo;
    //   5548: getfield 3215	bieo:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5551: getfield 3218	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:mShowRightCloseButton	Z
    //   5554: iload 12
    //   5556: if_icmpeq +9 -> 5565
    //   5559: aload_1
    //   5560: iload 12
    //   5562: invokevirtual 3221	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setRightCloseButtonVisible	(Z)V
    //   5565: aload_2
    //   5566: ldc_w 3223
    //   5569: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5572: ifeq -5388 -> 184
    //   5575: aload_1
    //   5576: ifnull -5392 -> 184
    //   5579: aload_2
    //   5580: ldc_w 3223
    //   5583: iconst_0
    //   5584: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5587: ifeq +632 -> 6219
    //   5590: aload_3
    //   5591: invokevirtual 3104	com/tencent/mobileqq/webview/swift/WebViewFragment:isFullScreen	()Z
    //   5594: ifne -5410 -> 184
    //   5597: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5600: ifeq +12 -> 5612
    //   5603: ldc 209
    //   5605: iconst_4
    //   5606: ldc_w 3225
    //   5609: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5612: aload_1
    //   5613: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5616: iconst_1
    //   5617: putfield 3227	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isFullScreen	Z
    //   5620: aload_0
    //   5621: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   5624: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   5627: invokevirtual 3231	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5630: sipush 1024
    //   5633: sipush 1024
    //   5636: invokevirtual 3235	android/view/Window:setFlags	(II)V
    //   5639: aload_3
    //   5640: invokevirtual 3238	com/tencent/mobileqq/webview/swift/WebViewFragment:hideVirtualNavBar	()V
    //   5643: aload_3
    //   5644: iconst_0
    //   5645: invokevirtual 3241	com/tencent/mobileqq/webview/swift/WebViewFragment:doShowTitleBar	(Z)V
    //   5648: goto -5464 -> 184
    //   5651: astore_1
    //   5652: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5655: ifeq -5471 -> 184
    //   5658: ldc 209
    //   5660: iconst_4
    //   5661: new 549	java/lang/StringBuilder
    //   5664: dup
    //   5665: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   5668: ldc_w 3243
    //   5671: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5674: aload_1
    //   5675: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5678: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5681: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5684: goto -5500 -> 184
    //   5687: aload 5
    //   5689: bipush 8
    //   5691: invokevirtual 1015	android/widget/ImageView:setVisibility	(I)V
    //   5694: aload_1
    //   5695: iconst_0
    //   5696: invokevirtual 3073	android/widget/TextView:setVisibility	(I)V
    //   5699: goto -1042 -> 4657
    //   5702: astore_1
    //   5703: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5706: ifeq -5522 -> 184
    //   5709: ldc 209
    //   5711: iconst_4
    //   5712: new 549	java/lang/StringBuilder
    //   5715: dup
    //   5716: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   5719: ldc_w 3243
    //   5722: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5725: aload_1
    //   5726: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5729: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5732: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5735: goto -5551 -> 184
    //   5738: aload_1
    //   5739: bipush 8
    //   5741: invokevirtual 3073	android/widget/TextView:setVisibility	(I)V
    //   5744: aload 5
    //   5746: bipush 8
    //   5748: invokevirtual 1015	android/widget/ImageView:setVisibility	(I)V
    //   5751: goto -1094 -> 4657
    //   5754: aload_0
    //   5755: iconst_2
    //   5756: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5759: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5762: astore 14
    //   5764: aload 14
    //   5766: ifnull -831 -> 4935
    //   5769: aload 14
    //   5771: getfield 3247	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mLoadingProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   5774: astore_1
    //   5775: goto -840 -> 4935
    //   5778: iconst_0
    //   5779: invokestatic 3251	com/tencent/mobileqq/theme/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   5782: ifeq +24 -> 5806
    //   5785: aload_3
    //   5786: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5789: ldc_w 3252
    //   5792: invokevirtual 3125	android/view/View:setBackgroundResource	(I)V
    //   5795: aload_3
    //   5796: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5799: iconst_0
    //   5800: invokevirtual 1889	android/view/View:setVisibility	(I)V
    //   5803: goto -783 -> 5020
    //   5806: aload_3
    //   5807: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5810: invokestatic 978	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5813: invokevirtual 3253	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5816: ldc_w 3254
    //   5819: invokevirtual 1863	android/content/res/Resources:getColor	(I)I
    //   5822: invokevirtual 3053	android/view/View:setBackgroundColor	(I)V
    //   5825: iconst_0
    //   5826: invokestatic 978	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5829: invokevirtual 3253	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5832: ldc_w 3254
    //   5835: invokevirtual 1863	android/content/res/Resources:getColor	(I)I
    //   5838: aload_0
    //   5839: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   5842: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   5845: invokevirtual 3231	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5848: invokestatic 3259	bdfk:a	(ZILandroid/view/Window;)V
    //   5851: goto -56 -> 5795
    //   5854: aload 5
    //   5856: iconst_0
    //   5857: invokevirtual 3125	android/view/View:setBackgroundResource	(I)V
    //   5860: ldc_w 1975
    //   5863: istore 6
    //   5865: aload_2
    //   5866: ldc_w 3261
    //   5869: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5872: ifeq +15 -> 5887
    //   5875: aload_2
    //   5876: ldc_w 3261
    //   5879: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5882: bipush 24
    //   5884: ishl
    //   5885: istore 6
    //   5887: iload 7
    //   5889: iload 6
    //   5891: ior
    //   5892: istore 8
    //   5894: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5897: ifeq +61 -> 5958
    //   5900: ldc 209
    //   5902: iconst_2
    //   5903: new 549	java/lang/StringBuilder
    //   5906: dup
    //   5907: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   5910: ldc_w 3263
    //   5913: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5916: iload 6
    //   5918: invokestatic 3058	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5921: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5924: ldc_w 3265
    //   5927: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5930: iload 7
    //   5932: invokestatic 3058	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5935: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5938: ldc_w 3267
    //   5941: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5944: iload 8
    //   5946: invokestatic 3058	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5949: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5952: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5955: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5958: aload 5
    //   5960: iload 8
    //   5962: invokevirtual 3053	android/view/View:setBackgroundColor	(I)V
    //   5965: aload_1
    //   5966: ifnull +13 -> 5979
    //   5969: aload_1
    //   5970: ldc_w 1975
    //   5973: iload 7
    //   5975: ior
    //   5976: invokevirtual 3270	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   5979: aload_3
    //   5980: invokevirtual 3136	com/tencent/mobileqq/webview/swift/WebViewFragment:isTransparentTitle	()Z
    //   5983: ifeq +24 -> 6007
    //   5986: aload_3
    //   5987: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5990: ifnonnull +71 -> 6061
    //   5993: aload_3
    //   5994: iconst_1
    //   5995: invokevirtual 3273	com/tencent/mobileqq/webview/swift/WebViewFragment:setNeedStatusTrans	(Z)V
    //   5998: aload_3
    //   5999: iconst_1
    //   6000: invokevirtual 3276	com/tencent/mobileqq/webview/swift/WebViewFragment:setActNeedImmersive	(Z)V
    //   6003: aload_3
    //   6004: invokevirtual 3279	com/tencent/mobileqq/webview/swift/WebViewFragment:setImmersiveStatus	()V
    //   6007: aload_3
    //   6008: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6011: ifnull -986 -> 5025
    //   6014: aload_2
    //   6015: ldc_w 3281
    //   6018: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6021: ifeq +51 -> 6072
    //   6024: aload_2
    //   6025: ldc_w 3281
    //   6028: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6031: istore 6
    //   6033: aload_3
    //   6034: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6037: iload 6
    //   6039: invokevirtual 3053	android/view/View:setBackgroundColor	(I)V
    //   6042: iconst_1
    //   6043: iload 6
    //   6045: aload_0
    //   6046: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6049: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   6052: invokevirtual 3231	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6055: invokestatic 3259	bdfk:a	(ZILandroid/view/Window;)V
    //   6058: goto -1033 -> 5025
    //   6061: aload_3
    //   6062: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6065: iconst_0
    //   6066: invokevirtual 1889	android/view/View:setVisibility	(I)V
    //   6069: goto -62 -> 6007
    //   6072: aload_3
    //   6073: getfield 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6076: iload 8
    //   6078: invokevirtual 3053	android/view/View:setBackgroundColor	(I)V
    //   6081: iconst_1
    //   6082: iload 8
    //   6084: aload_0
    //   6085: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6088: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   6091: invokevirtual 3231	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6094: invokestatic 3259	bdfk:a	(ZILandroid/view/Window;)V
    //   6097: aload_3
    //   6098: iconst_1
    //   6099: invokevirtual 3139	com/tencent/mobileqq/webview/swift/WebViewFragment:setUsingCustomTitleBarColor	(Z)V
    //   6102: goto -1077 -> 5025
    //   6105: aload_3
    //   6106: ldc_w 1975
    //   6109: iload 6
    //   6111: ior
    //   6112: invokevirtual 3284	com/tencent/mobileqq/webview/swift/WebViewFragment:setTitleBarTextColor	(I)V
    //   6115: aload_2
    //   6116: ldc_w 3286
    //   6119: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6122: ifeq +11449 -> 17571
    //   6125: aload_2
    //   6126: ldc_w 3286
    //   6129: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6132: istore 7
    //   6134: iload 7
    //   6136: iconst_m1
    //   6137: if_icmpeq +11434 -> 17571
    //   6140: ldc_w 1975
    //   6143: iload 7
    //   6145: ior
    //   6146: istore 6
    //   6148: aload_3
    //   6149: iload 6
    //   6151: invokevirtual 3289	com/tencent/mobileqq/webview/swift/WebViewFragment:setTitleBarButtonColor	(I)V
    //   6154: aload_0
    //   6155: iload 6
    //   6157: invokevirtual 3291	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   6160: goto -987 -> 5173
    //   6163: aload_3
    //   6164: aload_3
    //   6165: invokevirtual 3158	com/tencent/mobileqq/webview/swift/WebViewFragment:getRulesFromUrl	()J
    //   6168: ldc2_w 2620
    //   6171: lor
    //   6172: invokevirtual 3163	com/tencent/mobileqq/webview/swift/WebViewFragment:setRulesFromUrl	(J)V
    //   6175: goto -949 -> 5226
    //   6178: iload 6
    //   6180: iconst_1
    //   6181: if_icmpne -823 -> 5358
    //   6184: aload_1
    //   6185: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6188: iconst_1
    //   6189: putfield 3184	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isScreenLandscape	Z
    //   6192: aload_1
    //   6193: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6196: iconst_0
    //   6197: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6200: putfield 3188	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:mIsPortraitOnly	Ljava/lang/Boolean;
    //   6203: goto -845 -> 5358
    //   6206: iload 6
    //   6208: ifne -718 -> 5490
    //   6211: aload 4
    //   6213: invokevirtual 3293	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:f	()V
    //   6216: goto -726 -> 5490
    //   6219: aload_3
    //   6220: invokevirtual 3104	com/tencent/mobileqq/webview/swift/WebViewFragment:isFullScreen	()Z
    //   6223: ifeq -6039 -> 184
    //   6226: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6229: ifeq +12 -> 6241
    //   6232: ldc 209
    //   6234: iconst_4
    //   6235: ldc_w 3295
    //   6238: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6241: aload_1
    //   6242: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6245: iconst_0
    //   6246: putfield 3227	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isFullScreen	Z
    //   6249: aload_0
    //   6250: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6253: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   6256: invokevirtual 3231	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6259: sipush 1024
    //   6262: invokevirtual 3298	android/view/Window:clearFlags	(I)V
    //   6265: aload_3
    //   6266: invokevirtual 3301	com/tencent/mobileqq/webview/swift/WebViewFragment:showVirtualNavBar	()V
    //   6269: aload_3
    //   6270: iconst_1
    //   6271: invokevirtual 3241	com/tencent/mobileqq/webview/swift/WebViewFragment:doShowTitleBar	(Z)V
    //   6274: goto -6090 -> 184
    //   6277: ldc_w 3303
    //   6280: aload 4
    //   6282: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6285: ifeq +484 -> 6769
    //   6288: aload 5
    //   6290: arraylength
    //   6291: iconst_1
    //   6292: if_icmpgt +477 -> 6769
    //   6295: new 113	org/json/JSONObject
    //   6298: dup
    //   6299: aload 5
    //   6301: iconst_0
    //   6302: aaload
    //   6303: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6306: astore_1
    //   6307: aload_0
    //   6308: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6311: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   6314: instanceof 386
    //   6317: ifne +5 -> 6322
    //   6320: iconst_1
    //   6321: ireturn
    //   6322: new 3305	aasb
    //   6325: dup
    //   6326: invokespecial 3306	aasb:<init>	()V
    //   6329: astore_2
    //   6330: aload_1
    //   6331: ldc_w 3308
    //   6334: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6337: ifeq +18 -> 6355
    //   6340: aload_2
    //   6341: aload_1
    //   6342: ldc_w 3308
    //   6345: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6348: ldc_w 1975
    //   6351: ior
    //   6352: putfield 3309	aasb:jdField_a_of_type_Int	I
    //   6355: aload_1
    //   6356: ldc_w 809
    //   6359: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6362: ifeq +14 -> 6376
    //   6365: aload_2
    //   6366: aload_1
    //   6367: ldc_w 809
    //   6370: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6373: putfield 3310	aasb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6376: aload_1
    //   6377: ldc_w 3312
    //   6380: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6383: ifeq +176 -> 6559
    //   6386: aload_2
    //   6387: new 1819	java/util/ArrayList
    //   6390: dup
    //   6391: invokespecial 2220	java/util/ArrayList:<init>	()V
    //   6394: putfield 3315	aasb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6397: aload_1
    //   6398: ldc_w 3312
    //   6401: invokevirtual 1037	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6404: astore_3
    //   6405: aload_3
    //   6406: invokevirtual 1608	org/json/JSONArray:length	()I
    //   6409: istore 7
    //   6411: iconst_0
    //   6412: istore 6
    //   6414: iload 6
    //   6416: iload 7
    //   6418: if_icmpge +141 -> 6559
    //   6421: aload_3
    //   6422: iload 6
    //   6424: invokevirtual 3318	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6427: astore 4
    //   6429: new 3320	aasa
    //   6432: dup
    //   6433: invokespecial 3321	aasa:<init>	()V
    //   6436: astore 5
    //   6438: aload 4
    //   6440: ldc_w 799
    //   6443: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6446: ifeq +16 -> 6462
    //   6449: aload 5
    //   6451: aload 4
    //   6453: ldc_w 799
    //   6456: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6459: putfield 3322	aasa:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6462: aload 4
    //   6464: ldc_w 2277
    //   6467: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6470: ifeq +16 -> 6486
    //   6473: aload 5
    //   6475: aload 4
    //   6477: ldc_w 2277
    //   6480: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6483: putfield 3323	aasa:jdField_a_of_type_Int	I
    //   6486: aload 4
    //   6488: ldc_w 3325
    //   6491: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6494: ifeq +16 -> 6510
    //   6497: aload 5
    //   6499: aload 4
    //   6501: ldc_w 3325
    //   6504: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6507: putfield 3326	aasa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6510: aload 4
    //   6512: ldc_w 1803
    //   6515: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6518: ifeq +20 -> 6538
    //   6521: aload 5
    //   6523: aload 4
    //   6525: ldc_w 1803
    //   6528: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6531: ldc_w 1975
    //   6534: ior
    //   6535: putfield 3327	aasa:jdField_b_of_type_Int	I
    //   6538: aload_2
    //   6539: getfield 3315	aasb:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6542: aload 5
    //   6544: invokeinterface 2322 2 0
    //   6549: pop
    //   6550: iload 6
    //   6552: iconst_1
    //   6553: iadd
    //   6554: istore 6
    //   6556: goto -142 -> 6414
    //   6559: aload_1
    //   6560: ldc_w 3329
    //   6563: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6566: ifeq +78 -> 6644
    //   6569: aload_2
    //   6570: new 1819	java/util/ArrayList
    //   6573: dup
    //   6574: invokespecial 2220	java/util/ArrayList:<init>	()V
    //   6577: putfield 3331	aasb:b	Ljava/util/List;
    //   6580: aload_1
    //   6581: ldc_w 3329
    //   6584: invokevirtual 1037	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6587: astore_1
    //   6588: aload_1
    //   6589: invokevirtual 1608	org/json/JSONArray:length	()I
    //   6592: istore 7
    //   6594: iconst_0
    //   6595: istore 6
    //   6597: iload 6
    //   6599: iload 7
    //   6601: if_icmpge +43 -> 6644
    //   6604: aload_1
    //   6605: iload 6
    //   6607: invokevirtual 3318	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6610: ldc 160
    //   6612: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6615: ifeq +10967 -> 17582
    //   6618: aload_1
    //   6619: iload 6
    //   6621: invokevirtual 3318	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6624: ldc 160
    //   6626: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6629: astore_3
    //   6630: aload_2
    //   6631: getfield 3331	aasb:b	Ljava/util/List;
    //   6634: aload_3
    //   6635: invokeinterface 2322 2 0
    //   6640: pop
    //   6641: goto +10941 -> 17582
    //   6644: aload_0
    //   6645: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6648: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6651: astore_1
    //   6652: aload_1
    //   6653: ifnull +10834 -> 17487
    //   6656: aload_1
    //   6657: invokevirtual 2408	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6660: astore_1
    //   6661: aload_1
    //   6662: ifnull +10825 -> 17487
    //   6665: aload_1
    //   6666: ldc_w 3333
    //   6669: invokevirtual 3336	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6672: astore_1
    //   6673: aload_1
    //   6674: ifnull +10813 -> 17487
    //   6677: aload_1
    //   6678: instanceof 184
    //   6681: ifeq +10806 -> 17487
    //   6684: aload_1
    //   6685: checkcast 184	aart
    //   6688: astore_1
    //   6689: aload_1
    //   6690: ifnull -6506 -> 184
    //   6693: aload_1
    //   6694: aload_2
    //   6695: invokevirtual 3339	aart:a	(Laasb;)V
    //   6698: aload_2
    //   6699: getfield 3310	aasb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6702: ifnull -6518 -> 184
    //   6705: aload_1
    //   6706: invokestatic 3341	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Laart;)Ljava/lang/String;
    //   6709: astore_1
    //   6710: aload_1
    //   6711: ifnull -6527 -> 184
    //   6714: aload_0
    //   6715: aload_2
    //   6716: getfield 3310	aasb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6719: iconst_1
    //   6720: anewarray 285	java/lang/String
    //   6723: dup
    //   6724: iconst_0
    //   6725: aload_1
    //   6726: aastore
    //   6727: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6730: goto -6546 -> 184
    //   6733: astore_1
    //   6734: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6737: ifeq -6553 -> 184
    //   6740: ldc 209
    //   6742: iconst_4
    //   6743: new 549	java/lang/StringBuilder
    //   6746: dup
    //   6747: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   6750: ldc_w 3343
    //   6753: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6756: aload_1
    //   6757: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6760: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6763: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6766: goto -6582 -> 184
    //   6769: ldc_w 3345
    //   6772: aload 4
    //   6774: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6777: ifeq +176 -> 6953
    //   6780: aload 5
    //   6782: arraylength
    //   6783: iconst_1
    //   6784: if_icmpgt +169 -> 6953
    //   6787: new 113	org/json/JSONObject
    //   6790: dup
    //   6791: aload 5
    //   6793: iconst_0
    //   6794: aaload
    //   6795: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6798: astore_1
    //   6799: aload_0
    //   6800: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6803: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   6806: instanceof 386
    //   6809: ifne +5 -> 6814
    //   6812: iconst_1
    //   6813: ireturn
    //   6814: aload_1
    //   6815: ldc_w 3346
    //   6818: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6821: ifeq -6637 -> 184
    //   6824: aload_1
    //   6825: ldc_w 3346
    //   6828: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6831: istore 12
    //   6833: aload_1
    //   6834: ldc_w 3348
    //   6837: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6840: ifeq +10641 -> 17481
    //   6843: aload_1
    //   6844: ldc_w 3348
    //   6847: invokevirtual 3175	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   6850: ldc2_w 3176
    //   6853: dmul
    //   6854: d2i
    //   6855: istore 6
    //   6857: aload_0
    //   6858: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6861: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6864: astore_1
    //   6865: aload_1
    //   6866: ifnull +10610 -> 17476
    //   6869: aload_1
    //   6870: invokevirtual 2408	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6873: astore_1
    //   6874: aload_1
    //   6875: ifnull +10601 -> 17476
    //   6878: aload_1
    //   6879: ldc_w 3333
    //   6882: invokevirtual 3336	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6885: astore_1
    //   6886: aload_1
    //   6887: ifnull +10589 -> 17476
    //   6890: aload_1
    //   6891: instanceof 184
    //   6894: ifeq +10582 -> 17476
    //   6897: aload_1
    //   6898: checkcast 184	aart
    //   6901: astore_1
    //   6902: aload_1
    //   6903: ifnull -6719 -> 184
    //   6906: aload_1
    //   6907: iload 12
    //   6909: iload 6
    //   6911: invokevirtual 3349	aart:a	(ZI)V
    //   6914: goto -6730 -> 184
    //   6917: astore_1
    //   6918: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6921: ifeq -6737 -> 184
    //   6924: ldc 209
    //   6926: iconst_4
    //   6927: new 549	java/lang/StringBuilder
    //   6930: dup
    //   6931: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   6934: ldc_w 3351
    //   6937: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6940: aload_1
    //   6941: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6944: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6947: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6950: goto -6766 -> 184
    //   6953: ldc_w 3353
    //   6956: aload 4
    //   6958: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6961: ifeq +226 -> 7187
    //   6964: aload 5
    //   6966: arraylength
    //   6967: iconst_1
    //   6968: if_icmpgt +219 -> 7187
    //   6971: new 113	org/json/JSONObject
    //   6974: dup
    //   6975: aload 5
    //   6977: iconst_0
    //   6978: aaload
    //   6979: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   6982: astore_1
    //   6983: aload_0
    //   6984: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   6987: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   6990: instanceof 386
    //   6993: ifne +5 -> 6998
    //   6996: iconst_1
    //   6997: ireturn
    //   6998: new 3320	aasa
    //   7001: dup
    //   7002: invokespecial 3321	aasa:<init>	()V
    //   7005: astore_2
    //   7006: aload_1
    //   7007: ldc_w 799
    //   7010: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7013: ifeq +14 -> 7027
    //   7016: aload_2
    //   7017: aload_1
    //   7018: ldc_w 799
    //   7021: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7024: putfield 3322	aasa:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7027: aload_1
    //   7028: ldc_w 2277
    //   7031: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7034: ifeq +14 -> 7048
    //   7037: aload_2
    //   7038: aload_1
    //   7039: ldc_w 2277
    //   7042: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7045: putfield 3323	aasa:jdField_a_of_type_Int	I
    //   7048: aload_1
    //   7049: ldc_w 3325
    //   7052: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7055: ifeq +14 -> 7069
    //   7058: aload_2
    //   7059: aload_1
    //   7060: ldc_w 3325
    //   7063: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7066: putfield 3326	aasa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7069: aload_1
    //   7070: ldc_w 1803
    //   7073: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7076: ifeq +18 -> 7094
    //   7079: aload_2
    //   7080: aload_1
    //   7081: ldc_w 1803
    //   7084: invokestatic 3046	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   7087: ldc_w 1975
    //   7090: ior
    //   7091: putfield 3327	aasa:jdField_b_of_type_Int	I
    //   7094: aload_0
    //   7095: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7098: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7101: astore_1
    //   7102: aload_1
    //   7103: ifnull +10368 -> 17471
    //   7106: aload_1
    //   7107: invokevirtual 2408	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7110: astore_1
    //   7111: aload_1
    //   7112: ifnull +10359 -> 17471
    //   7115: aload_1
    //   7116: ldc_w 3333
    //   7119: invokevirtual 3336	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7122: astore_1
    //   7123: aload_1
    //   7124: ifnull +10347 -> 17471
    //   7127: aload_1
    //   7128: instanceof 184
    //   7131: ifeq +10340 -> 17471
    //   7134: aload_1
    //   7135: checkcast 184	aart
    //   7138: astore_1
    //   7139: aload_1
    //   7140: ifnull -6956 -> 184
    //   7143: aload_1
    //   7144: aload_2
    //   7145: invokevirtual 3356	aart:a	(Laasa;)V
    //   7148: goto -6964 -> 184
    //   7151: astore_1
    //   7152: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7155: ifeq -6971 -> 184
    //   7158: ldc 209
    //   7160: iconst_4
    //   7161: new 549	java/lang/StringBuilder
    //   7164: dup
    //   7165: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   7168: ldc_w 3358
    //   7171: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7174: aload_1
    //   7175: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7178: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7181: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7184: goto -7000 -> 184
    //   7187: ldc_w 3360
    //   7190: aload 4
    //   7192: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7195: ifeq +110 -> 7305
    //   7198: aload 5
    //   7200: arraylength
    //   7201: iconst_1
    //   7202: if_icmpgt +103 -> 7305
    //   7205: aload 5
    //   7207: arraylength
    //   7208: iconst_1
    //   7209: if_icmpne +22 -> 7231
    //   7212: new 113	org/json/JSONObject
    //   7215: dup
    //   7216: aload 5
    //   7218: iconst_0
    //   7219: aaload
    //   7220: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7223: ldc_w 3362
    //   7226: iconst_0
    //   7227: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7230: pop
    //   7231: aload_0
    //   7232: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7235: aload_0
    //   7236: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7239: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   7242: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   7245: astore_1
    //   7246: aload_1
    //   7247: ifnull -7063 -> 184
    //   7250: aload_1
    //   7251: instanceof 3364
    //   7254: ifeq -7070 -> 184
    //   7257: aload_1
    //   7258: checkcast 3364	bikm
    //   7261: invokeinterface 3366 1 0
    //   7266: goto -7082 -> 184
    //   7269: astore_1
    //   7270: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7273: ifeq -7089 -> 184
    //   7276: ldc 209
    //   7278: iconst_4
    //   7279: new 549	java/lang/StringBuilder
    //   7282: dup
    //   7283: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   7286: ldc_w 3368
    //   7289: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: aload_1
    //   7293: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7296: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7299: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7302: goto -7118 -> 184
    //   7305: ldc_w 3370
    //   7308: aload 4
    //   7310: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7313: ifeq +195 -> 7508
    //   7316: aload 5
    //   7318: arraylength
    //   7319: iconst_1
    //   7320: if_icmpne +188 -> 7508
    //   7323: new 113	org/json/JSONObject
    //   7326: dup
    //   7327: aload 5
    //   7329: iconst_0
    //   7330: aaload
    //   7331: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7334: astore_1
    //   7335: aload_1
    //   7336: ldc_w 1544
    //   7339: iconst_0
    //   7340: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7343: istore 6
    //   7345: aload_1
    //   7346: ldc_w 1551
    //   7349: iconst_0
    //   7350: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7353: istore 7
    //   7355: aload_1
    //   7356: ldc_w 1546
    //   7359: iconst_0
    //   7360: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7363: istore 12
    //   7365: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7368: ifeq +48 -> 7416
    //   7371: ldc 209
    //   7373: iconst_2
    //   7374: new 549	java/lang/StringBuilder
    //   7377: dup
    //   7378: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   7381: ldc_w 3372
    //   7384: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7387: aload_1
    //   7388: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7391: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7394: ldc_w 3374
    //   7397: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7400: aload_0
    //   7401: getfield 98	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7404: invokevirtual 1554	java/lang/Object:toString	()Ljava/lang/String;
    //   7407: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7410: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7413: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7416: invokestatic 619	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7419: new 129	android/content/Intent
    //   7422: dup
    //   7423: ldc_w 2568
    //   7426: invokespecial 134	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7429: ldc_w 1544
    //   7432: iload 6
    //   7434: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7437: ldc_w 1546
    //   7440: iload 12
    //   7442: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7445: ldc_w 1551
    //   7448: iload 7
    //   7450: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7453: ldc_w 1553
    //   7456: aload_0
    //   7457: getfield 1558	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7460: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7463: ldc_w 2570
    //   7466: invokevirtual 3379	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7469: goto -7285 -> 184
    //   7472: astore_1
    //   7473: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7476: ifeq -7292 -> 184
    //   7479: ldc 209
    //   7481: iconst_4
    //   7482: new 549	java/lang/StringBuilder
    //   7485: dup
    //   7486: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   7489: ldc_w 3381
    //   7492: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7495: aload_1
    //   7496: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7499: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7502: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7505: goto -7321 -> 184
    //   7508: ldc_w 3383
    //   7511: aload 4
    //   7513: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7516: ifeq +258 -> 7774
    //   7519: aload 5
    //   7521: arraylength
    //   7522: iconst_1
    //   7523: if_icmpne +251 -> 7774
    //   7526: aload_0
    //   7527: aconst_null
    //   7528: putfield 3385	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7531: new 113	org/json/JSONObject
    //   7534: dup
    //   7535: aload 5
    //   7537: iconst_0
    //   7538: aaload
    //   7539: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7542: astore_3
    //   7543: aload_3
    //   7544: ldc_w 590
    //   7547: invokevirtual 2699	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7550: lstore 10
    //   7552: aload_3
    //   7553: ldc_w 3387
    //   7556: bipush 13
    //   7558: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7561: istore 6
    //   7563: aload_3
    //   7564: ldc_w 3389
    //   7567: iconst_0
    //   7568: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7571: istore 7
    //   7573: aload_3
    //   7574: ldc_w 809
    //   7577: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7580: astore_1
    //   7581: aload_0
    //   7582: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7585: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   7588: astore_2
    //   7589: aload_2
    //   7590: ifnull +10 -> 7600
    //   7593: aload_2
    //   7594: invokevirtual 3392	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7597: ifne +20 -> 7617
    //   7600: aload_0
    //   7601: aload_1
    //   7602: iconst_1
    //   7603: anewarray 285	java/lang/String
    //   7606: dup
    //   7607: iconst_0
    //   7608: ldc_w 3394
    //   7611: aastore
    //   7612: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7615: iconst_1
    //   7616: ireturn
    //   7617: aload_3
    //   7618: ldc_w 2724
    //   7621: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7624: astore_3
    //   7625: aload_3
    //   7626: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7629: ifne +31 -> 7660
    //   7632: aload_3
    //   7633: aload_2
    //   7634: invokevirtual 1691	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7637: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7640: ifne +20 -> 7660
    //   7643: aload_0
    //   7644: aload_1
    //   7645: iconst_1
    //   7646: anewarray 285	java/lang/String
    //   7649: dup
    //   7650: iconst_0
    //   7651: ldc_w 3396
    //   7654: aastore
    //   7655: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7658: iconst_1
    //   7659: ireturn
    //   7660: aload_0
    //   7661: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7664: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   7667: astore_2
    //   7668: aload_2
    //   7669: ifnull -7485 -> 184
    //   7672: aload_0
    //   7673: aload_1
    //   7674: putfield 3385	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7677: new 129	android/content/Intent
    //   7680: dup
    //   7681: aload_2
    //   7682: ldc_w 3398
    //   7685: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7688: astore_1
    //   7689: aload_1
    //   7690: ldc_w 1575
    //   7693: bipush 16
    //   7695: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7698: pop
    //   7699: aload_1
    //   7700: ldc_w 3387
    //   7703: iload 6
    //   7705: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7708: pop
    //   7709: aload_1
    //   7710: ldc_w 590
    //   7713: lload 10
    //   7715: invokevirtual 606	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   7718: pop
    //   7719: aload_1
    //   7720: ldc_w 3389
    //   7723: iload 7
    //   7725: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7728: pop
    //   7729: aload_0
    //   7730: aload_1
    //   7731: iconst_5
    //   7732: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7735: goto -7551 -> 184
    //   7738: astore_1
    //   7739: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7742: ifeq -7558 -> 184
    //   7745: ldc 209
    //   7747: iconst_4
    //   7748: new 549	java/lang/StringBuilder
    //   7751: dup
    //   7752: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   7755: ldc_w 3400
    //   7758: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7761: aload_1
    //   7762: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7765: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7768: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7771: goto -7587 -> 184
    //   7774: ldc_w 3402
    //   7777: aload 4
    //   7779: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7782: ifeq +269 -> 8051
    //   7785: aload 5
    //   7787: arraylength
    //   7788: iconst_1
    //   7789: if_icmpne +262 -> 8051
    //   7792: aload_0
    //   7793: aconst_null
    //   7794: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7797: new 113	org/json/JSONObject
    //   7800: dup
    //   7801: aload 5
    //   7803: iconst_0
    //   7804: aaload
    //   7805: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7808: astore_3
    //   7809: aload_0
    //   7810: aload_3
    //   7811: ldc_w 2724
    //   7814: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7817: putfield 3404	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7820: aload_3
    //   7821: ldc_w 3406
    //   7824: iconst_0
    //   7825: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7828: istore 6
    //   7830: aload_0
    //   7831: aload_3
    //   7832: ldc_w 3408
    //   7835: iconst_0
    //   7836: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7839: putfield 3410	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7842: aload_3
    //   7843: ldc_w 809
    //   7846: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7849: astore_1
    //   7850: aload_0
    //   7851: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7854: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   7857: astore_2
    //   7858: aload_2
    //   7859: ifnull +10 -> 7869
    //   7862: aload_2
    //   7863: invokevirtual 3392	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7866: ifne +20 -> 7886
    //   7869: aload_0
    //   7870: aload_1
    //   7871: iconst_1
    //   7872: anewarray 285	java/lang/String
    //   7875: dup
    //   7876: iconst_0
    //   7877: ldc_w 3412
    //   7880: aastore
    //   7881: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7884: iconst_1
    //   7885: ireturn
    //   7886: aload_0
    //   7887: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   7890: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   7893: astore_2
    //   7894: aload_2
    //   7895: ifnull -7711 -> 184
    //   7898: iload 6
    //   7900: ifne -7716 -> 184
    //   7903: aload_3
    //   7904: ldc_w 425
    //   7907: aload_2
    //   7908: ldc_w 3413
    //   7911: invokevirtual 856	android/app/Activity:getString	(I)Ljava/lang/String;
    //   7914: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7917: astore_3
    //   7918: aload_0
    //   7919: aload_1
    //   7920: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7923: aload_0
    //   7924: getfield 3410	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7927: ifeq +101 -> 8028
    //   7930: new 129	android/content/Intent
    //   7933: dup
    //   7934: aload_2
    //   7935: ldc_w 3415
    //   7938: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7941: astore_1
    //   7942: aload_1
    //   7943: ldc_w 3417
    //   7946: iconst_1
    //   7947: invokevirtual 603	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7950: pop
    //   7951: aload_1
    //   7952: ldc_w 3419
    //   7955: aload_0
    //   7956: getfield 3404	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7959: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7962: pop
    //   7963: aload_1
    //   7964: ldc_w 3421
    //   7967: aload_3
    //   7968: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7971: pop
    //   7972: aload_0
    //   7973: aload_1
    //   7974: bipush 7
    //   7976: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7979: aload_2
    //   7980: ldc_w 3422
    //   7983: ldc_w 3423
    //   7986: invokevirtual 412	android/app/Activity:overridePendingTransition	(II)V
    //   7989: goto -7805 -> 184
    //   7992: astore_1
    //   7993: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7996: ifeq -7812 -> 184
    //   7999: ldc 209
    //   8001: iconst_4
    //   8002: new 549	java/lang/StringBuilder
    //   8005: dup
    //   8006: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8009: ldc_w 3425
    //   8012: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8015: aload_1
    //   8016: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8019: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8022: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8025: goto -7841 -> 184
    //   8028: aload_2
    //   8029: aload_0
    //   8030: getfield 3404	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8033: bipush 14
    //   8035: invokestatic 2708	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   8038: astore_1
    //   8039: aload_1
    //   8040: ldc_w 3427
    //   8043: aload_3
    //   8044: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8047: pop
    //   8048: goto -76 -> 7972
    //   8051: ldc_w 3429
    //   8054: aload 4
    //   8056: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8059: ifeq +126 -> 8185
    //   8062: aload 5
    //   8064: arraylength
    //   8065: iconst_1
    //   8066: if_icmpne +119 -> 8185
    //   8069: new 113	org/json/JSONObject
    //   8072: dup
    //   8073: aload 5
    //   8075: iconst_0
    //   8076: aaload
    //   8077: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8080: astore_1
    //   8081: aload_1
    //   8082: ldc_w 3431
    //   8085: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8088: ifeq -7904 -> 184
    //   8091: aload_1
    //   8092: ldc_w 3431
    //   8095: invokevirtual 3152	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8098: istore 12
    //   8100: aload_0
    //   8101: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   8104: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   8107: invokevirtual 3432	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
    //   8110: checkcast 1888	android/view/View
    //   8113: astore_1
    //   8114: aload_1
    //   8115: ifnonnull +5 -> 8120
    //   8118: iconst_1
    //   8119: ireturn
    //   8120: aload_1
    //   8121: instanceof 1962
    //   8124: ifne +5 -> 8129
    //   8127: iconst_1
    //   8128: ireturn
    //   8129: aload_0
    //   8130: aload_1
    //   8131: checkcast 1962	com/tencent/biz/ui/RefreshView
    //   8134: putfield 1964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8137: aload_0
    //   8138: getfield 1964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8141: iload 12
    //   8143: invokevirtual 3433	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   8146: goto -7962 -> 184
    //   8149: astore_1
    //   8150: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8153: ifeq -7969 -> 184
    //   8156: ldc 209
    //   8158: iconst_4
    //   8159: new 549	java/lang/StringBuilder
    //   8162: dup
    //   8163: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8166: ldc_w 3435
    //   8169: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8172: aload_1
    //   8173: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8176: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8179: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8182: goto -7998 -> 184
    //   8185: ldc_w 3437
    //   8188: aload 4
    //   8190: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8193: ifeq +443 -> 8636
    //   8196: aload 5
    //   8198: arraylength
    //   8199: iconst_1
    //   8200: if_icmpne +436 -> 8636
    //   8203: aconst_null
    //   8204: astore 4
    //   8206: aconst_null
    //   8207: astore_3
    //   8208: iconst_1
    //   8209: istore 7
    //   8211: aload_3
    //   8212: astore_2
    //   8213: aload 4
    //   8215: astore_1
    //   8216: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8219: ifeq +37 -> 8256
    //   8222: aload_3
    //   8223: astore_2
    //   8224: aload 4
    //   8226: astore_1
    //   8227: ldc 209
    //   8229: iconst_1
    //   8230: new 549	java/lang/StringBuilder
    //   8233: dup
    //   8234: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8237: ldc_w 3439
    //   8240: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8243: aload 5
    //   8245: iconst_0
    //   8246: aaload
    //   8247: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8250: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8253: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8256: aload_3
    //   8257: astore_2
    //   8258: aload 4
    //   8260: astore_1
    //   8261: new 113	org/json/JSONObject
    //   8264: dup
    //   8265: aload 5
    //   8267: iconst_0
    //   8268: aaload
    //   8269: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8272: astore 15
    //   8274: aload_3
    //   8275: astore_2
    //   8276: aload 4
    //   8278: astore_1
    //   8279: aload 15
    //   8281: ldc_w 425
    //   8284: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8287: astore 5
    //   8289: aload_3
    //   8290: astore_2
    //   8291: aload 4
    //   8293: astore_1
    //   8294: aload 15
    //   8296: ldc_w 3325
    //   8299: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8302: astore 14
    //   8304: aload_3
    //   8305: astore_2
    //   8306: aload 4
    //   8308: astore_1
    //   8309: aload 15
    //   8311: ldc_w 809
    //   8314: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8317: astore_3
    //   8318: iload 7
    //   8320: istore 6
    //   8322: aload_3
    //   8323: astore_2
    //   8324: aload_3
    //   8325: astore_1
    //   8326: aload 5
    //   8328: invokevirtual 3440	java/lang/String:length	()I
    //   8331: ifle +71 -> 8402
    //   8334: aload_3
    //   8335: astore_2
    //   8336: aload_3
    //   8337: astore_1
    //   8338: aload_0
    //   8339: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   8342: invokevirtual 1875	bifw:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   8345: astore 4
    //   8347: aload 4
    //   8349: ifnull +219 -> 8568
    //   8352: aload_3
    //   8353: astore_2
    //   8354: aload_3
    //   8355: astore_1
    //   8356: aload 4
    //   8358: getfield 3441	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8361: ifnull +207 -> 8568
    //   8364: aload_3
    //   8365: astore_2
    //   8366: aload_3
    //   8367: astore_1
    //   8368: aload 4
    //   8370: getfield 3441	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8373: getfield 3444	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isNeedSwitchAIOForH5Game	Z
    //   8376: ifeq +75 -> 8451
    //   8379: aload_3
    //   8380: astore_2
    //   8381: aload_3
    //   8382: astore_1
    //   8383: aload 4
    //   8385: aload 5
    //   8387: iconst_m1
    //   8388: aload 14
    //   8390: ldc_w 3446
    //   8393: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   8396: invokevirtual 3450	com/tencent/mobileqq/webview/swift/WebViewFragment:gotoConversationForH5SDK	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   8399: iconst_0
    //   8400: istore 6
    //   8402: aload_3
    //   8403: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8406: ifne -8222 -> 184
    //   8409: aload_0
    //   8410: aload_3
    //   8411: iconst_1
    //   8412: anewarray 285	java/lang/String
    //   8415: dup
    //   8416: iconst_0
    //   8417: new 549	java/lang/StringBuilder
    //   8420: dup
    //   8421: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8424: ldc_w 3452
    //   8427: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8430: iload 6
    //   8432: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8435: ldc_w 1801
    //   8438: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8441: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8444: aastore
    //   8445: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8448: goto -8264 -> 184
    //   8451: aload_3
    //   8452: astore_2
    //   8453: aload_3
    //   8454: astore_1
    //   8455: aload 4
    //   8457: getfield 3441	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8460: getfield 3455	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isNeedSwitchAIO	Z
    //   8463: ifeq -64 -> 8399
    //   8466: aload_3
    //   8467: astore_2
    //   8468: aload_3
    //   8469: astore_1
    //   8470: new 301	android/os/Bundle
    //   8473: dup
    //   8474: invokespecial 302	android/os/Bundle:<init>	()V
    //   8477: astore 14
    //   8479: aload_3
    //   8480: astore_2
    //   8481: aload_3
    //   8482: astore_1
    //   8483: aload 14
    //   8485: ldc_w 3457
    //   8488: aload 5
    //   8490: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8493: aload_3
    //   8494: astore_2
    //   8495: aload_3
    //   8496: astore_1
    //   8497: aload 4
    //   8499: aload 14
    //   8501: invokevirtual 3460	com/tencent/mobileqq/webview/swift/WebViewFragment:goToConversation	(Landroid/os/Bundle;)V
    //   8504: goto -105 -> 8399
    //   8507: astore_3
    //   8508: aload_2
    //   8509: astore_1
    //   8510: ldc 209
    //   8512: iconst_1
    //   8513: ldc_w 3462
    //   8516: aload_3
    //   8517: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8520: aload_2
    //   8521: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8524: ifne -8340 -> 184
    //   8527: aload_0
    //   8528: aload_2
    //   8529: iconst_1
    //   8530: anewarray 285	java/lang/String
    //   8533: dup
    //   8534: iconst_0
    //   8535: new 549	java/lang/StringBuilder
    //   8538: dup
    //   8539: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8542: ldc_w 3452
    //   8545: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8548: iconst_1
    //   8549: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8552: ldc_w 1801
    //   8555: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8558: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8561: aastore
    //   8562: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8565: goto -8381 -> 184
    //   8568: aload_3
    //   8569: astore_2
    //   8570: aload_3
    //   8571: astore_1
    //   8572: ldc 209
    //   8574: iconst_1
    //   8575: ldc_w 3464
    //   8578: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   8581: iload 7
    //   8583: istore 6
    //   8585: goto -183 -> 8402
    //   8588: astore_2
    //   8589: aload_1
    //   8590: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8593: ifne +41 -> 8634
    //   8596: aload_0
    //   8597: aload_1
    //   8598: iconst_1
    //   8599: anewarray 285	java/lang/String
    //   8602: dup
    //   8603: iconst_0
    //   8604: new 549	java/lang/StringBuilder
    //   8607: dup
    //   8608: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8611: ldc_w 3452
    //   8614: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8617: iconst_1
    //   8618: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8621: ldc_w 1801
    //   8624: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8627: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8630: aastore
    //   8631: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8634: aload_2
    //   8635: athrow
    //   8636: ldc_w 1955
    //   8639: aload 4
    //   8641: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8644: ifeq +284 -> 8928
    //   8647: aload 5
    //   8649: arraylength
    //   8650: iconst_1
    //   8651: if_icmpne +277 -> 8928
    //   8654: new 113	org/json/JSONObject
    //   8657: dup
    //   8658: aload 5
    //   8660: iconst_0
    //   8661: aaload
    //   8662: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8665: astore_1
    //   8666: aload_1
    //   8667: ldc_w 3431
    //   8670: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8673: ifeq +135 -> 8808
    //   8676: aload_1
    //   8677: ldc_w 3431
    //   8680: invokevirtual 3152	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8683: istore 13
    //   8685: iconst_0
    //   8686: istore 12
    //   8688: aload_1
    //   8689: ldc 154
    //   8691: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8694: astore_2
    //   8695: aload_1
    //   8696: ldc_w 3466
    //   8699: ldc_w 1975
    //   8702: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8705: istore 6
    //   8707: aload_1
    //   8708: ldc_w 3468
    //   8711: ldc_w 1975
    //   8714: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8717: istore 7
    //   8719: ldc_w 3470
    //   8722: aload_2
    //   8723: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8726: ifeq +6 -> 8732
    //   8729: iconst_1
    //   8730: istore 12
    //   8732: iload 13
    //   8734: aload_0
    //   8735: getfield 3472	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8738: if_icmpeq -8554 -> 184
    //   8741: iload 13
    //   8743: ifeq +58 -> 8801
    //   8746: aload_0
    //   8747: iload 12
    //   8749: iload 6
    //   8751: iload 7
    //   8753: invokevirtual 3474	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZII)V
    //   8756: aload_0
    //   8757: iload 13
    //   8759: putfield 3472	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8762: goto -8578 -> 184
    //   8765: astore_1
    //   8766: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8769: ifeq -8585 -> 184
    //   8772: ldc 209
    //   8774: iconst_4
    //   8775: new 549	java/lang/StringBuilder
    //   8778: dup
    //   8779: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   8782: ldc_w 3435
    //   8785: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8788: aload_1
    //   8789: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8792: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8795: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8798: goto -8614 -> 184
    //   8801: aload_0
    //   8802: invokevirtual 3475	com/tencent/mobileqq/jsp/UiApiPlugin:c	()V
    //   8805: goto -49 -> 8756
    //   8808: aload_1
    //   8809: ldc_w 3477
    //   8812: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8815: ifeq -8631 -> 184
    //   8818: aload_0
    //   8819: getfield 1966	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8822: ifeq -8638 -> 184
    //   8825: aload_0
    //   8826: iconst_0
    //   8827: putfield 1966	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8830: aload_1
    //   8831: ldc_w 3477
    //   8834: invokevirtual 3152	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8837: istore 12
    //   8839: invokestatic 619	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8842: invokevirtual 3478	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   8845: astore_2
    //   8846: aload_0
    //   8847: getfield 1974	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aakn	Laakn;
    //   8850: ifnull +43 -> 8893
    //   8853: iload 12
    //   8855: ifeq +8736 -> 17591
    //   8858: iconst_0
    //   8859: istore 6
    //   8861: iload 12
    //   8863: ifeq +47 -> 8910
    //   8866: aload_1
    //   8867: ldc_w 799
    //   8870: aload_2
    //   8871: ldc_w 3479
    //   8874: invokevirtual 3480	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8877: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8880: astore_1
    //   8881: aload_0
    //   8882: getfield 1974	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aakn	Laakn;
    //   8885: iload 6
    //   8887: aload_1
    //   8888: invokeinterface 3483 3 0
    //   8893: aload_0
    //   8894: getfield 1964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8897: ifnull -8713 -> 184
    //   8900: aload_0
    //   8901: getfield 1964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8904: invokevirtual 3485	com/tencent/biz/ui/RefreshView:b	()V
    //   8907: goto -8723 -> 184
    //   8910: aload_1
    //   8911: ldc_w 799
    //   8914: aload_2
    //   8915: ldc_w 3486
    //   8918: invokevirtual 3480	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8921: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8924: astore_1
    //   8925: goto -44 -> 8881
    //   8928: ldc_w 3488
    //   8931: aload 4
    //   8933: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8936: ifeq +192 -> 9128
    //   8939: aload 5
    //   8941: arraylength
    //   8942: iconst_1
    //   8943: if_icmpne +185 -> 9128
    //   8946: new 113	org/json/JSONObject
    //   8949: dup
    //   8950: aload 5
    //   8952: iconst_0
    //   8953: aaload
    //   8954: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8957: astore_2
    //   8958: aload_2
    //   8959: ldc_w 3490
    //   8962: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8965: istore 6
    //   8967: aload_2
    //   8968: ldc 160
    //   8970: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8973: astore_1
    //   8974: aload_2
    //   8975: ldc 217
    //   8977: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8980: istore 7
    //   8982: aload_0
    //   8983: aload_2
    //   8984: ldc_w 809
    //   8987: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8990: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8993: new 129	android/content/Intent
    //   8996: dup
    //   8997: getstatic 3494	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   9000: ldc_w 3496
    //   9003: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   9006: astore_2
    //   9007: aload_2
    //   9008: ldc_w 3498
    //   9011: iload 6
    //   9013: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9016: pop
    //   9017: aload_2
    //   9018: ldc_w 3500
    //   9021: aload_1
    //   9022: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9025: pop
    //   9026: aload_2
    //   9027: ldc_w 3502
    //   9030: iload 7
    //   9032: invokevirtual 402	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9035: pop
    //   9036: aload_2
    //   9037: ldc_w 3504
    //   9040: bipush 6
    //   9042: invokevirtual 3507	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   9045: pop
    //   9046: aload_0
    //   9047: aload_2
    //   9048: bipush 6
    //   9050: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   9053: goto -8869 -> 184
    //   9056: astore_1
    //   9057: aload_1
    //   9058: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   9061: aload_0
    //   9062: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9065: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9068: ifne -8884 -> 184
    //   9071: aload_0
    //   9072: aload_0
    //   9073: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9076: iconst_1
    //   9077: anewarray 285	java/lang/String
    //   9080: dup
    //   9081: iconst_0
    //   9082: ldc_w 3509
    //   9085: aastore
    //   9086: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9089: goto -8905 -> 184
    //   9092: astore_1
    //   9093: aload_1
    //   9094: invokevirtual 874	java/lang/Exception:printStackTrace	()V
    //   9097: aload_0
    //   9098: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9101: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9104: ifne -8920 -> 184
    //   9107: aload_0
    //   9108: aload_0
    //   9109: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9112: iconst_1
    //   9113: anewarray 285	java/lang/String
    //   9116: dup
    //   9117: iconst_0
    //   9118: ldc_w 3509
    //   9121: aastore
    //   9122: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9125: goto -8941 -> 184
    //   9128: ldc_w 3511
    //   9131: aload 4
    //   9133: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9136: ifeq +250 -> 9386
    //   9139: aload_0
    //   9140: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   9143: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   9146: astore_1
    //   9147: aload_0
    //   9148: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   9151: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   9154: astore_2
    //   9155: aload_1
    //   9156: ifnull -8972 -> 184
    //   9159: aload_2
    //   9160: ifnull -8976 -> 184
    //   9163: aconst_null
    //   9164: astore_2
    //   9165: aload_2
    //   9166: astore_1
    //   9167: new 113	org/json/JSONObject
    //   9170: dup
    //   9171: aload 5
    //   9173: iconst_0
    //   9174: aaload
    //   9175: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9178: astore_3
    //   9179: aload_2
    //   9180: astore_1
    //   9181: aload_3
    //   9182: ldc_w 809
    //   9185: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9188: astore_2
    //   9189: aload_2
    //   9190: astore_1
    //   9191: aload_3
    //   9192: ldc_w 2724
    //   9195: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9198: invokestatic 3515	axqj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9201: astore 4
    //   9203: aload_2
    //   9204: astore_1
    //   9205: aload_3
    //   9206: ldc_w 3517
    //   9209: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9212: astore 5
    //   9214: aload_2
    //   9215: astore_1
    //   9216: aload_3
    //   9217: ldc_w 1041
    //   9220: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9223: istore 7
    //   9225: iconst_0
    //   9226: istore 6
    //   9228: aload_2
    //   9229: astore_1
    //   9230: aload_3
    //   9231: ldc_w 3519
    //   9234: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9237: ifeq +14 -> 9251
    //   9240: aload_2
    //   9241: astore_1
    //   9242: aload_3
    //   9243: ldc_w 3519
    //   9246: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9249: istore 6
    //   9251: aload_2
    //   9252: astore_1
    //   9253: new 301	android/os/Bundle
    //   9256: dup
    //   9257: invokespecial 302	android/os/Bundle:<init>	()V
    //   9260: astore_3
    //   9261: aload_2
    //   9262: astore_1
    //   9263: aload_3
    //   9264: ldc_w 2724
    //   9267: aload 4
    //   9269: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9272: aload 5
    //   9274: ifnull +14 -> 9288
    //   9277: aload_2
    //   9278: astore_1
    //   9279: aload_3
    //   9280: ldc_w 3517
    //   9283: aload 5
    //   9285: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9288: aload_2
    //   9289: astore_1
    //   9290: aload_3
    //   9291: ldc_w 3521
    //   9294: iload 7
    //   9296: invokevirtual 594	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9299: aload_2
    //   9300: astore_1
    //   9301: aload_3
    //   9302: ldc_w 1726
    //   9305: ldc_w 3511
    //   9308: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9311: aload_2
    //   9312: astore_1
    //   9313: aload_3
    //   9314: ldc_w 3519
    //   9317: iload 6
    //   9319: invokevirtual 594	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9322: aload_2
    //   9323: astore_1
    //   9324: ldc_w 3523
    //   9327: aload_2
    //   9328: aload_0
    //   9329: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Ascz	Lascz;
    //   9332: getfield 3528	ascz:key	I
    //   9335: aload_3
    //   9336: invokestatic 3533	asdd:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9339: astore_3
    //   9340: aload_2
    //   9341: astore_1
    //   9342: invokestatic 3538	ashz:a	()Lashz;
    //   9345: aload_3
    //   9346: invokevirtual 3539	ashz:a	(Landroid/os/Bundle;)V
    //   9349: goto -9165 -> 184
    //   9352: astore_2
    //   9353: aload_1
    //   9354: ifnull -9170 -> 184
    //   9357: aload_0
    //   9358: aload_1
    //   9359: iconst_1
    //   9360: anewarray 285	java/lang/String
    //   9363: dup
    //   9364: iconst_0
    //   9365: ldc_w 3541
    //   9368: iconst_1
    //   9369: anewarray 277	java/lang/Object
    //   9372: dup
    //   9373: iconst_0
    //   9374: aload_2
    //   9375: aastore
    //   9376: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9379: aastore
    //   9380: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9383: goto -9199 -> 184
    //   9386: ldc_w 3543
    //   9389: aload 4
    //   9391: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9394: ifeq +403 -> 9797
    //   9397: aload_0
    //   9398: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   9401: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   9404: astore_1
    //   9405: aload_0
    //   9406: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   9409: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   9412: astore_2
    //   9413: aload_1
    //   9414: ifnull -9230 -> 184
    //   9417: aload_2
    //   9418: ifnull -9234 -> 184
    //   9421: aconst_null
    //   9422: astore_2
    //   9423: aconst_null
    //   9424: astore 4
    //   9426: aload_2
    //   9427: astore_1
    //   9428: new 113	org/json/JSONObject
    //   9431: dup
    //   9432: aload 5
    //   9434: iconst_0
    //   9435: aaload
    //   9436: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9439: astore 14
    //   9441: aload_2
    //   9442: astore_1
    //   9443: aload 14
    //   9445: ldc_w 809
    //   9448: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9451: astore_3
    //   9452: aload_3
    //   9453: astore_1
    //   9454: aload 14
    //   9456: ldc_w 2724
    //   9459: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9462: invokestatic 3515	axqj:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9465: astore_2
    //   9466: aload_3
    //   9467: astore_1
    //   9468: aload 14
    //   9470: ldc_w 2722
    //   9473: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9476: astore 5
    //   9478: aload_3
    //   9479: astore_1
    //   9480: aload 14
    //   9482: ldc_w 3545
    //   9485: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9488: astore 15
    //   9490: iconst_0
    //   9491: istore 12
    //   9493: aload_3
    //   9494: astore_1
    //   9495: aload 5
    //   9497: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9500: ifne +7968 -> 17468
    //   9503: iconst_1
    //   9504: istore 12
    //   9506: aload 5
    //   9508: astore_2
    //   9509: aload_3
    //   9510: astore_1
    //   9511: aload 14
    //   9513: ldc_w 3517
    //   9516: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9519: astore 5
    //   9521: aload_3
    //   9522: astore_1
    //   9523: aload 14
    //   9525: ldc_w 1041
    //   9528: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9531: istore 6
    //   9533: aload_3
    //   9534: astore_1
    //   9535: aload 14
    //   9537: ldc_w 3547
    //   9540: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9543: istore 7
    //   9545: aload_3
    //   9546: astore_1
    //   9547: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9550: ifeq +35 -> 9585
    //   9553: aload_3
    //   9554: astore_1
    //   9555: ldc 209
    //   9557: iconst_2
    //   9558: new 549	java/lang/StringBuilder
    //   9561: dup
    //   9562: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   9565: ldc_w 3549
    //   9568: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9571: aload 14
    //   9573: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9576: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9579: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9582: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9585: aload_3
    //   9586: astore_1
    //   9587: aload_2
    //   9588: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9591: ifne +178 -> 9769
    //   9594: aload_3
    //   9595: astore_1
    //   9596: new 301	android/os/Bundle
    //   9599: dup
    //   9600: invokespecial 302	android/os/Bundle:<init>	()V
    //   9603: astore 14
    //   9605: aload_3
    //   9606: astore_1
    //   9607: aload 14
    //   9609: ldc_w 1041
    //   9612: iload 6
    //   9614: invokevirtual 594	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9617: aload_3
    //   9618: astore_1
    //   9619: aload 14
    //   9621: ldc_w 2724
    //   9624: aload_2
    //   9625: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9628: aload_3
    //   9629: astore_1
    //   9630: aload 14
    //   9632: ldc_w 3551
    //   9635: iload 12
    //   9637: invokevirtual 376	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9640: aload_3
    //   9641: astore_1
    //   9642: aload 14
    //   9644: ldc_w 1726
    //   9647: ldc_w 3543
    //   9650: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9653: aload_3
    //   9654: astore_1
    //   9655: aload 14
    //   9657: ldc_w 3547
    //   9660: iload 7
    //   9662: invokevirtual 594	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9665: aload_3
    //   9666: astore_1
    //   9667: aload 5
    //   9669: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9672: ifne +15 -> 9687
    //   9675: aload_3
    //   9676: astore_1
    //   9677: aload 14
    //   9679: ldc_w 3517
    //   9682: aload 5
    //   9684: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9687: aload_3
    //   9688: astore_1
    //   9689: aload 15
    //   9691: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9694: ifne +15 -> 9709
    //   9697: aload_3
    //   9698: astore_1
    //   9699: aload 14
    //   9701: ldc_w 3545
    //   9704: aload 15
    //   9706: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9709: aload_3
    //   9710: astore_1
    //   9711: ldc_w 3523
    //   9714: aload_3
    //   9715: aload_0
    //   9716: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Ascz	Lascz;
    //   9719: getfield 3528	ascz:key	I
    //   9722: aload 14
    //   9724: invokestatic 3533	asdd:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9727: astore_2
    //   9728: aload_3
    //   9729: astore_1
    //   9730: invokestatic 3538	ashz:a	()Lashz;
    //   9733: aload_2
    //   9734: invokevirtual 3539	ashz:a	(Landroid/os/Bundle;)V
    //   9737: aload_3
    //   9738: astore_1
    //   9739: aload 4
    //   9741: astore_2
    //   9742: aload_2
    //   9743: ifnull -9559 -> 184
    //   9746: aload_1
    //   9747: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9750: ifne -9566 -> 184
    //   9753: aload_0
    //   9754: aload_1
    //   9755: iconst_1
    //   9756: anewarray 285	java/lang/String
    //   9759: dup
    //   9760: iconst_0
    //   9761: aload_2
    //   9762: aastore
    //   9763: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9766: goto -9582 -> 184
    //   9769: ldc_w 3553
    //   9772: astore_2
    //   9773: aload_3
    //   9774: astore_1
    //   9775: goto -33 -> 9742
    //   9778: astore_2
    //   9779: ldc_w 3541
    //   9782: iconst_1
    //   9783: anewarray 277	java/lang/Object
    //   9786: dup
    //   9787: iconst_0
    //   9788: aload_2
    //   9789: aastore
    //   9790: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9793: astore_2
    //   9794: goto -52 -> 9742
    //   9797: ldc_w 3555
    //   9800: aload 4
    //   9802: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9805: ifeq +196 -> 10001
    //   9808: aconst_null
    //   9809: astore_2
    //   9810: aload_2
    //   9811: astore_1
    //   9812: new 113	org/json/JSONObject
    //   9815: dup
    //   9816: aload 5
    //   9818: iconst_0
    //   9819: aaload
    //   9820: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9823: astore_3
    //   9824: aload_2
    //   9825: astore_1
    //   9826: aload_3
    //   9827: ldc_w 809
    //   9830: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9833: astore_2
    //   9834: aload_2
    //   9835: astore_1
    //   9836: aload_3
    //   9837: ldc_w 3431
    //   9840: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9843: ifeq -9659 -> 184
    //   9846: aload_2
    //   9847: astore_1
    //   9848: aload_3
    //   9849: ldc_w 3431
    //   9852: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   9855: istore 12
    //   9857: aload_2
    //   9858: astore_1
    //   9859: aload_0
    //   9860: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   9863: aload_0
    //   9864: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   9867: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   9870: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   9873: astore_3
    //   9874: aload_3
    //   9875: ifnull +83 -> 9958
    //   9878: aload_2
    //   9879: astore_1
    //   9880: aload_3
    //   9881: instanceof 3557
    //   9884: ifeq +74 -> 9958
    //   9887: aload_2
    //   9888: astore_1
    //   9889: aload_3
    //   9890: checkcast 3557	bikf
    //   9893: astore_3
    //   9894: iload 12
    //   9896: ifne +56 -> 9952
    //   9899: iconst_1
    //   9900: istore 12
    //   9902: aload_2
    //   9903: astore_1
    //   9904: aload_3
    //   9905: iload 12
    //   9907: invokeinterface 3558 2 0
    //   9912: goto -9728 -> 184
    //   9915: astore_2
    //   9916: aload_1
    //   9917: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9920: ifne -9736 -> 184
    //   9923: aload_0
    //   9924: aload_1
    //   9925: iconst_1
    //   9926: anewarray 285	java/lang/String
    //   9929: dup
    //   9930: iconst_0
    //   9931: ldc_w 3541
    //   9934: iconst_1
    //   9935: anewarray 277	java/lang/Object
    //   9938: dup
    //   9939: iconst_0
    //   9940: aload_2
    //   9941: aastore
    //   9942: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9945: aastore
    //   9946: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9949: goto -9765 -> 184
    //   9952: iconst_0
    //   9953: istore 12
    //   9955: goto -53 -> 9902
    //   9958: aload_2
    //   9959: astore_1
    //   9960: aload_0
    //   9961: iconst_m1
    //   9962: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   9965: checkcast 3560	bihn
    //   9968: astore_3
    //   9969: aload_3
    //   9970: ifnull -9786 -> 184
    //   9973: iload 12
    //   9975: ifne +20 -> 9995
    //   9978: iconst_1
    //   9979: istore 12
    //   9981: aload_2
    //   9982: astore_1
    //   9983: aload_3
    //   9984: ldc_w 3562
    //   9987: iload 12
    //   9989: invokevirtual 3564	bihn:a	(Ljava/lang/String;Z)V
    //   9992: goto -9808 -> 184
    //   9995: iconst_0
    //   9996: istore 12
    //   9998: goto -17 -> 9981
    //   10001: ldc_w 3566
    //   10004: aload 4
    //   10006: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10009: ifeq +196 -> 10205
    //   10012: aconst_null
    //   10013: astore_2
    //   10014: aload_2
    //   10015: astore_1
    //   10016: new 113	org/json/JSONObject
    //   10019: dup
    //   10020: aload 5
    //   10022: iconst_0
    //   10023: aaload
    //   10024: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10027: astore_3
    //   10028: aload_2
    //   10029: astore_1
    //   10030: aload_3
    //   10031: ldc_w 809
    //   10034: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10037: astore_2
    //   10038: aload_2
    //   10039: astore_1
    //   10040: aload_3
    //   10041: ldc_w 3431
    //   10044: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10047: ifeq -9863 -> 184
    //   10050: aload_2
    //   10051: astore_1
    //   10052: aload_3
    //   10053: ldc_w 3431
    //   10056: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10059: istore 12
    //   10061: aload_2
    //   10062: astore_1
    //   10063: aload_0
    //   10064: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   10067: aload_0
    //   10068: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   10071: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   10074: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   10077: astore_3
    //   10078: aload_3
    //   10079: ifnull +83 -> 10162
    //   10082: aload_2
    //   10083: astore_1
    //   10084: aload_3
    //   10085: instanceof 3557
    //   10088: ifeq +74 -> 10162
    //   10091: aload_2
    //   10092: astore_1
    //   10093: aload_3
    //   10094: checkcast 3557	bikf
    //   10097: astore_3
    //   10098: iload 12
    //   10100: ifne +56 -> 10156
    //   10103: iconst_1
    //   10104: istore 12
    //   10106: aload_2
    //   10107: astore_1
    //   10108: aload_3
    //   10109: iload 12
    //   10111: invokeinterface 3568 2 0
    //   10116: goto -9932 -> 184
    //   10119: astore_2
    //   10120: aload_1
    //   10121: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10124: ifne -9940 -> 184
    //   10127: aload_0
    //   10128: aload_1
    //   10129: iconst_1
    //   10130: anewarray 285	java/lang/String
    //   10133: dup
    //   10134: iconst_0
    //   10135: ldc_w 3541
    //   10138: iconst_1
    //   10139: anewarray 277	java/lang/Object
    //   10142: dup
    //   10143: iconst_0
    //   10144: aload_2
    //   10145: aastore
    //   10146: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10149: aastore
    //   10150: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10153: goto -9969 -> 184
    //   10156: iconst_0
    //   10157: istore 12
    //   10159: goto -53 -> 10106
    //   10162: aload_2
    //   10163: astore_1
    //   10164: aload_0
    //   10165: iconst_m1
    //   10166: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10169: checkcast 3560	bihn
    //   10172: astore_3
    //   10173: aload_3
    //   10174: ifnull -9990 -> 184
    //   10177: iload 12
    //   10179: ifne +20 -> 10199
    //   10182: iconst_1
    //   10183: istore 12
    //   10185: aload_2
    //   10186: astore_1
    //   10187: aload_3
    //   10188: ldc_w 3570
    //   10191: iload 12
    //   10193: invokevirtual 3564	bihn:a	(Ljava/lang/String;Z)V
    //   10196: goto -10012 -> 184
    //   10199: iconst_0
    //   10200: istore 12
    //   10202: goto -17 -> 10185
    //   10205: ldc_w 3572
    //   10208: aload 4
    //   10210: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10213: ifeq +74 -> 10287
    //   10216: new 113	org/json/JSONObject
    //   10219: dup
    //   10220: aload 5
    //   10222: iconst_0
    //   10223: aaload
    //   10224: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10227: astore_1
    //   10228: new 3574	aodf
    //   10231: dup
    //   10232: invokespecial 3575	aodf:<init>	()V
    //   10235: aload_1
    //   10236: ldc_w 3577
    //   10239: invokevirtual 1037	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10242: invokevirtual 3580	aodf:a	(Lorg/json/JSONArray;)V
    //   10245: goto -10061 -> 184
    //   10248: astore_1
    //   10249: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10252: ifeq -10068 -> 184
    //   10255: ldc 209
    //   10257: iconst_2
    //   10258: new 549	java/lang/StringBuilder
    //   10261: dup
    //   10262: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   10265: ldc_w 3582
    //   10268: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10271: aload 5
    //   10273: iconst_0
    //   10274: aaload
    //   10275: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10278: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10281: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10284: goto -10100 -> 184
    //   10287: ldc_w 3584
    //   10290: aload 4
    //   10292: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10295: ifeq +154 -> 10449
    //   10298: new 113	org/json/JSONObject
    //   10301: dup
    //   10302: aload 5
    //   10304: iconst_0
    //   10305: aaload
    //   10306: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10309: ldc_w 809
    //   10312: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10315: astore_1
    //   10316: new 3574	aodf
    //   10319: dup
    //   10320: invokespecial 3575	aodf:<init>	()V
    //   10323: astore 4
    //   10325: new 113	org/json/JSONObject
    //   10328: dup
    //   10329: invokespecial 172	org/json/JSONObject:<init>	()V
    //   10332: astore_2
    //   10333: new 1080	org/json/JSONArray
    //   10336: dup
    //   10337: invokespecial 3585	org/json/JSONArray:<init>	()V
    //   10340: astore_3
    //   10341: aload 4
    //   10343: invokevirtual 3588	aodf:a	()Ljava/util/ArrayList;
    //   10346: astore 4
    //   10348: iconst_0
    //   10349: istore 6
    //   10351: iload 6
    //   10353: aload 4
    //   10355: invokevirtual 3591	java/util/ArrayList:size	()I
    //   10358: if_icmpge +24 -> 10382
    //   10361: aload_3
    //   10362: aload 4
    //   10364: iload 6
    //   10366: invokevirtual 3593	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   10369: invokevirtual 3596	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   10372: pop
    //   10373: iload 6
    //   10375: iconst_1
    //   10376: iadd
    //   10377: istore 6
    //   10379: goto -28 -> 10351
    //   10382: aload_2
    //   10383: ldc_w 3577
    //   10386: aload_3
    //   10387: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   10390: pop
    //   10391: aload_0
    //   10392: aload_1
    //   10393: iconst_1
    //   10394: anewarray 285	java/lang/String
    //   10397: dup
    //   10398: iconst_0
    //   10399: aload_2
    //   10400: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10403: aastore
    //   10404: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10407: goto -10223 -> 184
    //   10410: astore_1
    //   10411: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10414: ifeq -10230 -> 184
    //   10417: ldc 209
    //   10419: iconst_2
    //   10420: new 549	java/lang/StringBuilder
    //   10423: dup
    //   10424: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   10427: ldc_w 3598
    //   10430: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10433: aload 5
    //   10435: iconst_0
    //   10436: aaload
    //   10437: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10440: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10443: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10446: goto -10262 -> 184
    //   10449: ldc_w 3600
    //   10452: aload 4
    //   10454: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10457: ifeq +221 -> 10678
    //   10460: aload_0
    //   10461: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   10464: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   10467: astore 14
    //   10469: aload_0
    //   10470: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   10473: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   10476: astore_1
    //   10477: aload 14
    //   10479: ifnull -10295 -> 184
    //   10482: aload_1
    //   10483: ifnull -10299 -> 184
    //   10486: aconst_null
    //   10487: astore_1
    //   10488: aconst_null
    //   10489: astore 4
    //   10491: new 113	org/json/JSONObject
    //   10494: dup
    //   10495: aload 5
    //   10497: iconst_0
    //   10498: aaload
    //   10499: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10502: astore_3
    //   10503: aload_3
    //   10504: ldc_w 809
    //   10507: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10510: astore_2
    //   10511: aload_2
    //   10512: astore_1
    //   10513: aload_3
    //   10514: ifnull +155 -> 10669
    //   10517: new 301	android/os/Bundle
    //   10520: dup
    //   10521: invokespecial 302	android/os/Bundle:<init>	()V
    //   10524: astore 5
    //   10526: aload 5
    //   10528: ldc_w 3602
    //   10531: aload_3
    //   10532: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10535: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10538: aload 14
    //   10540: invokevirtual 281	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10543: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   10546: ldc_w 3604
    //   10549: invokevirtual 288	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10552: istore 12
    //   10554: aload 4
    //   10556: astore_2
    //   10557: aload_1
    //   10558: astore_3
    //   10559: iload 12
    //   10561: ifeq +41 -> 10602
    //   10564: aconst_null
    //   10565: aload 14
    //   10567: new 113	org/json/JSONObject
    //   10570: dup
    //   10571: aload 5
    //   10573: ldc_w 3602
    //   10576: invokevirtual 3605	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10579: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10582: ldc_w 3607
    //   10585: ldc_w 482
    //   10588: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10591: invokestatic 3611	uqu:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10594: invokestatic 3616	uuc:a	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   10597: aload_1
    //   10598: astore_3
    //   10599: aload 4
    //   10601: astore_2
    //   10602: aload_2
    //   10603: ifnull -10419 -> 184
    //   10606: aload_3
    //   10607: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10610: ifne -10426 -> 184
    //   10613: aload_0
    //   10614: aload_3
    //   10615: iconst_1
    //   10616: anewarray 285	java/lang/String
    //   10619: dup
    //   10620: iconst_0
    //   10621: aload_2
    //   10622: aastore
    //   10623: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10626: goto -10442 -> 184
    //   10629: astore_2
    //   10630: ldc 209
    //   10632: iconst_2
    //   10633: ldc_w 3618
    //   10636: aload_2
    //   10637: invokestatic 2730	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10640: aload 4
    //   10642: astore_2
    //   10643: aload_1
    //   10644: astore_3
    //   10645: goto -43 -> 10602
    //   10648: astore_2
    //   10649: ldc_w 3541
    //   10652: iconst_1
    //   10653: anewarray 277	java/lang/Object
    //   10656: dup
    //   10657: iconst_0
    //   10658: aload_2
    //   10659: aastore
    //   10660: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10663: astore_2
    //   10664: aload_1
    //   10665: astore_3
    //   10666: goto -64 -> 10602
    //   10669: ldc_w 3553
    //   10672: astore_2
    //   10673: aload_1
    //   10674: astore_3
    //   10675: goto -73 -> 10602
    //   10678: ldc_w 3620
    //   10681: aload 4
    //   10683: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10686: ifeq +330 -> 11016
    //   10689: aconst_null
    //   10690: ldc_w 768
    //   10693: ldc_w 770
    //   10696: ldc_w 482
    //   10699: ldc_w 772
    //   10702: ldc_w 3622
    //   10705: iconst_0
    //   10706: iconst_1
    //   10707: iconst_0
    //   10708: aload 5
    //   10710: iconst_0
    //   10711: aaload
    //   10712: ldc_w 482
    //   10715: ldc_w 482
    //   10718: ldc_w 482
    //   10721: invokestatic 779	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10724: aload_0
    //   10725: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   10728: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   10731: astore 14
    //   10733: aload_0
    //   10734: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   10737: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   10740: astore_1
    //   10741: aload 14
    //   10743: ifnull -10559 -> 184
    //   10746: aload_1
    //   10747: ifnull -10563 -> 184
    //   10750: aconst_null
    //   10751: astore_3
    //   10752: aconst_null
    //   10753: astore 4
    //   10755: aload 4
    //   10757: astore_1
    //   10758: aload_3
    //   10759: astore_2
    //   10760: new 113	org/json/JSONObject
    //   10763: dup
    //   10764: aload 5
    //   10766: iconst_0
    //   10767: aaload
    //   10768: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10771: astore 5
    //   10773: aload 4
    //   10775: astore_1
    //   10776: aload_3
    //   10777: astore_2
    //   10778: aload 5
    //   10780: ldc_w 809
    //   10783: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10786: astore_3
    //   10787: aload 4
    //   10789: astore_1
    //   10790: aload_3
    //   10791: astore_2
    //   10792: aload 5
    //   10794: ldc 223
    //   10796: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10799: astore 4
    //   10801: aload 4
    //   10803: astore_1
    //   10804: aload_3
    //   10805: astore_2
    //   10806: aload 5
    //   10808: ldc_w 1726
    //   10811: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10814: astore 15
    //   10816: aload 4
    //   10818: astore_1
    //   10819: aload_3
    //   10820: astore_2
    //   10821: aload 5
    //   10823: ldc 198
    //   10825: invokevirtual 423	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10828: astore 5
    //   10830: aload 4
    //   10832: astore_1
    //   10833: aload_3
    //   10834: astore_2
    //   10835: ldc_w 772
    //   10838: aload 15
    //   10840: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10843: ifeq +6618 -> 17461
    //   10846: aload 5
    //   10848: ifnull +6613 -> 17461
    //   10851: aload 4
    //   10853: astore_1
    //   10854: aload_3
    //   10855: astore_2
    //   10856: aload 5
    //   10858: ldc_w 425
    //   10861: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10864: astore 15
    //   10866: aload 4
    //   10868: astore_1
    //   10869: aload_3
    //   10870: astore_2
    //   10871: aload 5
    //   10873: ldc_w 3325
    //   10876: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10879: astore 16
    //   10881: aload 4
    //   10883: astore_1
    //   10884: aload_3
    //   10885: astore_2
    //   10886: aload 5
    //   10888: ldc 160
    //   10890: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10893: astore 5
    //   10895: aload 4
    //   10897: astore_1
    //   10898: aload_3
    //   10899: astore_2
    //   10900: aload 15
    //   10902: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10905: ifne +67 -> 10972
    //   10908: aload 4
    //   10910: astore_1
    //   10911: aload_3
    //   10912: astore_2
    //   10913: aload 5
    //   10915: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10918: ifne +54 -> 10972
    //   10921: aload 4
    //   10923: astore_1
    //   10924: aload_3
    //   10925: astore_2
    //   10926: aload_0
    //   10927: aload 14
    //   10929: aload 15
    //   10931: aload 16
    //   10933: aload 4
    //   10935: aload 5
    //   10937: aload_3
    //   10938: invokespecial 3624	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10941: aconst_null
    //   10942: astore_1
    //   10943: aload_3
    //   10944: astore_2
    //   10945: aload_1
    //   10946: ifnull -10762 -> 184
    //   10949: aload_2
    //   10950: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10953: ifne -10769 -> 184
    //   10956: aload_0
    //   10957: aload_2
    //   10958: iconst_1
    //   10959: anewarray 285	java/lang/String
    //   10962: dup
    //   10963: iconst_0
    //   10964: aload_1
    //   10965: aastore
    //   10966: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10969: goto -10785 -> 184
    //   10972: aload 4
    //   10974: astore_1
    //   10975: aload_3
    //   10976: astore_2
    //   10977: ldc_w 2984
    //   10980: aconst_null
    //   10981: ldc_w 3626
    //   10984: aload 4
    //   10986: invokestatic 766	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10989: astore 4
    //   10991: aload 4
    //   10993: astore_1
    //   10994: aload_3
    //   10995: astore_2
    //   10996: goto -51 -> 10945
    //   10999: astore_3
    //   11000: ldc_w 3628
    //   11003: aconst_null
    //   11004: aload_3
    //   11005: invokevirtual 1376	java/lang/Exception:toString	()Ljava/lang/String;
    //   11008: aload_1
    //   11009: invokestatic 766	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11012: astore_1
    //   11013: goto -68 -> 10945
    //   11016: ldc_w 3630
    //   11019: aload 4
    //   11021: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11024: ifeq +316 -> 11340
    //   11027: aload 5
    //   11029: arraylength
    //   11030: ifle +310 -> 11340
    //   11033: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11036: ifeq +33 -> 11069
    //   11039: ldc_w 3632
    //   11042: iconst_2
    //   11043: new 549	java/lang/StringBuilder
    //   11046: dup
    //   11047: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11050: ldc_w 3634
    //   11053: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11056: aload 5
    //   11058: iconst_0
    //   11059: aaload
    //   11060: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11063: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11066: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11069: new 113	org/json/JSONObject
    //   11072: dup
    //   11073: aload 5
    //   11075: iconst_0
    //   11076: aaload
    //   11077: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11080: ldc 160
    //   11082: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11085: astore_3
    //   11086: aload_3
    //   11087: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11090: ifne -10906 -> 184
    //   11093: aload_3
    //   11094: ldc_w 3636
    //   11097: invokevirtual 3640	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11100: astore_1
    //   11101: new 2431	java/util/HashMap
    //   11104: dup
    //   11105: invokespecial 3641	java/util/HashMap:<init>	()V
    //   11108: astore_2
    //   11109: aload_1
    //   11110: arraylength
    //   11111: iconst_1
    //   11112: if_icmple -10928 -> 184
    //   11115: aload_1
    //   11116: iconst_1
    //   11117: aaload
    //   11118: ldc_w 3643
    //   11121: invokevirtual 3640	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11124: astore_1
    //   11125: iconst_0
    //   11126: istore 6
    //   11128: aload_1
    //   11129: arraylength
    //   11130: istore 7
    //   11132: iload 6
    //   11134: iload 7
    //   11136: if_icmpge +49 -> 11185
    //   11139: aload_1
    //   11140: iload 6
    //   11142: aaload
    //   11143: bipush 61
    //   11145: invokevirtual 3646	java/lang/String:indexOf	(I)I
    //   11148: istore 8
    //   11150: iload 8
    //   11152: iconst_m1
    //   11153: if_icmpeq +6444 -> 17597
    //   11156: aload_2
    //   11157: aload_1
    //   11158: iload 6
    //   11160: aaload
    //   11161: iconst_0
    //   11162: iload 8
    //   11164: invokevirtual 3650	java/lang/String:substring	(II)Ljava/lang/String;
    //   11167: aload_1
    //   11168: iload 6
    //   11170: aaload
    //   11171: iload 8
    //   11173: iconst_1
    //   11174: iadd
    //   11175: invokevirtual 3652	java/lang/String:substring	(I)Ljava/lang/String;
    //   11178: invokevirtual 2437	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11181: pop
    //   11182: goto +6415 -> 17597
    //   11185: aload_3
    //   11186: ldc_w 2087
    //   11189: invokevirtual 325	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11192: ifeq +123 -> 11315
    //   11195: aload_2
    //   11196: ldc_w 600
    //   11199: invokevirtual 3653	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11202: checkcast 285	java/lang/String
    //   11205: astore_1
    //   11206: aload_2
    //   11207: ldc 174
    //   11209: invokevirtual 3653	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11212: checkcast 285	java/lang/String
    //   11215: astore_2
    //   11216: aload_0
    //   11217: aload_1
    //   11218: aload_2
    //   11219: aload_3
    //   11220: invokevirtual 3655	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   11223: ifne -11039 -> 184
    //   11226: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11229: ifeq +13 -> 11242
    //   11232: ldc_w 3632
    //   11235: iconst_2
    //   11236: ldc_w 2764
    //   11239: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11242: aload_0
    //   11243: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   11246: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   11249: aload_0
    //   11250: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   11253: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11256: aload_0
    //   11257: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   11260: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   11263: aload 5
    //   11265: iconst_0
    //   11266: aaload
    //   11267: iconst_0
    //   11268: iconst_0
    //   11269: invokestatic 2769	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   11272: goto -11088 -> 184
    //   11275: astore_1
    //   11276: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11279: ifeq -11095 -> 184
    //   11282: ldc_w 3632
    //   11285: iconst_2
    //   11286: new 549	java/lang/StringBuilder
    //   11289: dup
    //   11290: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11293: ldc_w 3657
    //   11296: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11299: aload 5
    //   11301: iconst_0
    //   11302: aaload
    //   11303: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11306: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11309: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11312: goto -11128 -> 184
    //   11315: aload_2
    //   11316: ldc_w 3419
    //   11319: invokevirtual 3653	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11322: checkcast 285	java/lang/String
    //   11325: astore_1
    //   11326: aload_2
    //   11327: ldc_w 3659
    //   11330: invokevirtual 3653	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11333: checkcast 285	java/lang/String
    //   11336: astore_2
    //   11337: goto -121 -> 11216
    //   11340: ldc_w 3661
    //   11343: aload 4
    //   11345: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11348: ifeq +66 -> 11414
    //   11351: aload 5
    //   11353: arraylength
    //   11354: ifle +60 -> 11414
    //   11357: aload_0
    //   11358: new 113	org/json/JSONObject
    //   11361: dup
    //   11362: aload 5
    //   11364: iconst_0
    //   11365: aaload
    //   11366: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11369: invokevirtual 3663	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   11372: goto -11188 -> 184
    //   11375: astore_1
    //   11376: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11379: ifeq -11195 -> 184
    //   11382: ldc 209
    //   11384: iconst_2
    //   11385: new 549	java/lang/StringBuilder
    //   11388: dup
    //   11389: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11392: ldc_w 3665
    //   11395: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11398: aload 5
    //   11400: iconst_0
    //   11401: aaload
    //   11402: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11405: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11408: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11411: goto -11227 -> 184
    //   11414: ldc_w 3667
    //   11417: aload 4
    //   11419: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11422: ifeq +10 -> 11432
    //   11425: aload_0
    //   11426: invokevirtual 3669	com/tencent/mobileqq/jsp/UiApiPlugin:d	()V
    //   11429: goto -11245 -> 184
    //   11432: ldc_w 3671
    //   11435: aload 4
    //   11437: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11440: ifeq +72 -> 11512
    //   11443: aload 5
    //   11445: arraylength
    //   11446: ifle +66 -> 11512
    //   11449: aload_0
    //   11450: new 113	org/json/JSONObject
    //   11453: dup
    //   11454: aload 5
    //   11456: iconst_0
    //   11457: aaload
    //   11458: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11461: ldc_w 809
    //   11464: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11467: invokevirtual 3673	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   11470: goto -11286 -> 184
    //   11473: astore_1
    //   11474: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11477: ifeq -11293 -> 184
    //   11480: ldc 209
    //   11482: iconst_2
    //   11483: new 549	java/lang/StringBuilder
    //   11486: dup
    //   11487: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11490: ldc_w 3582
    //   11493: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11496: aload 5
    //   11498: iconst_0
    //   11499: aaload
    //   11500: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11503: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11506: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11509: goto -11325 -> 184
    //   11512: ldc_w 3675
    //   11515: aload 4
    //   11517: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11520: ifeq +112 -> 11632
    //   11523: new 113	org/json/JSONObject
    //   11526: dup
    //   11527: aload 5
    //   11529: iconst_0
    //   11530: aaload
    //   11531: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11534: astore_1
    //   11535: aload_0
    //   11536: invokevirtual 2606	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbikl;
    //   11539: astore_2
    //   11540: aload_2
    //   11541: ifnull -11357 -> 184
    //   11544: aload_2
    //   11545: aload_1
    //   11546: invokeinterface 3678 2 0
    //   11551: goto -11367 -> 184
    //   11554: astore_1
    //   11555: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11558: ifeq -11374 -> 184
    //   11561: ldc 209
    //   11563: iconst_2
    //   11564: new 549	java/lang/StringBuilder
    //   11567: dup
    //   11568: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11571: ldc_w 3680
    //   11574: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11577: aload_1
    //   11578: invokevirtual 3681	org/json/JSONException:toString	()Ljava/lang/String;
    //   11581: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11584: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11587: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11590: goto -11406 -> 184
    //   11593: astore_1
    //   11594: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11597: ifeq -11413 -> 184
    //   11600: ldc 209
    //   11602: iconst_2
    //   11603: new 549	java/lang/StringBuilder
    //   11606: dup
    //   11607: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11610: ldc_w 3680
    //   11613: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11616: aload_1
    //   11617: invokevirtual 1376	java/lang/Exception:toString	()Ljava/lang/String;
    //   11620: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11623: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11626: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11629: goto -11445 -> 184
    //   11632: ldc_w 3683
    //   11635: aload 4
    //   11637: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11640: ifeq +194 -> 11834
    //   11643: aload 5
    //   11645: arraylength
    //   11646: ifle +188 -> 11834
    //   11649: new 113	org/json/JSONObject
    //   11652: dup
    //   11653: aload 5
    //   11655: iconst_0
    //   11656: aaload
    //   11657: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11660: ldc_w 809
    //   11663: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11666: astore_1
    //   11667: aload_1
    //   11668: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11671: ifeq +14 -> 11685
    //   11674: ldc 209
    //   11676: iconst_1
    //   11677: ldc_w 3685
    //   11680: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11683: iconst_1
    //   11684: ireturn
    //   11685: new 113	org/json/JSONObject
    //   11688: dup
    //   11689: invokespecial 172	org/json/JSONObject:<init>	()V
    //   11692: astore_2
    //   11693: new 113	org/json/JSONObject
    //   11696: dup
    //   11697: invokespecial 172	org/json/JSONObject:<init>	()V
    //   11700: astore_3
    //   11701: aload_0
    //   11702: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   11705: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   11708: invokevirtual 751	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11711: ldc_w 752
    //   11714: invokevirtual 757	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   11717: istore 7
    //   11719: iload 7
    //   11721: istore 6
    //   11723: invokestatic 1895	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   11726: iconst_1
    //   11727: if_icmpne +18 -> 11745
    //   11730: iload 7
    //   11732: aload_0
    //   11733: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   11736: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   11739: invokestatic 1898	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   11742: iadd
    //   11743: istore 6
    //   11745: aload_3
    //   11746: ldc_w 1813
    //   11749: iload 6
    //   11751: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11754: pop
    //   11755: aload_2
    //   11756: ldc_w 1797
    //   11759: iconst_0
    //   11760: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11763: pop
    //   11764: aload_2
    //   11765: ldc 221
    //   11767: ldc_w 3687
    //   11770: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11773: pop
    //   11774: aload_2
    //   11775: ldc 198
    //   11777: aload_3
    //   11778: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11781: pop
    //   11782: aload_0
    //   11783: aload_1
    //   11784: iconst_1
    //   11785: anewarray 285	java/lang/String
    //   11788: dup
    //   11789: iconst_0
    //   11790: aload_2
    //   11791: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11794: aastore
    //   11795: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11798: goto -11614 -> 184
    //   11801: astore_1
    //   11802: ldc 209
    //   11804: iconst_1
    //   11805: new 549	java/lang/StringBuilder
    //   11808: dup
    //   11809: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   11812: ldc_w 3689
    //   11815: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11818: aload_1
    //   11819: invokestatic 2831	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   11822: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11825: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11828: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11831: goto -11647 -> 184
    //   11834: ldc_w 3691
    //   11837: aload 4
    //   11839: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11842: ifeq +78 -> 11920
    //   11845: new 113	org/json/JSONObject
    //   11848: dup
    //   11849: aload 5
    //   11851: iconst_0
    //   11852: aaload
    //   11853: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11856: astore_1
    //   11857: aload_1
    //   11858: ldc_w 600
    //   11861: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11864: astore_2
    //   11865: aload_0
    //   11866: aload_1
    //   11867: ldc_w 809
    //   11870: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11873: putfield 3693	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   11876: aload_0
    //   11877: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   11880: ifnonnull +17 -> 11897
    //   11883: aload_0
    //   11884: invokestatic 2044	aady:a	()Laady;
    //   11887: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   11890: aload_0
    //   11891: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   11894: invokevirtual 2046	aady:a	()V
    //   11897: aload_0
    //   11898: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   11901: aload_2
    //   11902: new 3695	awcd
    //   11905: dup
    //   11906: aload_0
    //   11907: aload_2
    //   11908: invokespecial 3696	awcd:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   11911: invokevirtual 3699	aady:a	(Ljava/lang/String;Laaea;)V
    //   11914: goto -11730 -> 184
    //   11917: astore_1
    //   11918: iconst_1
    //   11919: ireturn
    //   11920: ldc_w 3701
    //   11923: aload 4
    //   11925: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11928: ifeq +441 -> 12369
    //   11931: aload 5
    //   11933: arraylength
    //   11934: iconst_1
    //   11935: if_icmpne +434 -> 12369
    //   11938: new 113	org/json/JSONObject
    //   11941: dup
    //   11942: aload 5
    //   11944: iconst_0
    //   11945: aaload
    //   11946: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11949: astore_3
    //   11950: aload_3
    //   11951: ldc_w 3703
    //   11954: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11957: astore 4
    //   11959: aload_3
    //   11960: ldc_w 3705
    //   11963: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11966: astore_1
    //   11967: aload_1
    //   11968: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11971: ifeq +22 -> 11993
    //   11974: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11977: ifeq +5629 -> 17606
    //   11980: ldc_w 3707
    //   11983: iconst_2
    //   11984: ldc_w 3709
    //   11987: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11990: goto +5616 -> 17606
    //   11993: aload_0
    //   11994: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   11997: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12000: astore_2
    //   12001: aload_2
    //   12002: ifnull +10 -> 12012
    //   12005: aload_2
    //   12006: invokevirtual 3713	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Logn;
    //   12009: ifnonnull +22 -> 12031
    //   12012: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12015: ifeq +5593 -> 17608
    //   12018: ldc_w 3707
    //   12021: iconst_2
    //   12022: ldc_w 3715
    //   12025: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12028: goto +5580 -> 17608
    //   12031: aload_2
    //   12032: invokevirtual 3713	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Logn;
    //   12035: getfield 3718	ogn:jdField_a_of_type_Int	I
    //   12038: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12041: astore_2
    //   12042: aload_3
    //   12043: ldc_w 3406
    //   12046: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12049: istore 6
    //   12051: iload 6
    //   12053: iconst_1
    //   12054: if_icmpne +226 -> 12280
    //   12057: new 3720	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12060: dup
    //   12061: invokespecial 3721	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12064: astore_3
    //   12065: aload_3
    //   12066: getfield 3724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12069: sipush 1814
    //   12072: invokevirtual 684	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12075: aload_3
    //   12076: getfield 3727	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12079: bipush 48
    //   12081: invokevirtual 684	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12084: aload_1
    //   12085: invokevirtual 3730	java/lang/String:getBytes	()[B
    //   12088: arraylength
    //   12089: bipush 6
    //   12091: iadd
    //   12092: invokestatic 3736	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12095: astore 4
    //   12097: aload 4
    //   12099: aload_2
    //   12100: invokevirtual 2629	java/lang/Integer:intValue	()I
    //   12103: invokevirtual 3738	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12106: pop
    //   12107: aload 4
    //   12109: aload_1
    //   12110: invokevirtual 3730	java/lang/String:getBytes	()[B
    //   12113: arraylength
    //   12114: i2s
    //   12115: invokevirtual 3742	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12118: pop
    //   12119: aload 4
    //   12121: aload_1
    //   12122: invokevirtual 3730	java/lang/String:getBytes	()[B
    //   12125: invokevirtual 3745	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12128: pop
    //   12129: aload_3
    //   12130: getfield 3749	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12133: aload 4
    //   12135: invokevirtual 3752	java/nio/ByteBuffer:array	()[B
    //   12138: invokestatic 3758	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12141: invokevirtual 3763	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12144: new 702	mqq/app/NewIntent
    //   12147: dup
    //   12148: aload_0
    //   12149: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12152: ldc_w 704
    //   12155: invokespecial 705	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12158: astore_2
    //   12159: new 301	android/os/Bundle
    //   12162: dup
    //   12163: invokespecial 302	android/os/Bundle:<init>	()V
    //   12166: astore 4
    //   12168: aload 4
    //   12170: ldc_w 3705
    //   12173: aload_1
    //   12174: invokevirtual 485	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12177: aload_2
    //   12178: aload 4
    //   12180: invokevirtual 3764	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12183: pop
    //   12184: aload_2
    //   12185: ldc_w 710
    //   12188: ldc_w 3766
    //   12191: invokevirtual 713	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12194: pop
    //   12195: aload_2
    //   12196: ldc 198
    //   12198: aload_3
    //   12199: invokevirtual 3767	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12202: invokevirtual 720	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12205: pop
    //   12206: aload_2
    //   12207: ldc_w 3769
    //   12210: iconst_1
    //   12211: invokevirtual 3770	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12214: pop
    //   12215: aload_2
    //   12216: new 3772	awce
    //   12219: dup
    //   12220: aload_0
    //   12221: invokespecial 3773	awce:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   12224: invokevirtual 729	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12227: aload_0
    //   12228: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   12231: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   12234: aload_2
    //   12235: invokevirtual 735	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12238: goto -12054 -> 184
    //   12241: astore_1
    //   12242: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12245: ifeq -12061 -> 184
    //   12248: ldc 209
    //   12250: iconst_2
    //   12251: new 549	java/lang/StringBuilder
    //   12254: dup
    //   12255: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12258: ldc_w 3775
    //   12261: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12264: aload 5
    //   12266: iconst_0
    //   12267: aaload
    //   12268: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12271: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12274: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12277: goto -12093 -> 184
    //   12280: iload 6
    //   12282: ifne -12098 -> 184
    //   12285: aload_0
    //   12286: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   12289: ifnonnull +17 -> 12306
    //   12292: aload_0
    //   12293: invokestatic 2044	aady:a	()Laady;
    //   12296: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   12299: aload_0
    //   12300: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   12303: invokevirtual 2046	aady:a	()V
    //   12306: aload_0
    //   12307: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   12310: aload_2
    //   12311: aload_1
    //   12312: aload 4
    //   12314: new 3777	awcf
    //   12317: dup
    //   12318: aload_0
    //   12319: aload_2
    //   12320: aload_1
    //   12321: invokespecial 3780	awcf:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   12324: invokevirtual 3783	aady:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Laaea;)V
    //   12327: goto -12143 -> 184
    //   12330: astore_1
    //   12331: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12334: ifeq -12150 -> 184
    //   12337: ldc 209
    //   12339: iconst_2
    //   12340: new 549	java/lang/StringBuilder
    //   12343: dup
    //   12344: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12347: ldc_w 3785
    //   12350: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12353: aload 5
    //   12355: iconst_0
    //   12356: aaload
    //   12357: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12360: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12363: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12366: goto -12182 -> 184
    //   12369: ldc_w 3787
    //   12372: aload 4
    //   12374: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12377: ifeq +455 -> 12832
    //   12380: aload 5
    //   12382: arraylength
    //   12383: iconst_1
    //   12384: if_icmpne +448 -> 12832
    //   12387: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12390: ifeq +33 -> 12423
    //   12393: ldc_w 3707
    //   12396: iconst_2
    //   12397: new 549	java/lang/StringBuilder
    //   12400: dup
    //   12401: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12404: ldc_w 3789
    //   12407: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12410: aload 5
    //   12412: iconst_0
    //   12413: aaload
    //   12414: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12417: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12420: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12423: new 113	org/json/JSONObject
    //   12426: dup
    //   12427: aload 5
    //   12429: iconst_0
    //   12430: aaload
    //   12431: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12434: astore_3
    //   12435: aload_3
    //   12436: ldc_w 3703
    //   12439: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12442: astore_1
    //   12443: aload_3
    //   12444: ldc_w 3705
    //   12447: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12450: astore_2
    //   12451: aload_3
    //   12452: ldc_w 3791
    //   12455: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12458: astore_3
    //   12459: aload_2
    //   12460: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12463: ifne +10 -> 12473
    //   12466: aload_3
    //   12467: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12470: ifeq +49 -> 12519
    //   12473: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12476: ifeq +5134 -> 17610
    //   12479: ldc_w 3707
    //   12482: iconst_2
    //   12483: new 549	java/lang/StringBuilder
    //   12486: dup
    //   12487: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12490: ldc_w 3793
    //   12493: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12496: aload_3
    //   12497: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12500: ldc_w 3795
    //   12503: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12506: aload_2
    //   12507: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12510: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12513: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12516: goto +5094 -> 17610
    //   12519: aload_0
    //   12520: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   12523: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12526: astore 4
    //   12528: aload 4
    //   12530: ifnull +11 -> 12541
    //   12533: aload 4
    //   12535: invokevirtual 3713	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Logn;
    //   12538: ifnonnull +22 -> 12560
    //   12541: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12544: ifeq +5068 -> 17612
    //   12547: ldc_w 3707
    //   12550: iconst_2
    //   12551: ldc_w 3797
    //   12554: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12557: goto +5055 -> 17612
    //   12560: aload 4
    //   12562: invokevirtual 3713	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Logn;
    //   12565: getfield 3718	ogn:jdField_a_of_type_Int	I
    //   12568: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12571: astore 4
    //   12573: new 3720	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12576: dup
    //   12577: invokespecial 3721	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12580: astore 14
    //   12582: aload 14
    //   12584: getfield 3724	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12587: sipush 1814
    //   12590: invokevirtual 684	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12593: aload 14
    //   12595: getfield 3727	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12598: bipush 48
    //   12600: invokevirtual 684	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12603: aload_3
    //   12604: invokevirtual 3730	java/lang/String:getBytes	()[B
    //   12607: arraylength
    //   12608: bipush 6
    //   12610: iadd
    //   12611: invokestatic 3736	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12614: astore 15
    //   12616: aload 15
    //   12618: aload 4
    //   12620: invokevirtual 2629	java/lang/Integer:intValue	()I
    //   12623: invokevirtual 3738	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12626: pop
    //   12627: aload 15
    //   12629: aload_3
    //   12630: invokevirtual 3730	java/lang/String:getBytes	()[B
    //   12633: arraylength
    //   12634: i2s
    //   12635: invokevirtual 3742	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12638: pop
    //   12639: aload 15
    //   12641: aload_3
    //   12642: invokevirtual 3730	java/lang/String:getBytes	()[B
    //   12645: invokevirtual 3745	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12648: pop
    //   12649: aload 14
    //   12651: getfield 3749	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12654: aload 15
    //   12656: invokevirtual 3752	java/nio/ByteBuffer:array	()[B
    //   12659: invokestatic 3758	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12662: invokevirtual 3763	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12665: new 702	mqq/app/NewIntent
    //   12668: dup
    //   12669: aload_0
    //   12670: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12673: ldc_w 704
    //   12676: invokespecial 705	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12679: astore_3
    //   12680: aload_3
    //   12681: new 301	android/os/Bundle
    //   12684: dup
    //   12685: invokespecial 302	android/os/Bundle:<init>	()V
    //   12688: invokevirtual 3764	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12691: pop
    //   12692: aload_3
    //   12693: ldc_w 710
    //   12696: ldc_w 3766
    //   12699: invokevirtual 713	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12702: pop
    //   12703: aload_3
    //   12704: ldc 198
    //   12706: aload 14
    //   12708: invokevirtual 3767	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12711: invokevirtual 720	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12714: pop
    //   12715: aload_3
    //   12716: ldc_w 3769
    //   12719: iconst_1
    //   12720: invokevirtual 3770	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12723: pop
    //   12724: aload_3
    //   12725: new 3799	awcg
    //   12728: dup
    //   12729: aload_0
    //   12730: aload 4
    //   12732: aload_2
    //   12733: aload_1
    //   12734: invokespecial 3802	awcg:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   12737: invokevirtual 729	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12740: aload_0
    //   12741: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   12744: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   12747: aload_3
    //   12748: invokevirtual 735	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12751: goto -12567 -> 184
    //   12754: astore_1
    //   12755: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12758: ifeq -12574 -> 184
    //   12761: ldc 209
    //   12763: iconst_2
    //   12764: new 549	java/lang/StringBuilder
    //   12767: dup
    //   12768: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12771: ldc_w 3775
    //   12774: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12777: aload 5
    //   12779: iconst_0
    //   12780: aaload
    //   12781: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12784: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12787: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12790: goto -12606 -> 184
    //   12793: astore_1
    //   12794: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12797: ifeq -12613 -> 184
    //   12800: ldc 209
    //   12802: iconst_2
    //   12803: new 549	java/lang/StringBuilder
    //   12806: dup
    //   12807: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12810: ldc_w 3785
    //   12813: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12816: aload 5
    //   12818: iconst_0
    //   12819: aaload
    //   12820: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12823: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12826: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12829: goto -12645 -> 184
    //   12832: ldc_w 3804
    //   12835: aload 4
    //   12837: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12840: ifeq +200 -> 13040
    //   12843: aload_0
    //   12844: new 113	org/json/JSONObject
    //   12847: dup
    //   12848: aload 5
    //   12850: iconst_0
    //   12851: aaload
    //   12852: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12855: ldc_w 809
    //   12858: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12861: putfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12864: aload_0
    //   12865: invokevirtual 2606	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbikl;
    //   12868: astore_1
    //   12869: aload_1
    //   12870: ifnull -12686 -> 184
    //   12873: aload_1
    //   12874: invokeinterface 3807 1 0
    //   12879: istore 6
    //   12881: aload_0
    //   12882: aload_0
    //   12883: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12886: iconst_1
    //   12887: anewarray 285	java/lang/String
    //   12890: dup
    //   12891: iconst_0
    //   12892: new 549	java/lang/StringBuilder
    //   12895: dup
    //   12896: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12899: ldc_w 3809
    //   12902: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12905: iload 6
    //   12907: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12910: ldc_w 1801
    //   12913: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12916: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12919: aastore
    //   12920: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12923: goto -12739 -> 184
    //   12926: astore_1
    //   12927: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12930: ifeq -12746 -> 184
    //   12933: aload_0
    //   12934: aload_0
    //   12935: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12938: iconst_1
    //   12939: anewarray 285	java/lang/String
    //   12942: dup
    //   12943: iconst_0
    //   12944: ldc_w 3811
    //   12947: aastore
    //   12948: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12951: ldc 209
    //   12953: iconst_2
    //   12954: new 549	java/lang/StringBuilder
    //   12957: dup
    //   12958: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   12961: ldc_w 3813
    //   12964: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12967: aload_1
    //   12968: invokevirtual 3681	org/json/JSONException:toString	()Ljava/lang/String;
    //   12971: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12974: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12977: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12980: goto -12796 -> 184
    //   12983: astore_1
    //   12984: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12987: ifeq -12803 -> 184
    //   12990: aload_0
    //   12991: aload_0
    //   12992: getfield 2958	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12995: iconst_1
    //   12996: anewarray 285	java/lang/String
    //   12999: dup
    //   13000: iconst_0
    //   13001: ldc_w 3811
    //   13004: aastore
    //   13005: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13008: ldc 209
    //   13010: iconst_2
    //   13011: new 549	java/lang/StringBuilder
    //   13014: dup
    //   13015: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13018: ldc_w 3813
    //   13021: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13024: aload_1
    //   13025: invokevirtual 1376	java/lang/Exception:toString	()Ljava/lang/String;
    //   13028: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13031: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13034: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13037: goto -12853 -> 184
    //   13040: ldc_w 3815
    //   13043: aload 4
    //   13045: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13048: ifeq +135 -> 13183
    //   13051: aload 5
    //   13053: arraylength
    //   13054: iconst_1
    //   13055: if_icmpgt +128 -> 13183
    //   13058: ldc_w 482
    //   13061: astore_1
    //   13062: aload 5
    //   13064: arraylength
    //   13065: iconst_1
    //   13066: if_icmpne +4386 -> 17452
    //   13069: new 113	org/json/JSONObject
    //   13072: dup
    //   13073: aload 5
    //   13075: iconst_0
    //   13076: aaload
    //   13077: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13080: astore_3
    //   13081: aload_3
    //   13082: ldc_w 425
    //   13085: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13088: astore_2
    //   13089: aload_2
    //   13090: astore_1
    //   13091: aload_3
    //   13092: ldc_w 1748
    //   13095: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   13098: ifeq +4354 -> 17452
    //   13101: aload_3
    //   13102: ldc_w 1748
    //   13105: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13108: astore_1
    //   13109: aload_0
    //   13110: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   13113: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   13116: astore_3
    //   13117: aload_3
    //   13118: ifnull -12934 -> 184
    //   13121: aload_3
    //   13122: instanceof 522
    //   13125: ifeq -12941 -> 184
    //   13128: aload_3
    //   13129: checkcast 522	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13132: invokevirtual 3204	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13135: checkcast 3206	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13138: iconst_0
    //   13139: aload_2
    //   13140: aload_1
    //   13141: invokevirtual 3818	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   13144: goto -12960 -> 184
    //   13147: astore_1
    //   13148: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13151: ifeq -12967 -> 184
    //   13154: ldc 209
    //   13156: iconst_4
    //   13157: new 549	java/lang/StringBuilder
    //   13160: dup
    //   13161: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13164: ldc_w 3820
    //   13167: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13170: aload_1
    //   13171: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13174: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13177: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13180: goto -12996 -> 184
    //   13183: ldc_w 3822
    //   13186: aload 4
    //   13188: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13191: ifeq +256 -> 13447
    //   13194: aload 5
    //   13196: arraylength
    //   13197: iconst_1
    //   13198: if_icmpgt +249 -> 13447
    //   13201: aload 5
    //   13203: arraylength
    //   13204: iconst_1
    //   13205: if_icmpne -13021 -> 184
    //   13208: new 113	org/json/JSONObject
    //   13211: dup
    //   13212: aload 5
    //   13214: iconst_0
    //   13215: aaload
    //   13216: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13219: astore_1
    //   13220: aload_1
    //   13221: ldc_w 3431
    //   13224: iconst_m1
    //   13225: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13228: istore 6
    //   13230: aload_1
    //   13231: ldc_w 3521
    //   13234: iconst_m1
    //   13235: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13238: istore 7
    //   13240: aload_0
    //   13241: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   13244: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   13247: astore_1
    //   13248: aload_1
    //   13249: ifnull -13065 -> 184
    //   13252: aload_1
    //   13253: instanceof 522
    //   13256: ifeq -13072 -> 184
    //   13259: aload_1
    //   13260: checkcast 522	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13263: invokevirtual 3204	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13266: checkcast 3206	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13269: astore_1
    //   13270: aload_1
    //   13271: ifnull -13087 -> 184
    //   13274: iload 7
    //   13276: iconst_1
    //   13277: if_icmpne +134 -> 13411
    //   13280: aload_1
    //   13281: iconst_0
    //   13282: putfield 3823	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13285: aload_1
    //   13286: iconst_1
    //   13287: invokevirtual 3824	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   13290: iload 6
    //   13292: iconst_1
    //   13293: if_icmpne +136 -> 13429
    //   13296: aload_1
    //   13297: iconst_0
    //   13298: putfield 3823	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13301: aload_1
    //   13302: iconst_1
    //   13303: invokevirtual 3826	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13306: goto -13122 -> 184
    //   13309: astore_1
    //   13310: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13313: ifeq -13129 -> 184
    //   13316: ldc 209
    //   13318: iconst_4
    //   13319: new 549	java/lang/StringBuilder
    //   13322: dup
    //   13323: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13326: ldc_w 3828
    //   13329: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13332: aload_1
    //   13333: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13336: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13339: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13342: goto -13158 -> 184
    //   13345: astore_2
    //   13346: ldc 209
    //   13348: iconst_1
    //   13349: new 549	java/lang/StringBuilder
    //   13352: dup
    //   13353: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13356: ldc_w 3830
    //   13359: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13362: aload_2
    //   13363: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13366: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13369: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13372: iconst_m1
    //   13373: istore 6
    //   13375: goto -145 -> 13230
    //   13378: astore_1
    //   13379: iconst_m1
    //   13380: istore 7
    //   13382: ldc 209
    //   13384: iconst_1
    //   13385: new 549	java/lang/StringBuilder
    //   13388: dup
    //   13389: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13392: ldc_w 3832
    //   13395: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13398: aload_1
    //   13399: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13402: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13405: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13408: goto -168 -> 13240
    //   13411: iload 7
    //   13413: ifne -123 -> 13290
    //   13416: aload_1
    //   13417: iconst_1
    //   13418: putfield 3823	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13421: aload_1
    //   13422: iconst_0
    //   13423: invokevirtual 3824	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   13426: goto -136 -> 13290
    //   13429: iload 6
    //   13431: ifne -13247 -> 184
    //   13434: aload_1
    //   13435: iconst_1
    //   13436: putfield 3823	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13439: aload_1
    //   13440: iconst_0
    //   13441: invokevirtual 3826	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13444: goto -13260 -> 184
    //   13447: ldc_w 3834
    //   13450: aload 4
    //   13452: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13455: ifeq +168 -> 13623
    //   13458: aload 5
    //   13460: arraylength
    //   13461: iconst_1
    //   13462: if_icmpgt +161 -> 13623
    //   13465: aload 5
    //   13467: arraylength
    //   13468: iconst_1
    //   13469: if_icmpne -13285 -> 184
    //   13472: aload 5
    //   13474: arraylength
    //   13475: iconst_1
    //   13476: if_icmpne -13292 -> 184
    //   13479: new 113	org/json/JSONObject
    //   13482: dup
    //   13483: aload 5
    //   13485: iconst_0
    //   13486: aaload
    //   13487: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13490: ldc_w 3836
    //   13493: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13496: astore_1
    //   13497: aload_0
    //   13498: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   13501: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   13504: astore_2
    //   13505: aload_2
    //   13506: ifnull -13322 -> 184
    //   13509: aload_2
    //   13510: instanceof 522
    //   13513: ifeq -13329 -> 184
    //   13516: aload_2
    //   13517: checkcast 522	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13520: invokevirtual 3204	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13523: checkcast 3206	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13526: astore_3
    //   13527: ldc_w 447
    //   13530: aload_1
    //   13531: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13534: ifeq +61 -> 13595
    //   13537: aload_2
    //   13538: ldc_w 2124
    //   13541: invokevirtual 2125	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13544: checkcast 2127	android/view/inputmethod/InputMethodManager
    //   13547: aload_3
    //   13548: invokevirtual 3839	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13551: iconst_0
    //   13552: invokevirtual 3843	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   13555: pop
    //   13556: goto -13372 -> 184
    //   13559: astore_1
    //   13560: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13563: ifeq -13379 -> 184
    //   13566: ldc 209
    //   13568: iconst_4
    //   13569: new 549	java/lang/StringBuilder
    //   13572: dup
    //   13573: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13576: ldc_w 3845
    //   13579: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13582: aload_1
    //   13583: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13586: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13589: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13592: goto -13408 -> 184
    //   13595: aload_2
    //   13596: ldc_w 2124
    //   13599: invokevirtual 2125	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13602: checkcast 2127	android/view/inputmethod/InputMethodManager
    //   13605: aload_2
    //   13606: invokevirtual 3231	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13609: invokevirtual 3848	android/view/Window:getDecorView	()Landroid/view/View;
    //   13612: invokevirtual 3852	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13615: iconst_0
    //   13616: invokevirtual 3856	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13619: pop
    //   13620: goto -13436 -> 184
    //   13623: ldc_w 3858
    //   13626: aload 4
    //   13628: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13631: ifeq +96 -> 13727
    //   13634: aload 5
    //   13636: arraylength
    //   13637: iconst_1
    //   13638: if_icmpgt +89 -> 13727
    //   13641: aload 5
    //   13643: arraylength
    //   13644: iconst_1
    //   13645: if_icmpne -13461 -> 184
    //   13648: new 113	org/json/JSONObject
    //   13651: dup
    //   13652: aload 5
    //   13654: iconst_0
    //   13655: aaload
    //   13656: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13659: ldc_w 809
    //   13662: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13665: astore_1
    //   13666: aload_1
    //   13667: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13670: ifne -13486 -> 184
    //   13673: aload_0
    //   13674: aload_1
    //   13675: iconst_1
    //   13676: anewarray 285	java/lang/String
    //   13679: dup
    //   13680: iconst_0
    //   13681: ldc_w 3860
    //   13684: aastore
    //   13685: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13688: goto -13504 -> 184
    //   13691: astore_1
    //   13692: invokestatic 878	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13695: ifeq -13511 -> 184
    //   13698: ldc 209
    //   13700: iconst_4
    //   13701: new 549	java/lang/StringBuilder
    //   13704: dup
    //   13705: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13708: ldc_w 3862
    //   13711: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13714: aload_1
    //   13715: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13718: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13721: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13724: goto -13540 -> 184
    //   13727: ldc_w 3864
    //   13730: aload 4
    //   13732: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13735: ifeq +114 -> 13849
    //   13738: aload 5
    //   13740: arraylength
    //   13741: ifle +108 -> 13849
    //   13744: new 113	org/json/JSONObject
    //   13747: dup
    //   13748: aload 5
    //   13750: iconst_0
    //   13751: aaload
    //   13752: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13755: astore_3
    //   13756: aload_0
    //   13757: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   13760: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   13763: astore_1
    //   13764: aload_0
    //   13765: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   13768: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   13771: astore_2
    //   13772: aload_3
    //   13773: ldc_w 2724
    //   13776: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13779: astore_3
    //   13780: aload_3
    //   13781: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13784: ifne -13600 -> 184
    //   13787: aload_1
    //   13788: ifnull -13604 -> 184
    //   13791: aload_2
    //   13792: ifnull -13608 -> 184
    //   13795: aload_1
    //   13796: new 3866	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   13799: dup
    //   13800: aload_3
    //   13801: bipush 90
    //   13803: invokespecial 3868	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   13806: invokestatic 3873	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   13809: goto -13625 -> 184
    //   13812: astore_1
    //   13813: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13816: ifeq -13632 -> 184
    //   13819: ldc_w 2692
    //   13822: iconst_2
    //   13823: new 549	java/lang/StringBuilder
    //   13826: dup
    //   13827: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13830: ldc_w 3875
    //   13833: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13836: aload_1
    //   13837: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13840: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13843: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13846: goto -13662 -> 184
    //   13849: ldc_w 3877
    //   13852: aload 4
    //   13854: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13857: ifeq +96 -> 13953
    //   13860: aload 5
    //   13862: arraylength
    //   13863: ifle +90 -> 13953
    //   13866: new 113	org/json/JSONObject
    //   13869: dup
    //   13870: aload 5
    //   13872: iconst_0
    //   13873: aaload
    //   13874: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13877: ldc_w 3879
    //   13880: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13883: istore 6
    //   13885: aload_0
    //   13886: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   13889: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   13892: astore_1
    //   13893: aload_1
    //   13894: ifnull -13710 -> 184
    //   13897: aload_1
    //   13898: instanceof 522
    //   13901: ifeq -13717 -> 184
    //   13904: aload_1
    //   13905: checkcast 522	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13908: iload 6
    //   13910: invokevirtual 3880	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   13913: goto -13729 -> 184
    //   13916: astore_1
    //   13917: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13920: ifeq -13736 -> 184
    //   13923: ldc_w 2692
    //   13926: iconst_2
    //   13927: new 549	java/lang/StringBuilder
    //   13930: dup
    //   13931: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   13934: ldc_w 3882
    //   13937: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13940: aload_1
    //   13941: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13944: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13947: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13950: goto -13766 -> 184
    //   13953: ldc_w 3884
    //   13956: aload 4
    //   13958: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13961: ifeq +267 -> 14228
    //   13964: aload 5
    //   13966: arraylength
    //   13967: ifle +261 -> 14228
    //   13970: new 113	org/json/JSONObject
    //   13973: dup
    //   13974: aload 5
    //   13976: iconst_0
    //   13977: aaload
    //   13978: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13981: astore_3
    //   13982: aload_3
    //   13983: ldc_w 3886
    //   13986: iconst_0
    //   13987: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13990: iconst_1
    //   13991: if_icmpne +176 -> 14167
    //   13994: iconst_1
    //   13995: istore 12
    //   13997: aload_3
    //   13998: ldc_w 3888
    //   14001: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14004: istore 6
    //   14006: aload_3
    //   14007: ldc_w 3890
    //   14010: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14013: istore 7
    //   14015: aload_3
    //   14016: ldc_w 3892
    //   14019: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14022: istore 8
    //   14024: aload_3
    //   14025: ldc_w 3894
    //   14028: iconst_1
    //   14029: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14032: iconst_1
    //   14033: if_icmpne +140 -> 14173
    //   14036: iconst_1
    //   14037: istore 13
    //   14039: aload_3
    //   14040: ldc_w 3896
    //   14043: aconst_null
    //   14044: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14047: astore_1
    //   14048: aload_3
    //   14049: ldc_w 3898
    //   14052: aconst_null
    //   14053: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14056: astore_2
    //   14057: aload_3
    //   14058: ldc_w 809
    //   14061: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14064: astore_3
    //   14065: aload_0
    //   14066: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14069: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14072: astore 5
    //   14074: aload_0
    //   14075: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14078: invokevirtual 1875	bifw:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   14081: astore 4
    //   14083: aload_0
    //   14084: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14087: aload 5
    //   14089: invokevirtual 1449	bifw:a	(Landroid/app/Activity;)Lbifb;
    //   14092: astore 5
    //   14094: aload 4
    //   14096: ifnull +83 -> 14179
    //   14099: aload 4
    //   14101: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   14104: ifnull +75 -> 14179
    //   14107: aload 4
    //   14109: getfield 3092	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   14112: iload 12
    //   14114: iload 6
    //   14116: iload 7
    //   14118: iload 8
    //   14120: iload 13
    //   14122: aload_1
    //   14123: aload_2
    //   14124: aload_3
    //   14125: invokevirtual 3901	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setTitleBarScrollChange	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   14128: goto -13944 -> 184
    //   14131: astore_1
    //   14132: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14135: ifeq -13951 -> 184
    //   14138: ldc 209
    //   14140: iconst_2
    //   14141: new 549	java/lang/StringBuilder
    //   14144: dup
    //   14145: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   14148: ldc_w 3903
    //   14151: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14154: aload_1
    //   14155: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14158: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14161: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14164: goto -13980 -> 184
    //   14167: iconst_0
    //   14168: istore 12
    //   14170: goto -173 -> 13997
    //   14173: iconst_0
    //   14174: istore 13
    //   14176: goto -137 -> 14039
    //   14179: aload 5
    //   14181: ifnull -13997 -> 184
    //   14184: aload 5
    //   14186: instanceof 1788
    //   14189: ifeq -14005 -> 184
    //   14192: aload 5
    //   14194: checkcast 1788	bike
    //   14197: iload 12
    //   14199: iload 6
    //   14201: iload 7
    //   14203: iload 8
    //   14205: iload 13
    //   14207: aload_1
    //   14208: aload_2
    //   14209: aload_3
    //   14210: aload_0
    //   14211: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14214: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14217: invokevirtual 1791	java/lang/Object:hashCode	()I
    //   14220: invokeinterface 3906 10 0
    //   14225: goto -14041 -> 184
    //   14228: ldc_w 3908
    //   14231: aload 4
    //   14233: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14236: ifeq +162 -> 14398
    //   14239: aload 5
    //   14241: arraylength
    //   14242: ifle +156 -> 14398
    //   14245: new 113	org/json/JSONObject
    //   14248: dup
    //   14249: aload 5
    //   14251: iconst_0
    //   14252: aaload
    //   14253: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14256: ldc_w 1726
    //   14259: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14262: istore 6
    //   14264: aload_0
    //   14265: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14268: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14271: astore_2
    //   14272: aload_2
    //   14273: ifnull -14089 -> 184
    //   14276: iload 6
    //   14278: ifne +24 -> 14302
    //   14281: aload_2
    //   14282: invokevirtual 3911	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   14285: goto -14101 -> 184
    //   14288: astore_1
    //   14289: ldc 209
    //   14291: iconst_2
    //   14292: ldc_w 3913
    //   14295: aload_1
    //   14296: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14299: goto -14115 -> 184
    //   14302: aload_0
    //   14303: iconst_4
    //   14304: invokevirtual 2862	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   14307: checkcast 3915	biho
    //   14310: astore_1
    //   14311: aload_1
    //   14312: ifnull -14128 -> 184
    //   14315: aload_2
    //   14316: invokevirtual 3918	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   14319: astore_2
    //   14320: aload_1
    //   14321: getfield 3921	biho:a	Laasr;
    //   14324: ifnonnull +28 -> 14352
    //   14327: aload_1
    //   14328: new 2177	aasr
    //   14331: dup
    //   14332: aload_0
    //   14333: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14336: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   14339: aload_0
    //   14340: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14343: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14346: invokespecial 3924	aasr:<init>	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;)V
    //   14349: putfield 3921	biho:a	Laasr;
    //   14352: iload 6
    //   14354: iconst_1
    //   14355: if_icmpne +20 -> 14375
    //   14358: aload_1
    //   14359: bipush 6
    //   14361: aload_2
    //   14362: new 301	android/os/Bundle
    //   14365: dup
    //   14366: invokespecial 302	android/os/Bundle:<init>	()V
    //   14369: invokevirtual 3927	biho:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14372: goto -14188 -> 184
    //   14375: iload 6
    //   14377: iconst_2
    //   14378: if_icmpne -14194 -> 184
    //   14381: aload_1
    //   14382: bipush 11
    //   14384: aload_2
    //   14385: new 301	android/os/Bundle
    //   14388: dup
    //   14389: invokespecial 302	android/os/Bundle:<init>	()V
    //   14392: invokevirtual 3927	biho:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14395: goto -14211 -> 184
    //   14398: ldc_w 3929
    //   14401: aload 4
    //   14403: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14406: ifeq +62 -> 14468
    //   14409: new 129	android/content/Intent
    //   14412: dup
    //   14413: aload_0
    //   14414: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14417: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14420: ldc_w 3931
    //   14423: invokespecial 389	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   14426: astore_1
    //   14427: aload_1
    //   14428: ldc_w 3933
    //   14431: aload 5
    //   14433: iconst_0
    //   14434: aaload
    //   14435: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14438: pop
    //   14439: aload_0
    //   14440: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14443: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14446: aload_1
    //   14447: sipush 11533
    //   14450: invokevirtual 406	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14453: aload_0
    //   14454: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14457: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14460: iconst_0
    //   14461: iconst_0
    //   14462: invokevirtual 412	android/app/Activity:overridePendingTransition	(II)V
    //   14465: goto -14281 -> 184
    //   14468: ldc_w 3935
    //   14471: aload 4
    //   14473: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14476: ifeq +177 -> 14653
    //   14479: new 113	org/json/JSONObject
    //   14482: dup
    //   14483: aload 5
    //   14485: iconst_0
    //   14486: aaload
    //   14487: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14490: astore_2
    //   14491: aload_2
    //   14492: ldc 160
    //   14494: ldc_w 482
    //   14497: invokevirtual 926	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14500: astore_1
    //   14501: aload_0
    //   14502: aload_2
    //   14503: ldc_w 809
    //   14506: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14509: putfield 2650	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14512: aload_1
    //   14513: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14516: ifeq +65 -> 14581
    //   14519: new 113	org/json/JSONObject
    //   14522: dup
    //   14523: invokespecial 172	org/json/JSONObject:<init>	()V
    //   14526: astore_1
    //   14527: aload_1
    //   14528: ldc 217
    //   14530: iconst_m1
    //   14531: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14534: pop
    //   14535: aload_1
    //   14536: ldc 198
    //   14538: ldc_w 482
    //   14541: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14544: pop
    //   14545: aload_0
    //   14546: aload_0
    //   14547: getfield 2650	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14550: iconst_1
    //   14551: anewarray 285	java/lang/String
    //   14554: dup
    //   14555: iconst_0
    //   14556: aload_1
    //   14557: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14560: aastore
    //   14561: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14564: goto -14380 -> 184
    //   14567: astore_1
    //   14568: ldc 209
    //   14570: iconst_1
    //   14571: ldc_w 3937
    //   14574: aload_1
    //   14575: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14578: goto -14394 -> 184
    //   14581: aload_2
    //   14582: ldc_w 3939
    //   14585: iconst_0
    //   14586: invokevirtual 887	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14589: istore 6
    //   14591: new 129	android/content/Intent
    //   14594: dup
    //   14595: invokespecial 494	android/content/Intent:<init>	()V
    //   14598: astore_2
    //   14599: iload 6
    //   14601: ifne +38 -> 14639
    //   14604: aload_2
    //   14605: invokestatic 978	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14608: ldc_w 386
    //   14611: invokevirtual 3943	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14614: pop
    //   14615: aload_2
    //   14616: ldc 160
    //   14618: aload_1
    //   14619: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14622: pop
    //   14623: aload_0
    //   14624: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14627: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14630: aload_2
    //   14631: bipush 14
    //   14633: invokevirtual 406	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14636: goto -14452 -> 184
    //   14639: aload_2
    //   14640: invokestatic 978	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14643: ldc_w 545
    //   14646: invokevirtual 3943	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14649: pop
    //   14650: goto -35 -> 14615
    //   14653: ldc_w 3945
    //   14656: aload 4
    //   14658: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14661: ifeq +61 -> 14722
    //   14664: new 113	org/json/JSONObject
    //   14667: dup
    //   14668: aload 5
    //   14670: iconst_0
    //   14671: aaload
    //   14672: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14675: ldc 198
    //   14677: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14680: astore_1
    //   14681: aload_0
    //   14682: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   14685: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   14688: iconst_m1
    //   14689: new 129	android/content/Intent
    //   14692: dup
    //   14693: invokespecial 494	android/content/Intent:<init>	()V
    //   14696: ldc 198
    //   14698: aload_1
    //   14699: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14702: invokevirtual 651	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   14705: goto -14521 -> 184
    //   14708: astore_1
    //   14709: ldc 209
    //   14711: iconst_1
    //   14712: ldc_w 3947
    //   14715: aload_1
    //   14716: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14719: goto -14535 -> 184
    //   14722: ldc_w 3949
    //   14725: aload 4
    //   14727: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14730: ifne -14546 -> 184
    //   14733: ldc_w 3951
    //   14736: aload 4
    //   14738: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14741: ifeq +99 -> 14840
    //   14744: new 113	org/json/JSONObject
    //   14747: dup
    //   14748: aload 5
    //   14750: iconst_0
    //   14751: aaload
    //   14752: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14755: astore_2
    //   14756: aload_2
    //   14757: ldc_w 809
    //   14760: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14763: astore_1
    //   14764: aload_2
    //   14765: ldc_w 3521
    //   14768: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14771: iconst_0
    //   14772: iconst_0
    //   14773: invokestatic 3956	bhyk:a	(Ljava/lang/String;ZZ)Lbhyl;
    //   14776: astore_2
    //   14777: new 113	org/json/JSONObject
    //   14780: dup
    //   14781: invokespecial 172	org/json/JSONObject:<init>	()V
    //   14784: astore_3
    //   14785: aload_3
    //   14786: ldc 217
    //   14788: aload_2
    //   14789: getfield 3959	bhyl:jdField_a_of_type_Int	I
    //   14792: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14795: pop
    //   14796: aload_3
    //   14797: ldc 160
    //   14799: aload_2
    //   14800: getfield 3960	bhyl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14803: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14806: pop
    //   14807: aload_0
    //   14808: aload_1
    //   14809: iconst_1
    //   14810: anewarray 285	java/lang/String
    //   14813: dup
    //   14814: iconst_0
    //   14815: aload_3
    //   14816: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14819: aastore
    //   14820: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14823: goto -14639 -> 184
    //   14826: astore_1
    //   14827: ldc 209
    //   14829: iconst_1
    //   14830: ldc_w 3962
    //   14833: aload_1
    //   14834: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14837: goto -14653 -> 184
    //   14840: ldc_w 3964
    //   14843: aload 4
    //   14845: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14848: ifeq +221 -> 15069
    //   14851: new 113	org/json/JSONObject
    //   14854: dup
    //   14855: aload 5
    //   14857: iconst_0
    //   14858: aaload
    //   14859: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14862: astore_2
    //   14863: aload_2
    //   14864: ldc_w 809
    //   14867: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14870: astore_1
    //   14871: aload_2
    //   14872: ldc 174
    //   14874: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14877: istore 6
    //   14879: aload_2
    //   14880: ldc_w 3521
    //   14883: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14886: astore_2
    //   14887: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14890: ifeq +40 -> 14930
    //   14893: ldc 209
    //   14895: iconst_2
    //   14896: new 549	java/lang/StringBuilder
    //   14899: dup
    //   14900: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   14903: ldc_w 3966
    //   14906: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14909: iload 6
    //   14911: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14914: ldc_w 3968
    //   14917: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14920: aload_2
    //   14921: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14924: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14927: invokestatic 882	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14930: aload_2
    //   14931: iconst_0
    //   14932: iconst_1
    //   14933: invokestatic 3956	bhyk:a	(Ljava/lang/String;ZZ)Lbhyl;
    //   14936: astore_3
    //   14937: new 113	org/json/JSONObject
    //   14940: dup
    //   14941: invokespecial 172	org/json/JSONObject:<init>	()V
    //   14944: astore 4
    //   14946: aload_3
    //   14947: getfield 3959	bhyl:jdField_a_of_type_Int	I
    //   14950: iconst_1
    //   14951: if_icmpne +46 -> 14997
    //   14954: aload 4
    //   14956: ldc 217
    //   14958: iconst_2
    //   14959: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14962: pop
    //   14963: aload_0
    //   14964: aload_1
    //   14965: iconst_1
    //   14966: anewarray 285	java/lang/String
    //   14969: dup
    //   14970: iconst_0
    //   14971: aload 4
    //   14973: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14976: aastore
    //   14977: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14980: goto -14796 -> 184
    //   14983: astore_1
    //   14984: ldc 209
    //   14986: iconst_1
    //   14987: ldc_w 3970
    //   14990: aload_1
    //   14991: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14994: goto -14810 -> 184
    //   14997: aload_3
    //   14998: getfield 3959	bhyl:jdField_a_of_type_Int	I
    //   15001: iconst_4
    //   15002: if_icmpne +32 -> 15034
    //   15005: aload 4
    //   15007: ldc 217
    //   15009: iconst_0
    //   15010: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15013: pop
    //   15014: aload_0
    //   15015: aload_1
    //   15016: iconst_1
    //   15017: anewarray 285	java/lang/String
    //   15020: dup
    //   15021: iconst_0
    //   15022: aload 4
    //   15024: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15027: aastore
    //   15028: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15031: goto -14847 -> 184
    //   15034: new 3972	bhyj
    //   15037: dup
    //   15038: aload_0
    //   15039: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15042: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15045: aload_0
    //   15046: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15049: invokevirtual 1678	bifw:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   15052: aload_1
    //   15053: iload 6
    //   15055: aload_2
    //   15056: aload_3
    //   15057: getfield 3959	bhyl:jdField_a_of_type_Int	I
    //   15060: invokespecial 3975	bhyj:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   15063: invokevirtual 3976	bhyj:show	()V
    //   15066: goto -14882 -> 184
    //   15069: ldc_w 3978
    //   15072: aload 4
    //   15074: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15077: ifeq +93 -> 15170
    //   15080: new 113	org/json/JSONObject
    //   15083: dup
    //   15084: aload 5
    //   15086: iconst_0
    //   15087: aaload
    //   15088: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15091: astore_2
    //   15092: aload_2
    //   15093: ldc_w 809
    //   15096: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15099: astore_1
    //   15100: aload_2
    //   15101: ldc_w 3521
    //   15104: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15107: astore_2
    //   15108: new 113	org/json/JSONObject
    //   15111: dup
    //   15112: invokespecial 172	org/json/JSONObject:<init>	()V
    //   15115: astore_3
    //   15116: aload_3
    //   15117: ldc 217
    //   15119: invokestatic 3979	bhyk:a	()I
    //   15122: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15125: pop
    //   15126: aload_3
    //   15127: ldc 160
    //   15129: aload_2
    //   15130: invokestatic 3980	bhyk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15133: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15136: pop
    //   15137: aload_0
    //   15138: aload_1
    //   15139: iconst_1
    //   15140: anewarray 285	java/lang/String
    //   15143: dup
    //   15144: iconst_0
    //   15145: aload_3
    //   15146: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15149: aastore
    //   15150: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15153: goto -14969 -> 184
    //   15156: astore_1
    //   15157: ldc 209
    //   15159: iconst_1
    //   15160: ldc_w 3962
    //   15163: aload_1
    //   15164: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15167: goto -14983 -> 184
    //   15170: ldc_w 3982
    //   15173: aload 4
    //   15175: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15178: ifeq +128 -> 15306
    //   15181: new 113	org/json/JSONObject
    //   15184: dup
    //   15185: aload 5
    //   15187: iconst_0
    //   15188: aaload
    //   15189: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15192: astore_1
    //   15193: aload_1
    //   15194: ldc_w 3431
    //   15197: invokevirtual 3152	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   15200: istore 12
    //   15202: aload_1
    //   15203: ldc_w 3984
    //   15206: invokevirtual 423	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   15209: astore_1
    //   15210: aload_1
    //   15211: ifnull -15027 -> 184
    //   15214: aload_1
    //   15215: ldc_w 1805
    //   15218: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15221: istore 6
    //   15223: aload_1
    //   15224: ldc_w 1807
    //   15227: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15230: istore 7
    //   15232: new 1809	android/graphics/Rect
    //   15235: dup
    //   15236: iload 6
    //   15238: iload 7
    //   15240: aload_1
    //   15241: ldc_w 1811
    //   15244: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15247: iload 6
    //   15249: iadd
    //   15250: aload_1
    //   15251: ldc_w 1813
    //   15254: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15257: iload 7
    //   15259: iadd
    //   15260: invokespecial 1815	android/graphics/Rect:<init>	(IIII)V
    //   15263: astore_1
    //   15264: aload_0
    //   15265: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15268: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15271: astore_2
    //   15272: aload_2
    //   15273: instanceof 621
    //   15276: ifeq -15092 -> 184
    //   15279: aload_2
    //   15280: checkcast 621	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   15283: aload_1
    //   15284: iload 12
    //   15286: invokevirtual 3987	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   15289: goto -15105 -> 184
    //   15292: astore_1
    //   15293: ldc 209
    //   15295: iconst_1
    //   15296: ldc_w 3989
    //   15299: aload_1
    //   15300: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15303: goto -15119 -> 184
    //   15306: ldc_w 3991
    //   15309: aload 4
    //   15311: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15314: ifeq +56 -> 15370
    //   15317: new 113	org/json/JSONObject
    //   15320: dup
    //   15321: aload 5
    //   15323: iconst_0
    //   15324: aaload
    //   15325: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15328: astore_1
    //   15329: aload_1
    //   15330: ifnonnull +21 -> 15351
    //   15333: iconst_1
    //   15334: ireturn
    //   15335: astore_1
    //   15336: ldc 209
    //   15338: iconst_1
    //   15339: ldc_w 3993
    //   15342: aload_1
    //   15343: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15346: aconst_null
    //   15347: astore_1
    //   15348: goto -19 -> 15329
    //   15351: invokestatic 3996	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   15354: new 3998	com/tencent/mobileqq/jsp/UiApiPlugin$8
    //   15357: dup
    //   15358: aload_0
    //   15359: aload_1
    //   15360: invokespecial 3999	com/tencent/mobileqq/jsp/UiApiPlugin$8:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   15363: invokevirtual 1331	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   15366: pop
    //   15367: goto -15183 -> 184
    //   15370: ldc_w 4001
    //   15373: aload 4
    //   15375: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15378: ifeq +117 -> 15495
    //   15381: new 113	org/json/JSONObject
    //   15384: dup
    //   15385: aload 5
    //   15387: iconst_0
    //   15388: aaload
    //   15389: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15392: astore_1
    //   15393: aload_0
    //   15394: aload_1
    //   15395: ldc_w 809
    //   15398: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15401: putfield 4003	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   15404: aload_1
    //   15405: ldc_w 3705
    //   15408: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15411: astore_2
    //   15412: aload_1
    //   15413: ldc_w 4005
    //   15416: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15419: astore_3
    //   15420: aload_1
    //   15421: ldc_w 4007
    //   15424: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15427: astore 4
    //   15429: aload_1
    //   15430: ldc_w 4009
    //   15433: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15436: astore 5
    //   15438: aload_1
    //   15439: ldc_w 4011
    //   15442: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15445: istore 6
    //   15447: aload_0
    //   15448: aload_0
    //   15449: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15452: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15455: iconst_3
    //   15456: aload_2
    //   15457: aload_3
    //   15458: sipush 3016
    //   15461: iload 6
    //   15463: aload 4
    //   15465: aload 5
    //   15467: aconst_null
    //   15468: aconst_null
    //   15469: aconst_null
    //   15470: invokestatic 4016	com/tencent/mobileqq/activity/AddFriendLogicActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15473: bipush 16
    //   15475: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   15478: goto -15294 -> 184
    //   15481: astore_1
    //   15482: ldc 209
    //   15484: iconst_1
    //   15485: ldc_w 4018
    //   15488: aload_1
    //   15489: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15492: goto -15308 -> 184
    //   15495: ldc_w 4020
    //   15498: aload 4
    //   15500: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15503: ifeq +178 -> 15681
    //   15506: new 113	org/json/JSONObject
    //   15509: dup
    //   15510: aload 5
    //   15512: iconst_0
    //   15513: aaload
    //   15514: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15517: astore_3
    //   15518: aload_3
    //   15519: ldc_w 4022
    //   15522: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15525: astore_1
    //   15526: aload_3
    //   15527: ldc_w 2476
    //   15530: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15533: astore_2
    //   15534: aload_3
    //   15535: ldc_w 2485
    //   15538: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15541: astore_3
    //   15542: aload_1
    //   15543: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15546: ifne +69 -> 15615
    //   15549: new 1570	java/io/File
    //   15552: dup
    //   15553: aload_1
    //   15554: invokespecial 2009	java/io/File:<init>	(Ljava/lang/String;)V
    //   15557: astore_1
    //   15558: aload_1
    //   15559: invokevirtual 2369	java/io/File:exists	()Z
    //   15562: ifne +45 -> 15607
    //   15565: aload_0
    //   15566: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15569: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   15572: invokevirtual 2330	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15575: iconst_1
    //   15576: ldc_w 4023
    //   15579: invokestatic 2335	anvx:a	(I)Ljava/lang/String;
    //   15582: iconst_0
    //   15583: invokestatic 890	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15586: invokevirtual 2338	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15589: pop
    //   15590: goto -15406 -> 184
    //   15593: astore_1
    //   15594: ldc 209
    //   15596: iconst_1
    //   15597: ldc_w 4025
    //   15600: aload_1
    //   15601: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15604: goto -15420 -> 184
    //   15607: aload_0
    //   15608: aload_1
    //   15609: invokevirtual 2011	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   15612: goto -15428 -> 184
    //   15615: aload_2
    //   15616: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15619: ifne +19 -> 15638
    //   15622: aload_0
    //   15623: aload_2
    //   15624: iconst_0
    //   15625: invokestatic 1028	bhcu:decode	(Ljava/lang/String;I)[B
    //   15628: aload_2
    //   15629: invokestatic 2481	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   15632: invokevirtual 4027	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   15635: goto -15451 -> 184
    //   15638: aload_3
    //   15639: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15642: ifne +11 -> 15653
    //   15645: aload_0
    //   15646: aload_3
    //   15647: invokevirtual 4029	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   15650: goto -15466 -> 184
    //   15653: aload_0
    //   15654: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15657: invokevirtual 1688	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   15660: invokevirtual 2330	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15663: iconst_1
    //   15664: ldc_w 4030
    //   15667: invokestatic 2335	anvx:a	(I)Ljava/lang/String;
    //   15670: iconst_0
    //   15671: invokestatic 890	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15674: invokevirtual 2338	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15677: pop
    //   15678: goto -15494 -> 184
    //   15681: ldc_w 4032
    //   15684: aload 4
    //   15686: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15689: ifeq +44 -> 15733
    //   15692: aload_0
    //   15693: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15696: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15699: iconst_m1
    //   15700: new 129	android/content/Intent
    //   15703: dup
    //   15704: invokespecial 494	android/content/Intent:<init>	()V
    //   15707: ldc_w 4034
    //   15710: aload 5
    //   15712: iconst_0
    //   15713: aaload
    //   15714: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15717: invokevirtual 651	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   15720: aload_0
    //   15721: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15724: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15727: invokevirtual 654	android/app/Activity:finish	()V
    //   15730: goto -15546 -> 184
    //   15733: ldc_w 4036
    //   15736: aload 4
    //   15738: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15741: ifeq +13 -> 15754
    //   15744: aload_0
    //   15745: aload 5
    //   15747: iconst_0
    //   15748: aaload
    //   15749: invokevirtual 4038	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   15752: iconst_1
    //   15753: ireturn
    //   15754: ldc_w 4040
    //   15757: aload 4
    //   15759: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15762: ifeq +102 -> 15864
    //   15765: aload 5
    //   15767: arraylength
    //   15768: iconst_1
    //   15769: if_icmpne +95 -> 15864
    //   15772: new 113	org/json/JSONObject
    //   15775: dup
    //   15776: aload 5
    //   15778: iconst_0
    //   15779: aaload
    //   15780: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15783: astore_1
    //   15784: aload_1
    //   15785: ldc_w 809
    //   15788: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15791: astore_2
    //   15792: new 4042	bgpy
    //   15795: dup
    //   15796: aload_1
    //   15797: ldc_w 4044
    //   15800: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15803: aload_1
    //   15804: ldc_w 4046
    //   15807: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15810: aload_1
    //   15811: ldc_w 4048
    //   15814: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15817: aload_1
    //   15818: ldc_w 4050
    //   15821: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15824: aload_1
    //   15825: ldc_w 4052
    //   15828: invokevirtual 2699	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   15831: invokespecial 4055	bgpy:<init>	(IIIIJ)V
    //   15834: aload_0
    //   15835: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15838: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15841: new 4057	awcj
    //   15844: dup
    //   15845: aload_0
    //   15846: aload_2
    //   15847: invokespecial 4058	awcj:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   15850: invokevirtual 4061	bgpy:a	(Landroid/app/Activity;Lbgqc;)V
    //   15853: goto -15669 -> 184
    //   15856: astore_1
    //   15857: aload_1
    //   15858: invokevirtual 2866	org/json/JSONException:printStackTrace	()V
    //   15861: goto -15677 -> 184
    //   15864: ldc_w 4063
    //   15867: aload 4
    //   15869: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15872: ifeq +102 -> 15974
    //   15875: new 113	org/json/JSONObject
    //   15878: dup
    //   15879: aload 5
    //   15881: iconst_0
    //   15882: aaload
    //   15883: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15886: ldc_w 809
    //   15889: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15892: astore_1
    //   15893: new 113	org/json/JSONObject
    //   15896: dup
    //   15897: invokespecial 172	org/json/JSONObject:<init>	()V
    //   15900: astore_2
    //   15901: aload_0
    //   15902: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   15905: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   15908: astore_3
    //   15909: aload_3
    //   15910: ifnonnull +5 -> 15915
    //   15913: iconst_1
    //   15914: ireturn
    //   15915: aload_3
    //   15916: invokestatic 4066	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:a	(Landroid/app/Activity;)V
    //   15919: aload_2
    //   15920: ldc_w 4068
    //   15923: invokestatic 4070	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:b	()Z
    //   15926: invokevirtual 189	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   15929: pop
    //   15930: aload_2
    //   15931: ldc_w 4072
    //   15934: getstatic 4073	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:jdField_a_of_type_Int	I
    //   15937: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15940: pop
    //   15941: aload_0
    //   15942: aload_1
    //   15943: iconst_1
    //   15944: anewarray 285	java/lang/String
    //   15947: dup
    //   15948: iconst_0
    //   15949: aload_2
    //   15950: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15953: aastore
    //   15954: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15957: goto -15773 -> 184
    //   15960: astore_1
    //   15961: ldc 209
    //   15963: iconst_1
    //   15964: ldc_w 4075
    //   15967: aload_1
    //   15968: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15971: goto -15787 -> 184
    //   15974: ldc_w 4077
    //   15977: aload 4
    //   15979: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15982: ifeq +137 -> 16119
    //   15985: new 113	org/json/JSONObject
    //   15988: dup
    //   15989: aload 5
    //   15991: iconst_0
    //   15992: aaload
    //   15993: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15996: astore_2
    //   15997: aload_2
    //   15998: ldc_w 4079
    //   16001: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16004: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16007: astore_1
    //   16008: aload_2
    //   16009: ldc_w 809
    //   16012: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16015: astore_2
    //   16016: aload_1
    //   16017: invokevirtual 2629	java/lang/Integer:intValue	()I
    //   16020: iconst_1
    //   16021: if_icmpne +77 -> 16098
    //   16024: iconst_1
    //   16025: invokestatic 4082	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16028: new 113	org/json/JSONObject
    //   16031: dup
    //   16032: invokespecial 172	org/json/JSONObject:<init>	()V
    //   16035: astore_1
    //   16036: aload_1
    //   16037: ldc 217
    //   16039: ldc_w 3477
    //   16042: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16045: pop
    //   16046: invokestatic 4083	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	()Z
    //   16049: ifeq +64 -> 16113
    //   16052: iconst_1
    //   16053: istore 6
    //   16055: aload_1
    //   16056: ldc_w 4079
    //   16059: iload 6
    //   16061: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16064: pop
    //   16065: aload_0
    //   16066: aload_2
    //   16067: iconst_1
    //   16068: anewarray 285	java/lang/String
    //   16071: dup
    //   16072: iconst_0
    //   16073: aload_1
    //   16074: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16077: aastore
    //   16078: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16081: goto -15897 -> 184
    //   16084: astore_1
    //   16085: ldc 209
    //   16087: iconst_1
    //   16088: ldc_w 4085
    //   16091: aload_1
    //   16092: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16095: goto -15911 -> 184
    //   16098: aload_1
    //   16099: invokevirtual 2629	java/lang/Integer:intValue	()I
    //   16102: iconst_2
    //   16103: if_icmpne -75 -> 16028
    //   16106: iconst_0
    //   16107: invokestatic 4082	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16110: goto -82 -> 16028
    //   16113: iconst_2
    //   16114: istore 6
    //   16116: goto -61 -> 16055
    //   16119: ldc_w 4087
    //   16122: aload 4
    //   16124: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16127: ifeq +166 -> 16293
    //   16130: new 113	org/json/JSONObject
    //   16133: dup
    //   16134: aload 5
    //   16136: iconst_0
    //   16137: aaload
    //   16138: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16141: astore 4
    //   16143: aload 4
    //   16145: ldc_w 4089
    //   16148: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16151: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16154: astore_1
    //   16155: aload 4
    //   16157: ldc_w 4091
    //   16160: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16163: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16166: astore_2
    //   16167: aload 4
    //   16169: ldc_w 4093
    //   16172: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16175: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16178: astore_3
    //   16179: aload 4
    //   16181: ldc_w 809
    //   16184: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16187: astore 4
    //   16189: ldc 209
    //   16191: iconst_1
    //   16192: new 549	java/lang/StringBuilder
    //   16195: dup
    //   16196: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   16199: ldc_w 4095
    //   16202: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16205: aload_1
    //   16206: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16209: ldc_w 4097
    //   16212: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16215: aload_2
    //   16216: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16219: ldc_w 4099
    //   16222: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16225: aload_3
    //   16226: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16229: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16232: invokestatic 882	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16235: aload_0
    //   16236: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16239: ifnonnull +17 -> 16256
    //   16242: aload_0
    //   16243: invokestatic 2044	aady:a	()Laady;
    //   16246: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16249: aload_0
    //   16250: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16253: invokevirtual 2046	aady:a	()V
    //   16256: aload_0
    //   16257: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16260: aload_1
    //   16261: aload_2
    //   16262: aload_3
    //   16263: new 4101	awbe
    //   16266: dup
    //   16267: aload_0
    //   16268: aload 4
    //   16270: invokespecial 4102	awbe:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16273: invokevirtual 4105	aady:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Laaea;)V
    //   16276: goto -16092 -> 184
    //   16279: astore_1
    //   16280: ldc 209
    //   16282: iconst_1
    //   16283: ldc_w 4107
    //   16286: aload_1
    //   16287: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16290: goto -16106 -> 184
    //   16293: ldc_w 4109
    //   16296: aload 4
    //   16298: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16301: ifeq +139 -> 16440
    //   16304: new 113	org/json/JSONObject
    //   16307: dup
    //   16308: aload 5
    //   16310: iconst_0
    //   16311: aaload
    //   16312: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16315: astore_3
    //   16316: aload_3
    //   16317: ldc_w 4111
    //   16320: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16323: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16326: astore_1
    //   16327: aload_3
    //   16328: ldc_w 4091
    //   16331: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16334: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16337: astore_2
    //   16338: aload_3
    //   16339: ldc_w 2724
    //   16342: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16345: astore_3
    //   16346: ldc 209
    //   16348: iconst_1
    //   16349: new 549	java/lang/StringBuilder
    //   16352: dup
    //   16353: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   16356: ldc_w 4113
    //   16359: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16362: aload_1
    //   16363: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16366: ldc_w 4115
    //   16369: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16372: aload_2
    //   16373: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16376: ldc_w 4117
    //   16379: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16382: aload_3
    //   16383: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16386: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16389: invokestatic 882	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16392: aload_0
    //   16393: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16396: ifnonnull +17 -> 16413
    //   16399: aload_0
    //   16400: invokestatic 2044	aady:a	()Laady;
    //   16403: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16406: aload_0
    //   16407: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16410: invokevirtual 2046	aady:a	()V
    //   16413: aload_0
    //   16414: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16417: aload_1
    //   16418: aload_2
    //   16419: aload_3
    //   16420: invokevirtual 4120	aady:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V
    //   16423: goto -16239 -> 184
    //   16426: astore_1
    //   16427: ldc 209
    //   16429: iconst_1
    //   16430: ldc_w 4122
    //   16433: aload_1
    //   16434: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16437: goto -16253 -> 184
    //   16440: ldc_w 4124
    //   16443: aload 4
    //   16445: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16448: ifeq +139 -> 16587
    //   16451: new 113	org/json/JSONObject
    //   16454: dup
    //   16455: aload 5
    //   16457: iconst_0
    //   16458: aaload
    //   16459: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16462: astore_3
    //   16463: aload_3
    //   16464: ldc_w 4111
    //   16467: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16470: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16473: astore_1
    //   16474: aload_3
    //   16475: ldc_w 2724
    //   16478: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16481: astore_2
    //   16482: aload_3
    //   16483: ldc_w 4091
    //   16486: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16489: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16492: astore_3
    //   16493: ldc 209
    //   16495: iconst_1
    //   16496: new 549	java/lang/StringBuilder
    //   16499: dup
    //   16500: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   16503: ldc_w 4126
    //   16506: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16509: aload_1
    //   16510: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16513: ldc_w 4117
    //   16516: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16519: aload_2
    //   16520: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16523: ldc_w 4115
    //   16526: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16529: aload_3
    //   16530: invokevirtual 898	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16533: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16536: invokestatic 882	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16539: aload_0
    //   16540: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16543: ifnonnull +17 -> 16560
    //   16546: aload_0
    //   16547: invokestatic 2044	aady:a	()Laady;
    //   16550: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16553: aload_0
    //   16554: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16557: invokevirtual 2046	aady:a	()V
    //   16560: aload_0
    //   16561: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16564: aload_1
    //   16565: aload_2
    //   16566: aload_3
    //   16567: invokevirtual 4129	aady:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V
    //   16570: goto -16386 -> 184
    //   16573: astore_1
    //   16574: ldc 209
    //   16576: iconst_1
    //   16577: ldc_w 4131
    //   16580: aload_1
    //   16581: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16584: goto -16400 -> 184
    //   16587: ldc_w 4133
    //   16590: aload 4
    //   16592: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16595: ifeq +252 -> 16847
    //   16598: new 113	org/json/JSONObject
    //   16601: dup
    //   16602: aload 5
    //   16604: iconst_0
    //   16605: aaload
    //   16606: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16609: astore 4
    //   16611: aload 4
    //   16613: ldc_w 4135
    //   16616: iconst_1
    //   16617: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   16620: ifne +41 -> 16661
    //   16623: aload 4
    //   16625: aload 4
    //   16627: ldc_w 809
    //   16630: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16633: new 4137	awbf
    //   16636: dup
    //   16637: aload_0
    //   16638: invokespecial 4138	awbf:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   16641: invokestatic 4143	uta:a	(Lorg/json/JSONObject;Ljava/lang/String;Ltwh;)V
    //   16644: goto -16460 -> 184
    //   16647: astore_1
    //   16648: ldc 209
    //   16650: iconst_1
    //   16651: ldc_w 4145
    //   16654: aload_1
    //   16655: invokestatic 417	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16658: goto -16474 -> 184
    //   16661: aload 4
    //   16663: ldc_w 1635
    //   16666: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16669: pop
    //   16670: aload 4
    //   16672: ldc_w 1637
    //   16675: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16678: pop
    //   16679: aload 4
    //   16681: ldc_w 1639
    //   16684: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   16687: pop
    //   16688: aload 4
    //   16690: ldc_w 1641
    //   16693: invokevirtual 1645	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   16696: pop2
    //   16697: aload 4
    //   16699: ldc_w 1653
    //   16702: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16705: astore_1
    //   16706: aload 4
    //   16708: ldc_w 1655
    //   16711: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16714: astore_2
    //   16715: aload 4
    //   16717: ldc_w 1657
    //   16720: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16723: astore_3
    //   16724: aload 4
    //   16726: ldc_w 1659
    //   16729: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16732: astore 4
    //   16734: new 2431	java/util/HashMap
    //   16737: dup
    //   16738: invokespecial 3641	java/util/HashMap:<init>	()V
    //   16741: astore 14
    //   16743: aload 14
    //   16745: ldc_w 1653
    //   16748: aload_1
    //   16749: invokeinterface 4146 3 0
    //   16754: pop
    //   16755: aload 14
    //   16757: ldc_w 1655
    //   16760: aload_2
    //   16761: invokeinterface 4146 3 0
    //   16766: pop
    //   16767: aload 14
    //   16769: ldc_w 1657
    //   16772: aload_3
    //   16773: invokeinterface 4146 3 0
    //   16778: pop
    //   16779: aload 14
    //   16781: ldc_w 1659
    //   16784: aload 4
    //   16786: invokeinterface 4146 3 0
    //   16791: pop
    //   16792: aload_0
    //   16793: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16796: ifnonnull +17 -> 16813
    //   16799: aload_0
    //   16800: invokestatic 2044	aady:a	()Laady;
    //   16803: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16806: aload_0
    //   16807: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16810: invokevirtual 2046	aady:a	()V
    //   16813: new 4148	awbg
    //   16816: dup
    //   16817: aload_0
    //   16818: aload 14
    //   16820: invokespecial 4151	awbg:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/util/Map;)V
    //   16823: astore_1
    //   16824: aload_0
    //   16825: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aady	Laady;
    //   16828: aload_1
    //   16829: invokevirtual 4154	aady:a	(Laaea;)I
    //   16832: istore 6
    //   16834: aload_0
    //   16835: aload 5
    //   16837: iconst_0
    //   16838: aaload
    //   16839: iload 6
    //   16841: invokevirtual 4155	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;I)V
    //   16844: goto -16660 -> 184
    //   16847: ldc_w 4157
    //   16850: aload 4
    //   16852: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16855: ifeq +251 -> 17106
    //   16858: new 113	org/json/JSONObject
    //   16861: dup
    //   16862: aload 5
    //   16864: iconst_0
    //   16865: aaload
    //   16866: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16869: astore_1
    //   16870: aload_1
    //   16871: ldc_w 1726
    //   16874: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16877: astore_2
    //   16878: aload_0
    //   16879: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   16882: invokevirtual 1875	bifw:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   16885: astore_3
    //   16886: aload_1
    //   16887: ldc_w 4159
    //   16890: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16893: istore 6
    //   16895: aload_1
    //   16896: ldc_w 425
    //   16899: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16902: astore 4
    //   16904: aload_1
    //   16905: ldc_w 272
    //   16908: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16911: astore 5
    //   16913: aload_1
    //   16914: ldc_w 4161
    //   16917: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16920: istore 7
    //   16922: ldc_w 3346
    //   16925: aload_2
    //   16926: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16929: ifeq +104 -> 17033
    //   16932: aload_3
    //   16933: aload 4
    //   16935: putfield 4164	com/tencent/mobileqq/webview/swift/WebViewFragment:mKeyWording	Ljava/lang/String;
    //   16938: aload_3
    //   16939: iload 6
    //   16941: putfield 4167	com/tencent/mobileqq/webview/swift/WebViewFragment:mBusiID	I
    //   16944: aload_3
    //   16945: iload 7
    //   16947: putfield 4170	com/tencent/mobileqq/webview/swift/WebViewFragment:mWhere	I
    //   16950: aload_3
    //   16951: aload 5
    //   16953: putfield 4173	com/tencent/mobileqq/webview/swift/WebViewFragment:mStyle	Ljava/lang/String;
    //   16956: iload 7
    //   16958: iconst_1
    //   16959: if_icmpne +62 -> 17021
    //   16962: aload_0
    //   16963: iload 6
    //   16965: invokevirtual 4175	com/tencent/mobileqq/jsp/UiApiPlugin:b	(I)V
    //   16968: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16971: ifeq -16787 -> 184
    //   16974: ldc 209
    //   16976: iconst_2
    //   16977: new 549	java/lang/StringBuilder
    //   16980: dup
    //   16981: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   16984: ldc_w 4177
    //   16987: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16990: aload_1
    //   16991: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16994: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16997: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17000: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17003: goto -16819 -> 184
    //   17006: astore_1
    //   17007: ldc 209
    //   17009: iconst_1
    //   17010: aload_1
    //   17011: iconst_0
    //   17012: anewarray 277	java/lang/Object
    //   17015: invokestatic 1734	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   17018: goto -16834 -> 184
    //   17021: aload_3
    //   17022: invokevirtual 4180	com/tencent/mobileqq/webview/swift/WebViewFragment:initNativeMiniAIOUser	()V
    //   17025: aload_3
    //   17026: iconst_1
    //   17027: invokevirtual 4183	com/tencent/mobileqq/webview/swift/WebViewFragment:setMiniAIOEntry	(Z)V
    //   17030: goto -62 -> 16968
    //   17033: ldc_w 4185
    //   17036: aload_2
    //   17037: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17040: ifeq +11 -> 17051
    //   17043: aload_3
    //   17044: iconst_0
    //   17045: invokevirtual 4183	com/tencent/mobileqq/webview/swift/WebViewFragment:setMiniAIOEntry	(Z)V
    //   17048: goto -80 -> 16968
    //   17051: ldc_w 4079
    //   17054: aload_2
    //   17055: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17058: ifeq +27 -> 17085
    //   17061: aload_3
    //   17062: aload 4
    //   17064: putfield 4164	com/tencent/mobileqq/webview/swift/WebViewFragment:mKeyWording	Ljava/lang/String;
    //   17067: aload_0
    //   17068: getfield 2166	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17071: ifnull -103 -> 16968
    //   17074: aload_0
    //   17075: getfield 2166	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17078: aconst_null
    //   17079: invokevirtual 4188	com/tencent/mobileqq/activity/miniaio/MiniMsgUser:onClick	(Landroid/view/View;)V
    //   17082: goto -114 -> 16968
    //   17085: ldc_w 4190
    //   17088: aload_2
    //   17089: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17092: ifeq -124 -> 16968
    //   17095: invokestatic 4195	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:getInstance	()Lcom/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient;
    //   17098: iload 6
    //   17100: invokevirtual 4198	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:clearBusiness	(I)V
    //   17103: goto -135 -> 16968
    //   17106: ldc_w 4200
    //   17109: aload 4
    //   17111: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17114: ifeq +68 -> 17182
    //   17117: iconst_0
    //   17118: new 113	org/json/JSONObject
    //   17121: dup
    //   17122: aload 5
    //   17124: iconst_0
    //   17125: aaload
    //   17126: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17129: ldc_w 809
    //   17132: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17135: new 4202	awbh
    //   17138: dup
    //   17139: aload_0
    //   17140: invokespecial 4203	awbh:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   17143: invokestatic 4205	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZLjava/lang/String;Ltwh;)V
    //   17146: goto -16962 -> 184
    //   17149: astore_1
    //   17150: ldc 209
    //   17152: iconst_1
    //   17153: new 549	java/lang/StringBuilder
    //   17156: dup
    //   17157: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   17160: ldc_w 4207
    //   17163: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17166: aload_1
    //   17167: invokevirtual 921	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17170: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17173: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17176: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17179: goto -16995 -> 184
    //   17182: ldc_w 4209
    //   17185: aload 4
    //   17187: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17190: ifeq +79 -> 17269
    //   17193: new 113	org/json/JSONObject
    //   17196: dup
    //   17197: aload 5
    //   17199: iconst_0
    //   17200: aaload
    //   17201: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17204: ldc_w 809
    //   17207: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17210: astore_1
    //   17211: new 113	org/json/JSONObject
    //   17214: dup
    //   17215: aload 5
    //   17217: iconst_0
    //   17218: aaload
    //   17219: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17222: aload_1
    //   17223: aload_0
    //   17224: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   17227: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   17230: invokestatic 4211	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;Landroid/app/Activity;)V
    //   17233: goto -17049 -> 184
    //   17236: astore_1
    //   17237: ldc 209
    //   17239: iconst_1
    //   17240: new 549	java/lang/StringBuilder
    //   17243: dup
    //   17244: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   17247: ldc_w 4213
    //   17250: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17253: aload_1
    //   17254: invokevirtual 921	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17257: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17260: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17263: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17266: goto -17082 -> 184
    //   17269: aload 4
    //   17271: ldc_w 4215
    //   17274: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17277: ifeq +10 -> 17287
    //   17280: aload_0
    //   17281: invokevirtual 4216	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   17284: goto -17100 -> 184
    //   17287: ldc_w 4218
    //   17290: aload 4
    //   17292: invokevirtual 456	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17295: ifeq -17111 -> 184
    //   17298: aconst_null
    //   17299: astore_2
    //   17300: aload_2
    //   17301: astore_1
    //   17302: new 113	org/json/JSONObject
    //   17305: dup
    //   17306: aload 5
    //   17308: iconst_0
    //   17309: aaload
    //   17310: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17313: astore_3
    //   17314: aload_2
    //   17315: astore_1
    //   17316: aload_3
    //   17317: ldc_w 809
    //   17320: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17323: astore_2
    //   17324: aload_2
    //   17325: astore_1
    //   17326: aload_0
    //   17327: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbifw;
    //   17330: invokevirtual 1445	bifw:a	()Landroid/app/Activity;
    //   17333: aload_3
    //   17334: invokestatic 4224	com/tencent/hippy/qq/utils/HippyAccessHelper:startHippyPage	(Landroid/content/Context;Lorg/json/JSONObject;)Z
    //   17337: istore 12
    //   17339: iload 12
    //   17341: ifeq +56 -> 17397
    //   17344: iconst_0
    //   17345: istore 6
    //   17347: aload_2
    //   17348: astore_1
    //   17349: aload_1
    //   17350: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17353: ifne -17169 -> 184
    //   17356: new 113	org/json/JSONObject
    //   17359: dup
    //   17360: invokespecial 172	org/json/JSONObject:<init>	()V
    //   17363: astore_2
    //   17364: aload_2
    //   17365: ldc_w 1295
    //   17368: iload 6
    //   17370: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   17373: pop
    //   17374: aload_0
    //   17375: aload_1
    //   17376: iconst_1
    //   17377: anewarray 285	java/lang/String
    //   17380: dup
    //   17381: iconst_0
    //   17382: aload_2
    //   17383: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   17386: aastore
    //   17387: invokevirtual 782	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   17390: goto -17206 -> 184
    //   17393: astore_1
    //   17394: goto -17210 -> 184
    //   17397: iconst_m1
    //   17398: istore 6
    //   17400: aload_2
    //   17401: astore_1
    //   17402: goto -53 -> 17349
    //   17405: astore_2
    //   17406: ldc 209
    //   17408: iconst_1
    //   17409: new 549	java/lang/StringBuilder
    //   17412: dup
    //   17413: invokespecial 550	java/lang/StringBuilder:<init>	()V
    //   17416: ldc_w 4226
    //   17419: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17422: aload_2
    //   17423: invokevirtual 921	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17426: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17429: invokevirtual 560	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17432: invokestatic 916	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17435: iconst_m1
    //   17436: istore 6
    //   17438: goto -89 -> 17349
    //   17441: iconst_0
    //   17442: ireturn
    //   17443: astore_2
    //   17444: goto -6795 -> 10649
    //   17447: astore 15
    //   17449: goto -13875 -> 3574
    //   17452: aload_1
    //   17453: astore_2
    //   17454: ldc_w 482
    //   17457: astore_1
    //   17458: goto -4349 -> 13109
    //   17461: aconst_null
    //   17462: astore_1
    //   17463: aload_3
    //   17464: astore_2
    //   17465: goto -6520 -> 10945
    //   17468: goto -7959 -> 9509
    //   17471: aconst_null
    //   17472: astore_1
    //   17473: goto -10334 -> 7139
    //   17476: aconst_null
    //   17477: astore_1
    //   17478: goto -10576 -> 6902
    //   17481: iconst_0
    //   17482: istore 6
    //   17484: goto -10627 -> 6857
    //   17487: aconst_null
    //   17488: astore_1
    //   17489: goto -10800 -> 6689
    //   17492: astore_1
    //   17493: goto -17309 -> 184
    //   17496: iconst_1
    //   17497: ireturn
    //   17498: iconst_1
    //   17499: ireturn
    //   17500: iconst_1
    //   17501: ireturn
    //   17502: iconst_1
    //   17503: ireturn
    //   17504: iconst_1
    //   17505: ireturn
    //   17506: astore_1
    //   17507: goto -17323 -> 184
    //   17510: iload 6
    //   17512: tableswitch	default:+20 -> 17532, 1001:+-13440->4072
    //   17533: breakpoint
    //   17534: l2i
    //   17535: iload 6
    //   17537: tableswitch	default:+19 -> 17556, 1001:+-13241->4296
    //   17557: newarray 慢⁤污潬慣楴湯
    //   17559: iconst_0
    //   17560: istore 12
    //   17562: goto -12881 -> 4681
    //   17565: iconst_0
    //   17566: istore 12
    //   17568: goto -12500 -> 5068
    //   17571: iload 6
    //   17573: ldc_w 1975
    //   17576: ior
    //   17577: istore 6
    //   17579: goto -11431 -> 6148
    //   17582: iload 6
    //   17584: iconst_1
    //   17585: iadd
    //   17586: istore 6
    //   17588: goto -10991 -> 6597
    //   17591: iconst_1
    //   17592: istore 6
    //   17594: goto -8733 -> 8861
    //   17597: iload 6
    //   17599: iconst_1
    //   17600: iadd
    //   17601: istore 6
    //   17603: goto -6471 -> 11132
    //   17606: iconst_1
    //   17607: ireturn
    //   17608: iconst_1
    //   17609: ireturn
    //   17610: iconst_1
    //   17611: ireturn
    //   17612: iconst_1
    //   17613: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17614	0	this	UiApiPlugin
    //   0	17614	1	paramJsBridgeListener	JsBridgeListener
    //   0	17614	2	paramString1	String
    //   0	17614	3	paramString2	String
    //   0	17614	4	paramString3	String
    //   0	17614	5	paramVarArgs	String[]
    //   268	17334	6	n	int
    //   4761	12199	7	i1	int
    //   4770	9434	8	i2	int
    //   4779	205	9	i3	int
    //   259	7455	10	l1	long
    //   1454	16113	12	bool1	boolean
    //   8683	5523	13	bool2	boolean
    //   615	16204	14	localObject1	Object
    //   3508	9147	15	localObject2	Object
    //   17447	1	15	localJSONException	JSONException
    //   10879	53	16	str	String
    // Exception table:
    //   from	to	target	type
    //   33	91	186	org/json/JSONException
    //   96	176	186	org/json/JSONException
    //   176	184	186	org/json/JSONException
    //   240	355	358	org/json/JSONException
    //   442	467	528	org/json/JSONException
    //   469	525	528	org/json/JSONException
    //   559	588	737	org/json/JSONException
    //   590	689	737	org/json/JSONException
    //   695	703	737	org/json/JSONException
    //   707	719	737	org/json/JSONException
    //   719	734	737	org/json/JSONException
    //   763	784	737	org/json/JSONException
    //   798	838	841	org/json/JSONException
    //   873	880	888	java/lang/Exception
    //   873	880	897	finally
    //   1140	1157	1160	org/json/JSONException
    //   1198	1206	1287	org/json/JSONException
    //   1210	1217	1287	org/json/JSONException
    //   1220	1284	1287	org/json/JSONException
    //   1325	1333	1366	org/json/JSONException
    //   1337	1344	1366	org/json/JSONException
    //   1347	1363	1366	org/json/JSONException
    //   1404	1412	1483	org/json/JSONException
    //   1416	1423	1483	org/json/JSONException
    //   1426	1480	1483	org/json/JSONException
    //   1521	1529	1561	org/json/JSONException
    //   1533	1540	1561	org/json/JSONException
    //   1543	1558	1561	org/json/JSONException
    //   1599	1607	1639	java/lang/Exception
    //   1611	1618	1639	java/lang/Exception
    //   1621	1636	1639	java/lang/Exception
    //   1901	1962	2052	org/json/JSONException
    //   1964	2035	2052	org/json/JSONException
    //   2037	2049	2052	org/json/JSONException
    //   2085	2131	2052	org/json/JSONException
    //   2152	2185	2236	org/json/JSONException
    //   2189	2209	2236	org/json/JSONException
    //   2209	2225	2236	org/json/JSONException
    //   2229	2233	2236	org/json/JSONException
    //   2262	2283	2286	org/json/JSONException
    //   2312	2345	2372	org/json/JSONException
    //   2349	2369	2372	org/json/JSONException
    //   2398	2431	2491	org/json/JSONException
    //   2435	2455	2491	org/json/JSONException
    //   2517	2550	2577	org/json/JSONException
    //   2554	2574	2577	org/json/JSONException
    //   2603	2636	2696	org/json/JSONException
    //   2640	2660	2696	org/json/JSONException
    //   2722	2755	2815	org/json/JSONException
    //   2759	2779	2815	org/json/JSONException
    //   2841	2874	2934	org/json/JSONException
    //   2878	2898	2934	org/json/JSONException
    //   2960	3014	3016	org/json/JSONException
    //   3042	3140	3143	org/json/JSONException
    //   3158	3165	3143	org/json/JSONException
    //   3183	3248	3143	org/json/JSONException
    //   3251	3258	3143	org/json/JSONException
    //   3261	3287	3143	org/json/JSONException
    //   3291	3331	3143	org/json/JSONException
    //   3334	3369	3143	org/json/JSONException
    //   3373	3428	3143	org/json/JSONException
    //   3042	3140	3168	java/lang/Exception
    //   3158	3165	3168	java/lang/Exception
    //   3183	3248	3168	java/lang/Exception
    //   3251	3258	3168	java/lang/Exception
    //   3261	3287	3168	java/lang/Exception
    //   3291	3331	3168	java/lang/Exception
    //   3334	3369	3168	java/lang/Exception
    //   3373	3428	3168	java/lang/Exception
    //   3472	3537	3643	java/lang/Exception
    //   3537	3547	3643	java/lang/Exception
    //   3547	3556	3643	java/lang/Exception
    //   3561	3574	3643	java/lang/Exception
    //   3574	3640	3643	java/lang/Exception
    //   3705	3713	3643	java/lang/Exception
    //   3716	3743	3643	java/lang/Exception
    //   3746	3808	3643	java/lang/Exception
    //   3808	3827	3643	java/lang/Exception
    //   3893	3976	3643	java/lang/Exception
    //   3979	4018	3643	java/lang/Exception
    //   4021	4037	3643	java/lang/Exception
    //   4085	4153	3643	java/lang/Exception
    //   4157	4177	3643	java/lang/Exception
    //   4177	4203	3643	java/lang/Exception
    //   4206	4271	3643	java/lang/Exception
    //   3456	3468	3698	org/json/JSONException
    //   3537	3547	3704	org/json/JSONException
    //   3827	3841	3889	java/lang/Exception
    //   3844	3879	3889	java/lang/Exception
    //   3879	3886	3889	java/lang/Exception
    //   4040	4069	3889	java/lang/Exception
    //   4072	4082	3889	java/lang/Exception
    //   4271	4293	3889	java/lang/Exception
    //   4296	4306	3889	java/lang/Exception
    //   4345	4374	5651	org/json/JSONException
    //   4376	4384	5651	org/json/JSONException
    //   4390	4438	5651	org/json/JSONException
    //   4442	4464	5651	org/json/JSONException
    //   4464	4500	5651	org/json/JSONException
    //   4500	4519	5651	org/json/JSONException
    //   4524	4566	5651	org/json/JSONException
    //   4570	4578	5651	org/json/JSONException
    //   4578	4622	5651	org/json/JSONException
    //   4637	4657	5651	org/json/JSONException
    //   4657	4678	5651	org/json/JSONException
    //   4681	4687	5651	org/json/JSONException
    //   4687	4823	5651	org/json/JSONException
    //   4823	4875	5651	org/json/JSONException
    //   4875	4911	5651	org/json/JSONException
    //   4918	4935	5651	org/json/JSONException
    //   4941	4990	5651	org/json/JSONException
    //   4994	4998	5651	org/json/JSONException
    //   4998	5020	5651	org/json/JSONException
    //   5020	5025	5651	org/json/JSONException
    //   5025	5044	5651	org/json/JSONException
    //   5053	5059	5651	org/json/JSONException
    //   5068	5102	5651	org/json/JSONException
    //   5102	5126	5651	org/json/JSONException
    //   5126	5144	5651	org/json/JSONException
    //   5144	5163	5651	org/json/JSONException
    //   5169	5173	5651	org/json/JSONException
    //   5173	5194	5651	org/json/JSONException
    //   5194	5226	5651	org/json/JSONException
    //   5226	5255	5651	org/json/JSONException
    //   5255	5274	5651	org/json/JSONException
    //   5279	5303	5651	org/json/JSONException
    //   5303	5311	5651	org/json/JSONException
    //   5311	5330	5651	org/json/JSONException
    //   5339	5358	5651	org/json/JSONException
    //   5358	5362	5651	org/json/JSONException
    //   5362	5381	5651	org/json/JSONException
    //   5391	5395	5651	org/json/JSONException
    //   5395	5420	5651	org/json/JSONException
    //   5420	5448	5651	org/json/JSONException
    //   5453	5474	5651	org/json/JSONException
    //   5485	5490	5651	org/json/JSONException
    //   5490	5510	5651	org/json/JSONException
    //   5514	5520	5651	org/json/JSONException
    //   5520	5540	5651	org/json/JSONException
    //   5544	5565	5651	org/json/JSONException
    //   5565	5575	5651	org/json/JSONException
    //   5579	5612	5651	org/json/JSONException
    //   5612	5648	5651	org/json/JSONException
    //   5687	5699	5651	org/json/JSONException
    //   5738	5751	5651	org/json/JSONException
    //   5754	5764	5651	org/json/JSONException
    //   5769	5775	5651	org/json/JSONException
    //   5778	5795	5651	org/json/JSONException
    //   5795	5803	5651	org/json/JSONException
    //   5806	5851	5651	org/json/JSONException
    //   5854	5860	5651	org/json/JSONException
    //   5865	5887	5651	org/json/JSONException
    //   5894	5958	5651	org/json/JSONException
    //   5958	5965	5651	org/json/JSONException
    //   5969	5979	5651	org/json/JSONException
    //   5979	6007	5651	org/json/JSONException
    //   6007	6058	5651	org/json/JSONException
    //   6061	6069	5651	org/json/JSONException
    //   6072	6102	5651	org/json/JSONException
    //   6105	6134	5651	org/json/JSONException
    //   6148	6160	5651	org/json/JSONException
    //   6163	6175	5651	org/json/JSONException
    //   6184	6203	5651	org/json/JSONException
    //   6211	6216	5651	org/json/JSONException
    //   6219	6241	5651	org/json/JSONException
    //   6241	6274	5651	org/json/JSONException
    //   4345	4374	5702	java/lang/Exception
    //   4376	4384	5702	java/lang/Exception
    //   4390	4438	5702	java/lang/Exception
    //   4442	4464	5702	java/lang/Exception
    //   4464	4500	5702	java/lang/Exception
    //   4500	4519	5702	java/lang/Exception
    //   4524	4566	5702	java/lang/Exception
    //   4570	4578	5702	java/lang/Exception
    //   4578	4622	5702	java/lang/Exception
    //   4637	4657	5702	java/lang/Exception
    //   4657	4678	5702	java/lang/Exception
    //   4681	4687	5702	java/lang/Exception
    //   4687	4823	5702	java/lang/Exception
    //   4823	4875	5702	java/lang/Exception
    //   4875	4911	5702	java/lang/Exception
    //   4918	4935	5702	java/lang/Exception
    //   4941	4990	5702	java/lang/Exception
    //   4994	4998	5702	java/lang/Exception
    //   4998	5020	5702	java/lang/Exception
    //   5020	5025	5702	java/lang/Exception
    //   5025	5044	5702	java/lang/Exception
    //   5053	5059	5702	java/lang/Exception
    //   5068	5102	5702	java/lang/Exception
    //   5102	5126	5702	java/lang/Exception
    //   5126	5144	5702	java/lang/Exception
    //   5144	5163	5702	java/lang/Exception
    //   5169	5173	5702	java/lang/Exception
    //   5173	5194	5702	java/lang/Exception
    //   5194	5226	5702	java/lang/Exception
    //   5226	5255	5702	java/lang/Exception
    //   5255	5274	5702	java/lang/Exception
    //   5279	5303	5702	java/lang/Exception
    //   5303	5311	5702	java/lang/Exception
    //   5311	5330	5702	java/lang/Exception
    //   5339	5358	5702	java/lang/Exception
    //   5358	5362	5702	java/lang/Exception
    //   5362	5381	5702	java/lang/Exception
    //   5391	5395	5702	java/lang/Exception
    //   5395	5420	5702	java/lang/Exception
    //   5420	5448	5702	java/lang/Exception
    //   5453	5474	5702	java/lang/Exception
    //   5485	5490	5702	java/lang/Exception
    //   5490	5510	5702	java/lang/Exception
    //   5514	5520	5702	java/lang/Exception
    //   5520	5540	5702	java/lang/Exception
    //   5544	5565	5702	java/lang/Exception
    //   5565	5575	5702	java/lang/Exception
    //   5579	5612	5702	java/lang/Exception
    //   5612	5648	5702	java/lang/Exception
    //   5687	5699	5702	java/lang/Exception
    //   5738	5751	5702	java/lang/Exception
    //   5754	5764	5702	java/lang/Exception
    //   5769	5775	5702	java/lang/Exception
    //   5778	5795	5702	java/lang/Exception
    //   5795	5803	5702	java/lang/Exception
    //   5806	5851	5702	java/lang/Exception
    //   5854	5860	5702	java/lang/Exception
    //   5865	5887	5702	java/lang/Exception
    //   5894	5958	5702	java/lang/Exception
    //   5958	5965	5702	java/lang/Exception
    //   5969	5979	5702	java/lang/Exception
    //   5979	6007	5702	java/lang/Exception
    //   6007	6058	5702	java/lang/Exception
    //   6061	6069	5702	java/lang/Exception
    //   6072	6102	5702	java/lang/Exception
    //   6105	6134	5702	java/lang/Exception
    //   6148	6160	5702	java/lang/Exception
    //   6163	6175	5702	java/lang/Exception
    //   6184	6203	5702	java/lang/Exception
    //   6211	6216	5702	java/lang/Exception
    //   6219	6241	5702	java/lang/Exception
    //   6241	6274	5702	java/lang/Exception
    //   6295	6320	6733	org/json/JSONException
    //   6322	6355	6733	org/json/JSONException
    //   6355	6376	6733	org/json/JSONException
    //   6376	6411	6733	org/json/JSONException
    //   6421	6462	6733	org/json/JSONException
    //   6462	6486	6733	org/json/JSONException
    //   6486	6510	6733	org/json/JSONException
    //   6510	6538	6733	org/json/JSONException
    //   6538	6550	6733	org/json/JSONException
    //   6559	6594	6733	org/json/JSONException
    //   6604	6641	6733	org/json/JSONException
    //   6644	6652	6733	org/json/JSONException
    //   6656	6661	6733	org/json/JSONException
    //   6665	6673	6733	org/json/JSONException
    //   6677	6689	6733	org/json/JSONException
    //   6693	6710	6733	org/json/JSONException
    //   6714	6730	6733	org/json/JSONException
    //   6787	6812	6917	org/json/JSONException
    //   6814	6857	6917	org/json/JSONException
    //   6857	6865	6917	org/json/JSONException
    //   6869	6874	6917	org/json/JSONException
    //   6878	6886	6917	org/json/JSONException
    //   6890	6902	6917	org/json/JSONException
    //   6906	6914	6917	org/json/JSONException
    //   6971	6996	7151	org/json/JSONException
    //   6998	7027	7151	org/json/JSONException
    //   7027	7048	7151	org/json/JSONException
    //   7048	7069	7151	org/json/JSONException
    //   7069	7094	7151	org/json/JSONException
    //   7094	7102	7151	org/json/JSONException
    //   7106	7111	7151	org/json/JSONException
    //   7115	7123	7151	org/json/JSONException
    //   7127	7139	7151	org/json/JSONException
    //   7143	7148	7151	org/json/JSONException
    //   7205	7231	7269	org/json/JSONException
    //   7231	7246	7269	org/json/JSONException
    //   7250	7266	7269	org/json/JSONException
    //   7323	7416	7472	org/json/JSONException
    //   7416	7469	7472	org/json/JSONException
    //   7526	7589	7738	org/json/JSONException
    //   7593	7600	7738	org/json/JSONException
    //   7600	7615	7738	org/json/JSONException
    //   7617	7658	7738	org/json/JSONException
    //   7660	7668	7738	org/json/JSONException
    //   7672	7735	7738	org/json/JSONException
    //   7792	7858	7992	org/json/JSONException
    //   7862	7869	7992	org/json/JSONException
    //   7869	7884	7992	org/json/JSONException
    //   7886	7894	7992	org/json/JSONException
    //   7903	7972	7992	org/json/JSONException
    //   7972	7989	7992	org/json/JSONException
    //   8028	8048	7992	org/json/JSONException
    //   8069	8114	8149	org/json/JSONException
    //   8120	8127	8149	org/json/JSONException
    //   8129	8146	8149	org/json/JSONException
    //   8216	8222	8507	org/json/JSONException
    //   8227	8256	8507	org/json/JSONException
    //   8261	8274	8507	org/json/JSONException
    //   8279	8289	8507	org/json/JSONException
    //   8294	8304	8507	org/json/JSONException
    //   8309	8318	8507	org/json/JSONException
    //   8326	8334	8507	org/json/JSONException
    //   8338	8347	8507	org/json/JSONException
    //   8356	8364	8507	org/json/JSONException
    //   8368	8379	8507	org/json/JSONException
    //   8383	8399	8507	org/json/JSONException
    //   8455	8466	8507	org/json/JSONException
    //   8470	8479	8507	org/json/JSONException
    //   8483	8493	8507	org/json/JSONException
    //   8497	8504	8507	org/json/JSONException
    //   8572	8581	8507	org/json/JSONException
    //   8216	8222	8588	finally
    //   8227	8256	8588	finally
    //   8261	8274	8588	finally
    //   8279	8289	8588	finally
    //   8294	8304	8588	finally
    //   8309	8318	8588	finally
    //   8326	8334	8588	finally
    //   8338	8347	8588	finally
    //   8356	8364	8588	finally
    //   8368	8379	8588	finally
    //   8383	8399	8588	finally
    //   8455	8466	8588	finally
    //   8470	8479	8588	finally
    //   8483	8493	8588	finally
    //   8497	8504	8588	finally
    //   8510	8520	8588	finally
    //   8572	8581	8588	finally
    //   8654	8685	8765	org/json/JSONException
    //   8688	8719	8765	org/json/JSONException
    //   8719	8729	8765	org/json/JSONException
    //   8732	8741	8765	org/json/JSONException
    //   8746	8756	8765	org/json/JSONException
    //   8756	8762	8765	org/json/JSONException
    //   8801	8805	8765	org/json/JSONException
    //   8808	8853	8765	org/json/JSONException
    //   8866	8881	8765	org/json/JSONException
    //   8881	8893	8765	org/json/JSONException
    //   8893	8907	8765	org/json/JSONException
    //   8910	8925	8765	org/json/JSONException
    //   8946	9053	9056	org/json/JSONException
    //   8946	9053	9092	java/lang/Exception
    //   9167	9179	9352	java/lang/Exception
    //   9181	9189	9352	java/lang/Exception
    //   9191	9203	9352	java/lang/Exception
    //   9205	9214	9352	java/lang/Exception
    //   9216	9225	9352	java/lang/Exception
    //   9230	9240	9352	java/lang/Exception
    //   9242	9251	9352	java/lang/Exception
    //   9253	9261	9352	java/lang/Exception
    //   9263	9272	9352	java/lang/Exception
    //   9279	9288	9352	java/lang/Exception
    //   9290	9299	9352	java/lang/Exception
    //   9301	9311	9352	java/lang/Exception
    //   9313	9322	9352	java/lang/Exception
    //   9324	9340	9352	java/lang/Exception
    //   9342	9349	9352	java/lang/Exception
    //   9428	9441	9778	java/lang/Exception
    //   9443	9452	9778	java/lang/Exception
    //   9454	9466	9778	java/lang/Exception
    //   9468	9478	9778	java/lang/Exception
    //   9480	9490	9778	java/lang/Exception
    //   9495	9503	9778	java/lang/Exception
    //   9511	9521	9778	java/lang/Exception
    //   9523	9533	9778	java/lang/Exception
    //   9535	9545	9778	java/lang/Exception
    //   9547	9553	9778	java/lang/Exception
    //   9555	9585	9778	java/lang/Exception
    //   9587	9594	9778	java/lang/Exception
    //   9596	9605	9778	java/lang/Exception
    //   9607	9617	9778	java/lang/Exception
    //   9619	9628	9778	java/lang/Exception
    //   9630	9640	9778	java/lang/Exception
    //   9642	9653	9778	java/lang/Exception
    //   9655	9665	9778	java/lang/Exception
    //   9667	9675	9778	java/lang/Exception
    //   9677	9687	9778	java/lang/Exception
    //   9689	9697	9778	java/lang/Exception
    //   9699	9709	9778	java/lang/Exception
    //   9711	9728	9778	java/lang/Exception
    //   9730	9737	9778	java/lang/Exception
    //   9812	9824	9915	java/lang/Exception
    //   9826	9834	9915	java/lang/Exception
    //   9836	9846	9915	java/lang/Exception
    //   9848	9857	9915	java/lang/Exception
    //   9859	9874	9915	java/lang/Exception
    //   9880	9887	9915	java/lang/Exception
    //   9889	9894	9915	java/lang/Exception
    //   9904	9912	9915	java/lang/Exception
    //   9960	9969	9915	java/lang/Exception
    //   9983	9992	9915	java/lang/Exception
    //   10016	10028	10119	java/lang/Exception
    //   10030	10038	10119	java/lang/Exception
    //   10040	10050	10119	java/lang/Exception
    //   10052	10061	10119	java/lang/Exception
    //   10063	10078	10119	java/lang/Exception
    //   10084	10091	10119	java/lang/Exception
    //   10093	10098	10119	java/lang/Exception
    //   10108	10116	10119	java/lang/Exception
    //   10164	10173	10119	java/lang/Exception
    //   10187	10196	10119	java/lang/Exception
    //   10216	10245	10248	org/json/JSONException
    //   10298	10348	10410	org/json/JSONException
    //   10351	10373	10410	org/json/JSONException
    //   10382	10407	10410	org/json/JSONException
    //   10564	10597	10629	java/lang/Exception
    //   10517	10554	10648	java/lang/Exception
    //   10630	10640	10648	java/lang/Exception
    //   10760	10773	10999	java/lang/Exception
    //   10778	10787	10999	java/lang/Exception
    //   10792	10801	10999	java/lang/Exception
    //   10806	10816	10999	java/lang/Exception
    //   10821	10830	10999	java/lang/Exception
    //   10835	10846	10999	java/lang/Exception
    //   10856	10866	10999	java/lang/Exception
    //   10871	10881	10999	java/lang/Exception
    //   10886	10895	10999	java/lang/Exception
    //   10900	10908	10999	java/lang/Exception
    //   10913	10921	10999	java/lang/Exception
    //   10926	10941	10999	java/lang/Exception
    //   10977	10991	10999	java/lang/Exception
    //   11069	11125	11275	org/json/JSONException
    //   11128	11132	11275	org/json/JSONException
    //   11139	11150	11275	org/json/JSONException
    //   11156	11182	11275	org/json/JSONException
    //   11185	11216	11275	org/json/JSONException
    //   11216	11242	11275	org/json/JSONException
    //   11242	11272	11275	org/json/JSONException
    //   11315	11337	11275	org/json/JSONException
    //   11357	11372	11375	org/json/JSONException
    //   11449	11470	11473	org/json/JSONException
    //   11523	11540	11554	org/json/JSONException
    //   11544	11551	11554	org/json/JSONException
    //   11523	11540	11593	java/lang/Exception
    //   11544	11551	11593	java/lang/Exception
    //   11649	11683	11801	java/lang/Exception
    //   11685	11719	11801	java/lang/Exception
    //   11723	11745	11801	java/lang/Exception
    //   11745	11798	11801	java/lang/Exception
    //   11845	11897	11917	java/lang/Exception
    //   11897	11914	11917	java/lang/Exception
    //   11938	11990	12241	org/json/JSONException
    //   11993	12001	12241	org/json/JSONException
    //   12005	12012	12241	org/json/JSONException
    //   12012	12028	12241	org/json/JSONException
    //   12031	12051	12241	org/json/JSONException
    //   12057	12238	12241	org/json/JSONException
    //   12285	12306	12241	org/json/JSONException
    //   12306	12327	12241	org/json/JSONException
    //   11938	11990	12330	java/lang/Exception
    //   11993	12001	12330	java/lang/Exception
    //   12005	12012	12330	java/lang/Exception
    //   12012	12028	12330	java/lang/Exception
    //   12031	12051	12330	java/lang/Exception
    //   12057	12238	12330	java/lang/Exception
    //   12285	12306	12330	java/lang/Exception
    //   12306	12327	12330	java/lang/Exception
    //   12423	12473	12754	org/json/JSONException
    //   12473	12516	12754	org/json/JSONException
    //   12519	12528	12754	org/json/JSONException
    //   12533	12541	12754	org/json/JSONException
    //   12541	12557	12754	org/json/JSONException
    //   12560	12751	12754	org/json/JSONException
    //   12423	12473	12793	java/lang/Exception
    //   12473	12516	12793	java/lang/Exception
    //   12519	12528	12793	java/lang/Exception
    //   12533	12541	12793	java/lang/Exception
    //   12541	12557	12793	java/lang/Exception
    //   12560	12751	12793	java/lang/Exception
    //   12843	12869	12926	org/json/JSONException
    //   12873	12923	12926	org/json/JSONException
    //   12843	12869	12983	java/lang/Exception
    //   12873	12923	12983	java/lang/Exception
    //   13062	13089	13147	org/json/JSONException
    //   13091	13109	13147	org/json/JSONException
    //   13109	13117	13147	org/json/JSONException
    //   13121	13144	13147	org/json/JSONException
    //   13201	13220	13309	org/json/JSONException
    //   13220	13230	13309	org/json/JSONException
    //   13230	13240	13309	org/json/JSONException
    //   13240	13248	13309	org/json/JSONException
    //   13252	13270	13309	org/json/JSONException
    //   13280	13290	13309	org/json/JSONException
    //   13296	13306	13309	org/json/JSONException
    //   13346	13372	13309	org/json/JSONException
    //   13382	13408	13309	org/json/JSONException
    //   13416	13426	13309	org/json/JSONException
    //   13434	13444	13309	org/json/JSONException
    //   13220	13230	13345	java/lang/Exception
    //   13230	13240	13378	java/lang/Exception
    //   13465	13505	13559	org/json/JSONException
    //   13509	13556	13559	org/json/JSONException
    //   13595	13620	13559	org/json/JSONException
    //   13648	13688	13691	org/json/JSONException
    //   13744	13787	13812	org/json/JSONException
    //   13795	13809	13812	org/json/JSONException
    //   13866	13893	13916	org/json/JSONException
    //   13897	13913	13916	org/json/JSONException
    //   13970	13994	14131	org/json/JSONException
    //   13997	14036	14131	org/json/JSONException
    //   14039	14094	14131	org/json/JSONException
    //   14099	14128	14131	org/json/JSONException
    //   14184	14225	14131	org/json/JSONException
    //   14245	14272	14288	org/json/JSONException
    //   14281	14285	14288	org/json/JSONException
    //   14302	14311	14288	org/json/JSONException
    //   14315	14352	14288	org/json/JSONException
    //   14358	14372	14288	org/json/JSONException
    //   14381	14395	14288	org/json/JSONException
    //   14479	14564	14567	java/lang/Exception
    //   14581	14599	14567	java/lang/Exception
    //   14604	14615	14567	java/lang/Exception
    //   14615	14636	14567	java/lang/Exception
    //   14639	14650	14567	java/lang/Exception
    //   14664	14705	14708	java/lang/Exception
    //   14744	14823	14826	java/lang/Exception
    //   14851	14930	14983	java/lang/Exception
    //   14930	14980	14983	java/lang/Exception
    //   14997	15031	14983	java/lang/Exception
    //   15034	15066	14983	java/lang/Exception
    //   15080	15153	15156	java/lang/Exception
    //   15181	15210	15292	java/lang/Exception
    //   15214	15289	15292	java/lang/Exception
    //   15317	15329	15335	java/lang/Exception
    //   15381	15478	15481	java/lang/Exception
    //   15506	15590	15593	java/lang/Exception
    //   15607	15612	15593	java/lang/Exception
    //   15615	15635	15593	java/lang/Exception
    //   15638	15650	15593	java/lang/Exception
    //   15653	15678	15593	java/lang/Exception
    //   15772	15853	15856	org/json/JSONException
    //   15875	15909	15960	java/lang/Exception
    //   15915	15957	15960	java/lang/Exception
    //   15985	16028	16084	org/json/JSONException
    //   16028	16052	16084	org/json/JSONException
    //   16055	16081	16084	org/json/JSONException
    //   16098	16110	16084	org/json/JSONException
    //   16130	16256	16279	org/json/JSONException
    //   16256	16276	16279	org/json/JSONException
    //   16304	16413	16426	org/json/JSONException
    //   16413	16423	16426	org/json/JSONException
    //   16451	16560	16573	org/json/JSONException
    //   16560	16570	16573	org/json/JSONException
    //   16598	16644	16647	org/json/JSONException
    //   16661	16813	16647	org/json/JSONException
    //   16813	16844	16647	org/json/JSONException
    //   16858	16956	17006	java/lang/Exception
    //   16962	16968	17006	java/lang/Exception
    //   16968	17003	17006	java/lang/Exception
    //   17021	17030	17006	java/lang/Exception
    //   17033	17048	17006	java/lang/Exception
    //   17051	17082	17006	java/lang/Exception
    //   17085	17103	17006	java/lang/Exception
    //   17117	17146	17149	org/json/JSONException
    //   17193	17233	17236	org/json/JSONException
    //   17349	17390	17393	org/json/JSONException
    //   17302	17314	17405	org/json/JSONException
    //   17316	17324	17405	org/json/JSONException
    //   17326	17339	17405	org/json/JSONException
    //   10491	10511	17443	java/lang/Exception
    //   3547	3556	17447	org/json/JSONException
    //   3561	3574	17447	org/json/JSONException
    //   1007	1040	17492	java/lang/Throwable
    //   1043	1076	17492	java/lang/Throwable
    //   1079	1108	17492	java/lang/Throwable
    //   1111	1119	17492	java/lang/Throwable
    //   1719	1760	17506	org/json/JSONException
    //   1762	1835	17506	org/json/JSONException
    //   1837	1848	17506	org/json/JSONException
    //   1851	1880	17506	org/json/JSONException
  }
  
  public void onActivityReady()
  {
    if ((jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (QbSdk.getTbsVersion(this.mRuntime.a()) >= 44001)) {
      h();
    }
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    try
    {
      e();
      if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        this.jdField_b_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
        jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "put current UiApiPlugin into sUiApiPluginReferences: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "error:" + localException.toString());
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 13) {
      if (paramIntent != null) {}
    }
    Object localObject4;
    Object localObject3;
    label565:
    Object localObject2;
    int n;
    boolean bool1;
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
                do
                {
                  do
                  {
                    do
                    {
                      Object localObject1;
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localObject1 = paramIntent.getStringExtra("result");
                              callJs(paramIntent.getStringExtra("callback"), new String[] { localObject1 });
                              return;
                              if (paramByte != 3) {
                                break;
                              }
                            } while (paramIntent == null);
                            localObject1 = paramIntent.getStringExtra("scanResult");
                            if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                              break;
                            }
                            localObject4 = paramIntent.getStringExtra("callback_url");
                            localObject3 = paramIntent.getStringExtra("name");
                          } while ((TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject3)));
                          localObject4 = ((String)localObject4).split("#");
                          localStringBuilder = new StringBuilder(localObject4[0]);
                          if (localObject4[0].contains("?")) {}
                          for (paramIntent = "&";; paramIntent = "?")
                          {
                            paramIntent = localStringBuilder.append(paramIntent).append((String)localObject3).append("=").append(URLEncoder.encode((String)localObject1));
                            if (localObject4.length > 1) {
                              paramIntent.append("#").append(localObject4[1]);
                            }
                            if (this.mRuntime.a() == null) {
                              break;
                            }
                            this.mRuntime.a().loadUrl(paramIntent.toString());
                            return;
                          }
                          localObject3 = this.jdField_c_of_type_JavaLangString;
                          if (localObject1 == null) {}
                          for (paramIntent = "''";; paramIntent = nwo.a((String)localObject1))
                          {
                            callJs((String)localObject3, new String[] { paramIntent });
                            return;
                          }
                          if (paramByte != 17) {
                            break;
                          }
                        } while (paramIntent == null);
                        paramInt = paramIntent.getIntExtra("ret_code", -1);
                        localObject3 = paramIntent.getStringExtra("ocr_result");
                        localObject4 = new JSONObject();
                        try
                        {
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            paramInt = -1;
                          }
                          ((JSONObject)localObject4).put("retCode", paramInt);
                          localObject1 = localObject3;
                          if (TextUtils.isEmpty((CharSequence)localObject3)) {
                            localObject1 = "";
                          }
                          ((JSONObject)localObject4).put("result", localObject1);
                        }
                        catch (JSONException localJSONException1)
                        {
                          for (;;)
                          {
                            localJSONException1.printStackTrace();
                            continue;
                            paramIntent = "?";
                          }
                          callJs(this.jdField_d_of_type_JavaLangString, new String[] { ((JSONObject)localObject4).toString() });
                          return;
                        }
                        if (QLog.isColorLevel()) {
                          QLog.i("UiApiPlugin", 2, "scanForOCR CODE_OCRCODE result: " + ((JSONObject)localObject4).toString());
                        }
                        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
                          break label565;
                        }
                        localObject3 = paramIntent.getStringExtra("callback_url");
                        localObject1 = paramIntent.getStringExtra("name");
                      } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)));
                      localObject3 = ((String)localObject3).split("#");
                      StringBuilder localStringBuilder = new StringBuilder(localObject3[0]);
                      if (!localObject3[0].contains("?")) {
                        break;
                      }
                      paramIntent = "&";
                      paramIntent = localStringBuilder.append(paramIntent).append((String)localObject1).append("=").append(URLEncoder.encode(((JSONObject)localObject4).toString()));
                      if (localObject3.length > 1) {
                        paramIntent.append("#").append(localObject3[1]);
                      }
                    } while (this.mRuntime.a() == null);
                    this.mRuntime.a().loadUrl(paramIntent.toString());
                    return;
                    if (paramByte != 4) {
                      break;
                    }
                  } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
                  if (paramInt == -1)
                  {
                    if (paramIntent == null) {}
                    for (paramIntent = "";; paramIntent = paramIntent.getStringExtra("result"))
                    {
                      paramIntent = "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramIntent + "}}";
                      callJs(this.jdField_f_of_type_JavaLangString, new String[] { paramIntent });
                      return;
                    }
                  }
                  callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
                  return;
                  if (paramByte != 5) {
                    break;
                  }
                } while (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString));
                if (paramInt == -1)
                {
                  paramInt = paramIntent.getIntExtra("ret", 4);
                  if (QLog.isColorLevel()) {
                    QLog.d("UiApiPlugin", 2, "select contact ret:" + paramInt);
                  }
                  localObject2 = new JSONObject();
                  for (;;)
                  {
                    try
                    {
                      ((JSONObject)localObject2).put("ret", paramInt);
                      if (paramInt == 0)
                      {
                        localObject3 = paramIntent.getStringArrayExtra("openids");
                        paramIntent = paramIntent.getIntArrayExtra("types");
                        if ((localObject3 != null) && (paramIntent != null) && (localObject3.length == paramIntent.length))
                        {
                          n = localObject3.length;
                          localObject4 = new JSONArray();
                          paramInt = 0;
                          if (paramInt < n)
                          {
                            ((JSONArray)localObject4).put(new JSONObject().put("type", paramIntent[paramInt]).put("openID", localObject3[paramInt]));
                            paramInt += 1;
                            continue;
                          }
                          ((JSONObject)localObject2).put("contacts", localObject4);
                        }
                        callJs(this.jdField_g_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                        return;
                      }
                    }
                    catch (JSONException paramIntent)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
                      }
                      callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":4}" });
                      return;
                    }
                    ((JSONObject)localObject2).put("errMsg", paramIntent.getStringExtra("errMsg"));
                  }
                }
                callJs(this.jdField_g_of_type_JavaLangString, new String[] { "{\"ret\":3}" });
                return;
                if (paramByte != 7) {
                  break;
                }
              } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
              if (paramInt == -1)
              {
                paramInt = paramIntent.getIntExtra("ret", 0);
                if (QLog.isColorLevel()) {
                  QLog.d("UiApiPlugin", 2, "select Member ret:" + paramInt);
                }
                localObject2 = new JSONObject();
                for (;;)
                {
                  try
                  {
                    ((JSONObject)localObject2).put("ret", paramInt);
                    if (paramInt == 0)
                    {
                      ((JSONObject)localObject2).put("selectMore", this.jdField_b_of_type_Boolean);
                      ((JSONObject)localObject2).put("uin", this.k);
                      ((JSONObject)localObject2).put("uinType", "0");
                      localObject3 = new JSONArray();
                      if (this.jdField_b_of_type_Boolean)
                      {
                        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
                        paramInt = 0;
                        if (paramInt < paramIntent.size())
                        {
                          localObject4 = (ResultRecord)paramIntent.get(paramInt);
                          ((JSONArray)localObject3).put(new JSONObject().put("memUin", ((ResultRecord)localObject4).uin).put("nick", ((ResultRecord)localObject4).name));
                          paramInt += 1;
                          continue;
                        }
                      }
                      else
                      {
                        localObject4 = paramIntent.getStringExtra("member_uin");
                        paramIntent = paramIntent.getStringExtra("member_display_name");
                        ((JSONArray)localObject3).put(new JSONObject().put("memUin", localObject4).put("nick", paramIntent));
                      }
                      ((JSONObject)localObject2).put("selectUins", localObject3);
                      callJs(this.jdField_f_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
                      return;
                    }
                  }
                  catch (JSONException paramIntent)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("UiApiPlugin", 2, "select contact result json exception", paramIntent);
                    }
                    callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":3,\"errMsg\":\"Json Parse Error\"}" });
                    return;
                  }
                  ((JSONObject)localObject2).put("errMsg", paramIntent.getStringExtra("errMsg"));
                }
              }
              callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{\"ret\":1,\"errMsg\":\"User cancle\"}" });
              return;
              if (paramByte != 6) {
                break;
              }
            } while (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString));
            if (paramInt == -1)
            {
              callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : 0}" });
              return;
            }
            paramInt = paramIntent.getIntExtra("retCode", -1);
            callJs(this.jdField_f_of_type_JavaLangString, new String[] { "{'retcode' : " + paramInt + "}" });
            return;
            if ((paramByte != 8) && (paramByte != 9)) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          bool1 = paramIntent.getBooleanExtra("key_troop_fee_notify_js_data_changed", false);
          paramIntent = paramIntent.getStringExtra("callback");
        } while (!bool1);
        callJs(paramIntent, new String[] { "{}" });
        return;
        if (paramByte != 10) {
          break;
        }
      } while ((paramInt != -1) && (paramIntent == null));
      bglb.a(this.mRuntime.a(), paramIntent, null);
      a(paramIntent.getStringExtra("troop_uin"), "send_page");
      return;
      if (paramByte != 11) {
        break label1904;
      }
      localObject2 = null;
      bool1 = false;
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringExtra("callback");
        bool1 = paramIntent.getBooleanExtra("isOpenApi", false);
      }
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject2 = this.l;
      boolean bool2 = this.jdField_c_of_type_Boolean;
      bool1 = bool2;
      localObject3 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      bool1 = bool2;
      localObject3 = localObject2;
      if (bool2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("UiApiPlugin", 2, "groupOrganizationView no callback");
    return;
    this.l = null;
    this.jdField_c_of_type_Boolean = false;
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("UiApiPlugin", 2, "groupOrganization result intent=null");
      }
      if (bool1)
      {
        callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
        return;
      }
      callJs((String)localObject3, new String[] { "{ret:4}" });
      return;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        n = paramIntent.getIntExtra("ret", 5);
        ((JSONObject)localObject2).put("ret", n);
        localObject4 = paramIntent.getStringExtra("errMsg");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((JSONObject)localObject2).put("errMsg", localObject4);
        }
        if (n != 0) {
          break label2310;
        }
        paramIntent = paramIntent.getStringArrayExtra("result");
        localObject4 = new JSONArray();
        int i1 = paramIntent.length;
        paramInt = 0;
        if (paramInt < i1)
        {
          ((JSONArray)localObject4).put(paramIntent[paramInt]);
          paramInt += 1;
          continue;
        }
        ((JSONObject)localObject2).put("openIDArr", localObject4);
      }
      catch (JSONException paramIntent)
      {
        label1813:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("UiApiPlugin", 2, "groupOrganization error", paramIntent);
        if (!bool1) {
          break label1887;
        }
      }
      callJs4OpenApiIfNeeded("groupOrganizationView", paramInt, ((JSONObject)localObject2).toString());
      return;
      callJs4OpenApiIfNeeded("groupOrganizationView", -100, "{ret:4}");
      return;
      label1887:
      label1904:
      do
      {
        paramInt = -100;
        break label1813;
        do
        {
          callJs((String)localObject3, new String[] { ((JSONObject)localObject2).toString() });
          return;
          callJs((String)localObject3, new String[] { "{ret:4}" });
          return;
          if (paramByte == 12)
          {
            paramInt = paramIntent.getIntExtra("cGroupOption", -1);
            localObject2 = paramIntent.getStringExtra("troop_uin");
            if (paramIntent.getBooleanExtra("isSetFee", false)) {
              paramInt = 4;
            }
            for (;;)
            {
              paramIntent = new JSONObject();
              try
              {
                paramIntent.put("gc", localObject2);
                paramIntent.put("ret", 0);
                paramIntent.put("joinType", paramInt);
                callJs(this.m, new String[] { paramIntent.toString() });
                return;
                switch (paramInt)
                {
                default: 
                  paramInt = -1;
                  break;
                case 1: 
                  paramInt = 0;
                  break;
                case 2: 
                  paramInt = 1;
                  break;
                case 3: 
                  paramInt = 5;
                  break;
                case 4: 
                  paramInt = 3;
                  break;
                case 5: 
                  paramInt = 2;
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                }
              }
            }
          }
          if (paramByte == 15)
          {
            if (TextUtils.isEmpty(this.i)) {
              break;
            }
            str = this.i;
            localObject3 = new StringBuilder().append("{'result' : ");
            if (paramInt == -1) {}
            for (paramIntent = "true";; paramIntent = "false")
            {
              callJs(str, new String[] { paramIntent + "}" });
              return;
            }
          }
          if (paramByte == 16)
          {
            if (TextUtils.isEmpty(this.j)) {
              break;
            }
            str = this.j;
            localObject3 = new StringBuilder().append("{'result' : ");
            if (paramInt == -1) {}
            for (paramIntent = "true";; paramIntent = "false")
            {
              callJs(str, new String[] { paramIntent + "}" });
              return;
            }
          }
          if ((paramByte != 117) || (paramInt != 1699)) {
            break;
          }
          String str = paramIntent.getStringExtra("arg_callback");
          if (TextUtils.isEmpty(str)) {
            break;
          }
          if (this.jdField_a_of_type_Owx != null) {
            this.jdField_a_of_type_Owx.a();
          }
          this.jdField_a_of_type_Owx = new owx();
          a(paramIntent, this.jdField_a_of_type_Owx, str, new awbk(this));
          return;
        } while (!bool1);
      } while (n != 0);
      label2310:
      paramInt = 0;
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "1", Integer.toString(this.jdField_a_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_a_of_type_Int));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      Activity localActivity = this.mRuntime.a();
      if (localActivity != null) {
        localActivity.finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate()
  {
    ashz.a().a(this.jdField_a_of_type_Ascz);
  }
  
  public void onDestroy()
  {
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UiApiPlugin", 2, "remove current UiApiPlugin from sUiApiPluginReferences: " + this.jdField_a_of_type_JavaLangRefWeakReference.toString());
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    c();
    this.jdField_a_of_type_ComTencentBizUiRefreshView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Aakn = null;
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
    if (this.jdField_a_of_type_Aady != null) {
      this.jdField_a_of_type_Aady.b();
    }
    ashz.a().b(this.jdField_a_of_type_Ascz);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    if (this.jdField_a_of_type_Owx != null)
    {
      this.jdField_a_of_type_Owx.a();
      this.jdField_a_of_type_Owx = null;
    }
    super.onDestroy();
  }
  
  public void onDismiss()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "1", Integer.toString(this.jdField_a_of_type_Int) });
      return;
    }
    callJs4OpenApiIfNeeded("showActionSheet", 0, Integer.toString(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin
 * JD-Core Version:    0.7.0.1
 */