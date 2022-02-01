package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class DataLineDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  private static final String TAG = "_dataline_file";
  protected BaseApplicationImpl application;
  
  public DataLineDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.application = paramBaseApplicationImpl;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private Bitmap makeThumb(DataLineDownloader.DatalineDownLoadInfo paramDatalineDownLoadInfo)
  {
    if (paramDatalineDownLoadInfo == null) {
      return null;
    }
    int k = paramDatalineDownLoadInfo.photoInfo.thumbWidth;
    int m = paramDatalineDownLoadInfo.photoInfo.thumbHeight;
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inDensity = 160;
        localOptions.inTargetDensity = 160;
        localOptions.inScreenDensity = 160;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramDatalineDownLoadInfo.photoInfo.path, localOptions);
        j = 0;
        int i = 0;
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = calculateInSampleSize(localOptions, k, m);
        Object localObject1 = FilePicURLDrawlableHelper.a(paramDatalineDownLoadInfo.photoInfo.path, localOptions);
        k = AIOUtils.b(135.0F, BaseApplicationImpl.getContext().getResources());
        if (localOptions.outHeight > localOptions.outWidth * 2.0F)
        {
          j = (int)((localOptions.outHeight - localOptions.outWidth * 2.0F) / 2.0F);
          localOptions.outHeight = ((int)(localOptions.outWidth * 2.0F));
        }
        else
        {
          i = j;
          if (localOptions.outWidth <= localOptions.outHeight * 2.0F) {
            break label370;
          }
          i = (int)((localOptions.outWidth - localOptions.outHeight * 2.0F) / 2.0F);
          localOptions.outWidth = ((int)(localOptions.outHeight * 2.0F));
          break label370;
        }
        Object localObject2 = Bitmap.createBitmap((Bitmap)localObject1, i, j, localOptions.outWidth, localOptions.outHeight);
        if (localOptions.outWidth <= k)
        {
          localObject1 = localObject2;
          if (localOptions.outHeight <= k) {}
        }
        else
        {
          localObject1 = ImageUtil.a((Bitmap)localObject2, k);
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = ((IPicUtil)QRoute.api(IPicUtil.class)).getExifBitmap(paramDatalineDownLoadInfo.photoInfo.path, (Bitmap)localObject1);
        }
        return localObject2;
      }
      catch (OutOfMemoryError paramDatalineDownLoadInfo)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("_dataline_file", 2, "make Thumb OOM ", paramDatalineDownLoadInfo);
          return null;
        }
      }
      catch (Exception paramDatalineDownLoadInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("_dataline_file", 2, "make Thumb ", paramDatalineDownLoadInfo);
        }
      }
      return null;
      label370:
      int j = 0;
    }
  }
  
  public int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt1 != -1) && (paramInt2 != -1))
    {
      int j = paramOptions.outHeight;
      int k = paramOptions.outWidth;
      while ((j > paramInt2) && (k > paramInt1))
      {
        int m = Math.round(j / paramInt2);
        int n = Math.round(k / paramInt1);
        if (m >= n) {
          m = n;
        }
        if (m < 2) {
          break;
        }
        k /= 2;
        j /= 2;
        i *= 2;
      }
      return i;
    }
    if (paramOptions.outWidth * paramOptions.outHeight > 5000000)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("calculateInSampleSize options.outWidth*options.outHeight=");
        localStringBuilder.append(paramOptions.outWidth * paramOptions.outHeight);
        QLog.d("_dataline_file", 2, localStringBuilder.toString());
      }
      return 2;
    }
    return 1;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    Object localObject = new DataLineDownloader.VideoBitmapDecoder(this);
    localObject = paramURLDrawableHandler.getThumb(paramDownloadParams.url, (BitmapDecoder)localObject);
    paramURLDrawableHandler = (URLDrawableHandler)localObject;
    if (localObject == null)
    {
      paramURLDrawableHandler = BaseApplicationImpl.getContext();
      int i = FileManagerUtil.c(paramFile.getPath());
      paramURLDrawableHandler = drawableToBitmap(paramURLDrawableHandler.getResources().getDrawable(FileManagerUtil.c(i)));
    }
    paramFile = parseUrl(paramDownloadParams.url);
    if ((paramFile != null) && (paramFile.isDrawRound))
    {
      paramFile = ImageUtil.a(paramURLDrawableHandler, AIOUtils.b(12.0F, BaseApplicationImpl.getContext().getResources()));
      paramURLDrawableHandler.recycle();
      return paramFile;
    }
    return paramURLDrawableHandler;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = parseUrl(paramDownloadParams.url);
    if (paramOutputStream != null) {
      return new File(paramOutputStream.photoInfo.path);
    }
    return new File(AppConstants.SDCARD_ROOT);
  }
  
  public DataLineDownloader.DatalineDownLoadInfo parseUrl(URL paramURL)
  {
    try
    {
      DataLineDownloader.DatalineDownLoadInfo localDatalineDownLoadInfo = new DataLineDownloader.DatalineDownLoadInfo(this);
      paramURL = paramURL.getFile().split("\\|");
      localDatalineDownLoadInfo.photoInfo = new LocalMediaInfo();
      localDatalineDownLoadInfo.photoInfo.path = paramURL[0];
      localDatalineDownLoadInfo.photoInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localDatalineDownLoadInfo.photoInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      localDatalineDownLoadInfo.photoInfo.modifiedDate = Long.parseLong(paramURL[3]);
      localDatalineDownLoadInfo.isDrawRound = Boolean.parseBoolean(paramURL[4]);
      return localDatalineDownLoadInfo;
    }
    catch (Exception paramURL)
    {
      label92:
      break label92;
    }
    return null;
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DataLineDownloader
 * JD-Core Version:    0.7.0.1
 */