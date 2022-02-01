package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class CarrierImgDownloader
  extends HttpDownloader
{
  public static final int CARRIER_IMG_HEIGHT = 70;
  public static final int CARRIER_IMG_WIDTH = 70;
  public static final String PROTOCAL_CARRIER_IMG = "carrier";
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = new BitmapFactory.Options();
    paramURLDrawableHandler.inJustDecodeBounds = true;
    paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramURLDrawableHandler);
    float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    paramURLDrawableHandler.inSampleSize = (Math.min(paramURLDrawableHandler.outWidth, paramURLDrawableHandler.outHeight) / (int)(f * 70.0F + 0.5F));
    paramURLDrawableHandler.inJustDecodeBounds = false;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramURLDrawableHandler);
      return ImageUtil.c(ImageUtil.b(paramFile), 70, 70);
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        paramFile = paramDownloadParams;
      }
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams.url = new URL(paramDownloadParams.url.getFile());
    paramDownloadParams.urlStr = paramDownloadParams.url.toString();
    return super.downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.CarrierImgDownloader
 * JD-Core Version:    0.7.0.1
 */