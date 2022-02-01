package com.tencent.mobileqq.pic;

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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mIsPicPreloadSuitable");
      localStringBuilder.append(PicPreDownloaderCore.a(this.this$0).get());
      Logger.a("PIC_TAG_PRELOAD", "timer count off, picPreDownload set on", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.1
 * JD-Core Version:    0.7.0.1
 */