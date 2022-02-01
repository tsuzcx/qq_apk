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
    QMLog.i("EngineInstaller", "[MiniEng] onDownloadFailed " + this.val$engineUrl);
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
      EngineInstaller.access$100(this.this$0, paramFloat, "正在下载引擎 " + String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%");
      QMLog.i("EngineInstaller", "[MiniEng]onDownloadProgress, progress=" + paramFloat);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    QMLog.i("EngineInstaller", "[MiniEng] onDownloadSucceed " + this.val$engineUrl);
    paramString = new File(this.val$tmpZipFile);
    if ((paramString.length() == this.val$engineFileSize) || (this.val$engineFileSize < 0L))
    {
      QMLog.i("EngineInstaller", "[MiniEng] onDownloadSucceed length is match " + this.val$engineFileSize);
      EngineInstaller.access$100(this.this$0, 1.0F, "正在下载引擎 100%");
      if (this.val$info.baseLibType == 2)
      {
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 5, "1");
        MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), 6, "1");
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = EngineInstaller.access$200(this.this$0, this.val$engineRootDir, this.val$engineUrl, this.val$engineVersion, this.val$tmpZipFile, this.val$isUpdate);
        if (this.val$info.baseLibType == 2)
        {
          paramString = ReportConst.miniAppConfigForPreload();
          if (!bool) {
            break label264;
          }
          paramInt = 0;
          MiniReportManager.reportEventType(paramString, 7, null, null, null, paramInt, "1", 0L, null);
        }
        return;
      }
      finally {}
      QMLog.i("EngineInstaller", "[MiniEng]refuse to unzip " + this.val$tmpZipFile + " length=" + paramString.length() + ", mEngineFileSize=" + this.val$engineFileSize);
      EngineInstaller.access$000(this.this$0);
      return;
      label264:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.EngineInstaller.2
 * JD-Core Version:    0.7.0.1
 */