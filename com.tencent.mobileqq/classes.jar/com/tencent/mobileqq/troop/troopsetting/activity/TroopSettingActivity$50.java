package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopSettingActivity$50
  implements Runnable
{
  TroopSettingActivity$50(TroopSettingActivity paramTroopSettingActivity, ITroopMemberInfoService paramITroopMemberInfoService) {}
  
  public void run()
  {
    TroopMemberInfo localTroopMemberInfo = this.a.getTroopMember(this.this$0.i.troopUin, TroopSettingActivity.a(this.this$0).getCurrentAccountUin());
    if (localTroopMemberInfo != null)
    {
      this.this$0.i.troopColorNick = localTroopMemberInfo.troopColorNick;
      this.this$0.i.troopColorNickId = localTroopMemberInfo.troopColorNickId;
      this.this$0.i.troopCard = localTroopMemberInfo.troopnick;
      this.this$0.runOnUiThread(new TroopSettingActivity.50.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.50
 * JD-Core Version:    0.7.0.1
 */