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
    Object localObject = this.val$listener;
    if (localObject != null)
    {
      ((ApkgManager.OnGetApkgInfoListener)localObject).onGetApkgInfo(null, 4, HardCodeUtil.a(2131700512));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadCanceled() called with: s = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("ApkgManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    if ((paramDownloadResult != null) && (paramDownloadResult.getStatus() != null))
    {
      int i;
      if (paramDownloadResult.getStatus().exception2Code != 0) {
        i = paramDownloadResult.getStatus().exception2Code;
      }
      for (;;)
      {
        break;
        if (paramDownloadResult.getStatus().httpStatus > 0) {
          i = paramDownloadResult.getStatus().httpStatus;
        } else {
          i = -99999;
        }
      }
      MiniReportManager.reportEventType(this.val$miniAppConfig, 620, null, null, null, i);
      if ((this.val$miniAppConfig.config.verType != 3) && (paramDownloadResult.getStatus().httpStatus >= 400) && (paramDownloadResult.getReport() != null) && (paramDownloadResult.getReport().response != null))
      {
        localObject1 = paramDownloadResult.getReport().response.headerIterator("x-Miniprogram-Download-Error");
        if (localObject1 != null)
        {
          localObject1 = ((HeaderIterator)localObject1).nextHeader();
          if (localObject1 != null)
          {
            try
            {
              String str = URLDecoder.decode(((Header)localObject1).getValue(), "UTF-8");
              Object localObject2 = str.substring(str.indexOf("message=") + 8, str.length());
              if (this.val$listener != null)
              {
                this.val$listener.onGetApkgInfo(null, 1, (String)localObject2);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("onDownloadFailed() called with: s = [");
                ((StringBuilder)localObject2).append(paramString);
                ((StringBuilder)localObject2).append("], httpStatus = [");
                ((StringBuilder)localObject2).append(paramDownloadResult.getStatus().httpStatus);
                ((StringBuilder)localObject2).append("]; header : ");
                ((StringBuilder)localObject2).append(((Header)localObject1).getName());
                ((StringBuilder)localObject2).append("; ");
                ((StringBuilder)localObject2).append(str);
                QLog.d("ApkgManager", 1, ((StringBuilder)localObject2).toString());
                return;
              }
            }
            catch (UnsupportedEncodingException paramString)
            {
              paramDownloadResult = new StringBuilder();
              paramDownloadResult.append("decode message error. ");
              paramDownloadResult.append(paramString);
              QLog.e("ApkgManager", 1, paramDownloadResult.toString());
            }
            return;
          }
        }
      }
    }
    Object localObject1 = this.val$listener;
    if (localObject1 != null)
    {
      ((ApkgManager.OnGetApkgInfoListener)localObject1).onGetApkgInfo(null, 1, HardCodeUtil.a(2131700513));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDownloadFailed() called with: s = [");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("], downloadResult = [");
      ((StringBuilder)localObject1).append(paramDownloadResult);
      ((StringBuilder)localObject1).append("]");
      QLog.d("ApkgManager", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    long l;
    if ((paramDownloadResult != null) && (paramDownloadResult.getContent() != null)) {
      l = paramDownloadResult.getContent().length;
    } else {
      l = -1L;
    }
    MiniReportManager.reportEventType(this.val$miniAppConfig, 620, String.valueOf(l), "0");
    ApkgManager.access$200(this.this$0, this.val$savePath, this.val$unPackFolderPath, this.val$miniAppConfig, this.val$subApkUrl, this.val$independentPath, this.val$listener);
    ApkgManager.downloadDuration = System.currentTimeMillis() - this.val$startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.6
 * JD-Core Version:    0.7.0.1
 */