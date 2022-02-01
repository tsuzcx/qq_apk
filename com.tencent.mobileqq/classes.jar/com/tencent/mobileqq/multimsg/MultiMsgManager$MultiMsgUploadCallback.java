package com.tencent.mobileqq.multimsg;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.im.msg.im_msg_body.RichText;

class MultiMsgManager$MultiMsgUploadCallback
  implements UpCallBack
{
  int jdField_a_of_type_Int;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public MultiMsgManager$MultiMsgUploadCallback(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject;
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      localObject = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((MessageForStructing)localObject).structingMsg.mResid = paramSendResult.c;
      ((MessageForStructing)localObject).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject).uniseq);
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, ((MessageForStructing)localObject).uniseq, ((MessageForStructing)localObject).structingMsg.getBytes());
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null);
      if (QLog.isColorLevel())
      {
        paramSendResult = new StringBuilder();
        paramSendResult.append("send real struct msg done, cost : ");
        paramSendResult.append(System.currentTimeMillis() - MultiMsgManager.b());
        QLog.d("MultiMsg_TAG", 2, paramSendResult.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload multi msg pack failed, result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.b);
        ((StringBuilder)localObject).append(",result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.jdField_a_of_type_JavaLangString);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      paramSendResult = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade().getLastMessage(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if ((paramSendResult != null) && (paramSendResult.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
        paramSendResult.extraflag = 32768;
      }
      paramSendResult = this.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_Int;
      long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
      ((MessageHandler)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(this.jdField_a_of_type_Int), false, new Object[] { paramSendResult, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.MultiMsgUploadCallback
 * JD-Core Version:    0.7.0.1
 */