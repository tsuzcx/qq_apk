package com.tencent.smtt.sdk;

import android.content.Context;

final class QbSdk$3
  implements TbsListener
{
  QbSdk$3(Context paramContext, QbSdk.PreInitCallback paramPreInitCallback) {}
  
  public void onDownloadFinish(int paramInt) {}
  
  public void onDownloadProgress(int paramInt) {}
  
  public void onInstallFinish(int paramInt)
  {
    QbSdk.preInit(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk.3
 * JD-Core Version:    0.7.0.1
 */