package com.tencent.mobileqq.microapp.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;

final class c
  extends AnimatorListenerAdapter
{
  c(AppBrandUI paramAppBrandUI, a parama1, a parama2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.c();
    this.a.g.setTranslationY(0.0F);
    this.c.a.a(this.b);
    this.b.a(this.b.c.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.ui.c
 * JD-Core Version:    0.7.0.1
 */