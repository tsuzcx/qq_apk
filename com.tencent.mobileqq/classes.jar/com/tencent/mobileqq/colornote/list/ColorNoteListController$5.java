package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ColorNoteListController$5
  extends D8SafeAnimatorListener
{
  ColorNoteListController$5(ColorNoteListController paramColorNoteListController, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorNoteListController.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).scrollTo(0, 0);
    ColorNoteListController.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).setAlpha(1.0F);
    ColorNoteListController.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).setBackgroundColor(ColorNoteListController.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).getResources().getColor(ColorNoteListController.a()));
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = -this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.getMeasuredWidth();
    } else {
      i = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.getMeasuredWidth();
    }
    paramAnimator.setX(i);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.setAlpha(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.5
 * JD-Core Version:    0.7.0.1
 */