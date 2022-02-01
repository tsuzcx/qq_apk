package com.tencent.mobileqq.guild.animate;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class RectangleRevealAnimator
  extends ValueAnimator
{
  private ValueAnimator.AnimatorUpdateListener a;
  
  public RectangleRevealAnimator(View paramView, Rect paramRect1, float paramFloat1, Rect paramRect2, float paramFloat2)
  {
    setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("top", new float[] { paramRect1.top, paramRect2.top }), PropertyValuesHolder.ofFloat("left", new float[] { paramRect1.left, paramRect2.left }), PropertyValuesHolder.ofFloat("width", new float[] { paramRect1.width(), paramRect2.width() }), PropertyValuesHolder.ofFloat("height", new float[] { paramRect1.height(), paramRect2.height() }), PropertyValuesHolder.ofFloat("radius", new float[] { paramFloat1, paramFloat2 }) });
    this.a = new RectangleRevealAnimator.1(this, a(paramView));
    addUpdateListener(this.a);
  }
  
  private RectangleClipCompatLayout a(View paramView)
  {
    if ((paramView instanceof RectangleClipCompatLayout)) {
      return (RectangleClipCompatLayout)paramView;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup instanceof RectangleClipCompatLayout)) {
      return (RectangleClipCompatLayout)localViewGroup;
    }
    RectangleClipCompatLayout localRectangleClipCompatLayout = new RectangleClipCompatLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localRectangleClipCompatLayout.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
    localViewGroup.addView(localRectangleClipCompatLayout, i, localLayoutParams);
    return localRectangleClipCompatLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.RectangleRevealAnimator
 * JD-Core Version:    0.7.0.1
 */