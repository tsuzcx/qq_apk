import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class oiy
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<ogd> a;
  
  public oiy(ogd paramogd)
  {
    this.a = new WeakReference(paramogd);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ogd)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oiy
 * JD-Core Version:    0.7.0.1
 */