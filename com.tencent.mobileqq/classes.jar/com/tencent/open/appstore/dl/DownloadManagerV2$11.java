package com.tencent.open.appstore.dl;

import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManagerV2$11
  implements Runnable
{
  DownloadManagerV2$11(DownloadManagerV2 paramDownloadManagerV2, String paramString) {}
  
  public void run()
  {
    if (DownloadManagerV2.a(this.this$0).get(this.a) != null) {
      return;
    }
    DownloadInfo localDownloadInfo = DownloadInfoDB.a().a(this.a);
    if (localDownloadInfo != null) {
      this.this$0.c(localDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.11
 * JD-Core Version:    0.7.0.1
 */