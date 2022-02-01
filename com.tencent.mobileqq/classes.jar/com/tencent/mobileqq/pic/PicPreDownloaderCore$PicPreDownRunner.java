package com.tencent.mobileqq.pic;

import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicInteger;

public class PicPreDownloaderCore$PicPreDownRunner
  implements Runnable
{
  Runnable a;
  String b;
  
  PicPreDownloaderCore$PicPreDownRunner(PicPreDownloaderCore paramPicPreDownloaderCore, Runnable paramRunnable, String paramString)
  {
    this.a = paramRunnable;
    this.b = paramString;
  }
  
  public void run()
  {
    this.a.run();
    PicPreDownloaderCore.g(this.this$0).decrementAndGet();
    PicPreDownloaderCore.h(this.this$0);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicPreDownloader ,");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.PicPreDownRunner
 * JD-Core Version:    0.7.0.1
 */