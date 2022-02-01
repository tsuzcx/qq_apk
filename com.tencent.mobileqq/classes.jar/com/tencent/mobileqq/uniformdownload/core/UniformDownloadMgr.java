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
  private static UniformDownloadMgr h;
  private AppRuntime a;
  private UniformDownloaderListenerMgr b = new UniformDownloaderListenerMgr();
  private SucDownloadInfoMgr c = new SucDownloadInfoMgr();
  private DownloadingRbResmeInfoMgr d = new DownloadingRbResmeInfoMgr();
  private DownloadInstContextMgr e = new DownloadInstContextMgr(this.b);
  private boolean f = true;
  private BroadcastReceiver g = null;
  
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
  
  public static UniformDownloadMgr a()
  {
    try
    {
      if (h == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-getInstance] create");
        }
        h = new UniformDownloadMgr();
      }
      UniformDownloadMgr localUniformDownloadMgr = h;
      return localUniformDownloadMgr;
    }
    finally {}
  }
  
  private int h(String paramString, Bundle paramBundle)
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
      if (-1 == this.e.c(paramString)) {
        a(new DownloadInfoBuilder().a(paramString).b(str1).a(l).c(str2).a(paramBundle).a(i).a(true));
      }
      return 0;
    }
    QLog.e("UniformDownloadMgr_Impl", 1, "[UniformDL] inRResumeDownload. param error!!");
    return -1;
  }
  
  public int a(DownloadInfoBuilder paramDownloadInfoBuilder)
  {
    if ((paramDownloadInfoBuilder.a() != null) && (paramDownloadInfoBuilder.b() != null))
    {
      long l = UniformDownloadUtil.a();
      Object localObject1 = new UniformDownloader(l, paramDownloadInfoBuilder.a(), paramDownloadInfoBuilder.e());
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("_PARAM_FILENAME", paramDownloadInfoBuilder.b());
      ((Bundle)localObject2).putLong("_PARAM_FILESIZE", paramDownloadInfoBuilder.c());
      ((Bundle)localObject2).putBundle("_PARAM_USER_DATA", paramDownloadInfoBuilder.e());
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
      if (1 == ((UniformDownloader)localObject1).b())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[createAndStartDownloadTask][");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" - NEW_ID]. >>> create UniformDownloader.using appbaby. url: ");
        ((StringBuilder)localObject2).append(paramDownloadInfoBuilder.a());
        QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject2).toString());
      }
      else if (2 == ((UniformDownloader)localObject1).b())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[createAndStartDownloadTask][");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" - NEW_ID]. >>>create UniformDownloader.using common. url:");
        ((StringBuilder)localObject2).append(paramDownloadInfoBuilder.a());
        QLog.i("UniformDownloadMgr_Impl", 1, ((StringBuilder)localObject2).toString());
      }
      ((UniformDownloader)localObject1).a(new UniformDownloadMgr.7(this), true);
      localObject2 = this.b.a(paramDownloadInfoBuilder.a());
      if (localObject2 != null) {
        ((UniformDownloader)localObject1).a((IUniformDownloaderListener)localObject2, false);
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("_notify_param_Filename", paramDownloadInfoBuilder.b());
      if (!TextUtils.isEmpty(paramDownloadInfoBuilder.d())) {
        ((Bundle)localObject2).putString("_notify_param_ContentTitle", paramDownloadInfoBuilder.d());
      } else {
        ((Bundle)localObject2).putString("_notify_param_ContentTitle", paramDownloadInfoBuilder.b());
      }
      ((Bundle)localObject2).putString("_notify_param_Url", paramDownloadInfoBuilder.a());
      ((Bundle)localObject2).putLong("_notify_param_Filesize", paramDownloadInfoBuilder.c());
      ((Bundle)localObject2).putBundle("_notify_param_userdata", paramDownloadInfoBuilder.e());
      int i = UniformDownloadNfn.a().a((UniformDownloader)localObject1, (Bundle)localObject2, l, paramDownloadInfoBuilder.f());
      this.e.a(paramDownloadInfoBuilder.a(), new DownloadInstContextMgr.DownloadInstContext(null, ((UniformDownloader)localObject1).b(), (UniformDownloader)localObject1, l, i));
      if (paramDownloadInfoBuilder.g())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(l);
        localStringBuilder.append("] preHadStarted. url:");
        localStringBuilder.append(paramDownloadInfoBuilder.a());
        QLog.w("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
        ((UniformDownloader)localObject1).a(true);
      }
      if (this.e.f(paramDownloadInfoBuilder.a()) == 0)
      {
        ((UniformDownloader)localObject1).a(true);
        UniformDownloadNfn.a().b(i, (Bundle)localObject2);
      }
      this.f = false;
      return 0;
    }
    QLog.e("UniformDownloadMgr_Impl", 1, "[createAndStartDownloadTask] createAndStartDownloadTask.. param = null");
    return -1;
  }
  
  public void a(String paramString)
  {
    IUniformDownloaderListener localIUniformDownloaderListener = this.b.b(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.e.a(paramString);
      if ((paramString != null) && (paramString.e != null) && (localIUniformDownloaderListener != null)) {
        paramString.e.a(localIUniformDownloaderListener);
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
    localObject = this.b.a(paramString);
    this.b.a(paramString, paramIUniformDownloaderListener);
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.4(this, paramString, paramBundle, (IUniformDownloaderListener)localObject));
  }
  
  public void a(String paramString, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    DownloadInstContextMgr.DownloadInstContext localDownloadInstContext = this.e.a(paramString);
    if (localDownloadInstContext != null)
    {
      if (localDownloadInstContext.e == null) {
        return;
      }
      int i = localDownloadInstContext.e.i();
      if ((i == 1) || (i == 2))
      {
        if (paramIUniformDownloaderListener != null) {
          localDownloadInstContext.e.a(paramIUniformDownloaderListener);
        }
        paramIUniformDownloaderListener = this.b.a(paramString);
        if (paramIUniformDownloaderListener != null) {
          localDownloadInstContext.e.a(paramIUniformDownloaderListener, false);
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
    this.a = paramAppRuntime;
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.1(this));
  }
  
  public AppRuntime b()
  {
    if (this.a == null) {
      QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-getApp] APP=null.");
    }
    return this.a;
  }
  
  public void b(String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("【UniformDL-startDownloadNoSzie】 URL:");
    localStringBuilder.append(paramString);
    QLog.d("UniformDownloadMgr_Impl", 1, localStringBuilder.toString());
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.5(this, paramBundle, paramString));
  }
  
  public boolean b(String paramString)
  {
    return this.e.a(paramString) != null;
  }
  
  public SucDownloadInfoMgr c()
  {
    return this.c;
  }
  
  public boolean c(String paramString, Bundle paramBundle)
  {
    QLog.d("UniformDownloadMgr_Impl", 1, "【UniformDL-inRStartDownload】");
    if (paramString != null)
    {
      if (paramBundle == null) {
        return false;
      }
      Object localObject = this.e.a(paramString);
      if ((localObject != null) && (((DownloadInstContextMgr.DownloadInstContext)localObject).e != null))
      {
        int i = ((DownloadInstContextMgr.DownloadInstContext)localObject).e.i();
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
          this.e.b(paramString);
          return true;
        case 4: 
          this.e.b(paramString);
          a(DownloadInfoBuilder.a(paramBundle, paramString));
          return true;
        case 3: 
        case 5: 
          this.e.c(paramString);
          return true;
        case 2: 
          paramString = this.b.a(paramString);
          if (paramString != null)
          {
            ((DownloadInstContextMgr.DownloadInstContext)localObject).e.a(paramString);
            ((DownloadInstContextMgr.DownloadInstContext)localObject).e.a(paramString, false);
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
  
  public DownloadingRbResmeInfoMgr d()
  {
    return this.d;
  }
  
  public void d(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.9(this, paramString, paramBundle));
  }
  
  public void e()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL-onAppDestroy]");
    this.a = null;
    this.e.a();
    ThreadManager.executeOnSubThread(new UniformDownloadMgr.2(this));
  }
  
  public void e(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.10(this, paramString, paramBundle));
  }
  
  public void f()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onActiveAccount...");
    h();
  }
  
  public void f(String paramString, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.11(this, paramString, paramBundle));
  }
  
  public void g()
  {
    QLog.i("UniformDownloadMgr_Impl", 1, "[UniformDL] UniformDownloadMgr onQQProcessExit...");
    this.e.c();
    this.c.c();
    this.d.c();
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.6(this));
  }
  
  public void g(String paramString, Bundle paramBundle)
  {
    f(paramString, paramBundle);
  }
  
  public void h()
  {
    ThreadManager.getSubThreadHandler().post(new UniformDownloadMgr.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr
 * JD-Core Version:    0.7.0.1
 */