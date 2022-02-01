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
  
  public void a()
  {
    FastWebActivity.a(this.b, this.a);
  }
  
  public void b() {}
  
  public void c()
  {
    if (AdData.a(this.a))
    {
      AdData localAdData = (AdData)this.a;
      if (localAdData.j != null)
      {
        ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).removeAdFromAllScene(Long.valueOf(localAdData.j.mAdAid));
        ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).handleExposedAd("RIJAdRefreshSceneNativeArticle", localAdData.j);
      }
    }
  }
  
  public int d()
  {
    return ((IRIJAdReqFreshService)QRoute.api(IRIJAdReqFreshService.class)).getExposeRate();
  }
  
  public BaseData e()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.22
 * JD-Core Version:    0.7.0.1
 */