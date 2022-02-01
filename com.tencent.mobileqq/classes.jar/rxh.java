import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class rxh
  extends GestureDetector.SimpleOnGestureListener
{
  rxh(rxg paramrxg) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((rxg.a(this.a) != null) && (rxg.a(this.a).a != null)) {
      this.a.a.a(rxg.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((rxg.a(this.a) != null) && (rxg.a(this.a).b != null)) {
      this.a.a.onClick(rxg.a(this.a).b);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxh
 * JD-Core Version:    0.7.0.1
 */