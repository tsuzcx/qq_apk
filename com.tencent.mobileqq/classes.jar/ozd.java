import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.ipc.QrImageScan;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ozd
  implements ScannerView.FileDecodeListener
{
  public ozd(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.a.a.d = false;
    ScannerActivity.a(this.a).setVisibility(8);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    localQQCustomDialog.setMessage(2131429976);
    oze localoze = new oze(this);
    localQQCustomDialog.setPositiveButton(2131433030, localoze);
    localQQCustomDialog.setOnCancelListener(localoze);
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
 * Qualified Name:     ozd
 * JD-Core Version:    0.7.0.1
 */