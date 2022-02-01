package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SecurePhoneBannerManager$2
  implements Animation.AnimationListener
{
  SecurePhoneBannerManager$2(SecurePhoneBannerManager paramSecurePhoneBannerManager, Dialog paramDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager.2
 * JD-Core Version:    0.7.0.1
 */