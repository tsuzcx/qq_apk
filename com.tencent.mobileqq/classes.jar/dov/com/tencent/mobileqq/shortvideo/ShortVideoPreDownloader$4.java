package dov.com.tencent.mobileqq.shortvideo;

import bjiw;
import bjix;
import bjjb;
import bjjc;
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
      bjjc localbjjc = (bjjc)localIterator.next();
      bjiw.a(localbjjc, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbjjc.a != null) {
        bjjb.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbjjc.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */