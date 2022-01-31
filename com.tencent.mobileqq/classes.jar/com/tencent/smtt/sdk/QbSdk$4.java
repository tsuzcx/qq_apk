package com.tencent.smtt.sdk;

import android.content.Context;

final class QbSdk$4
  implements TbsListener
{
  QbSdk$4(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onDownloadFinish(int paramInt) {}
  
  public void onDownloadProgress(int paramInt) {}
  
  public void onInstallFinish(int paramInt)
  {
    QbSdk.preInit(this.val$context, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.4
 * JD-Core Version:    0.7.0.1
 */