package com.tencent.widget.itemtouchhelper;

import android.view.animation.Interpolator;

final class ItemTouchHelper$Callback$2
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback.2
 * JD-Core Version:    0.7.0.1
 */