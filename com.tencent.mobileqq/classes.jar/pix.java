import android.hardware.Camera;
import com.tencent.biz.widgets.ScannerView;

class pix
  implements Runnable
{
  pix(piw parampiw) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidHardwareCamera == null) {
      return;
    }
    try
    {
      this.a.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      label21:
      ScannerView.b(this.a.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
      return;
    }
    catch (Exception localException)
    {
      break label21;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pix
 * JD-Core Version:    0.7.0.1
 */