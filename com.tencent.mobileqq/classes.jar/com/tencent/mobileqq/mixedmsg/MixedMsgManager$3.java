package com.tencent.mobileqq.mixedmsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.service.message.MessageCache;

class MixedMsgManager$3
  extends MessageObserver
{
  MixedMsgManager$3(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().notifyUI(6003, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq + "" });
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgData);
    if (paramBoolean)
    {
      MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, true);
      return;
    }
    MixedMsgManager localMixedMsgManager = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager;
    MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
    StringBuilder localStringBuilder = new StringBuilder().append("sendStructLongMsg fail : errCode = ");
    if (paramStatictisInfo != null) {}
    for (paramStatictisInfo = Integer.valueOf(paramStatictisInfo.b);; paramStatictisInfo = "")
    {
      MixedMsgManager.a(localMixedMsgManager, localMessageForMixedMsg, true, paramStatictisInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.3
 * JD-Core Version:    0.7.0.1
 */