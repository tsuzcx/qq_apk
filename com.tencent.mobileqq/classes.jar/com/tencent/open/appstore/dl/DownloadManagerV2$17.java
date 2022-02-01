package com.tencent.open.appstore.dl;

import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.downloadnew.DownloadInfo;

class DownloadManagerV2$17
  implements Runnable
{
  DownloadManagerV2$17(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo, boolean paramBoolean) {}
  
  public void run()
  {
    DownloadInfoDB.a().a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.17
 * JD-Core Version:    0.7.0.1
 */