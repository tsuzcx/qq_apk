package com.tencent.mobileqq.troopshare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

class TroopShareUtility$3
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
    if ((!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) || (((this.a.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4)) && ((this.a.b == 1) || (this.a.b == 0)))) {
      return;
    }
    ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.3
 * JD-Core Version:    0.7.0.1
 */