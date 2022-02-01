package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;

public abstract interface IQQLiveEnterRoomService
  extends IQQLiveModule
{
  public abstract void addEnterRoomMessageListener(RoomAudienceInfoListener paramRoomAudienceInfoListener);
  
  public abstract void bindRoom(ILiveRoom paramILiveRoom);
  
  public abstract void delEnterRoomMessageListener(RoomAudienceInfoListener paramRoomAudienceInfoListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService
 * JD-Core Version:    0.7.0.1
 */