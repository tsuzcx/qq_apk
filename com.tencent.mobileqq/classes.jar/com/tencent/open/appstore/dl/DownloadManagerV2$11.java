package com.tencent.open.appstore.dl;

import bdhi;
import bdhk;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$11
  implements Runnable
{
  public DownloadManagerV2$11(bdhk parambdhk, String paramString) {}
  
  public void run()
  {
    if (bdhk.a(this.this$0).get(this.a) != null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      localDownloadInfo = bdhi.a().a(this.a);
    } while (localDownloadInfo == null);
    this.this$0.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.11
 * JD-Core Version:    0.7.0.1
 */