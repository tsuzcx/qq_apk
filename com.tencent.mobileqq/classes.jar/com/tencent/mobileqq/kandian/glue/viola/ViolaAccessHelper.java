package com.tencent.mobileqq.kandian.glue.viola;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.qq.ac.sdk.api.AcInterface;
import com.qq.ac.sdk.api.AcType.Gender;
import com.qq.ac.sdk.api.AcType.UidType;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessConstants;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegateConstants;
import com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageDomObject;
import com.tencent.mobileqq.kandian.biz.viola.barrage.VBarrage;
import com.tencent.mobileqq.kandian.biz.viola.module.CacheModule;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyWebRenderEngine;
import com.tencent.mobileqq.kandian.glue.viola.adapter.BaseHttpAdapter;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ExperimentConfigManager;
import com.tencent.mobileqq.kandian.glue.viola.adapter.MultiV8ViolaRuntimeAdapter;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaLogAdapter;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter;
import com.tencent.mobileqq.kandian.glue.viola.comment.KdCommentHeader;
import com.tencent.mobileqq.kandian.glue.viola.comment.KdCommentList;
import com.tencent.mobileqq.kandian.glue.viola.components.VideoAnimationComponent;
import com.tencent.mobileqq.kandian.glue.viola.components.VideoDanmakuComponent;
import com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieViewCreater;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.DtReportModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.NavigationModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.NotifyModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.QReportModule;
import com.tencent.mobileqq.kandian.glue.viola.reward.VKdRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideo;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.VTopicVideo;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.DomObjectTKDWormhole;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.VTKDWormhole;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaVideoFeedsConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaSusAutoPlayConfigSp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.viola.core.InitConfig.Builder;
import com.tencent.viola.core.ViolaDomObjectManager;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.lottie.VLottieView.Factory;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaAccessHelper
  extends IViolaAccessConstants
{
  public static int a = 0;
  public static long b = 0L;
  public static String c;
  public static boolean d = false;
  public static Map<String, String> e;
  private static final String f;
  private static int g = 1;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ/8.8.17 Android/0.17 Android/");
    localStringBuilder.append(Build.VERSION.RELEASE);
    f = localStringBuilder.toString();
  }
  
  private static Intent a(Context paramContext, String paramString1, Bundle paramBundle, boolean paramBoolean, String paramString2)
  {
    Intent localIntent = new Intent();
    if (a(paramBundle))
    {
      localIntent.putExtra("url", paramString2);
      localIntent.addFlags(268435456);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      if ((paramContext instanceof SplashActivity)) {
        paramContext = "&from_splash_activity=1";
      } else {
        paramContext = "&from_splash_activity=0";
      }
      localStringBuilder.append(paramContext);
      localIntent.putExtra("url", localStringBuilder.toString());
    }
    localIntent.putExtra(IViolaUiDelegateConstants.a, paramString1);
    localIntent.putExtra("useTransParentFragment", paramBoolean);
    if (paramBundle != null)
    {
      localIntent.putExtras(paramBundle);
      if (paramBundle.containsKey(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA)) {
        localIntent.putExtra(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA, paramBundle.getString(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA));
      }
      if (paramBundle.containsKey("param")) {
        localIntent.putExtra("param", paramBundle.getString("param"));
      }
    }
    return localIntent;
  }
  
  public static QBaseFragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = a(paramContext, "", paramBundle, false, a(paramString));
    paramBundle = new ReadInJoyViolaChannelFragment();
    paramBundle.setArguments(paramContext.getExtras());
    paramBundle.b(paramString);
    return paramBundle;
  }
  
  @VisibleForTesting
  protected static String a(Bundle paramBundle, String paramString)
  {
    Object localObject1 = paramString;
    if (paramBundle.containsKey("floating_window_rowkey"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&rowkey=");
      ((StringBuilder)localObject1).append(paramBundle.getString("floating_window_rowkey"));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (paramBundle.containsKey("float_layer_topic_id"))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("&topicId=");
      paramString.append(paramBundle.getString("float_layer_topic_id"));
      paramString = paramString.toString();
    }
    localObject1 = paramString;
    boolean bool;
    if (paramBundle.containsKey("scroll_to_top"))
    {
      bool = paramBundle.getBoolean("scroll_to_top", false);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      if (bool) {
        paramString = "&v_present_auto_top=1";
      } else {
        paramString = "&v_present_auto_top=0";
      }
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (paramBundle.containsKey("up_animation"))
    {
      bool = paramBundle.getBoolean("up_animation", false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      if (bool) {
        paramString = "&v_present_pop=1";
      } else {
        paramString = "&v_present_pop=0";
      }
      ((StringBuilder)localObject2).append(paramString);
      paramString = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = paramString;
    if (paramBundle.containsKey("margin_top"))
    {
      localObject1 = paramBundle.getString("margin_top", null);
      localObject2 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = paramString;
        if (!"null".equals(localObject1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("&v_present_top=");
          ((StringBuilder)localObject1).append(paramBundle.getString("margin_top"));
          localObject2 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    localObject1 = localObject2;
    if (paramBundle.containsKey("gray_bar"))
    {
      bool = paramBundle.getBoolean("gray_bar", false);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      if (bool) {
        paramString = "&v_present_back_bar=1";
      } else {
        paramString = "&v_present_back_bar=0";
      }
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    paramString = (String)localObject1;
    if (paramBundle.containsKey("floating_bundle_extra_data"))
    {
      localObject2 = paramBundle.getBundle("floating_bundle_extra_data");
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        paramString = (String)localObject1;
        if (((Bundle)localObject2).containsKey("VIDEO_H5_URL"))
        {
          localObject2 = ((Bundle)localObject2).getString("VIDEO_H5_URL", "");
          paramString = (String)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramString = (String)localObject1;
            if (((String)localObject2).contains("redpackid"))
            {
              paramString = new StringBuilder();
              paramString.append((String)localObject1);
              paramString.append("&redpackid=");
              paramString.append(Uri.parse((String)localObject2).getQueryParameter("redpackid"));
              paramString = paramString.toString();
            }
          }
        }
      }
    }
    localObject1 = paramString;
    if (paramBundle.containsKey("floating_window_scene"))
    {
      int i = paramBundle.getInt("floating_window_scene", 0);
      localObject1 = paramString;
      if (i == 4)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("&v_present_interrupt_back=1");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("&presentFrom=");
      paramString.append(i);
      localObject1 = paramString.toString();
    }
    paramString = (String)localObject1;
    if (paramBundle.containsKey("REPORT_VIDEO_FEEDS_CHANNEL_ID"))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append("&channelId=");
      paramString.append(paramBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID"));
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (paramString.contains("v_bid_min_version"))
      {
        localObject2 = Uri.parse(paramString).getQueryParameter("v_bid");
        Object localObject1 = Uri.parse(paramString).getQueryParameter("v_bid_min_version");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = HtmlOffline.d((String)localObject2);
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (Integer.valueOf((String)localObject2).intValue() < Integer.valueOf((String)localObject1).intValue()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("&v_bid_apply_anywhere=0");
            localObject1 = ((StringBuilder)localObject1).toString();
            return localObject1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startViolaPage error ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject2).toString());
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = l(paramString1);
      if (paramString1.containsKey(paramString2))
      {
        paramString1 = paramString1.getString(paramString2);
        if (!TextUtils.isEmpty(paramString1)) {
          return paramString1;
        }
      }
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1 = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      int j;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(paramString1);
        if (URLUtil.a(paramString1).size() <= 0) {
          break label249;
        }
        i = 1;
        boolean bool = TextUtils.isEmpty(paramString2);
        str1 = "&";
        j = i;
        if (bool) {
          break label261;
        }
        JSONObject localJSONObject = new JSONObject(paramString2);
        Iterator localIterator = localJSONObject.keys();
        j = i;
        if (!localIterator.hasNext()) {
          break label261;
        }
        String str2 = (String)localIterator.next();
        Object localObject = localJSONObject.opt(str2);
        if (i == 0) {
          break label254;
        }
        paramString2 = "&";
        localStringBuilder.append(paramString2);
        localStringBuilder.append(str2);
        localStringBuilder.append("=");
        localStringBuilder.append(localObject);
        i = 1;
        continue;
        localStringBuilder.append(paramString2);
        localStringBuilder.append("refreshForUGCUpload");
        localStringBuilder.append("=");
        localStringBuilder.append("1");
        str1 = localStringBuilder.toString();
      }
      catch (JSONException paramString2)
      {
        QLog.d("ViolaAccessHelper", 1, paramString2.getMessage());
        str1 = paramString1;
      }
      paramString1 = new StringBuilder();
      paramString1.append("addParams viola url: ");
      paramString1.append(str1);
      QLog.d("ViolaAccessHelper", 1, paramString1.toString());
      return str1;
      label249:
      int i = 0;
      continue;
      label254:
      paramString2 = "?";
      continue;
      label261:
      if (paramBoolean) {
        if (j != 0) {
          paramString2 = str1;
        } else {
          paramString2 = "?";
        }
      }
    }
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    if (ReadInJoyHelper.s(paramAppRuntime)) {
      return "https://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=2&v_bundleName=messageBox&statusColor=1&support_night=1&hideNav=1&v_nav_immer=1";
    }
    return "https://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=6&v_bundleName=messageBox&v_bid=3740&statusColor=1&support_night=1&hideNav=1&v_nav_immer=1";
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "preInit");
    }
    if (TextUtils.isEmpty(c)) {
      c = RIJQQAppInterfaceUtil.d();
    }
    ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).preDownload();
    NativeVueLoaderManager.a().d();
    ViolaResLoader.a.a().a();
    WormholeEngine.a();
    i();
    if (ViolaSDKEngine.isInitialized()) {
      return;
    }
    ThreadManager.post(new ViolaAccessHelper.1(), 8, null, true);
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    int i;
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        if (paramInt != 4) {
          localObject1 = "";
        }
      }
      for (;;)
      {
        i = 0;
        break;
        localObject1 = "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1";
        continue;
        localObject1 = "https://viola.qq.com/js/shortPGC.js?_rij_violaUrl=1&v_tid=15&v_bundleName=shortPGC&hideNav=1&v_nav_immer=1&v_bid=3811&v_present_titleHeight=44";
      }
    }
    Object localObject1 = new JSONObject();
    if (paramBundle.containsKey("floating_window_scene"))
    {
      int j = paramBundle.getInt("floating_window_scene", 0);
      i = j;
      if (j == 3) {
        try
        {
          ((JSONObject)localObject1).put("autoPlayDisable", RIJViolaSusAutoPlayConfigSp.a());
          i = j;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i = j;
        }
      }
    }
    else
    {
      i = 0;
    }
    paramBundle.putString("param", ((JSONObject)localObject1).toString());
    localObject1 = "https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123&cycle_loading=1";
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&v_present=2");
    localObject1 = a(paramBundle, ((StringBuilder)localObject2).toString());
    if (paramBundle.containsKey("floating_window_scene")) {
      i = paramBundle.getInt("floating_window_scene", 0);
    }
    if (paramInt == 2)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("VIDEO_FROM_TYPE", c(i));
      ((Intent)localObject2).putExtras(paramBundle);
      MultiVideoHelper.a(paramContext, (Intent)localObject2, (String)localObject1);
      return;
    }
    a(paramContext, "", (String)localObject1, paramBundle, false);
  }
  
  private static void a(Context paramContext, String paramString) {}
  
  public static void a(Context paramContext, String paramString, ViolaAccessHelper.ViolaSdkPermitlistener paramViolaSdkPermitlistener) {}
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle, false);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, ViolaAccessHelper.ViolaSdkPermitlistener paramViolaSdkPermitlistener)
  {
    if (!a(paramContext))
    {
      if (paramViolaSdkPermitlistener != null) {
        paramViolaSdkPermitlistener.a();
      }
      return;
    }
    if ((paramString2.contains("v_tid")) && (paramString2.contains("v_bundleName")))
    {
      b(paramContext, paramString1, paramString2, paramBundle);
      return;
    }
    if (TextUtils.isEmpty(Uri.parse(paramString2).getQueryParameter("v_bid")))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("openViolaPageWithOffline businessId is empty,url = ");
        paramContext.append(paramString2);
        QLog.d("ViolaAccessHelper", 4, paramContext.toString());
      }
      if (paramViolaSdkPermitlistener != null) {
        paramViolaSdkPermitlistener.a();
      }
      return;
    }
    String str = ViolaBizUtils.b(paramString2);
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("openViolaPageWithOffline filePath is empty,url = ");
        paramContext.append(paramString2);
        QLog.d("ViolaAccessHelper", 4, paramContext.toString());
      }
      if (paramViolaSdkPermitlistener != null) {
        paramViolaSdkPermitlistener.a();
      }
      return;
    }
    if (!new File(str).exists())
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getResponse local file not exists :");
        paramContext.append(str);
        QLog.d("ViolaAccessHelper", 4, paramContext.toString());
      }
      if (paramViolaSdkPermitlistener != null) {
        paramViolaSdkPermitlistener.a();
      }
      return;
    }
    b(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    ViolaFragment.setCurrentJSUrl(paramString2);
    paramString2 = a(paramString2);
    paramString1 = a(paramContext, paramString1, paramBundle, paramBoolean, paramString2);
    if ((!paramString2.contains("v_present=2")) && (!paramString2.contains("v_present=1")) && (!paramString2.contains("v_push_animated_disable=1")))
    {
      if ((paramBundle != null) && ((paramContext instanceof Activity)))
      {
        if ((!paramBoolean) && (!paramString2.contains("v_usetrans=1")))
        {
          QPublicFragmentActivity.startForResult((Activity)paramContext, paramString1, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
        }
        else
        {
          paramString1.putExtra("public_fragment_window_feature", 1);
          paramContext = (Activity)paramContext;
          QPublicFragmentActivity.Launcher.a(paramContext, paramString1, QPublicTransFragmentActivity.class, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
          paramContext.overridePendingTransition(2130772028, 0);
        }
      }
      else if ((!paramBoolean) && (!paramString2.contains("v_usetrans=1")))
      {
        QPublicFragmentActivity.start(paramContext, paramString1, ViolaFragment.class);
      }
      else
      {
        paramString1.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.Launcher.a(paramContext, paramString1, QPublicTransFragmentActivity.class, ViolaFragment.class);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130772028, 0);
        }
      }
    }
    else
    {
      paramString1.putExtra("public_fragment_window_feature", 1);
      if ((paramBundle != null) && (paramBundle.containsKey("requestCode")) && ((paramContext instanceof Activity))) {
        QPublicFragmentActivity.Launcher.a((Activity)paramContext, paramString1, QPublicTransFragmentActivity.class, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
      } else {
        QPublicFragmentActivity.Launcher.a(paramContext, paramString1, QPublicTransFragmentActivity.class, ViolaFragment.class);
      }
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
    WormholeEngine.a();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Bundle localBundle = new Bundle();
      a(paramContext, "", a(paramString2, paramString1, paramBoolean), localBundle, false);
    }
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramContext == null) {
        return;
      }
      try
      {
        localObject = paramJSONObject.optString("from_type");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a((String)localObject, paramJSONObject, paramContext);
          return;
        }
        d(paramContext, paramJSONObject);
        return;
      }
      catch (Exception paramContext)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openVideo jsonobject is: ");
          ((StringBuilder)localObject).append(paramJSONObject.toString());
          ((StringBuilder)localObject).append("  error :");
          ((StringBuilder)localObject).append(paramContext.getMessage());
          QLog.d("ViolaAccessHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, ViolaReportDelegate paramViolaReportDelegate, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback)
  {
    for (;;)
    {
      try
      {
        if (!ViolaSDKEngine.isInitialized())
        {
          InitConfig.Builder localBuilder = new InitConfig.Builder().setBusinessId(1).setFramework(paramString).setHttpAdapter(new BaseHttpAdapter()).setComponentAdapter(new ComponentAdapter()).setReportDelegate(paramViolaReportDelegate).setLogAdapter(new ViolaLogAdapter()).setConfigManager(new ExperimentConfigManager()).setMultiV8ViolaRuntimeAdapter(new MultiV8ViolaRuntimeAdapter());
          if (paramAppInterface == null) {
            break label212;
          }
          localMobileQQ = paramAppInterface.getApplication();
          ViolaSDKEngine.initialize(localMobileQQ, localBuilder.build(), new ViolaAccessHelper.5(paramAppInterface, paramSDKInitCallback, paramViolaReportDelegate, paramString), ViolaBizUtils.a());
        }
        else
        {
          try
          {
            ViolaSDKEngine.registerModule("bridge", BridgeModule.class, false);
            if (paramSDKInitCallback != null) {
              new Handler(Looper.getMainLooper()).post(new ViolaAccessHelper.6(paramSDKInitCallback));
            }
          }
          catch (Exception paramAppInterface)
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("SDKInitialize Exception e: ");
              paramString.append(paramAppInterface.getMessage());
              QLog.e("ViolaAccessHelper", 2, paramString.toString());
            }
          }
        }
        return;
      }
      finally {}
      label212:
      MobileQQ localMobileQQ = null;
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    ViolaSDKEngine.registerModule("bridge", BridgeModule.class, false);
    ViolaSDKEngine.registerModule("navigation", NavigationModule.class, true);
    ViolaSDKEngine.registerModule("QReport", QReportModule.class, true);
    ViolaSDKEngine.registerModule("cache", CacheModule.class, true);
    ViolaSDKEngine.registerModule("comic", ((IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class)).getComicModuleClass(), true);
    ViolaSDKEngine.registerModule("report", DtReportModule.class, true);
    ViolaSDKEngine.registerModule("notify", NotifyModule.class, false);
    ViolaSDKEngine.registerComponent(VVideo.class, false, new String[] { "video" });
    ViolaSDKEngine.registerComponent(VKdRewardTaskVideoTimer.class, false, new String[] { "kdredpacket-process" });
    ViolaSDKEngine.registerComponent(VTopicVideo.class, false, new String[] { "topic-video" });
    ViolaSDKEngine.registerComponent(KdCommentList.class, false, new String[] { "kdcomment" });
    ViolaSDKEngine.registerComponent(KdCommentHeader.class, false, new String[] { "kdcomment-header" });
    ViolaSDKEngine.registerComponent(VBarrage.class, false, new String[] { "barrage" });
    ViolaDomObjectManager.registerDomObj("barrage", BarrageDomObject.class);
    ViolaSDKEngine.registerComponent(VideoDanmakuComponent.class, false, new String[] { "video-danmaku" });
    ViolaSDKEngine.registerComponent(VideoAnimationComponent.class, false, new String[] { "video-animation" });
    ViolaSDKEngine.registerComponent(VTKDWormhole.class, false, new String[] { "TKDWormhole" });
    ViolaDomObjectManager.registerDomObj("TKDWormhole", DomObjectTKDWormhole.class);
    if (paramBoolean)
    {
      VLottieView.Factory.setVLottieViewCreater(new KdLottieViewCreater());
      Object localObject2 = null;
      if (paramAppInterface != null) {
        localObject1 = paramAppInterface.getApplication();
      } else {
        localObject1 = null;
      }
      AcInterface.init((Context)localObject1);
      AcInterface.setAppID("ac0632ab2c1e20593b52");
      AcInterface.setAppKey("zBWcxAx7HhqAj0pu2RaXm0T8QElpYiiLXMK4553L2uj");
      Object localObject1 = localObject2;
      if (paramAppInterface != null) {
        localObject1 = paramAppInterface.getAccount();
      }
      AcInterface.setUid((String)localObject1, AcType.UidType.QQ, AcType.Gender.UNKNOWN);
    }
  }
  
  @Deprecated
  public static void a(String paramString, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if ((localQQAppInterface == null) && (paramSDKInitCallback != null))
    {
      paramSDKInitCallback.a();
      return;
    }
    a(localQQAppInterface, paramString, null, paramSDKInitCallback);
  }
  
  public static void a(String paramString, ViolaAccessHelper.ViolaOfflineDownloadListener paramViolaOfflineDownloadListener)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      ThreadManager.post(new ViolaAccessHelper.4(paramString, localQQAppInterface, paramViolaOfflineDownloadListener, System.currentTimeMillis()), 8, null, true);
      return;
    }
    if (paramViolaOfflineDownloadListener != null) {
      paramViolaOfflineDownloadListener.b();
    }
  }
  
  public static void a(String paramString, ViolaBaseView.LoadAsyBack paramLoadAsyBack)
  {
    ThreadManager.post(new ViolaAccessHelper.7(paramString, paramLoadAsyBack), 8, null, false);
  }
  
  private static void a(String paramString, JSONObject paramJSONObject, Context paramContext)
  {
    if (("2".equals(paramString)) && (paramJSONObject != null))
    {
      if (paramContext == null) {
        return;
      }
      paramJSONObject = b(paramContext, paramJSONObject);
      if (paramJSONObject == null) {
        return;
      }
      paramString = paramJSONObject.getExtras();
      int i = 0;
      try
      {
        boolean bool = MultiVideoConfigHandler.a(paramString.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(paramString.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(paramString.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(paramString.getString("VIDEO_TIME")).intValue());
        i = bool;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[openVideoForDiscover]: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("ViolaAccessHelper", 1, localStringBuilder.toString());
      }
      if (i != 0)
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtras(paramString);
        MultiVideoHelper.a(paramContext, paramJSONObject);
        return;
      }
      paramContext.startActivity(paramJSONObject);
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 41726;
  }
  
  public static boolean a(int paramInt, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleLockScreenJumpViola: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" pushJson: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" refresh: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ViolaAccessHelper", 1, ((StringBuilder)localObject).toString());
    localObject = e(paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("has violaUrl: ");
      localStringBuilder.append((String)localObject);
      QLog.d("ViolaAccessHelper", 1, localStringBuilder.toString());
      a(paramActivity, paramString, (String)localObject, paramBoolean);
      QLog.d("ViolaAccessHelper", 1, "jump viola follow channel success");
      return true;
    }
    QLog.d("ViolaAccessHelper", 1, "has no violaUrl");
    return false;
  }
  
  private static boolean a(Context paramContext)
  {
    if (!ReadInJoyWebRenderEngine.a().c()) {
      ReadInJoyWebRenderEngine.a().b();
    }
    if (!Build.CPU_ABI.contains("armeabi"))
    {
      a(paramContext, "cpu架构不支持");
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit check cpu config is false");
      }
      return false;
    }
    if (!b())
    {
      a(paramContext, HardCodeUtil.a(2131913647));
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit checkWhiteConfig is false");
      }
      return false;
    }
    if (!j())
    {
      a(paramContext, HardCodeUtil.a(2131913649));
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit checkSO is false");
      }
      return false;
    }
    String str = ViolaBizUtils.b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (TextUtils.isEmpty(str))
    {
      a(paramContext, "mainJsPath is empty");
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit mainJsPath is empty");
      }
      return false;
    }
    if (!new File(str).exists())
    {
      a(paramContext, HardCodeUtil.a(2131913648));
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit viola.js is false");
      }
      paramContext = Uri.parse("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547").getQueryParameter("v_bid");
      if (!TextUtils.isEmpty(paramContext)) {
        k(paramContext);
      }
      return false;
    }
    return true;
  }
  
  private static boolean a(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("from_color_note"));
  }
  
  private static Intent b(Context paramContext, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("video_card");
    if (localJSONObject == null) {
      return null;
    }
    paramContext = new Intent(paramContext, VideoFeedsPlayActivity.class);
    paramContext.putExtra("is_from_viola", paramJSONObject.optString("from_viola"));
    String str1 = paramJSONObject.optString("isFromWeishiDiscover");
    String str2 = paramJSONObject.optString("isWeishiSource");
    if ("1".equals(str1))
    {
      paramContext.putExtra("VIDEO_FROM_TYPE", 20);
      paramContext.putExtra("key_source", 5);
    }
    else
    {
      if ("1".equals(str2)) {
        paramContext.putExtra("VIDEO_FROM_TYPE", 23);
      } else {
        paramContext.putExtra("VIDEO_FROM_TYPE", 18);
      }
      paramContext.putExtra("key_source", 4);
    }
    paramContext.putExtra("VIDEO_COMMON_DATA", localJSONObject.optString("common_data_24"));
    if (!TextUtils.isEmpty(localJSONObject.optString("topic_id_18"))) {
      paramContext.putExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", Long.valueOf(localJSONObject.optString("topic_id_18")));
    }
    paramContext.putExtra("VIDEO_VID", localJSONObject.optString("vid_19"));
    paramContext.putExtra("VIDEO_ARTICLE_ID", localJSONObject.optString("article_id_8"));
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_UIN", localJSONObject.optString("subscribe_id_6"));
    paramContext.putExtra("VIDEO_PUB_ACCOUNT_NAME", localJSONObject.optString("subscribe_name_7"));
    paramContext.putExtra("VIDEO_THIRD_ACTION", localJSONObject.optString("third_action_20"));
    paramContext.putExtra("VIDEO_THIRD_ICON", localJSONObject.optString("third_icon_url_21"));
    paramContext.putExtra("VIDEO_THIRD_NAME", localJSONObject.optString("third_uin_name_22"));
    paramContext.putExtra("VIDEO_TITLE", localJSONObject.optString("article_title_9"));
    paramContext.putExtra("VIDEO_SUMMARY", localJSONObject.optString("article_summary_10"));
    paramContext.putExtra("VIDEO_COVER", localJSONObject.optString("cover_url_2"));
    paramContext.putExtra("VIDEO_URL", localJSONObject.optString("video_url_23"));
    paramContext.putExtra("VIDEO_WIDTH", localJSONObject.optString("width_25"));
    paramContext.putExtra("VIDEO_HEIGHT", localJSONObject.optString("height_26"));
    paramContext.putExtra("VIDEO_TIME", localJSONObject.optString("duration_27"));
    if (!TextUtils.isEmpty(localJSONObject.optString("busiType_28"))) {
      paramContext.putExtra("VIDEO_ARTICLE_BUSITYPE", Integer.valueOf(localJSONObject.optString("busiType_28")));
    }
    if (!TextUtils.isEmpty(localJSONObject.optString("feeds_type_4"))) {
      paramContext.putExtra("VIDEO_FEED_TYPE", Integer.valueOf(localJSONObject.optString("feeds_type_4")));
    }
    if (!TextUtils.isEmpty(localJSONObject.optString("feeds_id_3"))) {
      paramContext.putExtra("VIDEO_FEED_ID", Long.valueOf(localJSONObject.optString("feeds_id_3")));
    }
    if (!TextUtils.isEmpty(localJSONObject.optString("xg_file_size_29"))) {
      paramContext.putExtra("VIDEO_XG_FILE_SIZE", Long.valueOf(localJSONObject.optString("xg_file_size_29")));
    }
    paramJSONObject = paramJSONObject.optJSONObject("from_frame");
    if (paramJSONObject != null)
    {
      if (!TextUtils.isEmpty(paramJSONObject.optString("x"))) {
        paramContext.putExtra("item_x", Integer.valueOf(paramJSONObject.optString("x")));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("y"))) {
        paramContext.putExtra("item_y", Integer.valueOf(paramJSONObject.optString("y")));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("height"))) {
        paramContext.putExtra("item_height", Integer.valueOf(paramJSONObject.optString("height")));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("width"))) {
        paramContext.putExtra("item_width", Integer.valueOf(paramJSONObject.optString("width")));
      }
    }
    return paramContext;
  }
  
  public static String b(String paramString)
  {
    if (AppSetting.h) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("http")) {
        return null;
      }
      Object localObject1 = Uri.parse(paramString).getQueryParameter("v_bid");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      Object localObject2 = SwiftOfflineDataUtils.b(paramString);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject2).b)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "load offline想 data cache on loadRes");
        }
        return ((SwiftOfflineDataUtils.OfflineData)localObject2).b;
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        localObject2 = OfflineEnvHelper.b((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(File.separator);
        localObject1 = localStringBuilder.toString();
        paramString = HtmlOffline.g(paramString);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramString);
        localObject1 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject1).exists())
        {
          if (!QLog.isColorLevel()) {
            break label245;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getResponse local file not exists :");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("ViolaAccessHelper", 4, ((StringBuilder)localObject1).toString());
          return null;
        }
        paramString = ViolaUtils.readFile((File)localObject1);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.e("ViolaAccessHelper", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
      }
    }
    else
    {
      return null;
    }
    label245:
    return null;
  }
  
  @Deprecated
  private static void b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (f())
    {
      if (e == null) {
        e = new ArrayMap();
      }
      e.put(h(paramString1), paramString2);
    }
  }
  
  public static boolean b()
  {
    return ReadInJoyHelper.X(RIJQQAppInterfaceUtil.e());
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 41725;
  }
  
  public static int c(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return -1;
          }
        }
        else {
          return 33;
        }
      }
      else {
        return 27;
      }
    }
    return 24;
  }
  
  private static Bundle c(Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramContext != null) && (paramJSONObject != null))
    {
      Bundle localBundle = new Bundle();
      paramContext = paramJSONObject.optString("innerUniqueID");
      String str1 = paramJSONObject.optString("busitype");
      String str2 = paramJSONObject.optString("video_vid");
      String str3 = paramJSONObject.optString("video_width");
      String str4 = paramJSONObject.optString("video_height");
      String str5 = paramJSONObject.optString("video_duration");
      String str6 = paramJSONObject.optString("video_from_type");
      String str7 = paramJSONObject.optString("title");
      String str8 = paramJSONObject.optString("video_cover");
      String str9 = paramJSONObject.optString("share_url");
      String str10 = paramJSONObject.optString("account_name");
      String str11 = paramJSONObject.optString("account_uin");
      String str12 = paramJSONObject.optString("video_create_time");
      String str13 = paramJSONObject.optString("third_icon_url");
      String str14 = paramJSONObject.optString("third_name");
      String str15 = paramJSONObject.optString("third_jump_url");
      String str16 = paramJSONObject.optString("biudata");
      String str17 = paramJSONObject.optString("commondata");
      int i = paramJSONObject.optInt("from_viola", 0);
      String str18 = paramJSONObject.optString("video_url");
      int j = paramJSONObject.optInt("channel_id", -1);
      JSONObject localJSONObject = paramJSONObject.optJSONObject("from_frame");
      localBundle.putString("VIDEO_ARTICLE_ID", paramContext);
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", Integer.valueOf(str1).intValue());
      }
      localBundle.putString("VIDEO_VID", str2);
      if (!TextUtils.isEmpty(str6)) {
        localBundle.putInt("VIDEO_FROM_TYPE", Integer.valueOf(str6).intValue());
      }
      localBundle.putString("VIDEO_WIDTH", str3);
      localBundle.putString("VIDEO_HEIGHT", str4);
      localBundle.putString("VIDEO_TIME", str5);
      localBundle.putString("VIDEO_TITLE", str7);
      localBundle.putString("VIDEO_COVER", str8);
      localBundle.putString("VIDEO_H5_URL", str9);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", str10);
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", str11);
      localBundle.putString("VIDEO_CREATE_TIME", str12);
      localBundle.putString("VIDEO_THIRD_ICON", str13);
      localBundle.putString("VIDEO_THIRD_NAME", str14);
      localBundle.putString("VIDEO_THIRD_ACTION", str15);
      localBundle.putString("VIDEO_COMMON_DATA", str17);
      localBundle.putString("VIDEO_ARTICLE_INFO_FOR_BIU", str16);
      localBundle.putString("is_from_viola", String.valueOf(i));
      localBundle.putString("VIDEO_URL", str18);
      if (localJSONObject != null)
      {
        if (!TextUtils.isEmpty(localJSONObject.optString("x"))) {
          localBundle.putInt("item_x", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("x"), 750));
        }
        if (!TextUtils.isEmpty(localJSONObject.optString("y"))) {
          localBundle.putInt("item_y", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("y"), 750));
        }
        if (!TextUtils.isEmpty(localJSONObject.optString("height"))) {
          localBundle.putInt("item_height", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("height"), 750));
        }
        if (!TextUtils.isEmpty(localJSONObject.optString("width"))) {
          localBundle.putInt("item_width", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("width"), 750));
        }
      }
      paramContext = "commentId";
      if (TextUtils.isEmpty(paramJSONObject.optString("commentId", null))) {
        paramContext = "commentid";
      }
      str1 = paramJSONObject.optString(paramContext, null);
      if (!TextUtils.isEmpty(str1))
      {
        paramContext = "subCommentId";
        if (TextUtils.isEmpty(paramJSONObject.optString("subCommentId", null))) {
          paramContext = "subcommentid";
        }
        str2 = paramJSONObject.optString(paramContext, null);
        paramContext = "jumpCommentType";
        if (TextUtils.isEmpty(paramJSONObject.optString("jumpCommentType", null))) {
          paramContext = "jumpcommenttype";
        }
        str3 = paramJSONObject.optString(paramContext, null);
        paramContext = "isAwesome";
        if (TextUtils.isEmpty(paramJSONObject.optString("isAwesome", null))) {
          paramContext = "isawesome";
        }
        paramContext = paramJSONObject.optString(paramContext, null);
        paramJSONObject = new AnchorData();
        paramJSONObject.a = str1;
        paramJSONObject.b = str2;
        paramJSONObject.d = "0".equals(str3);
        paramJSONObject.c = "1".equals(paramContext);
        localBundle.putBoolean("VIDEO_SHOW_COMMENT", true);
        localBundle.putParcelable("VIDEO_COMMENT_ANCHOR", paramJSONObject);
      }
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", j);
      return localBundle;
    }
    return null;
  }
  
  public static JSONObject c()
  {
    Object localObject2 = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localObject2 == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject3 = (TicketManager)((QQAppInterface)localObject2).getManager(2);
      localObject1 = ((QQAppInterface)localObject2).getAccount();
      localObject2 = ((TicketManager)localObject3).getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("uin=o");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("; skey=");
      ((StringBuilder)localObject3).append((String)localObject2);
      localJSONObject.put("Cookie", ((StringBuilder)localObject3).toString());
      localJSONObject.put("User-Agent", f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBaseInitData JSONException e");
        ((StringBuilder)localObject1).append(localJSONException.getMessage());
        QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return null;
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ("1".equals(a(paramString, "_rij_violaUrl")));
  }
  
  public static String d(int paramInt)
  {
    if (paramInt == 41725) {
      return "https://viola.qq.com/js/VideoAccountFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoAccountFeeds&hideNav=1&statusColor=1&v_bid=3811&_cache_bunle=1&v_nav_immer=1";
    }
    return ViolaVideoFeedsConfigHandler.b();
  }
  
  public static void d()
  {
    a("https://sqimg.qq.com/qq_product_operations/kan/viola_config/viola_config.json?v_bid=3192", new ViolaAccessHelper.8());
  }
  
  private static void d(Context paramContext, JSONObject paramJSONObject)
  {
    Bundle localBundle = c(paramContext, paramJSONObject);
    if (localBundle == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("openVideo jsonobject is: ");
      localStringBuilder1.append(paramJSONObject.toString());
      localStringBuilder1.append("  bundle is :");
      localStringBuilder1.append(localBundle.toString());
      QLog.d("ViolaAccessHelper", 2, localStringBuilder1.toString());
    }
    paramJSONObject = new Intent(paramContext, VideoFeedsPlayActivity.class);
    int i = 0;
    try
    {
      boolean bool = MultiVideoConfigHandler.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
      i = bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[internalOpenVideo]: ");
      localStringBuilder2.append(localException.getMessage());
      QLog.e("ViolaAccessHelper", 1, localStringBuilder2.toString());
    }
    if (i != 0)
    {
      paramJSONObject = new Intent();
      paramJSONObject.putExtras(localBundle);
      MultiVideoHelper.a(paramContext, paramJSONObject);
      return;
    }
    paramJSONObject.putExtras(localBundle);
    paramContext.startActivity(paramJSONObject);
  }
  
  private static void d(String paramString1, String paramString2)
  {
    if ((b()) && (j()) && (((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists())) || (!TextUtils.isEmpty(paramString2)))) {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          paramString2 = ViolaUtils.readFile(new File(paramString1));
        }
        a(paramString2, new ViolaAccessHelper.2());
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static boolean d(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.contains("web.kandian.qq.com")) || (paramString.contains("webtest.kandian.qq.com"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String e()
  {
    return ViolaVideoFeedsConfigHandler.b();
  }
  
  public static String e(int paramInt)
  {
    Object localObject1 = Aladdin.get(379).getString("viola_follow_tabs_jump_urls", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length > 0)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            try
            {
              localObject2 = ((String)localObject2).split(",");
              int k = Integer.parseInt(localObject2[0]);
              localObject2 = URLDecoder.decode(localObject2[1]);
              if (k == paramInt) {
                return localObject2;
              }
            }
            catch (Exception localException)
            {
              QLog.d("ViolaAccessHelper", 1, localException.getMessage());
            }
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static boolean e(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      boolean bool = paramString.contains("viola_share_url");
      if (bool)
      {
        Object localObject1 = Uri.parse(paramString).getQueryParameter("viola_share_url");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return false;
        }
        localObject1 = URLDecoder.decode((String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return false;
        }
        if (!((String)localObject1).contains("_rij_violaUrl=1")) {
          return false;
        }
        localObject1 = Uri.parse((String)localObject1).getQueryParameter("v_minVersion");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return true;
        }
        localObject1 = ((String)localObject1).split("\\.");
        localObject2 = "8.8.17".split("\\.");
        if (Integer.valueOf(localObject1[0]).intValue() < Integer.valueOf(localObject2[0]).intValue()) {
          return true;
        }
        if ((Integer.valueOf(localObject1[0]) == Integer.valueOf(localObject2[0])) && (Integer.valueOf(localObject1[1]).intValue() < Integer.valueOf(localObject2[1]).intValue())) {
          return true;
        }
        if ((Integer.valueOf(localObject1[0]) == Integer.valueOf(localObject2[0])) && (Integer.valueOf(localObject1[1]) == Integer.valueOf(localObject2[1])) && (Integer.valueOf(localObject1[2]).intValue() <= Integer.valueOf(localObject2[2]).intValue())) {
          return true;
        }
      }
      else
      {
        bool = paramString.contains("_rij_violaUrl=1");
        return bool;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("isViolaUrlFromWeb error:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        ((StringBuilder)localObject2).append(",webUrl=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject2).toString());
      }
      return false;
    }
    return false;
  }
  
  public static String f(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      boolean bool = paramString.contains("viola_share_url");
      if (bool)
      {
        String str = Uri.parse(paramString).getQueryParameter("viola_share_url");
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = URLDecoder.decode(str);
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        if (!str.contains("_rij_violaUrl=1")) {
          return null;
        }
      }
      else
      {
        bool = paramString.contains("_rij_violaUrl=1");
        if (bool) {
          return paramString;
        }
        return null;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getViolaUrlFromWeb error:");
        localStringBuilder.append(localException.getMessage());
        localStringBuilder.append(",webUrl=");
        localStringBuilder.append(paramString);
        QLog.e("ViolaAccessHelper", 2, localStringBuilder.toString());
      }
      return null;
    }
    return localException;
  }
  
  public static boolean f()
  {
    return false;
  }
  
  public static String g(String paramString)
  {
    Map localMap = e;
    if (localMap != null) {
      return (String)localMap.get(h(paramString));
    }
    return null;
  }
  
  public static String h(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("?")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    return str;
  }
  
  private static void i()
  {
    if ((System.currentTimeMillis() - b >= 18000000L) || ((!TextUtils.isEmpty(c)) && (!c.equals(RIJQQAppInterfaceUtil.d()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is start");
      }
      a("3192", new ViolaAccessHelper.3());
    }
  }
  
  public static void i(String paramString)
  {
    RIJSPUtils.a("KEY_SP_CHANNEL_FOLLOW_URL", paramString);
  }
  
  private static boolean j()
  {
    return ViolaSoLoaderManager.a.a().b();
  }
  
  private static void k(String paramString)
  {
    a(paramString, null);
  }
  
  private static Bundle l(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int i = paramString.indexOf('?');
    if (i >= 0)
    {
      i += 1;
      if (i >= paramString.length()) {
        return localBundle;
      }
      paramString = paramString.substring(i);
      if (TextUtils.isEmpty(paramString)) {
        return localBundle;
      }
      paramString = paramString.split("&");
      if (paramString != null)
      {
        i = 0;
        while (i < paramString.length)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length == 2)) {
            try
            {
              localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
          i += 1;
        }
      }
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper
 * JD-Core Version:    0.7.0.1
 */