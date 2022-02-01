package com.tencent.mobileqq.location.ui;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.mobileqq.widget.ISlidePanelListener;

class PoiSlideBottomPanel$5
  extends D8SafeAnimatorListener
{
  PoiSlideBottomPanel$5(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.h(this.a, false);
    PoiSlideBottomPanel.i(this.a, false);
    PoiSlideBottomPanel.j(this.a, false);
    if (PoiSlideBottomPanel.m(this.a) != null) {
      PoiSlideBottomPanel.n(this.a).hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.e(this.a, false);
    PoiSlideBottomPanel.f(this.a, false);
    PoiSlideBottomPanel.g(this.a, false);
    if (PoiSlideBottomPanel.k(this.a) != null) {
      PoiSlideBottomPanel.l(this.a).hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PoiSlideBottomPanel.d(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel.5
 * JD-Core Version:    0.7.0.1
 */