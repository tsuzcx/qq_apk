package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$18
  implements View.OnClickListener
{
  TroopSettingActivity$18(TroopSettingActivity paramTroopSettingActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.18
 * JD-Core Version:    0.7.0.1
 */