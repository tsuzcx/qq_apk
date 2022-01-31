package com.tencent.mobileqq.mini.appbrand.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ProgressBar;

class AppLoadingUI$3
  implements Animation.AnimationListener
{
  AppLoadingUI$3(AppLoadingUI paramAppLoadingUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppLoadingUI.access$200(this.this$0).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.3
 * JD-Core Version:    0.7.0.1
 */