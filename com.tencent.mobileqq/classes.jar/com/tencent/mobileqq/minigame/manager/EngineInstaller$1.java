package com.tencent.mobileqq.minigame.manager;

import ajya;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

class EngineInstaller$1
  implements AbstractDownloader.DownloadListener
{
  private float lastProgress;
  
  EngineInstaller$1(EngineInstaller paramEngineInstaller, BaseLibInfo paramBaseLibInfo, long paramLong, File paramFile, String paramString, EngineVersion paramEngineVersion, boolean paramBoolean) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadCanceled");
    EngineInstaller.access$000(this.this$0);
  }
  
  public void onDownloadFailed(String paramString)
  {
    QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadFailed " + paramString);
    if (this.val$info.baseLibType == 2) {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, null, null, null, 1, "1", 0L, null);
    }
    EngineInstaller.access$000(this.this$0);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    if (paramFloat - this.lastProgress > 0.05F)
    {
      this.lastProgress = paramFloat;
      EngineInstaller.access$100(this.this$0, paramFloat, ajya.a(2131704142) + String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%");
      QLog.i("EngineInstaller", 1, "[MiniEng]onDownloadProgress, progress=" + paramFloat);
    }
  }
  
  public void onDownloadSucceed(String paramString1, String paramString2)
  {
    int i = 1;
    QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadSucceed " + paramString1);
    paramString1 = new File(paramString2);
    if ((paramString1.length() == this.val$engineFileSize) || (this.val$engineFileSize < 0L))
    {
      QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadSucceed length is match " + this.val$engineFileSize);
      EngineInstaller.access$100(this.this$0, 1.0F, ajya.a(2131704143));
      if (this.val$info.baseLibType == 2)
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, "1");
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 6, "1");
      }
      try
      {
        boolean bool = EngineInstaller.access$200(this.this$0, this.val$engineRootDir, this.val$engineUrl, this.val$engineVersion, paramString2, this.val$isUpdate);
        if (this.val$info.baseLibType == 2)
        {
          paramString1 = MiniProgramReportHelper.miniAppConfigForPreload();
          if (bool) {
            i = 0;
          }
          MiniReportManager.reportEventType(paramString1, 7, null, null, null, i, "1", 0L, null);
        }
        return;
      }
      finally {}
    }
    QLog.i("EngineInstaller", 1, "[MiniEng]refuse to unzip " + paramString2 + " length=" + paramString1.length() + ", mEngineFileSize=" + this.val$engineFileSize);
    EngineInstaller.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstaller.1
 * JD-Core Version:    0.7.0.1
 */