package com.tencent.mobileqq.qwallet.transaction;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INotifyMsgApi
  extends QRouteApi
{
  public abstract boolean checkBusinessType(int paramInt);
  
  public abstract int getAAPayState(String paramString, MessageRecord paramMessageRecord);
  
  public abstract String getAAPayState(MessageRecord paramMessageRecord);
  
  public abstract boolean isBusinessTypeAAPay(int paramInt);
  
  public abstract void onActiveAccount();
  
  public abstract void onReceiveAAPaySysNotify(int paramInt, Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
 * JD-Core Version:    0.7.0.1
 */