package com.tencent.mobileqq.troop.utils;

import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class AIOAnimationControlManager$9
  implements Function0<Unit>
{
  AIOAnimationControlManager$9(AIOAnimationControlManager paramAIOAnimationControlManager, AIOAnimationControlManager.IAnimationMessage paramIAnimationMessage) {}
  
  public Unit a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.a = 1;
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.b.get(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$IAnimationMessage.getFriendUin());
    if (localList != null) {
      try
      {
        localList.remove(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$IAnimationMessage);
      }
      finally {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.9
 * JD-Core Version:    0.7.0.1
 */