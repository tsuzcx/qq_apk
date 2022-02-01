package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AIOPhotoImageDownloader
  extends ChatImageDownloader
  implements ProtocolDownloaderConstants
{
  private static final String TAG = "AIOPhotoImageDownloader";
  
  public AIOPhotoImageDownloader(BaseApplication paramBaseApplication)
  {
    super(paramBaseApplication);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      paramURLDrawableHandler.publishProgress(9900);
      paramURLDrawableHandler = paramDownloadParams.urlStr;
      boolean bool1 = "aiothumb".equals(paramDownloadParams.url.getProtocol());
      boolean bool2 = QLog.isColorLevel();
      if (bool2)
      {
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("DecodeFile START,cacheFile=");
        paramDownloadParams.append(paramFile.getAbsolutePath());
        paramDownloadParams.append(",url=");
        paramDownloadParams.append(paramURLDrawableHandler);
        log("AIOPhotoImageDownloader", "DecodeFile", paramDownloadParams.toString());
      }
      if ((GifDrawable.isGifFile(paramFile)) && (!bool1))
      {
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("DecodeFile END,GIF image,cacheFile=");
          paramDownloadParams.append(paramFile.getAbsolutePath());
          paramDownloadParams.append(",url=");
          paramDownloadParams.append(paramURLDrawableHandler);
          log("AIOPhotoImageDownloader", "DecodeFile", paramDownloadParams.toString());
          return null;
        }
      }
      else
      {
        paramDownloadParams = new BitmapFactory.Options();
        paramDownloadParams.inPreferredConfig = Bitmap.Config.ARGB_8888;
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        if (bool1) {
          try
          {
            paramDownloadParams.inJustDecodeBounds = false;
            paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramDownloadParams);
            if (paramDownloadParams != null) {
              return new ExifBitmapCreator(paramFile.getAbsolutePath()).creatBitmap(paramDownloadParams);
            }
            paramFile.delete();
            throw new IOException("step:decode error, not valid pic");
          }
          catch (OutOfMemoryError paramFile)
          {
            throw paramFile;
          }
        }
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("DecodeFile END,is not Thumb,cacheFile=");
          paramDownloadParams.append(paramFile.getAbsolutePath());
          paramDownloadParams.append(",url=");
          paramDownloadParams.append(paramURLDrawableHandler);
          log("AIOPhotoImageDownloader", "DecodeFile", paramDownloadParams.toString());
        }
        return null;
      }
    }
    catch (Exception paramURLDrawableHandler)
    {
      paramDownloadParams = ProcessorReport.getExceptionMessage(paramURLDrawableHandler);
      if (paramDownloadParams != null)
      {
        paramFile = paramDownloadParams;
        if (paramDownloadParams.length() != 0) {}
      }
      else
      {
        paramFile = paramURLDrawableHandler.toString();
      }
      if (QLog.isColorLevel())
      {
        QLog.e("AIOPhotoImageDownloader", 2, paramFile);
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("DecodeFile FAIL,exceptionmsg:");
        paramDownloadParams.append(paramFile);
        log("AIOPhotoImageDownloader", "DecodeFile", paramDownloadParams.toString());
      }
      throw paramURLDrawableHandler;
    }
    return null;
  }
  
  public String getUrl(String paramString)
  {
    return AbsDownloader.covertUrlForAioImage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AIOPhotoImageDownloader
 * JD-Core Version:    0.7.0.1
 */