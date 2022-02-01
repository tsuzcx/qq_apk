package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class NearbyProfileEditPanel$20$2
  implements DialogInterface.OnClickListener
{
  NearbyProfileEditPanel$20$2(NearbyProfileEditPanel.20 param20, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.quitEditWithoutSaving();
    paramInt = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.app;
    String str = NearbyUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel$20.a.a.from);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(paramDialogInterface, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, str, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.20.2
 * JD-Core Version:    0.7.0.1
 */