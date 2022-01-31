package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;
import android.view.View;

public class HorizontalOverScrollBounceEffectDecorator
  extends AbsOverScrollDecorator
{
  public HorizontalOverScrollBounceEffectDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter)
  {
    this(paramIOverScrollDecoratorAdapter, 3.0F, 1.0F, -2.0F);
  }
  
  public HorizontalOverScrollBounceEffectDecorator(AbsOverScrollDecorator.IOverScrollDecoratorAdapter paramIOverScrollDecoratorAdapter, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramIOverScrollDecoratorAdapter, paramFloat1, paramFloat2, paramFloat3);
  }
  
  protected AbsOverScrollDecorator.AnimationAttributes createAnimationAttributes()
  {
    return new HorizontalOverScrollBounceEffectDecorator.AnimationAttributesHorizontal();
  }
  
  protected AbsOverScrollDecorator.MotionAttributes createMotionAttributes()
  {
    return new HorizontalOverScrollBounceEffectDecorator.MotionAttributesHorizontal();
  }
  
  protected void translateView(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  protected void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent)
  {
    paramView.setTranslationX(paramFloat);
    paramMotionEvent.offsetLocation(paramFloat - paramMotionEvent.getX(0), 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator
 * JD-Core Version:    0.7.0.1
 */