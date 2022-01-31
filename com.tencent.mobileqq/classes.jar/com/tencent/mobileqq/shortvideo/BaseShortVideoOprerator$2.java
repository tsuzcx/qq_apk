package com.tencent.mobileqq.shortvideo;

import aune;
import axdr;
import axdz;
import axeg;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, axeg paramaxeg) {}
  
  public void run()
  {
    axdz localaxdz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localaxdz.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Axeg))
    {
      localaxdz.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Axeg);
      localaxdz.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localaxdz.a.remove(this.jdField_a_of_type_Axeg.a.jdField_a_of_type_JavaLangString);
      aune.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Axeg.a.jdField_a_of_type_Long + ",curHandingNum:" + localaxdz.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */