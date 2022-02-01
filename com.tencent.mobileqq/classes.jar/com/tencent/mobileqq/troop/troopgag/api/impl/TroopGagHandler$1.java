package com.tencent.mobileqq.troop.troopgag.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopGagHandler$1
  extends TroopObserver
{
  TroopGagHandler$1(TroopGagHandler paramTroopGagHandler, String paramString) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.jdField_a_of_type_JavaLangString)) && (paramString2.equals("SUBCMD_GET_TROOP_GAG")))
    {
      if ((paramBoolean) && (paramGroupInfo != null) && (paramGroupInfo.uint32_group_admin_max_num.has()))
      {
        int i = paramGroupInfo.uint32_shutup_timestamp.get();
        int j = paramGroupInfo.uint32_shutup_timestamp_me.get();
        ITroopInfoService localITroopInfoService = (ITroopInfoService)TroopGagHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler).getRuntimeService(ITroopInfoService.class, "");
        paramGroupInfo = localITroopInfoService.findTroopInfo(paramString1);
        paramString2 = paramGroupInfo;
        if (paramGroupInfo == null)
        {
          paramString2 = new TroopInfo();
          paramString2.troopuin = paramString1;
        }
        paramString2.dwGagTimeStamp = i;
        long l = j;
        paramString2.dwGagTimeStamp_me = l;
        if (QLog.isColorLevel()) {
          QLog.d("TroopGagHandler", 2, String.format("fightgag.handleGetTroopGag9780:sUin=%s, self Gag,time = %d", new Object[] { paramString1, Integer.valueOf(j) }));
        }
        if ((paramString2.dwGagTimeStamp == 0L) && (paramString2.dwGagTimeStamp_me == 0L)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler.a.remove(paramString1);
        }
        localITroopInfoService.saveTroopInfo(paramString2);
        ((ITroopMemberInfoService)TroopGagHandler.b(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler).getRuntimeService(ITroopMemberInfoService.class, "")).saveTroopMember(paramString1, TroopGagHandler.c(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler).getCurrentAccountUin(), null, -100, null, null, -100, -100, -100, -100L, l);
        paramString2 = (ITroopGagService)TroopGagHandler.d(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler).getRuntimeService(ITroopGagService.class, "");
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler.notifyUI(TroopGagObserver.a, true, new GagStatus(paramString1, paramString2.getSelfGagInfo(paramString1, true)));
      }
      TroopGagHandler.e(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgagApiImplTroopGagHandler).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagHandler.1
 * JD-Core Version:    0.7.0.1
 */