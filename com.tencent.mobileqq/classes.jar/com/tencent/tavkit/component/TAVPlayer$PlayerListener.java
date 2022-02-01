package com.tencent.tavkit.component;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;

public abstract interface TAVPlayer$PlayerListener
{
  public abstract void onPositionChanged(CMTime paramCMTime1, CMTime paramCMTime2);
  
  public abstract void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus, Player paramPlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.PlayerListener
 * JD-Core Version:    0.7.0.1
 */