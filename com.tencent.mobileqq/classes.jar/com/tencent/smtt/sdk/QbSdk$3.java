package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import com.tencent.smtt.utils.TbsLog;

final class QbSdk$3
  extends Thread
{
  QbSdk$3(Context paramContext, Handler paramHandler) {}
  
  public void run()
  {
    int i = TbsInstaller.getInstance().getTbsCoreInstalledVerWithNew(true, this.val$context);
    TbsDownloader.setAppContext(this.val$context);
    TbsLog.i("QbSdk", "QbSdk preinit ver is " + i);
    if (i == 0) {
      TbsInstaller.getInstance().installTbsCoreIfNeeded(this.val$context, true);
    }
    TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
    SDKEngine.getInstance(true).init(this.val$context, false, false, null);
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(this.val$context, null);
    boolean bool = localX5CoreEngine.isX5Core();
    this.val$handler.sendEmptyMessage(3);
    if (!bool)
    {
      this.val$handler.sendEmptyMessage(2);
      return;
    }
    this.val$handler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.3
 * JD-Core Version:    0.7.0.1
 */