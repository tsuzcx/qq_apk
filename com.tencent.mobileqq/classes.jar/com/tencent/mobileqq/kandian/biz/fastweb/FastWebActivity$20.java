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
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.entity.ExposureArticle;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;

class FastWebActivity$20
  implements ItemShowDispatcher.ItemShowCallback
{
  FastWebActivity$20(FastWebActivity paramFastWebActivity, int paramInt, BaseData paramBaseData) {}
  
  public void a()
  {
    Object localObject1 = FastWebActivity.v(this.c).a(this.a);
    if (localObject1 != null) {
      ReportUtil.a(this.c.app, (AdData)this.b, ((ItemShowDispatcher.AdPostionReportManager)localObject1).d, ((ItemShowDispatcher.AdPostionReportManager)localObject1).c, false);
    } else {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineAdExposure(this.c.app, (AdData)this.b, false);
    }
    if (this.b.aS) {
      localObject1 = "innerAd";
    } else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfRecommendAdData(this.b)) {
      localObject1 = "recommendAd";
    } else {
      localObject1 = "bottomAd";
    }
    Object localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShow50percentOneSecond:on fast web ad expose report : type = ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(" title = ");
    localStringBuilder.append(((AdData)this.b).l);
    ((IRIJAdLogService)localObject2).d("REPORT_LINK", localStringBuilder.toString());
    try
    {
      localObject1 = RIJFeedsDynamicInsertController.INSTANCE;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AdData)this.b).y);
      ((StringBuilder)localObject2).append("");
      ((RIJFeedsDynamicInsertController)localObject1).deleteArticle(new ExposureArticle(((StringBuilder)localObject2).toString(), true));
      return;
    }
    catch (Exception localException)
    {
      label236:
      break label236;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "onShow50percentOneSecond:on fast web ad expose report : type = baseData adid error");
  }
  
  public void b()
  {
    Object localObject = FastWebActivity.v(this.c).a(this.a);
    if (localObject != null) {
      ReportUtil.a(this.c.app, (AdData)this.b, ((ItemShowDispatcher.AdPostionReportManager)localObject).d, ((ItemShowDispatcher.AdPostionReportManager)localObject).c, true);
    } else {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).reportNativeEngineAdExposure(this.c.app, (AdData)this.b, true);
    }
    if (this.b.aS) {
      localObject = "innerAd";
    } else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfRecommendAdData(this.b)) {
      localObject = "recommendAd";
    } else {
      localObject = "bottomAd";
    }
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onShow1percent:on fast web ad expose report : type = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" title = ");
    localStringBuilder.append(((AdData)this.b).l);
    localIRIJAdLogService.d("REPORT_LINK", localStringBuilder.toString());
  }
  
  public void c()
  {
    if (AdData.a(this.b))
    {
      AdData localAdData = (AdData)this.b;
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
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.20
 * JD-Core Version:    0.7.0.1
 */