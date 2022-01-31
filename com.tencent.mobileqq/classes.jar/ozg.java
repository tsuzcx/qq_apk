import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.ipc.PreCallUpToolProc.Callback;
import com.tencent.qphone.base.util.QLog;

public class ozg
  implements PreCallUpToolProc.Callback
{
  public ozg(ScannerActivity paramScannerActivity, long paramLong) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerActivity.b();
    QLog.d("ScannerActivity", 2, "launchAr time end: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozg
 * JD-Core Version:    0.7.0.1
 */