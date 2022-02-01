package com.tencent.mobileqq.musicgene;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import mqq.app.AppRuntime;

public class QQMusicConst
{
  public static void a(Context paramContext, String paramString)
  {
    long l = 0L;
    try
    {
      URL localURL = new URL(paramString);
      try
      {
        int i = localURL.openConnection().getContentLength();
        l = i;
      }
      catch (IOException localIOException)
      {
        QLog.e("QQMusicConst", 1, "music player activity url IOException ", localIOException);
      }
      localBundle = new Bundle();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QLog.e("QQMusicConst", 1, "music player activity url io MalformedURLException ", localMalformedURLException);
    }
    Bundle localBundle;
    localBundle.putString("big_brother_source_key", "biz_src_qqmusic");
    localBundle.putLong("_filesize_from_dlg", l);
    localBundle.putString("_filename_from_dlg", paramContext.getResources().getString(2131694577));
    localBundle.putString("FILE_MIME_TYPE", "application/vnd.android.package-archive");
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_qqmusic");
    ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(paramString, localBundle);
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, "com.tencent.qqmusic");
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext.getPackageInfo(paramString, 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label14:
      break label14;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.QQMusicConst
 * JD-Core Version:    0.7.0.1
 */