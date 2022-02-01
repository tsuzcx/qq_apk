package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class UniformDownloader$2
  implements IUniformDownloaderListener
{
  UniformDownloader$2(UniformDownloader paramUniformDownloader) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool = this.a.c();
    Object localObject1 = UniformDownloader.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.a.b);
    ((StringBuilder)localObject2).append("]. onDownloadStart. start:");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("progress:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (bool) {
      return;
    }
    this.a.a(true);
    localObject1 = UniformDownloader.c(this.a);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IUniformDownloaderListener)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((IUniformDownloaderListener)localObject2).a(paramInt, paramBundle);
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject1 = UniformDownloader.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.a.b);
    ((StringBuilder)localObject2).append("]. onDownloadFailed. errcode:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("errStr:");
    ((StringBuilder)localObject2).append(paramString);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if ((UniformDownloader.f(this.a) < 1) && (1 == UniformDownloader.d(this.a)))
    {
      localObject1 = UniformDownloader.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.a.b);
      ((StringBuilder)localObject2).append("]. onDownloadFailed. errorRetry");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      UniformDownloader.g(this.a);
      UniformDownloader.a(this.a, paramInt, paramString, paramBundle);
      return;
    }
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    localObject1 = UniformDownloader.c(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IUniformDownloaderListener)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((IUniformDownloaderListener)localObject2).a(paramInt, paramString, paramBundle);
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    paramBundle = UniformDownloader.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append("]. onDownloadSucess. filePath:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", UniformDownloader.d(this.a));
    paramBundle.putString("_CB_URL", UniformDownloader.e(this.a));
    paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    localObject = UniformDownloader.c(this.a).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)((Iterator)localObject).next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.a(paramString, paramLong, paramBundle);
      }
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    Iterator localIterator = UniformDownloader.c(this.a).iterator();
    while (localIterator.hasNext())
    {
      IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.b(paramInt, paramBundle);
      }
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = UniformDownloader.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.a.b);
    ((StringBuilder)localObject2).append("]. onDownloadPause. progress:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    localObject1 = UniformDownloader.c(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IUniformDownloaderListener)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((IUniformDownloaderListener)localObject2).c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = UniformDownloader.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.a.b);
    ((StringBuilder)localObject2).append("]. onDownloadResume. progress:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    localObject1 = UniformDownloader.c(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IUniformDownloaderListener)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((IUniformDownloaderListener)localObject2).d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader.2
 * JD-Core Version:    0.7.0.1
 */