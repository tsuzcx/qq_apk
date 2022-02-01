package dov.com.qq.im.ae.download.old;

import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;
import java.util.Map;

class AEOldResManager$8
  implements Runnable
{
  AEOldResManager$8(AEOldResManager paramAEOldResManager, AEOldResInfo paramAEOldResInfo, List paramList, AEOldShortVideoResManager.INet_ShortVideoResource paramINet_ShortVideoResource) {}
  
  public void run()
  {
    AEQLog.b("AEOldResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo);
    AEOldResManager.a(this.this$0).put(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, Integer.valueOf(3));
    AEOldResManager.b(this.this$0).put(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, Long.valueOf(System.currentTimeMillis()));
    AEOldResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldResInfo, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResManager$INet_ShortVideoResource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldResManager.8
 * JD-Core Version:    0.7.0.1
 */