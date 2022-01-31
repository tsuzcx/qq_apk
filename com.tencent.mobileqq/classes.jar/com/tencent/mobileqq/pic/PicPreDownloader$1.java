package com.tencent.mobileqq.pic;

import aung;
import java.util.concurrent.atomic.AtomicBoolean;

class PicPreDownloader$1
  implements Runnable
{
  PicPreDownloader$1(PicPreDownloader paramPicPreDownloader) {}
  
  public void run()
  {
    if (!this.this$0.a.get())
    {
      this.this$0.a.set(true);
      aung.b("PIC_TAG_PRELOAD", "timer count off,picPreDownload set on", "mIsPicPreloadSuitable" + this.this$0.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.1
 * JD-Core Version:    0.7.0.1
 */