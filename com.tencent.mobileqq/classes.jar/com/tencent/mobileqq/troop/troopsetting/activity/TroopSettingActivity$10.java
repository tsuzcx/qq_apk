package com.tencent.mobileqq.troop.troopsetting.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$10
  implements View.OnClickListener
{
  TroopSettingActivity$10(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onClick(View paramView)
  {
    TroopSettingActivity.a(this.a);
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_quitgrp", 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.10
 * JD-Core Version:    0.7.0.1
 */