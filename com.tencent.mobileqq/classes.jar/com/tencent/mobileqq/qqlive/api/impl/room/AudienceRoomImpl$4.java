package com.tencent.mobileqq.qqlive.api.impl.room;

import com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;

class AudienceRoomImpl$4
  implements ExitRoomCallback
{
  AudienceRoomImpl$4(AudienceRoomImpl paramAudienceRoomImpl, ExitRoomCallback paramExitRoomCallback) {}
  
  public void onComplete(int paramInt, String paramString)
  {
    this.val$callback.onComplete(paramInt, paramString);
    this.this$0.techReporter.onComplete(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomImpl.4
 * JD-Core Version:    0.7.0.1
 */