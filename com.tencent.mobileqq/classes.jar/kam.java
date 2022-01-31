import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.VideoControlUI;

public class kam
  implements View.OnTouchListener
{
  public kam(VideoControlUI paramVideoControlUI) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      return this.a.a.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kam
 * JD-Core Version:    0.7.0.1
 */