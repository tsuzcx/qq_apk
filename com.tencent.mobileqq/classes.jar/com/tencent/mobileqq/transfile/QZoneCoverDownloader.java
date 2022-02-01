package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class QZoneCoverDownloader
  extends AbsDownloader
{
  protected static final String TAG = "Q.qzonecover.";
  
  protected String dealUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf("http", 0);
      if ((i > 0) && (i < paramString.length()))
      {
        str = paramString.substring(i);
        break label38;
      }
    }
    String str = paramString;
    label38:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dealUrl|in: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", out: ");
      localStringBuilder.append(str);
      QLog.i("Q.qzonecover.", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeFile() url = ");
      localStringBuilder.append(paramDownloadParams.url);
      localStringBuilder.append(", path = ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      QLog.i("Q.qzonecover.", 2, localStringBuilder.toString());
    }
    try
    {
      paramFile = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("decodeFile() exception: ");
      paramDownloadParams.append(paramFile.toString());
      QLog.i("Q.qzonecover.", 2, paramDownloadParams.toString());
      paramFile.printStackTrace();
      throw paramFile;
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel())
    {
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("downloadImage|config.urlStr = ");
      paramOutputStream.append(paramDownloadParams.urlStr);
      QLog.i("Q.qzonecover.", 2, paramOutputStream.toString());
    }
    paramOutputStream = paramDownloadParams.url.getFile();
    paramDownloadParams = paramDownloadParams.url.getHost();
    if (QLog.isColorLevel())
    {
      paramURLDrawableHandler = new StringBuilder();
      paramURLDrawableHandler.append("downloadImage|host = ");
      paramURLDrawableHandler.append(paramDownloadParams);
      paramURLDrawableHandler.append(", url = ");
      paramURLDrawableHandler.append(paramOutputStream);
      QLog.i("Q.qzonecover.", 2, paramURLDrawableHandler.toString());
    }
    paramDownloadParams = dealUrl(paramOutputStream);
    if (!TextUtils.isEmpty(paramDownloadParams))
    {
      paramOutputStream = CacheManager.getImageFilePath(BaseApplication.getContext(), paramDownloadParams);
      if (QLog.isColorLevel())
      {
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("downloadImage|path = ");
        paramURLDrawableHandler.append(paramOutputStream);
        QLog.i("Q.qzonecover.", 2, paramURLDrawableHandler.toString());
        if (FileUtils.fileExistsAndNotEmpty(paramOutputStream)) {
          QLog.i("Q.qzonecover.", 2, "downloadImage|file exist and not empty");
        } else {
          QLog.i("Q.qzonecover.", 2, "downloadImage|file not exist or empty!!");
        }
      }
      if (paramOutputStream != null)
      {
        paramURLDrawableHandler = new File(paramOutputStream);
        if (!paramURLDrawableHandler.exists())
        {
          if (((paramDownloadParams.startsWith("http://")) || (paramDownloadParams.startsWith("https://"))) && (DownloaderFactory.a(new DownloadTask(paramDownloadParams, paramURLDrawableHandler), null) == 0) && (paramURLDrawableHandler.exists())) {
            return paramURLDrawableHandler;
          }
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("downloadImage|file not exist, path = ");
          paramDownloadParams.append(paramOutputStream);
          throw new RuntimeException(paramDownloadParams.toString());
        }
        return paramURLDrawableHandler;
      }
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("downloadImage|file not exist, path = ");
      paramDownloadParams.append(paramOutputStream);
      throw new RuntimeException(paramDownloadParams.toString());
    }
    throw new RuntimeException("downloadImage|url is null");
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QZoneCoverDownloader
 * JD-Core Version:    0.7.0.1
 */