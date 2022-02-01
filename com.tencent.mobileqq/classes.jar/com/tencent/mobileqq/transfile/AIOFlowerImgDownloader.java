package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class AIOFlowerImgDownloader
  extends HttpDownloader
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = new BitmapFactory.Options();
    paramDownloadParams.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramDownloadParams);
    float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    paramDownloadParams.inSampleSize = ((int)Math.min(paramDownloadParams.outWidth / (115.0F * f + 0.5F), paramDownloadParams.outHeight / (f * 105.0F + 0.5F)));
    paramDownloadParams.inJustDecodeBounds = false;
    paramURLDrawableHandler = null;
    try
    {
      paramDownloadParams = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramDownloadParams);
    }
    catch (OutOfMemoryError paramFile)
    {
      label91:
      int i;
      int j;
      label229:
      break label91;
    }
    paramDownloadParams = null;
    if (paramDownloadParams == null) {
      return null;
    }
    i = paramDownloadParams.getWidth();
    j = paramDownloadParams.getHeight();
    paramFile = paramURLDrawableHandler;
    try
    {
      paramURLDrawableHandler = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      paramFile = paramURLDrawableHandler;
      paramURLDrawableHandler.setDensity(160);
      paramFile = paramURLDrawableHandler;
      Canvas localCanvas = new Canvas(paramURLDrawableHandler);
      paramFile = paramURLDrawableHandler;
      Paint localPaint = new Paint(1);
      paramFile = paramURLDrawableHandler;
      localPaint.setColor(-16777216);
      paramFile = paramURLDrawableHandler;
      BaseApplicationImpl.getApplication();
      paramFile = paramURLDrawableHandler;
      Rect localRect = new Rect(0, 0, i, j - (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 5.0F));
      paramFile = paramURLDrawableHandler;
      localCanvas.drawBitmap(paramDownloadParams, localRect, new RectF(localRect), localPaint);
      paramFile = paramURLDrawableHandler;
    }
    catch (OutOfMemoryError paramURLDrawableHandler)
    {
      break label229;
    }
    if (!paramDownloadParams.isRecycled()) {
      paramDownloadParams.recycle();
    }
    return paramFile;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    URL localURL = paramDownloadParams.url;
    String str = paramDownloadParams.urlStr;
    paramDownloadParams.url = new URL(paramDownloadParams.url.getFile());
    paramDownloadParams.urlStr = paramDownloadParams.url.toString();
    if (QLog.isDevelopLevel()) {
      QLog.i("AIOFlowerImgDownloader", 4, paramDownloadParams.urlStr);
    }
    paramOutputStream = super.downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
    paramDownloadParams.url = localURL;
    paramDownloadParams.urlStr = str;
    return paramOutputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AIOFlowerImgDownloader
 * JD-Core Version:    0.7.0.1
 */