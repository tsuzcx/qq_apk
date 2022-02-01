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
  WeakReference<QQAppInterface> a;
  MessageRecord b;
  String c;
  int d;
  
  public MultiMsgManager$MultiMsgUploadCallback(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = paramMessageRecord;
    this.c = paramString;
    this.d = paramInt;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject;
    if (paramSendResult.a == 0)
    {
      localObject = (MessageForStructing)this.b;
      ((MessageForStructing)localObject).structingMsg.mResid = paramSendResult.f;
      ((MessageForStructing)localObject).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject).uniseq);
      ((QQAppInterface)this.a.get()).getMessageFacade().a(this.c, this.d, ((MessageForStructing)localObject).uniseq, ((MessageForStructing)localObject).structingMsg.getBytes());
      ((QQAppInterface)this.a.get()).getMessageFacade().b(this.b, null);
      if (QLog.isColorLevel())
      {
        paramSendResult = new StringBuilder();
        paramSendResult.append("send real struct msg done, cost : ");
        paramSendResult.append(System.currentTimeMillis() - MultiMsgManager.k());
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
        ((StringBuilder)localObject).append(paramSendResult.c);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
      }
      this.b.extraflag = 32768;
      ((QQAppInterface)this.a.get()).getMsgCache().b(this.c, this.d, this.b.uniseq);
      paramSendResult = ((QQAppInterface)this.a.get()).getMessageFacade().getLastMessage(this.c, this.d);
      if ((paramSendResult != null) && (paramSendResult.uniseq == this.b.uniseq)) {
        paramSendResult.extraflag = 32768;
      }
      paramSendResult = this.c;
      int i = this.d;
      long l = this.b.uniseq;
      ((MessageHandler)((QQAppInterface)this.a.get()).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.b(this.d), false, new Object[] { paramSendResult, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.MultiMsgUploadCallback
 * JD-Core Version:    0.7.0.1
 */