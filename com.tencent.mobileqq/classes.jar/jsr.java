import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.av.widget.BidirectionSeekBar;

public class jsr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public jsr(BeautySettingUi paramBeautySettingUi) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.b) && (this.a.a != null) && (this.a.a.getWidth() > 0))
    {
      this.a.b = false;
      this.a.a(this.a.a.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsr
 * JD-Core Version:    0.7.0.1
 */