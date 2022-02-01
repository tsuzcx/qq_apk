package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.List;

class RecycleViewAdapterHelper$3$3
  implements ViewBase.OnClickListener
{
  RecycleViewAdapterHelper$3$3(RecycleViewAdapterHelper.3 param3) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a.a() != null)) {
      ProteusSupportUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper.a.a(), this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    }
    ProteusSupportUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if ((RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper) != null) && (this.a.jdField_a_of_type_Int < RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper).size()))
    {
      RIJJumpUtils.a(RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper).getContext(), (AbsBaseArticleInfo)RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper).get(this.a.jdField_a_of_type_Int), paramViewBase.getEventAttachedData());
      return;
    }
    ReadInJoyUtils.a(RecycleViewAdapterHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper).getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper.3.3
 * JD-Core Version:    0.7.0.1
 */