package com.tencent.mobileqq.nearby.profilecard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QQCustomDialog;

class NearbyProfileEditTribePanel$14$3
  implements DialogInterface.OnClickListener
{
  NearbyProfileEditTribePanel$14$3(NearbyProfileEditTribePanel.14 param14, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel$14.a.e();
    paramDialogInterface = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.14.3
 * JD-Core Version:    0.7.0.1
 */