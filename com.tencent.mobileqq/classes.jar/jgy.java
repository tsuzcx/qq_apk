import android.annotation.TargetApi;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.VcCamera;
import com.tencent.qphone.base.util.QLog;

public class jgy
  implements Runnable
{
  boolean jdField_a_of_type_Boolean = false;
  
  public jgy(CameraUtils paramCameraUtils) {}
  
  @TargetApi(14)
  public void run()
  {
    QLog.w("CameraUtils", 1, "openCamera begin, mOpening[" + this.jdField_a_of_type_Boolean + "]");
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils).a(new Object[] { Integer.valueOf(1) });
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.e = 0;
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.g = false;
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvCameraVcCamera.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    int j;
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      j = this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d;
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvCameraVcCamera.g() != 0) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().l = true;
      }
      i = j;
      if (bool)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().i = false;
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().Q = false;
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().f = true;
        if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) {
          break label351;
        }
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d = 2;
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.c(2);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a("OpenCameraRunnable.run");
      }
    }
    for (int i = j;; i = 0)
    {
      CameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils).a(new Object[] { Integer.valueOf(2), Boolean.valueOf(bool), Integer.valueOf(i) });
      if (bool) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.e();
      }
      QLog.w("CameraUtils", 1, "openCamera end. result[" + bool + "]");
      this.jdField_a_of_type_Boolean = false;
      return;
      label351:
      if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d != 3) && (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d = 4;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgy
 * JD-Core Version:    0.7.0.1
 */