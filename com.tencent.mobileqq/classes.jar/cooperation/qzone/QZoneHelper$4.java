package cooperation.qzone;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import bgyp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class QZoneHelper$4
  implements Runnable
{
  public QZoneHelper$4(QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 26)
      {
        bgyp.a(bgyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
      }
      bgyp.b(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QZoneHelper", 2, "updateAlbumShortCut error! exception e = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.4
 * JD-Core Version:    0.7.0.1
 */