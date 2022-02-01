package com.tencent.mobileqq.mixedmsg.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IMsgMixed
  extends QRouteApi
{
  public abstract void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageRecord paramMessageRecord);
  
  public abstract List<MessageRecord> getElementList(MessageRecord paramMessageRecord);
  
  public abstract MessageRecord getMessageForPic(MessageRecord paramMessageRecord, long paramLong);
  
  public abstract boolean isMessageForMixedMsg(MessageRecord paramMessageRecord);
  
  public abstract void updateMsgAfterDownload(AppInterface paramAppInterface, MessageRecord paramMessageRecord, MessageForPic paramMessageForPic);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.api.IMsgMixed
 * JD-Core Version:    0.7.0.1
 */