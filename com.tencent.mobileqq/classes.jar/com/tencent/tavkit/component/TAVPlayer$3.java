package com.tencent.tavkit.component;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.Player;

class TAVPlayer$3
  implements IPlayer.PlayerListener
{
  TAVPlayer$3(TAVPlayer paramTAVPlayer, TAVPlayer.PlayerListener paramPlayerListener) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if ((this.val$playerListener != null) && (TAVPlayer.access$100(this.this$0) != null)) {
      this.val$playerListener.onPositionChanged(paramCMTime, TAVPlayer.access$100(this.this$0).duration());
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((this.val$playerListener != null) && (TAVPlayer.access$100(this.this$0) != null)) {
      this.val$playerListener.onStatusChanged(paramPlayerStatus, TAVPlayer.access$100(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.3
 * JD-Core Version:    0.7.0.1
 */