package com.tencent.mobileqq.shortvideo;

import azdo;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShortVideoPreDownloader$2
  implements Runnable
{
  public ShortVideoPreDownloader$2(azdo paramazdo) {}
  
  public void run()
  {
    if (!this.this$0.a.get())
    {
      this.this$0.a.set(true);
      azdo.a("openRunnable", "Timer count off, mIsPreDownloaderOpen=" + this.this$0.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */