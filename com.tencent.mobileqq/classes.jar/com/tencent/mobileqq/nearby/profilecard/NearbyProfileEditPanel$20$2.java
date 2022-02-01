package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class NearbyProfileEditPanel$20$2
  implements DialogInterface.OnClickListener
{
  NearbyProfileEditPanel$20$2(NearbyProfileEditPanel.20 param20, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.d();
    paramInt = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.j), paramInt + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.20.2
 * JD-Core Version:    0.7.0.1
 */