package cooperation.qzone;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.FileUtils;
import java.io.File;

class UploadSoDownloader$2
  implements ModuleDownloadListener
{
  UploadSoDownloader$2(UploadSoDownloader paramUploadSoDownloader) {}
  
  public void onDownloadCanceled(String paramString)
  {
    UploadSoDownloader.access$402(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    UploadSoDownloader.access$402(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals("upload.so")) {
      return;
    }
    UploadSoDownloader.access$402(false);
    String str = UploadSoDownloader.access$000().getAbsolutePath();
    QLog.d("[upload2]UploadEnv", 1, "upload so download success : " + str);
    paramString = QzoneModuleManager.getInstance().getModuleFilePath(paramString);
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!FileUtils.unzip(new File(paramString), localFile))
    {
      QLog.d("[upload2]UploadEnv", 1, "upload so unzip fail");
      UploadSoDownloader.access$402(false);
      return;
    }
    if (UploadSoDownloader.access$100(this.this$0, str))
    {
      QLog.d("[upload2]UploadEnv", 1, "upload so save success");
      UploadSoDownloader.access$300(this.this$0, true);
      UploadSoDownloader.access$202(true);
    }
    for (;;)
    {
      UploadSoDownloader.access$402(false);
      return;
      try
      {
        localFile.delete();
        UploadSoDownloader.access$300(this.this$0, false);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.2
 * JD-Core Version:    0.7.0.1
 */