package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;

class TroopManagerBizHandler$5
  extends TroopModifyObserver
{
  TroopManagerBizHandler$5(TroopManagerBizHandler paramTroopManagerBizHandler, long paramLong) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramLong == this.a) && (paramString1.equals("SUBCMD_SET_CONFESS_TALK_SWITCH")))
    {
      if (paramBoolean) {
        this.h.notifyUI(TroopManagerBizObserver.TYPE_CONFESS_TALK_SWITCH, true, new Object[] { Long.valueOf(paramLong) });
      } else {
        this.h.notifyUI(TroopManagerBizObserver.TYPE_CONFESS_TALK_SWITCH, false, null);
      }
      TroopManagerBizHandler.f(this.h).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmanager.api.impl.TroopManagerBizHandler.5
 * JD-Core Version:    0.7.0.1
 */