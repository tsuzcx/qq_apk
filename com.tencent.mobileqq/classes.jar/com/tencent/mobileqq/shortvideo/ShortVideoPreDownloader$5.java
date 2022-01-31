package com.tencent.mobileqq.shortvideo;

import axdo;
import axdr;
import axdz;
import axeg;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(axdz paramaxdz) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      axeg localaxeg = (axeg)localIterator.next();
      axdo.a(localaxeg, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localaxeg.a != null) {
        axdz.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localaxeg.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */