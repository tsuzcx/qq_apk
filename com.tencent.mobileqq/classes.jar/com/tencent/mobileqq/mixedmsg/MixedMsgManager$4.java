package com.tencent.mobileqq.mixedmsg;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class MixedMsgManager$4
  implements UpCallBack
{
  MessageForLongTextMsg jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg;
  
  MixedMsgManager$4(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, MediaMessageObserver paramMediaMessageObserver) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    try
    {
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("step3: sendLongTextMsg pack upload cost: ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - MixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager));
          ((StringBuilder)localObject).append(",mResid:");
          ((StringBuilder)localObject).append(paramSendResult.c);
          QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
        }
        localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        ((StructMsgForGeneralShare)localObject).mResid = paramSendResult.c;
        ((StructMsgForGeneralShare)localObject).mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq);
        ((StructMsgForGeneralShare)localObject).multiMsgFlag = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg = ((MessageForLongTextMsg)MessageRecordFactory.a(-1051));
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.structingMsg = ((StructMsgForGeneralShare)localObject);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.frienduin;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.istroop;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.selfuin;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.senderuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.senderuin;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.isread = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.isread;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.time = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.time;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.msgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgseq;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.msgUid = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.msgUid;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.shmsgseq;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.issend = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.issend;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.uniseq;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.mAnimFlag = true;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.mNewAnimFlag = true;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.longMsgCount = 1;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.longMsgIndex = 0;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.longMsgId = ((short)(int)this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg.shmsgseq);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramSendResult.c);
        AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg);
        ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongTextMsg, this.jdField_a_of_type_ComTencentMobileqqAppMediaMessageObserver);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload multi msg pack failed, result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.b);
        ((StringBuilder)localObject).append(",result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.jdField_a_of_type_JavaLangString);
        QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager;
      localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("upload longMsg pack fail: errCode = ");
      localStringBuilder.append(paramSendResult.b);
      MixedMsgManager.a((MixedMsgManager)localObject, localMessageForMixedMsg, true, localStringBuilder.toString());
      return;
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "upload multi msg pack failed, catch exception", paramSendResult);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMixedmsgMixedMsgManager;
      MessageForMixedMsg localMessageForMixedMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForMixedMsg;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendStructLongMsg fail: exception");
      localStringBuilder.append(paramSendResult.getMessage());
      MixedMsgManager.a((MixedMsgManager)localObject, localMessageForMixedMsg, true, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.4
 * JD-Core Version:    0.7.0.1
 */