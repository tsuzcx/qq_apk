package com.tencent.mobileqq.qqlive.push.api;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;

public abstract interface IQQLiveRoomPushService
  extends IQQLiveModule
{
  public abstract PushReceiver a();
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract long b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService
 * JD-Core Version:    0.7.0.1
 */