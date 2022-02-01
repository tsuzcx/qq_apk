package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.data.MessageRecord;

public abstract interface IOrderMediaMsgService$IMsgSendingListener
{
  public abstract void onSendBegin(MessageRecord paramMessageRecord);
  
  public abstract void onSendEnd(boolean paramBoolean, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService.IMsgSendingListener
 * JD-Core Version:    0.7.0.1
 */