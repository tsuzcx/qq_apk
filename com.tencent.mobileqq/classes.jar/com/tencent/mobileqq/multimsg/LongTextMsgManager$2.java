package com.tencent.mobileqq.multimsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class LongTextMsgManager$2
  implements UpCallBack
{
  LongTextMsgManager$2(LongTextMsgManager paramLongTextMsgManager, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean) {}
  
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
        if (QLog.isColorLevel()) {
          QLog.d("StructLongTextMsg", 2, "step3: sendLongTextMsg pack upload cost: " + (System.currentTimeMillis() - LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgLongTextMsgManager)) + ",mResid:" + paramSendResult.c);
        }
        StructMsgForGeneralShare localStructMsgForGeneralShare = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
        localStructMsgForGeneralShare.mResid = paramSendResult.c;
        localStructMsgForGeneralShare.mFileName = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
        localStructMsgForGeneralShare.multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localMessageForLongTextMsg.structingMsg = localStructMsgForGeneralShare;
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramSendResult.c);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, this.jdField_a_of_type_Boolean);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, result.errStr=" + paramSendResult.b + ",result.errStr=" + paramSendResult.jdField_a_of_type_JavaLangString);
      }
      LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramSendResult);
      }
      LongTextMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager.2
 * JD-Core Version:    0.7.0.1
 */