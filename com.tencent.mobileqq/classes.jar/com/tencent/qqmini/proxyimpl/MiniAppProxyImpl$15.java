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
    if ((MiniAppProxyImpl.g(this.a) != null) && (MiniAppProxyImpl.h(this.a) != null) && (MiniAppProxyImpl.g(this.a).equals(paramString1)) && (MiniAppProxyImpl.h(this.a).equals(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("installSucceed: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; pkgname : ");
      localStringBuilder.append(paramString2);
      QLog.d("MiniAppProxyImpl", 1, localStringBuilder.toString());
      InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.f(this.a), null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.e(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.e(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((MiniAppProxyImpl.e(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.e(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.e(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.e(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.15.1(this));
      InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.f(this.a), null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.e(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.e(this.a).equals(paramDownloadInfo.d)))
    {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadPause");
      InnerAppReportDc4239.innerAppReport(MiniAppProxyImpl.f(this.a), null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((MiniAppProxyImpl.e(this.a) != null) && (paramDownloadInfo != null) && (MiniAppProxyImpl.e(this.a).equals(paramDownloadInfo.d))) {
      QLog.d("MiniAppProxyImpl", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.15
 * JD-Core Version:    0.7.0.1
 */