import com.tencent.av.VideoController;
import com.tencent.av.camera.AndroidCamera.CameraPreviewCallback;
import com.tencent.av.camera.CameraUtils;

public class jhi
  implements AndroidCamera.CameraPreviewCallback
{
  public jhi(CameraUtils paramCameraUtils) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.b("onPreviewData");
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.a("onPreviewData");
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfByte, paramInt, paramLong, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jhi
 * JD-Core Version:    0.7.0.1
 */