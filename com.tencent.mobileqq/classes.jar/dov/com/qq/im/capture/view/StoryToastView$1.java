package dov.com.qq.im.capture.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class StoryToastView$1
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(Animator paramAnimator)
  {
    StoryToastView.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryToastView.1
 * JD-Core Version:    0.7.0.1
 */