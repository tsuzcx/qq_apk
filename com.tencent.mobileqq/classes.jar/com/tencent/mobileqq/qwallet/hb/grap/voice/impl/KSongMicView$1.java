package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.Iterator;
import java.util.List;

class KSongMicView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  KSongMicView$1(KSongMicView paramKSongMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = KSongMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      KSongMicView.CircleHolder localCircleHolder = (KSongMicView.CircleHolder)paramValueAnimator.next();
      localCircleHolder.jdField_c_of_type_Float = (localCircleHolder.f + (localCircleHolder.g - localCircleHolder.f) * f);
      localCircleHolder.d = (localCircleHolder.h + (localCircleHolder.i - localCircleHolder.h) * f);
      localCircleHolder.e = (localCircleHolder.j + (localCircleHolder.k - localCircleHolder.j) * f);
      localCircleHolder.a = (localCircleHolder.b + (int)((localCircleHolder.jdField_c_of_type_Int - localCircleHolder.b) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongMicView.1
 * JD-Core Version:    0.7.0.1
 */