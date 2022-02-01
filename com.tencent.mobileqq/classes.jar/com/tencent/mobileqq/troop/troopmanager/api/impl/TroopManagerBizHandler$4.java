package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;

class TroopManagerBizHandler$4
  extends TroopModifyObserver
{
  TroopManagerBizHandler$4(TroopManagerBizHandler paramTroopManagerBizHandler, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramLong == this.a) && (paramString1.equals("SUBCMD_MODIFY_TROOP_NICK_RULE")))
    {
      this.h.notifyUI(TroopManagerBizObserver.TYPE_NOTIFY_MODIFY_TROOP_NICK_RULE, paramBoolean, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString2 });
      TroopManagerBizHandler.e(this.h).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.4
 * JD-Core Version:    0.7.0.1
 */