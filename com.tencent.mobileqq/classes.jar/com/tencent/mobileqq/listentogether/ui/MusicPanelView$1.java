package com.tencent.mobileqq.listentogether.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class MusicPanelView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  MusicPanelView$1(MusicPanelView paramMusicPanelView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    MusicPanelView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.MusicPanelView.1
 * JD-Core Version:    0.7.0.1
 */