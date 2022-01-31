package com.tencent.open.appstore.dl;

import bccs;
import bccu;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$11
  implements Runnable
{
  public DownloadManagerV2$11(bccu parambccu, String paramString) {}
  
  public void run()
  {
    if (bccu.a(this.this$0).get(this.a) != null) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      localDownloadInfo = bccs.a().a(this.a);
    } while (localDownloadInfo == null);
    this.this$0.d(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.11
 * JD-Core Version:    0.7.0.1
 */