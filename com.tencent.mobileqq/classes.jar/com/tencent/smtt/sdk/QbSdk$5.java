package com.tencent.smtt.sdk;

import android.content.Context;

final class QbSdk$5
  implements TbsDownloader.TbsDownloaderCallback
{
  QbSdk$5(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if ((TbsShareManager.findCoreForThirdPartyApp(this.val$context) == 0) && (!TbsShareManager.getCoreDisabled())) {
      TbsShareManager.forceToLoadX5ForThirdApp(this.val$context, false);
    }
    if ((QbSdk.mIsBuglyEnabled) && (TbsShareManager.isThirdPartyApp(this.val$context))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.val$context);
    }
    QbSdk.preInit(this.val$context, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.5
 * JD-Core Version:    0.7.0.1
 */