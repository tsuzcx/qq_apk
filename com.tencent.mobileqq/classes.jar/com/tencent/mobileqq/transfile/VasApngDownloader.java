package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class VasApngDownloader
  extends AbstractImageDownloader
{
  public static final String BUNDLE_KEY_BID = "bundle_key_bid";
  public static final String BUNDLE_KEY_SCID = "bundle_key_scid";
  public static final String PROTOCAL_VAS_APNG = "vasapngdownloader";
  
  public VasApngDownloader()
  {
    super("VasApngDownloader", BaseApplicationImpl.getApplication());
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    boolean bool = ApngDrawable.isApngFile(paramFile);
    Object localObject = null;
    if (bool)
    {
      if ((paramFile.exists()) && (paramDownloadParams.useApngImage))
      {
        paramURLDrawableHandler = localObject;
        if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
          paramURLDrawableHandler = (Bundle)paramDownloadParams.mExtraInfo;
        }
        paramURLDrawableHandler = new VasApngDownloader.VasApngImage(paramFile, true, paramURLDrawableHandler);
        paramDownloadParams = paramURLDrawableHandler;
        if (paramURLDrawableHandler.firstFrame == null)
        {
          ChatBackgroundManager.a(paramFile.getAbsolutePath());
          return paramURLDrawableHandler;
        }
      }
      else
      {
        paramDownloadParams = null;
      }
      return paramDownloadParams;
    }
    if (paramFile == null)
    {
      QLog.e("vasapngdownloader", 1, "decodeFile error : file == null");
      return null;
    }
    return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null) {
      return null;
    }
    paramURLDrawableHandler = paramDownloadParams.url.getHost();
    File localFile = new File(paramURLDrawableHandler);
    if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {
      paramOutputStream = (Bundle)paramDownloadParams.mExtraInfo;
    } else {
      paramOutputStream = null;
    }
    int i = 0;
    int j = 0;
    long l;
    if (paramOutputStream != null)
    {
      l = paramOutputStream.getLong("bundle_key_bid", 0L);
      paramOutputStream = paramOutputStream.getString("bundle_key_scid");
      i = j;
      if (l != 0L)
      {
        i = j;
        if (!TextUtils.isEmpty(paramOutputStream)) {
          i = 1;
        }
      }
    }
    else
    {
      paramOutputStream = null;
      l = 0L;
    }
    if (!localFile.exists())
    {
      if (i != 0)
      {
        VasUpdateUtil.a(BaseApplicationImpl.sApplication.getRuntime(), l, paramOutputStream, null, true, null);
        if (!QLog.isColorLevel()) {
          break label492;
        }
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("downloadImage method err, scid=");
        paramDownloadParams.append(paramOutputStream);
        paramDownloadParams.append(", path=");
        paramDownloadParams.append(paramURLDrawableHandler);
        QLog.e("vasapngdownloader", 2, paramDownloadParams.toString());
        return null;
      }
      paramDownloadParams = paramDownloadParams.url.getFile();
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage url err, url=");
        paramOutputStream.append(paramDownloadParams);
        paramOutputStream.append(", path=");
        paramOutputStream.append(paramURLDrawableHandler);
        QLog.e("vasapngdownloader", 2, paramOutputStream.toString());
        return null;
      }
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith(File.separator)) {
        paramOutputStream = paramDownloadParams.substring(1);
      }
      if (!paramOutputStream.startsWith("http"))
      {
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("downloadImage url has no http err, url=");
          paramDownloadParams.append(paramOutputStream);
          paramDownloadParams.append(", path=");
          paramDownloadParams.append(paramURLDrawableHandler);
          QLog.e("vasapngdownloader", 2, paramDownloadParams.toString());
        }
        return null;
      }
      paramDownloadParams = new DownloadTask(paramOutputStream, localFile);
      paramDownloadParams.h = true;
      i = DownloaderFactory.a(paramDownloadParams, BaseApplicationImpl.sApplication.getRuntime());
      if (i != 0) {
        break label434;
      }
      if (!localFile.exists()) {}
    }
    else
    {
      return localFile;
    }
    paramDownloadParams = new StringBuilder();
    paramDownloadParams.append("downloadImage file not exists, url=");
    paramDownloadParams.append(paramOutputStream);
    paramDownloadParams.append(", path=");
    paramDownloadParams.append(paramURLDrawableHandler);
    paramDownloadParams.append(", ret:");
    paramDownloadParams.append(i);
    QLog.e("vasapngdownloader", 2, paramDownloadParams.toString());
    return null;
    label434:
    paramDownloadParams = new StringBuilder();
    paramDownloadParams.append("downloadImage Error url=");
    paramDownloadParams.append(paramOutputStream);
    paramDownloadParams.append(", path=");
    paramDownloadParams.append(paramURLDrawableHandler);
    paramDownloadParams.append(", ret:");
    paramDownloadParams.append(i);
    QLog.e("vasapngdownloader", 1, paramDownloadParams.toString());
    label492:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasApngDownloader
 * JD-Core Version:    0.7.0.1
 */