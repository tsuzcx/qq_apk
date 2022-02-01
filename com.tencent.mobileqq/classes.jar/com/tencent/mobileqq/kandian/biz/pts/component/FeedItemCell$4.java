package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.ad.api.IRIJDiversionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.KandianNegativeWindowForAd.OnDiversionListener;

class FeedItemCell$4
  implements KandianNegativeWindowForAd.OnDiversionListener
{
  FeedItemCell$4(FeedItemCell paramFeedItemCell) {}
  
  public void a()
  {
    ((IRIJDiversionService)QRoute.api(IRIJDiversionService.class)).jump(this.a.e, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.4
 * JD-Core Version:    0.7.0.1
 */