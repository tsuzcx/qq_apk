package com.tencent.mobileqq.hotpic;

import adrl;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class HotVideoPreviewDownloader
  extends ProtocolDownloader.Adapter
{
  public static final String a = AppConstants.aJ + "hotvideo/preview/";
  
  public static Drawable a(Context paramContext, HotVideoData paramHotVideoData)
  {
    Object localObject2 = null;
    Object localObject1;
    if (Build.VERSION.SDK_INT < 17) {
      localObject1 = new ColorDrawable(Color.parseColor("#7f000000"));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return localObject1;
                localObject1 = localObject2;
              } while (paramHotVideoData == null);
              localObject1 = localObject2;
            } while (paramHotVideoData.url == null);
            localObject1 = localObject2;
          } while (paramHotVideoData.md5 == null);
          localObject1 = localObject2;
        } while (paramContext == null);
        localObject1 = localObject2;
      } while (!a(paramHotVideoData.md5).exists());
      localObject1 = com.tencent.image.Utils.Crc64String(paramHotVideoData.md5);
      localObject1 = a + (String)localObject1;
      try
      {
        localObject1 = BitmapFactory.decodeFile((String)localObject1);
        paramHotVideoData = (HotVideoData)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
          QLog.e("HotPicManager.HotVideoPreviewDownloader", 1, "decodeFile hotVideo thum Bitmap OOM. hotVideo name is " + paramHotVideoData.name);
          paramHotVideoData = null;
        }
      }
      localObject1 = localObject2;
    } while (paramHotVideoData == null);
    paramHotVideoData = HotVideoUtils.a(paramHotVideoData, 10.0F, paramContext);
    return new BitmapDrawable(paramContext.getResources(), paramHotVideoData);
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = com.tencent.image.Utils.Crc64String(paramString);
      paramString = new File(a + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return null;
    }
    return a + paramHotVideoData.md5 + ".jpg";
  }
  
  public static URL a(HotVideoData paramHotVideoData)
  {
    paramHotVideoData = a(paramHotVideoData);
    try
    {
      paramHotVideoData = new URL("hot_video_preview", "", paramHotVideoData);
      return paramHotVideoData;
    }
    catch (MalformedURLException paramHotVideoData)
    {
      paramHotVideoData.printStackTrace();
    }
    return null;
  }
  
  private void a(File paramFile, HotVideoData paramHotVideoData, URLDrawableHandler paramURLDrawableHandler)
  {
    File localFile = paramFile;
    if (paramFile == null) {
      localFile = a(paramHotVideoData.md5);
    }
    paramFile = new File(a);
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    SystemClock.uptimeMillis();
    paramFile = new DownloadTask(paramHotVideoData.url.replaceFirst("https", "http"), localFile);
    paramFile.l = true;
    paramFile.b = 2;
    int i = DownloaderFactory.a(paramFile, null, null);
    if (i == 0)
    {
      paramFile = PortalUtils.a(localFile.getAbsolutePath());
      if (!paramHotVideoData.md5.equalsIgnoreCase(paramFile))
      {
        localFile.delete();
        a("onFileDownloadFailed .md5.equalsIgnoreCase is false videoData.md5 is :" + paramHotVideoData.md5 + " fileMD5 is " + paramFile, paramHotVideoData);
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadFailed(paramHotVideoData.picIndex);
        }
        paramHotVideoData.onFileDownloadFailed(paramHotVideoData.picIndex);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, "onFileDownloadSucceed download:" + paramHotVideoData.picIndex + localFile.getAbsolutePath());
      }
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadSucceed(paramHotVideoData.picIndex);
      }
      paramHotVideoData.onFileDownloadSucceed(paramHotVideoData.picIndex);
      a("DownloadFile: onFileDownloadSucceed End", paramHotVideoData);
      return;
    }
    if (paramURLDrawableHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, "onFileDownloadFailed:" + paramHotVideoData.picIndex + " " + i);
      }
      paramURLDrawableHandler.onFileDownloadFailed(paramHotVideoData.picIndex);
    }
    paramHotVideoData.onFileDownloadFailed(paramHotVideoData.picIndex);
    a("DownloadFile: onFileDownloadFailed End", paramHotVideoData);
  }
  
  private static void a(String paramString, HotVideoData paramHotVideoData)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = Calendar.getInstance();
      localObject = "" + " Time is :" + ((Calendar)localObject).get(11) + ":" + ((Calendar)localObject).get(12) + ":" + ((Calendar)localObject).get(13) + ":" + ((Calendar)localObject).get(14);
      localObject = (String)localObject + " " + paramString;
      paramString = (String)localObject;
      if (paramHotVideoData != null)
      {
        paramString = (String)localObject + " PicIndex is " + paramHotVideoData.picIndex;
        paramString = paramString + " Name is " + paramHotVideoData.name;
      }
      QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, paramString);
    }
  }
  
  public static boolean a(HotVideoData paramHotVideoData)
  {
    if ((paramHotVideoData == null) || (paramHotVideoData.md5 == null)) {}
    do
    {
      return false;
      paramHotVideoData = a(paramHotVideoData.md5);
    } while ((paramHotVideoData == null) || (!paramHotVideoData.exists()));
    return true;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = (HotVideoData)paramDownloadParams.mExtraInfo;
    paramURLDrawableHandler = PortalUtils.a(paramFile.getAbsolutePath());
    if (paramDownloadParams.md5.equalsIgnoreCase(paramURLDrawableHandler)) {
      try
      {
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        return paramFile;
      }
      catch (OutOfMemoryError paramFile)
      {
        paramFile.printStackTrace();
        QLog.e("HotPicManager.HotVideoPreviewDownloader", 1, "Override decodeFile hotVideo thum Bitmap OOM. HotVideo name is " + paramDownloadParams.name);
        return null;
      }
    }
    return null;
  }
  
  @TargetApi(9)
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = (HotVideoData)paramDownloadParams.mExtraInfo;
    paramDownloadParams.onFileDownloadStarted();
    File localFile = a(paramDownloadParams.md5);
    if (localFile.exists())
    {
      paramDownloadParams.onFileDownloadSucceed(paramDownloadParams.picIndex);
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
      }
      return localFile;
    }
    if ((com.tencent.mobileqq.util.Utils.a()) && (com.tencent.mobileqq.util.Utils.b() < 20971520L)) {
      throw new IOException("SD card free space is " + com.tencent.mobileqq.util.Utils.b());
    }
    if (paramDownloadParams.url.isEmpty())
    {
      paramDownloadParams.GetPreviewURLAsync((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0, "0", new adrl(this, paramDownloadParams, localFile, paramURLDrawableHandler));
      return localFile;
    }
    a(localFile, paramDownloadParams, paramURLDrawableHandler);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader
 * JD-Core Version:    0.7.0.1
 */