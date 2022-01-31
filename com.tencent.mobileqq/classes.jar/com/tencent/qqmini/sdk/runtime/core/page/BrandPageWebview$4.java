package com.tencent.qqmini.sdk.runtime.core.page;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import bhbi;
import bhbl;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;

public class BrandPageWebview$4
  implements Runnable
{
  public void run()
  {
    AppBrandPage localAppBrandPage = bhbi.a(this.this$0).a();
    localAppBrandPage.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(AppLoaderFactory.g().getMiniAppEnv().getContext(), 2130772085);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new bhbl(this));
    localAppBrandPage.startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.BrandPageWebview.4
 * JD-Core Version:    0.7.0.1
 */