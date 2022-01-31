import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;

public class kso
  implements DialogInterface.OnDismissListener
{
  public kso(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.r = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kso
 * JD-Core Version:    0.7.0.1
 */