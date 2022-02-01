package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdReqFreshService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.ItemShowCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;

class FastWebActivity$22
  implements ItemShowDispatcher.ItemShowCallback
{
  FastWebActivity$22(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
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
    FastWebActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData);
  }
  
  public void b() {}
  
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.22
 * JD-Core Version:    0.7.0.1
 */