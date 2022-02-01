package org.xwalk.core;

import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.updater.Scheduler;

class XWalkUpdater$BackgroundListener
  implements XWalkLibraryLoader.DownloadListener
{
  private XWalkUpdater.UpdateConfig mConfig;
  
  public XWalkUpdater$BackgroundListener(XWalkUpdater paramXWalkUpdater, XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    this.mConfig = paramUpdateConfig;
  }
  
  private void reportKV(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onDownloadCancelled()
  {
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateCancelled();
  }
  
  public void onDownloadCompleted(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download apk completed, apkver = ");
    localStringBuilder.append(this.mConfig.apkVer);
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", localStringBuilder.toString());
    if (this.mConfig.isPatchUpdate) {
      h.e(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    } else {
      h.c(System.currentTimeMillis() - paramDownloadInfo.mStartTimestamp);
    }
    reportKV(paramDownloadInfo);
    new XWalkUpdater.BackgroundListener.1(this).execute(new Void[0]);
  }
  
  public void onDownloadFailed(XWalkLibraryLoader.DownloadInfo paramDownloadInfo)
  {
    XWalkInitializer.addXWalkInitializeLog("XWalkLib", "download apk failed");
    if (this.mConfig.isPatchUpdate) {
      h.A();
    } else {
      h.v();
    }
    reportKV(paramDownloadInfo);
    paramDownloadInfo = this.mConfig;
    if ((paramDownloadInfo != null) && (paramDownloadInfo.scheduler != null)) {
      this.mConfig.scheduler.b(-1);
    }
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateFailed(-1, this.mConfig.scheduler);
  }
  
  public void onDownloadStarted(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadTask started, type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" config:");
    localStringBuilder.append(this.mConfig.getLogSelf());
    Log.d("XWalkLib", localStringBuilder.toString());
    if (this.mConfig.isPatchUpdate) {
      h.z();
    } else {
      h.u();
    }
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateStarted();
  }
  
  public void onDownloadUpdated(int paramInt)
  {
    XWalkUpdater.access$000(this.this$0).onXWalkUpdateProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.BackgroundListener
 * JD-Core Version:    0.7.0.1
 */