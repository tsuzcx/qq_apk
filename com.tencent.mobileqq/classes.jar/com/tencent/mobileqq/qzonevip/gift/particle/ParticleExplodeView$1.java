package com.tencent.mobileqq.qzonevip.gift.particle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

class ParticleExplodeView$1
  extends AnimatorListenerAdapter
{
  ParticleExplodeView$1(ParticleExplodeView paramParticleExplodeView) {}
  
  public void onAnimationEnd(Animator arg1)
  {
    synchronized (this.a.k)
    {
      this.a.d.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView.1
 * JD-Core Version:    0.7.0.1
 */