import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.SeekBar;
import com.tencent.av.ui.BeautyToolbar;

public class mco
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public mco(BeautyToolbar paramBeautyToolbar) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.mIs1stShow) && (this.a.mSeek != null) && (this.a.mSeek.getWidth() > 0))
    {
      this.a.mIs1stShow = false;
      this.a.updateTip(this.a.mSeek.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mco
 * JD-Core Version:    0.7.0.1
 */