package com.tencent.tav.player;

import com.tencent.tav.coremedia.CMTime;

public abstract interface IPlayer$PlayerListener
{
  public abstract void onPositionChanged(CMTime paramCMTime);
  
  public abstract void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.player.IPlayer.PlayerListener
 * JD-Core Version:    0.7.0.1
 */