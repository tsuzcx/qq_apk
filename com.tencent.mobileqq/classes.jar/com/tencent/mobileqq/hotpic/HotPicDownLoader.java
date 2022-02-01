package com.tencent.mobileqq.hotpic;

import android.os.SystemClock;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HotPicDownLoader
  extends ProtocolDownloader.Adapter
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("hotpic/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
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
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("hot_pic", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString).exists();
  }
  
  protected int a(String paramString, File paramFile)
  {
    paramString = new DownloadTask(paramString.replaceFirst("https", "http"), paramFile);
    paramString.e = 20000;
    paramString.n = true;
    paramString.b = 2;
    return DownloaderFactory.a(paramString, null, null);
  }
  
  protected String a(HotPicData paramHotPicData)
  {
    return paramHotPicData.url;
  }
  
  protected void a(int paramInt, HotPicData paramHotPicData)
  {
    if ((paramHotPicData instanceof EmotionSearchItem)) {
      EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(paramInt), 7);
    }
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    try
    {
      paramDownloadParams = a((HotPicData)paramDownloadParams.mExtraInfo);
      return a(paramDownloadParams);
    }
    catch (Exception paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return false;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = (HotPicData)paramDownloadParams.mExtraInfo;
    Object localObject2 = a(paramDownloadParams);
    int i;
    if ((paramDownloadParams instanceof HotPicSendData)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = a((String)localObject2);
    if (((File)localObject1).exists())
    {
      if ((i == 0) && (paramURLDrawableHandler != null))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onFileDownloadSucceed:");
          ((StringBuilder)localObject2).append(paramDownloadParams.picIndex);
          QLog.d("HotPicManager.HotPicDownLoader", 2, ((StringBuilder)localObject2).toString());
        }
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
      }
      return localObject1;
    }
    ((File)localObject1).getParentFile().mkdirs();
    if ((com.tencent.mobileqq.util.Utils.a()) && (com.tencent.mobileqq.util.Utils.b() < 31457280L))
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("SD card free space is ");
      paramDownloadParams.append(com.tencent.mobileqq.util.Utils.b());
      throw new IOException(paramDownloadParams.toString());
    }
    Object localObject3 = new File(a);
    if (!((File)localObject3).exists()) {
      ((File)localObject3).mkdir();
    }
    SystemClock.uptimeMillis();
    int j = a((String)localObject2, (File)localObject1);
    a(j, paramDownloadParams);
    if (j == 0)
    {
      localObject2 = PortalUtils.a(((File)localObject1).getAbsolutePath());
      localObject3 = paramDownloadParams.md5;
      if ((!paramDownloadParams.md5.equalsIgnoreCase((String)localObject2)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("md5 match fail: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localObject2);
        QLog.d("HotPicManager.HotPicDownLoader", 2, localStringBuilder.toString());
      }
      if (i == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onFileDownloadSucceed download:");
          ((StringBuilder)localObject2).append(paramDownloadParams.picIndex);
          ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
          QLog.d("HotPicManager.HotPicDownLoader", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
        }
      }
      return localObject1;
    }
    if (paramURLDrawableHandler != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onFileDownloadFailed:");
        ((StringBuilder)localObject1).append(paramDownloadParams.picIndex);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(j);
        QLog.d("HotPicManager.HotPicDownLoader", 2, ((StringBuilder)localObject1).toString());
      }
      paramURLDrawableHandler.onFileDownloadFailed(paramDownloadParams.picIndex);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicDownLoader
 * JD-Core Version:    0.7.0.1
 */