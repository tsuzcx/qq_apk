package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
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
    if (this.a.i)
    {
      if ((((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(FitSystemWindowsRelativeLayout.a(this.a)).a() ^ true))
      {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(FitSystemWindowsRelativeLayout.a(this.a), "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("placeholder.sprite", 2, "show sprite (normal) in fullscreen.");
        }
      }
      paramAnimator = this.a;
      paramAnimator.i = false;
      paramAnimator.a.setImageDrawable(null);
      paramAnimator = this.a;
      paramAnimator.removeView(paramAnimator.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FitSystemWindowsRelativeLayout.2
 * JD-Core Version:    0.7.0.1
 */