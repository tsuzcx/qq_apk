package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

class EngineInstaller$1
  implements AbstractDownloader.DownloadListener
{
  private float lastProgress = 0.0F;
  
  EngineInstaller$1(EngineInstaller paramEngineInstaller, BaseLibInfo paramBaseLibInfo, long paramLong, File paramFile, String paramString, EngineVersion paramEngineVersion, boolean paramBoolean) {}
  
  public void onDownloadCanceled(String paramString)
  {
    QLog.i("EngineInstaller", 1, "[MiniEng] onDownloadCanceled");
    EngineInstaller.access$000(this.this$0);
  }
  
  public void onDownloadFailed(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] onDownloadFailed ");
    localStringBuilder.append(paramString);
    QLog.i("EngineInstaller", 1, localStringBuilder.toString());
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
      paramString = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131704249));
      localStringBuilder.append(String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(100.0F * paramFloat) }));
      localStringBuilder.append("%");
      EngineInstaller.access$100(paramString, paramFloat, localStringBuilder.toString());
      paramString = new StringBuilder();
      paramString.append("[MiniEng]onDownloadProgress, progress=");
      paramString.append(paramFloat);
      QLog.i("EngineInstaller", 1, paramString.toString());
    }
  }
  
  public void onDownloadSucceed(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] onDownloadSucceed ");
    localStringBuilder.append(paramString1);
    QLog.i("EngineInstaller", 1, localStringBuilder.toString());
    paramString1 = new File(paramString2);
    long l1 = paramString1.length();
    long l2 = this.val$engineFileSize;
    if ((l1 != l2) && (l2 >= 0L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng]refuse to unzip ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" length=");
      localStringBuilder.append(paramString1.length());
      localStringBuilder.append(", mEngineFileSize=");
      localStringBuilder.append(this.val$engineFileSize);
      QLog.i("EngineInstaller", 1, localStringBuilder.toString());
      EngineInstaller.access$000(this.this$0);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[MiniEng] onDownloadSucceed length is match ");
    paramString1.append(this.val$engineFileSize);
    QLog.i("EngineInstaller", 1, paramString1.toString());
    EngineInstaller.access$100(this.this$0, 1.0F, HardCodeUtil.a(2131704250));
    if (this.val$info.baseLibType == 2)
    {
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 5, "1");
      MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 6, "1");
    }
    for (;;)
    {
      try
      {
        boolean bool = EngineInstaller.access$200(this.this$0, this.val$engineRootDir, this.val$engineUrl, this.val$engineVersion, paramString2, this.val$isUpdate);
        if (this.val$info.baseLibType == 2)
        {
          paramString1 = MiniProgramReportHelper.miniAppConfigForPreload();
          if (bool)
          {
            i = 0;
            MiniReportManager.reportEventType(paramString1, 7, null, null, null, i, "1", 0L, null);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstaller.1
 * JD-Core Version:    0.7.0.1
 */