package com.tencent.tavkit.component;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;

class TAVPlayer$3
  implements OnCompositionUpdateListener
{
  TAVPlayer$3(TAVPlayer paramTAVPlayer, CMTime paramCMTime, boolean paramBoolean) {}
  
  public void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    this.this$0.seekToTime(this.val$position);
    if ((this.val$autoPlay) && (paramBoolean)) {
      this.this$0.play();
    }
    TAVPlayer.access$102(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.3
 * JD-Core Version:    0.7.0.1
 */