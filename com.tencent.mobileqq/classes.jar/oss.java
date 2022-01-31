import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class oss
  implements DialogInterface.OnDismissListener
{
  public oss(QRCardActivity paramQRCardActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oss
 * JD-Core Version:    0.7.0.1
 */