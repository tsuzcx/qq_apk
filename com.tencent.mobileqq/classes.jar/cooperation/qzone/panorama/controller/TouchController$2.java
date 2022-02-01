package cooperation.qzone.panorama.controller;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;

class TouchController$2
  implements ScaleGestureDetector.OnScaleGestureListener
{
  TouchController$2(TouchController paramTouchController) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    TouchController.access$302(this.this$0, 1.0F - f + TouchController.access$300(this.this$0));
    if (TouchController.access$400(this.this$0) == 0) {
      TouchController.access$302(this.this$0, Math.max(TouchController.access$500(this.this$0), Math.min(1.5F, TouchController.access$300(this.this$0))));
    }
    for (;;)
    {
      TouchController.access$102(this.this$0, TouchController.access$300(this.this$0) / TouchController.access$600(this.this$0));
      if (TouchController.access$700(this.this$0) != null) {
        TouchController.access$700(this.this$0).onTouchScale(TouchController.access$300(this.this$0));
      }
      return true;
      TouchController.access$302(this.this$0, Math.max(TouchController.access$500(this.this$0), Math.min(1.0F, TouchController.access$300(this.this$0))));
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController.2
 * JD-Core Version:    0.7.0.1
 */