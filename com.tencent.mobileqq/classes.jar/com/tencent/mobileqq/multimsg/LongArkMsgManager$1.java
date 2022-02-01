package com.tencent.mobileqq.multimsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class LongArkMsgManager$1
  implements UpCallBack
{
  LongArkMsgManager$1(LongArkMsgManager paramLongArkMsgManager, MessageForArkApp paramMessageForArkApp, QQAppInterface paramQQAppInterface) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    try
    {
      if (paramSendResult.a == 0)
      {
        this.a.resIDForLongMsg = paramSendResult.f;
        this.b.getMessageFacade().b(this.a, null, false);
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload multi msg pack failed, result.errStr=");
        localStringBuilder.append(paramSendResult.b);
        localStringBuilder.append(",result.errStr=");
        localStringBuilder.append(paramSendResult.c);
        QLog.d("StructLongTextMsg", 2, localStringBuilder.toString());
      }
      LongTextMsgManager.a(this.b, this.a);
      return;
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramSendResult);
      }
      LongTextMsgManager.a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongArkMsgManager.1
 * JD-Core Version:    0.7.0.1
 */