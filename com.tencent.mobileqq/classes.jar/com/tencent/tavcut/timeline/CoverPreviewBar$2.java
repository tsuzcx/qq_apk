package com.tencent.tavcut.timeline;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;

class CoverPreviewBar$2
  implements IPlayer.PlayerListener
{
  CoverPreviewBar$2(CoverPreviewBar paramCoverPreviewBar, MoviePlayer paramMoviePlayer) {}
  
  public void onPositionChanged(CMTime paramCMTime) {}
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((paramPlayerStatus == IPlayer.PlayerStatus.IDLE) || (paramPlayerStatus == IPlayer.PlayerStatus.PAUSED)) {
      CoverPreviewBar.access$100(this.this$0, this.val$player);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.CoverPreviewBar.2
 * JD-Core Version:    0.7.0.1
 */