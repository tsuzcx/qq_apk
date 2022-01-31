import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class pzz
  extends GestureDetector.SimpleOnGestureListener
{
  pzz(pzy parampzy) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((pzy.a(this.a) != null) && (pzy.a(this.a).a != null)) {
      this.a.a.a(pzy.a(this.a).a, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((pzy.a(this.a) != null) && (pzy.a(this.a).d != null)) {
      this.a.a.onClick(pzy.a(this.a).d);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzz
 * JD-Core Version:    0.7.0.1
 */