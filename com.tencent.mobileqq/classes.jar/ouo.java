import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.qphone.base.util.QLog;

public class ouo
  implements QrHandleResultCallBack
{
  public ouo(ScannerActivity paramScannerActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "restartDecodeFrame");
    }
    this.a.finish();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "cameraOn");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouo
 * JD-Core Version:    0.7.0.1
 */