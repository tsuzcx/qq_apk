package com.tencent.mobileqq.colornote.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class CircularRevealAnimator
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private View jdField_a_of_type_AndroidViewView;
  
  private CircularRevealAnimator(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    setObjectValues(new Object[] { new CircularRevealAnimator.RevealCircle(paramFloat1, paramFloat2, paramFloat3), new CircularRevealAnimator.RevealCircle(paramFloat4, paramFloat5, paramFloat6) });
    setEvaluator(new CircularRevealAnimator.RevealCircleEvaluator(null));
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new CircularRevealAnimator.1(this, a(paramView));
    addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
  }
  
  public static CircularRevealAnimator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    float f1 = paramInt1;
    float f2 = paramInt2;
    return new CircularRevealAnimator(paramView, f1, f2, paramFloat1, f1, f2, paramFloat2);
  }
  
  private CircularRevealCompatLayout a(View paramView)
  {
    if ((paramView instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup instanceof CircularRevealCompatLayout)) {
      return (CircularRevealCompatLayout)localViewGroup;
    }
    CircularRevealCompatLayout localCircularRevealCompatLayout = new CircularRevealCompatLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localCircularRevealCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
    localViewGroup.addView(localCircularRevealCompatLayout, i, localLayoutParams);
    return localCircularRevealCompatLayout;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getParent();
    if ((localObject instanceof CircularRevealCompatLayout))
    {
      localObject = (CircularRevealCompatLayout)localObject;
      ((CircularRevealCompatLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
      ViewGroup localViewGroup = (ViewGroup)((CircularRevealCompatLayout)localObject).getParent();
      ViewGroup.LayoutParams localLayoutParams = ((CircularRevealCompatLayout)localObject).getLayoutParams();
      int i = localViewGroup.indexOfChild((View)localObject);
      localViewGroup.removeView((View)localObject);
      localViewGroup.addView(this.jdField_a_of_type_AndroidViewView, i, localLayoutParams);
    }
  }
  
  public void removeAllUpdateListeners()
  {
    super.removeAllUpdateListeners();
    addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.CircularRevealAnimator
 * JD-Core Version:    0.7.0.1
 */