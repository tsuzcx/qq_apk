package com.tencent.mobileqq.troopshare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;

class TroopShareUtility$2
  implements DialogInterface.OnDismissListener
{
  TroopShareUtility$2(TroopShareUtility paramTroopShareUtility) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a == -1) && ((this.a.h instanceof TroopCreateLogicActivity)))
    {
      ((TroopCreateLogicActivity)this.a.h).finish();
      if (QLog.isColorLevel()) {
        QLog.d("TroopShareUtility", 2, "mShareActionSheet noItemClick, onDismiss");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.2
 * JD-Core Version:    0.7.0.1
 */