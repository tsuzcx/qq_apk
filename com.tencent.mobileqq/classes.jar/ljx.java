import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class ljx
  implements Camera.PreviewCallback
{
  private int jdField_a_of_type_Int = -1;
  
  ljx(ljw paramljw) {}
  
  boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      if (!msf.a(this.jdField_a_of_type_Ljw.jdField_a_of_type_AndroidContentContext, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
        break label43;
      }
    }
    label43:
    for (this.jdField_a_of_type_Int = 1; this.jdField_a_of_type_Int == 1; this.jdField_a_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (AudioHelper.e()) {
        QLog.w("AndroidCamera", 1, "onPreviewFrame, data为空, Camera[" + paramCamera + "], camera[" + this.jdField_a_of_type_Ljw.jdField_a_of_type_AndroidHardwareCamera + "]");
      }
      this.jdField_a_of_type_Ljw.jdField_a_of_type_Lka.b();
    }
    int i1;
    int k;
    int i2;
    int i;
    int j;
    label214:
    label249:
    int i4;
    label308:
    boolean bool;
    label492:
    do
    {
      return;
      i1 = this.jdField_a_of_type_Ljw.d();
      k = ljw.a(this.jdField_a_of_type_Ljw) * 90;
      if (this.jdField_a_of_type_Ljw.e) {
        k = 0;
      }
      i2 = this.jdField_a_of_type_Ljw.e();
      i = 0;
      if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int != 1) {
        break;
      }
      i = (360 - (k + i1) % 360) % 360;
      j = i + i2;
      if ((i1 != 270) && (i1 != 90)) {
        break label619;
      }
      i = j;
      if (i2 % 180 == 0)
      {
        i = j;
        if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int == 1) {
          if (a())
          {
            i = j;
            if (!this.jdField_a_of_type_Ljw.d) {}
          }
          else
          {
            i = j + 180;
          }
        }
      }
      if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int != 1) {
        break label746;
      }
      if (this.jdField_a_of_type_Ljw.i <= 0) {
        break label724;
      }
      i += 360 - this.jdField_a_of_type_Ljw.i;
      int i3 = i % 360 / 90;
      j = ljw.k;
      i = ljw.l;
      i4 = paramArrayOfByte.length;
      int m = i;
      int n = j;
      if (i4 != j * i * 3 / 2)
      {
        if (i4 != 460800) {
          break label791;
        }
        j = 640;
        i = 480;
        m = i;
        n = j;
        if (AudioHelper.e())
        {
          QLog.w("AndroidCamera", 1, "OnPreviewData false, expectSize[" + ljw.k + ", " + ljw.l + "], datalen[" + i4 + "], fixSize[" + j + ", " + i + "]");
          n = j;
          m = i;
        }
      }
      this.jdField_a_of_type_Ljw.jdField_a_of_type_Lka.a(i3, this.jdField_a_of_type_Ljw.jdField_c_of_type_Int, ljw.jdField_a_of_type_Int, this.jdField_a_of_type_Ljw.e, i1, k, i2, paramArrayOfByte.length, n, m);
      if (this.jdField_a_of_type_Ljw.jdField_a_of_type_Ljz != null)
      {
        paramCamera = this.jdField_a_of_type_Ljw.jdField_a_of_type_Ljz;
        long l1 = this.jdField_a_of_type_Ljw.jdField_a_of_type_Lka.j;
        long l2 = ljw.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int != 1) {
          break label829;
        }
        bool = true;
        paramCamera.a(l1, paramArrayOfByte, n, m, i3, i2, l2, bool);
      }
    } while ((!this.jdField_a_of_type_Ljw.b) || (this.jdField_a_of_type_Ljw.jdField_a_of_type_AndroidHardwareCamera == null) || (paramArrayOfByte == null));
    paramCamera = lkh.a().a(0);
    if (paramCamera == null)
    {
      paramCamera = paramArrayOfByte;
      if (QLog.isDevelopLevel())
      {
        QLog.w("AndroidCamera", 1, "OnPreviewData, 没有空闲的缓存");
        paramCamera = paramArrayOfByte;
      }
    }
    for (;;)
    {
      if (paramCamera != null) {
        lkh.a().a(paramCamera, 1);
      }
      this.jdField_a_of_type_Ljw.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramCamera);
      return;
      if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int != 2) {
        break;
      }
      i = (i1 - k + 360) % 360;
      break;
      label619:
      if (i1 != 0)
      {
        i = j;
        if (i1 != 180) {
          break label214;
        }
      }
      if ((i2 == 90) || (i2 == 270))
      {
        i = j;
        if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int != 1) {
          break label214;
        }
        i = j;
        if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Boolean) {
          break label214;
        }
        i = j + 180;
        break label214;
      }
      i = j;
      if (this.jdField_a_of_type_Ljw.jdField_c_of_type_Int != 1) {
        break label214;
      }
      i = j;
      if (!this.jdField_a_of_type_Ljw.jdField_c_of_type_Boolean) {
        break label214;
      }
      i = j + 180;
      break label214;
      label724:
      i += this.jdField_a_of_type_Ljw.a(i2, this.jdField_a_of_type_Ljw.e);
      break label249;
      label746:
      if (this.jdField_a_of_type_Ljw.j > 0)
      {
        i += this.jdField_a_of_type_Ljw.j;
        break label249;
      }
      i += this.jdField_a_of_type_Ljw.b(i2, this.jdField_a_of_type_Ljw.e);
      break label249;
      label791:
      if (i4 == 1382400)
      {
        j = 1280;
        i = 720;
        break label308;
      }
      if (i4 != 115200) {
        break label308;
      }
      j = 320;
      i = 240;
      break label308;
      label829:
      bool = false;
      break label492;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljx
 * JD-Core Version:    0.7.0.1
 */