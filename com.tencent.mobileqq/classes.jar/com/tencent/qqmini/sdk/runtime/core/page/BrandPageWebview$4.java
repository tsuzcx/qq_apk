package com.tencent.qqmini.sdk.runtime.core.page;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import bfbf;
import bfbi;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class BrandPageWebview$4
  implements Runnable
{
  public void run()
  {
    AppBrandPage localAppBrandPage = bfbf.a(this.this$0).a();
    localAppBrandPage.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(MiniAppEnv.g().getContext(), 2130772085);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new bfbi(this));
    localAppBrandPage.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.4
 * JD-Core Version:    0.7.0.1
 */