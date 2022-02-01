package com.tencent.mobileqq.utils;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

final class SimpleModeHelper$2
  extends GestureDetector.SimpleOnGestureListener
{
  float a = this.b.getAlpha();
  
  SimpleModeHelper$2(View paramView) {}
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    SimpleModeHelper.c = true;
    if (!SimpleModeHelper.b) {
      this.b.setAlpha(this.a / 2.0F);
    }
    super.onShowPress(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SimpleModeHelper.2
 * JD-Core Version:    0.7.0.1
 */