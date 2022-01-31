package dov.com.tencent.mobileqq.shortvideo;

import bkzh;
import bkzi;
import bkzm;
import bkzn;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$4
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      bkzn localbkzn = (bkzn)localIterator.next();
      bkzh.a(localbkzn, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbkzn.a != null) {
        bkzm.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbkzn.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */