package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;

public abstract interface IQQLivePushCmdService
  extends IQQLiveModule
{
  public abstract void registerHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void registerLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void unRegisterHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
  
  public abstract void unRegisterLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService
 * JD-Core Version:    0.7.0.1
 */