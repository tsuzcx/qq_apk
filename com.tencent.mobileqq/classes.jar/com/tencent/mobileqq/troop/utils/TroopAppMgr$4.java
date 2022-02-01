package com.tencent.mobileqq.troop.utils;

import bfql;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;

public class TroopAppMgr$4
  implements Runnable
{
  public TroopAppMgr$4(bfql parambfql, EntityManager paramEntityManager, TroopAIOAppInfo paramTroopAIOAppInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAIOAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.4
 * JD-Core Version:    0.7.0.1
 */