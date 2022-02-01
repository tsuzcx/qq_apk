package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.EntityManager;

class TroopAssistantManager$4
  implements Runnable
{
  TroopAssistantManager$4(TroopAssistantManager paramTroopAssistantManager, TroopAssistantData paramTroopAssistantData, EntityManager paramEntityManager) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persist(this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.4
 * JD-Core Version:    0.7.0.1
 */