import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable.DownloadListener;

public class oyy
  implements URLDrawable.DownloadListener
{
  public oyy(TroopGiftPanel paramTroopGiftPanel, TextView paramTextView) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyy
 * JD-Core Version:    0.7.0.1
 */