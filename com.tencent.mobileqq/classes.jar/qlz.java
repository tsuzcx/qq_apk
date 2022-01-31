import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class qlz
  extends GestureDetector.SimpleOnGestureListener
{
  qlz(qly paramqly) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((qly.a(this.a) != null) && (qly.a(this.a).a != null)) {
      this.a.a.a(qly.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((qly.a(this.a) != null) && (qly.a(this.a).d != null)) {
      this.a.a.onClick(qly.a(this.a).d);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlz
 * JD-Core Version:    0.7.0.1
 */