import com.tencent.av.VideoController;
import com.tencent.av.camera.CameraUtils;

public class kzr
  implements kzo
{
  public kzr(CameraUtils paramCameraUtils) {}
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.a("onPreviewData_" + paramLong1);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.a(-1019L, "onPreviewData_" + paramLong1);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong2, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kzr
 * JD-Core Version:    0.7.0.1
 */