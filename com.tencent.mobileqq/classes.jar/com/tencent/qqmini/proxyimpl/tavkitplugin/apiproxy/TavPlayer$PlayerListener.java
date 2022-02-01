package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;

public abstract interface TavPlayer$PlayerListener
{
  public abstract void a(CMTime paramCMTime1, CMTime paramCMTime2);
  
  public abstract void a(IPlayer.PlayerStatus paramPlayerStatus, Player paramPlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.PlayerListener
 * JD-Core Version:    0.7.0.1
 */