package com.tencent.mobileqq.troop.troopgag.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.config.TroopGagProcessorConfig;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.mobileqq.troop.troopgag.data.GagTroopResult;

class TroopGagHandler$2
  extends TroopModifyObserver
{
  TroopGagHandler$2(TroopGagHandler paramTroopGagHandler, long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramLong == this.a) && (paramString1.equals("SUBCMD_SET_GAG_TROOP")))
    {
      if (!paramBoolean) {
        TroopGagProcessorConfig.a().a(TroopGagHandler.f(this.i), this.h);
      }
      this.i.a(new GagStatus(String.valueOf(this.a), new GagTroopResult(paramBoolean, this.h)));
      TroopGagHandler.g(this.i).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler.2
 * JD-Core Version:    0.7.0.1
 */