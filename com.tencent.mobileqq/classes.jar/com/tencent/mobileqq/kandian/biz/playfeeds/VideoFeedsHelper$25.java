package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class VideoFeedsHelper$25
  extends AnimatorListenerAdapter
{
  VideoFeedsHelper$25(View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setLayerType(0, null);
    this.a.setVisibility(8);
    this.a.setTranslationY(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.25
 * JD-Core Version:    0.7.0.1
 */