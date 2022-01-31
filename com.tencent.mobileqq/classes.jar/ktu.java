import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;

public class ktu
  implements View.OnTouchListener
{
  public ktu(VideoCoverFragment paramVideoCoverFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      VideoCoverFragment.a(this.a).b();
      if (VideoCoverFragment.a(this.a)) {
        this.a.a(false);
      }
    }
    else
    {
      return false;
    }
    this.a.a(true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktu
 * JD-Core Version:    0.7.0.1
 */