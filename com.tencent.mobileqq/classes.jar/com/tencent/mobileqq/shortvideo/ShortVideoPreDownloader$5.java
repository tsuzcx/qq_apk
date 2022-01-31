package com.tencent.mobileqq.shortvideo;

import azdd;
import azdg;
import azdo;
import azdx;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class ShortVideoPreDownloader$5
  implements Runnable
{
  public ShortVideoPreDownloader$5(azdo paramazdo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      azdx localazdx = (azdx)localIterator.next();
      azdd.a(localazdx, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localazdx.a != null) {
        azdo.a("consumeAllThumbsInPendingQueue", "consume thumb, uniseq=" + localazdx.a.a);
      }
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader.5
 * JD-Core Version:    0.7.0.1
 */