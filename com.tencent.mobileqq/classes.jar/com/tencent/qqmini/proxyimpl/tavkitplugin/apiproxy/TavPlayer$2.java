package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;

class TavPlayer$2
  implements IPlayer.PlayerListener
{
  TavPlayer$2(TavPlayer paramTavPlayer, TavPlayer.PlayerListener paramPlayerListener) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if ((this.a != null) && (TavPlayer.a(this.b) != null)) {
      this.a.a(paramCMTime, TavPlayer.a(this.b).duration());
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((this.a != null) && (TavPlayer.a(this.b) != null)) {
      this.a.a(paramPlayerStatus, TavPlayer.a(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayer.2
 * JD-Core Version:    0.7.0.1
 */