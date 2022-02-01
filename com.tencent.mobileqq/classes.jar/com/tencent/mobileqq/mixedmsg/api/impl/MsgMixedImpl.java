package com.tencent.mobileqq.mixedmsg.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.List;

public class MsgMixedImpl
  implements IMsgMixed
{
  public void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageRecord paramMessageRecord)
  {
    MessageForMixedMsg.copyBaseInfoFromMixedToPic(paramMessageForPic, (MessageForMixedMsg)paramMessageRecord);
  }
  
  public List<MessageRecord> getElementList(MessageRecord paramMessageRecord)
  {
    return ((MessageForMixedMsg)paramMessageRecord).msgElemList;
  }
  
  public MessageRecord getMessageForPic(MessageRecord paramMessageRecord, long paramLong)
  {
    return ((MessageForMixedMsg)paramMessageRecord).getSubMessage(paramLong);
  }
  
  public boolean isMessageForMixedMsg(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForMixedMsg;
  }
  
  public void updateMsgAfterDownload(AppInterface paramAppInterface, MessageRecord paramMessageRecord, MessageForPic paramMessageForPic)
  {
    paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).upateMessageForPic(paramMessageForPic);
    if (paramMessageRecord != null) {
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.api.impl.MsgMixedImpl
 * JD-Core Version:    0.7.0.1
 */