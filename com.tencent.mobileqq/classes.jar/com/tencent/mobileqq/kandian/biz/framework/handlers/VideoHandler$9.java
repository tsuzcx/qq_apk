package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$9
  extends AnimatorListenerAdapter
{
  VideoHandler$9(VideoHandler paramVideoHandler) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    VideoHandler.h(this.a).setLayerType(0, null);
    VideoHandler.g(this.a).setVisibility(8);
    VideoHandler.b(this.a).setAlpha(1.0F);
    if (this.a.g() != null) {
      this.a.z();
    }
    VideoHandler.h(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoanimation", 2, "trans animation end");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.9
 * JD-Core Version:    0.7.0.1
 */