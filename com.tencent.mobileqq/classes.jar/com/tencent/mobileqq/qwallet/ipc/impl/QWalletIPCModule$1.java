package com.tencent.mobileqq.qwallet.ipc.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import mqq.app.AppRuntime;

class QWalletIPCModule$1
  implements Runnable
{
  QWalletIPCModule$1(QWalletIPCModule paramQWalletIPCModule, Bundle paramBundle, int paramInt, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    String str = this.a.getString("id");
    QWalletIPCModule.1.1 local1 = new QWalletIPCModule.1.1(this, null);
    IPreloadService localIPreloadService = (IPreloadService)this.c.getRuntimeService(IPreloadService.class, "");
    if (localIPreloadService != null)
    {
      localIPreloadService.getFilePathByResID(str, local1);
      return;
    }
    local1.send(-7, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.1
 * JD-Core Version:    0.7.0.1
 */