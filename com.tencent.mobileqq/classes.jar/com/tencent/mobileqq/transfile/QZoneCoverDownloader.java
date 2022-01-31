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
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "downloadImage|config.urlStr = " + paramDownloadParams.urlStr);
    }
    paramOutputStream = paramDownloadParams.url.getFile();
    paramDownloadParams = paramDownloadParams.url.getHost();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "downloadImage|host = " + paramDownloadParams + ", url = " + paramOutputStream);
    }
    paramOutputStream = a(paramOutputStream);
    if (TextUtils.isEmpty(paramOutputStream)) {
      throw new RuntimeException("downloadImage|url is null");
    }
    paramDownloadParams = CacheManager.a(BaseApplication.getContext(), paramOutputStream);
    if (QLog.isColorLevel())
    {
      QLog.i("Q.qzonecover.", 2, "downloadImage|path = " + paramDownloadParams);
      if (!FileUtils.b(paramDownloadParams)) {
        break label198;
      }
      QLog.i("Q.qzonecover.", 2, "downloadImage|file exist and not empty");
    }
    while (paramDownloadParams == null)
    {
      throw new RuntimeException("downloadImage|file not exist, path = " + paramDownloadParams);
      label198:
      QLog.i("Q.qzonecover.", 2, "downloadImage|file not exist or empty!!");
    }
    paramURLDrawableHandler = new File(paramDownloadParams);
    if ((paramURLDrawableHandler.exists()) || ((paramOutputStream.startsWith("http://")) && (DownloaderFactory.a(new DownloadTask(paramOutputStream, paramURLDrawableHandler), null) == 0) && (paramURLDrawableHandler.exists()))) {
      return paramURLDrawableHandler;
    }
    throw new RuntimeException("downloadImage|file not exist, path = " + paramDownloadParams);
  }
  
  protected String a(String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.indexOf("http", 0);
      if ((i <= 0) || (i >= paramString.length())) {}
    }
    for (String str = paramString.substring(i);; str = paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qzonecover.", 2, "dealUrl|in: " + paramString + ", out: " + str);
      }
      return str;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qzonecover.", 2, "decodeFile() url = " + paramDownloadParams.url + ", path = " + paramFile.getAbsolutePath());
    }
    try
    {
      paramFile = super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.i("Q.qzonecover.", 2, "decodeFile() exception: " + paramFile.toString());
      paramFile.printStackTrace();
      throw paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QZoneCoverDownloader
 * JD-Core Version:    0.7.0.1
 */