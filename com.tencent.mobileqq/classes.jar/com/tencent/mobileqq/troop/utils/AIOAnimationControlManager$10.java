package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
    ((MessageForDeliverGiftTips)localObject1).hasFetchButFailed = true;
    ((MessageForDeliverGiftTips)localObject1).showButton = true;
    Object localObject2;
    String str;
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
      localObject2 = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface;
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);
      ((MessageForDeliverGiftTips)localObject1).senderName = ContactUtils.b((AppInterface)localObject2, str, localStringBuilder.toString());
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof VideoAppInterface))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
      localObject2 = (VideoAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface;
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);
      localStringBuilder.append("");
      ((MessageForDeliverGiftTips)localObject1).senderName = ((VideoAppInterface)localObject2).a(1, str, localStringBuilder.toString());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("playGiftBigAnimation getGrabBagInfo onError. errorCode:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" errorMsg:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i(".troop.send_gift", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.10.2(this));
  }
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo)
  {
    if (paramTroopGiftBagInfo.myGrabResult == null)
    {
      paramTroopGiftBagInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
      paramTroopGiftBagInfo.hasFetchButFailed = true;
      paramTroopGiftBagInfo.showButton = true;
      Object localObject;
      String str;
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
      {
        paramTroopGiftBagInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
        localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface;
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);
        paramTroopGiftBagInfo.senderName = ContactUtils.b((AppInterface)localObject, str, localStringBuilder.toString());
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof VideoAppInterface))
      {
        paramTroopGiftBagInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
        localObject = (VideoAppInterface)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_ComTencentCommonAppAppInterface;
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderUin);
        localStringBuilder.append("");
        paramTroopGiftBagInfo.senderName = ((VideoAppInterface)localObject).a(1, str, localStringBuilder.toString());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.senderName = null;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsAIOAnimationControlManager.jdField_a_of_type_AndroidOsHandler.post(new AIOAnimationControlManager.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.10
 * JD-Core Version:    0.7.0.1
 */