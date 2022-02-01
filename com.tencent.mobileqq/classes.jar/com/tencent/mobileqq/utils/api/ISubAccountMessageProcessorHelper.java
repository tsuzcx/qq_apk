package com.tencent.mobileqq.utils.api;

import PushNotifyPack.RequestPushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISubAccountMessageProcessorHelper
  extends QRouteApi
{
  public abstract String buildBaseMsg(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString);
  
  public abstract MessageRecord createMsgRecordByMsgType(int paramInt);
  
  public abstract boolean isMessageFuDai(MessageRecord paramMessageRecord);
  
  public abstract boolean isMessagePubAccount(MessageRecord paramMessageRecord);
  
  public abstract boolean isRedPacketMsg(MessageRecord paramMessageRecord);
  
  public abstract void processSubAccountRevokeNotify(AppInterface paramAppInterface, RequestPushNotify paramRequestPushNotify);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
 * JD-Core Version:    0.7.0.1
 */