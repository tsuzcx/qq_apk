import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;

public class ktm
  implements DialogInterface.OnDismissListener
{
  public ktm(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.q = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktm
 * JD-Core Version:    0.7.0.1
 */