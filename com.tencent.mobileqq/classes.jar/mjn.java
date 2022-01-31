import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.VideoControlUI;
import java.lang.ref.WeakReference;

public class mjn
  implements View.OnTouchListener
{
  WeakReference<VideoControlUI> a;
  
  public mjn(VideoControlUI paramVideoControlUI)
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
      paramView.z(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjn
 * JD-Core Version:    0.7.0.1
 */