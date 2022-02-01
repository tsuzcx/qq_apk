package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;

class ColorNoteListController$5
  implements Animator.AnimatorListener
{
  ColorNoteListController$5(ColorNoteListController paramColorNoteListController, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ColorNoteListController.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).scrollTo(0, 0);
    ColorNoteListController.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).setAlpha(1.0F);
    ColorNoteListController.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).setBackgroundColor(ColorNoteListController.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController).getResources().getColor(ColorNoteListController.a()));
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.getMeasuredWidth();; f = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.getMeasuredWidth())
    {
      paramAnimator.setX(f);
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.setAlpha(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a.animate().setInterpolator(new DecelerateInterpolator()).alpha(1.0F).translationX(0.0F).setDuration(180L).start();
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListController.5
 * JD-Core Version:    0.7.0.1
 */