package io.flutter.embedding.android;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class DrawableSplashScreen$1
  implements Animator.AnimatorListener
{
  DrawableSplashScreen$1(DrawableSplashScreen paramDrawableSplashScreen, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.val$onTransitionComplete.run();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$onTransitionComplete.run();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.DrawableSplashScreen.1
 * JD-Core Version:    0.7.0.1
 */