package com.tencent.open.downloadnew;

class DownloadManager$16
  implements Runnable
{
  DownloadManager$16(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    this.this$0.k = null;
    if (UpdateManager.a()) {
      UpdateManager.b().c();
    }
    if (MyAppApi.r()) {
      MyAppApi.l().s();
    }
    DownloadManager localDownloadManager = this.this$0;
    localDownloadManager.a(localDownloadManager.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.16
 * JD-Core Version:    0.7.0.1
 */