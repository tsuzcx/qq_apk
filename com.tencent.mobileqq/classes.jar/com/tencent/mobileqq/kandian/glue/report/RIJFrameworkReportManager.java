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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgCard;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
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
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
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
      if (paramContext.o() > 0L) {
        l1 = paramContext.o();
      } else {
        l1 = System.currentTimeMillis() - paramContext.p();
      }
      j = paramContext.q() ^ true;
    }
    else if ((paramContext instanceof SplashActivity))
    {
      paramContext = (RIJTabFrameBase)RIJJumpUtils.a(paramContext);
      l1 = l2;
      if (paramContext != null)
      {
        paramContext = paramContext.o();
        if (paramContext.a() != 0) {
          j = 0;
        } else {
          j = 1;
        }
        l1 = paramContext.b();
      }
    }
    else
    {
      l1 = l2;
      if (DailyModeConfigHandler.c(paramInt)) {
        if (KandianDailyReportUtils.f() != 0)
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
      if (ReadinjoyReportUtils.d(paramLong)) {
        return "0X8009356";
      }
      return "0X8009332";
    }
    return "0X8009CCB";
  }
  
  private String a(BaseReportData paramBaseReportData, String paramString)
  {
    int i = RIJBaseItemViewType.c(paramBaseReportData.l);
    String str;
    if ((i != 6) && (i != 66) && (i != 115) && (i != 28) && (i != 11) && (i != 26) && (i != 19))
    {
      if ((i != 46) && (!paramBaseReportData.l.isTwoItem))
      {
        if (i == 118)
        {
          paramString = new VideoR5.Builder(paramString);
          if (paramBaseReportData.l.mVideoColumnInfo != null)
          {
            paramString.Z(paramBaseReportData.l.mVideoColumnInfo.b);
            if (paramBaseReportData.l.mVideoColumnInfo.n != null) {
              paramString.r(paramBaseReportData.l.mVideoColumnInfo.n.f);
            }
          }
          paramString.k(paramBaseReportData.l.innerUniqueID);
          str = paramString.b().a();
        }
        else
        {
          str = paramString;
          if (i == 128)
          {
            paramString = new VideoR5.Builder(paramString);
            if (paramBaseReportData.l.mSimpleVideoColumnInfo != null)
            {
              paramString.Z(paramBaseReportData.l.mSimpleVideoColumnInfo.b);
              if (paramBaseReportData.l.mSimpleVideoColumnInfo.o != null) {
                paramString.r(paramBaseReportData.l.mSimpleVideoColumnInfo.o.f);
              }
            }
            paramString.k(paramBaseReportData.l.innerUniqueID);
            str = paramString.b().a();
          }
        }
      }
      else
      {
        paramString = new VideoR5.Builder(paramString);
        paramString.g(paramBaseReportData.l.mVideoVid);
        paramString.X(RIJFeedsType.g(paramBaseReportData.l));
        paramString.b(paramBaseReportData.l.videoReportInfo);
        if (i == 46) {
          paramString.aa(0);
        } else {
          paramString.aa(1);
        }
        paramString.e(paramBaseReportData.l);
        str = paramString.b().a();
      }
    }
    else {
      str = VideoReporter.b(VideoReporter.a(paramBaseReportData.l), paramString);
    }
    paramBaseReportData = str;
    if (i == 6)
    {
      paramBaseReportData = new VideoR5.Builder(str);
      paramBaseReportData.ab(VideoFeedsHelper.k());
      paramBaseReportData = paramBaseReportData.b().a();
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
        localJSONObject.put("is_change", ChannelListDynamicOrderConfigHandler.b(ReadInJoyUtils.b(), paramInt));
        if (paramBaseReportData.l != null)
        {
          bool = paramBaseReportData.l.isPGCShortContent();
          if ((TextUtils.isEmpty(paramBaseReportData.l.proteusItemsData)) || (!paramBaseReportData.l.proteusItemsData.contains("article_main_body_text"))) {
            break label170;
          }
          paramInt = 1;
          break label173;
          paramMap = (ReadinjoyReportUtils.ExposureReportItem)paramMap.get(Long.valueOf(paramBaseReportData.l.mArticleID));
          if ((paramMap != null) && (paramMap.a == paramBaseReportData.l)) {
            localJSONObject.put("main_text_read_time", paramMap.b);
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
      label170:
      paramInt = 0;
      label173:
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
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.a(paramInt1, paramString, paramInt2, paramInt3, false, -1).build(), false);
      PublicAccountReportUtils.a("0X8009294", "", "", "", "", RIJTransMergeKanDianReport.b(paramInt1));
    }
    if (paramInt1 == 56) {
      PublicAccountReportUtils.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", VideoReporter.a(paramInt1, null), false);
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
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
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
      if (RIJXTabConfigHandler.INSTANCE.isXTabMode()) {
        localReportInfo.mChannelId = RIJXTabBadgeStore.a.c();
      }
      if (localReportInfo.mChannelId == -1) {
        localReportInfo.mChannelId = 0;
      }
      localArrayList.add(localReportInfo);
      UserOperationModule.getInstance().request0x64eKandianActionReport(localArrayList, RIJKanDianFolderStatus.reportFolderStatus);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("RIJFrameworkReportManager", 1, "reportRealTimeKandianAction error ", paramString1);
    }
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X800A189";
    } else {
      str = "0X800A18A";
    }
    PublicAccountReportUtils.a(null, null, str, str, 0, 0, "", "", "", new VideoR5.Builder(null, null, null, null).e(paramLong).b().a(), false);
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
    Object localObject1 = RIJFeedsType.k(paramAbsBaseArticleInfo);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, i), false);
    PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, i));
    Object localObject2 = ReadinjoyReportUtils.e(paramInt);
    Object localObject3 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    localObject3 = RIJMsgReport.a.b((String)localObject3);
    PublicAccountReportUtils.a(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), (String)localObject3, false);
    PublicAccountReportUtils.a((String)localObject2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, i, j, NetworkUtil.isWifiConnected(paramContext), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo));
    paramContext = new ArrayList();
    localObject1 = new ReportInfo();
    ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.c();
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
      ((FeedsReportData)localObject2).a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        ((FeedsReportData)localObject2).b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      }
      ((FeedsReportData)localObject2).d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      ((FeedsReportData)localObject2).e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
      {
        ((FeedsReportData)localObject2).c = new ArrayList();
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
        while (paramAbsBaseArticleInfo.hasNext())
        {
          localObject3 = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
          if (localObject3 != null) {
            ((FeedsReportData)localObject2).c.add(Long.valueOf(((FeedsInfoUser)localObject3).a));
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
    String str1 = RIJFeedsType.k(paramAbsBaseArticleInfo);
    String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, i, bool ^ true, NetworkUtil.isWifiConnected(null), str1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    if ((!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) {
      str1 = paramAbsBaseArticleInfo.mSubscribeID;
    } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)) {
      str1 = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
    } else {
      str1 = "";
    }
    String str3 = ReadinjoyReportUtils.e(paramInt);
    PublicAccountReportUtils.a(null, "CliOper", "", str1, str3, str3, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), str2, false);
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
    else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
    {
      str1 = Long.toString(paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
      l1 = 0L;
    }
    else
    {
      l1 = 0L;
      str1 = "";
    }
    String str3 = RIJTransMergeKanDianReport.a(paramInt2, paramInt1, null, RIJFeedsType.g(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.k(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
    String str2;
    if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
      str2 = "0X8009363";
    } else {
      str2 = "0X8008899";
    }
    String str4 = Long.toString(l2);
    String str5 = Long.toString(l1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
    PublicAccountReportUtils.a(null, "CliOper", "", str1, str2, str2, 0, 0, str4, str5, localStringBuilder.toString(), str3, false);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, new Object[] { "reportGridImageClickEvent report click data, toUin: ", str1, ", r2(feedsId): ", Long.valueOf(l2), ", r3(articleId): ", Long.valueOf(l1), " r4(imagePos): ", Integer.valueOf(paramInt1), ", r5: ", str3 });
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Activity paramActivity, int paramInt, Integer paramInteger)
  {
    Object localObject1 = RIJFeedsType.k(paramAbsBaseArticleInfo);
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
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, j), false);
    PublicAccountReportUtils.a("0X80066FA", "", "", Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, j));
    Object localObject2 = ReadinjoyReportUtils.e(paramInt);
    Object localObject3;
    Object localObject4;
    if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
    {
      localObject3 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, j, m, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), i, paramAbsBaseArticleInfo));
      if (paramInt == 0) {
        ((VideoR5.Builder)localObject3).h(i).e((String)VideoReporter.c.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(RIJFeedsType.i(paramAbsBaseArticleInfo))).b(paramAbsBaseArticleInfo.videoReportInfo);
      }
      PublicAccountReportUtils.a(null, "CliOper", "", paramAbsBaseArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((VideoR5.Builder)localObject3).b().a(), false);
    }
    else
    {
      long l1 = paramAbsBaseArticleInfo.mAlgorithmID;
      int n = RIJFeedsType.g(paramAbsBaseArticleInfo);
      boolean bool = NetworkUtil.isWifiConnected(paramActivity);
      long l2 = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      localObject3 = paramAbsBaseArticleInfo.mStrCircleId;
      localObject4 = paramAbsBaseArticleInfo.innerUniqueID;
      Object localObject5 = RIJFeedsType.n(paramAbsBaseArticleInfo);
      int k = i;
      localObject3 = new VideoR5.Builder(RIJTransMergeKanDianReport.a(l1, n, paramInt, j, m, bool, String.valueOf(l2), (String)localObject3, (String)localObject4, (String)localObject5, i, paramAbsBaseArticleInfo));
      if (paramInt == 0) {
        ((VideoR5.Builder)localObject3).h(k).e((String)VideoReporter.c.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(RIJFeedsType.i(paramAbsBaseArticleInfo))).b(paramAbsBaseArticleInfo.videoReportInfo);
      }
      l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
      localObject4 = Long.toString(paramAbsBaseArticleInfo.mFeedId);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramAbsBaseArticleInfo.businessId);
      ((StringBuilder)localObject5).append("");
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(l1), (String)localObject2, (String)localObject2, 0, 0, (String)localObject4, ((StringBuilder)localObject5).toString(), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), ((VideoR5.Builder)localObject3).b().a(), false);
      i = k;
    }
    PublicAccountReportUtils.a((String)localObject2, paramAbsBaseArticleInfo.mSubscribeID, Long.toString(paramAbsBaseArticleInfo.mFeedId), Long.toString(paramAbsBaseArticleInfo.mArticleID), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, j, m, NetworkUtil.isWifiConnected(paramActivity), (String)localObject1, paramAbsBaseArticleInfo.mStrCircleId, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), i, paramAbsBaseArticleInfo));
    paramActivity = new ArrayList();
    localObject1 = new ReportInfo();
    ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.c();
    ((ReportInfo)localObject1).mSource = 0;
    ((ReportInfo)localObject1).mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    ((ReportInfo)localObject1).mChannelId = paramInt;
    ((ReportInfo)localObject1).mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    ((ReportInfo)localObject1).mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    ((ReportInfo)localObject1).mOperation = 1;
    ((ReportInfo)localObject1).mServerContext = paramAbsBaseArticleInfo.mServerContext;
    ((ReportInfo)localObject1).mReadTimeLength = -1;
    ((ReportInfo)localObject1).mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
    if ((!UGRuleManager.c(paramAbsBaseArticleInfo)) && (!ReadInJoySrtUtils.a().e()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramAbsBaseArticleInfo))) {
      ((ReportInfo)localObject1).noDifferenceJump = 1;
    }
    if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
      ((ReportInfo)localObject1).mColumnID = paramAbsBaseArticleInfo.mVideoColumnInfo.b;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localObject2 = new FeedsReportData();
      ((FeedsReportData)localObject2).a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        ((FeedsReportData)localObject2).b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      }
      ((FeedsReportData)localObject2).d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      ((FeedsReportData)localObject2).e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
      localObject3 = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        ((FeedsReportData)localObject2).c = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FeedsInfoUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            ((FeedsReportData)localObject2).c.add(Long.valueOf(((FeedsInfoUser)localObject4).a));
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
        int k = ((AbsBaseArticleInfo)localObject).mPolymericInfo.q;
        if (((AbsBaseArticleInfo)localObject).mPolymericInfo.r)
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
      PublicAccountReportUtils.a(null, null, "0X800A5AA", "0X800A5AA", 0, 0, "", "", "", new VideoR5.Builder(paramString, null, null, null, null).X(54).k(localStringBuilder.toString()).b().a(), false);
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
      Object localObject2 = RIJFeedsType.k(paramAbsBaseArticleInfo);
      if (paramAbsBaseArticleInfo.hasChannelInfo()) {
        int i = paramAbsBaseArticleInfo.mChannelInfoId;
      }
      TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleFriendLikeText);
      Object localObject1 = null;
      try
      {
        localObject2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramInt, NetworkUtil.isWifiConnected(null), (String)localObject2, paramAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(paramAbsBaseArticleInfo), 0, RIJTransMergeKanDianReport.b(), paramAbsBaseArticleInfo);
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
      PublicAccountReportUtils.a(null, RIJFeedsType.k(paramAbsBaseArticleInfo), paramString1, paramString2, 0, 0, RIJStringUtils.a(paramAbsBaseArticleInfo.mFeedId), String.valueOf(paramAbsBaseArticleInfo.businessId), Integer.toString(paramAbsBaseArticleInfo.mStrategyId), paramMap, false);
      ReadinjoyReportUtils.CoreReport.a(paramAbsBaseArticleInfo, paramInt);
    }
  }
  
  private void a(BaseReportData paramBaseReportData)
  {
    if (RIJFeedsType.H(paramBaseReportData.l)) {
      PublicAccountReportUtils.a(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  private void a(BaseReportData paramBaseReportData, int paramInt)
  {
    if (paramBaseReportData.c) {}
    for (;;)
    {
      try
      {
        if (paramBaseReportData.d)
        {
          JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
          localJSONObject.put("feeds_source", paramBaseReportData.k);
          localJSONObject.put("kandian_mode", RIJAppSetting.b());
          if (!ReadinjoyReportUtils.d(paramInt)) {
            break label102;
          }
          str = "0X8009358";
          PublicAccountReportUtils.a(null, "CliOper", "", "", str, str, 0, 0, RIJFeedsType.m(paramBaseReportData.l), "", "", localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException paramBaseReportData)
      {
        paramBaseReportData.printStackTrace();
      }
      return;
      label102:
      String str = "0X800744E";
    }
  }
  
  private void a(BaseReportData paramBaseReportData, int paramInt, String paramString)
  {
    if (paramBaseReportData.l.mRecommendFollowInfos.d == 0)
    {
      ComponentContentRecommend.a(paramBaseReportData.l, paramInt, paramString);
      return;
    }
    if (paramBaseReportData.l.mRecommendFollowInfos.d == 1)
    {
      ComponentContentRecommendFollowList.a(paramBaseReportData.l, paramInt, paramString);
      return;
    }
    if (paramBaseReportData.l.mRecommendFollowInfos.d == 2) {
      ComponentContentRecommendFollowGroup.a(paramBaseReportData.l, paramInt, paramString);
    }
  }
  
  private void a(BaseReportData paramBaseReportData, Context paramContext, int paramInt)
  {
    if (RIJFeedsType.G(paramBaseReportData.l))
    {
      Object localObject1 = (AbsBaseArticleInfo)paramBaseReportData.l.mGroupSubArticleList.get(0);
      paramContext = ReadinjoyReportUtils.a(paramContext, ((AbsBaseArticleInfo)localObject1).mArticleID, ((AbsBaseArticleInfo)localObject1).mAlgorithmID, 54, paramInt, ((AbsBaseArticleInfo)localObject1).getInnerUniqueID(), ((AbsBaseArticleInfo)localObject1).getVideoVid(), ReadinjoyReportUtils.a((AbsBaseArticleInfo)localObject1), ((AbsBaseArticleInfo)localObject1).videoReportInfo);
      try
      {
        localObject1 = new JSONObject(paramContext);
        boolean bool = paramBaseReportData.l.isShowGif;
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
        ((JSONObject)localObject2).put("account_expose_card", RIJTransMergeKanDianReport.c(paramBaseReportData.l));
        localObject2 = ((JSONObject)localObject2).toString();
        paramContext = (Context)localObject2;
      }
      catch (JSONException localJSONException2)
      {
        QLog.e("RIJFrameworkReportManager", 2, localJSONException2.getMessage());
      }
      a(paramBaseReportData.l, paramContext);
      return;
    }
    paramContext = ReadinjoyReportUtils.a(paramContext, paramBaseReportData.l.mVideoAdsSource, paramBaseReportData.B, paramBaseReportData.l.getInnerUniqueID(), 54, ReadinjoyReportUtils.a(paramBaseReportData.l), paramBaseReportData.l.videoReportInfo);
    PublicAccountReportUtils.a(null, "CliOper", "", paramBaseReportData.s, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramBaseReportData.l.mFeedId), Long.toString(paramBaseReportData.l.mArticleID), Integer.toString(paramBaseReportData.l.mStrategyId), paramContext, false);
    PublicAccountReportUtils.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, null).X(54).k(paramBaseReportData.l.getInnerUniqueID()).w(paramBaseReportData.B + 1).f(paramBaseReportData.l).b().a(), false);
  }
  
  private void a(BaseReportData paramBaseReportData, String paramString1, String paramString2)
  {
    int i = 0;
    while (i < paramBaseReportData.l.mTopicRecommendFeedsInfo.g.size())
    {
      String str1 = paramBaseReportData.s;
      String str2 = Long.toString(paramBaseReportData.l.mFeedId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseReportData.l.mTopicRecommendFeedsInfo.g.get(i)).a);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, str1, paramString2, paramString2, 0, 0, str2, localStringBuilder.toString(), Integer.toString(paramBaseReportData.h), paramString1, false);
      i += 1;
    }
  }
  
  private void a(BaseReportData paramBaseReportData, String paramString1, String paramString2, Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject3;
    if (!paramBaseReportData.l.mNewPolymericInfo.a)
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      } else {
        paramString1 = "0";
      }
      localObject2 = RIJTransMergeKanDianReport.a(paramBaseReportData.l.mAlgorithmID, RIJFeedsType.g(paramBaseReportData.l), paramInt, 0, 0, NetworkUtil.isWifiConnected(paramContext), paramBaseReportData.l.mSubscribeID, null, paramBaseReportData.l.innerUniqueID, null, paramBaseReportData.l);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramBaseReportData.l.mFeedId);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramBaseReportData.l.mArticleID);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBaseReportData.l.mStrategyId);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, (String)localObject3, (String)localObject4, localStringBuilder.toString(), (String)localObject2, false);
      paramString2 = ReadinjoyReportUtils.c(paramInt);
      if (localQQAppInterface != null) {
        paramString1 = localQQAppInterface.getCurrentUin();
      }
      paramContext = RIJTransMergeKanDianReport.a(paramBaseReportData.l.mAlgorithmID, RIJFeedsType.g(paramBaseReportData.l), paramInt, NetworkUtil.isWifiConnected(paramContext), paramBaseReportData.l.mSubscribeID, paramBaseReportData.l.innerUniqueID, null, 0, paramBaseReportData.u, paramBaseReportData.l);
      if (!paramBoolean) {
        break label505;
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
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramBaseReportData.l.mFeedId);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBaseReportData.l.mArticleID);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramBaseReportData.l.mStrategyId);
      ((StringBuilder)localObject3).append("");
      PublicAccountReportUtils.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, (String)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString(), paramContext, false);
      return;
      if (RIJFeedsType.K(paramBaseReportData.l)) {
        PublicAccountReportUtils.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      }
      return;
      label505:
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
      ((JSONObject)localObject).put("kandian_mode_new", VideoReporter.c());
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
    PublicAccountReportUtils.a(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", paramString, false);
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
        PublicAccountReportUtils.a(null, null, "0X8009CCD", "0X8009CCD", 0, 0, "", "", "", localJSONObject.toString(), false);
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
      if (!((BaseReportData)localObject1).b)
      {
        int i = 1;
        ((BaseReportData)localObject1).b = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((BaseReportData)localObject1).g.longValue();
        localReportInfo.mChannelId = paramInt;
        localReportInfo.mAlgorithmId = ((int)((BaseReportData)localObject1).i);
        localReportInfo.mStrategyId = ((BaseReportData)localObject1).h;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((BaseReportData)localObject1).q;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((BaseReportData)localObject1).t;
        if (((BaseReportData)localObject1).l.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((BaseReportData)localObject1).l.mVideoColumnInfo.b;
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
          ((ReportInfo.VideoExtraRepoerData)localObject2).c = i;
          localObject2 = ((ReportInfo.VideoExtraRepoerData)localObject2).toString();
          localReportInfo.mInnerId = ((BaseReportData)localObject1).t;
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
        if (((BaseReportData)localObject1).l.mSocialFeedInfo != null)
        {
          localObject2 = new FeedsReportData();
          ((FeedsReportData)localObject2).a = ((BaseReportData)localObject1).l.mSocialFeedInfo.a;
          if (((BaseReportData)localObject1).l.mSocialFeedInfo.c != null) {
            ((FeedsReportData)localObject2).b = ((BaseReportData)localObject1).l.mSocialFeedInfo.c.a;
          }
          ((FeedsReportData)localObject2).d = ((BaseReportData)localObject1).l.mSocialFeedInfo.h;
          ((FeedsReportData)localObject2).e = ((BaseReportData)localObject1).l.mSocialFeedInfo.j;
          localObject1 = ((BaseReportData)localObject1).l.mSocialFeedInfo.d;
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            ((FeedsReportData)localObject2).c = new ArrayList();
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (FeedsInfoUser)((Iterator)localObject1).next();
              if (localObject3 != null) {
                ((FeedsReportData)localObject2).c.add(Long.valueOf(((FeedsInfoUser)localObject3).a));
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
      AbsBaseArticleInfo localAbsBaseArticleInfo = ((ReadinjoyReportUtils.ExposureReportItem)localObject2).a;
      if ((!RIJFeedsType.l(localAbsBaseArticleInfo)) || (!localAbsBaseArticleInfo.mNewPolymericInfo.a))
      {
        String str = RIJFeedsType.k(localAbsBaseArticleInfo);
        paramMap = localAbsBaseArticleInfo.innerUniqueID;
        Object localObject1 = paramMap;
        if (RIJFeedsType.G(localAbsBaseArticleInfo))
        {
          localObject1 = paramMap;
          if (localAbsBaseArticleInfo.mGroupSubArticleList.size() >= 1) {
            localObject1 = ((AbsBaseArticleInfo)localAbsBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
          }
        }
        Object localObject3 = RIJFeedsType.n(localAbsBaseArticleInfo);
        if (((RIJItemViewTypeUtils.m(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.l(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(localAbsBaseArticleInfo))) && (!RIJItemViewTypeUtils.v(localAbsBaseArticleInfo))) {
          paramMap = String.valueOf(localAbsBaseArticleInfo.mSocialFeedInfo.s.e);
        }
        for (;;)
        {
          break;
          if ((RIJFeedsType.F(localAbsBaseArticleInfo)) && (localAbsBaseArticleInfo.mPolymericInfo.e == 6))
          {
            paramMap = new StringBuilder();
            paramMap.append(localAbsBaseArticleInfo.mPolymericInfo.f);
            paramMap.append("");
            paramMap = paramMap.toString();
          }
          else
          {
            paramMap = localAbsBaseArticleInfo.mSubscribeID;
          }
        }
        localObject1 = RIJTransMergeKanDianReport.a(localAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(localAbsBaseArticleInfo), (int)localAbsBaseArticleInfo.mChannelID, NetworkState.isWifiConn(), str, (String)localObject1, (String)localObject3, 0, ((ReadinjoyReportUtils.ExposureReportItem)localObject2).c, localAbsBaseArticleInfo);
        str = a(localAbsBaseArticleInfo.mChannelID);
        try
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append((float)((ReadinjoyReportUtils.ExposureReportItem)localObject2).b / 1000.0F);
          ((JSONObject)localObject1).put("exposure_time", ((StringBuilder)localObject3).toString());
          if (DailyModeConfigHandler.c((int)localAbsBaseArticleInfo.mChannelID)) {
            ((JSONObject)localObject1).put("cmd", ReadInJoyHelper.O());
          }
          localObject2 = Long.toString(localAbsBaseArticleInfo.mFeedId);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localAbsBaseArticleInfo.mArticleID);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
          localStringBuilder.append("");
          PublicAccountReportUtils.a(null, "CliOper", "", paramMap, str, str, 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), ((JSONObject)localObject1).toString(), false);
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
    String str = ReadinjoyReportUtils.e(paramInt);
    a(paramAbsBaseArticleInfo, str, str, paramInt);
  }
  
  private void b(BaseReportData paramBaseReportData)
  {
    if ((paramBaseReportData.l != null) && (paramBaseReportData.l.mSocialFeedInfo != null) && (paramBaseReportData.l.mSocialFeedInfo.J != null)) {
      RIJMedalUtils.a(paramBaseReportData.l.mSocialFeedInfo.J, paramBaseReportData.l);
    }
  }
  
  private void b(BaseReportData paramBaseReportData, Context paramContext, int paramInt)
  {
    if ((paramBaseReportData.j == 48) || (paramBaseReportData.j == 49) || (paramBaseReportData.j == 50) || (paramBaseReportData.j == 51) || (paramBaseReportData.j == 52) || (paramBaseReportData.j == 53) || (paramBaseReportData.j == 78) || (paramBaseReportData.j == 79) || (paramBaseReportData.j == 80) || (paramBaseReportData.j == 1005) || (paramBaseReportData.j == 1006) || (paramBaseReportData.j == 1007))
    {
      long l4 = paramBaseReportData.A;
      int i = paramBaseReportData.B;
      int j = GalleryReportedUtils.a(paramInt, paramBaseReportData.j);
      int k = GalleryReportedUtils.a(paramBaseReportData.j);
      long l1;
      String str1;
      String str2;
      long l2;
      long l3;
      if (paramBaseReportData.l != null)
      {
        l1 = paramBaseReportData.l.mArticleID;
        str1 = paramBaseReportData.l.innerUniqueID;
        str2 = paramBaseReportData.l.galleryReprotExdData;
        l2 = paramBaseReportData.l.mAlgorithmID;
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
      paramContext = GalleryReportedUtils.a(paramContext, RIJQQAppInterfaceUtil.c(), j, l3, l4, i, str1, str2, k, paramInt);
      paramBaseReportData = paramBaseReportData.s;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l2);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, paramBaseReportData, "0X8008E2E", "0X8008E2E", 0, 0, "", (String)localObject, localStringBuilder.toString(), paramContext, false);
      GalleryReportedUtils.a(7, RIJQQAppInterfaceUtil.c(), (int)l2, j, l4, i, str1, str2);
    }
  }
  
  private void b(BaseReportData paramBaseReportData, String paramString1, String paramString2)
  {
    if (paramBaseReportData != null)
    {
      if (paramBaseReportData.l == null) {
        return;
      }
      try
      {
        if ((RecycleViewAdapterHelper.c() != null) && (paramBaseReportData.l.mNewPolymericInfo != null) && (paramBaseReportData.l.mNewPolymericInfo.p != null))
        {
          paramString1 = new JSONObject(paramString1);
          if (paramBaseReportData.l.mProteusTemplateBean != null)
          {
            localObject1 = paramBaseReportData.l.mProteusTemplateBean.getDataAttribute(null);
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
          Object localObject1 = paramBaseReportData.l.mNewPolymericInfo.p;
          Object localObject2 = RecycleViewAdapterHelper.c().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Integer localInteger = (Integer)((Iterator)localObject2).next();
            if ((localInteger.intValue() < ((List)localObject1).size()) && (((List)localObject1).get(localInteger.intValue()) != null))
            {
              paramString1.put("rowkey", ((NewPolymericInfo.PackArticleInfo)((List)localObject1).get(localInteger.intValue())).l);
              PublicAccountReportUtils.a(null, "CliOper", "", paramBaseReportData.s, paramString2, paramString2, 0, 0, Long.toString(paramBaseReportData.l.mFeedId), Long.toString(paramBaseReportData.g.longValue()), Integer.toString(paramBaseReportData.h), paramString1.toString(), false);
            }
          }
          RecycleViewAdapterHelper.b();
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
    localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
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
      localFeedsReportData.a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
        localFeedsReportData.b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
      }
      localFeedsReportData.d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      localFeedsReportData.e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
      {
        localFeedsReportData.c = new ArrayList();
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
        while (paramAbsBaseArticleInfo.hasNext())
        {
          FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
          if (localFeedsInfoUser != null) {
            localFeedsReportData.c.add(Long.valueOf(localFeedsInfoUser.a));
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
    PublicAccountReportUtils.a(null, null, "0X800A5AB", "0X800A5AB", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, null).X(54).k(paramAbsBaseArticleInfo.getInnerUniqueID()).w(paramInt + 1).b().a(), false);
  }
  
  public static void e(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mVideoColumnInfo == null) {
        return;
      }
      PublicAccountReportUtils.a(null, null, "0X800A1C3", "0X800A1C3", 0, 0, "", "", "", new VideoR5.Builder(null, null, null, null).k(paramAbsBaseArticleInfo.innerUniqueID).c(paramAbsBaseArticleInfo).d(paramAbsBaseArticleInfo).S(paramInt).b(paramAbsBaseArticleInfo.videoReportInfo).a(paramAbsBaseArticleInfo, false).b().a(), false);
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
        TabChannelCoverInfo localTabChannelCoverInfo = localBaseReportData.C;
        int j = ChannelCoverView.b;
        int i;
        if ((localBaseReportData.C != null) && (localBaseReportData.C.redPoint != null) && (localBaseReportData.C.redPoint.a)) {
          i = localBaseReportData.C.redPoint.e + 1;
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
    //   0: ldc_w 287
    //   3: astore 25
    //   5: aload_1
    //   6: ifnull +1049 -> 1055
    //   9: aload_1
    //   10: invokeinterface 1222 1 0
    //   15: ifne +1040 -> 1055
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: goto +1033 -> 1055
    //   25: aload_1
    //   26: invokeinterface 1028 1 0
    //   31: invokeinterface 1031 1 0
    //   36: astore 28
    //   38: aload 25
    //   40: astore_1
    //   41: iload 6
    //   43: istore 7
    //   45: aload 28
    //   47: invokeinterface 578 1 0
    //   52: ifeq +997 -> 1049
    //   55: aload 28
    //   57: invokeinterface 582 1 0
    //   62: checkcast 100	com/tencent/mobileqq/kandian/repo/report/BaseReportData
    //   65: astore 27
    //   67: aload 27
    //   69: getfield 1223	com/tencent/mobileqq/kandian/repo/report/BaseReportData:a	Z
    //   72: ifne +974 -> 1046
    //   75: aload 27
    //   77: iconst_1
    //   78: putfield 1223	com/tencent/mobileqq/kandian/repo/report/BaseReportData:a	Z
    //   81: aload 27
    //   83: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   86: ifnull +52 -> 138
    //   89: aload 27
    //   91: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   94: getfield 1227	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   97: ifnull +41 -> 138
    //   100: aload 27
    //   102: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   105: getfield 1227	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   108: getfield 1233	tencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo:enum_article_style	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   111: invokevirtual 1237	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   114: istore 8
    //   116: aload 27
    //   118: sipush 1008
    //   121: putfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   124: iload 8
    //   126: iconst_5
    //   127: if_icmpne +11 -> 138
    //   130: aload 27
    //   132: sipush 1009
    //   135: putfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   138: aconst_null
    //   139: ldc_w 310
    //   142: ldc_w 312
    //   145: ldc_w 312
    //   148: ldc_w 1239
    //   151: ldc_w 1239
    //   154: iconst_0
    //   155: iconst_0
    //   156: ldc_w 312
    //   159: aload 27
    //   161: getfield 1036	com/tencent/mobileqq/kandian/repo/report/BaseReportData:g	Ljava/lang/Long;
    //   164: invokevirtual 373	java/lang/Long:longValue	()J
    //   167: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   170: aload 27
    //   172: getfield 967	com/tencent/mobileqq/kandian/repo/report/BaseReportData:h	I
    //   175: invokestatic 484	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   178: aload 27
    //   180: getfield 1038	com/tencent/mobileqq/kandian/repo/report/BaseReportData:i	J
    //   183: aload 27
    //   185: getfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   188: iload 7
    //   190: aload 27
    //   192: getfield 1241	com/tencent/mobileqq/kandian/repo/report/BaseReportData:o	I
    //   195: invokestatic 1243	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIII)Ljava/lang/String;
    //   198: iconst_0
    //   199: invokestatic 336	com/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   202: ldc_w 1239
    //   205: ldc_w 312
    //   208: ldc_w 312
    //   211: aload 27
    //   213: getfield 1036	com/tencent/mobileqq/kandian/repo/report/BaseReportData:g	Ljava/lang/Long;
    //   216: invokevirtual 373	java/lang/Long:longValue	()J
    //   219: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   222: aload 27
    //   224: getfield 967	com/tencent/mobileqq/kandian/repo/report/BaseReportData:h	I
    //   227: invokestatic 484	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   230: aload 27
    //   232: getfield 1038	com/tencent/mobileqq/kandian/repo/report/BaseReportData:i	J
    //   235: aload 27
    //   237: getfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   240: iload 7
    //   242: aload 27
    //   244: getfield 1241	com/tencent/mobileqq/kandian/repo/report/BaseReportData:o	I
    //   247: invokestatic 1243	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIII)Ljava/lang/String;
    //   250: invokestatic 342	com/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload 27
    //   255: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   258: ifnonnull +6 -> 264
    //   261: goto -220 -> 41
    //   264: aload 27
    //   266: getfield 1038	com/tencent/mobileqq/kandian/repo/report/BaseReportData:i	J
    //   269: aload 27
    //   271: getfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   274: iload 6
    //   276: aload 27
    //   278: getfield 1241	com/tencent/mobileqq/kandian/repo/report/BaseReportData:o	I
    //   281: aload 27
    //   283: getfield 1245	com/tencent/mobileqq/kandian/repo/report/BaseReportData:p	I
    //   286: aload 5
    //   288: invokestatic 498	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   291: aload 27
    //   293: getfield 871	com/tencent/mobileqq/kandian/repo/report/BaseReportData:k	Ljava/lang/String;
    //   296: aload 27
    //   298: getfield 1247	com/tencent/mobileqq/kandian/repo/report/BaseReportData:r	Ljava/lang/String;
    //   301: aload 27
    //   303: getfield 1043	com/tencent/mobileqq/kandian/repo/report/BaseReportData:t	Ljava/lang/String;
    //   306: aload 27
    //   308: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   311: invokestatic 503	com/tencent/mobileqq/kandian/repo/feeds/RIJFeedsType:n	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Ljava/lang/String;
    //   314: aload 27
    //   316: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   319: lconst_0
    //   320: iconst_m1
    //   321: aload 27
    //   323: getfield 991	com/tencent/mobileqq/kandian/repo/report/BaseReportData:u	I
    //   326: aload 27
    //   328: getfield 1249	com/tencent/mobileqq/kandian/repo/report/BaseReportData:v	I
    //   331: aload 27
    //   333: getfield 1251	com/tencent/mobileqq/kandian/repo/report/BaseReportData:w	I
    //   336: aload 27
    //   338: getfield 1254	com/tencent/mobileqq/kandian/repo/report/BaseReportData:x	Z
    //   341: aload 27
    //   343: getfield 1257	com/tencent/mobileqq/kandian/repo/report/BaseReportData:z	I
    //   346: aload 27
    //   348: getfield 1260	com/tencent/mobileqq/kandian/repo/report/BaseReportData:y	I
    //   351: aload 27
    //   353: getfield 1263	com/tencent/mobileqq/kandian/repo/report/BaseReportData:E	I
    //   356: invokestatic 1266	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   359: astore 26
    //   361: new 226	org/json/JSONObject
    //   364: dup
    //   365: aload 26
    //   367: invokespecial 227	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   370: astore 25
    //   372: aload 25
    //   374: ldc_w 1268
    //   377: aload 27
    //   379: getfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   382: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload 25
    //   388: ldc 229
    //   390: aload 4
    //   392: invokevirtual 233	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload 25
    //   398: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   401: astore 25
    //   403: goto +29 -> 432
    //   406: astore 25
    //   408: goto +10 -> 418
    //   411: astore 25
    //   413: goto +5 -> 418
    //   416: astore 25
    //   418: aload_1
    //   419: iconst_2
    //   420: aload 25
    //   422: invokevirtual 923	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   425: invokestatic 925	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload 26
    //   430: astore 25
    //   432: iload 6
    //   434: i2l
    //   435: invokestatic 91	com/tencent/mobileqq/kandian/glue/report/ReadinjoyReportUtils:d	(J)Z
    //   438: ifeq +11 -> 449
    //   441: ldc_w 1270
    //   444: astore 26
    //   446: goto +8 -> 454
    //   449: ldc_w 945
    //   452: astore 26
    //   454: new 117	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder
    //   457: dup
    //   458: aload 25
    //   460: invokespecial 120	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:<init>	(Ljava/lang/String;)V
    //   463: astore 25
    //   465: aload 25
    //   467: aload 27
    //   469: getfield 1272	com/tencent/mobileqq/kandian/repo/report/BaseReportData:m	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   472: invokevirtual 1274	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder;
    //   475: aload 27
    //   477: getfield 1272	com/tencent/mobileqq/kandian/repo/report/BaseReportData:m	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   480: invokevirtual 950	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:f	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder;
    //   483: pop
    //   484: aconst_null
    //   485: ldc_w 310
    //   488: ldc_w 312
    //   491: aload 27
    //   493: getfield 941	com/tencent/mobileqq/kandian/repo/report/BaseReportData:s	Ljava/lang/String;
    //   496: aload 26
    //   498: aload 26
    //   500: iconst_0
    //   501: iconst_0
    //   502: aload 27
    //   504: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   507: getfield 519	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   510: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   513: aload 27
    //   515: getfield 1036	com/tencent/mobileqq/kandian/repo/report/BaseReportData:g	Ljava/lang/Long;
    //   518: invokevirtual 373	java/lang/Long:longValue	()J
    //   521: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   524: aload 27
    //   526: getfield 967	com/tencent/mobileqq/kandian/repo/report/BaseReportData:h	I
    //   529: invokestatic 484	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   532: aload 25
    //   534: invokevirtual 154	com/tencent/mobileqq/kandian/glue/video/report/VideoR5$Builder:b	()Lcom/tencent/mobileqq/kandian/glue/video/report/VideoR5;
    //   537: invokevirtual 159	com/tencent/mobileqq/kandian/glue/video/report/VideoR5:a	()Ljava/lang/String;
    //   540: iconst_0
    //   541: invokestatic 336	com/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   544: aload 27
    //   546: getfield 941	com/tencent/mobileqq/kandian/repo/report/BaseReportData:s	Ljava/lang/String;
    //   549: astore 29
    //   551: aload 27
    //   553: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   556: getfield 519	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mFeedId	J
    //   559: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   562: astore 30
    //   564: aload 27
    //   566: getfield 1036	com/tencent/mobileqq/kandian/repo/report/BaseReportData:g	Ljava/lang/Long;
    //   569: invokevirtual 373	java/lang/Long:longValue	()J
    //   572: invokestatic 481	java/lang/Long:toString	(J)Ljava/lang/String;
    //   575: astore 31
    //   577: aload 27
    //   579: getfield 967	com/tencent/mobileqq/kandian/repo/report/BaseReportData:h	I
    //   582: invokestatic 484	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   585: astore 32
    //   587: aload 27
    //   589: getfield 1038	com/tencent/mobileqq/kandian/repo/report/BaseReportData:i	J
    //   592: lstore 17
    //   594: aload 27
    //   596: getfield 1118	com/tencent/mobileqq/kandian/repo/report/BaseReportData:j	I
    //   599: istore 7
    //   601: aload 27
    //   603: getfield 1241	com/tencent/mobileqq/kandian/repo/report/BaseReportData:o	I
    //   606: istore 8
    //   608: aload 27
    //   610: getfield 1245	com/tencent/mobileqq/kandian/repo/report/BaseReportData:p	I
    //   613: istore 9
    //   615: aload 5
    //   617: invokestatic 498	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   620: istore_2
    //   621: aload 27
    //   623: getfield 871	com/tencent/mobileqq/kandian/repo/report/BaseReportData:k	Ljava/lang/String;
    //   626: astore 33
    //   628: aload 27
    //   630: getfield 1247	com/tencent/mobileqq/kandian/repo/report/BaseReportData:r	Ljava/lang/String;
    //   633: astore 34
    //   635: aload 27
    //   637: getfield 1043	com/tencent/mobileqq/kandian/repo/report/BaseReportData:t	Ljava/lang/String;
    //   640: astore 35
    //   642: aload 27
    //   644: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   647: invokestatic 503	com/tencent/mobileqq/kandian/repo/feeds/RIJFeedsType:n	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Ljava/lang/String;
    //   650: astore 36
    //   652: aload 27
    //   654: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   657: astore 37
    //   659: aload 27
    //   661: getfield 991	com/tencent/mobileqq/kandian/repo/report/BaseReportData:u	I
    //   664: istore 10
    //   666: aload 27
    //   668: getfield 1249	com/tencent/mobileqq/kandian/repo/report/BaseReportData:v	I
    //   671: istore 11
    //   673: aload 27
    //   675: getfield 1251	com/tencent/mobileqq/kandian/repo/report/BaseReportData:w	I
    //   678: istore 12
    //   680: aload 27
    //   682: getfield 1254	com/tencent/mobileqq/kandian/repo/report/BaseReportData:x	Z
    //   685: istore 16
    //   687: aload 27
    //   689: getfield 1257	com/tencent/mobileqq/kandian/repo/report/BaseReportData:z	I
    //   692: istore 13
    //   694: aload 27
    //   696: getfield 1260	com/tencent/mobileqq/kandian/repo/report/BaseReportData:y	I
    //   699: istore 14
    //   701: aload 27
    //   703: getfield 1263	com/tencent/mobileqq/kandian/repo/report/BaseReportData:E	I
    //   706: istore 15
    //   708: aload_1
    //   709: astore 25
    //   711: aload 26
    //   713: aload 29
    //   715: aload 30
    //   717: aload 31
    //   719: aload 32
    //   721: lload 17
    //   723: iload 7
    //   725: iload 6
    //   727: iload 8
    //   729: iload 9
    //   731: iload_2
    //   732: aload 33
    //   734: aload 34
    //   736: aload 35
    //   738: aload 36
    //   740: aload 37
    //   742: lconst_0
    //   743: iconst_m1
    //   744: iload 10
    //   746: iload 11
    //   748: iload 12
    //   750: iload 16
    //   752: iload 13
    //   754: iload 14
    //   756: iload 15
    //   758: invokestatic 1266	com/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   761: invokestatic 342	com/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload 25
    //   766: astore_1
    //   767: aload 27
    //   769: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   772: ifnull +274 -> 1046
    //   775: aload 25
    //   777: astore_1
    //   778: aload 27
    //   780: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   783: getfield 1227	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   786: ifnull +260 -> 1046
    //   789: aload 27
    //   791: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   794: getfield 1227	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mGalleryFeedsInfo	Ltencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo;
    //   797: getfield 1233	tencent/im/oidb/gallery/galleryFeeds$GalleryFeedsInfo:enum_article_style	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   800: invokevirtual 1237	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   803: iconst_5
    //   804: if_icmpne +10 -> 814
    //   807: bipush 12
    //   809: istore 7
    //   811: goto +7 -> 818
    //   814: bipush 8
    //   816: istore 7
    //   818: aload 27
    //   820: getfield 1121	com/tencent/mobileqq/kandian/repo/report/BaseReportData:A	J
    //   823: lstore 23
    //   825: aload 27
    //   827: getfield 936	com/tencent/mobileqq/kandian/repo/report/BaseReportData:B	I
    //   830: istore 8
    //   832: aload 27
    //   834: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   837: ifnull +49 -> 886
    //   840: aload 27
    //   842: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   845: getfield 260	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   848: lstore 17
    //   850: aload 27
    //   852: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   855: getfield 148	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   858: astore_1
    //   859: aload 27
    //   861: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   864: getfield 1132	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:galleryReprotExdData	Ljava/lang/String;
    //   867: astore 26
    //   869: aload 27
    //   871: getfield 104	com/tencent/mobileqq/kandian/repo/report/BaseReportData:l	Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;
    //   874: getfield 487	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mAlgorithmID	J
    //   877: lstore 19
    //   879: lload 17
    //   881: lstore 21
    //   883: goto +19 -> 902
    //   886: aconst_null
    //   887: astore_1
    //   888: aload_1
    //   889: astore 26
    //   891: lconst_0
    //   892: lstore 17
    //   894: lload 17
    //   896: lstore 21
    //   898: lload 17
    //   900: lstore 19
    //   902: aload 5
    //   904: invokestatic 392	com/tencent/mobileqq/kandian/base/utils/RIJQQAppInterfaceUtil:c	()J
    //   907: bipush 16
    //   909: lload 21
    //   911: lload 23
    //   913: iload 8
    //   915: aload_1
    //   916: aload 26
    //   918: iload 7
    //   920: iload 6
    //   922: invokestatic 1135	com/tencent/mobileqq/kandian/glue/report/GalleryReportedUtils:a	(Landroid/content/Context;JIJJILjava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   925: astore 29
    //   927: aload 27
    //   929: getfield 941	com/tencent/mobileqq/kandian/repo/report/BaseReportData:s	Ljava/lang/String;
    //   932: astore 27
    //   934: new 639	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 640	java/lang/StringBuilder:<init>	()V
    //   941: astore 30
    //   943: aload 30
    //   945: lload 21
    //   947: invokevirtual 694	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   950: pop
    //   951: aload 30
    //   953: ldc_w 312
    //   956: invokevirtual 644	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload 30
    //   962: invokevirtual 648	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: astore 30
    //   967: new 639	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 640	java/lang/StringBuilder:<init>	()V
    //   974: astore 31
    //   976: aload 31
    //   978: lload 19
    //   980: invokevirtual 694	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: aload 31
    //   986: ldc_w 312
    //   989: invokevirtual 644	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aconst_null
    //   994: aload 27
    //   996: ldc_w 1137
    //   999: ldc_w 1137
    //   1002: iconst_0
    //   1003: iconst_0
    //   1004: ldc_w 312
    //   1007: aload 30
    //   1009: aload 31
    //   1011: invokevirtual 648	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1014: aload 29
    //   1016: iconst_0
    //   1017: invokestatic 352	com/tencent/mobileqq/kandian/biz/common/api/impl/PublicAccountReportUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1020: bipush 7
    //   1022: invokestatic 392	com/tencent/mobileqq/kandian/base/utils/RIJQQAppInterfaceUtil:c	()J
    //   1025: lload 19
    //   1027: l2i
    //   1028: bipush 16
    //   1030: lload 23
    //   1032: iload 8
    //   1034: aload_1
    //   1035: aload 26
    //   1037: invokestatic 1140	com/tencent/mobileqq/kandian/glue/report/GalleryReportedUtils:a	(IJIIJILjava/lang/String;Ljava/lang/String;)V
    //   1040: aload 25
    //   1042: astore_1
    //   1043: goto +3 -> 1046
    //   1046: goto -1005 -> 41
    //   1049: aload_0
    //   1050: aload_3
    //   1051: invokevirtual 1276	com/tencent/mobileqq/kandian/glue/report/RIJFrameworkReportManager:b	(Ljava/util/Map;)V
    //   1054: return
    //   1055: ldc_w 287
    //   1058: iconst_2
    //   1059: ldc_w 1278
    //   1062: invokestatic 294	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1065: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1066	0	this	RIJFrameworkReportManager
    //   0	1066	1	paramMap	Map<Long, BaseReportData>
    //   0	1066	2	paramBoolean	boolean
    //   0	1066	3	paramMap1	Map<Long, ReadinjoyReportUtils.ExposureReportItem>
    //   0	1066	4	paramString	String
    //   0	1066	5	paramContext	Context
    //   0	1066	6	paramInt	int
    //   43	876	7	i	int
    //   114	919	8	j	int
    //   613	117	9	k	int
    //   664	81	10	m	int
    //   671	76	11	n	int
    //   678	71	12	i1	int
    //   692	61	13	i2	int
    //   699	56	14	i3	int
    //   706	51	15	i4	int
    //   685	66	16	bool	boolean
    //   592	307	17	l1	long
    //   877	149	19	l2	long
    //   881	65	21	l3	long
    //   823	208	23	l4	long
    //   3	399	25	localObject1	Object
    //   406	1	25	localJSONException1	JSONException
    //   411	1	25	localJSONException2	JSONException
    //   416	5	25	localJSONException3	JSONException
    //   430	611	25	localObject2	Object
    //   359	677	26	localObject3	Object
    //   65	930	27	localObject4	Object
    //   36	20	28	localIterator	Iterator
    //   549	466	29	str1	String
    //   562	446	30	localObject5	Object
    //   575	435	31	localObject6	Object
    //   585	135	32	str2	String
    //   626	107	33	str3	String
    //   633	102	34	str4	String
    //   640	97	35	str5	String
    //   650	89	36	str6	String
    //   657	84	37	localAbsBaseArticleInfo	AbsBaseArticleInfo
    // Exception table:
    //   from	to	target	type
    //   386	403	406	org/json/JSONException
    //   372	386	411	org/json/JSONException
    //   361	372	416	org/json/JSONException
  }
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean1, Map<Long, ReadinjoyReportUtils.ExposureReportItem> paramMap1, String paramString, Context paramContext, int paramInt1, int paramInt2, ReadInJoyBaseViewController paramReadInJoyBaseViewController, boolean paramBoolean2, long paramLong)
  {
    Object localObject1 = this;
    Context localContext = paramContext;
    int i = paramInt1;
    boolean bool = paramBoolean2;
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramBoolean1))
    {
      RIJVideoReportManager.a(paramMap, i, paramReadInJoyBaseViewController.s());
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramMap.values().iterator();
      while (localIterator.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)localIterator.next();
        if (!localBaseReportData.a)
        {
          localBaseReportData.a = true;
          Object localObject2 = ((RIJFrameworkReportManager)localObject1).a(localContext, i);
          long l1 = ((Long)((Pair)localObject2).second).longValue();
          int j = ((Integer)((Pair)localObject2).first).intValue();
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localBaseReportData.g.longValue()), Integer.toString(localBaseReportData.h), RIJTransMergeKanDianReport.a(localBaseReportData.i, localBaseReportData.j, i, localBaseReportData.o), false);
          PublicAccountReportUtils.a("0X80066FC", "", "", Long.toString(localBaseReportData.g.longValue()), Integer.toString(localBaseReportData.h), RIJTransMergeKanDianReport.a(localBaseReportData.i, localBaseReportData.j, i, localBaseReportData.o));
          if (localBaseReportData.l != null)
          {
            String str1 = RIJTransMergeKanDianReport.a(localBaseReportData.i, localBaseReportData.j, paramInt1, localBaseReportData.o, localBaseReportData.p, NetworkUtil.isWifiConnected(paramContext), localBaseReportData.k, localBaseReportData.r, localBaseReportData.t, RIJFeedsType.n(localBaseReportData.l), localBaseReportData.l, l1, j, localBaseReportData.u, localBaseReportData.v, localBaseReportData.w, localBaseReportData.x, localBaseReportData.z, localBaseReportData.y, localBaseReportData.E);
            if (i == 56)
            {
              localObject2 = RIJVideoReportManager.a(localBaseReportData, str1, paramReadInJoyBaseViewController.j());
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
            if (ReadinjoyReportUtils.d(l2)) {
              localObject2 = "0X8009354";
            } else {
              localObject2 = "0X8007626";
            }
            if ((DailyModeConfigHandler.a(paramInt1)) || (RIJShowKanDianTabSp.a(l2))) {
              localObject2 = "0X8009CC8";
            }
            if (RIJItemViewTypeUtils.t(localBaseReportData.l)) {
              ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, str1, (String)localObject2);
            }
            for (;;)
            {
              break label873;
              if (RIJFeedsType.I(localBaseReportData.l))
              {
                ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, localContext, i);
              }
              else if (RIJFeedsType.P(localBaseReportData.l))
              {
                ((RIJFrameworkReportManager)localObject1).b(localBaseReportData, str1, (String)localObject2);
              }
              else if (RIJFeedsType.l(localBaseReportData.l))
              {
                a(localBaseReportData, str1, (String)localObject2, paramContext, paramInt1, paramBoolean2);
              }
              else if (RIJFeedsType.R(localBaseReportData.l))
              {
                ((RIJFrameworkReportManager)localObject1).a(localBaseReportData, i, (String)localObject2);
              }
              else if (localBaseReportData.l.mFeedType == 33)
              {
                localObject2 = localBaseReportData.l.getProteusItemData();
                if (localObject2 == null) {
                  return;
                }
                RIJVideoReportManager.a(false, (JSONObject)localObject2, localBaseReportData);
                RIJVideoReportManager.a(true, (JSONObject)localObject2, localBaseReportData);
              }
              else if (RIJFeedsType.N(localBaseReportData.l))
              {
                RIJVideoReportManager.a(localBaseReportData.l, localBaseReportData);
              }
              else
              {
                if (RIJFeedsType.F(localBaseReportData.l))
                {
                  localObject1 = localBaseReportData.l;
                  JSONObject localJSONObject = RIJKanDianFolderStatus.getPolymericCommonR5Report(((AbsBaseArticleInfo)localObject1).mPolymericInfo);
                  String str2 = localBaseReportData.s;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(localBaseReportData.B);
                  localStringBuilder.append("");
                  PublicAccountReportUtils.a(null, "CliOper", "", str2, "0X8008F57", "0X8008F57", 0, 0, localStringBuilder.toString(), Long.toString(localBaseReportData.g.longValue()), Long.toString(((AbsBaseArticleInfo)localObject1).mPolymericInfo.k), localJSONObject.toString(), false);
                  if (localHashMap.containsKey(Long.valueOf(((AbsBaseArticleInfo)localObject1).mPolymericInfo.h)))
                  {
                    localObject1 = this;
                    break;
                  }
                  localHashMap.put(Long.valueOf(((AbsBaseArticleInfo)localObject1).mPolymericInfo.h), Boolean.valueOf(true));
                }
                RIJVideoReportManager.a(localBaseReportData, l1, j, str1, (String)localObject2, paramContext, paramInt1, paramInt2, paramReadInJoyBaseViewController, paramBoolean2);
                localObject1 = this;
              }
            }
            label873:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager
 * JD-Core Version:    0.7.0.1
 */