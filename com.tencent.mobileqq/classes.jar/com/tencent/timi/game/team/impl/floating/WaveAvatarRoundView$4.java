package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class WaveAvatarRoundView$4
  implements PAGView.PAGViewListener
{
  WaveAvatarRoundView$4(WaveAvatarRoundView paramWaveAvatarRoundView) {}
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    WaveAvatarRoundView.b(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    WaveAvatarRoundView.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView)
  {
    WaveAvatarRoundView.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.WaveAvatarRoundView.4
 * JD-Core Version:    0.7.0.1
 */