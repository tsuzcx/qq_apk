package com.tencent.mobileqq.qqlive.api.room;

public abstract interface ILiveMediaRoom<F>
  extends ILiveRoom
{
  public abstract F getDisplayView();
  
  public abstract void setMute(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom
 * JD-Core Version:    0.7.0.1
 */