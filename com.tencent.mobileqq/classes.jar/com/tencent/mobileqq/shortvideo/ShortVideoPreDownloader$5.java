package com.tencent.mobileqq.shortvideo;

import bcwu;
import bcwx;
import bcxf;
import bcxn;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(bcxf parambcxf) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      bcxn localbcxn = (bcxn)localIterator.next();
      bcwu.a(localbcxn, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localbcxn.a != null) {
        bcxf.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localbcxn.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */