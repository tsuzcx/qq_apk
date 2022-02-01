package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;

class ThemeHbFragment$4
  implements AnimationView.MyAnimationListener
{
  ThemeHbFragment$4(ThemeHbFragment paramThemeHbFragment) {}
  
  public void onAnimationEnd(AnimationView paramAnimationView) {}
  
  public void onAnimationRepeat(AnimationView paramAnimationView) {}
  
  public void onAnimationStart(AnimationView paramAnimationView)
  {
    if (ThemeHbFragment.f(this.a).getChildCount() > 0) {
      ThemeHbFragment.f(this.a).removeViewAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.ThemeHbFragment.4
 * JD-Core Version:    0.7.0.1
 */