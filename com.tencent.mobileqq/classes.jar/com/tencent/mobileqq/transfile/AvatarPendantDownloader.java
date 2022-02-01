package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class AvatarPendantDownloader
  extends AbsDownloader
{
  public static final String PROTOCOL_PENDANT_IMAGE = "protocol_pendant_image";
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject1;
    Object localObject2;
    if (paramDownloadParams != null)
    {
      if (paramDownloadParams.url == null) {
        return null;
      }
      localObject1 = paramDownloadParams.url.getHost();
      paramOutputStream = paramDownloadParams.url.getFile();
      if ("DEFAULT_HEAD".equals(localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject1).append("avatarPendantDefaultHead");
        ((StringBuilder)localObject1).append(paramOutputStream);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists()) {
          return localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("https://i.gtimg.cn/qqshow/admindata/comdata/mobileDefaultHead/");
        ((StringBuilder)localObject2).append(paramOutputStream);
        paramOutputStream = ((StringBuilder)localObject2).toString();
      }
      else if (("AIO_STATIC".equals(localObject1)) && (!TextUtils.isEmpty(paramOutputStream)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AppConstants.SDCARD_PENDANT_ROOT);
        ((StringBuilder)localObject1).append(paramOutputStream);
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdir();
        }
        long l = Long.valueOf(paramOutputStream.split("/")[1]).longValue();
        localObject1 = AvatarPendantUtil.b(l, 5);
        paramOutputStream = new File((String)localObject1);
        if (paramOutputStream.exists()) {
          return paramOutputStream;
        }
        paramOutputStream = AvatarPendantUtil.c(l, 5);
      }
      else
      {
        paramOutputStream = null;
        localObject1 = paramOutputStream;
      }
      if (paramOutputStream != null)
      {
        paramDownloadParams.url = new URL(paramOutputStream);
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("downloadImage pendant: ");
          ((StringBuilder)localObject2).append(paramOutputStream);
          ((StringBuilder)localObject2).append(" -> ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("AvatarPendantDownloader", 4, ((StringBuilder)localObject2).toString());
        }
        paramURLDrawableHandler.publishProgress(0);
        localObject2 = new FileOutputStream((String)localObject1);
      }
    }
    try
    {
      new HttpDownloader().downloadImage((OutputStream)localObject2, paramDownloadParams, paramURLDrawableHandler);
      ((FileOutputStream)localObject2).close();
    }
    catch (Exception paramDownloadParams)
    {
      label377:
      break label377;
    }
    ((FileOutputStream)localObject2).close();
    new File((String)localObject1).delete();
    paramDownloadParams = new File((String)localObject1);
    if (paramDownloadParams.exists()) {
      return paramDownloadParams;
    }
    if (QLog.isDevelopLevel())
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("downloadImage pendant fail.-> ");
      paramDownloadParams.append(paramOutputStream);
      QLog.d("AvatarPendantDownloader", 2, paramDownloadParams.toString());
    }
    return null;
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AvatarPendantDownloader
 * JD-Core Version:    0.7.0.1
 */