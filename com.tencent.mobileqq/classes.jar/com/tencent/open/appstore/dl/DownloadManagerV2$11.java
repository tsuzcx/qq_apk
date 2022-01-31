package com.tencent.open.appstore.dl;

import bdgt;
import bdgv;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$11
  implements Runnable
{
  public DownloadManagerV2$11(bdgv parambdgv, String paramString) {}
  
  public void run()
  {
    if (bdgv.a(this.this$0).get(this.a) != null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      localDownloadInfo = bdgt.a().a(this.a);
    } while (localDownloadInfo == null);
    this.this$0.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.11
 * JD-Core Version:    0.7.0.1
 */