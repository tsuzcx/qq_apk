package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.provider.Settings.System;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.webkit.URLUtil;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableColorSpan;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.common.Achilles;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.FullPlayInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.video.VideoFeedsUtil;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class VideoFeedsHelper
{
  static Dialog a;
  static Handler b = new Handler(Looper.getMainLooper());
  private static int c = 0;
  private static int d = 0;
  private static boolean e = false;
  private static int f = 0;
  private static int g = 0;
  private static boolean h = false;
  private static boolean i = false;
  private static DecimalFormat j;
  private static DecimalFormat k;
  private static DecimalFormat l;
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      if (localObject != null)
      {
        localObject = ((Class)localObject).getMethod("getInt", new Class[] { String.class, Integer.TYPE });
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) });
          if ((paramString instanceof Integer))
          {
            int m = ((Integer)paramString).intValue();
            return m;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSystemPropertyForXiaomi() Exception=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("VideoFeedsHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
    return paramInt;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    if (ReadInJoyHelper.D(paramAppRuntime, "VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG_DATE")) {
      return b(paramAppRuntime);
    }
    return 0;
  }
  
  public static final Animator a(View paramView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, long paramLong, boolean paramBoolean)
  {
    int m = paramArrayOfInt1[0];
    int n = paramArrayOfInt1[1];
    int i1 = paramArrayOfInt3[0];
    int i2 = paramArrayOfInt3[1];
    int i3 = paramArrayOfInt2[0];
    int i4 = paramArrayOfInt2[1];
    int i5 = paramArrayOfInt4[0];
    int i6 = paramArrayOfInt4[1];
    paramView.setPivotX(0.0F);
    paramView.setPivotY(0.0F);
    paramArrayOfInt1 = new AnimatorSet();
    float f1 = i3 / paramView.getWidth();
    float f2 = i5 / paramView.getWidth();
    float f3 = i4 / paramView.getHeight();
    float f4 = i6 / paramView.getHeight();
    paramArrayOfInt2 = ObjectAnimator.ofFloat(paramView, "x", new float[] { m, i1 });
    paramArrayOfInt3 = ObjectAnimator.ofFloat(paramView, "y", new float[] { n, i2 });
    paramArrayOfInt4 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { f1, f2 });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { f3, f4 });
    paramArrayOfInt1.setDuration(paramLong);
    paramArrayOfInt1.playTogether(new Animator[] { paramArrayOfInt4, paramView, paramArrayOfInt2, paramArrayOfInt3 });
    if (paramBoolean) {
      paramArrayOfInt1.start();
    }
    return paramArrayOfInt1;
  }
  
  public static ObjectAnimator a(View paramView, int paramInt1, int paramInt2)
  {
    return a(paramView, paramInt1, paramInt2, false);
  }
  
  @TargetApi(11)
  public static ObjectAnimator a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView.getVisibility() == paramInt1) {
      return null;
    }
    if (!VersionUtils.e())
    {
      b(paramView, paramInt1, paramInt2);
      return null;
    }
    ObjectAnimator localObjectAnimator;
    if (paramInt1 == 0)
    {
      paramView.setVisibility(0);
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setDuration(paramInt2);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator.setRepeatCount(0);
      localObjectAnimator.start();
      paramView.setLayerType(2, null);
      localObjectAnimator.addListener(new VideoFeedsHelper.3(paramView));
      localObjectAnimator.start();
    }
    else if ((paramInt1 != 8) && (paramInt1 != 4))
    {
      localObjectAnimator = null;
    }
    else
    {
      localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(paramInt2);
      localObjectAnimator.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator.setRepeatCount(0);
      localObjectAnimator.start();
      paramView.setLayerType(2, null);
      localObjectAnimator.addListener(new VideoFeedsHelper.4(paramView));
      localObjectAnimator.start();
    }
    if (paramBoolean) {
      paramView.setTag(2131444213, localObjectAnimator);
    }
    return localObjectAnimator;
  }
  
  public static Rect a(Activity paramActivity, VideoInfo paramVideoInfo, int paramInt)
  {
    int n = paramVideoInfo.a(paramActivity, paramInt);
    int m = paramVideoInfo.i();
    int i1 = paramVideoInfo.j();
    paramActivity = c(paramActivity);
    if (n != 2)
    {
      n = paramActivity[0];
      paramInt = (int)(i1 / m * n);
      m = (paramActivity[1] - paramInt) / 2;
    }
    else
    {
      paramInt = paramActivity[1] - paramInt;
      n = (int)(m / i1 * paramInt);
      m = 0;
    }
    i1 = (paramActivity[0] - n) / 2;
    return new Rect(i1, m, n + i1, paramInt + m);
  }
  
  public static RecentUser a(List<RecentUser> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser.getType() == 0) {
        return localRecentUser;
      }
    }
    return null;
  }
  
  public static VideoInfo a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.b = paramBundle.getString("VIDEO_VID");
    Object localObject = paramBundle.getString("VIDEO_WIDTH");
    String str1 = paramBundle.getString("VIDEO_HEIGHT");
    String str2 = paramBundle.getString("VIDEO_TIME");
    boolean bool = false;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        m = Integer.valueOf((String)localObject).intValue();
        localVideoInfo.c = m;
        if (str1 == null) {
          break label539;
        }
        m = Integer.valueOf(str1).intValue();
        localVideoInfo.d = m;
        if (str2 == null) {
          break label544;
        }
        m = Integer.valueOf(str2).intValue();
        localVideoInfo.e = m;
      }
      catch (Exception localException)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finishActivityWithResult() e=");
      ((StringBuilder)localObject).append(str1.getMessage());
      VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
      localVideoInfo.k = paramBundle.getString("VIDEO_H5_URL");
      localVideoInfo.f = paramBundle.getString("VIDEO_COVER");
      localVideoInfo.q = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      localVideoInfo.h = paramBundle.getString("VIDEO_SUMMARY");
      localVideoInfo.g = paramBundle.getString("VIDEO_TITLE");
      localVideoInfo.i = paramBundle.getString("VIDEO_CREATE_TIME");
      localVideoInfo.l = paramBundle.getString("VIDEO_ARTICLE_ID");
      localVideoInfo.B = paramBundle.getString("VIDEO_THIRD_ICON");
      localVideoInfo.r = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      localObject = paramBundle.getString("VIDEO_THIRD_NAME");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localVideoInfo.r = ((String)localObject);
      }
      localVideoInfo.A = paramBundle.getString("VIDEO_THIRD_ACTION");
      localVideoInfo.a = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
      localVideoInfo.D = paramBundle.getString("VIDEO_URL");
      localVideoInfo.E = paramBundle.getLong("VIDEO_FEED_ID");
      localVideoInfo.F = paramBundle.getInt("VIDEO_FEED_TYPE");
      localVideoInfo.o = paramBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
      localVideoInfo.aB = ((AbsBaseArticleInfo)paramBundle.getParcelable("VIDEO_ARTICLE_INFO_FOR_BIU"));
      localVideoInfo.n = paramBundle.getLong("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.ai = paramBundle.getInt("VIDEO_STRATEGY_ID", 0);
      localVideoInfo.ah = paramBundle.getLong("VIDEO_ALGORITHM_ID", 0L);
      localVideoInfo.m = paramBundle.getString("VIDEO_RECOMMEND_REASON");
      if (localVideoInfo.a == 6) {
        bool = true;
      }
      localVideoInfo.t = bool;
      localVideoInfo.ay = ((VideoColumnInfo)paramBundle.getParcelable("VIDEO_COLUMN_INFO"));
      localVideoInfo.v = paramBundle.getString("KEY_VIDEO_JSON_LIST");
      localVideoInfo.aj = paramBundle.getInt("VIDEO_PLAY_COUNT");
      localVideoInfo.x = paramBundle.getInt("VIDEO_COLUMN_ID");
      localVideoInfo.al = paramBundle.getBoolean("VIDEO_ACCOUNT_IS_FOLLOWED");
      localVideoInfo.am = paramBundle.getBoolean("VIDEO_IS_DIANZAN");
      localVideoInfo.an = paramBundle.getInt("VIDEO_DIAN_ZAN_COUNT");
      localVideoInfo.p = paramBundle.getInt("VIDEO_COMMENT_COUNT");
      localVideoInfo.w = paramBundle.getInt("VIDEO_BIU_COUNT");
      return localVideoInfo;
      int m = 0;
      continue;
      label539:
      m = 0;
      continue;
      label544:
      m = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsUtil.b(paramInt));
    localStringBuilder.append(HardCodeUtil.a(2131913365));
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      paramString = e(paramInt);
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.getAccount();
    } else {
      paramQQAppInterface = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    return MD5Utils.toMD5(localStringBuilder.toString());
  }
  
  public static String a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return "";
    }
    String str;
    if (paramBoolean1) {
      str = ReadInJoyConstants.h;
    } else {
      str = ReadInJoyConstants.l;
    }
    if (paramBoolean2) {
      str = "https://viola.qq.com/js/profile.js?_rij_violaUrl=1&v_bid=3740&v_tid=6&v_bundleName=profile&hideNav=1&v_nav_immer=1&v_hide_nav=1&accountId=";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramVideoInfo.q).getBytes(), 2));
    localStringBuilder.append("&rowkey=");
    localStringBuilder.append(paramVideoInfo.l);
    localStringBuilder.append("&last_scene_type=3");
    return localStringBuilder.toString();
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.busiType != 1) && (paramAbsBaseArticleInfo.busiType != 6)) {
      return paramAbsBaseArticleInfo.thirdUinName;
    }
    return paramAbsBaseArticleInfo.getSubscribeName();
  }
  
  public static StringBuilder a(long paramLong)
  {
    if (paramLong >= 2147483647L) {
      return null;
    }
    paramLong /= 1000L;
    long l2 = paramLong / 3600L;
    long l1 = paramLong / 60L;
    long l3 = paramLong % 60L;
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong = l1;
    if (l2 > 0L)
    {
      paramLong = l1 - 60L * l2;
      if (l2 < 10L)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(l2);
      }
      else
      {
        localStringBuilder.append(l2);
      }
      localStringBuilder.append(":");
    }
    if (paramLong < 10L)
    {
      localStringBuilder.append("0");
      localStringBuilder.append(paramLong);
    }
    else
    {
      localStringBuilder.append(paramLong);
    }
    localStringBuilder.append(":");
    if (l3 < 10L)
    {
      localStringBuilder.append("0");
      localStringBuilder.append(l3);
      return localStringBuilder;
    }
    localStringBuilder.append(l3);
    return localStringBuilder;
  }
  
  public static List<RecentUser> a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    paramQQAppInterface = ForwardOptionBuilder.a(paramActivity.getIntent(), paramQQAppInterface, paramActivity);
    if (localRecentUserProxy != null) {
      return paramQQAppInterface.a(localRecentUserProxy.a(true));
    }
    return null;
  }
  
  public static JSONObject a(String paramString, List<VideoFullPlayController.FullPlayInfo> paramList, Bundle paramBundle)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          VideoFullPlayController.FullPlayInfo localFullPlayInfo = (VideoFullPlayController.FullPlayInfo)paramList.next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("rowKey", localFullPlayInfo.a.a());
          localJSONObject2.put("playCount", localFullPlayInfo.b);
          localJSONArray.put(localJSONObject2);
        }
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
      localJSONObject1.put("first_rowKey", paramString);
      if (paramBundle != null) {
        localJSONObject1.put("video_column_cookie", paramBundle.getString("video_column_topic_cookie"));
      }
      return localJSONObject1;
    }
    catch (Exception paramString)
    {
      paramList = new StringBuilder();
      paramList.append("[generateReqRangeJson error]: ");
      paramList.append(paramString.getMessage());
      QLog.e("VideoFeedsHelper", 1, paramList.toString());
    }
    return new JSONObject();
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    long l1;
    int m;
    String str;
    boolean bool;
    if ((paramAbsBaseArticleInfo.busiType == 6) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.c != null) && (!paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.isEmpty()))
    {
      l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.n.b.longValue();
      m = paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue();
      str = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.get(0)).b;
      bool = true;
    }
    else
    {
      l1 = 0L;
      str = null;
      bool = false;
      m = 0;
    }
    a(paramActivity, paramBundle, paramInt, paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo.busiType, paramAbsBaseArticleInfo.getVideoVid(), paramAbsBaseArticleInfo.getVideoWidth(), paramAbsBaseArticleInfo.getVideoHeight(), paramAbsBaseArticleInfo.getVideoDuration(), paramAbsBaseArticleInfo.mTitle, paramAbsBaseArticleInfo.getVideoCoverURL().getPath(), paramAbsBaseArticleInfo.mArticleContentUrl, paramAbsBaseArticleInfo.thirdUinName, paramAbsBaseArticleInfo.thirdUin, paramAbsBaseArticleInfo.mXGFileSize, bool, l1, m, str, null, null, null, null);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("VIDEO_ARTICLE_ID", paramString);
    a(paramActivity, localBundle, true, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt6, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putInt("VIDEO_FROM_TYPE", paramInt1);
    paramBundle.putString("VIDEO_VID", paramString2);
    paramBundle.putString("VIDEO_ARTICLE_ID", paramString1);
    paramBundle.putString("VIDEO_TITLE", paramString3);
    paramBundle.putString("VIDEO_COVER", paramString4);
    paramBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramInt2);
    paramBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramString7);
    paramBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramString6);
    paramBundle.putString("VIDEO_WIDTH", String.valueOf(paramInt3));
    paramBundle.putString("VIDEO_HEIGHT", String.valueOf(paramInt4));
    paramBundle.putString("VIDEO_TIME", String.valueOf(paramInt5));
    paramBundle.putLong("VIDEO_XG_FILE_SIZE", paramLong1);
    paramBundle.putBoolean("VIDEO_IS_UGC", paramBoolean);
    paramBundle.putLong("VIDEO_FEED_ID", paramLong2);
    paramBundle.putInt("VIDEO_FEED_TYPE", paramInt6);
    paramBundle.putString("VIDEO_URL", paramString8);
    paramBundle.putString("VIDEO_H5_URL", paramString5);
    paramBundle.putString("VIDEO_SUMMARY", paramString9);
    paramBundle.putString("VIDEO_THIRD_ACTION", paramString10);
    paramBundle.putString("VIDEO_THIRD_ICON", paramString11);
    paramBundle.putString("VIDEO_CREATE_TIME", paramString12);
    a(paramContext, paramBundle, false, paramInt1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Context paramContext, TextView paramTextView)
  {
    a(paramContext, paramTextView, HardCodeUtil.a(2131913410), HardCodeUtil.a(2131913414), CUKingCardHelper.a("kandian"), null);
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    int m = paramString1.indexOf(paramString2);
    int n = paramString2.length() + m;
    if (m >= 0)
    {
      if (n > paramString1.length()) {
        return;
      }
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new VideoFeedsHelper.12(paramString3, paramContext, paramOnClickListener), m, n, 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramString1);
    }
  }
  
  public static void a(Context paramContext, UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramContext != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jumpInfo.clipboardInfo = ");
        localStringBuilder.append(paramUrlJumpInfo.e);
        QLog.e("VideoFeedsHelper", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramUrlJumpInfo.e)) {
        b(paramContext, paramUrlJumpInfo.e);
      }
      if (paramUrlJumpInfo.a == 1)
      {
        if (!TextUtils.isEmpty(paramUrlJumpInfo.b)) {
          ReadInJoyUtils.a(paramContext, paramUrlJumpInfo.b);
        }
      }
      else if (paramUrlJumpInfo.a == 2)
      {
        if (!ReadInJoyActivityHelper.INSTANCE.checkAppPackage(paramUrlJumpInfo.c))
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoFeedsHelper", 2, "resolveUrlJumpInfo: checkAppPackage failure");
          }
          return;
        }
        if (PackageUtil.a(paramContext, paramUrlJumpInfo.c)) {
          a(paramContext, paramUrlJumpInfo.d);
        } else if ((!Achilles.a(paramUrlJumpInfo.c, true)) && (!TextUtils.isEmpty(paramUrlJumpInfo.b))) {
          ReadInJoyUtils.a(paramContext, paramUrlJumpInfo.b);
        }
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("resolveUrlJumpInfo: jumpInfo=");
        paramContext.append(paramUrlJumpInfo);
        QLog.d("VideoFeedsHelper", 2, paramContext.toString());
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
    localIntent.setData(Uri.parse(paramString));
    if (a(paramContext, localIntent))
    {
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = a;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {}
    try
    {
      a.dismiss();
      a = null;
      b.removeCallbacksAndMessages(null);
      localObject = new TextView(paramContext);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(2, 14.0F);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setBackgroundDrawable(h(paramContext));
      int m = AIOUtils.b(16.0F, paramContext.getResources());
      ((TextView)localObject).setPadding(m, 0, m, 0);
      paramString = new Dialog(paramContext, 2131952294);
      paramString.setContentView((View)localObject, new ViewGroup.LayoutParams(-2, DisplayUtil.a(paramContext, 40.0F)));
      paramString.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      paramString.setCanceledOnTouchOutside(false);
      paramContext = paramString.getWindow().getAttributes();
      paramContext.gravity = 49;
      paramContext.y = paramInt;
      paramString.getWindow().setFlags(16, 16);
    }
    catch (Exception localException)
    {
      try
      {
        paramString.show();
        label190:
        a = paramString;
        b.postDelayed(new VideoFeedsHelper.11(), 1000L);
        return;
        localException = localException;
      }
      catch (Exception paramContext)
      {
        break label190;
      }
    }
  }
  
  public static void a(View paramView)
  {
    paramView.clearAnimation();
    paramView = paramView.getTag(2131444213);
    if ((paramView instanceof ObjectAnimator)) {
      ((ObjectAnimator)paramView).cancel();
    }
  }
  
  public static void a(View paramView, int paramInt)
  {
    a(paramView, paramInt, 300);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getVisibility() == paramInt2) {
      return;
    }
    if (!VersionUtils.e())
    {
      paramView.setVisibility(paramInt2);
      return;
    }
    ObjectAnimator localObjectAnimator1;
    if (paramInt2 == 0)
    {
      paramView.setVisibility(0);
      localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramInt3, 0.0F });
      localObjectAnimator1.setDuration(paramInt1);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator1.setRepeatCount(0);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, 10.0F, 0.0F });
      localObjectAnimator2.setDuration(paramInt1 / 10);
      localObjectAnimator2.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator2.setRepeatCount(0);
      paramView.setLayerType(2, null);
      localObjectAnimator2.addListener(new VideoFeedsHelper.24(paramView));
      paramView = new AnimatorSet();
      paramView.setDuration(paramInt1 * 11 / 10);
      paramView.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      paramView.setInterpolator(new DecelerateInterpolator());
      paramView.start();
      return;
    }
    if ((paramInt2 == 8) || (paramInt2 == 4))
    {
      localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramInt3 });
      localObjectAnimator1.setDuration(paramInt1);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator1.setRepeatCount(0);
      paramView.setLayerType(2, null);
      localObjectAnimator1.addListener(new VideoFeedsHelper.25(paramView));
      localObjectAnimator1.start();
    }
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    paramView.postDelayed(new VideoFeedsHelper.26(paramView, paramInt1, paramInt2, paramInt4), paramInt3);
  }
  
  public static void a(View paramView, Point paramPoint)
  {
    if (paramView != null)
    {
      if (paramPoint == null) {
        return;
      }
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = paramPoint.x;
      localLayoutParams.height = paramPoint.y;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    if ((("sm-g9650".equalsIgnoreCase(Build.DEVICE)) || ("star2qltezc".equalsIgnoreCase(Build.PRODUCT))) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      paramViewGroup.bottomMargin += ViewUtils.dip2px(20.0F);
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, String paramString)
  {
    if (paramInt > 0) {
      paramString = e(paramInt);
    }
    if (paramTextView != null) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt > 0) {
      paramString2 = e(paramInt);
    }
    if (paramTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      paramTextView.setText(localStringBuilder.toString());
    }
  }
  
  public static void a(TextView paramTextView, long paramLong)
  {
    if (paramLong >= 2147483647L) {
      return;
    }
    if (paramTextView != null)
    {
      StringBuilder localStringBuilder1 = a(paramLong);
      if (localStringBuilder1 == null) {
        return;
      }
      if ((paramTextView.getTag() instanceof StringBuilder))
      {
        StringBuilder localStringBuilder2 = (StringBuilder)paramTextView.getTag();
        if (localStringBuilder1.toString().equals(localStringBuilder2.toString())) {
          return;
        }
      }
      paramTextView.setTag(localStringBuilder1);
      paramTextView.post(new VideoFeedsHelper.7(paramTextView, localStringBuilder1));
    }
  }
  
  public static void a(TextView paramTextView, VideoPlayerWrapper paramVideoPlayerWrapper, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    ReadInJoyHelper.o(ReadInJoyUtils.b());
    if (paramTextView != null) {
      paramTextView.setVisibility(8);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((VideoColumnSubscribeHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COLUMN_SUBSCRIBE_HANDLER)).a(paramInt, paramBoolean, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    ForwardUtils.a(paramQQAppInterface, null, paramQQAppInterface.getApplication().getApplicationContext(), localIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    VideoFeedsHelper.15 local15 = new VideoFeedsHelper.15(paramString1, paramBoolean1);
    int m;
    if (paramBoolean1) {
      m = 2;
    } else {
      m = 1;
    }
    localUserOperationModule.request0x978(paramQQAppInterface, paramString1, true, paramString2, local15, m, paramBoolean2);
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, View paramView)
  {
    if (!MultiVideoConfigHandler.d()) {
      return;
    }
    if (!(paramView instanceof ProteusItemView)) {
      return;
    }
    paramView = ((ProteusItemView)paramView).getContainer();
    if (paramView != null)
    {
      if (paramView.getVirtualView() == null) {
        return;
      }
      paramView = paramView.getVirtualView().findViewBaseByName("id_article_large_imge");
      if ((paramView instanceof ImageBase))
      {
        if (paramView.getNativeView() == null) {
          return;
        }
        paramView = (ImageBase)paramView;
        String str = paramView.getSrc();
        if (!TextUtils.isEmpty(str)) {
          paramVideoPlayParam.b = str;
        }
        paramVideoPlayParam.K = paramView.getNativeView().getWidth();
        paramVideoPlayParam.L = paramView.getNativeView().getHeight();
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.a != 0)
    {
      if (paramVideoInfo.aB == null)
      {
        BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
        localBaseArticleInfo.innerUniqueID = paramVideoInfo.l;
        localBaseArticleInfo.mTitle = paramVideoInfo.g;
        localBaseArticleInfo.mSubscribeName = paramVideoInfo.r;
        localBaseArticleInfo.mSubscribeID = paramVideoInfo.q;
        localBaseArticleInfo.mFirstPagePicUrl = paramVideoInfo.f;
        localBaseArticleInfo.mVideoDuration = paramVideoInfo.e;
        localBaseArticleInfo.mVideoCoverUrl = paramVideoInfo.t();
        localBaseArticleInfo.mVideoVid = paramVideoInfo.b;
        localBaseArticleInfo.mFeedType = paramVideoInfo.F;
        localBaseArticleInfo.mFeedId = paramVideoInfo.E;
        localBaseArticleInfo.mAlgorithmID = paramVideoInfo.ah;
        localBaseArticleInfo.mArticleID = paramVideoInfo.u;
        if (paramVideoInfo.t)
        {
          localBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localBaseArticleInfo.mSocialFeedInfo.s = new UGCFeedsInfo();
          if (!TextUtils.isEmpty(paramVideoInfo.q)) {
            localBaseArticleInfo.mSocialFeedInfo.s.e = Long.valueOf(paramVideoInfo.q).longValue();
          }
          localBaseArticleInfo.mSocialFeedInfo.s.a = paramVideoInfo.F;
          localBaseArticleInfo.mSocialFeedInfo.s.c = new ArrayList();
          UGCVideoInfo localUGCVideoInfo = new UGCVideoInfo();
          localUGCVideoInfo.n = paramVideoInfo.k;
          localUGCVideoInfo.e = paramVideoInfo.g;
          localUGCVideoInfo.d = paramVideoInfo.f;
          localUGCVideoInfo.g = paramVideoInfo.e;
          localBaseArticleInfo.mSocialFeedInfo.s.c.add(localUGCVideoInfo);
        }
        paramVideoInfo.aB = localBaseArticleInfo;
      }
      if (TextUtils.isEmpty(paramVideoInfo.aB.innerUniqueID)) {
        paramVideoInfo.aB.innerUniqueID = paramVideoInfo.l;
      }
    }
    else
    {
      paramVideoInfo.aB = new BaseArticleInfo();
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    paramTextView.setText(null);
    int m;
    if ((paramVideoInfo.aL != null) && (paramVideoInfo.aL.size() > 0)) {
      m = paramVideoInfo.aL.size() - 1;
    }
    while (m >= 0)
    {
      RichTitleInfo localRichTitleInfo = (RichTitleInfo)paramVideoInfo.aL.get(m);
      if (localRichTitleInfo.c != null)
      {
        ClickableColorSpan localClickableColorSpan = new ClickableColorSpan(-12541697);
        localClickableColorSpan.a(new VideoFeedsHelper.20(paramTextView, localRichTitleInfo, paramVideoInfo));
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRichTitleInfo.c);
        ((StringBuilder)localObject).append(" ");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        ((SpannableStringBuilder)localObject).setSpan(localClickableColorSpan, 0, ((SpannableStringBuilder)localObject).length(), 33);
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramTextView.append((CharSequence)localObject);
      }
      if (localRichTitleInfo.a != null) {
        paramTextView.append(localRichTitleInfo.a);
      }
      m -= 1;
      continue;
      paramTextView.setMovementMethod(null);
      paramTextView.setText(paramVideoInfo.g);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Intent paramIntent)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.hasFirstFramePreload()))
    {
      if (paramIntent == null) {
        return;
      }
      paramIntent.putExtra("item_image_width", paramAbsBaseArticleInfo.getFirstFrameWidth());
      paramIntent.putExtra("item_image_height", paramAbsBaseArticleInfo.getFirstFrameHeight());
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getFirstFrameUrl();
      if (paramAbsBaseArticleInfo != null) {
        paramIntent.putExtra("VIDEO_COVER", paramAbsBaseArticleInfo.toString());
      }
    }
  }
  
  public static void a(Object paramObject, VideoInfo paramVideoInfo, String paramString)
  {
    a(paramObject, paramVideoInfo, paramString, "single");
  }
  
  public static void a(Object paramObject, VideoInfo paramVideoInfo, String paramString1, String paramString2)
  {
    VideoReport.setElementParams(paramObject, new RIJDtParamBuilder().a(paramVideoInfo).c(paramString1).d(paramString2).c());
  }
  
  public static void a(Runnable paramRunnable)
  {
    ThreadUtil.a(paramRunnable);
  }
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "#00a5e0";
      }
      paramTextView.setText(paramString1);
      int m = Color.parseColor(str);
      paramString1 = new GradientDrawable();
      paramString1.setColor(m);
      paramString1.setCornerRadius(4);
      try
      {
        ApiCompatibilityUtils.a(paramTextView, paramString1);
      }
      catch (Exception paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("VideoFeedsHelper", 2, "setTagTextview: ", paramString2);
        }
        ApiCompatibilityUtils.a(paramTextView, paramString1);
      }
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    ReadInJoyHelper.x(paramAppRuntime, paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if (ReadInJoyAtlasManager.checkIsLocalFirstDoFavorite(paramActivity, true)) {
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131915580), paramActivity.getString(2131915579), 2131887648, 2131915578, new VideoFeedsHelper.17(), null).setMessageCount(null).show();
    }
  }
  
  public static boolean a()
  {
    return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = c(paramActivity);
    boolean bool = false;
    if (paramActivity[0] == 0) {
      return true;
    }
    if (paramActivity[1] / paramActivity[0] > 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get() != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.has()))
    {
      if (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.get() != 3) {
        return false;
      }
      paramAbsBaseArticleInfo = (articlesummary.UrlJumpInfo)paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get();
      int m = paramAbsBaseArticleInfo.uint32_jump_type.get();
      if (m == 1)
      {
        if (RIJPBFieldUtils.c(paramAbsBaseArticleInfo.bytes_jump_url))
        {
          ReadInJoyUtils.a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_url));
          return true;
        }
      }
      else if ((m == 2) && (RIJPBFieldUtils.c(paramAbsBaseArticleInfo.bytes_jump_bundle)) && (PackageUtil.a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_bundle))))
      {
        a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_schema));
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (paramIntent == null) {
        return false;
      }
      bool1 = bool2;
      if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      boolean bool = FollowListInfoModule.a(paramLong, null);
      return bool;
    }
    catch (Exception paramQQAppInterface)
    {
      label8:
      break label8;
    }
    return true;
  }
  
  public static boolean a(VideoInfo paramVideoInfo, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramVideoInfo == null) {
      return false;
    }
    if ((paramVideoInfo.t) && (!TextUtils.isEmpty(paramVideoInfo.q)) && (paramBaseQQAppInterface != null))
    {
      if (paramVideoInfo.q.equals(paramBaseQQAppInterface.getCurrentUin())) {
        return true;
      }
      if (((FriendsManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramVideoInfo.q)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    String str = ProteusSupportUtil.c(paramAbsBaseArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (UGRuleManager.a(str))
      {
        RIJJumpUtils.a(paramContext, paramAbsBaseArticleInfo, str);
        return true;
      }
      a(paramContext, str);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      boolean bool = a(null, Long.parseLong(paramString));
      return bool;
    }
    catch (Throwable paramString)
    {
      QLog.e("VideoFeedsHelper", 1, "checkPublicAccountIsFollowed error", paramString);
    }
    return false;
  }
  
  protected static int[] a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return new int[] { paramInt1, paramInt2 };
    }
    if (e) {
      return new int[] { paramInt1 - c, paramInt2 - d };
    }
    Object localObject = c(paramActivity);
    int m = localObject[0];
    int n = localObject[1];
    paramActivity = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    localObject = new Point();
    paramActivity.getSize((Point)localObject);
    int i1 = ((Point)localObject).x;
    int i2 = ((Point)localObject).y;
    c = i1 - m;
    d = i2 - n;
    e = true;
    return new int[] { paramInt1 - c, paramInt2 - d };
  }
  
  public static int[] a(Activity paramActivity, VideoInfo paramVideoInfo, boolean paramBoolean, int paramInt)
  {
    paramInt = paramVideoInfo.a(paramActivity, paramInt);
    int i1 = ViewUtils.dip2px(50.0F);
    int m = -1;
    int n;
    if (paramInt != 0)
    {
      if (paramInt == 2)
      {
        n = AIOUtils.b(10.0F, paramActivity.getResources());
        paramInt = i1;
        m = n;
        if (!LiuHaiUtils.b()) {
          break label281;
        }
        paramInt = i1 + LiuHaiUtils.e(paramActivity);
        m = n;
        break label281;
      }
    }
    else if (!paramBoolean)
    {
      paramInt = paramVideoInfo.d(paramActivity);
      int i2 = c(paramActivity)[1];
      if (i2 >= paramInt)
      {
        n = AIOUtils.b(10.0F, paramActivity.getResources());
        if (paramVideoInfo.a(paramActivity))
        {
          i2 = (i2 - paramInt) / 2;
          paramInt = i1;
          m = n;
          if (i2 <= i1) {
            break label281;
          }
          paramInt = AIOUtils.b(32.0F, paramActivity.getResources());
          m = i2;
        }
        else
        {
          m = (i2 - paramInt) / 2;
          paramInt = AIOUtils.b(10.0F, paramActivity.getResources());
        }
        paramInt = m + paramInt;
        m = n;
        break label281;
      }
    }
    else
    {
      if (paramVideoInfo.j() != 0) {
        break label197;
      }
    }
    paramInt = -1;
    break label281;
    label197:
    paramInt = c(paramActivity)[1];
    m = c(paramActivity)[0];
    m = (int)(paramVideoInfo.i() / paramVideoInfo.j() * m);
    if (m <= paramInt) {
      m = (paramInt - m) / 2 + AIOUtils.b(16.0F, paramActivity.getResources());
    } else {
      m = AIOUtils.b(16.0F, paramActivity.getResources());
    }
    paramInt = AIOUtils.b(16.0F, paramActivity.getResources());
    label281:
    return new int[] { paramInt, m };
  }
  
  public static int[] a(Context paramContext)
  {
    return a(paramContext, -1);
  }
  
  public static int[] a(Context paramContext, int paramInt)
  {
    Display localDisplay1;
    if ((Build.VERSION.SDK_INT >= 17) && (paramInt != -1)) {
      localDisplay1 = ((DisplayManager)paramContext.getSystemService("display")).getDisplay(paramInt);
    } else {
      localDisplay1 = null;
    }
    Display localDisplay2 = localDisplay1;
    if (localDisplay1 == null) {
      localDisplay2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    }
    paramContext = new Point();
    int m;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplay2.getRealSize(paramContext);
      m = paramContext.x;
      paramInt = paramContext.y;
    }
    else if (Build.VERSION.SDK_INT >= 15)
    {
      localDisplay2.getSize(paramContext);
      m = paramContext.x;
      paramInt = paramContext.y;
    }
    else
    {
      paramContext = new DisplayMetrics();
      localDisplay2.getMetrics(paramContext);
      m = paramContext.widthPixels;
      paramInt = paramContext.heightPixels;
    }
    return new int[] { m, paramInt };
  }
  
  public static Integer[] a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int n = paramArrayOfInt.length;
    int m = 0;
    if (n == 0) {
      return new Integer[0];
    }
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    while (m < paramArrayOfInt.length)
    {
      arrayOfInteger[m] = Integer.valueOf(paramArrayOfInt[m]);
      m += 1;
    }
    return arrayOfInteger;
  }
  
  public static int b()
  {
    int m;
    if (ReadInJoyHelper.b()) {
      m = 6;
    } else {
      m = 3;
    }
    return ViewUtils.dip2px(m);
  }
  
  public static int b(Activity paramActivity, VideoInfo paramVideoInfo, int paramInt)
  {
    int[] arrayOfInt = c(paramActivity);
    int m = arrayOfInt[0];
    int n = arrayOfInt[1];
    int i1 = paramVideoInfo.i();
    int i2 = paramVideoInfo.j();
    if ((paramActivity != null) && (m != 0))
    {
      if (n == 0) {
        return 0;
      }
      float f2 = n;
      float f1 = m;
      float f3 = f2 / f1;
      if ((paramVideoInfo.a(paramActivity)) && (i1 > 0) && (i2 > 0))
      {
        float f4 = i1;
        float f5 = i2;
        f2 = n - paramInt;
        paramInt = (int)(f5 / f4 * f1);
        if (f3 < 1.97D) {
          f1 = 0.95F;
        } else {
          f1 = 0.85F;
        }
        if (paramInt >= f1 * f2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  private static int b(AppRuntime paramAppRuntime)
  {
    return ReadInJoyHelper.ac(paramAppRuntime);
  }
  
  public static Rect b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.c = paramInt1;
    localVideoInfo.d = paramInt2;
    return a(paramActivity, localVideoInfo, d(paramActivity));
  }
  
  public static RecentUser b(List<RecentUser> paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser.getType() == 1) {
        return localRecentUser;
      }
    }
    return null;
  }
  
  public static Integer b(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Integer localInteger = Integer.valueOf(-1);
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get() != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.has()))
    {
      if (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.get() != 3) {
        return localInteger;
      }
      paramAbsBaseArticleInfo = (articlesummary.UrlJumpInfo)paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get();
      int m = paramAbsBaseArticleInfo.uint32_jump_type.get();
      if (m == 1)
      {
        if (RIJPBFieldUtils.c(paramAbsBaseArticleInfo.bytes_jump_url)) {
          return ReadInJoyUtils.a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_url));
        }
      }
      else if (m == 2)
      {
        if ((RIJPBFieldUtils.c(paramAbsBaseArticleInfo.bytes_jump_bundle)) && (PackageUtil.a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_bundle))))
        {
          a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_schema));
          return Integer.valueOf(16);
        }
        if (RIJPBFieldUtils.c(paramAbsBaseArticleInfo.bytes_jump_url)) {
          return ReadInJoyUtils.a(paramActivity, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.bytes_jump_url));
        }
      }
    }
    return localInteger;
  }
  
  public static Long b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.busiType == 1)
    {
      long l1;
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
        l1 = 0L;
      } else {
        l1 = Long.valueOf(paramAbsBaseArticleInfo.mSubscribeID).longValue();
      }
      return Long.valueOf(l1);
    }
    if (paramAbsBaseArticleInfo.busiType == 6)
    {
      if (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) {
        return Long.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.c.a);
      }
      return Long.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
    }
    return Long.valueOf(paramAbsBaseArticleInfo.thirdUin);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsUtil.b(paramInt));
    localStringBuilder.append(HardCodeUtil.a(2131913409));
    return localStringBuilder.toString();
  }
  
  public static String b(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (paramInt > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(d(paramInt));
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String b(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public static String b(View paramView)
  {
    if (paramView.getId() == -1) {
      return "no-id";
    }
    return paramView.getResources().getResourceName(paramView.getId());
  }
  
  public static void b(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    int m = paramString1.indexOf(paramString2);
    int n = paramString2.length() + m;
    if (m >= 0)
    {
      if (n > paramString1.length()) {
        return;
      }
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new VideoFeedsHelper.13(paramTextView), m, n, 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramString1);
      paramTextView.setOnClickListener(new VideoFeedsHelper.14(paramString3, paramContext, paramOnClickListener));
    }
  }
  
  private static void b(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null))
    {
      paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
      paramString = ClipData.newPlainText("", paramString);
      if (paramContext != null) {
        paramContext.setPrimaryClip(paramString);
      }
    }
  }
  
  public static void b(View paramView, int paramInt)
  {
    b(paramView, paramInt, 300);
  }
  
  @TargetApi(11)
  public static void b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    int n = paramView.getVisibility();
    int m = n;
    if (paramView.getTag(-1) != null)
    {
      m = n;
      if (paramView.getAnimation() != null) {
        m = ((Integer)paramView.getTag(-1)).intValue();
      }
    }
    paramView.setTag(-1, Integer.valueOf(paramInt1));
    if (m == paramInt1) {
      return;
    }
    AlphaAnimation localAlphaAnimation;
    if (paramInt1 == 0)
    {
      paramView.setVisibility(0);
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(paramInt2);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new VideoFeedsHelper.5(paramView));
      paramView.clearAnimation();
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
    if ((paramInt1 == 8) || (paramInt1 == 4))
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(paramInt2);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new VideoFeedsHelper.6(paramView));
      paramView.clearAnimation();
      paramView.startAnimation(localAlphaAnimation);
    }
  }
  
  public static void b(TextView paramTextView, int paramInt, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setTag(50331903, Integer.valueOf(paramInt));
    ThreadManager.excute(new VideoFeedsHelper.10(paramInt, paramString, paramTextView), 16, null, true);
  }
  
  public static void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("asyncHttpReport reportUrl = ");
      localStringBuilder.append(paramString);
      QLog.d("VideoFeedsHelper", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return;
      }
      ThreadManager.executeOnNetWorkThread(new VideoFeedsHelper.27(paramString));
    }
  }
  
  private static void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label8:
      StringBuilder localStringBuilder;
      break label8;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("followPubAccount() onFollowPublicAccount error uin=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", isSuccess=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", isUGC=");
    localStringBuilder.append(paramBoolean2);
    QLog.e("VideoFeedsHelper", 2, localStringBuilder.toString());
    l1 = -1L;
    if ((paramBoolean1) && (l1 != -1L))
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(l1, true);
      ThreadManager.post(new VideoFeedsHelper.16(l1), 8, null, true);
    }
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      int m = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isSystemAutoRotateOpen: value=");
        paramContext.append(m);
        QLog.d("VideoFeedsHelper", 2, paramContext.toString());
      }
      if (m == 1) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI() Settings.System.ACCELEROMETER_ROTATION ERROR=");
        localStringBuilder.append(paramContext.getMessage());
        QLog.d("VideoFeedsHelper", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public static byte[] b(VideoInfo paramVideoInfo)
  {
    StringBuilder localStringBuilder = null;
    if (paramVideoInfo == null) {
      return null;
    }
    Object localObject = localStringBuilder;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject = localStringBuilder;
      paramVideoInfo.writeToParcel(localParcel, 0);
      localObject = localStringBuilder;
      localParcel.setDataPosition(0);
      localObject = localStringBuilder;
      paramVideoInfo = localParcel.marshall();
      localObject = paramVideoInfo;
      localParcel.recycle();
      return paramVideoInfo;
    }
    catch (Exception paramVideoInfo)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBytesFromVideoInfo() error=");
      localStringBuilder.append(paramVideoInfo.toString());
      QLog.e("VideoFeedsHelper", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static int[] b(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    return new int[] { Math.min(paramActivity.getWidth(), paramActivity.getHeight()), Math.max(paramActivity.getWidth(), paramActivity.getHeight()) };
  }
  
  public static int c()
  {
    if (ReadInJoyHelper.b()) {
      return 0;
    }
    return 3;
  }
  
  public static int c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.c = paramInt1;
    localVideoInfo.d = paramInt2;
    return b(paramActivity, localVideoInfo, d(paramActivity));
  }
  
  @Nullable
  public static Animator c(View paramView, int paramInt)
  {
    if (((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramView.getTag(2131428370) == null))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int m = localMarginLayoutParams.height;
      localMarginLayoutParams.bottomMargin -= m;
      int n = localMarginLayoutParams.bottomMargin;
      paramView.setLayoutParams(localMarginLayoutParams);
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, m });
      localValueAnimator.addUpdateListener(new VideoFeedsHelper.18(m, localMarginLayoutParams, n, paramView));
      localValueAnimator.addListener(new VideoFeedsHelper.19(paramView));
      paramView.setTag(2131428370, localValueAnimator);
      long l1 = paramInt;
      localValueAnimator.setDuration(l1);
      localValueAnimator.start();
      paramView.setAlpha(0.0F);
      paramView.animate().alpha(1.0F).setDuration(l1).start();
      return localValueAnimator;
    }
    return null;
  }
  
  public static Intent c(Context paramContext)
  {
    return new Intent(paramContext, VideoFeedsPlayActivity.class);
  }
  
  public static String c(int paramInt)
  {
    return VideoFeedsUtil.a(paramInt);
  }
  
  public static String c(long paramLong)
  {
    if (j == null) {
      j = new DecimalFormat("##0.0");
    }
    Object localObject2 = j.format((float)paramLong / 1048576.0F);
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith(".0"))
    {
      int m = ((String)localObject2).indexOf(".0");
      localObject1 = localObject2;
      if (m > 0) {
        localObject1 = ((String)localObject2).substring(0, m);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("M");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (AppNetConnInfo.isMobileConn())
    {
      str = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        if (!paramString.contains("qq.com")) {
          return paramString;
        }
        int m = VasUtil.a().getVasFtManager().obtainCardState("016a");
        paramString = Uri.parse(paramString).buildUpon();
        paramString.appendQueryParameter("freeflow", String.valueOf(m));
        str = paramString.toString();
      }
    }
    return str;
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    boolean bool2 = bool4;
    boolean bool3 = bool5;
    for (;;)
    {
      try
      {
        if (UGRuleManager.c(paramAbsBaseArticleInfo))
        {
          bool2 = bool4;
          bool3 = bool5;
          if (paramAbsBaseArticleInfo.weishiUGInfo != null)
          {
            bool2 = bool4;
            bool3 = bool5;
            if (paramAbsBaseArticleInfo.weishiUGInfo.uint32_auto_play != null)
            {
              bool2 = bool4;
              bool3 = bool5;
              if (paramAbsBaseArticleInfo.weishiUGInfo.uint32_auto_play.has())
              {
                bool2 = bool4;
                if (paramAbsBaseArticleInfo.weishiUGInfo.uint32_auto_play.get() != 1) {
                  break label235;
                }
                bool2 = bool1;
                bool3 = bool1;
                if (QLog.isColorLevel())
                {
                  bool2 = bool1;
                  localStringBuilder = new StringBuilder();
                  bool2 = bool1;
                  localStringBuilder.append("isAutoPlayByUgVideoCard,articleInfo,title: ");
                  bool2 = bool1;
                  localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
                  bool2 = bool1;
                  localStringBuilder.append(", mArticleID:");
                  bool2 = bool1;
                  localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
                  bool2 = bool1;
                  localStringBuilder.append(",isAutoPlay:");
                  bool2 = bool1;
                  localStringBuilder.append(bool1);
                  bool2 = bool1;
                  QLog.d("VideoFeedsHelper", 2, localStringBuilder.toString());
                  return bool1;
                }
              }
            }
          }
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isAutoPlayByUgVideoCard error: ");
        localStringBuilder.append(paramAbsBaseArticleInfo.getMessage());
        QLog.e("VideoFeedsHelper", 2, localStringBuilder.toString());
        bool3 = bool2;
      }
      return bool3;
      label235:
      bool1 = false;
    }
  }
  
  @TargetApi(17)
  public static int[] c(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getScreenSize() ERROR activity == null");
      }
      return new int[] { 0, 0 };
    }
    int[] arrayOfInt = b(paramActivity);
    if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
    {
      f = arrayOfInt[0];
      g = arrayOfInt[1];
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("getMeasureScreenSize(): width=");
        paramActivity.append(arrayOfInt[0]);
        paramActivity.append(", height=");
        paramActivity.append(arrayOfInt[1]);
        QLog.d("VideoFeedsHelper", 2, paramActivity.toString());
      }
      return arrayOfInt;
    }
    arrayOfInt = a(paramActivity);
    f = arrayOfInt[0];
    g = arrayOfInt[1];
    int i2 = f;
    int i1 = g;
    int m;
    int n;
    if ((a()) && (f(paramActivity)))
    {
      paramActivity = g(paramActivity);
      m = i1;
      if (paramActivity == null) {
        break label242;
      }
      m = i1;
      if (paramActivity.length < 2) {
        break label242;
      }
      m = i1;
      if (paramActivity[0] <= 0) {
        break label242;
      }
      m = i1;
      if (paramActivity[1] <= 0) {
        break label242;
      }
      m = g;
      n = paramActivity[1];
    }
    else
    {
      m = i1;
      if (!d(paramActivity)) {
        break label242;
      }
      n = e(paramActivity);
      m = i1;
      if (n <= 0) {
        break label242;
      }
      m = g;
    }
    m -= n;
    label242:
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("getScreenSize() screenWidth=");
      paramActivity.append(f);
      paramActivity.append(", screenHeight=");
      paramActivity.append(g);
      paramActivity.append(", width=");
      paramActivity.append(i2);
      paramActivity.append(", height=");
      paramActivity.append(m);
      QLog.d("VideoFeedsHelper", 2, paramActivity.toString());
    }
    return new int[] { i2, m };
  }
  
  public static int d()
  {
    if (ReadInJoyHelper.b()) {
      return 22;
    }
    return 32;
  }
  
  public static int d(Activity paramActivity)
  {
    boolean bool = ReadInJoyHelper.b();
    int[] arrayOfInt = c(paramActivity);
    if ((bool) && (arrayOfInt[1] / arrayOfInt[0] >= 1.97D)) {
      return ViewUtils.dip2px(54.0F);
    }
    if ((!bool) && (a(paramActivity)) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1)) {
      return ViewUtils.dip2px(60.0F);
    }
    return 0;
  }
  
  public static String d(int paramInt)
  {
    return e(paramInt);
  }
  
  public static String d(long paramLong)
  {
    if (paramLong <= 0L) {
      return HardCodeUtil.a(2131913427);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramLong));
    localStringBuilder.append(HardCodeUtil.a(2131913423));
    return localStringBuilder.toString();
  }
  
  private static boolean d(Context paramContext)
  {
    boolean bool3 = "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int m = a("ro.miui.notch", 0);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isXiaomiWithNotch() getSystemPropertyForXiaomi=");
        paramContext.append(m);
        QLog.d("VideoFeedsHelper", 2, paramContext.toString());
      }
      bool1 = bool2;
      if (m == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Object[] d(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramActivity = c(paramActivity);
    int n = paramActivity[0];
    Boolean localBoolean = Boolean.valueOf(true);
    int m = paramActivity[1];
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      boolean bool;
      if (paramInt1 < paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      m -= 2;
      paramInt2 = (int)(paramInt2 / paramInt1 * n);
      paramInt1 = paramInt2;
      if (paramInt2 > m) {
        paramInt1 = m;
      }
      return new Object[] { localBoolean, Integer.valueOf(m), Integer.valueOf(paramInt1), Boolean.valueOf(bool) };
    }
    return new Object[] { Boolean.valueOf(false), Integer.valueOf(m), Integer.valueOf(m), localBoolean };
  }
  
  public static int e(Activity paramActivity)
  {
    return (int)(c(paramActivity)[0] * 9.0F / 16.0F);
  }
  
  private static int e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources();
      if (paramContext != null)
      {
        int m = paramContext.getIdentifier("status_bar_height", "dimen", "android");
        if (m > 0)
        {
          m = paramContext.getDimensionPixelSize(m);
          return m;
        }
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNotchSizeInXiaomi() Exception=");
        localStringBuilder.append(paramContext.getMessage());
        QLog.d("VideoFeedsHelper", 2, localStringBuilder.toString());
      }
    }
    return 0;
  }
  
  public static Pair<Integer, Integer> e(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)d(paramActivity, paramInt1, paramInt2)[2]).intValue();
    return new Pair(Integer.valueOf(c(paramActivity)[0]), Integer.valueOf(paramInt1));
  }
  
  public static String e(int paramInt)
  {
    Object localObject = "";
    if (paramInt >= 99985000) {
      return "9999万";
    }
    DecimalFormat localDecimalFormat;
    double d1;
    if (paramInt >= 10004999)
    {
      if (l == null) {
        l = new DecimalFormat("##");
      }
      localObject = new StringBuilder();
      localDecimalFormat = l;
      d1 = paramInt;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(localDecimalFormat.format(d1 / 10000.0D));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913376));
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt >= 10000)
    {
      if (k == null) {
        k = new DecimalFormat("##.#");
      }
      localObject = new StringBuilder();
      localDecimalFormat = k;
      d1 = paramInt;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(localDecimalFormat.format(d1 / 10000.0D));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913357));
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static final boolean e()
  {
    return Aladdin.getConfig(364).getIntegerFromString("is_interrupt", 1) == 1;
  }
  
  public static int f(Activity paramActivity)
  {
    int m = c(paramActivity)[0];
    return c(paramActivity)[1] - e(paramActivity);
  }
  
  public static boolean f()
  {
    if (Build.VERSION.SDK_INT <= 21) {}
    while ((Build.VERSION.SDK_INT > 21) && (Build.VERSION.SDK_INT <= 23) && (DeviceInfoUtil.a() <= -2147483648L)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private static boolean f(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 2075	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   6: astore_0
    //   7: iload_2
    //   8: istore_1
    //   9: aload_0
    //   10: ifnull +61 -> 71
    //   13: iload_2
    //   14: istore_1
    //   15: getstatic 1575	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 23
    //   20: if_icmplt +51 -> 71
    //   23: aload_0
    //   24: ldc_w 2077
    //   27: invokevirtual 2082	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   30: astore_0
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: ifnull +37 -> 71
    //   37: aload_0
    //   38: ldc_w 2084
    //   41: iconst_0
    //   42: anewarray 48	java/lang/Class
    //   45: invokevirtual 66	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   48: astore_3
    //   49: iload_2
    //   50: istore_1
    //   51: aload_3
    //   52: ifnull +19 -> 71
    //   55: aload_3
    //   56: aload_0
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokevirtual 76	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 2011	java/lang/Boolean
    //   67: invokevirtual 2087	java/lang/Boolean:booleanValue	()Z
    //   70: istore_1
    //   71: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +35 -> 109
    //   77: new 88	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   84: astore_0
    //   85: aload_0
    //   86: ldc_w 2089
    //   89: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: iload_1
    //   95: invokevirtual 1742	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc 101
    //   101: iconst_2
    //   102: aload_0
    //   103: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iload_1
    //   110: ireturn
    //   111: goto +85 -> 196
    //   114: astore_0
    //   115: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +38 -> 156
    //   121: new 88	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   128: astore_3
    //   129: aload_3
    //   130: ldc_w 2091
    //   133: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_3
    //   138: aload_0
    //   139: invokevirtual 99	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 101
    //   148: iconst_2
    //   149: aload_3
    //   150: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +35 -> 194
    //   162: new 88	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   169: astore_0
    //   170: aload_0
    //   171: ldc_w 2089
    //   174: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_0
    //   179: iconst_0
    //   180: invokevirtual 1742	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 101
    //   186: iconst_2
    //   187: aload_0
    //   188: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +35 -> 234
    //   202: new 88	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   209: astore_0
    //   210: aload_0
    //   211: ldc_w 2089
    //   214: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_0
    //   219: iconst_0
    //   220: invokevirtual 1742	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 101
    //   226: iconst_2
    //   227: aload_0
    //   228: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_0
    //   237: goto -126 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   8	102	1	bool1	boolean
    //   1	49	2	bool2	boolean
    //   48	102	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	114	java/lang/Exception
    //   15	31	114	java/lang/Exception
    //   37	49	114	java/lang/Exception
    //   55	71	114	java/lang/Exception
    //   2	7	236	finally
    //   15	31	236	finally
    //   37	49	236	finally
    //   55	71	236	finally
    //   115	156	236	finally
  }
  
  public static void g(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(7428);
  }
  
  public static boolean g()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(153);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig != null)
    {
      int m = localAladdinConfig.getIntegerFromString("readinjoy_videochannel_jump_multivideo_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isVideoChannelClickJumpToMultiVideo(), value = ", Integer.valueOf(m) });
      }
      bool1 = bool2;
      if (m == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static int[] g(Context paramContext)
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray int
    //   3: astore_1
    //   4: aload_1
    //   5: dup
    //   6: iconst_0
    //   7: iconst_0
    //   8: iastore
    //   9: dup
    //   10: iconst_1
    //   11: iconst_0
    //   12: iastore
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual 2075	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +50 -> 70
    //   23: aload_0
    //   24: ldc_w 2077
    //   27: invokevirtual 2082	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +38 -> 70
    //   35: aload_0
    //   36: ldc_w 2104
    //   39: iconst_0
    //   40: anewarray 48	java/lang/Class
    //   43: invokevirtual 66	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +22 -> 70
    //   51: aload_2
    //   52: aload_0
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokevirtual 76	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 2106	[I
    //   63: checkcast 2106	[I
    //   66: astore_0
    //   67: goto +5 -> 72
    //   70: aload_1
    //   71: astore_0
    //   72: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +35 -> 110
    //   78: new 88	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc_w 2108
    //   90: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: aload_0
    //   96: invokevirtual 849	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 101
    //   102: iconst_2
    //   103: aload_1
    //   104: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_0
    //   111: areturn
    //   112: goto +85 -> 197
    //   115: astore_0
    //   116: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +38 -> 157
    //   122: new 88	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   129: astore_2
    //   130: aload_2
    //   131: ldc_w 2110
    //   134: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_2
    //   139: aload_0
    //   140: invokevirtual 99	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 101
    //   149: iconst_2
    //   150: aload_2
    //   151: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +35 -> 195
    //   163: new 88	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   170: astore_0
    //   171: aload_0
    //   172: ldc_w 2108
    //   175: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual 849	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 101
    //   187: iconst_2
    //   188: aload_0
    //   189: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_1
    //   196: areturn
    //   197: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +35 -> 235
    //   203: new 88	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   210: astore_0
    //   211: aload_0
    //   212: ldc_w 2108
    //   215: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 849	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 101
    //   227: iconst_2
    //   228: aload_0
    //   229: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_1
    //   236: areturn
    //   237: astore_0
    //   238: goto -126 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramContext	Context
    //   3	233	1	localObject1	Object
    //   46	105	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	115	java/lang/Exception
    //   23	31	115	java/lang/Exception
    //   35	47	115	java/lang/Exception
    //   51	67	115	java/lang/Exception
    //   14	19	237	finally
    //   23	31	237	finally
    //   35	47	237	finally
    //   51	67	237	finally
    //   116	157	237	finally
  }
  
  private static Drawable h(Context paramContext)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(AIOUtils.b(3.0F, paramContext.getResources()));
    localGradientDrawable.setColor(-1728053248);
    localGradientDrawable.setStroke(1, 0);
    return localGradientDrawable;
  }
  
  public static void h(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(7942);
  }
  
  public static boolean h()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(169);
    boolean bool = true;
    if (localAladdinConfig != null)
    {
      int m = localAladdinConfig.getIntegerFromString("kandian_video_logo_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isShowKandianVideoLogoEnable(), value = ", Integer.valueOf(m) });
      }
      if (m == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static int i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    int m;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("ks_column_card_video_autoplay", 0);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getKSColumnCardAutoPlayConfig(), value = ", Integer.valueOf(n) });
        return n;
      }
    }
    else
    {
      m = 0;
    }
    return m;
  }
  
  public static void i(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(6914);
  }
  
  public static int j()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(300);
    int m;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("king_card_support", 2);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getMainFeedsKingCardAutoPlayConfig(), value = ", Integer.valueOf(n) });
        return n;
      }
    }
    else
    {
      m = 0;
    }
    return m;
  }
  
  public static boolean j(Activity paramActivity)
  {
    return paramActivity instanceof VideoFeedsPlayActivity;
  }
  
  public static int k()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    int m;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("big_img_video_autoplay", 0);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoCardAutoPlayConfig(), value = ", Integer.valueOf(n) });
        return n;
      }
    }
    else
    {
      m = 0;
    }
    return m;
  }
  
  public static int l()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    int m;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("big_img_video_click_show_layer", 0);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoClickShowLayer(), value = ", Integer.valueOf(n) });
        return n;
      }
    }
    else
    {
      m = 0;
    }
    return m;
  }
  
  public static int m()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(239);
    int m;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("big_img_video_column_autoplay", 0);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoColumnCardAutoPlayConfig(), value = ", Integer.valueOf(n) });
        return n;
      }
    }
    else
    {
      m = 0;
    }
    return m;
  }
  
  public static int n()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(239);
    int m;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("big_img_video_column_click_show_layer", 0);
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoColumnClickShowLayer(), value = ", Integer.valueOf(n) });
        return n;
      }
    }
    else
    {
      m = 0;
    }
    return m;
  }
  
  public static boolean o()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(180);
    boolean bool = true;
    if (localAladdinConfig != null)
    {
      int m = localAladdinConfig.getIntegerFromString("VideoEntranceJumpAppSwitch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isVideoEntranceJumpAppEnable(), value = ", Integer.valueOf(m) });
      }
      if (m == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static int p()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(180);
    if (localAladdinConfig != null)
    {
      int m = localAladdinConfig.getIntegerFromString("VideoEntranceJumpMaxDisplayCountOneDay", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getVideoEntranceJumpAppMaxDisplayCountOneDay(), value = ", Integer.valueOf(m) });
      }
      return m;
    }
    return 0;
  }
  
  public static boolean q()
  {
    return Aladdin.getConfig(376).getIntegerFromString("slide_into_home_page_enable", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper
 * JD-Core Version:    0.7.0.1
 */