import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.qphone.base.util.QLog;

public class pee
  extends Thread
  implements Camera.AutoFocusCallback
{
  Camera jdField_a_of_type_AndroidHardwareCamera;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected Runnable a;
  
  public pee(ScannerView paramScannerView, Camera paramCamera)
  {
    this.jdField_a_of_type_JavaLangRunnable = new pef(this);
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a()
  {
    try
    {
      if ((ScannerView.e(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)) && (this.jdField_a_of_type_AndroidHardwareCamera != null) && (ScannerView.f(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)))
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2500L);
        this.jdField_a_of_type_AndroidHardwareCamera.autoFocus(this);
        ScannerView.b(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, false);
      }
      return;
    }
    finally {}
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScannerView", 4, "onAutoFocus");
    }
    ScannerView.b(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void run()
  {
    try
    {
      if (ScannerView.d(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)) {
        ScannerView.c(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, false);
      }
      for (;;)
      {
        try
        {
          a();
        }
        catch (RuntimeException localRuntimeException1) {}
        break;
        Thread.sleep(3000L);
      }
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
        ScannerView.b(this.jdField_a_of_type_ComTencentBizWidgetsScannerView, true);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidHardwareCamera = null;
        return;
      }
      catch (RuntimeException localRuntimeException2)
      {
        break label77;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (ScannerView.e(this.jdField_a_of_type_ComTencentBizWidgetsScannerView)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pee
 * JD-Core Version:    0.7.0.1
 */