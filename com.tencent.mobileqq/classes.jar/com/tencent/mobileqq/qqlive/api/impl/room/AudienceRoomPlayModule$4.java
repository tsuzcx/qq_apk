package com.tencent.mobileqq.qqlive.api.impl.room;

class AudienceRoomPlayModule$4
  implements Runnable
{
  AudienceRoomPlayModule$4(AudienceRoomPlayModule paramAudienceRoomPlayModule, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.val$isPreload)
    {
      this.this$0.preloadUrl(this.val$url);
      return;
    }
    this.this$0.startPlay(this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule.4
 * JD-Core Version:    0.7.0.1
 */