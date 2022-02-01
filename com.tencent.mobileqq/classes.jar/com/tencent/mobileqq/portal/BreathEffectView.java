package com.tencent.mobileqq.portal;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class BreathEffectView
  extends ImageView
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  
  public BreathEffectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BreathEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BreathEffectView", 2, "yure yellow");
    }
    g();
    setImageResource(2130845275);
    d();
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BreathEffectView", 2, "formal red");
    }
    g();
    setImageResource(2130845276);
    d();
    this.jdField_a_of_type_Int = 2;
  }
  
  public void c()
  {
    g();
    setImageResource(2130846860);
    e();
  }
  
  public void d()
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    localAlphaAnimation.setAnimationListener(this);
    localAlphaAnimation.setRepeatMode(2);
    localAlphaAnimation.setDuration(1300L);
    localAlphaAnimation.setRepeatCount(-1);
    startAnimation(localAlphaAnimation);
  }
  
  public void e()
  {
    setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F, 0.5F, 1.0F, 0.0F });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.addUpdateListener(new BreathEffectView.1(this));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(4000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(0);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  public void f()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null)
    {
      localObjectAnimator.end();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
  }
  
  public void g()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null)
    {
      localAnimation.setAnimationListener(null);
      setAnimation(null);
      clearAnimation();
    }
    setImageDrawable(null);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.BreathEffectView
 * JD-Core Version:    0.7.0.1
 */