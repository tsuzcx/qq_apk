package com.tencent.mobileqq.tribe.fragment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

class TribeVideoListPlayerFragment$2
  implements ValueAnimator.AnimatorUpdateListener
{
  TribeVideoListPlayerFragment$2(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.b.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.2
 * JD-Core Version:    0.7.0.1
 */