package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class NormalRetryStrategy
  implements AudienceRoomPlayModule.PlayRetryStrategy
{
  private int currentTime = 0;
  private AudienceRoomPlayModule playModule;
  int retryTime = 2147483647;
  
  public void bindPlayModule(AudienceRoomPlayModule paramAudienceRoomPlayModule)
  {
    this.playModule = paramAudienceRoomPlayModule;
  }
  
  public void onError(int paramInt)
  {
    int i = this.currentTime;
    if (i >= this.retryTime)
    {
      this.currentTime = 0;
      Iterator localIterator = this.playModule.playerListeners.iterator();
      while (localIterator.hasNext()) {
        ((AudienceRoomPlayerListener)localIterator.next()).onError(paramInt, "");
      }
      return;
    }
    this.currentTime = (i + 1);
    this.playModule.retry();
  }
  
  public void onPrepared() {}
  
  public void reset()
  {
    this.currentTime = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.NormalRetryStrategy
 * JD-Core Version:    0.7.0.1
 */