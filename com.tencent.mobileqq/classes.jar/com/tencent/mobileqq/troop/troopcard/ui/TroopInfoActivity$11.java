package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopInfoActivity$11
  implements DialogInterface.OnClickListener
{
  TroopInfoActivity$11(TroopInfoActivity paramTroopInfoActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.b, true);
    this.b.finish();
    paramDialogInterface = this.a;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      this.a.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.11
 * JD-Core Version:    0.7.0.1
 */