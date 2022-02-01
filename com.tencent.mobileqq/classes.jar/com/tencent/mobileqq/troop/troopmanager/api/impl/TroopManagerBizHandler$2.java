package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopManagerBizHandler$2
  extends TroopObserver
{
  TroopManagerBizHandler$2(TroopManagerBizHandler paramTroopManagerBizHandler, String paramString1, String paramString2) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.a)) && (paramString2.equals("SUBCMD_GET_PAY_TO_JOIN_TROOP_STATUS")))
    {
      if ((paramBoolean) && (paramGroupInfo != null))
      {
        if (paramGroupInfo.uint32_app_privilege_flag.has()) {
          TroopManagerBizHandler.a(this.c, paramBoolean, this.a, this.b, paramGroupInfo);
        }
      }
      else {
        this.c.notifyUI(TroopManagerBizObserver.TYPE_GET_PAY_TO_JOIN_TROOP_STATUS, paramBoolean, new Object[] { this.a, Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), this.b });
      }
      TroopManagerBizHandler.c(this.c).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.2
 * JD-Core Version:    0.7.0.1
 */