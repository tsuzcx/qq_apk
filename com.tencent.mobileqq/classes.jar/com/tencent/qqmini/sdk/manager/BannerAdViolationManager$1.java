package com.tencent.qqmini.sdk.manager;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class BannerAdViolationManager$1
  implements View.OnTouchListener
{
  BannerAdViolationManager$1(float[] paramArrayOfFloat) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.val$lastTouchDownXY[0] = paramMotionEvent.getX();
      this.val$lastTouchDownXY[1] = paramMotionEvent.getY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BannerAdViolationManager.1
 * JD-Core Version:    0.7.0.1
 */