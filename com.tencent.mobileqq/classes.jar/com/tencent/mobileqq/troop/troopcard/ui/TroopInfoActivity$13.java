package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcard.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;

class TroopInfoActivity$13
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  TroopInfoActivity$13(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    if (this.a.i != null) {
      this.a.i.troopTypeExt = 4;
    }
    ReportController.b(this.a.H, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.a.f.troopUin, this.a.A, "", "");
    TroopInfoActivity localTroopInfoActivity = this.a;
    TroopInfoActivity.a(localTroopInfoActivity, true, 0L, "", localTroopInfoActivity.f.dwGroupClassExt, this.a.f.dwGroupClassExt);
  }
  
  public void a(String paramString)
  {
    this.a.n();
    TroopInfoActivity localTroopInfoActivity = this.a;
    TroopInfoActivity.a(localTroopInfoActivity, false, 0L, paramString, localTroopInfoActivity.f.dwGroupClassExt, this.a.f.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.13
 * JD-Core Version:    0.7.0.1
 */