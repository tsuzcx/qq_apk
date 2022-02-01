package com.tencent.mobileqq.hotpic;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HotPicOriginDownLoader
  extends HotPicDownLoader
{
  protected static URL b(String paramString)
  {
    try
    {
      paramString = new URL("hot_pic_origin", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected String a(HotPicData paramHotPicData)
  {
    return paramHotPicData.originalUrl;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    HotPicData localHotPicData = (HotPicData)paramDownloadParams.mExtraInfo;
    paramDownloadParams = a(localHotPicData);
    File localFile = a(paramDownloadParams);
    if (localFile.exists())
    {
      if (QLog.isColorLevel())
      {
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("loadImageFile file exist:");
        paramDownloadParams.append(localFile.getAbsolutePath());
        QLog.d("HotPicManager.HotPicOriginDownLoader", 2, paramDownloadParams.toString());
      }
      return localFile;
    }
    localFile.getParentFile().mkdirs();
    if ((Utils.a()) && (Utils.b() < 31457280L))
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("SD card free space is ");
      paramDownloadParams.append(Utils.b());
      throw new IOException(paramDownloadParams.toString());
    }
    Object localObject = new File(a);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    int i = a(paramDownloadParams, localFile);
    if (i == 0)
    {
      localObject = PortalUtils.a(localFile.getAbsolutePath());
      if (!localHotPicData.originalMD5.equalsIgnoreCase((String)localObject))
      {
        localFile.delete();
        paramURLDrawableHandler.onFileDownloadFailed(0);
        return null;
      }
      paramURLDrawableHandler.onFileDownloadSucceed(localFile.length());
      if (QLog.isColorLevel())
      {
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("url->");
        paramURLDrawableHandler.append(paramDownloadParams);
        paramURLDrawableHandler.append(" result->0");
        QLog.d("HotPicManager.HotPicOriginDownLoader", 2, paramURLDrawableHandler.toString());
      }
      return localFile;
    }
    if (QLog.isColorLevel())
    {
      paramURLDrawableHandler = new StringBuilder();
      paramURLDrawableHandler.append("url->");
      paramURLDrawableHandler.append(paramDownloadParams);
      paramURLDrawableHandler.append(" result->");
      paramURLDrawableHandler.append(i);
      QLog.d("HotPicManager.HotPicOriginDownLoader", 2, paramURLDrawableHandler.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicOriginDownLoader
 * JD-Core Version:    0.7.0.1
 */