package com.tencent.mobileqq.qqlive.callback.room;

import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;

public abstract interface RoomAudienceInfoListener
{
  public abstract void a(LiveMessageData.SpeakerInfo paramSpeakerInfo);
  
  public abstract void a(RoomAudienceInfo paramRoomAudienceInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
 * JD-Core Version:    0.7.0.1
 */