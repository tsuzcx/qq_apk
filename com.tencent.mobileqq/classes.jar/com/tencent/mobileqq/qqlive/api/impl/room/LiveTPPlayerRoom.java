package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;

public abstract class LiveTPPlayerRoom
  extends BaseLiveRoom
  implements ILiveTPPlayerRoom
{
  AudienceRoomPlayModule playModule = null;
  
  public LiveTPPlayerRoom()
  {
    this.playModule = new AudienceRoomPlayModule();
  }
  
  public LiveTPPlayerRoom(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.playModule = new AudienceRoomPlayModule();
    }
  }
  
  public void destroy()
  {
    super.destroy();
    AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
    if (localAudienceRoomPlayModule != null)
    {
      localAudienceRoomPlayModule.destroy();
      this.playModule = null;
    }
  }
  
  public ITPPlayerVideoView getDisplayView()
  {
    if (!this.isDestroy)
    {
      AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
      if (localAudienceRoomPlayModule != null) {
        return localAudienceRoomPlayModule.playerView;
      }
    }
    return null;
  }
  
  public int getPlayStatus()
  {
    AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
    if (localAudienceRoomPlayModule == null) {
      return 0;
    }
    return localAudienceRoomPlayModule.getCurrentStatus();
  }
  
  public void pause()
  {
    AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
    if (localAudienceRoomPlayModule != null) {
      localAudienceRoomPlayModule.pause();
    }
  }
  
  public void play()
  {
    AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
    if (localAudienceRoomPlayModule != null) {
      localAudienceRoomPlayModule.startPlay("");
    }
  }
  
  public void preloadUrl(String paramString)
  {
    if (!this.isDestroy)
    {
      AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
      if (localAudienceRoomPlayModule == null) {
        return;
      }
      localAudienceRoomPlayModule.preloadUrl(paramString);
    }
  }
  
  public void registerRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    if (!this.isDestroy)
    {
      AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
      if (localAudienceRoomPlayModule == null) {
        return;
      }
      localAudienceRoomPlayModule.registerRoomPlayerListener(paramAudienceRoomPlayerListener);
    }
  }
  
  public void reset()
  {
    super.reset();
    AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
    if (localAudienceRoomPlayModule != null) {
      localAudienceRoomPlayModule.reset();
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    if (!this.isDestroy)
    {
      AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
      if (localAudienceRoomPlayModule == null) {
        return;
      }
      localAudienceRoomPlayModule.setMute(paramBoolean);
    }
  }
  
  public void startPlay(String paramString)
  {
    if (!this.isDestroy)
    {
      AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
      if (localAudienceRoomPlayModule == null) {
        return;
      }
      localAudienceRoomPlayModule.startPlay(paramString);
    }
  }
  
  public void unRegisterRoomPlayerListener(AudienceRoomPlayerListener paramAudienceRoomPlayerListener)
  {
    if (!this.isDestroy)
    {
      AudienceRoomPlayModule localAudienceRoomPlayModule = this.playModule;
      if (localAudienceRoomPlayModule == null) {
        return;
      }
      localAudienceRoomPlayModule.unRegisterRoomPlayerListener(paramAudienceRoomPlayerListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.LiveTPPlayerRoom
 * JD-Core Version:    0.7.0.1
 */