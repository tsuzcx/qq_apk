package com.tencent.mobileqq.qwallet.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class QWalletPicDownloader
  extends AbsDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      if ((paramFile != null) && (paramFile.exists()) && (paramDownloadParams.useApngImage) && ("png".equals(FileUtils.estimateFileType(paramFile.getPath()))))
      {
        if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
          paramDownloadParams = (Bundle)paramDownloadParams.mExtraInfo;
        } else {
          paramDownloadParams = null;
        }
        paramDownloadParams = new ApngImage(paramFile, true, paramDownloadParams);
        if (paramDownloadParams.firstFrame == null) {
          ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).QWalletPicDownloader$reportDeviceCantPlayBackground(paramFile.getAbsolutePath());
        }
        return paramDownloadParams;
      }
      paramDownloadParams.useApngImage = false;
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return null;
    }
    String str = paramDownloadParams.url.getHost();
    File localFile = new File(str);
    if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
      paramOutputStream = (Bundle)paramDownloadParams.mExtraInfo;
    } else {
      paramOutputStream = null;
    }
    if (paramOutputStream != null) {
      paramOutputStream = paramOutputStream.getString("qwallet_config_md5", "");
    } else {
      paramOutputStream = "";
    }
    if ((localFile.exists()) && (TextUtils.isEmpty(paramOutputStream))) {
      return localFile;
    }
    paramURLDrawableHandler = paramDownloadParams.url.getFile();
    if (TextUtils.isEmpty(paramURLDrawableHandler))
    {
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("downloadImage url err, url=");
      paramOutputStream.append(paramURLDrawableHandler);
      paramOutputStream.append(", path=");
      paramOutputStream.append(str);
      QLog.e("QWalletPicDownloader", 2, paramOutputStream.toString());
      return null;
    }
    paramDownloadParams = paramURLDrawableHandler;
    if (paramURLDrawableHandler.startsWith(File.separator)) {
      paramDownloadParams = paramURLDrawableHandler.substring(1);
    }
    if (!paramDownloadParams.startsWith("http"))
    {
      if (QLog.isColorLevel())
      {
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage url has no http err, url=");
        paramOutputStream.append(paramDownloadParams);
        paramOutputStream.append(", path=");
        paramOutputStream.append(str);
        QLog.e("QWalletPicDownloader", 2, paramOutputStream.toString());
      }
      return null;
    }
    paramURLDrawableHandler = new DownloadParam();
    paramURLDrawableHandler.url = paramDownloadParams;
    paramURLDrawableHandler.md5 = paramOutputStream;
    paramURLDrawableHandler.useQWalletConfig = true;
    paramOutputStream = new AtomicBoolean(false);
    PreloadStaticApi.a().getResPath(paramURLDrawableHandler, new QWalletPicDownloader.1(this, localFile, paramOutputStream));
    if (!paramOutputStream.get()) {
      try
      {
        boolean bool = paramOutputStream.get();
        if (!bool) {
          try
          {
            localFile.wait(30000L);
          }
          catch (InterruptedException paramOutputStream)
          {
            QLog.e("QWalletPicDownloader", 1, paramOutputStream, new Object[0]);
          }
        }
        return localFile;
      }
      finally {}
    }
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPicDownloader
 * JD-Core Version:    0.7.0.1
 */