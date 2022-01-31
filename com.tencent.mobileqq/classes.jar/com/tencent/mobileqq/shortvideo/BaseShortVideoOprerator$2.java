package com.tencent.mobileqq.shortvideo;

import awen;
import ayyx;
import ayzf;
import ayzo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, ayzo paramayzo) {}
  
  public void run()
  {
    ayzf localayzf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localayzf.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Ayzo))
    {
      localayzf.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Ayzo);
      localayzf.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localayzf.a.remove(this.jdField_a_of_type_Ayzo.a.jdField_a_of_type_JavaLangString);
      awen.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Ayzo.a.jdField_a_of_type_Long + ",curHandingNum:" + localayzf.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */