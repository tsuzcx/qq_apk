package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class UploadSoDownloader$1
  implements Runnable
{
  UploadSoDownloader$1(UploadSoDownloader paramUploadSoDownloader) {}
  
  public void run()
  {
    boolean bool = UploadSoDownloader.access$100(this.this$0, UploadSoDownloader.access$000().getAbsolutePath());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check so md5 result: ");
    localStringBuilder.append(bool);
    QLog.d("[upload2]UploadEnv", 1, localStringBuilder.toString());
    if (bool)
    {
      UploadSoDownloader.access$202(true);
      return;
    }
    try
    {
      if (UploadSoDownloader.access$000().exists()) {
        UploadSoDownloader.access$000().delete();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    UploadSoDownloader.access$300(this.this$0, false);
    UploadSoDownloader.access$202(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */