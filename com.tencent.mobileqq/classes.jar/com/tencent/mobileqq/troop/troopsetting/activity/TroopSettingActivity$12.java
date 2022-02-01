package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import com.tencent.mobileqq.utils.TroopReportor;

class TroopSettingActivity$12
  implements TroopPluginCallback
{
  TroopSettingActivity$12(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject = this.a;
      ((TroopSettingActivity)localObject).b = true;
      boolean bool = ((TroopSettingActivity)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim();
      localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[5];
      if (localObject != null)
      {
        if (bool) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        ((View)localObject).setVisibility(paramInt);
      }
      if (bool) {
        TroopReportor.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.12
 * JD-Core Version:    0.7.0.1
 */