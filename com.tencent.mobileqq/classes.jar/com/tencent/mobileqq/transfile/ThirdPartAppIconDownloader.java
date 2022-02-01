package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ThirdPartAppIconDownloader
  extends HttpDownloader
{
  public static final String PROTOCOL_THIRD_PART = "third_part";
  private float mDensity = 2.0F;
  
  public ThirdPartAppIconDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    try
    {
      this.mDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
      return;
    }
    catch (Exception paramBaseApplicationImpl) {}
  }
  
  public static Bitmap fixImageSize(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale((float)paramDouble1 / f1, (float)paramDouble2 / f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, (int)f1, (int)f2, (Matrix)localObject, true);
    if (localObject != paramBitmap) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = null;
    try
    {
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), null);
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      paramFile = paramDownloadParams;
    }
    catch (OutOfMemoryError paramFile)
    {
      paramFile.printStackTrace();
      paramFile = paramDownloadParams;
    }
    float f = this.mDensity;
    paramDownloadParams = fixImageSize(paramFile, f * 50.0F, f * 50.0F);
    int i = paramDownloadParams.getWidth();
    int j = paramDownloadParams.getHeight();
    paramFile = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    paramFile.setDensity(160);
    paramURLDrawableHandler = new Canvas(paramFile);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-16777216);
    Rect localRect = new Rect(0, 0, i, j);
    RectF localRectF = new RectF(localRect);
    f = this.mDensity * 10.0F;
    paramURLDrawableHandler.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    paramURLDrawableHandler.drawBitmap(paramDownloadParams, localRect, localRect, localPaint);
    try
    {
      if (!paramDownloadParams.isRecycled())
      {
        paramDownloadParams.recycle();
        return paramFile;
      }
    }
    catch (Throwable paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return paramFile;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    URL localURL = paramDownloadParams.url;
    paramDownloadParams.url = new URL("http", localURL.getAuthority(), localURL.getFile());
    return super.downloadImage(paramOutputStream, paramDownloadParams, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ThirdPartAppIconDownloader
 * JD-Core Version:    0.7.0.1
 */