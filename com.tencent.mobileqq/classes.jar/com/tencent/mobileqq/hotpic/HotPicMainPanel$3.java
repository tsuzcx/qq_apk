package com.tencent.mobileqq.hotpic;

import android.animation.Animator;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class HotPicMainPanel$3
  extends D8SafeAnimatorListener
{
  HotPicMainPanel$3(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.a.s != null) && (this.a.s.isShowing())) {
      this.a.s.dismiss();
    }
    this.a.j.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel.3
 * JD-Core Version:    0.7.0.1
 */