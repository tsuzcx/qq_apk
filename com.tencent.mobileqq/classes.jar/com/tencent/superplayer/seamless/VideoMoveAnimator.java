package com.tencent.superplayer.seamless;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

class VideoMoveAnimator
  implements VideoAnimator
{
  private Animator.AnimatorListener animatorListener;
  private long duration;
  private ViewInfo fromViewInfo;
  private View targetView;
  private ViewInfo toViewInfo;
  
  public VideoMoveAnimator(View paramView, ViewInfo paramViewInfo1, ViewInfo paramViewInfo2, long paramLong, Animator.AnimatorListener paramAnimatorListener)
  {
    this.targetView = paramView;
    this.fromViewInfo = paramViewInfo1;
    this.toViewInfo = paramViewInfo2;
    this.duration = paramLong;
    this.animatorListener = paramAnimatorListener;
  }
  
  public void start()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.targetView, "x", new float[] { this.fromViewInfo.x, this.toViewInfo.x });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.targetView, "y", new float[] { this.fromViewInfo.y, this.toViewInfo.y });
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.fromViewInfo.width, this.toViewInfo.width });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.fromViewInfo.height, this.toViewInfo.height });
    localValueAnimator1.addUpdateListener(new VideoMoveAnimator.1(this));
    localValueAnimator2.addUpdateListener(new VideoMoveAnimator.2(this));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.setDuration(this.duration);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.addListener(this.animatorListener);
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.seamless.VideoMoveAnimator
 * JD-Core Version:    0.7.0.1
 */