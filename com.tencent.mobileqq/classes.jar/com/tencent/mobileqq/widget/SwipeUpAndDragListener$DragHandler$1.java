package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.pic.Logger;

class SwipeUpAndDragListener$DragHandler$1
  implements Animation.AnimationListener
{
  SwipeUpAndDragListener$DragHandler$1(SwipeUpAndDragListener.DragHandler paramDragHandler, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new StringBuilder();
    paramAnimation.append(" flyOutAnimation End fAnimLayout:");
    paramAnimation.append(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.jdField_b_of_type_AndroidWidgetRelativeLayout);
    paramAnimation.append(",## dy = ");
    paramAnimation.append(this.jdField_a_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener.b);
    Logger.a("PhotoListPanel", "DragHandler", paramAnimation.toString());
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.d.getLayoutParams();
    paramAnimation.topMargin = this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.e.topMargin;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.d.setLayoutParams(paramAnimation);
    paramAnimation = new AnimationSet(false);
    Object localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.d.getWidth() / 2, this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.d.getHeight() / 2);
    paramAnimation.addAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    paramAnimation.addAnimation((Animation)localObject);
    paramAnimation.setDuration(200L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.d.startAnimation(paramAnimation);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startReemergeAnimation fAnimLayout:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.jdField_b_of_type_AndroidWidgetRelativeLayout);
    Logger.a("PhotoListPanel", "DragHandler", ((StringBuilder)localObject).toString());
    paramAnimation.setAnimationListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSwipeUpAndDragListener$DragHandler.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Logger.a("PhotoListPanel", "DragHandler", "@#flyOutAnimation, onAnimationStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.DragHandler.1
 * JD-Core Version:    0.7.0.1
 */