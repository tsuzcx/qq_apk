package dov.com.qq.im.ae.mode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;

class AEVideoStoryCaptureModePart$AECaptureModeAdapter$1
  implements View.OnClickListener
{
  AEVideoStoryCaptureModePart$AECaptureModeAdapter$1(AEVideoStoryCaptureModePart.AECaptureModeAdapter paramAECaptureModeAdapter, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModePart$AECaptureModeAdapter.a, this.jdField_a_of_type_DovComQqImAeModeAECaptureMode);
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {
      AEBaseDataReporter.a().K();
    }
    for (;;)
    {
      AEQLog.b("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
        AEBaseDataReporter.a().J();
      } else if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
        AEBaseDataReporter.a().T();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.mode.AEVideoStoryCaptureModePart.AECaptureModeAdapter.1
 * JD-Core Version:    0.7.0.1
 */