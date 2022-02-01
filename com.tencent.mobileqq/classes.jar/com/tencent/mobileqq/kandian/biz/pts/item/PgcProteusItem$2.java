package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

class PgcProteusItem$2
  implements ViewBase.OnClickListener
{
  PgcProteusItem$2(PgcProteusItem paramPgcProteusItem, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    PgcProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemPgcProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel())
    {
      paramViewBase = new StringBuilder();
      paramViewBase.append("click gallery comment for jumping to gallery articleinfo = ");
      paramViewBase.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
      paramViewBase.append(" position = ");
      paramViewBase.append(this.jdField_a_of_type_Int);
      QLog.d("PgcProteusItem", 2, paramViewBase.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcProteusItem.2
 * JD-Core Version:    0.7.0.1
 */