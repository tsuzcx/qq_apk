import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.VcCamera;
import com.tencent.qphone.base.util.QLog;

public class jhl
  implements Runnable
{
  private boolean jdField_a_of_type_Boolean = true;
  
  public jhl(CameraUtils paramCameraUtils) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "closeCamera begin.");
    }
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils).a(new Object[] { Integer.valueOf(3) });
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvCameraVcCamera.c();
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b("CloseCameraRunnable.run");
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) {
        break label218;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().f = false;
        if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().g)
        {
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d = 1;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.c(1);
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().Q = true;
        }
      }
    }
    for (;;)
    {
      CameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils).a(new Object[] { Integer.valueOf(4), Boolean.valueOf(true) });
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.f();
      if (QLog.isColorLevel()) {
        QLog.d("CameraUtils", 2, "closeCamera end.");
      }
      return;
      label218:
      if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) && (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().g)) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().d = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhl
 * JD-Core Version:    0.7.0.1
 */