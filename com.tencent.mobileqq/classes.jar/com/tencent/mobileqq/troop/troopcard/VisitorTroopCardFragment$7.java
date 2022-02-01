package com.tencent.mobileqq.troop.troopcard;

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
    if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (paramAnimation == this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
      VisitorTroopCardFragment.a(this.a, false);
    }
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)) {
      VisitorTroopCardFragment.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.7
 * JD-Core Version:    0.7.0.1
 */