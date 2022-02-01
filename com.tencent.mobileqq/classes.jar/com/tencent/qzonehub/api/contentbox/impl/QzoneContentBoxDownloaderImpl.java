package com.tencent.qzonehub.api.contentbox.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneContentBoxDownloader;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class QzoneContentBoxDownloaderImpl
  extends AbsDownloader
  implements IQzoneContentBoxDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = null;
    if ((paramFile != null) && (paramFile.exists()) && (paramDownloadParams != null) && (paramDownloadParams.useApngImage) && (ApngDrawable.isApngFile(paramFile)))
    {
      if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
        paramURLDrawableHandler = (Bundle)paramDownloadParams.mExtraInfo;
      }
      paramURLDrawableHandler = new ApngImage(paramFile, true, paramURLDrawableHandler);
      paramDownloadParams = paramURLDrawableHandler;
      if (paramURLDrawableHandler.firstFrame == null)
      {
        ChatBackgroundManager.a(paramFile.getAbsolutePath());
        return paramURLDrawableHandler;
      }
    }
    else
    {
      if (paramDownloadParams != null) {
        paramDownloadParams.useApngImage = false;
      }
      paramDownloadParams = null;
    }
    return paramDownloadParams;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return null;
    }
    paramURLDrawableHandler = paramDownloadParams.url.getHost();
    File localFile = new File(paramURLDrawableHandler);
    int i;
    if (!localFile.exists())
    {
      paramDownloadParams = paramDownloadParams.url.getFile();
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage url err, url=");
        paramOutputStream.append(paramDownloadParams);
        paramOutputStream.append(", path=");
        paramOutputStream.append(paramURLDrawableHandler);
        QLog.e("qzonecontentboxdownloader", 2, paramOutputStream.toString());
        return null;
      }
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith(File.separator)) {
        paramOutputStream = paramDownloadParams.substring(1);
      }
      if (!paramOutputStream.startsWith("http"))
      {
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("downloadImage url has no http err, url=");
          paramDownloadParams.append(paramOutputStream);
          paramDownloadParams.append(", path=");
          paramDownloadParams.append(paramURLDrawableHandler);
          QLog.e("qzonecontentboxdownloader", 2, paramDownloadParams.toString());
        }
        return null;
      }
      i = DownloaderFactory.a(new DownloadTask(paramOutputStream, localFile), BaseApplicationImpl.sApplication.getRuntime());
      if (i != 0) {
        break label272;
      }
      if (!localFile.exists()) {}
    }
    else
    {
      return localFile;
    }
    paramDownloadParams = new StringBuilder();
    paramDownloadParams.append("downloadImage file not exists, url=");
    paramDownloadParams.append(paramOutputStream);
    paramDownloadParams.append(", path=");
    paramDownloadParams.append(paramURLDrawableHandler);
    paramDownloadParams.append(", ret:");
    paramDownloadParams.append(i);
    QLog.e("qzonecontentboxdownloader", 1, paramDownloadParams.toString());
    return null;
    label272:
    paramDownloadParams = new StringBuilder();
    paramDownloadParams.append("downloadImage Error url=");
    paramDownloadParams.append(paramOutputStream);
    paramDownloadParams.append(", path=");
    paramDownloadParams.append(paramURLDrawableHandler);
    paramDownloadParams.append(", ret:");
    paramDownloadParams.append(i);
    QLog.e("qzonecontentboxdownloader", 1, paramDownloadParams.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.contentbox.impl.QzoneContentBoxDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */