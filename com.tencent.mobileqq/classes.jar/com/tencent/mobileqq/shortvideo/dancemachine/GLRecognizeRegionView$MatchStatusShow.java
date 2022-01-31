package com.tencent.mobileqq.shortvideo.dancemachine;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

public class GLRecognizeRegionView$MatchStatusShow
  implements Animation.AnimationListener
{
  int jdField_a_of_type_Int;
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  boolean jdField_a_of_type_Boolean;
  AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  boolean jdField_b_of_type_Boolean;
  AnimationSet jdField_c_of_type_AndroidViewAnimationAnimationSet;
  boolean jdField_c_of_type_Boolean;
  
  GLRecognizeRegionView$MatchStatusShow()
  {
    a();
  }
  
  private AnimationSet d()
  {
    this.jdField_c_of_type_AndroidViewAnimationAnimationSet = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidViewAnimationAnimationSet == null) {
        this.jdField_c_of_type_Boolean = true;
      }
      return this.jdField_c_of_type_AndroidViewAnimationAnimationSet;
      this.jdField_c_of_type_AndroidViewAnimationAnimationSet = null;
      continue;
      this.jdField_c_of_type_AndroidViewAnimationAnimationSet = f();
      continue;
      this.jdField_c_of_type_AndroidViewAnimationAnimationSet = g();
    }
  }
  
  private AnimationSet e()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(3.0F, 1.0F, 3.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setStartOffset(500L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setStartOffset(500L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  private AnimationSet f()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setStartOffset(500L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setStartOffset(500L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  private AnimationSet g()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(3.0F, 1.5F, 3.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(100L);
    ((AlphaAnimation)localObject).setStartOffset(500L);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.5F, 2.5F, 1.5F, 0.05F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(100L);
    ((ScaleAnimation)localObject).setStartOffset(500L);
    ((ScaleAnimation)localObject).setFillEnabled(true);
    ((ScaleAnimation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  AnimationSet a()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(100L);
    localAlphaAnimation.setStartOffset(500L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillBefore(false);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(this);
    return localAnimationSet;
  }
  
  String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "unKnown";
    case 0: 
      return "MISS";
    case 1: 
      return "GOOD";
    case 2: 
      return "GREAT";
    }
    return "PERFECT";
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimationSet = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean);
  }
  
  AnimationSet b()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = a();
    return this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
  }
  
  String b()
  {
    return " haveMongolianStop=" + this.jdField_a_of_type_Boolean + " haveBackgroundStop=" + this.jdField_b_of_type_Boolean + " haveTypefaceStop=" + this.jdField_c_of_type_Boolean;
  }
  
  void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  AnimationSet c()
  {
    this.jdField_b_of_type_AndroidViewAnimationAnimationSet = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null) {
        this.jdField_b_of_type_Boolean = true;
      }
      return this.jdField_b_of_type_AndroidViewAnimationAnimationSet;
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = e();
      continue;
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = a();
      continue;
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = a();
      continue;
      this.jdField_b_of_type_AndroidViewAnimationAnimationSet = a();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == paramAnimation) {
      this.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == paramAnimation)
      {
        this.jdField_b_of_type_Boolean = true;
        return;
      }
    } while (this.jdField_c_of_type_AndroidViewAnimationAnimationSet != paramAnimation);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView.MatchStatusShow
 * JD-Core Version:    0.7.0.1
 */