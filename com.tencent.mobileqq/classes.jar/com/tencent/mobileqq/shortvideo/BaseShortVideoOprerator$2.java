package com.tencent.mobileqq.shortvideo;

import atpg;
import awej;
import awer;
import awey;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, awey paramawey) {}
  
  public void run()
  {
    awer localawer = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localawer.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Awey))
    {
      localawer.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Awey);
      localawer.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localawer.a.remove(this.jdField_a_of_type_Awey.a.jdField_a_of_type_JavaLangString);
      atpg.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Awey.a.jdField_a_of_type_Long + ",curHandingNum:" + localawer.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */