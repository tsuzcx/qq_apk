package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$17
  implements View.OnClickListener
{
  TroopSettingActivity$17(TroopSettingActivity paramTroopSettingActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    TroopSettingActivity.e(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */