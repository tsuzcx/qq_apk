package com.tencent.tkd.topicsdk.ucrop.handler;

import com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector;
import com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener;

class GestureCropHandler$RotateListener
  extends RotationGestureDetector.SimpleOnRotationGestureListener
{
  private GestureCropHandler$RotateListener(GestureCropHandler paramGestureCropHandler) {}
  
  public boolean a(RotationGestureDetector paramRotationGestureDetector)
  {
    this.a.c(paramRotationGestureDetector.a(), GestureCropHandler.a(this.a), GestureCropHandler.b(this.a));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler.RotateListener
 * JD-Core Version:    0.7.0.1
 */