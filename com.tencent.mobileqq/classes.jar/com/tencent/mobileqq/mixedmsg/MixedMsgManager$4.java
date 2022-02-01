package com.tencent.mobileqq.mixedmsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.service.message.MessageCache;

class MixedMsgManager$4
  extends MediaMessageObserver
{
  MixedMsgManager$4(MixedMsgManager paramMixedMsgManager, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    this.a.getMsgCache().b(this.b.frienduin, this.b.istroop, this.b.uniseq);
    Object localObject2 = this.a.getMsgHandler();
    Object localObject3 = this.b.frienduin;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.uniseq);
    Object localObject1 = "";
    localStringBuilder.append("");
    ((MessageHandler)localObject2).notifyUI(6003, true, new Object[] { localObject3, localStringBuilder.toString() });
    this.a.getMessageFacade().a(this.c, this.d, this.b.uniseq, this.b.msgData);
    if (paramBoolean)
    {
      MixedMsgManager.a(this.e, this.b, true);
      return;
    }
    localObject2 = this.e;
    localObject3 = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendStructLongMsg fail : errCode = ");
    if (paramStatictisInfo != null) {
      localObject1 = Integer.valueOf(paramStatictisInfo.b);
    }
    localStringBuilder.append(localObject1);
    MixedMsgManager.a((MixedMsgManager)localObject2, (MessageForMixedMsg)localObject3, true, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.4
 * JD-Core Version:    0.7.0.1
 */