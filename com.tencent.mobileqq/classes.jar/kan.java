import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.av.ui.VideoControlUI;

public class kan
  implements GestureDetector.OnGestureListener
{
  public kan(VideoControlUI paramVideoControlUI) {}
  
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
    if ((this.a.k != null) && (this.a.k.isShown()))
    {
      this.a.k.setVisibility(8);
      com.tencent.mobileqq.utils.AudioHelper.b = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kan
 * JD-Core Version:    0.7.0.1
 */