package com.tencent.open.downloadnew;

class DownloadManager$1
  implements Runnable
{
  DownloadManager$1(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    if (!this.this$0.a)
    {
      MyAppApi.a();
      if (!MyAppApi.b()) {
        this.this$0.a(true);
      }
      this.this$0.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.1
 * JD-Core Version:    0.7.0.1
 */