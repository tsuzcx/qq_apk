import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class okg
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<ohl> a;
  
  public okg(ohl paramohl)
  {
    this.a = new WeakReference(paramohl);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ohl)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okg
 * JD-Core Version:    0.7.0.1
 */