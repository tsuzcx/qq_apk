import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

class tcn
  implements DialogInterface.OnCancelListener
{
  tcn(tcl paramtcl) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.setResult(4003);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcn
 * JD-Core Version:    0.7.0.1
 */