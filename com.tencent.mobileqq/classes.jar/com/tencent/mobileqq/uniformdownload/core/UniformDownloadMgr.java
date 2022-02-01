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
  private static UniformDownloadMgr jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadMgr;
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
    if ((paramString != null) && (paramBundle != null))
    {
      int i = paramBundle.getInt("_notify_param_Id");
      String str1 = paramBundle.getString("_notify_param_Filename");
      String str2 = paramBundle.getString("_notify_param_ContentTitle", "");
      long l = paramBundle.getLong("_notify_param_Filesize");
      paramBundle = paramBundle.getBundle("_notify_param_userdata");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] >>>inRResumeDownload. URL:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" nofiyid:");
      localStringBuilder.append(i);
      QLog.i("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
      if (-1 == this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.b(paramString)) {
        a(new DownloadInfoBuilder().a(paramString).b(str1).a(l).c(str2).a(paramBundle).a(i).a(true));
      }
      return 0;
    }
    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] inRResumeDownload. param error!!");
    return -1;
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
    if ((paramDownloadInfoBuilder.a() != null) && (paramDownloadInfoBuilder.b() != null))
    {
      long l = UniformDownloadUtil.a();
      Object localObject1 = new UniformDownloader(l, paramDownloadInfoBuilder.a(), paramDownloadInfoBuilder.a());
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("_PARAM_FILENAME", paramDownloadInfoBuilder.b());
      ((Bundle)localObject2).putLong("_PARAM_FILESIZE", paramDownloadInfoBuilder.a());
      ((Bundle)localObject2).putBundle("_PARAM_USER_DATA", paramDownloadInfoBuilder.a());
      if (!((UniformDownloader)localObject1).a((Bundle)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[createAndStartDownloadTask][");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(" - NEW_ID] create UniformDownloader failed. url:");
        ((StringBuilder)localObject1).append(paramDownloadInfoBuilder.a());
        QLog.e("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject1).toString());
        return -2;
      }
      if (1 == ((UniformDownloader)localObject1).a())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[createAndStartDownloadTask][");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" - NEW_ID]. >>> create UniformDownloader.using appbaby. url: ");
        ((StringBuilder)localObject2).append(paramDownloadInfoBuilder.a());
        QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject2).toString());
      }
      else if (2 == ((UniformDownloader)localObject1).a())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[createAndStartDownloadTask][");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" - NEW_ID]. >>>create UniformDownloader.using common. url:");
        ((StringBuilder)localObject2).append(paramDownloadInfoBuilder.a());
        QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject2).toString());
      }
      ((UniformDownloader)localObject1).a(new UniformDownloadMgr.7(this), true);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramDownloadInfoBuilder.a());
      if (localObject2 != null) {
        ((UniformDownloader)localObject1).a((IUniformDownloaderListener)localObject2, false);
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("_notify_param_Filename", paramDownloadInfoBuilder.b());
      if (!TextUtils.isEmpty(paramDownloadInfoBuilder.c())) {
        ((Bundle)localObject2).putString("_notify_param_ContentTitle", paramDownloadInfoBuilder.c());
      } else {
        ((Bundle)localObject2).putString("_notify_param_ContentTitle", paramDownloadInfoBuilder.b());
      }
      ((Bundle)localObject2).putString("_notify_param_Url", paramDownloadInfoBuilder.a());
      ((Bundle)localObject2).putLong("_notify_param_Filesize", paramDownloadInfoBuilder.a());
      ((Bundle)localObject2).putBundle("_notify_param_userdata", paramDownloadInfoBuilder.a());
      int i = UniformDownloadNfn.a().a((UniformDownloader)localObject1, (Bundle)localObject2, l, paramDownloadInfoBuilder.a());
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramDownloadInfoBuilder.a(), new DownloadInstContextMgr.DownloadInstContext(null, ((UniformDownloader)localObject1).a(), (UniformDownloader)localObject1, l, i));
      if (paramDownloadInfoBuilder.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(l);
        localStringBuilder.append("] preHadStarted. url:");
        localStringBuilder.append(paramDownloadInfoBuilder.a());
        QLog.w("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
        ((UniformDownloader)localObject1).a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.e(paramDownloadInfoBuilder.a()) == 0)
      {
        ((UniformDownloader)localObject1).a(true);
        UniformDownloadNfn.a().b(i, (Bundle)localObject2);
      }
      this.jdField_a_of_type_Boolean = false;
      return 0;
    }
    QLog.e("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask] createAndStartDownloadTask.. param = null");
    return -1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【UniformDL-startDownload】 URL:");
    localStringBuilder.append(paramString);
    QLog.d("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.3(this, paramString, paramBundle));
  }
  
  public void a(String paramString, Bundle paramBundle, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("【UniformDL-startDownload + listener】 URL:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString, paramIUniformDownloaderListener);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.4(this, paramString, paramBundle, (IUniformDownloaderListener)localObject));
  }
  
  public void a(String paramString, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
    if (localDownloadInstContext != null)
    {
      if (localDownloadInstContext.a == null) {
        return;
      }
      int i = localDownloadInstContext.a.g();
      if ((i == 1) || (i == 2))
      {
        if (paramIUniformDownloaderListener != null) {
          localDownloadInstContext.a.a(paramIUniformDownloaderListener);
        }
        paramIUniformDownloaderListener = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
        if (paramIUniformDownloaderListener != null) {
          localDownloadInstContext.a.a(paramIUniformDownloaderListener, false);
        }
        paramIUniformDownloaderListener = new StringBuilder();
        paramIUniformDownloaderListener.append("[UniformDL-reflashOuterListenser] startDownload. URL:");
        paramIUniformDownloaderListener.append(paramString);
        paramIUniformDownloaderListener.append(" update OuterListenner");
        QLog.i("UniformDownloadMgr_Impl", 1, paramIUniformDownloaderListener.toString());
      }
    }
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
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-inRStartDownload】");
    if (paramString != null)
    {
      if (paramBundle == null) {
        return false;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
      if ((localObject != null) && (((DownloadInstContextMgr.DownloadInstContext)localObject).a != null))
      {
        int i = ((DownloadInstContextMgr.DownloadInstContext)localObject).a.g();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[inRStartDownload] instance is exist.status:");
        localStringBuilder.append(i);
        localStringBuilder.append(" may be do something. url:");
        localStringBuilder.append(paramString);
        QLog.w("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
        switch (i)
        {
        default: 
          return true;
        case 7: 
          this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
          return true;
        case 4: 
          this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.a(paramString);
          a(DownloadInfoBuilder.a(paramBundle, paramString));
          return true;
        case 3: 
        case 5: 
          this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataDownloadInstContextMgr.b(paramString);
          return true;
        case 2: 
          paramString = this.jdField_a_of_type_ComTencentMobileqqUniformdownloadDataUniformDownloaderListenerMgr.a(paramString);
          if (paramString != null)
          {
            ((DownloadInstContextMgr.DownloadInstContext)localObject).a.a(paramString);
            ((DownloadInstContextMgr.DownloadInstContext)localObject).a.a(paramString, false);
          }
          break;
        }
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL-inRStartDownload] run a new download. url:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject).toString());
      a(DownloadInfoBuilder.a(paramBundle, paramString));
    }
    return false;
  }
  
  public void b()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onActiveAccount...");
    d();
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【UniformDL-startDownloadNoSzie】 URL:");
    localStringBuilder.append(paramString);
    QLog.d("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr
 * JD-Core Version:    0.7.0.1
 */