import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class rkv
  implements rkw
{
  rkv(rku paramrku, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    rku.a(this.jdField_a_of_type_Rku);
    if (rku.a(this.jdField_a_of_type_Rku) <= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTask", 2, "onCaptureFailed try angin tryCount:" + rku.a(this.jdField_a_of_type_Rku) + "  CaptureTask:" + this.jdField_a_of_type_Rku);
      }
      this.jdField_a_of_type_Rku.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, rku paramrku)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    rku.a(this.jdField_a_of_type_Rku);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkv
 * JD-Core Version:    0.7.0.1
 */