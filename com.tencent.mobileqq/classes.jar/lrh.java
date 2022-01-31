import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;
import com.tencent.av.ui.BeautySeekView;

public class lrh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public lrh(BeautySeekView paramBeautySeekView) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.a) && (BeautySeekView.a(this.a) != null) && (BeautySeekView.a(this.a).getWidth() > 0))
    {
      this.a.a = false;
      BeautySeekView.a(this.a, BeautySeekView.a(this.a).getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrh
 * JD-Core Version:    0.7.0.1
 */