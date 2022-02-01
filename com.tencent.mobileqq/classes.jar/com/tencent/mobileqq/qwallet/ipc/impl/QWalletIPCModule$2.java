package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import mqq.app.AppRuntime;

class QWalletIPCModule$2
  implements Runnable
{
  QWalletIPCModule$2(QWalletIPCModule paramQWalletIPCModule, Bundle paramBundle, AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    String str1 = this.a.getString("config_str");
    String str2 = this.a.getString("id");
    QWalletIPCModule.2.1 local1 = new QWalletIPCModule.2.1(this, (ResultReceiver)this.a.getParcelable("receiver"));
    IPreloadService localIPreloadService = (IPreloadService)this.b.getRuntimeService(IPreloadService.class, "");
    if ("downloadModule".equals(this.c))
    {
      localIPreloadService.downloadModule(str2, str1, local1);
      return;
    }
    if ("downloadRes".equals(this.c)) {
      localIPreloadService.downloadRes(str2, str1, local1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.2
 * JD-Core Version:    0.7.0.1
 */