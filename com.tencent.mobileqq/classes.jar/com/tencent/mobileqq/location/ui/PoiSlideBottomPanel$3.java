package com.tencent.mobileqq.location.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.ISlidePanelListener;

class PoiSlideBottomPanel$3
  implements Animator.AnimatorListener
{
  PoiSlideBottomPanel$3(PoiSlideBottomPanel paramPoiSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    PoiSlideBottomPanel.c(this.a, false);
    if (PoiSlideBottomPanel.e(this.a) != null) {
      PoiSlideBottomPanel.f(this.a).displayPanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PoiSlideBottomPanel.b(this.a, false);
    if (PoiSlideBottomPanel.c(this.a) != null) {
      PoiSlideBottomPanel.d(this.a).displayPanelFinish();
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