package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class ResumeRetryStrategy
  implements AudienceRoomPlayModule.PlayRetryStrategy
{
  private boolean isError = false;
  private AudienceRoomPlayModule playModule;
  
  public void bindPlayModule(AudienceRoomPlayModule paramAudienceRoomPlayModule)
  {
    this.playModule = paramAudienceRoomPlayModule;
  }
  
  public void onError(int paramInt)
  {
    if (!this.isError)
    {
      Iterator localIterator = this.playModule.playerListeners.iterator();
      while (localIterator.hasNext()) {
        ((AudienceRoomPlayerListener)localIterator.next()).onError(paramInt, "");
      }
    }
    this.isError = true;
    this.playModule.retry();
  }
  
  public void onPrepared()
  {
    if (this.isError)
    {
      this.isError = false;
      Iterator localIterator = this.playModule.playerListeners.iterator();
      while (localIterator.hasNext()) {
        ((AudienceRoomPlayerListener)localIterator.next()).onResume();
      }
    }
  }
  
  public void reset()
  {
    this.isError = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.ResumeRetryStrategy
 * JD-Core Version:    0.7.0.1
 */