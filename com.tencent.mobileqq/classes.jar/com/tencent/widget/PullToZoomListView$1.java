package com.tencent.widget;

import android.view.animation.Interpolator;

final class PullToZoomListView$1
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.PullToZoomListView.1
 * JD-Core Version:    0.7.0.1
 */