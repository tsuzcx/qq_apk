package com.tencent.mobileqq.kandian.glue.report;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.base.image.AggregateAvatarUrlDrawable;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJNoDifferenceJumpAppAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.FeedsSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;

public class RIJTransMergeKanDianReport
{
  public static int a = -1;
  public static boolean b = false;
  
  public static int a(Long paramLong)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localQQAppInterface == null) {
      return 0;
    }
    return TextUtils.isEmpty(((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(paramLong)) ^ true;
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 == null) {
      return paramDrawable;
    }
    localObject1 = ((QQMessageFacade)localObject1).r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localObject1 != null)
    {
      if (((MessageRecord)localObject1).isread) {
        return paramDrawable;
      }
      QLog.d("RIJTransMergeKanDianReport", 2, "getSpecAggregateAvatarForKandian run !");
    }
    for (;;)
    {
      try
      {
        Object localObject3 = BaseApplicationImpl.getApplication().getResources();
        Object localObject4 = new JSONObject(((MessageRecord)localObject1).extStr);
        boolean bool = false;
        if (!((JSONObject)localObject4).has("kdUin")) {
          break label529;
        }
        localObject1 = ((JSONObject)localObject4).getString("kdUin");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("got tipUin from kdUin: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("RIJTransMergeKanDianReport", 2, ((StringBuilder)localObject2).toString());
        if (!((JSONObject)localObject4).has("kdDefaultSourceAvatarUrl")) {
          break label534;
        }
        localObject2 = ((JSONObject)localObject4).getString("kdDefaultSourceAvatarUrl");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("got defaultAvatarUrl from kdDefaultSourceAvatarUrl: ");
        localStringBuilder.append((String)localObject2);
        QLog.d("RIJTransMergeKanDianReport", 2, localStringBuilder.toString());
        if (((JSONObject)localObject4).has("kdShouldShowMergedAvatar"))
        {
          bool = ((JSONObject)localObject4).getBoolean("kdShouldShowMergedAvatar");
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("got shouldShowMergedAvatar from kdShouldShowMergedAvatar: ");
          ((StringBuilder)localObject4).append(bool);
          QLog.d("RIJTransMergeKanDianReport", 2, ((StringBuilder)localObject4).toString());
        }
        if (!bool)
        {
          QLog.d("RIJTransMergeKanDianReport", 2, "shouldn't show merged icon, give up");
          return paramDrawable;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("kd_");
          ((StringBuilder)localObject2).append((String)localObject1);
          paramQQAppInterface = paramQQAppInterface.getFaceBitmapCacheKey(1, ((StringBuilder)localObject2).toString(), (byte)3, 0, 100, true);
          localObject2 = (AggregateAvatarUrlDrawable)CommonImageCacheHelper.b(paramQQAppInterface);
          if (localObject2 != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getMergeIcon From cache ! key : ");
            ((StringBuilder)localObject3).append(paramQQAppInterface);
            ((StringBuilder)localObject3).append(", tipUin : ");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d("RIJTransMergeKanDianReport", 2, ((StringBuilder)localObject3).toString());
            return localObject2;
          }
          localObject2 = ImageUtil.a(paramDrawable);
          if (localObject2 == null) {
            return paramDrawable;
          }
          localObject2 = new AggregateAvatarUrlDrawable((Bitmap)localObject2, AIOUtils.b(50.0F, (Resources)localObject3), (Resources)localObject3, (String)localObject1, 1);
          a((String)localObject1, (AggregateAvatarUrlDrawable)localObject2);
          CommonImageCacheHelper.a(paramQQAppInterface, (Sizeable)localObject2);
          return localObject2;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramQQAppInterface = ImageUtil.a(paramDrawable);
          if (paramQQAppInterface == null) {
            return paramDrawable;
          }
          paramQQAppInterface = new AggregateAvatarUrlDrawable(paramQQAppInterface, (String)localObject2, AIOUtils.b(50.0F, (Resources)localObject3), (Resources)localObject3, 1);
          return paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get merge icon has error : ");
        ((StringBuilder)localObject1).append(paramQQAppInterface);
        QLog.d("RIJTransMergeKanDianReport", 2, ((StringBuilder)localObject1).toString());
        return paramDrawable;
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get merge icon has error : ");
        ((StringBuilder)localObject1).append(paramQQAppInterface);
        QLog.d("RIJTransMergeKanDianReport", 2, ((StringBuilder)localObject1).toString());
      }
      return paramDrawable;
      label529:
      localObject1 = null;
      continue;
      label534:
      Object localObject2 = null;
    }
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    try
    {
      paramString1 = localReportR5Builder.addAlgorithmId(paramLong).addFolderStatus().addTime().addFeedsType(paramInt2).addChannelId(paramInt1).addNetworkType().addFeedSources(paramString1).addIMEI().addIMSI().addRowkey(paramString2).addNumber(paramInt3).addWords(paramInt4).addLikes(paramInt5).addComments(paramInt6).addBiu(paramInt7).addRedStyle().addKandianMode().addKandianModeNew().addTabSource();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localReportR5Builder;
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    for (;;)
    {
      try
      {
        RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2 = localReportR5Builder1.addFolderStatus().addTime().addChannelId(paramInt1).addKandianMode().addKandianModeNew().addTabSource().addSessionId().addSkinId(paramString).addSkinVoice(paramInt2).addRefreshCategory(paramInt3).addAntiCheat();
        if (!paramBoolean) {
          break label109;
        }
        paramString = "1";
        localReportR5Builder2.addString("refresh_way", paramString).addOS().addVersion();
        if (paramInt4 != -1)
        {
          localReportR5Builder1.addString("pull_image", String.valueOf(paramInt4));
          return localReportR5Builder1;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return localReportR5Builder1;
      label109:
      paramString = "2";
    }
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        int j = ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime());
        i = 1;
        if (j == 1)
        {
          ((JSONObject)localObject).put("reddot_style", i);
          ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.b());
          ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.c());
          ((JSONObject)localObject).put("tab_source", b());
          ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
          localObject = ((JSONObject)localObject).toString();
          return localObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      int i = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
      ((JSONObject)localObject).put("failed_reason", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(b());
    }
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("source", str);
      localJSONObject.put("feeds_type", paramInt3);
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      boolean bool = TextUtils.isEmpty(paramString2);
      if (!bool) {
        localJSONObject.put("rowkey", paramString2);
      } else {
        localJSONObject.put("rowkey", "0");
      }
      localJSONObject.put("pic_number", paramInt1);
      if (paramInt2 > 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(paramInt2);
        localJSONObject.put("pic_position", paramString1.toString());
      }
      if (paramAbsBaseArticleInfo != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("algorithm_id", paramString1.toString());
      }
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJTransMergeKanDianReport", 2, "transGridImageClickR5 json exception.");
      }
      paramString1.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(b());
    }
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      boolean bool = TextUtils.isEmpty(paramString3);
      if (!bool) {
        localJSONObject.put("feeds_source", paramString3);
      } else {
        localJSONObject.put("feeds_source", "0");
      }
      localJSONObject.put("feeds_type", paramInt3);
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      localJSONObject.put("source", str);
      bool = TextUtils.isEmpty(paramString2);
      if (!bool) {
        localJSONObject.put("rowkey", paramString2);
      } else {
        localJSONObject.put("rowkey", "0");
      }
      localJSONObject.put("pic_number", paramInt1);
      if (paramInt2 > 0)
      {
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(paramInt2);
        localJSONObject.put("pic_position", paramString1.toString());
      }
      if (paramAbsBaseArticleInfo != null)
      {
        paramString1 = new StringBuilder();
        paramString1.append("");
        paramString1.append(paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("algorithm_id", paramString1.toString());
        localJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
      }
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJTransMergeKanDianReport", 2, "transGridImageClickR5 json exception.");
      }
      paramString1.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramString1 = a(paramLong, paramInt1, paramInt2, paramBoolean, paramString1, paramString3, paramString4, paramInt5, b(), paramAbsBaseArticleInfo).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, 0, paramAbsBaseArticleInfo);
  }
  
  public static String a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean2, int paramInt9, int paramInt10, int paramInt11)
  {
    paramString2 = a(paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramString1, paramString2, paramString3, paramString4, paramAbsBaseArticleInfo);
    paramString1 = paramString2;
    for (;;)
    {
      try
      {
        paramString4 = new JSONObject(paramString2);
        paramString1 = paramString2;
        paramString4.put("kandian_mode", paramInt7);
        paramString1 = paramString2;
        paramString4.put("kandian_mode_new", VideoReporter.c());
        paramString1 = paramString2;
        paramString4.put("tab_source", paramInt6);
        paramString1 = paramString2;
        RIJJsonUtils.a(paramString4, "entry_path", paramInt11);
        paramString1 = paramString2;
        RIJJsonUtils.a(paramString4, "behavior_type", paramInt5);
        paramString1 = paramString2;
        RIJJsonUtils.a(paramString4, "stay_duration", paramLong2);
        paramString1 = paramString2;
        paramString4.put("video_inserted", paramBoolean2);
        paramString1 = paramString2;
        paramString4.put("video_strategyid", paramInt8);
        paramString1 = paramString2;
        paramString4.put("proteus_bid", RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"));
        paramString1 = paramString2;
        paramString4.put("ads_jump", paramInt9);
        paramString1 = paramString2;
        paramString4.put("ads_source", paramInt10);
        paramString1 = paramString2;
        paramString4.put("star_logo", RIJFeedsType.h(paramAbsBaseArticleInfo));
        paramString1 = paramString2;
        if (CUKingCardUtils.a() != 1) {
          break label737;
        }
        paramString3 = "1";
        paramString1 = paramString2;
        paramString4.put("simCardType", paramString3);
        paramString1 = paramString2;
        if (paramAbsBaseArticleInfo == null) {
          break label734;
        }
        paramString1 = paramString2;
        paramBoolean1 = DailyModeConfigHandler.c(paramInt2);
        paramString1 = paramString2;
        paramString3 = new StringBuilder();
        paramString1 = paramString2;
        paramString3.append("readinjoy_daily_article_first_exposure_");
        paramString1 = paramString2;
        paramString3.append(paramAbsBaseArticleInfo.mArticleID);
        paramString1 = paramString2;
        RIJJsonUtils.a(paramString4, "daily_article_first_timestamp", ((Long)RIJSPUtils.b(paramString3.toString(), Long.valueOf(0L))).longValue(), paramBoolean1);
        paramString1 = paramString2;
        paramBoolean1 = paramAbsBaseArticleInfo.isShowGif;
        paramInt2 = 0;
        if (!paramBoolean1) {
          break label745;
        }
        paramInt1 = 1;
        paramString1 = paramString2;
        paramString4.put("short_content_gif", paramInt1);
        paramString1 = paramString2;
        paramString4.put("account_expose_card", c(paramAbsBaseArticleInfo));
        paramString1 = paramString2;
        paramString4.put("picture_click_jumptype", Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
        paramString1 = paramString2;
        if (paramAbsBaseArticleInfo.mChannelID != 0L) {
          break label750;
        }
        paramString1 = paramString2;
        if (!RIJBaseItemViewType.b(paramAbsBaseArticleInfo)) {
          break label750;
        }
        paramBoolean1 = true;
        paramString1 = paramString2;
        if (paramAbsBaseArticleInfo.mCommentCount > 100L) {
          break label761;
        }
        paramString1 = paramString2;
        if (paramAbsBaseArticleInfo.mVideoCommentCount <= 100) {
          break label756;
        }
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString1 = paramString2;
      RIJJsonUtils.b(paramString4, "comment_exposure", paramInt1, paramBoolean1);
      paramString1 = paramString2;
      a(paramString4);
      paramString1 = paramString2;
      RIJJsonUtils.b(paramString4, "jump_src", UGRuleManager.g(paramAbsBaseArticleInfo), UGRuleManager.c(paramAbsBaseArticleInfo));
      paramString1 = paramString2;
      RIJJsonUtils.a(paramString4, "short_content_size", ComponentPGCShortContentBig.g, paramAbsBaseArticleInfo.isPGCShortContent());
      paramInt1 = paramInt2;
      paramString1 = paramString2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        paramInt1 = paramInt2;
        paramString1 = paramString2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.N != null)
        {
          paramInt1 = paramInt2;
          paramString1 = paramString2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.N.uint32_is_topic.has()) {
            paramInt1 = 1;
          }
        }
      }
      paramString1 = paramString2;
      paramString4.put("istopic", paramInt1);
      paramString1 = paramString2;
      paramString4.put("default_feeds_aladdin_keys", ((String)RIJSPUtils.b("default_feeds_aladdin_keys", "")).replace("|", "_"));
      paramString1 = paramString2;
      paramString2 = paramString4.toString();
      paramString1 = paramString2;
      paramString2 = new VideoR5.Builder(paramString2).c(paramAbsBaseArticleInfo).d(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo.videoReportInfo).a(paramAbsBaseArticleInfo, true).b().a();
      return paramString2;
      label734:
      return paramString1;
      label737:
      paramString3 = "0";
      continue;
      label745:
      paramInt1 = 0;
      continue;
      label750:
      paramBoolean1 = false;
      continue;
      label756:
      paramInt1 = 2;
      continue;
      label761:
      paramInt1 = 1;
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString3)
  {
    paramString1 = a(paramLong, paramInt1, paramInt2, 0, 0, paramBoolean, paramString1, null, paramString2, null, 0, paramAbsBaseArticleInfo);
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString2.put("topicid", paramString3);
      paramString2.put("proteus_bid", RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"));
      return paramString2.toString();
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return a(paramAbsBaseArticleInfo, false);
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("RIJTransMergeKanDianReport", 1, "transMergeKandianReportR5BaseForFastWeb articleInfo is null.");
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", paramAbsBaseArticleInfo.mAlgorithmID);
      localJSONObject.put("puin_type", paramString);
      localJSONObject.put("source", RIJAppSetting.a(paramInt));
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      localJSONObject.put("mp_article_id", paramAbsBaseArticleInfo.mArticleID);
      localJSONObject.put("channel_id", paramInt);
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        a(localJSONObject, paramAbsBaseArticleInfo);
        if (paramBoolean)
        {
          paramAbsBaseArticleInfo = "1";
          localJSONObject.put("fast_biu", paramAbsBaseArticleInfo);
          paramAbsBaseArticleInfo = localJSONObject.toString();
          return paramAbsBaseArticleInfo;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        return "";
      }
      paramAbsBaseArticleInfo = "0";
    }
  }
  
  public static String a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("feeds_friends_interaction", paramInt);
      localJSONObject.put("session_id", RIJKanDianFolderStatus.reportSessionId);
      localJSONObject.put("os", "1");
      localJSONObject.put("version", "8.8.17".replace(".", ""));
      localJSONObject.put("rowkey", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null))
    {
      if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.isEmpty()) {
        return "";
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localJSONObject.put("feeds_source", ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0)).a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(RIJFeedsType.g(paramAbsBaseArticleInfo));
        localJSONObject.put("feeds_type", localStringBuilder.toString());
        localJSONObject.put("entry_mode", paramString);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(RIJAppSetting.b());
        localJSONObject.put("kandian_mode", paramString.toString());
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(b());
        localJSONObject.put("tab_source", paramString.toString());
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        localJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("algorithm_id", paramString.toString());
        paramString = localJSONObject.toString();
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return "";
      }
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        boolean bool = RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo);
        if (bool) {
          localJSONObject.put("feeds_source", paramAbsBaseArticleInfo.mSubscribeID);
        } else {
          localJSONObject.put("feeds_source", ((SocializeFeedsInfo)localObject).c.a);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(RIJFeedsType.g(paramAbsBaseArticleInfo));
        localJSONObject.put("feeds_type", ((StringBuilder)localObject).toString());
        localJSONObject.put("entry_mode", paramString);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(RIJAppSetting.b());
        localJSONObject.put("kandian_mode", paramString.toString());
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(b());
        localJSONObject.put("tab_source", paramString.toString());
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        localJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("algorithm_id", paramString.toString());
        localJSONObject.put("enter_uin", paramLong);
        localJSONObject.put("kandian_mode_new", VideoReporter.c());
        paramString = localJSONObject.toString();
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "", "", false);
  }
  
  public static String a(String paramString1, String paramString2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      localJSONObject.put("tab_source", b());
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", RIJFeedsType.g(paramAbsBaseArticleInfo));
      localJSONObject.put("topicId", paramString2);
      localJSONObject.put("proteus_bid", RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"));
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localJSONObject.put("time", System.currentTimeMillis());
        localJSONObject.put("algorithm_id", paramString1);
        localJSONObject.put("session_id", RIJKanDianFolderStatus.reportSessionId);
        int j = 0;
        if (paramBoolean)
        {
          i = 1;
          localJSONObject.put("avatar", i);
          localJSONObject.put("kd_pos", RIJKanDianFolderStatus.reportLastRedPntPosition);
          if (!TextUtils.isEmpty(paramString3)) {
            localJSONObject.put("stick", paramString3);
          }
          if (RIJKanDianFolderStatus.reportFolderStatus == 6)
          {
            localJSONObject.put("id", paramString2);
            localJSONObject.put("social_uin", paramString4);
          }
          if (!f()) {
            break label252;
          }
          i = 1;
          localJSONObject.put("message_status", i);
          if (ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label258;
          }
          i = 1;
          localJSONObject.put("reddot_style", i);
          i = j;
          if (FeedsSPUtils.a(RIJQQAppInterfaceUtil.e())) {
            i = 1;
          }
          localJSONObject.put("hemera_switch", i);
          localJSONObject.put("kandian_mode_new", VideoReporter.c());
          paramString1 = localJSONObject.toString();
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
      int i = 0;
      continue;
      label252:
      i = 0;
      continue;
      label258:
      i = 0;
    }
  }
  
  public static JSONObject a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, int paramInt4, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = "1";
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = VideoReporter.a;
        if (localObject == null) {
          VideoReporter.a = "8.8.17".replace(".", "");
        }
        int k = ReadInJoyBaseFragment.c(paramInt2);
        boolean bool = a(BaseApplicationImpl.getApplication().getApplicationContext(), paramAbsBaseArticleInfo);
        int j = RIJNoDifferenceJumpAppAladdinConfig.a();
        localObject = new ReportR5WithTimeBuilder().a(paramLong).a(RIJKanDianFolderStatus.getFolderStatus(paramInt2)).a(paramInt1).a().b(paramInt2);
        int i = 1;
        if (paramBoolean)
        {
          paramInt1 = 2;
          paramString1 = ((ReportR5WithTimeBuilder)localObject).c(paramInt1).b(paramString1).c(RIJDeviceUtil.a()).d(RIJDeviceUtil.b()).e(RIJKanDianFolderStatus.reportSessionId).I(paramInt2).b(paramInt2, paramAbsBaseArticleInfo).g(paramString2).h(paramString3).b(paramAbsBaseArticleInfo, RIJFeedsType.f(paramAbsBaseArticleInfo));
          if (ReadInJoyHelper.ah(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label765;
          }
          paramInt1 = 1;
          paramString1 = paramString1.d(paramInt1).a(RIJFeedsType.g(paramAbsBaseArticleInfo)).e(RIJAppSetting.b()).f(VideoReporter.c()).g(paramInt4).h(paramInt3).u(paramAbsBaseArticleInfo);
          if (!FeedsSPUtils.a(RIJQQAppInterfaceUtil.e())) {
            break label770;
          }
          paramInt1 = 1;
          paramString2 = paramString1.j(paramInt1).i(RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid")).d().k(RIJFeedsType.h(paramAbsBaseArticleInfo)).t(paramAbsBaseArticleInfo).b(ReportR5WithTimeBuilder.r(paramAbsBaseArticleInfo)).m(VideoReporter.a).n("1").H(paramInt2).a(RIJQQAppInterfaceUtil.c(), paramString2, paramAbsBaseArticleInfo).b();
          if (CUKingCardUtils.a() != 1) {
            break label775;
          }
          paramString1 = str;
          paramString1 = paramString2.q(paramString1).q(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, RIJBaseItemViewType.b(paramAbsBaseArticleInfo)).p(paramAbsBaseArticleInfo).n(k).o(paramAbsBaseArticleInfo).G(paramInt2);
          if (!RIJSocialBottomViewAladdinConfig.a()) {
            break label783;
          }
          paramInt1 = 1;
          paramString1 = paramString1.o(paramInt1).n(paramAbsBaseArticleInfo);
          paramString2 = new StringBuilder();
          paramString2.append("");
          paramString2.append(paramAbsBaseArticleInfo.isSuperTop);
          paramString2 = paramString1.s(paramString2.toString());
          if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mReportCommonData)) {
            break label788;
          }
          paramString1 = paramAbsBaseArticleInfo.mReportCommonData;
          paramString2 = paramString2.B(paramString1);
          if (TextUtils.isEmpty(Build.BRAND)) {
            break label796;
          }
          paramString1 = Build.BRAND;
          paramString2 = paramString2.t(paramString1);
          if (TextUtils.isEmpty(Build.MODEL)) {
            break label804;
          }
          paramString1 = Build.MODEL;
          paramString1 = paramString2.u(paramString1).m(paramAbsBaseArticleInfo).t(c(paramAbsBaseArticleInfo)).l(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, bool, j).a(paramInt2, paramAbsBaseArticleInfo).F(paramInt2).j(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).h(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo);
          if (!b) {
            break label812;
          }
          paramInt1 = 1;
          paramString1 = paramString1.z(paramInt1).f(paramAbsBaseArticleInfo).e(paramAbsBaseArticleInfo).c("default_feeds_aladdin_keys", (String)RIJSPUtils.b("default_feeds_aladdin_keys", "")).a(paramAbsBaseArticleInfo, a(Long.valueOf(paramAbsBaseArticleInfo.mArticleID))).d(paramAbsBaseArticleInfo);
          if (!paramAbsBaseArticleInfo.hasWalletIcon) {
            break label817;
          }
          paramInt1 = i;
          paramString1 = paramString1.C(paramInt1).a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).c(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).c();
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("transMergeKandianReportR5WithTime error r5: ");
        paramString2.append(localJSONObject.toString());
        paramString2.append(" error: ");
        paramString2.append(paramString1.getMessage());
        QLog.e("RIJTransMergeKanDianReport", 2, paramString2.toString());
        return localJSONObject;
      }
      paramInt1 = 1;
      continue;
      label765:
      paramInt1 = 0;
      continue;
      label770:
      paramInt1 = 0;
      continue;
      label775:
      paramString1 = "0";
      continue;
      label783:
      paramInt1 = 0;
      continue;
      label788:
      paramString1 = "";
      continue;
      label796:
      paramString1 = "";
      continue;
      label804:
      paramString1 = "";
      continue;
      label812:
      paramInt1 = 0;
      continue;
      label817:
      paramInt1 = 0;
    }
  }
  
  public static JSONObject a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("puin_type", paramString);
        localJSONObject.put("feeds_type", RIJFeedsType.g(paramAbsBaseArticleInfo));
        localJSONObject.put("source", RIJAppSetting.a(paramInt));
        localJSONObject.put("is_fans", e(paramAbsBaseArticleInfo));
        localJSONObject.put("kandian_mode", RIJAppSetting.b());
        localJSONObject.put("session_id", RIJKanDianFolderStatus.reportSessionId);
        localJSONObject.put("mp_article_id", paramAbsBaseArticleInfo.mArticleID);
        localJSONObject.put("channel_id", paramInt);
        if (NetworkUtil.isWifiConnected(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.8.17".replace(".", ""));
          localJSONObject.put("imei", RIJDeviceUtil.a());
          localJSONObject.put("imsi", RIJDeviceUtil.b());
          boolean bool = RIJFeedsType.f(paramAbsBaseArticleInfo);
          if (bool)
          {
            localJSONObject.put("likes", paramAbsBaseArticleInfo.mSocialFeedInfo.h);
            localJSONObject.put("biu", paramAbsBaseArticleInfo.mSocialFeedInfo.l);
            return localJSONObject;
          }
          localJSONObject.put("likes", 0);
          localJSONObject.put("biu", 0);
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
      paramInt = 2;
    }
  }
  
  public static JSONObject a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramString);
    try
    {
      paramContext.put("biu_state", paramInt2);
      return paramContext;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    return paramContext;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hotword", paramString1);
      localJSONObject.put("rowKey", paramString2);
      localJSONObject.put("hotword_number", paramInt);
      localJSONObject.put("jump_type", 0);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      label46:
      break label46;
    }
    paramString1 = new StringBuilder();
    paramString1.append("transMergeKandianPeportR5WithTime, hotword = , rowKey = ");
    paramString1.append(paramString2);
    paramString1.append(", hotword_number = ");
    paramString1.append(paramInt);
    paramString1.append(", jump_type = ");
    paramString1.append(0);
    QLog.e("RIJTransMergeKanDianReport", 1, paramString1.toString());
    return localJSONObject;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("comment_level", String.valueOf(paramInt1));
      ((JSONObject)localObject).put("entry", String.valueOf(paramInt2));
      ((JSONObject)localObject).put("action_type", String.valueOf(paramInt3));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localObject = ((JSONObject)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    if (localQQAppInterface == null) {
      return;
    }
    PublicAccountReportUtils.a(localQQAppInterface, localQQAppInterface.getAccount(), "0X800B9F3", "0X800B9F3", 0, 0, "", "", "", (String)localObject, false);
  }
  
  public static void a(String paramString)
  {
    String str = h().toString();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("eid", paramString);
    localHashMap.put("touin", localQQAppInterface.getAccount());
    localHashMap.put("r5", str);
    VideoReport.reportEvent("clck", localHashMap);
  }
  
  private static void a(String paramString, AggregateAvatarUrlDrawable paramAggregateAvatarUrlDrawable)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 0L)
      {
        paramString = ReadInJoyUserInfoModule.a(l, new RIJTransMergeKanDianReport.1(l, paramAggregateAvatarUrlDrawable));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[AggregateAvatarUrlDrawable] load aggregate avatar from 0xb81 userinfo success, uin:");
        localStringBuilder.append(l);
        QLog.d("RIJTransMergeKanDianReport", 1, localStringBuilder.toString());
        if (paramString != null)
        {
          paramAggregateAvatarUrlDrawable.a(ReadInJoyUserInfoModule.a(paramString));
          return;
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("RIJTransMergeKanDianReport", 2, paramString.getMessage());
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    if ((ChannelCoverInfoModule.g() != -1) && (ChannelCoverInfoModule.g() != 0))
    {
      paramJSONObject.put("mainfeeds_showcase", ChannelCoverInfoModule.g());
      paramJSONObject.put("configchannel_name", ChannelCoverInfoModule.h());
      return;
    }
    paramJSONObject.put("mainfeeds_showcase", 0);
  }
  
  public static void a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
        paramJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        boolean bool = RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo);
        if (bool) {
          paramJSONObject.put("feeds_source", paramAbsBaseArticleInfo.mSubscribeID);
        } else if ((localObject != null) && (((SocializeFeedsInfo)localObject).c != null)) {
          paramJSONObject.put("feeds_source", ((SocializeFeedsInfo)localObject).c.a);
        }
        paramJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(RIJFeedsType.g(paramAbsBaseArticleInfo));
        paramJSONObject.put("feeds_type", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(RIJAppSetting.b());
        paramJSONObject.put("kandian_mode", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(b());
        paramJSONObject.put("tab_source", ((StringBuilder)localObject).toString());
        paramJSONObject.put("channel_id", paramAbsBaseArticleInfo.mChannelID);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mAlgorithmID);
        paramJSONObject.put("algorithm_id", ((StringBuilder)localObject).toString());
        if (paramAbsBaseArticleInfo.isPGCShortContent())
        {
          paramAbsBaseArticleInfo = "1";
          paramJSONObject.put("content_source", paramAbsBaseArticleInfo);
          paramJSONObject.put("kandian_mode_new", VideoReporter.c());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      paramAbsBaseArticleInfo = "0";
    }
  }
  
  public static boolean a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str;
    if (paramAbsBaseArticleInfo.mProteusTemplateBean == null) {
      str = "";
    } else {
      str = paramAbsBaseArticleInfo.mProteusTemplateBean.getStyleName();
    }
    return a(paramContext, paramAbsBaseArticleInfo, str);
  }
  
  public static boolean a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo.mChannelID != 0L) && (!DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)))
    {
      paramContext = new StringBuilder();
      paramContext.append("judgeShouldNoDifferenceJumpToApp channelID: ");
      paramContext.append(paramAbsBaseArticleInfo.mChannelID);
      QLog.e("RIJTransMergeKanDianReport", 1, paramContext.toString());
      return false;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(199);
    if (localAladdinConfig == null)
    {
      QLog.e("RIJTransMergeKanDianReport", 1, "judgeShouldNoDifferenceJumpToApp AladdinConfig is empty.");
      return false;
    }
    boolean bool1 = ReadInJoyHelper.P();
    if (!bool1)
    {
      QLog.e("RIJTransMergeKanDianReport", 1, "judgeShouldNoDifferenceJumpToApp is not first no difference jump app today.");
      return false;
    }
    int i = RIJBaseItemViewType.c(paramAbsBaseArticleInfo);
    int j;
    if ((paramAbsBaseArticleInfo.mFeedType == 0) && ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 6))) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((paramAbsBaseArticleInfo.mFeedType == 29) && ((paramString.equalsIgnoreCase("ReadInjoy_daily_small_img_cell")) || (paramString.equalsIgnoreCase("ReadInjoy_daily_triple_img_cell")) || (paramString.equalsIgnoreCase("ReadInjoy_daily_large_img_cell")))) {
      k = 1;
    } else {
      k = 0;
    }
    if (localAladdinConfig.getIntegerFromString("no_difference_jump_app_switch", 0) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((j == 0) && (k == 0)) {
      j = 0;
    } else {
      j = 1;
    }
    boolean bool2 = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleSubscriptText);
    if (paramAbsBaseArticleInfo.isSuperTop == 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)) && ((paramAbsBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi")) || (paramAbsBaseArticleInfo.mArticleContentUrl.contains("target=4")))) {
      m = 1;
    } else {
      m = 0;
    }
    if ((i != 0) && (bool1) && (j != 0) && (bool2) && (k != 0) && (m == 0))
    {
      i = localAladdinConfig.getIntegerFromString("no_difference_jump_app_type", 0);
      paramAbsBaseArticleInfo = localAladdinConfig.getString("no_difference_jump_app_package_name", "");
      if (i == 0) {
        return true;
      }
      if (i == 1) {
        return PackageUtil.a(paramContext, paramAbsBaseArticleInfo) ^ true;
      }
      if (i == 2) {
        return PackageUtil.a(paramContext, paramAbsBaseArticleInfo);
      }
    }
    return false;
  }
  
  public static int b()
  {
    int i = a;
    if (i != -1) {
      return i;
    }
    boolean bool = RIJShowKanDianTabSp.c();
    i = 1;
    BaseActivity localBaseActivity;
    if (bool)
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return -1;
      }
      if ((localBaseActivity instanceof SplashActivity))
      {
        Object localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        if (localObject == null) {
          return -1;
        }
        localObject = (ReadinjoyTabFrame)((FrameHelperActivity)localObject).a(ReadinjoyTabFrame.class);
        if (localObject == null) {
          return -1;
        }
        if (ReadInJoyHelper.v()) {
          return 2;
        }
        int j = ((ReadinjoyTabFrame)localObject).D();
        if (j == 0) {
          return 1;
        }
        if (j == 2) {
          return 3;
        }
        if (j == 1) {
          return 2;
        }
      }
      if ((localBaseActivity instanceof PublicFragmentActivity))
      {
        if ((localBaseActivity.getIntent() != null) && (QLog.isColorLevel())) {
          QLog.d("RIJTransMergeKanDianReport", 2, new Object[] { "ClassName: ", localBaseActivity.getIntent().getStringExtra("public_fragment_class") });
        }
        if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class") != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.mobileqq.kandian.biz.follow.ReadInJoyBBCircleFragment"))) {
          return 3;
        }
        if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class") != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyFragment"))) {
          return 6;
        }
      }
      if (!(localBaseActivity instanceof ReadInJoyNewFeedsActivity)) {}
    }
    for (i = ReadInJoyNewFeedsActivity.g;; i = ReadInJoyNewFeedsActivity.g)
    {
      return i + 1;
      if ((localBaseActivity instanceof ReadInJoyChannelActivity))
      {
        if (localBaseActivity.getIntent().getIntExtra("channel_id", 0) != 56) {
          i = 0;
        }
        if (i != 0) {
          return 2;
        }
      }
      return -1;
    }
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) {}
      StringBuilder localStringBuilder;
      for (Object localObject = paramAbsBaseArticleInfo.mSubscribeID;; localObject = localStringBuilder.toString())
      {
        break;
        localStringBuilder = new StringBuilder();
        localObject = "";
        localStringBuilder.append("");
        if (localSocializeFeedsInfo.c != null) {
          localObject = Long.valueOf(localSocializeFeedsInfo.c.a);
        }
        localStringBuilder.append(localObject);
      }
      int i;
      if (localSocializeFeedsInfo.d != null) {
        i = localSocializeFeedsInfo.d.size();
      } else {
        i = 0;
      }
      boolean bool = TextUtils.isEmpty(localSocializeFeedsInfo.e);
      int j = localSocializeFeedsInfo.h;
      int k = localSocializeFeedsInfo.j;
      int m = localSocializeFeedsInfo.l;
      return a((int)paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo.mAlgorithmID, paramAbsBaseArticleInfo.mFeedType, (String)localObject, paramAbsBaseArticleInfo.innerUniqueID, i + 1, bool ^ true, j, k, m);
    }
    return new RIJTransMergeKanDianReport.ReportR5Builder();
  }
  
  public static String b(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt);
      ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.b());
      ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.c());
      ((JSONObject)localObject).put("tab_source", b());
      ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", VideoReporter.a);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    return a(paramString, "");
  }
  
  public static String b(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      if (paramInt > 0) {
        localJSONObject.put("from", paramInt);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_session_id", paramString2);
      }
      paramString2 = localJSONObject.toString();
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static int c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPartnerAccountInfo != null) && (paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.has())) {
      return paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.get();
    }
    return 0;
  }
  
  public static String c()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localJSONObject.put("kandian_mode", String.valueOf(RIJAppSetting.b()));
        localJSONObject.put("kandian_mode_new", VideoReporter.c());
        localJSONObject.put("session_id", RIJKanDianFolderStatus.reportSessionId);
        if (ArticleInfoModule.b())
        {
          String str1 = "1";
          localJSONObject.put("is_requesting_articles", str1);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", VideoReporter.a);
          localJSONObject.put("type", Aladdin.getConfig(431).getIntegerFromString("msg_ui_style", 0));
          str1 = localJSONObject.toString();
          return str1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      String str2 = "0";
    }
  }
  
  public static String c(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("reddot_num", paramInt);
      ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.b());
      ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID)))
    {
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) {
        return "";
      }
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optString("card_report_params");
        return paramAbsBaseArticleInfo;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("RIJTransMergeKanDianReport", 1, paramAbsBaseArticleInfo, new Object[0]);
      }
    }
    return "";
  }
  
  public static JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("session_id", RIJKanDianFolderStatus.reportSessionId);
      localJSONObject.put("kandian_mode_new", VideoReporter.c());
      localJSONObject.put("algorithm_id", RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("session_id", RIJKanDianFolderStatus.reportSessionId);
      ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.c());
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private static String e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
    int i = 0;
    try
    {
      boolean bool = ((IPublicAccountDataManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(l), true);
      i = bool;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      QLog.e("RIJTransMergeKanDianReport", 2, paramAbsBaseArticleInfo.getMessage());
    }
    if (i != 0) {
      return "1";
    }
    return "2";
  }
  
  public static boolean f()
  {
    if (!RIJQQAppInterfaceUtil.g()) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Conversation)localObject1).K().j();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData)) {
          localArrayList.add((RecentBaseData)localObject2);
        }
      }
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (RecentBaseData)localArrayList.get(i);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN)) && (((RecentUserBaseData)localObject1).getRecentUserType() != 5000))
          {
            int k = ((RecentUserBaseData)localObject1).getUnreadNum();
            if (k > 0) {
              return true;
            }
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("failed to construct recent base ");
      ((StringBuilder)localObject1).append(localException.toString());
      QLog.d("RIJTransMergeKanDianReport", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static RIJTransMergeKanDianReport.ReportR5Builder g()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    try
    {
      localReportR5Builder.addOS();
      localReportR5Builder.addIMEI();
      localReportR5Builder.addIMSI();
      localReportR5Builder.addVersion();
      localReportR5Builder.addNetworkType();
      return localReportR5Builder;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localReportR5Builder;
  }
  
  public static JSONObject h()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      localJSONObject.put("kandian_mode_new", VideoReporter.c());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport
 * JD-Core Version:    0.7.0.1
 */