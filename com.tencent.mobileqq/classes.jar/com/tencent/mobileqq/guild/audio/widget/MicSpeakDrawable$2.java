package com.tencent.mobileqq.guild.audio.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MicSpeakDrawable$2
  implements ValueAnimator.AnimatorUpdateListener
{
  MicSpeakDrawable$2(MicSpeakDrawable paramMicSpeakDrawable) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MicSpeakDrawable.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.MicSpeakDrawable.2
 * JD-Core Version:    0.7.0.1
 */