import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;

public class oas
  implements DialogInterface.OnDismissListener
{
  public oas(PublicAccountMenuBar paramPublicAccountMenuBar) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    PublicAccountMenuBar.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oas
 * JD-Core Version:    0.7.0.1
 */