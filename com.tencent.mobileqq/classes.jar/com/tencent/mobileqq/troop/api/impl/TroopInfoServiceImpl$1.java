package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.os.MqqHandler;

class TroopInfoServiceImpl$1
  implements Runnable
{
  TroopInfoServiceImpl$1(TroopInfoServiceImpl paramTroopInfoServiceImpl, String paramString) {}
  
  public void run()
  {
    TroopInfo localTroopInfo = (TroopInfo)this.this$0.em.find(TroopInfo.class, this.a);
    ThreadManager.getUIHandler().post(new TroopInfoServiceImpl.1.1(this, localTroopInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */