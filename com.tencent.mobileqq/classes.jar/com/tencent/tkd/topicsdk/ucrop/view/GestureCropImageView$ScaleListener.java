package com.tencent.tkd.topicsdk.ucrop.view;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

class GestureCropImageView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private GestureCropImageView$ScaleListener(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.b(paramScaleGestureDetector.getScaleFactor(), GestureCropImageView.a(this.a), GestureCropImageView.b(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.GestureCropImageView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */