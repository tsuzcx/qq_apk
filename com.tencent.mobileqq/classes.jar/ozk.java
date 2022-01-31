import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity.QQDialogCancelListener;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import mqq.app.AppActivity;

class ozk
  extends ScannerActivity.QQDialogCancelListener
{
  ozk(ozj paramozj) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.a.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.i)
    {
      this.a.jdField_a_of_type_ComTencentBizQrcodeIpcQrHandleResultCallBack.a();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e)
    {
      this.a.jdField_a_of_type_MqqAppAppActivity.finish();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQrcodeIpcQrHandleResultCallBack.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozk
 * JD-Core Version:    0.7.0.1
 */