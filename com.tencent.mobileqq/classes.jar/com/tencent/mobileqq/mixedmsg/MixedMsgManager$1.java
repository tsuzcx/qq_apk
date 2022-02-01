package com.tencent.mobileqq.mixedmsg;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class MixedMsgManager$1
  implements Runnable
{
  MixedMsgManager$1(MixedMsgManager paramMixedMsgManager, SessionInfo paramSessionInfo, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.b.getAccount();
    int k = this.a.a;
    String str = this.a.b;
    Object localObject1 = this.a.c;
    localObject1 = MessageRecordFactory.g(this.this$0.b, str, (String)localObject1, k);
    int j = this.b;
    int i = j;
    if (j == 0) {
      i = this.c.forwardID;
    }
    ForwardOrderManager.a().a(((MessageForMixedMsg)localObject1).uniseq, this.c.uniseq, i);
    ((MessageForMixedMsg)localObject1).extraflag = 32772;
    ((MessageForMixedMsg)localObject1).msgData = this.c.msgData;
    ((MessageForMixedMsg)localObject1).msgElemList = this.c.msgElemList;
    if (!this.d)
    {
      ((MessageForMixedMsg)localObject1).mForwardFromIsTroop = this.c.istroop;
      ((MessageForMixedMsg)localObject1).mForwardFromUin = this.c.frienduin;
    }
    else
    {
      ((MessageForMixedMsg)localObject1).mIsResend = true;
    }
    Object localObject3 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localMessageRecord.istroop = k;
      }
    }
    ((MessageForMixedMsg)localObject1).prewrite();
    ((IOrderMediaMsgService)this.this$0.b.getRuntimeService(IOrderMediaMsgService.class)).updateMediaMsgByUniseq(str, this.c.uniseq, ((MessageForMixedMsg)localObject1).uniseq);
    ((IOrderMediaMsgService)this.this$0.b.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg((MessageRecord)localObject1, null);
    this.this$0.b.getMsgHandler().notifyUI(1000, true, str);
    localObject3 = new ArrayList();
    localObject2 = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfos(7, (MessageRecord)localObject1, k, (String)localObject2, str, this.this$0.b.getAccount());
    if (localObject2 != null) {
      ((ArrayList)localObject3).addAll((Collection)localObject2);
    } else if (QLog.isColorLevel()) {
      QLog.e("MixedMsgManager", 2, "[forwardMixedMsg]createForwardPicInfos from MessageForMixedMsg failed");
    }
    if (((ArrayList)localObject3).size() > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[forwardMixedMsg]Upload pictures, count is [");
        ((StringBuilder)localObject2).append(((ArrayList)localObject3).size());
        ((StringBuilder)localObject2).append("], goto requestUploadPics");
        QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.this$0;
      MixedMsgManager.a((MixedMsgManager)localObject2, ((MixedMsgManager)localObject2).b, str, k, (ArrayList)localObject3, (MessageForMixedMsg)localObject1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[forwardMixedMsg]There's not any picture messages, goto onPackAndSendMsg");
    }
    localObject2 = this.this$0;
    MixedMsgManager.a((MixedMsgManager)localObject2, ((MixedMsgManager)localObject2).b, str, k, (MessageForMixedMsg)localObject1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.1
 * JD-Core Version:    0.7.0.1
 */