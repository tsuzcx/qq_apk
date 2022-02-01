package com.tencent.mobileqq.hotpic;

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
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("hotvideo/preview/");
    a = localStringBuilder.toString();
  }
  
  public static Drawable a(Context paramContext, HotVideoData paramHotVideoData)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return new ColorDrawable(Color.parseColor("#7f000000"));
    }
    StringBuilder localStringBuilder = null;
    Object localObject1 = localStringBuilder;
    Object localObject2;
    if (paramHotVideoData != null)
    {
      localObject1 = localStringBuilder;
      if (paramHotVideoData.url != null)
      {
        localObject1 = localStringBuilder;
        if (paramHotVideoData.md5 != null)
        {
          if (paramContext == null) {
            return null;
          }
          localObject1 = localStringBuilder;
          if (a(paramHotVideoData.md5).exists())
          {
            localObject1 = com.tencent.image.Utils.Crc64String(paramHotVideoData.md5);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(a);
            localStringBuilder.append((String)localObject1);
            localObject1 = localStringBuilder.toString();
            try
            {
              localObject1 = BitmapFactory.decodeFile((String)localObject1);
              paramHotVideoData = (HotVideoData)localObject1;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              localOutOfMemoryError.printStackTrace();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("decodeFile hotVideo thum Bitmap OOM. hotVideo name is ");
              ((StringBuilder)localObject2).append(paramHotVideoData.name);
              QLog.e("HotPicManager.HotVideoPreviewDownloader", 1, ((StringBuilder)localObject2).toString());
              paramHotVideoData = null;
            }
            if (paramHotVideoData == null) {
              return null;
            }
            paramHotVideoData = HotVideoUtils.a(paramHotVideoData, 10.0F, paramContext);
            localObject2 = new BitmapDrawable(paramContext.getResources(), paramHotVideoData);
          }
        }
      }
    }
    return localObject2;
  }
  
  public static File a(String paramString)
  {
    try
    {
      paramString = com.tencent.image.Utils.Crc64String(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString);
      paramString = new File(localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramHotVideoData.md5);
    localStringBuilder.append(".jpg");
    return localStringBuilder.toString();
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
    Object localObject = paramFile;
    if (paramFile == null) {
      localObject = a(paramHotVideoData.md5);
    }
    paramFile = new File(a);
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    SystemClock.uptimeMillis();
    paramFile = new DownloadTask(paramHotVideoData.url.replaceFirst("https", "http"), (File)localObject);
    paramFile.n = true;
    paramFile.b = 2;
    int i = DownloaderFactory.a(paramFile, null, null);
    if (i == 0)
    {
      paramFile = PortalUtils.a(((File)localObject).getAbsolutePath());
      if (!paramHotVideoData.md5.equalsIgnoreCase(paramFile))
      {
        ((File)localObject).delete();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onFileDownloadFailed .md5.equalsIgnoreCase is false videoData.md5 is :");
        ((StringBuilder)localObject).append(paramHotVideoData.md5);
        ((StringBuilder)localObject).append(" fileMD5 is ");
        ((StringBuilder)localObject).append(paramFile);
        a(((StringBuilder)localObject).toString(), paramHotVideoData);
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadFailed(paramHotVideoData.picIndex);
        }
        paramHotVideoData.onFileDownloadFailed(paramHotVideoData.picIndex);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("onFileDownloadSucceed download:");
        paramFile.append(paramHotVideoData.picIndex);
        paramFile.append(((File)localObject).getAbsolutePath());
        QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, paramFile.toString());
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
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("onFileDownloadFailed:");
        paramFile.append(paramHotVideoData.picIndex);
        paramFile.append(" ");
        paramFile.append(i);
        QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, paramFile.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(" Time is :");
      localStringBuilder.append(((Calendar)localObject).get(11));
      localStringBuilder.append(":");
      localStringBuilder.append(((Calendar)localObject).get(12));
      localStringBuilder.append(":");
      localStringBuilder.append(((Calendar)localObject).get(13));
      localStringBuilder.append(":");
      localStringBuilder.append(((Calendar)localObject).get(14));
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      localObject = localStringBuilder.toString();
      paramString = (String)localObject;
      if (paramHotVideoData != null)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append(" PicIndex is ");
        paramString.append(paramHotVideoData.picIndex);
        paramString = paramString.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" Name is ");
        ((StringBuilder)localObject).append(paramHotVideoData.name);
        paramString = ((StringBuilder)localObject).toString();
      }
      QLog.d("HotPicManager.HotVideoPreviewDownloader", 2, paramString);
    }
  }
  
  public static boolean a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData != null)
    {
      if (paramHotVideoData.md5 == null) {
        return false;
      }
      paramHotVideoData = a(paramHotVideoData.md5);
      if (paramHotVideoData != null) {
        return paramHotVideoData.exists();
      }
    }
    return false;
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
        paramFile = new StringBuilder();
        paramFile.append("Override decodeFile hotVideo thum Bitmap OOM. HotVideo name is ");
        paramFile.append(paramDownloadParams.name);
        QLog.e("HotPicManager.HotVideoPreviewDownloader", 1, paramFile.toString());
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
    if ((com.tencent.mobileqq.util.Utils.a()) && (com.tencent.mobileqq.util.Utils.b() < 31457280L))
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("SD card free space is ");
      paramDownloadParams.append(com.tencent.mobileqq.util.Utils.b());
      throw new IOException(paramDownloadParams.toString());
    }
    if (paramDownloadParams.url.isEmpty())
    {
      paramDownloadParams.GetPreviewURLAsync((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 0, "0", new HotVideoPreviewDownloader.1(this, paramDownloadParams, localFile, paramURLDrawableHandler));
      return localFile;
    }
    a(localFile, paramDownloadParams, paramURLDrawableHandler);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader
 * JD-Core Version:    0.7.0.1
 */