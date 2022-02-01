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
    if ((paramLong == this.jdField_a_of_type_Long) && (paramString1.equals("SUBCMD_SET_GAG_TROOP")))
    {
      if (!paramBoolean) {
        TroopGagProcessorConfig.a().a(TroopGagHandler.f(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler), this.b);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler.a(new GagStatus(String.valueOf(this.jdField_a_of_type_Long), new GagTroopResult(paramBoolean, this.b)));
      TroopGagHandler.g(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler.2
 * JD-Core Version:    0.7.0.1
 */