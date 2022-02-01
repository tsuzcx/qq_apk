package com.tencent.mobileqq.intervideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.impl.NowDownloadTaskInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class CdnPmUpdater
  implements ICdnPmUpdater, PluginManagerUpdater
{
  AssetsPmUpdater a;
  private final String b;
  private final File c;
  private final String d;
  private final String e;
  private final String f;
  private final File g;
  private final SharedPreferences h = BaseApplicationImpl.getContext().getSharedPreferences("IVShadowCdnPmUpdater", 0);
  private final AtomicLong i = new AtomicLong(System.currentTimeMillis() - 180000L);
  private final IVPluginDataReporter j = new IVPluginDataReporter();
  private final boolean k;
  private String l;
  private Future<File> m;
  private ICdnPmUpdater.PmUpdaterListener n;
  
  public CdnPmUpdater(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.l = paramString3;
    this.g = new File(new File(paramContext.getFilesDir(), "IVShadowCdnPmUpdater"), paramString1);
    this.g.mkdirs();
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(this.l);
    localStringBuilder.append("_pm.temp");
    this.c = new File((File)localObject, localStringBuilder.toString());
    this.d = paramString1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pm_name_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.l);
    this.e = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wasUpdate_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.l);
    this.f = ((StringBuilder)localObject).toString();
    this.k = "Now".equals(paramString1);
    this.a = new AssetsPmUpdater(paramContext, paramString1, paramString3);
    if (this.k)
    {
      if (!StringUtil.isEmpty(paramString2)) {
        paramContext = paramString2.substring(paramString2.length() - 1);
      } else {
        paramContext = "9";
      }
      paramString2 = new StringBuilder();
      paramString2.append("https://dlied5sdk.myapp.com/now/pluginmanager/");
      paramString2.append("");
      paramString2.append(this.l);
      paramString2.append("/ShadowPluginManager_nowPlugin_");
      paramString2.append(paramContext);
      this.b = paramString2.toString();
    }
    else
    {
      if ((paramString2 != null) && (paramString2.endsWith("0"))) {
        paramContext = "_A";
      } else {
        paramContext = "_B";
      }
      paramString2 = new StringBuilder();
      paramString2.append("https://dlied5sdk.myapp.com/huayang/Android/ShadowPluginManager1_1_");
      paramString2.append(paramString1);
      paramString2.append(paramContext);
      this.b = paramString2.toString();
    }
    this.j.opDepartment("shadow").opName(paramString1);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("use cdnupdater url = ");
      paramContext.append(this.b);
      QLog.i("shadow::CdnPmUpdater", 2, paramContext.toString());
    }
  }
  
  private void a(File paramFile)
  {
    this.h.edit().putString(this.e, paramFile.getAbsolutePath()).apply();
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void a(boolean paramBoolean)
  {
    this.h.edit().putBoolean(this.f, paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWasUpdating:");
      localStringBuilder.append(paramBoolean);
      QLog.i("shadow::CdnPmUpdater", 2, localStringBuilder.toString());
    }
  }
  
  private boolean c()
  {
    Object localObject1 = getLatest();
    boolean bool = true;
    if (localObject1 == null) {
      return true;
    }
    long l1 = System.currentTimeMillis() - this.i.get();
    if (l1 <= 180000L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("短时间内不重复检测interval==");
        ((StringBuilder)localObject1).append(l1);
        QLog.i("shadow::CdnPmUpdater", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    try
    {
      localObject4 = new URL(this.b).openConnection();
      if ((localObject4 instanceof HttpURLConnection))
      {
        localObject4 = (HttpURLConnection)localObject4;
        try
        {
          if (((HttpURLConnection)localObject4).getResponseCode() == 200)
          {
            l1 = ((File)localObject1).length();
            int i1 = ((HttpURLConnection)localObject4).getContentLength();
            this.i.set(System.currentTimeMillis());
            if (l1 == i1) {
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
          break label286;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(HardCodeUtil.a(2131899704));
      throw new Error(localStringBuilder.toString());
    }
    finally
    {
      Object localObject4 = null;
      label286:
      if (localObject4 != null) {
        ((HttpURLConnection)localObject4).disconnect();
      }
    }
  }
  
  private boolean d()
  {
    return this.h.getBoolean(this.f, false);
  }
  
  public File a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, "start download ");
    }
    File localFile = this.g;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("_");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject1).append(Long.valueOf(((StringBuilder)localObject2).toString(), 36));
    ((StringBuilder)localObject1).append(".apk");
    localFile = new File(localFile, ((StringBuilder)localObject1).toString());
    localObject1 = new CountDownLatch(1);
    localObject2 = new Exception[1];
    long l1 = System.currentTimeMillis();
    INowDownloadManager localINowDownloadManager = ((INowDownloadManager)QRoute.api(INowDownloadManager.class)).createObject(false);
    localINowDownloadManager.init(BaseApplicationImpl.getContext());
    localINowDownloadManager.addDownloadListener(this.b, new CdnPmUpdater.2(this, localFile, (Exception[])localObject2, l1, (CountDownLatch)localObject1));
    String str = this.b;
    localINowDownloadManager.startDownload(NowDownloadTaskInfo.a(str, str, this.c.getAbsolutePath()));
    ((CountDownLatch)localObject1).await();
    if (localObject2[0] == null)
    {
      localFile.setLastModified(localFile.lastModified() + 1000L);
      a(localFile);
      return localFile;
    }
    throw localObject2[0];
  }
  
  public void a(ICdnPmUpdater.PmUpdaterListener paramPmUpdaterListener)
  {
    this.n = paramPmUpdaterListener;
  }
  
  public void b()
  {
    File localFile = getLatest();
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public File getLatest()
  {
    Object localObject = this.h.getString(this.e, null);
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
      QLog.i("shadow::CdnPmUpdater", 2, "update");
    }
    if (this.k) {
      localObject = "33669796";
    } else {
      localObject = "33669801";
    }
    Monitor.b((String)localObject);
    this.j.opType("update").report();
    Object localObject = this.m;
    if ((localObject != null) && (!((Future)localObject).isDone()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.m;
    }
    this.m = ThreadManagerExecutor.getExecutorService(192).submit(new CdnPmUpdater.1(this));
    return this.m;
  }
  
  public boolean wasUpdating()
  {
    return d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.CdnPmUpdater
 * JD-Core Version:    0.7.0.1
 */