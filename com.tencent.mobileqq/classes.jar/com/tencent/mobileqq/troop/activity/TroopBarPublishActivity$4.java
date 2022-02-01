package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;

class TroopBarPublishActivity$4
  implements Animation.AnimationListener
{
  TroopBarPublishActivity$4(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool = false;
    paramAnimation = this.a;
    paramAnimation.q -= 1;
    if (this.a.q == 0)
    {
      this.a.p = false;
      int i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(i);
        if (paramAnimation != null) {
          paramAnimation.clearAnimation();
        }
        i += 1;
      }
      this.a.c.clearAnimation();
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(this.a.r);
      paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < this.a.s) {
        bool = true;
      }
      paramAnimation.a(bool, true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.4
 * JD-Core Version:    0.7.0.1
 */