package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.util.FeedExposureHelper.Range;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
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
      if ((j < paramRIJDataManager.a().a().getCount()) && (j >= 0))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramRIJDataManager.a().a().getItem(j);
        if (localAbsBaseArticleInfo != null) {
          a(localAbsBaseArticleInfo, new ReadInJoyModelImpl(paramRIJDataManager.a().a(), localAbsBaseArticleInfo, paramRIJDataManager.a().a().getItemViewType(j), paramRIJDataManager.a().b(), paramRIJDataManager.a().a(), j, paramRIJDataManager.a().d(), paramRIJDataManager.a().a().getCount(), null, paramRIJDataManager.a().a()), System.currentTimeMillis(), j, paramRIJDataManager);
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
    RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Integer.valueOf(paramRIJDataManager.a().b())).a("14");
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
    VideoReport.setElementParams(paramView, paramRIJDataManager.b(Integer.valueOf(paramInt)).a().a());
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
    int i = paramRange.jdField_a_of_type_Int;
    while (i <= paramRange.jdField_b_of_type_Int)
    {
      int j = i - paramInt;
      if (j >= 0)
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = paramRIJDataManager.a(j);
        if (localAbsBaseArticleInfo != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onExposure : ");
          localStringBuilder.append(localAbsBaseArticleInfo);
          localStringBuilder.append(" proteusItemsData : ");
          localStringBuilder.append(localAbsBaseArticleInfo.proteusItemsData);
          QLog.d("FeedExposureHelper", 2, localStringBuilder.toString());
          ReadinjoyReportUtils.a(localAbsBaseArticleInfo, paramRange.jdField_a_of_type_Long);
        }
      }
      i += 1;
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt, RIJDataManager paramRIJDataManager)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramRIJDataManager.a().a() != null))
    {
      boolean bool = paramAbsBaseArticleInfo instanceof BaseArticleInfo;
      if ((bool) && (paramRIJDataManager.a().a().b(paramAbsBaseArticleInfo)) && (!PTSLiteItemViewBuilder.b(paramAbsBaseArticleInfo))) {
        return;
      }
      if ((bool) && (PTSLiteItemViewBuilder.a(paramAbsBaseArticleInfo))) {
        return;
      }
      if ((RIJFeedsType.A(paramAbsBaseArticleInfo)) && (!RIJFeedsType.C(paramAbsBaseArticleInfo))) {
        return;
      }
      if ((BaseArticleInfoKt.a(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0) && (paramAbsBaseArticleInfo.mFeedType != 121))
      {
        Iterator localIterator = paramAbsBaseArticleInfo.mSubArticleList.iterator();
        while (localIterator.hasNext()) {
          a((AbsBaseArticleInfo)localIterator.next(), new ReadInJoyModelImpl(paramRIJDataManager.a().a(), paramAbsBaseArticleInfo, 46, paramRIJDataManager.a().b(), paramRIJDataManager.a().a(), paramInt, paramRIJDataManager.a().d(), paramRIJDataManager.a().a().getCount(), null, paramRIJDataManager.a().a()), paramLong, paramInt, paramRIJDataManager);
        }
      }
      PTSLiteDataFactory.a.a(paramAbsBaseArticleInfo, paramLong, paramInt, paramRIJDataManager);
      if ((RIJFeedsType.h(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)) {
        bool = paramRIJDataManager.a().a().containsKey(Long.valueOf(-paramAbsBaseArticleInfo.mArticleID));
      } else {
        bool = paramRIJDataManager.a().a().containsKey(Long.valueOf(paramAbsBaseArticleInfo.mArticleID));
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
    if (RIJFeedsType.A(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      paramBaseReportData.jdField_b_of_type_Boolean = true;
      return;
    }
    if (!paramBaseReportData.jdField_b_of_type_Boolean)
    {
      paramBaseReportData.jdField_b_of_type_Boolean = true;
      ArrayList localArrayList = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      localReportInfo.mSource = paramInt1;
      localReportInfo.mSourceArticleId = paramBaseReportData.jdField_a_of_type_JavaLangLong.longValue();
      if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) {
        paramInt1 = (int)paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID;
      } else {
        paramInt1 = 0;
      }
      localReportInfo.mChannelId = paramInt1;
      localReportInfo.mAlgorithmId = ((int)paramBaseReportData.jdField_a_of_type_Long);
      localReportInfo.mStrategyId = paramBaseReportData.jdField_b_of_type_Int;
      localReportInfo.mOperation = paramInt2;
      localReportInfo.mServerContext = paramBaseReportData.jdField_a_of_type_ArrayOfByte;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mInnerId = paramBaseReportData.jdField_e_of_type_JavaLangString;
      if ((paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo != null)) {
        localReportInfo.mColumnID = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if ((paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (!RIJFeedsType.C(paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
      {
        FeedsReportData localFeedsReportData = new FeedsReportData();
        localFeedsReportData.jdField_a_of_type_Long = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
          localFeedsReportData.jdField_b_of_type_Long = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        }
        localFeedsReportData.jdField_a_of_type_Int = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localFeedsReportData.jdField_b_of_type_Int = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.d;
        Object localObject = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject).next();
            if (localFeedsInfoUser != null) {
              localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = localFeedsReportData;
      }
      localReportInfo.dynamicInsertReportData = paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData;
      if ((paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (DailyModeConfigHandler.c((int)paramBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID)))
      {
        localReportInfo.mSearchTagName = paramBaseReportData.f;
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
      localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = paramRIJDataManager.a().b();
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
    if (DailyModeConfigHandler.c(paramRIJDataManager.a().b())) {
      try
      {
        paramRIJDataManager.a().a().add(paramBaseReportData);
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
      paramBaseReportData.jdField_d_of_type_JavaLangString = String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.businessId);
    }
    else if ((RIJFeedsType.z(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mPolymericInfo.jdField_b_of_type_Long);
      localStringBuilder.append("");
      paramBaseReportData.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    else if (RIJFeedsType.C(paramAbsBaseArticleInfo))
    {
      if (RIJFeedsType.A(paramAbsBaseArticleInfo))
      {
        if (paramAbsBaseArticleInfo.mGroupSubArticleList.size() >= 1)
        {
          if (!TextUtils.isEmpty(((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid)) {
            paramBaseReportData.jdField_b_of_type_JavaLangString = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).mVideoVid;
          }
          paramBaseReportData.jdField_e_of_type_JavaLangString = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).innerUniqueID;
        }
      }
      else
      {
        paramBaseReportData.k = paramInt;
        if (paramAbsBaseArticleInfo.mPolymericInfo != null) {
          paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Boolean = true;
        }
      }
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    else if (RIJFeedsType.h(paramAbsBaseArticleInfo))
    {
      paramBaseReportData.jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.mSubscribeID;
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    else
    {
      paramBaseReportData.jdField_d_of_type_JavaLangString = paramAbsBaseArticleInfo.mSubscribeID;
      paramBaseReportData.jdField_a_of_type_JavaLangLong = Long.valueOf(paramAbsBaseArticleInfo.mArticleID);
    }
    if (paramBaseReportData.jdField_e_of_type_Boolean)
    {
      if (paramIReadInJoyModel.b()) {
        paramInt = 2;
      } else if (paramIReadInJoyModel.d()) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      paramBaseReportData.jdField_a_of_type_Int = paramInt;
    }
  }
  
  private static void b(BaseReportData paramBaseReportData, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJDataManager paramRIJDataManager)
  {
    if ((RIJFeedsType.h(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      paramRIJDataManager.a().a().put(Long.valueOf(-paramAbsBaseArticleInfo.mArticleID), paramBaseReportData);
      return;
    }
    paramRIJDataManager.a().a().put(Long.valueOf(paramAbsBaseArticleInfo.mArticleID), paramBaseReportData);
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
    paramBaseReportData.jdField_d_of_type_Boolean = paramIReadInJoyModel.a();
    if (!paramIReadInJoyModel.b())
    {
      bool1 = bool2;
      if (!paramIReadInJoyModel.d()) {}
    }
    else
    {
      bool1 = true;
    }
    paramBaseReportData.jdField_e_of_type_Boolean = bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager
 * JD-Core Version:    0.7.0.1
 */