package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;

public abstract interface IQQLiveSystemMsgService
  extends IQQLiveModule
{
  public abstract void addSystemMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void delSystemMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void sendSystemNotice(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService
 * JD-Core Version:    0.7.0.1
 */