package com.tencent.mobileqq.winkpublish.uploader;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QzoneModuleConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostSoDownloadHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import java.io.File;

class AUploadSoDownloader$2
  implements ModuleDownloadListener
{
  AUploadSoDownloader$2(AUploadSoDownloader paramAUploadSoDownloader) {}
  
  public void onDownloadCanceled(String paramString)
  {
    AUploadSoDownloader.b(false);
  }
  
  public void onDownloadFailed(String paramString)
  {
    AUploadSoDownloader.b(false);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString)
  {
    if (!paramString.equals(QCircleHostConstants.QzoneModuleConst.QZONE_MODULE_UPLOAD_SO())) {
      return;
    }
    AUploadSoDownloader.b(false);
    String str = AUploadSoDownloader.b().getAbsolutePath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload so download success : ");
    ((StringBuilder)localObject).append(str);
    QLog.d("[upload2]AUploadSoDownloader", 1, ((StringBuilder)localObject).toString());
    paramString = QCircleHostSoDownloadHelper.getModuleFilePath(paramString);
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (!HostFileUtils.unzip(new File(paramString), (File)localObject))
    {
      QLog.d("[upload2]AUploadSoDownloader", 1, "upload so unzip fail");
      AUploadSoDownloader.b(false);
      return;
    }
    if (AUploadSoDownloader.a(this.a, str))
    {
      QLog.d("[upload2]AUploadSoDownloader", 1, "upload so save success");
      AUploadSoDownloader.a(this.a, true);
      AUploadSoDownloader.a(true);
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
      AUploadSoDownloader.a(this.a, false);
    }
    AUploadSoDownloader.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.AUploadSoDownloader.2
 * JD-Core Version:    0.7.0.1
 */