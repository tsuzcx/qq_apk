package com.tencent.mobileqq.qqlive.api.anchor.room;

import android.app.Activity;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallbackRegister;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.RoomInfoListener;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;

public abstract interface IQQLiveAnchorRoom
  extends ILiveRoom, IQQLiveAnchorRoomCallbackRegister
{
  public abstract QQLiveAnchorRoomState currentState();
  
  public abstract void enterRoom();
  
  public abstract void fastExit(ExitRoomCallback paramExitRoomCallback);
  
  public abstract void fastResume();
  
  public abstract QQLiveAnchorRoomInfo getAnchorRoomInfo();
  
  public abstract QQLiveAnchorRoomConfig getRoomConfig();
  
  public abstract void prepare(Activity paramActivity);
  
  public abstract void registerRoomInfoListener(RoomInfoListener paramRoomInfoListener);
  
  public abstract void setAnchorRoomConfig(QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig);
  
  public abstract void setAnchorRoomInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo);
  
  public abstract void startPublishStream();
  
  public abstract void startSet(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr);
  
  public abstract void unRegisterRoomInfoListener(RoomInfoListener paramRoomInfoListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom
 * JD-Core Version:    0.7.0.1
 */