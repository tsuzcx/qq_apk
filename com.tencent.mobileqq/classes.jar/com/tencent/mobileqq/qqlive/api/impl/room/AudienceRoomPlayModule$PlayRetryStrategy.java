package com.tencent.mobileqq.qqlive.api.impl.room;

public abstract interface AudienceRoomPlayModule$PlayRetryStrategy
{
  public abstract void bindPlayModule(AudienceRoomPlayModule paramAudienceRoomPlayModule);
  
  public abstract void onError(int paramInt);
  
  public abstract void onPrepared();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule.PlayRetryStrategy
 * JD-Core Version:    0.7.0.1
 */