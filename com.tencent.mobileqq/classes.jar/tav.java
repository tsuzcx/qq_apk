import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton.6.1;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;

public class tav
  implements ApngDrawable.OnPlayRepeatListener
{
  public tav(ColorBandVideoEntranceButton paramColorBandVideoEntranceButton) {}
  
  public void onPlayRepeat(int paramInt)
  {
    this.a.post(new ColorBandVideoEntranceButton.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tav
 * JD-Core Version:    0.7.0.1
 */