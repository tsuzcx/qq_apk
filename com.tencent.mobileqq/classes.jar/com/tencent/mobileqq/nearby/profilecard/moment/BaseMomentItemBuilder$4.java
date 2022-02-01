package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class BaseMomentItemBuilder$4
  implements DialogInterface.OnClickListener
{
  BaseMomentItemBuilder$4(BaseMomentItemBuilder paramBaseMomentItemBuilder, MomentFeedInfo paramMomentFeedInfo, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131701105), 0).a();
      return;
    }
    ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentBaseMomentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.c, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.a, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentDataMomentFeedInfo.d, new BaseMomentItemBuilder.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */