import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;
import com.tencent.av.ui.beauty.BeautySeekView;

public class mms
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public mms(BeautySeekView paramBeautySeekView) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.a) && (BeautySeekView.a(this.a) != null) && (BeautySeekView.a(this.a).getWidth() > 0))
    {
      this.a.a = false;
      BeautySeekView.a(this.a, BeautySeekView.a(this.a).getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mms
 * JD-Core Version:    0.7.0.1
 */