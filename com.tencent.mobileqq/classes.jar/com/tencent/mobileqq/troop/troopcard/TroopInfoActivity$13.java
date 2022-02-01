package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopInfoActivity$13
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  TroopInfoActivity$13(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = 4;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.a.b, "", "");
    TroopInfoActivity localTroopInfoActivity = this.a;
    TroopInfoActivity.a(localTroopInfoActivity, true, 0L, "", localTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt);
  }
  
  public void a(String paramString)
  {
    this.a.l();
    TroopInfoActivity localTroopInfoActivity = this.a;
    TroopInfoActivity.a(localTroopInfoActivity, false, 0L, paramString, localTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.13
 * JD-Core Version:    0.7.0.1
 */