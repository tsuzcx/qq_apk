package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;

class TroopManagerBizHandler$6
  extends TroopModifyObserver
{
  TroopManagerBizHandler$6(TroopManagerBizHandler paramTroopManagerBizHandler, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramLong == this.jdField_a_of_type_Long) && (paramString1.equals("SUBCMD_SET_WRITE_TOGETHER_SWITCH")))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler.notifyUI(TroopManagerBizObserver.TYPE_WRITE_TOGETHER_SWITCH, true, new Object[] { Long.valueOf(paramLong) });
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler.notifyUI(TroopManagerBizObserver.TYPE_WRITE_TOGETHER_SWITCH, false, null);
      }
      TroopManagerBizHandler.g(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.6
 * JD-Core Version:    0.7.0.1
 */