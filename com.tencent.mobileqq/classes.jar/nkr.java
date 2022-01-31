import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class nkr
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<nhw> a;
  
  public nkr(nhw paramnhw)
  {
    this.a = new WeakReference(paramnhw);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nhw)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkr
 * JD-Core Version:    0.7.0.1
 */