import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;

public class odb
  implements DialogInterface.OnDismissListener
{
  public odb(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.o = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odb
 * JD-Core Version:    0.7.0.1
 */