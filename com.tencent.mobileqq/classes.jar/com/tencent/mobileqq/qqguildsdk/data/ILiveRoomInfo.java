package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.HashMap;

public abstract interface ILiveRoomInfo
  extends Serializable
{
  public abstract ILiveRoomAnchorInfo getAnchorInfo();
  
  public abstract int getFakeNum();
  
  public abstract String getProgramId();
  
  public abstract String getQueryId();
  
  public abstract int getRealNum();
  
  public abstract int getRobotNum();
  
  public abstract HashMap<String, String> getRoomIcons();
  
  public abstract String getRoomId();
  
  public abstract int getRoomState();
  
  public abstract String getRoomTitle();
  
  public abstract long getViewer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
 * JD-Core Version:    0.7.0.1
 */