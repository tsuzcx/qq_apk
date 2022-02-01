package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public abstract interface ILiveRoomAnchorInfo
  extends Serializable
{
  public abstract String getAnchorIcon();
  
  public abstract String getAnchorName();
  
  public abstract String getAnchorTinyId();
  
  public abstract int getIdVerifyTimestamp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo
 * JD-Core Version:    0.7.0.1
 */