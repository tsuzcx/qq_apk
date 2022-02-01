package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class VisitorTroopCardFragment$7
  implements Animation.AnimationListener
{
  VisitorTroopCardFragment$7(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.b == null) {
      return;
    }
    if (paramAnimation == this.a.V) {
      VisitorTroopCardFragment.b(this.a, false);
    }
    this.a.b.clearAnimation();
    this.a.b.setFocusable(true);
    this.a.f.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.b != null) && (paramAnimation == this.a.U)) {
      VisitorTroopCardFragment.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment.7
 * JD-Core Version:    0.7.0.1
 */