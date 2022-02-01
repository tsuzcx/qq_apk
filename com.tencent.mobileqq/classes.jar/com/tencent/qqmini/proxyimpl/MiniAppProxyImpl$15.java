package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppProxyImpl$15
  implements DownloadListener
{
  MiniAppProxyImpl$15(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((MiniAppProxyImpl.b(this.a) != null) && (MiniAppProxyImpl.c(this.a) != null) && (MiniAppProxyImpl.b(this.a).equals(paramString1)) && (MiniAppProxyImpl.c(this.a).equals(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installSucceed: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; pkgname : ");
      localStringBuilder.append(paramString2);
      QLog.d("MiniAppProxyImpl", 1, localStringBuilder.toString());
      InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.a(this.a), null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.a(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((MiniAppProxyImpl.a(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.a(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.a(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.15.1(this));
      InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.a(this.a), null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.a(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.a(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
      InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.a(this.a), null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.a(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.a(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.15
 * JD-Core Version:    0.7.0.1
 */