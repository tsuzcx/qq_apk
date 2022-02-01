package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class FitSystemWindowsRelativeLayout$2
  extends AnimatorListenerAdapter
{
  FitSystemWindowsRelativeLayout$2(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.a.jdField_a_of_type_Boolean) {
      if (!((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(FitSystemWindowsRelativeLayout.a(this.a)).a()) {
        break label120;
      }
    }
    label120:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(FitSystemWindowsRelativeLayout.a(this.a), "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("placeholder.sprite", 2, "show sprite (normal) in fullscreen.");
        }
      }
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      this.a.removeView(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.FitSystemWindowsRelativeLayout.2
 * JD-Core Version:    0.7.0.1
 */