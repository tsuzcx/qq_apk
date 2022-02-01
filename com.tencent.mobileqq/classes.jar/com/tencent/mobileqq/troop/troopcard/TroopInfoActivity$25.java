package com.tencent.mobileqq.troop.troopcard;

import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;

class TroopInfoActivity$25
  extends TroopSettingObserver
{
  TroopInfoActivity$25(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(this.a.a.troopUin))) {
      this.a.b = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.25
 * JD-Core Version:    0.7.0.1
 */