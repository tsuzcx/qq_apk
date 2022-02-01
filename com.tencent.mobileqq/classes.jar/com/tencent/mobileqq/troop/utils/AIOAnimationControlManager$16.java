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
    this.a.jdField_a_of_type_Int = 1;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) && (this.a.jdField_a_of_type_AndroidAppActivity == null) && (!AIOAnimationControlManager.jdField_a_of_type_JavaLangString.equals(this.a.jdField_b_of_type_JavaLangString))) {}
    String str1;
    List localList;
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        break;
      }
      str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.jdField_a_of_type_JavaLangString;
      localList = (List)this.a.jdField_b_of_type_JavaUtilHashMap.get(str1);
    } while ((TroopGiftUtil.a(localList)) || (localList == null));
    if (localList != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = (AIOAnimationControlManager.IAnimationMessage)localList.remove(0);
        if ((localObject3 instanceof MessageForDeliverGiftTips))
        {
          localObject3 = (MessageForDeliverGiftTips)localObject3;
          String str2 = TroopGiftUtil.b((MessageForDeliverGiftTips)localObject3);
          ((MessageForDeliverGiftTips)localObject3).hasFetchButFailed = false;
          if (QLog.isColorLevel()) {
            QLog.d("AIOAnimationControlManager", 2, "onMagicPlayEnd id:" + str2);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$OnAnimationPlayEndListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager$OnAnimationPlayEndListener.a(str1, str2);
          }
        }
        if (localList.size() == 0) {
          break label250;
        }
        Collections.sort(localList, this.a.jdField_a_of_type_JavaUtilComparator);
        this.a.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.16.1(this));
        return;
      }
      finally {}
      Object localObject2 = this.a.jdField_b_of_type_JavaLangString;
      break;
      label250:
      this.a.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(null);
      AIOAnimationControlManager.a(this.a, false);
      localObject2 = ChatActivityUtils.a((String)localObject2, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      if ((AIOAnimationControlManager.jdField_a_of_type_Boolean) && (localObject2 != null) && (-1 == ((Integer)localObject2).intValue()) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)) {
        AIOAnimationControlManager.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.16
 * JD-Core Version:    0.7.0.1
 */