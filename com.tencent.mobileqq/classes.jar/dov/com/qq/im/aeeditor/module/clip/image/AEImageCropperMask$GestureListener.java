package dov.com.qq.im.aeeditor.module.clip.image;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.util.AEQLog;

class AEImageCropperMask$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private AEImageCropperMask$GestureListener(AEImageCropperMask paramAEImageCropperMask) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!AEImageCropperMask.a(this.a)) {}
    do
    {
      do
      {
        return false;
        if (AEImageCropperMask.b(this.a))
        {
          AEQLog.d("CropperGridView", "Cropping current bitmap. Can't perform this action right now.");
          return false;
        }
      } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null) || (paramMotionEvent1.getPointerCount() > 1) || (paramMotionEvent2.getPointerCount() > 1));
      if (AEImageCropperMask.c(this.a))
      {
        AEImageCropperMask.a(this.a, paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        return false;
      }
    } while (!AEImageCropperMask.d(this.a));
    AEImageCropperMask.a(this.a, paramFloat1, paramFloat2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperMask.GestureListener
 * JD-Core Version:    0.7.0.1
 */