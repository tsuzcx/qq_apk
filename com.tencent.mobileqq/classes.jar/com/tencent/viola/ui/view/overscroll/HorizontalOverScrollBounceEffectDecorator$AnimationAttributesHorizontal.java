package com.tencent.viola.ui.view.overscroll;

import android.support.annotation.RequiresApi;
import android.view.View;

public class HorizontalOverScrollBounceEffectDecorator$AnimationAttributesHorizontal
  extends AbsOverScrollDecorator.AnimationAttributes
{
  public HorizontalOverScrollBounceEffectDecorator$AnimationAttributesHorizontal()
  {
    this.mProperty = View.TRANSLATION_X;
  }
  
  @RequiresApi(api=11)
  protected void init(View paramView)
  {
    this.mAbsOffset = paramView.getTranslationX();
    this.mMaxOffset = paramView.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator.AnimationAttributesHorizontal
 * JD-Core Version:    0.7.0.1
 */