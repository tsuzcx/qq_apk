import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class jvm
  implements DialogInterface.OnDismissListener
{
  public jvm(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b("onDismiss");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvm
 * JD-Core Version:    0.7.0.1
 */