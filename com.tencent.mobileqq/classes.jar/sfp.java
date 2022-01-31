import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class sfp
  implements DialogInterface.OnCancelListener
{
  public sfp(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     sfp
 * JD-Core Version:    0.7.0.1
 */