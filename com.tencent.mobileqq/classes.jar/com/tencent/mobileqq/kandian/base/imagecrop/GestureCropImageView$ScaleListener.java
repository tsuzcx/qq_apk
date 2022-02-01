package com.tencent.mobileqq.kandian.base.imagecrop;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

class GestureCropImageView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private GestureCropImageView$ScaleListener(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.a(paramScaleGestureDetector.getScaleFactor(), GestureCropImageView.a(this.a), GestureCropImageView.b(this.a), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.GestureCropImageView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */