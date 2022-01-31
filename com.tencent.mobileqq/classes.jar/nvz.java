import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class nvz
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<ntd> a;
  
  public nvz(ntd paramntd)
  {
    this.a = new WeakReference(paramntd);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ntd)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvz
 * JD-Core Version:    0.7.0.1
 */