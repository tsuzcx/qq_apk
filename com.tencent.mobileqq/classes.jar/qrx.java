import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class qrx
  implements qry
{
  qrx(qrw paramqrw, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    qrw.a(this.jdField_a_of_type_Qrw);
    if (qrw.a(this.jdField_a_of_type_Qrw) <= 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTask", 2, "onCaptureFailed try angin tryCount:" + qrw.a(this.jdField_a_of_type_Qrw) + "  CaptureTask:" + this.jdField_a_of_type_Qrw);
      }
      this.jdField_a_of_type_Qrw.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, qrw paramqrw)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    qrw.a(this.jdField_a_of_type_Qrw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrx
 * JD-Core Version:    0.7.0.1
 */