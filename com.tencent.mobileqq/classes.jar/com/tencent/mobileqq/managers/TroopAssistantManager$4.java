package com.tencent.mobileqq.managers;

import auam;
import awgf;
import com.tencent.mobileqq.data.TroopAssistantData;

public class TroopAssistantManager$4
  implements Runnable
{
  public TroopAssistantManager$4(auam paramauam, TroopAssistantData paramTroopAssistantData, awgf paramawgf) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.getStatus() == 1000)
    {
      this.jdField_a_of_type_Awgf.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData);
      return;
    }
    this.jdField_a_of_type_Awgf.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.4
 * JD-Core Version:    0.7.0.1
 */