package com.tencent.mobileqq.troop.essencemsg;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import java.util.HashSet;

class TroopEssenceMsgManager$2
  extends MessageObserver
{
  TroopEssenceMsgManager$2(TroopEssenceMsgManager paramTroopEssenceMsgManager) {}
  
  public void onNotifyUpdateSelfMsgSeqAndTime(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while ((this.a.a == null) || (paramMessageRecord.istroop != 1) || (!this.a.a.contains(new TroopEssenceMsgManager.WaittingEssenceMsgItem(this.a, paramMessageRecord.frienduin, paramMessageRecord.uniseq)))) {
      return;
    }
    TroopEssenceMsgItem localTroopEssenceMsgItem = new TroopEssenceMsgItem();
    try
    {
      localTroopEssenceMsgItem.troopUin = Long.parseLong(paramMessageRecord.frienduin);
      localTroopEssenceMsgItem.msgSeq = paramMessageRecord.shmsgseq;
      localTroopEssenceMsgItem.msgRandom = MessageUtils.b(paramMessageRecord.msgUid);
      localTroopEssenceMsgItem.opUin = TroopEssenceMsgManager.a(this.a).getCurrentUin();
      localTroopEssenceMsgItem.msgSenderUin = paramMessageRecord.senderuin;
      localTroopEssenceMsgItem.opType = 1;
      localTroopEssenceMsgItem.msgType = TroopEssenceUtil.a(TroopEssenceMsgManager.a(this.a), (ChatMessage)paramMessageRecord);
      this.a.a(localTroopEssenceMsgItem, 2);
      this.a.a.remove(new TroopEssenceMsgManager.WaittingEssenceMsgItem(this.a, paramMessageRecord.frienduin, paramMessageRecord.uniseq));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager.2
 * JD-Core Version:    0.7.0.1
 */