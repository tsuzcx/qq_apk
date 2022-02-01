package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper;
import com.tencent.qphone.base.util.QLog;

class TroopAioAppServiceImpl$1
  implements Runnable
{
  TroopAioAppServiceImpl$1(TroopAioAppServiceImpl paramTroopAioAppServiceImpl) {}
  
  public void run()
  {
    TroopAioAppServiceImpl.access$000(this.this$0).b();
    TroopAioAppServiceImpl.access$100(this.this$0).a();
    if (QLog.isColorLevel()) {
      QLog.i("TroopAioAppServiceImpl", 2, "login fullList from db ");
    }
    TroopAioAppServiceImpl.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAioAppServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */