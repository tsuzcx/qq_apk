package com.tencent.qqmini.sdk.manager;

import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class EngineInstaller$2
  implements DownloaderProxy.DownloadListener
{
  private float lastProgress = 0.0F;
  
  EngineInstaller$2(EngineInstaller paramEngineInstaller, String paramString1, BaseLibInfo paramBaseLibInfo, String paramString2, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("[MiniEng] onDownloadFailed ");
    paramString.append(this.val$engineUrl);
    QMLog.i("EngineInstaller", paramString.toString());
    if (this.val$info.baseLibType == 2) {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
    }
    EngineInstaller.access$000(this.this$0);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramFloat - this.lastProgress > 0.05F)
    {
      this.lastProgress = paramFloat;
      Object localObject = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("正在下载引擎 ");
      localStringBuilder.append(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(100.0F * paramFloat) }));
      localStringBuilder.append("%");
      EngineInstaller.access$100((EngineInstaller)localObject, paramFloat, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[MiniEng]onDownloadProgress, progress=");
      ((StringBuilder)localObject).append(paramFloat);
      QMLog.i("EngineInstaller", ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    paramString = new StringBuilder();
    paramString.append("[MiniEng] onDownloadSucceed ");
    paramString.append(this.val$engineUrl);
    QMLog.i("EngineInstaller", paramString.toString());
    paramString = new File(this.val$tmpZipFile);
    long l1 = paramString.length();
    long l2 = this.val$engineFileSize;
    if ((l1 != l2) && (l2 > 0L))
    {
      paramDownloadResult = new StringBuilder();
      paramDownloadResult.append("[MiniEng]refuse to unzip ");
      paramDownloadResult.append(this.val$tmpZipFile);
      paramDownloadResult.append(" length=");
      paramDownloadResult.append(paramString.length());
      paramDownloadResult.append(", mEngineFileSize=");
      paramDownloadResult.append(this.val$engineFileSize);
      QMLog.i("EngineInstaller", paramDownloadResult.toString());
      EngineInstaller.access$000(this.this$0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("[MiniEng] onDownloadSucceed length is match ");
    paramString.append(this.val$engineFileSize);
    QMLog.i("EngineInstaller", paramString.toString());
    EngineInstaller.access$100(this.this$0, 1.0F, "正在下载引擎 100%");
    if (this.val$info.baseLibType == 2)
    {
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, "1");
      MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, "1");
    }
    for (;;)
    {
      try
      {
        boolean bool = EngineInstaller.access$200(this.this$0, this.val$engineRootDir, this.val$engineUrl, this.val$engineVersion, this.val$tmpZipFile, this.val$isUpdate);
        if (this.val$info.baseLibType == 2)
        {
          paramString = ReportConst.miniAppConfigForPreload();
          if (bool)
          {
            paramInt = 0;
            MiniReportManager.reportEventType(paramString, 7, null, null, null, paramInt, "1", 0L, null);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineInstaller.2
 * JD-Core Version:    0.7.0.1
 */