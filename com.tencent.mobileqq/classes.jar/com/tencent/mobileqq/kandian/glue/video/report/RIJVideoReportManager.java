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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
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
    localBuilder.U(ReadinjoyTabFrame.g).V(paramInt);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.R)
      {
        if (paramVideoInfo.P) {
          paramInt = 3;
        } else {
          paramInt = 2;
        }
      }
      else {
        paramInt = 4;
      }
      localBuilder.b("status", Integer.valueOf(paramInt)).k(paramVideoInfo.l).e(paramVideoInfo.ah).g(paramVideoInfo.b).W(0).a(0);
    }
    else
    {
      localBuilder.b("status", Integer.valueOf(1));
    }
    return localBuilder.b().a();
  }
  
  public static String a(BaseReportData paramBaseReportData, String paramString, VideoPlayManager paramVideoPlayManager)
  {
    paramVideoPlayManager = RIJTransMergeKanDianReport.b(paramString, paramVideoPlayManager.C(), VideoReporter.b);
    if (paramBaseReportData.l == null) {
      return paramVideoPlayManager;
    }
    paramString = paramVideoPlayManager;
    if (paramBaseReportData.l.mVideoColumnInfo != null) {
      paramString = new VideoR5.Builder(paramVideoPlayManager).c(paramBaseReportData.l).d(paramBaseReportData.l).b(paramBaseReportData.l.videoReportInfo).b().a();
    }
    if (((RIJBaseItemViewType.c(paramBaseReportData.l) == 46) || (paramBaseReportData.l.isTwoItem)) && (paramBaseReportData.l.mVideoDownloadBarInfo != null) && (paramBaseReportData.l.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.c(paramBaseReportData.l.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.c(paramBaseReportData.l.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail)))
    {
      paramVideoPlayManager = new StringBuilder();
      paramVideoPlayManager.append(RIJPBFieldUtils.d(paramBaseReportData.l.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url));
      paramVideoPlayManager.append(RIJPBFieldUtils.d(paramBaseReportData.l.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      VideoFeedsHelper.b(paramVideoPlayManager.toString());
    }
    return paramString;
  }
  
  public static void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    String str1 = RIJFeedsType.k(paramAbsBaseArticleInfo);
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    int j = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramRIJDataManager.a().B(), i), false);
    PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramRIJDataManager.a().B(), i));
    VideoR5.Builder localBuilder = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramRIJDataManager.a().B(), i, j, NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
    localBuilder.a(paramRIJDataManager.a().y(), paramAbsBaseArticleInfo.mArticleID).a(paramRIJDataManager.a().y()).g(VideoReporter.b).h(409409).j(paramAbsBaseArticleInfo.mVideoAdsJumpType).k(paramAbsBaseArticleInfo.mVideoAdsSource).a(Boolean.valueOf(RIJFeedsType.i(paramAbsBaseArticleInfo))).b(paramAbsBaseArticleInfo.videoReportInfo);
    if (paramRIJDataManager.a().B() == 0)
    {
      paramVideoPlayParam.E = VideoReporter.b();
      localBuilder.d(paramVideoPlayParam.E);
      if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
        localBuilder.Z(paramAbsBaseArticleInfo.mVideoColumnInfo.b);
      }
      if (RIJBaseItemViewType.c(paramAbsBaseArticleInfo) == 6) {
        localBuilder.ab(VideoFeedsHelper.k());
      }
    }
    else if ((paramRIJDataManager.a().B() == 56) && (paramRIJDataManager.a().y() != null) && (!TextUtils.isEmpty(paramRIJDataManager.a().z().C())))
    {
      paramVideoPlayParam.F = paramRIJDataManager.a().z().C();
      localBuilder.e(paramVideoPlayParam.F);
    }
    if ((paramRIJDataManager.a().z() != null) && (paramRIJDataManager.a().z().a() == paramVideoPlayParam))
    {
      long l = paramRIJDataManager.a().z().f();
      if (l != 0L) {
        localBuilder.f(l);
      }
    }
    if (paramRIJDataManager.a().B() == 40677)
    {
      localBuilder.b(paramAbsBaseArticleInfo.mVideoAdsJumpType).c(WeishiGuideUtils.a(paramRIJDataManager.a().A()));
      localBuilder.i(2);
      PublicAccountReportUtils.a(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, "0X8009293", "0X8009293", 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), localBuilder.b().a(), false);
      PublicAccountReportUtils.a("0X8009293", paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramRIJDataManager.a().B(), i, j, NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
      return;
    }
    localBuilder.a(paramAbsBaseArticleInfo).O((int)paramRIJDataManager.a().x()).c(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, true).d(paramAbsBaseArticleInfo).f(paramAbsBaseArticleInfo);
    if ((RIJFeedsType.I(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPolymericInfo != null)) {
      localBuilder.w(paramAbsBaseArticleInfo.mPolymericInfo.q + 1);
    }
    String str2 = ReadinjoyReportUtils.e(paramRIJDataManager.a().B());
    PublicAccountReportUtils.a(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, str2, str2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), JSONUtils.a(localBuilder.b().a(), paramVideoPlayParam.V), false);
    PublicAccountReportUtils.a(str2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramRIJDataManager.a().B(), i, j, NetworkUtil.isWifiConnected(paramRIJDataManager.a().A()), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), 409409, paramAbsBaseArticleInfo));
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    if ((paramAbsBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(RIJPBFieldUtils.d(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url)))) {
      RIJJumpUtils.c(paramContext, RIJPBFieldUtils.d(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url));
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, Map<String, Object> paramMap, RIJDataManager paramRIJDataManager, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramRIJDataManager.a().B() == 0) || (paramRIJDataManager.a().B() == 56))
    {
      if (VideoFeedsHelper.a((Activity)paramRIJDataManager.a().A(), paramAbsBaseArticleInfo1))
      {
        a(paramVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
        if ((paramRIJDataManager.a().B() == 56) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.c(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.c(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail)))
        {
          paramAbsBaseArticleInfo2 = new StringBuilder();
          paramAbsBaseArticleInfo2.append(RIJPBFieldUtils.d(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url));
          paramAbsBaseArticleInfo2.append(RIJPBFieldUtils.d(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_schema_report_tail));
          VideoFeedsHelper.b(paramAbsBaseArticleInfo2.toString());
        }
        return;
      }
      if ((paramRIJDataManager.a().B() == 56) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo != null) && (paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo != null) && (RIJPBFieldUtils.c(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (RIJPBFieldUtils.c(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJPBFieldUtils.d(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url));
        localStringBuilder.append(RIJPBFieldUtils.d(paramAbsBaseArticleInfo1.mVideoDownloadBarInfo.weishiUGInfo.bytes_click_report_tail));
        VideoFeedsHelper.b(localStringBuilder.toString());
      }
    }
    if (paramAbsBaseArticleInfo1.videoJumpChannelID > 0)
    {
      if (paramAbsBaseArticleInfo1.videoJumpChannelID == 56)
      {
        ReadInJoyActivityHelper.INSTANCE.launchVideoChannelActivityForTwoItemVideo(paramRIJDataManager.a().A(), paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo1, true);
      }
      else
      {
        paramAbsBaseArticleInfo2 = new HashMap();
        paramAbsBaseArticleInfo2.put("param_key_insert_article_id", Long.valueOf(paramAbsBaseArticleInfo1.mArticleID));
        ReadInJoyActivityHelper.INSTANCE.launchVideoSubChannelActivity(paramRIJDataManager.a().A(), paramAbsBaseArticleInfo1.videoJumpChannelID, paramAbsBaseArticleInfo1.videoJumpChannelName, paramAbsBaseArticleInfo1.videoJumpChannelType, 5, paramAbsBaseArticleInfo2);
      }
      a(paramVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    if (ReadInJoyHelper.j(BaseApplicationImpl.getApplication().getRuntime()) == 1)
    {
      ReadInJoyActivityHelper.INSTANCE.launchVideoChannelActivityForTwoItemVideo(paramRIJDataManager.a().A(), paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo1, true);
      a(paramVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    paramVideoPlayParam.V = paramMap;
    paramRIJDataManager.a().v().a(paramVideoPlayParam, paramAbsBaseArticleInfo1);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseReportData paramBaseReportData)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (!RIJFeedsType.N(paramAbsBaseArticleInfo)) {
        return;
      }
      paramBaseReportData = new VideoR5.Builder(null, null, null, null).X(Integer.valueOf("2007").intValue());
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
      paramBaseReportData.r(paramAbsBaseArticleInfo.mKdLiveInfo.h);
      PublicAccountReportUtils.a(null, paramAbsBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.b().a(), false);
      paramBaseReportData.r(localAbsBaseArticleInfo.mKdLiveInfo.h);
      PublicAccountReportUtils.a(null, localAbsBaseArticleInfo.mSubscribeID, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.b().a(), false);
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
        localBaseReportData.w = paramVideoRecommendManager.a();
        if (paramVideoRecommendManager.a(localBaseReportData.l.mArticleID)) {
          localBaseReportData.x = true;
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt, long paramLong)
  {
    if ((paramAbsBaseArticleInfo.isAccountShown) && (paramInt == 0) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)))
    {
      RIJJumpUtils.c(paramContext, paramAbsBaseArticleInfo.mArticleContentUrl);
      PublicAccountReportUtils.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", new VideoR5.Builder(null, null, paramAbsBaseArticleInfo.mVideoVid, paramAbsBaseArticleInfo.innerUniqueID).aa(paramBoolean ^ true).a(paramInt).b(paramAbsBaseArticleInfo.videoReportInfo).a(paramAbsBaseArticleInfo).O((int)paramLong).X(RIJFeedsType.g(paramAbsBaseArticleInfo)).e(paramAbsBaseArticleInfo).S(6).f(paramAbsBaseArticleInfo).b().a(), false);
    }
  }
  
  public static void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, String paramString, Map<String, Object> paramMap, RIJDataManager paramRIJDataManager)
  {
    VideoPlayParam localVideoPlayParam = RIJConfigVideoItem.a(paramAbsBaseArticleInfo1);
    localVideoPlayParam.H = paramString;
    localVideoPlayParam.E = VideoReporter.b();
    if ((paramRIJDataManager.a().z() != null) && (!TextUtils.isEmpty(paramRIJDataManager.a().z().C()))) {
      localVideoPlayParam.F = paramRIJDataManager.a().z().C();
    }
    PublicAccountReportUtils.a(null, "", "0X8008D33", "0X8008D33", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, null).aa(paramBoolean ^ true).d(localVideoPlayParam.E).e(localVideoPlayParam.F).a(paramRIJDataManager.a().B()).k(paramAbsBaseArticleInfo1.mVideoAdsSource).j(paramAbsBaseArticleInfo1.mVideoAdsJumpType).b(paramAbsBaseArticleInfo1.videoReportInfo).a(paramAbsBaseArticleInfo1).O((int)paramRIJDataManager.a().x()).b().a(), false);
    if (VideoFeedsHelper.a(paramAbsBaseArticleInfo1, paramRIJDataManager.a().A()))
    {
      a(localVideoPlayParam, paramAbsBaseArticleInfo1, paramRIJDataManager);
      return;
    }
    if ((paramAbsBaseArticleInfo1.isAccountShown) && (paramRIJDataManager.a().B() == 0) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo1.mArticleContentUrl)))
    {
      RIJJumpUtils.c(paramRIJDataManager.a().A(), paramAbsBaseArticleInfo1.mArticleContentUrl);
      paramAbsBaseArticleInfo2 = new VideoR5.Builder(null, null, paramAbsBaseArticleInfo1.mVideoVid, paramAbsBaseArticleInfo1.innerUniqueID).aa(paramBoolean ^ true).d(localVideoPlayParam.E).e(localVideoPlayParam.F).a(paramRIJDataManager.a().B()).k(paramAbsBaseArticleInfo1.mVideoAdsSource).j(paramAbsBaseArticleInfo1.mVideoAdsJumpType).b(paramAbsBaseArticleInfo1.videoReportInfo).a(paramAbsBaseArticleInfo1).O((int)paramRIJDataManager.a().x()).X(RIJFeedsType.g(paramAbsBaseArticleInfo1)).e(paramAbsBaseArticleInfo1).S(7).f(paramAbsBaseArticleInfo2);
      if ((paramAbsBaseArticleInfo1.columnEntrances != null) && (paramAbsBaseArticleInfo1.columnEntrances.size() > 0))
      {
        paramString = (VideoColumnInfo)paramAbsBaseArticleInfo1.columnEntrances.get(0);
        if (paramString.b != 0)
        {
          paramAbsBaseArticleInfo1 = "1";
          paramAbsBaseArticleInfo2.b("is_column", "1");
          paramAbsBaseArticleInfo2.b("column_id", String.valueOf(paramString.b));
          if (!paramString.h) {
            paramAbsBaseArticleInfo1 = "2";
          }
          paramAbsBaseArticleInfo2.b("subscribe_flag", paramAbsBaseArticleInfo1);
        }
        else
        {
          paramAbsBaseArticleInfo2.b("is_column", "0");
        }
      }
      PublicAccountReportUtils.a(null, "", "0X8007625", "0X8007625", 0, 0, "", "", "", JSONUtils.a(paramAbsBaseArticleInfo2.b().a(), paramMap), false);
      return;
    }
    if (paramAbsBaseArticleInfo1.isVideoItemForAdJump())
    {
      paramAbsBaseArticleInfo2 = (Activity)paramRIJDataManager.a().A();
      if (paramAbsBaseArticleInfo2 != null)
      {
        paramString = new Intent(paramAbsBaseArticleInfo2, QQBrowserActivity.class);
        paramString.putExtra("url", paramAbsBaseArticleInfo1.mVideoAdsJumpUrl);
        paramString.putExtra("big_brother_source_key", RIJJumpUtils.a(paramRIJDataManager.a().B()));
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
      if (paramBaseReportData.l == null) {
        return;
      }
      Object localObject = new VideoR5.Builder(null, null, null, null).X(Integer.valueOf("1031").intValue()).s(paramJSONObject.optString("double_videocard_jump_page")).t(paramJSONObject.optString("double_videocard_jump_src")).a((int)paramBaseReportData.l.mChannelID);
      int i = ReadinjoyReportUtils.e();
      int j = 0;
      if (i > 0) {
        i = 0;
      } else {
        i = 1;
      }
      paramBaseReportData = ((VideoR5.Builder)localObject).ah(i).f(paramBaseReportData.l);
      i = j;
      if (paramBoolean)
      {
        localObject = paramJSONObject.optString("column_id");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBaseReportData.b("columnId", localObject);
        }
        paramBaseReportData.k(paramJSONObject.optString("all_rowkey"));
        paramBaseReportData.u(paramJSONObject.optString("subscript"));
        PublicAccountReportUtils.a(null, null, "0X800A5A8", "0X800A5A8", 0, 0, "", "", "", paramBaseReportData.b().a(), false);
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
          paramBaseReportData.b("columnId", localObject);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("rowKey_");
        ((StringBuilder)localObject).append(j);
        paramBaseReportData.k(paramJSONObject.optString(((StringBuilder)localObject).toString()));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("subscript_");
        ((StringBuilder)localObject).append(j);
        paramBaseReportData.u(paramJSONObject.optString(((StringBuilder)localObject).toString()));
        paramBaseReportData.aa(i);
        PublicAccountReportUtils.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData.b().a(), false);
        i = j;
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt, VideoRecommendManager paramVideoRecommendManager, VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager.g()) {
      paramVideoPlayManager.c();
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
    if ((paramVideoRecommendManager != null) && (paramVideoRecommendManager.d.equals(paramAbsBaseArticleInfo.mVideoVid))) {
      l1 = paramVideoPlayManager.f();
    } else {
      l1 = 0L;
    }
    paramVideoPlayManager = new VideoR5.Builder(null, paramAbsBaseArticleInfo.mSubscribeID, paramAbsBaseArticleInfo.mVideoVid, paramAbsBaseArticleInfo.innerUniqueID).a(l1).c(paramAbsBaseArticleInfo.mVideoDuration * 1000).e(paramAbsBaseArticleInfo.mAlgorithmID).c(paramAbsBaseArticleInfo.mStrategyId).a(paramInt).i(paramBoolean1).j(paramBoolean2).b().a();
    String str = paramAbsBaseArticleInfo.mSubscribeID;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
      paramVideoRecommendManager = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      paramVideoRecommendManager = "0";
    }
    PublicAccountReportUtils.a(null, str, "0X8007B89", "0X8007B89", 0, 0, "1", "", paramVideoRecommendManager, paramVideoPlayManager, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager
 * JD-Core Version:    0.7.0.1
 */