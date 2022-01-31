import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

public class oro
  implements DialogInterface.OnCancelListener
{
  public oro(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.d) {
      return;
    }
    this.a.h = -1;
    this.a.d = true;
    QRDisplayActivity.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oro
 * JD-Core Version:    0.7.0.1
 */