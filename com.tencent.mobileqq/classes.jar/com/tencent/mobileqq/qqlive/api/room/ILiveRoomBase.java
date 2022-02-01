package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.GetRoomInfoCallback;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

public abstract interface ILiveRoomBase
  extends IQQLiveModule
{
  public abstract void exitRoom(ExitRoomCallback paramExitRoomCallback);
  
  public abstract BaseAnchorInfo getAnchorInfo();
  
  public abstract BaseRoomInfo getRoomInfo();
  
  public abstract void getRoomRealTimeInfo(GetRoomInfoCallback paramGetRoomInfoCallback);
  
  public abstract boolean isDestroyed();
  
  public abstract boolean isExitRoom();
  
  public abstract boolean isInited();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveRoomBase
 * JD-Core Version:    0.7.0.1
 */