package com.tencent.mobileqq.troop.essencemsg;

import bflc;
import bfli;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class TroopEssenceMsgManager$9$1
  implements Runnable
{
  TroopEssenceMsgManager$9$1(TroopEssenceMsgManager.9 param9, HashMap paramHashMap) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.this$0.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.a), this.jdField_a_of_type_JavaUtilHashMap);
    Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.this$0.b.get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.a));
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bfli)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.a, this.jdField_a_of_type_JavaUtilHashMap);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.this$0.b.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopEssencemsgTroopEssenceMsgManager$9.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.9.1
 * JD-Core Version:    0.7.0.1
 */