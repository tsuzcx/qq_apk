package com.tencent.timi.game.team.impl.team;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class MicWaveViewLottie$1
  extends D8SafeAnimatorListener
{
  MicWaveViewLottie$1(MicWaveViewLottie paramMicWaveViewLottie) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    MicWaveViewLottie.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    MicWaveViewLottie.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    MicWaveViewLottie.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.MicWaveViewLottie.1
 * JD-Core Version:    0.7.0.1
 */