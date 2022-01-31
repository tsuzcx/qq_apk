import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class rbe
  extends GestureDetector.SimpleOnGestureListener
{
  rbe(rbd paramrbd) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((rbd.a(this.a) != null) && (rbd.a(this.a).a != null)) {
      this.a.a.a(rbd.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((rbd.a(this.a) != null) && (rbd.a(this.a).d != null)) {
      this.a.a.onClick(rbd.a(this.a).d);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbe
 * JD-Core Version:    0.7.0.1
 */