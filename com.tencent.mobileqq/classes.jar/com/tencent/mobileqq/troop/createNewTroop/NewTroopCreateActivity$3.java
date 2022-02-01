package com.tencent.mobileqq.troop.createNewTroop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView;

class NewTroopCreateActivity$3
  extends AnimatorListenerAdapter
{
  NewTroopCreateActivity$3(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiAbsNewTroopBaseView.a(this.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity.3
 * JD-Core Version:    0.7.0.1
 */