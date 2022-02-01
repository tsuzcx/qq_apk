package com.tencent.mobileqq.kandian.glue.video.report;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame;
import com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;

public class RIJVideoReportManager
{
  public static String a(VideoInfo paramVideoInfo, int paramInt)
  {
    VideoR5.Builder localBuilder = new VideoR5.Builder(null, null, null, null);
    localBuilder.T(ReadinjoyTabFrame.b).U(paramInt);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.jdField_g_of_type_Boolean)
      {
        if (paramVideoInfo.jdField_f_of_type_Boolean) {
          paramInt = 3;
        } else {
          paramInt = 2;
        }
      }
      else {
        paramInt = 4;
      }
      localBuilder.a("status", Integer.valueOf(paramInt)).j(paramVideoInfo.jdField_g_of_type_JavaLangString).e(paramVideoInfo.jdField_f_of_type_Long).f(paramVideoInfo.a).V(0).a(0);
    }
    else
    {
      localBuilder.a("status", Integer.valueOf(1));
    }
    return localBuilder.a().a();
  }
  
  public static String a(BaseReportData paramBaseReportData, String paramString, VideoPlayManager paramVideoPlayManager)
  {
    paramVideoPlayManager = RIJTransMergeKanDianReport.a(paramString, paramVideoPlayManager.b(), VideoReporter.jdField_a_of_type_Int);
    if (paramBaseReportData.a == null) {
      return paramVideoPlayManager;
    }
    paramString = paramVideoPlayManager;
    if (paramBaseReportData.a.mVideoColumnInfo != null) {
      paramString = new VideoR5.Builder(paramVideoPlayManager).c(paramBaseReportData.a).d(paramBaseReportData.a).a(paramBaseReportData.a.videoReportInfo).a().a();
    }
    if (((RIJBaseItemViewType.a(paramBaseReportData.a) == 46) || (paramBaseReportData.a.isTwoItem)) && (paramBaseReportData.a.mVideoDownloadBarInfo != null) && (paramBaseReportData.a.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.a(paramBaseReportData.a.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.a(paramBaseReportData.a.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail)))
    {
      paramVideoPlayManager = new StringBuilder();
      paramVideoPlayManager.append(RIJPBFieldUtils.b(paramBaseReportData.a.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url));
      paramVideoPlayManager.append(RIJPBFieldUtils.b(paramBaseReportData.a.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      VideoFeedsHelper.a(paramVideoPlayManager.toString());
    }
    return paramString;
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    String str1 = RIJFeedsType.c(paramAbsBaseArticleInfo);
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    int j = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramRIJDataManager.a().b(), i), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramRIJDataManager.a().b(), i));
    VideoR5.Builder localBuilder = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramRIJDataManager.a().b(), i, j, NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
    localBuilder.a(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo.mArticleID).a(paramRIJDataManager.a().a()).g(VideoReporter.jdField_a_of_type_Int).h(409409).j(paramAbsBaseArticleInfo.mVideoAdsJumpType).k(paramAbsBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(RIJFeedsType.g(paramAbsBaseArticleInfo))).a(paramAbsBaseArticleInfo.videoReportInfo);
    if (paramRIJDataManager.a().b() == 0)
    {
      paramVideoPlayParam.l = VideoReporter.b();
      localBuilder.c(paramVideoPlayParam.l);
      if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
        localBuilder.Y(paramAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
      }
      if (RIJBaseItemViewType.a(paramAbsBaseArticleInfo) == 6) {
        localBuilder.aa(VideoFeedsHelper.f());
      }
    }
    else if ((paramRIJDataManager.a().b() == 56) && (paramRIJDataManager.a().a() != null) && (!TextUtils.isEmpty(paramRIJDataManager.a().a().b())))
    {
      paramVideoPlayParam.m = paramRIJDataManager.a().a().b();
      localBuilder.d(paramVideoPlayParam.m);
    }
    if ((paramRIJDataManager.a().a() != null) && (paramRIJDataManager.a().a().a() == paramVideoPlayParam))
    {
      long l = paramRIJDataManager.a().a().b();
      if (l != 0L) {
        localBuilder.f(l);
      }
    }
    if (paramRIJDataManager.a().b() == 40677)
    {
      localBuilder.b(paramAbsBaseArticleInfo.mVideoAdsJumpType).a(WeishiGuideUtils.a(paramRIJDataManager.a().a()));
      localBuilder.i(2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), localBuilder.a().a(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009293", paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramRIJDataManager.a().b(), i, j, NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
      return;
    }
    localBuilder.a(paramAbsBaseArticleInfo).N((int)paramRIJDataManager.a().a()).c(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, true).d(paramAbsBaseArticleInfo).f(paramAbsBaseArticleInfo);
    if ((RIJFeedsType.C(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPolymericInfo != null)) {
      localBuilder.w(paramAbsBaseArticleInfo.mPolymericInfo.f + 1);
    }
    String str2 = ReadinjoyReportUtils.b(paramRIJDataManager.a().b());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), JSONUtils.a(localBuilder.a().a(), paramVideoPlayParam.a), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse(str2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramRIJDataManager.a().b(), i, j, NetworkUtil.isWifiConnected(paramRIJDataManager.a().a()), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramAbsBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(RIJPBFieldUtils.b(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      RIJJumpUtils.a(paramContext, RIJPBFieldUtils.b(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, Map<String, Object> paramMap, RIJDataManager paramRIJDataManager, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramRIJDataManager.a().b() == 0) || (paramRIJDataManager.a().b() == 56))
    {
      if (VideoFeedsHelper.a((Activity)paramRIJDataManager.a().a(), paramAbsBaseArticleInfo1))
      {
        a(paramVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
        if ((paramRIJDataManager.a().b() == 56) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.a(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.a(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)))
        {
          paramAbsBaseArticleInfo2 = new StringBuilder();
          paramAbsBaseArticleInfo2.append(RIJPBFieldUtils.b(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url));
          paramAbsBaseArticleInfo2.append(RIJPBFieldUtils.b(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
          VideoFeedsHelper.a(paramAbsBaseArticleInfo2.toString());
        }
        return;
      }
      if ((paramRIJDataManager.a().b() == 56) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.a(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.a(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJPBFieldUtils.b(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url));
        localStringBuilder.append(RIJPBFieldUtils.b(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
        VideoFeedsHelper.a(localStringBuilder.toString());
      }
    }
    if (paramAbsBaseArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramAbsBaseArticleInfo1.videoJumpChannelID == 56)
      {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoChannelActivityForTwoItemVideo(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo1, true);
      }
      else
      {
        paramAbsBaseArticleInfo2 = new HashMap();
        paramAbsBaseArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramAbsBaseArticleInfo1.mArticleID));
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoSubChannelActivity(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo1.videoJumpChannelID, paramAbsBaseArticleInfo1.videoJumpChannelName, paramAbsBaseArticleInfo1.videoJumpChannelType, 5, paramAbsBaseArticleInfo2);
      }
      a(paramVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    if (ReadInJoyHelper.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchVideoChannelActivityForTwoItemVideo(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo1, true);
      a(paramVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    paramVideoPlayParam.a = paramMap;
    paramRIJDataManager.a().a().a(paramVideoPlayParam, paramAbsBaseArticleInfo1);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseReportData paramBaseReportData)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!RIJFeedsType.H(paramAbsBaseArticleInfo)) {
        return;
      }
      paramBaseReportData = new VideoR5.Builder(null, null, null, null).W(Integer.valueOf("2007").intValue());
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
      paramBaseReportData.q(paramAbsBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramAbsBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
      paramBaseReportData.q(localAbsBaseArticleInfo.mKdLiveInfo.jdField_g_of_type_JavaLangString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, localAbsBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
    }
  }
  
  public static void a(BaseReportData paramBaseReportData, long paramLong, int paramInt1, String paramString1, String paramString2, Context paramContext, int paramInt2, int paramInt3, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Map<Long, BaseReportData> paramMap, int paramInt, VideoRecommendManager paramVideoRecommendManager)
  {
    if ((paramInt == 56) && (paramVideoRecommendManager != null))
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        localBaseReportData.h = paramVideoRecommendManager.a();
        if (paramVideoRecommendManager.a(localBaseReportData.a.mArticleID)) {
          localBaseReportData.jdField_f_of_type_Boolean = true;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt, long paramLong)
  {
    if ((paramAbsBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)))
    {
      RIJJumpUtils.a(paramContext, paramAbsBaseArticleInfo.mArticleContentUrl);
      paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, paramAbsBaseArticleInfo.mVideoVid, paramAbsBaseArticleInfo.innerUniqueID).Z(paramBoolean ^ true).a(paramInt).a(paramAbsBaseArticleInfo.videoReportInfo).a(paramAbsBaseArticleInfo).N((int)paramLong).W(RIJFeedsType.a(paramAbsBaseArticleInfo)).e(paramAbsBaseArticleInfo).R(6).f(paramAbsBaseArticleInfo).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
    }
  }
  
  public static void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, String paramString, Map<String, Object> paramMap, RIJDataManager paramRIJDataManager)
  {
    VideoPlayParam localVideoPlayParam = RIJConfigVideoItem.a(paramAbsBaseArticleInfo1);
    localVideoPlayParam.n = paramString;
    localVideoPlayParam.l = VideoReporter.b();
    if ((paramRIJDataManager.a().a() != null) && (!TextUtils.isEmpty(paramRIJDataManager.a().a().b()))) {
      localVideoPlayParam.m = paramRIJDataManager.a().a().b();
    }
    paramString = new VideoR5.Builder(null, null, null, null).Z(paramBoolean ^ true).c(localVideoPlayParam.l).d(localVideoPlayParam.m).a(paramRIJDataManager.a().b()).k(paramAbsBaseArticleInfo1.mVideoAdsSource).j(paramAbsBaseArticleInfo1.mVideoAdsJumpType).a(paramAbsBaseArticleInfo1.videoReportInfo).a(paramAbsBaseArticleInfo1).N((int)paramRIJDataManager.a().a()).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", paramString, false);
    if (VideoFeedsHelper.a(paramAbsBaseArticleInfo1, paramRIJDataManager.a().a()))
    {
      a(localVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    if ((paramAbsBaseArticleInfo1.isAccountShown) && (paramRIJDataManager.a().b() == 0) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo1.mArticleContentUrl)))
    {
      RIJJumpUtils.a(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo1.mArticleContentUrl);
      paramAbsBaseArticleInfo2 = new VideoR5.Builder(null, null, paramAbsBaseArticleInfo1.mVideoVid, paramAbsBaseArticleInfo1.innerUniqueID).Z(paramBoolean ^ true).c(localVideoPlayParam.l).d(localVideoPlayParam.m).a(paramRIJDataManager.a().b()).k(paramAbsBaseArticleInfo1.mVideoAdsSource).j(paramAbsBaseArticleInfo1.mVideoAdsJumpType).a(paramAbsBaseArticleInfo1.videoReportInfo).a(paramAbsBaseArticleInfo1).N((int)paramRIJDataManager.a().a()).W(RIJFeedsType.a(paramAbsBaseArticleInfo1)).e(paramAbsBaseArticleInfo1).R(7).f(paramAbsBaseArticleInfo2);
      if ((paramAbsBaseArticleInfo1.columnEntrances != null) && (paramAbsBaseArticleInfo1.columnEntrances.size() > 0))
      {
        paramString = (VideoColumnInfo)paramAbsBaseArticleInfo1.columnEntrances.get(0);
        if (paramString.jdField_a_of_type_Int != 0)
        {
          paramAbsBaseArticleInfo1 = "1";
          paramAbsBaseArticleInfo2.a("is_column", "1");
          paramAbsBaseArticleInfo2.a("column_id", String.valueOf(paramString.jdField_a_of_type_Int));
          if (!paramString.jdField_a_of_type_Boolean) {
            paramAbsBaseArticleInfo1 = "2";
          }
          paramAbsBaseArticleInfo2.a("subscribe_flag", paramAbsBaseArticleInfo1);
        }
        else
        {
          paramAbsBaseArticleInfo2.a("is_column", "0");
        }
      }
      paramAbsBaseArticleInfo1 = paramAbsBaseArticleInfo2.a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", JSONUtils.a(paramAbsBaseArticleInfo1, paramMap), false);
      return;
    }
    if (paramAbsBaseArticleInfo1.isVideoItemForAdJump())
    {
      paramAbsBaseArticleInfo2 = (Activity)paramRIJDataManager.a().a();
      if (paramAbsBaseArticleInfo2 != null)
      {
        paramString = new Intent(paramAbsBaseArticleInfo2, QQBrowserActivity.class);
        paramString.putExtra("url", paramAbsBaseArticleInfo1.mVideoAdsJumpUrl);
        paramString.putExtra("big_brother_source_key", RIJJumpUtils.a(paramRIJDataManager.a().b()));
        paramAbsBaseArticleInfo2.startActivity(paramString);
      }
      a(localVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    a(paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2, paramMap, paramRIJDataManager, localVideoPlayParam);
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject, BaseReportData paramBaseReportData)
  {
    if (paramJSONObject != null)
    {
      if (paramBaseReportData.a == null) {
        return;
      }
      Object localObject = new VideoR5.Builder(null, null, null, null).W(Integer.valueOf("1031").intValue()).r(paramJSONObject.optString("double_videocard_jump_page")).s(paramJSONObject.optString("double_videocard_jump_src")).a((int)paramBaseReportData.a.mChannelID);
      int i = ReadinjoyReportUtils.b();
      int j = 0;
      if (i > 0) {
        i = 0;
      } else {
        i = 1;
      }
      paramBaseReportData = ((VideoR5.Builder)localObject).ag(i).f(paramBaseReportData.a);
      i = j;
      if (paramBoolean)
      {
        localObject = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBaseReportData.a("columnId", localObject);
        }
        paramBaseReportData.j(paramJSONObject.optString("all_rowkey"));
        paramBaseReportData.t(paramJSONObject.optString("subscript"));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
        return;
      }
      while (i < 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("columnId_");
        j = i + 1;
        ((StringBuilder)localObject).append(j);
        localObject = paramJSONObject.optString(((StringBuilder)localObject).toString());
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBaseReportData.a("columnId", localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rowKey_");
        ((StringBuilder)localObject).append(j);
        paramBaseReportData.j(paramJSONObject.optString(((StringBuilder)localObject).toString()));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("subscript_");
        ((StringBuilder)localObject).append(j);
        paramBaseReportData.t(paramJSONObject.optString(((StringBuilder)localObject).toString()));
        paramBaseReportData.Z(i);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.a().a(), false);
        i = j;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt, VideoRecommendManager paramVideoRecommendManager, VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager.a()) {
      paramVideoPlayManager.a();
    }
    if (paramVideoRecommendManager != null) {
      paramVideoRecommendManager.a(1, paramAbsBaseArticleInfo, 0L, 0L);
    }
    paramVideoRecommendManager = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramVideoRecommendManager.putExtra("arg_article_info", paramAbsBaseArticleInfo);
    int i = 2;
    paramVideoRecommendManager.putExtra("biu_src", 2);
    paramVideoRecommendManager.putExtra("arg_from_type", 7);
    paramVideoRecommendManager.putExtra("fast_biu_type", paramBoolean2);
    paramActivity.startActivityForResult(paramVideoRecommendManager, 2);
    paramActivity.overridePendingTransition(0, 0);
    paramVideoRecommendManager = paramVideoPlayManager.a();
    long l1;
    if ((paramVideoRecommendManager != null) && (paramVideoRecommendManager.c.equals(paramAbsBaseArticleInfo.mVideoVid))) {
      l1 = paramVideoPlayManager.b();
    } else {
      l1 = 0L;
    }
    paramVideoPlayManager = new VideoR5.Builder(null, paramAbsBaseArticleInfo.mSubscribeID, paramAbsBaseArticleInfo.mVideoVid, paramAbsBaseArticleInfo.innerUniqueID).a(l1).c(paramAbsBaseArticleInfo.mVideoDuration * 1000).e(paramAbsBaseArticleInfo.mAlgorithmID).c(paramAbsBaseArticleInfo.mStrategyId).a(paramInt).g(paramBoolean1).h(paramBoolean2).a().a();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = paramAbsBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
      paramVideoRecommendManager = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      paramVideoRecommendManager = "0";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramVideoRecommendManager, paramVideoPlayManager, false);
    long l2 = paramActivity.getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    paramActivity = new ReportInfo.VideoExtraRepoerData();
    paramActivity.d = ((int)l1);
    paramActivity.e = (paramAbsBaseArticleInfo.mVideoDuration * 1000);
    if (l2 == 0L) {
      i = 1;
    }
    paramActivity.c = i;
    VideoReporter.a(paramAbsBaseArticleInfo, paramInt, 25, -1L, paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager
 * JD-Core Version:    0.7.0.1
 */