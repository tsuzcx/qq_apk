package com.tencent.mobileqq.mixedmsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.service.message.MessageCache;

class MixedMsgManager$3
  extends MediaMessageObserver
{
  MixedMsgManager$3(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    Object localObject1 = "";
    localStringBuilder.append("");
    ((MessageHandler)localObject2).notifyUI(6003, true, new Object[] { localObject3, localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager;
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendStructLongMsg fail : errCode = ");
    if (paramStatictisInfo != null) {
      localObject1 = Integer.valueOf(paramStatictisInfo.b);
    }
    localStringBuilder.append(localObject1);
    MixedMsgManager.a((MixedMsgManager)localObject2, (MessageForMixedMsg)localObject3, true, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.3
 * JD-Core Version:    0.7.0.1
 */