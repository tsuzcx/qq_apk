import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;

public class tcu
  implements DialogInterface.OnCancelListener
{
  public tcu(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tcu
 * JD-Core Version:    0.7.0.1
 */