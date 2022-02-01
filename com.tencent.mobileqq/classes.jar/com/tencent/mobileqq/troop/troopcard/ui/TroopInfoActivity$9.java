package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopInfoActivity$9
  implements DialogInterface.OnClickListener
{
  TroopInfoActivity$9(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppInterface localAppInterface = this.a.H;
    String str2 = this.a.f.troopUin;
    String str1;
    if (this.a.f.bOwner) {
      str1 = "0";
    } else {
      str1 = "1";
    }
    ReportController.b(localAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_clk", 0, 0, str2, str1, "1", "");
    paramDialogInterface.dismiss();
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */