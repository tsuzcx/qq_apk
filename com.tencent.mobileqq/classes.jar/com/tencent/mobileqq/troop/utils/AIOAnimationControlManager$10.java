package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class AIOAnimationControlManager$10
  extends TroopGiftCallback
{
  AIOAnimationControlManager$10(AIOAnimationControlManager paramAIOAnimationControlManager, MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "playGiftBigAnimation getGrabBagInfo onError. errorCode:" + paramInt + " errorMsg:" + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.10.2(this));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof VideoAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ((VideoAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface).a(1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin + "");
      } else {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = null;
      }
    }
  }
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo)
  {
    if (paramTroopGiftBagInfo.myGrabResult == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton = true;
      if (!(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label105;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ContactUtils.g((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.10.1(this));
      return;
      label105:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof VideoAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = ((VideoAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface).a(1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin + "");
      } else {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.10
 * JD-Core Version:    0.7.0.1
 */