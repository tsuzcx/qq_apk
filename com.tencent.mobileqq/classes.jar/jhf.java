import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.camera.AndroidCamera.CameraPreviewCallback;
import com.tencent.av.utils.PhoneStatusTools;

public class jhf
  implements Camera.PreviewCallback
{
  public jhf(AndroidCamera paramAndroidCamera) {}
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool = true;
    int i;
    if (this.a.jdField_c_of_type_Int == 1)
    {
      i = AndroidCamera.a(this.a) * 90;
      if (this.a.e) {
        i = 0;
      }
      i = (360 - (i + this.a.d()) % 360) % 360;
    }
    for (;;)
    {
      int j = i + this.a.e();
      label166:
      label201:
      long l;
      if ((this.a.d() == 270) || (this.a.d() == 90))
      {
        i = j;
        if (this.a.e() % 180 == 0)
        {
          i = j;
          if (this.a.jdField_c_of_type_Int == 1) {
            if (PhoneStatusTools.a(this.a.jdField_a_of_type_AndroidContentContext, "ro.qq.orientation").equalsIgnoreCase("ZTE"))
            {
              i = j;
              if (!this.a.d) {}
            }
            else
            {
              i = j + 180;
            }
          }
        }
        if (this.a.jdField_c_of_type_Int != 1) {
          break label500;
        }
        if (this.a.i <= 0) {
          break label473;
        }
        i += 360 - this.a.i;
        i = i % 360 / 90;
        if (this.a.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback != null)
        {
          paramCamera = this.a.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback;
          l = AndroidCamera.jdField_a_of_type_Int;
          if (this.a.jdField_c_of_type_Int != 1) {
            break label550;
          }
        }
      }
      for (;;)
      {
        paramCamera.a(paramArrayOfByte, i, l, bool);
        if ((this.a.b) && (this.a.jdField_a_of_type_AndroidHardwareCamera != null) && (paramArrayOfByte != null)) {
          this.a.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramArrayOfByte);
        }
        return;
        if (this.a.jdField_c_of_type_Int != 2) {
          break label556;
        }
        i = AndroidCamera.a(this.a) * 90;
        if (this.a.e) {
          i = 0;
        }
        i = (this.a.d() - i + 360) % 360;
        break;
        if (this.a.d() != 0)
        {
          i = j;
          if (this.a.d() != 180) {
            break label166;
          }
        }
        if ((this.a.e() == 90) || (this.a.e() == 270))
        {
          i = j;
          if (this.a.jdField_c_of_type_Int != 1) {
            break label166;
          }
          i = j;
          if (this.a.jdField_c_of_type_Boolean) {
            break label166;
          }
          i = j + 180;
          break label166;
        }
        i = j;
        if (this.a.jdField_c_of_type_Int != 1) {
          break label166;
        }
        i = j;
        if (!this.a.jdField_c_of_type_Boolean) {
          break label166;
        }
        i = j + 180;
        break label166;
        label473:
        i += this.a.a(this.a.e(), this.a.e);
        break label201;
        label500:
        if (this.a.j > 0)
        {
          i += this.a.j;
          break label201;
        }
        i += this.a.b(this.a.e(), this.a.e);
        break label201;
        label550:
        bool = false;
      }
      label556:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhf
 * JD-Core Version:    0.7.0.1
 */