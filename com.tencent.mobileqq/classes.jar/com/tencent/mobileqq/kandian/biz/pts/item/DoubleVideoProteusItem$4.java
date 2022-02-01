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
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mProteusTemplateBean;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
    }
    if (localObject1 != null)
    {
      paramViewBase = DoubleVideoProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDoubleVideoProteusItem, (TemplateBean)localObject1, paramViewBase);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideoSingle(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).jumpToMiniGame(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g());
        return;
      }
      localObject1 = (ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      ((ReadInJoyBaseAdapter)localObject1).a(false, (AbsBaseArticleInfo)localObject2, this.b, ((AbsBaseArticleInfo)localObject2).innerUniqueID, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem.4
 * JD-Core Version:    0.7.0.1
 */