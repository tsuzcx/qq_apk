package com.tencent.timi.game.team.impl.floating;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;

class WaveAvatarRoundView$3
  extends AnimatorListenerAdapter
{
  WaveAvatarRoundView$3(WaveAvatarRoundView paramWaveAvatarRoundView) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    WaveAvatarRoundView.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.WaveAvatarRoundView.3
 * JD-Core Version:    0.7.0.1
 */