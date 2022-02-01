package com.tencent.mobileqq.qqlive.callback.room.audience;

public abstract interface LiveRoomStatusListener
{
  public abstract void onRoomClose(int paramInt, String paramString);
  
  public abstract void onRoomOpen();
  
  public abstract void onRoomPause();
  
  public abstract void onRoomResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
 * JD-Core Version:    0.7.0.1
 */