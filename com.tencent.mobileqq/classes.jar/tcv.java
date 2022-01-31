import android.graphics.Bitmap;

class tcv
  implements tyi
{
  tcv(tcu paramtcu, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (tcu.a(this.jdField_a_of_type_Tcu))
    {
      paramString = bacm.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        tcu.a(this.jdField_a_of_type_Tcu, false);
        return;
      }
      bool = vlc.a(paramString, tcu.a(this.jdField_a_of_type_Tcu));
      paramString.recycle();
      tcu.b(this.jdField_a_of_type_Tcu, bool);
      return;
    }
    boolean bool = vlc.a(paramBitmap, tcu.a(this.jdField_a_of_type_Tcu));
    tcu.c(this.jdField_a_of_type_Tcu, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    urk.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    tcu.d(this.jdField_a_of_type_Tcu, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcv
 * JD-Core Version:    0.7.0.1
 */