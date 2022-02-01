package com.tencent.mobileqq.managers;

import awtz;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.persistence.EntityManager;

public class TroopAssistantManager$4
  implements Runnable
{
  public TroopAssistantManager$4(awtz paramawtz, TroopAssistantData paramTroopAssistantData, EntityManager paramEntityManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.4
 * JD-Core Version:    0.7.0.1
 */