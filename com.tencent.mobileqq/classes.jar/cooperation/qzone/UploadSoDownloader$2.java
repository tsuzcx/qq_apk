package cooperation.qzone;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload so download success : ");
    ((StringBuilder)localObject).append(str);
    QLog.d("[upload2]UploadEnv", 1, ((StringBuilder)localObject).toString());
    paramString = ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(paramString);
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (!FileUtils.unzip(new File(paramString), (File)localObject))
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
    else
    {
      try
      {
        ((File)localObject).delete();
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      UploadSoDownloader.access$300(this.this$0, false);
    }
    UploadSoDownloader.access$402(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.UploadSoDownloader.2
 * JD-Core Version:    0.7.0.1
 */