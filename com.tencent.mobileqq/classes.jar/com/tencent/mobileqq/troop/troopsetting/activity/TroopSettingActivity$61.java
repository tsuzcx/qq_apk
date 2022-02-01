package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopSettingActivity$61
  implements Runnable
{
  TroopSettingActivity$61(TroopSettingActivity paramTroopSettingActivity, ITroopMemberInfoService paramITroopMemberInfoService) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.a.getTroopMember(this.this$0.a.troopUin, TroopSettingActivity.a(this.this$0).getCurrentAccountUin());
    this.this$0.a(localTroopMemberInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.61
 * JD-Core Version:    0.7.0.1
 */