package com.tencent.mobileqq.troop.troopcard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopInfoActivity$11
  implements DialogInterface.OnClickListener
{
  TroopInfoActivity$11(TroopInfoActivity paramTroopInfoActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.finish();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.11
 * JD-Core Version:    0.7.0.1
 */