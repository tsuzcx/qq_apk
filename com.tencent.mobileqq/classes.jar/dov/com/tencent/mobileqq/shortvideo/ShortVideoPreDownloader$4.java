package dov.com.tencent.mobileqq.shortvideo;

import bnpu;
import bnpv;
import bnpz;
import bnqa;
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
      bnqa localbnqa = (bnqa)localIterator.next();
      bnpu.a(localbnqa, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbnqa.a != null) {
        bnpz.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbnqa.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */