package com.tencent.mobileqq.shortvideo;

import bcec;
import bcef;
import bcen;
import bcev;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(bcen parambcen) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      bcev localbcev = (bcev)localIterator.next();
      bcec.a(localbcev, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbcev.a != null) {
        bcen.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbcev.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */