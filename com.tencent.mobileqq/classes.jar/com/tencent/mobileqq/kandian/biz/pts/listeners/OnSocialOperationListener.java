package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OnSocialOperationListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  OnSocialOperationListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      ReportInfo localReportInfo = new ReportInfo();
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      FeedsReportData localFeedsReportData = new FeedsReportData();
      localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
      localReportInfo.mChannelId = ((int)paramAbsBaseArticleInfo.mChannelID);
      localReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
      localReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mOperation = paramInt;
      if (localObject != null)
      {
        localFeedsReportData.jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
          localFeedsReportData.jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        }
        localFeedsReportData.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        localFeedsReportData.jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject).d;
        paramAbsBaseArticleInfo = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList;
        if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
        {
          localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
          while (paramAbsBaseArticleInfo.hasNext())
          {
            localObject = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
            if (localObject != null) {
              localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = localFeedsReportData;
      paramAbsBaseArticleInfo = new ArrayList();
      paramAbsBaseArticleInfo.add(localReportInfo);
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
        paramString1 = paramString2;
      }
      if (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo))
      {
        paramString2 = paramAbsBaseArticleInfo.mSubscribeID;
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append("");
        paramString2.append(((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
        paramString2 = paramString2.toString();
      }
      int i;
      if (((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList != null) {
        i = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList.size();
      } else {
        i = 0;
      }
      boolean bool = TextUtils.isEmpty(((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaLangString);
      int j = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
      int k = ((SocializeFeedsInfo)localObject).d;
      int m = ((SocializeFeedsInfo)localObject).f;
      paramString2 = RIJTransMergeKanDianReport.a((int)paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(paramAbsBaseArticleInfo), paramString2, paramAbsBaseArticleInfo.innerUniqueID, i + 1, bool ^ true, j, k, m).build();
      long l1 = paramAbsBaseArticleInfo.mArticleID;
      if ((RIJFeedsType.j(paramAbsBaseArticleInfo)) || (RIJFeedsType.k(paramAbsBaseArticleInfo)) || (RIJFeedsType.m(paramAbsBaseArticleInfo)) || (RIJFeedsType.n(paramAbsBaseArticleInfo))) {
        l1 = paramAbsBaseArticleInfo.businessId;
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils;
      long l2;
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str = paramAbsBaseArticleInfo.mSubscribeID;
        l2 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str, paramString1, paramString1, 0, 0, String.valueOf(l2), String.valueOf(l1), ((StringBuilder)localObject).toString(), paramString2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        l2 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
        long l3 = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l2), paramString1, paramString1, 0, 0, String.valueOf(l3), String.valueOf(l1), ((StringBuilder)localObject).toString(), paramString2, false);
      }
      if ((!RIJFeedsType.s(paramAbsBaseArticleInfo)) && (!RIJFeedsType.t(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramAbsBaseArticleInfo);
    a(paramAbsBaseArticleInfo, a());
  }
  
  protected abstract int a();
  
  protected abstract void a(ViewBase paramViewBase);
  
  protected abstract void a(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public final void onClick(ViewBase paramViewBase)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    a(paramViewBase);
    c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).clickAdUgcSocialOperationReport(paramViewBase, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialOperationListener
 * JD-Core Version:    0.7.0.1
 */