package com.tencent.mobileqq.location.ui;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.mobileqq.widget.ISlidePanelListener;

class PoiSlideBottomPanel$3
  extends D8SafeAnimatorListener
{
  PoiSlideBottomPanel$3(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.c(this.a, false);
    if (PoiSlideBottomPanel.g(this.a) != null) {
      PoiSlideBottomPanel.h(this.a).displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.b(this.a, false);
    if (PoiSlideBottomPanel.e(this.a) != null) {
      PoiSlideBottomPanel.f(this.a).displayPanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    PoiSlideBottomPanel.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.PoiSlideBottomPanel.3
 * JD-Core Version:    0.7.0.1
 */