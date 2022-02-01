package com.tencent.mobileqq.qqlive.push.api;

import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;

public abstract interface IQQLivePushCallback
{
  public abstract void onRecv(int paramInt, byte[] paramArrayOfByte, LiveMsgExtInfo paramLiveMsgExtInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.api.IQQLivePushCallback
 * JD-Core Version:    0.7.0.1
 */