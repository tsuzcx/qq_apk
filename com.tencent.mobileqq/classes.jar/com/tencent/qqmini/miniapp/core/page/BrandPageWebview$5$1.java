package com.tencent.qqmini.miniapp.core.page;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;

class BrandPageWebview$5$1
  implements Animation.AnimationListener
{
  BrandPageWebview$5$1(BrandPageWebview.5 param5) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new BrandPageWebview.5.1.1(this), 10L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.5.1
 * JD-Core Version:    0.7.0.1
 */