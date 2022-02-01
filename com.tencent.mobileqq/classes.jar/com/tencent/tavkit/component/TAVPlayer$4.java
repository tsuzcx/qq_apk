package com.tencent.tavkit.component;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;

class TAVPlayer$4
  implements OnCompositionUpdateListener
{
  TAVPlayer$4(TAVPlayer paramTAVPlayer, CMTime paramCMTime, boolean paramBoolean, OnCompositionUpdateListener paramOnCompositionUpdateListener) {}
  
  public void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    this.this$0.seekToTime(this.val$position);
    if ((this.val$autoPlay) && (paramBoolean)) {
      this.this$0.play();
    }
    TAVPlayer.access$202(this.this$0, false);
    OnCompositionUpdateListener localOnCompositionUpdateListener = this.val$compositionUpdateListener;
    if (localOnCompositionUpdateListener != null) {
      localOnCompositionUpdateListener.onUpdated(paramPlayer, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.4
 * JD-Core Version:    0.7.0.1
 */