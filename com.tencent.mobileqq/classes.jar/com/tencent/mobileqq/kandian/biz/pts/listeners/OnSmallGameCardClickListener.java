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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private int b;
  private int c;
  
  public OnSmallGameCardClickListener(IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
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
    int j = this.jdField_a_of_type_Int;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    if (localAbsBaseArticleInfo != null)
    {
      int i;
      if (localAbsBaseArticleInfo.hasChannelInfo()) {
        i = localAbsBaseArticleInfo.mChannelInfoId;
      } else {
        i = 0;
      }
      boolean bool = TextUtils.isEmpty(localAbsBaseArticleInfo.mArticleFriendLikeText);
      String str = RIJFeedsType.c(localAbsBaseArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", localAbsBaseArticleInfo.mSubscribeID, "0X8007625", "0X8007625", 0, 0, Long.toString(localAbsBaseArticleInfo.mFeedId), Long.toString(localAbsBaseArticleInfo.mArticleID), Integer.toString(localAbsBaseArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(localAbsBaseArticleInfo.mAlgorithmID, RIJFeedsType.a(localAbsBaseArticleInfo), j, i, bool ^ true, NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext), str, localAbsBaseArticleInfo.mStrCircleId, localAbsBaseArticleInfo.innerUniqueID, RIJFeedsType.e(localAbsBaseArticleInfo), localAbsBaseArticleInfo), false);
      ReadinjoyReportUtils.CoreReport.a(localAbsBaseArticleInfo, j);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).a() != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo == null) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
      int i = this.c;
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
        paramViewBase = localBuilder.h(paramViewBase).i(String.valueOf(this.b)).a();
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameAd(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
        RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a);
        break;
      case 1119: 
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).jumpToMiniGame((AbsBaseArticleInfo)localObject1, this.jdField_a_of_type_AndroidContentContext, this.b);
        return;
      case 1118: 
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo.t))
        {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo.t);
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameGuideFollow(this.jdField_a_of_type_AndroidContentContext, (AbsBaseArticleInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g(), 5040702, true);
        }
        return;
      case 1117: 
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameGuideFollow(this.jdField_a_of_type_AndroidContentContext, (AbsBaseArticleInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g(), 5040703, true);
        ((IRIJMiniGameService)QRoute.api(IRIJMiniGameService.class)).followMiniGameAccount(((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.j);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo.r))
        {
          paramViewBase = (ReadInjoyImageView)paramViewBase;
          paramViewBase.mSrc = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo.r;
          paramViewBase.loadImage(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSmallMiniGameInfo.r);
        }
        return;
      case 1116: 
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(this.jdField_a_of_type_AndroidContentContext, (AbsBaseArticleInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g(), this.b, 1);
        paramViewBase = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.b(this.b);
        localObject1 = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a(this.b);
        break;
      case 1113: 
      case 1114: 
      case 1115: 
        i = a(i);
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportMiniGameFromRecommendCard(this.jdField_a_of_type_AndroidContentContext, (AbsBaseArticleInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g(), i, 1);
        paramViewBase = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.b(i);
        localObject1 = ((AbsBaseArticleInfo)localObject1).mSmallMiniGameInfo.a(i);
      }
      break label545;
      localObject1 = "";
      paramViewBase = (ViewBase)localObject2;
      label545:
      if ((!TextUtils.isEmpty(paramViewBase)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramViewBase, 2103, null)))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mini game url error jump by appid url = ");
          ((StringBuilder)localObject2).append(paramViewBase);
          QLog.d("OnSmallGameCardClickListener", 0, ((StringBuilder)localObject2).toString());
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, null, null, null, null, 2103, null);
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSmallGameCardClickListener
 * JD-Core Version:    0.7.0.1
 */