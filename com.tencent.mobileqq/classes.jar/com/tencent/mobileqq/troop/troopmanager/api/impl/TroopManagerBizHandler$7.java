package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopManagerBizHandler$7
  extends TroopObserver
{
  TroopManagerBizHandler$7(TroopManagerBizHandler paramTroopManagerBizHandler, Long paramLong) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(Long.toString(this.jdField_a_of_type_JavaLangLong.longValue()))) && (paramString2.equals("SUBCMD_GET_INVITE_NO_AUTH_LIMIT_NUM")))
    {
      if ((paramBoolean) && (paramGroupInfo != null) && (paramGroupInfo.uint64_invite_no_auth_num_limit.has()))
      {
        long l = paramGroupInfo.uint64_invite_no_auth_num_limit.get();
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler.notifyUI(TroopManagerBizObserver.TYPE_GET_INVITE_NO_AUTH_LIMIT_NUM, true, new Object[] { this.jdField_a_of_type_JavaLangLong, Long.valueOf(l) });
      }
      TroopManagerBizHandler.h(this.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiImplTroopManagerBizHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.7
 * JD-Core Version:    0.7.0.1
 */