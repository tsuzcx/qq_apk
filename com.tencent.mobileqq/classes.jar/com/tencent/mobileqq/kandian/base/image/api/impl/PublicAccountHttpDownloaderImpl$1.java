package com.tencent.mobileqq.kandian.base.image.api.impl;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class PublicAccountHttpDownloaderImpl$1
  implements Runnable
{
  PublicAccountHttpDownloaderImpl$1(PublicAccountHttpDownloaderImpl paramPublicAccountHttpDownloaderImpl, OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong) {}
  
  public void run()
  {
    try
    {
      PublicAccountHttpDownloaderImpl.access$601(this.this$0, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      if (this.a != null)
      {
        this.a.close();
        return;
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("PubAccountHttpDownloader", 1, localIOException.getMessage());
      PublicAccountHttpDownloaderImpl.access$700(this.this$0, this.b, this.d, this.e, this.f, localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */