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

class MixedMsgManager$3
  implements UpCallBack
{
  MessageForLongTextMsg a;
  
  MixedMsgManager$3(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, MediaMessageObserver paramMediaMessageObserver) {}
  
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
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("step3: sendLongTextMsg pack upload cost: ");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - MixedMsgManager.a(this.e));
          ((StringBuilder)localObject).append(",mResid:");
          ((StringBuilder)localObject).append(paramSendResult.f);
          QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
        }
        localObject = ChatActivityFacade.a(this.b.getApp().getApplicationContext(), this.c, this.b.getCurrentNickname());
        ((StructMsgForGeneralShare)localObject).mResid = paramSendResult.f;
        ((StructMsgForGeneralShare)localObject).mFileName = String.valueOf(this.c.uniseq);
        ((StructMsgForGeneralShare)localObject).multiMsgFlag = 1;
        this.a = ((MessageForLongTextMsg)MessageRecordFactory.a(-1051));
        this.a.structingMsg = ((StructMsgForGeneralShare)localObject);
        this.a.frienduin = this.c.frienduin;
        this.a.istroop = this.c.istroop;
        this.a.selfuin = this.c.selfuin;
        this.a.senderuin = this.c.senderuin;
        this.a.isread = this.c.isread;
        this.a.time = this.c.time;
        this.a.msgseq = this.c.msgseq;
        this.a.msgUid = this.c.msgUid;
        this.a.shmsgseq = this.c.shmsgseq;
        this.a.issend = this.c.issend;
        this.a.uniseq = this.c.uniseq;
        this.a.mAnimFlag = true;
        this.a.mNewAnimFlag = true;
        this.a.longMsgCount = 1;
        this.a.longMsgIndex = 0;
        this.a.longMsgId = ((short)(int)this.c.shmsgseq);
        this.a.saveExtInfoToExtStr("long_text_msg_resid", paramSendResult.f);
        AnonymousChatHelper.a().a(this.a);
        ((IOrderMediaMsgService)this.b.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(this.a, this.d);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("upload multi msg pack failed, result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.b);
        ((StringBuilder)localObject).append(",result.errStr=");
        ((StringBuilder)localObject).append(paramSendResult.c);
        QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.e;
      localMessageForMixedMsg = this.c;
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
      Object localObject = this.e;
      MessageForMixedMsg localMessageForMixedMsg = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendStructLongMsg fail: exception");
      localStringBuilder.append(paramSendResult.getMessage());
      MixedMsgManager.a((MixedMsgManager)localObject, localMessageForMixedMsg, true, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.3
 * JD-Core Version:    0.7.0.1
 */