package com.tencent.mobileqq.qzoneplayer.player;

import com.tencent.oskplayer.model.SegmentVideoInfo.StreamInfo;

public abstract interface IPlayerSupport
{
  public abstract PlayerSupportStatus isSupport();
  
  public abstract PlayerSupportStatus isSupportStream(SegmentVideoInfo.StreamInfo paramStreamInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzoneplayer.player.IPlayerSupport
 * JD-Core Version:    0.7.0.1
 */