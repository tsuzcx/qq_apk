package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IMessageRecordFactory
  extends QRouteApi
{
  public abstract MessageRecord createMsgRecordByMsgType(int paramInt);
  
  public abstract MessageRecord createMsgRecordFromDB(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3);
  
  public abstract MessageRecord createResendMsg(MessageRecord paramMessageRecord);
  
  public abstract MessageRecord createSendMSg_BlessPTV(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt);
  
  public abstract MessageRecord createSendMSg_Pic(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt);
  
  public abstract MessageRecord createSendMSg_ShortVideo(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt);
  
  public abstract void setSendingMsgRecordBaseInfo(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMessageRecordFactory
 * JD-Core Version:    0.7.0.1
 */