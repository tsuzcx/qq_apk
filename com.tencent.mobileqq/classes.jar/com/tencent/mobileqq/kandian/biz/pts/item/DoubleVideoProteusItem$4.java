package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DoubleVideoProteusItem$4
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$4(DoubleVideoProteusItem paramDoubleVideoProteusItem, IReadInJoyModel paramIReadInJoyModel, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    EventCollector.getInstance().onViewClicked(paramViewBase.getNativeView());
    Object localObject2 = this.a.k().mProteusTemplateBean;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ProteusSupportUtil.c(this.a.t(), this.b, this.a.k());
    }
    if (localObject1 != null)
    {
      paramViewBase = DoubleVideoProteusItem.a(this.e, (TemplateBean)localObject1, paramViewBase);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideoSingle(this.c))
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).jumpToMiniGame(this.c, this.a.t().getContext(), this.a.r());
        return;
      }
      localObject1 = (ReadInJoyBaseAdapter)this.a.u();
      localObject2 = this.c;
      ((ReadInJoyBaseAdapter)localObject1).a(false, (AbsBaseArticleInfo)localObject2, this.d, ((AbsBaseArticleInfo)localObject2).innerUniqueID, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem.4
 * JD-Core Version:    0.7.0.1
 */