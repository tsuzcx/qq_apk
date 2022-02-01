package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class TroopAvatarWallEditActivity$3
  implements AdapterView.OnItemSelectedListener
{
  TroopAvatarWallEditActivity$3(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    paramAdapterView = this.a;
    paramAdapterView.j = paramInt;
    if (paramAdapterView.u != null) {
      this.a.u.b(paramInt);
    }
    if (!this.a.p) {
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.k, "0", "", "");
    } else {
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.k, "1", "", "");
    }
    if (TroopAvatarWallEditActivity.b(this.a) != null) {
      TroopAvatarWallEditActivity.b(this.a).a(paramInt);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.3
 * JD-Core Version:    0.7.0.1
 */