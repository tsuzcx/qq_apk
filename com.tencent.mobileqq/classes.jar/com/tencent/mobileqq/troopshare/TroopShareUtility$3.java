package com.tencent.mobileqq.troopshare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;

class TroopShareUtility$3
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.c = false;
    if ((paramDialogInterface.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity))
    {
      if ((this.a.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
      {
        if (this.a.b == 1) {
          return;
        }
        if (this.a.b == 0) {
          return;
        }
      }
      ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.3
 * JD-Core Version:    0.7.0.1
 */