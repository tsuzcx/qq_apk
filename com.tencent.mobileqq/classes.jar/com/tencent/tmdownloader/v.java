package com.tencent.tmdownloader;

import com.tencent.tmassistant.common.PackageInstallReceiver;
import com.tencent.tmassistant.st.b;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.a.c;
import com.tencent.tmdownloader.internal.storage.a;
import java.util.ArrayList;

class v
  implements Runnable
{
  v(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = a.a().c();
    this.a.mServiceDownloadTaskManager = new c((ArrayList)localObject);
    try
    {
      this.a.mServiceDownloadTaskManager.a(this.a);
      this.a.mServiceDownloadTaskManager.a();
      if (GlobalUtil.getInstance().getContext() == null) {
        GlobalUtil.getInstance().setContext(this.a);
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ApkDownloadManager.getInstance().init();
        PackageInstallReceiver.a().a(this.a);
        b.a();
        label89:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Load downloadInfo end, timeCost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        aa.a(((StringBuilder)localObject).toString());
        ab.c("TMADownloadSDKService", "<onCreate>exit");
        return;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        break label89;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.v
 * JD-Core Version:    0.7.0.1
 */