package dov.com.tencent.mobileqq.shortvideo;

import brhv;
import brhw;
import bria;
import bric;
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
      bric localbric = (bric)localIterator.next();
      brhv.a(localbric, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbric.a != null) {
        bria.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbric.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */