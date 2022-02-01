package com.tencent.mobileqq.shortvideo;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

class ShortVideoPreDownloader$5
  implements Runnable
{
  ShortVideoPreDownloader$5(ShortVideoPreDownloader paramShortVideoPreDownloader) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)localIterator.next();
      ShortVideoBusiManager.a(localShortVideoReq, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localShortVideoReq.a != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("consume thumb, uniseq=");
        localStringBuilder.append(localShortVideoReq.a.a);
        ShortVideoPreDownloader.a("consumeAllThumbsInPendingQueue", localStringBuilder.toString());
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */