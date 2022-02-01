package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.Iterator;
import java.util.List;

class RecordMicView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  RecordMicView$1(RecordMicView paramRecordMicView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = RecordMicView.a(this.a).iterator();
    while (paramValueAnimator.hasNext())
    {
      RecordMicView.CircleHolder localCircleHolder = (RecordMicView.CircleHolder)paramValueAnimator.next();
      localCircleHolder.c = (localCircleHolder.g + (localCircleHolder.h - localCircleHolder.g) * f);
      localCircleHolder.d = (localCircleHolder.i + (localCircleHolder.j - localCircleHolder.i) * f);
      localCircleHolder.e = (localCircleHolder.k + (localCircleHolder.l - localCircleHolder.k) * f);
      localCircleHolder.f = (localCircleHolder.m + (int)((localCircleHolder.n - localCircleHolder.m) * f));
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.RecordMicView.1
 * JD-Core Version:    0.7.0.1
 */