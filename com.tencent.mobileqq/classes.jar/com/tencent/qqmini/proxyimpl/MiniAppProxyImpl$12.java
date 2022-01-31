package com.tencent.qqmini.proxyimpl;

import bdko;
import bexy;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppProxyImpl$12
  implements bdko
{
  MiniAppProxyImpl$12(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((MiniAppProxyImpl.access$1200(this.this$0) != null) && (MiniAppProxyImpl.access$1300(this.this$0) != null) && (MiniAppProxyImpl.access$1200(this.this$0).equals(paramString1)) && (MiniAppProxyImpl.access$1300(this.this$0).equals(paramString2)))
    {
      QLog.d("MiniAppProxyImpl", 1, "installSucceed: " + paramString1 + "; pkgname : " + paramString2);
      bexy.a(MiniAppProxyImpl.access$1100(this.this$0), null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.access$1000(this.this$0) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.access$1000(this.this$0).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((MiniAppProxyImpl.access$1000(this.this$0) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.access$1000(this.this$0).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.access$1000(this.this$0) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.access$1000(this.this$0).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.12.1(this));
      bexy.a(MiniAppProxyImpl.access$1100(this.this$0), null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.access$1000(this.this$0) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.access$1000(this.this$0).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
      bexy.a(MiniAppProxyImpl.access$1100(this.this$0), null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.access$1000(this.this$0) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.access$1000(this.this$0).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.12
 * JD-Core Version:    0.7.0.1
 */