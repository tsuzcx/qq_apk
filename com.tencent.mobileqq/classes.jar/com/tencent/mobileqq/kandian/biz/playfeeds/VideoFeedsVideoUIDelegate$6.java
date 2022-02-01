package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class VideoFeedsVideoUIDelegate$6
  extends AnimateUtils.AnimationAdapter
{
  VideoFeedsVideoUIDelegate$6(VideoFeedsVideoUIDelegate paramVideoFeedsVideoUIDelegate, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.a.aw.startAnimation(this.a);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsVideoUIDelegate.6
 * JD-Core Version:    0.7.0.1
 */