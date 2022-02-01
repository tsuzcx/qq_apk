package com.tencent.mobileqq.troop.troopmanager.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopManagerBizHandler$8
  extends TroopObserver
{
  TroopManagerBizHandler$8(TroopManagerBizHandler paramTroopManagerBizHandler, String paramString, Bundle paramBundle) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.jdField_a_of_type_JavaLangString)) && (paramString2.equals("SUBCMD_GET_TROOP_SEQ_AND_JOIN_TIME")))
    {
      TroopManagerBizHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler, paramString1, paramGroupInfo, this.jdField_a_of_type_AndroidOsBundle);
      TroopManagerBizHandler.i(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.8
 * JD-Core Version:    0.7.0.1
 */