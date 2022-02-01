package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IPttTempApi
  extends QRouteApi
{
  public abstract void addAIOMessage(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString);
  
  public abstract MessageForPtt createPttMessage(AppRuntime paramAppRuntime, String paramString, BaseSessionInfo paramBaseSessionInfo, int paramInt1, int paramInt2);
  
  public abstract void doOnPttSrvAddressError(boolean paramBoolean, String paramString);
  
  public abstract Message getLastMessage(AppRuntime paramAppRuntime, String paramString, int paramInt);
  
  public abstract MessageRecord getMsgItemByUniseq(AppRuntime paramAppRuntime, String paramString, int paramInt, long paramLong);
  
  public abstract int getPttVipFlag(AppRuntime paramAppRuntime, String paramString);
  
  public abstract boolean isHotChat(AppRuntime paramAppRuntime, String paramString);
  
  public abstract void sendMessage(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver);
  
  public abstract void setJsPttLocalPath(String paramString);
  
  public abstract void setJsPttServerId(String paramString);
  
  public abstract void updateMsgContentByUniseq(AppRuntime paramAppRuntime, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  public abstract void updatePttRecordMessage(AppRuntime paramAppRuntime, BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IPttTempApi
 * JD-Core Version:    0.7.0.1
 */