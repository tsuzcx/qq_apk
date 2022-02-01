import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class rna
  implements rnb
{
  rna(rmz paramrmz, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    rmz.a(this.jdField_a_of_type_Rmz);
    if (rmz.a(this.jdField_a_of_type_Rmz) <= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTask", 2, "onCaptureFailed try angin tryCount:" + rmz.a(this.jdField_a_of_type_Rmz) + "  CaptureTask:" + this.jdField_a_of_type_Rmz);
      }
      this.jdField_a_of_type_Rmz.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, rmz paramrmz)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    rmz.a(this.jdField_a_of_type_Rmz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rna
 * JD-Core Version:    0.7.0.1
 */