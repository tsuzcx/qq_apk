package com.tencent.qqmini.sdk.task;

import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.InstalledEngine;

class MiniAppSoLoader$1
  implements Runnable
{
  MiniAppSoLoader$1(MiniAppSoLoader paramMiniAppSoLoader, IWXLivePlayerProxy paramIWXLivePlayerProxy) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadAllOk, TXLiveBase.setLibraryPath:");
    localStringBuilder.append(MiniAppSoLoader.access$000(this.this$0).engineDir);
    QMLog.d("MiniAppSoLoader", localStringBuilder.toString());
    this.a.hookListenerAndGoOn(MiniAppSoLoader.access$000(this.this$0).engineDir, new MiniAppSoLoader.InnerTXLiveBaseListenerImpl(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppSoLoader.1
 * JD-Core Version:    0.7.0.1
 */