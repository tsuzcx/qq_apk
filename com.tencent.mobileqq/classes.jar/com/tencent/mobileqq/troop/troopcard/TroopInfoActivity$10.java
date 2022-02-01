package com.tencent.mobileqq.troop.troopcard;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopInfoActivity$10
  implements DialogInterface.OnClickListener
{
  TroopInfoActivity$10(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppInterface localAppInterface = this.a.jdField_a_of_type_ComTencentCommonAppAppInterface;
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    String str1;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      str1 = "0";
    } else {
      str1 = "1";
    }
    ReportController.b(localAppInterface, "P_CliOper", "Grp_manage", "", "manage_grp", "sub_clk", 0, 0, str2, str1, "0", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */