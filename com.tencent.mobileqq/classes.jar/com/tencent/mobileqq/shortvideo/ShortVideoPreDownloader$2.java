package com.tencent.mobileqq.shortvideo;

import java.util.concurrent.atomic.AtomicBoolean;

class ShortVideoPreDownloader$2
  implements Runnable
{
  ShortVideoPreDownloader$2(ShortVideoPreDownloader paramShortVideoPreDownloader) {}
  
  public void run()
  {
    if (!this.this$0.i.get())
    {
      this.this$0.i.set(true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Timer count off, mIsPreDownloaderOpen=");
      localStringBuilder.append(this.this$0.i.get());
      ShortVideoPreDownloader.a("openRunnable", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */