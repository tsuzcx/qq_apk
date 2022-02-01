package com.tencent.qqmini.sdk.runtime;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AppUIProxy$LoadingUI$5
  implements Animation.AnimationListener
{
  AppUIProxy$LoadingUI$5(AppUIProxy.LoadingUI paramLoadingUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppUIProxy.LoadingUI.access$400(this.this$0).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.5
 * JD-Core Version:    0.7.0.1
 */