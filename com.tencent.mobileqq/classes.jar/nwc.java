import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class nwc
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<ntg> a;
  
  public nwc(ntg paramntg)
  {
    this.a = new WeakReference(paramntg);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ntg)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwc
 * JD-Core Version:    0.7.0.1
 */