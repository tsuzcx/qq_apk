package com.tencent.timi.game.team.impl.floating;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;

class WaveAvatarRoundView$2
  implements Animation.AnimationListener
{
  WaveAvatarRoundView$2(WaveAvatarRoundView paramWaveAvatarRoundView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    WaveAvatarRoundView.b(this.a).setVisibility(8);
    WaveAvatarRoundView.b(this.a).d();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.WaveAvatarRoundView.2
 * JD-Core Version:    0.7.0.1
 */