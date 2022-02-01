package com.tencent.tavkit.component;

import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;

class TAVPlayer$PostUpdateThread$1
  implements OnCompositionUpdateListener
{
  TAVPlayer$PostUpdateThread$1(TAVPlayer.PostUpdateThread paramPostUpdateThread, TAVPlayer.ICompositionBuilder paramICompositionBuilder) {}
  
  public void onUpdated(Player paramPlayer, boolean paramBoolean)
  {
    this.val$templateSource.onUpdated(paramPlayer, paramBoolean);
    TAVPlayer.PostUpdateThread.access$600(this.this$1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.PostUpdateThread.1
 * JD-Core Version:    0.7.0.1
 */