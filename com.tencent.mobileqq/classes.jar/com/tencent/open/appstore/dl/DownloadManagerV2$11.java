package com.tencent.open.appstore.dl;

import bfkp;
import bfkr;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$11
  implements Runnable
{
  public DownloadManagerV2$11(bfkr parambfkr, String paramString) {}
  
  public void run()
  {
    if (bfkr.a(this.this$0).get(this.a) != null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      localDownloadInfo = bfkp.a().a(this.a);
    } while (localDownloadInfo == null);
    this.this$0.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.11
 * JD-Core Version:    0.7.0.1
 */