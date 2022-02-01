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
      Object localObject;
      if (paramSendResult.a == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("step3: sendLongTextMsg pack upload cost: ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - LongTextMsgManager.a(this.d));
          ((StringBuilder)localObject).append(",mResid:");
          ((StringBuilder)localObject).append(paramSendResult.f);
          QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
        }
        localObject = ChatActivityFacade.a(this.a.getApp().getApplicationContext(), this.b, this.a.getCurrentNickname());
        ((StructMsgForGeneralShare)localObject).mResid = paramSendResult.f;
        ((StructMsgForGeneralShare)localObject).mFileName = String.valueOf(this.b.uniseq);
        ((StructMsgForGeneralShare)localObject).multiMsgFlag = 1;
        MessageForLongTextMsg localMessageForLongTextMsg = (MessageForLongTextMsg)this.b;
        localMessageForLongTextMsg.structingMsg = ((StructMsgForGeneralShare)localObject);
        localMessageForLongTextMsg.saveExtInfoToExtStr("long_text_msg_resid", paramSendResult.f);
        this.a.getMessageFacade().b(this.b, null, this.c);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload multi msg pack failed, result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.b);
        ((StringBuilder)localObject).append(",result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.c);
        QLog.d("StructLongTextMsg", 2, ((StringBuilder)localObject).toString());
      }
      LongTextMsgManager.a(this.a, this.b);
      return;
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "upload multi msg pack failed, catch exception", paramSendResult);
      }
      LongTextMsgManager.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongTextMsgManager.2
 * JD-Core Version:    0.7.0.1
 */