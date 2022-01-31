import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.ipc.QrImageScan;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class oum
  implements ScannerView.FileDecodeListener
{
  public oum(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    localQQCustomDialog.setMessage(2131429974);
    oun localoun = new oun(this);
    localQQCustomDialog.setPositiveButton(2131433016, localoun);
    localQQCustomDialog.setOnCancelListener(localoun);
    localQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    String str = "QR_CODE";
    if (ScannerActivity.a(this.a) != null) {
      str = ScannerActivity.a(this.a).a();
    }
    ScannerActivity.a(this.a, str, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oum
 * JD-Core Version:    0.7.0.1
 */