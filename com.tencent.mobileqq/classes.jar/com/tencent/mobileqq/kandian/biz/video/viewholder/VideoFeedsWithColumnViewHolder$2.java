package com.tencent.mobileqq.kandian.biz.video.viewholder;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

class VideoFeedsWithColumnViewHolder$2
  implements Animation.AnimationListener
{
  VideoFeedsWithColumnViewHolder$2(VideoFeedsWithColumnViewHolder paramVideoFeedsWithColumnViewHolder, ImageView paramImageView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.a.setImageResource(VideoFeedsWithColumnViewHolder.a(this.c, this.b));
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsWithColumnViewHolder.2
 * JD-Core Version:    0.7.0.1
 */