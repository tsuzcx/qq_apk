import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class mer
  implements DialogInterface.OnDismissListener
{
  public mer(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b("onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mer
 * JD-Core Version:    0.7.0.1
 */