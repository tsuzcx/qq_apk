package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.association.data.AllianceItem;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopSettingActivity$2
  extends TroopAssociationObserver
{
  TroopSettingActivity$2(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.a.troopUin)) && (paramAllianceItem != null))
    {
      TroopSettingActivity.a(this.a, paramAllianceItem.associatedTroopCount);
      return;
    }
    TroopSettingActivity.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.2
 * JD-Core Version:    0.7.0.1
 */