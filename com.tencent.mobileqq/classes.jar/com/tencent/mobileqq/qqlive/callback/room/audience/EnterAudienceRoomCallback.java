package com.tencent.mobileqq.qqlive.callback.room.audience;

import com.tencent.mobileqq.qqlive.data.room.LiveInfo;

public abstract interface EnterAudienceRoomCallback
{
  public abstract void onFailed(int paramInt, String paramString);
  
  public abstract void onSuccess(LiveInfo paramLiveInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
 * JD-Core Version:    0.7.0.1
 */