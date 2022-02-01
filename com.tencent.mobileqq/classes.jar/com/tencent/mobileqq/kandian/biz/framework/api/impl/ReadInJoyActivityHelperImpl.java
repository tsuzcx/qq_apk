package com.tencent.mobileqq.kandian.biz.framework.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.test.VideoTestHelper;
import com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdIMAXBrowserFragment;
import com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdPopSheetBrowserFragment;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.Achilles;
import com.tencent.mobileqq.kandian.biz.common.ReadinjoyJumpUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment;
import com.tencent.mobileqq.kandian.biz.detail.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.fragment.ReadInJoyUninterestComplainFragment;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxFragment;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.daily.PreLoader;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyActivityHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyActivityHelper;", "()V", "checkAppPackage", "", "appPackageName", "", "getFastWebIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "data", "Ljava/util/HashMap;", "getJumpReadInJoyNewFeedsIntent", "from", "", "getJumpReadInJoyTabFloatingWindowIntent", "rowKey", "articleURL", "getJumpReadInJoyTabIntent", "channelId", "getOpenArticleSchemeIntent", "getReadInJoyAdIMAXBrowserFragmentClazz", "Ljava/lang/Class;", "getReadInJoyAdPopSheetBrowserFragmentClazz", "getReadInJoyChannelActivityClazz", "getReadInJoyDraftboxFragmentClazz", "getReadInJoyNewFeedsActivityClazz", "getReadInJoySettingActivityClazz", "getReadInJoyUploadAvatarFragmentClazz", "handleMenuDataParse", "", "bundle", "Landroid/os/Bundle;", "isReadInJoyArticleDetailActivity", "isReadInJoyChannelActivity", "isReadInJoyNewFeedsActivity", "launchApp", "appSchema", "channelID", "defaultURL", "cancelJump", "launchChannelActivity", "channelName", "channelType", "reportFrom", "param", "", "", "clearTop", "launchFeedsActivity", "launchFrom", "tabIndex", "extraData", "articleList", "", "", "currentArticleID", "launchGroupSubscribeChannelActivity", "args", "comeFrom", "launchInterestActivity", "launchKanDianDailyActivity", "launchReadInJoyPrivacyListFragment", "activity", "Landroid/app/Activity;", "feedsId", "launchReadInJoySelectMemberAQFragmentForResult", "intent", "launchReadInJoySelfActivity", "redTouch", "launchReadInJoyTab", "launchReadInJoyUninterestComplainFragmentForResult", "launchSelfFromIndependentTab", "shouldMessages", "launchSubscriptionActivity", "jumpAction", "launchVideoChannelActivityForTwoItemVideo", "mainArticle", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "clickedArticle", "showAdapterAnim", "launchVideoSubChannelActivity", "openDailyDynamicChildFeeds", "openEmptyFullPlayActivity", "openFlutterPage", "openFullVideoPlay", "openMXFlutterPage", "startApp", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyActivityHelperImpl
  implements IReadInJoyActivityHelper
{
  public static final ReadInJoyActivityHelperImpl.Companion Companion = new ReadInJoyActivityHelperImpl.Companion(null);
  @NotNull
  private static String InterestWebUrl = "https://kandian.qq.com/mqq/html/settingInterest.html?_wv=1027&_bid=2378";
  @NotNull
  public static final String TAG = "ReadInJoyActivityHelper";
  
  private final void handleMenuDataParse(HashMap<String, String> paramHashMap, Bundle paramBundle)
  {
    String str1 = (String)paramHashMap.get("approveCount");
    String str2 = (String)paramHashMap.get("approveStatus");
    String str3 = (String)paramHashMap.get("followStatus");
    String str4 = (String)paramHashMap.get("commentCount");
    paramHashMap = (String)paramHashMap.get("shareCount");
    int j = 0;
    if (str1 != null) {}
    for (;;)
    {
      try
      {
        if (((CharSequence)str1).length() <= 0) {
          continue;
        }
        i = 1;
        if (i == 1) {
          paramBundle.putInt("VIDEO_DIAN_ZAN_COUNT", Integer.parseInt(str1));
        }
        if (str2 == null) {
          continue;
        }
        if (((CharSequence)str2).length() <= 0) {
          continue;
        }
        i = 1;
      }
      catch (NumberFormatException paramHashMap)
      {
        continue;
        int i = 0;
        continue;
        boolean bool = false;
        continue;
        i = 0;
        continue;
        bool = false;
        continue;
        i = 0;
        continue;
      }
      if (i == 1)
      {
        if (Integer.parseInt(str2) != 1) {
          continue;
        }
        bool = true;
        paramBundle.putBoolean("VIDEO_IS_DIANZAN", bool);
      }
      if (str3 != null)
      {
        if (((CharSequence)str3).length() <= 0) {
          continue;
        }
        i = 1;
        if (i == 1)
        {
          if (Integer.parseInt(str3) != 1) {
            continue;
          }
          bool = true;
          paramBundle.putBoolean("VIDEO_ACCOUNT_IS_FOLLOWED", bool);
        }
      }
      if (str4 != null)
      {
        if (((CharSequence)str4).length() <= 0) {
          continue;
        }
        i = 1;
        if (i == 1) {
          paramBundle.putInt("VIDEO_COMMENT_COUNT", Integer.parseInt(str4));
        }
      }
      if (paramHashMap != null)
      {
        i = j;
        if (((CharSequence)paramHashMap).length() > 0) {
          i = 1;
        }
        if (i == 1)
        {
          paramBundle.putInt("VIDEO_BIU_COUNT", Integer.parseInt(paramHashMap));
          return;
          QLog.e("ReadInJoyActivityHelper", 1, "parse videoinfo error = ", (Throwable)paramHashMap);
        }
      }
      return;
      i = 0;
    }
  }
  
  private final void openEmptyFullPlayActivity(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("sourceFrom");
    String str = (String)paramHashMap.get("rowKey");
    int i;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (StringsKt.equals("nativeArticleRecommend", (String)localObject, true))
        {
          i = 10;
        }
        else
        {
          localObject = Integer.valueOf((String)localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "Integer.valueOf(sourceFrom)");
          i = ((Integer)localObject).intValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyActivityHelper", 2, "openEmptyFullPlayActivity: ", (Throwable)localException);
      }
      i = -1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("VIDEO_ENTER_FROM_KD_TAB", Intrinsics.areEqual("1", (String)paramHashMap.get("enter_from_kdtab")));
    VideoTestHelper.a.a(paramHashMap);
    VideoFeedsHelper.a(paramActivity, localBundle, str, i);
  }
  
  public boolean checkAppPackage(@Nullable String paramString)
  {
    boolean bool1 = TextUtils.isEmpty((CharSequence)paramString);
    boolean bool2 = true;
    if (!bool1)
    {
      bool1 = bool2;
      if (StringsKt.equals("com.tencent.reading", paramString, true)) {
        return bool1;
      }
      bool1 = bool2;
      if (StringsKt.equals("com.tencent.rijvideo", paramString, true)) {
        return bool1;
      }
      if (StringsKt.equals("com.tencent.weishi", paramString, true)) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  @NotNull
  public Intent getFastWebIntent(@NotNull Context paramContext, @NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "data");
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    paramContext = new Intent(paramContext, FastWebActivity.class);
    try
    {
      String str7 = (String)paramHashMap.get("channelID");
      String str6 = (String)paramHashMap.get("strategyId");
      String str5 = (String)paramHashMap.get("algorithmID");
      String str3 = (String)paramHashMap.get("title");
      String str8 = (String)paramHashMap.get("firstPagePicUrl");
      String str9 = (String)paramHashMap.get("articleContentUrl");
      String str4 = (String)paramHashMap.get("articleID");
      String str1 = (String)paramHashMap.get("subscribeID");
      String str2 = (String)paramHashMap.get("subscribeName");
      paramHashMap = (String)paramHashMap.get("rowKey");
      if (paramHashMap != null) {
        localBaseArticleInfo.innerUniqueID = paramHashMap;
      }
      if (str9 != null) {
        localBaseArticleInfo.mArticleContentUrl = URLDecoder.decode(str9, "utf-8");
      }
      if (str8 != null) {
        localBaseArticleInfo.mFirstPagePicUrl = URLDecoder.decode(str8, "utf-8");
      }
      if (str7 != null)
      {
        paramHashMap = Long.valueOf(str7);
        Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "java.lang.Long.valueOf(channelID)");
        localBaseArticleInfo.mChannelID = paramHashMap.longValue();
      }
      if (str6 != null)
      {
        paramHashMap = Integer.valueOf(str6);
        Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "Integer.valueOf(strategyId)");
        localBaseArticleInfo.mStrategyId = paramHashMap.intValue();
      }
      if (str5 != null)
      {
        paramHashMap = Long.valueOf(str5);
        Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "java.lang.Long.valueOf(algorithmID)");
        localBaseArticleInfo.mAlgorithmID = paramHashMap.longValue();
      }
      if (str3 != null) {
        localBaseArticleInfo.mTitle = str3;
      }
      if (str4 != null)
      {
        paramHashMap = Long.valueOf(str4);
        Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "java.lang.Long.valueOf(articleID)");
        localBaseArticleInfo.mArticleID = paramHashMap.longValue();
      }
      if (str1 != null) {
        localBaseArticleInfo.mSubscribeID = str1;
      }
      if (str2 != null) {
        localBaseArticleInfo.mSubscribeName = str2;
      }
    }
    catch (Exception paramHashMap)
    {
      label332:
      break label332;
    }
    paramContext.putExtra("fast_web_article_info", (Parcelable)localBaseArticleInfo);
    paramContext.putExtra("native_article_launch_from", 1002);
    return paramContext;
  }
  
  @NotNull
  public Intent getJumpReadInJoyNewFeedsIntent(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if ((paramInt != 9) && (paramInt != 6)) {
      return new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    }
    paramContext = ReadInJoyLockScreenJumpDelegate.a(paramContext, paramInt, 0);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ReadInJoyLockScreenJumpD…nts.CHANNEL_ID_RECOMMEND)");
    return paramContext;
  }
  
  @NotNull
  public Intent getJumpReadInJoyTabFloatingWindowIntent(@NotNull Context paramContext, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "articleURL");
    paramContext = getJumpReadInJoyTabIntent(paramContext, paramInt);
    paramContext.putExtra("arg_channel_rowkey", paramString1);
    paramContext.putExtra("arg_channel_article_url", paramString2);
    return paramContext;
  }
  
  @NotNull
  public Intent getJumpReadInJoyTabIntent(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return getJumpReadInJoyTabIntent(paramContext, paramInt, 0);
  }
  
  @NotNull
  public Intent getJumpReadInJoyTabIntent(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("launch_from", paramInt1);
    localIntent.putExtra("tab_index", FrameControllerUtil.h);
    localIntent.putExtra("open_kandian_tab_fragment", true);
    localIntent.putExtra("arg_channel_cover_id", paramInt2);
    localIntent.setFlags(335544320);
    if ((paramInt1 != 9) && (paramInt1 != 6)) {
      return localIntent;
    }
    ReadinjoyJumpUtils.a(localIntent);
    paramContext = ReadInJoyLockScreenJumpDelegate.a(paramContext, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ReadInJoyLockScreenJumpD…context, from, channelId)");
    return paramContext;
  }
  
  @Nullable
  public Intent getOpenArticleSchemeIntent(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
    Intent localIntent = new Intent(paramContext, FastWebActivity.class);
    String str7 = null;
    if (paramHashMap != null) {}
    for (;;)
    {
      try
      {
        str2 = (String)paramHashMap.get("strategyId");
        if (paramHashMap == null) {
          break label399;
        }
        str3 = (String)paramHashMap.get("algorithmID");
        if (paramHashMap == null) {
          break label405;
        }
        str4 = (String)paramHashMap.get("url");
        if (paramHashMap == null) {
          break label411;
        }
        str5 = (String)paramHashMap.get("rowkey");
        if (paramHashMap != null) {
          paramContext = (String)paramHashMap.get("fromType");
        }
        if (paramHashMap == null) {
          break label417;
        }
        str1 = (String)paramHashMap.get("commenId");
        paramContext = str1;
        if (TextUtils.isEmpty((CharSequence)str1))
        {
          if (paramHashMap == null) {
            break label422;
          }
          paramContext = (String)paramHashMap.get("commentId");
        }
        if (paramHashMap == null) {
          break label427;
        }
        str1 = (String)paramHashMap.get("subCommentId");
        if (paramHashMap == null) {
          break label432;
        }
        str6 = (String)paramHashMap.get("jumpCommentType");
        if (paramHashMap != null) {
          str7 = (String)paramHashMap.get("isAwesome");
        }
        if (str5 != null) {
          localBaseArticleInfo.innerUniqueID = str5;
        }
        if (str4 != null)
        {
          paramHashMap = Base64Util.decode(str4, 0);
          Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "Base64Util.decode(articl…tUrl, Base64Util.DEFAULT)");
          localBaseArticleInfo.mArticleContentUrl = new String(paramHashMap, Charsets.UTF_8);
        }
        if (str2 != null)
        {
          paramHashMap = Integer.valueOf(str2);
          Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "Integer.valueOf(strategyId)");
          localBaseArticleInfo.mStrategyId = paramHashMap.intValue();
        }
        if (str3 != null)
        {
          paramHashMap = Long.valueOf(str3);
          Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "java.lang.Long.valueOf(algorithmID)");
          localBaseArticleInfo.mAlgorithmID = paramHashMap.longValue();
        }
        paramHashMap = new AnchorData();
        paramHashMap.jdField_a_of_type_JavaLangString = paramContext;
        paramHashMap.jdField_b_of_type_JavaLangString = str1;
        paramHashMap.jdField_b_of_type_Boolean = Intrinsics.areEqual("0", str6);
        paramHashMap.jdField_a_of_type_Boolean = Intrinsics.areEqual("1", str7);
        localIntent.putExtra("intent_key_anchor_data", (Parcelable)paramHashMap);
      }
      catch (Exception paramContext)
      {
        continue;
      }
      localIntent.putExtra("fast_web_article_info", (Parcelable)localBaseArticleInfo);
      return localIntent;
      String str2 = null;
      continue;
      label399:
      String str3 = null;
      continue;
      label405:
      String str4 = null;
      continue;
      label411:
      String str5 = null;
      continue;
      label417:
      String str1 = null;
      continue;
      label422:
      paramContext = null;
      continue;
      label427:
      str1 = null;
      continue;
      label432:
      String str6 = null;
    }
  }
  
  @NotNull
  public Class<?> getReadInJoyAdIMAXBrowserFragmentClazz()
  {
    return ReadInJoyAdIMAXBrowserFragment.class;
  }
  
  @NotNull
  public Class<?> getReadInJoyAdPopSheetBrowserFragmentClazz()
  {
    return ReadInJoyAdPopSheetBrowserFragment.class;
  }
  
  @NotNull
  public Class<?> getReadInJoyChannelActivityClazz()
  {
    return ReadInJoyChannelActivity.class;
  }
  
  @NotNull
  public Class<?> getReadInJoyDraftboxFragmentClazz()
  {
    return ReadInJoyDraftboxFragment.class;
  }
  
  @NotNull
  public Class<?> getReadInJoyNewFeedsActivityClazz()
  {
    return ReadInJoyNewFeedsActivity.class;
  }
  
  @NotNull
  public Class<?> getReadInJoySettingActivityClazz()
  {
    return ReadInJoySettingActivity.class;
  }
  
  @NotNull
  public Class<?> getReadInJoyUploadAvatarFragmentClazz()
  {
    return ReadInJoyUploadAvatarFragment.class;
  }
  
  public boolean isReadInJoyArticleDetailActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return paramContext instanceof ReadInJoyArticleDetailActivity;
  }
  
  public boolean isReadInJoyChannelActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return paramContext instanceof ReadInJoyChannelActivity;
  }
  
  public boolean isReadInJoyNewFeedsActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return paramContext instanceof ReadInJoyNewFeedsActivity;
  }
  
  public void launchApp(@NotNull Context paramContext, @Nullable String paramString1, int paramInt, @Nullable String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString1));
    localIntent.putExtra("big_brother_source_key", RIJJumpUtils.a(paramInt));
    localIntent.putExtra("launch_app_time", System.currentTimeMillis());
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = -1;
    paramString1 = (JumpCallback)new ReadInJoyActivityHelperImpl.launchApp.jumpCallback.1(localIntRef, new WeakReference(paramContext), paramBoolean, paramString2, paramString1);
    localIntRef.element = TeleScreen.a().a(paramString1);
    localIntent.putExtra("key_callback_id", localIntRef.element);
    paramContext.startActivity(localIntent);
  }
  
  public void launchChannelActivity(@NotNull Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    launchChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public void launchChannelActivity(@Nullable Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap)
  {
    launchChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap, false);
  }
  
  public void launchChannelActivity(@Nullable Context paramContext, int paramInt1, @Nullable String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap, boolean paramBoolean)
  {
    if (paramInt1 == 41522)
    {
      paramMap = new Intent();
      paramMap.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramMap.putExtra("channel_id", paramInt1);
      paramMap.putExtra("sub_channel_name", paramString);
      paramMap.putExtra("is_sub_channel", true);
      QPublicFragmentActivity.start(paramContext, paramMap, ReadInJoyPicWaterFallFragment.class);
      return;
    }
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    if ((paramMap != null) && ((paramMap.isEmpty() ^ true)))
    {
      paramString = new SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("channel_map_data", (Serializable)paramString);
    }
    if (paramBoolean) {
      localIntent.addFlags(67108864);
    }
    if (paramContext != null) {
      paramContext.startActivity(localIntent);
    }
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).overridePendingTransition(2097217536, 0);
    }
  }
  
  public void launchFeedsActivity(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    launchFeedsActivity(paramContext, paramInt1, paramInt2, null);
  }
  
  public void launchFeedsActivity(@NotNull Context paramContext, int paramInt1, int paramInt2, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    localIntent.putExtra("readinjoy_show_tab", 0);
    if (paramInt1 == 2) {
      localIntent.setFlags(131072);
    }
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadinjoyStopFunctionSwitch())
    {
      localIntent = new Intent(paramContext, ReadInJoySettingActivity.class);
    }
    else if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab())
    {
      localIntent = getJumpReadInJoyTabIntent(paramContext, paramInt1);
    }
    else
    {
      if (paramInt1 == 1)
      {
        localIntent.putExtra("from_search", true);
      }
      else if (paramInt1 == 9)
      {
        localIntent.putExtra("from_lock_screen", true);
        ReadinjoyJumpUtils.a(localIntent);
        QLog.d("ReadInJoyActivityHelper", 2, "start kandian activity, launch from lock screen");
      }
      else
      {
        localIntent.putExtra("from_search", false);
      }
      localIntent.putExtra("launch_from", paramInt1);
      VideoVolumeControl.getInstance().setMute(true, "init", 1);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramContext.startActivity(localIntent);
    if ((paramInt2 == 0) && (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab()))
    {
      paramContext = RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (paramContext != null)
      {
        ((KandianMergeManager)paramContext).h();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
    }
  }
  
  public void launchFeedsActivity(@NotNull Context paramContext, @Nullable List<Long> paramList, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    Collection localCollection = (Collection)paramList;
    int i;
    if ((localCollection != null) && (!localCollection.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      if (paramList != null)
      {
        localIntent.putExtra("subscription_all_article_id", (Serializable)paramList);
        QLog.i("ReadInJoyActivityHelper", 1, paramList.toString());
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.io.Serializable");
      }
    }
    if (paramLong != -1L) {
      localIntent.putExtra("subscription_click_article_id", paramLong);
    }
    if (paramInt == 1) {
      localIntent.putExtra("from_search", true);
    } else {
      localIntent.putExtra("from_search", false);
    }
    localIntent.putExtra("launch_from", paramInt);
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
    paramContext = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "BaseApplicationImpl.getApplication()");
    paramContext = paramContext.getRuntime().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (paramContext != null)
    {
      ((KandianMergeManager)paramContext).h();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  public void launchGroupSubscribeChannelActivity(@Nullable Context paramContext, @Nullable String paramString, int paramInt)
  {
    Object localObject2 = (Map)null;
    Object localObject1 = localObject2;
    String str;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      try
      {
        long l = new JSONObject(paramString).optInt("articleid", -1);
        localObject1 = (Map)new HashMap();
        if (l != -1L) {}
        try
        {
          ((Map)localObject1).put("articleID", Long.valueOf(l));
          ((Map)localObject1).put("pushContext", paramString);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("group subscribe articleID : ");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(", pushContext : ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("ReadInJoyActivityHelper", 1, ((StringBuilder)localObject2).toString());
        }
        catch (JSONException localJSONException2)
        {
          paramString = (String)localObject1;
          localObject1 = localJSONException2;
        }
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        paramString = localJSONException2;
      }
      str = paramString;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009334", "0X8009334", 0, 0, "", String.valueOf(paramInt), "", ReadInJoyBaseDeliverActivity.a(), false);
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(paramContext, 40830, ReadInJoyConstants.jdField_b_of_type_JavaLangString, 0, paramInt, str);
  }
  
  public void launchInterestActivity(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", InterestWebUrl);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
  }
  
  public void launchKanDianDailyActivity(@NotNull Context paramContext, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (PTSHelper.a(paramContext)) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (!(paramContext instanceof BaseActivity)) {
      localIntent.setFlags(268435456);
    }
    if (paramBoolean)
    {
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
    }
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.a(paramContext, localIntent, ReadInJoyDailyFragment.class);
  }
  
  public void launchReadInJoyPrivacyListFragment(@NotNull Activity paramActivity, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intent localIntent = new Intent();
    localIntent.putExtra("feeds_id", paramLong);
    PublicFragmentActivity.a((Context)paramActivity, localIntent, ReadInJoyPrivacyListFragment.class);
  }
  
  public void launchReadInJoySelectMemberAQFragmentForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    PublicFragmentActivity.a(paramActivity, paramIntent, ReadInJoySelectMemberAQFragment.class, 119);
  }
  
  public void launchReadInJoySelfActivity(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    localIntent.putExtra("redTouch", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  public void launchReadInJoyTab(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("tab_index", FrameControllerUtil.h);
    localIntent.putExtra("open_kandian_tab_fragment", true);
    localIntent.setFlags(335544320);
    if ((paramInt == 9) || (paramInt == 6)) {
      ReadinjoyJumpUtils.a(localIntent);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void launchReadInJoyUninterestComplainFragmentForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    QPublicFragmentActivity.startForResult(paramActivity, paramIntent, ReadInJoyUninterestComplainFragment.class, 9999);
  }
  
  public void launchSelfFromIndependentTab(@NotNull Context paramContext, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent(paramContext, ReadInJoyMessagesActivity.class);
      localIntent.putExtra("shouldBackSelfAct", true);
    }
    else
    {
      localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    }
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  @Nullable
  public Intent launchSubscriptionActivity(@NotNull Context paramContext, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intent localIntent = (Intent)null;
    if (paramInt1 != -1) {
      localIntent = new Intent(paramContext, ReadInJoyFeedsActivity.class);
    }
    if ((paramInt1 != -1) && (localIntent != null)) {
      localIntent.putExtra("readinjoy_show_tab", paramInt1);
    }
    if ((paramInt2 != -1) && (localIntent != null)) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    return localIntent;
  }
  
  public void launchVideoChannelActivityForTwoItemVideo(@NotNull Context paramContext, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo1, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo1, "mainArticle");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo2, "clickedArticle");
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", HardCodeUtil.a(2131712954));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", 1);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramAbsBaseArticleInfo2.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramAbsBaseArticleInfo1.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    if (paramAbsBaseArticleInfo1 != paramAbsBaseArticleInfo2) {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 2);
    } else {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 1);
    }
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo2) ^ true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", (Parcelable)paramAbsBaseArticleInfo2);
    localIntent.putExtra("is_need_show_animation_adapter", paramBoolean);
    paramContext.startActivity(localIntent);
    paramContext = VideoReporter.a;
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "VideoReporter.sVideoSessionMap");
    ((Map)paramContext).put(ReadInJoyChannelActivity.class, VideoReporter.b());
    VideoVolumeControl.getInstance().setMute(false, "jumpFromKandianFeed", 1);
  }
  
  public void launchVideoSubChannelActivity(@NotNull Context paramContext, int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "channelName");
    launchVideoSubChannelActivity(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public void launchVideoSubChannelActivity(@NotNull Context paramContext, int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, @Nullable Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "channelName");
    Intent localIntent = new Intent(paramContext, ReadInJoyVideoSubChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("channel_from", paramInt3);
    if ((paramMap != null) && ((paramMap.isEmpty() ^ true)))
    {
      paramString = new SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("channel_map_data", (Serializable)paramString);
    }
    paramContext.startActivity(localIntent);
  }
  
  public void openDailyDynamicChildFeeds(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramHashMap != null) {
      try
      {
        String str1 = (String)paramHashMap.get("channelID");
        String str2 = (String)paramHashMap.get("channelName");
        if ((paramContext != null) && (!TextUtils.isEmpty((CharSequence)str1)) && (!TextUtils.isEmpty((CharSequence)str2)))
        {
          Object localObject = new Intent(paramContext, ReadInJoyChannelActivity.class);
          Integer localInteger = Integer.valueOf(str1);
          Intrinsics.checkExpressionValueIsNotNull(localInteger, "Integer.valueOf(channelID)");
          ((Intent)localObject).putExtra("channel_id", localInteger.intValue());
          ((Intent)localObject).putExtra("channel_name", str2);
          ((Intent)localObject).putExtra("channel_map_data", (Serializable)paramHashMap);
          ((Intent)localObject).putExtra("is_daily_dynamic_child_channel", true);
          paramContext.startActivity((Intent)localObject);
          if ((paramContext instanceof Activity)) {
            ((Activity)paramContext).overridePendingTransition(2097217536, 0);
          }
          paramContext = (String)paramHashMap.get("requestData");
          if (!TextUtils.isEmpty((CharSequence)paramContext))
          {
            paramHashMap = (IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("DAILY_CHILD_FEEDS_REQUEST_CONFIG");
            ((StringBuilder)localObject).append(str1);
            paramHashMap.updateReadInJoySpValue(((StringBuilder)localObject).toString(), paramContext);
          }
          localStringBuilder.append(str1);
          localStringBuilder.append(str2);
          localStringBuilder.append(paramContext);
        }
      }
      catch (Exception paramContext)
      {
        localStringBuilder.append(paramContext.toString());
      }
    }
    QLog.d("ReadInJoyActivityHelper", 1, new Object[] { "openDailyDynamicChildFeeds log=", localStringBuilder.toString() });
  }
  
  public void openFlutterPage(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    RIJFlutterUtils.a(RIJFlutterUtils.a, paramContext, paramHashMap, false, null, 8, null);
  }
  
  /* Error */
  public void openFullVideoPlay(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +1198 -> 1199
    //   4: aload_2
    //   5: ifnonnull +6 -> 11
    //   8: goto +1191 -> 1199
    //   11: ldc 242
    //   13: aload_2
    //   14: ldc_w 927
    //   17: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 141	java/lang/String
    //   23: invokestatic 248	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   26: ifeq +13 -> 39
    //   29: aload_0
    //   30: aload_1
    //   31: checkcast 623	android/app/Activity
    //   34: aload_2
    //   35: invokespecial 929	com/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyActivityHelperImpl:openEmptyFullPlayActivity	(Landroid/app/Activity;Ljava/util/HashMap;)V
    //   38: return
    //   39: aload_2
    //   40: ldc 199
    //   42: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 141	java/lang/String
    //   48: astore 13
    //   50: aload_2
    //   51: ldc_w 931
    //   54: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 141	java/lang/String
    //   60: astore 18
    //   62: aload_2
    //   63: ldc_w 933
    //   66: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 141	java/lang/String
    //   72: astore 14
    //   74: aload_2
    //   75: ldc_w 935
    //   78: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 141	java/lang/String
    //   84: astore 19
    //   86: aload_2
    //   87: ldc_w 937
    //   90: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 141	java/lang/String
    //   96: astore 20
    //   98: aload_2
    //   99: ldc_w 939
    //   102: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: checkcast 141	java/lang/String
    //   108: astore 21
    //   110: aload_2
    //   111: ldc_w 295
    //   114: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 141	java/lang/String
    //   120: astore 15
    //   122: aload_2
    //   123: ldc_w 297
    //   126: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast 141	java/lang/String
    //   132: astore 10
    //   134: aload_2
    //   135: ldc_w 299
    //   138: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: checkcast 141	java/lang/String
    //   144: astore 11
    //   146: aload_2
    //   147: ldc_w 303
    //   150: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 141	java/lang/String
    //   156: astore 16
    //   158: aload_2
    //   159: ldc_w 305
    //   162: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast 141	java/lang/String
    //   168: astore 17
    //   170: aload_2
    //   171: ldc 198
    //   173: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 141	java/lang/String
    //   179: astore 22
    //   181: aload_2
    //   182: ldc_w 442
    //   185: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: checkcast 141	java/lang/String
    //   191: astore 34
    //   193: aload_2
    //   194: ldc_w 444
    //   197: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: checkcast 141	java/lang/String
    //   203: astore 8
    //   205: aload_2
    //   206: ldc_w 941
    //   209: invokevirtual 945	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   212: ifeq +18 -> 230
    //   215: aload_2
    //   216: ldc_w 941
    //   219: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   222: checkcast 141	java/lang/String
    //   225: astore 8
    //   227: goto +28 -> 255
    //   230: aload_2
    //   231: ldc_w 947
    //   234: invokevirtual 945	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   237: ifeq +18 -> 255
    //   240: aload_2
    //   241: ldc_w 947
    //   244: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   247: checkcast 141	java/lang/String
    //   250: astore 8
    //   252: goto +3 -> 255
    //   255: aload_2
    //   256: ldc_w 448
    //   259: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: checkcast 141	java/lang/String
    //   265: astore 38
    //   267: aload_2
    //   268: ldc_w 446
    //   271: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   274: checkcast 141	java/lang/String
    //   277: astore 39
    //   279: aload_2
    //   280: ldc_w 291
    //   283: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 141	java/lang/String
    //   289: astore 23
    //   291: aload_2
    //   292: ldc_w 293
    //   295: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   298: checkcast 141	java/lang/String
    //   301: astore 24
    //   303: aload_2
    //   304: ldc_w 289
    //   307: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   310: checkcast 141	java/lang/String
    //   313: astore 25
    //   315: aload_2
    //   316: ldc_w 949
    //   319: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 141	java/lang/String
    //   325: astore 26
    //   327: aload_2
    //   328: ldc_w 951
    //   331: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   334: checkcast 141	java/lang/String
    //   337: astore 27
    //   339: aload_2
    //   340: ldc_w 953
    //   343: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   346: checkcast 141	java/lang/String
    //   349: astore 28
    //   351: aload_2
    //   352: ldc_w 955
    //   355: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   358: checkcast 141	java/lang/String
    //   361: astore 29
    //   363: aload_2
    //   364: ldc_w 957
    //   367: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   370: checkcast 141	java/lang/String
    //   373: astore 30
    //   375: aload_2
    //   376: ldc_w 959
    //   379: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   382: checkcast 141	java/lang/String
    //   385: astore 31
    //   387: aload_2
    //   388: ldc_w 961
    //   391: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   394: checkcast 141	java/lang/String
    //   397: astore 32
    //   399: aload_2
    //   400: ldc_w 963
    //   403: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: checkcast 141	java/lang/String
    //   409: astore 33
    //   411: aload_2
    //   412: ldc_w 965
    //   415: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   418: checkcast 141	java/lang/String
    //   421: astore 35
    //   423: aload_2
    //   424: ldc_w 967
    //   427: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   430: checkcast 141	java/lang/String
    //   433: astore 12
    //   435: aconst_null
    //   436: checkcast 141	java/lang/String
    //   439: astore 9
    //   441: aload 35
    //   443: checkcast 151	java/lang/CharSequence
    //   446: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne +38 -> 487
    //   452: new 759	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 760	java/lang/StringBuilder:<init>	()V
    //   459: astore 9
    //   461: aload 9
    //   463: bipush 35
    //   465: invokevirtual 970	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 9
    //   471: aload 35
    //   473: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 9
    //   479: invokevirtual 772	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: astore 9
    //   484: goto +3 -> 487
    //   487: aload_2
    //   488: ldc_w 972
    //   491: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   494: checkcast 141	java/lang/String
    //   497: astore 36
    //   499: aload_2
    //   500: ldc_w 974
    //   503: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   506: checkcast 141	java/lang/String
    //   509: astore 37
    //   511: new 165	android/os/Bundle
    //   514: dup
    //   515: invokespecial 238	android/os/Bundle:<init>	()V
    //   518: astore 35
    //   520: aload 35
    //   522: ldc_w 976
    //   525: ldc 242
    //   527: aload_2
    //   528: ldc_w 978
    //   531: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   534: checkcast 141	java/lang/String
    //   537: invokestatic 248	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   540: invokevirtual 175	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   543: ldc 242
    //   545: aload_2
    //   546: ldc_w 980
    //   549: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   552: checkcast 141	java/lang/String
    //   555: invokestatic 248	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   558: ifeq +12 -> 570
    //   561: aload 35
    //   563: ldc_w 982
    //   566: iconst_1
    //   567: invokevirtual 175	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   570: aload 34
    //   572: checkcast 151	java/lang/CharSequence
    //   575: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   578: ifne +73 -> 651
    //   581: new 466	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData
    //   584: dup
    //   585: invokespecial 467	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:<init>	()V
    //   588: astore 40
    //   590: aload 40
    //   592: aload 34
    //   594: putfield 469	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   597: aload 40
    //   599: aload 8
    //   601: putfield 472	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   604: aload 40
    //   606: ldc 242
    //   608: aload 38
    //   610: invokestatic 248	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   613: putfield 479	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_a_of_type_Boolean	Z
    //   616: aload 40
    //   618: ldc_w 474
    //   621: aload 39
    //   623: invokestatic 248	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   626: putfield 477	com/tencent/mobileqq/kandian/biz/comment/entity/AnchorData:jdField_b_of_type_Boolean	Z
    //   629: aload 35
    //   631: ldc_w 982
    //   634: iconst_1
    //   635: invokevirtual 175	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   638: aload 35
    //   640: ldc_w 984
    //   643: aload 40
    //   645: checkcast 366	android/os/Parcelable
    //   648: invokevirtual 988	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   651: aload 35
    //   653: ldc 240
    //   655: ldc 242
    //   657: aload_2
    //   658: ldc 244
    //   660: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   663: checkcast 141	java/lang/String
    //   666: invokestatic 248	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   669: invokevirtual 175	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   672: aload 11
    //   674: ifnull +526 -> 1200
    //   677: aload 11
    //   679: ldc_w 310
    //   682: invokestatic 316	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   685: astore 8
    //   687: goto +3 -> 690
    //   690: aload 10
    //   692: ifnull +515 -> 1207
    //   695: aload 10
    //   697: ldc_w 310
    //   700: invokestatic 316	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   703: astore 10
    //   705: goto +3 -> 708
    //   708: iconst_0
    //   709: istore_3
    //   710: aload 18
    //   712: iconst_0
    //   713: invokestatic 992	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:a	(Ljava/lang/String;I)I
    //   716: istore 4
    //   718: aload 19
    //   720: iconst_0
    //   721: invokestatic 992	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:a	(Ljava/lang/String;I)I
    //   724: istore 5
    //   726: aload 20
    //   728: iconst_0
    //   729: invokestatic 992	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:a	(Ljava/lang/String;I)I
    //   732: istore 6
    //   734: aload 21
    //   736: iconst_0
    //   737: invokestatic 992	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:a	(Ljava/lang/String;I)I
    //   740: istore 7
    //   742: aload 22
    //   744: ifnull +469 -> 1213
    //   747: aload 22
    //   749: checkcast 151	java/lang/CharSequence
    //   752: invokeinterface 155 1 0
    //   757: ifle +5 -> 762
    //   760: iconst_1
    //   761: istore_3
    //   762: iload_3
    //   763: iconst_1
    //   764: if_icmpne +449 -> 1213
    //   767: ldc 207
    //   769: aload 22
    //   771: iconst_1
    //   772: invokestatic 213	kotlin/text/StringsKt:equals	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   775: ifeq +9 -> 784
    //   778: bipush 10
    //   780: istore_3
    //   781: goto +429 -> 1210
    //   784: aload 22
    //   786: invokestatic 163	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   789: istore_3
    //   790: goto +420 -> 1210
    //   793: aload 35
    //   795: ldc_w 994
    //   798: aload 23
    //   800: invokestatic 997	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:b	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    //   803: aload 35
    //   805: ldc_w 999
    //   808: aload 24
    //   810: invokestatic 1001	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload 35
    //   815: ldc_w 1003
    //   818: aload 25
    //   820: invokestatic 997	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:b	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    //   823: aload 35
    //   825: ldc_w 1005
    //   828: aload 26
    //   830: invokestatic 1001	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    //   833: aload 27
    //   835: checkcast 151	java/lang/CharSequence
    //   838: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   841: ifne +13 -> 854
    //   844: aload 35
    //   846: ldc_w 1007
    //   849: aload 27
    //   851: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: aload 28
    //   856: checkcast 151	java/lang/CharSequence
    //   859: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   862: ifne +13 -> 875
    //   865: aload 35
    //   867: ldc_w 1013
    //   870: aload 28
    //   872: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: aload 35
    //   877: ldc_w 1015
    //   880: aload 29
    //   882: invokestatic 997	com/tencent/mobileqq/kandian/base/utils/RIJNumericUtils:b	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    //   885: iload_3
    //   886: bipush 31
    //   888: if_icmpne +13 -> 901
    //   891: aload 35
    //   893: ldc_w 1017
    //   896: bipush 7
    //   898: invokevirtual 169	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   901: aload 31
    //   903: checkcast 151	java/lang/CharSequence
    //   906: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   909: ifne +13 -> 922
    //   912: aload 35
    //   914: ldc_w 1019
    //   917: aload 31
    //   919: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   922: aload 32
    //   924: checkcast 151	java/lang/CharSequence
    //   927: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   930: ifne +13 -> 943
    //   933: aload 35
    //   935: ldc_w 1021
    //   938: aload 32
    //   940: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   943: aload 33
    //   945: checkcast 151	java/lang/CharSequence
    //   948: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   951: ifne +13 -> 964
    //   954: aload 35
    //   956: ldc_w 1023
    //   959: aload 33
    //   961: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: aload 12
    //   966: checkcast 151	java/lang/CharSequence
    //   969: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifne +13 -> 985
    //   975: aload 35
    //   977: ldc_w 1025
    //   980: aload 12
    //   982: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   985: ldc_w 640
    //   988: invokestatic 646	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   991: checkcast 640	com/tencent/mobileqq/kandian/biz/common/api/IReadInJoyHelper
    //   994: iload_3
    //   995: invokeinterface 1029 2 0
    //   1000: ifeq +13 -> 1013
    //   1003: aload 35
    //   1005: ldc_w 1031
    //   1008: bipush 7
    //   1010: invokevirtual 169	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1013: aload 9
    //   1015: checkcast 151	java/lang/CharSequence
    //   1018: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1021: ifne +13 -> 1034
    //   1024: aload 35
    //   1026: ldc_w 1033
    //   1029: aload 9
    //   1031: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1034: aload 37
    //   1036: checkcast 151	java/lang/CharSequence
    //   1039: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1042: ifne +13 -> 1055
    //   1045: aload 35
    //   1047: ldc_w 1035
    //   1050: aload 37
    //   1052: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1055: aload 36
    //   1057: checkcast 151	java/lang/CharSequence
    //   1060: invokestatic 205	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1063: ifne +13 -> 1076
    //   1066: aload 35
    //   1068: ldc_w 1037
    //   1071: aload 36
    //   1073: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1076: aload_0
    //   1077: aload_2
    //   1078: aload 35
    //   1080: invokespecial 1039	com/tencent/mobileqq/kandian/biz/framework/api/impl/ReadInJoyActivityHelperImpl:handleMenuDataParse	(Ljava/util/HashMap;Landroid/os/Bundle;)V
    //   1083: aload 35
    //   1085: ldc_w 1041
    //   1088: aload 30
    //   1090: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1093: aload 35
    //   1095: ldc_w 1043
    //   1098: aload_2
    //   1099: ldc_w 1043
    //   1102: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1105: checkcast 141	java/lang/String
    //   1108: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: aload 35
    //   1113: ldc_w 1045
    //   1116: aload_2
    //   1117: ldc_w 1045
    //   1120: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: checkcast 141	java/lang/String
    //   1126: invokevirtual 1011	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1129: aload_1
    //   1130: checkcast 623	android/app/Activity
    //   1133: checkcast 563	android/content/Context
    //   1136: astore_1
    //   1137: aload_1
    //   1138: aload 35
    //   1140: iload_3
    //   1141: aload 13
    //   1143: iload 4
    //   1145: aload 14
    //   1147: iload 5
    //   1149: iload 6
    //   1151: iload 7
    //   1153: aload 15
    //   1155: aload 10
    //   1157: aload 8
    //   1159: aload 17
    //   1161: aload 16
    //   1163: lconst_0
    //   1164: iconst_0
    //   1165: lconst_0
    //   1166: iconst_0
    //   1167: aconst_null
    //   1168: aconst_null
    //   1169: aconst_null
    //   1170: aconst_null
    //   1171: aconst_null
    //   1172: invokestatic 1048	com/tencent/mobileqq/kandian/biz/playfeeds/VideoFeedsHelper:a	(Landroid/content/Context;Landroid/os/Bundle;ILjava/lang/String;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1175: return
    //   1176: astore_1
    //   1177: goto +8 -> 1185
    //   1180: astore_1
    //   1181: goto +4 -> 1185
    //   1184: astore_1
    //   1185: ldc 108
    //   1187: iconst_1
    //   1188: ldc_w 1050
    //   1191: aload_1
    //   1192: checkcast 185	java/lang/Throwable
    //   1195: invokestatic 191	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1198: return
    //   1199: return
    //   1200: aload 11
    //   1202: astore 8
    //   1204: goto -514 -> 690
    //   1207: goto -499 -> 708
    //   1210: goto -417 -> 793
    //   1213: iconst_m1
    //   1214: istore_3
    //   1215: goto -422 -> 793
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1218	0	this	ReadInJoyActivityHelperImpl
    //   0	1218	1	paramContext	Context
    //   0	1218	2	paramHashMap	HashMap<String, String>
    //   709	506	3	i	int
    //   716	428	4	j	int
    //   724	424	5	k	int
    //   732	418	6	m	int
    //   740	412	7	n	int
    //   203	1000	8	str1	String
    //   439	591	9	localObject1	Object
    //   132	1024	10	str2	String
    //   144	1057	11	str3	String
    //   433	548	12	str4	String
    //   48	1094	13	str5	String
    //   72	1074	14	str6	String
    //   120	1034	15	str7	String
    //   156	1006	16	str8	String
    //   168	992	17	str9	String
    //   60	651	18	str10	String
    //   84	635	19	str11	String
    //   96	631	20	str12	String
    //   108	627	21	str13	String
    //   179	606	22	str14	String
    //   289	510	23	str15	String
    //   301	508	24	str16	String
    //   313	506	25	str17	String
    //   325	504	26	str18	String
    //   337	513	27	str19	String
    //   349	522	28	str20	String
    //   361	520	29	str21	String
    //   373	716	30	str22	String
    //   385	533	31	str23	String
    //   397	542	32	str24	String
    //   409	551	33	str25	String
    //   191	402	34	str26	String
    //   421	718	35	localObject2	Object
    //   497	575	36	str27	String
    //   509	542	37	str28	String
    //   265	344	38	str29	String
    //   277	345	39	str30	String
    //   588	56	40	localAnchorData	AnchorData
    // Exception table:
    //   from	to	target	type
    //   1137	1175	1176	java/lang/Exception
    //   1076	1137	1180	java/lang/Exception
    //   677	687	1184	java/lang/Exception
    //   695	705	1184	java/lang/Exception
    //   710	742	1184	java/lang/Exception
    //   747	760	1184	java/lang/Exception
    //   767	778	1184	java/lang/Exception
    //   784	790	1184	java/lang/Exception
    //   793	854	1184	java/lang/Exception
    //   854	875	1184	java/lang/Exception
    //   875	885	1184	java/lang/Exception
    //   891	901	1184	java/lang/Exception
    //   901	922	1184	java/lang/Exception
    //   922	943	1184	java/lang/Exception
    //   943	964	1184	java/lang/Exception
    //   964	985	1184	java/lang/Exception
    //   985	1013	1184	java/lang/Exception
    //   1013	1034	1184	java/lang/Exception
    //   1034	1055	1184	java/lang/Exception
    //   1055	1076	1184	java/lang/Exception
  }
  
  public void openMXFlutterPage(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    RIJFlutterUtils.a(RIJFlutterUtils.a, paramContext, paramHashMap, true, null, 8, null);
  }
  
  public void startApp(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap)
  {
    String str2;
    String str1;
    boolean bool1;
    boolean bool2;
    String str3;
    Object localObject;
    if ((paramContext != null) && (paramHashMap != null))
    {
      str2 = (String)paramHashMap.get("appSchema");
      str1 = (String)paramHashMap.get("appPackageName");
      bool1 = Intrinsics.areEqual("1", (String)paramHashMap.get("isCancelJump"));
      bool2 = PackageUtil.a(paramContext, str1);
      str3 = (String)paramHashMap.get("defaultURL");
      paramHashMap = (String)paramHashMap.get("channelID");
      localObject = (CharSequence)paramHashMap;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject))) {
        paramHashMap = Integer.valueOf(paramHashMap);
      } else {
        paramHashMap = Integer.valueOf(0);
      }
      localObject = new StringBuilder();
      if (!checkAppPackage(str1)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = (Context)new WeakReference(paramContext).get();
        if (paramContext != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(paramContext, "contextWeakReference.get() ?: return");
          str3 = URLDecoder.decode(str3, "utf-8");
          str2 = URLDecoder.decode(str2, "utf-8");
          str2 = PreLoader.a().a(str2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("appSchema:");
          localStringBuilder.append(str2);
          localStringBuilder.append(" appPackageName:");
          localStringBuilder.append(str1);
          localStringBuilder.append(" defaultUrl:");
          localStringBuilder.append(str3);
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          if (bool2)
          {
            Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "channelID");
            i = paramHashMap.intValue();
          }
          try
          {
            launchApp(paramContext, str2, i, str3, bool1);
            continue;
            if (!Achilles.a(str1, true))
            {
              RIJJumpUtils.b(paramContext, str3);
              if (!bool1) {
                break label463;
              }
              i = 1;
              RIJFrameworkReportManager.a(str2, 2, i);
            }
            paramContext = new StringBuilder();
            paramContext.append("hasInstalled:");
            paramContext.append(bool2);
            paramContext.append(" configSwitch:");
            paramContext.append(0);
            ((StringBuilder)localObject).append(paramContext.toString());
          }
          catch (Exception paramContext)
          {
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append(" startApp error:");
        paramHashMap.append(paramContext);
        ((StringBuilder)localObject).append(paramHashMap.toString());
        paramContext = new StringBuilder();
        paramContext.append(" hasInstalled:");
        paramContext.append(bool2);
        ((StringBuilder)localObject).append(paramContext.toString());
        QLog.e("ReadInJoyActivityHelper", 1, ((StringBuilder)localObject).toString());
        return;
      }
      return;
      label463:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelperImpl
 * JD-Core Version:    0.7.0.1
 */