package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStartStatistic;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.MultiVideoConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJFullVideoPlayActivity
{
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (1 == paramAbsBaseArticleInfo.mVideoType) {
      return 1;
    }
    if (0L == paramAbsBaseArticleInfo.mChannelID) {
      return 1;
    }
    return 9091;
  }
  
  public static Bundle a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, VideoPlayManager paramVideoPlayManager, RIJDataManager paramRIJDataManager)
  {
    Bundle localBundle = new Bundle();
    int i = paramVideoPlayParam.jdField_f_of_type_Int;
    boolean bool2 = true;
    if (i == 1)
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramAbsBaseArticleInfo.mSubscribeID);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.mSubscribeName);
    }
    else if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
    {
      StringBuilder localStringBuilder;
      if (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", localStringBuilder.toString());
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaLangString);
      if (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)) {
        localBundle.putString("VIDEO_URL", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString);
      }
    }
    else
    {
      localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramAbsBaseArticleInfo.thirdUin);
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramAbsBaseArticleInfo.thirdUinName);
    }
    if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
    {
      localBundle.putString("VIDEO_H5_URL", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      localBundle.putString("VIDEO_CREATE_TIME", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_Int, true));
    }
    else
    {
      localBundle.putString("VIDEO_H5_URL", paramAbsBaseArticleInfo.mArticleContentUrl);
      localBundle.putString("VIDEO_CREATE_TIME", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(paramAbsBaseArticleInfo.mTime, true));
    }
    localBundle.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
    if (paramAbsBaseArticleInfo.mVideoJsonWidth != 0) {
      localBundle.putString("VIDEO_WIDTH", String.valueOf(paramAbsBaseArticleInfo.mVideoJsonWidth));
    } else if (paramVideoPlayParam.jdField_f_of_type_Int == 6) {
      localBundle.putString("VIDEO_WIDTH", String.valueOf(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int));
    }
    if (paramAbsBaseArticleInfo.mVideoJsonHeight != 0) {
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(paramAbsBaseArticleInfo.mVideoJsonHeight));
    } else if (paramVideoPlayParam.jdField_f_of_type_Int == 6) {
      localBundle.putString("VIDEO_HEIGHT", String.valueOf(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int));
    }
    localBundle.putString("VIDEO_VID", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    localBundle.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
    localBundle.putLong("VIDEO_XG_FILE_SIZE", paramAbsBaseArticleInfo.mXGFileSize);
    localBundle.putInt("VIDEO_STRATEGY_ID", paramAbsBaseArticleInfo.mStrategyId);
    localBundle.putLong("VIDEO_ALGORITHM_ID", paramAbsBaseArticleInfo.mAlgorithmID);
    localBundle.putString("VIDEO_SECOND_INDEX_INNER_ID", paramVideoPlayParam.n);
    if ((paramRIJDataManager.a().a() != null) && (paramRIJDataManager.a().a().a() != null) && (paramVideoPlayManager != null) && (paramRIJDataManager.a().a().a().jdField_c_of_type_Long == paramVideoPlayParam.jdField_c_of_type_Long)) {
      localBundle.putLong("VIDEO_PLAY_POSITION", paramVideoPlayManager.b());
    } else {
      localBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
    if (paramVideoPlayParam.jdField_f_of_type_Int == 6)
    {
      localBundle.putString("VIDEO_ARTICLE_ID", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_g_of_type_JavaLangString);
      localBundle.putLong("VIDEO_FEED_ID", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.longValue());
      localBundle.putInt("VIDEO_FEED_TYPE", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue());
      localBundle.putString("VIDEO_TITLE", ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
    }
    else
    {
      localBundle.putString("VIDEO_ARTICLE_ID", paramAbsBaseArticleInfo.innerUniqueID);
      localBundle.putString("VIDEO_TITLE", paramAbsBaseArticleInfo.mTitle);
    }
    localBundle.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", RIJShowKanDianTabSp.a(paramRIJDataManager.a().a()));
    boolean bool1;
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
    localBundle.putString("VIDEO_RECOMMEND_REASON", paramAbsBaseArticleInfo.mRecommentdReason);
    localBundle.putBoolean("isFromKandian", true);
    localBundle.putLong("channelID", paramAbsBaseArticleInfo.mChannelID);
    localBundle.putLong("algorithmID", paramAbsBaseArticleInfo.mAlgorithmID);
    localBundle.putString("innderId", paramAbsBaseArticleInfo.innerUniqueID);
    localBundle.putLong("strategyId", paramAbsBaseArticleInfo.mStrategyId);
    localBundle.putInt("interactionType", TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true);
    localBundle.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
    localBundle.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
    localBundle.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
    localBundle.putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_g_of_type_JavaLangString);
    localBundle.putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramVideoPlayParam.jdField_f_of_type_Long);
    localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_f_of_type_Int);
    paramRIJDataManager = new Bundle();
    paramRIJDataManager.putString("VINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    paramRIJDataManager.putString("TINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    paramRIJDataManager.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
    if (paramVideoPlayManager == null) {
      i = 0;
    } else {
      i = (int)paramVideoPlayManager.b();
    }
    paramRIJDataManager.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(i, paramVideoPlayParam.jdField_b_of_type_Int));
    paramRIJDataManager.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_c_of_type_Int);
    paramRIJDataManager.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_d_of_type_Int);
    paramRIJDataManager.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
    paramRIJDataManager.putString("source_puin", paramAbsBaseArticleInfo.mSubscribeID);
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1)
    {
      paramRIJDataManager.putString("ACCOUNT_UIN", paramAbsBaseArticleInfo.mSubscribeID);
      paramRIJDataManager.putString("ACCOUNT_NAME", paramAbsBaseArticleInfo.mSubscribeName);
    }
    else
    {
      paramRIJDataManager.putString("ACCOUNT_UIN", paramAbsBaseArticleInfo.thirdUin);
      paramRIJDataManager.putString("ACCOUNT_NAME", paramAbsBaseArticleInfo.thirdUinName);
    }
    if ((paramVideoPlayParam.jdField_f_of_type_Int == 6) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      paramVideoPlayManager = new StringBuilder();
      paramVideoPlayManager.append(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_e_of_type_JavaLangString);
      paramVideoPlayManager.append(": ");
      paramVideoPlayManager.append(((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.get(0)).h);
      paramRIJDataManager.putString("compatible_text", paramVideoPlayManager.toString());
      paramRIJDataManager.putInt("req_type", 125);
    }
    else
    {
      paramRIJDataManager.putInt("req_type", 140);
    }
    paramRIJDataManager.putInt("TYPE", paramVideoPlayParam.jdField_f_of_type_Int);
    paramRIJDataManager.putString("ARTICLE_ID", paramAbsBaseArticleInfo.innerUniqueID);
    paramRIJDataManager.putInt("layout_item", 5);
    paramRIJDataManager.putBoolean("video_url_load", false);
    paramRIJDataManager.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
    if (paramAbsBaseArticleInfo.aioShareUrl != null)
    {
      paramRIJDataManager.putString("detail_url", paramAbsBaseArticleInfo.aioShareUrl);
    }
    else
    {
      paramVideoPlayManager = new StringBuilder();
      paramVideoPlayManager.append(paramAbsBaseArticleInfo.mArticleContentUrl);
      paramVideoPlayManager.append("&sourcefrom=0");
      paramRIJDataManager.putString("detail_url", paramVideoPlayManager.toString());
    }
    paramRIJDataManager.putString("video_url", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    paramRIJDataManager.putString("title", paramAbsBaseArticleInfo.mTitle);
    paramRIJDataManager.putString("req_create_time", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(paramAbsBaseArticleInfo.mTime));
    paramRIJDataManager.putString("brief_key", paramAbsBaseArticleInfo.mTitle);
    localBundle.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(paramRIJDataManager)).getBytes());
    localBundle.putString("VIDEO_SUBS_TEXT", paramAbsBaseArticleInfo.mVideoArticleSubsText);
    localBundle.putString("VIDEO_SUBS_COLOR", paramAbsBaseArticleInfo.mVideoArticleSubsColor);
    localBundle.putString("KEY_VIDEO_JSON_LIST", paramAbsBaseArticleInfo.mJsonVideoList);
    localBundle.putInt("VIDEO_PLAY_COUNT", paramAbsBaseArticleInfo.mVideoPlayCount);
    localBundle.putString("VIDEO_ACCOUNT_AVATAR_URL", paramAbsBaseArticleInfo.preloadAvatarUrl);
    localBundle.putBoolean("VIDEO_ACCOUNT_IS_FOLLOWED", VideoFeedsHelper.a(paramAbsBaseArticleInfo.getSubscribeUin()));
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localBundle.putBoolean("VIDEO_IS_DIANZAN", bool1);
      localBundle.putInt("VIDEO_DIAN_ZAN_COUNT", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int);
      localBundle.putInt("VIDEO_COMMENT_COUNT", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int);
      localBundle.putInt("VIDEO_BIU_COUNT", paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_f_of_type_Int);
    }
    return localBundle;
  }
  
  private static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, paramBundle.get(str));
      }
      catch (JSONException localJSONException)
      {
        QLog.e("extralBundle2extralDataString", 1, localJSONException.getMessage());
      }
    }
    return new String(Base64.encode(localJSONObject.toString().getBytes(), 0));
  }
  
  private static void a(Bundle paramBundle)
  {
    paramBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 6);
    paramBundle.putInt("VIDEO_FROM_TYPE", 9);
    paramBundle.putInt("key_source", 0);
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 8);
  }
  
  private static void a(Bundle paramBundle, RIJDataManager paramRIJDataManager)
  {
    if (paramRIJDataManager.a().a() == 3) {
      paramBundle.putInt("VIDEO_FROM_TYPE", 6);
    } else {
      paramBundle.putInt("VIDEO_FROM_TYPE", 7);
    }
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 5);
  }
  
  private static void a(Bundle paramBundle, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 14);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
      return;
    }
    paramBundle.putInt("VIDEO_FROM_TYPE", 8);
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
  }
  
  private static void a(Bundle paramBundle, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramRIJDataManager.a().b() == 0)
    {
      b(paramBundle, paramAbsBaseArticleInfo);
      return;
    }
    if (paramRIJDataManager.a().b() == 56)
    {
      a(paramRIJDataManager, paramBundle, paramAbsBaseArticleInfo);
      return;
    }
    if (paramRIJDataManager.a().b() == 70)
    {
      a(paramBundle, paramAbsBaseArticleInfo);
      return;
    }
    if (paramRIJDataManager.a().b() == 40677)
    {
      a(paramBundle);
      return;
    }
    if (DailyModeConfigHandler.c(paramRIJDataManager.a().b()))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 24);
      return;
    }
    a(paramBundle, paramRIJDataManager);
  }
  
  private static void a(RIJDataManager paramRIJDataManager)
  {
    if ((paramRIJDataManager != null) && (paramRIJDataManager.a().a() != null))
    {
      paramRIJDataManager.a().a().d();
      paramRIJDataManager.a().b(true);
    }
  }
  
  private static void a(RIJDataManager paramRIJDataManager, Intent paramIntent, Bundle paramBundle, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      bool1 = MultiVideoConfigHandler.a(paramBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(paramBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(paramBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(paramBundle.getString("VIDEO_TIME")).intValue());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, new Object[] { "openFullVideoPlayActivity MultiVideoConfigHandler.isEnterMultiMode is error:", localException.getMessage() });
      }
      bool1 = false;
    }
    if ("1".equals(paramBundle.getString("forceViola"))) {
      bool1 = bool2;
    }
    if (bool1)
    {
      MultiVideoHelper.a((Activity)paramRIJDataManager.a().a(), paramIntent, paramInt);
      ((Activity)paramRIJDataManager.a().a()).overridePendingTransition(2130772023, 0);
      return;
    }
    ((Activity)paramRIJDataManager.a().a()).startActivityForResult(paramIntent, paramInt);
    ((Activity)paramRIJDataManager.a().a()).overridePendingTransition(2130772112, 2130772113);
  }
  
  private static void a(RIJDataManager paramRIJDataManager, Bundle paramBundle, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.z(paramAbsBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 5);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramAbsBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
    }
    else if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 5);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
    }
    else if (paramRIJDataManager.a().a() == 1004L)
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 25);
    }
    else
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 2);
    }
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 4);
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean, RIJDataManager paramRIJDataManager)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("open full play activity, articleID : ");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject1).append(", playPosition : ");
      ((StringBuilder)localObject1).append(paramVideoPlayParam.jdField_d_of_type_Long);
      ((StringBuilder)localObject1).append(",vid : ");
      ((StringBuilder)localObject1).append(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", showComment : ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramRIJDataManager.a().a() != null) {
      paramRIJDataManager.a().a().b();
    }
    paramRIJDataManager.a().a(true);
    if (RIJFeedsType.h(paramAbsBaseArticleInfo)) {
      localObject1 = b(paramVideoPlayParam, paramAbsBaseArticleInfo, paramRIJDataManager.a().a(), paramRIJDataManager);
    } else {
      localObject1 = a(paramVideoPlayParam, paramAbsBaseArticleInfo, paramRIJDataManager.a().a(), paramRIJDataManager);
    }
    if (paramRIJDataManager.a().a() != null)
    {
      if (paramRIJDataManager.a().a().c() == paramAbsBaseArticleInfo.mArticleID) {
        i = paramRIJDataManager.a().a().a();
      } else {
        i = 1;
      }
      ((Bundle)localObject1).putInt("VIDEO_PLAY_STATUS", i);
    }
    if (paramVideoPlayParam.jdField_f_of_type_Int == 2)
    {
      localObject2 = ThirdVideoManager.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putString("VIDEO_THIRD_VID_URL", ((VideoUrlInfo)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putLong("VIDEO_THIRD_VID_URL_TIME", ((VideoUrlInfo)localObject2).jdField_b_of_type_Long);
      }
    }
    ((Bundle)localObject1).putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    ((Bundle)localObject1).putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    a((Bundle)localObject1, paramAbsBaseArticleInfo, paramRIJDataManager);
    ((Bundle)localObject1).putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", paramRIJDataManager.a().b());
    ((Bundle)localObject1).putParcelable("VIDEO_COLUMN_INFO", paramAbsBaseArticleInfo.mVideoColumnInfo);
    ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramAbsBaseArticleInfo.mJsonVideoList);
    Object localObject2 = new Intent(paramRIJDataManager.a().a(), VideoFeedsPlayActivity.class);
    ((Intent)localObject2).addFlags(536870912);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      ((Bundle)localObject1).putBoolean("param_needSmooth", VideoVolumeControl.getInstance().needSmoothVideo());
      VideoVolumeControl.getInstance().setDynamicPauseReceive(true);
      ((Bundle)localObject1).putBoolean("param_needAlertInXg", VideoAutoPlayController.isAllowPlayInXgNetwork());
    }
    ((Bundle)localObject1).putString("forceViola", paramVideoPlayParam.a.getString("forceViola"));
    ((Bundle)localObject1).putString("extralData", a(paramVideoPlayParam.a));
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    if ((paramVideoPlayParam.jdField_f_of_type_Int == 6) && (!RIJFeedsType.h(paramAbsBaseArticleInfo))) {
      ((Intent)localObject2).putExtra("VIDEO_ARTICLE_INFO_FOR_BIU", paramAbsBaseArticleInfo);
    }
    int i = a(paramAbsBaseArticleInfo);
    ((Intent)localObject2).putExtra("VIDEO_FEEDS_INNER_SESSION_ID", paramVideoPlayParam.l);
    ((Intent)localObject2).putExtra("VIDEO_CHANNEL_SESSION_ID", paramVideoPlayParam.m);
    ((Intent)localObject2).putExtra("item_x", paramVideoPlayParam.h);
    ((Intent)localObject2).putExtra("item_y", paramVideoPlayParam.i);
    ((Intent)localObject2).putExtra("item_width", paramVideoPlayParam.j);
    ((Intent)localObject2).putExtra("item_height", paramVideoPlayParam.k);
    VideoFeedsHelper.a(paramAbsBaseArticleInfo, (Intent)localObject2);
    ((Intent)localObject2).putExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", RIJFeedsType.a(paramAbsBaseArticleInfo));
    ((Intent)localObject2).putExtra("VIDEO_SHOW_COMMENT", paramBoolean);
    ((Intent)localObject2).putExtra("video_player_session_id", paramRIJDataManager.a().a().a());
    a(paramRIJDataManager, (Intent)localObject2, (Bundle)localObject1, i);
    if ((((Bundle)localObject1).getInt("VIDEO_FROM_TYPE", -1) == 3) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID))) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ENTER, 0, 0, 0), 6);
    }
    VideoFeedsStartStatistic.a();
    a(paramRIJDataManager);
    if (ReadInJoyHelper.l()) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008B68", "0X8008B68", 0, 0, "", "", "", VideoReporter.a(null, null, paramAbsBaseArticleInfo.mVideoVid, paramAbsBaseArticleInfo.innerUniqueID, paramRIJDataManager.a().b(), null), false);
    }
  }
  
  private static Bundle b(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, VideoPlayManager paramVideoPlayManager, RIJDataManager paramRIJDataManager)
  {
    boolean bool = RIJFeedsType.E(paramAbsBaseArticleInfo);
    Object localObject1 = null;
    Object localObject2 = null;
    if (bool)
    {
      localObject3 = paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject3).next();
        if ((((NewPolymericInfo.PackArticleInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo != null) && (TextUtils.equals(paramVideoPlayParam.jdField_c_of_type_JavaLangString, ((NewPolymericInfo.PackArticleInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString))) {
          localObject2 = localObject1;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    }
    localObject1 = new Bundle();
    if (((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_Boolean)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
      ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((StringBuilder)localObject3).toString());
      ((Bundle)localObject1).putString("VIDEO_H5_URL", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_c_of_type_JavaLangString);
      ((Bundle)localObject1).putLong("VIDEO_FEED_ID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_c_of_type_Long);
      ((Bundle)localObject1).putInt("VIDEO_FEED_TYPE", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_b_of_type_Int);
    }
    else
    {
      ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_UIN", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_e_of_type_JavaLangString);
      ((Bundle)localObject1).putString("VIDEO_PUB_ACCOUNT_NAME", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_f_of_type_JavaLangString);
      ((Bundle)localObject1).putString("VIDEO_H5_URL", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_d_of_type_JavaLangString);
    }
    Object localObject3 = ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo;
    ((Bundle)localObject1).putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
    ((Bundle)localObject1).putString("VIDEO_WIDTH", String.valueOf(paramVideoPlayParam.jdField_c_of_type_Int));
    ((Bundle)localObject1).putString("VIDEO_HEIGHT", String.valueOf(paramVideoPlayParam.jdField_d_of_type_Int));
    ((Bundle)localObject1).putString("VIDEO_VID", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject1).putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject1).putLong("VIDEO_XG_FILE_SIZE", paramAbsBaseArticleInfo.mXGFileSize);
    ((Bundle)localObject1).putInt("VIDEO_STRATEGY_ID", paramVideoPlayParam.jdField_g_of_type_Int);
    ((Bundle)localObject1).putLong("VIDEO_ALGORITHM_ID", paramVideoPlayParam.jdField_g_of_type_Long);
    ((Bundle)localObject1).putString("VIDEO_SECOND_INDEX_INNER_ID", paramVideoPlayParam.n);
    if ((paramRIJDataManager.a().a() != null) && (paramRIJDataManager.a().a().a() != null) && (paramVideoPlayManager != null) && (paramRIJDataManager.a().a().a().jdField_c_of_type_Long == paramVideoPlayParam.jdField_c_of_type_Long)) {
      ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", paramVideoPlayManager.b());
    } else {
      ((Bundle)localObject1).putLong("VIDEO_PLAY_POSITION", 0L);
    }
    ((Bundle)localObject1).putString("VIDEO_ARTICLE_ID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_g_of_type_JavaLangString);
    ((Bundle)localObject1).putString("VIDEO_TITLE", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_JavaLangString);
    ((Bundle)localObject1).putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", RIJShowKanDianTabSp.a(paramRIJDataManager.a().a()));
    if (paramVideoPlayParam.jdField_f_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((Bundle)localObject1).putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
    ((Bundle)localObject1).putBoolean("isFromKandian", true);
    ((Bundle)localObject1).putLong("channelID", paramAbsBaseArticleInfo.mChannelID);
    ((Bundle)localObject1).putLong("algorithmID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_b_of_type_Long);
    ((Bundle)localObject1).putString("innderId", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_g_of_type_JavaLangString);
    ((Bundle)localObject1).putLong("strategyId", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_Int);
    ((Bundle)localObject1).putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
    ((Bundle)localObject1).putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
    ((Bundle)localObject1).putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_f_of_type_JavaLangString);
    ((Bundle)localObject1).putString("VIDEO_THIRD_URL", paramVideoPlayParam.jdField_g_of_type_JavaLangString);
    ((Bundle)localObject1).putLong("VIDEO_THRID_URL_EXPIRE_TIME", paramVideoPlayParam.jdField_f_of_type_Long);
    ((Bundle)localObject1).putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_f_of_type_Int);
    paramRIJDataManager = new Bundle();
    paramRIJDataManager.putString("VINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    paramRIJDataManager.putString("TINFO", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    paramRIJDataManager.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
    int i;
    if (paramVideoPlayManager == null) {
      i = 0;
    } else {
      i = (int)paramVideoPlayManager.b();
    }
    paramRIJDataManager.putInt("PREVIEW_START_POSI", VideoPlayUtils.a(i, paramVideoPlayParam.jdField_b_of_type_Int));
    paramRIJDataManager.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_c_of_type_Int);
    paramRIJDataManager.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_d_of_type_Int);
    paramRIJDataManager.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_b_of_type_Int);
    paramRIJDataManager.putString("source_puin", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_e_of_type_JavaLangString);
    paramRIJDataManager.putString("ACCOUNT_UIN", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_e_of_type_JavaLangString);
    paramRIJDataManager.putString("ACCOUNT_NAME", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_f_of_type_JavaLangString);
    paramRIJDataManager.putInt("TYPE", paramVideoPlayParam.jdField_f_of_type_Int);
    paramRIJDataManager.putString("ARTICLE_ID", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_g_of_type_JavaLangString);
    paramRIJDataManager.putInt("layout_item", 5);
    paramRIJDataManager.putBoolean("video_url_load", false);
    paramRIJDataManager.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
    paramVideoPlayManager = new StringBuilder();
    paramVideoPlayManager.append(((NewPolymericInfo.PackArticleInfo)localObject2).jdField_d_of_type_JavaLangString);
    paramVideoPlayManager.append("&sourcefrom=0");
    paramRIJDataManager.putString("detail_url", paramVideoPlayManager.toString());
    paramRIJDataManager.putString("video_url", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    paramRIJDataManager.putString("title", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_JavaLangString);
    paramRIJDataManager.putString("req_create_time", ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getDateTimeString(paramAbsBaseArticleInfo.mTime));
    paramRIJDataManager.putString("brief_key", ((NewPolymericInfo.PackArticleInfo)localObject2).jdField_a_of_type_JavaLangString);
    paramRIJDataManager.putInt("req_type", 140);
    ((Bundle)localObject1).putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(paramRIJDataManager)).getBytes());
    ((Bundle)localObject1).putString("KEY_VIDEO_JSON_LIST", paramAbsBaseArticleInfo.mJsonVideoList);
    return localObject1;
  }
  
  private static void b(Bundle paramBundle, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (RIJFeedsType.z(paramAbsBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 4);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", paramAbsBaseArticleInfo.mPolymericInfo.jdField_f_of_type_Long);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
    }
    else if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 13);
      paramBundle.putLong("VIDEO_FROM_POLYMERIC_PUIN", paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Long);
    }
    else
    {
      paramBundle.putInt("VIDEO_FROM_TYPE", 3);
    }
    paramBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJFullVideoPlayActivity
 * JD-Core Version:    0.7.0.1
 */