import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ljr
  extends ljg
  implements Camera.PreviewCallback
{
  public boolean a;
  
  public ljr(lje paramlje, ljf paramljf)
  {
    super(paramlje, paramljf);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private int a(int paramInt)
  {
    int i = ImageFormat.getBitsPerPixel(paramInt);
    float f = i * 1.0F / 8.0F;
    int j = (int)(lje.b * lje.jdField_a_of_type_Int * f);
    if (AudioHelper.f()) {
      QLog.w("MyPreviewCallback", 1, "getPreviewBufferSize, previewFormat[" + paramInt + "], bitPixel[" + i + "], byteNum[" + f + "], bufSize[" + j + "]");
    }
    return j;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      ljp.a().a(paramInt);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          ljp.a().a(paramInt);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("MyPreviewCallback", 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    ljp.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("MyPreviewCallback", 2, "release");
    }
  }
  
  public void a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Ljt.a();
    int j;
    int k;
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Lje.a() != null)) {
      if (a(a(this.jdField_a_of_type_Lje.a().getPreviewFormat())))
      {
        j = 0;
        k = 0;
        if (j < ljp.a().a())
        {
          paramSurfaceTexture = ljp.a().a(0);
          i = k;
          if (paramSurfaceTexture != null)
          {
            ljp.a().a(paramSurfaceTexture, 1);
            this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramSurfaceTexture);
            k += 1;
            i = k;
            if (k < 2) {}
          }
        }
        else
        {
          this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this);
          i = 1;
        }
      }
    }
    for (;;)
    {
      QLog.w("MyPreviewCallback", 1, "setPreviewCallback, type[" + i + "], seq[" + paramLong + "]");
      return;
      j += 1;
      k = i;
      break;
      this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this);
      i = 2;
      continue;
      i = 3;
      this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this);
    }
  }
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (AudioHelper.f()) {
        QLog.w("MyPreviewCallback", 1, "onPreviewFrame, data is null, Camera[" + paramCamera + "], camera[" + this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera + "]");
      }
      this.jdField_a_of_type_Ljt.b();
    }
    int n;
    int j;
    int i;
    boolean bool;
    label327:
    do
    {
      return;
      a(this.jdField_a_of_type_Ljh);
      n = paramArrayOfByte.length;
      j = lje.jdField_a_of_type_Int;
      i = lje.b;
      int k = i;
      int m = j;
      if (n != j * i * 3 / 2)
      {
        if (n != 460800) {
          break;
        }
        j = 640;
        i = 480;
        k = i;
        m = j;
        if (AudioHelper.f())
        {
          QLog.w("MyPreviewCallback", 1, "OnPreviewData false, expectSize[" + lje.jdField_a_of_type_Int + ", " + lje.b + "], dataLen[" + n + "], fixSize[" + j + ", " + i + "]");
          m = j;
          k = i;
        }
      }
      this.jdField_a_of_type_Ljt.a(this.jdField_a_of_type_Ljh.jdField_a_of_type_Int, this.jdField_a_of_type_Lje.f, lje.d, this.jdField_a_of_type_Lje.e, this.jdField_a_of_type_Ljh.c, this.jdField_a_of_type_Ljh.d, this.jdField_a_of_type_Ljh.b, n, m, k);
      if (this.jdField_a_of_type_Ljf != null)
      {
        paramCamera = lpc.a();
        long l = this.jdField_a_of_type_Ljt.j;
        i = lje.c;
        j = this.jdField_a_of_type_Ljh.jdField_a_of_type_Int;
        n = this.jdField_a_of_type_Ljh.b;
        if (this.jdField_a_of_type_Lje.f != 1) {
          break label467;
        }
        bool = true;
        paramCamera.a(l, paramArrayOfByte, m, k, i, j, n, bool, lje.d, System.currentTimeMillis());
        this.jdField_a_of_type_Ljf.a(paramCamera);
      }
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera == null));
    paramCamera = ljp.a().a(0);
    if (paramCamera == null)
    {
      paramCamera = paramArrayOfByte;
      if (QLog.isDevelopLevel())
      {
        QLog.w("MyPreviewCallback", 1, "OnPreviewData, 没有空闲的缓存");
        paramCamera = paramArrayOfByte;
      }
    }
    for (;;)
    {
      ljp.a().a(paramCamera, 1);
      this.jdField_a_of_type_Lje.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramCamera);
      return;
      if (n == 1382400)
      {
        j = 1280;
        i = 720;
        break;
      }
      if (n != 115200) {
        break;
      }
      j = 320;
      i = 240;
      break;
      label467:
      bool = false;
      break label327;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljr
 * JD-Core Version:    0.7.0.1
 */