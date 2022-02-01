package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJMiniGameService;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.CoreReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;

public class OnSmallGameCardClickListener
  implements ViewBase.OnClickListener
{
  private IReadInJoyModel a;
  private Context b;
  private int c;
  private int d;
  private int e;
  
  public OnSmallGameCardClickListener(IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramIReadInJoyModel;
    this.b = paramContext;
    this.e = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1115: 
      return 2;
    case 1114: 
      return 1;
    }
    return 0;
  }
  
  public void a()
  {
    int j = this.c;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.k();
    if (localAbsBaseArticleInfo != null)
    {
      int i;
      if (localAbsBaseArticleInfo.hasChannelInfo()) {
        i = localAbsBaseArticleInfo.mChannelInfoId;
      } else {
        i = 0;
      }
      boolean bool = TextUtils.isEmpty(localAbsBaseArticleInfo.mArticleFriendLikeText);
      String str = RIJFeedsType.k(localAbsBaseArticleInfo);
      PublicAccountReportUtils.a(null, "CliOper", "", localAbsBaseArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(localAbsBaseArticleInfo.mFeedId), Long.toString(localAbsBaseArticleInfo.mArticleID), Integer.toString(localAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(localAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.g(localAbsBaseArticleInfo), j, i, bool ^ true, NetworkUtil.isWifiConnected(this.b), str, localAbsBaseArticleInfo.mStrCircleId, localAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.n(localAbsBaseArticleInfo), localAbsBaseArticleInfo), false);
      ReadinjoyReportUtils.CoreReport.a(localAbsBaseArticleInfo, j);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).k() != null))
    {
      if (this.a.k().mSmallMiniGameInfo == null) {
        return;
      }
      localObject1 = this.a.k();
      int i = this.e;
      Object localObject2 = "";
      switch (i)
      {
      default: 
        break;
      case 1120: 
        AdReportExtData.Builder localBuilder = new AdReportExtData.Builder().a(501L).b(50101L).c(5010105L).d(9L);
        if (((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a()) {
          paramViewBase = "3";
        } else {
          paramViewBase = "2";
        }
        paramViewBase = localBuilder.h(paramViewBase).i(String.valueOf(this.d)).a();
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameAd(this.b, paramViewBase);
        RIJJumpUtils.c(this.b, ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a);
        break;
      case 1119: 
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).jumpToMiniGame((AbsBaseArticleInfo)localObject1, this.b, this.d);
        return;
      case 1118: 
        if (!TextUtils.isEmpty(this.a.k().mSmallMiniGameInfo.w))
        {
          ReadInJoyUtils.a(this.b, this.a.k().mSmallMiniGameInfo.w);
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameGuideFollow(this.b, (AbsBaseArticleInfo)localObject1, this.a.r(), 5040702, true);
        }
        return;
      case 1117: 
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameGuideFollow(this.b, (AbsBaseArticleInfo)localObject1, this.a.r(), 5040703, true);
        ((IRIJMiniGameService)QRoute.api(IRIJMiniGameService.class)).followMiniGameAccount(((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.m);
        if (!TextUtils.isEmpty(this.a.k().mSmallMiniGameInfo.u))
        {
          paramViewBase = (ReadInjoyImageView)paramViewBase;
          paramViewBase.mSrc = this.a.k().mSmallMiniGameInfo.u;
          paramViewBase.loadImage(this.a.k().mSmallMiniGameInfo.u);
        }
        return;
      case 1116: 
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(this.b, (AbsBaseArticleInfo)localObject1, this.a.r(), this.d, 1);
        paramViewBase = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.b(this.d);
        localObject1 = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a(this.d);
        break;
      case 1113: 
      case 1114: 
      case 1115: 
        i = a(i);
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(this.b, (AbsBaseArticleInfo)localObject1, this.a.r(), i, 1);
        paramViewBase = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.b(i);
        localObject1 = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a(i);
      }
      break label545;
      localObject1 = "";
      paramViewBase = (ViewBase)localObject2;
      label545:
      if ((!TextUtils.isEmpty(paramViewBase)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.b, paramViewBase, 2103, null)))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mini game url error jump by appid url = ");
          ((StringBuilder)localObject2).append(paramViewBase);
          QLog.d("OnSmallGameCardClickListener", 0, ((StringBuilder)localObject2).toString());
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(this.b, (String)localObject1, null, null, null, null, 2103, null);
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSmallGameCardClickListener
 * JD-Core Version:    0.7.0.1
 */