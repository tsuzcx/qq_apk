package com.tencent.mobileqq.multimsg;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class LongTextMsgManager$1
  implements UpCallBack
{
  LongTextMsgManager$1(LongTextMsgManager paramLongTextMsgManager, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    try
    {
      Object localObject;
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("step3: sendLongTextMsg pack upload cost: ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgLongTextMsgManager));
          ((StringBuilder)localObject).append(",mResid:");
          ((StringBuilder)localObject).append(paramSendResult.c);
          QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
        }
        localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        ((StructMsgForGeneralShare)localObject).mResid = paramSendResult.c;
        ((StructMsgForGeneralShare)localObject).mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        ((StructMsgForGeneralShare)localObject).multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)MessageRecordFactory.a(-1051);
        localMessageForLongTextMsg.structingMsg = ((StructMsgForGeneralShare)localObject);
        localMessageForLongTextMsg.frienduin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
        localMessageForLongTextMsg.istroop = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
        localMessageForLongTextMsg.selfuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin;
        localMessageForLongTextMsg.senderuin = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
        localMessageForLongTextMsg.isread = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread;
        localMessageForLongTextMsg.time = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        localMessageForLongTextMsg.msgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq;
        localMessageForLongTextMsg.msgUid = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgUid;
        localMessageForLongTextMsg.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
        localMessageForLongTextMsg.issend = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.issend;
        localMessageForLongTextMsg.uniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
        localMessageForLongTextMsg.mAnimFlag = true;
        localMessageForLongTextMsg.mNewAnimFlag = true;
        localMessageForLongTextMsg.longMsgCount = 1;
        localMessageForLongTextMsg.longMsgIndex = 0;
        localMessageForLongTextMsg.longMsgId = ((short)(int)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq);
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramSendResult.c);
        if (AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
          AnonymousChatHelper.a().a(localMessageForLongTextMsg);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageForLongTextMsg, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MessageForReplyText upload multi msg pack failed, result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.b);
        ((StringBuilder)localObject).append(",result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.jdField_a_of_type_JavaLangString);
        QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
      }
      LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "MessageForReplyText upload multi msg pack failed, catch exception", paramSendResult);
      }
      LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager.1
 * JD-Core Version:    0.7.0.1
 */