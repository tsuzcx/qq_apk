package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.util.FeedExposureHelper.Range;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory;
import com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory.Companion;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsExposureSwitchAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RIJReportDataCollectionManager
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, RIJDataManager paramRIJDataManager)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = paramInt1 - paramInt2 + i;
      if ((j < paramRIJDataManager.a().v().getCount()) && (j >= 0))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramRIJDataManager.a().v().getItem(j);
        if (localAbsBaseArticleInfo != null) {
          a(localAbsBaseArticleInfo, new ReadInJoyModelImpl(paramRIJDataManager.a().A(), localAbsBaseArticleInfo, paramRIJDataManager.a().v().getItemViewType(j), paramRIJDataManager.a().B(), paramRIJDataManager.a().r(), j, paramRIJDataManager.a().n(), paramRIJDataManager.a().v().getCount(), null, paramRIJDataManager.a().v()), System.currentTimeMillis(), j, paramRIJDataManager);
        }
      }
      i += 1;
    }
  }
  
  public static void a(View paramView, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramInt == 46) {
      return;
    }
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return;
    }
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementEndExposePolicy(paramView, EndExposurePolicy.REPORT_ALL);
    VideoReport.setElementId(paramView, "card");
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().B())).a("14");
    String str = "null";
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID))) {
      paramRIJDataManager = paramAbsBaseArticleInfo.innerUniqueID;
    } else {
      paramRIJDataManager = "null";
    }
    localRIJDtParamBuilder = localRIJDtParamBuilder.e(paramRIJDataManager).b("list").c("click_contentid");
    if (paramAbsBaseArticleInfo != null) {
      paramRIJDataManager = paramAbsBaseArticleInfo.dtReportBackendInfo;
    } else {
      paramRIJDataManager = "";
    }
    paramRIJDataManager = localRIJDtParamBuilder.g(paramRIJDataManager);
    if (paramAbsBaseArticleInfo != null) {
      paramInt = paramAbsBaseArticleInfo.dtReportContentType;
    } else {
      paramInt = 5;
    }
    VideoReport.setElementParams(paramView, paramRIJDataManager.b(Integer.valueOf(paramInt)).a().c());
    paramRIJDataManager = str;
    if (paramAbsBaseArticleInfo != null)
    {
      paramRIJDataManager = str;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
        paramRIJDataManager = paramAbsBaseArticleInfo.innerUniqueID;
      }
    }
    VideoReport.setElementReuseIdentifier(paramView, paramRIJDataManager);
  }
  
  public static void a(FeedExposureHelper.Range paramRange, int paramInt, RIJDataManager paramRIJDataManager)
  {
    new ArrayList();
    int i = paramRange.b;
    while (i <= paramRange.c)
    {
      int j = i - paramInt;
      if (j >= 0)
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = paramRIJDataManager.c(j);
        if (localAbsBaseArticleInfo != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onExposure : ");
          localStringBuilder.append(localAbsBaseArticleInfo);
          localStringBuilder.append(" proteusItemsData : ");
          localStringBuilder.append(localAbsBaseArticleInfo.proteusItemsData);
          QLog.d("FeedExposureHelper", 2, localStringBuilder.toString());
          ReadinjoyReportUtils.a(localAbsBaseArticleInfo, paramRange.a);
        }
      }
      i += 1;
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt, RIJDataManager paramRIJDataManager)
  {
    Object localObject;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mArticleContentUrl != null) && (paramAbsBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi://readinjoy/open")) && (paramAbsBaseArticleInfo.mArticleContentUrl.contains("appSchema=rijvideo")) && (paramAbsBaseArticleInfo.mArticleContentUrl.contains("target=4")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("ugType", "1");
      if (PackageUtil.a(BaseApplication.getContext(), "com.tencent.rijvideo")) {
        ((HashMap)localObject).put("stateType", "2");
      } else {
        ((HashMap)localObject).put("stateType", "1");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(RIJQQAppInterfaceUtil.d(), "actKanDianUgExpo", true, 0L, 0L, (HashMap)localObject, "", true);
    }
    if ((paramAbsBaseArticleInfo != null) && (paramRIJDataManager.a().k() != null))
    {
      boolean bool = paramAbsBaseArticleInfo instanceof BaseArticleInfo;
      if ((bool) && (paramRIJDataManager.a().j().b(paramAbsBaseArticleInfo)) && (!PTSLiteItemViewBuilder.c(paramAbsBaseArticleInfo))) {
        return;
      }
      if ((bool) && (PTSLiteItemViewBuilder.b(paramAbsBaseArticleInfo))) {
        return;
      }
      if ((RIJFeedsType.G(paramAbsBaseArticleInfo)) && (!RIJFeedsType.I(paramAbsBaseArticleInfo))) {
        return;
      }
      if ((BaseArticleInfoKt.a(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0) && (paramAbsBaseArticleInfo.mFeedType != 121))
      {
        localObject = paramAbsBaseArticleInfo.mSubArticleList.iterator();
        while (((Iterator)localObject).hasNext()) {
          a((AbsBaseArticleInfo)((Iterator)localObject).next(), new ReadInJoyModelImpl(paramRIJDataManager.a().A(), paramAbsBaseArticleInfo, 46, paramRIJDataManager.a().B(), paramRIJDataManager.a().r(), paramInt, paramRIJDataManager.a().n(), paramRIJDataManager.a().v().getCount(), null, paramRIJDataManager.a().v()), paramLong, paramInt, paramRIJDataManager);
        }
      }
      PTSLiteDataFactory.a.a(paramAbsBaseArticleInfo, paramLong, paramInt, paramRIJDataManager);
      if ((RIJFeedsType.l(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mNewPolymericInfo.a)) {
        bool = paramRIJDataManager.a().l().containsKey(Long.valueOf(-paramAbsBaseArticleInfo.mArticleID));
      } else {
        bool = paramRIJDataManager.a().l().containsKey(Long.valueOf(paramAbsBaseArticleInfo.mArticleID));
      }
      if ((bool ^ true)) {
        ThreadManager.post(new RIJReportDataCollectionManager.1(paramAbsBaseArticleInfo, paramIReadInJoyModel, paramInt, paramRIJDataManager, paramLong, paramAbsBaseArticleInfo), 5, null, true);
      }
      if (RIJKanDianFeedsExposureSwitchAladdinConfig.a()) {
        ThreadManager.executeOnSubThread(new RIJReportDataCollectionManager.2(paramRIJDataManager, paramAbsBaseArticleInfo));
      }
    }
  }
  
  public static void a(BaseReportData paramBaseReportData, int paramInt1, int paramInt2)
  {
    if (RIJFeedsType.G(paramBaseReportData.l))
    {
      paramBaseReportData.b = true;
      return;
    }
    if (!paramBaseReportData.b)
    {
      paramBaseReportData.b = true;
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
      localReportInfo.mSource = paramInt1;
      localReportInfo.mSourceArticleId = paramBaseReportData.g.longValue();
      if (paramBaseReportData.l != null) {
        paramInt1 = (int)paramBaseReportData.l.mChannelID;
      } else {
        paramInt1 = 0;
      }
      localReportInfo.mChannelId = paramInt1;
      localReportInfo.mAlgorithmId = ((int)paramBaseReportData.i);
      localReportInfo.mStrategyId = paramBaseReportData.h;
      localReportInfo.mOperation = paramInt2;
      localReportInfo.mServerContext = paramBaseReportData.q;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mInnerId = paramBaseReportData.t;
      if ((paramBaseReportData.l != null) && (paramBaseReportData.l.mVideoColumnInfo != null)) {
        localReportInfo.mColumnID = paramBaseReportData.l.mVideoColumnInfo.b;
      }
      if ((paramBaseReportData.l != null) && (paramBaseReportData.l.mSocialFeedInfo != null) && (!RIJFeedsType.I(paramBaseReportData.l)))
      {
        FeedsReportData localFeedsReportData = new FeedsReportData();
        localFeedsReportData.a = paramBaseReportData.l.mSocialFeedInfo.a;
        if (paramBaseReportData.l.mSocialFeedInfo.c != null) {
          localFeedsReportData.b = paramBaseReportData.l.mSocialFeedInfo.c.a;
        }
        localFeedsReportData.d = paramBaseReportData.l.mSocialFeedInfo.h;
        localFeedsReportData.e = paramBaseReportData.l.mSocialFeedInfo.j;
        Object localObject = paramBaseReportData.l.mSocialFeedInfo.d;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localFeedsReportData.c = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject).next();
            if (localFeedsInfoUser != null) {
              localFeedsReportData.c.add(Long.valueOf(localFeedsInfoUser.a));
            }
          }
        }
        localReportInfo.mFeedsReportData = localFeedsReportData;
      }
      localReportInfo.dynamicInsertReportData = paramBaseReportData.G;
      if ((paramBaseReportData.l != null) && (DailyModeConfigHandler.c((int)paramBaseReportData.l.mChannelID)))
      {
        localReportInfo.mSearchTagName = paramBaseReportData.F;
        KandianDailyReportUtils.a(localReportInfo);
        return;
      }
      localArrayList.add(localReportInfo);
      paramBaseReportData = new StringBuilder();
      paramBaseReportData.append("report0x64eExposureInfo: article ");
      paramBaseReportData.append(localReportInfo.mSourceArticleId);
      paramBaseReportData.append(" exposed!");
      QLog.d("RIJReportDataManager", 2, paramBaseReportData.toString());
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
  }
  
  private static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if (paramAbsBaseArticleInfo.mFeedType == 3)
    {
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = paramRIJDataManager.a().B();
      localReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
      localReportInfo.mOperation = 7;
      localReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
        localReportInfo.mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
      }
      localArrayList.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(localArrayList);
    }
  }
  
  private static void b(BaseReportData paramBaseReportData)
  {
    a(paramBaseReportData, 0, 7);
  }
  
  private static void b(BaseReportData paramBaseReportData, RIJDataManager paramRIJDataManager)
  {
    if (DailyModeConfigHandler.c(paramRIJDataManager.a().B())) {
      try
      {
        paramRIJDataManager.a().m().add(paramBaseReportData);
        return;
      }
      catch (Exception paramBaseReportData)
      {
        paramRIJDataManager = new StringBuilder();
        paramRIJDataManager.append("mDailyReportDatas error!  msg=");
        paramRIJDataManager.append(paramBaseReportData);
        QLog.d("RIJReportDataManager", 2, paramRIJDataManager.toString());
      }
    }
  }
  
  private static void b(BaseReportData paramBaseReportData, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, IReadInJoyModel paramIReadInJoyModel)
  {
    boolean bool = RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo);
    int i = 1;
    if (((bool) || (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) && (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo)))
    {
      paramBaseReportData.s = String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
      paramBaseReportData.g = Long.valueOf(paramAbsBaseArticleInfo.businessId);
    }
    else if ((RIJFeedsType.F(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPolymericInfo.e == 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mPolymericInfo.f);
      localStringBuilder.append("");
      paramBaseReportData.s = localStringBuilder.toString();
      paramBaseReportData.g = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    else if (RIJFeedsType.I(paramAbsBaseArticleInfo))
    {
      if (RIJFeedsType.G(paramAbsBaseArticleInfo))
      {
        if (paramAbsBaseArticleInfo.mGroupSubArticleList.size() >= 1)
        {
          if (!TextUtils.isEmpty(((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
            paramBaseReportData.n = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
          }
          paramBaseReportData.t = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
        }
      }
      else
      {
        paramBaseReportData.B = paramInt;
        if (paramAbsBaseArticleInfo.mPolymericInfo != null) {
          paramAbsBaseArticleInfo.mPolymericInfo.r = true;
        }
      }
      paramBaseReportData.g = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    else if (RIJFeedsType.l(paramAbsBaseArticleInfo))
    {
      paramBaseReportData.s = paramAbsBaseArticleInfo.mSubscribeID;
      paramBaseReportData.g = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    else
    {
      paramBaseReportData.s = paramAbsBaseArticleInfo.mSubscribeID;
      paramBaseReportData.g = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    if (paramBaseReportData.e)
    {
      if (paramIReadInJoyModel.c()) {
        paramInt = 2;
      } else if (paramIReadInJoyModel.f()) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      paramBaseReportData.f = paramInt;
    }
  }
  
  private static void b(BaseReportData paramBaseReportData, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if ((RIJFeedsType.l(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mNewPolymericInfo.a))
    {
      paramRIJDataManager.a().l().put(Long.valueOf(-paramAbsBaseArticleInfo.mArticleID), paramBaseReportData);
      return;
    }
    paramRIJDataManager.a().l().put(Long.valueOf(paramAbsBaseArticleInfo.mArticleID), paramBaseReportData);
  }
  
  private static void b(BaseReportData paramBaseReportData, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel)
  {
    long l = paramAbsBaseArticleInfo.mGroupId;
    boolean bool2 = false;
    boolean bool1;
    if ((l == -1L) && (!paramAbsBaseArticleInfo.isSubscriptFeed())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    paramBaseReportData.c = bool1;
    paramBaseReportData.d = paramIReadInJoyModel.a();
    if (!paramIReadInJoyModel.c())
    {
      bool1 = bool2;
      if (!paramIReadInJoyModel.f()) {}
    }
    else
    {
      bool1 = true;
    }
    paramBaseReportData.e = bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager
 * JD-Core Version:    0.7.0.1
 */