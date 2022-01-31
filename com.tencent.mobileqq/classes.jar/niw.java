import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;

public class niw
  implements View.OnTouchListener
{
  public niw(VideoCoverFragment paramVideoCoverFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      VideoCoverFragment.a(this.a).b();
      if (!this.a.a())
      {
        if (!VideoCoverFragment.a(this.a)) {
          break label47;
        }
        this.a.a(false);
      }
    }
    return false;
    label47:
    this.a.a(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */