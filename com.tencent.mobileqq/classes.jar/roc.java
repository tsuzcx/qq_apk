import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class roc
  extends GestureDetector.SimpleOnGestureListener
{
  roc(rob paramrob) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((rob.a(this.a) != null) && (rob.a(this.a).a != null)) {
      this.a.a.a(rob.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((rob.a(this.a) != null) && (rob.a(this.a).b != null)) {
      this.a.a.onClick(rob.a(this.a).b);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     roc
 * JD-Core Version:    0.7.0.1
 */