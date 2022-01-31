import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class qlw
  extends GestureDetector.SimpleOnGestureListener
{
  qlw(qlv paramqlv) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((qlv.a(this.a) != null) && (qlv.a(this.a).a != null)) {
      this.a.a.a(qlv.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((qlv.a(this.a) != null) && (qlv.a(this.a).d != null)) {
      this.a.a.onClick(qlv.a(this.a).d);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlw
 * JD-Core Version:    0.7.0.1
 */