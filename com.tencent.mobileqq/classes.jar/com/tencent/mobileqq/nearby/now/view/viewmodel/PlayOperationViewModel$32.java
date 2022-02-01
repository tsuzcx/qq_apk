package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;

class PlayOperationViewModel$32
  extends AnimatorListenerAdapter
{
  PlayOperationViewModel$32(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367295).setVisibility(8);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367274).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367294).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367300).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    int i = this.a.jdField_b_of_type_Int;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367293).setBackgroundResource(2130845718);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367293).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367292).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.32
 * JD-Core Version:    0.7.0.1
 */