package dov.com.qq.im.ae.download;

import ayzw;
import bkwh;
import bkwi;
import blfg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.List;
import java.util.Map;

public class AEResManager$2
  implements Runnable
{
  public AEResManager$2(bkwi parambkwi, bkwh parambkwh, QQAppInterface paramQQAppInterface, List paramList, ayzw paramayzw) {}
  
  public void run()
  {
    blfg.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_Bkwh);
    bkwi.a(this.this$0).put(this.jdField_a_of_type_Bkwh, Integer.valueOf(3));
    bkwi.b(this.this$0).put(this.jdField_a_of_type_Bkwh, Long.valueOf(System.currentTimeMillis()));
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ayzw, this.jdField_a_of_type_Bkwh.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.2
 * JD-Core Version:    0.7.0.1
 */