import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.av.ui.VideoControlUI;

public class mju
  implements GestureDetector.OnGestureListener
{
  public mju(VideoControlUI paramVideoControlUI) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.a.g != null) && (this.a.g.isShown())) {
      this.a.r(false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mju
 * JD-Core Version:    0.7.0.1
 */