package cooperation.qzone;

import bctj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

final class QzoneVerticalVideoDownloadActivity$6
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$6(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.jdField_a_of_type_JavaLangString, this.b);
    bctj.a(BaseApplicationImpl.getApplication()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.c, true, this.jdField_a_of_type_Int, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.6
 * JD-Core Version:    0.7.0.1
 */