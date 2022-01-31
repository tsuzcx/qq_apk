package com.tencent.mobileqq.shortvideo;

import axdq;
import axdt;
import axeb;
import axei;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(axeb paramaxeb) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      axei localaxei = (axei)localIterator.next();
      axdq.a(localaxei, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localaxei.a != null) {
        axeb.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localaxei.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */