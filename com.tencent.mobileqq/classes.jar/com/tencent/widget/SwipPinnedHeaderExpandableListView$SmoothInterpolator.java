package com.tencent.widget;

import android.view.animation.Interpolator;

public class SwipPinnedHeaderExpandableListView$SmoothInterpolator
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.SwipPinnedHeaderExpandableListView.SmoothInterpolator
 * JD-Core Version:    0.7.0.1
 */