package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.AdPostionReportManager;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.ItemShowCallback;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;

class FastWebActivity$20
  implements ItemShowDispatcher.ItemShowCallback
{
  FastWebActivity$20(FastWebActivity paramFastWebActivity, int paramInt, BaseData paramBaseData) {}
  
  public int a()
  {
    return ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).getExposeRate();
  }
  
  public BaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData;
  }
  
  public void a()
  {
    Object localObject1 = FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject1 != null) {
      ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, ((ItemShowDispatcher.AdPostionReportManager)localObject1).jdField_a_of_type_Float, ((ItemShowDispatcher.AdPostionReportManager)localObject1).jdField_a_of_type_Long, false);
    } else {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineAdExposure(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.f) {
      localObject1 = "innerAd";
    } else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfRecommendAdData(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData)) {
      localObject1 = "recommendAd";
    } else {
      localObject1 = "bottomAd";
    }
    Object localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShow50percentOneSecond:on fast web ad expose report : type = ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" title = ");
    localStringBuilder.append(((AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).j);
    ((IRIJAdLogService)localObject2).d("REPORT_LINK", localStringBuilder.toString());
    try
    {
      localObject1 = (IRIJFeedsDynamicInsertController)QRoute.api(IRIJFeedsDynamicInsertController.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).e);
      ((StringBuilder)localObject2).append("");
      ((IRIJFeedsDynamicInsertController)localObject1).deleteArticle(new ExposureArticle(((StringBuilder)localObject2).toString(), true));
      return;
    }
    catch (Exception localException)
    {
      label243:
      break label243;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "onShow50percentOneSecond:on fast web ad expose report : type = baseData adid error");
  }
  
  public void b()
  {
    Object localObject = FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity).a(this.jdField_a_of_type_Int);
    if (localObject != null) {
      ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Float, ((ItemShowDispatcher.AdPostionReportManager)localObject).jdField_a_of_type_Long, true);
    } else {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineAdExposure(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.app, (AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.f) {
      localObject = "innerAd";
    } else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfRecommendAdData(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData)) {
      localObject = "recommendAd";
    } else {
      localObject = "bottomAd";
    }
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShow1percent:on fast web ad expose report : type = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" title = ");
    localStringBuilder.append(((AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).j);
    localIRIJAdLogService.d("REPORT_LINK", localStringBuilder.toString());
  }
  
  public void c()
  {
    if (AdData.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData))
    {
      AdData localAdData = (AdData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData;
      if (localAdData.a != null)
      {
        ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).removeAdFromAllScene(Long.valueOf(localAdData.a.mAdAid));
        ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).handleExposedAd("RIJAdRefreshSceneNativeArticle", localAdData.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.20
 * JD-Core Version:    0.7.0.1
 */