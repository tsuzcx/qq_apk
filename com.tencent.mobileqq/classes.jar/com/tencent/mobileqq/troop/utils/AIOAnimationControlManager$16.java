package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class AIOAnimationControlManager$16
  implements FrameSprite.OnFrameEndListener
{
  AIOAnimationControlManager$16(AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public void a()
  {
    Object localObject1 = this.a;
    ((AIOAnimationControlManager)localObject1).jdField_a_of_type_Int = 1;
    if ((((AIOAnimationControlManager)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (this.a.jdField_a_of_type_AndroidAppActivity == null) && (!AIOAnimationControlManager.jdField_a_of_type_JavaLangString.equals(this.a.jdField_b_of_type_JavaLangString))) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString;
    } else {
      localObject1 = this.a.jdField_b_of_type_JavaLangString;
    }
    List localList = (List)this.a.jdField_b_of_type_JavaUtilHashMap.get(localObject1);
    if ((!TroopGiftUtil.a(localList)) && (localList != null))
    {
      if (localList != null) {}
      try
      {
        Object localObject3 = (AIOAnimationControlManager.IAnimationMessage)localList.remove(0);
        if ((localObject3 instanceof MessageForDeliverGiftTips))
        {
          Object localObject4 = (MessageForDeliverGiftTips)localObject3;
          localObject3 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject4);
          ((MessageForDeliverGiftTips)localObject4).hasFetchButFailed = false;
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("onMagicPlayEnd id:");
            ((StringBuilder)localObject4).append((String)localObject3);
            QLog.d("AIOAnimationControlManager", 2, ((StringBuilder)localObject4).toString());
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$OnAnimationPlayEndListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$OnAnimationPlayEndListener.a((String)localObject1, (String)localObject3);
          }
        }
        if (localList.size() != 0)
        {
          Collections.sort(localList, this.a.jdField_a_of_type_JavaUtilComparator);
          this.a.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.16.1(this));
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(null);
          AIOAnimationControlManager.a(this.a, false);
          localObject1 = ChatActivityUtils.a((String)localObject1, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
          if ((AIOAnimationControlManager.jdField_a_of_type_Boolean) && (localObject1 != null) && (-1 == ((Integer)localObject1).intValue()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)) {
            AIOAnimationControlManager.jdField_a_of_type_Boolean = false;
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.16
 * JD-Core Version:    0.7.0.1
 */