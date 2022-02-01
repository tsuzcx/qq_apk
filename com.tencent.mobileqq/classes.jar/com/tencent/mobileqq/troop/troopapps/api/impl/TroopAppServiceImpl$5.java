package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.ArrayList;
import java.util.Iterator;

class TroopAppServiceImpl$5
  implements Runnable
{
  TroopAppServiceImpl$5(TroopAppServiceImpl paramTroopAppServiceImpl, ArrayList paramArrayList, EntityManager paramEntityManager) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      TroopAppServiceImpl.access$100(this.this$0, this.b, localTroopAIOAppInfo);
    }
    this.b.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */