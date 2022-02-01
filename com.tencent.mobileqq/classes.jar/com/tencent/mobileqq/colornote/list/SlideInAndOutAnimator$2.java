package com.tencent.mobileqq.colornote.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

class SlideInAndOutAnimator$2
  extends AnimatorListenerAdapter
{
  SlideInAndOutAnimator$2(SlideInAndOutAnimator paramSlideInAndOutAnimator, RecyclerView.ViewHolder paramViewHolder, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewViewPropertyAnimator.setListener(null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator.dispatchAddFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    SlideInAndOutAnimator.b(this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    SlideInAndOutAnimator.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator.dispatchAddStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.SlideInAndOutAnimator.2
 * JD-Core Version:    0.7.0.1
 */