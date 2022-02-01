package com.tencent.mobileqq.shortvideo;

import bbqf;
import bbqh;
import bbqp;
import bbqx;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(bbqp parambbqp) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      bbqx localbbqx = (bbqx)localIterator.next();
      bbqf.a(localbbqx, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbbqx.a != null) {
        bbqp.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbbqx.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */