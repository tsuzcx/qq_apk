package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseSVReceiveOperator$2
  implements Runnable
{
  BaseSVReceiveOperator$2(BaseQQAppInterface paramBaseQQAppInterface, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    ShortVideoPreDownloader localShortVideoPreDownloader = ((QQAppInterface)this.a).getShortVideoPredownloer();
    if (localShortVideoPreDownloader.l.contains(this.b))
    {
      localShortVideoPreDownloader.l.remove(this.b);
      localShortVideoPreDownloader.m.decrementAndGet();
      localShortVideoPreDownloader.c.remove(this.b.e.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uniseq:");
      localStringBuilder.append(this.b.e.g);
      localStringBuilder.append(",curHandingNum:");
      localStringBuilder.append(localShortVideoPreDownloader.m.get());
      Logger.a("PIC_TAG_PRELOAD", "onDownload", localStringBuilder.toString());
      ((QQAppInterface)this.a).getShortVideoPredownloer().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseSVReceiveOperator.2
 * JD-Core Version:    0.7.0.1
 */