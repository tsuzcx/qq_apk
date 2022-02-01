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
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.a.getWindow() != null)) {
      this.a.dismiss();
    }
    TroopSettingActivity.h(this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */