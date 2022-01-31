import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.av.ui.BeautyToolbar;
import com.tencent.av.widget.BidirectionSeekBar;

public class jsx
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public jsx(BeautyToolbar paramBeautyToolbar) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.mIs1stShow) && (this.a.mSeek != null) && (this.a.mSeek.getWidth() > 0))
    {
      this.a.mIs1stShow = false;
      this.a.updateTip(this.a.mSeek.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsx
 * JD-Core Version:    0.7.0.1
 */