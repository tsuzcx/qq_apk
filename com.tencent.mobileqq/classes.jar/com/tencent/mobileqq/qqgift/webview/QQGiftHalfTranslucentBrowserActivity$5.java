package com.tencent.mobileqq.qqgift.webview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QQGiftHalfTranslucentBrowserActivity$5
  implements Animation.AnimationListener
{
  QQGiftHalfTranslucentBrowserActivity$5(QQGiftHalfTranslucentBrowserActivity paramQQGiftHalfTranslucentBrowserActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQGiftHalfTranslucentBrowserActivity.f(this.a) != null) {
      QQGiftHalfTranslucentBrowserActivity.f(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity.5
 * JD-Core Version:    0.7.0.1
 */