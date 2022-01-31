import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.av.ui.BeautySettingUi;
import com.tencent.av.widget.BidirectionSeekBar;

public class jqn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public jqn(BeautySettingUi paramBeautySettingUi) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.b) && (this.a.a != null) && (this.a.a.getWidth() > 0))
    {
      this.a.b = false;
      this.a.a(this.a.a.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqn
 * JD-Core Version:    0.7.0.1
 */