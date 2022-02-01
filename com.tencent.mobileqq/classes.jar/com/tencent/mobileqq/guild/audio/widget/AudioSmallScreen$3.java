package com.tencent.mobileqq.guild.audio.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class AudioSmallScreen$3
  implements Animator.AnimatorListener
{
  AudioSmallScreen$3(AudioSmallScreen paramAudioSmallScreen, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    AudioSmallScreen.d(this.b).setBackgroundResource(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen.3
 * JD-Core Version:    0.7.0.1
 */