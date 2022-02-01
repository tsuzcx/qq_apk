package com.tencent.mobileqq.kandian.glue.report;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.comment.RIJMedalUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase.FeedsOperation;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgCard;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJFrameworkReportManager
{
  private Pair<Integer, Long> a(Context paramContext, int paramInt)
  {
    boolean bool = paramContext instanceof ReadInJoyNewFeedsActivity;
    long l2 = 0L;
    int i = -1;
    long l1;
    int j;
    if (bool)
    {
      paramContext = (ReadInJoyNewFeedsActivity)paramContext;
      if (paramContext.a() > 0L) {
        l1 = paramContext.a();
      } else {
        l1 = System.currentTimeMillis() - paramContext.b();
      }
      j = paramContext.b() ^ true;
    }
    else if ((paramContext instanceof SplashActivity))
    {
      paramContext = (RIJTabFrameBase)RIJJumpUtils.a(paramContext);
      l1 = l2;
      if (paramContext != null)
      {
        paramContext = paramContext.a();
        if (paramContext.a() != 0) {
          j = 0;
        } else {
          j = 1;
        }
        l1 = paramContext.a();
      }
    }
    else
    {
      l1 = l2;
      if (DailyModeConfigHandler.c(paramInt)) {
        if (KandianDailyReportUtils.b() != 0)
        {
          j = 0;
          l1 = l2;
        }
        else
        {
          j = 1;
          l1 = l2;
        }
      }
    }
    return new Pair(Integer.valueOf(j), Long.valueOf(l1));
  }
  
  private static String a(long paramLong)
  {
    if ((!DailyModeConfigHandler.a((int)paramLong)) && (!RIJShowKanDianTabSp.a(paramLong)))
    {
      if (ReadinjoyReportUtils.a(paramLong)) {
        return "0X8009356";
      }
      return "0X8009332";
    }
    return "0X8009CCB";
  }
  
  private String a(BaseReportData paramBaseReportData, String paramString)
  {
    int i = RIJBaseItemViewType.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    String str;
    if ((i != 6) && (i != 66) && (i != 115) && (i != 28) && (i != 11) && (i != 26) && (i != 19))
    {
      if ((i != 46) && (!paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.isTwoItem))
      {
        if (i == 118)
        {
          paramString = new VideoR5.Builder(paramString);
          if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo != null)
          {
            paramString.Y(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
            if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) {
              paramString.q(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_e_of_type_JavaLangString);
            }
          }
          paramString.j(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
          str = paramString.a().a();
        }
        else
        {
          str = paramString;
          if (i == 128)
          {
            paramString = new VideoR5.Builder(paramString);
            if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSimpleVideoColumnInfo != null)
            {
              paramString.Y(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
              if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
                paramString.q(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
              }
            }
            paramString.j(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
            str = paramString.a().a();
          }
        }
      }
      else
      {
        paramString = new VideoR5.Builder(paramString);
        paramString.f(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoVid);
        paramString.W(RIJFeedsType.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        paramString.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.videoReportInfo);
        if (i == 46) {
          paramString.Z(0);
        } else {
          paramString.Z(1);
        }
        paramString.e(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        str = paramString.a().a();
      }
    }
    else {
      str = VideoReporter.a(VideoReporter.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), paramString);
    }
    paramBaseReportData = str;
    if (i == 6)
    {
      paramBaseReportData = new VideoR5.Builder(str);
      paramBaseReportData.aa(VideoFeedsHelper.f());
      paramBaseReportData = paramBaseReportData.a().a();
    }
    return paramBaseReportData;
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramArrayOfString == null) {
        return null;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (str.contains(paramString))
        {
          paramString = str.split("=");
          if (paramString.length == 2) {
            return paramString[1];
          }
          return null;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private String a(Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap, String paramString1, BaseReportData paramBaseReportData, String paramString2, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        localJSONObject.put("folder_status", paramString1);
        localJSONObject.put("is_change", ChannelListDynamicOrderConfigHandler.a(ReadInJoyUtils.a(), paramInt));
        if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
        {
          bool = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.isPGCShortContent();
          if ((TextUtils.isEmpty(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.proteusItemsData)) || (!paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
            break label169;
          }
          paramInt = 1;
          break label172;
          paramMap = (ReadinjoyReportUtils.ExposureReportItem)paramMap.get(Long.valueOf(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID));
          if ((paramMap != null) && (paramMap.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
            localJSONObject.put("main_text_read_time", paramMap.jdField_a_of_type_Long);
          }
        }
        paramMap = localJSONObject.toString();
        return paramMap;
      }
      catch (Exception paramMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJFrameworkReportManager", 2, QLog.getStackTraceString(paramMap));
        }
        return paramString2;
      }
      label169:
      paramInt = 0;
      label172:
      if ((bool) || (paramInt != 0)) {}
    }
  }
  
  public static void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.3(paramInt));
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramInt1 == 40677)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.a(paramInt1, paramString, paramInt2, paramInt3, false, -1).build(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009294", "", "", "", "", RIJTransMergeKanDianReport.b(paramInt1));
    }
    if (paramInt1 == 56) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", VideoReporter.a(paramInt1, null), false);
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ThreadManager.executeOnSubThread(new RIJFrameworkReportManager.1(paramInt, System.currentTimeMillis() - paramLong));
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mOperation = paramInt1;
      localReportInfo.mSourceArticleId = Long.valueOf(paramString1).longValue();
      localReportInfo.mAlgorithmId = Integer.valueOf(paramString3).intValue();
      localReportInfo.mStrategyId = Integer.valueOf(paramString2).intValue();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.a();
      long l;
      if (TextUtils.isEmpty(paramString4)) {
        l = -1L;
      } else {
        l = Long.valueOf(paramString4).longValue();
      }
      localReportInfo.mPuin = l;
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = RIJKanDianFolderStatus.reportFolderStatus;
      }
      localReportInfo.mFolderStatus = paramInt1;
      localReportInfo.mOpSource = 3;
      if (((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).isXTabMode()) {
        localReportInfo.mChannelId = RIJXTabBadgeStore.a.a();
      }
      if (localReportInfo.mChannelId == -1) {
        localReportInfo.mChannelId = 0;
      }
      localArrayList.add(localReportInfo);
      ((IUserOperationModule)QRoute.api(IUserOperationModule.class)).request0x64eKandianActionReport(localArrayList, RIJKanDianFolderStatus.reportFolderStatus);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("RIJFrameworkReportManager", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "0X800A189";
    } else {
      str1 = "0X800A18A";
    }
    String str2 = new VideoR5.Builder(null, null, null, null).e(paramLong).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, str1, str1, 0, 0, "", "", "", str2, false);
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    int j = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
    Object localObject1 = RIJFeedsType.c(paramAbsBaseArticleInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, i), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, i));
    Object localObject2 = ReadinjoyReportUtils.b(paramInt);
    Object localObject3 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    localObject3 = RIJMsgReport.a.b((String)localObject3);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), (String)localObject3, false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo));
    paramContext = new ArrayList();
    localObject1 = new ReportInfo();
    ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.a();
    ((ReportInfo)localObject1).mSource = 0;
    ((ReportInfo)localObject1).mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    ((ReportInfo)localObject1).mChannelId = paramInt;
    ((ReportInfo)localObject1).mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    ((ReportInfo)localObject1).mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    ((ReportInfo)localObject1).mOperation = 1;
    ((ReportInfo)localObject1).mServerContext = paramAbsBaseArticleInfo.mServerContext;
    ((ReportInfo)localObject1).mReadTimeLength = -1;
    ((ReportInfo)localObject1).mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localObject2 = new FeedsReportData();
      ((FeedsReportData)localObject2).jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
        ((FeedsReportData)localObject2).jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      }
      ((FeedsReportData)localObject2).jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((FeedsReportData)localObject2).jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
      {
        ((FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
        while (paramAbsBaseArticleInfo.hasNext())
        {
          localObject3 = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
          if (localObject3 != null) {
            ((FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject3).jdField_a_of_type_Long));
          }
        }
      }
      ((ReportInfo)localObject1).mFeedsReportData = ((FeedsReportData)localObject2);
    }
    paramContext.add(localObject1);
    ReadInJoyLogicEngine.a().a(paramContext);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    int i;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      i = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
    String str1 = RIJFeedsType.c(paramAbsBaseArticleInfo);
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, i, bool ^ true, NetworkUtil.isWifiConnected(null), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) {
      str1 = paramAbsBaseArticleInfo.mSubscribeID;
    } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)) {
      str1 = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
    } else {
      str1 = "";
    }
    String str3 = ReadinjoyReportUtils.b(paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), str2, false);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridClickEvent channelId: ", Integer.valueOf(paramInt), ", toUin: ", str1, ", r5: ", str2 });
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    long l2 = paramAbsBaseArticleInfo.mFeedId;
    paramInt1 += 1;
    String str1;
    long l1;
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      str1 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = paramAbsBaseArticleInfo.mArticleID;
    }
    else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
    {
      str1 = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
      l1 = 0L;
    }
    else
    {
      l1 = 0L;
      str1 = "";
    }
    String str3 = RIJTransMergeKanDianReport.a(paramInt2, paramInt1, null, RIJFeedsType.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.c(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    String str2;
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
      str2 = "0X8009363";
    } else {
      str2 = "0X8008899";
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str4 = Long.toString(l2);
    String str5 = Long.toString(l1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
    localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, str2, str2, 0, 0, str4, str5, localStringBuilder.toString(), str3, false);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str1, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", str3 });
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt)
  {
    a(paramAbsBaseArticleInfo, paramActivity, paramInt, Integer.valueOf(0));
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt, Integer paramInteger)
  {
    Object localObject1 = RIJFeedsType.c(paramAbsBaseArticleInfo);
    int j;
    if (paramAbsBaseArticleInfo.hasChannelInfo()) {
      j = paramAbsBaseArticleInfo.mChannelInfoId;
    } else {
      j = 0;
    }
    int m = TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText) ^ true;
    int i;
    if (paramAbsBaseArticleInfo.videoJumpChannelID > 0) {
      i = paramAbsBaseArticleInfo.videoJumpChannelID;
    } else {
      i = 56;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, j), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, j));
    Object localObject2 = ReadinjoyReportUtils.b(paramInt);
    Object localObject3;
    Object localObject4;
    if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      localObject3 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, j, m, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), i, paramAbsBaseArticleInfo));
      if (paramInt == 0) {
        ((VideoR5.Builder)localObject3).h(i).d((String)VideoReporter.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(RIJFeedsType.g(paramAbsBaseArticleInfo))).a(paramAbsBaseArticleInfo.videoReportInfo);
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((VideoR5.Builder)localObject3).a().a(), false);
    }
    else
    {
      long l1 = paramAbsBaseArticleInfo.mAlgorithmID;
      int n = RIJFeedsType.a(paramAbsBaseArticleInfo);
      boolean bool = NetworkUtil.isWifiConnected(paramActivity);
      long l2 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      localObject3 = paramAbsBaseArticleInfo.mStrCircleId;
      localObject4 = paramAbsBaseArticleInfo.innerUniqueID;
      String str = RIJFeedsType.e(paramAbsBaseArticleInfo);
      int k = i;
      localObject3 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(l1, n, paramInt, j, m, bool, String.valueOf(l2), (String)localObject3, (String)localObject4, str, i, paramAbsBaseArticleInfo));
      if (paramInt == 0) {
        ((VideoR5.Builder)localObject3).h(k).d((String)VideoReporter.a.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(RIJFeedsType.g(paramAbsBaseArticleInfo))).a(paramAbsBaseArticleInfo.videoReportInfo);
      }
      localObject4 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      str = Long.toString(paramAbsBaseArticleInfo.mFeedId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.businessId);
      localStringBuilder.append("");
      ((IPublicAccountReportUtils)localObject4).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(l1), (String)localObject2, (String)localObject2, 0, 0, str, localStringBuilder.toString(), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((VideoR5.Builder)localObject3).a().a(), false);
      i = k;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, j, m, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), i, paramAbsBaseArticleInfo));
    paramActivity = new ArrayList();
    localObject1 = new ReportInfo();
    ((ReportInfo)localObject1).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    ((ReportInfo)localObject1).mSource = 0;
    ((ReportInfo)localObject1).mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    ((ReportInfo)localObject1).mChannelId = paramInt;
    ((ReportInfo)localObject1).mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    ((ReportInfo)localObject1).mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    ((ReportInfo)localObject1).mOperation = 1;
    ((ReportInfo)localObject1).mServerContext = paramAbsBaseArticleInfo.mServerContext;
    ((ReportInfo)localObject1).mReadTimeLength = -1;
    ((ReportInfo)localObject1).mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
    if ((!UGRuleManager.c(paramAbsBaseArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramAbsBaseArticleInfo))) {
      ((ReportInfo)localObject1).noDifferenceJump = 1;
    }
    if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
      ((ReportInfo)localObject1).mColumnID = paramAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localObject2 = new FeedsReportData();
      ((FeedsReportData)localObject2).jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
        ((FeedsReportData)localObject2).jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      }
      ((FeedsReportData)localObject2).jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((FeedsReportData)localObject2).jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      localObject3 = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        ((FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FeedsInfoUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            ((FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject4).jdField_a_of_type_Long));
          }
        }
      }
      ((ReportInfo)localObject1).mFeedsReportData = ((FeedsReportData)localObject2);
    }
    paramActivity.add(localObject1);
    ReadInJoyLogicEngine.a().a(paramActivity);
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo))
    {
      paramActivity = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
      localObject1 = (AdvertisementInfo)paramAbsBaseArticleInfo;
      if (paramActivity.checkConditionForJumpToGdt((AdvertisementInfo)localObject1, paramInt)) {
        paramInt = 8;
      } else if (RIJFeedsType.a(paramAbsBaseArticleInfo)) {
        paramInt = 11;
      } else {
        paramInt = 3;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplicationImpl.getContext()).a(1).b(paramInt).b(paramInteger).a((AdvertisementInfo)localObject1));
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mGroupSubArticleList != null))
    {
      if (paramAbsBaseArticleInfo.mGroupSubArticleList.isEmpty()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      int j = paramAbsBaseArticleInfo.mGroupSubArticleList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(i);
        String str = ((AbsBaseArticleInfo)localObject).getInnerUniqueID();
        int k = ((AbsBaseArticleInfo)localObject).mPolymericInfo.jdField_f_of_type_Int;
        if (((AbsBaseArticleInfo)localObject).mPolymericInfo.jdField_a_of_type_Boolean)
        {
          localStringBuilder.append(str);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("position：");
            ((StringBuilder)localObject).append(k);
            ((StringBuilder)localObject).append(", rowKey: ");
            ((StringBuilder)localObject).append(str);
            QLog.d("RIJFrameworkReportManager", 2, ((StringBuilder)localObject).toString());
          }
        }
        if ((j != 1) && (i != j - 1)) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
      localStringBuilder.append("]");
      paramAbsBaseArticleInfo = new VideoR5.Builder(paramString, null, null, null, null).W(54).j(localStringBuilder.toString()).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    a(paramAbsBaseArticleInfo, paramString1, paramString2, paramInt, null);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject2 = RIJFeedsType.c(paramAbsBaseArticleInfo);
      if (paramAbsBaseArticleInfo.hasChannelInfo()) {
        int i = paramAbsBaseArticleInfo.mChannelInfoId;
      }
      TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
      Object localObject1 = null;
      try
      {
        localObject2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramInt, NetworkUtil.isWifiConnected(null), (String)localObject2, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(paramAbsBaseArticleInfo), 0, RIJTransMergeKanDianReport.a(), paramAbsBaseArticleInfo);
        if ((paramMap != null) && (paramMap.entrySet() != null))
        {
          paramMap = paramMap.entrySet().iterator();
          while ((paramMap != null) && (paramMap.hasNext()))
          {
            Map.Entry localEntry = (Map.Entry)paramMap.next();
            ((JSONObject)localObject2).put((String)localEntry.getKey(), localEntry.getValue().toString());
          }
        }
        paramMap = ((JSONObject)localObject2).toString();
      }
      catch (Exception paramMap)
      {
        AIOUtils.a("ReadInJoyBaseAdapter", "reportClickEvent", new IllegalArgumentException(paramMap));
        paramMap = localObject1;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, RIJFeedsType.c(paramAbsBaseArticleInfo), paramString1, paramString2, 0, 0, RIJStringUtils.a(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.businessId), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), paramMap, false);
      ReadinjoyReportUtils.CoreReport.a(paramAbsBaseArticleInfo, paramInt);
    }
  }
  
  private void a(BaseReportData paramBaseReportData)
  {
    if (RIJFeedsType.B(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  private void a(BaseReportData paramBaseReportData, int paramInt)
  {
    if (paramBaseReportData.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        if (paramBaseReportData.jdField_d_of_type_Boolean)
        {
          JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
          localJSONObject.put("feeds_source", paramBaseReportData.jdField_a_of_type_JavaLangString);
          localJSONObject.put("kandian_mode", RIJAppSetting.a());
          if (!ReadinjoyReportUtils.a(paramInt)) {
            break label113;
          }
          str = "0X8009358";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", str, str, 0, 0, RIJFeedsType.d(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException paramBaseReportData)
      {
        paramBaseReportData.printStackTrace();
      }
      return;
      label113:
      String str = "0X800744E";
    }
  }
  
  private void a(BaseReportData paramBaseReportData, int paramInt, String paramString)
  {
    if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0)
    {
      ComponentContentRecommend.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt, paramString);
      return;
    }
    if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
    {
      ComponentContentRecommendFollowList.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt, paramString);
      return;
    }
    if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 2) {
      ComponentContentRecommendFollowGroup.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramInt, paramString);
    }
  }
  
  private void a(BaseReportData paramBaseReportData, Context paramContext, int paramInt)
  {
    if (RIJFeedsType.A(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      Object localObject1 = (AbsBaseArticleInfo)paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mGroupSubArticleList.get(0);
      paramContext = ReadinjoyReportUtils.a(paramContext, ((AbsBaseArticleInfo)localObject1).mArticleID, ((AbsBaseArticleInfo)localObject1).mAlgorithmID, 54, paramInt, ((AbsBaseArticleInfo)localObject1).getInnerUniqueID(), ((AbsBaseArticleInfo)localObject1).getVideoVid(), ReadinjoyReportUtils.a((AbsBaseArticleInfo)localObject1), ((AbsBaseArticleInfo)localObject1).videoReportInfo);
      try
      {
        localObject1 = new JSONObject(paramContext);
        boolean bool = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.isShowGif;
        if (bool) {
          ((JSONObject)localObject1).put("short_content_gif", 1);
        } else {
          ((JSONObject)localObject1).put("short_content_gif", 0);
        }
        localObject1 = ((JSONObject)localObject1).toString();
        paramContext = (Context)localObject1;
      }
      catch (JSONException localJSONException1)
      {
        QLog.e("RIJFrameworkReportManager", 2, localJSONException1.getMessage());
      }
      try
      {
        Object localObject2 = new JSONObject(paramContext);
        ((JSONObject)localObject2).put("account_expose_card", RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        localObject2 = ((JSONObject)localObject2).toString();
        paramContext = (Context)localObject2;
      }
      catch (JSONException localJSONException2)
      {
        QLog.e("RIJFrameworkReportManager", 2, localJSONException2.getMessage());
      }
      a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramContext);
      return;
    }
    paramContext = ReadinjoyReportUtils.a(paramContext, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoAdsSource, paramBaseReportData.k, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.videoReportInfo);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), Integer.toString(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), paramContext, false);
    paramBaseReportData = new VideoR5.Builder(null, null, null, null).W(54).j(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getInnerUniqueID()).w(paramBaseReportData.k + 1).f(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramBaseReportData, false);
  }
  
  private void a(BaseReportData paramBaseReportData, String paramString1, String paramString2)
  {
    int i = 0;
    while (i < paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
    {
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str1 = paramBaseReportData.jdField_d_of_type_JavaLangString;
      String str2 = Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(i)).jdField_a_of_type_Int);
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, paramString2, paramString2, 0, 0, str2, localStringBuilder.toString(), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), paramString1, false);
      i += 1;
    }
  }
  
  private void a(BaseReportData paramBaseReportData, String paramString1, String paramString2, Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (!paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      } else {
        paramString1 = "0";
      }
      localObject1 = RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), paramInt, 0, 0, NetworkUtil.isWifiConnected(paramContext), paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID, null, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, null, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
      localStringBuilder.append("");
      ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), (String)localObject1, false);
      paramString2 = ReadinjoyReportUtils.a(paramInt);
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      }
      paramContext = RIJTransMergeKanDianReport.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), paramInt, NetworkUtil.isWifiConnected(paramContext), paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, null, 0, paramBaseReportData.jdField_f_of_type_Int, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      if (!paramBoolean) {
        break label543;
      }
      paramInt = 1;
    }
    for (;;)
    {
      try
      {
        paramContext.put("from_aio", paramInt);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("RIJFrameworkReportManager", 2, localJSONException.getMessage());
      }
      paramContext = paramContext.toString();
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
      ((StringBuilder)localObject3).append("");
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, (String)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString(), paramContext, false);
      return;
      if (RIJFeedsType.E(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      }
      return;
      label543:
      paramInt = 0;
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      ((JSONObject)localObject).put("tab_source", paramString);
      ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.a());
      paramString = ((JSONObject)localObject).toString();
    }
    catch (JSONException paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("firstClassDeliverOperationReport:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("RIJFrameworkReportManager", 2, ((StringBuilder)localObject).toString());
      }
      paramString = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!paramString.contains("dailyJumpSrc")) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("dailyJumpSrc", a("dailyJumpSrc", paramString.split("&")));
        localJSONObject.put("jumpSuccess", paramInt1);
        localJSONObject.put("fullScheme", paramString);
        localJSONObject.put("isCancelJump", paramInt2);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("RIJFrameworkReportManager", 2, paramString.getMessage());
      }
    }
  }
  
  private void a(Map<Long, BaseReportData> paramMap, int paramInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (BaseReportData)paramMap.next();
      if (!((BaseReportData)localObject1).jdField_b_of_type_Boolean)
      {
        int i = 1;
        ((BaseReportData)localObject1).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((BaseReportData)localObject1).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = paramInt;
        localReportInfo.mAlgorithmId = ((int)((BaseReportData)localObject1).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((BaseReportData)localObject1).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((BaseReportData)localObject1).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString;
        if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject2;
        Object localObject3;
        if (paramInt == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject2 = new ReportInfo.VideoExtraRepoerData();
          if (paramLong != 0L) {
            i = 0;
          }
          ((ReportInfo.VideoExtraRepoerData)localObject2).jdField_c_of_type_Int = i;
          localObject2 = ((ReportInfo.VideoExtraRepoerData)localObject2).toString();
          localReportInfo.mInnerId = ((BaseReportData)localObject1).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("reportVideoUserOperationByOidbOfFeed--mUin:");
            ((StringBuilder)localObject3).append(localReportInfo.mUin);
            ((StringBuilder)localObject3).append("; mSource:");
            ((StringBuilder)localObject3).append(localReportInfo.mSource);
            ((StringBuilder)localObject3).append("; mOpSource:");
            ((StringBuilder)localObject3).append(localReportInfo.mOpSource);
            ((StringBuilder)localObject3).append("; mInnerId:");
            ((StringBuilder)localObject3).append(localReportInfo.mInnerId);
            ((StringBuilder)localObject3).append("; mChannelId:");
            ((StringBuilder)localObject3).append(localReportInfo.mChannelId);
            ((StringBuilder)localObject3).append("; mAlgorithmId:");
            ((StringBuilder)localObject3).append(localReportInfo.mAlgorithmId);
            ((StringBuilder)localObject3).append("; mStrategyId:");
            ((StringBuilder)localObject3).append(localReportInfo.mStrategyId);
            ((StringBuilder)localObject3).append("; mOperation:");
            ((StringBuilder)localObject3).append(localReportInfo.mOperation);
            ((StringBuilder)localObject3).append("; mPlayTimeLength:");
            ((StringBuilder)localObject3).append(localReportInfo.mPlayTimeLength);
            ((StringBuilder)localObject3).append("; videoExtraRepoerData:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("VideoReporter", 2, ((StringBuilder)localObject3).toString());
          }
        }
        if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          localObject2 = new FeedsReportData();
          ((FeedsReportData)localObject2).jdField_a_of_type_Long = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
            ((FeedsReportData)localObject2).jdField_b_of_type_Long = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
          }
          ((FeedsReportData)localObject2).jdField_a_of_type_Int = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((FeedsReportData)localObject2).jdField_b_of_type_Int = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject1 = ((BaseReportData)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            ((FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (FeedsInfoUser)((Iterator)localObject1).next();
              if (localObject3 != null) {
                ((FeedsReportData)localObject2).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject3).jdField_a_of_type_Long));
              }
            }
          }
          localReportInfo.mFeedsReportData = ((FeedsReportData)localObject2);
        }
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
  }
  
  private void a(Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = paramMap.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ReadinjoyReportUtils.ExposureReportItem)localIterator.next();
      AbsBaseArticleInfo localAbsBaseArticleInfo = ((ReadinjoyReportUtils.ExposureReportItem)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((!RIJFeedsType.h(localAbsBaseArticleInfo)) || (!localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
      {
        String str = RIJFeedsType.c(localAbsBaseArticleInfo);
        paramMap = localAbsBaseArticleInfo.innerUniqueID;
        Object localObject1 = paramMap;
        if (RIJFeedsType.A(localAbsBaseArticleInfo))
        {
          localObject1 = paramMap;
          if (localAbsBaseArticleInfo.mGroupSubArticleList.size() >= 1) {
            localObject1 = ((AbsBaseArticleInfo)localAbsBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        Object localObject3 = RIJFeedsType.e(localAbsBaseArticleInfo);
        if (((RIJItemViewTypeUtils.m(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.l(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(localAbsBaseArticleInfo))) && (!RIJItemViewTypeUtils.v(localAbsBaseArticleInfo))) {
          paramMap = String.valueOf(localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
        }
        for (;;)
        {
          break;
          if ((RIJFeedsType.z(localAbsBaseArticleInfo)) && (localAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
          {
            paramMap = new StringBuilder();
            paramMap.append(localAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
            paramMap.append("");
            paramMap = paramMap.toString();
          }
          else
          {
            paramMap = localAbsBaseArticleInfo.mSubscribeID;
          }
        }
        localObject1 = RIJTransMergeKanDianReport.a(localAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(localAbsBaseArticleInfo), (int)localAbsBaseArticleInfo.mChannelID, NetworkState.isWifiConn(), str, (String)localObject1, (String)localObject3, 0, ((ReadinjoyReportUtils.ExposureReportItem)localObject2).jdField_a_of_type_Int, localAbsBaseArticleInfo);
        str = a(localAbsBaseArticleInfo.mChannelID);
        try
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append((float)((ReadinjoyReportUtils.ExposureReportItem)localObject2).jdField_a_of_type_Long / 1000.0F);
          ((JSONObject)localObject1).put("exposure_time", ((StringBuilder)localObject3).toString());
          if (DailyModeConfigHandler.c((int)localAbsBaseArticleInfo.mChannelID)) {
            ((JSONObject)localObject1).put("cmd", ReadInJoyHelper.c());
          }
          localObject2 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject3 = Long.toString(localAbsBaseArticleInfo.mFeedId);
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mArticleID);
          ((StringBuilder)localObject4).append("");
          localObject4 = ((StringBuilder)localObject4).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
          localStringBuilder.append("");
          ((IPublicAccountReportUtils)localObject2).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramMap, str, str, 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), ((JSONObject)localObject1).toString(), false);
        }
        catch (JSONException paramMap)
        {
          paramMap.printStackTrace();
        }
      }
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    String str = ReadinjoyReportUtils.b(paramInt);
    a(paramAbsBaseArticleInfo, str, str, paramInt);
  }
  
  private void b(BaseReportData paramBaseReportData)
  {
    if ((paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo != null)) {
      RIJMedalUtils.a(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo, paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    }
  }
  
  private void b(BaseReportData paramBaseReportData, Context paramContext, int paramInt)
  {
    if ((paramBaseReportData.jdField_c_of_type_Int == 48) || (paramBaseReportData.jdField_c_of_type_Int == 49) || (paramBaseReportData.jdField_c_of_type_Int == 50) || (paramBaseReportData.jdField_c_of_type_Int == 51) || (paramBaseReportData.jdField_c_of_type_Int == 52) || (paramBaseReportData.jdField_c_of_type_Int == 53) || (paramBaseReportData.jdField_c_of_type_Int == 78) || (paramBaseReportData.jdField_c_of_type_Int == 79) || (paramBaseReportData.jdField_c_of_type_Int == 80) || (paramBaseReportData.jdField_c_of_type_Int == 1005) || (paramBaseReportData.jdField_c_of_type_Int == 1006) || (paramBaseReportData.jdField_c_of_type_Int == 1007))
    {
      long l4 = paramBaseReportData.jdField_b_of_type_Long;
      int i = paramBaseReportData.k;
      int j = GalleryReportedUtils.a(paramInt, paramBaseReportData.jdField_c_of_type_Int);
      int k = GalleryReportedUtils.a(paramBaseReportData.jdField_c_of_type_Int);
      long l1;
      String str1;
      String str2;
      long l2;
      long l3;
      if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        l1 = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
        str1 = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
        str2 = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.galleryReprotExdData;
        l2 = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID;
        l3 = l1;
      }
      else
      {
        str1 = null;
        str2 = str1;
        l1 = 0L;
        l3 = l1;
        l2 = l1;
      }
      paramContext = GalleryReportedUtils.a(paramContext, ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), j, l3, l4, i, str1, str2, k, paramInt);
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      paramBaseReportData = paramBaseReportData.jdField_d_of_type_JavaLangString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l2);
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, paramBaseReportData, "0X8008E2E", "0X8008E2E", 0, 0, "", (String)localObject, localStringBuilder.toString(), paramContext, false);
      GalleryReportedUtils.a(7, ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), (int)l2, j, l4, i, str1, str2);
    }
  }
  
  private void b(BaseReportData paramBaseReportData, String paramString1, String paramString2)
  {
    if (paramBaseReportData != null)
    {
      if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      try
      {
        if ((RecycleViewAdapterHelper.a() != null) && (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mProteusTemplateBean != null)
          {
            localObject1 = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
            if ((localObject1 != null) && (((Map)localObject1).entrySet() != null))
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while ((localObject1 != null) && (((Iterator)localObject1).hasNext()))
              {
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                paramString1.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue().toString());
              }
            }
          }
          Object localObject1 = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList;
          Object localObject2 = RecycleViewAdapterHelper.a().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject2).next();
            if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
            {
              paramString1.put("rowkey", ((NewPolymericInfo.PackArticleInfo)((List)localObject1).get(localInteger.intValue())).g);
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramBaseReportData.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), Long.toString(paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(paramBaseReportData.jdField_b_of_type_Int), paramString1.toString(), false);
            }
          }
          RecycleViewAdapterHelper.a();
          return;
        }
      }
      catch (JSONException paramBaseReportData)
      {
        QLog.e("RIJFrameworkReportManager", 2, paramBaseReportData.getMessage());
      }
    }
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = RIJQQAppInterfaceUtil.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    localReportInfo.mChannelId = paramInt;
    localReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    localReportInfo.mOperation = 1;
    localReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
    localReportInfo.mReadTimeLength = -1;
    localReportInfo.mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      FeedsReportData localFeedsReportData = new FeedsReportData();
      localFeedsReportData.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
        localFeedsReportData.jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      }
      localFeedsReportData.jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      localFeedsReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
      {
        localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
        while (paramAbsBaseArticleInfo.hasNext())
        {
          FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
          if (localFeedsInfoUser != null) {
            localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
    }
    localArrayList.add(localReportInfo);
    ReadInJoyLogicEngine.a().a(localArrayList);
  }
  
  public static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).W(54).j(paramAbsBaseArticleInfo.getInnerUniqueID()).w(paramInt + 1).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
  }
  
  public static void e(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mVideoColumnInfo == null) {
        return;
      }
      paramAbsBaseArticleInfo = new VideoR5.Builder(null, null, null, null).j(paramAbsBaseArticleInfo.innerUniqueID).c(paramAbsBaseArticleInfo).d(paramAbsBaseArticleInfo).R(paramInt).a(paramAbsBaseArticleInfo.videoReportInfo).a(paramAbsBaseArticleInfo, false).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", paramAbsBaseArticleInfo, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (DailyModeConfigHandler.c(paramInt1))
    {
      if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) == 0)
      {
        KandianDailyReportUtils.a(1);
        return;
      }
      if (paramInt2 != 2) {
        KandianDailyReportUtils.a(1);
      }
    }
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo;
        int j = ChannelCoverView.jdField_b_of_type_Int;
        int i;
        if ((localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo != null) && (localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.redPoint != null) && (localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {
          i = localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;
        } else {
          i = 0;
        }
        ChannelCoverView.a("0X8009495", localTabChannelCoverInfo, j, i, -1);
      }
    }
  }
  
  /* Error */
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 275
    //   3: astore 25
    //   5: aload_1
    //   6: ifnull +1134 -> 1140
    //   9: aload_1
    //   10: invokeinterface 1193 1 0
    //   15: ifne +1125 -> 1140
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: goto +1118 -> 1140
    //   25: aload_1
    //   26: invokeinterface 1007 1 0
    //   31: invokeinterface 1010 1 0
    //   36: astore 28
    //   38: aload 25
    //   40: astore_1
    //   41: iload 6
    //   43: istore 7
    //   45: aload 28
    //   47: invokeinterface 559 1 0
    //   52: ifeq +1082 -> 1134
    //   55: aload 28
    //   57: invokeinterface 563 1 0
    //   62: checkcast 93	com/tencent/mobileqq/kandian/repo/report/BaseReportData
    //   65: astore 27
    //   67: aload 27
    //   69: getfield 1194	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_Boolean	Z
    //   72: ifne +1059 -> 1131
    //   75: aload 27
    //   77: iconst_1
    //   78: putfield 1194	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_Boolean	Z
    //   81: aload 27
    //   83: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   86: ifnull +52 -> 138
    //   89: aload 27
    //   91: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   94: getfield 1198	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   97: ifnull +41 -> 138
    //   100: aload 27
    //   102: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   105: getfield 1198	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   108: getfield 1204	tencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo:enum_article_style	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   111: invokevirtual 1208	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   114: istore 8
    //   116: aload 27
    //   118: sipush 1008
    //   121: putfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   124: iload 8
    //   126: iconst_5
    //   127: if_icmpne +11 -> 138
    //   130: aload 27
    //   132: sipush 1009
    //   135: putfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   138: ldc_w 299
    //   141: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   144: checkcast 299	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   147: aconst_null
    //   148: ldc_w 307
    //   151: ldc_w 309
    //   154: ldc_w 309
    //   157: ldc_w 1210
    //   160: ldc_w 1210
    //   163: iconst_0
    //   164: iconst_0
    //   165: ldc_w 309
    //   168: aload 27
    //   170: getfield 1015	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   173: invokevirtual 371	java/lang/Long:longValue	()J
    //   176: invokestatic 467	java/lang/Long:toString	(J)Ljava/lang/String;
    //   179: aload 27
    //   181: getfield 950	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_Int	I
    //   184: invokestatic 470	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   187: aload 27
    //   189: getfield 1016	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_Long	J
    //   192: aload 27
    //   194: getfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   197: iload 7
    //   199: aload 27
    //   201: getfield 1211	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_Int	I
    //   204: invokestatic 1213	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIII)Ljava/lang/String;
    //   207: iconst_0
    //   208: invokeinterface 332 14 0
    //   213: ldc_w 299
    //   216: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   219: checkcast 299	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   222: ldc_w 1210
    //   225: ldc_w 309
    //   228: ldc_w 309
    //   231: aload 27
    //   233: getfield 1015	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   236: invokevirtual 371	java/lang/Long:longValue	()J
    //   239: invokestatic 467	java/lang/Long:toString	(J)Ljava/lang/String;
    //   242: aload 27
    //   244: getfield 950	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_Int	I
    //   247: invokestatic 470	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   250: aload 27
    //   252: getfield 1016	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_Long	J
    //   255: aload 27
    //   257: getfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   260: iload 7
    //   262: aload 27
    //   264: getfield 1211	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_Int	I
    //   267: invokestatic 1213	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIII)Ljava/lang/String;
    //   270: invokeinterface 339 7 0
    //   275: aload 27
    //   277: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   280: ifnonnull +6 -> 286
    //   283: goto -242 -> 41
    //   286: aload 27
    //   288: getfield 1016	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_Long	J
    //   291: aload 27
    //   293: getfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   296: iload 6
    //   298: aload 27
    //   300: getfield 1211	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_Int	I
    //   303: aload 27
    //   305: getfield 1215	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_e_of_type_Int	I
    //   308: aload 5
    //   310: invokestatic 484	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   313: aload 27
    //   315: getfield 855	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   318: aload 27
    //   320: getfield 1217	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   323: aload 27
    //   325: getfield 1019	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   328: aload 27
    //   330: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   333: invokestatic 489	com/tencent/mobileqq/kandian/repo/feeds/RIJFeedsType:e	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Ljava/lang/String;
    //   336: aload 27
    //   338: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   341: lconst_0
    //   342: iconst_m1
    //   343: aload 27
    //   345: getfield 970	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_f_of_type_Int	I
    //   348: aload 27
    //   350: getfield 1219	com/tencent/mobileqq/kandian/repo/report/BaseReportData:g	I
    //   353: aload 27
    //   355: getfield 1221	com/tencent/mobileqq/kandian/repo/report/BaseReportData:h	I
    //   358: aload 27
    //   360: getfield 1223	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_f_of_type_Boolean	Z
    //   363: aload 27
    //   365: getfield 1225	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   368: aload 27
    //   370: getfield 1228	com/tencent/mobileqq/kandian/repo/report/BaseReportData:i	I
    //   373: aload 27
    //   375: getfield 1230	com/tencent/mobileqq/kandian/repo/report/BaseReportData:m	I
    //   378: invokestatic 1233	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   381: astore 26
    //   383: new 215	org/json/JSONObject
    //   386: dup
    //   387: aload 26
    //   389: invokespecial 216	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   392: astore 25
    //   394: aload 25
    //   396: ldc_w 1235
    //   399: aload 27
    //   401: getfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   404: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   407: pop
    //   408: aload 25
    //   410: ldc 218
    //   412: aload 4
    //   414: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 25
    //   420: invokevirtual 268	org/json/JSONObject:toString	()Ljava/lang/String;
    //   423: astore 25
    //   425: goto +29 -> 454
    //   428: astore 25
    //   430: goto +10 -> 440
    //   433: astore 25
    //   435: goto +5 -> 440
    //   438: astore 25
    //   440: aload_1
    //   441: iconst_2
    //   442: aload 25
    //   444: invokevirtual 907	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   447: invokestatic 909	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 26
    //   452: astore 25
    //   454: iload 6
    //   456: i2l
    //   457: invokestatic 84	com/tencent/mobileqq/kandian/glue/report/ReadinjoyReportUtils:a	(J)Z
    //   460: ifeq +11 -> 471
    //   463: ldc_w 1237
    //   466: astore 26
    //   468: goto +8 -> 476
    //   471: ldc_w 934
    //   474: astore 26
    //   476: new 109	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder
    //   479: dup
    //   480: aload 25
    //   482: invokespecial 112	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:<init>	(Ljava/lang/String;)V
    //   485: astore 25
    //   487: aload 25
    //   489: aload 27
    //   491: getfield 1239	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   494: invokevirtual 1241	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder;
    //   497: aload 27
    //   499: getfield 1239	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   502: invokevirtual 932	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:f	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder;
    //   505: pop
    //   506: ldc_w 299
    //   509: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   512: checkcast 299	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   515: aconst_null
    //   516: ldc_w 307
    //   519: ldc_w 309
    //   522: aload 27
    //   524: getfield 925	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   527: aload 26
    //   529: aload 26
    //   531: iconst_0
    //   532: iconst_0
    //   533: aload 27
    //   535: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   538: getfield 505	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   541: invokestatic 467	java/lang/Long:toString	(J)Ljava/lang/String;
    //   544: aload 27
    //   546: getfield 1015	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   549: invokevirtual 371	java/lang/Long:longValue	()J
    //   552: invokestatic 467	java/lang/Long:toString	(J)Ljava/lang/String;
    //   555: aload 27
    //   557: getfield 950	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_Int	I
    //   560: invokestatic 470	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   563: aload 25
    //   565: invokevirtual 147	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:a	()Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5;
    //   568: invokevirtual 152	com/tencent/mobileqq/kandian/glue/video/report/VideoR5:a	()Ljava/lang/String;
    //   571: iconst_0
    //   572: invokeinterface 332 14 0
    //   577: ldc_w 299
    //   580: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   583: checkcast 299	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   586: astore 29
    //   588: aload 27
    //   590: getfield 925	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   593: astore 30
    //   595: aload 27
    //   597: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   600: getfield 505	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   603: invokestatic 467	java/lang/Long:toString	(J)Ljava/lang/String;
    //   606: astore 31
    //   608: aload 27
    //   610: getfield 1015	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   613: invokevirtual 371	java/lang/Long:longValue	()J
    //   616: invokestatic 467	java/lang/Long:toString	(J)Ljava/lang/String;
    //   619: astore 32
    //   621: aload 27
    //   623: getfield 950	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_Int	I
    //   626: invokestatic 470	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   629: astore 33
    //   631: aload 27
    //   633: getfield 1016	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_Long	J
    //   636: lstore 17
    //   638: aload 27
    //   640: getfield 1093	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_Int	I
    //   643: istore 7
    //   645: aload 27
    //   647: getfield 1211	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_Int	I
    //   650: istore 8
    //   652: aload 27
    //   654: getfield 1215	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_e_of_type_Int	I
    //   657: istore 9
    //   659: aload 5
    //   661: invokestatic 484	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   664: istore_2
    //   665: aload 27
    //   667: getfield 855	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   670: astore 34
    //   672: aload 27
    //   674: getfield 1217	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   677: astore 35
    //   679: aload 27
    //   681: getfield 1019	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   684: astore 36
    //   686: aload 27
    //   688: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   691: invokestatic 489	com/tencent/mobileqq/kandian/repo/feeds/RIJFeedsType:e	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Ljava/lang/String;
    //   694: astore 37
    //   696: aload 27
    //   698: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   701: astore 38
    //   703: aload 27
    //   705: getfield 970	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_f_of_type_Int	I
    //   708: istore 10
    //   710: aload 27
    //   712: getfield 1219	com/tencent/mobileqq/kandian/repo/report/BaseReportData:g	I
    //   715: istore 11
    //   717: aload 27
    //   719: getfield 1221	com/tencent/mobileqq/kandian/repo/report/BaseReportData:h	I
    //   722: istore 12
    //   724: aload 27
    //   726: getfield 1223	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_f_of_type_Boolean	Z
    //   729: istore 16
    //   731: aload 27
    //   733: getfield 1225	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   736: istore 13
    //   738: aload 27
    //   740: getfield 1228	com/tencent/mobileqq/kandian/repo/report/BaseReportData:i	I
    //   743: istore 14
    //   745: aload 27
    //   747: getfield 1230	com/tencent/mobileqq/kandian/repo/report/BaseReportData:m	I
    //   750: istore 15
    //   752: aload_1
    //   753: astore 25
    //   755: aload 29
    //   757: aload 26
    //   759: aload 30
    //   761: aload 31
    //   763: aload 32
    //   765: aload 33
    //   767: lload 17
    //   769: iload 7
    //   771: iload 6
    //   773: iload 8
    //   775: iload 9
    //   777: iload_2
    //   778: aload 34
    //   780: aload 35
    //   782: aload 36
    //   784: aload 37
    //   786: aload 38
    //   788: lconst_0
    //   789: iconst_m1
    //   790: iload 10
    //   792: iload 11
    //   794: iload 12
    //   796: iload 16
    //   798: iload 13
    //   800: iload 14
    //   802: iload 15
    //   804: invokestatic 1233	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   807: invokeinterface 339 7 0
    //   812: aload 25
    //   814: astore_1
    //   815: aload 27
    //   817: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   820: ifnull +311 -> 1131
    //   823: aload 25
    //   825: astore_1
    //   826: aload 27
    //   828: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   831: getfield 1198	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   834: ifnull +297 -> 1131
    //   837: aload 27
    //   839: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   842: getfield 1198	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   845: getfield 1204	tencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo:enum_article_style	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   848: invokevirtual 1208	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   851: iconst_5
    //   852: if_icmpne +10 -> 862
    //   855: bipush 12
    //   857: istore 7
    //   859: goto +7 -> 866
    //   862: bipush 8
    //   864: istore 7
    //   866: aload 27
    //   868: getfield 1094	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_b_of_type_Long	J
    //   871: lstore 23
    //   873: aload 27
    //   875: getfield 920	com/tencent/mobileqq/kandian/repo/report/BaseReportData:k	I
    //   878: istore 8
    //   880: aload 27
    //   882: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   885: ifnull +49 -> 934
    //   888: aload 27
    //   890: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   893: getfield 249	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   896: lstore 17
    //   898: aload 27
    //   900: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   903: getfield 141	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   906: astore_1
    //   907: aload 27
    //   909: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   912: getfield 1105	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:galleryReprotExdData	Ljava/lang/String;
    //   915: astore 26
    //   917: aload 27
    //   919: getfield 96	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   922: getfield 473	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mAlgorithmID	J
    //   925: lstore 19
    //   927: lload 17
    //   929: lstore 21
    //   931: goto +19 -> 950
    //   934: aconst_null
    //   935: astore_1
    //   936: aload_1
    //   937: astore 26
    //   939: lconst_0
    //   940: lstore 17
    //   942: lload 17
    //   944: lstore 21
    //   946: lload 17
    //   948: lstore 19
    //   950: aload 5
    //   952: ldc_w 682
    //   955: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   958: checkcast 682	com/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils
    //   961: invokeinterface 685 1 0
    //   966: bipush 16
    //   968: lload 21
    //   970: lload 23
    //   972: iload 8
    //   974: aload_1
    //   975: aload 26
    //   977: iload 7
    //   979: iload 6
    //   981: invokestatic 1108	com/tencent/mobileqq/kandian/glue/report/GalleryReportedUtils:a	(Landroid/content/Context;JIJJILjava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   984: astore 29
    //   986: ldc_w 299
    //   989: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   992: checkcast 299	com/tencent/mobileqq/kandian/biz/common/api/IPublicAccountReportUtils
    //   995: astore 30
    //   997: aload 27
    //   999: getfield 925	com/tencent/mobileqq/kandian/repo/report/BaseReportData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1002: astore 27
    //   1004: new 621	java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial 622	java/lang/StringBuilder:<init>	()V
    //   1011: astore 31
    //   1013: aload 31
    //   1015: lload 21
    //   1017: invokevirtual 680	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 31
    //   1023: ldc_w 309
    //   1026: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: pop
    //   1030: aload 31
    //   1032: invokevirtual 630	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1035: astore 31
    //   1037: new 621	java/lang/StringBuilder
    //   1040: dup
    //   1041: invokespecial 622	java/lang/StringBuilder:<init>	()V
    //   1044: astore 32
    //   1046: aload 32
    //   1048: lload 19
    //   1050: invokevirtual 680	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload 32
    //   1056: ldc_w 309
    //   1059: invokevirtual 626	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload 30
    //   1065: aconst_null
    //   1066: aload 27
    //   1068: ldc_w 1110
    //   1071: ldc_w 1110
    //   1074: iconst_0
    //   1075: iconst_0
    //   1076: ldc_w 309
    //   1079: aload 31
    //   1081: aload 32
    //   1083: invokevirtual 630	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: aload 29
    //   1088: iconst_0
    //   1089: invokeinterface 350 12 0
    //   1094: bipush 7
    //   1096: ldc_w 682
    //   1099: invokestatic 305	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1102: checkcast 682	com/tencent/mobileqq/kandian/biz/framework/api/IReadInJoyUtils
    //   1105: invokeinterface 685 1 0
    //   1110: lload 19
    //   1112: l2i
    //   1113: bipush 16
    //   1115: lload 23
    //   1117: iload 8
    //   1119: aload_1
    //   1120: aload 26
    //   1122: invokestatic 1113	com/tencent/mobileqq/kandian/glue/report/GalleryReportedUtils:a	(IJIIJILjava/lang/String;Ljava/lang/String;)V
    //   1125: aload 25
    //   1127: astore_1
    //   1128: goto +3 -> 1131
    //   1131: goto -1090 -> 41
    //   1134: aload_0
    //   1135: aload_3
    //   1136: invokevirtual 1243	com/tencent/mobileqq/kandian/glue/report/RIJFrameworkReportManager:b	(Ljava/util/Map;)V
    //   1139: return
    //   1140: ldc_w 275
    //   1143: iconst_2
    //   1144: ldc_w 1245
    //   1147: invokestatic 283	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1150: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1151	0	this	RIJFrameworkReportManager
    //   0	1151	1	paramMap	Map<Long, BaseReportData>
    //   0	1151	2	paramBoolean	boolean
    //   0	1151	3	paramMap1	Map<Long, ReadinjoyReportUtils.ExposureReportItem>
    //   0	1151	4	paramString	String
    //   0	1151	5	paramContext	Context
    //   0	1151	6	paramInt	int
    //   43	935	7	i	int
    //   114	1004	8	j	int
    //   657	119	9	k	int
    //   708	83	10	m	int
    //   715	78	11	n	int
    //   722	73	12	i1	int
    //   736	63	13	i2	int
    //   743	58	14	i3	int
    //   750	53	15	i4	int
    //   729	68	16	bool	boolean
    //   636	311	17	l1	long
    //   925	186	19	l2	long
    //   929	87	21	l3	long
    //   871	245	23	l4	long
    //   3	421	25	localObject1	Object
    //   428	1	25	localJSONException1	JSONException
    //   433	1	25	localJSONException2	JSONException
    //   438	5	25	localJSONException3	JSONException
    //   452	674	25	localObject2	Object
    //   381	740	26	localObject3	Object
    //   65	1002	27	localObject4	Object
    //   36	20	28	localIterator	Iterator
    //   586	501	29	localObject5	Object
    //   593	471	30	localObject6	Object
    //   606	474	31	localObject7	Object
    //   619	463	32	localObject8	Object
    //   629	137	33	str1	String
    //   670	109	34	str2	String
    //   677	104	35	str3	String
    //   684	99	36	str4	String
    //   694	91	37	str5	String
    //   701	86	38	localAbsBaseArticleInfo	AbsBaseArticleInfo
    // Exception table:
    //   from	to	target	type
    //   408	425	428	org/json/JSONException
    //   394	408	433	org/json/JSONException
    //   383	394	438	org/json/JSONException
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean1, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, Context paramContext, int paramInt1, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean2, long paramLong)
  {
    Object localObject1 = this;
    Context localContext = paramContext;
    int i = paramInt1;
    boolean bool = paramBoolean2;
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramBoolean1))
    {
      RIJVideoReportManager.a(paramMap, i, paramReadInJoyBaseViewController.a());
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)localIterator.next();
        if (!localBaseReportData.jdField_a_of_type_Boolean)
        {
          localBaseReportData.jdField_a_of_type_Boolean = true;
          Object localObject2 = ((RIJFrameworkReportManager)localObject1).a(localContext, i);
          long l1 = ((Long)((Pair)localObject2).second).longValue();
          int j = ((Integer)((Pair)localObject2).first).intValue();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, i, localBaseReportData.jdField_d_of_type_Int), false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FC", "", "", Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localBaseReportData.jdField_b_of_type_Int), RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, i, localBaseReportData.jdField_d_of_type_Int));
          if (localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
          {
            String str1 = RIJTransMergeKanDianReport.a(localBaseReportData.jdField_a_of_type_Long, localBaseReportData.jdField_c_of_type_Int, paramInt1, localBaseReportData.jdField_d_of_type_Int, localBaseReportData.jdField_e_of_type_Int, NetworkUtil.isWifiConnected(paramContext), localBaseReportData.jdField_a_of_type_JavaLangString, localBaseReportData.jdField_c_of_type_JavaLangString, localBaseReportData.jdField_e_of_type_JavaLangString, RIJFeedsType.e(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, l1, j, localBaseReportData.jdField_f_of_type_Int, localBaseReportData.g, localBaseReportData.h, localBaseReportData.jdField_f_of_type_Boolean, localBaseReportData.j, localBaseReportData.i, localBaseReportData.m);
            if (i == 56)
            {
              localObject2 = RIJVideoReportManager.a(localBaseReportData, str1, paramReadInJoyBaseViewController.a());
            }
            else
            {
              localObject2 = str1;
              if (i == 0) {
                localObject2 = ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, str1);
              }
            }
            localObject2 = a(paramMap1, paramString, localBaseReportData, (String)localObject2, paramInt1);
            str1 = RIJMsgReport.a.b((String)localObject2);
            long l2 = i;
            if (ReadinjoyReportUtils.a(l2)) {
              localObject2 = "0X8009354";
            } else {
              localObject2 = "0X8007626";
            }
            if ((DailyModeConfigHandler.a(paramInt1)) || (RIJShowKanDianTabSp.a(l2))) {
              localObject2 = "0X8009CC8";
            }
            if (RIJItemViewTypeUtils.t(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
              ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, str1, (String)localObject2);
            }
            for (;;)
            {
              break label910;
              if (RIJFeedsType.C(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
              {
                ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, localContext, i);
              }
              else if (RIJFeedsType.J(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
              {
                ((RIJFrameworkReportManager)localObject1).b(localBaseReportData, str1, (String)localObject2);
              }
              else if (RIJFeedsType.h(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
              {
                a(localBaseReportData, str1, (String)localObject2, paramContext, paramInt1, paramBoolean2);
              }
              else if (RIJFeedsType.K(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
              {
                ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, i, (String)localObject2);
              }
              else if (localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 33)
              {
                localObject2 = localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getProteusItemData();
                if (localObject2 == null) {
                  return;
                }
                RIJVideoReportManager.a(false, (JSONObject)localObject2, localBaseReportData);
                RIJVideoReportManager.a(true, (JSONObject)localObject2, localBaseReportData);
              }
              else if (RIJFeedsType.H(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
              {
                RIJVideoReportManager.a(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, localBaseReportData);
              }
              else
              {
                if (RIJFeedsType.z(localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
                {
                  localObject1 = localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
                  JSONObject localJSONObject = RIJKanDianFolderStatus.getPolymericCommonR5Report(((AbsBaseArticleInfo)localObject1).mPolymericInfo);
                  IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
                  String str2 = localBaseReportData.jdField_d_of_type_JavaLangString;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(localBaseReportData.k);
                  localStringBuilder.append("");
                  localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", str2, "0X8008F57", "0X8008F57", 0, 0, localStringBuilder.toString(), Long.toString(localBaseReportData.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(((AbsBaseArticleInfo)localObject1).mPolymericInfo.d), localJSONObject.toString(), false);
                  if (localHashMap.containsKey(Long.valueOf(((AbsBaseArticleInfo)localObject1).mPolymericInfo.c)))
                  {
                    localObject1 = this;
                    break;
                  }
                  localHashMap.put(Long.valueOf(((AbsBaseArticleInfo)localObject1).mPolymericInfo.c), Boolean.valueOf(true));
                }
                RIJVideoReportManager.a(localBaseReportData, l1, j, str1, (String)localObject2, paramContext, paramInt1, paramInt2, paramReadInJoyBaseViewController, paramBoolean2);
                localObject1 = this;
              }
            }
            label910:
            j = i;
            ((RIJFrameworkReportManager)localObject1).b(localBaseReportData, localContext, j);
            ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, j);
            ((RIJFrameworkReportManager)localObject1).a(localBaseReportData);
            ((RIJFrameworkReportManager)localObject1).b(localBaseReportData);
          }
        }
      }
      if (i != 40677) {
        ((RIJFrameworkReportManager)localObject1).a(paramMap, i, paramLong);
      }
      ((RIJFrameworkReportManager)localObject1).a(paramMap1, bool);
      ReadinjoySocialMsgCard.a(((Integer)((RIJFrameworkReportManager)localObject1).a(localContext, i).first).intValue());
      return;
    }
    QLog.d("RIJFrameworkReportManager", 2, "report data is null ");
    if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
      ((RIJFrameworkReportManager)localObject1).a(paramMap1, bool);
    }
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean1, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, boolean paramBoolean2, int paramInt1, Context paramContext, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean3, long paramLong)
  {
    ThreadManager.post(new RIJFrameworkReportManager.2(this, paramBoolean2, paramMap, paramBoolean1, paramMap1, paramString, paramContext, paramInt1, paramInt2, paramReadInJoyBaseViewController, paramBoolean3, paramLong), 5, null, false);
  }
  
  public void b(Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap)
  {
    a(paramMap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager
 * JD-Core Version:    0.7.0.1
 */