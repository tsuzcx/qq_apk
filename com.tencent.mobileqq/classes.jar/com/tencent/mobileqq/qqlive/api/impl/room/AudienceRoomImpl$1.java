package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;

class AudienceRoomImpl$1
  implements LiveRoomStatusListener
{
  AudienceRoomImpl$1(AudienceRoomImpl paramAudienceRoomImpl) {}
  
  public void onRoomClose(int paramInt, String paramString)
  {
    if (this.this$0.playModule != null) {
      this.this$0.playModule.pause();
    }
  }
  
  public void onRoomOpen()
  {
    if (this.this$0.playModule != null) {
      this.this$0.playModule.startPlay("");
    }
  }
  
  public void onRoomPause()
  {
    if (this.this$0.playModule != null) {
      this.this$0.playModule.pause();
    }
  }
  
  public void onRoomResume()
  {
    if (this.this$0.playModule != null) {
      this.this$0.playModule.startPlay("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomImpl.1
 * JD-Core Version:    0.7.0.1
 */