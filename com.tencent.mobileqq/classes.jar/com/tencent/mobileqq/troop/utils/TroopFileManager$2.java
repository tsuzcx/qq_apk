package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.util.Map;

class TroopFileManager$2
  extends BizTroopObserver
{
  static
  {
    if (!TroopFileManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  TroopFileManager$2(TroopFileManager paramTroopFileManager) {}
  
  public void onTroopFileStatusUpdate(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof TroopFileStatusInfo))) {
      return;
    }
    Object localObject2 = (TroopFileStatusInfo)???;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager)
    {
      if (((TroopFileStatusInfo)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_a_of_type_Long) {
        return;
      }
    }
    TroopFileInfo localTroopFileInfo1 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b.get(((TroopFileStatusInfo)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localTroopFileInfo1 == null)) {
      throw new AssertionError();
    }
    if (localTroopFileInfo1 == null) {
      return;
    }
    int i = localTroopFileInfo1.e;
    if ((localTroopFileInfo1.b == null) && (((TroopFileStatusInfo)localObject2).e != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(((TroopFileStatusInfo)localObject2).e, localTroopFileInfo1);
    }
    localTroopFileInfo1.a((TroopFileStatusInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(localTroopFileInfo1.g);
      if (localObject2 != null) {
        ((TroopFileInfo)localObject2).a(localTroopFileInfo1);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d(localTroopFileInfo1);
      return;
    }
    if (localTroopFileInfo1.jdField_a_of_type_Boolean) {
      if (((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localTroopFileInfo1.jdField_a_of_type_Boolean = bool;; localTroopFileInfo1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localTroopFileInfo1.g))
          {
            TroopFileInfo localTroopFileInfo2 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(localTroopFileInfo1.g);
            if ((localTroopFileInfo2 != null) && ((localTroopFileInfo1.e == 9) || (localTroopFileInfo1.e == 10) || (localTroopFileInfo1.e == 11))) {
              localTroopFileInfo2.a(localTroopFileInfo1);
            }
          }
          if ((((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localTroopFileInfo1.a((int)NetConnInfoCenter.getServerTime());
            localTroopFileInfo1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.e(localTroopFileInfo1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d(localTroopFileInfo1);
          return;
        } while ((((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int != 11) || (localTroopFileInfo1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.2
 * JD-Core Version:    0.7.0.1
 */