package dov.com.qq.im.aeeditor.module.clip.image;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import dov.com.qq.im.ae.util.AEQLog;

class AEImageCropperView$ScaleListener
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private AEImageCropperView$ScaleListener(AEImageCropperView paramAEImageCropperView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!AEImageCropperView.a(this.a)) {}
    while (AEImageCropperView.a(this.a) == 0) {
      return false;
    }
    if (AEImageCropperView.b(this.a))
    {
      AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't perform this action right now.");
      return false;
    }
    Matrix localMatrix = this.a.getImageMatrix();
    AEImageCropperView.a(this.a, paramScaleGestureDetector.getFocusX());
    AEImageCropperView.b(this.a, paramScaleGestureDetector.getFocusY());
    localMatrix.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    this.a.setImageMatrix(localMatrix);
    this.a.invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView.ScaleListener
 * JD-Core Version:    0.7.0.1
 */