import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.PoiMapActivity;

public class kiy
  extends GestureDetector.SimpleOnGestureListener
{
  public kiy(PoiMapActivity paramPoiMapActivity) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a.j();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kiy
 * JD-Core Version:    0.7.0.1
 */