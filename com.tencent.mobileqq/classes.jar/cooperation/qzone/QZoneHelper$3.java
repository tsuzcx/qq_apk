package cooperation.qzone;

import android.graphics.Bitmap;
import bflz;
import bjdt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class QZoneHelper$3
  implements Runnable
{
  public QZoneHelper$3(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, String paramString1, long paramLong, String paramString2) {}
  
  public void run()
  {
    try
    {
      bjdt.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QZoneHelper", 2, "createAlbumShortCut error! exception e = " + localException.getMessage());
      bflz.a().a(2131690149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.3
 * JD-Core Version:    0.7.0.1
 */