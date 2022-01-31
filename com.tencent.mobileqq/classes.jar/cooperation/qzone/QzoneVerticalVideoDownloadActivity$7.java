package cooperation.qzone;

import azly;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.Properties;

final class QzoneVerticalVideoDownloadActivity$7
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$7(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    Properties localProperties = new Properties();
    localProperties.put(this.jdField_a_of_type_JavaLangString, this.b);
    azly.a(BaseApplicationImpl.getContext()).reportTimeKVEvent(this.c, localProperties, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */