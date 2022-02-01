package com.tencent.mobileqq.winkpublish.uploader;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AUploadSoDownloader$1
  implements Runnable
{
  AUploadSoDownloader$1(AUploadSoDownloader paramAUploadSoDownloader) {}
  
  public void run()
  {
    boolean bool = AUploadSoDownloader.a(this.this$0, AUploadSoDownloader.b().getAbsolutePath());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check so md5 result: ");
    localStringBuilder.append(bool);
    QLog.d("[upload2]AUploadSoDownloader", 1, localStringBuilder.toString());
    if (bool)
    {
      AUploadSoDownloader.a(true);
      return;
    }
    try
    {
      if (AUploadSoDownloader.b().exists()) {
        AUploadSoDownloader.b().delete();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    AUploadSoDownloader.a(this.this$0, false);
    AUploadSoDownloader.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.AUploadSoDownloader.1
 * JD-Core Version:    0.7.0.1
 */