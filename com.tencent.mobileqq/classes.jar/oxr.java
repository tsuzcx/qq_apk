import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;

public class oxr
  implements DialogInterface.OnDismissListener
{
  public oxr(TroopNewGuidePopWindow paramTroopNewGuidePopWindow) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.deleteObserver(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxr
 * JD-Core Version:    0.7.0.1
 */