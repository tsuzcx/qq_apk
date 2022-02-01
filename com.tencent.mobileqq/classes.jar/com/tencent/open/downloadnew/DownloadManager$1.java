package com.tencent.open.downloadnew;

class DownloadManager$1
  implements Runnable
{
  DownloadManager$1(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    if (!this.this$0.f)
    {
      MyAppApi.l();
      if (!MyAppApi.m()) {
        this.this$0.a(true);
      }
      this.this$0.f = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.1
 * JD-Core Version:    0.7.0.1
 */