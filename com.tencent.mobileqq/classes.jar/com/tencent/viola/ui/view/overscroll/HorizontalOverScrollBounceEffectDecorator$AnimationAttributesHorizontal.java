package com.tencent.viola.ui.view.overscroll;

import android.animation.ValueAnimator;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.lang.ref.WeakReference;

public class HorizontalOverScrollBounceEffectDecorator$AnimationAttributesHorizontal
  extends AbsOverScrollDecorator.AnimationAttributes
{
  private WeakReference<HorizontalOverScrollBounceEffectDecorator> weakRef;
  
  public HorizontalOverScrollBounceEffectDecorator$AnimationAttributesHorizontal(HorizontalOverScrollBounceEffectDecorator paramHorizontalOverScrollBounceEffectDecorator)
  {
    this.mProperty = View.TRANSLATION_X;
    this.weakRef = new WeakReference(paramHorizontalOverScrollBounceEffectDecorator);
  }
  
  @RequiresApi(api=11)
  protected void init(View paramView)
  {
    this.mAbsOffset = paramView.getTranslationX();
    this.mMaxOffset = paramView.getWidth();
  }
  
  protected void onAnimationEnd()
  {
    HorizontalOverScrollBounceEffectDecorator localHorizontalOverScrollBounceEffectDecorator = (HorizontalOverScrollBounceEffectDecorator)this.weakRef.get();
    if (localHorizontalOverScrollBounceEffectDecorator != null) {
      localHorizontalOverScrollBounceEffectDecorator.onUpdate(null);
    }
  }
  
  protected void onUpdate(ValueAnimator paramValueAnimator)
  {
    HorizontalOverScrollBounceEffectDecorator localHorizontalOverScrollBounceEffectDecorator = (HorizontalOverScrollBounceEffectDecorator)this.weakRef.get();
    if (localHorizontalOverScrollBounceEffectDecorator != null) {
      localHorizontalOverScrollBounceEffectDecorator.onUpdate(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator.AnimationAttributesHorizontal
 * JD-Core Version:    0.7.0.1
 */