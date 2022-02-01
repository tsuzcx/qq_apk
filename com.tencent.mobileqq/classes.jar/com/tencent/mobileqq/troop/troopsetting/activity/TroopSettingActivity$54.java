package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.fans.api.TroopFansObserver;

class TroopSettingActivity$54
  extends TroopFansObserver
{
  TroopSettingActivity$54(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void onGetFansTroopIdolInfo(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (paramBoolean)
    {
      if (!TextUtils.equals(paramString1, this.a.a.troopUin)) {
        return;
      }
      TroopSettingActivity.a(this.a, paramString2, paramLong.longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.54
 * JD-Core Version:    0.7.0.1
 */