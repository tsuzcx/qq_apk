import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.VideoControlUI;
import java.lang.ref.WeakReference;

public class kap
  implements View.OnTouchListener
{
  WeakReference a;
  
  public kap(VideoControlUI paramVideoControlUI)
  {
    this.a = new WeakReference(paramVideoControlUI);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (VideoControlUI)this.a.get();
    if (paramView != null) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      paramView.ad();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kap
 * JD-Core Version:    0.7.0.1
 */