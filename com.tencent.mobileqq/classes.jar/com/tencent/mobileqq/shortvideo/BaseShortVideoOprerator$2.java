package com.tencent.mobileqq.shortvideo;

import aung;
import axdt;
import axeb;
import axei;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, axei paramaxei) {}
  
  public void run()
  {
    axeb localaxeb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localaxeb.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Axei))
    {
      localaxeb.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Axei);
      localaxeb.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localaxeb.a.remove(this.jdField_a_of_type_Axei.a.jdField_a_of_type_JavaLangString);
      aung.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Axei.a.jdField_a_of_type_Long + ",curHandingNum:" + localaxeb.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */