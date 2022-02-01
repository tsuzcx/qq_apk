import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class oto
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<oqu> a;
  
  public oto(oqu paramoqu)
  {
    this.a = new WeakReference(paramoqu);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oqu)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oto
 * JD-Core Version:    0.7.0.1
 */