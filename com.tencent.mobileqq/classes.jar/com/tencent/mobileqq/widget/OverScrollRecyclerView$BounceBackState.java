package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class OverScrollRecyclerView$BounceBackState
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, OverScrollRecyclerView.IDecoratorState
{
  protected final float a;
  protected final Interpolator a;
  protected final OverScrollRecyclerView.AnimationAttributes a;
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  protected final float b;
  
  public OverScrollRecyclerView$BounceBackState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager, float paramFloat)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager = paramOverScrollStateManager;
    this.jdField_a_of_type_Float = paramFloat;
    this.b = (2.0F * paramFloat);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes = new OverScrollRecyclerView.AnimationAttributes();
  }
  
  protected Animator a()
  {
    float f1 = 0.0F;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$IOverScrollDecor;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStartAttributes;
    float f3 = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_Float;
    ((OverScrollRecyclerView.IOverScrollDecor)localObject2).a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes);
    if ((f3 == 0.0F) || ((f3 < 0.0F) && (((OverScrollRecyclerView.OverScrollStartAttributes)localObject3).jdField_a_of_type_Boolean)) || ((f3 > 0.0F) && (!((OverScrollRecyclerView.OverScrollStartAttributes)localObject3).jdField_a_of_type_Boolean))) {
      return a(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes.jdField_a_of_type_Float);
    }
    float f2 = -f3 / this.jdField_a_of_type_Float;
    if (f2 < 0.0F) {}
    for (;;)
    {
      f2 = -f3 * f3 / this.b + this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes.jdField_a_of_type_Float;
      localObject1 = a((View)localObject1, (int)f1, f2);
      localObject2 = a(f2);
      localObject3 = new AnimatorSet();
      ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject1, localObject2 });
      return localObject3;
      f1 = f2;
    }
  }
  
  protected ObjectAnimator a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.a();
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStartAttributes;
    paramFloat = Math.abs(paramFloat) / this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes.b;
    localObject = ObjectAnimator.ofFloat(localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes.jdField_a_of_type_AndroidUtilProperty, new float[] { localOverScrollStartAttributes.jdField_a_of_type_Float });
    ((ObjectAnimator)localObject).setDuration(Math.max((int)(paramFloat * 800.0F), 200));
    ((ObjectAnimator)localObject).setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    ((ObjectAnimator)localObject).addUpdateListener(this);
    return localObject;
  }
  
  protected ObjectAnimator a(View paramView, int paramInt, float paramFloat)
  {
    paramView = ObjectAnimator.ofFloat(paramView, this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$AnimationAttributes.jdField_a_of_type_AndroidUtilProperty, new float[] { paramFloat });
    paramView.setDuration(paramInt);
    paramView.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    paramView.addUpdateListener(this);
    return paramView;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    paramIDecoratorState = a();
    paramIDecoratorState.addListener(this);
    paramIDecoratorState.start();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$OverScrollStateManager.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView$IdleState);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.BounceBackState
 * JD-Core Version:    0.7.0.1
 */