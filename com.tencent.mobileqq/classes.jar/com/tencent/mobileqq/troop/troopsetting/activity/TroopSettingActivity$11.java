package com.tencent.mobileqq.troop.troopsetting.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopSettingActivity$11
  implements CompoundButton.OnCheckedChangeListener
{
  TroopSettingActivity$11(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (((Boolean)paramCompoundButton.getTag()).booleanValue())
    {
      paramCompoundButton.setTag(Boolean.FALSE);
    }
    else if (this.a.t != null)
    {
      int i = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopMask(TroopSettingActivity.a(this.a), this.a.i.troopUin);
      if (i != -1)
      {
        if (paramBoolean)
        {
          if (i != 1) {
            break label244;
          }
          TroopSettingActivity.b(this.a, 4);
        }
        else
        {
          if (i == 1) {
            break label244;
          }
          TroopSettingActivity.b(this.a, 1);
        }
        if (TroopSettingActivity.d(this.a) != null) {
          TroopSettingActivity.e(this.a);
        }
        AppInterface localAppInterface = TroopSettingActivity.a(this.a);
        String str;
        if (paramBoolean) {
          str = "msg_open";
        } else {
          str = "msg_close";
        }
        ReportController.b(localAppInterface, "dc00899", "Grp_msg", "", "Grp_data", str, 0, 0, this.a.i.troopUin, "", "", "");
        if (paramBoolean) {
          str = "msg_open";
        } else {
          str = "msg_close";
        }
        TroopReportor.a("Grp_msg", "grpData_admin", str, 0, 0, new String[] { this.a.i.troopUin, TroopReportor.a(this.a.i) });
      }
    }
    label244:
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */