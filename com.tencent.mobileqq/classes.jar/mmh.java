import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.av.ui.VideoControlUI;
import java.lang.ref.WeakReference;

public class mmh
  implements View.OnTouchListener
{
  WeakReference<VideoControlUI> a;
  
  public mmh(VideoControlUI paramVideoControlUI)
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
      paramView.C(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mmh
 * JD-Core Version:    0.7.0.1
 */