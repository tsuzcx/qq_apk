package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;
import android.view.View;

public class HorizontalOverScrollBounceEffectDecorator$MotionAttributesHorizontal
  extends AbsOverScrollDecorator.MotionAttributes
{
  public boolean init(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (paramMotionEvent.getHistorySize() == 0) {}
    float f1;
    float f2;
    float f3;
    do
    {
      return false;
      f1 = paramMotionEvent.getY(0);
      f2 = paramMotionEvent.getHistoricalY(0, 0);
      f3 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
    } while (Math.abs(f3) < Math.abs(f1 - f2));
    this.mAbsOffset = paramView.getTranslationX();
    this.mDeltaOffset = f3;
    if (this.mDeltaOffset > 0.0F) {
      bool = true;
    }
    this.mDir = bool;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator.MotionAttributesHorizontal
 * JD-Core Version:    0.7.0.1
 */