package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import bgil;
import bgio;
import bgoe;
import bgog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
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
    Object localObject1 = null;
    if ((paramDownloadParams.mExtraInfo instanceof Bundle))
    {
      Object localObject2 = (Bundle)paramDownloadParams.mExtraInfo;
      if (((Bundle)localObject2).getBoolean("key_use_gldrawable", false))
      {
        boolean bool = ((Bundle)localObject2).getBoolean("key_use_cache", false);
        bgio.a().a(null);
        localObject2 = bgio.a().a(paramFile, bool);
        if (localObject2 != null) {
          paramURLDrawableHandler = (URLDrawableHandler)localObject2;
        }
      }
    }
    do
    {
      do
      {
        return paramURLDrawableHandler;
        if (!ApngDrawable.isApngFile(paramFile)) {
          break;
        }
        paramURLDrawableHandler = localObject1;
      } while (!paramFile.exists());
      paramURLDrawableHandler = localObject1;
    } while (!paramDownloadParams.useApngImage);
    if ((paramDownloadParams.mExtraInfo instanceof Bundle)) {}
    for (paramDownloadParams = (Bundle)paramDownloadParams.mExtraInfo;; paramDownloadParams = null)
    {
      paramDownloadParams = new VasApngDownloader.VasApngImage(paramFile, true, paramDownloadParams);
      paramURLDrawableHandler = paramDownloadParams;
      if (paramDownloadParams.firstFrame != null) {
        break;
      }
      ChatBackgroundManager.a(paramFile.getAbsolutePath());
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
    label42:
    long l;
    int i;
    if ((paramDownloadParams.mExtraInfo instanceof Bundle))
    {
      paramOutputStream = (Bundle)paramDownloadParams.mExtraInfo;
      if (paramOutputStream == null) {
        break label420;
      }
      l = paramOutputStream.getLong("bundle_key_bid", 0L);
      paramOutputStream = paramOutputStream.getString("bundle_key_scid");
      if ((l == 0L) || (TextUtils.isEmpty(paramOutputStream))) {
        break label95;
      }
      i = 1;
    }
    for (;;)
    {
      if (localFile.exists())
      {
        return localFile;
        paramOutputStream = null;
        break label42;
        label95:
        i = 0;
        continue;
      }
      if (i != 0)
      {
        VasQuickUpdateManager.getFileFromLocal(BaseApplicationImpl.sApplication.getRuntime(), l, paramOutputStream, null, true, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage method err, scid=" + paramOutputStream + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramDownloadParams = paramDownloadParams.url.getFile();
      if (TextUtils.isEmpty(paramDownloadParams))
      {
        QLog.e("vasapngdownloader", 2, "downloadImage url err, url=" + paramDownloadParams + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramOutputStream = paramDownloadParams;
      if (paramDownloadParams.startsWith(File.separator)) {
        paramOutputStream = paramDownloadParams.substring(1);
      }
      if (!paramOutputStream.startsWith("http"))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage url has no http err, url=" + paramOutputStream + ", path=" + paramURLDrawableHandler);
        return null;
      }
      paramDownloadParams = new bgoe(paramOutputStream, localFile);
      paramDownloadParams.h = true;
      i = bgog.a(paramDownloadParams, BaseApplicationImpl.sApplication.getRuntime());
      if (i == 0)
      {
        if (localFile.exists()) {
          return localFile;
        }
        QLog.e("vasapngdownloader", 2, "downloadImage file not exists, url=" + paramOutputStream + ", path=" + paramURLDrawableHandler + ", ret:" + i);
        return null;
      }
      QLog.e("vasapngdownloader", 1, "downloadImage Error url=" + paramOutputStream + ", path=" + paramURLDrawableHandler + ", ret:" + i);
      return null;
      label420:
      i = 0;
      paramOutputStream = null;
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasApngDownloader
 * JD-Core Version:    0.7.0.1
 */