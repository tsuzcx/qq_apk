package com.tencent.mobileqq.webview.webso;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class WebSoScreenshot$1$1
  extends D8SafeAnimatorListener
{
  WebSoScreenshot$1$1(WebSoScreenshot.1 param1, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.a.setBackgroundDrawable(this.b.b);
    this.b.a.setVisibility(8);
    this.a.setListener(null);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoScreenshot.1.1
 * JD-Core Version:    0.7.0.1
 */