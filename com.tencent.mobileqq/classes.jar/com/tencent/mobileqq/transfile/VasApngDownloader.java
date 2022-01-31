package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class VasApngDownloader
  extends AbsDownloader
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return null;
    }
    paramURLDrawableHandler = paramDownloadParams.url.getHost();
    File localFile = new File(paramURLDrawableHandler);
    label42:
    long l;
    int i;
    if ((paramDownloadParams.mExtraInfo instanceof Bundle))
    {
      paramOutputStream = (Bundle)paramDownloadParams.mExtraInfo;
      if (paramOutputStream == null) {
        break label413;
      }
      l = paramOutputStream.getLong("bundle_key_bid", 0L);
      paramOutputStream = paramOutputStream.getString("bundle_key_scid");
      if ((l == 0L) || (TextUtils.isEmpty(paramOutputStream))) {
        break label95;
      }
      i = 1;
    }
    for (;;)
    {
      if (localFile.exists())
      {
        return localFile;
        paramOutputStream = null;
        break label42;
        label95:
        i = 0;
        continue;
      }
      if (i != 0)
      {
        VasQuickUpdateManager.a(BaseApplicationImpl.sApplication.getRuntime(), l, paramOutputStream, null, true, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage method err, scid=" + paramOutputStream + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramDownloadParams = paramDownloadParams.url.getFile();
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        QLog.e("vasapngdownloader", 2, "downloadImage url err, url=" + paramDownloadParams + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith(File.separator)) {
        paramOutputStream = paramDownloadParams.substring(1);
      }
      if (!paramOutputStream.startsWith("http"))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage url has no http err, url=" + paramOutputStream + ", path=" + paramURLDrawableHandler);
        return null;
      }
      i = DownloaderFactory.a(new DownloadTask(paramOutputStream, localFile), BaseApplicationImpl.sApplication.getRuntime());
      if (i == 0)
      {
        if (localFile.exists()) {
          return localFile;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage file not exists, url=" + paramOutputStream + ", path=" + paramURLDrawableHandler + ", ret:" + i);
        return null;
      }
      QLog.e("vasapngdownloader", 1, "downloadImage Error url=" + paramOutputStream + ", path=" + paramURLDrawableHandler + ", ret:" + i);
      return null;
      label413:
      i = 0;
      paramOutputStream = null;
      l = 0L;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    paramURLDrawableHandler = localObject2;
    if (paramFile != null)
    {
      paramURLDrawableHandler = localObject2;
      if (paramFile.exists())
      {
        paramURLDrawableHandler = localObject2;
        if (paramDownloadParams != null)
        {
          paramURLDrawableHandler = localObject2;
          if (paramDownloadParams.useApngImage)
          {
            paramURLDrawableHandler = localObject1;
            if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
              paramURLDrawableHandler = (Bundle)paramDownloadParams.mExtraInfo;
            }
            paramURLDrawableHandler = new VasApngDownloader.VasApngImage(paramFile, true, paramURLDrawableHandler);
            if (paramURLDrawableHandler.firstFrame == null) {
              ChatBackgroundManager.a(paramFile.getAbsolutePath());
            }
          }
        }
      }
    }
    return paramURLDrawableHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasApngDownloader
 * JD-Core Version:    0.7.0.1
 */