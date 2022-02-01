package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class VideoHandler$8
  extends AnimatorListenerAdapter
{
  VideoHandler$8(VideoHandler paramVideoHandler) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoHandler.a(this.a).setLayerType(0, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "alpha animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.8
 * JD-Core Version:    0.7.0.1
 */