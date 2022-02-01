package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GroupAppsServlet;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;

class TroopAioAppServiceImpl$2
  implements Runnable
{
  TroopAioAppServiceImpl$2(TroopAioAppServiceImpl paramTroopAioAppServiceImpl, long paramLong) {}
  
  public void run()
  {
    TroopAioAppServiceImpl.access$000(this.this$0).a();
    if (!GroupUtil.a(this.this$0.getAppsFromCache(this.a))) {
      GroupAppsServlet.a(TroopAioAppServiceImpl.access$300(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAioAppServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */