package com.tencent.open.appstore.dl;

import com.tencent.open.downloadnew.MyAppApi;

class DownloadManagerV2$4
  implements Runnable
{
  DownloadManagerV2$4(DownloadManagerV2 paramDownloadManagerV2) {}
  
  public void run()
  {
    if (!DownloadManagerV2.d(this.this$0))
    {
      MyAppApi.g();
      if (!MyAppApi.m()) {
        this.this$0.a(true);
      }
      DownloadManagerV2.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.4
 * JD-Core Version:    0.7.0.1
 */