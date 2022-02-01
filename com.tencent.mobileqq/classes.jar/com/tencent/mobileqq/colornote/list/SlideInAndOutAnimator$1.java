package com.tencent.mobileqq.colornote.list;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;

class SlideInAndOutAnimator$1
  implements ViewPropertyAnimatorListener
{
  SlideInAndOutAnimator$1(SlideInAndOutAnimator paramSlideInAndOutAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat) {}
  
  public void onAnimationCancel(View paramView) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPropertyAnimatorCompat.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator.dispatchRemoveFinished(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    SlideInAndOutAnimator.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator).remove(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
    SlideInAndOutAnimator.a(this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteListSlideInAndOutAnimator.dispatchRemoveStarting(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.SlideInAndOutAnimator.1
 * JD-Core Version:    0.7.0.1
 */