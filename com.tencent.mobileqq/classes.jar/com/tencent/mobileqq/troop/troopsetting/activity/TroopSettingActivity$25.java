package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Dialog;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQProgressDialog;

class TroopSettingActivity$25
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  TroopSettingActivity$25(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    paramDialog = new TroopSettingActivity.ClearChatRecordTask(this.a);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    ThreadManager.post(paramDialog, 5, null, false);
    TroopReportor.a("Grp_set_new", "grpData_admin", "confirm_delRecord", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.25
 * JD-Core Version:    0.7.0.1
 */