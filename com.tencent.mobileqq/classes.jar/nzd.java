import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class nzd
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<nwi> a;
  
  public nzd(nwi paramnwi)
  {
    this.a = new WeakReference(paramnwi);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((nwi)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nzd
 * JD-Core Version:    0.7.0.1
 */