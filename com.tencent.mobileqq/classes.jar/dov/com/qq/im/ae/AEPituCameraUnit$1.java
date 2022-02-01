package dov.com.qq.im.ae;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraManagerListener;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.util.AEQLog;
import mqq.os.MqqHandler;

class AEPituCameraUnit$1
  implements AECameraManager.CameraManagerListener
{
  AEPituCameraUnit$1(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    AEQLog.b(this.a.b, "onCameraPreviewSizeChanged---width=" + paramInt1 + ", height=" + paramInt2);
    if (this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onCameraPreviewSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onCameraPreviewStarted()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.a.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onCameraPreviewStarted();
    }
  }
  
  public void onCameraStarted(boolean paramBoolean, String paramString)
  {
    AEQLog.b(this.a.b, "onCameraStarted--success=" + paramBoolean + ", errMsg=" + paramString);
    this.a.a(paramBoolean, paramString);
    if (paramBoolean) {
      AELaunchRecorder.a().a("onCameraStart");
    }
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.1(this));
    }
    for (;;)
    {
      int i = AEBeautyProviderView.a();
      int j = AEBeautyProviderView.b();
      this.a.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a(i);
      this.a.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.b(j);
      this.a.jdField_a_of_type_DovComQqImAePartVideoStoryCapturePartManager.a(458753, new Object[0]);
      return;
      if (this.a.jdField_a_of_type_DovComQqImAeViewAECameraErrorDialog != null) {
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.1.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */