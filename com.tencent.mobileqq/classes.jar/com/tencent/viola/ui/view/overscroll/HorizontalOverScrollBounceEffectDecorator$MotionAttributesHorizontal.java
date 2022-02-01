package com.tencent.viola.ui.view.overscroll;

import android.view.MotionEvent;
import android.view.View;

public class HorizontalOverScrollBounceEffectDecorator$MotionAttributesHorizontal
  extends AbsOverScrollDecorator.MotionAttributes
{
  public boolean init(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getHistorySize();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    float f1 = paramMotionEvent.getY(0);
    float f2 = paramMotionEvent.getHistoricalY(0, 0);
    float f3 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
    if (Math.abs(f3) < Math.abs(f1 - f2)) {
      return false;
    }
    this.mAbsOffset = paramView.getTranslationX();
    this.mDeltaOffset = f3;
    if (this.mDeltaOffset > 0.0F) {
      bool = true;
    }
    this.mDir = bool;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.overscroll.HorizontalOverScrollBounceEffectDecorator.MotionAttributesHorizontal
 * JD-Core Version:    0.7.0.1
 */