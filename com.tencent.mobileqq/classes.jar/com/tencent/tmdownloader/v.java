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
    ArrayList localArrayList = a.a().c();
    this.a.mServiceDownloadTaskManager = new c(localArrayList);
    try
    {
      this.a.mServiceDownloadTaskManager.a(this.a);
      this.a.mServiceDownloadTaskManager.a();
      label50:
      if (GlobalUtil.getInstance().getContext() == null) {
        GlobalUtil.getInstance().setContext(this.a);
      }
      try
      {
        ApkDownloadManager.getInstance().init();
        PackageInstallReceiver.a().a(this.a);
        b.a();
        label89:
        aa.a("Load downloadInfo end, timeCost = " + (System.currentTimeMillis() - l));
        ab.c("TMADownloadSDKService", "<onCreate>exit");
        return;
      }
      catch (Throwable localThrowable1)
      {
        break label89;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.v
 * JD-Core Version:    0.7.0.1
 */