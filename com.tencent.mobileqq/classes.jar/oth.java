import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class oth
  implements DialogInterface.OnDismissListener
{
  public oth(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oth
 * JD-Core Version:    0.7.0.1
 */