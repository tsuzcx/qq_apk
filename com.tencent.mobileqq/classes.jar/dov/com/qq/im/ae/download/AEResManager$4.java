package dov.com.qq.im.ae.download;

import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;
import java.util.Map;

class AEResManager$4
  implements Runnable
{
  AEResManager$4(AEResManager paramAEResManager, AEResInfo paramAEResInfo, List paramList, ShortVideoResourceManager.INet_ShortVideoResource paramINet_ShortVideoResource) {}
  
  public void run()
  {
    AEQLog.b("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo);
    AEResManager.a(this.this$0).put(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Integer.valueOf(3));
    AEResManager.b(this.this$0).put(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, Long.valueOf(System.currentTimeMillis()));
    AEResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadAEResInfo, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResManager.4
 * JD-Core Version:    0.7.0.1
 */