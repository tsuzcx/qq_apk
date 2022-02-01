package com.tencent.mobileqq.kandian.glue.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusListenersUtils;
import com.tencent.qphone.base.util.QLog;

class ProteusSupportUtil$2$1
  implements ViewBase.OnClickListener
{
  ProteusSupportUtil$2$1(ProteusSupportUtil.2 param2, int paramInt, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      ProteusListenersUtils.a.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemProteusItemView, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsUtilProteusSupportUtil$2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
      return;
    }
    catch (Exception paramViewBase)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invokeListener error! cmd=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" msg=");
      localStringBuilder.append(paramViewBase);
      QLog.d("ProteusSupportUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil.2.1
 * JD-Core Version:    0.7.0.1
 */