package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VideoFeedsShareGuideController$2
  implements Animation.AnimationListener
{
  VideoFeedsShareGuideController$2(VideoFeedsShareGuideController paramVideoFeedsShareGuideController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoFeedsShareGuideController.f(this.a).startAnimation(VideoFeedsShareGuideController.e(this.a));
    VideoFeedsShareGuideController.g(this.a).sendEmptyMessageDelayed(1, 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareGuideController.2
 * JD-Core Version:    0.7.0.1
 */