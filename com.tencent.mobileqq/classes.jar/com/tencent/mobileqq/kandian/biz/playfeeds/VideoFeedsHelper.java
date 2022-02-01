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
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
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
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
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
  private static int jdField_a_of_type_Int = 0;
  static Dialog jdField_a_of_type_AndroidAppDialog;
  static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static DecimalFormat jdField_a_of_type_JavaTextDecimalFormat;
  private static boolean jdField_a_of_type_Boolean = false;
  private static int jdField_b_of_type_Int = 0;
  private static DecimalFormat jdField_b_of_type_JavaTextDecimalFormat;
  private static boolean jdField_b_of_type_Boolean = false;
  private static int jdField_c_of_type_Int = 0;
  private static DecimalFormat jdField_c_of_type_JavaTextDecimalFormat;
  private static boolean jdField_c_of_type_Boolean = false;
  private static int d;
  
  public static int a()
  {
    int i;
    if (ReadInJoyHelper.b()) {
      i = 6;
    } else {
      i = 3;
    }
    return ViewUtils.a(i);
  }
  
  public static int a(Activity paramActivity)
  {
    boolean bool = ReadInJoyHelper.b();
    int[] arrayOfInt = b(paramActivity);
    if ((bool) && (arrayOfInt[1] / arrayOfInt[0] >= 1.97D)) {
      return ViewUtils.a(54.0F);
    }
    if ((!bool) && (a(paramActivity)) && (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) == 1)) {
      return ViewUtils.a(60.0F);
    }
    return 0;
  }
  
  public static int a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_b_of_type_Int = paramInt1;
    localVideoInfo.jdField_c_of_type_Int = paramInt2;
    return a(paramActivity, localVideoInfo, a(paramActivity));
  }
  
  public static int a(Activity paramActivity, VideoInfo paramVideoInfo, int paramInt)
  {
    int[] arrayOfInt = b(paramActivity);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramVideoInfo.a();
    int m = paramVideoInfo.b();
    if ((paramActivity != null) && (i != 0))
    {
      if (j == 0) {
        return 0;
      }
      float f2 = j;
      float f1 = i;
      float f3 = f2 / f1;
      if ((paramVideoInfo.a(paramActivity)) && (k > 0) && (m > 0))
      {
        float f4 = k;
        float f5 = m;
        f2 = j - paramInt;
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
  
  private static int a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources();
      if (paramContext != null)
      {
        int i = paramContext.getIdentifier("status_bar_height", "dimen", "android");
        if (i > 0)
        {
          i = paramContext.getDimensionPixelSize(i);
          return i;
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
            int i = ((Integer)paramString).intValue();
            return i;
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
    if (ReadInJoyHelper.b(paramAppRuntime, "VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG_DATE")) {
      return b(paramAppRuntime);
    }
    return 0;
  }
  
  @Nullable
  public static Animator a(View paramView, int paramInt)
  {
    if (((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramView.getTag(2131362698) == null))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int i = localMarginLayoutParams.height;
      localMarginLayoutParams.bottomMargin -= i;
      int j = localMarginLayoutParams.bottomMargin;
      paramView.setLayoutParams(localMarginLayoutParams);
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
      localValueAnimator.addUpdateListener(new VideoFeedsHelper.18(i, localMarginLayoutParams, j, paramView));
      localValueAnimator.addListener(new VideoFeedsHelper.19(paramView));
      paramView.setTag(2131362698, localValueAnimator);
      long l = paramInt;
      localValueAnimator.setDuration(l);
      localValueAnimator.start();
      paramView.setAlpha(0.0F);
      paramView.animate().alpha(1.0F).setDuration(l).start();
      return localValueAnimator;
    }
    return null;
  }
  
  public static final Animator a(View paramView, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, long paramLong, boolean paramBoolean)
  {
    int i = paramArrayOfInt1[0];
    int j = paramArrayOfInt1[1];
    int k = paramArrayOfInt3[0];
    int m = paramArrayOfInt3[1];
    int n = paramArrayOfInt2[0];
    int i1 = paramArrayOfInt2[1];
    int i2 = paramArrayOfInt4[0];
    int i3 = paramArrayOfInt4[1];
    paramView.setPivotX(0.0F);
    paramView.setPivotY(0.0F);
    paramArrayOfInt1 = new AnimatorSet();
    float f1 = n / paramView.getWidth();
    float f2 = i2 / paramView.getWidth();
    float f3 = i1 / paramView.getHeight();
    float f4 = i3 / paramView.getHeight();
    paramArrayOfInt2 = ObjectAnimator.ofFloat(paramView, "x", new float[] { i, k });
    paramArrayOfInt3 = ObjectAnimator.ofFloat(paramView, "y", new float[] { j, m });
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
      a(paramView, paramInt1, paramInt2);
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
      paramView.setTag(2131376013, localObjectAnimator);
    }
    return localObjectAnimator;
  }
  
  public static Rect a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_b_of_type_Int = paramInt1;
    localVideoInfo.jdField_c_of_type_Int = paramInt2;
    return a(paramActivity, localVideoInfo, a(paramActivity));
  }
  
  public static Rect a(Activity paramActivity, VideoInfo paramVideoInfo, int paramInt)
  {
    int j = paramVideoInfo.a(paramActivity, paramInt);
    int i = paramVideoInfo.a();
    int k = paramVideoInfo.b();
    paramActivity = b(paramActivity);
    if (j != 2)
    {
      j = paramActivity[0];
      paramInt = (int)(k / i * j);
      i = (paramActivity[1] - paramInt) / 2;
    }
    else
    {
      paramInt = paramActivity[1] - paramInt;
      j = (int)(i / k * paramInt);
      i = 0;
    }
    k = (paramActivity[0] - j) / 2;
    return new Rect(k, i, j + k, paramInt + i);
  }
  
  private static Drawable a(Context paramContext)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(AIOUtils.b(3.0F, paramContext.getResources()));
    localGradientDrawable.setColor(-1728053248);
    localGradientDrawable.setStroke(1, 0);
    return localGradientDrawable;
  }
  
  public static Pair<Integer, Integer> a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)a(paramActivity, paramInt1, paramInt2)[2]).intValue();
    return new Pair(Integer.valueOf(b(paramActivity)[0]), Integer.valueOf(paramInt1));
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
    localVideoInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("VIDEO_VID");
    Object localObject = paramBundle.getString("VIDEO_WIDTH");
    String str1 = paramBundle.getString("VIDEO_HEIGHT");
    String str2 = paramBundle.getString("VIDEO_TIME");
    boolean bool = false;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf((String)localObject).intValue();
        localVideoInfo.jdField_b_of_type_Int = i;
        if (str1 == null) {
          break label539;
        }
        i = Integer.valueOf(str1).intValue();
        localVideoInfo.jdField_c_of_type_Int = i;
        if (str2 == null) {
          break label544;
        }
        i = Integer.valueOf(str2).intValue();
        localVideoInfo.jdField_d_of_type_Int = i;
      }
      catch (Exception localException)
      {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finishActivityWithResult() e=");
      ((StringBuilder)localObject).append(str1.getMessage());
      VideoFeedsPlayActivity.a(((StringBuilder)localObject).toString());
      localVideoInfo.jdField_f_of_type_JavaLangString = paramBundle.getString("VIDEO_H5_URL");
      localVideoInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("VIDEO_COVER");
      localVideoInfo.j = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      localVideoInfo.jdField_d_of_type_JavaLangString = paramBundle.getString("VIDEO_SUMMARY");
      localVideoInfo.jdField_c_of_type_JavaLangString = paramBundle.getString("VIDEO_TITLE");
      localVideoInfo.jdField_e_of_type_JavaLangString = paramBundle.getString("VIDEO_CREATE_TIME");
      localVideoInfo.jdField_g_of_type_JavaLangString = paramBundle.getString("VIDEO_ARTICLE_ID");
      localVideoInfo.jdField_p_of_type_JavaLangString = paramBundle.getString("VIDEO_THIRD_ICON");
      localVideoInfo.k = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      localObject = paramBundle.getString("VIDEO_THIRD_NAME");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localVideoInfo.k = ((String)localObject);
      }
      localVideoInfo.o = paramBundle.getString("VIDEO_THIRD_ACTION");
      localVideoInfo.jdField_a_of_type_Int = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
      localVideoInfo.r = paramBundle.getString("VIDEO_URL");
      localVideoInfo.jdField_d_of_type_Long = paramBundle.getLong("VIDEO_FEED_ID");
      localVideoInfo.jdField_h_of_type_Int = paramBundle.getInt("VIDEO_FEED_TYPE");
      localVideoInfo.i = paramBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramBundle.getParcelable("VIDEO_ARTICLE_INFO_FOR_BIU"));
      localVideoInfo.jdField_b_of_type_Long = paramBundle.getLong("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.jdField_p_of_type_Int = paramBundle.getInt("VIDEO_STRATEGY_ID", 0);
      localVideoInfo.jdField_f_of_type_Long = paramBundle.getLong("VIDEO_ALGORITHM_ID", 0L);
      localVideoInfo.jdField_h_of_type_JavaLangString = paramBundle.getString("VIDEO_RECOMMEND_REASON");
      if (localVideoInfo.jdField_a_of_type_Int == 6) {
        bool = true;
      }
      localVideoInfo.jdField_b_of_type_Boolean = bool;
      localVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo = ((VideoColumnInfo)paramBundle.getParcelable("VIDEO_COLUMN_INFO"));
      localVideoInfo.l = paramBundle.getString("KEY_VIDEO_JSON_LIST");
      localVideoInfo.jdField_q_of_type_Int = paramBundle.getInt("VIDEO_PLAY_COUNT");
      localVideoInfo.jdField_g_of_type_Int = paramBundle.getInt("VIDEO_COLUMN_ID");
      localVideoInfo.jdField_p_of_type_Boolean = paramBundle.getBoolean("VIDEO_ACCOUNT_IS_FOLLOWED");
      localVideoInfo.jdField_q_of_type_Boolean = paramBundle.getBoolean("VIDEO_IS_DIANZAN");
      localVideoInfo.s = paramBundle.getInt("VIDEO_DIAN_ZAN_COUNT");
      localVideoInfo.jdField_e_of_type_Int = paramBundle.getInt("VIDEO_COMMENT_COUNT");
      localVideoInfo.jdField_f_of_type_Int = paramBundle.getInt("VIDEO_BIU_COUNT");
      return localVideoInfo;
      int i = 0;
      continue;
      label539:
      i = 0;
      continue;
      label544:
      i = 0;
    }
  }
  
  public static Integer a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Integer localInteger = Integer.valueOf(-1);
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get() != null) && (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.has()))
    {
      if (paramAbsBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.get() != 3) {
        return localInteger;
      }
      paramAbsBaseArticleInfo = (articlesummary.UrlJumpInfo)paramAbsBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get();
      int i = paramAbsBaseArticleInfo.uint32_jump_type.get();
      if (i == 1)
      {
        if (RIJPBFieldUtils.a(paramAbsBaseArticleInfo.bytes_jump_url)) {
          return ReadInJoyUtils.a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_url));
        }
      }
      else if (i == 2)
      {
        if ((RIJPBFieldUtils.a(paramAbsBaseArticleInfo.bytes_jump_bundle)) && (PackageUtil.a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_bundle))))
        {
          a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_schema));
          return Integer.valueOf(16);
        }
        if (RIJPBFieldUtils.a(paramAbsBaseArticleInfo.bytes_jump_url)) {
          return ReadInJoyUtils.a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_url));
        }
      }
    }
    return localInteger;
  }
  
  public static Long a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.busiType == 1)
    {
      long l;
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
        l = 0L;
      } else {
        l = Long.valueOf(paramAbsBaseArticleInfo.mSubscribeID).longValue();
      }
      return Long.valueOf(l);
    }
    if (paramAbsBaseArticleInfo.busiType == 6)
    {
      if (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) {
        return Long.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
      }
      return Long.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
    }
    return Long.valueOf(paramAbsBaseArticleInfo.thirdUin);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsUtil.b(paramInt));
    localStringBuilder.append(HardCodeUtil.a(2131715909));
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      paramString = e(paramInt);
    }
    return paramString;
  }
  
  public static String a(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  public static String a(View paramView)
  {
    if (paramView.getId() == -1) {
      return "no-id";
    }
    return paramView.getResources().getResourceName(paramView.getId());
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
      str = ReadInJoyConstants.jdField_g_of_type_JavaLangString;
    } else {
      str = ReadInJoyConstants.k;
    }
    if (paramBoolean2) {
      str = "https://viola.qq.com/js/profile.js?_rij_violaUrl=1&v_bid=3740&v_tid=6&v_bundleName=profile&hideNav=1&v_nav_immer=1&v_hide_nav=1&accountId=";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramVideoInfo.j).getBytes(), 2));
    localStringBuilder.append("&rowkey=");
    localStringBuilder.append(paramVideoInfo.jdField_g_of_type_JavaLangString);
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
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().a();
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
          localJSONObject2.put("rowKey", localFullPlayInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityBaseVideoPlayParam.a());
          localJSONObject2.put("playCount", localFullPlayInfo.jdField_a_of_type_Int);
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
  
  public static void a(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(7428);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    long l;
    int i;
    String str;
    boolean bool;
    if ((paramAbsBaseArticleInfo.busiType == 6) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b != null) && (!paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.isEmpty()))
    {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.longValue();
      i = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue();
      str = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_b_of_type_JavaLangString;
      bool = true;
    }
    else
    {
      l = 0L;
      str = null;
      bool = false;
      i = 0;
    }
    a(paramActivity, paramBundle, paramInt, paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo.busiType, paramAbsBaseArticleInfo.getVideoVid(), paramAbsBaseArticleInfo.getVideoWidth(), paramAbsBaseArticleInfo.getVideoHeight(), paramAbsBaseArticleInfo.getVideoDuration(), paramAbsBaseArticleInfo.mTitle, paramAbsBaseArticleInfo.getVideoCoverURL().getPath(), paramAbsBaseArticleInfo.mArticleContentUrl, paramAbsBaseArticleInfo.thirdUinName, paramAbsBaseArticleInfo.thirdUin, paramAbsBaseArticleInfo.mXGFileSize, bool, l, i, str, null, null, null, null);
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
    a(paramContext, paramTextView, HardCodeUtil.a(2131715955), HardCodeUtil.a(2131715960), CUKingCardHelper.a("kandian"), null);
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    if (i >= 0)
    {
      if (j > paramString1.length()) {
        return;
      }
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new VideoFeedsHelper.12(paramString3, paramContext, paramOnClickListener), i, j, 33);
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
        localStringBuilder.append(paramUrlJumpInfo.jdField_d_of_type_JavaLangString);
        QLog.e("VideoFeedsHelper", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramUrlJumpInfo.jdField_d_of_type_JavaLangString)) {
        b(paramContext, paramUrlJumpInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramUrlJumpInfo.jdField_a_of_type_Int == 1)
      {
        if (!TextUtils.isEmpty(paramUrlJumpInfo.jdField_a_of_type_JavaLangString)) {
          ReadInJoyUtils.a(paramContext, paramUrlJumpInfo.jdField_a_of_type_JavaLangString);
        }
      }
      else if (paramUrlJumpInfo.jdField_a_of_type_Int == 2)
      {
        if (!((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).checkAppPackage(paramUrlJumpInfo.jdField_b_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoFeedsHelper", 2, "resolveUrlJumpInfo: checkAppPackage failure");
          }
          return;
        }
        if (PackageUtil.a(paramContext, paramUrlJumpInfo.jdField_b_of_type_JavaLangString)) {
          a(paramContext, paramUrlJumpInfo.jdField_c_of_type_JavaLangString);
        } else if ((!Achilles.a(paramUrlJumpInfo.jdField_b_of_type_JavaLangString, true)) && (!TextUtils.isEmpty(paramUrlJumpInfo.jdField_a_of_type_JavaLangString))) {
          ReadInJoyUtils.a(paramContext, paramUrlJumpInfo.jdField_a_of_type_JavaLangString);
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
    Object localObject = jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {}
    try
    {
      jdField_a_of_type_AndroidAppDialog.dismiss();
      jdField_a_of_type_AndroidAppDialog = null;
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      localObject = new TextView(paramContext);
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextColor(-1);
      ((TextView)localObject).setTextSize(2, 14.0F);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setBackgroundDrawable(a(paramContext));
      int i = AIOUtils.b(16.0F, paramContext.getResources());
      ((TextView)localObject).setPadding(i, 0, i, 0);
      paramString = new Dialog(paramContext, 2131755508);
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
        jdField_a_of_type_AndroidAppDialog = paramString;
        jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsHelper.11(), 1000L);
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
    paramView = paramView.getTag(2131376013);
    if ((paramView instanceof ObjectAnimator)) {
      ((ObjectAnimator)paramView).cancel();
    }
  }
  
  public static void a(View paramView, int paramInt)
  {
    a(paramView, paramInt, 300);
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    int j = paramView.getVisibility();
    int i = j;
    if (paramView.getTag(-1) != null)
    {
      i = j;
      if (paramView.getAnimation() != null) {
        i = ((Integer)paramView.getTag(-1)).intValue();
      }
    }
    paramView.setTag(-1, Integer.valueOf(paramInt1));
    if (i == paramInt1) {
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
      paramViewGroup.bottomMargin += ViewUtils.a(20.0F);
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
    ReadInJoyHelper.j(ReadInJoyUtils.a());
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
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    VideoFeedsHelper.15 local15 = new VideoFeedsHelper.15(paramString1, paramBoolean1);
    int i;
    if (paramBoolean1) {
      i = 2;
    } else {
      i = 1;
    }
    localUserOperationModule.request0x978(paramQQAppInterface, paramString1, true, paramString2, local15, i, paramBoolean2);
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, View paramView)
  {
    if (!MultiVideoConfigHandler.a()) {
      return;
    }
    if (!(paramView instanceof ProteusItemView)) {
      return;
    }
    paramView = ((ProteusItemView)paramView).a();
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
          paramVideoPlayParam.jdField_b_of_type_JavaLangString = str;
        }
        paramVideoPlayParam.j = paramView.getNativeView().getWidth();
        paramVideoPlayParam.k = paramView.getNativeView().getHeight();
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
      {
        BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
        localBaseArticleInfo.innerUniqueID = paramVideoInfo.jdField_g_of_type_JavaLangString;
        localBaseArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localBaseArticleInfo.mSubscribeName = paramVideoInfo.k;
        localBaseArticleInfo.mSubscribeID = paramVideoInfo.j;
        localBaseArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localBaseArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localBaseArticleInfo.mVideoCoverUrl = paramVideoInfo.a();
        localBaseArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localBaseArticleInfo.mFeedType = paramVideoInfo.jdField_h_of_type_Int;
        localBaseArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localBaseArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localBaseArticleInfo.mArticleID = paramVideoInfo.jdField_c_of_type_Long;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          localBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo = new UGCFeedsInfo();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b = new ArrayList();
          UGCVideoInfo localUGCVideoInfo = new UGCVideoInfo();
          localUGCVideoInfo.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localUGCVideoInfo.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localUGCVideoInfo.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localUGCVideoInfo.jdField_a_of_type_Long = paramVideoInfo.jdField_d_of_type_Int;
          localBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.add(localUGCVideoInfo);
        }
        paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = localBaseArticleInfo;
      }
      if (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)) {
        paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID = paramVideoInfo.jdField_g_of_type_JavaLangString;
      }
    }
    else
    {
      paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = new BaseArticleInfo();
    }
  }
  
  public static void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    paramTextView.setText(null);
    int i;
    if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList != null) && (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() > 0)) {
      i = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() - 1;
    }
    while (i >= 0)
    {
      RichTitleInfo localRichTitleInfo = (RichTitleInfo)paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.get(i);
      if (localRichTitleInfo.jdField_c_of_type_JavaLangString != null)
      {
        ClickableColorSpan localClickableColorSpan = new ClickableColorSpan(-12541697);
        localClickableColorSpan.a(new VideoFeedsHelper.20(paramTextView, localRichTitleInfo, paramVideoInfo));
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRichTitleInfo.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" ");
        localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
        ((SpannableStringBuilder)localObject).setSpan(localClickableColorSpan, 0, ((SpannableStringBuilder)localObject).length(), 33);
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramTextView.append((CharSequence)localObject);
      }
      if (localRichTitleInfo.jdField_a_of_type_JavaLangString != null) {
        paramTextView.append(localRichTitleInfo.jdField_a_of_type_JavaLangString);
      }
      i -= 1;
      continue;
      paramTextView.setMovementMethod(null);
      paramTextView.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
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
    VideoReport.setElementParams(paramObject, new RIJDtParamBuilder().a(paramVideoInfo).c(paramString1).d(paramString2).a());
  }
  
  public static void a(Runnable paramRunnable)
  {
    ThreadUtil.a(paramRunnable);
  }
  
  public static void a(String paramString)
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
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "#00a5e0";
      }
      paramTextView.setText(paramString1);
      int i = Color.parseColor(str);
      paramString1 = new GradientDrawable();
      paramString1.setColor(i);
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
    ReadInJoyHelper.v(paramAppRuntime, paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if (ReadInJoyAtlasManager.checkIsLocalFirstDoFavorite(paramActivity, true)) {
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131718103), paramActivity.getString(2131718102), 2131690728, 2131718101, new VideoFeedsHelper.17(), null).setMessageCount(null).show();
    }
  }
  
  public static boolean a()
  {
    return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = b(paramActivity);
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
      int i = paramAbsBaseArticleInfo.uint32_jump_type.get();
      if (i == 1)
      {
        if (RIJPBFieldUtils.a(paramAbsBaseArticleInfo.bytes_jump_url))
        {
          ReadInJoyUtils.a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_url));
          return true;
        }
      }
      else if ((i == 2) && (RIJPBFieldUtils.a(paramAbsBaseArticleInfo.bytes_jump_bundle)) && (PackageUtil.a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_bundle))))
      {
        a(paramActivity, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_jump_schema));
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isSystemAutoRotateOpen: value=");
        paramContext.append(i);
        QLog.d("VideoFeedsHelper", 2, paramContext.toString());
      }
      if (i == 1) {
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
    if ((paramVideoInfo.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(paramVideoInfo.j)) && (paramBaseQQAppInterface != null))
    {
      if (paramVideoInfo.j.equals(paramBaseQQAppInterface.getCurrentUin())) {
        return true;
      }
      if (((FriendsManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramVideoInfo.j)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    String str = ProteusSupportUtil.a(paramAbsBaseArticleInfo);
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
  
  public static byte[] a(VideoInfo paramVideoInfo)
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
  
  public static int[] a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    return new int[] { Math.min(paramActivity.getWidth(), paramActivity.getHeight()), Math.max(paramActivity.getWidth(), paramActivity.getHeight()) };
  }
  
  protected static int[] a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return new int[] { paramInt1, paramInt2 };
    }
    if (jdField_a_of_type_Boolean) {
      return new int[] { paramInt1 - jdField_a_of_type_Int, paramInt2 - jdField_b_of_type_Int };
    }
    Object localObject = b(paramActivity);
    int i = localObject[0];
    int j = localObject[1];
    paramActivity = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
    localObject = new Point();
    paramActivity.getSize((Point)localObject);
    int k = ((Point)localObject).x;
    int m = ((Point)localObject).y;
    jdField_a_of_type_Int = k - i;
    jdField_b_of_type_Int = m - j;
    jdField_a_of_type_Boolean = true;
    return new int[] { paramInt1 - jdField_a_of_type_Int, paramInt2 - jdField_b_of_type_Int };
  }
  
  public static int[] a(Activity paramActivity, VideoInfo paramVideoInfo, boolean paramBoolean, int paramInt)
  {
    paramInt = paramVideoInfo.a(paramActivity, paramInt);
    int k = ViewUtils.a(50.0F);
    int i = -1;
    int j;
    if (paramInt != 0)
    {
      if (paramInt == 2)
      {
        j = AIOUtils.b(10.0F, paramActivity.getResources());
        paramInt = k;
        i = j;
        if (!LiuHaiUtils.b()) {
          break label281;
        }
        paramInt = k + LiuHaiUtils.b(paramActivity);
        i = j;
        break label281;
      }
    }
    else if (!paramBoolean)
    {
      paramInt = paramVideoInfo.b(paramActivity);
      int m = b(paramActivity)[1];
      if (m >= paramInt)
      {
        j = AIOUtils.b(10.0F, paramActivity.getResources());
        if (paramVideoInfo.a(paramActivity))
        {
          m = (m - paramInt) / 2;
          paramInt = k;
          i = j;
          if (m <= k) {
            break label281;
          }
          paramInt = AIOUtils.b(32.0F, paramActivity.getResources());
          i = m;
        }
        else
        {
          i = (m - paramInt) / 2;
          paramInt = AIOUtils.b(10.0F, paramActivity.getResources());
        }
        paramInt = i + paramInt;
        i = j;
        break label281;
      }
    }
    else
    {
      if (paramVideoInfo.b() != 0) {
        break label197;
      }
    }
    paramInt = -1;
    break label281;
    label197:
    paramInt = b(paramActivity)[1];
    i = b(paramActivity)[0];
    i = (int)(paramVideoInfo.a() / paramVideoInfo.b() * i);
    if (i <= paramInt) {
      i = (paramInt - i) / 2 + AIOUtils.b(16.0F, paramActivity.getResources());
    } else {
      i = AIOUtils.b(16.0F, paramActivity.getResources());
    }
    paramInt = AIOUtils.b(16.0F, paramActivity.getResources());
    label281:
    return new int[] { paramInt, i };
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
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localDisplay2.getRealSize(paramContext);
      i = paramContext.x;
      paramInt = paramContext.y;
    }
    else if (Build.VERSION.SDK_INT >= 15)
    {
      localDisplay2.getSize(paramContext);
      i = paramContext.x;
      paramInt = paramContext.y;
    }
    else
    {
      paramContext = new DisplayMetrics();
      localDisplay2.getMetrics(paramContext);
      i = paramContext.widthPixels;
      paramInt = paramContext.heightPixels;
    }
    return new int[] { i, paramInt };
  }
  
  public static Integer[] a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    if (j == 0) {
      return new Integer[0];
    }
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    while (i < paramArrayOfInt.length)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  public static Object[] a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramActivity = b(paramActivity);
    int j = paramActivity[0];
    Boolean localBoolean = Boolean.valueOf(true);
    int i = paramActivity[1];
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      boolean bool;
      if (paramInt1 < paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      i -= 2;
      paramInt2 = (int)(paramInt2 / paramInt1 * j);
      paramInt1 = paramInt2;
      if (paramInt2 > i) {
        paramInt1 = i;
      }
      return new Object[] { localBoolean, Integer.valueOf(i), Integer.valueOf(paramInt1), Boolean.valueOf(bool) };
    }
    return new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i), localBoolean };
  }
  
  public static int b()
  {
    if (ReadInJoyHelper.b()) {
      return 0;
    }
    return 3;
  }
  
  public static int b(Activity paramActivity)
  {
    return (int)(b(paramActivity)[0] * 9.0F / 16.0F);
  }
  
  private static int b(AppRuntime paramAppRuntime)
  {
    return ReadInJoyHelper.w(paramAppRuntime);
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
  
  public static String b(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsUtil.b(paramInt));
    localStringBuilder.append(HardCodeUtil.a(2131715954));
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
    if (jdField_a_of_type_JavaTextDecimalFormat == null) {
      jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("##0.0");
    }
    Object localObject2 = jdField_a_of_type_JavaTextDecimalFormat.format((float)paramLong / 1048576.0F);
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith(".0"))
    {
      int i = ((String)localObject2).indexOf(".0");
      localObject1 = localObject2;
      if (i > 0) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("M");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(7942);
  }
  
  public static void b(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    if (i >= 0)
    {
      if (j > paramString1.length()) {
        return;
      }
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new VideoFeedsHelper.13(paramTextView), i, j, 33);
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
    a(paramView, paramInt, 300);
  }
  
  public static void b(TextView paramTextView, int paramInt, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setTag(50331903, Integer.valueOf(paramInt));
    ThreadManager.excute(new VideoFeedsHelper.10(paramInt, paramString, paramTextView), 16, null, true);
  }
  
  private static void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
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
    l = -1L;
    if ((paramBoolean1) && (l != -1L))
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(l, true);
      ThreadManager.post(new VideoFeedsHelper.16(l), 8, null, true);
    }
  }
  
  public static final boolean b()
  {
    return Aladdin.getConfig(364).getIntegerFromString("is_interrupt", 1) == 1;
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool3 = "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      int i = a("ro.miui.notch", 0);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("isXiaomiWithNotch() getSystemPropertyForXiaomi=");
        paramContext.append(i);
        QLog.d("VideoFeedsHelper", 2, paramContext.toString());
      }
      bool1 = bool2;
      if (i == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @TargetApi(17)
  public static int[] b(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getScreenSize() ERROR activity == null");
      }
      return new int[] { 0, 0 };
    }
    int[] arrayOfInt = a(paramActivity);
    if ((arrayOfInt[0] != 0) && (arrayOfInt[1] != 0))
    {
      jdField_c_of_type_Int = arrayOfInt[0];
      jdField_d_of_type_Int = arrayOfInt[1];
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
    jdField_c_of_type_Int = arrayOfInt[0];
    jdField_d_of_type_Int = arrayOfInt[1];
    int m = jdField_c_of_type_Int;
    int k = jdField_d_of_type_Int;
    int i;
    int j;
    if ((a()) && (c(paramActivity)))
    {
      paramActivity = b(paramActivity);
      i = k;
      if (paramActivity == null) {
        break label242;
      }
      i = k;
      if (paramActivity.length < 2) {
        break label242;
      }
      i = k;
      if (paramActivity[0] <= 0) {
        break label242;
      }
      i = k;
      if (paramActivity[1] <= 0) {
        break label242;
      }
      i = jdField_d_of_type_Int;
      j = paramActivity[1];
    }
    else
    {
      i = k;
      if (!b(paramActivity)) {
        break label242;
      }
      j = a(paramActivity);
      i = k;
      if (j <= 0) {
        break label242;
      }
      i = jdField_d_of_type_Int;
    }
    i -= j;
    label242:
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("getScreenSize() screenWidth=");
      paramActivity.append(jdField_c_of_type_Int);
      paramActivity.append(", screenHeight=");
      paramActivity.append(jdField_d_of_type_Int);
      paramActivity.append(", width=");
      paramActivity.append(m);
      paramActivity.append(", height=");
      paramActivity.append(i);
      QLog.d("VideoFeedsHelper", 2, paramActivity.toString());
    }
    return new int[] { m, i };
  }
  
  /* Error */
  private static int[] b(Context paramContext)
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
    //   15: invokevirtual 1978	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnull +50 -> 70
    //   23: aload_0
    //   24: ldc_w 1980
    //   27: invokevirtual 1985	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +38 -> 70
    //   35: aload_0
    //   36: ldc_w 1987
    //   39: iconst_0
    //   40: anewarray 144	java/lang/Class
    //   43: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +22 -> 70
    //   51: aload_2
    //   52: aload_0
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokevirtual 172	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 1989	[I
    //   63: checkcast 1989	[I
    //   66: astore_0
    //   67: goto +5 -> 72
    //   70: aload_1
    //   71: astore_0
    //   72: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +35 -> 110
    //   78: new 121	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc_w 1991
    //   90: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: aload_0
    //   96: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 134
    //   102: iconst_2
    //   103: aload_1
    //   104: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_0
    //   111: areturn
    //   112: goto +85 -> 197
    //   115: astore_0
    //   116: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +38 -> 157
    //   122: new 121	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   129: astore_2
    //   130: aload_2
    //   131: ldc_w 1993
    //   134: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_2
    //   139: aload_0
    //   140: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 134
    //   149: iconst_2
    //   150: aload_2
    //   151: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +35 -> 195
    //   163: new 121	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   170: astore_0
    //   171: aload_0
    //   172: ldc_w 1991
    //   175: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: ldc 134
    //   187: iconst_2
    //   188: aload_0
    //   189: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: aload_1
    //   196: areturn
    //   197: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +35 -> 235
    //   203: new 121	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   210: astore_0
    //   211: aload_0
    //   212: ldc_w 1991
    //   215: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 1092	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: ldc 134
    //   227: iconst_2
    //   228: aload_0
    //   229: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public static int c()
  {
    if (ReadInJoyHelper.b()) {
      return 22;
    }
    return 32;
  }
  
  public static int c(Activity paramActivity)
  {
    int i = b(paramActivity)[0];
    return b(paramActivity)[1] - b(paramActivity);
  }
  
  public static String c(int paramInt)
  {
    return VideoFeedsUtil.a(paramInt);
  }
  
  public static String c(long paramLong)
  {
    if (paramLong <= 0L) {
      return HardCodeUtil.a(2131715973);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramLong));
    localStringBuilder.append(HardCodeUtil.a(2131715969));
    return localStringBuilder.toString();
  }
  
  public static void c(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(6914);
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT <= 21) {}
    while ((Build.VERSION.SDK_INT > 21) && (Build.VERSION.SDK_INT <= 23) && (DeviceInfoUtil.a() <= -2147483648L)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 1978	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   6: astore_0
    //   7: iload_2
    //   8: istore_1
    //   9: aload_0
    //   10: ifnull +61 -> 71
    //   13: iload_2
    //   14: istore_1
    //   15: getstatic 1817	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 23
    //   20: if_icmplt +51 -> 71
    //   23: aload_0
    //   24: ldc_w 1980
    //   27: invokevirtual 1985	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   30: astore_0
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: ifnull +37 -> 71
    //   37: aload_0
    //   38: ldc_w 2007
    //   41: iconst_0
    //   42: anewarray 144	java/lang/Class
    //   45: invokevirtual 162	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   48: astore_3
    //   49: iload_2
    //   50: istore_1
    //   51: aload_3
    //   52: ifnull +19 -> 71
    //   55: aload_3
    //   56: aload_0
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokevirtual 172	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 1845	java/lang/Boolean
    //   67: invokevirtual 2010	java/lang/Boolean:booleanValue	()Z
    //   70: istore_1
    //   71: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +35 -> 109
    //   77: new 121	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   84: astore_0
    //   85: aload_0
    //   86: ldc_w 2012
    //   89: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: iload_1
    //   95: invokevirtual 1719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: ldc 134
    //   101: iconst_2
    //   102: aload_0
    //   103: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: iload_1
    //   110: ireturn
    //   111: goto +85 -> 196
    //   114: astore_0
    //   115: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +38 -> 156
    //   121: new 121	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   128: astore_3
    //   129: aload_3
    //   130: ldc_w 2014
    //   133: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_3
    //   138: aload_0
    //   139: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 134
    //   148: iconst_2
    //   149: aload_3
    //   150: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +35 -> 194
    //   162: new 121	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   169: astore_0
    //   170: aload_0
    //   171: ldc_w 2012
    //   174: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_0
    //   179: iconst_0
    //   180: invokevirtual 1719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 134
    //   186: iconst_2
    //   187: aload_0
    //   188: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +35 -> 234
    //   202: new 121	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   209: astore_0
    //   210: aload_0
    //   211: ldc_w 2012
    //   214: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_0
    //   219: iconst_0
    //   220: invokevirtual 1719	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: ldc 134
    //   226: iconst_2
    //   227: aload_0
    //   228: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public static int d()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    int i;
    if (localAladdinConfig != null)
    {
      int j = localAladdinConfig.getIntegerFromString("ks_column_card_video_autoplay", 0);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getKSColumnCardAutoPlayConfig(), value = ", Integer.valueOf(j) });
        return j;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static String d(int paramInt)
  {
    return e(paramInt);
  }
  
  public static boolean d()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(153);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("readinjoy_videochannel_jump_multivideo_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isVideoChannelClickJumpToMultiVideo(), value = ", Integer.valueOf(i) });
      }
      bool1 = bool2;
      if (i == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(300);
    int i;
    if (localAladdinConfig != null)
    {
      int j = localAladdinConfig.getIntegerFromString("king_card_support", 2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getMainFeedsKingCardAutoPlayConfig(), value = ", Integer.valueOf(j) });
        return j;
      }
    }
    else
    {
      i = 0;
    }
    return i;
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
      if (jdField_c_of_type_JavaTextDecimalFormat == null) {
        jdField_c_of_type_JavaTextDecimalFormat = new DecimalFormat("##");
      }
      localObject = new StringBuilder();
      localDecimalFormat = jdField_c_of_type_JavaTextDecimalFormat;
      d1 = paramInt;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(localDecimalFormat.format(d1 / 10000.0D));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715921));
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt >= 10000)
    {
      if (jdField_b_of_type_JavaTextDecimalFormat == null) {
        jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("##.#");
      }
      localObject = new StringBuilder();
      localDecimalFormat = jdField_b_of_type_JavaTextDecimalFormat;
      d1 = paramInt;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(localDecimalFormat.format(d1 / 10000.0D));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131715901));
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
  
  public static boolean e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(169);
    boolean bool = true;
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("kandian_video_logo_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isShowKandianVideoLogoEnable(), value = ", Integer.valueOf(i) });
      }
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static int f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    int i;
    if (localAladdinConfig != null)
    {
      int j = localAladdinConfig.getIntegerFromString("big_img_video_autoplay", 0);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoCardAutoPlayConfig(), value = ", Integer.valueOf(j) });
        return j;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static boolean f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(180);
    boolean bool = true;
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("VideoEntranceJumpAppSwitch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isVideoEntranceJumpAppEnable(), value = ", Integer.valueOf(i) });
      }
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static int g()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    int i;
    if (localAladdinConfig != null)
    {
      int j = localAladdinConfig.getIntegerFromString("big_img_video_click_show_layer", 0);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoClickShowLayer(), value = ", Integer.valueOf(j) });
        return j;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static boolean g()
  {
    return Aladdin.getConfig(376).getIntegerFromString("slide_into_home_page_enable", 1) == 1;
  }
  
  public static int h()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(239);
    int i;
    if (localAladdinConfig != null)
    {
      int j = localAladdinConfig.getIntegerFromString("big_img_video_column_autoplay", 0);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoColumnCardAutoPlayConfig(), value = ", Integer.valueOf(j) });
        return j;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static int i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(239);
    int i;
    if (localAladdinConfig != null)
    {
      int j = localAladdinConfig.getIntegerFromString("big_img_video_column_click_show_layer", 0);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoColumnClickShowLayer(), value = ", Integer.valueOf(j) });
        return j;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public static int j()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(180);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("VideoEntranceJumpMaxDisplayCountOneDay", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getVideoEntranceJumpAppMaxDisplayCountOneDay(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper
 * JD-Core Version:    0.7.0.1
 */