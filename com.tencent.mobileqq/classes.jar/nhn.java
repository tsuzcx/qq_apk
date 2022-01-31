import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;

public class nhn
  implements DialogInterface.OnDismissListener
{
  public nhn(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.p = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhn
 * JD-Core Version:    0.7.0.1
 */