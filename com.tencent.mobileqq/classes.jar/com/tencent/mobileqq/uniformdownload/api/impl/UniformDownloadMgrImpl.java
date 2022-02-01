package com.tencent.mobileqq.uniformdownload.api.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class UniformDownloadMgrImpl
  implements IUniformDownloadMgr
{
  private static final String TAG = "UniformDownloadMgrImpl";
  
  public AppRuntime getApp()
  {
    return UniformDownloadMgr.a().b();
  }
  
  public boolean isExistedDownloadOfUrl(String paramString)
  {
    return UniformDownloadMgr.a().b(paramString);
  }
  
  public void onActiveAccount()
  {
    UniformDownloadMgr.a().f();
  }
  
  public void onAppInit(AppRuntime paramAppRuntime)
  {
    UniformDownloadMgr.a().a(paramAppRuntime);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (!(paramAppRuntime instanceof BaseQQAppInterface))
    {
      QLog.d("UniformDownloadMgrImpl", 1, "[onCreate] can not get app, only support process main.");
      return;
    }
    QLog.d("UniformDownloadMgrImpl", 1, "[onCreate] run UniformDownloadMgr onAppInit...");
    UniformDownloadMgr.a().a(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    UniformDownloadMgr.a().e();
  }
  
  public void onQQProcessExit()
  {
    UniformDownloadMgr.a().g();
  }
  
  public void removeOuterListenner(String paramString)
  {
    UniformDownloadMgr.a().a(paramString);
  }
  
  public void startDownload(String paramString, Bundle paramBundle)
  {
    UniformDownloadMgr.a().a(paramString, paramBundle);
  }
  
  public void startDownload(String paramString, Bundle paramBundle, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    UniformDownloadMgr.a().a(paramString, paramBundle, paramIUniformDownloaderListener);
  }
  
  public void startDownloadNoSzie(String paramString, Bundle paramBundle)
  {
    UniformDownloadMgr.a().b(paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.api.impl.UniformDownloadMgrImpl
 * JD-Core Version:    0.7.0.1
 */