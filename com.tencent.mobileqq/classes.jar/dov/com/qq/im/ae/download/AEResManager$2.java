package dov.com.qq.im.ae.download;

import azef;
import blao;
import blap;
import bljn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.List;
import java.util.Map;

public class AEResManager$2
  implements Runnable
{
  public AEResManager$2(blap paramblap, blao paramblao, QQAppInterface paramQQAppInterface, List paramList, azef paramazef) {}
  
  public void run()
  {
    bljn.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_Blao);
    blap.a(this.this$0).put(this.jdField_a_of_type_Blao, Integer.valueOf(3));
    blap.b(this.this$0).put(this.jdField_a_of_type_Blao, Long.valueOf(System.currentTimeMillis()));
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Azef, this.jdField_a_of_type_Blao.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.2
 * JD-Core Version:    0.7.0.1
 */