package dov.com.qq.im.ae.biz.qcircle.widget;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class CustomGestureDetector$1
  implements ScaleGestureDetector.OnScaleGestureListener
{
  CustomGestureDetector$1(CustomGestureDetector paramCustomGestureDetector) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {
      return false;
    }
    if (f >= 0.0F) {
      CustomGestureDetector.a(this.a).a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector.getScaleFactor();
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector.getScaleFactor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.CustomGestureDetector.1
 * JD-Core Version:    0.7.0.1
 */