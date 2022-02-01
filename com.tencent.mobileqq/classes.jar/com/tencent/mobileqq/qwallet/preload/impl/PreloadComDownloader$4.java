package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.vip.DownloaderInterface;

class PreloadComDownloader$4
  implements Runnable
{
  public void run()
  {
    if (PreloadComDownloader.a(this.this$0) != null) {
      PreloadComDownloader.a(this.this$0).startDownload(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadComDownloader.4
 * JD-Core Version:    0.7.0.1
 */