package com.tencent.viola.ui.view.overscroll;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

public class HorizontalOverScrollBounceEffectDecorator
  extends AbsOverScrollDecorator
{
  private OverScrollHelper.OverScrollListener overScrollListener;
  
  public HorizontalOverScrollBounceEffectDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, float paramFloat1, float paramFloat2, float paramFloat3, OverScrollHelper.OverScrollListener paramOverScrollListener)
  {
    super(paramIOverScrollDecoratorAdapter, paramFloat1, paramFloat2, paramFloat3);
    this.overScrollListener = paramOverScrollListener;
  }
  
  public HorizontalOverScrollBounceEffectDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, OverScrollHelper.OverScrollListener paramOverScrollListener)
  {
    this(paramIOverScrollDecoratorAdapter, 3.0F, 1.0F, -2.0F, paramOverScrollListener);
  }
  
  protected AbsOverScrollDecorator.AnimationAttributes createAnimationAttributes()
  {
    return new HorizontalOverScrollBounceEffectDecorator.AnimationAttributesHorizontal(this);
  }
  
  protected AbsOverScrollDecorator.MotionAttributes createMotionAttributes()
  {
    return new HorizontalOverScrollBounceEffectDecorator.MotionAttributesHorizontal();
  }
  
  void onUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.overScrollListener == null) {
      return;
    }
    if (paramValueAnimator != null) {}
    for (float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();; f = 0.0F)
    {
      this.overScrollListener.onOverScroll(f);
      return;
    }
  }
  
  protected void translateView(View paramView, float paramFloat)
  {
    if (this.overScrollListener != null) {
      this.overScrollListener.onOverScroll(paramFloat);
    }
    paramView.setTranslationX(paramFloat);
  }
  
  protected void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent)
  {
    paramView.setTranslationX(paramFloat);
    paramMotionEvent.offsetLocation(paramFloat - paramMotionEvent.getX(0), 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator
 * JD-Core Version:    0.7.0.1
 */