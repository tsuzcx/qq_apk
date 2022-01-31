package com.tencent.mobileqq.shortvideo;

import ayyu;
import ayyx;
import ayzf;
import ayzo;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(ayzf paramayzf) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      ayzo localayzo = (ayzo)localIterator.next();
      ayyu.a(localayzo, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localayzo.a != null) {
        ayzf.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localayzo.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */