package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopManagerBizHandler$1
  extends TroopObserver
{
  TroopManagerBizHandler$1(TroopManagerBizHandler paramTroopManagerBizHandler, String paramString) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.a)) && (paramString2.equals("SUBCMD_GET_MAX_TROOP_ADMIN_NUM")))
    {
      if ((paramBoolean) && (paramGroupInfo != null))
      {
        if (paramGroupInfo.uint32_group_admin_max_num.has())
        {
          ITroopInfoService localITroopInfoService = (ITroopInfoService)TroopManagerBizHandler.a(this.b).getRuntimeService(ITroopInfoService.class, "");
          TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString1);
          paramString2 = localTroopInfo;
          if (localTroopInfo == null)
          {
            paramString2 = new TroopInfo();
            paramString2.troopuin = paramString1;
          }
          paramString2.maxAdminNum = paramGroupInfo.uint32_group_admin_max_num.get();
          localITroopInfoService.saveTroopInfo(paramString2);
          this.b.notifyUI(TroopManagerBizObserver.TYPE_GET_MAX_TROOP_ADMIN_NUM, true, new Object[] { paramString1, Integer.valueOf(paramGroupInfo.uint32_group_admin_max_num.get()) });
        }
      }
      else {
        this.b.notifyUI(TroopManagerBizObserver.TYPE_GET_MAX_TROOP_ADMIN_NUM, false, null);
      }
      TroopManagerBizHandler.b(this.b).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.1
 * JD-Core Version:    0.7.0.1
 */