package com.tencent.mobileqq.kandian.biz.video.view;

import android.view.animation.Interpolator;

final class ReadInJoyPullToZoomListView$1
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.ReadInJoyPullToZoomListView.1
 * JD-Core Version:    0.7.0.1
 */