package com.tencent.mobileqq.colornote.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class CircularRevealAnimator
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener a;
  private View b;
  
  private CircularRevealAnimator(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.b = paramView;
    setObjectValues(new Object[] { new CircularRevealAnimator.RevealCircle(paramFloat1, paramFloat2, paramFloat3), new CircularRevealAnimator.RevealCircle(paramFloat4, paramFloat5, paramFloat6) });
    setEvaluator(new CircularRevealAnimator.RevealCircleEvaluator(null));
    this.a = new CircularRevealAnimator.1(this, a(paramView));
    addUpdateListener(this.a);
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
    Object localObject = this.b.getParent();
    if ((localObject instanceof CircularRevealCompatLayout))
    {
      localObject = (CircularRevealCompatLayout)localObject;
      ((CircularRevealCompatLayout)localObject).removeView(this.b);
      ViewGroup localViewGroup = (ViewGroup)((CircularRevealCompatLayout)localObject).getParent();
      ViewGroup.LayoutParams localLayoutParams = ((CircularRevealCompatLayout)localObject).getLayoutParams();
      int i = localViewGroup.indexOfChild((View)localObject);
      localViewGroup.removeView((View)localObject);
      localViewGroup.addView(this.b, i, localLayoutParams);
    }
  }
  
  public void removeAllUpdateListeners()
  {
    super.removeAllUpdateListeners();
    addUpdateListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.CircularRevealAnimator
 * JD-Core Version:    0.7.0.1
 */