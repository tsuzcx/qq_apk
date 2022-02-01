package com.tencent.mobileqq.shortvideo;

import azjq;
import bcxb;
import bcxj;
import bcxr;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, bcxr parambcxr) {}
  
  public void run()
  {
    bcxj localbcxj = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer();
    if (localbcxj.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Bcxr))
    {
      localbcxj.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Bcxr);
      localbcxj.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localbcxj.a.remove(this.jdField_a_of_type_Bcxr.a.jdField_a_of_type_JavaLangString);
      azjq.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Bcxr.a.jdField_a_of_type_Long + ",curHandingNum:" + localbcxj.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */