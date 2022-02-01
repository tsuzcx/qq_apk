import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class mfm
  implements DialogInterface.OnDismissListener
{
  public mfm(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b("onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mfm
 * JD-Core Version:    0.7.0.1
 */