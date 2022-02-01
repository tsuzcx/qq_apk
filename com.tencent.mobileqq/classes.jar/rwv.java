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
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.RichTitleInfo;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.10;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.11;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.16;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.26;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.27;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.7;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class rwv
{
  private static int jdField_a_of_type_Int;
  public static Dialog a;
  static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static DecimalFormat jdField_a_of_type_JavaTextDecimalFormat;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static DecimalFormat jdField_b_of_type_JavaTextDecimalFormat;
  private static int jdField_c_of_type_Int;
  private static DecimalFormat jdField_c_of_type_JavaTextDecimalFormat;
  private static int jdField_d_of_type_Int;
  private static DecimalFormat jdField_d_of_type_JavaTextDecimalFormat;
  
  public static int a()
  {
    if (bkwm.d()) {}
    for (int i = 6;; i = 3) {
      return ViewUtils.dip2px(i);
    }
  }
  
  public static int a(Activity paramActivity)
  {
    int j = 0;
    boolean bool = bkwm.d();
    int[] arrayOfInt = b(paramActivity);
    int i;
    if ((bool) && (arrayOfInt[1] / arrayOfInt[0] >= 1.97D)) {
      i = ViewUtils.dip2px(54.0F);
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (bool);
        i = j;
      } while (!a(paramActivity));
      i = j;
    } while (Aladdin.getConfig(324).getIntegerFromString("videodetail_videogravity_style", 0) != 1);
    return ViewUtils.dip2px(60.0F);
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
    int m = arrayOfInt[1];
    int j = paramVideoInfo.b();
    int k = paramVideoInfo.c();
    if ((paramActivity == null) || (i == 0) || (m == 0)) {}
    for (;;)
    {
      return 0;
      float f = m / i;
      if ((paramVideoInfo.b(paramActivity)) && (j > 0) && (k > 0))
      {
        paramInt = m - paramInt;
        m = (int)(j / k * paramInt);
        i = (int)(k / j * i);
        if (f < 1.97D) {}
        for (f = 0.95F; i >= f * paramInt; f = 0.85F) {
          return 2;
        }
      }
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getNotchSizeInXiaomi() Exception=" + paramContext.getMessage());
      }
    }
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      i = paramInt;
      if (localObject != null)
      {
        localObject = ((Class)localObject).getMethod("getInt", new Class[] { String.class, Integer.TYPE });
        i = paramInt;
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(null, new Object[] { paramString, Integer.valueOf(paramInt) });
          i = paramInt;
          if ((paramString instanceof Integer)) {
            i = ((Integer)paramString).intValue();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      do
      {
        int i = paramInt;
      } while (!QLog.isColorLevel());
      QLog.d("VideoFeedsHelper", 2, "getSystemPropertyForXiaomi() Exception=" + paramString.getMessage());
    }
    return i;
    return paramInt;
  }
  
  public static int a(AppRuntime paramAppRuntime)
  {
    if (bkwm.b(paramAppRuntime, "VIDEO_FEEDS_SOFT_AD_LOCAL_CONFIG_DATE")) {
      return b(paramAppRuntime);
    }
    return 0;
  }
  
  @Nullable
  public static Animator a(View paramView, int paramInt)
  {
    if (((paramView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (paramView.getTag(2131362701) == null))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int i = localMarginLayoutParams.height;
      localMarginLayoutParams.bottomMargin -= i;
      int j = localMarginLayoutParams.bottomMargin;
      paramView.setLayoutParams(localMarginLayoutParams);
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });
      localValueAnimator.addUpdateListener(new rxb(i, localMarginLayoutParams, j, paramView));
      localValueAnimator.addListener(new rxc(paramView));
      paramView.setTag(2131362701, localValueAnimator);
      localValueAnimator.setDuration(paramInt);
      localValueAnimator.start();
      paramView.setAlpha(0.0F);
      paramView.animate().alpha(1.0F).setDuration(paramInt).start();
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
    float f1 = n * paramView.getScaleX() / paramView.getWidth();
    float f2 = i2 * paramView.getScaleX() / paramView.getWidth();
    float f3 = i1 * paramView.getScaleY() / paramView.getHeight();
    float f4 = i3 * paramView.getScaleY() / paramView.getHeight();
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
    ObjectAnimator localObjectAnimator1 = null;
    ObjectAnimator localObjectAnimator2 = null;
    if (paramView.getVisibility() == paramInt1) {
      return localObjectAnimator2;
    }
    if (!VersionUtils.isHoneycomb())
    {
      a(paramView, paramInt1, paramInt2);
      return null;
    }
    if (paramInt1 == 0)
    {
      paramView.setVisibility(0);
      localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(paramInt2);
      localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
      localObjectAnimator1.setRepeatCount(0);
      localObjectAnimator1.start();
      paramView.setLayerType(2, null);
      localObjectAnimator1.addListener(new rxg(paramView));
      localObjectAnimator1.start();
    }
    for (;;)
    {
      localObjectAnimator2 = localObjectAnimator1;
      if (!paramBoolean) {
        break;
      }
      paramView.setTag(2131375879, localObjectAnimator1);
      return localObjectAnimator1;
      if ((paramInt1 == 8) || (paramInt1 == 4))
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
        localObjectAnimator1.setDuration(paramInt2);
        localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
        localObjectAnimator1.setRepeatCount(0);
        localObjectAnimator1.start();
        paramView.setLayerType(2, null);
        localObjectAnimator1.addListener(new rxh(paramView));
        localObjectAnimator1.start();
      }
    }
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
    int i = paramVideoInfo.a(paramActivity, paramInt);
    int k = paramVideoInfo.b();
    int m = paramVideoInfo.c();
    paramActivity = b(paramActivity);
    int j;
    switch (i)
    {
    default: 
      j = paramActivity[0];
      i = (int)(m / k * j);
    }
    for (paramInt = (paramActivity[1] - i) / 2;; paramInt = 0)
    {
      k = (paramActivity[0] - j) / 2;
      return new Rect(k, paramInt, j + k, i + paramInt);
      i = paramActivity[1] - paramInt;
      j = (int)(k / m * i);
    }
  }
  
  private static Drawable a(Context paramContext)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(3.0F, paramContext.getResources()));
    localGradientDrawable.setColor(-1728053248);
    localGradientDrawable.setStroke(1, 0);
    return localGradientDrawable;
  }
  
  public static Pair<Integer, Integer> a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)a(paramActivity, paramInt1, paramInt2)[2]).intValue();
    return new Pair(Integer.valueOf(b(paramActivity)[0]), Integer.valueOf(paramInt1));
  }
  
  public static VideoInfo a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("VIDEO_VID");
    String str1 = paramBundle.getString("VIDEO_WIDTH");
    String str2 = paramBundle.getString("VIDEO_HEIGHT");
    String str3 = paramBundle.getString("VIDEO_TIME");
    if (str1 != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf(str1).intValue();
        localVideoInfo.jdField_b_of_type_Int = i;
        if (str2 == null) {
          continue;
        }
        i = Integer.valueOf(str2).intValue();
        localVideoInfo.jdField_c_of_type_Int = i;
        if (str3 == null) {
          continue;
        }
        i = Integer.valueOf(str3).intValue();
        localVideoInfo.jdField_d_of_type_Int = i;
      }
      catch (Exception localException)
      {
        int i;
        VideoFeedsPlayActivity.a("finishActivityWithResult() e=" + localException.getMessage());
        continue;
        boolean bool = false;
        continue;
      }
      localVideoInfo.jdField_f_of_type_JavaLangString = paramBundle.getString("VIDEO_H5_URL");
      localVideoInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("VIDEO_COVER");
      localVideoInfo.j = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      localVideoInfo.jdField_d_of_type_JavaLangString = paramBundle.getString("VIDEO_SUMMARY");
      localVideoInfo.jdField_c_of_type_JavaLangString = paramBundle.getString("VIDEO_TITLE");
      localVideoInfo.e = paramBundle.getString("VIDEO_CREATE_TIME");
      localVideoInfo.jdField_g_of_type_JavaLangString = paramBundle.getString("VIDEO_ARTICLE_ID");
      localVideoInfo.p = paramBundle.getString("VIDEO_THIRD_ICON");
      localVideoInfo.k = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
      str1 = paramBundle.getString("VIDEO_THIRD_NAME");
      if (!TextUtils.isEmpty(str1)) {
        localVideoInfo.k = str1;
      }
      localVideoInfo.o = paramBundle.getString("VIDEO_THIRD_ACTION");
      localVideoInfo.jdField_a_of_type_Int = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
      localVideoInfo.jdField_r_of_type_JavaLangString = paramBundle.getString("VIDEO_URL");
      localVideoInfo.jdField_d_of_type_Long = paramBundle.getLong("VIDEO_FEED_ID");
      localVideoInfo.jdField_h_of_type_Int = paramBundle.getInt("VIDEO_FEED_TYPE");
      localVideoInfo.i = paramBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramBundle.getParcelable("VIDEO_ARTICLE_INFO_FOR_BIU"));
      localVideoInfo.jdField_b_of_type_Long = paramBundle.getLong("VIDEO_XG_FILE_SIZE", 0L);
      localVideoInfo.q = paramBundle.getInt("VIDEO_STRATEGY_ID", 0);
      localVideoInfo.jdField_f_of_type_Long = paramBundle.getLong("VIDEO_ALGORITHM_ID", 0L);
      localVideoInfo.w = paramBundle.getString("VIDEO_SUBS_TEXT");
      localVideoInfo.x = paramBundle.getString("VIDEO_SUBS_COLOR");
      localVideoInfo.jdField_h_of_type_JavaLangString = paramBundle.getString("VIDEO_RECOMMEND_REASON");
      if (localVideoInfo.jdField_a_of_type_Int != 6) {
        continue;
      }
      bool = true;
      localVideoInfo.jdField_b_of_type_Boolean = bool;
      localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = ((VideoColumnInfo)paramBundle.getParcelable("VIDEO_COLUMN_INFO"));
      localVideoInfo.l = paramBundle.getString("KEY_VIDEO_JSON_LIST");
      localVideoInfo.jdField_r_of_type_Int = paramBundle.getInt("VIDEO_PLAY_COUNT");
      localVideoInfo.jdField_g_of_type_Int = paramBundle.getInt("VIDEO_COLUMN_ID");
      return localVideoInfo;
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static Long a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.busiType == 1)
    {
      if (TextUtils.isEmpty(paramBaseArticleInfo.mSubscribeID)) {}
      for (long l = 0L;; l = Long.valueOf(paramBaseArticleInfo.mSubscribeID).longValue()) {
        return Long.valueOf(l);
      }
    }
    if (paramBaseArticleInfo.busiType == 6)
    {
      if (pgb.g(paramBaseArticleInfo)) {
        return Long.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long);
      }
      return Long.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long);
    }
    return Long.valueOf(paramBaseArticleInfo.thirdUin);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    return f(paramInt) + amtj.a(2131715172);
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramInt > 0) {
      str = paramString + d(paramInt);
    }
    return str;
  }
  
  public static String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 1000L / 60L), Long.valueOf(paramLong / 1000L % 60L) });
  }
  
  public static String a(View paramView)
  {
    if (paramView.getId() == -1) {
      return "no-id";
    }
    return paramView.getResources().getResourceName(paramView.getId());
  }
  
  public static String a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return "";
    }
    if (paramBoolean1) {}
    for (String str = paa.jdField_g_of_type_JavaLangString;; str = paa.k)
    {
      if (paramBoolean2) {
        str = "https://viola.qq.com/js/profile.js?_rij_violaUrl=1&v_bid=3740&v_tid=6&v_bundleName=profile&hideNav=1&v_nav_immer=1&accountId=";
      }
      return str + bfuc.encodeToString(String.valueOf(paramVideoInfo.j).getBytes(), 2) + "&rowkey=" + paramVideoInfo.jdField_g_of_type_JavaLangString + "&last_scene_type=3";
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.busiType == 1) || (paramBaseArticleInfo.busiType == 6)) {
      return paramBaseArticleInfo.getSubscribeName();
    }
    return paramBaseArticleInfo.thirdUinName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return MD5Utils.toMD5(paramQQAppInterface.getCurrentAccountUin() + "_" + paramString + "_" + System.currentTimeMillis());
  }
  
  public static StringBuilder a(long paramLong)
  {
    if (paramLong >= 2147483647L) {
      return null;
    }
    long l2 = paramLong / 1000L / 3600L;
    long l1 = paramLong / 1000L / 60L;
    long l3 = paramLong / 1000L % 60L;
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong = l1;
    if (l2 > 0L)
    {
      paramLong = l1 - l2 * 60L;
      if (l2 < 10L)
      {
        localStringBuilder.append("0").append(l2);
        localStringBuilder.append(":");
      }
    }
    else
    {
      if (paramLong >= 10L) {
        break label168;
      }
      localStringBuilder.append("0").append(paramLong);
    }
    for (;;)
    {
      localStringBuilder.append(":");
      if (l3 >= 10L) {
        break label178;
      }
      localStringBuilder.append("0").append(l3);
      return localStringBuilder;
      localStringBuilder.append(l2);
      break;
      label168:
      localStringBuilder.append(paramLong);
    }
    label178:
    localStringBuilder.append(l3);
    return localStringBuilder;
  }
  
  private static Set<String> a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(314);
    HashSet localHashSet = new HashSet();
    if (localAladdinConfig != null) {
      Collections.addAll(localHashSet, localAladdinConfig.getString("video_localdns_black_domain_list", "").split("|"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "getVideoLocalDnsBlackDomainList(), result = " + localHashSet);
    }
    return localHashSet;
  }
  
  public static JSONObject a(String paramString, List<scy> paramList, Bundle paramBundle)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          scy localscy = (scy)paramList.next();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("rowKey", localscy.jdField_a_of_type_Rsd.a());
          localJSONObject2.put("playCount", localscy.jdField_a_of_type_Int);
          localJSONArray.put(localJSONObject2);
        }
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
    }
    catch (Exception paramString)
    {
      QLog.e("VideoFeedsHelper", 1, "[generateReqRangeJson error]: " + paramString.getMessage());
      return new JSONObject();
    }
    localJSONObject1.put("first_rowKey", paramString);
    if (paramBundle != null) {
      localJSONObject1.put("video_column_cookie", paramBundle.getString("video_column_topic_cookie"));
    }
    return localJSONObject1;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(7942);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    long l2 = 0L;
    boolean bool2 = false;
    int j = 0;
    Object localObject2 = null;
    boolean bool1 = bool2;
    long l1 = l2;
    int i = j;
    Object localObject1 = localObject2;
    if (paramBaseArticleInfo.busiType == 6)
    {
      bool1 = bool2;
      l1 = l2;
      i = j;
      localObject1 = localObject2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        l1 = l2;
        i = j;
        localObject1 = localObject2;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep != null)
        {
          bool1 = bool2;
          l1 = l2;
          i = j;
          localObject1 = localObject2;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null)
          {
            bool1 = bool2;
            l1 = l2;
            i = j;
            localObject1 = localObject2;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b != null)
            {
              bool1 = bool2;
              l1 = l2;
              i = j;
              localObject1 = localObject2;
              if (!paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.isEmpty())
              {
                bool1 = true;
                l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.a.longValue();
                i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.b.intValue();
                localObject1 = ((rfl)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.get(0)).jdField_b_of_type_JavaLangString;
              }
            }
          }
        }
      }
    }
    a(paramActivity, paramBundle, paramInt, paramBaseArticleInfo.innerUniqueID, paramBaseArticleInfo.busiType, paramBaseArticleInfo.getVideoVid(), paramBaseArticleInfo.getVideoWidth(), paramBaseArticleInfo.getVideoHeight(), paramBaseArticleInfo.getVideoDuration(), paramBaseArticleInfo.mTitle, paramBaseArticleInfo.getVideoCoverURL().getPath(), paramBaseArticleInfo.mArticleContentUrl, paramBaseArticleInfo.thirdUinName, paramBaseArticleInfo.thirdUin, paramBaseArticleInfo.mXGFileSize, bool1, l1, i, (String)localObject1, null, null, null, null);
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
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt6, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("VIDEO_FROM_TYPE", paramInt1);
    localBundle.putString("VIDEO_VID", paramString2);
    localBundle.putString("VIDEO_ARTICLE_ID", paramString1);
    localBundle.putString("VIDEO_TITLE", paramString3);
    localBundle.putString("VIDEO_COVER", paramString4);
    localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramInt2);
    localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramString7);
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramString6);
    localBundle.putString("VIDEO_WIDTH", String.valueOf(paramInt3));
    localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramInt4));
    localBundle.putString("VIDEO_TIME", String.valueOf(paramInt5));
    localBundle.putLong("VIDEO_XG_FILE_SIZE", paramLong1);
    localBundle.putBoolean("VIDEO_IS_UGC", paramBoolean);
    localBundle.putLong("VIDEO_FEED_ID", paramLong2);
    localBundle.putInt("VIDEO_FEED_TYPE", paramInt6);
    localBundle.putString("VIDEO_URL", paramString8);
    localBundle.putString("VIDEO_H5_URL", paramString5);
    localBundle.putString("VIDEO_SUMMARY", paramString9);
    localBundle.putString("VIDEO_THIRD_ACTION", paramString10);
    localBundle.putString("VIDEO_THIRD_ICON", paramString11);
    localBundle.putString("VIDEO_CREATE_TIME", paramString12);
    a(paramContext, localBundle, false, paramInt1);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("VIDEO_FROM_TYPE", paramInt);
    int i;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      localBundle.putInt("KEY_LOAD_DELEGATE_TYPE", i);
      boolean bool = localBundle.getBoolean("FLAG_ACTIVITY_NEW_TASK");
      if ((paramBoolean) || (paramInt == 11)) {}
      try
      {
        paramBoolean = pcv.a(localBundle.getInt("VIDEO_FROM_TYPE", -1));
        for (;;)
        {
          if (!paramBoolean) {
            break label247;
          }
          paramBundle = new Intent();
          paramBundle.putExtras(localBundle);
          if (bool) {
            paramBundle.addFlags(268435456);
          }
          sgi.a(paramContext, paramBundle);
          if ((paramContext instanceof Activity)) {
            ((Activity)paramContext).overridePendingTransition(2130772011, 0);
          }
          return;
          i = 0;
          break;
          paramBundle = (VideoInfo)localBundle.getParcelable("VIDEO_OBJ");
          if (paramBundle != null) {
            paramBoolean = pcv.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), paramBundle.jdField_b_of_type_Int, paramBundle.jdField_c_of_type_Int, paramBundle.jdField_d_of_type_Int);
          } else {
            paramBoolean = pcv.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue(), localBundle);
          }
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBoolean = false;
        }
        label247:
        paramBundle = new Intent(paramContext, VideoFeedsPlayActivity.class);
        if (!bool) {
          break label285;
        }
      }
    }
    paramBundle.addFlags(268435456);
    for (;;)
    {
      paramBundle.putExtras(localBundle);
      paramContext.startActivity(paramBundle);
      return;
      label285:
      paramBundle.addFlags(536870912);
    }
  }
  
  public static void a(Context paramContext, TextView paramTextView)
  {
    a(paramContext, paramTextView, amtj.a(2131715218), amtj.a(2131715223), bgoa.a("kandian"), null);
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    if ((i < 0) || (j > paramString1.length())) {
      return;
    }
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new rww(paramString3, paramContext, paramOnClickListener), i, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  public static void a(Context paramContext, UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramContext != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFeedsHelper", 2, "jumpInfo.clipboardInfo = " + paramUrlJumpInfo.jdField_d_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramUrlJumpInfo.jdField_d_of_type_JavaLangString)) {
        c(paramContext, paramUrlJumpInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramUrlJumpInfo.jdField_a_of_type_Int != 1) {
        break label120;
      }
      if (!TextUtils.isEmpty(paramUrlJumpInfo.jdField_a_of_type_JavaLangString)) {
        pay.a(paramContext, paramUrlJumpInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "resolveUrlJumpInfo: jumpInfo=" + paramUrlJumpInfo);
      }
      return;
      label120:
      if (paramUrlJumpInfo.jdField_a_of_type_Int == 2)
      {
        if (!okj.a(paramUrlJumpInfo.jdField_b_of_type_JavaLangString))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("VideoFeedsHelper", 2, "resolveUrlJumpInfo: checkAppPackage failure");
          return;
        }
        if (bfwv.a(paramContext, paramUrlJumpInfo.jdField_b_of_type_JavaLangString)) {
          a(paramContext, paramUrlJumpInfo.jdField_c_of_type_JavaLangString);
        } else if ((!Achilles.a(paramUrlJumpInfo.jdField_b_of_type_JavaLangString, true)) && (!TextUtils.isEmpty(paramUrlJumpInfo.jdField_a_of_type_JavaLangString))) {
          pay.a(paramContext, paramUrlJumpInfo.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.putExtra("big_brother_source_key", pay.f(0));
      localIntent.setData(Uri.parse(paramString));
    } while (!a(paramContext, localIntent));
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if ((jdField_a_of_type_AndroidAppDialog != null) && (jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      jdField_a_of_type_AndroidAppDialog.dismiss();
      jdField_a_of_type_AndroidAppDialog = null;
      label25:
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      TextView localTextView = new TextView(paramContext);
      localTextView.setText(paramString);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setGravity(17);
      localTextView.setBackgroundDrawable(a(paramContext));
      int i = AIOUtils.dp2px(16.0F, paramContext.getResources());
      localTextView.setPadding(i, 0, i, 0);
      paramString = new ReportDialog(paramContext, 2131755325);
      paramString.setContentView(localTextView, new ViewGroup.LayoutParams(-2, DisplayUtil.dip2px(paramContext, 40.0F)));
      paramString.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      paramString.setCanceledOnTouchOutside(false);
      paramContext = paramString.getWindow().getAttributes();
      paramContext.gravity = 49;
      paramContext.y = paramInt;
      paramString.getWindow().setFlags(16, 16);
      try
      {
        paramString.show();
        label187:
        jdField_a_of_type_AndroidAppDialog = paramString;
        jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsHelper.11(), 1000L);
        return;
      }
      catch (Exception paramContext)
      {
        break label187;
      }
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public static void a(View paramView)
  {
    paramView.clearAnimation();
    paramView = paramView.getTag(2131375879);
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
    if (paramView == null) {}
    do
    {
      int i;
      do
      {
        return;
        int j = paramView.getVisibility();
        i = j;
        if (paramView.getTag(-1) != null)
        {
          i = j;
          if (paramView.getAnimation() != null) {
            i = ((Integer)paramView.getTag(-1)).intValue();
          }
        }
        paramView.setTag(-1, Integer.valueOf(paramInt1));
      } while (i == paramInt1);
      if (paramInt1 == 0)
      {
        paramView.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(paramInt2);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setAnimationListener(new rxi(paramView));
        paramView.clearAnimation();
        paramView.startAnimation(localAlphaAnimation);
        return;
      }
    } while ((paramInt1 != 8) && (paramInt1 != 4));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt2);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new rxj(paramView));
    paramView.clearAnimation();
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (paramView.getVisibility() == paramInt2);
      if (!VersionUtils.isHoneycomb())
      {
        paramView.setVisibility(paramInt2);
        return;
      }
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
        localObjectAnimator2.addListener(new rxe(paramView));
        paramView = new AnimatorSet();
        paramView.setDuration(paramInt1 * 11 / 10);
        paramView.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
        paramView.setInterpolator(new DecelerateInterpolator());
        paramView.start();
        return;
      }
    } while ((paramInt2 != 8) && (paramInt2 != 4));
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramInt3 });
    localObjectAnimator1.setDuration(paramInt1);
    localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator1.setRepeatCount(0);
    paramView.setLayerType(2, null);
    localObjectAnimator1.addListener(new rxf(paramView));
    localObjectAnimator1.start();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    paramView.postDelayed(new VideoFeedsHelper.26(paramView, paramInt1, paramInt2, paramInt4), paramInt3);
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
    if (paramTextView != null) {
      paramTextView.setText(paramString2 + paramString1);
    }
  }
  
  public static void a(TextView paramTextView, long paramLong)
  {
    if (paramLong >= 2147483647L) {}
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramTextView == null);
        localStringBuilder1 = a(paramLong);
      } while (localStringBuilder1 == null);
      if (!(paramTextView.getTag() instanceof StringBuilder)) {
        break;
      }
      localStringBuilder2 = (StringBuilder)paramTextView.getTag();
    } while (localStringBuilder1.toString().equals(localStringBuilder2.toString()));
    paramTextView.setTag(localStringBuilder1);
    paramTextView.post(new VideoFeedsHelper.7(paramTextView, localStringBuilder1));
  }
  
  public static void a(TextView paramTextView, sdj paramsdj, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    bkwm.i(pay.a());
    if (paramTextView != null) {
      paramTextView.setVisibility(8);
    }
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        ArticleInfo localArticleInfo = new ArticleInfo();
        localArticleInfo.innerUniqueID = paramVideoInfo.jdField_g_of_type_JavaLangString;
        localArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localArticleInfo.mSubscribeName = paramVideoInfo.k;
        localArticleInfo.mSubscribeID = paramVideoInfo.j;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localArticleInfo.mVideoDuration = paramVideoInfo.jdField_d_of_type_Int;
        localArticleInfo.mVideoCoverUrl = paramVideoInfo.a();
        localArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localArticleInfo.mFeedType = paramVideoInfo.jdField_h_of_type_Int;
        localArticleInfo.mFeedId = paramVideoInfo.jdField_d_of_type_Long;
        localArticleInfo.mAlgorithmID = paramVideoInfo.jdField_f_of_type_Long;
        localArticleInfo.mArticleID = paramVideoInfo.jdField_c_of_type_Long;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj = new rfj();
          if (!TextUtils.isEmpty(paramVideoInfo.j)) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b = new ArrayList();
          rfl localrfl = new rfl();
          localrfl.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localrfl.e = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localrfl.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localrfl.jdField_a_of_type_Long = paramVideoInfo.jdField_d_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.b.add(localrfl);
        }
        paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      }
      if (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) {
        paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID = paramVideoInfo.jdField_g_of_type_JavaLangString;
      }
      return;
    }
    paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = new ArticleInfo();
  }
  
  public static void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    paramTextView.setText(null);
    Iterator localIterator;
    if ((paramVideoInfo.jdField_d_of_type_JavaUtilArrayList != null) && (paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.size() > 0)) {
      localIterator = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo.RichTitleInfo)localIterator.next();
      paramTextView.append(((VideoInfo.RichTitleInfo)localObject).jdField_a_of_type_JavaLangString);
      tah localtah = new tah(-12541697);
      localtah.a(new rxd(paramTextView, (VideoInfo.RichTitleInfo)localObject, paramVideoInfo));
      localObject = new SpannableStringBuilder(((VideoInfo.RichTitleInfo)localObject).jdField_c_of_type_JavaLangString + " ");
      ((SpannableStringBuilder)localObject).setSpan(localtah, 0, ((SpannableStringBuilder)localObject).length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.append((CharSequence)localObject);
      continue;
      paramTextView.setMovementMethod(null);
      paramTextView.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Intent paramIntent)
  {
    if ((paramBaseArticleInfo == null) || (!paramBaseArticleInfo.hasFirstFramePreload()) || (paramIntent == null)) {}
    do
    {
      return;
      paramIntent.putExtra("item_image_width", paramBaseArticleInfo.getFirstFrameWidth());
      paramIntent.putExtra("item_image_height", paramBaseArticleInfo.getFirstFrameHeight());
      paramBaseArticleInfo = paramBaseArticleInfo.getFirstFrameUrl();
    } while (paramBaseArticleInfo == null);
    paramIntent.putExtra("VIDEO_COVER", paramBaseArticleInfo.toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((oej)paramQQAppInterface.getBusinessHandler(155)).a(paramInt, paramBoolean, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    ForwardUtils.handleForwardData(paramQQAppInterface, null, paramQQAppInterface.getApplication().getApplicationContext(), localIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    pwu localpwu = pkm.a().a();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    rwz localrwz = new rwz(paramString1, paramBoolean1);
    if (paramBoolean1) {}
    for (int i = 2;; i = 1)
    {
      localpwu.a(paramQQAppInterface, paramString1, true, paramString2, localrwz, i, paramBoolean2);
      return;
    }
  }
  
  public static void a(Object paramObject, VideoInfo paramVideoInfo, String paramString)
  {
    a(paramObject, paramVideoInfo, paramString, "single");
  }
  
  public static void a(Object paramObject, VideoInfo paramVideoInfo, String paramString1, String paramString2)
  {
    VideoReport.setElementParams(paramObject, new pil().a(paramVideoInfo).c(paramString1).d(paramString2).a());
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "asyncHttpReport reportUrl = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new VideoFeedsHelper.27(paramString));
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
        oyw.a(paramTextView, paramString1);
        paramTextView.setVisibility(0);
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("VideoFeedsHelper", 2, "setTagTextview: ", paramString2);
          }
          oyw.a(paramTextView, paramString1);
        }
      }
    }
    paramTextView.setVisibility(8);
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    bkwm.w(paramAppRuntime, paramInt);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if (ptf.a(paramActivity, true)) {
      bfur.a(paramActivity, 230, paramActivity.getString(2131717580), paramActivity.getString(2131717579), 2131690620, 2131717578, new rxa(), null).setMessageCount(null).show();
    }
  }
  
  public static void a(sdg paramsdg, View paramView)
  {
    if (!pcv.a()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramView instanceof ProteusItemView));
        paramView = ((ProteusItemView)paramView).a();
      } while ((paramView == null) || (paramView.getVirtualView() == null));
      paramView = paramView.getVirtualView().findViewBaseByName("id_article_large_imge");
    } while ((!(paramView instanceof ImageBase)) || (paramView.getNativeView() == null));
    paramView = (ImageBase)paramView;
    String str = paramView.getSrc();
    if (!TextUtils.isEmpty(str)) {
      paramsdg.jdField_b_of_type_JavaLangString = str;
    }
    paramsdg.j = paramView.getNativeView().getWidth();
    paramsdg.k = paramView.getNativeView().getHeight();
  }
  
  public static boolean a()
  {
    return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean a(Activity paramActivity)
  {
    paramActivity = b(paramActivity);
    if (paramActivity[0] == 0) {}
    while (paramActivity[1] / paramActivity[0] > 1) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoDownloadBarInfo == null) || (paramBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get() == null) || (!paramBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.has()) || (paramBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.get() != 3)) {
      return false;
    }
    paramBaseArticleInfo = (articlesummary.UrlJumpInfo)paramBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get();
    int i = paramBaseArticleInfo.uint32_jump_type.get();
    if (i == 1)
    {
      if (pay.a(paramBaseArticleInfo.bytes_jump_url))
      {
        pay.a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_url));
        return true;
      }
    }
    else if ((i == 2) && (pay.a(paramBaseArticleInfo.bytes_jump_bundle)) && (bfwv.a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_bundle))))
    {
      a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_schema));
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
      if (i == 0) {
        bool = false;
      }
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoFeedsHelper", 2, "initUI() Settings.System.ACCELEROMETER_ROTATION ERROR=" + paramContext.getMessage());
    }
    return bool;
    return true;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    while (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    boolean bool2 = bool4;
    bool3 = bool5;
    try
    {
      if (rbt.c(paramBaseArticleInfo))
      {
        bool2 = bool4;
        bool3 = bool5;
        if (paramBaseArticleInfo.weishiUGInfo != null)
        {
          bool2 = bool4;
          bool3 = bool5;
          if (paramBaseArticleInfo.weishiUGInfo.uint32_auto_play != null)
          {
            bool2 = bool4;
            bool3 = bool5;
            if (paramBaseArticleInfo.weishiUGInfo.uint32_auto_play.has())
            {
              bool3 = bool5;
              if (paramBaseArticleInfo.weishiUGInfo.uint32_auto_play.get() != 1) {
                break label154;
              }
            }
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          QLog.d("VideoFeedsHelper", 2, "isAutoPlayByUgVideoCard,articleInfo,title: " + paramBaseArticleInfo.mTitle + ", mArticleID:" + paramBaseArticleInfo.mArticleID + ",isAutoPlay:" + bool1);
          bool2 = bool1;
        }
        return bool2;
        label154:
        bool1 = false;
      }
      return bool3;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.e("VideoFeedsHelper", 2, "isAutoPlayByUgVideoCard error: " + paramBaseArticleInfo.getMessage());
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    String str = ozp.a(paramBaseArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (rbt.a(str))
      {
        pay.a(paramContext, paramBaseArticleInfo, str);
        return true;
      }
      a(paramContext, str);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      boolean bool = puw.a(paramLong, null);
      return bool;
    }
    catch (Exception paramQQAppInterface) {}
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = a().contains(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "isDomainInLocalDnsBlackList(), result = " + bool);
    }
    return bool;
  }
  
  public static byte[] a(VideoInfo paramVideoInfo)
  {
    Object localObject2 = null;
    if (paramVideoInfo == null) {
      return null;
    }
    Object localObject1 = localObject2;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localObject2;
      paramVideoInfo.writeToParcel(localParcel, 0);
      localObject1 = localObject2;
      localParcel.setDataPosition(0);
      localObject1 = localObject2;
      paramVideoInfo = localParcel.marshall();
      localObject1 = paramVideoInfo;
      localParcel.recycle();
      return paramVideoInfo;
    }
    catch (Exception paramVideoInfo)
    {
      QLog.e("VideoFeedsHelper", 2, "getBytesFromVideoInfo() error=" + paramVideoInfo.toString());
    }
    return localObject1;
  }
  
  public static int[] a(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    return new int[] { Math.min(paramActivity.getWidth(), paramActivity.getHeight()), Math.max(paramActivity.getWidth(), paramActivity.getHeight()) };
  }
  
  public static int[] a(Activity paramActivity, int paramInt1, int paramInt2)
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
  
  public static int[] a(Context paramContext)
  {
    return a(paramContext, -1);
  }
  
  public static int[] a(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = localObject2;
      if (paramInt != -1) {
        localObject1 = ((DisplayManager)paramContext.getSystemService("display")).getDisplay(paramInt);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    }
    paramContext = new Point();
    int i;
    if (Build.VERSION.SDK_INT >= 17)
    {
      ((Display)localObject2).getRealSize(paramContext);
      i = paramContext.x;
      paramInt = paramContext.y;
    }
    for (;;)
    {
      return new int[] { i, paramInt };
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject2).getSize(paramContext);
        i = paramContext.x;
        paramInt = paramContext.y;
      }
      else
      {
        paramContext = new DisplayMetrics();
        ((Display)localObject2).getMetrics(paramContext);
        i = paramContext.widthPixels;
        paramInt = paramContext.heightPixels;
      }
    }
  }
  
  public static Integer[] a(int[] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt == null) {
      return null;
    }
    if (paramArrayOfInt.length == 0) {
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
    int i = paramActivity[1];
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i), Boolean.valueOf(true) };
    }
    if (paramInt1 < paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      i -= 2;
      paramInt2 = (int)(paramInt2 / paramInt1 * j);
      paramInt1 = paramInt2;
      if (paramInt2 > i) {
        paramInt1 = i;
      }
      return new Object[] { Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(paramInt1), Boolean.valueOf(bool) };
    }
  }
  
  public static int b()
  {
    if (bkwm.d()) {
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
    return bkwm.B(paramAppRuntime);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    return f(paramInt) + amtj.a(2131715217);
  }
  
  public static String b(long paramLong)
  {
    if (jdField_b_of_type_JavaTextDecimalFormat == null) {
      jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("##0.0");
    }
    String str2 = jdField_b_of_type_JavaTextDecimalFormat.format((float)paramLong / 1048576.0F);
    String str1 = str2;
    if (str2.endsWith(".0"))
    {
      int i = str2.indexOf(".0");
      str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
    }
    return str1 + "M";
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(6914);
  }
  
  public static void b(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    if ((i < 0) || (j > paramString1.length())) {
      return;
    }
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new rwx(paramTextView), i, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
    paramTextView.setOnClickListener(new rwy(paramString3, paramContext, paramOnClickListener));
  }
  
  public static void b(Context paramContext, String paramString) {}
  
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
      if ((paramBoolean1) && (l != -1L))
      {
        pkp.a().b(l, true);
        ThreadManager.post(new VideoFeedsHelper.16(l), 8, null, true);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("VideoFeedsHelper", 2, "followPubAccount() onFollowPublicAccount error uin=" + paramString + ", isSuccess=" + paramBoolean1 + ", isUGC=" + paramBoolean2);
        long l = -1L;
      }
    }
  }
  
  public static final boolean b()
  {
    return Aladdin.getConfig(364).getIntegerFromString("is_interrupt", 1) == 1;
  }
  
  public static boolean b(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mVideoDownloadBarInfo == null) || (paramBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get() == null) || (!paramBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.has()) || (paramBaseArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.get() != 3)) {
      return false;
    }
    paramBaseArticleInfo = (articlesummary.UrlJumpInfo)paramBaseArticleInfo.mVideoDownloadBarInfo.msg_url_jump_info.get();
    int i = paramBaseArticleInfo.uint32_jump_type.get();
    if (i == 1)
    {
      if (pay.a(paramBaseArticleInfo.bytes_jump_url))
      {
        pay.a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_url));
        return true;
      }
    }
    else if (i == 2)
    {
      if ((pay.a(paramBaseArticleInfo.bytes_jump_bundle)) && (bfwv.a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_bundle))))
      {
        a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_schema));
        return true;
      }
      if (pay.a(paramBaseArticleInfo.bytes_jump_url))
      {
        pay.a(paramActivity, pay.a(paramBaseArticleInfo.bytes_jump_url));
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(Context paramContext)
  {
    if ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER))
    {
      int i = a("ro.miui.notch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "isXiaomiWithNotch() getSystemPropertyForXiaomi=" + i);
      }
      return i == 1;
    }
    return false;
  }
  
  @TargetApi(17)
  public static int[] b(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getScreenSize() ERROR activity == null");
      }
      paramActivity = new int[2];
      paramActivity[0] = 0;
      paramActivity[1] = 0;
      paramActivity;
    }
    do
    {
      return paramActivity;
      arrayOfInt = a(paramActivity);
      if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0)) {
        break;
      }
      jdField_c_of_type_Int = arrayOfInt[0];
      jdField_d_of_type_Int = arrayOfInt[1];
      paramActivity = arrayOfInt;
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsHelper", 2, "getMeasureScreenSize(): width=" + arrayOfInt[0] + ", height=" + arrayOfInt[1]);
    return arrayOfInt;
    int[] arrayOfInt = a(paramActivity);
    jdField_c_of_type_Int = arrayOfInt[0];
    jdField_d_of_type_Int = arrayOfInt[1];
    int k = jdField_c_of_type_Int;
    int j = jdField_d_of_type_Int;
    int i;
    if ((a()) && (c(paramActivity)))
    {
      paramActivity = b(paramActivity);
      i = j;
      if (paramActivity != null)
      {
        i = j;
        if (paramActivity.length >= 2)
        {
          i = j;
          if (paramActivity[0] > 0)
          {
            i = j;
            if (paramActivity[1] > 0) {
              i = jdField_d_of_type_Int - paramActivity[1];
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getScreenSize() screenWidth=" + jdField_c_of_type_Int + ", screenHeight=" + jdField_d_of_type_Int + ", width=" + k + ", height=" + i);
      }
      return new int[] { k, i };
      i = j;
      if (b(paramActivity))
      {
        int m = a(paramActivity);
        i = j;
        if (m > 0) {
          i = jdField_d_of_type_Int - m;
        }
      }
    }
  }
  
  private static int[] b(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getClassLoader();
        if (paramContext == null) {
          break label210;
        }
        paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
        if (paramContext == null) {
          break label210;
        }
        Method localMethod = paramContext.getMethod("getNotchSize", new Class[0]);
        if (localMethod == null) {
          break label210;
        }
        paramContext = (int[])localMethod.invoke(paramContext, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsHelper", 2, "getNotchSizeInHW() ret=" + paramContext);
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsHelper", 2, "getNotchSizeInHW() Exception=" + paramContext.getMessage());
      }
      finally
      {
        paramContext = arrayOfInt;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsHelper", 2, "getNotchSizeInHW() ret=" + arrayOfInt);
        return arrayOfInt;
      }
      return paramContext;
      label210:
      paramContext = arrayOfInt;
    }
  }
  
  public static int c()
  {
    if (bkwm.d()) {
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
    return f(paramInt);
  }
  
  public static String c(long paramLong)
  {
    if (paramLong <= 0L) {
      return amtj.a(2131715236);
    }
    return b(paramLong) + amtj.a(2131715232);
  }
  
  private static void c(Context paramContext, String paramString)
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
  
  public static boolean c()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Build.VERSION.SDK_INT <= 21) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (Build.VERSION.SDK_INT <= 21);
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT > 23);
      bool1 = bool2;
    } while (DeviceInfoUtil.getSystemTotalMemory() > -2147483648L);
    return false;
  }
  
  private static boolean c(Context paramContext)
  {
    for (boolean bool1 = false;; bool1 = false)
    {
      try
      {
        paramContext = paramContext.getClassLoader();
        if ((paramContext == null) || (Build.VERSION.SDK_INT < 23)) {
          continue;
        }
        paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
        if (paramContext == null) {
          continue;
        }
        Method localMethod = paramContext.getMethod("hasNotchInScreen", new Class[0]);
        if (localMethod == null) {
          continue;
        }
        boolean bool2 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsHelper", 2, "hasNotchInHW() ret=" + bool1);
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsHelper", 2, "hasNotchInHW() Exception=" + paramContext.getMessage());
      }
      finally
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("VideoFeedsHelper", 2, "hasNotchInHW() ret=" + false);
        return false;
      }
      return bool1;
    }
  }
  
  public static int d()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("ks_column_card_video_autoplay", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getKSColumnCardAutoPlayConfig(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
  }
  
  public static String d(int paramInt)
  {
    return e(paramInt);
  }
  
  public static boolean d()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(153);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("readinjoy_videochannel_jump_multivideo_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isVideoChannelClickJumpToMultiVideo(), value = ", Integer.valueOf(i) });
      }
      return i == 1;
    }
    return false;
  }
  
  public static int e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(300);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("king_card_support", 2);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getMainFeedsKingCardAutoPlayConfig(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
  }
  
  public static String e(int paramInt)
  {
    String str = "";
    if (paramInt >= 99985000) {
      str = "9999万";
    }
    do
    {
      return str;
      if (paramInt >= 10004999)
      {
        if (jdField_d_of_type_JavaTextDecimalFormat == null) {
          jdField_d_of_type_JavaTextDecimalFormat = new DecimalFormat("##");
        }
        return jdField_d_of_type_JavaTextDecimalFormat.format(paramInt / 10000.0D) + amtj.a(2131715184);
      }
      if (paramInt >= 10000)
      {
        if (jdField_c_of_type_JavaTextDecimalFormat == null) {
          jdField_c_of_type_JavaTextDecimalFormat = new DecimalFormat("##.#");
        }
        return jdField_c_of_type_JavaTextDecimalFormat.format(paramInt / 10000.0D) + amtj.a(2131715164);
      }
    } while (paramInt <= 0);
    return paramInt + "";
  }
  
  public static boolean e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(169);
    int i;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("kandian_video_logo_switch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isShowKandianVideoLogoEnable(), value = ", Integer.valueOf(i) });
      }
    }
    return i == 1;
  }
  
  public static int f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("big_img_video_autoplay", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoCardAutoPlayConfig(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
  }
  
  private static String f(int paramInt)
  {
    String str = "";
    if (jdField_a_of_type_JavaTextDecimalFormat == null) {
      jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("###.#");
    }
    if (paramInt >= 100000000) {
      str = jdField_a_of_type_JavaTextDecimalFormat.format(paramInt / 100000000.0D) + amtj.a(2131715211);
    }
    do
    {
      return str;
      if (paramInt >= 10000) {
        return jdField_a_of_type_JavaTextDecimalFormat.format(paramInt / 10000.0D) + amtj.a(2131715209);
      }
    } while (paramInt < 0);
    return paramInt + "";
  }
  
  public static boolean f()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(314);
    int j;
    if (localAladdinConfig != null)
    {
      j = localAladdinConfig.getIntegerFromString("video_localdns_enable", 1);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "isVideoLocalDnsEnable(), value = " + j);
      }
    }
    for (int i = j;; i = 1) {
      return i == 1;
    }
  }
  
  public static int g()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(193);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("big_img_video_click_show_layer", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoClickShowLayer(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
  }
  
  public static boolean g()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(180);
    int i;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("VideoEntranceJumpAppSwitch", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "isVideoEntranceJumpAppEnable(), value = ", Integer.valueOf(i) });
      }
    }
    return i == 1;
  }
  
  public static int h()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(239);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("big_img_video_column_autoplay", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoColumnCardAutoPlayConfig(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
  }
  
  public static boolean h()
  {
    return Aladdin.getConfig(376).getIntegerFromString("slide_into_home_page_enable", 1) == 1;
  }
  
  public static int i()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(239);
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("big_img_video_column_click_show_layer", 0);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 1, new Object[] { "getBigImgVideoColumnClickShowLayer(), value = ", Integer.valueOf(i) });
      }
      return i;
    }
    return 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwv
 * JD-Core Version:    0.7.0.1
 */