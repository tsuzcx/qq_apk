import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.qrcode.activity.QRLoginActivity;

public class ouh
  implements DialogInterface.OnCancelListener
{
  public ouh(QRLoginActivity paramQRLoginActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouh
 * JD-Core Version:    0.7.0.1
 */