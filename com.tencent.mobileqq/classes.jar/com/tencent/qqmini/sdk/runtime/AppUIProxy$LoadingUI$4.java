package com.tencent.qqmini.sdk.runtime;

import android.view.animation.AnimationSet;
import android.widget.TextView;

class AppUIProxy$LoadingUI$4
  implements Runnable
{
  AppUIProxy$LoadingUI$4(AppUIProxy.LoadingUI paramLoadingUI, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    AppUIProxy.LoadingUI.access$300(this.this$0).setVisibility(0);
    AppUIProxy.LoadingUI.access$300(this.this$0).setAnimation(this.val$nameAniSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.4
 * JD-Core Version:    0.7.0.1
 */