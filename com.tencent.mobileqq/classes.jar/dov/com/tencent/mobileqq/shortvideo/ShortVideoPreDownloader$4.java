package dov.com.tencent.mobileqq.shortvideo;

import bkzy;
import bkzz;
import blad;
import blae;
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
      blae localblae = (blae)localIterator.next();
      bkzy.a(localblae, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localblae.a != null) {
        blad.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localblae.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */