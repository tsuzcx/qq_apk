package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;

class TroopRemindSettingManager$1
  implements Runnable
{
  TroopRemindSettingManager$1(TroopRemindSettingManager paramTroopRemindSettingManager, AppInterface paramAppInterface, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.getEntityManagerFactory().createEntityManager();
    if ((TroopRemindSettingData)localEntityManager.find(TroopRemindSettingData.class, this.b) == null)
    {
      TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
      localTroopRemindSettingData.troopUin = this.b;
      localTroopRemindSettingData.isOpenState = 0;
      localEntityManager.persistOrReplace(localTroopRemindSettingData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRemindSettingManager.1
 * JD-Core Version:    0.7.0.1
 */