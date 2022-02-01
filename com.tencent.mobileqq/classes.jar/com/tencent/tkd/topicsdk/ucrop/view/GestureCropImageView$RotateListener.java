package com.tencent.tkd.topicsdk.ucrop.view;

import com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector;
import com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener;

class GestureCropImageView$RotateListener
  extends RotationGestureDetector.SimpleOnRotationGestureListener
{
  private GestureCropImageView$RotateListener(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean a(RotationGestureDetector paramRotationGestureDetector)
  {
    this.a.c(paramRotationGestureDetector.a(), GestureCropImageView.a(this.a), GestureCropImageView.b(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.GestureCropImageView.RotateListener
 * JD-Core Version:    0.7.0.1
 */