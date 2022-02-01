import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class rdv
  implements rdw
{
  rdv(rdu paramrdu, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    rdu.a(this.jdField_a_of_type_Rdu);
    if (rdu.a(this.jdField_a_of_type_Rdu) <= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTask", 2, "onCaptureFailed try angin tryCount:" + rdu.a(this.jdField_a_of_type_Rdu) + "  CaptureTask:" + this.jdField_a_of_type_Rdu);
      }
      this.jdField_a_of_type_Rdu.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, rdu paramrdu)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    rdu.a(this.jdField_a_of_type_Rdu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdv
 * JD-Core Version:    0.7.0.1
 */