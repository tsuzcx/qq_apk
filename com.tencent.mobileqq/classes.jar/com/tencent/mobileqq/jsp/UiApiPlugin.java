package com.tencent.mobileqq.jsp;

import aach;
import aadf;
import amtj;
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
import aqyp;
import ardu;
import atky;
import auve;
import auvj;
import auvk;
import auvl;
import auvm;
import auvn;
import auvp;
import auvq;
import auvr;
import auvs;
import auvt;
import auvu;
import auvv;
import auvw;
import auvx;
import auvz;
import auwa;
import auwb;
import auwc;
import auwd;
import bbgk;
import bcef;
import bcvs;
import bfcv;
import bfuc;
import bfur;
import bfvh;
import bfvo;
import bfyg;
import bfyz;
import bgbt;
import bgbw;
import bgoe;
import bgog;
import bgoj;
import bgtw;
import bguj;
import bgve;
import bgyb;
import bgzj;
import bgzk;
import bgzm;
import bgzp;
import bgzq;
import bgzt;
import bjnw;
import bjoe;
import bjog;
import bjoi;
import bjsv;
import bjsy;
import bkfe;
import bkgu;
import bkws;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
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
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
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
import mqq.app.BaseActivity;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import nko;
import nma;
import npn;
import ooy;
import ooz;
import opd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tiu;
import xwa;
import yns;
import yyi;
import zon;
import zvb;

public class UiApiPlugin
  extends WebViewPlugin
  implements DialogInterface.OnCancelListener, View.OnClickListener, bjoe, bjog, bjoi
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
  public ProgressDialog a;
  public View a;
  public ImageView a;
  public aqyp a;
  public bjnw a;
  bjsv jdField_a_of_type_Bjsv = null;
  public RefreshView a;
  public MiniMsgUser a;
  public String a;
  WeakReference<UiApiPlugin> jdField_a_of_type_JavaLangRefWeakReference = null;
  private ooz jdField_a_of_type_Ooz;
  public zon a;
  public zvb a;
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
    this.jdField_a_of_type_Zon = null;
    this.jdField_a_of_type_Aqyp = new auve(this);
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
      return 2130843715;
    }
    return 2130850321;
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
    return new auwc(this);
  }
  
  private MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new auwd(this);
  }
  
  public static String a(aach paramaach)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramaach != null) {}
    try
    {
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("type", "init");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isShowBottomBar", paramaach.jdField_a_of_type_Boolean);
      localJSONObject.put("barHeight", paramaach.jdField_a_of_type_Int);
      ((JSONObject)localObject1).put("data", localJSONObject);
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (JSONException paramaach)
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
            break label2635;
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
          break label2578;
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
        break label581;
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
        break label2591;
      }
      PluginJumpManager.getInstance().updateConfig(paramAppInterface);
      PluginJumpManager.getInstance().loadConfig();
      if (!(paramActivity instanceof BaseActivity)) {
        break label837;
      }
    } while (PluginJumpManager.getInstance().openView(paramActivity, str2, String.valueOf(n)));
    break label2591;
    label354:
    label380:
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
        label568:
        label581:
        for (;;)
        {
          label502:
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
        label837:
        if (!PluginJumpManager.getInstance().openView(paramActivity, str2, String.valueOf(n))) {
          break label2591;
        }
        return;
        paramString.putBoolean("hide_more_button", false);
        paramString.putBoolean("hide_operation_bar", true);
        break label354;
        paramString.putBoolean("hide_more_button", true);
        paramString.putBoolean("hide_operation_bar", true);
        break label354;
        paramString.putBoolean("hide_more_button", false);
        paramString.putBoolean("hide_operation_bar", false);
        paramString.putString("webStyle", "");
        break label354;
        paramString.putBoolean("hide_more_button", true);
        paramString.putBoolean("hide_operation_bar", false);
        paramString.putString("webStyle", "");
        break label354;
        paramString.putBoolean("hide_left_button", true);
        paramString.putBoolean("show_right_close_button", true);
        break label354;
        paramString.putBoolean("isTransparentTitleAndClickable", true);
        break label380;
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
          if (bkfe.a(str2, paramCustomWebView))
          {
            paramCustomWebView.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
            paramActivity.startActivityForResult(paramCustomWebView, 100);
          }
          else
          {
            bkfe.a(paramActivity, paramCustomWebView, 100);
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
          if (bcvs.a(str2)) {
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
            break label2573;
          }
          paramCustomWebView = ((BasePluginActivity)paramActivity).getOutActivity();
          label1661:
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
            break label2000;
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
      label2000:
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
    label2573:
    label2578:
    label2591:
    label2635:
    label2640:
    label2651:
    for (;;)
    {
      if (bcvs.a(str2))
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
      if (bkfe.a(str2, paramCustomWebView))
      {
        paramCustomWebView.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
        bkgu.a(paramActivity, paramCustomWebView, "com.qqcomic.activity.media.VipComicMediaPlayActivity", null);
        break label502;
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
            break label2651;
          }
          ((EcshopNewPageFragment)paramAppInterface).jdField_a_of_type_Boolean = true;
          break label2651;
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
      break label502;
      paramActivity.overridePendingTransition(2130772300, 0);
      return;
      paramCustomWebView = paramActivity;
      break label1661;
      break label114;
      for (;;)
      {
        if (paramString == null) {
          break label2640;
        }
        str1 = paramString;
        break;
        switch (n)
        {
        }
        break label354;
        break label380;
        return;
        paramString = null;
      }
      if (localIntent != null) {
        break label568;
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
    paramArrayOfString = new NewIntent(BaseApplicationImpl.getContext(), nma.class);
    paramArrayOfString.setWithouLogin(true);
    paramArrayOfString.putExtra("cmd", "CommCompSvr.get_openid");
    paramArrayOfString.putExtra("data", localGetOpenidReq.toByteArray());
    paramArrayOfString.setObserver(new auvm(paramActivity));
    paramAppInterface.startServlet(paramArrayOfString);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (bfyg.a(paramActivity, new String[] { paramString1 }))
    {
      QQToast.a(paramActivity, 2131691947, 0).b(paramActivity.getResources().getDimensionPixelSize(2131299076));
      paramActivity = a("-4", null, "createShortcut exsit!", paramString3);
      bcef.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
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
          QQCustomDialog localQQCustomDialog = bfur.a(paramActivity, 0);
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
            paramJSONObject = paramActivity.getString(2131690620);
            localQQCustomDialog.setNegativeButton(paramJSONObject, paramOnClickListener1);
          }
          if (bool1)
          {
            if (TextUtils.isEmpty(str1))
            {
              paramActivity = paramActivity.getString(2131694201);
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
            QQToast.a(paramContext, n, str, 0).b(paramContext.getResources().getDimensionPixelSize(2131299076));
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
  
  public static void a(Intent paramIntent, ooz paramooz, String paramString, tiu paramtiu)
  {
    if ((paramIntent == null) || (paramooz == null))
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
    paramooz.a(new auvk(paramtiu, paramString, str2, str3, (String)localObject1));
    if (!TextUtils.isEmpty(str3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramooz, n, (ArticleInfo)localObject2, i1, str3, str2, paramIntent, bool2, bool1, str4);
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
  
  private static void a(ooz paramooz, int paramInt1, ArticleInfo paramArticleInfo, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
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
      paramooz.a(paramArticleInfo, localRIJBiuAndCommentRequestData);
      return;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, Activity paramActivity)
  {
    if ((paramJSONObject == null) || (paramActivity == null))
    {
      QLog.d("UiApiPlugin", 1, "showCommentEditorNew null object");
      return;
    }
    QLog.d("UiApiPlugin", 1, "showCommentEditorNew json is :" + paramJSONObject.toString());
    String str1 = new String(bfuc.decode(paramJSONObject.optString("placeholder", ""), 0));
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    int n = paramJSONObject.optInt("maxLength", 100);
    int i1 = paramJSONObject.optInt("commentType", 1);
    int i2 = paramJSONObject.optInt("sourceType", 1);
    int i3 = paramJSONObject.optInt("openAt", 0);
    boolean bool = paramJSONObject.optBoolean("canBiu", false);
    String str2 = new String(bfuc.decode(paramJSONObject.optString("defaultTxt"), 0));
    Intent localIntent = new Intent();
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
    PublicTransFragmentActivity.b(paramActivity, localIntent, ReadInJoyCommentComponentFragment.class, 117);
  }
  
  public static void a(boolean paramBoolean, String paramString, tiu paramtiu)
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
      paramBoolean = ooy.a();
      try
      {
        localJSONObject.put("isGrayscaleUser", paramBoolean);
        QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig is " + paramBoolean);
        paramtiu.a(paramString, localJSONObject);
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
    QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_update_biu_and_comment_switch_action", new Bundle(), new auvj(localJSONObject, paramtiu, paramString));
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
        paramString2 = BitmapFactory.decodeResource(paramContext.getResources(), 2130840385);
        if (paramString2 == null) {
          break label373;
        }
        n = bfvh.a(paramContext);
        if (n == paramString2.getWidth()) {
          break label373;
        }
        if (bgbw.jdField_c_of_type_Boolean) {
          break label168;
        }
        paramString2 = bgbt.a().a(paramString2, n);
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
      bgbt.a().a(paramIntent);
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
  
  private static JSONObject b(opd paramopd, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramopd.a());
      localJSONObject.put("rspCommentId", paramopd.a());
      localJSONObject.put("replyFirstCommentId", paramString1);
      localJSONObject.put("replySubCommentId", paramString2);
      localJSONObject.put("comment", paramopd.c());
      localJSONObject.put("replyUin", paramopd.e());
      localJSONObject.put("replyNick", paramString3);
      return localJSONObject;
    }
    catch (JSONException paramopd)
    {
      QLog.e("UiApiPlugin", 1, "convertRespDataToJsonString error :" + paramopd.getMessage());
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
    jdField_c_of_type_AndroidContentBroadcastReceiver = new auwb(this);
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
      this.jdField_a_of_type_Bjnw.dismiss();
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
      n = 2130843893;
    }
    do
    {
      return n;
      if ("2".equals(paramString)) {
        return 2130843892;
      }
      if ("3".equals(paramString)) {
        return 2130840333;
      }
      if ("4".equals(paramString)) {
        return 2130839412;
      }
      if ("5".equals(paramString)) {
        return 2130843937;
      }
      if ("7".equals(paramString))
      {
        if (paramBoolean) {
          return 2130842537;
        }
        return 2130842540;
      }
      if ("8".equals(paramString))
      {
        if (paramBoolean) {
          return 2130850052;
        }
        return 2130850056;
      }
      if ("9".equals(paramString)) {
        return 2130838942;
      }
      if ("10".equals(paramString)) {
        return 2130850233;
      }
      if ("11".equals(paramString)) {
        return 2130850232;
      }
      if ("14".equals(paramString)) {
        return 2130850162;
      }
    } while (!"15".equals(paramString));
    return 2130850163;
  }
  
  public Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public bgzp a()
  {
    bguj localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzp))) {
      return (bgzp)localbguj;
    }
    return null;
  }
  
  public bgzt a()
  {
    bguj localbguj = this.mRuntime.a(this.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzt))) {
      return (bgzt)localbguj;
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
        localDrawable = bfvo.a(localDrawable, paramInt);
        if (localDrawable != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = null;
    auvp localauvp = null;
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
        localRelativeLayout = (RelativeLayout)localActivity.findViewById(2131376501);
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
          Drawable localDrawable = localActivity.getResources().getDrawable(2130844675);
          localObject = localDrawable;
          if (!TextUtils.isEmpty(paramString))
          {
            localauvp = new auvp(this, paramString);
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
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localauvp);
        this.jdField_a_of_type_AndroidWidgetImageView.invalidate();
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localActivity.getResources().getDrawable(2130850321));
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localActivity);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localauvp);
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
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131376632);
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
        bcef.b(null, "CliOper", "", "", "ep_mall", "Clk_ep_search", 0, 0, "", "", "", "");
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
    atky.a(localActivity, (Intent)localObject, 18);
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_Bjnw != null)
      {
        if (this.jdField_a_of_type_Bjnw.isShowing()) {
          this.jdField_a_of_type_Bjnw.dismiss();
        }
        if (paramString.equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Bjnw.show();
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
        localObject1 = bjnw.a((Context)localObject1);
        Object localObject2 = localJSONObject.optString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((bjnw)localObject1).a((CharSequence)localObject2);
        }
        localObject2 = localJSONObject.optJSONArray("items");
        int i3 = localJSONObject.optInt("selected", -1);
        this.jdField_a_of_type_Boolean = false;
        String str = localJSONObject.optString("close");
        if (TextUtils.isEmpty(str)) {
          break label398;
        }
        this.jdField_a_of_type_Boolean = true;
        ((bjnw)localObject1).a(str, 3);
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
                ((bjnw)localObject1).a(str, bool);
                i1 += 1;
                continue;
              }
            }
            if (i1 >= i4) {
              break label409;
            }
            ((bjnw)localObject1).c(((JSONArray)localObject2).getString(i1));
            i1 += 1;
            continue;
          }
        }
        localObject2 = localJSONObject.optString("cancel");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((bjnw)localObject1).d((CharSequence)localObject2);
        }
        ((bjnw)localObject1).a(this);
        ((bjnw)localObject1).a(this);
        ((bjnw)localObject1).setOnCancelListener(this);
        ((bjnw)localObject1).a(this);
        this.jdField_a_of_type_Bjnw = ((bjnw)localObject1);
        this.jdField_b_of_type_JavaLangString = localJSONObject.optString("onclick");
        this.jdField_a_of_type_Int = i1;
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Bjnw.show();
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
      bcef.b(null, "P_CliOper", "Grp_flower", "", "mber", paramString2, 0, 0, paramString1, n + "", "", "");
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
      a(paramJSONObject, null, new auvq(this, paramJSONObject));
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
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bgzt)))
      {
        ((bgzt)paramJSONObject).setRightButton(str2, str1, str3, bool2, n, i1, paramOnClickListener, null);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bgzj)))
      {
        ((bgzj)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
      if ((paramJSONObject != null) && ((paramJSONObject instanceof bgzk)))
      {
        ((bgzk)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener);
        return;
      }
    } while ((paramJSONObject == null) || (!(paramJSONObject instanceof bgzm)));
    ((bgzm)paramJSONObject).a(str2, str1, str3, bool2, n, i1, paramOnClickListener, this.mRuntime.a().hashCode());
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
    bbgk.a(this.mRuntime.a(), paramString, str2, (List)localObject, paramJSONObject, localRect, new auvz(this, str1));
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
    ((TextView)localObject1).setText(2131690768);
    ((TextView)localObject1).setBackgroundResource(2130850602);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setMaxWidth(DisplayUtil.dip2px((Context)localObject3, 100.0F));
    ((TextView)localObject1).setMinWidth(DisplayUtil.dip2px((Context)localObject3, 52.0F));
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setTextColor(((Context)localObject3).getResources().getColor(2131167006));
    ((TextView)localObject1).setTextSize(1, 17.0F);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px((Context)localObject3, 36.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, 2131376632);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((TextView)localObject1).setOnClickListener(this);
    Object localObject2 = (RelativeLayout)((Activity)localObject2).findViewById(2131376501);
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
      localView = ((Activity)localObject).findViewById(2131376501);
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
        ((TranslateAnimation)localObject).setAnimationListener(new auvu(this, localView, localView.getTop() - n, localView.getBottom() - n));
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
      ((TranslateAnimation)localObject).setAnimationListener(new auvv(this, localView, localView.getTop() + n, n + localView.getBottom()));
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
      this.jdField_b_of_type_AndroidViewView = localActivity.findViewById(2131363712);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Zvb = this.jdField_a_of_type_ComTencentBizUiRefreshView.jdField_a_of_type_Zvb;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Zvb.setHeaderBgColor(-16777216);
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setBackgroundColor(-16777216);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizUiRefreshView.setOnRefreshListener(new auvn(this));
        callJs4OpenApiIfNeeded("setPullDown", 0, "[]");
        return;
        this.jdField_a_of_type_Zvb.setHeaderBgColor(paramInt1);
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
        startActivityForResult(bfcv.a(this.mRuntime.a(), paramString1, "web"), (byte)10);
        a(paramString1, "exp");
        return true;
      }
      if (paramString2.equals("g_proceeding")) {
        return true;
      }
      if (paramString2.equals("g_homework"))
      {
        if (this.jdField_a_of_type_Zon == null)
        {
          this.jdField_a_of_type_Zon = zon.a();
          this.jdField_a_of_type_Zon.a();
        }
        this.jdField_a_of_type_Zon.a(paramString1, paramString2);
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
        if (this.jdField_a_of_type_Zon == null)
        {
          this.jdField_a_of_type_Zon = zon.a();
          this.jdField_a_of_type_Zon.a();
        }
        this.jdField_a_of_type_Zon.a(paramString1, paramString2);
        return true;
      }
      if (paramString2.equals("g_background"))
      {
        if (bfyz.q(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin())) {
          TroopPicEffectsEditActivity.a(this.mRuntime.a(), paramString1, paramString1);
        }
        for (;;)
        {
          return true;
          bfyz.z(this.mRuntime.a(), this.mRuntime.a().getCurrentAccountUin());
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
      paramString1 = yns.a(null, paramString3, null);
      xwa.a("story_grp", "clk_entry", 0, 0, new String[] { "", "", "", "" });
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
  
  public void ab_()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject instanceof PublicFragmentActivity))
    {
      localObject = ((PublicFragmentActivity)localObject).a();
      if ((localObject instanceof TribeVideoListPlayerFragment)) {
        ((TribeVideoListPlayerFragment)localObject).a(this.jdField_a_of_type_Bjnw);
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
    if ((localObject != null) && ((localObject instanceof bgzq)))
    {
      localObject = ((bgzq)localObject).getShare();
      Bundle localBundle = new Bundle();
      localBundle.putString("title", ((aadf)localObject).b());
      localBundle.putString("desc", ((aadf)localObject).c());
      localBundle.putString("detail_url", ((aadf)localObject).a());
      localBundle.putString("cover_url", ((aadf)localObject).e());
      localBundle.putInt("article_id", ((aadf)localObject).a());
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(((aadf)localObject).d());
      localBundle.putStringArrayList("image_url", localArrayList);
      localBundle.putString("source_name", ((aadf)localObject).f());
      if (a() != null)
      {
        if (!bkws.a(this.mRuntime.a(), a(), localBundle, null, 0)) {
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
    yyi.a(1, 2131689486);
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
      if ((localObject1 != null) && ((localObject1 instanceof bgzt))) {
        localObject1 = ((bgzt)localObject1).getTitleBarView();
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
          if ((localObject1 != null) && ((localObject1 instanceof bgzj)))
          {
            localObject1 = ((bgzj)localObject1).a();
          }
          else if ((localObject1 != null) && ((localObject1 instanceof bgzm)))
          {
            localObject1 = ((bgzm)localObject1).a(this.mRuntime.a().hashCode());
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
      if (this.jdField_a_of_type_Bjsv != null)
      {
        if (!this.jdField_a_of_type_Bjsv.isShowing()) {
          this.jdField_a_of_type_Bjsv.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298807) - localActivity.getResources().getDimensionPixelSize(2131298803), localActivity.getResources().getDimensionPixelSize(2131298804));
        }
      }
      else
      {
        Drawable localDrawable = localActivity.getResources().getDrawable(2130839547);
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
      this.jdField_a_of_type_Bjsv = bjsv.a(localActivity, localArrayList, new auvr(this, paramJSONObject, localActivity));
      this.jdField_a_of_type_Bjsv.showAsDropDown((View)localObject1, ((View)localObject1).getWidth() - localActivity.getResources().getDimensionPixelSize(2131298807) - localActivity.getResources().getDimensionPixelSize(2131298803), localActivity.getResources().getDimensionPixelSize(2131298804));
      return;
      int n = 0;
      while (n < localJSONArray.length())
      {
        Object localObject2 = localJSONArray.optJSONObject(n);
        bjsy localbjsy = new bjsy();
        localbjsy.jdField_a_of_type_Int = Integer.parseInt(((JSONObject)localObject2).optString("id"));
        localbjsy.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("itemContent");
        localbjsy.jdField_c_of_type_JavaLangString = localbjsy.jdField_a_of_type_JavaLangString;
        localbjsy.jdField_b_of_type_Int = 2130850736;
        localObject2 = ((JSONObject)localObject2).optString("itemUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)(71.0F * f1));
          localURLDrawableOptions.mRequestHeight = ((int)(94.0F * f1));
          localURLDrawableOptions.mLoadingDrawable = localException;
          localURLDrawableOptions.mFailedDrawable = localException;
          localbjsy.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        }
        localArrayList.add(localbjsy);
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
      QQToast.a(this.mRuntime.a().getApplication(), 1, amtj.a(2131714864), 0).a();
      return;
    }
    if (this.jdField_b_of_type_AndroidAppProgressDialog == null)
    {
      this.jdField_b_of_type_AndroidAppProgressDialog = new ReportProgressDialog((Context)localObject1, 2131755826);
      this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
      this.jdField_b_of_type_AndroidAppProgressDialog.show();
      this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2131559574);
      ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131372546)).setText(amtj.a(2131714866));
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
    Object localObject2 = new bgoe(paramString, (File)localObject2);
    ((bgoe)localObject2).d = 60L;
    ((bgog)this.mRuntime.a().getManager(47)).a(1).a((bgoe)localObject2, new auvw(this, paramString), (Bundle)localObject1);
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
    bguj localbguj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localbguj = this.mRuntime.a(this.mRuntime.a());
      if ((localbguj != null) && ((localbguj instanceof bgzm))) {
        ((bgzm)localbguj).a((String)localObject2, this.mRuntime.a().hashCode());
      }
    }
    else
    {
      label97:
      localObject2 = paramJSONObject.optString("callback");
    }
    for (;;)
    {
      try
      {
        if (this.mRuntime != null) {
          break label411;
        }
        paramJSONObject = null;
        if (paramJSONObject == null) {
          break;
        }
        localObject3 = paramJSONObject.getPluginEngine();
        paramJSONObject = paramJSONObject.getUrl();
        if ((localObject3 != null) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          boolean bool = ((WebViewPluginEngine)localObject3).a().a(paramJSONObject, "ui.setLeftCloseHandler");
          if (bool) {
            this.jdField_e_of_type_JavaLangString = ((String)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("UiApiPlugin", 2, new Object[] { "setLeftCloseHandler url:", paramJSONObject, " hasRight:", Boolean.valueOf(bool) });
          }
        }
        localObject2 = new HashMap(2);
        if (paramJSONObject != null) {
          break label422;
        }
        paramJSONObject = (JSONObject)localObject1;
      }
      catch (Exception paramJSONObject)
      {
        label241:
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
        if ((localbguj != null) && ((localbguj instanceof bgzj)))
        {
          ((bgzj)localbguj).a((String)localObject2);
          break label97;
        }
        if ((localbguj instanceof WebViewFragment))
        {
          if (bgyb.a()) {
            break label97;
          }
          localObject3 = (WebViewFragment)localbguj;
          if ((((WebViewFragment)localObject3).mSwiftTitleUI == null) || (((WebViewFragment)localObject3).mSwiftTitleUI.leftView == null)) {
            break label97;
          }
          ((WebViewFragment)localObject3).mSwiftTitleUI.leftView.setText((CharSequence)localObject2);
          break label97;
        }
        localObject3 = (TextView)((Activity)localObject3).findViewById(2131369068);
        if (localObject3 == null) {
          break label97;
        }
        ((TextView)localObject3).setText((CharSequence)localObject2);
        break label97;
        label411:
        paramJSONObject = this.mRuntime.a();
        continue;
        label422:
        paramJSONObject = Uri.parse(paramJSONObject);
      }
      while (paramJSONObject != null)
      {
        localObject1 = paramJSONObject.getHost();
        break;
        paramJSONObject = paramJSONObject.getPath();
        break label241;
      }
      localObject1 = "";
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bjsv.isShowing()) {
      this.jdField_a_of_type_Bjsv.dismiss();
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
        FileUtils.writeFile(bfuc.decode(str, 0), (String)localObject1);
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
    localObject2 = new bgoe(str, (File)localObject2);
    ((bgoe)localObject2).d = 60L;
    ((bgog)this.mRuntime.a().getManager(47)).a(1).a((bgoe)localObject2, new auvx(this, str, paramString), (Bundle)localObject1);
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
      localWebViewFragment.mSwiftTitleUI.rightViewImg.setOnClickListener(new auvs(this, localActivity, (String)localObject1, (String)localObject2));
      a(localWebViewFragment.mSwiftTitleUI.rightViewImg, localWebViewFragment.mSwiftTitleUI.mRightCornerIcon, i1);
      localObject1 = (RelativeLayout)localActivity.findViewById(2131376501);
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
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new auvt(this, localActivity, str1, str2));
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
      this.jdField_c_of_type_AndroidWidgetImageView.setId(2131378732);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131376632);
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
    jdField_a_of_type_AndroidContentBroadcastReceiver = new auwa(this);
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
    if (this.jdField_a_of_type_Zon == null) {
      this.jdField_a_of_type_Zon = zon.a();
    }
    this.jdField_a_of_type_Zon.e();
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
                    if ((localObject1 != null) && ((((bgzt)localObject1).getRulesFromUrl() & 0x200000) == 0L) && (!((Intent)localObject2).getBooleanExtra("show_right_close_button", false)))
                    {
                      localObject2 = (TextView)paramString.findViewById(2131369099);
                      if ((localObject2 == null) || (((TextView)localObject2).getVisibility() != 0) || (!paramString.getString(2131690768).equals(((TextView)localObject2).getText()))) {
                        break label299;
                      }
                    }
                  }
                }
                while (this.jdField_c_of_type_Int == 0)
                {
                  return false;
                  if ((((bgzt)localObject1).getRulesFromUrl() & 0x4) == 0L) {
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
    //   3: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +17426 -> 17432
    //   9: aload_0
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 2668	com/tencent/mobileqq/jsp/UiApiPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   16: ldc_w 2670
    //   19: aload 4
    //   21: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   47: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   50: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   53: astore 4
    //   55: aload 5
    //   57: ldc_w 2672
    //   60: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload 5
    //   66: ldc_w 2674
    //   69: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload 5
    //   75: ldc 154
    //   77: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload 5
    //   83: ldc_w 811
    //   86: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 5
    //   91: aload 4
    //   93: ifnull +91 -> 184
    //   96: aload_1
    //   97: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   100: ifeq +84 -> 184
    //   103: aload_2
    //   104: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   107: ifeq +77 -> 184
    //   110: new 129	android/content/Intent
    //   113: dup
    //   114: aload 4
    //   116: ldc_w 2681
    //   119: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   122: astore 4
    //   124: aload 4
    //   126: ldc_w 2083
    //   129: aload_1
    //   130: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   133: pop
    //   134: aload 4
    //   136: ldc_w 2674
    //   139: aload_2
    //   140: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   143: pop
    //   144: ldc_w 2683
    //   147: aload_3
    //   148: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +25 -> 176
    //   154: aload 4
    //   156: ldc_w 2685
    //   159: bipush 8
    //   161: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   164: pop
    //   165: aload 4
    //   167: ldc_w 811
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
    //   193: ldc_w 2687
    //   196: iconst_2
    //   197: new 551	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 2689
    //   207: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -36 -> 184
    //   223: ldc_w 2691
    //   226: aload 4
    //   228: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   253: ldc_w 602
    //   256: invokevirtual 2694	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 10
    //   261: aload_2
    //   262: ldc_w 2696
    //   265: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   268: istore 6
    //   270: aload_2
    //   271: ldc_w 2698
    //   274: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_1
    //   278: aload_2
    //   279: ldc_w 811
    //   282: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: astore_2
    //   286: aload_0
    //   287: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   290: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   293: new 551	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   300: lload 10
    //   302: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc_w 484
    //   308: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: bipush 9
    //   316: invokestatic 2703	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   319: astore_3
    //   320: aload_3
    //   321: ldc_w 2705
    //   324: aload_1
    //   325: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 2707
    //   333: iload 6
    //   335: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   338: pop
    //   339: aload_3
    //   340: ldc_w 811
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
    //   365: ldc_w 2687
    //   368: iconst_2
    //   369: new 551	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 2709
    //   379: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -208 -> 184
    //   395: ldc_w 2711
    //   398: aload 4
    //   400: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq +28 -> 431
    //   406: aload 5
    //   408: arraylength
    //   409: ifle +22 -> 431
    //   412: aload_0
    //   413: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   416: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   419: invokevirtual 1680	com/tencent/biz/pubaccount/CustomWebView:getContext	()Landroid/content/Context;
    //   422: aload 5
    //   424: iconst_0
    //   425: aaload
    //   426: invokestatic 2713	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   429: iconst_1
    //   430: ireturn
    //   431: ldc_w 2715
    //   434: aload 4
    //   436: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   439: ifeq +109 -> 548
    //   442: new 113	org/json/JSONObject
    //   445: dup
    //   446: aload 5
    //   448: iconst_0
    //   449: aaload
    //   450: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   453: ldc_w 2717
    //   456: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   459: astore_1
    //   460: aload_1
    //   461: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   464: ifeq +5 -> 469
    //   467: iconst_1
    //   468: ireturn
    //   469: aload_0
    //   470: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   473: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   476: astore_2
    //   477: new 129	android/content/Intent
    //   480: dup
    //   481: aload_2
    //   482: ldc_w 2649
    //   485: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   488: aconst_null
    //   489: invokestatic 2655	com/tencent/mobileqq/activity/aio/AIOUtils:setOpenAIOIntent	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   492: astore_3
    //   493: aload_3
    //   494: ldc_w 2719
    //   497: aload_1
    //   498: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   501: pop
    //   502: aload_3
    //   503: ldc_w 462
    //   506: iconst_1
    //   507: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   510: pop
    //   511: aload_3
    //   512: ldc_w 2721
    //   515: iconst_1
    //   516: invokevirtual 605	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
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
    //   538: ldc_w 2723
    //   541: aload_1
    //   542: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: goto -361 -> 184
    //   548: ldc_w 2727
    //   551: aload 4
    //   553: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   556: ifeq +231 -> 787
    //   559: new 113	org/json/JSONObject
    //   562: dup
    //   563: aload 5
    //   565: iconst_0
    //   566: aaload
    //   567: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   570: astore_3
    //   571: aload_3
    //   572: ldc_w 2717
    //   575: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   578: astore 4
    //   580: aload 4
    //   582: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   585: ifeq +5 -> 590
    //   588: iconst_1
    //   589: ireturn
    //   590: aload_3
    //   591: ldc_w 2729
    //   594: ldc_w 2730
    //   597: invokestatic 2335	amtj:a	(I)Ljava/lang/String;
    //   600: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   603: astore 5
    //   605: aload_3
    //   606: ldc_w 2732
    //   609: ldc_w 2734
    //   612: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   615: astore 14
    //   617: aload_0
    //   618: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   621: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   624: astore_1
    //   625: new 129	android/content/Intent
    //   628: dup
    //   629: aload_1
    //   630: ldc_w 2649
    //   633: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   636: aconst_null
    //   637: invokestatic 2655	com/tencent/mobileqq/activity/aio/AIOUtils:setOpenAIOIntent	(Landroid/content/Intent;[I)Landroid/content/Intent;
    //   640: astore_2
    //   641: aload_2
    //   642: ldc_w 2719
    //   645: aload 4
    //   647: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   650: pop
    //   651: aload_2
    //   652: ldc_w 462
    //   655: iconst_1
    //   656: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   659: pop
    //   660: aload_2
    //   661: ldc_w 2729
    //   664: aload 5
    //   666: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   669: pop
    //   670: aload_2
    //   671: ldc_w 2732
    //   674: aload 14
    //   676: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   679: pop
    //   680: aload_3
    //   681: ldc 174
    //   683: iconst_0
    //   684: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   687: istore 6
    //   689: iload 6
    //   691: iconst_1
    //   692: if_icmpne +65 -> 757
    //   695: aload_3
    //   696: ldc_w 2736
    //   699: invokevirtual 1078	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   702: astore_3
    //   703: aload_3
    //   704: ifnull +15 -> 719
    //   707: aload_2
    //   708: ldc_w 2738
    //   711: aload_3
    //   712: invokevirtual 1113	org/json/JSONArray:toString	()Ljava/lang/String;
    //   715: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   718: pop
    //   719: aload_2
    //   720: ldc_w 2740
    //   723: iload 6
    //   725: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
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
    //   747: ldc_w 2742
    //   750: aload_1
    //   751: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   754: goto -570 -> 184
    //   757: iload 6
    //   759: iconst_2
    //   760: if_icmpne -41 -> 719
    //   763: aload_2
    //   764: ldc_w 2744
    //   767: aload_3
    //   768: ldc_w 2736
    //   771: ldc_w 2745
    //   774: invokestatic 2335	amtj:a	(I)Ljava/lang/String;
    //   777: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   780: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   783: pop
    //   784: goto -65 -> 719
    //   787: ldc_w 2747
    //   790: aload 4
    //   792: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifeq +50 -> 845
    //   798: new 113	org/json/JSONObject
    //   801: dup
    //   802: aload 5
    //   804: iconst_0
    //   805: aaload
    //   806: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   809: ldc_w 801
    //   812: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   815: astore_1
    //   816: aload_1
    //   817: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   820: ifne -636 -> 184
    //   823: aload_0
    //   824: aload_0
    //   825: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   828: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   831: aload_1
    //   832: invokestatic 2752	avnx:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/app/ProgressDialog;
    //   835: putfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   838: goto -654 -> 184
    //   841: astore_1
    //   842: goto -658 -> 184
    //   845: ldc_w 2756
    //   848: aload 4
    //   850: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   853: ifeq +52 -> 905
    //   856: aload_0
    //   857: getfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   860: ifnull -676 -> 184
    //   863: aload_0
    //   864: getfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   867: invokevirtual 2757	android/app/ProgressDialog:isShowing	()Z
    //   870: ifeq -686 -> 184
    //   873: aload_0
    //   874: getfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   877: invokevirtual 2370	android/app/ProgressDialog:dismiss	()V
    //   880: aload_0
    //   881: aconst_null
    //   882: putfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   885: goto -701 -> 184
    //   888: astore_1
    //   889: aload_0
    //   890: aconst_null
    //   891: putfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   894: goto -710 -> 184
    //   897: astore_1
    //   898: aload_0
    //   899: aconst_null
    //   900: putfield 2754	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   903: aload_1
    //   904: athrow
    //   905: ldc_w 2759
    //   908: aload 4
    //   910: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   913: ifeq +83 -> 996
    //   916: aload 5
    //   918: arraylength
    //   919: iconst_1
    //   920: if_icmpne -736 -> 184
    //   923: aload_1
    //   924: getfield 2762	com/tencent/mobileqq/webview/swift/JsBridgeListener:jdField_a_of_type_Boolean	Z
    //   927: ifeq +36 -> 963
    //   930: aload_0
    //   931: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   934: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   937: aload_0
    //   938: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   941: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   944: aload_0
    //   945: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   948: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   951: aload 5
    //   953: iconst_0
    //   954: aaload
    //   955: iconst_1
    //   956: iconst_0
    //   957: invokestatic 2764	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   960: goto -776 -> 184
    //   963: aload_0
    //   964: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   967: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   970: aload_0
    //   971: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   974: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   977: aload_0
    //   978: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   981: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   984: aload 5
    //   986: iconst_0
    //   987: aaload
    //   988: iconst_0
    //   989: iconst_0
    //   990: invokestatic 2764	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   993: goto -809 -> 184
    //   996: ldc_w 2766
    //   999: aload 4
    //   1001: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1004: ifeq +118 -> 1122
    //   1007: aload_0
    //   1008: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1011: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1014: instanceof 2768
    //   1017: ifeq +26 -> 1043
    //   1020: aload_1
    //   1021: aload_0
    //   1022: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1025: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1028: checkcast 2768	mqq/app/AppActivity
    //   1031: invokevirtual 2771	mqq/app/AppActivity:isResume	()Z
    //   1034: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1037: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1040: goto -856 -> 184
    //   1043: aload_0
    //   1044: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1047: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1050: instanceof 2776
    //   1053: ifeq +26 -> 1079
    //   1056: aload_1
    //   1057: aload_0
    //   1058: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1061: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1064: checkcast 2776	cooperation/qwallet/plugin/QWalletPluginProxyActivity
    //   1067: invokevirtual 2777	cooperation/qwallet/plugin/QWalletPluginProxyActivity:isResume	()Z
    //   1070: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1073: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1076: goto -892 -> 184
    //   1079: aload_0
    //   1080: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1083: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1086: ifnonnull +25 -> 1111
    //   1089: invokestatic 2780	aurn:a	()Z
    //   1092: ifne +19 -> 1111
    //   1095: aload_1
    //   1096: invokestatic 2785	aurt:a	()Laurt;
    //   1099: invokevirtual 2786	aurt:a	()Z
    //   1102: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1105: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1108: goto -924 -> 184
    //   1111: aload_1
    //   1112: iconst_0
    //   1113: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1116: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1119: goto -935 -> 184
    //   1122: ldc_w 2788
    //   1125: aload 4
    //   1127: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   1170: ldc_w 2790
    //   1173: aload_1
    //   1174: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1177: goto -993 -> 184
    //   1180: ldc_w 2792
    //   1183: aload 4
    //   1185: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1188: ifeq +119 -> 1307
    //   1191: aload 5
    //   1193: arraylength
    //   1194: iconst_1
    //   1195: if_icmpne +112 -> 1307
    //   1198: aload_0
    //   1199: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1202: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1205: astore_2
    //   1206: aload_2
    //   1207: ifnull +16280 -> 17487
    //   1210: aload_2
    //   1211: invokevirtual 799	android/app/Activity:isFinishing	()Z
    //   1214: ifeq +6 -> 1220
    //   1217: goto +16270 -> 17487
    //   1220: new 113	org/json/JSONObject
    //   1223: dup
    //   1224: aload 5
    //   1226: iconst_0
    //   1227: aaload
    //   1228: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1231: astore_2
    //   1232: aload_0
    //   1233: aload_2
    //   1234: ldc_w 2794
    //   1237: invokevirtual 425	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1240: invokevirtual 2796	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1243: aload_0
    //   1244: aload_2
    //   1245: ldc_w 2798
    //   1248: invokevirtual 425	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1251: aload_1
    //   1252: invokevirtual 2800	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1255: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1258: ifeq -1074 -> 184
    //   1261: ldc 209
    //   1263: iconst_2
    //   1264: iconst_2
    //   1265: anewarray 277	java/lang/Object
    //   1268: dup
    //   1269: iconst_0
    //   1270: ldc_w 2792
    //   1273: aastore
    //   1274: dup
    //   1275: iconst_1
    //   1276: aload_2
    //   1277: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1280: aastore
    //   1281: invokestatic 2424	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1284: goto -1100 -> 184
    //   1287: astore_1
    //   1288: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1291: ifeq -1107 -> 184
    //   1294: ldc 209
    //   1296: iconst_2
    //   1297: ldc_w 2802
    //   1300: aload_1
    //   1301: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1304: goto -1120 -> 184
    //   1307: ldc_w 2803
    //   1310: aload 4
    //   1312: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1315: ifeq +71 -> 1386
    //   1318: aload 5
    //   1320: arraylength
    //   1321: iconst_1
    //   1322: if_icmpne +64 -> 1386
    //   1325: aload_0
    //   1326: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1329: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1332: astore_2
    //   1333: aload_2
    //   1334: ifnull +16155 -> 17489
    //   1337: aload_2
    //   1338: invokevirtual 799	android/app/Activity:isFinishing	()Z
    //   1341: ifeq +6 -> 1347
    //   1344: goto +16145 -> 17489
    //   1347: aload_0
    //   1348: new 113	org/json/JSONObject
    //   1351: dup
    //   1352: aload 5
    //   1354: iconst_0
    //   1355: aaload
    //   1356: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1359: aload_1
    //   1360: invokevirtual 2800	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   1363: goto -1179 -> 184
    //   1366: astore_1
    //   1367: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq -1186 -> 184
    //   1373: ldc 209
    //   1375: iconst_2
    //   1376: ldc_w 2805
    //   1379: aload_1
    //   1380: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1383: goto -1199 -> 184
    //   1386: ldc_w 2807
    //   1389: aload 4
    //   1391: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1394: ifeq +109 -> 1503
    //   1397: aload 5
    //   1399: arraylength
    //   1400: iconst_1
    //   1401: if_icmpne +102 -> 1503
    //   1404: aload_0
    //   1405: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1408: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1411: astore_1
    //   1412: aload_1
    //   1413: ifnull +16078 -> 17491
    //   1416: aload_1
    //   1417: invokevirtual 799	android/app/Activity:isFinishing	()Z
    //   1420: ifeq +6 -> 1426
    //   1423: goto +16068 -> 17491
    //   1426: new 113	org/json/JSONObject
    //   1429: dup
    //   1430: aload 5
    //   1432: iconst_0
    //   1433: aaload
    //   1434: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1437: astore_1
    //   1438: aload_1
    //   1439: ldc_w 2809
    //   1442: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1445: istore 6
    //   1447: aload_1
    //   1448: ldc_w 2811
    //   1451: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1454: istore 12
    //   1456: aload_1
    //   1457: ldc_w 811
    //   1460: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1463: astore_2
    //   1464: aload_0
    //   1465: iload 6
    //   1467: iload 12
    //   1469: aload_1
    //   1470: ldc_w 2813
    //   1473: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   1476: aload_2
    //   1477: invokevirtual 2815	com/tencent/mobileqq/jsp/UiApiPlugin:a	(IZZLjava/lang/String;)V
    //   1480: goto -1296 -> 184
    //   1483: astore_1
    //   1484: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1487: ifeq -1303 -> 184
    //   1490: ldc 209
    //   1492: iconst_2
    //   1493: ldc_w 2805
    //   1496: aload_1
    //   1497: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1500: goto -1316 -> 184
    //   1503: ldc_w 2597
    //   1506: aload 4
    //   1508: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1511: ifeq +70 -> 1581
    //   1514: aload 5
    //   1516: arraylength
    //   1517: iconst_1
    //   1518: if_icmpne +63 -> 1581
    //   1521: aload_0
    //   1522: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1525: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1528: astore_1
    //   1529: aload_1
    //   1530: ifnull +15963 -> 17493
    //   1533: aload_1
    //   1534: invokevirtual 799	android/app/Activity:isFinishing	()Z
    //   1537: ifeq +6 -> 1543
    //   1540: goto +15953 -> 17493
    //   1543: aload_0
    //   1544: new 113	org/json/JSONObject
    //   1547: dup
    //   1548: aload 5
    //   1550: iconst_0
    //   1551: aaload
    //   1552: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1555: invokevirtual 2796	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Lorg/json/JSONObject;)V
    //   1558: goto -1374 -> 184
    //   1561: astore_1
    //   1562: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1565: ifeq -1381 -> 184
    //   1568: ldc 209
    //   1570: iconst_2
    //   1571: ldc_w 2817
    //   1574: aload_1
    //   1575: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1578: goto -1394 -> 184
    //   1581: ldc_w 2819
    //   1584: aload 4
    //   1586: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1589: ifeq +83 -> 1672
    //   1592: aload 5
    //   1594: arraylength
    //   1595: iconst_1
    //   1596: if_icmpne +76 -> 1672
    //   1599: aload_0
    //   1600: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1603: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1606: astore_1
    //   1607: aload_1
    //   1608: ifnull +15887 -> 17495
    //   1611: aload_1
    //   1612: invokevirtual 799	android/app/Activity:isFinishing	()Z
    //   1615: ifeq +6 -> 1621
    //   1618: goto +15877 -> 17495
    //   1621: aload_0
    //   1622: new 113	org/json/JSONObject
    //   1625: dup
    //   1626: aload 5
    //   1628: iconst_0
    //   1629: aaload
    //   1630: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1633: invokevirtual 2821	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Lorg/json/JSONObject;)V
    //   1636: goto -1452 -> 184
    //   1639: astore_1
    //   1640: ldc 209
    //   1642: iconst_1
    //   1643: new 551	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   1650: ldc_w 2823
    //   1653: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: aload_1
    //   1657: invokestatic 2826	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1660: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1666: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1669: goto -1485 -> 184
    //   1672: ldc_w 1398
    //   1675: aload 4
    //   1677: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1680: ifeq +21 -> 1701
    //   1683: aload 5
    //   1685: arraylength
    //   1686: iconst_1
    //   1687: if_icmpne +14 -> 1701
    //   1690: aload_0
    //   1691: aload 5
    //   1693: iconst_0
    //   1694: aaload
    //   1695: invokevirtual 2827	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;)V
    //   1698: goto -1514 -> 184
    //   1701: ldc_w 2829
    //   1704: aload 4
    //   1706: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   1732: ldc_w 2831
    //   1735: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1738: astore_1
    //   1739: aload_0
    //   1740: aload_2
    //   1741: ldc_w 811
    //   1744: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1747: putfield 2832	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1750: aload_0
    //   1751: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1754: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1757: ifnonnull +5 -> 1762
    //   1760: iconst_1
    //   1761: ireturn
    //   1762: aload_0
    //   1763: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1766: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1769: invokevirtual 261	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1772: astore_2
    //   1773: new 129	android/content/Intent
    //   1776: dup
    //   1777: aload_0
    //   1778: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1781: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1784: ldc_w 2834
    //   1787: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1790: ldc 154
    //   1792: ldc_w 774
    //   1795: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1798: astore_3
    //   1799: aload_1
    //   1800: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1803: ifeq +48 -> 1851
    //   1806: aload_0
    //   1807: getfield 2832	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1810: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1813: ifeq +38 -> 1851
    //   1816: aload_3
    //   1817: ldc_w 2836
    //   1820: iconst_1
    //   1821: invokevirtual 605	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1824: pop
    //   1825: aload_0
    //   1826: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1829: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1832: ifnonnull +5 -> 1837
    //   1835: iconst_1
    //   1836: ireturn
    //   1837: aload_0
    //   1838: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1841: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1844: aload_3
    //   1845: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1848: goto -1664 -> 184
    //   1851: aload_3
    //   1852: ldc_w 2831
    //   1855: aload_1
    //   1856: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1859: ldc_w 2838
    //   1862: aload_2
    //   1863: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1866: ldc_w 2840
    //   1869: iconst_1
    //   1870: invokevirtual 605	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1873: pop
    //   1874: aload_0
    //   1875: aload_3
    //   1876: iconst_3
    //   1877: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   1880: goto -1696 -> 184
    //   1883: ldc_w 2842
    //   1886: aload 4
    //   1888: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   1916: ldc_w 2831
    //   1919: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1922: astore_1
    //   1923: aload 4
    //   1925: ldc_w 930
    //   1928: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1931: astore_2
    //   1932: aload 4
    //   1934: ldc 174
    //   1936: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1939: astore_3
    //   1940: aload_0
    //   1941: aload 4
    //   1943: ldc_w 811
    //   1946: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1949: putfield 2844	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1952: aload_0
    //   1953: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1956: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1959: ifnonnull +5 -> 1964
    //   1962: iconst_1
    //   1963: ireturn
    //   1964: aload_0
    //   1965: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1968: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1971: invokevirtual 261	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1974: astore 4
    //   1976: new 129	android/content/Intent
    //   1979: dup
    //   1980: aload_0
    //   1981: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   1984: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   1987: ldc_w 2846
    //   1990: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1993: ldc_w 2848
    //   1996: iconst_4
    //   1997: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2000: ldc_w 2849
    //   2003: invokevirtual 590	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2006: astore 5
    //   2008: aload_1
    //   2009: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2012: ifeq +73 -> 2085
    //   2015: aload_0
    //   2016: getfield 2844	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2019: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2022: ifeq +63 -> 2085
    //   2025: aload_0
    //   2026: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2029: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2032: ifnonnull +5 -> 2037
    //   2035: iconst_1
    //   2036: ireturn
    //   2037: aload_0
    //   2038: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2041: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2044: aload 5
    //   2046: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   2049: goto -1865 -> 184
    //   2052: astore_1
    //   2053: ldc 209
    //   2055: iconst_1
    //   2056: new 551	java/lang/StringBuilder
    //   2059: dup
    //   2060: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   2063: ldc_w 2851
    //   2066: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: aload_1
    //   2070: invokevirtual 923	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2073: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2079: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2082: goto -1898 -> 184
    //   2085: aload 5
    //   2087: ldc_w 2831
    //   2090: aload_1
    //   2091: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2094: ldc 174
    //   2096: aload_3
    //   2097: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2100: ldc_w 930
    //   2103: aload_2
    //   2104: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2107: ldc_w 2838
    //   2110: aload 4
    //   2112: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2115: ldc_w 2840
    //   2118: iconst_1
    //   2119: invokevirtual 605	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2122: pop
    //   2123: aload_0
    //   2124: aload 5
    //   2126: bipush 17
    //   2128: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   2131: goto -1947 -> 184
    //   2134: ldc_w 2853
    //   2137: aload 4
    //   2139: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2163: ldc_w 811
    //   2166: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2169: astore_1
    //   2170: aload_0
    //   2171: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2174: aload_0
    //   2175: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2178: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2181: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2184: astore_2
    //   2185: aload_2
    //   2186: ifnull +23 -> 2209
    //   2189: aload_2
    //   2190: instanceof 2171
    //   2193: ifeq +16 -> 2209
    //   2196: aload_2
    //   2197: checkcast 2171	bgzq
    //   2200: invokeinterface 2175 1 0
    //   2205: aload_1
    //   2206: putfield 2856	aadf:v	Ljava/lang/String;
    //   2209: aload_1
    //   2210: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2213: ifne -2029 -> 184
    //   2216: aload_0
    //   2217: iconst_2
    //   2218: invokevirtual 2857	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   2221: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   2224: astore_1
    //   2225: aload_1
    //   2226: ifnull -2042 -> 184
    //   2229: aload_1
    //   2230: invokevirtual 2860	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setAddShortcutBtnVisible	()V
    //   2233: goto -2049 -> 184
    //   2236: astore_1
    //   2237: aload_1
    //   2238: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2241: goto -2057 -> 184
    //   2244: ldc_w 2863
    //   2247: aload 4
    //   2249: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2274: ldc_w 811
    //   2277: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2280: putfield 2417	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2283: goto -2099 -> 184
    //   2286: astore_1
    //   2287: aload_1
    //   2288: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2291: goto -2107 -> 184
    //   2294: ldc_w 2865
    //   2297: aload 4
    //   2299: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2323: ldc_w 811
    //   2326: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2329: astore_1
    //   2330: aload_0
    //   2331: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2334: aload_0
    //   2335: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2338: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2341: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2344: astore_2
    //   2345: aload_2
    //   2346: ifnull -2162 -> 184
    //   2349: aload_2
    //   2350: instanceof 2171
    //   2353: ifeq -2169 -> 184
    //   2356: aload_2
    //   2357: checkcast 2171	bgzq
    //   2360: invokeinterface 2175 1 0
    //   2365: aload_1
    //   2366: invokevirtual 2866	aadf:a	(Ljava/lang/String;)V
    //   2369: goto -2185 -> 184
    //   2372: astore_1
    //   2373: aload_1
    //   2374: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2377: goto -2193 -> 184
    //   2380: ldc_w 2868
    //   2383: aload 4
    //   2385: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2409: ldc_w 811
    //   2412: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2415: astore_1
    //   2416: aload_0
    //   2417: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2420: aload_0
    //   2421: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2424: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2427: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2430: astore_2
    //   2431: aload_2
    //   2432: ifnull +23 -> 2455
    //   2435: aload_2
    //   2436: instanceof 2171
    //   2439: ifeq +16 -> 2455
    //   2442: aload_2
    //   2443: checkcast 2171	bgzq
    //   2446: invokeinterface 2175 1 0
    //   2451: aload_1
    //   2452: putfield 2870	aadf:q	Ljava/lang/String;
    //   2455: aconst_null
    //   2456: ldc_w 770
    //   2459: ldc_w 2872
    //   2462: ldc_w 484
    //   2465: ldc_w 2874
    //   2468: ldc_w 2874
    //   2471: iconst_0
    //   2472: iconst_0
    //   2473: ldc_w 484
    //   2476: ldc_w 484
    //   2479: ldc_w 484
    //   2482: ldc_w 484
    //   2485: invokestatic 1537	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2488: goto -2304 -> 184
    //   2491: astore_1
    //   2492: aload_1
    //   2493: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2496: goto -41 -> 2455
    //   2499: ldc_w 2876
    //   2502: aload 4
    //   2504: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2528: ldc_w 811
    //   2531: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2534: astore_1
    //   2535: aload_0
    //   2536: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2539: aload_0
    //   2540: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2543: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2546: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2549: astore_2
    //   2550: aload_2
    //   2551: ifnull -2367 -> 184
    //   2554: aload_2
    //   2555: instanceof 2171
    //   2558: ifeq -2374 -> 184
    //   2561: aload_2
    //   2562: checkcast 2171	bgzq
    //   2565: invokeinterface 2175 1 0
    //   2570: aload_1
    //   2571: putfield 2879	aadf:r	Ljava/lang/String;
    //   2574: goto -2390 -> 184
    //   2577: astore_1
    //   2578: aload_1
    //   2579: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2582: goto -2398 -> 184
    //   2585: ldc_w 2881
    //   2588: aload 4
    //   2590: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2614: ldc_w 811
    //   2617: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2620: astore_1
    //   2621: aload_0
    //   2622: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2625: aload_0
    //   2626: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2629: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2632: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2635: astore_2
    //   2636: aload_2
    //   2637: ifnull +23 -> 2660
    //   2640: aload_2
    //   2641: instanceof 2171
    //   2644: ifeq +16 -> 2660
    //   2647: aload_2
    //   2648: checkcast 2171	bgzq
    //   2651: invokeinterface 2175 1 0
    //   2656: aload_1
    //   2657: putfield 2884	aadf:s	Ljava/lang/String;
    //   2660: aconst_null
    //   2661: ldc_w 770
    //   2664: ldc_w 2872
    //   2667: ldc_w 484
    //   2670: ldc_w 2886
    //   2673: ldc_w 2886
    //   2676: iconst_0
    //   2677: iconst_0
    //   2678: ldc_w 484
    //   2681: ldc_w 484
    //   2684: ldc_w 484
    //   2687: ldc_w 484
    //   2690: invokestatic 1537	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2693: goto -2509 -> 184
    //   2696: astore_1
    //   2697: aload_1
    //   2698: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2701: goto -41 -> 2660
    //   2704: ldc_w 2888
    //   2707: aload 4
    //   2709: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2733: ldc_w 811
    //   2736: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2739: astore_1
    //   2740: aload_0
    //   2741: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2744: aload_0
    //   2745: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2748: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2751: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2754: astore_2
    //   2755: aload_2
    //   2756: ifnull +23 -> 2779
    //   2759: aload_2
    //   2760: instanceof 2171
    //   2763: ifeq +16 -> 2779
    //   2766: aload_2
    //   2767: checkcast 2171	bgzq
    //   2770: invokeinterface 2175 1 0
    //   2775: aload_1
    //   2776: putfield 2891	aadf:t	Ljava/lang/String;
    //   2779: aconst_null
    //   2780: ldc_w 770
    //   2783: ldc_w 2872
    //   2786: ldc_w 484
    //   2789: ldc_w 2893
    //   2792: ldc_w 2893
    //   2795: iconst_0
    //   2796: iconst_0
    //   2797: ldc_w 484
    //   2800: ldc_w 484
    //   2803: ldc_w 484
    //   2806: ldc_w 484
    //   2809: invokestatic 1537	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2812: goto -2628 -> 184
    //   2815: astore_1
    //   2816: aload_1
    //   2817: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2820: goto -41 -> 2779
    //   2823: ldc_w 2895
    //   2826: aload 4
    //   2828: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2852: ldc_w 811
    //   2855: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2858: astore_1
    //   2859: aload_0
    //   2860: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2863: aload_0
    //   2864: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   2867: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   2870: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   2873: astore_2
    //   2874: aload_2
    //   2875: ifnull +23 -> 2898
    //   2878: aload_2
    //   2879: instanceof 2171
    //   2882: ifeq +16 -> 2898
    //   2885: aload_2
    //   2886: checkcast 2171	bgzq
    //   2889: invokeinterface 2175 1 0
    //   2894: aload_1
    //   2895: putfield 2898	aadf:u	Ljava/lang/String;
    //   2898: aconst_null
    //   2899: ldc_w 770
    //   2902: ldc_w 2872
    //   2905: ldc_w 484
    //   2908: ldc_w 2900
    //   2911: ldc_w 2900
    //   2914: iconst_0
    //   2915: iconst_0
    //   2916: ldc_w 484
    //   2919: ldc_w 484
    //   2922: ldc_w 484
    //   2925: ldc_w 484
    //   2928: invokestatic 1537	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2931: goto -2747 -> 184
    //   2934: astore_1
    //   2935: aload_1
    //   2936: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   2939: goto -41 -> 2898
    //   2942: ldc_w 2902
    //   2945: aload 4
    //   2947: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   2973: ldc_w 811
    //   2976: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2979: astore_3
    //   2980: new 2904	auvo
    //   2983: dup
    //   2984: aload_0
    //   2985: aload_3
    //   2986: invokespecial 2905	auvo:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   2989: astore_2
    //   2990: new 2907	auvy
    //   2993: dup
    //   2994: aload_0
    //   2995: aload_3
    //   2996: invokespecial 2908	auvy:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   2999: astore_3
    //   3000: aload_0
    //   3001: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3004: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   3007: aload_1
    //   3008: aload_2
    //   3009: aload_2
    //   3010: aload_3
    //   3011: invokestatic 2910	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lorg/json/JSONObject;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;)V
    //   3014: iconst_1
    //   3015: ireturn
    //   3016: astore_1
    //   3017: aload_1
    //   3018: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   3021: goto -2837 -> 184
    //   3024: ldc_w 2912
    //   3027: aload 4
    //   3029: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   3055: ldc_w 2914
    //   3058: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3061: astore_3
    //   3062: aload_2
    //   3063: ldc_w 2916
    //   3066: invokevirtual 425	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   3069: astore_2
    //   3070: ldc_w 2918
    //   3073: aload_3
    //   3074: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3077: ifeq +106 -> 3183
    //   3080: aload_2
    //   3081: ldc_w 2672
    //   3084: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3087: astore_2
    //   3088: aload_2
    //   3089: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3092: ifeq +66 -> 3158
    //   3095: new 129	android/content/Intent
    //   3098: dup
    //   3099: invokespecial 496	android/content/Intent:<init>	()V
    //   3102: astore_3
    //   3103: aload_3
    //   3104: getstatic 2921	cooperation/troop/TroopFileProxyActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3107: aload_2
    //   3108: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3111: pop
    //   3112: aload_0
    //   3113: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3116: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   3119: aload_3
    //   3120: aload_0
    //   3121: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3124: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   3127: invokevirtual 2064	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3130: invokestatic 2924	cooperation/troop/TroopFileProxyActivity:a	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;)V
    //   3133: aload_1
    //   3134: ldc_w 2926
    //   3137: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3140: goto -2956 -> 184
    //   3143: astore_2
    //   3144: aload_2
    //   3145: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   3148: aload_1
    //   3149: ldc_w 2928
    //   3152: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3155: goto -2971 -> 184
    //   3158: aload_1
    //   3159: ldc_w 2928
    //   3162: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3165: goto -2981 -> 184
    //   3168: astore_2
    //   3169: aload_2
    //   3170: invokevirtual 876	java/lang/Exception:printStackTrace	()V
    //   3173: aload_1
    //   3174: ldc_w 2928
    //   3177: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3180: goto -2996 -> 184
    //   3183: ldc_w 2930
    //   3186: aload_3
    //   3187: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3190: ifeq +71 -> 3261
    //   3193: aload_2
    //   3194: ldc_w 2672
    //   3197: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3200: astore_2
    //   3201: aload_2
    //   3202: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3205: ifeq +46 -> 3251
    //   3208: invokestatic 2935	cooperation/qzone/QZoneHelper$UserInfo:getInstance	()Lcooperation/qzone/QZoneHelper$UserInfo;
    //   3211: astore_3
    //   3212: aload_3
    //   3213: aload_0
    //   3214: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3217: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   3220: invokevirtual 2064	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3223: putfield 2938	cooperation/qzone/QZoneHelper$UserInfo:qzone_uin	Ljava/lang/String;
    //   3226: aload_0
    //   3227: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3230: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   3233: aload_3
    //   3234: aload_2
    //   3235: aconst_null
    //   3236: iconst_0
    //   3237: iconst_0
    //   3238: invokestatic 2944	cooperation/qzone/QZoneHelper:forwardToQunFeed	(Landroid/app/Activity;Lcooperation/qzone/QZoneHelper$UserInfo;Ljava/lang/String;Ljava/lang/String;ZI)V
    //   3241: aload_1
    //   3242: ldc_w 2926
    //   3245: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3248: goto -3064 -> 184
    //   3251: aload_1
    //   3252: ldc_w 2928
    //   3255: invokevirtual 2774	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   3258: goto -3074 -> 184
    //   3261: ldc_w 2946
    //   3264: aload_3
    //   3265: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3268: ifeq +66 -> 3334
    //   3271: aload_0
    //   3272: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3275: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   3278: astore_3
    //   3279: aload_2
    //   3280: ldc_w 2672
    //   3283: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3286: astore_2
    //   3287: aload_3
    //   3288: ifnull -3104 -> 184
    //   3291: aload_2
    //   3292: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3295: ifeq -3111 -> 184
    //   3298: new 129	android/content/Intent
    //   3301: dup
    //   3302: aload_3
    //   3303: ldc_w 2948
    //   3306: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
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
    //   3328: invokevirtual 656	android/app/Activity:finish	()V
    //   3331: goto -3147 -> 184
    //   3334: ldc_w 2950
    //   3337: aload_3
    //   3338: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3341: ifeq -3157 -> 184
    //   3344: aload_0
    //   3345: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3348: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   3351: astore_3
    //   3352: aload_2
    //   3353: ldc_w 2672
    //   3356: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3359: astore 4
    //   3361: aload_2
    //   3362: ldc_w 2674
    //   3365: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3368: astore_2
    //   3369: aload_3
    //   3370: ifnull -3186 -> 184
    //   3373: aload 4
    //   3375: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3378: ifeq -3194 -> 184
    //   3381: aload_2
    //   3382: invokestatic 2679	com/tencent/mobileqq/data/Friends:isValidUin	(Ljava/lang/String;)Z
    //   3385: ifeq -3201 -> 184
    //   3388: new 129	android/content/Intent
    //   3391: dup
    //   3392: aload_3
    //   3393: ldc_w 2681
    //   3396: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3399: astore 5
    //   3401: aload 5
    //   3403: ldc_w 2083
    //   3406: aload 4
    //   3408: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3411: pop
    //   3412: aload 5
    //   3414: ldc_w 2674
    //   3417: aload_2
    //   3418: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3421: pop
    //   3422: aload_3
    //   3423: aload 5
    //   3425: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3428: goto -3244 -> 184
    //   3431: ldc_w 2951
    //   3434: aload 4
    //   3436: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3439: ifeq +888 -> 4327
    //   3442: aload 5
    //   3444: arraylength
    //   3445: iconst_1
    //   3446: if_icmpne +881 -> 4327
    //   3449: aload_0
    //   3450: ldc_w 484
    //   3453: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
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
    //   3473: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3476: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   3479: astore_3
    //   3480: aload_1
    //   3481: ldc_w 2955
    //   3484: ldc_w 2957
    //   3487: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3490: astore 14
    //   3492: aload_1
    //   3493: ldc_w 2831
    //   3496: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3499: astore 4
    //   3501: aload_1
    //   3502: ldc_w 421
    //   3505: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3508: astore 15
    //   3510: aload_1
    //   3511: ldc_w 2959
    //   3514: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3517: astore 5
    //   3519: aload_1
    //   3520: ldc_w 811
    //   3523: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3526: astore_2
    //   3527: aload_1
    //   3528: ldc_w 410
    //   3531: iconst_m1
    //   3532: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3535: istore 6
    //   3537: new 113	org/json/JSONObject
    //   3540: dup
    //   3541: aload 15
    //   3543: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3546: astore_1
    //   3547: aload_0
    //   3548: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   3551: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   3554: astore 15
    //   3556: aload 15
    //   3558: ifnull +16 -> 3574
    //   3561: aload_1
    //   3562: ldc_w 2961
    //   3565: aload 15
    //   3567: invokevirtual 2962	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   3570: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3573: pop
    //   3574: ldc_w 2964
    //   3577: aload 14
    //   3579: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3582: ifeq +164 -> 3746
    //   3585: new 301	android/os/Bundle
    //   3588: dup
    //   3589: invokespecial 302	android/os/Bundle:<init>	()V
    //   3592: astore_2
    //   3593: aload_2
    //   3594: ldc_w 421
    //   3597: aload_1
    //   3598: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3601: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3604: aload_2
    //   3605: ldc_w 2959
    //   3608: aload 5
    //   3610: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3613: ldc_w 2966
    //   3616: aload 4
    //   3618: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3621: ifeq +95 -> 3716
    //   3624: new 2968	bdpa
    //   3627: dup
    //   3628: aload_3
    //   3629: checkcast 2970	com/tencent/mobileqq/app/BaseActivity
    //   3632: aload_2
    //   3633: invokespecial 2973	bdpa:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3636: aload_3
    //   3637: invokevirtual 2975	bdpa:a	(Landroid/app/Activity;)V
    //   3640: goto -3456 -> 184
    //   3643: astore_1
    //   3644: ldc_w 484
    //   3647: astore_2
    //   3648: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3651: ifeq +22 -> 3673
    //   3654: ldc 209
    //   3656: iconst_2
    //   3657: ldc_w 2977
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
    //   3688: ldc_w 2979
    //   3691: aastore
    //   3692: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
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
    //   3716: ldc_w 2981
    //   3719: aload 4
    //   3721: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3724: ifeq -3540 -> 184
    //   3727: new 2983	bdqv
    //   3730: dup
    //   3731: aload_3
    //   3732: checkcast 2970	com/tencent/mobileqq/app/BaseActivity
    //   3735: aload_2
    //   3736: invokespecial 2984	bdqv:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/os/Bundle;)V
    //   3739: aload_3
    //   3740: invokevirtual 2985	bdqv:a	(Landroid/app/Activity;)V
    //   3743: goto -3559 -> 184
    //   3746: ldc_w 2957
    //   3749: aload 14
    //   3751: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3754: ifeq +331 -> 4085
    //   3757: new 129	android/content/Intent
    //   3760: dup
    //   3761: invokespecial 496	android/content/Intent:<init>	()V
    //   3764: astore 14
    //   3766: ldc_w 2987
    //   3769: aload 4
    //   3771: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3774: ifeq +119 -> 3893
    //   3777: aload 14
    //   3779: new 2989	android/content/ComponentName
    //   3782: dup
    //   3783: aload_0
    //   3784: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   3787: aload 4
    //   3789: invokespecial 2990	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3792: invokevirtual 2994	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3795: pop
    //   3796: aload 14
    //   3798: ldc_w 2996
    //   3801: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   3804: invokevirtual 608	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3807: pop
    //   3808: aload 14
    //   3810: ldc_w 421
    //   3813: aload_1
    //   3814: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3817: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3820: pop
    //   3821: aload_0
    //   3822: aload 5
    //   3824: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3827: aload 5
    //   3829: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3832: ifeq +208 -> 4040
    //   3835: aload_3
    //   3836: aload 14
    //   3838: invokevirtual 1528	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   3841: goto +13660 -> 17501
    //   3844: ldc_w 2998
    //   3847: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   3850: aload 4
    //   3852: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3855: ifeq -3671 -> 184
    //   3858: aload_0
    //   3859: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   3862: ifnonnull +17 -> 3879
    //   3865: aload_0
    //   3866: invokestatic 2044	zon:a	()Lzon;
    //   3869: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   3872: aload_0
    //   3873: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   3876: invokevirtual 2046	zon:a	()V
    //   3879: aload_0
    //   3880: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   3883: invokevirtual 3000	zon:c	()V
    //   3886: goto -3702 -> 184
    //   3889: astore_1
    //   3890: goto -242 -> 3648
    //   3893: ldc_w 3002
    //   3896: aload 4
    //   3898: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3901: ifeq +78 -> 3979
    //   3904: aload 14
    //   3906: new 2989	android/content/ComponentName
    //   3909: dup
    //   3910: aload_3
    //   3911: aload 4
    //   3913: invokespecial 2990	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   3916: invokevirtual 2994	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   3919: pop
    //   3920: aload 14
    //   3922: ldc_w 3004
    //   3925: iconst_0
    //   3926: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3929: pop
    //   3930: aload 14
    //   3932: ldc_w 304
    //   3935: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   3938: invokevirtual 608	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3941: pop
    //   3942: aload 14
    //   3944: getstatic 3008	bkrk:l	Ljava/lang/String;
    //   3947: iconst_1
    //   3948: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   3951: pop
    //   3952: aload 14
    //   3954: getstatic 3009	bkrk:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3957: ldc_w 2434
    //   3960: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3963: pop
    //   3964: aload 14
    //   3966: getstatic 3010	bkrk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3969: ldc_w 2831
    //   3972: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3975: pop
    //   3976: goto -168 -> 3808
    //   3979: ldc_w 3012
    //   3982: aload 4
    //   3984: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3987: ifeq +34 -> 4021
    //   3990: aload 14
    //   3992: new 2989	android/content/ComponentName
    //   3995: dup
    //   3996: aload_3
    //   3997: aload 4
    //   3999: invokespecial 2990	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4002: invokevirtual 2994	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4005: pop
    //   4006: aload 14
    //   4008: ldc_w 3014
    //   4011: ldc_w 2212
    //   4014: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4017: pop
    //   4018: goto -210 -> 3808
    //   4021: aload 14
    //   4023: new 2989	android/content/ComponentName
    //   4026: dup
    //   4027: aload_3
    //   4028: aload 4
    //   4030: invokespecial 2990	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4033: invokevirtual 2994	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4036: pop
    //   4037: goto -229 -> 3808
    //   4040: aload_0
    //   4041: aload 14
    //   4043: iconst_4
    //   4044: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4047: aload_2
    //   4048: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4051: ifne +13450 -> 17501
    //   4054: aload_0
    //   4055: aload_2
    //   4056: iconst_1
    //   4057: anewarray 285	java/lang/String
    //   4060: dup
    //   4061: iconst_0
    //   4062: ldc_w 1396
    //   4065: aastore
    //   4066: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4069: goto +13432 -> 17501
    //   4072: aload_3
    //   4073: ldc_w 3015
    //   4076: ldc_w 3016
    //   4079: invokevirtual 414	android/app/Activity:overridePendingTransition	(II)V
    //   4082: goto -238 -> 3844
    //   4085: ldc_w 3018
    //   4088: aload 14
    //   4090: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4093: ifeq -3909 -> 184
    //   4096: aload 4
    //   4098: ldc_w 3020
    //   4101: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4104: ifeq +102 -> 4206
    //   4107: aload_1
    //   4108: ldc_w 3022
    //   4111: iconst_0
    //   4112: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   4115: iconst_1
    //   4116: if_icmpne -3932 -> 184
    //   4119: aload_0
    //   4120: aload 5
    //   4122: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4125: aload_1
    //   4126: ldc 154
    //   4128: ldc_w 484
    //   4131: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4134: astore_2
    //   4135: aload_3
    //   4136: aload_0
    //   4137: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   4140: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   4143: aload_1
    //   4144: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4147: iconst_4
    //   4148: aload_2
    //   4149: invokestatic 3027	bdmy:a	(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;BLjava/lang/String;)Landroid/content/Intent;
    //   4152: astore_1
    //   4153: aload_1
    //   4154: ifnull +23 -> 4177
    //   4157: aload_0
    //   4158: invokevirtual 3029	com/tencent/mobileqq/jsp/UiApiPlugin:g	()V
    //   4161: aload_0
    //   4162: aload_1
    //   4163: iconst_4
    //   4164: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4167: aload_3
    //   4168: ldc_w 3015
    //   4171: ldc_w 3016
    //   4174: invokevirtual 414	android/app/Activity:overridePendingTransition	(II)V
    //   4177: ldc_w 484
    //   4180: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4183: ifne -3999 -> 184
    //   4186: aload_0
    //   4187: ldc_w 484
    //   4190: iconst_1
    //   4191: anewarray 285	java/lang/String
    //   4194: dup
    //   4195: iconst_0
    //   4196: ldc_w 1396
    //   4199: aastore
    //   4200: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4203: goto -4019 -> 184
    //   4206: aload 4
    //   4208: ldc_w 3031
    //   4211: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   4214: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4217: ifeq -4033 -> 184
    //   4220: new 129	android/content/Intent
    //   4223: dup
    //   4224: invokespecial 496	android/content/Intent:<init>	()V
    //   4227: astore 14
    //   4229: aload 14
    //   4231: new 2989	android/content/ComponentName
    //   4234: dup
    //   4235: aload_3
    //   4236: aload 4
    //   4238: invokespecial 2990	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   4241: invokevirtual 2994	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   4244: pop
    //   4245: aload 14
    //   4247: ldc_w 421
    //   4250: aload_1
    //   4251: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4254: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4257: pop
    //   4258: aload_0
    //   4259: aload 5
    //   4261: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   4264: aload_0
    //   4265: aload 14
    //   4267: iconst_4
    //   4268: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   4271: aload_2
    //   4272: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4275: ifne +13248 -> 17523
    //   4278: aload_0
    //   4279: aload_2
    //   4280: iconst_1
    //   4281: anewarray 285	java/lang/String
    //   4284: dup
    //   4285: iconst_0
    //   4286: ldc_w 1396
    //   4289: aastore
    //   4290: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4293: goto +13230 -> 17523
    //   4296: aload_3
    //   4297: ldc_w 3015
    //   4300: ldc_w 3016
    //   4303: invokevirtual 414	android/app/Activity:overridePendingTransition	(II)V
    //   4306: goto -4122 -> 184
    //   4309: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4312: ifeq -4128 -> 184
    //   4315: ldc 209
    //   4317: iconst_2
    //   4318: ldc_w 3033
    //   4321: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4324: goto -4140 -> 184
    //   4327: ldc_w 3035
    //   4330: aload 4
    //   4332: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   4358: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   4361: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   4364: astore 4
    //   4366: aload 4
    //   4368: instanceof 388
    //   4371: ifne +5 -> 4376
    //   4374: iconst_1
    //   4375: ireturn
    //   4376: aload_0
    //   4377: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   4380: invokevirtual 1875	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4383: astore_3
    //   4384: aload_3
    //   4385: ifnonnull +5 -> 4390
    //   4388: iconst_1
    //   4389: ireturn
    //   4390: aload_2
    //   4391: ldc_w 3037
    //   4394: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4397: ifeq +103 -> 4500
    //   4400: aload_2
    //   4401: ldc_w 3039
    //   4404: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4407: ifeq +93 -> 4500
    //   4410: aload_2
    //   4411: ldc_w 3039
    //   4414: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   4417: ifeq +83 -> 4500
    //   4420: aload_2
    //   4421: ldc_w 3037
    //   4424: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   4427: istore 6
    //   4429: aload_0
    //   4430: iconst_2
    //   4431: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   4434: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   4437: astore_1
    //   4438: aload_1
    //   4439: ifnull +25 -> 4464
    //   4442: aload_1
    //   4443: getfield 3044	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mBrowserTips	Landroid/view/View;
    //   4446: ifnull +18 -> 4464
    //   4449: aload_1
    //   4450: iload 6
    //   4452: putfield 3047	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mBrowserTipsColor	I
    //   4455: aload_1
    //   4456: getfield 3044	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mBrowserTips	Landroid/view/View;
    //   4459: iload 6
    //   4461: invokevirtual 3048	android/view/View:setBackgroundColor	(I)V
    //   4464: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4467: ifeq +33 -> 4500
    //   4470: ldc 209
    //   4472: iconst_2
    //   4473: new 551	java/lang/StringBuilder
    //   4476: dup
    //   4477: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   4480: ldc_w 3050
    //   4483: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4486: iload 6
    //   4488: invokestatic 3053	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   4491: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4494: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4497: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4500: aload_2
    //   4501: ldc_w 3055
    //   4504: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4507: ifeq +71 -> 4578
    //   4510: aload_2
    //   4511: ldc_w 3055
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
    //   4542: new 551	java/lang/StringBuilder
    //   4545: dup
    //   4546: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   4549: ldc_w 3057
    //   4552: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4555: iload 12
    //   4557: invokevirtual 1128	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4560: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4563: invokestatic 884	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4566: aload_1
    //   4567: ifnull +11 -> 4578
    //   4570: aload_1
    //   4571: getfield 3061	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mProgressBarController	Lbhkb;
    //   4574: iconst_0
    //   4575: invokevirtual 3064	bhkb:a	(Z)V
    //   4578: aload_2
    //   4579: ldc_w 3066
    //   4582: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4585: ifeq +72 -> 4657
    //   4588: aload_2
    //   4589: ldc_w 3066
    //   4592: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4595: istore 6
    //   4597: aload 4
    //   4599: ldc_w 2607
    //   4602: invokevirtual 1475	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4605: checkcast 832	android/widget/TextView
    //   4608: astore_1
    //   4609: aload 4
    //   4611: ldc_w 3067
    //   4614: invokevirtual 1475	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   4617: checkcast 976	android/widget/ImageView
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
    //   4648: invokevirtual 1017	android/widget/ImageView:setVisibility	(I)V
    //   4651: aload_1
    //   4652: bipush 8
    //   4654: invokevirtual 3068	android/widget/TextView:setVisibility	(I)V
    //   4657: aload_2
    //   4658: ldc_w 3070
    //   4661: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4664: ifeq +23 -> 4687
    //   4667: aload_2
    //   4668: ldc_w 3070
    //   4671: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4674: iconst_1
    //   4675: if_icmpne +12872 -> 17547
    //   4678: iconst_1
    //   4679: istore 12
    //   4681: aload_3
    //   4682: iload 12
    //   4684: invokevirtual 3073	com/tencent/mobileqq/webview/swift/WebViewFragment:enableSwipeBackForJS	(Z)V
    //   4687: aload_2
    //   4688: ldc_w 3075
    //   4691: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4694: ifeq +129 -> 4823
    //   4697: aload_2
    //   4698: ldc_w 3077
    //   4701: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4704: ifeq +119 -> 4823
    //   4707: aload_2
    //   4708: ldc_w 3079
    //   4711: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4714: ifeq +109 -> 4823
    //   4717: aload_2
    //   4718: ldc_w 3081
    //   4721: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4724: ifeq +99 -> 4823
    //   4727: aload_2
    //   4728: ldc_w 3083
    //   4731: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4734: ifeq +89 -> 4823
    //   4737: aload_2
    //   4738: ldc_w 3075
    //   4741: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4744: astore_1
    //   4745: aload_2
    //   4746: ldc_w 3077
    //   4749: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4752: istore 6
    //   4754: aload_2
    //   4755: ldc_w 3079
    //   4758: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4761: istore 7
    //   4763: aload_2
    //   4764: ldc_w 3081
    //   4767: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4770: istore 8
    //   4772: aload_2
    //   4773: ldc_w 3083
    //   4776: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4779: istore 9
    //   4781: aload_3
    //   4782: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4785: ifnull +38 -> 4823
    //   4788: aload_3
    //   4789: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4792: getfield 3091	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4795: instanceof 1962
    //   4798: ifeq +25 -> 4823
    //   4801: aload_3
    //   4802: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4805: getfield 3091	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4808: checkcast 1962	com/tencent/biz/ui/RefreshView
    //   4811: aload_1
    //   4812: iload 6
    //   4814: iload 7
    //   4816: iload 8
    //   4818: iload 9
    //   4820: invokevirtual 3094	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;IIII)V
    //   4823: aload_2
    //   4824: ldc_w 3096
    //   4827: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4830: ifeq +45 -> 4875
    //   4833: aload_2
    //   4834: ldc_w 3096
    //   4837: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4840: astore_1
    //   4841: aload_3
    //   4842: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4845: ifnull +30 -> 4875
    //   4848: aload_3
    //   4849: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4852: getfield 3091	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4855: instanceof 1962
    //   4858: ifeq +17 -> 4875
    //   4861: aload_3
    //   4862: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   4865: getfield 3091	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:webviewWrapper	Landroid/view/ViewGroup;
    //   4868: checkcast 1962	com/tencent/biz/ui/RefreshView
    //   4871: aload_1
    //   4872: invokevirtual 3097	com/tencent/biz/ui/RefreshView:a	(Ljava/lang/String;)V
    //   4875: aload_3
    //   4876: invokevirtual 3099	com/tencent/mobileqq/webview/swift/WebViewFragment:isFullScreen	()Z
    //   4879: ifne +146 -> 5025
    //   4882: aload_2
    //   4883: ldc_w 3101
    //   4886: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4889: ifeq +136 -> 5025
    //   4892: aload_2
    //   4893: ldc_w 3101
    //   4896: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
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
    //   4919: invokevirtual 3103	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbgzp;
    //   4922: ifnull +832 -> 5754
    //   4925: aload_0
    //   4926: invokevirtual 3103	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbgzp;
    //   4929: invokeinterface 3106 1 0
    //   4934: astore_1
    //   4935: iload 7
    //   4937: iconst_m1
    //   4938: if_icmpne +916 -> 5854
    //   4941: aload 5
    //   4943: invokevirtual 3109	android/view/View:getPaddingTop	()I
    //   4946: istore 6
    //   4948: aload 5
    //   4950: invokevirtual 3112	android/view/View:getPaddingBottom	()I
    //   4953: istore 7
    //   4955: aload 5
    //   4957: invokevirtual 3115	android/view/View:getPaddingLeft	()I
    //   4960: istore 8
    //   4962: aload 5
    //   4964: invokevirtual 3118	android/view/View:getPaddingRight	()I
    //   4967: istore 9
    //   4969: aload 5
    //   4971: ldc_w 3119
    //   4974: invokevirtual 3120	android/view/View:setBackgroundResource	(I)V
    //   4977: aload 5
    //   4979: iload 8
    //   4981: iload 6
    //   4983: iload 9
    //   4985: iload 7
    //   4987: invokevirtual 3123	android/view/View:setPadding	(IIII)V
    //   4990: aload_1
    //   4991: ifnull +7 -> 4998
    //   4994: aload_1
    //   4995: invokevirtual 3126	com/tencent/mobileqq/widget/WebViewProgressBar:a	()V
    //   4998: aload_3
    //   4999: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5002: ifnull +23 -> 5025
    //   5005: aload_3
    //   5006: invokevirtual 3131	com/tencent/mobileqq/webview/swift/WebViewFragment:isTransparentTitle	()Z
    //   5009: ifeq +769 -> 5778
    //   5012: aload_3
    //   5013: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5016: iconst_4
    //   5017: invokevirtual 1889	android/view/View:setVisibility	(I)V
    //   5020: aload_3
    //   5021: iconst_0
    //   5022: invokevirtual 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:setUsingCustomTitleBarColor	(Z)V
    //   5025: aload_2
    //   5026: ldc_w 1756
    //   5029: iconst_m1
    //   5030: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
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
    //   5062: if_icmpne +12491 -> 17553
    //   5065: iconst_1
    //   5066: istore 12
    //   5068: aload 5
    //   5070: iload 12
    //   5072: putfield 1771	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isShowDefaultThemeIcon	Z
    //   5075: aload_0
    //   5076: getfield 2521	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5079: ifeq +23 -> 5102
    //   5082: aload_1
    //   5083: aload_1
    //   5084: getfield 3135	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbgtw;
    //   5087: getfield 2510	bgtw:rightViewImg	Landroid/widget/ImageView;
    //   5090: iconst_0
    //   5091: aload_0
    //   5092: getfield 2521	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5095: aload_0
    //   5096: getfield 2521	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_e_of_type_Int	I
    //   5099: invokevirtual 2525	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setDefaultThemeIcon	(Landroid/view/View;ZII)V
    //   5102: aload_0
    //   5103: getfield 2540	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5106: ifeq +20 -> 5126
    //   5109: aload_1
    //   5110: aload_0
    //   5111: getfield 1456	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   5114: iconst_0
    //   5115: aload_0
    //   5116: getfield 2540	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5119: aload_0
    //   5120: getfield 2540	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_d_of_type_Int	I
    //   5123: invokevirtual 2525	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setDefaultThemeIcon	(Landroid/view/View;ZII)V
    //   5126: aload_1
    //   5127: aload_1
    //   5128: getfield 3135	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbgtw;
    //   5131: getfield 2461	bgtw:leftView	Landroid/widget/TextView;
    //   5134: iconst_1
    //   5135: ldc_w 3136
    //   5138: ldc_w 3137
    //   5141: invokevirtual 2525	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setDefaultThemeIcon	(Landroid/view/View;ZII)V
    //   5144: aload_2
    //   5145: ldc_w 3139
    //   5148: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5151: ifeq +22 -> 5173
    //   5154: aload_2
    //   5155: ldc_w 3139
    //   5158: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   5161: istore 6
    //   5163: iload 6
    //   5165: iconst_m1
    //   5166: if_icmpne +939 -> 6105
    //   5169: aload_3
    //   5170: invokevirtual 3142	com/tencent/mobileqq/webview/swift/WebViewFragment:resetTitleBarTextColor	()V
    //   5173: aload_2
    //   5174: ldc_w 3144
    //   5177: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5180: ifeq +14 -> 5194
    //   5183: aload_3
    //   5184: aload_2
    //   5185: ldc_w 3144
    //   5188: invokevirtual 3147	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5191: invokevirtual 3150	com/tencent/mobileqq/webview/swift/WebViewFragment:setBottomBarVisible	(Z)V
    //   5194: aload_2
    //   5195: ldc_w 3152
    //   5198: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5201: ifeq +25 -> 5226
    //   5204: aload_2
    //   5205: ldc_w 3152
    //   5208: invokevirtual 3147	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   5211: ifeq +952 -> 6163
    //   5214: aload_3
    //   5215: aload_3
    //   5216: invokevirtual 3153	com/tencent/mobileqq/webview/swift/WebViewFragment:getRulesFromUrl	()J
    //   5219: ldc2_w 3154
    //   5222: land
    //   5223: invokevirtual 3158	com/tencent/mobileqq/webview/swift/WebViewFragment:setRulesFromUrl	(J)V
    //   5226: aload_2
    //   5227: ldc_w 3160
    //   5230: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5233: ifeq +22 -> 5255
    //   5236: aload_2
    //   5237: ldc_w 3160
    //   5240: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5243: astore 5
    //   5245: aload 4
    //   5247: checkcast 388	com/tencent/mobileqq/activity/QQBrowserActivity
    //   5250: aload 5
    //   5252: invokevirtual 3162	com/tencent/mobileqq/activity/QQBrowserActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   5255: aload_2
    //   5256: ldc_w 3164
    //   5259: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5262: ifeq +49 -> 5311
    //   5265: aload_2
    //   5266: ldc_w 3164
    //   5269: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   5272: istore 12
    //   5274: sipush 800
    //   5277: istore 6
    //   5279: aload_2
    //   5280: ldc_w 3166
    //   5283: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5286: ifeq +17 -> 5303
    //   5289: aload_2
    //   5290: ldc_w 3166
    //   5293: invokevirtual 3170	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   5296: ldc2_w 3171
    //   5299: dmul
    //   5300: d2i
    //   5301: istore 6
    //   5303: aload_0
    //   5304: iload 12
    //   5306: iload 6
    //   5308: invokevirtual 3174	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZI)V
    //   5311: aload_2
    //   5312: ldc_w 3176
    //   5315: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5318: ifeq +44 -> 5362
    //   5321: aload_2
    //   5322: ldc_w 3176
    //   5325: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5328: istore 6
    //   5330: aload_1
    //   5331: ifnull +31 -> 5362
    //   5334: iload 6
    //   5336: ifne +842 -> 6178
    //   5339: aload_1
    //   5340: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5343: iconst_0
    //   5344: putfield 3179	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isScreenLandscape	Z
    //   5347: aload_1
    //   5348: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5351: iconst_1
    //   5352: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   5355: putfield 3183	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:mIsPortraitOnly	Ljava/lang/Boolean;
    //   5358: aload_1
    //   5359: invokevirtual 3186	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:updateScreenOrientation	()V
    //   5362: aload_2
    //   5363: ldc_w 3188
    //   5366: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5369: ifeq +26 -> 5395
    //   5372: aload_2
    //   5373: ldc_w 3188
    //   5376: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5379: istore 6
    //   5381: aload_1
    //   5382: ifnull +13 -> 5395
    //   5385: iload 6
    //   5387: iconst_1
    //   5388: if_icmpne +7 -> 5395
    //   5391: aload_1
    //   5392: invokevirtual 3191	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:restoreOrientationFollowSenSor	()V
    //   5395: aload_2
    //   5396: ldc_w 3193
    //   5399: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5402: ifeq +18 -> 5420
    //   5405: aload_2
    //   5406: ldc_w 3193
    //   5409: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5412: iconst_1
    //   5413: if_icmpne +7 -> 5420
    //   5416: aload_1
    //   5417: invokevirtual 3196	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:supportOrientationFollowSenSor	()V
    //   5420: aload_2
    //   5421: ldc_w 3198
    //   5424: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5427: ifeq +63 -> 5490
    //   5430: aload_2
    //   5431: ldc_w 3198
    //   5434: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5437: istore 6
    //   5439: aload_0
    //   5440: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   5443: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   5446: astore 5
    //   5448: aload 5
    //   5450: ifnull +40 -> 5490
    //   5453: aload 5
    //   5455: instanceof 524
    //   5458: ifeq +32 -> 5490
    //   5461: aload 4
    //   5463: checkcast 524	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   5466: invokevirtual 3199	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   5469: checkcast 3201	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   5472: astore 4
    //   5474: aload 4
    //   5476: ifnull +14 -> 5490
    //   5479: iload 6
    //   5481: iconst_1
    //   5482: if_icmpne +724 -> 6206
    //   5485: aload 4
    //   5487: invokevirtual 3202	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:e	()V
    //   5490: aload_2
    //   5491: ldc_w 3204
    //   5494: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5497: ifeq +23 -> 5520
    //   5500: aload_2
    //   5501: ldc_w 3204
    //   5504: iconst_0
    //   5505: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5508: istore 12
    //   5510: aload_1
    //   5511: ifnull +9 -> 5520
    //   5514: aload_1
    //   5515: iload 12
    //   5517: invokevirtual 3207	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setFloatingShareVisible	(Z)V
    //   5520: aload_2
    //   5521: ldc_w 3209
    //   5524: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5527: ifeq +38 -> 5565
    //   5530: aload_2
    //   5531: ldc_w 3209
    //   5534: iconst_0
    //   5535: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5538: istore 12
    //   5540: aload_1
    //   5541: ifnull +24 -> 5565
    //   5544: aload_1
    //   5545: getfield 3135	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mSwiftTitleUI	Lbgtw;
    //   5548: getfield 3210	bgtw:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5551: getfield 3213	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:mShowRightCloseButton	Z
    //   5554: iload 12
    //   5556: if_icmpeq +9 -> 5565
    //   5559: aload_1
    //   5560: iload 12
    //   5562: invokevirtual 3216	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setRightCloseButtonVisible	(Z)V
    //   5565: aload_2
    //   5566: ldc_w 3218
    //   5569: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5572: ifeq -5388 -> 184
    //   5575: aload_1
    //   5576: ifnull -5392 -> 184
    //   5579: aload_2
    //   5580: ldc_w 3218
    //   5583: iconst_0
    //   5584: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   5587: ifeq +632 -> 6219
    //   5590: aload_3
    //   5591: invokevirtual 3099	com/tencent/mobileqq/webview/swift/WebViewFragment:isFullScreen	()Z
    //   5594: ifne -5410 -> 184
    //   5597: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5600: ifeq +12 -> 5612
    //   5603: ldc 209
    //   5605: iconst_4
    //   5606: ldc_w 3220
    //   5609: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5612: aload_1
    //   5613: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   5616: iconst_1
    //   5617: putfield 3222	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isFullScreen	Z
    //   5620: aload_0
    //   5621: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   5624: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   5627: invokevirtual 3226	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5630: sipush 1024
    //   5633: sipush 1024
    //   5636: invokevirtual 3230	android/view/Window:setFlags	(II)V
    //   5639: aload_3
    //   5640: invokevirtual 3233	com/tencent/mobileqq/webview/swift/WebViewFragment:hideVirtualNavBar	()V
    //   5643: aload_3
    //   5644: iconst_0
    //   5645: invokevirtual 3236	com/tencent/mobileqq/webview/swift/WebViewFragment:doShowTitleBar	(Z)V
    //   5648: goto -5464 -> 184
    //   5651: astore_1
    //   5652: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5655: ifeq -5471 -> 184
    //   5658: ldc 209
    //   5660: iconst_4
    //   5661: new 551	java/lang/StringBuilder
    //   5664: dup
    //   5665: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   5668: ldc_w 3238
    //   5671: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5674: aload_1
    //   5675: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5678: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5681: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5684: goto -5500 -> 184
    //   5687: aload 5
    //   5689: bipush 8
    //   5691: invokevirtual 1017	android/widget/ImageView:setVisibility	(I)V
    //   5694: aload_1
    //   5695: iconst_0
    //   5696: invokevirtual 3068	android/widget/TextView:setVisibility	(I)V
    //   5699: goto -1042 -> 4657
    //   5702: astore_1
    //   5703: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5706: ifeq -5522 -> 184
    //   5709: ldc 209
    //   5711: iconst_4
    //   5712: new 551	java/lang/StringBuilder
    //   5715: dup
    //   5716: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   5719: ldc_w 3238
    //   5722: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5725: aload_1
    //   5726: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5729: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5732: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5735: goto -5551 -> 184
    //   5738: aload_1
    //   5739: bipush 8
    //   5741: invokevirtual 3068	android/widget/TextView:setVisibility	(I)V
    //   5744: aload 5
    //   5746: bipush 8
    //   5748: invokevirtual 1017	android/widget/ImageView:setVisibility	(I)V
    //   5751: goto -1094 -> 4657
    //   5754: aload_0
    //   5755: iconst_2
    //   5756: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5759: checkcast 1762	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler
    //   5762: astore 14
    //   5764: aload 14
    //   5766: ifnull -831 -> 4935
    //   5769: aload 14
    //   5771: getfield 3242	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mLoadingProgressBar	Lcom/tencent/mobileqq/widget/WebViewProgressBar;
    //   5774: astore_1
    //   5775: goto -840 -> 4935
    //   5778: iconst_0
    //   5779: invokestatic 3246	com/tencent/mobileqq/theme/ThemeUtil:isDefaultOrDIYTheme	(Z)Z
    //   5782: ifeq +24 -> 5806
    //   5785: aload_3
    //   5786: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5789: ldc_w 3247
    //   5792: invokevirtual 3120	android/view/View:setBackgroundResource	(I)V
    //   5795: aload_3
    //   5796: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5799: iconst_0
    //   5800: invokevirtual 1889	android/view/View:setVisibility	(I)V
    //   5803: goto -783 -> 5020
    //   5806: aload_3
    //   5807: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5810: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5813: invokevirtual 3248	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5816: ldc_w 3249
    //   5819: invokevirtual 1863	android/content/res/Resources:getColor	(I)I
    //   5822: invokevirtual 3048	android/view/View:setBackgroundColor	(I)V
    //   5825: iconst_0
    //   5826: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5829: invokevirtual 3248	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   5832: ldc_w 3249
    //   5835: invokevirtual 1863	android/content/res/Resources:getColor	(I)I
    //   5838: aload_0
    //   5839: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   5842: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   5845: invokevirtual 3226	android/app/Activity:getWindow	()Landroid/view/Window;
    //   5848: invokestatic 3254	bbyp:a	(ZILandroid/view/Window;)V
    //   5851: goto -56 -> 5795
    //   5854: aload 5
    //   5856: iconst_0
    //   5857: invokevirtual 3120	android/view/View:setBackgroundResource	(I)V
    //   5860: ldc_w 1975
    //   5863: istore 6
    //   5865: aload_2
    //   5866: ldc_w 3256
    //   5869: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   5872: ifeq +15 -> 5887
    //   5875: aload_2
    //   5876: ldc_w 3256
    //   5879: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
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
    //   5903: new 551	java/lang/StringBuilder
    //   5906: dup
    //   5907: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   5910: ldc_w 3258
    //   5913: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5916: iload 6
    //   5918: invokestatic 3053	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5921: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5924: ldc_w 3260
    //   5927: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5930: iload 7
    //   5932: invokestatic 3053	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5935: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5938: ldc_w 3262
    //   5941: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5944: iload 8
    //   5946: invokestatic 3053	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   5949: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5952: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5955: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5958: aload 5
    //   5960: iload 8
    //   5962: invokevirtual 3048	android/view/View:setBackgroundColor	(I)V
    //   5965: aload_1
    //   5966: ifnull +13 -> 5979
    //   5969: aload_1
    //   5970: ldc_w 1975
    //   5973: iload 7
    //   5975: ior
    //   5976: invokevirtual 3265	com/tencent/mobileqq/widget/WebViewProgressBar:setCustomColor	(I)V
    //   5979: aload_3
    //   5980: invokevirtual 3131	com/tencent/mobileqq/webview/swift/WebViewFragment:isTransparentTitle	()Z
    //   5983: ifeq +24 -> 6007
    //   5986: aload_3
    //   5987: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   5990: ifnonnull +71 -> 6061
    //   5993: aload_3
    //   5994: iconst_1
    //   5995: invokevirtual 3268	com/tencent/mobileqq/webview/swift/WebViewFragment:setNeedStatusTrans	(Z)V
    //   5998: aload_3
    //   5999: iconst_1
    //   6000: invokevirtual 3271	com/tencent/mobileqq/webview/swift/WebViewFragment:setActNeedImmersive	(Z)V
    //   6003: aload_3
    //   6004: invokevirtual 3274	com/tencent/mobileqq/webview/swift/WebViewFragment:setImmersiveStatus	()V
    //   6007: aload_3
    //   6008: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6011: ifnull -986 -> 5025
    //   6014: aload_2
    //   6015: ldc_w 3276
    //   6018: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6021: ifeq +51 -> 6072
    //   6024: aload_2
    //   6025: ldc_w 3276
    //   6028: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6031: istore 6
    //   6033: aload_3
    //   6034: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6037: iload 6
    //   6039: invokevirtual 3048	android/view/View:setBackgroundColor	(I)V
    //   6042: iconst_1
    //   6043: iload 6
    //   6045: aload_0
    //   6046: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6049: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   6052: invokevirtual 3226	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6055: invokestatic 3254	bbyp:a	(ZILandroid/view/Window;)V
    //   6058: goto -1033 -> 5025
    //   6061: aload_3
    //   6062: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6065: iconst_0
    //   6066: invokevirtual 1889	android/view/View:setVisibility	(I)V
    //   6069: goto -62 -> 6007
    //   6072: aload_3
    //   6073: getfield 3129	com/tencent/mobileqq/webview/swift/WebViewFragment:mSystemBarComp	Landroid/view/View;
    //   6076: iload 8
    //   6078: invokevirtual 3048	android/view/View:setBackgroundColor	(I)V
    //   6081: iconst_1
    //   6082: iload 8
    //   6084: aload_0
    //   6085: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6088: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   6091: invokevirtual 3226	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6094: invokestatic 3254	bbyp:a	(ZILandroid/view/Window;)V
    //   6097: aload_3
    //   6098: iconst_1
    //   6099: invokevirtual 3134	com/tencent/mobileqq/webview/swift/WebViewFragment:setUsingCustomTitleBarColor	(Z)V
    //   6102: goto -1077 -> 5025
    //   6105: aload_3
    //   6106: ldc_w 1975
    //   6109: iload 6
    //   6111: ior
    //   6112: invokevirtual 3279	com/tencent/mobileqq/webview/swift/WebViewFragment:setTitleBarTextColor	(I)V
    //   6115: aload_2
    //   6116: ldc_w 3281
    //   6119: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6122: ifeq +11437 -> 17559
    //   6125: aload_2
    //   6126: ldc_w 3281
    //   6129: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6132: istore 7
    //   6134: iload 7
    //   6136: iconst_m1
    //   6137: if_icmpeq +11422 -> 17559
    //   6140: ldc_w 1975
    //   6143: iload 7
    //   6145: ior
    //   6146: istore 6
    //   6148: aload_3
    //   6149: iload 6
    //   6151: invokevirtual 3284	com/tencent/mobileqq/webview/swift/WebViewFragment:setTitleBarButtonColor	(I)V
    //   6154: aload_0
    //   6155: iload 6
    //   6157: invokevirtual 3286	com/tencent/mobileqq/jsp/UiApiPlugin:a	(I)V
    //   6160: goto -987 -> 5173
    //   6163: aload_3
    //   6164: aload_3
    //   6165: invokevirtual 3153	com/tencent/mobileqq/webview/swift/WebViewFragment:getRulesFromUrl	()J
    //   6168: ldc2_w 2615
    //   6171: lor
    //   6172: invokevirtual 3158	com/tencent/mobileqq/webview/swift/WebViewFragment:setRulesFromUrl	(J)V
    //   6175: goto -949 -> 5226
    //   6178: iload 6
    //   6180: iconst_1
    //   6181: if_icmpne -823 -> 5358
    //   6184: aload_1
    //   6185: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6188: iconst_1
    //   6189: putfield 3179	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isScreenLandscape	Z
    //   6192: aload_1
    //   6193: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6196: iconst_0
    //   6197: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   6200: putfield 3183	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:mIsPortraitOnly	Ljava/lang/Boolean;
    //   6203: goto -845 -> 5358
    //   6206: iload 6
    //   6208: ifne -718 -> 5490
    //   6211: aload 4
    //   6213: invokevirtual 3288	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:f	()V
    //   6216: goto -726 -> 5490
    //   6219: aload_3
    //   6220: invokevirtual 3099	com/tencent/mobileqq/webview/swift/WebViewFragment:isFullScreen	()Z
    //   6223: ifeq -6039 -> 184
    //   6226: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6229: ifeq +12 -> 6241
    //   6232: ldc 209
    //   6234: iconst_4
    //   6235: ldc_w 3290
    //   6238: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6241: aload_1
    //   6242: getfield 1766	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   6245: iconst_0
    //   6246: putfield 3222	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isFullScreen	Z
    //   6249: aload_0
    //   6250: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6253: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   6256: invokevirtual 3226	android/app/Activity:getWindow	()Landroid/view/Window;
    //   6259: sipush 1024
    //   6262: invokevirtual 3293	android/view/Window:clearFlags	(I)V
    //   6265: aload_3
    //   6266: invokevirtual 3296	com/tencent/mobileqq/webview/swift/WebViewFragment:showVirtualNavBar	()V
    //   6269: aload_3
    //   6270: iconst_1
    //   6271: invokevirtual 3236	com/tencent/mobileqq/webview/swift/WebViewFragment:doShowTitleBar	(Z)V
    //   6274: goto -6090 -> 184
    //   6277: ldc_w 3298
    //   6280: aload 4
    //   6282: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   6308: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6311: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   6314: instanceof 388
    //   6317: ifne +5 -> 6322
    //   6320: iconst_1
    //   6321: ireturn
    //   6322: new 3300	aacp
    //   6325: dup
    //   6326: invokespecial 3301	aacp:<init>	()V
    //   6329: astore_2
    //   6330: aload_1
    //   6331: ldc_w 3303
    //   6334: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6337: ifeq +18 -> 6355
    //   6340: aload_2
    //   6341: aload_1
    //   6342: ldc_w 3303
    //   6345: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6348: ldc_w 1975
    //   6351: ior
    //   6352: putfield 3304	aacp:jdField_a_of_type_Int	I
    //   6355: aload_1
    //   6356: ldc_w 811
    //   6359: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6362: ifeq +14 -> 6376
    //   6365: aload_2
    //   6366: aload_1
    //   6367: ldc_w 811
    //   6370: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6373: putfield 3305	aacp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6376: aload_1
    //   6377: ldc_w 3307
    //   6380: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6383: ifeq +176 -> 6559
    //   6386: aload_2
    //   6387: new 1819	java/util/ArrayList
    //   6390: dup
    //   6391: invokespecial 2220	java/util/ArrayList:<init>	()V
    //   6394: putfield 3310	aacp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6397: aload_1
    //   6398: ldc_w 3307
    //   6401: invokevirtual 1078	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   6424: invokevirtual 3313	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6427: astore 4
    //   6429: new 3315	aaco
    //   6432: dup
    //   6433: invokespecial 3316	aaco:<init>	()V
    //   6436: astore 5
    //   6438: aload 4
    //   6440: ldc_w 801
    //   6443: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6446: ifeq +16 -> 6462
    //   6449: aload 5
    //   6451: aload 4
    //   6453: ldc_w 801
    //   6456: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6459: putfield 3317	aaco:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6462: aload 4
    //   6464: ldc_w 2277
    //   6467: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6470: ifeq +16 -> 6486
    //   6473: aload 5
    //   6475: aload 4
    //   6477: ldc_w 2277
    //   6480: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6483: putfield 3318	aaco:jdField_a_of_type_Int	I
    //   6486: aload 4
    //   6488: ldc_w 3320
    //   6491: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6494: ifeq +16 -> 6510
    //   6497: aload 5
    //   6499: aload 4
    //   6501: ldc_w 3320
    //   6504: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6507: putfield 3321	aaco:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6510: aload 4
    //   6512: ldc_w 1803
    //   6515: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6518: ifeq +20 -> 6538
    //   6521: aload 5
    //   6523: aload 4
    //   6525: ldc_w 1803
    //   6528: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   6531: ldc_w 1975
    //   6534: ior
    //   6535: putfield 3322	aaco:jdField_b_of_type_Int	I
    //   6538: aload_2
    //   6539: getfield 3310	aacp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6542: aload 5
    //   6544: invokeinterface 2322 2 0
    //   6549: pop
    //   6550: iload 6
    //   6552: iconst_1
    //   6553: iadd
    //   6554: istore 6
    //   6556: goto -142 -> 6414
    //   6559: aload_1
    //   6560: ldc_w 3324
    //   6563: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6566: ifeq +78 -> 6644
    //   6569: aload_2
    //   6570: new 1819	java/util/ArrayList
    //   6573: dup
    //   6574: invokespecial 2220	java/util/ArrayList:<init>	()V
    //   6577: putfield 3326	aacp:b	Ljava/util/List;
    //   6580: aload_1
    //   6581: ldc_w 3324
    //   6584: invokevirtual 1078	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
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
    //   6607: invokevirtual 3313	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6610: ldc 160
    //   6612: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6615: ifeq +10955 -> 17570
    //   6618: aload_1
    //   6619: iload 6
    //   6621: invokevirtual 3313	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6624: ldc 160
    //   6626: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   6629: astore_3
    //   6630: aload_2
    //   6631: getfield 3326	aacp:b	Ljava/util/List;
    //   6634: aload_3
    //   6635: invokeinterface 2322 2 0
    //   6640: pop
    //   6641: goto +10929 -> 17570
    //   6644: aload_0
    //   6645: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6648: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6651: astore_1
    //   6652: aload_1
    //   6653: ifnull +10825 -> 17478
    //   6656: aload_1
    //   6657: invokevirtual 2403	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6660: astore_1
    //   6661: aload_1
    //   6662: ifnull +10816 -> 17478
    //   6665: aload_1
    //   6666: ldc_w 3328
    //   6669: invokevirtual 3331	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6672: astore_1
    //   6673: aload_1
    //   6674: ifnull +10804 -> 17478
    //   6677: aload_1
    //   6678: instanceof 184
    //   6681: ifeq +10797 -> 17478
    //   6684: aload_1
    //   6685: checkcast 184	aach
    //   6688: astore_1
    //   6689: aload_1
    //   6690: ifnull -6506 -> 184
    //   6693: aload_1
    //   6694: aload_2
    //   6695: invokevirtual 3334	aach:a	(Laacp;)V
    //   6698: aload_2
    //   6699: getfield 3305	aacp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6702: ifnull -6518 -> 184
    //   6705: aload_1
    //   6706: invokestatic 3336	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Laach;)Ljava/lang/String;
    //   6709: astore_1
    //   6710: aload_1
    //   6711: ifnull -6527 -> 184
    //   6714: aload_0
    //   6715: aload_2
    //   6716: getfield 3305	aacp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6719: iconst_1
    //   6720: anewarray 285	java/lang/String
    //   6723: dup
    //   6724: iconst_0
    //   6725: aload_1
    //   6726: aastore
    //   6727: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   6730: goto -6546 -> 184
    //   6733: astore_1
    //   6734: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6737: ifeq -6553 -> 184
    //   6740: ldc 209
    //   6742: iconst_4
    //   6743: new 551	java/lang/StringBuilder
    //   6746: dup
    //   6747: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   6750: ldc_w 3338
    //   6753: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6756: aload_1
    //   6757: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6760: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6763: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6766: goto -6582 -> 184
    //   6769: ldc_w 3340
    //   6772: aload 4
    //   6774: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   6800: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6803: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   6806: instanceof 388
    //   6809: ifne +5 -> 6814
    //   6812: iconst_1
    //   6813: ireturn
    //   6814: aload_1
    //   6815: ldc_w 3341
    //   6818: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6821: ifeq -6637 -> 184
    //   6824: aload_1
    //   6825: ldc_w 3341
    //   6828: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   6831: istore 12
    //   6833: aload_1
    //   6834: ldc_w 3343
    //   6837: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   6840: ifeq +10632 -> 17472
    //   6843: aload_1
    //   6844: ldc_w 3343
    //   6847: invokevirtual 3170	org/json/JSONObject:optDouble	(Ljava/lang/String;)D
    //   6850: ldc2_w 3171
    //   6853: dmul
    //   6854: d2i
    //   6855: istore 6
    //   6857: aload_0
    //   6858: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6861: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   6864: astore_1
    //   6865: aload_1
    //   6866: ifnull +10601 -> 17467
    //   6869: aload_1
    //   6870: invokevirtual 2403	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   6873: astore_1
    //   6874: aload_1
    //   6875: ifnull +10592 -> 17467
    //   6878: aload_1
    //   6879: ldc_w 3328
    //   6882: invokevirtual 3331	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   6885: astore_1
    //   6886: aload_1
    //   6887: ifnull +10580 -> 17467
    //   6890: aload_1
    //   6891: instanceof 184
    //   6894: ifeq +10573 -> 17467
    //   6897: aload_1
    //   6898: checkcast 184	aach
    //   6901: astore_1
    //   6902: aload_1
    //   6903: ifnull -6719 -> 184
    //   6906: aload_1
    //   6907: iload 12
    //   6909: iload 6
    //   6911: invokevirtual 3344	aach:a	(ZI)V
    //   6914: goto -6730 -> 184
    //   6917: astore_1
    //   6918: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6921: ifeq -6737 -> 184
    //   6924: ldc 209
    //   6926: iconst_4
    //   6927: new 551	java/lang/StringBuilder
    //   6930: dup
    //   6931: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   6934: ldc_w 3346
    //   6937: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6940: aload_1
    //   6941: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6944: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6947: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6950: goto -6766 -> 184
    //   6953: ldc_w 3348
    //   6956: aload 4
    //   6958: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   6984: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   6987: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   6990: instanceof 388
    //   6993: ifne +5 -> 6998
    //   6996: iconst_1
    //   6997: ireturn
    //   6998: new 3315	aaco
    //   7001: dup
    //   7002: invokespecial 3316	aaco:<init>	()V
    //   7005: astore_2
    //   7006: aload_1
    //   7007: ldc_w 801
    //   7010: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7013: ifeq +14 -> 7027
    //   7016: aload_2
    //   7017: aload_1
    //   7018: ldc_w 801
    //   7021: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7024: putfield 3317	aaco:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7027: aload_1
    //   7028: ldc_w 2277
    //   7031: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7034: ifeq +14 -> 7048
    //   7037: aload_2
    //   7038: aload_1
    //   7039: ldc_w 2277
    //   7042: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7045: putfield 3318	aaco:jdField_a_of_type_Int	I
    //   7048: aload_1
    //   7049: ldc_w 3320
    //   7052: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7055: ifeq +14 -> 7069
    //   7058: aload_2
    //   7059: aload_1
    //   7060: ldc_w 3320
    //   7063: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7066: putfield 3321	aaco:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7069: aload_1
    //   7070: ldc_w 1803
    //   7073: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   7076: ifeq +18 -> 7094
    //   7079: aload_2
    //   7080: aload_1
    //   7081: ldc_w 1803
    //   7084: invokestatic 3041	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;)I
    //   7087: ldc_w 1975
    //   7090: ior
    //   7091: putfield 3322	aaco:jdField_b_of_type_Int	I
    //   7094: aload_0
    //   7095: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7098: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   7101: astore_1
    //   7102: aload_1
    //   7103: ifnull +10359 -> 17462
    //   7106: aload_1
    //   7107: invokevirtual 2403	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   7110: astore_1
    //   7111: aload_1
    //   7112: ifnull +10350 -> 17462
    //   7115: aload_1
    //   7116: ldc_w 3328
    //   7119: invokevirtual 3331	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   7122: astore_1
    //   7123: aload_1
    //   7124: ifnull +10338 -> 17462
    //   7127: aload_1
    //   7128: instanceof 184
    //   7131: ifeq +10331 -> 17462
    //   7134: aload_1
    //   7135: checkcast 184	aach
    //   7138: astore_1
    //   7139: aload_1
    //   7140: ifnull -6956 -> 184
    //   7143: aload_1
    //   7144: aload_2
    //   7145: invokevirtual 3351	aach:a	(Laaco;)V
    //   7148: goto -6964 -> 184
    //   7151: astore_1
    //   7152: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7155: ifeq -6971 -> 184
    //   7158: ldc 209
    //   7160: iconst_4
    //   7161: new 551	java/lang/StringBuilder
    //   7164: dup
    //   7165: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   7168: ldc_w 3353
    //   7171: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7174: aload_1
    //   7175: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7178: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7181: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7184: goto -7000 -> 184
    //   7187: ldc_w 3355
    //   7190: aload 4
    //   7192: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   7223: ldc_w 3357
    //   7226: iconst_0
    //   7227: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7230: pop
    //   7231: aload_0
    //   7232: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7235: aload_0
    //   7236: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7239: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   7242: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   7245: astore_1
    //   7246: aload_1
    //   7247: ifnull -7063 -> 184
    //   7250: aload_1
    //   7251: instanceof 3359
    //   7254: ifeq -7070 -> 184
    //   7257: aload_1
    //   7258: checkcast 3359	bgzu
    //   7261: invokeinterface 3361 1 0
    //   7266: goto -7082 -> 184
    //   7269: astore_1
    //   7270: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7273: ifeq -7089 -> 184
    //   7276: ldc 209
    //   7278: iconst_4
    //   7279: new 551	java/lang/StringBuilder
    //   7282: dup
    //   7283: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   7286: ldc_w 3363
    //   7289: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: aload_1
    //   7293: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7296: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7299: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7302: goto -7118 -> 184
    //   7305: ldc_w 3365
    //   7308: aload 4
    //   7310: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   7340: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7343: istore 6
    //   7345: aload_1
    //   7346: ldc_w 1551
    //   7349: iconst_0
    //   7350: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
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
    //   7374: new 551	java/lang/StringBuilder
    //   7377: dup
    //   7378: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   7381: ldc_w 3367
    //   7384: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7387: aload_1
    //   7388: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   7391: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7394: ldc_w 3369
    //   7397: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7400: aload_0
    //   7401: getfield 98	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   7404: invokevirtual 1554	java/lang/Object:toString	()Ljava/lang/String;
    //   7407: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7410: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7413: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7416: invokestatic 621	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7419: new 129	android/content/Intent
    //   7422: dup
    //   7423: ldc_w 2563
    //   7426: invokespecial 134	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   7429: ldc_w 1544
    //   7432: iload 6
    //   7434: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7437: ldc_w 1546
    //   7440: iload 12
    //   7442: invokevirtual 605	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7445: ldc_w 1551
    //   7448: iload 7
    //   7450: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7453: ldc_w 1553
    //   7456: aload_0
    //   7457: getfield 1558	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Int	I
    //   7460: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7463: ldc_w 2565
    //   7466: invokevirtual 3374	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   7469: goto -7285 -> 184
    //   7472: astore_1
    //   7473: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7476: ifeq -7292 -> 184
    //   7479: ldc 209
    //   7481: iconst_4
    //   7482: new 551	java/lang/StringBuilder
    //   7485: dup
    //   7486: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   7489: ldc_w 3376
    //   7492: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7495: aload_1
    //   7496: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7499: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7502: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7505: goto -7321 -> 184
    //   7508: ldc_w 3378
    //   7511: aload 4
    //   7513: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7516: ifeq +258 -> 7774
    //   7519: aload 5
    //   7521: arraylength
    //   7522: iconst_1
    //   7523: if_icmpne +251 -> 7774
    //   7526: aload_0
    //   7527: aconst_null
    //   7528: putfield 3380	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7531: new 113	org/json/JSONObject
    //   7534: dup
    //   7535: aload 5
    //   7537: iconst_0
    //   7538: aaload
    //   7539: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7542: astore_3
    //   7543: aload_3
    //   7544: ldc_w 592
    //   7547: invokevirtual 2694	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   7550: lstore 10
    //   7552: aload_3
    //   7553: ldc_w 3382
    //   7556: bipush 13
    //   7558: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7561: istore 6
    //   7563: aload_3
    //   7564: ldc_w 3384
    //   7567: iconst_0
    //   7568: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7571: istore 7
    //   7573: aload_3
    //   7574: ldc_w 811
    //   7577: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7580: astore_1
    //   7581: aload_0
    //   7582: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7585: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   7588: astore_2
    //   7589: aload_2
    //   7590: ifnull +10 -> 7600
    //   7593: aload_2
    //   7594: invokevirtual 3387	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7597: ifne +20 -> 7617
    //   7600: aload_0
    //   7601: aload_1
    //   7602: iconst_1
    //   7603: anewarray 285	java/lang/String
    //   7606: dup
    //   7607: iconst_0
    //   7608: ldc_w 3389
    //   7611: aastore
    //   7612: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7615: iconst_1
    //   7616: ireturn
    //   7617: aload_3
    //   7618: ldc_w 2719
    //   7621: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7624: astore_3
    //   7625: aload_3
    //   7626: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7629: ifne +31 -> 7660
    //   7632: aload_3
    //   7633: aload_2
    //   7634: invokevirtual 1691	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   7637: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7640: ifne +20 -> 7660
    //   7643: aload_0
    //   7644: aload_1
    //   7645: iconst_1
    //   7646: anewarray 285	java/lang/String
    //   7649: dup
    //   7650: iconst_0
    //   7651: ldc_w 3391
    //   7654: aastore
    //   7655: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7658: iconst_1
    //   7659: ireturn
    //   7660: aload_0
    //   7661: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7664: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   7667: astore_2
    //   7668: aload_2
    //   7669: ifnull -7485 -> 184
    //   7672: aload_0
    //   7673: aload_1
    //   7674: putfield 3380	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   7677: new 129	android/content/Intent
    //   7680: dup
    //   7681: aload_2
    //   7682: ldc_w 3393
    //   7685: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7688: astore_1
    //   7689: aload_1
    //   7690: ldc_w 1575
    //   7693: bipush 16
    //   7695: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7698: pop
    //   7699: aload_1
    //   7700: ldc_w 3382
    //   7703: iload 6
    //   7705: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7708: pop
    //   7709: aload_1
    //   7710: ldc_w 592
    //   7713: lload 10
    //   7715: invokevirtual 608	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   7718: pop
    //   7719: aload_1
    //   7720: ldc_w 3384
    //   7723: iload 7
    //   7725: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7728: pop
    //   7729: aload_0
    //   7730: aload_1
    //   7731: iconst_5
    //   7732: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7735: goto -7551 -> 184
    //   7738: astore_1
    //   7739: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7742: ifeq -7558 -> 184
    //   7745: ldc 209
    //   7747: iconst_4
    //   7748: new 551	java/lang/StringBuilder
    //   7751: dup
    //   7752: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   7755: ldc_w 3395
    //   7758: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7761: aload_1
    //   7762: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7765: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7768: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7771: goto -7587 -> 184
    //   7774: ldc_w 3397
    //   7777: aload 4
    //   7779: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7782: ifeq +269 -> 8051
    //   7785: aload 5
    //   7787: arraylength
    //   7788: iconst_1
    //   7789: if_icmpne +262 -> 8051
    //   7792: aload_0
    //   7793: aconst_null
    //   7794: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7797: new 113	org/json/JSONObject
    //   7800: dup
    //   7801: aload 5
    //   7803: iconst_0
    //   7804: aaload
    //   7805: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   7808: astore_3
    //   7809: aload_0
    //   7810: aload_3
    //   7811: ldc_w 2719
    //   7814: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7817: putfield 3399	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7820: aload_3
    //   7821: ldc_w 3401
    //   7824: iconst_0
    //   7825: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7828: istore 6
    //   7830: aload_0
    //   7831: aload_3
    //   7832: ldc_w 3403
    //   7835: iconst_0
    //   7836: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   7839: putfield 3405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7842: aload_3
    //   7843: ldc_w 811
    //   7846: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7849: astore_1
    //   7850: aload_0
    //   7851: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7854: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   7857: astore_2
    //   7858: aload_2
    //   7859: ifnull +10 -> 7869
    //   7862: aload_2
    //   7863: invokevirtual 3387	com/tencent/common/app/AppInterface:isLogin	()Z
    //   7866: ifne +20 -> 7886
    //   7869: aload_0
    //   7870: aload_1
    //   7871: iconst_1
    //   7872: anewarray 285	java/lang/String
    //   7875: dup
    //   7876: iconst_0
    //   7877: ldc_w 3407
    //   7880: aastore
    //   7881: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   7884: iconst_1
    //   7885: ireturn
    //   7886: aload_0
    //   7887: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   7890: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   7893: astore_2
    //   7894: aload_2
    //   7895: ifnull -7711 -> 184
    //   7898: iload 6
    //   7900: ifne -7716 -> 184
    //   7903: aload_3
    //   7904: ldc_w 427
    //   7907: aload_2
    //   7908: ldc_w 3408
    //   7911: invokevirtual 858	android/app/Activity:getString	(I)Ljava/lang/String;
    //   7914: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7917: astore_3
    //   7918: aload_0
    //   7919: aload_1
    //   7920: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7923: aload_0
    //   7924: getfield 3405	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_b_of_type_Boolean	Z
    //   7927: ifeq +101 -> 8028
    //   7930: new 129	android/content/Intent
    //   7933: dup
    //   7934: aload_2
    //   7935: ldc_w 3410
    //   7938: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7941: astore_1
    //   7942: aload_1
    //   7943: ldc_w 3412
    //   7946: iconst_1
    //   7947: invokevirtual 605	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   7950: pop
    //   7951: aload_1
    //   7952: ldc_w 3414
    //   7955: aload_0
    //   7956: getfield 3399	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   7959: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7962: pop
    //   7963: aload_1
    //   7964: ldc_w 3416
    //   7967: aload_3
    //   7968: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7971: pop
    //   7972: aload_0
    //   7973: aload_1
    //   7974: bipush 7
    //   7976: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   7979: aload_2
    //   7980: ldc_w 3417
    //   7983: ldc_w 3418
    //   7986: invokevirtual 414	android/app/Activity:overridePendingTransition	(II)V
    //   7989: goto -7805 -> 184
    //   7992: astore_1
    //   7993: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   7996: ifeq -7812 -> 184
    //   7999: ldc 209
    //   8001: iconst_4
    //   8002: new 551	java/lang/StringBuilder
    //   8005: dup
    //   8006: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8009: ldc_w 3420
    //   8012: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8015: aload_1
    //   8016: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8019: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8022: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8025: goto -7841 -> 184
    //   8028: aload_2
    //   8029: aload_0
    //   8030: getfield 3399	com/tencent/mobileqq/jsp/UiApiPlugin:k	Ljava/lang/String;
    //   8033: bipush 14
    //   8035: invokestatic 2703	com/tencent/mobileqq/activity/TroopMemberListActivity:a	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/Intent;
    //   8038: astore_1
    //   8039: aload_1
    //   8040: ldc_w 3422
    //   8043: aload_3
    //   8044: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8047: pop
    //   8048: goto -76 -> 7972
    //   8051: ldc_w 3424
    //   8054: aload 4
    //   8056: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   8082: ldc_w 3426
    //   8085: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8088: ifeq -7904 -> 184
    //   8091: aload_1
    //   8092: ldc_w 3426
    //   8095: invokevirtual 3147	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8098: istore 12
    //   8100: aload_0
    //   8101: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   8104: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   8107: invokevirtual 3427	com/tencent/biz/pubaccount/CustomWebView:getParent	()Landroid/view/ViewParent;
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
    //   8143: invokevirtual 3428	com/tencent/biz/ui/RefreshView:a	(Z)V
    //   8146: goto -7962 -> 184
    //   8149: astore_1
    //   8150: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8153: ifeq -7969 -> 184
    //   8156: ldc 209
    //   8158: iconst_4
    //   8159: new 551	java/lang/StringBuilder
    //   8162: dup
    //   8163: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8166: ldc_w 3430
    //   8169: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8172: aload_1
    //   8173: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8176: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8179: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8182: goto -7998 -> 184
    //   8185: ldc_w 3432
    //   8188: aload 4
    //   8190: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   8230: new 551	java/lang/StringBuilder
    //   8233: dup
    //   8234: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8237: ldc_w 3434
    //   8240: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8243: aload 5
    //   8245: iconst_0
    //   8246: aaload
    //   8247: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8250: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   8281: ldc_w 427
    //   8284: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8287: astore 5
    //   8289: aload_3
    //   8290: astore_2
    //   8291: aload 4
    //   8293: astore_1
    //   8294: aload 15
    //   8296: ldc_w 3320
    //   8299: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8302: astore 14
    //   8304: aload_3
    //   8305: astore_2
    //   8306: aload 4
    //   8308: astore_1
    //   8309: aload 15
    //   8311: ldc_w 811
    //   8314: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8317: astore_3
    //   8318: iload 7
    //   8320: istore 6
    //   8322: aload_3
    //   8323: astore_2
    //   8324: aload_3
    //   8325: astore_1
    //   8326: aload 5
    //   8328: invokevirtual 3435	java/lang/String:length	()I
    //   8331: ifle +71 -> 8402
    //   8334: aload_3
    //   8335: astore_2
    //   8336: aload_3
    //   8337: astore_1
    //   8338: aload_0
    //   8339: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   8342: invokevirtual 1875	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   8345: astore 4
    //   8347: aload 4
    //   8349: ifnull +219 -> 8568
    //   8352: aload_3
    //   8353: astore_2
    //   8354: aload_3
    //   8355: astore_1
    //   8356: aload 4
    //   8358: getfield 3436	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8361: ifnull +207 -> 8568
    //   8364: aload_3
    //   8365: astore_2
    //   8366: aload_3
    //   8367: astore_1
    //   8368: aload 4
    //   8370: getfield 3436	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8373: getfield 3439	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isNeedSwitchAIOForH5Game	Z
    //   8376: ifeq +75 -> 8451
    //   8379: aload_3
    //   8380: astore_2
    //   8381: aload_3
    //   8382: astore_1
    //   8383: aload 4
    //   8385: aload 5
    //   8387: iconst_m1
    //   8388: aload 14
    //   8390: ldc_w 3441
    //   8393: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   8396: invokevirtual 3445	com/tencent/mobileqq/webview/swift/WebViewFragment:gotoConversationForH5SDK	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
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
    //   8417: new 551	java/lang/StringBuilder
    //   8420: dup
    //   8421: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8424: ldc_w 3447
    //   8427: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8430: iload 6
    //   8432: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8435: ldc_w 1801
    //   8438: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8441: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8444: aastore
    //   8445: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8448: goto -8264 -> 184
    //   8451: aload_3
    //   8452: astore_2
    //   8453: aload_3
    //   8454: astore_1
    //   8455: aload 4
    //   8457: getfield 3436	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyle	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    //   8460: getfield 3450	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler$SwiftBrowserUIStyle:isNeedSwitchAIO	Z
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
    //   8485: ldc_w 3452
    //   8488: aload 5
    //   8490: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   8493: aload_3
    //   8494: astore_2
    //   8495: aload_3
    //   8496: astore_1
    //   8497: aload 4
    //   8499: aload 14
    //   8501: invokevirtual 3455	com/tencent/mobileqq/webview/swift/WebViewFragment:goToConversation	(Landroid/os/Bundle;)V
    //   8504: goto -105 -> 8399
    //   8507: astore_3
    //   8508: aload_2
    //   8509: astore_1
    //   8510: ldc 209
    //   8512: iconst_1
    //   8513: ldc_w 3457
    //   8516: aload_3
    //   8517: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8520: aload_2
    //   8521: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8524: ifne -8340 -> 184
    //   8527: aload_0
    //   8528: aload_2
    //   8529: iconst_1
    //   8530: anewarray 285	java/lang/String
    //   8533: dup
    //   8534: iconst_0
    //   8535: new 551	java/lang/StringBuilder
    //   8538: dup
    //   8539: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8542: ldc_w 3447
    //   8545: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8548: iconst_1
    //   8549: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8552: ldc_w 1801
    //   8555: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8558: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8561: aastore
    //   8562: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8565: goto -8381 -> 184
    //   8568: aload_3
    //   8569: astore_2
    //   8570: aload_3
    //   8571: astore_1
    //   8572: ldc 209
    //   8574: iconst_1
    //   8575: ldc_w 3459
    //   8578: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   8604: new 551	java/lang/StringBuilder
    //   8607: dup
    //   8608: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8611: ldc_w 3447
    //   8614: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8617: iconst_1
    //   8618: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8621: ldc_w 1801
    //   8624: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8627: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8630: aastore
    //   8631: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   8634: aload_2
    //   8635: athrow
    //   8636: ldc_w 1955
    //   8639: aload 4
    //   8641: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8644: ifeq +275 -> 8919
    //   8647: aload 5
    //   8649: arraylength
    //   8650: iconst_1
    //   8651: if_icmpne +268 -> 8919
    //   8654: new 113	org/json/JSONObject
    //   8657: dup
    //   8658: aload 5
    //   8660: iconst_0
    //   8661: aaload
    //   8662: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8665: astore_1
    //   8666: aload_1
    //   8667: ldc_w 3426
    //   8670: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8673: ifeq +135 -> 8808
    //   8676: aload_1
    //   8677: ldc_w 3426
    //   8680: invokevirtual 3147	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8683: istore 13
    //   8685: iconst_0
    //   8686: istore 12
    //   8688: aload_1
    //   8689: ldc 154
    //   8691: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8694: astore_2
    //   8695: aload_1
    //   8696: ldc_w 3461
    //   8699: ldc_w 1975
    //   8702: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8705: istore 6
    //   8707: aload_1
    //   8708: ldc_w 3463
    //   8711: ldc_w 1975
    //   8714: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   8717: istore 7
    //   8719: ldc_w 3465
    //   8722: aload_2
    //   8723: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8726: ifeq +6 -> 8732
    //   8729: iconst_1
    //   8730: istore 12
    //   8732: iload 13
    //   8734: aload_0
    //   8735: getfield 3467	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8738: if_icmpeq -8554 -> 184
    //   8741: iload 13
    //   8743: ifeq +58 -> 8801
    //   8746: aload_0
    //   8747: iload 12
    //   8749: iload 6
    //   8751: iload 7
    //   8753: invokevirtual 3469	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZII)V
    //   8756: aload_0
    //   8757: iload 13
    //   8759: putfield 3467	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_Boolean	Z
    //   8762: goto -8578 -> 184
    //   8765: astore_1
    //   8766: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   8769: ifeq -8585 -> 184
    //   8772: ldc 209
    //   8774: iconst_4
    //   8775: new 551	java/lang/StringBuilder
    //   8778: dup
    //   8779: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   8782: ldc_w 3430
    //   8785: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8788: aload_1
    //   8789: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8792: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8795: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8798: goto -8614 -> 184
    //   8801: aload_0
    //   8802: invokevirtual 3470	com/tencent/mobileqq/jsp/UiApiPlugin:c	()V
    //   8805: goto -49 -> 8756
    //   8808: aload_1
    //   8809: ldc_w 3472
    //   8812: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   8815: ifeq -8631 -> 184
    //   8818: aload_0
    //   8819: getfield 1966	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8822: ifeq -8638 -> 184
    //   8825: aload_0
    //   8826: iconst_0
    //   8827: putfield 1966	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_Boolean	Z
    //   8830: aload_1
    //   8831: ldc_w 3472
    //   8834: invokevirtual 3147	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   8837: istore 12
    //   8839: invokestatic 621	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8842: invokevirtual 3473	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   8845: astore_2
    //   8846: iload 12
    //   8848: ifeq +44 -> 8892
    //   8851: aload_0
    //   8852: getfield 1974	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zvb	Lzvb;
    //   8855: iconst_0
    //   8856: aload_1
    //   8857: ldc_w 801
    //   8860: aload_2
    //   8861: ldc_w 3474
    //   8864: invokevirtual 3475	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8867: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8870: invokeinterface 3478 3 0
    //   8875: aload_0
    //   8876: getfield 1964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8879: ifnull -8695 -> 184
    //   8882: aload_0
    //   8883: getfield 1964	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentBizUiRefreshView	Lcom/tencent/biz/ui/RefreshView;
    //   8886: invokevirtual 3480	com/tencent/biz/ui/RefreshView:b	()V
    //   8889: goto -8705 -> 184
    //   8892: aload_0
    //   8893: getfield 1974	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zvb	Lzvb;
    //   8896: iconst_1
    //   8897: aload_1
    //   8898: ldc_w 801
    //   8901: aload_2
    //   8902: ldc_w 3481
    //   8905: invokevirtual 3475	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   8908: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8911: invokeinterface 3478 3 0
    //   8916: goto -41 -> 8875
    //   8919: ldc_w 3483
    //   8922: aload 4
    //   8924: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8927: ifeq +192 -> 9119
    //   8930: aload 5
    //   8932: arraylength
    //   8933: iconst_1
    //   8934: if_icmpne +185 -> 9119
    //   8937: new 113	org/json/JSONObject
    //   8940: dup
    //   8941: aload 5
    //   8943: iconst_0
    //   8944: aaload
    //   8945: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8948: astore_2
    //   8949: aload_2
    //   8950: ldc_w 3485
    //   8953: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8956: istore 6
    //   8958: aload_2
    //   8959: ldc 160
    //   8961: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8964: astore_1
    //   8965: aload_2
    //   8966: ldc 217
    //   8968: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8971: istore 7
    //   8973: aload_0
    //   8974: aload_2
    //   8975: ldc_w 811
    //   8978: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8981: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   8984: new 129	android/content/Intent
    //   8987: dup
    //   8988: getstatic 3489	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   8991: ldc_w 3491
    //   8994: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   8997: astore_2
    //   8998: aload_2
    //   8999: ldc_w 3493
    //   9002: iload 6
    //   9004: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9007: pop
    //   9008: aload_2
    //   9009: ldc_w 3495
    //   9012: aload_1
    //   9013: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   9016: pop
    //   9017: aload_2
    //   9018: ldc_w 3497
    //   9021: iload 7
    //   9023: invokevirtual 404	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   9026: pop
    //   9027: aload_2
    //   9028: ldc_w 3499
    //   9031: bipush 6
    //   9033: invokevirtual 3502	android/content/Intent:putExtra	(Ljava/lang/String;B)Landroid/content/Intent;
    //   9036: pop
    //   9037: aload_0
    //   9038: aload_2
    //   9039: bipush 6
    //   9041: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   9044: goto -8860 -> 184
    //   9047: astore_1
    //   9048: aload_1
    //   9049: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   9052: aload_0
    //   9053: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9056: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9059: ifne -8875 -> 184
    //   9062: aload_0
    //   9063: aload_0
    //   9064: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9067: iconst_1
    //   9068: anewarray 285	java/lang/String
    //   9071: dup
    //   9072: iconst_0
    //   9073: ldc_w 3504
    //   9076: aastore
    //   9077: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9080: goto -8896 -> 184
    //   9083: astore_1
    //   9084: aload_1
    //   9085: invokevirtual 876	java/lang/Exception:printStackTrace	()V
    //   9088: aload_0
    //   9089: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9092: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9095: ifne -8911 -> 184
    //   9098: aload_0
    //   9099: aload_0
    //   9100: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   9103: iconst_1
    //   9104: anewarray 285	java/lang/String
    //   9107: dup
    //   9108: iconst_0
    //   9109: ldc_w 3504
    //   9112: aastore
    //   9113: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9116: goto -8932 -> 184
    //   9119: ldc_w 3506
    //   9122: aload 4
    //   9124: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9127: ifeq +250 -> 9377
    //   9130: aload_0
    //   9131: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   9134: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   9137: astore_1
    //   9138: aload_0
    //   9139: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   9142: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   9145: astore_2
    //   9146: aload_1
    //   9147: ifnull -8963 -> 184
    //   9150: aload_2
    //   9151: ifnull -8967 -> 184
    //   9154: aconst_null
    //   9155: astore_2
    //   9156: aload_2
    //   9157: astore_1
    //   9158: new 113	org/json/JSONObject
    //   9161: dup
    //   9162: aload 5
    //   9164: iconst_0
    //   9165: aaload
    //   9166: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9169: astore_3
    //   9170: aload_2
    //   9171: astore_1
    //   9172: aload_3
    //   9173: ldc_w 811
    //   9176: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9179: astore_2
    //   9180: aload_2
    //   9181: astore_1
    //   9182: aload_3
    //   9183: ldc_w 2719
    //   9186: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9189: invokestatic 3510	awkh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9192: astore 4
    //   9194: aload_2
    //   9195: astore_1
    //   9196: aload_3
    //   9197: ldc_w 3512
    //   9200: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9203: astore 5
    //   9205: aload_2
    //   9206: astore_1
    //   9207: aload_3
    //   9208: ldc_w 1082
    //   9211: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9214: istore 7
    //   9216: iconst_0
    //   9217: istore 6
    //   9219: aload_2
    //   9220: astore_1
    //   9221: aload_3
    //   9222: ldc_w 3514
    //   9225: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9228: ifeq +14 -> 9242
    //   9231: aload_2
    //   9232: astore_1
    //   9233: aload_3
    //   9234: ldc_w 3514
    //   9237: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   9240: istore 6
    //   9242: aload_2
    //   9243: astore_1
    //   9244: new 301	android/os/Bundle
    //   9247: dup
    //   9248: invokespecial 302	android/os/Bundle:<init>	()V
    //   9251: astore_3
    //   9252: aload_2
    //   9253: astore_1
    //   9254: aload_3
    //   9255: ldc_w 2719
    //   9258: aload 4
    //   9260: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9263: aload 5
    //   9265: ifnull +14 -> 9279
    //   9268: aload_2
    //   9269: astore_1
    //   9270: aload_3
    //   9271: ldc_w 3512
    //   9274: aload 5
    //   9276: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9279: aload_2
    //   9280: astore_1
    //   9281: aload_3
    //   9282: ldc_w 3516
    //   9285: iload 7
    //   9287: invokevirtual 596	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9290: aload_2
    //   9291: astore_1
    //   9292: aload_3
    //   9293: ldc_w 1726
    //   9296: ldc_w 3506
    //   9299: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9302: aload_2
    //   9303: astore_1
    //   9304: aload_3
    //   9305: ldc_w 3514
    //   9308: iload 6
    //   9310: invokevirtual 596	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9313: aload_2
    //   9314: astore_1
    //   9315: ldc_w 3518
    //   9318: aload_2
    //   9319: aload_0
    //   9320: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aqyp	Laqyp;
    //   9323: getfield 3523	aqyp:key	I
    //   9326: aload_3
    //   9327: invokestatic 3528	aqyt:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9330: astore_3
    //   9331: aload_2
    //   9332: astore_1
    //   9333: invokestatic 3533	ardu:a	()Lardu;
    //   9336: aload_3
    //   9337: invokevirtual 3534	ardu:a	(Landroid/os/Bundle;)V
    //   9340: goto -9156 -> 184
    //   9343: astore_2
    //   9344: aload_1
    //   9345: ifnull -9161 -> 184
    //   9348: aload_0
    //   9349: aload_1
    //   9350: iconst_1
    //   9351: anewarray 285	java/lang/String
    //   9354: dup
    //   9355: iconst_0
    //   9356: ldc_w 3536
    //   9359: iconst_1
    //   9360: anewarray 277	java/lang/Object
    //   9363: dup
    //   9364: iconst_0
    //   9365: aload_2
    //   9366: aastore
    //   9367: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9370: aastore
    //   9371: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9374: goto -9190 -> 184
    //   9377: ldc_w 3538
    //   9380: aload 4
    //   9382: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9385: ifeq +403 -> 9788
    //   9388: aload_0
    //   9389: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   9392: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   9395: astore_1
    //   9396: aload_0
    //   9397: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   9400: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   9403: astore_2
    //   9404: aload_1
    //   9405: ifnull -9221 -> 184
    //   9408: aload_2
    //   9409: ifnull -9225 -> 184
    //   9412: aconst_null
    //   9413: astore_2
    //   9414: aconst_null
    //   9415: astore 4
    //   9417: aload_2
    //   9418: astore_1
    //   9419: new 113	org/json/JSONObject
    //   9422: dup
    //   9423: aload 5
    //   9425: iconst_0
    //   9426: aaload
    //   9427: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9430: astore 14
    //   9432: aload_2
    //   9433: astore_1
    //   9434: aload 14
    //   9436: ldc_w 811
    //   9439: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9442: astore_3
    //   9443: aload_3
    //   9444: astore_1
    //   9445: aload 14
    //   9447: ldc_w 2719
    //   9450: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9453: invokestatic 3510	awkh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   9456: astore_2
    //   9457: aload_3
    //   9458: astore_1
    //   9459: aload 14
    //   9461: ldc_w 2717
    //   9464: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9467: astore 5
    //   9469: aload_3
    //   9470: astore_1
    //   9471: aload 14
    //   9473: ldc_w 3540
    //   9476: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9479: astore 15
    //   9481: iconst_0
    //   9482: istore 12
    //   9484: aload_3
    //   9485: astore_1
    //   9486: aload 5
    //   9488: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9491: ifne +7968 -> 17459
    //   9494: iconst_1
    //   9495: istore 12
    //   9497: aload 5
    //   9499: astore_2
    //   9500: aload_3
    //   9501: astore_1
    //   9502: aload 14
    //   9504: ldc_w 3512
    //   9507: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9510: astore 5
    //   9512: aload_3
    //   9513: astore_1
    //   9514: aload 14
    //   9516: ldc_w 1082
    //   9519: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9522: istore 6
    //   9524: aload_3
    //   9525: astore_1
    //   9526: aload 14
    //   9528: ldc_w 3542
    //   9531: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9534: istore 7
    //   9536: aload_3
    //   9537: astore_1
    //   9538: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9541: ifeq +35 -> 9576
    //   9544: aload_3
    //   9545: astore_1
    //   9546: ldc 209
    //   9548: iconst_2
    //   9549: new 551	java/lang/StringBuilder
    //   9552: dup
    //   9553: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   9556: ldc_w 3544
    //   9559: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9562: aload 14
    //   9564: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9567: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9570: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9573: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9576: aload_3
    //   9577: astore_1
    //   9578: aload_2
    //   9579: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9582: ifne +178 -> 9760
    //   9585: aload_3
    //   9586: astore_1
    //   9587: new 301	android/os/Bundle
    //   9590: dup
    //   9591: invokespecial 302	android/os/Bundle:<init>	()V
    //   9594: astore 14
    //   9596: aload_3
    //   9597: astore_1
    //   9598: aload 14
    //   9600: ldc_w 1082
    //   9603: iload 6
    //   9605: invokevirtual 596	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9608: aload_3
    //   9609: astore_1
    //   9610: aload 14
    //   9612: ldc_w 2719
    //   9615: aload_2
    //   9616: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9619: aload_3
    //   9620: astore_1
    //   9621: aload 14
    //   9623: ldc_w 3546
    //   9626: iload 12
    //   9628: invokevirtual 378	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   9631: aload_3
    //   9632: astore_1
    //   9633: aload 14
    //   9635: ldc_w 1726
    //   9638: ldc_w 3538
    //   9641: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9644: aload_3
    //   9645: astore_1
    //   9646: aload 14
    //   9648: ldc_w 3542
    //   9651: iload 7
    //   9653: invokevirtual 596	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   9656: aload_3
    //   9657: astore_1
    //   9658: aload 5
    //   9660: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9663: ifne +15 -> 9678
    //   9666: aload_3
    //   9667: astore_1
    //   9668: aload 14
    //   9670: ldc_w 3512
    //   9673: aload 5
    //   9675: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9678: aload_3
    //   9679: astore_1
    //   9680: aload 15
    //   9682: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9685: ifne +15 -> 9700
    //   9688: aload_3
    //   9689: astore_1
    //   9690: aload 14
    //   9692: ldc_w 3540
    //   9695: aload 15
    //   9697: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   9700: aload_3
    //   9701: astore_1
    //   9702: ldc_w 3518
    //   9705: aload_3
    //   9706: aload_0
    //   9707: getfield 94	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Aqyp	Laqyp;
    //   9710: getfield 3523	aqyp:key	I
    //   9713: aload 14
    //   9715: invokestatic 3528	aqyt:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   9718: astore_2
    //   9719: aload_3
    //   9720: astore_1
    //   9721: invokestatic 3533	ardu:a	()Lardu;
    //   9724: aload_2
    //   9725: invokevirtual 3534	ardu:a	(Landroid/os/Bundle;)V
    //   9728: aload_3
    //   9729: astore_1
    //   9730: aload 4
    //   9732: astore_2
    //   9733: aload_2
    //   9734: ifnull -9550 -> 184
    //   9737: aload_1
    //   9738: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9741: ifne -9557 -> 184
    //   9744: aload_0
    //   9745: aload_1
    //   9746: iconst_1
    //   9747: anewarray 285	java/lang/String
    //   9750: dup
    //   9751: iconst_0
    //   9752: aload_2
    //   9753: aastore
    //   9754: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9757: goto -9573 -> 184
    //   9760: ldc_w 3548
    //   9763: astore_2
    //   9764: aload_3
    //   9765: astore_1
    //   9766: goto -33 -> 9733
    //   9769: astore_2
    //   9770: ldc_w 3536
    //   9773: iconst_1
    //   9774: anewarray 277	java/lang/Object
    //   9777: dup
    //   9778: iconst_0
    //   9779: aload_2
    //   9780: aastore
    //   9781: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9784: astore_2
    //   9785: goto -52 -> 9733
    //   9788: ldc_w 3550
    //   9791: aload 4
    //   9793: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9796: ifeq +196 -> 9992
    //   9799: aconst_null
    //   9800: astore_2
    //   9801: aload_2
    //   9802: astore_1
    //   9803: new 113	org/json/JSONObject
    //   9806: dup
    //   9807: aload 5
    //   9809: iconst_0
    //   9810: aaload
    //   9811: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9814: astore_3
    //   9815: aload_2
    //   9816: astore_1
    //   9817: aload_3
    //   9818: ldc_w 811
    //   9821: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9824: astore_2
    //   9825: aload_2
    //   9826: astore_1
    //   9827: aload_3
    //   9828: ldc_w 3426
    //   9831: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   9834: ifeq -9650 -> 184
    //   9837: aload_2
    //   9838: astore_1
    //   9839: aload_3
    //   9840: ldc_w 3426
    //   9843: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   9846: istore 12
    //   9848: aload_2
    //   9849: astore_1
    //   9850: aload_0
    //   9851: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   9854: aload_0
    //   9855: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   9858: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   9861: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   9864: astore_3
    //   9865: aload_3
    //   9866: ifnull +83 -> 9949
    //   9869: aload_2
    //   9870: astore_1
    //   9871: aload_3
    //   9872: instanceof 3552
    //   9875: ifeq +74 -> 9949
    //   9878: aload_2
    //   9879: astore_1
    //   9880: aload_3
    //   9881: checkcast 3552	bgzn
    //   9884: astore_3
    //   9885: iload 12
    //   9887: ifne +56 -> 9943
    //   9890: iconst_1
    //   9891: istore 12
    //   9893: aload_2
    //   9894: astore_1
    //   9895: aload_3
    //   9896: iload 12
    //   9898: invokeinterface 3553 2 0
    //   9903: goto -9719 -> 184
    //   9906: astore_2
    //   9907: aload_1
    //   9908: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9911: ifne -9727 -> 184
    //   9914: aload_0
    //   9915: aload_1
    //   9916: iconst_1
    //   9917: anewarray 285	java/lang/String
    //   9920: dup
    //   9921: iconst_0
    //   9922: ldc_w 3536
    //   9925: iconst_1
    //   9926: anewarray 277	java/lang/Object
    //   9929: dup
    //   9930: iconst_0
    //   9931: aload_2
    //   9932: aastore
    //   9933: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9936: aastore
    //   9937: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   9940: goto -9756 -> 184
    //   9943: iconst_0
    //   9944: istore 12
    //   9946: goto -53 -> 9893
    //   9949: aload_2
    //   9950: astore_1
    //   9951: aload_0
    //   9952: iconst_m1
    //   9953: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   9956: checkcast 3555	bgwv
    //   9959: astore_3
    //   9960: aload_3
    //   9961: ifnull -9777 -> 184
    //   9964: iload 12
    //   9966: ifne +20 -> 9986
    //   9969: iconst_1
    //   9970: istore 12
    //   9972: aload_2
    //   9973: astore_1
    //   9974: aload_3
    //   9975: ldc_w 3557
    //   9978: iload 12
    //   9980: invokevirtual 3559	bgwv:a	(Ljava/lang/String;Z)V
    //   9983: goto -9799 -> 184
    //   9986: iconst_0
    //   9987: istore 12
    //   9989: goto -17 -> 9972
    //   9992: ldc_w 3561
    //   9995: aload 4
    //   9997: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10000: ifeq +196 -> 10196
    //   10003: aconst_null
    //   10004: astore_2
    //   10005: aload_2
    //   10006: astore_1
    //   10007: new 113	org/json/JSONObject
    //   10010: dup
    //   10011: aload 5
    //   10013: iconst_0
    //   10014: aaload
    //   10015: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10018: astore_3
    //   10019: aload_2
    //   10020: astore_1
    //   10021: aload_3
    //   10022: ldc_w 811
    //   10025: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10028: astore_2
    //   10029: aload_2
    //   10030: astore_1
    //   10031: aload_3
    //   10032: ldc_w 3426
    //   10035: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   10038: ifeq -9854 -> 184
    //   10041: aload_2
    //   10042: astore_1
    //   10043: aload_3
    //   10044: ldc_w 3426
    //   10047: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   10050: istore 12
    //   10052: aload_2
    //   10053: astore_1
    //   10054: aload_0
    //   10055: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   10058: aload_0
    //   10059: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   10062: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   10065: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   10068: astore_3
    //   10069: aload_3
    //   10070: ifnull +83 -> 10153
    //   10073: aload_2
    //   10074: astore_1
    //   10075: aload_3
    //   10076: instanceof 3552
    //   10079: ifeq +74 -> 10153
    //   10082: aload_2
    //   10083: astore_1
    //   10084: aload_3
    //   10085: checkcast 3552	bgzn
    //   10088: astore_3
    //   10089: iload 12
    //   10091: ifne +56 -> 10147
    //   10094: iconst_1
    //   10095: istore 12
    //   10097: aload_2
    //   10098: astore_1
    //   10099: aload_3
    //   10100: iload 12
    //   10102: invokeinterface 3563 2 0
    //   10107: goto -9923 -> 184
    //   10110: astore_2
    //   10111: aload_1
    //   10112: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10115: ifne -9931 -> 184
    //   10118: aload_0
    //   10119: aload_1
    //   10120: iconst_1
    //   10121: anewarray 285	java/lang/String
    //   10124: dup
    //   10125: iconst_0
    //   10126: ldc_w 3536
    //   10129: iconst_1
    //   10130: anewarray 277	java/lang/Object
    //   10133: dup
    //   10134: iconst_0
    //   10135: aload_2
    //   10136: aastore
    //   10137: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10140: aastore
    //   10141: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10144: goto -9960 -> 184
    //   10147: iconst_0
    //   10148: istore 12
    //   10150: goto -53 -> 10097
    //   10153: aload_2
    //   10154: astore_1
    //   10155: aload_0
    //   10156: iconst_m1
    //   10157: invokespecial 1760	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   10160: checkcast 3555	bgwv
    //   10163: astore_3
    //   10164: aload_3
    //   10165: ifnull -9981 -> 184
    //   10168: iload 12
    //   10170: ifne +20 -> 10190
    //   10173: iconst_1
    //   10174: istore 12
    //   10176: aload_2
    //   10177: astore_1
    //   10178: aload_3
    //   10179: ldc_w 3565
    //   10182: iload 12
    //   10184: invokevirtual 3559	bgwv:a	(Ljava/lang/String;Z)V
    //   10187: goto -10003 -> 184
    //   10190: iconst_0
    //   10191: istore 12
    //   10193: goto -17 -> 10176
    //   10196: ldc_w 3567
    //   10199: aload 4
    //   10201: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10204: ifeq +74 -> 10278
    //   10207: new 113	org/json/JSONObject
    //   10210: dup
    //   10211: aload 5
    //   10213: iconst_0
    //   10214: aaload
    //   10215: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10218: astore_1
    //   10219: new 3569	anaq
    //   10222: dup
    //   10223: invokespecial 3570	anaq:<init>	()V
    //   10226: aload_1
    //   10227: ldc_w 3572
    //   10230: invokevirtual 1078	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   10233: invokevirtual 3575	anaq:a	(Lorg/json/JSONArray;)V
    //   10236: goto -10052 -> 184
    //   10239: astore_1
    //   10240: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10243: ifeq -10059 -> 184
    //   10246: ldc 209
    //   10248: iconst_2
    //   10249: new 551	java/lang/StringBuilder
    //   10252: dup
    //   10253: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   10256: ldc_w 3577
    //   10259: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10262: aload 5
    //   10264: iconst_0
    //   10265: aaload
    //   10266: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10269: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10272: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10275: goto -10091 -> 184
    //   10278: ldc_w 3579
    //   10281: aload 4
    //   10283: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10286: ifeq +154 -> 10440
    //   10289: new 113	org/json/JSONObject
    //   10292: dup
    //   10293: aload 5
    //   10295: iconst_0
    //   10296: aaload
    //   10297: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10300: ldc_w 811
    //   10303: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10306: astore_1
    //   10307: new 3569	anaq
    //   10310: dup
    //   10311: invokespecial 3570	anaq:<init>	()V
    //   10314: astore 4
    //   10316: new 113	org/json/JSONObject
    //   10319: dup
    //   10320: invokespecial 172	org/json/JSONObject:<init>	()V
    //   10323: astore_2
    //   10324: new 1112	org/json/JSONArray
    //   10327: dup
    //   10328: invokespecial 3580	org/json/JSONArray:<init>	()V
    //   10331: astore_3
    //   10332: aload 4
    //   10334: invokevirtual 3583	anaq:a	()Ljava/util/ArrayList;
    //   10337: astore 4
    //   10339: iconst_0
    //   10340: istore 6
    //   10342: iload 6
    //   10344: aload 4
    //   10346: invokevirtual 3586	java/util/ArrayList:size	()I
    //   10349: if_icmpge +24 -> 10373
    //   10352: aload_3
    //   10353: aload 4
    //   10355: iload 6
    //   10357: invokevirtual 3588	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   10360: invokevirtual 3591	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   10363: pop
    //   10364: iload 6
    //   10366: iconst_1
    //   10367: iadd
    //   10368: istore 6
    //   10370: goto -28 -> 10342
    //   10373: aload_2
    //   10374: ldc_w 3572
    //   10377: aload_3
    //   10378: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   10381: pop
    //   10382: aload_0
    //   10383: aload_1
    //   10384: iconst_1
    //   10385: anewarray 285	java/lang/String
    //   10388: dup
    //   10389: iconst_0
    //   10390: aload_2
    //   10391: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10394: aastore
    //   10395: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10398: goto -10214 -> 184
    //   10401: astore_1
    //   10402: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10405: ifeq -10221 -> 184
    //   10408: ldc 209
    //   10410: iconst_2
    //   10411: new 551	java/lang/StringBuilder
    //   10414: dup
    //   10415: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   10418: ldc_w 3593
    //   10421: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10424: aload 5
    //   10426: iconst_0
    //   10427: aaload
    //   10428: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10431: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10434: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10437: goto -10253 -> 184
    //   10440: ldc_w 3595
    //   10443: aload 4
    //   10445: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10448: ifeq +221 -> 10669
    //   10451: aload_0
    //   10452: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   10455: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   10458: astore 14
    //   10460: aload_0
    //   10461: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   10464: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   10467: astore_1
    //   10468: aload 14
    //   10470: ifnull -10286 -> 184
    //   10473: aload_1
    //   10474: ifnull -10290 -> 184
    //   10477: aconst_null
    //   10478: astore_1
    //   10479: aconst_null
    //   10480: astore 4
    //   10482: new 113	org/json/JSONObject
    //   10485: dup
    //   10486: aload 5
    //   10488: iconst_0
    //   10489: aaload
    //   10490: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10493: astore_3
    //   10494: aload_3
    //   10495: ldc_w 811
    //   10498: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10501: astore_2
    //   10502: aload_2
    //   10503: astore_1
    //   10504: aload_3
    //   10505: ifnull +155 -> 10660
    //   10508: new 301	android/os/Bundle
    //   10511: dup
    //   10512: invokespecial 302	android/os/Bundle:<init>	()V
    //   10515: astore 5
    //   10517: aload 5
    //   10519: ldc_w 3597
    //   10522: aload_3
    //   10523: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10526: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   10529: aload 14
    //   10531: invokevirtual 281	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10534: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   10537: ldc_w 3599
    //   10540: invokevirtual 288	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   10543: istore 12
    //   10545: aload 4
    //   10547: astore_2
    //   10548: aload_1
    //   10549: astore_3
    //   10550: iload 12
    //   10552: ifeq +41 -> 10593
    //   10555: aconst_null
    //   10556: aload 14
    //   10558: new 113	org/json/JSONObject
    //   10561: dup
    //   10562: aload 5
    //   10564: ldc_w 3597
    //   10567: invokevirtual 3600	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10570: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10573: ldc_w 3602
    //   10576: ldc_w 484
    //   10579: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10582: invokestatic 3606	ucx:a	(Ljava/lang/String;)Ljava/lang/String;
    //   10585: invokestatic 3611	ugf:a	(Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;)V
    //   10588: aload_1
    //   10589: astore_3
    //   10590: aload 4
    //   10592: astore_2
    //   10593: aload_2
    //   10594: ifnull -10410 -> 184
    //   10597: aload_3
    //   10598: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10601: ifne -10417 -> 184
    //   10604: aload_0
    //   10605: aload_3
    //   10606: iconst_1
    //   10607: anewarray 285	java/lang/String
    //   10610: dup
    //   10611: iconst_0
    //   10612: aload_2
    //   10613: aastore
    //   10614: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10617: goto -10433 -> 184
    //   10620: astore_2
    //   10621: ldc 209
    //   10623: iconst_2
    //   10624: ldc_w 3613
    //   10627: aload_2
    //   10628: invokestatic 2725	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   10631: aload 4
    //   10633: astore_2
    //   10634: aload_1
    //   10635: astore_3
    //   10636: goto -43 -> 10593
    //   10639: astore_2
    //   10640: ldc_w 3536
    //   10643: iconst_1
    //   10644: anewarray 277	java/lang/Object
    //   10647: dup
    //   10648: iconst_0
    //   10649: aload_2
    //   10650: aastore
    //   10651: invokestatic 1565	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10654: astore_2
    //   10655: aload_1
    //   10656: astore_3
    //   10657: goto -64 -> 10593
    //   10660: ldc_w 3548
    //   10663: astore_2
    //   10664: aload_1
    //   10665: astore_3
    //   10666: goto -73 -> 10593
    //   10669: ldc_w 3615
    //   10672: aload 4
    //   10674: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10677: ifeq +330 -> 11007
    //   10680: aconst_null
    //   10681: ldc_w 770
    //   10684: ldc_w 772
    //   10687: ldc_w 484
    //   10690: ldc_w 774
    //   10693: ldc_w 3617
    //   10696: iconst_0
    //   10697: iconst_1
    //   10698: iconst_0
    //   10699: aload 5
    //   10701: iconst_0
    //   10702: aaload
    //   10703: ldc_w 484
    //   10706: ldc_w 484
    //   10709: ldc_w 484
    //   10712: invokestatic 781	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10715: aload_0
    //   10716: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   10719: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   10722: astore 14
    //   10724: aload_0
    //   10725: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   10728: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   10731: astore_1
    //   10732: aload 14
    //   10734: ifnull -10550 -> 184
    //   10737: aload_1
    //   10738: ifnull -10554 -> 184
    //   10741: aconst_null
    //   10742: astore_3
    //   10743: aconst_null
    //   10744: astore 4
    //   10746: aload 4
    //   10748: astore_1
    //   10749: aload_3
    //   10750: astore_2
    //   10751: new 113	org/json/JSONObject
    //   10754: dup
    //   10755: aload 5
    //   10757: iconst_0
    //   10758: aaload
    //   10759: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10762: astore 5
    //   10764: aload 4
    //   10766: astore_1
    //   10767: aload_3
    //   10768: astore_2
    //   10769: aload 5
    //   10771: ldc_w 811
    //   10774: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10777: astore_3
    //   10778: aload 4
    //   10780: astore_1
    //   10781: aload_3
    //   10782: astore_2
    //   10783: aload 5
    //   10785: ldc 223
    //   10787: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10790: astore 4
    //   10792: aload 4
    //   10794: astore_1
    //   10795: aload_3
    //   10796: astore_2
    //   10797: aload 5
    //   10799: ldc_w 1726
    //   10802: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10805: astore 15
    //   10807: aload 4
    //   10809: astore_1
    //   10810: aload_3
    //   10811: astore_2
    //   10812: aload 5
    //   10814: ldc 198
    //   10816: invokevirtual 425	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10819: astore 5
    //   10821: aload 4
    //   10823: astore_1
    //   10824: aload_3
    //   10825: astore_2
    //   10826: ldc_w 774
    //   10829: aload 15
    //   10831: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10834: ifeq +6618 -> 17452
    //   10837: aload 5
    //   10839: ifnull +6613 -> 17452
    //   10842: aload 4
    //   10844: astore_1
    //   10845: aload_3
    //   10846: astore_2
    //   10847: aload 5
    //   10849: ldc_w 427
    //   10852: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10855: astore 15
    //   10857: aload 4
    //   10859: astore_1
    //   10860: aload_3
    //   10861: astore_2
    //   10862: aload 5
    //   10864: ldc_w 3320
    //   10867: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10870: astore 16
    //   10872: aload 4
    //   10874: astore_1
    //   10875: aload_3
    //   10876: astore_2
    //   10877: aload 5
    //   10879: ldc 160
    //   10881: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10884: astore 5
    //   10886: aload 4
    //   10888: astore_1
    //   10889: aload_3
    //   10890: astore_2
    //   10891: aload 15
    //   10893: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10896: ifne +67 -> 10963
    //   10899: aload 4
    //   10901: astore_1
    //   10902: aload_3
    //   10903: astore_2
    //   10904: aload 5
    //   10906: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10909: ifne +54 -> 10963
    //   10912: aload 4
    //   10914: astore_1
    //   10915: aload_3
    //   10916: astore_2
    //   10917: aload_0
    //   10918: aload 14
    //   10920: aload 15
    //   10922: aload 16
    //   10924: aload 4
    //   10926: aload 5
    //   10928: aload_3
    //   10929: invokespecial 3619	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10932: aconst_null
    //   10933: astore_1
    //   10934: aload_3
    //   10935: astore_2
    //   10936: aload_1
    //   10937: ifnull -10753 -> 184
    //   10940: aload_2
    //   10941: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10944: ifne -10760 -> 184
    //   10947: aload_0
    //   10948: aload_2
    //   10949: iconst_1
    //   10950: anewarray 285	java/lang/String
    //   10953: dup
    //   10954: iconst_0
    //   10955: aload_1
    //   10956: aastore
    //   10957: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   10960: goto -10776 -> 184
    //   10963: aload 4
    //   10965: astore_1
    //   10966: aload_3
    //   10967: astore_2
    //   10968: ldc_w 2979
    //   10971: aconst_null
    //   10972: ldc_w 3621
    //   10975: aload 4
    //   10977: invokestatic 768	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10980: astore 4
    //   10982: aload 4
    //   10984: astore_1
    //   10985: aload_3
    //   10986: astore_2
    //   10987: goto -51 -> 10936
    //   10990: astore_3
    //   10991: ldc_w 3623
    //   10994: aconst_null
    //   10995: aload_3
    //   10996: invokevirtual 1376	java/lang/Exception:toString	()Ljava/lang/String;
    //   10999: aload_1
    //   11000: invokestatic 768	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11003: astore_1
    //   11004: goto -68 -> 10936
    //   11007: ldc_w 3625
    //   11010: aload 4
    //   11012: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11015: ifeq +316 -> 11331
    //   11018: aload 5
    //   11020: arraylength
    //   11021: ifle +310 -> 11331
    //   11024: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11027: ifeq +33 -> 11060
    //   11030: ldc_w 3627
    //   11033: iconst_2
    //   11034: new 551	java/lang/StringBuilder
    //   11037: dup
    //   11038: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11041: ldc_w 3629
    //   11044: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11047: aload 5
    //   11049: iconst_0
    //   11050: aaload
    //   11051: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11054: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11057: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11060: new 113	org/json/JSONObject
    //   11063: dup
    //   11064: aload 5
    //   11066: iconst_0
    //   11067: aaload
    //   11068: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11071: ldc 160
    //   11073: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11076: astore_3
    //   11077: aload_3
    //   11078: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11081: ifne -10897 -> 184
    //   11084: aload_3
    //   11085: ldc_w 3631
    //   11088: invokevirtual 3635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11091: astore_1
    //   11092: new 2426	java/util/HashMap
    //   11095: dup
    //   11096: invokespecial 3636	java/util/HashMap:<init>	()V
    //   11099: astore_2
    //   11100: aload_1
    //   11101: arraylength
    //   11102: iconst_1
    //   11103: if_icmple -10919 -> 184
    //   11106: aload_1
    //   11107: iconst_1
    //   11108: aaload
    //   11109: ldc_w 3638
    //   11112: invokevirtual 3635	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   11115: astore_1
    //   11116: iconst_0
    //   11117: istore 6
    //   11119: aload_1
    //   11120: arraylength
    //   11121: istore 7
    //   11123: iload 6
    //   11125: iload 7
    //   11127: if_icmpge +49 -> 11176
    //   11130: aload_1
    //   11131: iload 6
    //   11133: aaload
    //   11134: bipush 61
    //   11136: invokevirtual 3641	java/lang/String:indexOf	(I)I
    //   11139: istore 8
    //   11141: iload 8
    //   11143: iconst_m1
    //   11144: if_icmpeq +6435 -> 17579
    //   11147: aload_2
    //   11148: aload_1
    //   11149: iload 6
    //   11151: aaload
    //   11152: iconst_0
    //   11153: iload 8
    //   11155: invokevirtual 3645	java/lang/String:substring	(II)Ljava/lang/String;
    //   11158: aload_1
    //   11159: iload 6
    //   11161: aaload
    //   11162: iload 8
    //   11164: iconst_1
    //   11165: iadd
    //   11166: invokevirtual 3647	java/lang/String:substring	(I)Ljava/lang/String;
    //   11169: invokevirtual 2432	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   11172: pop
    //   11173: goto +6406 -> 17579
    //   11176: aload_3
    //   11177: ldc_w 2087
    //   11180: invokevirtual 325	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11183: ifeq +123 -> 11306
    //   11186: aload_2
    //   11187: ldc_w 602
    //   11190: invokevirtual 3648	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11193: checkcast 285	java/lang/String
    //   11196: astore_1
    //   11197: aload_2
    //   11198: ldc 174
    //   11200: invokevirtual 3648	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11203: checkcast 285	java/lang/String
    //   11206: astore_2
    //   11207: aload_0
    //   11208: aload_1
    //   11209: aload_2
    //   11210: aload_3
    //   11211: invokevirtual 3650	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   11214: ifne -11030 -> 184
    //   11217: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11220: ifeq +13 -> 11233
    //   11223: ldc_w 3627
    //   11226: iconst_2
    //   11227: ldc_w 2759
    //   11230: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11233: aload_0
    //   11234: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   11237: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   11240: aload_0
    //   11241: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   11244: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11247: aload_0
    //   11248: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   11251: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   11254: aload 5
    //   11256: iconst_0
    //   11257: aaload
    //   11258: iconst_0
    //   11259: iconst_0
    //   11260: invokestatic 2764	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;ZZ)V
    //   11263: goto -11079 -> 184
    //   11266: astore_1
    //   11267: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11270: ifeq -11086 -> 184
    //   11273: ldc_w 3627
    //   11276: iconst_2
    //   11277: new 551	java/lang/StringBuilder
    //   11280: dup
    //   11281: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11284: ldc_w 3652
    //   11287: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11290: aload 5
    //   11292: iconst_0
    //   11293: aaload
    //   11294: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11297: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11300: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11303: goto -11119 -> 184
    //   11306: aload_2
    //   11307: ldc_w 3414
    //   11310: invokevirtual 3648	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11313: checkcast 285	java/lang/String
    //   11316: astore_1
    //   11317: aload_2
    //   11318: ldc_w 3654
    //   11321: invokevirtual 3648	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11324: checkcast 285	java/lang/String
    //   11327: astore_2
    //   11328: goto -121 -> 11207
    //   11331: ldc_w 3656
    //   11334: aload 4
    //   11336: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11339: ifeq +66 -> 11405
    //   11342: aload 5
    //   11344: arraylength
    //   11345: ifle +60 -> 11405
    //   11348: aload_0
    //   11349: new 113	org/json/JSONObject
    //   11352: dup
    //   11353: aload 5
    //   11355: iconst_0
    //   11356: aaload
    //   11357: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11360: invokevirtual 3658	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;)V
    //   11363: goto -11179 -> 184
    //   11366: astore_1
    //   11367: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11370: ifeq -11186 -> 184
    //   11373: ldc 209
    //   11375: iconst_2
    //   11376: new 551	java/lang/StringBuilder
    //   11379: dup
    //   11380: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11383: ldc_w 3660
    //   11386: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11389: aload 5
    //   11391: iconst_0
    //   11392: aaload
    //   11393: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11396: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11399: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11402: goto -11218 -> 184
    //   11405: ldc_w 3662
    //   11408: aload 4
    //   11410: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11413: ifeq +10 -> 11423
    //   11416: aload_0
    //   11417: invokevirtual 3664	com/tencent/mobileqq/jsp/UiApiPlugin:d	()V
    //   11420: goto -11236 -> 184
    //   11423: ldc_w 3666
    //   11426: aload 4
    //   11428: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11431: ifeq +72 -> 11503
    //   11434: aload 5
    //   11436: arraylength
    //   11437: ifle +66 -> 11503
    //   11440: aload_0
    //   11441: new 113	org/json/JSONObject
    //   11444: dup
    //   11445: aload 5
    //   11447: iconst_0
    //   11448: aaload
    //   11449: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11452: ldc_w 811
    //   11455: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11458: invokevirtual 3668	com/tencent/mobileqq/jsp/UiApiPlugin:b	(Ljava/lang/String;)V
    //   11461: goto -11277 -> 184
    //   11464: astore_1
    //   11465: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11468: ifeq -11284 -> 184
    //   11471: ldc 209
    //   11473: iconst_2
    //   11474: new 551	java/lang/StringBuilder
    //   11477: dup
    //   11478: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11481: ldc_w 3577
    //   11484: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11487: aload 5
    //   11489: iconst_0
    //   11490: aaload
    //   11491: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11494: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11497: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11500: goto -11316 -> 184
    //   11503: ldc_w 3670
    //   11506: aload 4
    //   11508: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11511: ifeq +112 -> 11623
    //   11514: new 113	org/json/JSONObject
    //   11517: dup
    //   11518: aload 5
    //   11520: iconst_0
    //   11521: aaload
    //   11522: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11525: astore_1
    //   11526: aload_0
    //   11527: invokevirtual 2601	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbgzt;
    //   11530: astore_2
    //   11531: aload_2
    //   11532: ifnull -11348 -> 184
    //   11535: aload_2
    //   11536: aload_1
    //   11537: invokeinterface 3673 2 0
    //   11542: goto -11358 -> 184
    //   11545: astore_1
    //   11546: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11549: ifeq -11365 -> 184
    //   11552: ldc 209
    //   11554: iconst_2
    //   11555: new 551	java/lang/StringBuilder
    //   11558: dup
    //   11559: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11562: ldc_w 3675
    //   11565: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11568: aload_1
    //   11569: invokevirtual 3676	org/json/JSONException:toString	()Ljava/lang/String;
    //   11572: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11575: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11578: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11581: goto -11397 -> 184
    //   11584: astore_1
    //   11585: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11588: ifeq -11404 -> 184
    //   11591: ldc 209
    //   11593: iconst_2
    //   11594: new 551	java/lang/StringBuilder
    //   11597: dup
    //   11598: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11601: ldc_w 3675
    //   11604: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11607: aload_1
    //   11608: invokevirtual 1376	java/lang/Exception:toString	()Ljava/lang/String;
    //   11611: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11614: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11617: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11620: goto -11436 -> 184
    //   11623: ldc_w 3678
    //   11626: aload 4
    //   11628: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11631: ifeq +194 -> 11825
    //   11634: aload 5
    //   11636: arraylength
    //   11637: ifle +188 -> 11825
    //   11640: new 113	org/json/JSONObject
    //   11643: dup
    //   11644: aload 5
    //   11646: iconst_0
    //   11647: aaload
    //   11648: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11651: ldc_w 811
    //   11654: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11657: astore_1
    //   11658: aload_1
    //   11659: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11662: ifeq +14 -> 11676
    //   11665: ldc 209
    //   11667: iconst_1
    //   11668: ldc_w 3680
    //   11671: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11674: iconst_1
    //   11675: ireturn
    //   11676: new 113	org/json/JSONObject
    //   11679: dup
    //   11680: invokespecial 172	org/json/JSONObject:<init>	()V
    //   11683: astore_2
    //   11684: new 113	org/json/JSONObject
    //   11687: dup
    //   11688: invokespecial 172	org/json/JSONObject:<init>	()V
    //   11691: astore_3
    //   11692: aload_0
    //   11693: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   11696: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   11699: invokevirtual 753	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   11702: ldc_w 754
    //   11705: invokevirtual 759	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   11708: istore 7
    //   11710: iload 7
    //   11712: istore 6
    //   11714: invokestatic 1895	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   11717: iconst_1
    //   11718: if_icmpne +18 -> 11736
    //   11721: iload 7
    //   11723: aload_0
    //   11724: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   11727: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   11730: invokestatic 1898	com/tencent/widget/immersive/ImmersiveUtils:getStatusBarHeight	(Landroid/content/Context;)I
    //   11733: iadd
    //   11734: istore 6
    //   11736: aload_3
    //   11737: ldc_w 1813
    //   11740: iload 6
    //   11742: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11745: pop
    //   11746: aload_2
    //   11747: ldc_w 1797
    //   11750: iconst_0
    //   11751: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11754: pop
    //   11755: aload_2
    //   11756: ldc 221
    //   11758: ldc_w 3682
    //   11761: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11764: pop
    //   11765: aload_2
    //   11766: ldc 198
    //   11768: aload_3
    //   11769: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11772: pop
    //   11773: aload_0
    //   11774: aload_1
    //   11775: iconst_1
    //   11776: anewarray 285	java/lang/String
    //   11779: dup
    //   11780: iconst_0
    //   11781: aload_2
    //   11782: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11785: aastore
    //   11786: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11789: goto -11605 -> 184
    //   11792: astore_1
    //   11793: ldc 209
    //   11795: iconst_1
    //   11796: new 551	java/lang/StringBuilder
    //   11799: dup
    //   11800: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   11803: ldc_w 3684
    //   11806: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11809: aload_1
    //   11810: invokestatic 2826	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   11813: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11816: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11819: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11822: goto -11638 -> 184
    //   11825: ldc_w 3686
    //   11828: aload 4
    //   11830: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11833: ifeq +78 -> 11911
    //   11836: new 113	org/json/JSONObject
    //   11839: dup
    //   11840: aload 5
    //   11842: iconst_0
    //   11843: aaload
    //   11844: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11847: astore_1
    //   11848: aload_1
    //   11849: ldc_w 602
    //   11852: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11855: astore_2
    //   11856: aload_0
    //   11857: aload_1
    //   11858: ldc_w 811
    //   11861: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11864: putfield 3688	com/tencent/mobileqq/jsp/UiApiPlugin:m	Ljava/lang/String;
    //   11867: aload_0
    //   11868: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   11871: ifnonnull +17 -> 11888
    //   11874: aload_0
    //   11875: invokestatic 2044	zon:a	()Lzon;
    //   11878: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   11881: aload_0
    //   11882: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   11885: invokevirtual 2046	zon:a	()V
    //   11888: aload_0
    //   11889: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   11892: aload_2
    //   11893: new 3690	auwe
    //   11896: dup
    //   11897: aload_0
    //   11898: aload_2
    //   11899: invokespecial 3691	auwe:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   11902: invokevirtual 3694	zon:a	(Ljava/lang/String;Lzop;)V
    //   11905: goto -11721 -> 184
    //   11908: astore_1
    //   11909: iconst_1
    //   11910: ireturn
    //   11911: ldc_w 3696
    //   11914: aload 4
    //   11916: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11919: ifeq +441 -> 12360
    //   11922: aload 5
    //   11924: arraylength
    //   11925: iconst_1
    //   11926: if_icmpne +434 -> 12360
    //   11929: new 113	org/json/JSONObject
    //   11932: dup
    //   11933: aload 5
    //   11935: iconst_0
    //   11936: aaload
    //   11937: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11940: astore_3
    //   11941: aload_3
    //   11942: ldc_w 3698
    //   11945: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11948: astore 4
    //   11950: aload_3
    //   11951: ldc_w 3700
    //   11954: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11957: astore_1
    //   11958: aload_1
    //   11959: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11962: ifeq +22 -> 11984
    //   11965: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11968: ifeq +5620 -> 17588
    //   11971: ldc_w 3702
    //   11974: iconst_2
    //   11975: ldc_w 3704
    //   11978: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11981: goto +5607 -> 17588
    //   11984: aload_0
    //   11985: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   11988: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   11991: astore_2
    //   11992: aload_2
    //   11993: ifnull +10 -> 12003
    //   11996: aload_2
    //   11997: invokevirtual 3708	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnzn;
    //   12000: ifnonnull +22 -> 12022
    //   12003: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12006: ifeq +5584 -> 17590
    //   12009: ldc_w 3702
    //   12012: iconst_2
    //   12013: ldc_w 3710
    //   12016: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12019: goto +5571 -> 17590
    //   12022: aload_2
    //   12023: invokevirtual 3708	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnzn;
    //   12026: getfield 3713	nzn:jdField_a_of_type_Int	I
    //   12029: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12032: astore_2
    //   12033: aload_3
    //   12034: ldc_w 3401
    //   12037: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12040: istore 6
    //   12042: iload 6
    //   12044: iconst_1
    //   12045: if_icmpne +226 -> 12271
    //   12048: new 3715	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12051: dup
    //   12052: invokespecial 3716	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12055: astore_3
    //   12056: aload_3
    //   12057: getfield 3719	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12060: sipush 1814
    //   12063: invokevirtual 686	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12066: aload_3
    //   12067: getfield 3722	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12070: bipush 48
    //   12072: invokevirtual 686	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12075: aload_1
    //   12076: invokevirtual 3725	java/lang/String:getBytes	()[B
    //   12079: arraylength
    //   12080: bipush 6
    //   12082: iadd
    //   12083: invokestatic 3731	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12086: astore 4
    //   12088: aload 4
    //   12090: aload_2
    //   12091: invokevirtual 2624	java/lang/Integer:intValue	()I
    //   12094: invokevirtual 3733	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12097: pop
    //   12098: aload 4
    //   12100: aload_1
    //   12101: invokevirtual 3725	java/lang/String:getBytes	()[B
    //   12104: arraylength
    //   12105: i2s
    //   12106: invokevirtual 3737	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12109: pop
    //   12110: aload 4
    //   12112: aload_1
    //   12113: invokevirtual 3725	java/lang/String:getBytes	()[B
    //   12116: invokevirtual 3740	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12119: pop
    //   12120: aload_3
    //   12121: getfield 3744	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12124: aload 4
    //   12126: invokevirtual 3747	java/nio/ByteBuffer:array	()[B
    //   12129: invokestatic 3753	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12132: invokevirtual 3758	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12135: new 704	mqq/app/NewIntent
    //   12138: dup
    //   12139: aload_0
    //   12140: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12143: ldc_w 706
    //   12146: invokespecial 707	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12149: astore_2
    //   12150: new 301	android/os/Bundle
    //   12153: dup
    //   12154: invokespecial 302	android/os/Bundle:<init>	()V
    //   12157: astore 4
    //   12159: aload 4
    //   12161: ldc_w 3700
    //   12164: aload_1
    //   12165: invokevirtual 487	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12168: aload_2
    //   12169: aload 4
    //   12171: invokevirtual 3759	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12174: pop
    //   12175: aload_2
    //   12176: ldc_w 712
    //   12179: ldc_w 3761
    //   12182: invokevirtual 715	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12185: pop
    //   12186: aload_2
    //   12187: ldc 198
    //   12189: aload_3
    //   12190: invokevirtual 3762	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12193: invokevirtual 722	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12196: pop
    //   12197: aload_2
    //   12198: ldc_w 3764
    //   12201: iconst_1
    //   12202: invokevirtual 3765	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12205: pop
    //   12206: aload_2
    //   12207: new 3767	auwf
    //   12210: dup
    //   12211: aload_0
    //   12212: invokespecial 3768	auwf:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   12215: invokevirtual 731	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12218: aload_0
    //   12219: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   12222: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   12225: aload_2
    //   12226: invokevirtual 737	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12229: goto -12045 -> 184
    //   12232: astore_1
    //   12233: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12236: ifeq -12052 -> 184
    //   12239: ldc 209
    //   12241: iconst_2
    //   12242: new 551	java/lang/StringBuilder
    //   12245: dup
    //   12246: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12249: ldc_w 3770
    //   12252: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12255: aload 5
    //   12257: iconst_0
    //   12258: aaload
    //   12259: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12262: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12265: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12268: goto -12084 -> 184
    //   12271: iload 6
    //   12273: ifne -12089 -> 184
    //   12276: aload_0
    //   12277: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   12280: ifnonnull +17 -> 12297
    //   12283: aload_0
    //   12284: invokestatic 2044	zon:a	()Lzon;
    //   12287: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   12290: aload_0
    //   12291: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   12294: invokevirtual 2046	zon:a	()V
    //   12297: aload_0
    //   12298: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   12301: aload_2
    //   12302: aload_1
    //   12303: aload 4
    //   12305: new 3772	auwg
    //   12308: dup
    //   12309: aload_0
    //   12310: aload_2
    //   12311: aload_1
    //   12312: invokespecial 3775	auwg:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;)V
    //   12315: invokevirtual 3778	zon:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lzop;)V
    //   12318: goto -12134 -> 184
    //   12321: astore_1
    //   12322: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12325: ifeq -12141 -> 184
    //   12328: ldc 209
    //   12330: iconst_2
    //   12331: new 551	java/lang/StringBuilder
    //   12334: dup
    //   12335: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12338: ldc_w 3780
    //   12341: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12344: aload 5
    //   12346: iconst_0
    //   12347: aaload
    //   12348: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12351: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12354: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12357: goto -12173 -> 184
    //   12360: ldc_w 3782
    //   12363: aload 4
    //   12365: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12368: ifeq +455 -> 12823
    //   12371: aload 5
    //   12373: arraylength
    //   12374: iconst_1
    //   12375: if_icmpne +448 -> 12823
    //   12378: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12381: ifeq +33 -> 12414
    //   12384: ldc_w 3702
    //   12387: iconst_2
    //   12388: new 551	java/lang/StringBuilder
    //   12391: dup
    //   12392: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12395: ldc_w 3784
    //   12398: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12401: aload 5
    //   12403: iconst_0
    //   12404: aaload
    //   12405: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12408: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12411: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12414: new 113	org/json/JSONObject
    //   12417: dup
    //   12418: aload 5
    //   12420: iconst_0
    //   12421: aaload
    //   12422: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12425: astore_3
    //   12426: aload_3
    //   12427: ldc_w 3698
    //   12430: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12433: astore_1
    //   12434: aload_3
    //   12435: ldc_w 3700
    //   12438: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12441: astore_2
    //   12442: aload_3
    //   12443: ldc_w 3786
    //   12446: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12449: astore_3
    //   12450: aload_2
    //   12451: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12454: ifne +10 -> 12464
    //   12457: aload_3
    //   12458: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12461: ifeq +49 -> 12510
    //   12464: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12467: ifeq +5125 -> 17592
    //   12470: ldc_w 3702
    //   12473: iconst_2
    //   12474: new 551	java/lang/StringBuilder
    //   12477: dup
    //   12478: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12481: ldc_w 3788
    //   12484: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12487: aload_3
    //   12488: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12491: ldc_w 3790
    //   12494: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12497: aload_2
    //   12498: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12501: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12504: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12507: goto +5085 -> 17592
    //   12510: aload_0
    //   12511: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   12514: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   12517: astore 4
    //   12519: aload 4
    //   12521: ifnull +11 -> 12532
    //   12524: aload 4
    //   12526: invokevirtual 3708	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnzn;
    //   12529: ifnonnull +22 -> 12551
    //   12532: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12535: ifeq +5059 -> 17594
    //   12538: ldc_w 3702
    //   12541: iconst_2
    //   12542: ldc_w 3792
    //   12545: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12548: goto +5046 -> 17594
    //   12551: aload 4
    //   12553: invokevirtual 3708	com/tencent/biz/pubaccount/CustomWebView:getOpenApiTokenInfo	()Lnzn;
    //   12556: getfield 3713	nzn:jdField_a_of_type_Int	I
    //   12559: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12562: astore 4
    //   12564: new 3715	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   12567: dup
    //   12568: invokespecial 3716	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   12571: astore 14
    //   12573: aload 14
    //   12575: getfield 3719	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_command	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12578: sipush 1814
    //   12581: invokevirtual 686	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12584: aload 14
    //   12586: getfield 3722	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12589: bipush 48
    //   12591: invokevirtual 686	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   12594: aload_3
    //   12595: invokevirtual 3725	java/lang/String:getBytes	()[B
    //   12598: arraylength
    //   12599: bipush 6
    //   12601: iadd
    //   12602: invokestatic 3731	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   12605: astore 15
    //   12607: aload 15
    //   12609: aload 4
    //   12611: invokevirtual 2624	java/lang/Integer:intValue	()I
    //   12614: invokevirtual 3733	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   12617: pop
    //   12618: aload 15
    //   12620: aload_3
    //   12621: invokevirtual 3725	java/lang/String:getBytes	()[B
    //   12624: arraylength
    //   12625: i2s
    //   12626: invokevirtual 3737	java/nio/ByteBuffer:putShort	(S)Ljava/nio/ByteBuffer;
    //   12629: pop
    //   12630: aload 15
    //   12632: aload_3
    //   12633: invokevirtual 3725	java/lang/String:getBytes	()[B
    //   12636: invokevirtual 3740	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   12639: pop
    //   12640: aload 14
    //   12642: getfield 3744	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12645: aload 15
    //   12647: invokevirtual 3747	java/nio/ByteBuffer:array	()[B
    //   12650: invokestatic 3753	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12653: invokevirtual 3758	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   12656: new 704	mqq/app/NewIntent
    //   12659: dup
    //   12660: aload_0
    //   12661: invokevirtual 2205	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Landroid/content/Context;
    //   12664: ldc_w 706
    //   12667: invokespecial 707	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   12670: astore_3
    //   12671: aload_3
    //   12672: new 301	android/os/Bundle
    //   12675: dup
    //   12676: invokespecial 302	android/os/Bundle:<init>	()V
    //   12679: invokevirtual 3759	mqq/app/NewIntent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   12682: pop
    //   12683: aload_3
    //   12684: ldc_w 712
    //   12687: ldc_w 3761
    //   12690: invokevirtual 715	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   12693: pop
    //   12694: aload_3
    //   12695: ldc 198
    //   12697: aload 14
    //   12699: invokevirtual 3762	tencent/im/oidb/oidb_sso$OIDBSSOPkg:toByteArray	()[B
    //   12702: invokevirtual 722	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   12705: pop
    //   12706: aload_3
    //   12707: ldc_w 3764
    //   12710: iconst_1
    //   12711: invokevirtual 3765	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12714: pop
    //   12715: aload_3
    //   12716: new 3794	auwh
    //   12719: dup
    //   12720: aload_0
    //   12721: aload 4
    //   12723: aload_2
    //   12724: aload_1
    //   12725: invokespecial 3797	auwh:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V
    //   12728: invokevirtual 731	mqq/app/NewIntent:setObserver	(Lmqq/observer/BusinessObserver;)V
    //   12731: aload_0
    //   12732: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   12735: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   12738: aload_3
    //   12739: invokevirtual 737	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   12742: goto -12558 -> 184
    //   12745: astore_1
    //   12746: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12749: ifeq -12565 -> 184
    //   12752: ldc 209
    //   12754: iconst_2
    //   12755: new 551	java/lang/StringBuilder
    //   12758: dup
    //   12759: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12762: ldc_w 3770
    //   12765: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12768: aload 5
    //   12770: iconst_0
    //   12771: aaload
    //   12772: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12775: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12778: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12781: goto -12597 -> 184
    //   12784: astore_1
    //   12785: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12788: ifeq -12604 -> 184
    //   12791: ldc 209
    //   12793: iconst_2
    //   12794: new 551	java/lang/StringBuilder
    //   12797: dup
    //   12798: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12801: ldc_w 3780
    //   12804: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12807: aload 5
    //   12809: iconst_0
    //   12810: aaload
    //   12811: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12814: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12817: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12820: goto -12636 -> 184
    //   12823: ldc_w 3799
    //   12826: aload 4
    //   12828: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12831: ifeq +200 -> 13031
    //   12834: aload_0
    //   12835: new 113	org/json/JSONObject
    //   12838: dup
    //   12839: aload 5
    //   12841: iconst_0
    //   12842: aaload
    //   12843: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12846: ldc_w 811
    //   12849: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12852: putfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12855: aload_0
    //   12856: invokevirtual 2601	com/tencent/mobileqq/jsp/UiApiPlugin:a	()Lbgzt;
    //   12859: astore_1
    //   12860: aload_1
    //   12861: ifnull -12677 -> 184
    //   12864: aload_1
    //   12865: invokeinterface 3802 1 0
    //   12870: istore 6
    //   12872: aload_0
    //   12873: aload_0
    //   12874: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12877: iconst_1
    //   12878: anewarray 285	java/lang/String
    //   12881: dup
    //   12882: iconst_0
    //   12883: new 551	java/lang/StringBuilder
    //   12886: dup
    //   12887: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12890: ldc_w 3804
    //   12893: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12896: iload 6
    //   12898: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12901: ldc_w 1801
    //   12904: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12907: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12910: aastore
    //   12911: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12914: goto -12730 -> 184
    //   12917: astore_1
    //   12918: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12921: ifeq -12737 -> 184
    //   12924: aload_0
    //   12925: aload_0
    //   12926: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12929: iconst_1
    //   12930: anewarray 285	java/lang/String
    //   12933: dup
    //   12934: iconst_0
    //   12935: ldc_w 3806
    //   12938: aastore
    //   12939: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12942: ldc 209
    //   12944: iconst_2
    //   12945: new 551	java/lang/StringBuilder
    //   12948: dup
    //   12949: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   12952: ldc_w 3808
    //   12955: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12958: aload_1
    //   12959: invokevirtual 3676	org/json/JSONException:toString	()Ljava/lang/String;
    //   12962: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12965: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12968: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12971: goto -12787 -> 184
    //   12974: astore_1
    //   12975: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12978: ifeq -12794 -> 184
    //   12981: aload_0
    //   12982: aload_0
    //   12983: getfield 2953	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   12986: iconst_1
    //   12987: anewarray 285	java/lang/String
    //   12990: dup
    //   12991: iconst_0
    //   12992: ldc_w 3806
    //   12995: aastore
    //   12996: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12999: ldc 209
    //   13001: iconst_2
    //   13002: new 551	java/lang/StringBuilder
    //   13005: dup
    //   13006: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13009: ldc_w 3808
    //   13012: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13015: aload_1
    //   13016: invokevirtual 1376	java/lang/Exception:toString	()Ljava/lang/String;
    //   13019: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13022: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13025: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13028: goto -12844 -> 184
    //   13031: ldc_w 3810
    //   13034: aload 4
    //   13036: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13039: ifeq +135 -> 13174
    //   13042: aload 5
    //   13044: arraylength
    //   13045: iconst_1
    //   13046: if_icmpgt +128 -> 13174
    //   13049: ldc_w 484
    //   13052: astore_1
    //   13053: aload 5
    //   13055: arraylength
    //   13056: iconst_1
    //   13057: if_icmpne +4386 -> 17443
    //   13060: new 113	org/json/JSONObject
    //   13063: dup
    //   13064: aload 5
    //   13066: iconst_0
    //   13067: aaload
    //   13068: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13071: astore_3
    //   13072: aload_3
    //   13073: ldc_w 427
    //   13076: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13079: astore_2
    //   13080: aload_2
    //   13081: astore_1
    //   13082: aload_3
    //   13083: ldc_w 1748
    //   13086: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   13089: ifeq +4354 -> 17443
    //   13092: aload_3
    //   13093: ldc_w 1748
    //   13096: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13099: astore_1
    //   13100: aload_0
    //   13101: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   13104: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   13107: astore_3
    //   13108: aload_3
    //   13109: ifnull -12925 -> 184
    //   13112: aload_3
    //   13113: instanceof 524
    //   13116: ifeq -12932 -> 184
    //   13119: aload_3
    //   13120: checkcast 524	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13123: invokevirtual 3199	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13126: checkcast 3201	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13129: iconst_0
    //   13130: aload_2
    //   13131: aload_1
    //   13132: invokevirtual 3813	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:a	(ZLjava/lang/String;Ljava/lang/String;)V
    //   13135: goto -12951 -> 184
    //   13138: astore_1
    //   13139: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13142: ifeq -12958 -> 184
    //   13145: ldc 209
    //   13147: iconst_4
    //   13148: new 551	java/lang/StringBuilder
    //   13151: dup
    //   13152: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13155: ldc_w 3815
    //   13158: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13161: aload_1
    //   13162: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13165: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13168: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13171: goto -12987 -> 184
    //   13174: ldc_w 3817
    //   13177: aload 4
    //   13179: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13182: ifeq +256 -> 13438
    //   13185: aload 5
    //   13187: arraylength
    //   13188: iconst_1
    //   13189: if_icmpgt +249 -> 13438
    //   13192: aload 5
    //   13194: arraylength
    //   13195: iconst_1
    //   13196: if_icmpne -13012 -> 184
    //   13199: new 113	org/json/JSONObject
    //   13202: dup
    //   13203: aload 5
    //   13205: iconst_0
    //   13206: aaload
    //   13207: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13210: astore_1
    //   13211: aload_1
    //   13212: ldc_w 3426
    //   13215: iconst_m1
    //   13216: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13219: istore 6
    //   13221: aload_1
    //   13222: ldc_w 3516
    //   13225: iconst_m1
    //   13226: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13229: istore 7
    //   13231: aload_0
    //   13232: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   13235: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   13238: astore_1
    //   13239: aload_1
    //   13240: ifnull -13056 -> 184
    //   13243: aload_1
    //   13244: instanceof 524
    //   13247: ifeq -13063 -> 184
    //   13250: aload_1
    //   13251: checkcast 524	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13254: invokevirtual 3199	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13257: checkcast 3201	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13260: astore_1
    //   13261: aload_1
    //   13262: ifnull -13078 -> 184
    //   13265: iload 7
    //   13267: iconst_1
    //   13268: if_icmpne +134 -> 13402
    //   13271: aload_1
    //   13272: iconst_0
    //   13273: putfield 3818	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13276: aload_1
    //   13277: iconst_1
    //   13278: invokevirtual 3819	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   13281: iload 6
    //   13283: iconst_1
    //   13284: if_icmpne +136 -> 13420
    //   13287: aload_1
    //   13288: iconst_0
    //   13289: putfield 3818	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13292: aload_1
    //   13293: iconst_1
    //   13294: invokevirtual 3821	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13297: goto -13113 -> 184
    //   13300: astore_1
    //   13301: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13304: ifeq -13120 -> 184
    //   13307: ldc 209
    //   13309: iconst_4
    //   13310: new 551	java/lang/StringBuilder
    //   13313: dup
    //   13314: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13317: ldc_w 3823
    //   13320: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13323: aload_1
    //   13324: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13327: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13330: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13333: goto -13149 -> 184
    //   13336: astore_2
    //   13337: ldc 209
    //   13339: iconst_1
    //   13340: new 551	java/lang/StringBuilder
    //   13343: dup
    //   13344: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13347: ldc_w 3825
    //   13350: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13353: aload_2
    //   13354: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13357: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13360: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13363: iconst_m1
    //   13364: istore 6
    //   13366: goto -145 -> 13221
    //   13369: astore_1
    //   13370: iconst_m1
    //   13371: istore 7
    //   13373: ldc 209
    //   13375: iconst_1
    //   13376: new 551	java/lang/StringBuilder
    //   13379: dup
    //   13380: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13383: ldc_w 3827
    //   13386: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13389: aload_1
    //   13390: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13393: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13396: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13399: goto -168 -> 13231
    //   13402: iload 7
    //   13404: ifne -123 -> 13281
    //   13407: aload_1
    //   13408: iconst_1
    //   13409: putfield 3818	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13412: aload_1
    //   13413: iconst_0
    //   13414: invokevirtual 3819	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:b	(Z)V
    //   13417: goto -136 -> 13281
    //   13420: iload 6
    //   13422: ifne -13238 -> 184
    //   13425: aload_1
    //   13426: iconst_1
    //   13427: putfield 3818	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:jdField_c_of_type_Boolean	Z
    //   13430: aload_1
    //   13431: iconst_0
    //   13432: invokevirtual 3821	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:c	(Z)V
    //   13435: goto -13251 -> 184
    //   13438: ldc_w 3829
    //   13441: aload 4
    //   13443: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13446: ifeq +168 -> 13614
    //   13449: aload 5
    //   13451: arraylength
    //   13452: iconst_1
    //   13453: if_icmpgt +161 -> 13614
    //   13456: aload 5
    //   13458: arraylength
    //   13459: iconst_1
    //   13460: if_icmpne -13276 -> 184
    //   13463: aload 5
    //   13465: arraylength
    //   13466: iconst_1
    //   13467: if_icmpne -13283 -> 184
    //   13470: new 113	org/json/JSONObject
    //   13473: dup
    //   13474: aload 5
    //   13476: iconst_0
    //   13477: aaload
    //   13478: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13481: ldc_w 3831
    //   13484: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   13487: astore_1
    //   13488: aload_0
    //   13489: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   13492: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   13495: astore_2
    //   13496: aload_2
    //   13497: ifnull -13313 -> 184
    //   13500: aload_2
    //   13501: instanceof 524
    //   13504: ifeq -13320 -> 184
    //   13507: aload_2
    //   13508: checkcast 524	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13511: invokevirtual 3199	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   13514: checkcast 3201	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment
    //   13517: astore_3
    //   13518: ldc_w 449
    //   13521: aload_1
    //   13522: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13525: ifeq +61 -> 13586
    //   13528: aload_2
    //   13529: ldc_w 2124
    //   13532: invokevirtual 2125	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13535: checkcast 2127	android/view/inputmethod/InputMethodManager
    //   13538: aload_3
    //   13539: invokevirtual 3834	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13542: iconst_0
    //   13543: invokevirtual 3838	android/view/inputmethod/InputMethodManager:showSoftInput	(Landroid/view/View;I)Z
    //   13546: pop
    //   13547: goto -13363 -> 184
    //   13550: astore_1
    //   13551: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13554: ifeq -13370 -> 184
    //   13557: ldc 209
    //   13559: iconst_4
    //   13560: new 551	java/lang/StringBuilder
    //   13563: dup
    //   13564: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13567: ldc_w 3840
    //   13570: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13573: aload_1
    //   13574: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13577: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13580: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13583: goto -13399 -> 184
    //   13586: aload_2
    //   13587: ldc_w 2124
    //   13590: invokevirtual 2125	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   13593: checkcast 2127	android/view/inputmethod/InputMethodManager
    //   13596: aload_2
    //   13597: invokevirtual 3226	android/app/Activity:getWindow	()Landroid/view/Window;
    //   13600: invokevirtual 3843	android/view/Window:getDecorView	()Landroid/view/View;
    //   13603: invokevirtual 3847	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   13606: iconst_0
    //   13607: invokevirtual 3851	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   13610: pop
    //   13611: goto -13427 -> 184
    //   13614: ldc_w 3853
    //   13617: aload 4
    //   13619: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13622: ifeq +96 -> 13718
    //   13625: aload 5
    //   13627: arraylength
    //   13628: iconst_1
    //   13629: if_icmpgt +89 -> 13718
    //   13632: aload 5
    //   13634: arraylength
    //   13635: iconst_1
    //   13636: if_icmpne -13452 -> 184
    //   13639: new 113	org/json/JSONObject
    //   13642: dup
    //   13643: aload 5
    //   13645: iconst_0
    //   13646: aaload
    //   13647: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13650: ldc_w 811
    //   13653: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13656: astore_1
    //   13657: aload_1
    //   13658: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13661: ifne -13477 -> 184
    //   13664: aload_0
    //   13665: aload_1
    //   13666: iconst_1
    //   13667: anewarray 285	java/lang/String
    //   13670: dup
    //   13671: iconst_0
    //   13672: ldc_w 3855
    //   13675: aastore
    //   13676: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   13679: goto -13495 -> 184
    //   13682: astore_1
    //   13683: invokestatic 880	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   13686: ifeq -13502 -> 184
    //   13689: ldc 209
    //   13691: iconst_4
    //   13692: new 551	java/lang/StringBuilder
    //   13695: dup
    //   13696: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13699: ldc_w 3857
    //   13702: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13705: aload_1
    //   13706: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13709: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13712: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13715: goto -13531 -> 184
    //   13718: ldc_w 3859
    //   13721: aload 4
    //   13723: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13726: ifeq +114 -> 13840
    //   13729: aload 5
    //   13731: arraylength
    //   13732: ifle +108 -> 13840
    //   13735: new 113	org/json/JSONObject
    //   13738: dup
    //   13739: aload 5
    //   13741: iconst_0
    //   13742: aaload
    //   13743: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13746: astore_3
    //   13747: aload_0
    //   13748: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   13751: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   13754: astore_1
    //   13755: aload_0
    //   13756: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   13759: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   13762: astore_2
    //   13763: aload_3
    //   13764: ldc_w 2719
    //   13767: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   13770: astore_3
    //   13771: aload_3
    //   13772: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13775: ifne -13591 -> 184
    //   13778: aload_1
    //   13779: ifnull -13595 -> 184
    //   13782: aload_2
    //   13783: ifnull -13599 -> 184
    //   13786: aload_1
    //   13787: new 3861	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   13790: dup
    //   13791: aload_3
    //   13792: bipush 90
    //   13794: invokespecial 3863	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   13797: invokestatic 3868	com/tencent/mobileqq/activity/ProfileActivity:b	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)V
    //   13800: goto -13616 -> 184
    //   13803: astore_1
    //   13804: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13807: ifeq -13623 -> 184
    //   13810: ldc_w 2687
    //   13813: iconst_2
    //   13814: new 551	java/lang/StringBuilder
    //   13817: dup
    //   13818: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13821: ldc_w 3870
    //   13824: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13827: aload_1
    //   13828: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13831: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13834: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13837: goto -13653 -> 184
    //   13840: ldc_w 3872
    //   13843: aload 4
    //   13845: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13848: ifeq +96 -> 13944
    //   13851: aload 5
    //   13853: arraylength
    //   13854: ifle +90 -> 13944
    //   13857: new 113	org/json/JSONObject
    //   13860: dup
    //   13861: aload 5
    //   13863: iconst_0
    //   13864: aaload
    //   13865: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13868: ldc_w 3874
    //   13871: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13874: istore 6
    //   13876: aload_0
    //   13877: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   13880: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   13883: astore_1
    //   13884: aload_1
    //   13885: ifnull -13701 -> 184
    //   13888: aload_1
    //   13889: instanceof 524
    //   13892: ifeq -13708 -> 184
    //   13895: aload_1
    //   13896: checkcast 524	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity
    //   13899: iload 6
    //   13901: invokevirtual 3875	com/tencent/mobileqq/activity/TeamWorkDocEditBrowserActivity:a	(I)V
    //   13904: goto -13720 -> 184
    //   13907: astore_1
    //   13908: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13911: ifeq -13727 -> 184
    //   13914: ldc_w 2687
    //   13917: iconst_2
    //   13918: new 551	java/lang/StringBuilder
    //   13921: dup
    //   13922: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   13925: ldc_w 3877
    //   13928: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13931: aload_1
    //   13932: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13935: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13938: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13941: goto -13757 -> 184
    //   13944: ldc_w 3879
    //   13947: aload 4
    //   13949: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13952: ifeq +267 -> 14219
    //   13955: aload 5
    //   13957: arraylength
    //   13958: ifle +261 -> 14219
    //   13961: new 113	org/json/JSONObject
    //   13964: dup
    //   13965: aload 5
    //   13967: iconst_0
    //   13968: aaload
    //   13969: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13972: astore_3
    //   13973: aload_3
    //   13974: ldc_w 3881
    //   13977: iconst_0
    //   13978: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   13981: iconst_1
    //   13982: if_icmpne +176 -> 14158
    //   13985: iconst_1
    //   13986: istore 12
    //   13988: aload_3
    //   13989: ldc_w 3883
    //   13992: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   13995: istore 6
    //   13997: aload_3
    //   13998: ldc_w 3885
    //   14001: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14004: istore 7
    //   14006: aload_3
    //   14007: ldc_w 3887
    //   14010: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14013: istore 8
    //   14015: aload_3
    //   14016: ldc_w 3889
    //   14019: iconst_1
    //   14020: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14023: iconst_1
    //   14024: if_icmpne +140 -> 14164
    //   14027: iconst_1
    //   14028: istore 13
    //   14030: aload_3
    //   14031: ldc_w 3891
    //   14034: aconst_null
    //   14035: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14038: astore_1
    //   14039: aload_3
    //   14040: ldc_w 3893
    //   14043: aconst_null
    //   14044: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14047: astore_2
    //   14048: aload_3
    //   14049: ldc_w 811
    //   14052: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14055: astore_3
    //   14056: aload_0
    //   14057: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14060: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14063: astore 5
    //   14065: aload_0
    //   14066: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14069: invokevirtual 1875	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   14072: astore 4
    //   14074: aload_0
    //   14075: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14078: aload 5
    //   14080: invokevirtual 1449	bgve:a	(Landroid/app/Activity;)Lbguj;
    //   14083: astore 5
    //   14085: aload 4
    //   14087: ifnull +83 -> 14170
    //   14090: aload 4
    //   14092: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   14095: ifnull +75 -> 14170
    //   14098: aload 4
    //   14100: getfield 3087	com/tencent/mobileqq/webview/swift/WebViewFragment:mUIStyleHandler	Lcom/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler;
    //   14103: iload 12
    //   14105: iload 6
    //   14107: iload 7
    //   14109: iload 8
    //   14111: iload 13
    //   14113: aload_1
    //   14114: aload_2
    //   14115: aload_3
    //   14116: invokevirtual 3896	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:setTitleBarScrollChange	(ZIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   14119: goto -13935 -> 184
    //   14122: astore_1
    //   14123: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14126: ifeq -13942 -> 184
    //   14129: ldc 209
    //   14131: iconst_2
    //   14132: new 551	java/lang/StringBuilder
    //   14135: dup
    //   14136: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   14139: ldc_w 3898
    //   14142: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14145: aload_1
    //   14146: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14149: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14152: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14155: goto -13971 -> 184
    //   14158: iconst_0
    //   14159: istore 12
    //   14161: goto -173 -> 13988
    //   14164: iconst_0
    //   14165: istore 13
    //   14167: goto -137 -> 14030
    //   14170: aload 5
    //   14172: ifnull -13988 -> 184
    //   14175: aload 5
    //   14177: instanceof 1788
    //   14180: ifeq -13996 -> 184
    //   14183: aload 5
    //   14185: checkcast 1788	bgzm
    //   14188: iload 12
    //   14190: iload 6
    //   14192: iload 7
    //   14194: iload 8
    //   14196: iload 13
    //   14198: aload_1
    //   14199: aload_2
    //   14200: aload_3
    //   14201: aload_0
    //   14202: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14205: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14208: invokevirtual 1791	java/lang/Object:hashCode	()I
    //   14211: invokeinterface 3901 10 0
    //   14216: goto -14032 -> 184
    //   14219: ldc_w 3903
    //   14222: aload 4
    //   14224: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14227: ifeq +162 -> 14389
    //   14230: aload 5
    //   14232: arraylength
    //   14233: ifle +156 -> 14389
    //   14236: new 113	org/json/JSONObject
    //   14239: dup
    //   14240: aload 5
    //   14242: iconst_0
    //   14243: aaload
    //   14244: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14247: ldc_w 1726
    //   14250: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14253: istore 6
    //   14255: aload_0
    //   14256: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14259: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   14262: astore_2
    //   14263: aload_2
    //   14264: ifnull -14080 -> 184
    //   14267: iload 6
    //   14269: ifne +24 -> 14293
    //   14272: aload_2
    //   14273: invokevirtual 3906	com/tencent/biz/pubaccount/CustomWebView:reload	()V
    //   14276: goto -14092 -> 184
    //   14279: astore_1
    //   14280: ldc 209
    //   14282: iconst_2
    //   14283: ldc_w 3908
    //   14286: aload_1
    //   14287: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14290: goto -14106 -> 184
    //   14293: aload_0
    //   14294: iconst_4
    //   14295: invokevirtual 2857	com/tencent/mobileqq/jsp/UiApiPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   14298: checkcast 3910	bgww
    //   14301: astore_1
    //   14302: aload_1
    //   14303: ifnull -14119 -> 184
    //   14306: aload_2
    //   14307: invokevirtual 3913	com/tencent/biz/pubaccount/CustomWebView:getOriginalUrl	()Ljava/lang/String;
    //   14310: astore_2
    //   14311: aload_1
    //   14312: getfield 3916	bgww:a	Laadf;
    //   14315: ifnonnull +28 -> 14343
    //   14318: aload_1
    //   14319: new 2177	aadf
    //   14322: dup
    //   14323: aload_0
    //   14324: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14327: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   14330: aload_0
    //   14331: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14334: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14337: invokespecial 3919	aadf:<init>	(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;)V
    //   14340: putfield 3916	bgww:a	Laadf;
    //   14343: iload 6
    //   14345: iconst_1
    //   14346: if_icmpne +20 -> 14366
    //   14349: aload_1
    //   14350: bipush 6
    //   14352: aload_2
    //   14353: new 301	android/os/Bundle
    //   14356: dup
    //   14357: invokespecial 302	android/os/Bundle:<init>	()V
    //   14360: invokevirtual 3922	bgww:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14363: goto -14179 -> 184
    //   14366: iload 6
    //   14368: iconst_2
    //   14369: if_icmpne -14185 -> 184
    //   14372: aload_1
    //   14373: bipush 11
    //   14375: aload_2
    //   14376: new 301	android/os/Bundle
    //   14379: dup
    //   14380: invokespecial 302	android/os/Bundle:<init>	()V
    //   14383: invokevirtual 3922	bgww:a	(ILjava/lang/String;Landroid/os/Bundle;)V
    //   14386: goto -14202 -> 184
    //   14389: ldc_w 3924
    //   14392: aload 4
    //   14394: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14397: ifeq +62 -> 14459
    //   14400: new 129	android/content/Intent
    //   14403: dup
    //   14404: aload_0
    //   14405: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14408: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14411: ldc_w 3926
    //   14414: invokespecial 391	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   14417: astore_1
    //   14418: aload_1
    //   14419: ldc_w 3928
    //   14422: aload 5
    //   14424: iconst_0
    //   14425: aaload
    //   14426: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14429: pop
    //   14430: aload_0
    //   14431: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14434: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14437: aload_1
    //   14438: sipush 11533
    //   14441: invokevirtual 408	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14444: aload_0
    //   14445: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14448: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14451: iconst_0
    //   14452: iconst_0
    //   14453: invokevirtual 414	android/app/Activity:overridePendingTransition	(II)V
    //   14456: goto -14272 -> 184
    //   14459: ldc_w 3930
    //   14462: aload 4
    //   14464: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14467: ifeq +177 -> 14644
    //   14470: new 113	org/json/JSONObject
    //   14473: dup
    //   14474: aload 5
    //   14476: iconst_0
    //   14477: aaload
    //   14478: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14481: astore_2
    //   14482: aload_2
    //   14483: ldc 160
    //   14485: ldc_w 484
    //   14488: invokevirtual 928	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14491: astore_1
    //   14492: aload_0
    //   14493: aload_2
    //   14494: ldc_w 811
    //   14497: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14500: putfield 2645	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14503: aload_1
    //   14504: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14507: ifeq +65 -> 14572
    //   14510: new 113	org/json/JSONObject
    //   14513: dup
    //   14514: invokespecial 172	org/json/JSONObject:<init>	()V
    //   14517: astore_1
    //   14518: aload_1
    //   14519: ldc 217
    //   14521: iconst_m1
    //   14522: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14525: pop
    //   14526: aload_1
    //   14527: ldc 198
    //   14529: ldc_w 484
    //   14532: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14535: pop
    //   14536: aload_0
    //   14537: aload_0
    //   14538: getfield 2645	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   14541: iconst_1
    //   14542: anewarray 285	java/lang/String
    //   14545: dup
    //   14546: iconst_0
    //   14547: aload_1
    //   14548: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14551: aastore
    //   14552: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14555: goto -14371 -> 184
    //   14558: astore_1
    //   14559: ldc 209
    //   14561: iconst_1
    //   14562: ldc_w 3932
    //   14565: aload_1
    //   14566: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14569: goto -14385 -> 184
    //   14572: aload_2
    //   14573: ldc_w 3934
    //   14576: iconst_0
    //   14577: invokevirtual 889	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   14580: istore 6
    //   14582: new 129	android/content/Intent
    //   14585: dup
    //   14586: invokespecial 496	android/content/Intent:<init>	()V
    //   14589: astore_2
    //   14590: iload 6
    //   14592: ifne +38 -> 14630
    //   14595: aload_2
    //   14596: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14599: ldc_w 388
    //   14602: invokevirtual 3938	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14605: pop
    //   14606: aload_2
    //   14607: ldc 160
    //   14609: aload_1
    //   14610: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14613: pop
    //   14614: aload_0
    //   14615: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14618: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14621: aload_2
    //   14622: bipush 14
    //   14624: invokevirtual 408	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   14627: goto -14443 -> 184
    //   14630: aload_2
    //   14631: invokestatic 980	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   14634: ldc_w 547
    //   14637: invokevirtual 3938	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   14640: pop
    //   14641: goto -35 -> 14606
    //   14644: ldc_w 3940
    //   14647: aload 4
    //   14649: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14652: ifeq +61 -> 14713
    //   14655: new 113	org/json/JSONObject
    //   14658: dup
    //   14659: aload 5
    //   14661: iconst_0
    //   14662: aaload
    //   14663: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14666: ldc 198
    //   14668: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14671: astore_1
    //   14672: aload_0
    //   14673: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   14676: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   14679: iconst_m1
    //   14680: new 129	android/content/Intent
    //   14683: dup
    //   14684: invokespecial 496	android/content/Intent:<init>	()V
    //   14687: ldc 198
    //   14689: aload_1
    //   14690: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   14693: invokevirtual 653	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   14696: goto -14512 -> 184
    //   14699: astore_1
    //   14700: ldc 209
    //   14702: iconst_1
    //   14703: ldc_w 3942
    //   14706: aload_1
    //   14707: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14710: goto -14526 -> 184
    //   14713: ldc_w 3944
    //   14716: aload 4
    //   14718: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14721: ifne -14537 -> 184
    //   14724: ldc_w 3946
    //   14727: aload 4
    //   14729: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14732: ifeq +99 -> 14831
    //   14735: new 113	org/json/JSONObject
    //   14738: dup
    //   14739: aload 5
    //   14741: iconst_0
    //   14742: aaload
    //   14743: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14746: astore_2
    //   14747: aload_2
    //   14748: ldc_w 811
    //   14751: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14754: astore_1
    //   14755: aload_2
    //   14756: ldc_w 3516
    //   14759: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14762: iconst_0
    //   14763: iconst_0
    //   14764: invokestatic 3951	bgoa:a	(Ljava/lang/String;ZZ)Lbgob;
    //   14767: astore_2
    //   14768: new 113	org/json/JSONObject
    //   14771: dup
    //   14772: invokespecial 172	org/json/JSONObject:<init>	()V
    //   14775: astore_3
    //   14776: aload_3
    //   14777: ldc 217
    //   14779: aload_2
    //   14780: getfield 3954	bgob:jdField_a_of_type_Int	I
    //   14783: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14786: pop
    //   14787: aload_3
    //   14788: ldc 160
    //   14790: aload_2
    //   14791: getfield 3955	bgob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14794: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   14797: pop
    //   14798: aload_0
    //   14799: aload_1
    //   14800: iconst_1
    //   14801: anewarray 285	java/lang/String
    //   14804: dup
    //   14805: iconst_0
    //   14806: aload_3
    //   14807: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14810: aastore
    //   14811: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14814: goto -14630 -> 184
    //   14817: astore_1
    //   14818: ldc 209
    //   14820: iconst_1
    //   14821: ldc_w 3957
    //   14824: aload_1
    //   14825: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14828: goto -14644 -> 184
    //   14831: ldc_w 3959
    //   14834: aload 4
    //   14836: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14839: ifeq +221 -> 15060
    //   14842: new 113	org/json/JSONObject
    //   14845: dup
    //   14846: aload 5
    //   14848: iconst_0
    //   14849: aaload
    //   14850: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   14853: astore_2
    //   14854: aload_2
    //   14855: ldc_w 811
    //   14858: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14861: astore_1
    //   14862: aload_2
    //   14863: ldc 174
    //   14865: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   14868: istore 6
    //   14870: aload_2
    //   14871: ldc_w 3516
    //   14874: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   14877: astore_2
    //   14878: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14881: ifeq +40 -> 14921
    //   14884: ldc 209
    //   14886: iconst_2
    //   14887: new 551	java/lang/StringBuilder
    //   14890: dup
    //   14891: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   14894: ldc_w 3961
    //   14897: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14900: iload 6
    //   14902: invokevirtual 1721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14905: ldc_w 3963
    //   14908: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14911: aload_2
    //   14912: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14915: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14918: invokestatic 884	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14921: aload_2
    //   14922: iconst_0
    //   14923: iconst_1
    //   14924: invokestatic 3951	bgoa:a	(Ljava/lang/String;ZZ)Lbgob;
    //   14927: astore_3
    //   14928: new 113	org/json/JSONObject
    //   14931: dup
    //   14932: invokespecial 172	org/json/JSONObject:<init>	()V
    //   14935: astore 4
    //   14937: aload_3
    //   14938: getfield 3954	bgob:jdField_a_of_type_Int	I
    //   14941: iconst_1
    //   14942: if_icmpne +46 -> 14988
    //   14945: aload 4
    //   14947: ldc 217
    //   14949: iconst_2
    //   14950: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   14953: pop
    //   14954: aload_0
    //   14955: aload_1
    //   14956: iconst_1
    //   14957: anewarray 285	java/lang/String
    //   14960: dup
    //   14961: iconst_0
    //   14962: aload 4
    //   14964: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   14967: aastore
    //   14968: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   14971: goto -14787 -> 184
    //   14974: astore_1
    //   14975: ldc 209
    //   14977: iconst_1
    //   14978: ldc_w 3965
    //   14981: aload_1
    //   14982: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14985: goto -14801 -> 184
    //   14988: aload_3
    //   14989: getfield 3954	bgob:jdField_a_of_type_Int	I
    //   14992: iconst_4
    //   14993: if_icmpne +32 -> 15025
    //   14996: aload 4
    //   14998: ldc 217
    //   15000: iconst_0
    //   15001: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15004: pop
    //   15005: aload_0
    //   15006: aload_1
    //   15007: iconst_1
    //   15008: anewarray 285	java/lang/String
    //   15011: dup
    //   15012: iconst_0
    //   15013: aload 4
    //   15015: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15018: aastore
    //   15019: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15022: goto -14838 -> 184
    //   15025: new 3967	bgnz
    //   15028: dup
    //   15029: aload_0
    //   15030: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15033: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15036: aload_0
    //   15037: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15040: invokevirtual 1678	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   15043: aload_1
    //   15044: iload 6
    //   15046: aload_2
    //   15047: aload_3
    //   15048: getfield 3954	bgob:jdField_a_of_type_Int	I
    //   15051: invokespecial 3970	bgnz:<init>	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/CustomWebView;Ljava/lang/String;ILjava/lang/String;I)V
    //   15054: invokevirtual 3971	bgnz:show	()V
    //   15057: goto -14873 -> 184
    //   15060: ldc_w 3973
    //   15063: aload 4
    //   15065: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15068: ifeq +93 -> 15161
    //   15071: new 113	org/json/JSONObject
    //   15074: dup
    //   15075: aload 5
    //   15077: iconst_0
    //   15078: aaload
    //   15079: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15082: astore_2
    //   15083: aload_2
    //   15084: ldc_w 811
    //   15087: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15090: astore_1
    //   15091: aload_2
    //   15092: ldc_w 3516
    //   15095: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15098: astore_2
    //   15099: new 113	org/json/JSONObject
    //   15102: dup
    //   15103: invokespecial 172	org/json/JSONObject:<init>	()V
    //   15106: astore_3
    //   15107: aload_3
    //   15108: ldc 217
    //   15110: invokestatic 3974	bgoa:a	()I
    //   15113: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15116: pop
    //   15117: aload_3
    //   15118: ldc 160
    //   15120: aload_2
    //   15121: invokestatic 3975	bgoa:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15124: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15127: pop
    //   15128: aload_0
    //   15129: aload_1
    //   15130: iconst_1
    //   15131: anewarray 285	java/lang/String
    //   15134: dup
    //   15135: iconst_0
    //   15136: aload_3
    //   15137: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15140: aastore
    //   15141: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15144: goto -14960 -> 184
    //   15147: astore_1
    //   15148: ldc 209
    //   15150: iconst_1
    //   15151: ldc_w 3957
    //   15154: aload_1
    //   15155: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15158: goto -14974 -> 184
    //   15161: ldc_w 3977
    //   15164: aload 4
    //   15166: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15169: ifeq +128 -> 15297
    //   15172: new 113	org/json/JSONObject
    //   15175: dup
    //   15176: aload 5
    //   15178: iconst_0
    //   15179: aaload
    //   15180: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15183: astore_1
    //   15184: aload_1
    //   15185: ldc_w 3426
    //   15188: invokevirtual 3147	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   15191: istore 12
    //   15193: aload_1
    //   15194: ldc_w 3979
    //   15197: invokevirtual 425	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   15200: astore_1
    //   15201: aload_1
    //   15202: ifnull -15018 -> 184
    //   15205: aload_1
    //   15206: ldc_w 1805
    //   15209: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15212: istore 6
    //   15214: aload_1
    //   15215: ldc_w 1807
    //   15218: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15221: istore 7
    //   15223: new 1809	android/graphics/Rect
    //   15226: dup
    //   15227: iload 6
    //   15229: iload 7
    //   15231: aload_1
    //   15232: ldc_w 1811
    //   15235: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15238: iload 6
    //   15240: iadd
    //   15241: aload_1
    //   15242: ldc_w 1813
    //   15245: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15248: iload 7
    //   15250: iadd
    //   15251: invokespecial 1815	android/graphics/Rect:<init>	(IIII)V
    //   15254: astore_1
    //   15255: aload_0
    //   15256: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15259: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15262: astore_2
    //   15263: aload_2
    //   15264: instanceof 623
    //   15267: ifeq -15083 -> 184
    //   15270: aload_2
    //   15271: checkcast 623	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity
    //   15274: aload_1
    //   15275: iload 12
    //   15277: invokevirtual 3982	com/tencent/biz/pubaccount/ecshopassit/EcshopWebActivity:a	(Landroid/graphics/Rect;Z)V
    //   15280: goto -15096 -> 184
    //   15283: astore_1
    //   15284: ldc 209
    //   15286: iconst_1
    //   15287: ldc_w 3984
    //   15290: aload_1
    //   15291: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15294: goto -15110 -> 184
    //   15297: ldc_w 3986
    //   15300: aload 4
    //   15302: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15305: ifeq +56 -> 15361
    //   15308: new 113	org/json/JSONObject
    //   15311: dup
    //   15312: aload 5
    //   15314: iconst_0
    //   15315: aaload
    //   15316: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15319: astore_1
    //   15320: aload_1
    //   15321: ifnonnull +21 -> 15342
    //   15324: iconst_1
    //   15325: ireturn
    //   15326: astore_1
    //   15327: ldc 209
    //   15329: iconst_1
    //   15330: ldc_w 3988
    //   15333: aload_1
    //   15334: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15337: aconst_null
    //   15338: astore_1
    //   15339: goto -19 -> 15320
    //   15342: invokestatic 3991	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   15345: new 3993	com/tencent/mobileqq/jsp/UiApiPlugin$8
    //   15348: dup
    //   15349: aload_0
    //   15350: aload_1
    //   15351: invokespecial 3994	com/tencent/mobileqq/jsp/UiApiPlugin$8:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Lorg/json/JSONObject;)V
    //   15354: invokevirtual 1331	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   15357: pop
    //   15358: goto -15174 -> 184
    //   15361: ldc_w 3996
    //   15364: aload 4
    //   15366: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15369: ifeq +117 -> 15486
    //   15372: new 113	org/json/JSONObject
    //   15375: dup
    //   15376: aload 5
    //   15378: iconst_0
    //   15379: aaload
    //   15380: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15383: astore_1
    //   15384: aload_0
    //   15385: aload_1
    //   15386: ldc_w 811
    //   15389: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15392: putfield 3998	com/tencent/mobileqq/jsp/UiApiPlugin:j	Ljava/lang/String;
    //   15395: aload_1
    //   15396: ldc_w 3700
    //   15399: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15402: astore_2
    //   15403: aload_1
    //   15404: ldc_w 4000
    //   15407: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15410: astore_3
    //   15411: aload_1
    //   15412: ldc_w 4002
    //   15415: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15418: astore 4
    //   15420: aload_1
    //   15421: ldc_w 4004
    //   15424: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15427: astore 5
    //   15429: aload_1
    //   15430: ldc_w 4006
    //   15433: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15436: istore 6
    //   15438: aload_0
    //   15439: aload_0
    //   15440: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15443: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15446: iconst_3
    //   15447: aload_2
    //   15448: aload_3
    //   15449: sipush 3016
    //   15452: iload 6
    //   15454: aload 4
    //   15456: aload 5
    //   15458: aconst_null
    //   15459: aconst_null
    //   15460: aconst_null
    //   15461: invokestatic 4011	com/tencent/mobileqq/activity/AddFriendLogicActivity:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15464: bipush 16
    //   15466: invokevirtual 2031	com/tencent/mobileqq/jsp/UiApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   15469: goto -15285 -> 184
    //   15472: astore_1
    //   15473: ldc 209
    //   15475: iconst_1
    //   15476: ldc_w 4013
    //   15479: aload_1
    //   15480: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15483: goto -15299 -> 184
    //   15486: ldc_w 4015
    //   15489: aload 4
    //   15491: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15494: ifeq +178 -> 15672
    //   15497: new 113	org/json/JSONObject
    //   15500: dup
    //   15501: aload 5
    //   15503: iconst_0
    //   15504: aaload
    //   15505: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15508: astore_3
    //   15509: aload_3
    //   15510: ldc_w 4017
    //   15513: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15516: astore_1
    //   15517: aload_3
    //   15518: ldc_w 2471
    //   15521: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15524: astore_2
    //   15525: aload_3
    //   15526: ldc_w 2480
    //   15529: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15532: astore_3
    //   15533: aload_1
    //   15534: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15537: ifne +69 -> 15606
    //   15540: new 1570	java/io/File
    //   15543: dup
    //   15544: aload_1
    //   15545: invokespecial 2009	java/io/File:<init>	(Ljava/lang/String;)V
    //   15548: astore_1
    //   15549: aload_1
    //   15550: invokevirtual 2369	java/io/File:exists	()Z
    //   15553: ifne +45 -> 15598
    //   15556: aload_0
    //   15557: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15560: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   15563: invokevirtual 2330	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15566: iconst_1
    //   15567: ldc_w 4018
    //   15570: invokestatic 2335	amtj:a	(I)Ljava/lang/String;
    //   15573: iconst_0
    //   15574: invokestatic 892	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15577: invokevirtual 2338	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15580: pop
    //   15581: goto -15397 -> 184
    //   15584: astore_1
    //   15585: ldc 209
    //   15587: iconst_1
    //   15588: ldc_w 4020
    //   15591: aload_1
    //   15592: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15595: goto -15411 -> 184
    //   15598: aload_0
    //   15599: aload_1
    //   15600: invokevirtual 2011	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/io/File;)V
    //   15603: goto -15419 -> 184
    //   15606: aload_2
    //   15607: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15610: ifne +19 -> 15629
    //   15613: aload_0
    //   15614: aload_2
    //   15615: iconst_0
    //   15616: invokestatic 1069	bfuc:decode	(Ljava/lang/String;I)[B
    //   15619: aload_2
    //   15620: invokestatic 2476	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   15623: invokevirtual 4022	com/tencent/mobileqq/jsp/UiApiPlugin:a	([BLjava/lang/String;)V
    //   15626: goto -15442 -> 184
    //   15629: aload_3
    //   15630: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15633: ifne +11 -> 15644
    //   15636: aload_0
    //   15637: aload_3
    //   15638: invokevirtual 4024	com/tencent/mobileqq/jsp/UiApiPlugin:c	(Ljava/lang/String;)V
    //   15641: goto -15457 -> 184
    //   15644: aload_0
    //   15645: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15648: invokevirtual 1688	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   15651: invokevirtual 2330	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   15654: iconst_1
    //   15655: ldc_w 4025
    //   15658: invokestatic 2335	amtj:a	(I)Ljava/lang/String;
    //   15661: iconst_0
    //   15662: invokestatic 892	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   15665: invokevirtual 2338	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   15668: pop
    //   15669: goto -15485 -> 184
    //   15672: ldc_w 4027
    //   15675: aload 4
    //   15677: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15680: ifeq +44 -> 15724
    //   15683: aload_0
    //   15684: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15687: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15690: iconst_m1
    //   15691: new 129	android/content/Intent
    //   15694: dup
    //   15695: invokespecial 496	android/content/Intent:<init>	()V
    //   15698: ldc_w 4029
    //   15701: aload 5
    //   15703: iconst_0
    //   15704: aaload
    //   15705: invokevirtual 158	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   15708: invokevirtual 653	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   15711: aload_0
    //   15712: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15715: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15718: invokevirtual 656	android/app/Activity:finish	()V
    //   15721: goto -15537 -> 184
    //   15724: ldc_w 4031
    //   15727: aload 4
    //   15729: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15732: ifeq +13 -> 15745
    //   15735: aload_0
    //   15736: aload 5
    //   15738: iconst_0
    //   15739: aaload
    //   15740: invokevirtual 4033	com/tencent/mobileqq/jsp/UiApiPlugin:d	(Ljava/lang/String;)V
    //   15743: iconst_1
    //   15744: ireturn
    //   15745: ldc_w 4035
    //   15748: aload 4
    //   15750: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15753: ifeq +102 -> 15855
    //   15756: aload 5
    //   15758: arraylength
    //   15759: iconst_1
    //   15760: if_icmpne +95 -> 15855
    //   15763: new 113	org/json/JSONObject
    //   15766: dup
    //   15767: aload 5
    //   15769: iconst_0
    //   15770: aaload
    //   15771: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15774: astore_1
    //   15775: aload_1
    //   15776: ldc_w 811
    //   15779: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15782: astore_2
    //   15783: new 4037	bfhh
    //   15786: dup
    //   15787: aload_1
    //   15788: ldc_w 4039
    //   15791: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15794: aload_1
    //   15795: ldc_w 4041
    //   15798: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15801: aload_1
    //   15802: ldc_w 4043
    //   15805: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15808: aload_1
    //   15809: ldc_w 4045
    //   15812: invokevirtual 117	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   15815: aload_1
    //   15816: ldc_w 4047
    //   15819: invokevirtual 2694	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   15822: invokespecial 4050	bfhh:<init>	(IIIIJ)V
    //   15825: aload_0
    //   15826: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15829: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15832: new 4052	auwk
    //   15835: dup
    //   15836: aload_0
    //   15837: aload_2
    //   15838: invokespecial 4053	auwk:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   15841: invokevirtual 4056	bfhh:a	(Landroid/app/Activity;Lbfhl;)V
    //   15844: goto -15660 -> 184
    //   15847: astore_1
    //   15848: aload_1
    //   15849: invokevirtual 2861	org/json/JSONException:printStackTrace	()V
    //   15852: goto -15668 -> 184
    //   15855: ldc_w 4058
    //   15858: aload 4
    //   15860: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15863: ifeq +102 -> 15965
    //   15866: new 113	org/json/JSONObject
    //   15869: dup
    //   15870: aload 5
    //   15872: iconst_0
    //   15873: aaload
    //   15874: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15877: ldc_w 811
    //   15880: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15883: astore_1
    //   15884: new 113	org/json/JSONObject
    //   15887: dup
    //   15888: invokespecial 172	org/json/JSONObject:<init>	()V
    //   15891: astore_2
    //   15892: aload_0
    //   15893: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   15896: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   15899: astore_3
    //   15900: aload_3
    //   15901: ifnonnull +5 -> 15906
    //   15904: iconst_1
    //   15905: ireturn
    //   15906: aload_3
    //   15907: invokestatic 4061	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:a	(Landroid/app/Activity;)V
    //   15910: aload_2
    //   15911: ldc_w 4063
    //   15914: invokestatic 4065	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:b	()Z
    //   15917: invokevirtual 189	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   15920: pop
    //   15921: aload_2
    //   15922: ldc_w 4067
    //   15925: getstatic 4068	dov/com/tencent/mobileqq/richmedia/capture/util/LiuHaiUtils:jdField_a_of_type_Int	I
    //   15928: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   15931: pop
    //   15932: aload_0
    //   15933: aload_1
    //   15934: iconst_1
    //   15935: anewarray 285	java/lang/String
    //   15938: dup
    //   15939: iconst_0
    //   15940: aload_2
    //   15941: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   15944: aastore
    //   15945: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   15948: goto -15764 -> 184
    //   15951: astore_1
    //   15952: ldc 209
    //   15954: iconst_1
    //   15955: ldc_w 4070
    //   15958: aload_1
    //   15959: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   15962: goto -15778 -> 184
    //   15965: ldc_w 4072
    //   15968: aload 4
    //   15970: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15973: ifeq +137 -> 16110
    //   15976: new 113	org/json/JSONObject
    //   15979: dup
    //   15980: aload 5
    //   15982: iconst_0
    //   15983: aaload
    //   15984: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15987: astore_2
    //   15988: aload_2
    //   15989: ldc_w 4074
    //   15992: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   15995: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15998: astore_1
    //   15999: aload_2
    //   16000: ldc_w 811
    //   16003: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16006: astore_2
    //   16007: aload_1
    //   16008: invokevirtual 2624	java/lang/Integer:intValue	()I
    //   16011: iconst_1
    //   16012: if_icmpne +77 -> 16089
    //   16015: iconst_1
    //   16016: invokestatic 4077	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16019: new 113	org/json/JSONObject
    //   16022: dup
    //   16023: invokespecial 172	org/json/JSONObject:<init>	()V
    //   16026: astore_1
    //   16027: aload_1
    //   16028: ldc 217
    //   16030: ldc_w 3472
    //   16033: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   16036: pop
    //   16037: invokestatic 4078	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	()Z
    //   16040: ifeq +64 -> 16104
    //   16043: iconst_1
    //   16044: istore 6
    //   16046: aload_1
    //   16047: ldc_w 4074
    //   16050: iload 6
    //   16052: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   16055: pop
    //   16056: aload_0
    //   16057: aload_2
    //   16058: iconst_1
    //   16059: anewarray 285	java/lang/String
    //   16062: dup
    //   16063: iconst_0
    //   16064: aload_1
    //   16065: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16068: aastore
    //   16069: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   16072: goto -15888 -> 184
    //   16075: astore_1
    //   16076: ldc 209
    //   16078: iconst_1
    //   16079: ldc_w 4080
    //   16082: aload_1
    //   16083: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16086: goto -15902 -> 184
    //   16089: aload_1
    //   16090: invokevirtual 2624	java/lang/Integer:intValue	()I
    //   16093: iconst_2
    //   16094: if_icmpne -75 -> 16019
    //   16097: iconst_0
    //   16098: invokestatic 4077	com/tencent/mobileqq/troop/activity/TroopBarPublishUtils:a	(Z)V
    //   16101: goto -82 -> 16019
    //   16104: iconst_2
    //   16105: istore 6
    //   16107: goto -61 -> 16046
    //   16110: ldc_w 4082
    //   16113: aload 4
    //   16115: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16118: ifeq +166 -> 16284
    //   16121: new 113	org/json/JSONObject
    //   16124: dup
    //   16125: aload 5
    //   16127: iconst_0
    //   16128: aaload
    //   16129: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16132: astore 4
    //   16134: aload 4
    //   16136: ldc_w 4084
    //   16139: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16142: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16145: astore_1
    //   16146: aload 4
    //   16148: ldc_w 4086
    //   16151: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16154: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16157: astore_2
    //   16158: aload 4
    //   16160: ldc_w 4088
    //   16163: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16166: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16169: astore_3
    //   16170: aload 4
    //   16172: ldc_w 811
    //   16175: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16178: astore 4
    //   16180: ldc 209
    //   16182: iconst_1
    //   16183: new 551	java/lang/StringBuilder
    //   16186: dup
    //   16187: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   16190: ldc_w 4090
    //   16193: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16196: aload_1
    //   16197: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16200: ldc_w 4092
    //   16203: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16206: aload_2
    //   16207: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16210: ldc_w 4094
    //   16213: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16216: aload_3
    //   16217: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16220: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16223: invokestatic 884	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16226: aload_0
    //   16227: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16230: ifnonnull +17 -> 16247
    //   16233: aload_0
    //   16234: invokestatic 2044	zon:a	()Lzon;
    //   16237: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16240: aload_0
    //   16241: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16244: invokevirtual 2046	zon:a	()V
    //   16247: aload_0
    //   16248: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16251: aload_1
    //   16252: aload_2
    //   16253: aload_3
    //   16254: new 4096	auvf
    //   16257: dup
    //   16258: aload_0
    //   16259: aload 4
    //   16261: invokespecial 4097	auvf:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/lang/String;)V
    //   16264: invokevirtual 4100	zon:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lzop;)V
    //   16267: goto -16083 -> 184
    //   16270: astore_1
    //   16271: ldc 209
    //   16273: iconst_1
    //   16274: ldc_w 4102
    //   16277: aload_1
    //   16278: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16281: goto -16097 -> 184
    //   16284: ldc_w 4104
    //   16287: aload 4
    //   16289: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16292: ifeq +139 -> 16431
    //   16295: new 113	org/json/JSONObject
    //   16298: dup
    //   16299: aload 5
    //   16301: iconst_0
    //   16302: aaload
    //   16303: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16306: astore_3
    //   16307: aload_3
    //   16308: ldc_w 4106
    //   16311: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16314: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16317: astore_1
    //   16318: aload_3
    //   16319: ldc_w 4086
    //   16322: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16325: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16328: astore_2
    //   16329: aload_3
    //   16330: ldc_w 2719
    //   16333: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16336: astore_3
    //   16337: ldc 209
    //   16339: iconst_1
    //   16340: new 551	java/lang/StringBuilder
    //   16343: dup
    //   16344: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   16347: ldc_w 4108
    //   16350: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16353: aload_1
    //   16354: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16357: ldc_w 4110
    //   16360: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16363: aload_2
    //   16364: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16367: ldc_w 4112
    //   16370: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16373: aload_3
    //   16374: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16377: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16380: invokestatic 884	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16383: aload_0
    //   16384: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16387: ifnonnull +17 -> 16404
    //   16390: aload_0
    //   16391: invokestatic 2044	zon:a	()Lzon;
    //   16394: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16397: aload_0
    //   16398: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16401: invokevirtual 2046	zon:a	()V
    //   16404: aload_0
    //   16405: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16408: aload_1
    //   16409: aload_2
    //   16410: aload_3
    //   16411: invokevirtual 4115	zon:a	(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V
    //   16414: goto -16230 -> 184
    //   16417: astore_1
    //   16418: ldc 209
    //   16420: iconst_1
    //   16421: ldc_w 4117
    //   16424: aload_1
    //   16425: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16428: goto -16244 -> 184
    //   16431: ldc_w 4119
    //   16434: aload 4
    //   16436: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16439: ifeq +139 -> 16578
    //   16442: new 113	org/json/JSONObject
    //   16445: dup
    //   16446: aload 5
    //   16448: iconst_0
    //   16449: aaload
    //   16450: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16453: astore_3
    //   16454: aload_3
    //   16455: ldc_w 4106
    //   16458: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16461: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16464: astore_1
    //   16465: aload_3
    //   16466: ldc_w 2719
    //   16469: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16472: astore_2
    //   16473: aload_3
    //   16474: ldc_w 4086
    //   16477: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16480: invokestatic 1561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   16483: astore_3
    //   16484: ldc 209
    //   16486: iconst_1
    //   16487: new 551	java/lang/StringBuilder
    //   16490: dup
    //   16491: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   16494: ldc_w 4121
    //   16497: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16500: aload_1
    //   16501: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16504: ldc_w 4112
    //   16507: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16510: aload_2
    //   16511: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16514: ldc_w 4110
    //   16517: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16520: aload_3
    //   16521: invokevirtual 900	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   16524: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16527: invokestatic 884	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   16530: aload_0
    //   16531: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16534: ifnonnull +17 -> 16551
    //   16537: aload_0
    //   16538: invokestatic 2044	zon:a	()Lzon;
    //   16541: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16544: aload_0
    //   16545: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16548: invokevirtual 2046	zon:a	()V
    //   16551: aload_0
    //   16552: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16555: aload_1
    //   16556: aload_2
    //   16557: aload_3
    //   16558: invokevirtual 4124	zon:a	(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V
    //   16561: goto -16377 -> 184
    //   16564: astore_1
    //   16565: ldc 209
    //   16567: iconst_1
    //   16568: ldc_w 4126
    //   16571: aload_1
    //   16572: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16575: goto -16391 -> 184
    //   16578: ldc_w 4128
    //   16581: aload 4
    //   16583: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16586: ifeq +252 -> 16838
    //   16589: new 113	org/json/JSONObject
    //   16592: dup
    //   16593: aload 5
    //   16595: iconst_0
    //   16596: aaload
    //   16597: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16600: astore 4
    //   16602: aload 4
    //   16604: ldc_w 4130
    //   16607: iconst_1
    //   16608: invokevirtual 295	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   16611: ifne +41 -> 16652
    //   16614: aload 4
    //   16616: aload 4
    //   16618: ldc_w 811
    //   16621: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16624: new 4132	auvg
    //   16627: dup
    //   16628: aload_0
    //   16629: invokespecial 4133	auvg:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   16632: invokestatic 4138	ufd:a	(Lorg/json/JSONObject;Ljava/lang/String;Ltiu;)V
    //   16635: goto -16451 -> 184
    //   16638: astore_1
    //   16639: ldc 209
    //   16641: iconst_1
    //   16642: ldc_w 4140
    //   16645: aload_1
    //   16646: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   16649: goto -16465 -> 184
    //   16652: aload 4
    //   16654: ldc_w 1635
    //   16657: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16660: pop
    //   16661: aload 4
    //   16663: ldc_w 1637
    //   16666: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16669: pop
    //   16670: aload 4
    //   16672: ldc_w 1639
    //   16675: invokevirtual 270	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   16678: pop
    //   16679: aload 4
    //   16681: ldc_w 1641
    //   16684: invokevirtual 1645	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   16687: pop2
    //   16688: aload 4
    //   16690: ldc_w 1653
    //   16693: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16696: astore_1
    //   16697: aload 4
    //   16699: ldc_w 1655
    //   16702: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16705: astore_2
    //   16706: aload 4
    //   16708: ldc_w 1657
    //   16711: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16714: astore_3
    //   16715: aload 4
    //   16717: ldc_w 1659
    //   16720: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16723: astore 4
    //   16725: new 2426	java/util/HashMap
    //   16728: dup
    //   16729: invokespecial 3636	java/util/HashMap:<init>	()V
    //   16732: astore 14
    //   16734: aload 14
    //   16736: ldc_w 1653
    //   16739: aload_1
    //   16740: invokeinterface 4141 3 0
    //   16745: pop
    //   16746: aload 14
    //   16748: ldc_w 1655
    //   16751: aload_2
    //   16752: invokeinterface 4141 3 0
    //   16757: pop
    //   16758: aload 14
    //   16760: ldc_w 1657
    //   16763: aload_3
    //   16764: invokeinterface 4141 3 0
    //   16769: pop
    //   16770: aload 14
    //   16772: ldc_w 1659
    //   16775: aload 4
    //   16777: invokeinterface 4141 3 0
    //   16782: pop
    //   16783: aload_0
    //   16784: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16787: ifnonnull +17 -> 16804
    //   16790: aload_0
    //   16791: invokestatic 2044	zon:a	()Lzon;
    //   16794: putfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16797: aload_0
    //   16798: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16801: invokevirtual 2046	zon:a	()V
    //   16804: new 4143	auvh
    //   16807: dup
    //   16808: aload_0
    //   16809: aload 14
    //   16811: invokespecial 4146	auvh:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;Ljava/util/Map;)V
    //   16814: astore_1
    //   16815: aload_0
    //   16816: getfield 85	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_Zon	Lzon;
    //   16819: aload_1
    //   16820: invokevirtual 4149	zon:a	(Lzop;)I
    //   16823: istore 6
    //   16825: aload_0
    //   16826: aload 5
    //   16828: iconst_0
    //   16829: aaload
    //   16830: iload 6
    //   16832: invokevirtual 4150	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Ljava/lang/String;I)V
    //   16835: goto -16651 -> 184
    //   16838: ldc_w 4152
    //   16841: aload 4
    //   16843: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16846: ifeq +251 -> 17097
    //   16849: new 113	org/json/JSONObject
    //   16852: dup
    //   16853: aload 5
    //   16855: iconst_0
    //   16856: aaload
    //   16857: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16860: astore_1
    //   16861: aload_1
    //   16862: ldc_w 1726
    //   16865: invokevirtual 121	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16868: astore_2
    //   16869: aload_0
    //   16870: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   16873: invokevirtual 1875	bgve:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   16876: astore_3
    //   16877: aload_1
    //   16878: ldc_w 4154
    //   16881: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16884: istore 6
    //   16886: aload_1
    //   16887: ldc_w 427
    //   16890: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16893: astore 4
    //   16895: aload_1
    //   16896: ldc_w 272
    //   16899: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   16902: astore 5
    //   16904: aload_1
    //   16905: ldc_w 4156
    //   16908: invokevirtual 320	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   16911: istore 7
    //   16913: ldc_w 3341
    //   16916: aload_2
    //   16917: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16920: ifeq +104 -> 17024
    //   16923: aload_3
    //   16924: aload 4
    //   16926: putfield 4159	com/tencent/mobileqq/webview/swift/WebViewFragment:mKeyWording	Ljava/lang/String;
    //   16929: aload_3
    //   16930: iload 6
    //   16932: putfield 4162	com/tencent/mobileqq/webview/swift/WebViewFragment:mBusiID	I
    //   16935: aload_3
    //   16936: iload 7
    //   16938: putfield 4165	com/tencent/mobileqq/webview/swift/WebViewFragment:mWhere	I
    //   16941: aload_3
    //   16942: aload 5
    //   16944: putfield 4168	com/tencent/mobileqq/webview/swift/WebViewFragment:mStyle	Ljava/lang/String;
    //   16947: iload 7
    //   16949: iconst_1
    //   16950: if_icmpne +62 -> 17012
    //   16953: aload_0
    //   16954: iload 6
    //   16956: invokevirtual 4170	com/tencent/mobileqq/jsp/UiApiPlugin:b	(I)V
    //   16959: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16962: ifeq -16778 -> 184
    //   16965: ldc 209
    //   16967: iconst_2
    //   16968: new 551	java/lang/StringBuilder
    //   16971: dup
    //   16972: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   16975: ldc_w 4172
    //   16978: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16981: aload_1
    //   16982: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   16985: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16988: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   16991: invokestatic 214	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16994: goto -16810 -> 184
    //   16997: astore_1
    //   16998: ldc 209
    //   17000: iconst_1
    //   17001: aload_1
    //   17002: iconst_0
    //   17003: anewarray 277	java/lang/Object
    //   17006: invokestatic 1734	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   17009: goto -16825 -> 184
    //   17012: aload_3
    //   17013: invokevirtual 4175	com/tencent/mobileqq/webview/swift/WebViewFragment:initNativeMiniAIOUser	()V
    //   17016: aload_3
    //   17017: iconst_1
    //   17018: invokevirtual 4178	com/tencent/mobileqq/webview/swift/WebViewFragment:setMiniAIOEntry	(Z)V
    //   17021: goto -62 -> 16959
    //   17024: ldc_w 4180
    //   17027: aload_2
    //   17028: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17031: ifeq +11 -> 17042
    //   17034: aload_3
    //   17035: iconst_0
    //   17036: invokevirtual 4178	com/tencent/mobileqq/webview/swift/WebViewFragment:setMiniAIOEntry	(Z)V
    //   17039: goto -80 -> 16959
    //   17042: ldc_w 4074
    //   17045: aload_2
    //   17046: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17049: ifeq +27 -> 17076
    //   17052: aload_3
    //   17053: aload 4
    //   17055: putfield 4159	com/tencent/mobileqq/webview/swift/WebViewFragment:mKeyWording	Ljava/lang/String;
    //   17058: aload_0
    //   17059: getfield 2166	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17062: ifnull -103 -> 16959
    //   17065: aload_0
    //   17066: getfield 2166	com/tencent/mobileqq/jsp/UiApiPlugin:jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser	Lcom/tencent/mobileqq/activity/miniaio/MiniMsgUser;
    //   17069: aconst_null
    //   17070: invokevirtual 4183	com/tencent/mobileqq/activity/miniaio/MiniMsgUser:onClick	(Landroid/view/View;)V
    //   17073: goto -114 -> 16959
    //   17076: ldc_w 4185
    //   17079: aload_2
    //   17080: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17083: ifeq -124 -> 16959
    //   17086: invokestatic 4190	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:getInstance	()Lcom/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient;
    //   17089: iload 6
    //   17091: invokevirtual 4193	com/tencent/mobileqq/activity/miniaio/MiniMsgIPCClient:clearBusiness	(I)V
    //   17094: goto -135 -> 16959
    //   17097: ldc_w 4195
    //   17100: aload 4
    //   17102: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17105: ifeq +68 -> 17173
    //   17108: iconst_0
    //   17109: new 113	org/json/JSONObject
    //   17112: dup
    //   17113: aload 5
    //   17115: iconst_0
    //   17116: aaload
    //   17117: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17120: ldc_w 811
    //   17123: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17126: new 4197	auvi
    //   17129: dup
    //   17130: aload_0
    //   17131: invokespecial 4198	auvi:<init>	(Lcom/tencent/mobileqq/jsp/UiApiPlugin;)V
    //   17134: invokestatic 4200	com/tencent/mobileqq/jsp/UiApiPlugin:a	(ZLjava/lang/String;Ltiu;)V
    //   17137: goto -16953 -> 184
    //   17140: astore_1
    //   17141: ldc 209
    //   17143: iconst_1
    //   17144: new 551	java/lang/StringBuilder
    //   17147: dup
    //   17148: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   17151: ldc_w 4202
    //   17154: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17157: aload_1
    //   17158: invokevirtual 923	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17161: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17164: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17167: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17170: goto -16986 -> 184
    //   17173: ldc_w 4204
    //   17176: aload 4
    //   17178: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17181: ifeq +79 -> 17260
    //   17184: new 113	org/json/JSONObject
    //   17187: dup
    //   17188: aload 5
    //   17190: iconst_0
    //   17191: aaload
    //   17192: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17195: ldc_w 811
    //   17198: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17201: astore_1
    //   17202: new 113	org/json/JSONObject
    //   17205: dup
    //   17206: aload 5
    //   17208: iconst_0
    //   17209: aaload
    //   17210: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17213: aload_1
    //   17214: aload_0
    //   17215: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   17218: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   17221: invokestatic 4206	com/tencent/mobileqq/jsp/UiApiPlugin:a	(Lorg/json/JSONObject;Ljava/lang/String;Landroid/app/Activity;)V
    //   17224: goto -17040 -> 184
    //   17227: astore_1
    //   17228: ldc 209
    //   17230: iconst_1
    //   17231: new 551	java/lang/StringBuilder
    //   17234: dup
    //   17235: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   17238: ldc_w 4208
    //   17241: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17244: aload_1
    //   17245: invokevirtual 923	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17248: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17251: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17254: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17257: goto -17073 -> 184
    //   17260: aload 4
    //   17262: ldc_w 4210
    //   17265: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17268: ifeq +10 -> 17278
    //   17271: aload_0
    //   17272: invokevirtual 4211	com/tencent/mobileqq/jsp/UiApiPlugin:b	()V
    //   17275: goto -17091 -> 184
    //   17278: ldc_w 4213
    //   17281: aload 4
    //   17283: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17286: ifeq -17102 -> 184
    //   17289: aconst_null
    //   17290: astore_2
    //   17291: aload_2
    //   17292: astore_1
    //   17293: new 113	org/json/JSONObject
    //   17296: dup
    //   17297: aload 5
    //   17299: iconst_0
    //   17300: aaload
    //   17301: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17304: astore_3
    //   17305: aload_2
    //   17306: astore_1
    //   17307: aload_3
    //   17308: ldc_w 811
    //   17311: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17314: astore_2
    //   17315: aload_2
    //   17316: astore_1
    //   17317: aload_0
    //   17318: getfield 1441	com/tencent/mobileqq/jsp/UiApiPlugin:mRuntime	Lbgve;
    //   17321: invokevirtual 1445	bgve:a	()Landroid/app/Activity;
    //   17324: aload_3
    //   17325: invokestatic 4219	com/tencent/hippy/qq/utils/HippyAccessHelper:startHippyPage	(Landroid/content/Context;Lorg/json/JSONObject;)Z
    //   17328: istore 12
    //   17330: iload 12
    //   17332: ifeq +56 -> 17388
    //   17335: iconst_0
    //   17336: istore 6
    //   17338: aload_2
    //   17339: astore_1
    //   17340: aload_1
    //   17341: invokestatic 254	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17344: ifne -17160 -> 184
    //   17347: new 113	org/json/JSONObject
    //   17350: dup
    //   17351: invokespecial 172	org/json/JSONObject:<init>	()V
    //   17354: astore_2
    //   17355: aload_2
    //   17356: ldc_w 1295
    //   17359: iload 6
    //   17361: invokevirtual 196	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   17364: pop
    //   17365: aload_0
    //   17366: aload_1
    //   17367: iconst_1
    //   17368: anewarray 285	java/lang/String
    //   17371: dup
    //   17372: iconst_0
    //   17373: aload_2
    //   17374: invokevirtual 201	org/json/JSONObject:toString	()Ljava/lang/String;
    //   17377: aastore
    //   17378: invokevirtual 784	com/tencent/mobileqq/jsp/UiApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   17381: goto -17197 -> 184
    //   17384: astore_1
    //   17385: goto -17201 -> 184
    //   17388: iconst_m1
    //   17389: istore 6
    //   17391: aload_2
    //   17392: astore_1
    //   17393: goto -53 -> 17340
    //   17396: astore_2
    //   17397: ldc 209
    //   17399: iconst_1
    //   17400: new 551	java/lang/StringBuilder
    //   17403: dup
    //   17404: invokespecial 552	java/lang/StringBuilder:<init>	()V
    //   17407: ldc_w 4221
    //   17410: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17413: aload_2
    //   17414: invokevirtual 923	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   17417: invokevirtual 558	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17420: invokevirtual 562	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17423: invokestatic 918	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   17426: iconst_m1
    //   17427: istore 6
    //   17429: goto -89 -> 17340
    //   17432: iconst_0
    //   17433: ireturn
    //   17434: astore_2
    //   17435: goto -6795 -> 10640
    //   17438: astore 15
    //   17440: goto -13866 -> 3574
    //   17443: aload_1
    //   17444: astore_2
    //   17445: ldc_w 484
    //   17448: astore_1
    //   17449: goto -4349 -> 13100
    //   17452: aconst_null
    //   17453: astore_1
    //   17454: aload_3
    //   17455: astore_2
    //   17456: goto -6520 -> 10936
    //   17459: goto -7959 -> 9500
    //   17462: aconst_null
    //   17463: astore_1
    //   17464: goto -10325 -> 7139
    //   17467: aconst_null
    //   17468: astore_1
    //   17469: goto -10567 -> 6902
    //   17472: iconst_0
    //   17473: istore 6
    //   17475: goto -10618 -> 6857
    //   17478: aconst_null
    //   17479: astore_1
    //   17480: goto -10791 -> 6689
    //   17483: astore_1
    //   17484: goto -17300 -> 184
    //   17487: iconst_1
    //   17488: ireturn
    //   17489: iconst_1
    //   17490: ireturn
    //   17491: iconst_1
    //   17492: ireturn
    //   17493: iconst_1
    //   17494: ireturn
    //   17495: iconst_1
    //   17496: ireturn
    //   17497: astore_1
    //   17498: goto -17314 -> 184
    //   17501: iload 6
    //   17503: tableswitch	default:+17 -> 17520, 1001:+-13431->4072
    //   17521: breakpoint
    //   17522: lcmp
    //   17523: iload 6
    //   17525: tableswitch	default:+19 -> 17544, 1001:+-13229->4296
    //   17545: newarray 慢⁤污潬慣楴湯
    //   17547: iconst_0
    //   17548: istore 12
    //   17550: goto -12869 -> 4681
    //   17553: iconst_0
    //   17554: istore 12
    //   17556: goto -12488 -> 5068
    //   17559: iload 6
    //   17561: ldc_w 1975
    //   17564: ior
    //   17565: istore 6
    //   17567: goto -11419 -> 6148
    //   17570: iload 6
    //   17572: iconst_1
    //   17573: iadd
    //   17574: istore 6
    //   17576: goto -10979 -> 6597
    //   17579: iload 6
    //   17581: iconst_1
    //   17582: iadd
    //   17583: istore 6
    //   17585: goto -6462 -> 11123
    //   17588: iconst_1
    //   17589: ireturn
    //   17590: iconst_1
    //   17591: ireturn
    //   17592: iconst_1
    //   17593: ireturn
    //   17594: iconst_1
    //   17595: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	17596	0	this	UiApiPlugin
    //   0	17596	1	paramJsBridgeListener	JsBridgeListener
    //   0	17596	2	paramString1	String
    //   0	17596	3	paramString2	String
    //   0	17596	4	paramString3	String
    //   0	17596	5	paramVarArgs	String[]
    //   268	17316	6	n	int
    //   4761	12190	7	i1	int
    //   4770	9425	8	i2	int
    //   4779	205	9	i3	int
    //   259	7455	10	l1	long
    //   1454	16101	12	bool1	boolean
    //   8683	5514	13	bool2	boolean
    //   615	16195	14	localObject1	Object
    //   3508	9138	15	localObject2	Object
    //   17438	1	15	localJSONException	JSONException
    //   10870	53	16	str	String
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
    //   8808	8846	8765	org/json/JSONException
    //   8851	8875	8765	org/json/JSONException
    //   8875	8889	8765	org/json/JSONException
    //   8892	8916	8765	org/json/JSONException
    //   8937	9044	9047	org/json/JSONException
    //   8937	9044	9083	java/lang/Exception
    //   9158	9170	9343	java/lang/Exception
    //   9172	9180	9343	java/lang/Exception
    //   9182	9194	9343	java/lang/Exception
    //   9196	9205	9343	java/lang/Exception
    //   9207	9216	9343	java/lang/Exception
    //   9221	9231	9343	java/lang/Exception
    //   9233	9242	9343	java/lang/Exception
    //   9244	9252	9343	java/lang/Exception
    //   9254	9263	9343	java/lang/Exception
    //   9270	9279	9343	java/lang/Exception
    //   9281	9290	9343	java/lang/Exception
    //   9292	9302	9343	java/lang/Exception
    //   9304	9313	9343	java/lang/Exception
    //   9315	9331	9343	java/lang/Exception
    //   9333	9340	9343	java/lang/Exception
    //   9419	9432	9769	java/lang/Exception
    //   9434	9443	9769	java/lang/Exception
    //   9445	9457	9769	java/lang/Exception
    //   9459	9469	9769	java/lang/Exception
    //   9471	9481	9769	java/lang/Exception
    //   9486	9494	9769	java/lang/Exception
    //   9502	9512	9769	java/lang/Exception
    //   9514	9524	9769	java/lang/Exception
    //   9526	9536	9769	java/lang/Exception
    //   9538	9544	9769	java/lang/Exception
    //   9546	9576	9769	java/lang/Exception
    //   9578	9585	9769	java/lang/Exception
    //   9587	9596	9769	java/lang/Exception
    //   9598	9608	9769	java/lang/Exception
    //   9610	9619	9769	java/lang/Exception
    //   9621	9631	9769	java/lang/Exception
    //   9633	9644	9769	java/lang/Exception
    //   9646	9656	9769	java/lang/Exception
    //   9658	9666	9769	java/lang/Exception
    //   9668	9678	9769	java/lang/Exception
    //   9680	9688	9769	java/lang/Exception
    //   9690	9700	9769	java/lang/Exception
    //   9702	9719	9769	java/lang/Exception
    //   9721	9728	9769	java/lang/Exception
    //   9803	9815	9906	java/lang/Exception
    //   9817	9825	9906	java/lang/Exception
    //   9827	9837	9906	java/lang/Exception
    //   9839	9848	9906	java/lang/Exception
    //   9850	9865	9906	java/lang/Exception
    //   9871	9878	9906	java/lang/Exception
    //   9880	9885	9906	java/lang/Exception
    //   9895	9903	9906	java/lang/Exception
    //   9951	9960	9906	java/lang/Exception
    //   9974	9983	9906	java/lang/Exception
    //   10007	10019	10110	java/lang/Exception
    //   10021	10029	10110	java/lang/Exception
    //   10031	10041	10110	java/lang/Exception
    //   10043	10052	10110	java/lang/Exception
    //   10054	10069	10110	java/lang/Exception
    //   10075	10082	10110	java/lang/Exception
    //   10084	10089	10110	java/lang/Exception
    //   10099	10107	10110	java/lang/Exception
    //   10155	10164	10110	java/lang/Exception
    //   10178	10187	10110	java/lang/Exception
    //   10207	10236	10239	org/json/JSONException
    //   10289	10339	10401	org/json/JSONException
    //   10342	10364	10401	org/json/JSONException
    //   10373	10398	10401	org/json/JSONException
    //   10555	10588	10620	java/lang/Exception
    //   10508	10545	10639	java/lang/Exception
    //   10621	10631	10639	java/lang/Exception
    //   10751	10764	10990	java/lang/Exception
    //   10769	10778	10990	java/lang/Exception
    //   10783	10792	10990	java/lang/Exception
    //   10797	10807	10990	java/lang/Exception
    //   10812	10821	10990	java/lang/Exception
    //   10826	10837	10990	java/lang/Exception
    //   10847	10857	10990	java/lang/Exception
    //   10862	10872	10990	java/lang/Exception
    //   10877	10886	10990	java/lang/Exception
    //   10891	10899	10990	java/lang/Exception
    //   10904	10912	10990	java/lang/Exception
    //   10917	10932	10990	java/lang/Exception
    //   10968	10982	10990	java/lang/Exception
    //   11060	11116	11266	org/json/JSONException
    //   11119	11123	11266	org/json/JSONException
    //   11130	11141	11266	org/json/JSONException
    //   11147	11173	11266	org/json/JSONException
    //   11176	11207	11266	org/json/JSONException
    //   11207	11233	11266	org/json/JSONException
    //   11233	11263	11266	org/json/JSONException
    //   11306	11328	11266	org/json/JSONException
    //   11348	11363	11366	org/json/JSONException
    //   11440	11461	11464	org/json/JSONException
    //   11514	11531	11545	org/json/JSONException
    //   11535	11542	11545	org/json/JSONException
    //   11514	11531	11584	java/lang/Exception
    //   11535	11542	11584	java/lang/Exception
    //   11640	11674	11792	java/lang/Exception
    //   11676	11710	11792	java/lang/Exception
    //   11714	11736	11792	java/lang/Exception
    //   11736	11789	11792	java/lang/Exception
    //   11836	11888	11908	java/lang/Exception
    //   11888	11905	11908	java/lang/Exception
    //   11929	11981	12232	org/json/JSONException
    //   11984	11992	12232	org/json/JSONException
    //   11996	12003	12232	org/json/JSONException
    //   12003	12019	12232	org/json/JSONException
    //   12022	12042	12232	org/json/JSONException
    //   12048	12229	12232	org/json/JSONException
    //   12276	12297	12232	org/json/JSONException
    //   12297	12318	12232	org/json/JSONException
    //   11929	11981	12321	java/lang/Exception
    //   11984	11992	12321	java/lang/Exception
    //   11996	12003	12321	java/lang/Exception
    //   12003	12019	12321	java/lang/Exception
    //   12022	12042	12321	java/lang/Exception
    //   12048	12229	12321	java/lang/Exception
    //   12276	12297	12321	java/lang/Exception
    //   12297	12318	12321	java/lang/Exception
    //   12414	12464	12745	org/json/JSONException
    //   12464	12507	12745	org/json/JSONException
    //   12510	12519	12745	org/json/JSONException
    //   12524	12532	12745	org/json/JSONException
    //   12532	12548	12745	org/json/JSONException
    //   12551	12742	12745	org/json/JSONException
    //   12414	12464	12784	java/lang/Exception
    //   12464	12507	12784	java/lang/Exception
    //   12510	12519	12784	java/lang/Exception
    //   12524	12532	12784	java/lang/Exception
    //   12532	12548	12784	java/lang/Exception
    //   12551	12742	12784	java/lang/Exception
    //   12834	12860	12917	org/json/JSONException
    //   12864	12914	12917	org/json/JSONException
    //   12834	12860	12974	java/lang/Exception
    //   12864	12914	12974	java/lang/Exception
    //   13053	13080	13138	org/json/JSONException
    //   13082	13100	13138	org/json/JSONException
    //   13100	13108	13138	org/json/JSONException
    //   13112	13135	13138	org/json/JSONException
    //   13192	13211	13300	org/json/JSONException
    //   13211	13221	13300	org/json/JSONException
    //   13221	13231	13300	org/json/JSONException
    //   13231	13239	13300	org/json/JSONException
    //   13243	13261	13300	org/json/JSONException
    //   13271	13281	13300	org/json/JSONException
    //   13287	13297	13300	org/json/JSONException
    //   13337	13363	13300	org/json/JSONException
    //   13373	13399	13300	org/json/JSONException
    //   13407	13417	13300	org/json/JSONException
    //   13425	13435	13300	org/json/JSONException
    //   13211	13221	13336	java/lang/Exception
    //   13221	13231	13369	java/lang/Exception
    //   13456	13496	13550	org/json/JSONException
    //   13500	13547	13550	org/json/JSONException
    //   13586	13611	13550	org/json/JSONException
    //   13639	13679	13682	org/json/JSONException
    //   13735	13778	13803	org/json/JSONException
    //   13786	13800	13803	org/json/JSONException
    //   13857	13884	13907	org/json/JSONException
    //   13888	13904	13907	org/json/JSONException
    //   13961	13985	14122	org/json/JSONException
    //   13988	14027	14122	org/json/JSONException
    //   14030	14085	14122	org/json/JSONException
    //   14090	14119	14122	org/json/JSONException
    //   14175	14216	14122	org/json/JSONException
    //   14236	14263	14279	org/json/JSONException
    //   14272	14276	14279	org/json/JSONException
    //   14293	14302	14279	org/json/JSONException
    //   14306	14343	14279	org/json/JSONException
    //   14349	14363	14279	org/json/JSONException
    //   14372	14386	14279	org/json/JSONException
    //   14470	14555	14558	java/lang/Exception
    //   14572	14590	14558	java/lang/Exception
    //   14595	14606	14558	java/lang/Exception
    //   14606	14627	14558	java/lang/Exception
    //   14630	14641	14558	java/lang/Exception
    //   14655	14696	14699	java/lang/Exception
    //   14735	14814	14817	java/lang/Exception
    //   14842	14921	14974	java/lang/Exception
    //   14921	14971	14974	java/lang/Exception
    //   14988	15022	14974	java/lang/Exception
    //   15025	15057	14974	java/lang/Exception
    //   15071	15144	15147	java/lang/Exception
    //   15172	15201	15283	java/lang/Exception
    //   15205	15280	15283	java/lang/Exception
    //   15308	15320	15326	java/lang/Exception
    //   15372	15469	15472	java/lang/Exception
    //   15497	15581	15584	java/lang/Exception
    //   15598	15603	15584	java/lang/Exception
    //   15606	15626	15584	java/lang/Exception
    //   15629	15641	15584	java/lang/Exception
    //   15644	15669	15584	java/lang/Exception
    //   15763	15844	15847	org/json/JSONException
    //   15866	15900	15951	java/lang/Exception
    //   15906	15948	15951	java/lang/Exception
    //   15976	16019	16075	org/json/JSONException
    //   16019	16043	16075	org/json/JSONException
    //   16046	16072	16075	org/json/JSONException
    //   16089	16101	16075	org/json/JSONException
    //   16121	16247	16270	org/json/JSONException
    //   16247	16267	16270	org/json/JSONException
    //   16295	16404	16417	org/json/JSONException
    //   16404	16414	16417	org/json/JSONException
    //   16442	16551	16564	org/json/JSONException
    //   16551	16561	16564	org/json/JSONException
    //   16589	16635	16638	org/json/JSONException
    //   16652	16804	16638	org/json/JSONException
    //   16804	16835	16638	org/json/JSONException
    //   16849	16947	16997	java/lang/Exception
    //   16953	16959	16997	java/lang/Exception
    //   16959	16994	16997	java/lang/Exception
    //   17012	17021	16997	java/lang/Exception
    //   17024	17039	16997	java/lang/Exception
    //   17042	17073	16997	java/lang/Exception
    //   17076	17094	16997	java/lang/Exception
    //   17108	17137	17140	org/json/JSONException
    //   17184	17224	17227	org/json/JSONException
    //   17340	17381	17384	org/json/JSONException
    //   17293	17305	17396	org/json/JSONException
    //   17307	17315	17396	org/json/JSONException
    //   17317	17330	17396	org/json/JSONException
    //   10482	10502	17434	java/lang/Exception
    //   3547	3556	17438	org/json/JSONException
    //   3561	3574	17438	org/json/JSONException
    //   1007	1040	17483	java/lang/Throwable
    //   1043	1076	17483	java/lang/Throwable
    //   1079	1108	17483	java/lang/Throwable
    //   1111	1119	17483	java/lang/Throwable
    //   1719	1760	17497	org/json/JSONException
    //   1762	1835	17497	org/json/JSONException
    //   1837	1848	17497	org/json/JSONException
    //   1851	1880	17497	org/json/JSONException
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
                          for (paramIntent = "''";; paramIntent = npn.a((String)localObject1))
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
      bfcv.a(this.mRuntime.a(), paramIntent, null);
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
          if (this.jdField_a_of_type_Ooz != null) {
            this.jdField_a_of_type_Ooz.a();
          }
          this.jdField_a_of_type_Ooz = new ooz();
          a(paramIntent, this.jdField_a_of_type_Ooz, str, new auvl(this));
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
    ardu.a().a(this.jdField_a_of_type_Aqyp);
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
    if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing())) {
      this.jdField_a_of_type_Bjnw.dismiss();
    }
    if (this.jdField_a_of_type_Zon != null) {
      this.jdField_a_of_type_Zon.b();
    }
    ardu.a().b(this.jdField_a_of_type_Aqyp);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    if (this.jdField_a_of_type_Ooz != null)
    {
      this.jdField_a_of_type_Ooz.a();
      this.jdField_a_of_type_Ooz = null;
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