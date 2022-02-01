package com.tencent.mobileqq.mini.apkg;

import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;

class ApkgManager$6
  implements Downloader.DownloadListener
{
  ApkgManager$6(ApkgManager paramApkgManager, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {}
  
  public void onDownloadCanceled(String paramString)
  {
    if (this.val$listener != null)
    {
      this.val$listener.onGetApkgInfo(null, 4, HardCodeUtil.a(2131700370));
      QLog.d("ApkgManager", 2, "onDownloadCanceled() called with: s = [" + paramString + "]");
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    int i;
    Object localObject;
    if ((paramDownloadResult != null) && (paramDownloadResult.getStatus() != null)) {
      if (paramDownloadResult.getStatus().exception2Code != 0)
      {
        i = paramDownloadResult.getStatus().exception2Code;
        MiniReportManager.reportEventType(this.val$miniAppConfig, 620, null, null, null, i);
        if ((this.val$miniAppConfig.config.verType == 3) || (paramDownloadResult.getStatus().httpStatus < 400) || (paramDownloadResult.getReport() == null) || (paramDownloadResult.getReport().response == null)) {
          break label307;
        }
        localObject = paramDownloadResult.getReport().response.headerIterator("x-Miniprogram-Download-Error");
        if (localObject == null) {
          break label307;
        }
        localObject = ((HeaderIterator)localObject).nextHeader();
        if (localObject == null) {
          break label307;
        }
      }
    }
    label307:
    while (this.val$listener == null)
    {
      try
      {
        String str1 = URLDecoder.decode(((Header)localObject).getValue(), "UTF-8");
        i = str1.indexOf("message=");
        int j = str1.length();
        String str2 = str1.substring("message=".length() + i, j);
        if (this.val$listener != null)
        {
          this.val$listener.onGetApkgInfo(null, 1, str2);
          QLog.d("ApkgManager", 1, "onDownloadFailed() called with: s = [" + paramString + "], httpStatus = [" + paramDownloadResult.getStatus().httpStatus + "]; header : " + ((Header)localObject).getName() + "; " + str1);
        }
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        QLog.e("ApkgManager", 1, "decode message error. " + paramString);
        return;
      }
      if (paramDownloadResult.getStatus().httpStatus > 0)
      {
        i = paramDownloadResult.getStatus().httpStatus;
        break;
      }
      i = -99999;
      break;
    }
    this.val$listener.onGetApkgInfo(null, 1, HardCodeUtil.a(2131700371));
    QLog.d("ApkgManager", 1, "onDownloadFailed() called with: s = [" + paramString + "], downloadResult = [" + paramDownloadResult + "]");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramDownloadResult != null)
    {
      l1 = l2;
      if (paramDownloadResult.getContent() != null) {
        l1 = paramDownloadResult.getContent().length;
      }
    }
    MiniReportManager.reportEventType(this.val$miniAppConfig, 620, String.valueOf(l1), "0");
    ApkgManager.access$200(this.this$0, this.val$savePath, this.val$unPackFolderPath, this.val$miniAppConfig, this.val$subApkUrl, this.val$independentPath, this.val$listener);
    ApkgManager.downloadDuration = System.currentTimeMillis() - this.val$startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.6
 * JD-Core Version:    0.7.0.1
 */