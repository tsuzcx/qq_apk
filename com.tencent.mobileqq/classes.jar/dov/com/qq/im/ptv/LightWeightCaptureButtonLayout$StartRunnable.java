package dov.com.qq.im.ptv;

import android.os.Handler;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import com.tencent.qphone.base.util.QLog;

class LightWeightCaptureButtonLayout$StartRunnable
  implements Runnable
{
  private LightWeightCaptureButtonLayout$StartRunnable(LightWeightCaptureButtonLayout paramLightWeightCaptureButtonLayout) {}
  
  public void run()
  {
    boolean bool = this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.c();
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureLayout", 2, " StartRunnable: canCapture: " + bool + " isStarting: " + this.this$0.c);
    }
    if (bool)
    {
      LightWeightCaptureButtonLayout.a(this.this$0);
      return;
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(LightWeightCaptureButtonLayout.a(this.this$0), 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCaptureButtonLayout.StartRunnable
 * JD-Core Version:    0.7.0.1
 */