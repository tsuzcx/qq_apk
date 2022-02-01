package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import android.animation.Animator;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class VideoView$7
  extends D8SafeAnimatorListener
{
  VideoView$7(VideoView paramVideoView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (VideoView.access$800(this.a) != null) {
      VideoView.access$800(this.a).setVisibility(4);
    }
    if (VideoView.access$900(this.a) != null) {
      VideoView.access$900(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.7
 * JD-Core Version:    0.7.0.1
 */