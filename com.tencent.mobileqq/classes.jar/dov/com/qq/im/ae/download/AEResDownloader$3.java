package dov.com.qq.im.ae.download;

import axeq;
import birq;
import bjah;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AEResDownloader$3
  implements Runnable
{
  public AEResDownloader$3(birq parambirq, int paramInt, QQAppInterface paramQQAppInterface, List paramList, axeq paramaxeq) {}
  
  public void run()
  {
    bjah.b("AEResDownloader", "【AEResDownloader】preDownloadTask 【start】package" + this.jdField_a_of_type_Int);
    birq.a(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(3));
    birq.b(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(System.currentTimeMillis()));
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Axeq, (String)birq.a().get(Integer.valueOf(this.jdField_a_of_type_Int)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResDownloader.3
 * JD-Core Version:    0.7.0.1
 */