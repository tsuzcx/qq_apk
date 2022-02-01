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
    paramDialogInterface.r = false;
    if ((paramDialogInterface.h instanceof TroopCreateLogicActivity))
    {
      if ((this.a.a == 0) || (this.a.a == 1) || (this.a.a == 2) || (this.a.a == 3) || (this.a.a == 4))
      {
        if (this.a.b == 1) {
          return;
        }
        if (this.a.b == 0) {
          return;
        }
      }
      ((TroopCreateLogicActivity)this.a.h).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.3
 * JD-Core Version:    0.7.0.1
 */