package dov.com.tencent.mobileqq.shortvideo;

import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

class ShortVideoPreDownloader$4
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      ShortVideoReq localShortVideoReq = (ShortVideoReq)localIterator.next();
      ShortVideoBusiManager.a(localShortVideoReq, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localShortVideoReq.a != null) {
        ShortVideoPreDownloader.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localShortVideoReq.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */