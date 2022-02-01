package com.tencent.qqmini.sdk.runtime;

import android.view.animation.AnimationSet;
import android.widget.TextView;

class AppUIProxy$LoadingUI$3
  implements Runnable
{
  AppUIProxy$LoadingUI$3(AppUIProxy.LoadingUI paramLoadingUI, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    AppUIProxy.LoadingUI.access$300(this.this$0).setVisibility(0);
    AppUIProxy.LoadingUI.access$300(this.this$0).setAnimation(this.val$nameAniSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.3
 * JD-Core Version:    0.7.0.1
 */