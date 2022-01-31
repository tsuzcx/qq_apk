import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.GestureCropImageView;

public class shk
  extends GestureDetector.SimpleOnGestureListener
{
  private shk(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (GestureCropImageView.a(this.a)) {
      this.a.a(this.a.c(), paramMotionEvent.getX(), paramMotionEvent.getY(), 200L);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.a.a(-paramFloat1, -paramFloat2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     shk
 * JD-Core Version:    0.7.0.1
 */