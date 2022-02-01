package com.tencent.mobileqq.pic;

import azjq;
import java.util.concurrent.atomic.AtomicBoolean;

class PicPreDownloaderCore$1
  implements Runnable
{
  PicPreDownloaderCore$1(PicPreDownloaderCore paramPicPreDownloaderCore) {}
  
  public void run()
  {
    if (!PicPreDownloaderCore.a(this.this$0).get())
    {
      PicPreDownloaderCore.a(this.this$0).set(true);
      azjq.a("PIC_TAG_PRELOAD", "timer count off, picPreDownload set on", "mIsPicPreloadSuitable" + PicPreDownloaderCore.a(this.this$0).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.1
 * JD-Core Version:    0.7.0.1
 */