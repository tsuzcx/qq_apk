package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.a.c;
import com.tencent.tmdownloader.internal.storage.a;
import java.util.ArrayList;

class u
  implements Runnable
{
  u(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void run()
  {
    ArrayList localArrayList = a.a().c();
    this.a.mServiceDownloadTaskManager = new c(localArrayList);
    this.a.mServiceDownloadTaskManager.a(this.a);
    this.a.mServiceDownloadTaskManager.a();
    if (GlobalUtil.getInstance().getContext() == null) {
      GlobalUtil.getInstance().setContext(this.a);
    }
    ApkDownloadManager.getInstance().init();
    r.c("TMAssistantDownloadSDKService", "<onCreate>exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.u
 * JD-Core Version:    0.7.0.1
 */