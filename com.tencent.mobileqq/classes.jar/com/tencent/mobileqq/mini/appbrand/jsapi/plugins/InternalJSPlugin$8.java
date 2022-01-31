package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bfka;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.report.InnerAppReportDc4239;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class InternalJSPlugin$8
  implements bfka
{
  InternalJSPlugin$8(InternalJSPlugin paramInternalJSPlugin) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if ((InternalJSPlugin.access$400(this.this$0) != null) && (InternalJSPlugin.access$500(this.this$0) != null) && (InternalJSPlugin.access$400(this.this$0).equals(paramString1)) && (InternalJSPlugin.access$500(this.this$0).equals(paramString2)))
    {
      QLog.d("InternalJSPlugin", 1, "installSucceed: " + paramString1 + "; pkgname : " + paramString2);
      InnerAppReportDc4239.innerAppReport(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "installapp", "qqdownload");
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((InternalJSPlugin.access$300(this.this$0) != null) && (paramDownloadInfo != null) && (InternalJSPlugin.access$300(this.this$0).equals(paramDownloadInfo.d))) {
      QLog.d("InternalJSPlugin", 1, "onDownloadCancel");
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((InternalJSPlugin.access$300(this.this$0) != null) && (paramDownloadInfo != null) && (InternalJSPlugin.access$300(this.this$0).equals(paramDownloadInfo.d))) {
      QLog.d("InternalJSPlugin", 1, "onDownloadError");
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((InternalJSPlugin.access$300(this.this$0) != null) && (paramDownloadInfo != null) && (InternalJSPlugin.access$300(this.this$0).equals(paramDownloadInfo.d)))
    {
      QLog.d("InternalJSPlugin", 1, "onDownloadFinish");
      AppBrandTask.runTaskOnUiThread(new InternalJSPlugin.8.1(this));
      InnerAppReportDc4239.innerAppReport(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "downloadappfinish", "qqdownload");
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((InternalJSPlugin.access$300(this.this$0) != null) && (paramDownloadInfo != null) && (InternalJSPlugin.access$300(this.this$0).equals(paramDownloadInfo.d)))
    {
      QLog.d("InternalJSPlugin", 1, "onDownloadPause");
      InnerAppReportDc4239.innerAppReport(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, null, "launchapp", "downloadapppause", "qqdownload");
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((InternalJSPlugin.access$300(this.this$0) != null) && (paramDownloadInfo != null) && (InternalJSPlugin.access$300(this.this$0).equals(paramDownloadInfo.d))) {
      QLog.d("InternalJSPlugin", 1, "onDownloadWait");
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.8
 * JD-Core Version:    0.7.0.1
 */