package com.tencent.mobileqq.qqlive.api.room;

public abstract interface ILiveRoomTime
{
  public abstract long getEnterRoomTime();
  
  public abstract void setEnterRoomTime(long paramLong);
  
  public abstract void setSeq(String paramString1, String paramString2, long paramLong);
  
  public abstract void startRoomTimer(long paramLong);
  
  public abstract void stopRoomTimer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveRoomTime
 * JD-Core Version:    0.7.0.1
 */