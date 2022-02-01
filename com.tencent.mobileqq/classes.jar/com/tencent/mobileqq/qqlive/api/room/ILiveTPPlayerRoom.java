package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;

public abstract interface ILiveTPPlayerRoom
  extends ILiveMediaRoom<ITPPlayerVideoView>
{
  public abstract int getPlayStatus();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void preloadUrl(String paramString);
  
  public abstract void registerRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener);
  
  public abstract void startPlay(String paramString);
  
  public abstract void unRegisterRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom
 * JD-Core Version:    0.7.0.1
 */