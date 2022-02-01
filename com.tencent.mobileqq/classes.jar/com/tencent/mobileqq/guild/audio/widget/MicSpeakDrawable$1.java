package com.tencent.mobileqq.guild.audio.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MicSpeakDrawable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  MicSpeakDrawable$1(MicSpeakDrawable paramMicSpeakDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MicSpeakDrawable.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.MicSpeakDrawable.1
 * JD-Core Version:    0.7.0.1
 */