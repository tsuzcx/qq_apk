import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;

public class nls
  implements View.OnTouchListener
{
  public nls(VideoCoverFragment paramVideoCoverFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nls
 * JD-Core Version:    0.7.0.1
 */