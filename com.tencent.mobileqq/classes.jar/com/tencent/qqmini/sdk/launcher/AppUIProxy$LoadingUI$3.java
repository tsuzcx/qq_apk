package com.tencent.qqmini.sdk.launcher;

import android.view.animation.AnimationSet;
import android.widget.TextView;

class AppUIProxy$LoadingUI$3
  implements Runnable
{
  AppUIProxy$LoadingUI$3(AppUIProxy.LoadingUI paramLoadingUI, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    AppUIProxy.LoadingUI.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppUIProxy$LoadingUI).setVisibility(0);
    AppUIProxy.LoadingUI.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppUIProxy$LoadingUI).setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.LoadingUI.3
 * JD-Core Version:    0.7.0.1
 */