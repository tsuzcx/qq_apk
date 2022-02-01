import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class mfh
  implements DialogInterface.OnDismissListener
{
  public mfh(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b("onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfh
 * JD-Core Version:    0.7.0.1
 */