package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  AbsBaseArticleInfo a;
  Context b;
  
  OnSocialOperationListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      ReportInfo localReportInfo = new ReportInfo();
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      FeedsReportData localFeedsReportData = new FeedsReportData();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
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
        localFeedsReportData.a = ((SocializeFeedsInfo)localObject).a;
        if (((SocializeFeedsInfo)localObject).c != null) {
          localFeedsReportData.b = ((SocializeFeedsInfo)localObject).c.a;
        }
        localFeedsReportData.d = ((SocializeFeedsInfo)localObject).h;
        localFeedsReportData.e = ((SocializeFeedsInfo)localObject).j;
        paramAbsBaseArticleInfo = ((SocializeFeedsInfo)localObject).d;
        if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
        {
          localFeedsReportData.c = new ArrayList();
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
          while (paramAbsBaseArticleInfo.hasNext())
          {
            localObject = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
            if (localObject != null) {
              localFeedsReportData.c.add(Long.valueOf(((FeedsInfoUser)localObject).a));
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
      if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
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
        paramString2.append(((SocializeFeedsInfo)localObject).c.a);
        paramString2 = paramString2.toString();
      }
      int i;
      if (((SocializeFeedsInfo)localObject).d != null) {
        i = ((SocializeFeedsInfo)localObject).d.size();
      } else {
        i = 0;
      }
      boolean bool = TextUtils.isEmpty(((SocializeFeedsInfo)localObject).e);
      int j = ((SocializeFeedsInfo)localObject).h;
      int k = ((SocializeFeedsInfo)localObject).j;
      int m = ((SocializeFeedsInfo)localObject).l;
      paramString2 = RIJTransMergeKanDianReport.a((int)paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(paramAbsBaseArticleInfo), paramString2, paramAbsBaseArticleInfo.innerUniqueID, i + 1, bool ^ true, j, k, m).build();
      long l1 = paramAbsBaseArticleInfo.mArticleID;
      if ((RIJFeedsType.p(paramAbsBaseArticleInfo)) || (RIJFeedsType.q(paramAbsBaseArticleInfo)) || (RIJFeedsType.s(paramAbsBaseArticleInfo)) || (RIJFeedsType.t(paramAbsBaseArticleInfo))) {
        l1 = paramAbsBaseArticleInfo.businessId;
      }
      long l2;
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        String str = paramAbsBaseArticleInfo.mSubscribeID;
        l2 = ((SocializeFeedsInfo)localObject).a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, str, paramString1, paramString1, 0, 0, String.valueOf(l2), String.valueOf(l1), ((StringBuilder)localObject).toString(), paramString2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        l2 = ((SocializeFeedsInfo)localObject).s.e;
        long l3 = ((SocializeFeedsInfo)localObject).a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, String.valueOf(l2), paramString1, paramString1, 0, 0, String.valueOf(l3), String.valueOf(l1), ((StringBuilder)localObject).toString(), paramString2, false);
      }
      if ((!RIJFeedsType.y(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramAbsBaseArticleInfo;
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
    b(this.a);
    a(paramViewBase);
    c(this.a);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).clickAdUgcSocialOperationReport(paramViewBase, this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialOperationListener
 * JD-Core Version:    0.7.0.1
 */