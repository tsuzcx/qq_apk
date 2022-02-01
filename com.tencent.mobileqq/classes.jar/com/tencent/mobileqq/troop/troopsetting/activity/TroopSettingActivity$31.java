package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;

class TroopSettingActivity$31
  extends TroopSettingObserver
{
  TroopSettingActivity$31(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramString1 != null) && (this.a.i.troopUin != null))
    {
      if (!paramString1.equals(this.a.i.troopUin)) {
        return;
      }
      if (paramInt2 == 512)
      {
        if (paramBoolean)
        {
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).updateHiddenChat(TroopSettingActivity.a(this.a), this.a.t);
          return;
        }
        TroopSettingActivity.s(this.a);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString.equals(this.a.i.troopUin))) {
      this.a.ad = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.31
 * JD-Core Version:    0.7.0.1
 */