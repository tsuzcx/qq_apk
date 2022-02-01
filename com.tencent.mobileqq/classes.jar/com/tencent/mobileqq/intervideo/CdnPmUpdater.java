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
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("IVShadowCdnPmUpdater", 0);
  AssetsPmUpdater jdField_a_of_type_ComTencentMobileqqIntervideoAssetsPmUpdater;
  private ICdnPmUpdater.PmUpdaterListener jdField_a_of_type_ComTencentMobileqqIntervideoICdnPmUpdater$PmUpdaterListener;
  private final IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  private final File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString;
  private Future<File> jdField_a_of_type_JavaUtilConcurrentFuture;
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(System.currentTimeMillis() - 180000L);
  private final boolean jdField_a_of_type_Boolean;
  private final File jdField_b_of_type_JavaIoFile;
  private final String jdField_b_of_type_JavaLangString;
  private final String c;
  private final String d;
  private String e;
  
  public CdnPmUpdater(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.e = paramString3;
    this.jdField_b_of_type_JavaIoFile = new File(new File(paramContext.getFilesDir(), "IVShadowCdnPmUpdater"), paramString1);
    this.jdField_b_of_type_JavaIoFile.mkdirs();
    Object localObject = this.jdField_b_of_type_JavaIoFile;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(this.e);
    localStringBuilder.append("_pm.temp");
    this.jdField_a_of_type_JavaIoFile = new File((File)localObject, localStringBuilder.toString());
    this.jdField_b_of_type_JavaLangString = paramString1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pm_name_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.e);
    this.c = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("wasUpdate_");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.e);
    this.d = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_Boolean = "Now".equals(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoAssetsPmUpdater = new AssetsPmUpdater(paramContext, paramString1, paramString3);
    if (this.jdField_a_of_type_Boolean)
    {
      if (!StringUtil.a(paramString2)) {
        paramContext = paramString2.substring(paramString2.length() - 1);
      } else {
        paramContext = "9";
      }
      paramString2 = new StringBuilder();
      paramString2.append("https://dlied5sdk.myapp.com/now/pluginmanager/");
      paramString2.append("");
      paramString2.append(this.e);
      paramString2.append("/ShadowPluginManager_nowPlugin_");
      paramString2.append(paramContext);
      this.jdField_a_of_type_JavaLangString = paramString2.toString();
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
      this.jdField_a_of_type_JavaLangString = paramString2.toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("use cdnupdater url = ");
      paramContext.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("shadow::CdnPmUpdater", 2, paramContext.toString());
    }
  }
  
  private void a(File paramFile)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.c, paramFile.getAbsolutePath()).apply();
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.d, paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setWasUpdating:");
      localStringBuilder.append(paramBoolean);
      QLog.i("shadow::CdnPmUpdater", 2, localStringBuilder.toString());
    }
  }
  
  private boolean a()
  {
    Object localObject1 = getLatest();
    boolean bool = true;
    if (localObject1 == null) {
      return true;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    if (l <= 180000L)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("短时间内不重复检测interval==");
        ((StringBuilder)localObject1).append(l);
        QLog.i("shadow::CdnPmUpdater", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    try
    {
      localObject4 = new URL(this.jdField_a_of_type_JavaLangString).openConnection();
      if ((localObject4 instanceof HttpURLConnection))
      {
        localObject4 = (HttpURLConnection)localObject4;
        try
        {
          if (((HttpURLConnection)localObject4).getResponseCode() == 200)
          {
            l = ((File)localObject1).length();
            int i = ((HttpURLConnection)localObject4).getContentLength();
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
            if (l == i) {
              bool = false;
            }
            if (localObject4 != null) {
              ((HttpURLConnection)localObject4).disconnect();
            }
            return bool;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701684));
          ((StringBuilder)localObject1).append(200);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701685));
          ((StringBuilder)localObject1).append(((HttpURLConnection)localObject4).getResponseCode());
          throw new Error(((StringBuilder)localObject1).toString());
        }
        finally
        {
          break label286;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(HardCodeUtil.a(2131701682));
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
  
  private boolean b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.d, false);
  }
  
  public File a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("shadow::CdnPmUpdater", 2, "start download ");
    }
    File localFile = this.jdField_b_of_type_JavaIoFile;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("_");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject1).append(Long.valueOf(((StringBuilder)localObject2).toString(), 36));
    ((StringBuilder)localObject1).append(".apk");
    localFile = new File(localFile, ((StringBuilder)localObject1).toString());
    localObject1 = new CountDownLatch(1);
    localObject2 = new Exception[1];
    long l = System.currentTimeMillis();
    INowDownloadManager localINowDownloadManager = ((INowDownloadManager)QRoute.api(INowDownloadManager.class)).createObject(false);
    localINowDownloadManager.init(BaseApplicationImpl.getContext());
    localINowDownloadManager.addDownloadListener(this.jdField_a_of_type_JavaLangString, new CdnPmUpdater.2(this, localFile, (Exception[])localObject2, l, (CountDownLatch)localObject1));
    String str = this.jdField_a_of_type_JavaLangString;
    localINowDownloadManager.startDownload(NowDownloadTaskInfo.a(str, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
    ((CountDownLatch)localObject1).await();
    if (localObject2[0] == null)
    {
      localFile.setLastModified(localFile.lastModified() + 1000L);
      a(localFile);
      return localFile;
    }
    throw localObject2[0];
  }
  
  public void a()
  {
    File localFile = getLatest();
    if (localFile != null) {
      localFile.delete();
    }
  }
  
  public void a(ICdnPmUpdater.PmUpdaterListener paramPmUpdaterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoICdnPmUpdater$PmUpdaterListener = paramPmUpdaterListener;
  }
  
  public File getLatest()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.c, null);
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
    throw new UnsupportedOperationException(HardCodeUtil.a(2131701683));
  }
  
  public Future<File> update()
  {
    a(true);
    if (QLog.isColorLevel()) {
      QLog.i("shadow::CdnPmUpdater", 2, "update");
    }
    if (this.jdField_a_of_type_Boolean) {
      localObject = "33669796";
    } else {
      localObject = "33669801";
    }
    Monitor.b((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("update").report();
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentFuture;
    if ((localObject != null) && (!((Future)localObject).isDone()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("shadow::CdnPmUpdater", 2, "上一次update还没结束，返回相同Future");
      }
      return this.jdField_a_of_type_JavaUtilConcurrentFuture;
    }
    this.jdField_a_of_type_JavaUtilConcurrentFuture = ThreadManagerExecutor.getExecutorService(192).submit(new CdnPmUpdater.1(this));
    return this.jdField_a_of_type_JavaUtilConcurrentFuture;
  }
  
  public boolean wasUpdating()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.CdnPmUpdater
 * JD-Core Version:    0.7.0.1
 */