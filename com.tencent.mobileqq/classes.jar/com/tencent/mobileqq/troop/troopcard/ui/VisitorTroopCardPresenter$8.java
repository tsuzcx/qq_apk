package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;

class VisitorTroopCardPresenter$8
  extends TroopSettingObserver
{
  VisitorTroopCardPresenter$8(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  protected void b(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (VisitorTroopCardPresenter.d(this.a) != null) && (paramString.equals(VisitorTroopCardPresenter.d(this.a).troopUin))) {
      this.a.a = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.8
 * JD-Core Version:    0.7.0.1
 */