package com.tencent.mobileqq.webview.swift;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class SwiftFloatViewUI$2$1
  implements Animation.AnimationListener
{
  SwiftFloatViewUI$2$1(SwiftFloatViewUI.2 param2, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)this.a.getLayoutParams();
    paramAnimation.leftMargin = this.b.e;
    paramAnimation.topMargin = this.b.f;
    this.a.setLayoutParams(paramAnimation);
    this.a.clearAnimation();
    this.a.setVisibility(0);
    this.b.i = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.2.1
 * JD-Core Version:    0.7.0.1
 */