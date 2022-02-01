package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopManagerBizHandler$3
  extends TroopObserver
{
  TroopManagerBizHandler$3(TroopManagerBizHandler paramTroopManagerBizHandler, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(String.valueOf(this.a))) && (paramString2.equals("SUBCMD_GET_PAY_TO_JOIN_TROOP_STATUS")))
    {
      paramString2 = null;
      paramString1 = paramString2;
      if (paramBoolean)
      {
        paramString1 = paramString2;
        if (paramGroupInfo != null) {
          paramString1 = TroopManagerBizHandler.a(this.e, this.a, paramGroupInfo);
        }
      }
      this.e.notifyUI(TroopManagerBizObserver.TYPE_GET_TROOP_INFO_FOR_SET_JOIN_TYPE, paramBoolean, new Object[] { Long.valueOf(this.a), Integer.valueOf(this.b), paramString1, Integer.valueOf(this.c), this.d });
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder(150);
        paramString1.append("handle_oidb_0x88d_0");
        paramString1.append("|isSuccess = ");
        paramString1.append(paramBoolean);
        paramString1.append("|troopuin = ");
        paramString1.append(this.a);
        paramString1.append("|flag = ");
        paramString1.append(this.b);
        QLog.i("TroopManagerBizHandler", 2, paramString1.toString());
        TroopManagerBizHandler.d(this.e).removeObserver(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.3
 * JD-Core Version:    0.7.0.1
 */