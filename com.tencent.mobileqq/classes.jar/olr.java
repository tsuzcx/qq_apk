import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class olr
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<oiy> a;
  
  public olr(oiy paramoiy)
  {
    this.a = new WeakReference(paramoiy);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((oiy)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olr
 * JD-Core Version:    0.7.0.1
 */