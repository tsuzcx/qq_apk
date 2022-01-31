package dov.com.qq.im.ae.download;

import axeo;
import biqz;
import bizq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AEResDownloader$3
  implements Runnable
{
  public AEResDownloader$3(biqz parambiqz, int paramInt, QQAppInterface paramQQAppInterface, List paramList, axeo paramaxeo) {}
  
  public void run()
  {
    bizq.b("AEResDownloader", "【AEResDownloader】preDownloadTask 【start】package" + this.jdField_a_of_type_Int);
    biqz.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(3));
    biqz.b(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(System.currentTimeMillis()));
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Axeo, (String)biqz.a().get(Integer.valueOf(this.jdField_a_of_type_Int)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResDownloader.3
 * JD-Core Version:    0.7.0.1
 */