package dov.com.qq.im.ae;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;

public class AEPituCameraUnit$AEGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  protected AEPituCameraUnit$AEGestureListener(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((!this.a.g()) && (System.currentTimeMillis() - AEPituCameraUnit.a(this.a) > 5000L))
    {
      this.a.a.a(196614, new Object[0]);
      AEPituCameraUnit.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.AEGestureListener
 * JD-Core Version:    0.7.0.1
 */