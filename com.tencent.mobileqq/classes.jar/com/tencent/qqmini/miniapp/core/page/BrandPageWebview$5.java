package com.tencent.qqmini.miniapp.core.page;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.qqmini.miniapp.R.anim;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

class BrandPageWebview$5
  implements Runnable
{
  BrandPageWebview$5(BrandPageWebview paramBrandPageWebview) {}
  
  public void run()
  {
    AppBrandPage localAppBrandPage = BrandPageWebview.access$700(this.this$0).getShowingPage();
    localAppBrandPage.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getContext(), R.anim.mini_sdk_page_slide_in_from_right);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new BrandPageWebview.5.1(this));
    localAppBrandPage.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.5
 * JD-Core Version:    0.7.0.1
 */