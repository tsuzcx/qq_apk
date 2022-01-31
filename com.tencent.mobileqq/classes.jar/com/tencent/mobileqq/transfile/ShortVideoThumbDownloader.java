package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;

public class ShortVideoThumbDownloader
  extends AbsDownloader
{
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = paramFile.getAbsolutePath();
    if (!FileUtils.b(paramFile)) {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoThumbDownloader", 2, "decodeFile file not exits. just return");
      }
    }
    do
    {
      return null;
      paramDownloadParams = new BitmapFactory.Options();
      paramDownloadParams.inDensity = 160;
      paramDownloadParams.inTargetDensity = 160;
      paramDownloadParams.inScreenDensity = 160;
      try
      {
        paramFile = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramFile)), null, paramDownloadParams);
        return paramFile;
      }
      catch (OutOfMemoryError paramFile) {}
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoThumbDownloader", 2, "decodeFile : OutOfMemoryError ", paramFile);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */