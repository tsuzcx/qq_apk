package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr;
import com.tencent.mobileqq.uniformdownload.data.DownloadInstContextMgr.DownloadInstContext;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr;
import com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr;
import com.tencent.mobileqq.uniformdownload.data.UniformDownloaderListenerMgr;
import com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class UniformDownloadMgr
{
  private static UniformDownloadMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadMgr = null;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private DownloadInstContextMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr = new DownloadInstContextMgr(this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr);
  private DownloadingRbResmeInfoMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadingRbResmeInfoMgr = new DownloadingRbResmeInfoMgr();
  private SucDownloadInfoMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadDataSucDownloadInfoMgr = new SucDownloadInfoMgr();
  private UniformDownloaderListenerMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr = new UniformDownloaderListenerMgr();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = true;
  
  private UniformDownloadMgr()
  {
    try
    {
      UniformDownloadPkgInstallReceiver.a(BaseApplication.getContext());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int a(String paramString, Bundle paramBundle)
  {
    if ((paramString == null) || (paramBundle == null))
    {
      QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] inRResumeDownload. param error!!");
      return -1;
    }
    int i = paramBundle.getInt("_notify_param_Id");
    String str1 = paramBundle.getString("_notify_param_Filename");
    String str2 = paramBundle.getString("_notify_param_ContentTitle", "");
    long l = paramBundle.getLong("_notify_param_Filesize");
    paramBundle = paramBundle.getBundle("_notify_param_userdata");
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] >>>inRResumeDownload. URL:" + paramString + " nofiyid:" + i);
    if (-1 == this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.b(paramString)) {
      a(new DownloadInfoBuilder().a(paramString).b(str1).a(l).c(str2).a(paramBundle).a(i).a(true));
    }
    return 0;
  }
  
  public static UniformDownloadMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadMgr == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-getInstance] create");
        }
        jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadMgr = new UniformDownloadMgr();
      }
      UniformDownloadMgr localUniformDownloadMgr = jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadMgr;
      return localUniformDownloadMgr;
    }
    finally {}
  }
  
  public int a(DownloadInfoBuilder paramDownloadInfoBuilder)
  {
    if ((paramDownloadInfoBuilder.a() == null) || (paramDownloadInfoBuilder.b() == null))
    {
      QLog.e("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask] createAndStartDownloadTask.. param = null");
      return -1;
    }
    long l = UniformDownloadUtil.a();
    UniformDownloader localUniformDownloader = new UniformDownloader(l, paramDownloadInfoBuilder.a(), paramDownloadInfoBuilder.a());
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_PARAM_FILENAME", paramDownloadInfoBuilder.b());
    ((Bundle)localObject).putLong("_PARAM_FILESIZE", paramDownloadInfoBuilder.a());
    ((Bundle)localObject).putBundle("_PARAM_USER_DATA", paramDownloadInfoBuilder.a());
    if (!localUniformDownloader.a((Bundle)localObject))
    {
      QLog.e("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask][" + l + " - NEW_ID] create UniformDownloader failed. url:" + paramDownloadInfoBuilder.a());
      return -2;
    }
    if (1 == localUniformDownloader.a())
    {
      QLog.i("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask][" + l + " - NEW_ID]. >>> create UniformDownloader.using appbaby. url: " + paramDownloadInfoBuilder.a());
      localUniformDownloader.a(new UniformDownloadMgr.7(this), true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramDownloadInfoBuilder.a());
      if (localObject != null) {
        localUniformDownloader.a((IUniformDownloaderListener)localObject, false);
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("_notify_param_Filename", paramDownloadInfoBuilder.b());
      if (TextUtils.isEmpty(paramDownloadInfoBuilder.c())) {
        break label481;
      }
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramDownloadInfoBuilder.c());
    }
    for (;;)
    {
      ((Bundle)localObject).putString("_notify_param_Url", paramDownloadInfoBuilder.a());
      ((Bundle)localObject).putLong("_notify_param_Filesize", paramDownloadInfoBuilder.a());
      ((Bundle)localObject).putBundle("_notify_param_userdata", paramDownloadInfoBuilder.a());
      int i = UniformDownloadNfn.a().a(localUniformDownloader, (Bundle)localObject, l, paramDownloadInfoBuilder.a());
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramDownloadInfoBuilder.a(), new DownloadInstContextMgr.DownloadInstContext(null, localUniformDownloader.a(), localUniformDownloader, l, i));
      if (paramDownloadInfoBuilder.a())
      {
        QLog.w("UniformDownloadMgr_Impl", 1, "[UniformDL][" + l + "] preHadStarted. url:" + paramDownloadInfoBuilder.a());
        localUniformDownloader.a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.e(paramDownloadInfoBuilder.a()) == 0)
      {
        localUniformDownloader.a(true);
        UniformDownloadNfn.a().b(i, (Bundle)localObject);
      }
      this.jdField_a_of_type_Boolean = false;
      return 0;
      if (2 != localUniformDownloader.a()) {
        break;
      }
      QLog.i("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask][" + l + " - NEW_ID]. >>>create UniformDownloader.using common. url:" + paramDownloadInfoBuilder.a());
      break;
      label481:
      ((Bundle)localObject).putString("_notify_param_ContentTitle", paramDownloadInfoBuilder.b());
    }
  }
  
  public DownloadingRbResmeInfoMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadingRbResmeInfoMgr;
  }
  
  public SucDownloadInfoMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataSucDownloadInfoMgr;
  }
  
  public AppRuntime a()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-getApp] APP=null.");
    }
    return this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public void a()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy]");
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a();
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.2(this));
  }
  
  public void a(String paramString)
  {
    IUniformDownloaderListener localIUniformDownloaderListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.b(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
      if ((paramString != null) && (paramString.a != null) && (localIUniformDownloaderListener != null)) {
        paramString.a.a(localIUniformDownloaderListener);
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-startDownload】 URL:" + paramString);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.3(this, paramString, paramBundle));
  }
  
  public void a(String paramString, Bundle paramBundle, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-startDownload + listener】 URL:" + paramString);
    IUniformDownloaderListener localIUniformDownloaderListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString, paramIUniformDownloaderListener);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.4(this, paramString, paramBundle, localIUniformDownloaderListener));
  }
  
  public void a(String paramString, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
    if ((localDownloadInstContext == null) || (localDownloadInstContext.a == null)) {}
    int i;
    do
    {
      return;
      i = localDownloadInstContext.a.g();
    } while ((i != 1) && (i != 2));
    if (paramIUniformDownloaderListener != null) {
      localDownloadInstContext.a.a(paramIUniformDownloaderListener);
    }
    paramIUniformDownloaderListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
    if (paramIUniformDownloaderListener != null) {
      localDownloadInstContext.a.a(paramIUniformDownloaderListener, false);
    }
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-reflashOuterListenser] startDownload. URL:" + paramString + " update OuterListenner");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppInit]");
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.1(this));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString) != null;
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    boolean bool2 = true;
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-inRStartDownload】");
    boolean bool1;
    if ((paramString == null) || (paramBundle == null)) {
      bool1 = false;
    }
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext;
    do
    {
      return bool1;
      localDownloadInstContext = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
      if ((localDownloadInstContext == null) || (localDownloadInstContext.a == null))
      {
        QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-inRStartDownload] run a new download. url:" + paramString);
        a(DownloadInfoBuilder.a(paramBundle, paramString));
        return false;
      }
      int i = localDownloadInstContext.a.g();
      QLog.w("UniformDownloadMgr_Impl", 1, "[inRStartDownload] instance is exist.status:" + i + " may be do something. url:" + paramString);
      bool1 = bool2;
      switch (i)
      {
      case 0: 
      case 1: 
      case 6: 
      default: 
        return true;
      case 2: 
        paramString = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
        bool1 = bool2;
      }
    } while (paramString == null);
    localDownloadInstContext.a.a(paramString);
    localDownloadInstContext.a.a(paramString, false);
    return true;
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.b(paramString);
    return true;
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
    a(DownloadInfoBuilder.a(paramBundle, paramString));
    return true;
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
    return true;
  }
  
  public void b()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onActiveAccount...");
    d();
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-startDownloadNoSzie】 URL:" + paramString);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.5(this, paramBundle, paramString));
  }
  
  public void c()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit...");
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.c();
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataSucDownloadInfoMgr.b();
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadingRbResmeInfoMgr.a();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.6(this));
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.9(this, paramString, paramBundle));
  }
  
  public void d()
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.8(this));
  }
  
  public void d(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.10(this, paramString, paramBundle));
  }
  
  public void e(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.11(this, paramString, paramBundle));
  }
  
  public void f(String paramString, Bundle paramBundle)
  {
    e(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr
 * JD-Core Version:    0.7.0.1
 */