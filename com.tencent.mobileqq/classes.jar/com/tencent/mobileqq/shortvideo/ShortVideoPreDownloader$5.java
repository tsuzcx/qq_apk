package com.tencent.mobileqq.shortvideo;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

class ShortVideoPreDownloader$5
  implements Runnable
{
  ShortVideoPreDownloader$5(ShortVideoPreDownloader paramShortVideoPreDownloader) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.k.iterator();
    while (localIterator.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)localIterator.next();
      ShortVideoBusiManager.a(localShortVideoReq, this.this$0.a);
      if (localShortVideoReq.e != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("consume thumb, uniseq=");
        localStringBuilder.append(localShortVideoReq.e.g);
        ShortVideoPreDownloader.a("consumeAllThumbsInPendingQueue", localStringBuilder.toString());
      }
    }
    this.this$0.k.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */