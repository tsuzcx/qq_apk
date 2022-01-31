import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class tfl
  extends GestureDetector.SimpleOnGestureListener
{
  tfl(tfk paramtfk) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    tlo.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    tfk.a(this.a, paramMotionEvent);
    tfk.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    tlo.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    tfk.a(this.a);
    tfk.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfl
 * JD-Core Version:    0.7.0.1
 */