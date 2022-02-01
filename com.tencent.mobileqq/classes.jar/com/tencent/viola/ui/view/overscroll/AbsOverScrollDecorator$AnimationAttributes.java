package com.tencent.viola.ui.view.overscroll;

import android.animation.ValueAnimator;
import android.util.Property;
import android.view.View;

public abstract class AbsOverScrollDecorator$AnimationAttributes
{
  public float mAbsOffset;
  public float mMaxOffset;
  public Property<View, Float> mProperty;
  
  protected abstract void init(View paramView);
  
  protected abstract void onAnimationEnd();
  
  protected abstract void onUpdate(ValueAnimator paramValueAnimator);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.AbsOverScrollDecorator.AnimationAttributes
 * JD-Core Version:    0.7.0.1
 */