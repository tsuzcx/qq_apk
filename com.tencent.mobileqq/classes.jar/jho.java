import android.annotation.TargetApi;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.VcCamera;
import com.tencent.qphone.base.util.QLog;

public class jho
  implements Runnable
{
  public jho(CameraUtils paramCameraUtils) {}
  
  @TargetApi(14)
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "switchCamera begin.");
    }
    CameraUtils.a(this.a).a(new Object[] { Integer.valueOf(5) });
    if (this.a.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.b(this.a.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    }
    CameraUtils.a(this.a).a(new Object[] { Integer.valueOf(6), Boolean.valueOf(true) });
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "switchCamera end.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jho
 * JD-Core Version:    0.7.0.1
 */