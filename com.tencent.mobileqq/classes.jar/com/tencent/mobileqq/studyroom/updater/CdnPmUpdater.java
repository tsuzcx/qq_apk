package com.tencent.mobileqq.studyroom.updater;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.studyroom.download.NowDownloadManager;
import com.tencent.mobileqq.studyroom.download.NowDownloadTaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class CdnPmUpdater
  implements IShadowPluginManagerUpdater
{
  private final String a;
  private final File b;
  private final String c;
  private final String d;
  private final String e;
  private final File f;
  private final SharedPreferences g;
  private final AtomicLong h;
  private Future<File> i;
  
  private void a(File paramFile)
  {
    this.g.edit().putString(this.d, paramFile.getAbsolutePath()).apply();
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void a(boolean paramBoolean)
  {
    this.g.edit().putBoolean(this.e, paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWasUpdating:");
      localStringBuilder.append(paramBoolean);
      QLog.i("studyroom.CdnPmUpdater", 2, localStringBuilder.toString());
    }
  }
  
  private boolean b()
  {
    Object localObject1 = getLatest();
    boolean bool = true;
    if (localObject1 == null) {
      return true;
    }
    long l = System.currentTimeMillis() - this.h.get();
    if (l <= 180000L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("短时间内不重复检测interval==");
        ((StringBuilder)localObject1).append(l);
        QLog.i("studyroom.CdnPmUpdater", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    try
    {
      localObject4 = new URL(this.a).openConnection();
      if ((localObject4 instanceof HttpURLConnection))
      {
        localObject4 = (HttpURLConnection)localObject4;
        try
        {
          if (((HttpURLConnection)localObject4).getResponseCode() == 200)
          {
            l = ((File)localObject1).length();
            int j = ((HttpURLConnection)localObject4).getContentLength();
            this.h.set(System.currentTimeMillis());
            if (l == j) {
              bool = false;
            }
            if (localObject4 != null) {
              ((HttpURLConnection)localObject4).disconnect();
            }
            return bool;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899706));
          ((StringBuilder)localObject1).append(200);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899707));
          ((StringBuilder)localObject1).append(((HttpURLConnection)localObject4).getResponseCode());
          throw new Error(((StringBuilder)localObject1).toString());
        }
        finally
        {
          break label283;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(HardCodeUtil.a(2131899704));
      throw new Error(localStringBuilder.toString());
    }
    finally
    {
      Object localObject4 = null;
      label283:
      if (localObject4 != null) {
        ((HttpURLConnection)localObject4).disconnect();
      }
    }
  }
  
  private boolean c()
  {
    return this.g.getBoolean(this.e, false);
  }
  
  public File a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("studyroom.CdnPmUpdater", 2, "start download ");
    }
    File localFile = this.f;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("_");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject1).append(Long.valueOf(((StringBuilder)localObject2).toString(), 36));
    ((StringBuilder)localObject1).append(".apk");
    localFile = new File(localFile, ((StringBuilder)localObject1).toString());
    localObject1 = new CountDownLatch(1);
    localObject2 = new Exception[1];
    System.currentTimeMillis();
    NowDownloadManager localNowDownloadManager = new NowDownloadManager();
    localNowDownloadManager.a(BaseApplicationImpl.getContext());
    localNowDownloadManager.a(this.a, new CdnPmUpdater.3(this, localFile, (Exception[])localObject2, (CountDownLatch)localObject1));
    String str = this.a;
    localNowDownloadManager.a(NowDownloadTaskInfo.a(str, str, this.b.getAbsolutePath()));
    ((CountDownLatch)localObject1).await();
    if (localObject2[0] == null)
    {
      localFile.setLastModified(localFile.lastModified() + 1000L);
      a(localFile);
      return localFile;
    }
    throw localObject2[0];
  }
  
  public File getLatest()
  {
    Object localObject = this.g.getString(this.d, null);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return null;
  }
  
  public Future<Boolean> isAvailable(File paramFile)
  {
    throw new UnsupportedOperationException(HardCodeUtil.a(2131899705));
  }
  
  public Future<File> update()
  {
    a(true);
    if (QLog.isColorLevel()) {
      QLog.i("studyroom.CdnPmUpdater", 2, "update");
    }
    Future localFuture = this.i;
    if ((localFuture != null) && (!localFuture.isDone()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("studyroom.CdnPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.i;
    }
    this.i = ThreadManagerExecutor.getExecutorService(192).submit(new CdnPmUpdater.1(this));
    return this.i;
  }
  
  public boolean wasUpdating()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.updater.CdnPmUpdater
 * JD-Core Version:    0.7.0.1
 */