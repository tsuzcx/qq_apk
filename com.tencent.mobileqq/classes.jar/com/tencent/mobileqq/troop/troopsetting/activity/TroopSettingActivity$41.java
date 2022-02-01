package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopSettingActivity$41
  implements Runnable
{
  TroopSettingActivity$41(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void run()
  {
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).deleteTroop(TroopSettingActivity.a(this.this$0), this.this$0.a.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.41
 * JD-Core Version:    0.7.0.1
 */