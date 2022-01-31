package com.tencent.mobileqq.shortvideo;

import aweg;
import awej;
import awer;
import awey;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(awer paramawer) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      awey localawey = (awey)localIterator.next();
      aweg.a(localawey, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localawey.a != null) {
        awer.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localawey.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */