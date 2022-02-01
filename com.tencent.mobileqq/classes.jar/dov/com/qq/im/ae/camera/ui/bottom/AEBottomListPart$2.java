package dov.com.qq.im.ae.camera.ui.bottom;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;

class AEBottomListPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEBottomListPart$2(AEBottomListPart paramAEBottomListPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.e();
      AEBottomListPart.a(this.a, paramAECaptureModeChangingEvent.b);
      if (AEBottomListPart.a(this.a) == AECaptureMode.NORMAL)
      {
        AEBottomListPart.a(this.a);
        return;
      }
      if (AEBottomListPart.a(this.a) == AECaptureMode.GIF)
      {
        this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
        return;
      }
    } while (AEBottomListPart.a(this.a) != AECaptureMode.PLAY);
    this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.2
 * JD-Core Version:    0.7.0.1
 */