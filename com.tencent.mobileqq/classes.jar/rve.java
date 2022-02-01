import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class rve
  extends GestureDetector.SimpleOnGestureListener
{
  rve(rvd paramrvd) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((rvd.a(this.a) != null) && (rvd.a(this.a).a != null)) {
      this.a.a.a(rvd.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((rvd.a(this.a) != null) && (rvd.a(this.a).b != null)) {
      this.a.a.onClick(rvd.a(this.a).b);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rve
 * JD-Core Version:    0.7.0.1
 */