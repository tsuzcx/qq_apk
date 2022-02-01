package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;

class TroopAppServiceImpl$4
  implements Runnable
{
  TroopAppServiceImpl$4(TroopAppServiceImpl paramTroopAppServiceImpl, EntityManager paramEntityManager, TroopAIOAppInfo paramTroopAIOAppInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAIOAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */