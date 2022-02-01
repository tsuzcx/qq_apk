package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallbackRegister;

public abstract interface ILiveRoom
  extends ILiveRoomBase, ILiveRoomMessage, ILiveRoomOperation, ILiveRoomTime, IQQLiveReportCallbackRegister
{
  public abstract BaseAnchorInfo getAnchorInfo();
  
  public abstract BaseRoomInfo getRoomInfo();
  
  public abstract boolean isAnchorRoom();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveRoom
 * JD-Core Version:    0.7.0.1
 */