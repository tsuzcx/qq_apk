package dov.com.qq.im.aeeditor.module.clip.image;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.util.AEQLog;

class AEImageCropperView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private AEImageCropperView$GestureListener(AEImageCropperView paramAEImageCropperView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!AEImageCropperView.a(this.a)) {}
    do
    {
      return false;
      if (AEImageCropperView.b(this.a))
      {
        AEQLog.d("AEImageCropperView", "Cropping current bitmap. Can't perform this action right now.");
        return false;
      }
    } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null) || (paramMotionEvent1.getPointerCount() > 1) || (paramMotionEvent2.getPointerCount() > 1));
    this.a.a(paramFloat1, paramFloat2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView.GestureListener
 * JD-Core Version:    0.7.0.1
 */