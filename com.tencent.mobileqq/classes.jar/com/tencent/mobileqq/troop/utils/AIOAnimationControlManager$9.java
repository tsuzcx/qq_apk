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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager;
    ((AIOAnimationControlManager)localObject1).a = 1;
    localObject1 = (List)((AIOAnimationControlManager)localObject1).b.get(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$IAnimationMessage.getFriendUin());
    if (localObject1 != null) {
      try
      {
        ((List)localObject1).remove(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$IAnimationMessage);
      }
      finally {}
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.9
 * JD-Core Version:    0.7.0.1
 */