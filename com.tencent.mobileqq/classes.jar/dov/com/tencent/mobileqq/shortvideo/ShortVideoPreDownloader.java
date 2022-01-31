package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.manager.Manager;

public class ShortVideoPreDownloader
  implements Manager
{
  public static long a;
  Timer a;
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      QLog.d("ShortVideoPreDownloader", 2, paramString1 + "(): " + str);
    }
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader
 * JD-Core Version:    0.7.0.1
 */