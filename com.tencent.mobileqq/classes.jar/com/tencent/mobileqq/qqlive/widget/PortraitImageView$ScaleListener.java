package com.tencent.mobileqq.qqlive.widget;

import android.view.ScaleGestureDetector;

class PortraitImageView$ScaleListener
  extends PortraitImageView.SimpleOnScaleGestureListener
{
  PortraitImageView$ScaleListener(PortraitImageView paramPortraitImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.isInProgress())) {
      try
      {
        float f1 = this.a.getScale();
        float f2 = paramScaleGestureDetector.getScaleFactor();
        f1 = Math.min(this.a.a(), Math.max(f1 * f2, 0.1F));
        this.a.a(f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        this.a.invalidate();
        return true;
      }
      catch (IllegalArgumentException paramScaleGestureDetector)
      {
        paramScaleGestureDetector.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.PortraitImageView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */