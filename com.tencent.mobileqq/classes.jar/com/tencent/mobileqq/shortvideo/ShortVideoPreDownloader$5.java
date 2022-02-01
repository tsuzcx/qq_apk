package com.tencent.mobileqq.shortvideo;

import bcwz;
import bcxb;
import bcxj;
import bcxr;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(bcxj parambcxj) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      bcxr localbcxr = (bcxr)localIterator.next();
      bcwz.a(localbcxr, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbcxr.a != null) {
        bcxj.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbcxr.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */