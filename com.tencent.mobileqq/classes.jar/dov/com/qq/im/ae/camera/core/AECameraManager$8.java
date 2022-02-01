package dov.com.qq.im.ae.camera.core;

import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

class AECameraManager$8
  implements Runnable
{
  AECameraManager$8(AECameraManager paramAECameraManager, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (AECameraManager.access$300(this.this$0) == null) {
      return;
    }
    CameraFocusParams localCameraFocusParams = new CameraFocusParams();
    localCameraFocusParams.jdField_a_of_type_Float = this.val$x;
    localCameraFocusParams.jdField_b_of_type_Float = this.val$y;
    localCameraFocusParams.jdField_a_of_type_Int = this.val$surfaceWidth;
    localCameraFocusParams.jdField_b_of_type_Int = this.val$surfaceHeight;
    localCameraFocusParams.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = AECameraManager.access$300(this.this$0);
    localCameraFocusParams.c = CaptureUtil.c(AECameraManager.access$1000(this.this$0));
    AECameraManager.access$800(this.this$0).a(localCameraFocusParams, new AECameraManager.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.8
 * JD-Core Version:    0.7.0.1
 */