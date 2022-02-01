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
    boolean bool = this.a.a();
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadStart. start:" + bool + "progress:" + paramInt);
    if (bool) {}
    for (;;)
    {
      return;
      this.a.a(true);
      Object localObject = UniformDownloader.a(this.a);
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)((Iterator)localObject).next();
        if (localIUniformDownloaderListener != null) {
          localIUniformDownloaderListener.a(paramInt, paramBundle);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errcode:" + paramInt + "errStr:" + paramString);
    if ((UniformDownloader.b(this.a) < 1) && (1 == UniformDownloader.a(this.a)))
    {
      QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadFailed. errorRetry");
      UniformDownloader.c(this.a);
      UniformDownloader.a(this.a, paramInt, paramString, paramBundle);
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
      }
      Iterator localIterator = UniformDownloader.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)localIterator.next();
        if (localIUniformDownloaderListener != null) {
          localIUniformDownloaderListener.a(paramInt, paramString, paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadSucess. filePath:" + paramString);
    paramBundle = new Bundle();
    paramBundle.putInt("_CB_SID", UniformDownloader.a(this.a));
    paramBundle.putString("_CB_URL", UniformDownloader.a(this.a));
    paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)localIterator.next();
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
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
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
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadPause. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.c(paramInt, paramBundle);
      }
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloader.jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + this.a.jdField_a_of_type_Long + "]. onDownloadResume. progress:" + paramInt);
    if (paramBundle != null) {
      paramBundle.putBundle("_CB_USERDATA", UniformDownloader.b(this.a));
    }
    Iterator localIterator = UniformDownloader.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      IUniformDownloaderListener localIUniformDownloaderListener = (IUniformDownloaderListener)localIterator.next();
      if (localIUniformDownloaderListener != null) {
        localIUniformDownloaderListener.d(paramInt, paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloader.2
 * JD-Core Version:    0.7.0.1
 */