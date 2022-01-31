import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

class tcm
  implements DialogInterface.OnClickListener
{
  tcm(tcl paramtcl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.setResult(4003);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcm
 * JD-Core Version:    0.7.0.1
 */