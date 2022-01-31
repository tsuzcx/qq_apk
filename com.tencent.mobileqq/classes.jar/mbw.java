import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;
import com.tencent.av.ui.BeautyToolbar;

public class mbw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public mbw(BeautyToolbar paramBeautyToolbar) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.mIs1stShow) && (this.a.mSeek != null) && (this.a.mSeek.getWidth() > 0))
    {
      this.a.mIs1stShow = false;
      this.a.updateTip(this.a.mSeek.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbw
 * JD-Core Version:    0.7.0.1
 */